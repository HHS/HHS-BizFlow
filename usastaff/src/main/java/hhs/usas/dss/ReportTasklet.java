package hhs.usas.dss;

import java.sql.Clob;
import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Component;

import hhs.usas.dss.ReportGeneration;
import hhs.usas.dss.model.Announcement;
import hhs.usas.dss.model.Application;
import hhs.usas.dss.model.Certificate;
import hhs.usas.dss.model.NewHire;
import hhs.usas.dss.model.Request;
import hhs.usas.dss.model.Review;
import hhs.usas.dss.model.Task;
import hhs.usas.dss.model.Vacancy;

@Component
public class ReportTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(ReportTasklet.class);

	@Autowired
	private DataSource targetDataSource;
		
	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		String reportXml;
		
		try {			
		
/*			//Retrieve Announcement DSS Report
			Announcement ann = new Announcement();
			ReportGeneration.generateReport(ann);
			
			//Retrieve Application DSS Report
			Application app = new Application();
			ReportGeneration.generateReport(app);
			
			//Retrieve Certificate DSS Report
			Certificate cert = new Certificate();
			ReportGeneration.generateReport(cert);
			
			//Retrieve New Hire DSS Report
			NewHire newHire = new NewHire();
			ReportGeneration.generateReport(newHire);
			
			//Retrieve Request DSS Report
			Request request = new Request();
			ReportGeneration.generateReport(request);
			
			//Retrieve Review DSS Report
			Review review = new Review();
			ReportGeneration.generateReport(review);
			
			//Retrieve Task DSS Report
			Task task = new Task();
			ReportGeneration.generateReport(task);*/
			
			//Retrieve Vacancy DSS Report
			Vacancy vacancy = new Vacancy();
			reportXml = ReportGeneration.generateReport(vacancy);
	
			JdbcTemplate template = new JdbcTemplate(targetDataSource);
			
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template)
					.withSchemaName("HHS_HR")
					.withProcedureName("SP_UPDATE_INTG_DATA");

			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("IO_ID", null);
			in.addValue("I_INTG_TYPE", vacancy.getIntgType());
			in.addValue("I_FIELD_DATA", new SqlLobValue(reportXml, new DefaultLobHandler()), Types.CLOB);
			in.addValue("I_USER", "HHS_HR");
			
			simpleJdbcCall.execute(in);
		
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}
	}
}
