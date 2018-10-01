package gov.hhs.usas.rest.report.model.CdcRecruitment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class VacancyResult {

	@XmlAttribute(name="VacancyCertificateCount")
	private int vacancyCertificateCount;
	@XmlElement(name="VacancyInfo")
	private VacancyInfoResult vacancyInfo;
	@XmlElementWrapper(name="CertificateInfo")
	@XmlElement(name="record")
	private List<CertificateInfoResult> certificateList;
	@XmlElementWrapper(name="ApplicantInfo")
	@XmlElement(name="record")
	private List<ApplicantInfoResult> applicantList;	
	//@XmlElement(name="Applicants")
	//private ApplicantResult applicants;
	
	public VacancyResult() {
	    this.vacancyCertificateCount = 0;
	    this.vacancyInfo = new VacancyInfoResult();
	    this.certificateList = new ArrayList<CertificateInfoResult>();
	    this.applicantList = new ArrayList<ApplicantInfoResult>();
	}

	public VacancyResult(int vacancyPositionCount, int vacancyCertificateCount, VacancyInfoResult vacancyInfo,
			List<CertificateInfoResult> certificateList, List<ApplicantInfoResult> applicantList) {
		this.vacancyCertificateCount = vacancyCertificateCount;
		this.vacancyInfo = vacancyInfo;
		this.certificateList = certificateList;
		this.applicantList = applicantList;
	}

	public int getVacancyCertificateCount() {
		return vacancyCertificateCount;
	}

	public void setVacancyCertificateCount(int vacancyCertificateCount) {
		this.vacancyCertificateCount = vacancyCertificateCount;
	}

	public VacancyInfoResult getVacancyInfo() {
		return vacancyInfo;
	}

	public void setVacancyInfo(VacancyInfoResult vacancyInfo) {
		this.vacancyInfo = vacancyInfo;
	}

	public List<CertificateInfoResult> getCertificateList() {
		return certificateList;
	}

	public void setCertificateList(List<CertificateInfoResult> certificate) {
		this.certificateList = certificate;
		this.setVacancyCertificateCount(this.certificateList.size());
	}

	public void addCertificate(CertificateInfoResult newCertificate) {
		if(!this.certificateList.contains(newCertificate)) {
			this.certificateList.add(newCertificate);
			this.vacancyCertificateCount += 1;
		}
	}
	
	public List<ApplicantInfoResult> getApplicants() {
		return applicantList;
	}

	public void setApplicants(List<ApplicantInfoResult> applicantList) {
		this.applicantList = applicantList;
	}
	
	public void addApplicantInfo(ApplicantInfoResult newApplicantInfo) {
		if(!this.applicantList.contains(newApplicantInfo)) {
			this.applicantList.add(newApplicantInfo);
		}
	}

	@Override
	public String toString() {
		return "VacancyResult [vacancyCertificateCount="+ vacancyCertificateCount + ", vacancyInfo=" + vacancyInfo + ", certificateList=" + certificateList
				+ ", applicants=" + applicantList + "]";
	}	
	
}
