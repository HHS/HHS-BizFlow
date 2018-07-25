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
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

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
import gov.hhs.usas.dss.whrsc.model.WHRSCDatastoreReport;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class WHRSCReportTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(WHRSCReportTasklet.class);
	
	@Autowired
	private Properties properties;
	
	@Autowired
	private WHRSCReportGenerator reportGenerator;

	@Autowired
	private DataSource whrscTargetDataSource;
	
	private WHRSCDatastoreReport report;
	
	public void setReport(WHRSCDatastoreReport whrscReport){
		this.report = whrscReport;
	}
	
	//@SuppressWarnings({ "finally" })
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		String reportXml;
		Date sysDate;
		Date currentDate;
		Calendar c;
		int reportIteration;
		long start;
		long time;
		int errCnt = 0;
		String errMsg;
		
//		WHRSCDatastoreReport report = new WHRSCDatastoreReport();
		
/*		if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getAnStepName())) {
			report = applicantNotifications;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getClStepName())) {
			report = certificateLocations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getcStepName())) {
			report = certificates;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getPpStepName())) {
			report = permissionProfiles;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getNhfStepName())) {
			report = newHireForms;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getNhodStepName())) {
			report = newHireOnboardingDocuments;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getNhtStepName())) {
			report = newHireTask;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getNhvrStepName())) {
			report = newHireVacancyRequest;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getNhStepName())) {
			report = newHires;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getRlStepName())) {
			report = requestLocations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getRrcStepName())) {
			report = requestRatingCombinations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getRvcStepName())) {
			report = requestVacancyCombinations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getReqStepname())) {
			report = requests;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getVacStepName())) {
			report = vacancies;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getVeStepName())) {
			report = vacancyEligibilities;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getVlStepName())) {
			report = vacancyLocations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getVmcoStepName())) {
			report = vacancyMissionCriticalOccupations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(properties.getVrcStepName())) {
			report = vacancyRatingCombinations;
		}*/
		
		try {			
			if (report.isRunReport()) {
				start = System.currentTimeMillis();
				
				sysDate = new Date();
				c = Calendar.getInstance();
				c.setTime(sysDate);
				c.add(Calendar.DATE, 1);
				currentDate = c.getTime();

				/*if (Util.isNull(report.getEndDate())) {
					//If there is no specified end date range then use the default report iteration
					reportIteration = report.getreportIteration();
				}else {
					//If there is a specified end date range then calculate the date iteration
					reportIteration = DateRange.generateDateIteration(currentDate, report.getEndDate(), report.getDateInterval());
				}
				
				if (!Util.isNull(report.getSpTruncate())) {
					ReportGeneration.truncateReportTables(whrscTargetDataSource, report);
				}*/
				
				/*for(int i=0; i< reportIteration; i++) {
					
					if((!(i+1< reportIteration)) && (!Util.isNull(report.getEndDate()))) {
						DateRange.generateDateRange(currentDate, report.getEndDate());
					}else {
						currentDate = DateRange.generateDateRange(currentDate, report.getDateInterval());
					}
					
					report.setRvpStartDisplay(DateRange.getStartDisplayVal());;
					report.setRvpStartUseval(DateRange.getStartUseVal());
					report.setRvpEndDisplay(DateRange.getEndDisplayVal());
					report.setRvpEndUseval(DateRange.getEndUseVal());
					
					reportXml = ReportGeneration.generateReport(report);
					
					if(!Util.isNull(reportXml)) {
						log.info("The report " + report.getReportName() + " retrieved data between " + report.getRvpStartUseval() + " and " + report.getRvpEndUseval());
						if (saveReportFile) {
							ReportGeneration.saveReportFile(report, reportXml);
						}
						ReportGeneration.insertReporttoDB(whrscTargetDataSource, report, reportXml);
					}else {
						log.info("The report " + report.getReportName() + " did not retrieve data between " + report.getRvpStartUseval() + " and " + report.getRvpEndUseval());
						errCnt++;
					}

				}*/
				
				reportXml = reportGenerator.generateReport(report);
				
				if(!Util.isNull(reportXml)) {
					log.info("The report " + report.getReportName() + " retrieved data.");
					if (!Util.isNull(report.getSpTruncate())) {
						reportGenerator.truncateReportTables(whrscTargetDataSource, report);
					}
					if (properties.saveReport()) {
						reportGenerator.saveReportFile(report, reportXml);
					}
					reportGenerator.insertReporttoDB(whrscTargetDataSource, report, reportXml);
				}else {
					log.info("The report " + report.getReportName() + " did not retrieve any data.");
					errCnt++;
				}
				time = System.currentTimeMillis() - start;
				log.info("Time taken for downloading " + report.getReportName() + " data: " + time + "ms");
				
				if (errCnt > 0) {
					errMsg = "The report " + report.getReportName() + " did not retrieve data for " + errCnt + " report iteration(s).";
					log.info(errMsg);
				    contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(), errMsg));
				    chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(report.getReportName(), properties.getReportErrorMessage());
				} else {
					chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(report.getReportName(), properties.getReportSuccessMessage());
				}
			} else {
				log.info("The report " + report.getReportName() + " is turned off.");
				chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(report.getReportName(), properties.getReportOffMessage());
			}
		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(report.getReportName(), properties.getReportFailMessage());
		}finally{
			return RepeatStatus.FINISHED;
		}
	}

}
