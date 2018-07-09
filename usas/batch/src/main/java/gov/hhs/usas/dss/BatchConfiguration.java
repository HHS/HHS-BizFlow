package gov.hhs.usas.dss;

import javax.sql.DataSource;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;

import gov.hhs.usas.dss.model.Announcement;
import gov.hhs.usas.dss.model.Application;
import gov.hhs.usas.dss.model.Certificate;
import gov.hhs.usas.dss.model.IHSVacancy;
import gov.hhs.usas.dss.model.NewHire;
import gov.hhs.usas.dss.model.Report;
import gov.hhs.usas.dss.model.Request;
import gov.hhs.usas.dss.model.Review;
import gov.hhs.usas.dss.model.Task;
import gov.hhs.usas.dss.model.TimeToOffer;
import gov.hhs.usas.dss.model.TimeToStaff;
import gov.hhs.usas.dss.model.Vacancy;


/*
 * Batch configuration defining job(s), its step,
 * tasklet, etc.
 * 
 */

@Configuration
@EnableBatchProcessing
@PropertySource("classpath:report.properties")
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
	@Qualifier("targetDb")
	private DataSource targetDataSource;
		
	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}

	@Value("${offer.step.name}")
	private String offerStepName;
	
	@Value("${staff.step.name}")
	private String staffStepName;
	
	@Value("${ihs.vac.step.name}")
	private String ihsVacStepName;
	
	@Value("${app.step.name}")
	private String appStepName;
	
	@Value("${ann.step.name}")
	private String annStepName;
	
	@Value("${cert.step.name}")
	private String certStepName;
	
	@Value("${newHire.step.name}")
	private String newHireStepName;
	
	@Value("${rqst.step.name}")
	private String rqstStepName;
	
	@Value("${rvw.step.name}")
	private String rvwStepName;
	
	@Value("${task.step.name}")
	private String taskStepName;
	
	@Value("${vac.step.name}")
	private String vacStepName;
	 
	/*
	 * Job - importDSSReports
	 */
	@Bean
	public Job importDSSReports() throws Exception {

    	final Flow offerFlow = new FlowBuilder<Flow>("offerFlow").from(stepBuilderFactory.get(offerStepName).tasklet(offerTasklet()).listener(stepListener).build()).end();
    	final Flow staffFlow = new FlowBuilder<Flow>("staffFlow").from(stepBuilderFactory.get(staffStepName).tasklet(staffTasklet()).listener(stepListener).build()).end();
    	final Flow ihsVacancyFlow = new FlowBuilder<Flow>("ihsVacancyFlow").from(stepBuilderFactory.get(ihsVacStepName).tasklet(ihsVacancyTasklet()).listener(stepListener).build()).end();
		final Flow appFlow = new FlowBuilder<Flow>("appFlow").from(stepBuilderFactory.get(appStepName).tasklet(appTasklet()).listener(stepListener).build()).end();
    	final Flow annFlow = new FlowBuilder<Flow>("annFlow").from(stepBuilderFactory.get(annStepName).tasklet(annTasklet()).listener(stepListener).build()).end();
    	final Flow certFlow = new FlowBuilder<Flow>("certFlow").from(stepBuilderFactory.get(certStepName).tasklet(certTasklet()).listener(stepListener).build()).end();
    	final Flow newHireFlow = new FlowBuilder<Flow>("newHireFlow").from(stepBuilderFactory.get(newHireStepName).tasklet(newHireTasklet()).listener(stepListener).build()).end();
    	final Flow requestFlow = new FlowBuilder<Flow>("requestFlow").from(stepBuilderFactory.get(rqstStepName).tasklet(requestTasklet()).listener(stepListener).build()).end();
    	final Flow reviewFlow = new FlowBuilder<Flow>("reviewFlow").from(stepBuilderFactory.get(rvwStepName).tasklet(reviewTasklet()).listener(stepListener).build()).end();
    	final Flow taskFlow = new FlowBuilder<Flow>("taskFlow").from(stepBuilderFactory.get(taskStepName).tasklet(taskTasklet()).listener(stepListener).build()).end();
    	final Flow vacFlow = new FlowBuilder<Flow>("vacFlow").from(stepBuilderFactory.get(vacStepName).tasklet(vacTasklet()).listener(stepListener).build()).end();

    	//Parallel Report Flows
    	final Flow parallelFlow1 = new FlowBuilder<Flow>("parallelFlow1").split(new SimpleAsyncTaskExecutor()).add(offerFlow, staffFlow, ihsVacancyFlow).build();
    	final Flow parallelFlow2 = new FlowBuilder<Flow>("parallelFlow2").split(new SimpleAsyncTaskExecutor()).add(appFlow, annFlow, certFlow).build();
    	final Flow parallelFlow3 = new FlowBuilder<Flow>("parallelFlow3").split(new SimpleAsyncTaskExecutor()).add(newHireFlow, requestFlow, reviewFlow).build();
    	final Flow parallelFlow4 = new FlowBuilder<Flow>("parallelFlow4").split(new SimpleAsyncTaskExecutor()).add(taskFlow, vacFlow).build();
    			
/*    	interfaceName = " USA Staffing Interface";
		return jobBuilderFactory.get("importDSSReports")
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				.preventRestart()
				.start(offerFlow).on("*")
				.to(staffFlow).on("*")
				.to(ihsVacancyFlow).on("*")
				.to(appFlow).on("*")
				.to(annFlow).on("*")
				.to(certFlow).on("*")		
				.to(newHireFlow).on("*")
				.to(requestFlow).on("*")
				.to(reviewFlow).on("*")
				.to(taskFlow).on("*")
				.to(vacFlow)
				.end()
				.build();*/
		
    	interfaceName = " USA Staffing Interface";
		return jobBuilderFactory.get("importDSSReports")
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				.preventRestart()
				.start(parallelFlow1).on("*")
				.to(parallelFlow2).on("*")
				.to(parallelFlow3).on("*")
				.to(parallelFlow4)
				.end()
				.build();
		
	}
	
	//Announcement Tasklet
	@Bean
	@StepScope
	public Tasklet annTasklet() {
		return new ReportTasklet();
	}
    
	//Application Tasklet
	@Bean
	@StepScope
	public Tasklet appTasklet() {		
		return new ReportTasklet();
	}	
	
	//Certificate Tasklet
	@Bean
	@StepScope
	public Tasklet certTasklet() {
		return new ReportTasklet();
	}
	
	//New Hire Tasklet
	@Bean
	@StepScope
	public Tasklet newHireTasklet() {
		return new ReportTasklet();
	}
	
	//Request Tasklet
	@Bean
	@StepScope
	public Tasklet requestTasklet() {
		return new ReportTasklet();
	}
	
	//Review Tasklet
	@Bean
	@StepScope
	public Tasklet reviewTasklet() {
		return new ReportTasklet();
	}
	
	//Task Tasklet
	@Bean
	@StepScope
	public Tasklet taskTasklet() {
		return new ReportTasklet();
	}
	
	//Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet vacTasklet() {
		return new ReportTasklet();
	}
	
	//Offer Tasklet
	@Bean
	@StepScope
	public Tasklet offerTasklet() {
		return new ReportTasklet();
	}	
		
	//Staff Tasklet
	@Bean
	@StepScope
	public Tasklet staffTasklet() {
		return new ReportTasklet();
	}
	
	//IHS Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet ihsVacancyTasklet() {
		return new ReportTasklet();
	}	
	
	@Bean
	public BatchConfigurer configurer() {
		return new DefaultBatchConfigurer(targetDataSource);
	}


	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(targetDataSource);
	}	
	

}
