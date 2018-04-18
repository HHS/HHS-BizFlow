package gov.hhs.usas.rest;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${report.id.recruitment}")
	private String recruitmentReportID;
	@Value("${report.id.appointment}")
	private String appointmentReportID;
	@Value("${report.format}")
	private String reportFormat;


	/**
	 * This method 
	 * @param reportname
	 * @param requestNumber
	 * @return
	 */
	/*	@RequestMapping(value={"/cognosreport/{reportname}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/xml"}, consumes={"text/plain"})
	@ResponseBody
	public String getAppointmentReportFromUSASCognos(@PathVariable("reportname") String reportname, @RequestBody String requestNumber)
	{
		log.info("Connecting to USAS - Cognos Server to get " + reportname + " report.");
		Prompt prompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);
		String reportID = "";
		if(reportname.equalsIgnoreCase("recruitment"))
			reportID = recruitmentReportID;
		else
			reportID = appointmentReportID;
		CognosReport report = new CognosReport(reportname, reportID, reportFormat, prompt);

		//if(this.c.getReportData(report).getResponseXML() != null)
		String response =this.c.getReportData(report).getResponseXML();
		if(client.getUsasResponse().getResponseCode() != 200){
			response = this.c.getUsasResponse().getErrorMessage();
		}
		return response;
	}*/

	/**
	 * This method connects to USA Staffing Cognos
	 * to pull the specific report for a specific Job Request 
	 * Number and returns the report in Cognos XML dataset format
	 * @param reportName
	 * @param requestNumber
	 * @return
	 */
	@GetMapping("/report/{reportName}/{requestNumber}")
	public String getReportFromUSASCognos(@PathVariable("reportName") String reportName, @PathVariable("requestNumber") String requestNumber)
	{
		log.info("Connecting to USAS - Cognos Server to get " + reportName + " report.");
		String reportID = "";
		if(reportName.equalsIgnoreCase("recruitment"))
			reportID = recruitmentReportID;
		else if(reportName.equalsIgnoreCase("appointment"))
			reportID = appointmentReportID;
		else
			return "Incorrect report name. Correct URL syntax: /usas/report/{reportName}/{requestNumber}";
		Prompt prompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);

		CognosReport report = new CognosReport(reportName, reportID, reportFormat, prompt);

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
	@GetMapping("/report/recruitment")
	public USAStaffingRecruitmentResult transformRecruitmentXML(@RequestParam(value = "reportPath", required = true) String reportPath)
	{
		USAStaffingRecruitmentResult usasRecruitment = new USAStaffingRecruitmentResult();
		File reportXML = new File(reportPath);
		if(reportXML.exists() && reportXML.isFile()){
			log.info("Using XML report for Recruitment located at "+ reportPath + " for transformation.");
			usasRecruitment = new RecruitmentReportService().parseReportFromFile(reportPath);
		}

		return usasRecruitment;
	}

	/**
	 * This method uses GET request to locate the pre-downloaded
	 * Appointment Report XML file and transform it to BizFlow
	 * consumable format.
	 * @param reportPath - XML file location for Appointment Report
	 * @return - Transformed XML for BizFlow
	 */
	@GetMapping("/report/appointment")
	public USAStaffingAppointmentResult transformAppointmentXML(@RequestParam(value = "reportPath", required = true) String reportPath)
	{
		USAStaffingAppointmentResult usasAppointment = new USAStaffingAppointmentResult();
		File reportXML = new File(reportPath);
		if(reportXML.exists() && reportXML.isFile()){
			log.info("Using XML report for Appointment located at "+ reportPath + " for transformation.");
			usasAppointment = new AppointmentReportService().parseReportFromFile(reportPath);

		}

		return usasAppointment;
	}


	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Recruitment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingRecruitmentResult - BizFlow consumable XML format
	 */
	@GetMapping("/reportXML/recruitment/{requestNumber}")
	public USAStaffingRecruitmentResult getRecruitmentData(@PathVariable String requestNumber)
	{
		String reportName = "Recruitment";
		Prompt recruitmentPrompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);
		CognosReport recruitmentReport = new CognosReport(reportName, recruitmentReportID, reportFormat, recruitmentPrompt);

		log.info("Connecting to USAS - Cognos Server to get " + reportName + " report.");    

		//		RecruitmentReportService test = new RecruitmentReportService();    
		USAStaffingRecruitmentResult usasRecruitment = new RecruitmentReportService().parseReportFromUSASResponse(this.client.sendReportDataRequest(recruitmentReport));

		return usasRecruitment;
	}

	/**
	 * This method connects to the USA Staffing Cognos Server to
	 * pull the Appointment Report for specific Job Request Number and 
	 * transforms the Cognos dataSet XML format to BizFlow consumable format
	 * @param requestNumber - Job Request Number
	 * @return USAStaffingAppointmentResult - BizFlow consumable XML format
	 */
	@GetMapping("/reportXML/appointment/{requestNumber}")
	public USAStaffingAppointmentResult getAppointmentData(@PathVariable String requestNumber)
	{
		String reportName = "Appointment";
		Prompt appointmentPrompt = new Prompt("parm_RequestNumber", requestNumber, requestNumber);
		CognosReport appointmentReport = new CognosReport(reportName, appointmentReportID, reportFormat, appointmentPrompt);

		log.info("Connecting to USAS - Cognos Server to get " + reportName + " report.");    

		//		AppointmentReportService test = new AppointmentReportService();    
		//USAStaffingAppointmentResult usasAppointment = test.parseReport(this.c.getReportData(appointmentReport));
		USAStaffingAppointmentResult usasAppointment = new AppointmentReportService().parseReportFromUSASResponse(this.client.sendReportDataRequest(appointmentReport));

		return usasAppointment;
	}

}

