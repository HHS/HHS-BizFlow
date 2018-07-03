package gov.hhs.usas.dss;

import java.util.Calendar;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import gov.hhs.usas.dss.ReportGeneration;
import gov.hhs.usas.dss.DateRange;
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
import gov.hhs.usas.dss.Util;


@Component
@PropertySource("classpath:report.properties")
public class ReportTasklet implements Tasklet {

	private static final Logger log = LoggerFactory.getLogger(ReportTasklet.class);

	@Autowired
	private DataSource targetDataSource;
	
	@Value("${save.report.file}")
	private boolean saveReportFile;
	
	@Value("${report.error}")
	private String rptErrorMsg;
	
	@Value("${report.off}")
	private String rptOffMsg;
	
	@Value("${report.success}")
	private String rptSuccessMsg;
	
	@Value("${report.fail}")
	private String rptFailMsg;
	
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
	
	
	
	@SuppressWarnings({ "finally", "resource" })
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		String reportXml;
		Date sysDate;
		Date currentDate;
		Calendar c;
		int rptIteration;
		long start;
		long time;
		int errCnt = 0;
		String errMsg;
		
		Report rpt = null;
		
		if(chunkContext.getStepContext().getStepExecution().getStepName()== offerStepName) {
			rpt = time2Offer;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== staffStepName) {
			rpt = time2Staff;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== ihsVacStepName) {
			rpt = ihsVacancy;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== appStepName) {
			rpt = application;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== annStepName) {
			rpt = announcement;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== certStepName) {
			rpt = certificate;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== newHireStepName) {
			rpt = newHire;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== rqstStepName) {
			rpt = request;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== rvwStepName) {
			rpt = review;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== taskStepName) {
			rpt = task;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName()== vacStepName) {
			rpt = vacancy;
		}
		
		try {			
			if (rpt.isRunReport()) {
				start = System.currentTimeMillis();
				
				sysDate = new Date();
				c = Calendar.getInstance();
				c.setTime(sysDate);
				c.add(Calendar.DATE, 1);
				currentDate = c.getTime();

				if (Util.isNull(rpt.getEndDate())) {
					//If there is no specified end date range then use the default report iteration
					rptIteration = rpt.getRptIteration();
				}else {
					//If there is a specified end date range then calculate the date iteration
					rptIteration = DateRange.generateDateIteration(currentDate, rpt.getEndDate(), rpt.getDateInterval());
				}
				
				if (!Util.isNull(rpt.getSpTruncate())) {
					ReportGeneration.truncateReportTables(targetDataSource, rpt);
				}
				
				for(int i=0; i< rptIteration; i++) {
					
					if((!(i+1< rptIteration)) && (!Util.isNull(rpt.getEndDate()))) {
						DateRange.generateDateRange(currentDate, rpt.getEndDate());
					}else {
						currentDate = DateRange.generateDateRange(currentDate, rpt.getDateInterval());
					}
					
					rpt.setRvpStartDisplay(DateRange.getStartDisplayVal());;
					rpt.setRvpStartUseval(DateRange.getStartUseVal());
					rpt.setRvpEndDisplay(DateRange.getEndDisplayVal());
					rpt.setRvpEndUseval(DateRange.getEndUseVal());
					
					reportXml = ReportGeneration.generateReport(rpt);
					
					if(!Util.isNull(reportXml)) {
						log.info("The report " + rpt.getReportName() + " retrieved data between " + rpt.getRvpStartUseval() + " and " + rpt.getRvpEndUseval());
						if (saveReportFile) {
							ReportGeneration.saveReportFile(rpt, reportXml);
						}
						ReportGeneration.insertReporttoDB(targetDataSource, rpt, reportXml);
					}else {
						log.info("The report " + rpt.getReportName() + " did not retrieve data between " + rpt.getRvpStartUseval() + " and " + rpt.getRvpEndUseval());
						errCnt++;
					}

				}
				time = System.currentTimeMillis() - start;
				log.info("Time taken for downloading " + rpt.getReportName() + " data: " + time + "ms");
				
				if (errCnt > 0) {
					errMsg = "The report " + rpt.getReportName() + " did not retrieve data for " + errCnt + " report iteration(s).";
					log.info(errMsg);
				    contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(), errMsg));
				    chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(rpt.getReportName(), rptErrorMsg);
				} else {
					chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(rpt.getReportName(), rptSuccessMsg);
				}
			} else {
				log.info("The report " + rpt.getReportName() + " is turned off.");
				chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(rpt.getReportName(), rptOffMsg);
			}
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(rpt.getReportName(), rptFailMsg);
		}finally{
			return RepeatStatus.FINISHED;
		}
	}
}
