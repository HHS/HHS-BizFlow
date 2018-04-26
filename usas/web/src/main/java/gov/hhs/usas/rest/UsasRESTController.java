package gov.hhs.usas.rest;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

		CognosReport report = new CognosReport(reportName, reportID, properties.getReportFormat(), prompt);

		String response = client.sendReportDataRequest(report).getResponse();
		if(client.getUsasResponse().getResponseCode() != 200){
			response = client.getUsasResponse().getErrorMessage();
		}
		return response;
	}



	/**
	 * This method uses GET request to locate the pre-downloaded
	 * Recruitment Report XML file and transform it to BizFlow
	 * consumable format.
	 * @param reportPath - XML file location for Recruitment Report
	 * @return - Transformed XML for BizFlow
	 */
	@GetMapping(path = "/report/recruitment", produces = MediaType.APPLICATION_XML_VALUE)
	public USAStaffingRecruitmentResult transformRecruitmentXML(@RequestParam(value = "reportPath", required = true) String reportPath)
	{
		USAStaffingRecruitmentResult usasRecruitment = new USAStaffingRecruitmentResult();
		log.info("Using XML report for Recruitment located at "+ reportPath + " for transformation.");
		usasRecruitment = recruitmentService.parseReportFromFile(reportPath);
		return usasRecruitment;
	}

	/**
	 * This method uses GET request to locate the pre-downloaded
	 * Appointment Report XML file and transform it to BizFlow
	 * consumable format.
	 * @param reportPath - XML file location for Appointment Report
	 * @return - Transformed XML for BizFlow
	 */
	@GetMapping(path = "/report/appointment", produces = MediaType.APPLICATION_XML_VALUE)
	public USAStaffingAppointmentResult transformAppointmentXML(@RequestParam(value = "reportPath", required = true) String reportPath)
	{
		USAStaffingAppointmentResult usasAppointment = new USAStaffingAppointmentResult();
		log.info("Using XML report for Appointment located at "+ reportPath + " for transformation.");
		usasAppointment = appointmentService.parseReportFromFile(reportPath);
		return usasAppointment;
	}


	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Recruitment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingRecruitmentResult - BizFlow consumable XML format
	 */
//	@GetMapping(path = "/reportXML/recruitment/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
//	public USAStaffingRecruitmentResult getRecruitmentData(@PathVariable String requestNumber)
//	{
//		Prompt recruitmentPrompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);
//		CognosReport recruitmentReport = new CognosReport(properties.getRecruitmentReportName(), properties.getRecruitmentReportID(), properties.getReportFormat(), recruitmentPrompt);
//
//		log.info("Connecting to USAS - Cognos Server to get " + properties.getRecruitmentReportName() + " report.");    
//
//		USAStaffingRecruitmentResult usasRecruitment = recruitmentService.parseReportFromUSASResponse(this.client.sendReportDataRequest(recruitmentReport));
//
//		return usasRecruitment;
//	}

	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Appointment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingAppointmentResult - BizFlow consumable XML format
	 */
	//	@GetMapping(path = "/reportXML/appointment/{requestNumber}", produces = MediaType.APPLICATION_XML_VALUE)
	//	public USAStaffingAppointmentResult getAppointmentData(@PathVariable String requestNumber)
	//	{
	//		Prompt appointmentPrompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);
	//		CognosReport appointmentReport = new CognosReport(properties.getAppointmentReportName(), properties.getAppointmentReportID(), properties.getReportFormat(), appointmentPrompt);
	//
	//		log.info("Connecting to USAS - Cognos Server to get " + properties.getAppointmentReportName() + " report.");    
	//
	//		USAStaffingAppointmentResult usasAppointment = appointmentService.parseReportFromUSASResponse(this.client.sendReportDataRequest(appointmentReport));
	//
	//		return usasAppointment;
	//	}


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
		CognosReport appointmentReport = new CognosReport(properties.getAppointmentReportName(), properties.getAppointmentReportID(), properties.getReportFormat(), appointmentPrompt);

		USAStaffingAppointmentResult usasAppointment = new USAStaffingAppointmentResult();

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){
			String reportPath = properties.getAppointmentFileLocation() + File.separator + requestNumber + ".xml";
			log.info("Using XML report for Appointment located at "+ reportPath + " for transformation.");
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
		CognosReport recruitmentReport = new CognosReport(properties.getRecruitmentReportName(), properties.getRecruitmentReportID(), properties.getReportFormat(), recruitmentPrompt);

		USAStaffingRecruitmentResult usasRecruitment = new USAStaffingRecruitmentResult();

		if(properties.getProgramMode().equalsIgnoreCase(properties.getTestMode())){
			String reportPath = properties.getRecruitmentFileLocation() + File.separator + requestNumber + ".xml";
			log.info("Using XML report for Recruitment located at "+ reportPath + " for transformation.");
			usasRecruitment = recruitmentService.parseReportFromFile(reportPath);
		}else{
			log.info("Connecting to USAS - Cognos Server to get " + properties.getRecruitmentReportName() + " report.");    
			usasRecruitment = recruitmentService.parseReportFromUSASResponse(this.client.sendReportDataRequest(recruitmentReport));
		}

		return usasRecruitment;
	}

}

