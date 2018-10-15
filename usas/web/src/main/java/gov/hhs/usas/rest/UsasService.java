package gov.hhs.usas.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.hhs.usas.rest.model.CognosReport;
import gov.hhs.usas.rest.model.Prompt;
import gov.hhs.usas.rest.report.model.ApplicantNotification;
import gov.hhs.usas.rest.report.model.ApplicantRoster;
import gov.hhs.usas.rest.report.model.Appointment.USAStaffingAppointmentResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CdcRecruitmentResult;
import gov.hhs.usas.rest.report.model.Recruitment.USAStaffingRecruitmentResult;
import gov.hhs.usas.rest.report.service.AppointmentReportService;
import gov.hhs.usas.rest.report.service.CdcRecruitmentReportService;
import gov.hhs.usas.rest.report.service.Properties;
import gov.hhs.usas.rest.report.service.RecruitmentReportService;

@Service
public class UsasService {

	private static final Logger log = LoggerFactory.getLogger(UsasService.class);

	@Autowired
	private Properties properties;
	@Autowired
	private CognosRESTClient client;
	@Autowired
	private AppointmentReportService appointmentService;
	@Autowired
	private RecruitmentReportService recruitmentService;
	@Autowired
	private CdcRecruitmentReportService cdcRecruitmentService;

	/**
	 * This method locates the pre-downloaded
	 * Appointment Report XML file and transform it to BizFlow
	 * consumable format when program runs in test mode.
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Appointment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * when program runs in production mode.
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingAppointmentResult - BizFlow consumable XML format
	 */
	public USAStaffingAppointmentResult getAppointmentData(String requestNumber){

		USAStaffingAppointmentResult usasAppointment = new USAStaffingAppointmentResult();

		Prompt appointmentPrompt = new Prompt(properties.getReportPromptRequest(), requestNumber, requestNumber);
		CognosReport appointmentReport = new CognosReport(properties.getAppointmentReportName(), properties.getAppointmentReportPath(), properties.getReportFormatDataSet(), appointmentPrompt);

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){//test mode
			log.info("**Application is running in TEST MODE: Pre-downloaded Appointment report will be used to generate the response.");
			String reportPath = properties.getAppointmentFileLocation() + File.separator + requestNumber + ".xml";
			log.info("Using XML report for Appointment "+ reportPath + " for transformation.");
			usasAppointment = appointmentService.parseReportFromFile(reportPath);
		}else{//normal or production mode
			log.info("Connecting to USAS - Cognos Server to get " + properties.getAppointmentReportName() + " report for Request Number ["+requestNumber+"].");
			usasAppointment = appointmentService.parseReportFromUSASResponse(this.client.processReportDataRequest(appointmentReport), requestNumber);
		}
		
		if(usasAppointment.getRequestNumber().length() == 0)//setting request number for response if not available			
			usasAppointment.setRequestNumber(requestNumber);
		log.info(usasAppointment.toString());
		return usasAppointment;
	}

	/**
	 * This method locates the pre-downloaded
	 * Recruitment Report XML file and transform it to BizFlow
	 * consumable format when program runs in test mode.
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Recruitment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * when program runs in production mode.
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingRecruitmentResult - BizFlow consumable XML format
	 */
	public USAStaffingRecruitmentResult getRecruitmentData(String requestNumber){

		USAStaffingRecruitmentResult usasRecruitment = new USAStaffingRecruitmentResult();

		Prompt recruitmentPrompt = new Prompt(properties.getReportPromptRequest(), requestNumber, requestNumber);
		CognosReport recruitmentReport = new CognosReport(properties.getRecruitmentReportName(), properties.getRecruitmentReportPath(), properties.getReportFormatDataSet(), recruitmentPrompt);

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){//test mode
			log.info("**Application is running in TEST MODE: Pre-downloaded Recruitment report will be used to generate the response.");
			String reportPath = properties.getRecruitmentFileLocation() + File.separator + requestNumber + ".xml";
			log.info("Using XML report for Recruitment "+ reportPath + " for transformation.");
			usasRecruitment = recruitmentService.parseReportFromFile(reportPath);
		}else{//normal or production mode
			log.info("Connecting to USAS - Cognos Server to get " + properties.getRecruitmentReportName() + " report for Request Number ["+requestNumber+"].");    
			usasRecruitment = recruitmentService.parseReportFromUSASResponse(this.client.processReportDataRequest(recruitmentReport), requestNumber);
		}
		if(usasRecruitment.getRequestNumber().length() == 0)//setting request number for response if not available			
			usasRecruitment.setRequestNumber(requestNumber);
		log.info(usasRecruitment.toString());
		return usasRecruitment;
	}
	
	/**
	 * This method locates the pre-downloaded
	 * CDC Recruitment Report XML file and transform it to BizFlow
	 * consumable format when program runs in test mode.
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the CDC Recruitment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * when program runs in production mode.
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingRecruitmentResult - BizFlow consumable XML format
	 */
	public CdcRecruitmentResult getCdcRecruitmentData(String requestNumber){

		CdcRecruitmentResult cdcRecruitment = new CdcRecruitmentResult();

		Prompt cdcRecruitmentPrompt = new Prompt(properties.getReportPromptRequest(), requestNumber, requestNumber);
		CognosReport cdcRecruitmentReport = new CognosReport(properties.getCdcRecruitmentReportName(), properties.getCdcRecruitmentReportPath(), properties.getReportFormatDataSet(), cdcRecruitmentPrompt);

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){//test mode
			log.info("**Application is running in TEST MODE: Pre-downloaded CDC Recruitment report will be used to generate the response.");
			String reportPath = properties.getCdcRecruitmentFileLocation() + File.separator + requestNumber + ".xml";
			log.info("Using XML report for CDC Recruitment "+ reportPath + " for transformation.");
			cdcRecruitment = cdcRecruitmentService.parseReportFromFile(reportPath);
		}else{//normal or production mode
			log.info("Connecting to USAS - Cognos Server to get " + properties.getCdcRecruitmentReportName() + " report for Request Number ["+requestNumber+"].");    
			cdcRecruitment = cdcRecruitmentService.parseReportFromUSASResponse(this.client.processReportDataRequest(cdcRecruitmentReport), requestNumber);
		}
		log.info(cdcRecruitment.toString());
		return cdcRecruitment;
	}

	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Applicant Roster Report for specific Vacancy Number 
	 * in HTML format.
	 * @param vacancyNumber - Vacancy Identification Number
	 * @return ApplicantRoster - Report result
	 */
	public ApplicantRoster getApplicantRosterReport(String vacancyNumber){

		ApplicantRoster applicantRoster = new ApplicantRoster();
		applicantRoster.setVacancyNumber(vacancyNumber);

		Prompt applicantRosterPrompt = new Prompt(properties.getReportPromptVacancy(), vacancyNumber, vacancyNumber);
		CognosReport applicantRosterReport = new CognosReport(properties.getApplicantRosterReportName(), properties.getApplicantRosterReportPath(), properties.getReportFormatHTML(), applicantRosterPrompt);

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){//test mode
			log.info("**Application is running in TEST MODE: Pre-downloaded Applicant Roster report will be used to generate the response.");
			String report = properties.getApplicantRosterFileLocation() + File.separator + vacancyNumber + ".html";
			File htmlFile = new File(report);
			if(htmlFile.exists() && htmlFile.isFile()){
				log.info("Pulling HTML report for " + properties.getApplicantRosterReportName() + " [" + report + "].");

				StringBuilder contentBuilder = new StringBuilder();
				try {
					BufferedReader in = new BufferedReader(new FileReader(report));
					String str;
					while ((str = in.readLine()) != null) {
						contentBuilder.append(str);
					}
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
				applicantRoster.setHtmlResponse(contentBuilder.toString());
			}else{
				applicantRoster.setHtmlResponse(properties.getNoFileException() + "File: " + report);
			}
		}else{//normal or production mode
			log.info("Connecting to USAS - Cognos Server to get " + properties.getApplicantRosterReportName() + " report for Vacancy Number ["+vacancyNumber+"].");    
			applicantRoster.setHtmlResponse(client.processReportDataRequest(applicantRosterReport).getResponse());
		}
		if(applicantRoster.getVacancyNumber().length() == 0)//setting vacancy number for response if not available			
			applicantRoster.setVacancyNumber(vacancyNumber);
		log.info(applicantRoster.toString());
		return applicantRoster;
	}

	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Applicant Notification Report for specific Vacancy Number 
	 * in HTML format.
	 * @param vacancyNumber - Vacancy Identification Number
	 * @return ApplicantNotification - Report result
	 */
	public ApplicantNotification getApplicantNotificationReport(String vacancyNumber){

		ApplicantNotification applicantNotification = new ApplicantNotification();
		applicantNotification.setVacancyNumber(vacancyNumber);

		Prompt applicantNotificationPrompt = new Prompt(properties.getReportPromptVacancy(), vacancyNumber, vacancyNumber);
		CognosReport applicantNotificationReport = new CognosReport(properties.getApplicantNotificationReportName(), properties.getApplicantNotificationReportPath(), properties.getReportFormatHTML(), applicantNotificationPrompt);

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){//test mode
			log.info("**Application is running in TEST MODE: Pre-downloaded Applicant Notification report will be used to generate the response.");
			String report = properties.getApplicantNotificationFileLocation() + File.separator + vacancyNumber + ".html";
			File htmlFile = new File(report);
			if(htmlFile.exists() && htmlFile.isFile()){
				log.info("Pulling HTML report for " + properties.getApplicantNotificationReportName() + " [" + report + "].");

				StringBuilder contentBuilder = new StringBuilder();
				try {
					BufferedReader in = new BufferedReader(new FileReader(report));
					String str;
					while ((str = in.readLine()) != null) {
						contentBuilder.append(str);
					}
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
				applicantNotification.setHtmlResponse(contentBuilder.toString());
			}else{
				applicantNotification.setHtmlResponse(properties.getNoFileException() + "File: " + report);
			}
		}else{//normal or production mode
			log.info("Connecting to USAS - Cognos Server to get " + properties.getApplicantNotificationReportName() + " report for Vacancy Number ["+vacancyNumber+"].");    
			applicantNotification.setHtmlResponse(client.processReportDataRequest(applicantNotificationReport).getResponse());
		}
		if(applicantNotification.getVacancyNumber().length() == 0)//setting vacancy number for response if not available			
			applicantNotification.setVacancyNumber(vacancyNumber);
		log.info(applicantNotification.toString());
		return applicantNotification;
	}

	/**
	 * This method connects to USA Staffing Cognos
	 * to pull the specific report for a specific Job Request 
	 * Number and returns the report in Cognos XML dataset format
	 * @param reportName
	 * @param requestNumber
	 * @return
	 */
	public String getCognosDatasetReport(String reportName, String requestNumber){
		log.info("Connecting to USAS - Cognos Server to get " + reportName + " report for Request Number ["+requestNumber+"].");
		String reportPath = "";
		if(reportName.equalsIgnoreCase("recruitment"))
			reportPath = properties.getRecruitmentReportPath();
		else if(reportName.equalsIgnoreCase("appointment"))
			reportPath = properties.getAppointmentReportPath();
		else
			return "Incorrect report name. Correct URL syntax: /usas/report/{reportName}/{requestNumber}";
		Prompt prompt = new Prompt(properties.getReportPromptRequest(), requestNumber, requestNumber);

		CognosReport report = new CognosReport(reportName, reportPath, properties.getReportFormatDataSet(), prompt);

		String response = client.processReportDataRequest(report).getResponse();
		if(client.getUsasResponse().getResponseCode() != 200){
			response = client.getUsasResponse().getErrorMessage();
		}		
		return response;
	}


}
