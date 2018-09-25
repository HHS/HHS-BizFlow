package gov.hhs.usas.rest.report.model.CdcRecruitment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class VacancyInfoResult {

	@XmlElement(name="Vacancy_Number")
	private String vacancyNumber;
	@XmlElement(name="Announcement_Number")
	private String announcementNumber;
	@XmlElement(name="Announcement_Type")
	private String announcementType;
	@XmlElementWrapper(name="Certificates")
	@XmlElement(name="record")
	private List<CertificateNumberResult> certificateList;
	@XmlElement(name="Vacancy_Status")
	private String vacancyStatus;
	@XmlElement(name="Vacancy_Total_Applicants")
	private String vacancyTotalApplicants;
	@XmlElement(name="Vacancy_Total_Eligible_Applicants")
	private String vacancyTotalEligibleApplicants;
	@XmlElement(name="Vacancy_Total_Referred_Applicants")
	private String vacancyTotalReferredApplicants;
	@XmlElement(name="Date_Applicants_Notified_Of_Referred_Status")
	private String dateApplicantsNotifiedOfReferredStatus;
	
	  public VacancyInfoResult()
	  {
	    this.vacancyNumber = "";
	    this.announcementNumber = "";
	    this.announcementType = "";
	    this.certificateList = new ArrayList<CertificateNumberResult>();
	    this.vacancyStatus = "";
	    this.vacancyTotalApplicants = "";
	    this.vacancyTotalEligibleApplicants = "";
	    this.vacancyTotalReferredApplicants = "";
	    this.dateApplicantsNotifiedOfReferredStatus = "";
	  }

	public VacancyInfoResult(String vacancyNumber, String announcementNumber,
			String announcementType, List<CertificateNumberResult> certificateList, String vacancyStatus,
			String vacancyTotalApplicants, String vacancyTotalEligibleApplicants, String vacancyTotalReferredApplicants,
			String dateApplicantsNotifiedOfReferredStatus) {
		this.vacancyNumber = vacancyNumber;
		this.announcementNumber = announcementNumber;
		this.announcementType = announcementType;
		this.certificateList = certificateList;
		this.vacancyStatus = vacancyStatus;
		this.vacancyTotalApplicants = vacancyTotalApplicants;
		this.vacancyTotalEligibleApplicants = vacancyTotalEligibleApplicants;
		this.vacancyTotalReferredApplicants = vacancyTotalReferredApplicants;
		this.dateApplicantsNotifiedOfReferredStatus = dateApplicantsNotifiedOfReferredStatus;
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

	public String getAnnouncementType() {
		return announcementType;
	}

	public void setAnnouncementType(String announcementType) {
		this.announcementType = announcementType;
	}

	public List<CertificateNumberResult> getCertificateList() {
		return certificateList;
	}

	public void setCertificateList(List<CertificateNumberResult> certificateList) {
		this.certificateList = certificateList;
	}

	public void addCertificate(CertificateNumberResult newCertificate) {
		if(!this.certificateList.contains(newCertificate)) {
			this.certificateList.add(newCertificate);
		}
	}

	public String getVacancyStatus() {
		return vacancyStatus;
	}

	public void setVacancyStatus(String vacancyStatus) {
		this.vacancyStatus = vacancyStatus;
	}

	public String getVacancyTotalApplicants() {
		return vacancyTotalApplicants;
	}

	public void setVacancyTotalApplicants(String vacancyTotalApplicants) {
		this.vacancyTotalApplicants = vacancyTotalApplicants;
	}

	public String getVacancyTotalEligibleApplicants() {
		return vacancyTotalEligibleApplicants;
	}

	public void setVacancyTotalEligibleApplicants(String vacancyTotalEligibleApplicants) {
		this.vacancyTotalEligibleApplicants = vacancyTotalEligibleApplicants;
	}

	public String getVacancyTotalReferredApplicants() {
		return vacancyTotalReferredApplicants;
	}

	public void setVacancyTotalReferredApplicants(String vacancyTotalReferredApplicants) {
		this.vacancyTotalReferredApplicants = vacancyTotalReferredApplicants;
	}

	public String getDateApplicantsNotifiedOfReferredStatus() {
		return dateApplicantsNotifiedOfReferredStatus;
	}

	public void setDateApplicantsNotifiedOfReferredStatus(String dateApplicantsNotifiedOfReferredStatus) {
		this.dateApplicantsNotifiedOfReferredStatus = dateApplicantsNotifiedOfReferredStatus;
	}

	@Override
	public String toString() {
		return "VacancyInfoResult [vacancyIdentificationNumber=" + vacancyNumber
				+ ", vacancyAnnouncementNumber=" + announcementNumber + ", announcementType=" + announcementType
				+ ", certificateList=" + certificateList + ", vacancyStatus=" + vacancyStatus
				+ ", vacancyTotalApplicants=" + vacancyTotalApplicants + ", vacancyTotalEligibleApplicants="
				+ vacancyTotalEligibleApplicants + ", vacancyTotalReferredApplicants=" + vacancyTotalReferredApplicants
				+ ", dateApplicantsNotifiedOfReferredStatus=" + dateApplicantsNotifiedOfReferredStatus + "]";
	}
		
}
