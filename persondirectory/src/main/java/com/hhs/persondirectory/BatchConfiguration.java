package com.hhs.persondirectory;

/*
 * Batch configuration defining job(s), its step,
 * reader(JDBC), processor and writer(JDBC),
 * job scheduler using cron, etc.
 * 
 */
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableBatchProcessing //enables Spring Batch features and provides a base configuration for setting up batch jobs
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobCompletionNotificationListener jobCompletionlistener;

	@Autowired
	private StepsListener stepsListener;

	@Autowired
	private ImportReadListener importReadListener;

	@Autowired
	private ImportWriteListener importWriteListener;

	@Autowired
	private StagingToFinalTasklet taskletStep;

	@Autowired
	@Qualifier("sourceDb")
	private DataSource sourceDataSource;

	@Autowired
	@Qualifier("targetDb")
	private DataSource targetDataSource;

	@Value("${sql.select.HHSEmp}")
	private String QUERY_LIST_HHS_EMPLOYEE;

	@Value("${sql.insert.memberStg}")
	private String QUERY_INSERT_MEMBER_STG;

	@Value("${chunk.size}")
	private int CHUNK_SIZE;

	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}


	/*
	 * Job - import Person Directory (PSC Locator) into staging table 
	 * and then, after applying business rules, move the data 
	 * from staging table to final tables
	 */
	@Bean
	public Job importPersonDirectoryJob() {
		interfaceName = " PSC Locator Interface ";
		return jobBuilderFactory.get("importPersonDirectoryJob")
				.incrementer(new RunIdIncrementer())
				.listener(jobCompletionlistener)
				.start(personDirectoryToStgStep())
				.next(stgToMemberFnlStep())
				.build();
	}

	//first step
	@Bean
	public Step personDirectoryToStgStep() {
		return stepBuilderFactory.get("personDirectoryToStagingStep")
				.<HHSEmployee, MemberStg>chunk(CHUNK_SIZE)
				.reader(importReader())
				.listener(importReadListener)
				.writer(importWriter())
				.listener(importWriteListener)
				.listener(stepsListener)
				.build();
	}

	//second step
	@Bean
	public Step stgToMemberFnlStep() {
		return stepBuilderFactory.get("stagingToMemberFinalStep")
				.tasklet(taskletStep)
				.listener(stepsListener)
				.build();
	}


	@Bean
	public ItemReader<HHSEmployee> importReader() {
		JdbcCursorItemReader<HHSEmployee> databaseReader = new JdbcCursorItemReader<HHSEmployee>();
		databaseReader.setDataSource(sourceDataSource);
		databaseReader.setSql(QUERY_LIST_HHS_EMPLOYEE);
		databaseReader.setRowMapper(new BeanPropertyRowMapper<HHSEmployee>(HHSEmployee.class));

		return databaseReader;

	}

	@Bean
	public ItemWriter<MemberStg> importWriter() {
		JdbcBatchItemWriter<MemberStg> databaseWriter = new JdbcBatchItemWriter<MemberStg>();
		databaseWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<MemberStg>());
		databaseWriter.setSql(QUERY_INSERT_MEMBER_STG);
		databaseWriter.setDataSource(targetDataSource);
		return databaseWriter;
	}

	//added new batch configurer for using multiple datasource
	@Bean
	public BatchConfigurer configurer(){
		return new DefaultBatchConfigurer(targetDataSource);
	}


	@Bean(name="sourceJdbcTemplate")
	public JdbcTemplate sourceJdbcTemplate() {
		return new JdbcTemplate(sourceDataSource);
	}

	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(targetDataSource);
	}

}

