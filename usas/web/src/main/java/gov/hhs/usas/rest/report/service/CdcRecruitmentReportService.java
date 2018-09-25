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
import gov.hhs.usas.rest.report.model.CdcRecruitment.ApplicantDates;
import gov.hhs.usas.rest.report.model.CdcRecruitment.ApplicantInfoResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.ApplicantTotal;
import gov.hhs.usas.rest.report.model.CdcRecruitment.Applicants;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CdcRecruitmentResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CertificateInfo;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CertificateInfoResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.VacancyInfoResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.VacancyResult;
import gov.hhs.usas.rest.report.model.Recruitment.USAStaffingRecruitmentResult;

@Component
public class CdcRecruitmentReportService {

	private static final Logger log = LoggerFactory.getLogger(CdcRecruitmentReportService.class);
	@Autowired
	private Properties properties;
	@Autowired
	private CdcRecruitmentReportParser parser;
	private XMLInputFactory xif;
	private StreamSource xml;
	private XMLStreamReader xsr;

	private List<CertificateInfo> certificateInfo;
	private List<ApplicantTotal> applicantTotal;
	private List<ApplicantDates> applicantDates;
	private List<Applicants> applicants;

	private List<VacancyInfoResult> vacancyInfoList;
	private Map<String, ArrayList<CertificateInfoResult>> certificateMap;
	private Map<String, ArrayList<ApplicantInfoResult>> applicantInfoMap;
	private List<VacancyResult> vacancyList;
	private String requestNumber;
	private CdcRecruitmentResult cdcRecruitment;

	private Class<?> cls;
	private Object object;
	private String cdcRecruitmentPackage;

	@PostConstruct
	public void init(){	
		this.certificateInfo = new ArrayList<CertificateInfo>();
		this.applicantTotal = new ArrayList<ApplicantTotal>();
		this.applicantDates = new ArrayList<ApplicantDates>();
		this.applicants = new ArrayList<Applicants>();

		this.vacancyInfoList = new ArrayList<VacancyInfoResult>();
		this.certificateMap = new HashMap<String, ArrayList<CertificateInfoResult>>();
		this.applicantInfoMap = new HashMap<String, ArrayList<ApplicantInfoResult>>();
		this.vacancyList = new ArrayList<VacancyResult>();
		this.requestNumber = "";
		this.cdcRecruitment = new CdcRecruitmentResult();
		this.cls = null;
		this.object = new Object();
		this.cdcRecruitmentPackage = "gov.hhs.usas.rest.report.model.CdcRecruitment.";
	}

	/**
	 * This method is used when a Report is pulled from USA Staffing Cognos
	 * and is available as USASResponse object
	 * @param usasResponse
	 * @return transformed XML report as CdcRecruitmentResult object
	 */
	public CdcRecruitmentResult parseReportFromUSASResponse(USASResponse usasResponse, String originRequestNumber){
		if(usasResponse.getResponseCode() != properties.getHttpStatusOk()){
			if(usasResponse.getResponseCode() == properties.getHttpSuccessNoContent()){
				return new CdcRecruitmentResult(originRequestNumber,properties.getResponseCodeNoDataError(), usasResponse.getErrorMessage());
			}
			return new CdcRecruitmentResult(originRequestNumber,properties.getResponseCodeConnectionError(), usasResponse.getErrorMessage());
		}
		String searchRequestNumber = "<Request__Number>" + originRequestNumber +"</Request__Number>";
		if(usasResponse.getResponse().toString().contains(searchRequestNumber)){
			this.requestNumber = originRequestNumber;
		this.xml = new StreamSource(new StringReader(usasResponse.getResponse()));
		return parseReport();
		}else{
			//Suggest end user to try again		
			return new CdcRecruitmentResult(originRequestNumber,properties.getResponseCodeReportError(), properties.getReportDataException());
		}
	}

	/**
	 * This method is used when a USA Staffing Report is pre-downloaded
	 * and save at a specific location
	 * @param filePath - absolute path of report XML
	 * @return transformed XML report as CdcRecruitmentResult object
	 */
	public CdcRecruitmentResult parseReportFromFile(String filePath){
		File reportXML = new File(filePath);

		if(reportXML.exists() && reportXML.isFile()){
			this.xml = new StreamSource(reportXML);
			return parseReport();
		}
		return new CdcRecruitmentResult(properties.getResponseCodeFileError(), properties.getNoFileException());

	}


	/**
	 * This method partially reads the XML report and unmarshalls 
	 * the block to respective POJO. When entire XML is read, it uses 
	 * the list of POJOs to transform the XMl to BizFlow consumable format.
	 * @return
	 */
	public CdcRecruitmentResult parseReport()
	{
		init();
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
						this.cls = Class.forName(this.getCdcRecruitmentPackage() + className);
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

					if (this.object instanceof CertificateInfo) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((CertificateInfo)this.object).getRequestNumber();
						}
						this.certificateInfo.add((CertificateInfo)this.object);
					}

					if (this.object instanceof ApplicantTotal) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((ApplicantTotal)this.object).getRequestNumber();
						}
						this.applicantTotal.add((ApplicantTotal) this.object);
					}
					if (this.object instanceof ApplicantDates) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((ApplicantDates)this.object).getRequestNumber();
						}
						this.applicantDates.add((ApplicantDates) this.object);	
					}
					if (this.object instanceof Applicants) {
						if (this.requestNumber.length() <= 0) {
							this.requestNumber = ((Applicants)this.object).getRequestNumber();
						}
						this.applicants.add((Applicants)this.object);
					}
					if ((this.object == null) || 

							(this.xsr.getEventType() == 4)) {
						this.xsr.next();
					}
				}
			}
			this.vacancyInfoList = this.parser.generateVacancyInfo(this.certificateInfo, this.applicantTotal, this.applicantDates);
			this.certificateMap = this.parser.generateCertificateInfo(this.certificateInfo);
			this.applicantInfoMap= this.parser.generateApplicantInfo(this.applicants);
			this.vacancyList = this.parser.generateVacancy(this.vacancyInfoList, this.certificateMap, this.applicantInfoMap);

			this.cdcRecruitment = this.parser.generateCdcRecruitment(this.requestNumber, this.vacancyList);
			
			//If there is no data for vacancy, add an error message
			if(this.cdcRecruitment.getVacancyCount() == 0){
				this.cdcRecruitment.setResultCode(properties.getResponseCodeNoDataError());
				this.cdcRecruitment.setFailureMessage(properties.getNoDataException());
			}
		}
		catch (XMLStreamException e)
		{
			String error = properties.getParseException() + e.getMessage() + "::" + e.getCause();
			log.error(error, e);
			this.cdcRecruitment = new CdcRecruitmentResult(properties.getResponseCodeParseError(), error);
		}
		catch (Exception e)
		{
			String error = properties.getParseException() + e.getMessage() + "::" + e.getCause();
			log.error(error, e);
			this.cdcRecruitment = new CdcRecruitmentResult(properties.getResponseCodeParseError(), error);
		}
		return this.cdcRecruitment;
	}

	public String getCdcRecruitmentPackage() {
		return cdcRecruitmentPackage;
	}
}
