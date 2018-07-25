package gov.hhs.usas.dss;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
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
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import gov.hhs.usas.dss.whrsc.model.ApplicantNotifications;
import gov.hhs.usas.dss.whrsc.model.CertificateLocations;
import gov.hhs.usas.dss.whrsc.model.Certificates;
import gov.hhs.usas.dss.whrsc.model.NewHireForms;
import gov.hhs.usas.dss.whrsc.model.NewHireOnboardingDocuments;
import gov.hhs.usas.dss.whrsc.model.NewHireTask;
import gov.hhs.usas.dss.whrsc.model.NewHireVacancyRequest;
import gov.hhs.usas.dss.whrsc.model.NewHires;
import gov.hhs.usas.dss.whrsc.model.PermissionProfiles;
import gov.hhs.usas.dss.whrsc.model.RequestLocations;
import gov.hhs.usas.dss.whrsc.model.RequestRatingCombinations;
import gov.hhs.usas.dss.whrsc.model.RequestVacancyCombinations;
import gov.hhs.usas.dss.whrsc.model.Requests;
import gov.hhs.usas.dss.whrsc.model.Vacancies;
import gov.hhs.usas.dss.whrsc.model.VacancyEligibilities;
import gov.hhs.usas.dss.whrsc.model.VacancyLocations;
import gov.hhs.usas.dss.whrsc.model.VacancyMissionCriticalOccupations;
import gov.hhs.usas.dss.whrsc.model.VacancyRatingCombinations;


/*
 * Batch configuration defining job(s), its step,
 * tasklet, etc.
 * 
 */

@Configuration
@EnableBatchProcessing

@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:whrsc-report.properties")
})
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	/*@Autowired
	private JobListener jobListener;*/

	@Autowired
	private StepsListener stepListener;
	
	@Autowired
	private WHRSCJobListener whrscJobListener;

	/*	@Autowired
	@Qualifier("targetDb")
	private DataSource targetDataSource;*/

	@Autowired
	@Qualifier("whrscDb")
	private DataSource whrscTargetDataSource;
	
	@Autowired
	private ApplicantNotifications applicantNotifications;
	
	@Autowired
	private CertificateLocations certificateLocations;
	
	@Autowired
	private Certificates certificates;
	
	@Autowired
	private PermissionProfiles permissionProfiles;
	
	@Autowired
	private NewHireForms newHireForms;	
	
	@Autowired
	private NewHireOnboardingDocuments newHireOnboardingDocuments;	
	
	@Autowired
	private NewHireTask newHireTask;	
	
	@Autowired
	private NewHireVacancyRequest newHireVacancyRequest;	
	
	@Autowired
	private NewHires newHires;	
	
	@Autowired
	private RequestLocations requestLocations;

	@Autowired
	private RequestRatingCombinations requestRatingCombinations;

	@Autowired
	private RequestVacancyCombinations requestVacancyCombinations;

	@Autowired
	private Requests requests;

	@Autowired
	private Vacancies vacancies;

	@Autowired
	private VacancyEligibilities vacancyEligibilities;

	@Autowired
	private VacancyLocations vacancyLocations;

	@Autowired
	private VacancyMissionCriticalOccupations vacancyMissionCriticalOccupations;

	@Autowired
	private VacancyRatingCombinations vacancyRatingCombinations;

	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}



	/*
	 * Job - importWHRSCReports
	 */
	@Bean
	public Job importWHRSCReports() throws Exception {

		interfaceName = " USA Staffing Interface ";
		return jobBuilderFactory.get("importWHRSCReports")
				.incrementer(new RunIdIncrementer())
				.listener(whrscJobListener)
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
		WHRSCReportTasklet anTasklet = new WHRSCReportTasklet();
		anTasklet.setReport(applicantNotifications);
		return anTasklet;
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
		WHRSCReportTasklet clTasklet = new WHRSCReportTasklet();
		clTasklet.setReport(certificateLocations);
		return clTasklet;
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
		WHRSCReportTasklet cTasklet = new WHRSCReportTasklet();
		cTasklet.setReport(certificates);
		return cTasklet;
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
		WHRSCReportTasklet ppTasklet = new WHRSCReportTasklet();
		ppTasklet.setReport(permissionProfiles);
		return ppTasklet;
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
		WHRSCReportTasklet nhfTasklet = new WHRSCReportTasklet();
		nhfTasklet.setReport(newHireForms);
		return nhfTasklet;
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
		WHRSCReportTasklet nhodTasklet = new WHRSCReportTasklet();
		nhodTasklet.setReport(newHireOnboardingDocuments);
		return nhodTasklet;
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
		WHRSCReportTasklet nhtTasklet = new WHRSCReportTasklet();
		nhtTasklet.setReport(newHireTask);
		return nhtTasklet;
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
		WHRSCReportTasklet nhvrTasklet = new WHRSCReportTasklet();
		nhvrTasklet.setReport(newHireVacancyRequest);
		return nhvrTasklet;
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
		WHRSCReportTasklet nhTasklet = new WHRSCReportTasklet();
		nhTasklet.setReport(newHires);
		return nhTasklet;
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
		WHRSCReportTasklet rlTasklet = new WHRSCReportTasklet();
		rlTasklet.setReport(requestLocations);
		return rlTasklet;
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
		WHRSCReportTasklet rrcTasklet = new WHRSCReportTasklet();
		rrcTasklet.setReport(requestRatingCombinations);
		return rrcTasklet;
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
		WHRSCReportTasklet rvcTasklet = new WHRSCReportTasklet();
		rvcTasklet.setReport(requestVacancyCombinations);
		return rvcTasklet;
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
		WHRSCReportTasklet reqTasklet = new WHRSCReportTasklet();
		reqTasklet.setReport(requests);
		return reqTasklet;
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
		WHRSCReportTasklet vacTasklet = new WHRSCReportTasklet();
		vacTasklet.setReport(vacancies);
		return vacTasklet;
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
		WHRSCReportTasklet veTasklet = new WHRSCReportTasklet();
		veTasklet.setReport(vacancyEligibilities);
		return veTasklet;
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
		WHRSCReportTasklet vlTasklet = new WHRSCReportTasklet();
		vlTasklet.setReport(vacancyLocations);
		return vlTasklet;
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
		WHRSCReportTasklet vmcoTasklet = new WHRSCReportTasklet();
		vmcoTasklet.setReport(vacancyMissionCriticalOccupations);
		return vmcoTasklet;
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
		WHRSCReportTasklet vrcTasklet = new WHRSCReportTasklet();
		vrcTasklet.setReport(vacancyRatingCombinations);
		return vrcTasklet;
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

	}*/




}
