package hhs.usas.dss;

import java.util.Date;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hhs.usas.dss.ReportGeneration;
import hhs.usas.dss.DateRange;
import hhs.usas.dss.model.Announcement;
import hhs.usas.dss.model.Application;
import hhs.usas.dss.model.Certificate;
import hhs.usas.dss.model.NewHire;
import hhs.usas.dss.model.Report;
import hhs.usas.dss.model.Request;
import hhs.usas.dss.model.Review;
import hhs.usas.dss.model.Task;
import hhs.usas.dss.model.Vacancy;

@Component
public class ReportTasklet extends Report implements Tasklet {

	private static final Logger log = LoggerFactory.getLogger(ReportTasklet.class);

	@Autowired
	private DataSource targetDataSource;
		
	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		String reportXml;
		Date currentDate;			
				
		try {

			currentDate = new Date();

			//Retrieve Announcement DSS Report
			Announcement ann = new Announcement();
			for(int i=0; i< ann.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, ann.getDateRange());
				ann.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				ann.setRvpStartUseval(DateRange.getStartUseVal());
				ann.setRvpEndDisplay(DateRange.getEndDisplayVal());
				ann.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(ann);
				ReportGeneration.saveReportFile(ann, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, ann, reportXml);
			}		
		
			currentDate = new Date();

			//Retrieve Application DSS Report
			Application app = new Application();
			for(int i=0; i< app.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, app.getDateRange());
				app.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				app.setRvpStartUseval(DateRange.getStartUseVal());
				app.setRvpEndDisplay(DateRange.getEndDisplayVal());
				app.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(app);
				ReportGeneration.saveReportFile(app, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, app, reportXml);
			}	
			
/*			currentDate = new Date();
			
			//Retrieve Certificate DSS Report
			Certificate cert = new Certificate();
			for(int i=0; i< cert.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, cert.getDateRange());
				cert.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				cert.setRvpStartUseval(DateRange.getStartUseVal());
				cert.setRvpEndDisplay(DateRange.getEndDisplayVal());
				cert.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(cert);
				ReportGeneration.saveReportFile(cert, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, cert, reportXml);
			}				
			
			currentDate = new Date();

			//Retrieve New Hire DSS Report
			NewHire newHire = new NewHire();
			for(int i=0; i< newHire.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, newHire.getDateRange());
				newHire.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				newHire.setRvpStartUseval(DateRange.getStartUseVal());
				newHire.setRvpEndDisplay(DateRange.getEndDisplayVal());
				newHire.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(newHire);
				ReportGeneration.saveReportFile(newHire, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, newHire, reportXml);
			}	
			
			currentDate = new Date();

			//Retrieve Request DSS Report
			Request request = new Request();
			for(int i=0; i< request.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, request.getDateRange());
				request.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				request.setRvpStartUseval(DateRange.getStartUseVal());
				request.setRvpEndDisplay(DateRange.getEndDisplayVal());
				request.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(request);
				ReportGeneration.saveReportFile(request, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, request, reportXml);
			}				
			
			currentDate = new Date();

			//Retrieve Review DSS Report
			Review review = new Review();
			for(int i=0; i< review.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, review.getDateRange());
				review.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				review.setRvpStartUseval(DateRange.getStartUseVal());
				review.setRvpEndDisplay(DateRange.getEndDisplayVal());
				review.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(review);
				ReportGeneration.saveReportFile(review, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, review, reportXml);
			}				
			
			currentDate = new Date();
			
			//Retrieve Task DSS Report
			Task task = new Task();
			for(int i=0; i< task.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, task.getDateRange());
				task.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				task.setRvpStartUseval(DateRange.getStartUseVal());
				task.setRvpEndDisplay(DateRange.getEndDisplayVal());
				task.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(task);
				ReportGeneration.saveReportFile(task, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, task, reportXml);
*/
			currentDate = new Date();

			//Retrieve Vacancy DSS Report
			Vacancy vacancy = new Vacancy();
			for(int i=0; i< vacancy.getRptIteration(); i++) {
				currentDate = DateRange.generateDateRange(currentDate, vacancy.getDateRange());
				vacancy.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				vacancy.setRvpStartUseval(DateRange.getStartUseVal());
				vacancy.setRvpEndDisplay(DateRange.getEndDisplayVal());
				vacancy.setRvpEndUseval(DateRange.getEndUseVal());
				reportXml = ReportGeneration.generateReport(vacancy);
				ReportGeneration.saveReportFile(vacancy, reportXml);
				ReportGeneration.insertReporttoDB(targetDataSource, vacancy, reportXml);
			}
			
			//reportXml = ReportGeneration.generateReport(this);
			//ReportGeneration.saveReportFile(this, reportXml);
			//ReportGeneration.insertReporttoDB(targetDataSource, this, reportXml);
		
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}
	}
}
