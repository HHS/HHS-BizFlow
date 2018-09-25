package gov.hhs.usas.rest.report.model.CdcRecruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_CertificateInfo", propOrder={})
public class CertificateInfo {

	@XmlElement(name="Request__Number", required=true)
	private String requestNumber;
	@XmlElement(name="Vacancy__Number")
	private String vacancyNumber;
	@XmlElement(name="Announcement__Number")
	private String announcementNumber;
	@XmlElement(name="Announcement__Type")
	private String announcementType;	
	@XmlElement(name="Certificate__Number")
	private String certificateNumber;
	@XmlElement(name="Vacancy__Status")
	private String vacancyStatus;
	@XmlElement(name="Certificate__Type")
	private String certificateType;
	@XmlElement(name="Position__Title")
	private String positionTitle;
	@XmlElement(name="Pay__Plan_x002dSeries_x002dGrade")
	private String payPlanSeriesGrade;
	@XmlElement(name="Date__Certificate__Issued")
	private String dateCertificateIssued;
	@XmlElement(name="Date__Certificate__Sent__to__SO")
	private String dateCertificateSentToSO;
	@XmlElement(name="Certificate__Audit__Complete__Date")
	private String certificateAuditCompleteDate;
	@XmlElement(name="Date__Certificate__Due")
	private String dateCertificateDue;
	
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
	public String getAnnouncementType() {
		return announcementType;
	}
	public void setAnnouncementType(String announcementType) {
		this.announcementType = announcementType;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getVacancyStatus() {
		return vacancyStatus;
	}
	public void setVacancyStatus(String vacancyStatus) {
		this.vacancyStatus = vacancyStatus;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getPositionTitle() {
		return positionTitle;
	}
	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}
	public String getPayPlanSeriesGrade() {
		return payPlanSeriesGrade;
	}
	public void setPayPlanSeriesGrade(String payPlanSeriesGrade) {
		this.payPlanSeriesGrade = payPlanSeriesGrade;
	}
	public String getDateCertificateIssued() {
		return dateCertificateIssued;
	}
	public void setDateCertificateIssued(String dateCertificateIssued) {
		this.dateCertificateIssued = dateCertificateIssued;
	}
	public String getDateCertificateSentToSO() {
		return dateCertificateSentToSO;
	}
	public void setDateCertificateSentToSO(String dateCertificateSentToSO) {
		this.dateCertificateSentToSO = dateCertificateSentToSO;
	}
	public String getCertificateAuditCompleteDate() {
		return certificateAuditCompleteDate;
	}
	public void setCertificateAuditCompleteDate(String certificateAuditCompleteDate) {
		this.certificateAuditCompleteDate = certificateAuditCompleteDate;
	}
	public String getDateCertificateDue() {
		return dateCertificateDue;
	}
	public void setDateCertificateDue(String dateCertificateDue) {
		this.dateCertificateDue = dateCertificateDue;
	}
	
}
