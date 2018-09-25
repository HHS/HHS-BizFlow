package gov.hhs.usas.rest.report.model.CdcRecruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_ApplicantDates", propOrder={})
public class ApplicantDates {

	@XmlElement(name="Request__Number", required=true)
	private String requestNumber;
	@XmlElement(name="Vacancy__Number")
	private String vacancyNumber;
	@XmlElement(name="Announcement__Number")
	private String announcementNumber;
	@XmlElement(name="Date__Applicant__Notified__of__Referred__Status")
	private String dateApplicantNotifiedReferredStatus;
	
	
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
	public String getDateApplicantNotifiedReferredStatus() {
		return dateApplicantNotifiedReferredStatus;
	}
	public void setDateApplicantNotifiedReferredStatus(String dateApplicantNotifiedReferredStatus) {
		this.dateApplicantNotifiedReferredStatus = dateApplicantNotifiedReferredStatus;
	}
	
}
