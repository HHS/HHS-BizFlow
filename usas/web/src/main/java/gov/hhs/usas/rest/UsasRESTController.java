package gov.hhs.usas.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.hhs.usas.rest.model.CognosReport;
import gov.hhs.usas.rest.model.Prompt;
import gov.hhs.usas.rest.report.model.Appointment.USAStaffingAppointmentResult;
import gov.hhs.usas.rest.report.model.Recruitment.USAStaffingRecruitmentResult;
import gov.hhs.usas.rest.report.service.AppointmentReportService;
import gov.hhs.usas.rest.report.service.Properties;
import gov.hhs.usas.rest.report.service.RecruitmentReportService;

/**
 * @author pvirdi
 *This class acts as main controller class for the
 *USA Staffing Cognos REST Client application.
 */
@RestController
@Controller
@RequestMapping({"/usas"})
public class UsasRESTController
{
	private static final Logger log = LoggerFactory.getLogger(UsasRESTController.class);
	@Autowired
	private CognosRESTClient client;
	@Autowired
	private Properties properties;
	@Autowired
	private AppointmentReportService appointmentService;
	@Autowired
	private RecruitmentReportService recruitmentService;


	/**
	 * This method connects to USA Staffing Cognos
	 * to pull the specific report for a specific Job Request 
	 * Number and returns the report in Cognos XML dataset format
	 * @param reportName
	 * @param requestNumber
	 * @return
	 */
	@GetMapping(path = "/report/{reportName}/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	public String getReportFromUSASCognos(@PathVariable("reportName") String reportName, @PathVariable("requestNumber") String requestNumber)
	{
		log.info("Connecting to USAS - Cognos Server to get " + reportName + " report.");
		String reportID = "";
		if(reportName.equalsIgnoreCase("recruitment"))
			reportID = properties.getRecruitmentReportID();
		else if(reportName.equalsIgnoreCase("appointment"))
			reportID = properties.getAppointmentReportID();
		else
			return "Incorrect report name. Correct URL syntax: /usas/report/{reportName}/{requestNumber}";
		Prompt prompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);

		CognosReport report = new CognosReport(reportName, reportID, properties.getReportFormatDataSet(), prompt);

		String response = client.sendReportDataRequest(report).getResponse();
		if(client.getUsasResponse().getResponseCode() != 200){
			response = client.getUsasResponse().getErrorMessage();
		}
		return response;
	}

	/**
	 * This method uses GET request to locate the pre-downloaded
	 * Appointment Report XML file and transform it to BizFlow
	 * consumable format when program runs in test mode.
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Appointment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * when program runs in production mode.
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingAppointmentResult - BizFlow consumable XML format
	 */
	@GetMapping(path = "/reportXML/appointment/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	public USAStaffingAppointmentResult getAppointmentFormData(@PathVariable String requestNumber)
	{
		Prompt appointmentPrompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);
		CognosReport appointmentReport = new CognosReport(properties.getAppointmentReportName(), properties.getAppointmentReportID(), properties.getReportFormatDataSet(), appointmentPrompt);

		USAStaffingAppointmentResult usasAppointment = new USAStaffingAppointmentResult();

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){
			String reportPath = properties.getAppointmentFileLocation() + File.separator + requestNumber + ".xml";
			log.info("Using XML report for Appointment "+ reportPath + " for transformation.");
			usasAppointment = appointmentService.parseReportFromFile(reportPath);
		}else{
			log.info("Connecting to USAS - Cognos Server to get " + properties.getAppointmentReportName() + " report.");    
			usasAppointment = appointmentService.parseReportFromUSASResponse(this.client.sendReportDataRequest(appointmentReport));
		}

		return usasAppointment;
	}

	/**
	 * This method uses GET request to locate the pre-downloaded
	 * Recruitment Report XML file and transform it to BizFlow
	 * consumable format when program runs in test mode.
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Recruitment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * when program runs in production mode.
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingRecruitmentResult - BizFlow consumable XML format
	 */
	@GetMapping(path = "/reportXML/recruitment/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	public USAStaffingRecruitmentResult getRecruitmentFormData(@PathVariable String requestNumber)
	{
		Prompt recruitmentPrompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);
		CognosReport recruitmentReport = new CognosReport(properties.getRecruitmentReportName(), properties.getRecruitmentReportID(), properties.getReportFormatDataSet(), recruitmentPrompt);

		USAStaffingRecruitmentResult usasRecruitment = new USAStaffingRecruitmentResult();

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){
			String reportPath = properties.getRecruitmentFileLocation() + File.separator + requestNumber + ".xml";
			log.info("Using XML report for Recruitment "+ reportPath + " for transformation.");
			usasRecruitment = recruitmentService.parseReportFromFile(reportPath);
		}else{
			log.info("Connecting to USAS - Cognos Server to get " + properties.getRecruitmentReportName() + " report.");    
			usasRecruitment = recruitmentService.parseReportFromUSASResponse(this.client.sendReportDataRequest(recruitmentReport));
		}

		return usasRecruitment;
	}

	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Applicant Roster Report for specific Vacancy Number 
	 * in HTML format and returns the HTML string.
	 * @param vacancyNumber - Vacancy Identification Number
	 * @return String - HTML value for report result
	 */
	@GetMapping(path = "/reportHTML/applicantroster/{vacancyNumber}", produces = MediaType.TEXT_HTML_VALUE)
	public String getApplicantRosterReport(@PathVariable String vacancyNumber)
	{
		Prompt applicantRosterPrompt = new Prompt("parm_VacancyNumber", vacancyNumber, vacancyNumber);
		CognosReport applicantRosterReport = new CognosReport(properties.getApplicantRosterReportName(), properties.getApplicantRosterReportID(), properties.getReportFormatHTML(), applicantRosterPrompt);

		String applicantRosterReportResult = "";
		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){
			String report = properties.getApplicantRosterFileLocation() + File.separator + vacancyNumber + ".html";
			File htmlFile = new File(report);
			if(htmlFile.exists() && htmlFile.isFile()){
				log.info("Pulling HTML report for " + properties.getApplicantRosterReportName() + " " + report + ".");

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
				applicantRosterReportResult = contentBuilder.toString();
			}else{
				applicantRosterReportResult = properties.getNoFileException() + "File: " + report;
			}
		}else{
			log.info("Connecting to USAS - Cognos Server to get " + properties.getApplicantRosterReportName() + " report.");    
			applicantRosterReportResult = this.client.sendReportDataRequest(applicantRosterReport).getResponse();
		}
		
		
		return applicantRosterReportResult;
	}

	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Applicant Roster Report for specific Vacancy Number 
	 * in HTML format and returns the HTML string.
	 * @param vacancyNumber - Vacancy Identification Number
	 * @return String - HTML value for report result
	 */
	@GetMapping(path = "/reportHTML/applicantnotification/{vacancyNumber}", produces = MediaType.TEXT_HTML_VALUE)
	public String getApplicantNotificationReport(@PathVariable String vacancyNumber)
	{
		Prompt applicantNotificationPrompt = new Prompt("parm_VacancyNumber", vacancyNumber, vacancyNumber);
		CognosReport applicantNotificationReport = new CognosReport(properties.getApplicantNotificationReportName(), properties.getApplicantNotificationReportID(), properties.getReportFormatHTML(), applicantNotificationPrompt);
		String applicantNotificationReportResult = "";
		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){
			String report = properties.getApplicantNotificationFileLocation() + File.separator + vacancyNumber + ".html";
			File htmlFile = new File(report);
			if(htmlFile.exists() && htmlFile.isFile()){
				log.info("Pulling HTML report for " + properties.getApplicantNotificationReportName() + " " + report + ".");

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
				applicantNotificationReportResult = contentBuilder.toString();
			}else{
				applicantNotificationReportResult = properties.getNoFileException() + "File: " + report;
			}
		}else{
			log.info("Connecting to USAS - Cognos Server to get " + properties.getApplicantNotificationReportName() + " report.");    
			applicantNotificationReportResult = this.client.sendReportDataRequest(applicantNotificationReport).getResponse();
		}


		return applicantNotificationReportResult;
	}

}

