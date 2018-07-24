package gov.hhs.usas.rest.report.service;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.model.USASResponse;
import gov.hhs.usas.rest.report.model.Appointment.ApptInfoCert;
import gov.hhs.usas.rest.report.model.Appointment.ApptInfoNewHire;
import gov.hhs.usas.rest.report.model.Appointment.DutyStationResult;
import gov.hhs.usas.rest.report.model.Appointment.Orientation;
import gov.hhs.usas.rest.report.model.Appointment.PayPlan;
import gov.hhs.usas.rest.report.model.Appointment.Position;
import gov.hhs.usas.rest.report.model.Appointment.USAStaffingAppointmentResult;
import gov.hhs.usas.rest.report.model.Appointment.VacancyAnnouncementResult;

@Component
public class AppointmentReportService extends ReportService {

	private static final Logger log = LoggerFactory.getLogger(AppointmentReportService.class);
	@Autowired
	private Properties properties;
	@Autowired
	private AppointmentReportParser parser;
	private XMLInputFactory xif;
	private StreamSource xml;
	private XMLStreamReader xsr;

	private List<ApptInfoCert> apptInfoCertList;
	private List<ApptInfoNewHire> apptInfoNewHireList;
	private List<Orientation> orientationList;
	private List<PayPlan> payPlanList;
	private List<Position> positionList;	

	private String requestNumber;
	private Map<String, ArrayList<DutyStationResult>> dutyStationMap;
	private List<VacancyAnnouncementResult> vacancyAnnouncementList;
	private USAStaffingAppointmentResult usasAppointment;

	private Class<?> cls;
	private Object object;
	private String appointmentPackage;

	@PostConstruct
	public void init(){	
		this.apptInfoCertList = new ArrayList<ApptInfoCert>();
		this.apptInfoNewHireList = new ArrayList<ApptInfoNewHire>();
		this.orientationList = new ArrayList<Orientation>();
		this.payPlanList = new ArrayList<PayPlan>();
		this.positionList = new ArrayList<Position>();

		this.requestNumber = "";
		this.dutyStationMap = new HashMap<String, ArrayList<DutyStationResult>>();
		this.vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
		this.usasAppointment = new USAStaffingAppointmentResult();
		this.cls = null;
		this.object = new Object();
		this.appointmentPackage = "gov.hhs.usas.rest.report.model.Appointment.";
	}


	/**
	 * This method is used when a Report is pulled from USA Staffing Cognos
	 * and is available as USASResponse object
	 * @param usasResponse
	 * @return transformed XML report as USAStaffingAppointmentResult object
	 */
	public USAStaffingAppointmentResult parseReportFromUSASResponse(USASResponse usasResponse, String originRequestNumber){
		if(usasResponse.getResponseCode() != properties.getHttpStatusOk()){
			if(usasResponse.getResponseCode() == properties.getHttpSuccessNoContent()){
				return new USAStaffingAppointmentResult(properties.getResponseCodeNoDataError(), usasResponse.getErrorMessage());
			}
			return new USAStaffingAppointmentResult(properties.getResponseCodeConnectionError(), usasResponse.getErrorMessage());
		}
		
		//To handle concurrency issue
		String searchRequestNumber = "<Request__Number>" + originRequestNumber +"</Request__Number>";
		if(usasResponse.getResponse().toString().contains(searchRequestNumber)){
			this.requestNumber = originRequestNumber;
			this.xml = new StreamSource(new StringReader(usasResponse.getResponse()));
			return parseReport();
		}else{
			//Suggest end user to try again
			return new USAStaffingAppointmentResult(properties.getResponseCodeReportError(), properties.getReportDataException());
			//return new USAStaffingAppointmentResult(properties.getResponseCodeNoDataError(), usasResponse.getErrorMessage());
		}
	}

	/**
	 * This method is used when a USA Staffing Report is pre-downloaded
	 * and save at a specific location
	 * @param filePath - absolute path of report XML
	 * @return transformed XML report as USAStaffingAppointmentResult object
	 */
	public USAStaffingAppointmentResult parseReportFromFile(String filePath){
		File reportXML = new File(filePath);

		if(reportXML.exists() && reportXML.isFile()){
			this.xml = new StreamSource(filePath);
			return parseReport();
		}
		return new USAStaffingAppointmentResult(properties.getResponseCodeFileError(), "The requested file could not be found.");

	}


	/**
	 * This method partially reads the XML report and unmarshalls 
	 * the block to respective POJO. When entire XML is read, it uses 
	 * the list of POJOs to transform the XMl to BizFlow consumable format.
	 * @return
	 */
	private USAStaffingAppointmentResult parseReport()
	{
		init();
		try
		{
			this.xif = XMLInputFactory.newFactory();
			this.xsr = this.xif.createXMLStreamReader(this.xml);
			this.xsr = new AppointmentReportService.XsiTypeReader(this.xsr);

			String className = "";
			while (this.xsr.hasNext())
			{
				while (((!this.xsr.isStartElement()) || (!this.xsr.getLocalName().equals("id"))) && 
						(this.xsr.getEventType() != 8)) {
					this.xsr.next();
				}
				if ((this.xsr.isStartElement()) && (this.xsr.getLocalName().equals("id")))
				{
					this.xsr.next();
					if (this.xsr.isCharacters())
					{
						className = this.xsr.getText().trim().substring(4, this.xsr.getText().trim().length());
						this.cls = Class.forName(this.getAppointmentPackage() + className);
					}
				}
				while (((!this.xsr.isStartElement()) || (!this.xsr.getLocalName().equals("row"))) && 
						(this.xsr.getEventType() != 8)) {
					this.xsr.next();
				}
				while (this.xsr.getEventType() == 1)
				{
					JAXBContext jc = JAXBContext.newInstance(new Class[] { this.cls });
					Unmarshaller unmarshaller = jc.createUnmarshaller();
					JAXBElement jbe = unmarshaller.unmarshal(this.xsr, this.cls);

					this.object = this.cls.newInstance();
					this.object = jbe.getValue();

					if ((this.object instanceof ApptInfoCert))
					{
						/*if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((ApptInfoCert)this.object).getRequestNumber();
						}*/
						this.apptInfoCertList.add((ApptInfoCert)this.object);
					}
					if ((this.object instanceof ApptInfoNewHire)) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((ApptInfoNewHire)this.object).getRequestNumber();
						}
						this.apptInfoNewHireList.add((ApptInfoNewHire)this.object);
					}
					if ((this.object instanceof Orientation)) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((Orientation)this.object).getRequestNumber();
						}
						this.orientationList.add((Orientation)this.object);
					}
					if ((this.object instanceof PayPlan)) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((PayPlan)this.object).getRequestNumber();
						}
						this.payPlanList.add((PayPlan)this.object);
					}
					if ((this.object instanceof Position)) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((Position)this.object).getRequestNumber();
						}
						this.positionList.add((Position)this.object);
					}

					if ((this.object == null) || 

							(this.xsr.getEventType() == 4)) {
						this.xsr.next();
					}
				}
			}
			this.positionList = this.parser.addPayPlan(this.payPlanList, this.positionList);
			this.dutyStationMap = this.parser.createDutyStationListForCertificate(this.positionList);

			this.vacancyAnnouncementList = this.parser.createVacancyAnnouncementListForUSAStaffingAppointment(this.apptInfoCertList, this.apptInfoNewHireList, this.orientationList, this.positionList, this.dutyStationMap);

			this.usasAppointment = this.parser.createUSAStaffingRecruitment(this.requestNumber, this.vacancyAnnouncementList);
			//If there is no data for vacancy, add an error message
			if(this.usasAppointment.getVacancyCount() == 0){
				this.usasAppointment.setResultCode(properties.getResponseCodeNoDataError());
				this.usasAppointment.setFailureMessage(properties.getNoDataException());
			}
		}
		catch (XMLStreamException e)
		{
			String error = properties.getParseException() + e.getMessage() + "::" + e.getCause();
			log.error(error, e);
			this.usasAppointment = new USAStaffingAppointmentResult(properties.getResponseCodeParseError(), error);
		}
		catch (Exception e)
		{
			String error = properties.getParseException() + e.getMessage() + "::" + e.getCause();
			log.error(error, e);
			this.usasAppointment = new USAStaffingAppointmentResult(properties.getResponseCodeParseError(), error);
		}
		return this.usasAppointment;
	}


	public String getAppointmentPackage() {
		return appointmentPackage;
	}

}
