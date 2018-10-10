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
public class EmployeeTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(EmployeeTasklet.class);

	@Autowired
	BIISProperties biisProperties;

	private static int sqlcode;
	private static String sqlerrm;

	public static int getSqlcode() {
		return sqlcode;
	}

	public static String getSqlerrm() {
		return sqlerrm;
	}

	@Autowired
	private DataSource hhsDataSource;

	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

		try {
			if (Boolean.valueOf(biisProperties.getImportBiisPerson())) {
				JdbcTemplate template = new JdbcTemplate(hhsDataSource);


				SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template)
						.withCatalogName(biisProperties.getPlsqlEmployeeCatalog())
						.withSchemaName(biisProperties.getPlsqlEmployeeSchema())
						.withFunctionName(biisProperties.getPlsqlEmployeeFunction())
						.withoutProcedureColumnMetaDataAccess()
						.declareParameters(
								new SqlOutParameter("SQL_CODE", Types.INTEGER),
								new SqlOutParameter("SQL_MSG", Types.VARCHAR)
								);


				Map out = simpleJdbcCall.execute();
				sqlcode = (int) out.get("SQL_CODE");
				sqlerrm = (String) out.get("SQL_MSG");
				log.info(biisProperties.getPlsqlEmployeeCatalog() + "."+ biisProperties.getPlsqlEmployeeFunction() + " :: "+ "SQL_CODE:: "+out.get("SQL_CODE") + "::::" + "SQL_MSG:: "+out.get("SQL_MSG"));
				
				//A sqlcode of 0 means success
				if (sqlcode!= 0) {
					chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getBiisPersonName(), biisProperties.getModuleErrorStatus());
				} else {
					chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getBiisPersonName(), biisProperties.getModuleSuccessStatus());
				}
			
			}else {
				log.info("Importing the employee information is turned off");
				chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getBiisPersonName(), biisProperties.getModuleOffStatus());
			}
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(biisProperties.getBiisPersonName(), biisProperties.getModuleErrorStatus());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}

	}

}
