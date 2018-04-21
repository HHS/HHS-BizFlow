package gov.hhs.usas.rest.report.service;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
import gov.hhs.usas.rest.report.model.Appointment.USAStaffingAppointmentResult;
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

@Component
public class RecruitmentReportService extends ReportService
{
	private static final Logger log = LoggerFactory.getLogger(RecruitmentReportService.class);
	@Autowired
	private Properties properties;
	@Autowired
	private RecruitmentReportParser parser;
	private XMLInputFactory xif;
	private StreamSource xml;
	private XMLStreamReader xsr;	

	private List<PreRecruitment> preRecruitmentPositions;
	private List<CertificateInformation> certificates;
	private List<ApplicantRating> applicantRatings;
	private List<ApplicantRatingDates> applicantRatingDates;
	private List<VacancyAnnouncement> vacancyAnnouncements;

	private PositionsResult positions;
	private List<CertificateResult> certificateList;
	private List<ApplicantRatingResult> applicantRatingList;
	private List<VacancyAnnouncementResult> vacancyAnnouncementList;
	private String requestNumber;
	private USAStaffingRecruitmentResult usasRecruitment;

	private Class<?> cls;
	private Object object;

	@PostConstruct
	public void init(){	
		this.preRecruitmentPositions = new ArrayList<PreRecruitment>();
		this.certificates = new ArrayList<CertificateInformation>();
		this.applicantRatings = new ArrayList<ApplicantRating>();
		this.applicantRatingDates = new ArrayList<ApplicantRatingDates>();
		this.vacancyAnnouncements = new ArrayList<VacancyAnnouncement>();
		this.positions = new PositionsResult();
		this.certificateList = new ArrayList<CertificateResult>();
		this.applicantRatingList = new ArrayList<ApplicantRatingResult>();
		this.vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
		this.requestNumber = "";
		this.usasRecruitment = new USAStaffingRecruitmentResult();
		this.cls = null;
		this.object = new Object();
	}

	/**
	 * This method is used when a Report is pulled from USA Staffing Cognos
	 * and is available as USASResponse object
	 * @param usasResponse
	 * @return transformed XML report as USAStaffingRecruitmentResult object
	 */
	public USAStaffingRecruitmentResult parseReportFromUSASResponse(USASResponse usasResponse){
		if(usasResponse.getResponseCode() != 200){
			return new USAStaffingRecruitmentResult(properties.getResponseCodeConnectionError(), usasResponse.getErrorMessage());
		}
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
		File reportXML = new File(filePath);

		if(reportXML.exists() && reportXML.isFile()){
			this.xml = new StreamSource(reportXML);
			return parseReport();
		}
		return new USAStaffingRecruitmentResult(properties.getResponseCodeFileError(), "The requested file could not be found.");

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
						this.cls = Class.forName(properties.getRecruitmentPackage() + className);
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

					if (this.object instanceof PreRecruitment)
					{
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((PreRecruitment)this.object).getRequestNumber();
						}
						this.preRecruitmentPositions.add((PreRecruitment)this.object);
					}
					if (this.object instanceof CertificateInformation) {
						this.certificates.add((CertificateInformation)this.object);
					}

					if (this.object instanceof ApplicantRating) {
						this.applicantRatings.add((ApplicantRating) this.object);
					}
					if (this.object instanceof ApplicantRatingDates) {
						this.applicantRatingDates.add((ApplicantRatingDates) this.object);	
					}
					if ((this.object instanceof VacancyAnnouncement)) {
						this.vacancyAnnouncements.add((VacancyAnnouncement)this.object);
					}
					if ((this.object == null) || 

							(this.xsr.getEventType() == 4)) {
						this.xsr.next();
					}
				}
			}
			this.positions = this.parser.createPositionsForUSAStaffingRecruitment(this.preRecruitmentPositions);
			this.certificateList = this.parser.createCertificateListForVacancyAnnouncement(this.certificates);
			this.applicantRatingList = this.parser.createApplicantRatingForVacancyAnnouncement(this.applicantRatings, this.applicantRatingDates);
			this.vacancyAnnouncementList = this.parser.createVacancyAnnouncementListForUSAStaffingRecruitment(this.certificateList, this.applicantRatingList, this.vacancyAnnouncements);

			this.usasRecruitment = this.parser.createUSAStaffingRecruitment(this.requestNumber, this.vacancyAnnouncementList, this.positions);
		}
		catch (XMLStreamException e)
		{
			String error = properties.getParseException() + e.getMessage() + "::" + e.getCause();
			log.error(error, e);
			this.usasRecruitment = new USAStaffingRecruitmentResult(properties.getResponseCodeParseError(), error);
		}
		catch (Exception e)
		{
			String error = properties.getParseException() + e.getMessage() + "::" + e.getCause();
			log.error(error, e);
			this.usasRecruitment = new USAStaffingRecruitmentResult(properties.getResponseCodeParseError(), error);
		}
		return this.usasRecruitment;
	}

}
