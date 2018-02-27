package hhs.usas.dss;

import javax.sql.DataSource;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


/*
 * Batch configuration defining job(s), its step,
 * reader(JDBC), processor and writer(JDBC),
 * job scheduler using cron, etc.
 * 
 */


@Configuration
@EnableBatchProcessing //enables Spring Batch features and provides a base configuration for setting up batch jobs
public class BatchConfiguration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobListener jobListener;

	@Autowired
	private StepsListener stepListener;

	@Autowired
	private ReportTasklet reportTaskletStep;

	@Autowired
	@Qualifier("targetDb")
	private DataSource targetDataSource;
	
	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}
	



	/*
	 * Job - importVacancyDSSReport into staging table 
	 * and then, after applying business rules, move the data 
	 * from staging table to final tables
	 */
	@Bean
	public Job importDSSReports() throws Exception {
		interfaceName = " USA Staffing Interface";
		return jobBuilderFactory.get("importDSSReports")
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				.start(retrieveCognosDataStep())
				.build();
		
	}

	//first step
	@Bean
	public Step retrieveCognosDataStep() {
		return stepBuilderFactory.get("retrieveCognosDataStep")
				.tasklet(reportTaskletStep)
				.listener(stepListener)
				.build();
	}
	
	
	//added new batch configurer for using multiple datasource
	@Bean
	public BatchConfigurer configurer(){
		return new DefaultBatchConfigurer(targetDataSource);
	}


	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(targetDataSource);
	}	
	

}
