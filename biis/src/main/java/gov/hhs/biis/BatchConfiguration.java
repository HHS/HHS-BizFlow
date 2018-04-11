package gov.hhs.biis;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

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
	private EmployeeTasklet employeeTasklet;
	
	@Autowired
	private BIISRefDataTasklet biisRefDataTasklet;
	
	@Autowired
	private EHRPRefDataTasklet ehrpRefDataTasklet;

	@Autowired
	@Qualifier("hhsDb")
	private DataSource hhsDataSource;

	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}


	/*
	 * Job - BiisInterfaceJob
	 */
	@Bean
	public Job BiisInterfaceJob() {
		interfaceName = "BIIS Interface ";
		return jobBuilderFactory.get("BiisInterfaceJob")
				.incrementer(new RunIdIncrementer())
				.listener(jobCompletionlistener)
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

	
	@Bean
	public BatchConfigurer configurer(){
		return new DefaultBatchConfigurer(hhsDataSource);
	}

	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(hhsDataSource);
	}

}

