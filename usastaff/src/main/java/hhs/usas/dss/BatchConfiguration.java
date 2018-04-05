package hhs.usas.dss;

import javax.sql.DataSource;


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

import hhs.usas.dss.model.Announcement;
import hhs.usas.dss.model.Application;
import hhs.usas.dss.model.Certificate;
import hhs.usas.dss.model.IHSVacancy;
import hhs.usas.dss.model.NewHire;
import hhs.usas.dss.model.Report;
import hhs.usas.dss.model.Request;
import hhs.usas.dss.model.Review;
import hhs.usas.dss.model.Task;
import hhs.usas.dss.model.TimeToOffer;
import hhs.usas.dss.model.TimeToRecruit;
import hhs.usas.dss.model.Vacancy;


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
		Announcement ann = new Announcement();
		return new ReportTasklet();
	}
    
	//Application Tasklet
	@Bean
	@StepScope
	public Tasklet appTasklet() {		
		Application app = new Application();
		return new ReportTasklet();
	}	
	
	//Certificate Tasklet
	@Bean
	@StepScope
	public Tasklet certTasklet() {
		Certificate cert = new Certificate();
		return new ReportTasklet();
	}
	
	//New Hire Tasklet
	@Bean
	@StepScope
	public Tasklet newHireTasklet() {
		NewHire newHire = new NewHire();
		return new ReportTasklet();
	}
	
	//Request Tasklet
	@Bean
	@StepScope
	public Tasklet requestTasklet() {
		Request request = new Request();
		return new ReportTasklet();
	}
	
	//Review Tasklet
	@Bean
	@StepScope
	public Tasklet reviewTasklet() {
		Review review = new Review();
		return new ReportTasklet();
	}
	
	//Task Tasklet
	@Bean
	@StepScope
	public Tasklet taskTasklet() {
		Task task = new Task();
		return new ReportTasklet();
	}
	
	//Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet vacTasklet() {
		Vacancy vac = new Vacancy();
		return new ReportTasklet();
	}
	
	//Offer Tasklet
	@Bean
	@StepScope
	public Tasklet offerTasklet() {
		TimeToOffer offer = new TimeToOffer();
		return new ReportTasklet();
	}	
		
	//Recruit Tasklet
	@Bean
	@StepScope
	public Tasklet recruitTasklet() {
		TimeToRecruit recruit = new TimeToRecruit();
		return new ReportTasklet();
	}
	
	//IHS Vacancy Tasklet
	@Bean
	@StepScope
	public Tasklet ihsVacancyTasklet() {
		IHSVacancy ihsVac = new IHSVacancy();
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
