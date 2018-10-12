package gov.hhs.batch;

/*
 * Batch configuration defining job(s), its step,
 * reader(JDBC), processor and writer(JDBC), etc.
 * 
 */
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import gov.hhs.batch.biis.BIISJobListener;
import gov.hhs.batch.biis.BIISProperties;
import gov.hhs.batch.biis.BIISRefDataTasklet;
import gov.hhs.batch.biis.EHRPRefDataTasklet;
import gov.hhs.batch.biis.EmployeeTasklet;
import gov.hhs.batch.ehrp.EHRPJobListener;
import gov.hhs.batch.ehrp.EHRPProperties;
import gov.hhs.batch.ehrp.EHRPXMLImportTasklet;
import gov.hhs.batch.ehrp.ShellScriptTasklet;

@Configuration
@EnableBatchProcessing
@PropertySource("classpath:application.properties")
public class BatchConfiguration {

	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Autowired
	Properties properties;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private StepListener stepsListener;
	
	@Autowired
	@Qualifier("hhsDb")
	private DataSource hhsDataSource;

	//EHRP Interface Specific Configurations
	@Autowired
	private EHRPProperties ehrpProperties;
	
	@Autowired
	private EHRPJobListener ehrpJobListener;
	
	@Autowired
	private ShellScriptTasklet shellScriptTasklet;
	
	@Autowired 
	private EHRPXMLImportTasklet ehrpXmlTasklet;

	//BIIS Interface Specific Configurations
	@Autowired
	private BIISProperties biisProperties;
	
	@Autowired
	private BIISJobListener biisJobListener;
	
	@Autowired
	private EmployeeTasklet employeeTasklet;
	
	@Autowired
	private BIISRefDataTasklet biisRefDataTasklet;
	
	@Autowired
	private EHRPRefDataTasklet ehrpRefDataTasklet;

	
	@Bean
	public BatchConfigurer configurer(){
		return new DefaultBatchConfigurer(hhsDataSource);
	}

	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(hhsDataSource);
	}
	
	/*
	 * Schedule the EHRP 15 Minute Interface Job 
	 */
	@Scheduled(cron = "${ehrp.cron.sched}")
	public void runEHRP15MinJob() {
		try {
			if(Boolean.valueOf(properties.getRunEhrpJob())) {
				JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
				getJobLauncher().run(Ehrp15MinInterfaceJob(), jobParameters);
			} else {
				log.info(ehrpProperties.getEhrpInterfaceName() + " is turned off.");
			}
		} catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
		}
	}
	
	
	/*
	 * Schedule the BIIS Interface Job 
	 */
	@Scheduled(cron = "${biis.cron.sched}")
	public void runBIISJob() {
		try {
			if(Boolean.valueOf(properties.getRunBiisJob())) {
				JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
				getJobLauncher().run(BiisInterfaceJob(), jobParameters);	
			} else {
				log.info(biisProperties.getBiisInterfaceName() + " is turned off.");
			}
		} catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
		}
	}
	
	/*
	 * Job - EHRP15MinInterfaceJob
	 */
	@Bean
	public Job Ehrp15MinInterfaceJob() {
		return jobBuilderFactory.get("EHRP15MinInterfaceJob")
				.incrementer(new RunIdIncrementer())
				.listener(ehrpJobListener)
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
				.tasklet(ehrpXmlTasklet)
				.listener(stepsListener)
				.build();
	}
	
	/*
	 * Job - BiisInterfaceJob
	 */
	@Bean
	public Job BiisInterfaceJob() {
		return jobBuilderFactory.get("BiisInterfaceJob")
				.incrementer(new RunIdIncrementer())
				.listener(biisJobListener)
				.preventRestart()
				.start(importEmployeeDataStep()).on("*")
				.to(importBiisRefDataStep()).on("*")
				.to(importEHRPRefDataStep())
				.end()
				.build();
	}
	
	/*
	 * Step - importBiisRefDataStep - Import BIIS Ref Data
	 */

	@Bean
	public Step importBiisRefDataStep() {
		return stepBuilderFactory.get("importBiisRefDataStep")
				.tasklet(biisRefDataTasklet)
				.listener(stepsListener)
				.build();
	}
		
	
	/*
	 * Step - importEmployeeData - Import employee records
	 * into the BizFlow member and employee lookup tables
	 */

	@Bean
	public Step importEmployeeDataStep() {
		return stepBuilderFactory.get("importEmployeeDataStep")
				.tasklet(employeeTasklet)
				.listener(stepsListener)
				.build();
	}
	
	/*
	 * Step - importEHRPRefDataStep - Import EHRP Ref Data
	 */

	@Bean
	public Step importEHRPRefDataStep() {
		return stepBuilderFactory.get("importEHRPRefDataStep")
				.tasklet(ehrpRefDataTasklet)
				.listener(stepsListener)
				.build();
	}
	
	//***To resolve error: Can't serialize access for this transaction***
	private JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(hhsDataSource);
		factory.setTransactionManager(getTransactionManager());
		factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");//Added to get rid of ->Caused by: java.sql.SQLException: ORA-08177: can't serialize access for this transaction
		factory.afterPropertiesSet();
		return (JobRepository) factory.getObject();
	}

	private PlatformTransactionManager getTransactionManager() {
		return new ResourcelessTransactionManager();
	}

	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}
	
}

