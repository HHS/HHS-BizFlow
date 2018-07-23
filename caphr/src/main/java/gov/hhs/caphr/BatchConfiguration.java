package gov.hhs.caphr;

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
	private CapHRTasklet capHRDataTasklet;

	@Autowired
	@Qualifier("whrscDb")
	private DataSource whrscDataSource;

	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}


	/*
	 * Job - capHRInterfaceJob
	 */
	@Bean
	public Job capHRInterfaceJob() {
		interfaceName = "CapHR Interface ";
		return jobBuilderFactory.get("capHRInterfaceJob")
				.incrementer(new RunIdIncrementer())
				.listener(jobCompletionlistener)
				.preventRestart()
				.start(importCapHRDataStep())//.on("*")
				.build();
	}
	
	
	/*
	 * Step - importEHRPRefDataStep - Import EHRP Ref Data
	 */

	@Bean
	public Step importCapHRDataStep() {
		return stepBuilderFactory.get("importCapHRDataStep")
				.tasklet(capHRDataTasklet)
				.listener(stepsListener)
				.build();
	}

	
	@Bean
	public BatchConfigurer configurer(){
		return new DefaultBatchConfigurer(whrscDataSource);
	}

	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(whrscDataSource);
	}

}

