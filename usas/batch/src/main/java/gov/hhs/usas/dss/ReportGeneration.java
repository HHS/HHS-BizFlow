package gov.hhs.usas.dss;

import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.axis.message.SOAPHeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Component;

import com.cognos.developer.schemas.bibus._3.ReportDataServiceLocator;
import com.cognos.developer.schemas.bibus._3.ReportDataServicePort;
import com.cognos.developer.schemas.rds.types._2.PromptValue;

import gov.hhs.usas.dss.model.Report;

public class ReportGeneration {
	
	private static final Logger log = LoggerFactory.getLogger(ReportGeneration.class);
				
	public static String generateReport(Report report) throws Exception{
		
		Credentials cred = new Credentials();
		String reportData = null;
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

			reportData = auth.getReportData(rdsservice, report.getSearchPath(), cred.getFORMAT(), prompts);
			auth.logoff(rdsservice, headers, cred.getCOGNOSURL());					

		} catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
		}
		return reportData;
	}
		
	public static void saveReportFile(Report report, String reportXml) throws Exception{
		try
		{
			@SuppressWarnings("resource")
			FileOutputStream outputFile=new FileOutputStream("reports/"+ report.getFileName() + "_" + System.currentTimeMillis() +".xml"); 
			outputFile.write(reportXml.getBytes());
			log.info("The report output is saved in the " + report.getFileName() + "_" + System.currentTimeMillis() +".xml file for data between " + report.getRvpStartUseval() + " and " + report.getRvpEndUseval());
		}
		catch(Exception e)
		{
			log.info(e.getMessage() + "::" + e.getCause());
		}				
	}
	
	public static void insertReporttoDB(DataSource targetDataSource, Report report, String reportXml) throws Exception{
		
		JdbcTemplate template = new JdbcTemplate(targetDataSource);
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template)
				.withSchemaName("HHS_HR")
				.withProcedureName("SP_UPDATE_INTG_DATA");

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("IO_ID", null);
		in.addValue("I_INTG_TYPE", report.getIntgType());
		in.addValue("I_FIELD_DATA", new SqlLobValue(reportXml, new DefaultLobHandler()), Types.CLOB);
		in.addValue("I_USER", "HHS_HR");
		
		simpleJdbcCall.execute(in);		
	}
	
	public static void truncateReportTables(DataSource targetDataSource, Report report) throws Exception{
		
		JdbcTemplate template = new JdbcTemplate(targetDataSource);
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template)
				.withSchemaName("HHS_HR")
				.withProcedureName(report.getSpTruncate());
		
		simpleJdbcCall.execute();	
	}

}
