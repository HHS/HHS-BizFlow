package hhs.usas.dss;

import java.io.FileOutputStream;

import java.net.URL;


import org.apache.axis.message.SOAPHeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cognos.developer.schemas.bibus._3.ReportDataServiceLocator;
import com.cognos.developer.schemas.bibus._3.ReportDataServicePort;
import com.cognos.developer.schemas.rds.types._2.PromptValue;


import hhs.usas.dss.model.Vacancy;

@Component 
public class ReportTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(ReportTasklet.class);

	@Value("${cognos.username}")
	private String username;
	@Value("${cognos.password}")
	private String password;
	@Value("${cognos.namespace}")
	private String namespace;
	@Value("${cognos.url}")
	private String cognosURL;
	@Value("${cognos.format}")
	private String format;	
	
	private String searchPath = Vacancy.getSEARCH_PATH();
	
	private String svpName = Vacancy.getSVP_NAME();
	private String svpUseval= Vacancy.getSVP_USEVAL();
	private String svpDisplay= Vacancy.getSVP_DISPLAY();
	
	private String rvpName= Vacancy.getRVP_NAME();
	private String rvpStartUseval= Vacancy.getRVP_START_USEVAL();
	private String rvpStartDisplay= Vacancy.getRVP_START_DISPLAY();
	private String rvpEndUseval= Vacancy.getRVP_END_USEVAL();
	private String rvpEndDisplay= Vacancy.getRVP_END_DISPLAY();

	private int parmNum = Vacancy.getParmNum();

	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		try {
			
			Authentication auth = new Authentication();
			Prompts p = new Prompts();
			
			SOAPHeaderElement[] headers = auth.logon(namespace, username, password, cognosURL);
			
		    // Create a report instance
			ReportDataServiceLocator rdslocator = new ReportDataServiceLocator();
			ReportDataServicePort rdsservice = rdslocator.getReportDataServiceBinding(new URL(cognosURL));
			((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
			
			PromptValue[] prompts = new PromptValue[parmNum];
			
			if (parmNum==1) {
				//Staffing Date Range Prompt
				prompts[0] = p.buildRangeValuePrompt(rvpName, rvpStartUseval,rvpEndUseval, rvpStartDisplay, rvpEndDisplay);
			}else if(parmNum==2) {
				//Staffing Date Type and Staffing Date Range Prompts
				prompts[0] = p.buildSimpleValuePrompt(svpName, svpUseval,svpDisplay);
				prompts[1] = p.buildRangeValuePrompt(rvpName, rvpStartUseval,rvpEndUseval, rvpStartDisplay, rvpEndDisplay);
			}

			String reportData = auth.getReportData(rdsservice, searchPath, format, prompts);
			auth.logoff(rdsservice, headers, cognosURL);
					
			try
			{
				@SuppressWarnings("resource")
				FileOutputStream outputFile=new FileOutputStream(Vacancy.getFileName()+".xml"); 
				outputFile.write(reportData.getBytes());
				log.info("The report output is saved in " + Vacancy.getFileName() + ".xml file.");
			}
			catch(Exception e)
			{
				log.info(e.getMessage() + "::" + e.getCause());
			}
			
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}
	}
}
