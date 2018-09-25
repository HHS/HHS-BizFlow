package gov.hhs.usas.rest.report.model.CdcRecruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_Applicants", propOrder={})
public class Applicants {
	
	@XmlElement(name="Request__Number", required=true)
	private String requestNumber;
	@XmlElement(name="Vacancy__Number")
	private String vacancyNumber;
	@XmlElement(name="Announcement__Number")
	private String announcementNumber;
	@XmlElement(name="Certificate__Number")
	private String certificateNumber;	
	@XmlElement(name="Applicant__Name")
	private String applicantName;
	@XmlElement(name="Applicant__First__Name")
	private String applicantFirstName;
	@XmlElement(name="Applicant__Middle__Name")
	private String applicantMiddleName;
	@XmlElement(name="Applicant__Last__Name")
	private String applicantLastName;
	@XmlElement(name="Audit__Code")
	private String auditCode;
	@XmlElement(name="Selectee__Request__Number")
	private String selecteeRequestNumber;
	
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
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantFirstName() {
		return applicantFirstName;
	}
	public void setApplicantFirstName(String applicantFirstName) {
		this.applicantFirstName = applicantFirstName;
	}
	public String getApplicantMiddleName() {
		return applicantMiddleName;
	}
	public void setApplicantMiddleName(String applicantMiddleName) {
		this.applicantMiddleName = applicantMiddleName;
	}
	public String getApplicantLastName() {
		return applicantLastName;
	}
	public void setApplicantLastName(String applicantLastName) {
		this.applicantLastName = applicantLastName;
	}
	public String getAuditCode() {
		return auditCode;
	}
	public void setAuditCode(String auditCode) {
		this.auditCode = auditCode;
	}
	public String getSelecteeRequestNumber() {
		return selecteeRequestNumber;
	}
	public void setSelecteeRequestNumber(String selecteeRequestNumber) {
		this.selecteeRequestNumber = selecteeRequestNumber;
	}

}
