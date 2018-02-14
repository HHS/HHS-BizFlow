package com.hhs.persondirectory;

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

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class StagingToFinalTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(StagingToFinalTasklet.class);

	@Value("${plsql.catalog}")
	private String catalogName;

	@Value("${plsql.schema}")
	private String schemaName;

	@Value("${plsql.function}")
	private String functionName;


	private static int sqlcode;
	private static String sqlerrm;

	public static int getSqlcode() {
		return sqlcode;
	}

	public static String getSqlerrm() {
		return sqlerrm;
	}


	@Autowired
	private DataSource targetDataSource;

	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

		try {
			JdbcTemplate template = new JdbcTemplate(targetDataSource);


			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template)
					.withCatalogName(catalogName)
					.withSchemaName(schemaName)
					.withFunctionName(functionName)
					.withoutProcedureColumnMetaDataAccess()
					.declareParameters(
							new SqlOutParameter("SQL_CODE", Types.INTEGER),
							new SqlOutParameter("SQL_MSG", Types.VARCHAR)
							);


			Map out = simpleJdbcCall.execute();
			sqlcode = (int) out.get("SQL_CODE");
			sqlerrm = (String) out.get("SQL_MSG");
			log.info("Function MEMBER_STG_TO_FNL:: "+ "SQL_CODE:: "+out.get("SQL_CODE") + "::::" + "SQL_MSG:: "+out.get("SQL_MSG"));
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}

	}

}
