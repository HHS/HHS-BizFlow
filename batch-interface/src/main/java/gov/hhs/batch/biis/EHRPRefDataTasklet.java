package gov.hhs.batch.biis;

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

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class EHRPRefDataTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(EmployeeTasklet.class);
	
	@Autowired
	BIISProperties biisProperties;

	private static String sqlmsg;

	public static String getSqlmsg() {
		return sqlmsg;
	}
	
	private static int sqlcode;

	@Autowired
	private DataSource hhsDataSource;

	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

		try {
			if (Boolean.valueOf(biisProperties.getImportEhrpRefData())) {
				JdbcTemplate template = new JdbcTemplate(hhsDataSource);

				SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template)
						.withCatalogName(biisProperties.getPlsqlEhrpRefDataCatalog())
						.withSchemaName(biisProperties.getPlsqlEhrpRefDataSchema())
						.withFunctionName(biisProperties.getPlsqEhrpRefDataFunction())
						.withoutProcedureColumnMetaDataAccess()
						.declareParameters(
								new SqlOutParameter("SQL_MSG", Types.VARCHAR)
								);


				Map out = simpleJdbcCall.execute();
				sqlmsg = (String) out.get("SQL_MSG");
				sqlcode = Integer.parseInt(sqlmsg.substring(0, sqlmsg.indexOf(" :")));
				
				log.info(biisProperties.getPlsqlEhrpRefDataCatalog() + "."+ biisProperties.getPlsqEhrpRefDataFunction() + " :: "+ "SQL_MSG:: "+out.get("SQL_MSG"));
				
				//A sqlcode of 0 means success
				if(sqlcode!=0) {
					chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getEhrpRefDataName(), biisProperties.getModuleErrorStatus());
				} else {
					chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getEhrpRefDataName(), biisProperties.getModuleSuccessStatus());
				}
				
			}else {
				log.info("Importing the EHRP Reference Data is turned off");
				chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getEhrpRefDataName(), biisProperties.getModuleOffStatus());
			}
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getEhrpRefDataName(), biisProperties.getModuleErrorStatus());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}

	}

}
