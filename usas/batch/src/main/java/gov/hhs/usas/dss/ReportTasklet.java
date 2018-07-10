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

import gov.hhs.usas.dss.model.Report;

import gov.hhs.usas.dss.Util;


@Component
@PropertySource("classpath:report.properties")
public class ReportTasklet implements Tasklet {

	public ReportTasklet() {
		super();

	}

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
	
	public Report rpt;
	
	public void setReport(Report rpt) {
		this.rpt = rpt;
	}
	
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
