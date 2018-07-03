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
import org.springframework.context.annotation.PropertySources;
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
import gov.hhs.usas.dss.whrsc.model.Report;
import gov.hhs.usas.dss.whrsc.model.RequestLocations;
import gov.hhs.usas.dss.whrsc.model.RequestRatingCombinations;
import gov.hhs.usas.dss.whrsc.model.RequestVacancyCombinations;
import gov.hhs.usas.dss.whrsc.model.Requests;
import gov.hhs.usas.dss.whrsc.model.Vacancies;
import gov.hhs.usas.dss.whrsc.model.VacancyEligibilities;
import gov.hhs.usas.dss.whrsc.model.VacancyLocations;
import gov.hhs.usas.dss.whrsc.model.VacancyMissionCriticalOccupations;
import gov.hhs.usas.dss.whrsc.model.VacancyRatingCombinations;

@Component
@PropertySources({
	@PropertySource("classpath:whrsc-app.properties"),
	@PropertySource("classpath:whrsc-report.properties")
})
public class WHRSCReportTasklet implements Tasklet{

	private static final Logger log = LoggerFactory.getLogger(WHRSCReportTasklet.class);
	
	@Autowired
	private WHRSCReportGenerator reportGenerator;

	@Autowired
	private DataSource whrscTargetDataSource;
	
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

	@Value("${an.step.name}")
	private String appNotifStepName;
	
	@Value("${cl.step.name}")
	private String certLocStepName;
	
	@Value("${c.step.name}")
	private String certsStepName;
	
	@Value("${pp.step.name}")
	private String permStepName;
	
	@Value("${nhf.step.name}")
	private String newHireFormsStepName;
	
	@Value("${nhod.step.name}")
	private String newHireOnDocsStepName;
	
	@Value("${nht.step.name}")
	private String newHireTaskStepName;
	
	@Value("${nhvr.step.name}")
	private String newHireVacReqStepName;
	
	@Value("${nh.step.name}")
	private String newHiresStepName;
	
	@Value("${rl.step.name}")
	private String reqLocStepName;

	@Value("${rrc.step.name}")
	private String reqRatngCombStepName;

	@Value("${rvc.step.name}")
	private String reqVacncyCombStepName;

	@Value("${req.step.name}")
	private String reqStepName;

	@Value("${vac.step.name}")
	private String vacncyStepName;

	@Value("${ve.step.name}")
	private String vacncyEligStepName;

	@Value("${vl.step.name}")
	private String vacncyLocStepName;

	@Value("${vmco.step.name}")
	private String vacncyMissnCritclStepName;

	@Value("${vrc.step.name}")
	private String vacncyRatngCombStepName;
	
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

		
	
	//@SuppressWarnings({ "finally" })
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
		
		Report rpt = new Report();
		
		if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(appNotifStepName)) {
			rpt = applicantNotifications;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(certLocStepName)) {
			rpt = certificateLocations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(certsStepName)) {
			rpt = certificates;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(permStepName)) {
			rpt = permissionProfiles;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(newHireFormsStepName)) {
			rpt = newHireForms;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(newHireOnDocsStepName)) {
			rpt = newHireOnboardingDocuments;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(newHireTaskStepName)) {
			rpt = newHireTask;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(newHireVacReqStepName)) {
			rpt = newHireVacancyRequest;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(newHiresStepName)) {
			rpt = newHires;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(reqLocStepName)) {
			rpt = requestLocations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(reqRatngCombStepName)) {
			rpt = requestRatingCombinations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(reqVacncyCombStepName)) {
			rpt = requestVacancyCombinations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(reqStepName)) {
			rpt = requests;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(vacncyStepName)) {
			rpt = vacancies;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(vacncyEligStepName)) {
			rpt = vacancyEligibilities;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(vacncyLocStepName)) {
			rpt = vacancyLocations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(vacncyMissnCritclStepName)) {
			rpt = vacancyMissionCriticalOccupations;
		}else if(chunkContext.getStepContext().getStepExecution().getStepName().equalsIgnoreCase(vacncyRatngCombStepName)) {
			rpt = vacancyRatingCombinations;
		}
		
		try {			
			if (rpt.isRunReport()) {
				start = System.currentTimeMillis();
				
				sysDate = new Date();
				c = Calendar.getInstance();
				c.setTime(sysDate);
				c.add(Calendar.DATE, 1);
				currentDate = c.getTime();

				/*if (Util.isNull(rpt.getEndDate())) {
					//If there is no specified end date range then use the default report iteration
					rptIteration = rpt.getRptIteration();
				}else {
					//If there is a specified end date range then calculate the date iteration
					rptIteration = DateRange.generateDateIteration(currentDate, rpt.getEndDate(), rpt.getDateInterval());
				}
				
				if (!Util.isNull(rpt.getSpTruncate())) {
					ReportGeneration.truncateReportTables(whrscTargetDataSource, rpt);
				}*/
				
				/*for(int i=0; i< rptIteration; i++) {
					
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
						ReportGeneration.insertReporttoDB(whrscTargetDataSource, rpt, reportXml);
					}else {
						log.info("The report " + rpt.getReportName() + " did not retrieve data between " + rpt.getRvpStartUseval() + " and " + rpt.getRvpEndUseval());
						errCnt++;
					}

				}*/
				
				reportXml = reportGenerator.generateReport(rpt); //WHRSCReportGenerator.generateReport(rpt);
				
				if(!Util.isNull(reportXml)) {
					log.info("The report " + rpt.getReportName() + " retrieved data.");
					if (saveReportFile) {
						reportGenerator.saveReportFile(rpt, reportXml); //WHRSCReportGenerator.saveReportFile(rpt, reportXml);
					}
					reportGenerator.insertReporttoDB(whrscTargetDataSource, rpt, reportXml);
				}else {
					log.info("The report " + rpt.getReportName() + " did not retrieve any data.");
					errCnt++;
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
