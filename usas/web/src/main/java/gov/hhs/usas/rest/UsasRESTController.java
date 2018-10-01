package gov.hhs.usas.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.hhs.usas.rest.report.model.Appointment.USAStaffingAppointmentResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CdcRecruitmentResult;
import gov.hhs.usas.rest.report.model.Recruitment.USAStaffingRecruitmentResult;

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
	private static Log log = LogFactory.getLog(UsasRESTController.class);
	@Autowired
	private UsasService usasService;

	/**
	 * This method pulls the specific report for a specific Job Request 
	 * Number and returns the report in Cognos XML dataset format
	 * @param reportName
	 * @param requestNumber
	 * @return
	 */
	@GetMapping(path = "/report/{reportName}/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	public String getReportFromUSASCognos(@PathVariable("reportName") String reportName, @PathVariable("requestNumber") String requestNumber)
	{		
		String response = usasService.getCognosDatasetReport(reportName, requestNumber);
		return response;
	}

	/**
	 * This method uses pulls the Appointment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format.
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingAppointmentResult - BizFlow consumable XML format
	 */
	@GetMapping(path = "/reportXML/appointment/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	public USAStaffingAppointmentResult getAppointmentFormData(@PathVariable String requestNumber)
	{
		log.info("Appointment Form Data Request received for Request Number ["+requestNumber+"].");
		USAStaffingAppointmentResult usasAppointment = usasService.getAppointmentData(requestNumber);

		return usasAppointment;
	}

	/**
	 * This method pulls the Recruitment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format.
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingRecruitmentResult - BizFlow consumable XML format
	 */
	@GetMapping(path = "/reportXML/recruitment/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	public USAStaffingRecruitmentResult getRecruitmentFormData(@PathVariable String requestNumber)
	{
		log.info("Recruitment Form Data Request received for Request Number ["+requestNumber+"].");
		USAStaffingRecruitmentResult usasRecruitment = usasService.getRecruitmentData(requestNumber);

		return usasRecruitment;
	}

	/**
	 * This method pulls the CDC Recruitment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format.
	 * @param requestNumber - Job Request Number
	 * @return CdcRecruitmentResult - BizFlow consumable XML format
	 */
	@GetMapping(path = "/reportXML/cdcrecruitment/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	public CdcRecruitmentResult getCdcRecruitmentFormData(@PathVariable String requestNumber)
	{
		CdcRecruitmentResult cdcRecruitment = usasService.getCdcRecruitmentData(requestNumber);

		return cdcRecruitment;
	}
	
	/**
	 * This method pulls the Applicant Roster Report for 
	 * specific Vacancy Number in HTML format and returns the HTML string.
	 * @param vacancyNumber - Vacancy Identification Number
	 * @return String - HTML value for report result
	 */
	@GetMapping(path = "/reportHTML/applicantroster/{vacancyNumber}", produces = MediaType.TEXT_HTML_VALUE)
	public String getApplicantRosterReport(@PathVariable String vacancyNumber)
	{
		log.info("Applicant Roster Report Request received for Vacancy Number ["+vacancyNumber+"].");
		String applicantRosterReportResult = usasService.getApplicantRosterReport(vacancyNumber).getHtmlResponse();
		return applicantRosterReportResult;
	}

	/**
	 * This method pulls the Applicant Notification Report for  
	 * specific Vacancy Number in HTML format and returns the HTML string.
	 * @param vacancyNumber - Vacancy Identification Number
	 * @return String - HTML value for report result
	 */
	@GetMapping(path = "/reportHTML/applicantnotification/{vacancyNumber}", produces = MediaType.TEXT_HTML_VALUE)
	public String getApplicantNotificationReport(@PathVariable String vacancyNumber)
	{
		log.info("Applicant Notification Report Request received for Vacancy Number ["+vacancyNumber+"].");
		String applicantNotificationReportResult = usasService.getApplicantNotificationReport(vacancyNumber).getHtmlResponse();
		return applicantNotificationReportResult;
	}

}

