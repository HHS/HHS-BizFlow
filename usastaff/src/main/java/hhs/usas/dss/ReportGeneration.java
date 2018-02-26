package hhs.usas.dss;

import java.io.FileOutputStream;
import java.net.URL;

import org.apache.axis.message.SOAPHeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognos.developer.schemas.bibus._3.ReportDataServiceLocator;
import com.cognos.developer.schemas.bibus._3.ReportDataServicePort;
import com.cognos.developer.schemas.rds.types._2.PromptValue;

import hhs.usas.dss.model.Report;

public class ReportGeneration {
	
	private static final Logger log = LoggerFactory.getLogger(ReportGeneration.class);
			
	public static void generateReport(Report report) throws Exception{
		
		Credentials cred = new Credentials();
		
		try {
			Authentication auth = new Authentication();
			Prompts p = new Prompts();
			
			SOAPHeaderElement[] headers = auth.logon(cred.getNAMESPACE(), cred.getUSERNAME(), cred.getPASSWORD(), cred.getCOGNOSURL());
			
			// Create a report instance
			ReportDataServiceLocator rdslocator = new ReportDataServiceLocator();
			ReportDataServicePort rdsservice = rdslocator.getReportDataServiceBinding(new URL(cred.getCOGNOSURL()));
			((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
			
			PromptValue[] prompts = new PromptValue[report.getParmNum()];
			
			if (report.getParmNum()==1) {
				//Staffing Date Range Prompt
				prompts[0] = p.buildRangeValuePrompt(report.getRvpName(), report.getRvpStartUseval(),report.getRvpEndUseval(), report.getRvpStartDisplay(), report.getRvpEndDisplay());
			}else if(report.getParmNum()==2) {
				//Staffing Date Type and Staffing Date Range Prompts
				prompts[0] = p.buildSimpleValuePrompt(report.getSvpName(), report.getSvpUseval(),report.getSvpDisplay());
				prompts[1] = p.buildRangeValuePrompt(report.getRvpName(), report.getRvpStartUseval(),report.getRvpEndUseval(), report.getRvpStartDisplay(), report.getRvpEndDisplay());
			}

			String reportData = auth.getReportData(rdsservice, report.getSearchPath(), cred.getFORMAT(), prompts);
			auth.logoff(rdsservice, headers, cred.getCOGNOSURL());
					
			try
			{
				@SuppressWarnings("resource")
				FileOutputStream outputFile=new FileOutputStream("reports/"+ report.getFileName() +".xml"); 
				outputFile.write(reportData.getBytes());
				log.info("The report output is saved in " + report.getFileName() + ".xml file.");
			}
			catch(Exception e)
			{
				log.info(e.getMessage() + "::" + e.getCause());
			}
		} catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
		}
		
	}

}
