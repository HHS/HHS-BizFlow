package gov.hhs.ehrp;

/*
 * Batch configuration defining job(s), its step,
 * reader(JDBC), processor and writer(JDBC), etc.
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import gov.hhs.ehrp.ShellScriptTasklet;
import gov.hhs.ehrp.StepListener;

@Configuration
@EnableBatchProcessing 
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobListener jobCompletionlistener;

	@Autowired
	private StepListener stepsListener;

	@Autowired
	private ShellScriptTasklet shellScriptTasklet;
	
	@Autowired 
	private EHRPXMLImportTasklet xmlTasklet;
	
	@Autowired
	@Qualifier("hhsDb")
	private DataSource hhsDataSource;

	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}


	/*
	 * Job - EHRP15MinInterfaceJob
	 */
	@Bean
	public Job Ehrp15MinInterfaceJob() {
		interfaceName = "EHRP 15 Minute Interface ";
		return jobBuilderFactory.get("EHRP15MinInterfaceJob")
				.incrementer(new RunIdIncrementer())
				.listener(jobCompletionlistener)
				.preventRestart()
				.start(runShellScriptStep())
				.next(importEHRPXMLStep())
				.build();
	}
	
	/*
	 * Step - runShellScriptStep - Run EHRP SHell Script
	 * to pull data from the MARS server into the BizFlow
	 * server
	 */

	@Bean
	public Step runShellScriptStep() {
		return stepBuilderFactory.get("runShellScriptStep")
				.tasklet(shellScriptTasklet)
				.listener(stepsListener)
				.build();
	}
	
		
	/*
	 * Step - importEHRPXMLStep - Process the EHRP XML
	 * files and insert the data into the database
	 */

	@Bean
	public Step importEHRPXMLStep() {
		return stepBuilderFactory.get("importEHRPXMLStep")
				.tasklet(xmlTasklet)
				.listener(stepsListener)
				.build();
	}
		
	@Bean
	public BatchConfigurer configurer(){
		return new DefaultBatchConfigurer(hhsDataSource);
	}

	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(hhsDataSource);
	}

}

