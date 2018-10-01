package gov.hhs.usas.rest.report.model.CdcRecruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_ApplicantTotal", propOrder={})
public class ApplicantTotal {

	@XmlElement(name="Request__Number", required=true)
	private String requestNumber;
	@XmlElement(name="Vacancy__Number")
	private String vacancyNumber;
	@XmlElement(name="Announcement__Number")
	private String announcementNumber;	
	@XmlElement(name="Vacancy__Total__Applicants")
	private String vacancyTotalApplicants;
	@XmlElement(name="Vacancy__Total__Eligible__Applicants")
	private String vacancyTotalEligibleApplicants;
	@XmlElement(name="Vacancy__Total__Referred__Applicants")
	private String vacancyTotalReferredApplicants;
	
	public String getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
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

}
