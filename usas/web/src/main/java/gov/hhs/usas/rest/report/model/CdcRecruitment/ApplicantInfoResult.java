package gov.hhs.usas.rest.report.model.CdcRecruitment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicantInfoResult {

	@XmlElement(name="Vacancy_Number")
	private String vacancyNumber;
	@XmlElement(name="Announcement_Number")
	private String announcementNumber;
	@XmlElement(name="Certificate_Number")
	private String certificateNumber;	
	@XmlElementWrapper(name="Applicants")
	@XmlElement(name="record")
	private List<ApplicantsResult> applicantList;

	public ApplicantInfoResult() {
	    this.vacancyNumber = "";
	    this.announcementNumber = "";
	    this.certificateNumber = "";
	    this.applicantList = new ArrayList<ApplicantsResult>();
	    
	}

	public ApplicantInfoResult(String vacancyNumber, String announcementNumber,
			String certificateNumber, List<ApplicantsResult> applicantList) {
		this.vacancyNumber = vacancyNumber;
		this.announcementNumber = announcementNumber;
		this.certificateNumber = certificateNumber;
		this.applicantList = applicantList;
	}

	public String getVacancyNumber() {
		return vacancyNumber;
	}

	public void setVacancyNumber(String vacancyNumber) {
		this.vacancyNumber = vacancyNumber;
	}

	public String getAnnouncementNumber() {
		return announcementNumber;
	}

	public void setAnnouncementNumber(String announcementNumber) {
		this.announcementNumber = announcementNumber;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public List<ApplicantsResult> getApplicantList() {
		return applicantList;
	}

	public void setApplicantList(List<ApplicantsResult> applicantList) {
		this.applicantList = applicantList;
	}
	
	public void addApplicant(ApplicantsResult newApplicant) {
		if(!this.applicantList.contains(newApplicant)) {
			this.applicantList.add(newApplicant);
		}
	}

	@Override
	public String toString() {
		return "ApplicantInfoResult [vacancyIdentificationNumber=" + vacancyNumber
				+ ", announcementNumber=" + announcementNumber + ", certificateNumber="
				+ certificateNumber + ", applicantList=" + applicantList + "]";
	}
	
}
