package gov.hhs.usas.dss;

import javax.sql.DataSource;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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
import gov.hhs.usas.dss.model.TimeToRecruit;
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
	private TimeToRecruit time2Recruit;
	
	@Autowired
	private Vacancy vacancy;
	
	/*
	 * Job - importDSSReports
	 */
	@Bean
	public Job importDSSReports() throws Exception {

    	final Flow appFlow = new FlowBuilder<Flow>("appFlow").from(stepBuilderFactory.get("executeApplicationReportStep").tasklet(appTasklet()).listener(stepListener).build()).end();
    	final Flow annFlow = new FlowBuilder<Flow>("annFlow").from(stepBuilderFactory.get("executeAnnouncementReportStep").tasklet(annTasklet()).listener(stepListener).build()).end();
    	final Flow certFlow = new FlowBuilder<Flow>("certFlow").from(stepBuilderFactory.get("executeCertificateReportStep").tasklet(certTasklet()).listener(stepListener).build()).end();
    	final Flow newHireFlow = new FlowBuilder<Flow>("newHireFlow").from(stepBuilderFactory.get("executeNewHireReportStep").tasklet(newHireTasklet()).listener(stepListener).build()).end();
    	final Flow requestFlow = new FlowBuilder<Flow>("requestFlow").from(stepBuilderFactory.get("executeRequestReportStep").tasklet(requestTasklet()).listener(stepListener).build()).end();
    	final Flow reviewFlow = new FlowBuilder<Flow>("reviewFlow").from(stepBuilderFactory.get("executeReviewReportStep").tasklet(reviewTasklet()).listener(stepListener).build()).end();
    	final Flow taskFlow = new FlowBuilder<Flow>("taskFlow").from(stepBuilderFactory.get("executeTaskReportStep").tasklet(taskTasklet()).listener(stepListener).build()).end();
    	final Flow vacFlow = new FlowBuilder<Flow>("vacFlow").from(stepBuilderFactory.get("executeVacancyReportStep").tasklet(vacTasklet()).listener(stepListener).build()).end();
    	final Flow offerFlow = new FlowBuilder<Flow>("offerFlow").from(stepBuilderFactory.get("executeOfferReportStep").tasklet(offerTasklet()).listener(stepListener).build()).end();
    	final Flow recruitFlow = new FlowBuilder<Flow>("recruitFlow").from(stepBuilderFactory.get("executeRecruitReportStep").tasklet(recruitTasklet()).listener(stepListener).build()).end();
    	final Flow ihsVacancyFlow = new FlowBuilder<Flow>("ihsVacancyFlow").from(stepBuilderFactory.get("executeIHSVacancyReportStep").tasklet(ihsVacancyTasklet()).listener(stepListener).build()).end();
    	
    	
		interfaceName = " USA Staffing Interface";
		return jobBuilderFactory.get("importDSSReports")
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				.preventRestart()
				.start(appFlow).on("*")
				.to(annFlow).on("*")
				.to(certFlow).on("*")
				.to(newHireFlow).on("*")
				.to(requestFlow).on("*")
				.to(reviewFlow).on("*")
				.to(taskFlow).on("*")
				.to(vacFlow).on("*")
				.to(offerFlow).on("*")
				.to(recruitFlow).on("*")
				.to(ihsVacancyFlow)
				.end()
				.build();		
	}

	//Announcement Tasklet
	@Bean
	@StepScope
	public Tasklet annTasklet() {
		announcement.construct();
		return new ReportTasklet();
	}
    
	//Application Tasklet
	@Bean
	@StepScope
	public Tasklet appTasklet() {		
		application.construct();
		return new ReportTasklet();
	}	
	
	//Certificate Tasklet
	@Bean
	@StepScope
	public Tasklet certTasklet() {
		certificate.construct();
		return new ReportTasklet();
	}
	
	//New Hire Tasklet
	@Bean
	@StepScope
	public Tasklet newHireTasklet() {
		newHire.construct();
		return new ReportTasklet();
	}
	
	//Request Tasklet
	@Bean
	@StepScope
	public Tasklet requestTasklet() {
		request.construct();
		return new ReportTasklet();
	}
	
	//Review Tasklet
	@Bean
	@StepScope
	public Tasklet reviewTasklet() {
		review.construct();
		return new ReportTasklet();
	}
	
	//Task Tasklet
	@Bean
	@StepScope
	public Tasklet taskTasklet() {
		task.construct();
		return new ReportTasklet();
	}
	
	//Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet vacTasklet() {
		vacancy.construct();
		return new ReportTasklet();
	}
	
	//Offer Tasklet
	@Bean
	@StepScope
	public Tasklet offerTasklet() {
		time2Offer.construct();
		return new ReportTasklet();
	}	
		
	//Recruit Tasklet
	@Bean
	@StepScope
	public Tasklet recruitTasklet() {
		time2Recruit.construct();
		return new ReportTasklet();
	}
	
	//IHS Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet ihsVacancyTasklet() {
		ihsVacancy.construct();
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
