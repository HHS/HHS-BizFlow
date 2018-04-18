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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import gov.hhs.usas.rest.model.USASResponse;
import gov.hhs.usas.rest.report.model.Recruitment.ApplicantRating;
import gov.hhs.usas.rest.report.model.Recruitment.ApplicantRatingDates;
import gov.hhs.usas.rest.report.model.Recruitment.ApplicantRatingResult;
import gov.hhs.usas.rest.report.model.Recruitment.CertificateInformation;
import gov.hhs.usas.rest.report.model.Recruitment.CertificateResult;
import gov.hhs.usas.rest.report.model.Recruitment.PositionsResult;
import gov.hhs.usas.rest.report.model.Recruitment.PreRecruitment;
import gov.hhs.usas.rest.report.model.Recruitment.USAStaffingRecruitmentResult;
import gov.hhs.usas.rest.report.model.Recruitment.VacancyAnnouncement;
import gov.hhs.usas.rest.report.model.Recruitment.VacancyAnnouncementResult;

@Service
public class RecruitmentReportService extends ReportService
{
	private static final Logger log = LoggerFactory.getLogger(RecruitmentReportService.class);
	private RecruitmentReportParser parser;
	private XMLInputFactory xif;
	private StreamSource xml;
	private XMLStreamReader xsr;
	@Value("${package.recruitment}")
	private String PACKAGE_NAME;
	
	private List<PreRecruitment> preRecruitmentPositions;
	private List<CertificateInformation> certificates;
	private List<VacancyAnnouncement> vacancyAnnouncements;
	
	private PositionsResult positions;
	private List<CertificateResult> certificateList;
	private List<ApplicantRatingResult> applicantRatingList;
	private List<VacancyAnnouncementResult> vacancyAnnouncementList;
	private String requestNumber;
	private USAStaffingRecruitmentResult usasRecruitment;
	
	private Class<?> cls;
	private Object object;
	private Object object2;
	

	public RecruitmentReportService() {
		this.parser = new RecruitmentReportParser();
		this.preRecruitmentPositions = new ArrayList<PreRecruitment>();
		this.certificates = new ArrayList<CertificateInformation>();
		this.vacancyAnnouncements = new ArrayList<VacancyAnnouncement>();
		this.positions = new PositionsResult();
		this.certificateList = new ArrayList<CertificateResult>();
		this.applicantRatingList = new ArrayList<ApplicantRatingResult>();
		this.vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
		this.requestNumber = "";
		this.usasRecruitment = new USAStaffingRecruitmentResult();
		this.cls = null;
		this.object = new Object();
		this.object2 = new Object();
	}

	/**
	 * This method is used when a Report is pulled from USA Staffing Cognos
	 * and is available as USASResponse object
	 * @param usasResponse
	 * @return transformed XML report as USAStaffingRecruitmentResult object
	 */
	public USAStaffingRecruitmentResult parseReportFromUSASResponse(USASResponse usasResponse){
		this.xml = new StreamSource(new StringReader(usasResponse.getResponse()));
		return parseReport();
	}
	
	/**
	 * This method is used when a USA Staffing Report is pre-downloaded
	 * and save at a specific location
	 * @param filePath - absolute path of report XML
	 * @return transformed XML report as USAStaffingRecruitmentResult object
	 */
	public USAStaffingRecruitmentResult parseReportFromFile(String filePath){
		this.xml = new StreamSource(filePath);
		return parseReport();
	}
	
	
	/**
	 * This method partially reads the XML report and unmarshalls 
	 * the block to respective POJO. When entire XML is read, it uses 
	 * the list of POJOs to transform the XMl to BizFlow consumable format.
	 * @return
	 */
	public USAStaffingRecruitmentResult parseReport()
	{
		try
		{
			this.xif = XMLInputFactory.newFactory();
			this.xsr = this.xif.createXMLStreamReader(this.xml);
			this.xsr = new RecruitmentReportService.XsiTypeReader(this.xsr);

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
					if ((this.object instanceof gov.hhs.usas.rest.report.model.Recruitment.ApplicantRating))
					{
						this.object2 = this.cls.newInstance();
						this.object2 = jbe.getValue();
					}
					else
					{
						this.object = this.cls.newInstance();
						this.object = jbe.getValue();
					}
					if ((this.object instanceof PreRecruitment))
					{
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((PreRecruitment)this.object).getRequestNumber();
						}
						this.preRecruitmentPositions.add((PreRecruitment)this.object);
					}
					if ((this.object instanceof CertificateInformation)) {
						this.certificates.add((CertificateInformation)this.object);
					}
					if (((this.object instanceof ApplicantRating)) && ((this.object2 instanceof ApplicantRatingDates))) {
						this.applicantRatingList.add(this.parser.createApplicantRatingForVacancyAnnouncement((ApplicantRating)this.object, (ApplicantRatingDates)this.object2));
					}
					if ((this.object2 instanceof VacancyAnnouncement)) {
						this.vacancyAnnouncements.add((VacancyAnnouncement)this.object2);
					}
					if ((this.object == null) || 

							(this.xsr.getEventType() == 4)) {
						this.xsr.next();
					}
				}
			}
			this.positions = this.parser.createPositionsForUSAStaffingRecruitment(this.preRecruitmentPositions);
			this.certificateList = this.parser.createCertificateListForVacancyAnnouncement(this.certificates);
			this.vacancyAnnouncementList = this.parser.createVacancyAnnouncementListForUSAStaffingRecruitment(this.certificateList, this.applicantRatingList, this.vacancyAnnouncements);

			this.usasRecruitment = this.parser.createUSAStaffingRecruitment(this.requestNumber, this.vacancyAnnouncementList, this.positions);
		}
		catch (XMLStreamException e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		catch (Exception e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		return this.usasRecruitment;
	}
	/*public USAStaffingRecruitmentResult parseReport(USASResponse usasResponse)
	{
		try
		{
			this.xif = XMLInputFactory.newFactory();
			//this.reader = new StringReader(usasResponse.getResponseXML());
			if(usasResponse.getResponse() != null)
				this.xml = new StreamSource(new StringReader(usasResponse.getResponse()));
			else
				this.xml = new StreamSource("WHRSCRecruitment2.xml");
			this.xsr = this.xif.createXMLStreamReader(this.xml);
			this.xsr = new RecruitmentReportService.XsiTypeReader(this.xsr);

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
					if ((this.object instanceof gov.hhs.usas.rest.report.model.cognos.Recruitment.ApplicantRating))
					{
						this.object2 = this.cls.newInstance();
						this.object2 = jbe.getValue();
					}
					else
					{
						this.object = this.cls.newInstance();
						this.object = jbe.getValue();
					}
					if ((this.object instanceof PreRecruitment))
					{
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((PreRecruitment)this.object).getRequestNumber();
						}
						this.preRecruitmentPositions.add((PreRecruitment)this.object);
					}
					if ((this.object instanceof CertificateInformation)) {
						this.certificates.add((CertificateInformation)this.object);
					}
					if (((this.object instanceof gov.hhs.usas.rest.report.model.cognos.Recruitment.ApplicantRating)) && ((this.object2 instanceof ApplicantRatingDates))) {
						this.applicantRatingList.add(this.parser.createApplicantRatingForVacancyAnnouncement((gov.hhs.usas.rest.report.model.cognos.Recruitment.ApplicantRating)this.object, (ApplicantRatingDates)this.object2));
					}
					if ((this.object2 instanceof gov.hhs.usas.rest.report.model.cognos.Recruitment.VacancyAnnouncement)) {
						this.vacancyAnnouncements.add((gov.hhs.usas.rest.report.model.cognos.Recruitment.VacancyAnnouncement)this.object2);
					}
					if ((this.object == null) || 

							(this.xsr.getEventType() == 4)) {
						this.xsr.next();
					}
				}
			}
			this.positions = this.parser.createPositionsForUSAStaffingRecruitment(this.preRecruitmentPositions);
			this.certificateList = this.parser.createCertificateListForVacancyAnnouncement(this.certificates);
			this.vacancyAnnouncementList = this.parser.createVacancyAnnouncementListForUSAStaffingRecruitment(this.certificateList, this.applicantRatingList, this.vacancyAnnouncements);

			this.usasRecruitment = this.parser.createUSAStaffingRecruitment(this.requestNumber, this.vacancyAnnouncementList, this.positions);
		}
		catch (XMLStreamException e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		catch (Exception e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		return this.usasRecruitment;
	}*/

	/*public static void main(String[] args)
	{
		RecruitmentReportService test = new RecruitmentReportService();
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
