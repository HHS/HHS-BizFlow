package gov.hhs.usas.dss;

import javax.sql.DataSource;


import org.springframework.batch.core.Job;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import gov.hhs.usas.dss.model.Announcement;
import gov.hhs.usas.dss.model.Application;
import gov.hhs.usas.dss.model.CDCAudit;
import gov.hhs.usas.dss.model.CDCCertificate;
import gov.hhs.usas.dss.model.CDCTimeToOffer;
import gov.hhs.usas.dss.model.CDCTimeToStaff;
import gov.hhs.usas.dss.model.Certificate;
import gov.hhs.usas.dss.model.IHSVacancy;
import gov.hhs.usas.dss.model.NewHire;
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

	@Autowired
	private Announcement announcement;
	
	@Autowired
	private Application application;
	
	@Autowired
	private Certificate certificate;
	
	@Autowired
	private IHSVacancy ihsVacancy;
	
	@Autowired
	private NewHire newHire;
	
	@Autowired
	private Request request;
	
	@Autowired
	private Review review;
	
	@Autowired
	private Task task;
	
	@Autowired
	private TimeToOffer time2Offer;
	
	@Autowired
	private TimeToStaff time2Staff;
	
	@Autowired
	private Vacancy vacancy;
	
	@Autowired
	private CDCTimeToOffer cdcTime2Offer;
	
	@Autowired
	private CDCTimeToStaff cdcTime2Staff;
	
	@Autowired
	private CDCCertificate cdcCert;
	
	@Autowired
	private CDCAudit cdcAudit;
	
		 
	/*
	 * Job - importDSSReports
	 */
	@Bean
	public Job importDSSReports() throws Exception {

    	final Flow offerFlow = new FlowBuilder<Flow>("offerFlow").from(stepBuilderFactory.get("executeOfferReportStep").tasklet(offerTasklet()).listener(stepListener).build()).end();
    	final Flow staffFlow = new FlowBuilder<Flow>("staffFlow").from(stepBuilderFactory.get("executeStaffReportStep").tasklet(staffTasklet()).listener(stepListener).build()).end();
    	final Flow ihsVacancyFlow = new FlowBuilder<Flow>("ihsVacancyFlow").from(stepBuilderFactory.get("executeIHSVacancyReportStep").tasklet(ihsVacancyTasklet()).listener(stepListener).build()).end();
    	final Flow cdcOfferFlow = new FlowBuilder<Flow>("cdcOfferFlow").from(stepBuilderFactory.get("executeCDCOfferReportStep").tasklet(cdcOfferTasklet()).listener(stepListener).build()).end();
    	final Flow cdcStaffFlow = new FlowBuilder<Flow>("cdcStaffFlow").from(stepBuilderFactory.get("executeCDCStaffReportStep").tasklet(cdcStaffTasklet()).listener(stepListener).build()).end();
    	final Flow cdcCertFlow = new FlowBuilder<Flow>("cdcCertFlow").from(stepBuilderFactory.get("executeCDCCertificateReportStep").tasklet(cdcCertTasklet()).listener(stepListener).build()).end();
    	final Flow cdcAuditFlow = new FlowBuilder<Flow>("cdcAuditFlow").from(stepBuilderFactory.get("executeCDCAuditReportStep").tasklet(cdcAuditTasklet()).listener(stepListener).build()).end();
    	final Flow appFlow = new FlowBuilder<Flow>("appFlow").from(stepBuilderFactory.get("executeApplicationReportStep").tasklet(appTasklet()).listener(stepListener).build()).end();
    	final Flow annFlow = new FlowBuilder<Flow>("annFlow").from(stepBuilderFactory.get("executeAnnouncementReportStep").tasklet(annTasklet()).listener(stepListener).build()).end();
    	final Flow certFlow = new FlowBuilder<Flow>("certFlow").from(stepBuilderFactory.get("executeCertificateReportStep").tasklet(certTasklet()).listener(stepListener).build()).end();
    	final Flow newHireFlow = new FlowBuilder<Flow>("newHireFlow").from(stepBuilderFactory.get("executeNewHireReportStep").tasklet(newHireTasklet()).listener(stepListener).build()).end();
    	final Flow requestFlow = new FlowBuilder<Flow>("requestFlow").from(stepBuilderFactory.get("executeRequestReportStep").tasklet(requestTasklet()).listener(stepListener).build()).end();
    	final Flow reviewFlow = new FlowBuilder<Flow>("reviewFlow").from(stepBuilderFactory.get("executeReviewReportStep").tasklet(reviewTasklet()).listener(stepListener).build()).end();
    	final Flow taskFlow = new FlowBuilder<Flow>("taskFlow").from(stepBuilderFactory.get("executeTaskReportStep").tasklet(taskTasklet()).listener(stepListener).build()).end();
    	final Flow vacFlow = new FlowBuilder<Flow>("vacFlow").from(stepBuilderFactory.get("executeVacancyReportStep").tasklet(vacTasklet()).listener(stepListener).build()).end();

    	//Parallel Report Flows
    	final Flow parallelFlow1 = new FlowBuilder<Flow>("parallelFlow1").split(new SimpleAsyncTaskExecutor()).add(offerFlow, staffFlow, ihsVacancyFlow, cdcOfferFlow, cdcStaffFlow, cdcCertFlow,cdcAuditFlow).build();
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
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(announcement);
		return rt;
	}
    
	//Application Tasklet
	@Bean
	@StepScope
	public Tasklet appTasklet() {		
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(application);
		return rt;
	}	
	
	//Certificate Tasklet
	@Bean
	@StepScope
	public Tasklet certTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(certificate);
		return rt;
	}
	
	//New Hire Tasklet
	@Bean
	@StepScope
	public Tasklet newHireTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(newHire);
		return rt;
	}
	
	//Request Tasklet
	@Bean
	@StepScope
	public Tasklet requestTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(request);
		return rt;
	}
	
	//Review Tasklet
	@Bean
	@StepScope
	public Tasklet reviewTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(review);
		return rt;
	}
	
	//Task Tasklet
	@Bean
	@StepScope
	public Tasklet taskTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(task);
		return rt;
	}
	
	//Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet vacTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(vacancy);
		return rt;
	}
	
	//CMS Offer Tasklet
	@Bean
	@StepScope
	public Tasklet offerTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(time2Offer);
		return rt;
	}	
		
	//CMS Staff Tasklet
	@Bean
	@StepScope
	public Tasklet staffTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(time2Staff);
		return rt;
	}
	
	//CDC Offer Tasklet
	@Bean
	@StepScope
	public Tasklet cdcOfferTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(cdcTime2Offer);
		return rt;
	}	
		
	//CDC Staff Tasklet
	@Bean
	@StepScope
	public Tasklet cdcStaffTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(cdcTime2Staff);
		return rt;
	}
	
	//CDC Certificate Tasklet
	@Bean
	@StepScope
	public Tasklet cdcCertTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(cdcCert);
		return rt;
	}
	
	//CDC Audit Tasklet
	@Bean
	@StepScope
	public Tasklet cdcAuditTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(cdcAudit);
		return rt;
	}
	
	//IHS Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet ihsVacancyTasklet() {
		ReportTasklet rt = new ReportTasklet();
		rt.setReport(ihsVacancy);
		return rt;
	}	
	
	@Bean
	public BatchConfigurer configurer() {
		return new DefaultBatchConfigurer(targetDataSource);
	}


	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(targetDataSource);
	}	
	
	//***To resolve error: Can't serialize access for this transaction***
	private JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(targetDataSource);//
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
