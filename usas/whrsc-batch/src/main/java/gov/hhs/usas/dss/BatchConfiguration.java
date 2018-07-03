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
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

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

@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:whrsc-app.properties"),
	@PropertySource("classpath:whrsc-report.properties")
})
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobListener jobListener;

	@Autowired
	private StepsListener stepListener;

	/*	@Autowired
	@Qualifier("targetDb")
	private DataSource targetDataSource;*/

	@Autowired
	@Qualifier("whrscDb")
	private DataSource whrscTargetDataSource;

	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}



	/*
	 * Job - importWHRSCReports
	 */
	@Bean
	public Job importWHRSCReports() throws Exception {

		interfaceName = " USA Staffing Interface";
		return jobBuilderFactory.get("importWHRSCReports")
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				//.flow(executeAppNotifReportStep())
				//.end()
				//.start(executeNewHireTaskReportStep())
				.start(executeAppNotifReportStep())
				.next(executeCertLocReportStep())
				.next(executeCertsReportStep())
				.next(executePermReportStep())
				.next(executeNewHireFormsReportStep())
				.next(executeNewHireOnDocsReportStep())
				.next(executeNewHireTaskReportStep())
				.next(executeNewHireVacReqReportStep())
				.next(executeNewHiresReportStep())
				.next(executeReqLocReportStep())
				.next(executeReqRatngCombReportStep())
				.next(executeReqVacncyCombReportStep())
				.next(executeRequestsReportStep())
				.next(executeVacncyReportStep())
				.next(executeVacncyEligReportStep())
				.next(executeVacncyLocReportStep())
				.next(executeVacncyMissnCritclReportStep())
				.next(executeVacncyRatngCombReportStep())

				.build();

	}

	//Applicant Notifications Report Step & Tasklet
	@Bean
	public Step executeAppNotifReportStep() throws Exception {
		return stepBuilderFactory.get("executeAppNotifReportStep")
				.listener(stepListener)
				.tasklet(anTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet anTasklet() {
		return new WHRSCReportTasklet();
	}

	//Certificate Locations Report Step & Tasklet
	@Bean
	public Step executeCertLocReportStep() throws Exception {
		return stepBuilderFactory.get("executeCertLocReportStep")
				.listener(stepListener)
				.tasklet(clTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet clTasklet() {
		return new WHRSCReportTasklet();
	}
	
	//Certificates Report Step & Tasklet
	@Bean
	public Step executeCertsReportStep() throws Exception {
		return stepBuilderFactory.get("executeCertsReportStep")
				.listener(stepListener)
				.tasklet(cTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet cTasklet() {
		return new WHRSCReportTasklet();
	}
	
	//Permission Profiles Report Step & Tasklet
	@Bean
	public Step executePermReportStep() throws Exception {
		return stepBuilderFactory.get("executePermReportStep")
				.listener(stepListener)
				.tasklet(ppTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet ppTasklet() {
		return new WHRSCReportTasklet();
	}

	//New Hire Forms Report Step & Tasklet
	@Bean
	public Step executeNewHireFormsReportStep() throws Exception {
		return stepBuilderFactory.get("executeNewHireFormsReportStep")
				.listener(stepListener)
				.tasklet(nhfTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet nhfTasklet() {
		return new WHRSCReportTasklet();
	}

	//New Hire Onboarding Documents Report Step & Tasklet
	@Bean
	public Step executeNewHireOnDocsReportStep() throws Exception {
		return stepBuilderFactory.get("executeNewHireOnDocsReportStep")
				.listener(stepListener)
				.tasklet(nhodTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet nhodTasklet() {
		return new WHRSCReportTasklet();
	}

	//New Hire Task Report Step & Tasklet
	@Bean
	public Step executeNewHireTaskReportStep() throws Exception {
		return stepBuilderFactory.get("executeNewHireTaskReportStep")
				.listener(stepListener)
				.tasklet(nhtTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet nhtTasklet() {
		return new WHRSCReportTasklet();
	}

	//New Hire Vacancy Request Report Step & Tasklet
	@Bean
	public Step executeNewHireVacReqReportStep() throws Exception {
		return stepBuilderFactory.get("executeNewHireVacReqReportStep")
				.listener(stepListener)
				.tasklet(nhvrTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet nhvrTasklet() {
		return new WHRSCReportTasklet();
	}

	//New Hires Report Step & Tasklet
	@Bean
	public Step executeNewHiresReportStep() throws Exception {
		return stepBuilderFactory.get("executeNewHiresReportStep")
				.listener(stepListener)
				.tasklet(nhTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet nhTasklet() {
		return new WHRSCReportTasklet();
	}
	
	//Request Locations Report Step & Tasklet
	@Bean
	public Step executeReqLocReportStep() throws Exception {
		return stepBuilderFactory.get("executeReqLocReportStep")
				.listener(stepListener)
				.tasklet(rlTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet rlTasklet() {
		return new WHRSCReportTasklet();
	}

	//Request Rating Combinations Report Step & Tasklet
	@Bean
	public Step executeReqRatngCombReportStep() throws Exception {
		return stepBuilderFactory.get("executeReqRatngCombReportStep")
				.listener(stepListener)
				.tasklet(rrcTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet rrcTasklet() {
		return new WHRSCReportTasklet();
	}
	
	//Request Vacancy Combinations Report Step & Tasklet
	@Bean
	public Step executeReqVacncyCombReportStep() throws Exception {
		return stepBuilderFactory.get("executeReqVacncyCombReportStep")
				.listener(stepListener)
				.tasklet(rvcTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet rvcTasklet() {
		return new WHRSCReportTasklet();
	}
	
	//Requests Report Step & Tasklet
	@Bean
	public Step executeRequestsReportStep() throws Exception {
		return stepBuilderFactory.get("executeRequestsReportStep")
				.listener(stepListener)
				.tasklet(reqTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet reqTasklet() {
		return new WHRSCReportTasklet();
	}

	//Vacancy Report Step & Tasklet
	@Bean
	public Step executeVacncyReportStep() throws Exception {
		return stepBuilderFactory.get("executeVacncyReportStep")
				.listener(stepListener)
				.tasklet(vacTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet vacTasklet() {
		return new WHRSCReportTasklet();
	}

	//Vacancy Eligibilities Report Step & Tasklet
	@Bean
	public Step executeVacncyEligReportStep() throws Exception {
		return stepBuilderFactory.get("executeVacncyEligReportStep")
				.listener(stepListener)
				.tasklet(veTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet veTasklet() {
		return new WHRSCReportTasklet();
	}

	//Vacancy Locations Report Step & Tasklet
	@Bean
	public Step executeVacncyLocReportStep() throws Exception {
		return stepBuilderFactory.get("executeVacncyLocReportStep")
				.listener(stepListener)
				.tasklet(vlTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet vlTasklet() {
		return new WHRSCReportTasklet();
	}

	//Vacancy Mission Critical Occupations Report Step & Tasklet
	@Bean
	public Step executeVacncyMissnCritclReportStep() throws Exception {
		return stepBuilderFactory.get("executeVacncyMissnCritclReportStep")
				.listener(stepListener)
				.tasklet(vmcoTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet vmcoTasklet() {
		return new WHRSCReportTasklet();
	}

	//Vacancy Rating Combinations Report Step & Tasklet
	@Bean
	public Step executeVacncyRatngCombReportStep() throws Exception {
		return stepBuilderFactory.get("executeVacncyRatngCombReportStep")
				.listener(stepListener)
				.tasklet(vrcTasklet())
				.build();
	}

	@Bean
	public WHRSCReportTasklet vrcTasklet() {
		return new WHRSCReportTasklet();
	}
	
	@Bean
	public BatchConfigurer whrscBatchConfigurer() {
		return new DefaultBatchConfigurer(whrscTargetDataSource);
	}


	@Bean(name="whrscTargetJdbcTemplate")
	public JdbcTemplate whrscTargetJdbcTemplate() {
		return new JdbcTemplate(whrscTargetDataSource);
	}

	//***To resolve error: Can't serialize access for this transaction***
	private JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(whrscTargetDataSource);//
		factory.setTransactionManager(getTransactionManager());
		factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");//Added to get rid of ->Caused by: java.sql.SQLException: ORA-08177: can't serialize access for this transaction
		factory.setTablePrefix("WHRSC_BATCH_");//move to properties, configurable
		// JobRepositoryFactoryBean's methods Throws Generic Exception,s
		// it would have been better to have a specific one
		factory.afterPropertiesSet();
		return (JobRepository) factory.getObject();
	}

	private PlatformTransactionManager getTransactionManager() {
		return new ResourcelessTransactionManager();
	}

	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		// SimpleJobLauncher's methods Throws Generic Exception,
		// it would have been better to have a specific one
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	//*** -----------------***



	//USAS DSS REPORTS CODE
	/*	@Value("${offer.step.name}")
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
	private String vacStepName;*/

	/*
	 * Job - importDSSReports
	 */
	/*	@Bean
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

    	interfaceName = " USA Staffing Interface";
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
				.build();

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
	}*/


}
