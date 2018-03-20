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
import hhs.usas.dss.model.Report;


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
		int rptIteration;
		long start;
		long time;
				
		try {
			start = System.currentTimeMillis();
			
			currentDate = new Date();
			
			if (Util.isNull(this.getEndDate())) {
				//If there is no specified end date range then use the default report iteration
				rptIteration = this.getRptIteration();
			}else {
				//If there is a specified end date range then calculate the date iteration
				rptIteration = DateRange.generateDateIteration(currentDate, this.getEndDate(), this.getDateIncrement());
			}
			
			ReportGeneration.truncateReportTables(targetDataSource, this);
			
			for(int i=0; i< rptIteration; i++) {
				
				if((!(i+1< rptIteration)) && (!Util.isNull(this.getEndDate()))) {
					DateRange.generateDateRange(currentDate, this.getEndDate());
				}else {
					currentDate = DateRange.generateDateRange(currentDate, this.getDateIncrement());
				}
				
				this.setRvpStartDisplay(DateRange.getStartDisplayVal());;
				this.setRvpStartUseval(DateRange.getStartUseVal());
				this.setRvpEndDisplay(DateRange.getEndDisplayVal());
				this.setRvpEndUseval(DateRange.getEndUseVal());
				
				reportXml = ReportGeneration.generateReport(this);
				
				if(!Util.isNull(reportXml)) {
					ReportGeneration.saveReportFile(this, reportXml);
					ReportGeneration.insertReporttoDB(targetDataSource, this, reportXml);
				}else {
					log.info("The report " + this.getFileName() + " did not retrieve data between " + this.getRvpStartUseval() + " and " + this.getRvpEndUseval());
				}

			}
			time = System.currentTimeMillis() - start;
			log.info("Time taken for downloading " + this.getFileName() + " data: " + time + "ms");
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			return RepeatStatus.FINISHED;
		}
	}
}
