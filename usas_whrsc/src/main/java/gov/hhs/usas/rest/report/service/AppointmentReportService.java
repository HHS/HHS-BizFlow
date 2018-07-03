package gov.hhs.usas.rest.report.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import gov.hhs.usas.rest.model.USASResponse;
import gov.hhs.usas.rest.report.model.Appointment.ApptInfoCert;
import gov.hhs.usas.rest.report.model.Appointment.ApptInfoNewHire;
import gov.hhs.usas.rest.report.model.Appointment.Orientation;
import gov.hhs.usas.rest.report.model.Appointment.Position;
import gov.hhs.usas.rest.report.model.Appointment.USAStaffingAppointmentResult;
import gov.hhs.usas.rest.report.model.Appointment.VacancyAnnouncementResult;


public class AppointmentReportService extends ReportService {
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentReportService.class);
	
	private AppointmentReportParser parser;
	private XMLInputFactory xif;
	private StreamSource xml;
	private XMLStreamReader xsr;
	private String PACKAGE_NAME;
	private List<ApptInfoCert> apptInfoCertList;
	private List<ApptInfoNewHire> apptInfoNewHireList;
	private List<Orientation> orientationList;
	private List<Position> positionList;	
	
	private String requestNumber;
	private List<VacancyAnnouncementResult> vacancyAnnouncementList;
	private USAStaffingAppointmentResult usasAppointment;
	
	private Class<?> cls;
	private Object object;	
	
	public AppointmentReportService() {
		this.PACKAGE_NAME = "gov.hhs.usas.rest.report.model.Appointment.";
		this.parser = new AppointmentReportParser();		
		this.apptInfoCertList = new ArrayList<ApptInfoCert>();
		this.apptInfoNewHireList = new ArrayList<ApptInfoNewHire>();
		this.orientationList = new ArrayList<Orientation>();
		this.positionList = new ArrayList<Position>();
		this.vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
		this.requestNumber = "";
		this.usasAppointment = new USAStaffingAppointmentResult();
		this.cls = null;
		this.object = new Object();
	}

	/**
	 * This method is used when a Report is pulled from USA Staffing Cognos
	 * and is available as USASResponse object
	 * @param usasResponse
	 * @return transformed XML report as USAStaffingAppointmentResult object
	 */
	public USAStaffingAppointmentResult parseReportFromUSASResponse(USASResponse usasResponse){
		this.xml = new StreamSource(new StringReader(usasResponse.getResponse()));
		return parseReport();
	}
	
	/**
	 * This method is used when a USA Staffing Report is pre-downloaded
	 * and save at a specific location
	 * @param filePath - absolute path of report XML
	 * @return transformed XML report as USAStaffingAppointmentResult object
	 */
	public USAStaffingAppointmentResult parseReportFromFile(String filePath){
		this.xml = new StreamSource(filePath);
		return parseReport();
	}
	
	
	/**
	 * This method partially reads the XML report and unmarshalls 
	 * the block to respective POJO. When entire XML is read, it uses 
	 * the list of POJOs to transform the XMl to BizFlow consumable format.
	 * @return
	 */
	private USAStaffingAppointmentResult parseReport()
	{
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
						this.cls = Class.forName(PACKAGE_NAME + className);
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
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((ApptInfoCert)this.object).getRequestNumber();
						}
						this.apptInfoCertList.add((ApptInfoCert)this.object);
					}
					if ((this.object instanceof ApptInfoNewHire)) {
						this.apptInfoNewHireList.add((ApptInfoNewHire)this.object);
					}
					if ((this.object instanceof Orientation)) {
						this.orientationList.add((Orientation)this.object);
					}
					if ((this.object instanceof Position)) {
						this.positionList.add((Position)this.object);
					}
					
					if ((this.object == null) || 

							(this.xsr.getEventType() == 4)) {
						this.xsr.next();
					}
				}
			}
			this.vacancyAnnouncementList = this.parser.createVacancyAnnouncementListForUSAStaffingAppointment(this.apptInfoCertList, this.apptInfoNewHireList, this.orientationList, this.positionList);

			this.usasAppointment = this.parser.createUSAStaffingRecruitment(this.requestNumber, this.vacancyAnnouncementList);
		}
		catch (XMLStreamException e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		catch (Exception e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		return this.usasAppointment;
	}


	/*public USAStaffingAppointmentResult parseReport(USASResponse usasResponse)
	{
		try
		{
			this.xif = XMLInputFactory.newFactory();
			//this.reader = new StringReader(usasResponse.getResponseXML());
			if(usasResponse.getResponseXML() != null)
				this.xml = new StreamSource(new StringReader(usasResponse.getResponseXML()));
			else
				this.xml = new StreamSource("WHRSCAppointment.xml");
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
						this.cls = Class.forName(PACKAGE_NAME + className);
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
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((ApptInfoCert)this.object).getRequestNumber();
						}
						this.apptInfoCertList.add((ApptInfoCert)this.object);
					}
					if ((this.object instanceof ApptInfoNewHire)) {
						this.apptInfoNewHireList.add((ApptInfoNewHire)this.object);
					}
					if ((this.object instanceof Orientation)) {
						this.orientationList.add((Orientation)this.object);
					}
					if ((this.object instanceof PositionInfo)) {
						this.positionInfoList.add((PositionInfo)this.object);
					}
					
					if ((this.object == null) || 

							(this.xsr.getEventType() == 4)) {
						this.xsr.next();
					}
				}
			}
			this.vacancyAnnouncementList = this.parser.createVacancyAnnouncementListForUSAStaffingAppointment(this.apptInfoCertList, this.apptInfoNewHireList, this.orientationList, this.positionInfoList);

			this.usasAppointment = this.parser.createUSAStaffingRecruitment(this.requestNumber, this.vacancyAnnouncementList);
		}
		catch (XMLStreamException e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		catch (Exception e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
			e.printStackTrace();
		}
		return this.usasAppointment;
	}
*/
/*	public static void main(String[] args)
	{
		AppointmentReportService test = new AppointmentReportService();
		USASResponse usasResponse = new USASResponse();
		//test.parseReport(usasResponse);
	}*/

/*	private static class XsiTypeReader extends StreamReaderDelegate {
		public XsiTypeReader(XMLStreamReader reader) {
			super(reader);
		}
		@Override
		public String getNamespaceURI() {
			return "";
		}
	}*/
}
