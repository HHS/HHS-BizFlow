package hhs.usas.dss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import hhs.usas.dss.model.Announcement;
import hhs.usas.dss.model.Application;
import hhs.usas.dss.model.Certificate;
import hhs.usas.dss.model.NewHire;
import hhs.usas.dss.model.Request;
import hhs.usas.dss.model.Review;
import hhs.usas.dss.model.Task;
import hhs.usas.dss.model.Vacancy;

@Component 
public class ReportTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(ReportTasklet.class);

	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

				
		try {

			//Retrieve Announcement DSS Report
			Announcement ann = new Announcement();
			ReportGeneration.generateReport(ann);
			
			//Retrieve Application DSS Report
			Application app = new Application();
			ReportGeneration.generateReport(app);
			
			//Retrieve Certificate DSS Report
			Certificate cert = new Certificate();
			ReportGeneration.generateReport(cert);
			
			//Retrieve New Hire DSS Report
			NewHire newHire = new NewHire();
			ReportGeneration.generateReport(newHire);
			
			//Retrieve Request DSS Report
			Request request = new Request();
			ReportGeneration.generateReport(request);
			
			//Retrieve Review DSS Report
			Review review = new Review();
			ReportGeneration.generateReport(review);
			
			//Retrieve Task DSS Report
			Task task = new Task();
			ReportGeneration.generateReport(task);
			
			//Retrieve Vacancy DSS Report
			Vacancy vacancy = new Vacancy();
			ReportGeneration.generateReport(vacancy);


		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}
	}
}
