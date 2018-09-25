package gov.hhs.usas.rest.report.model.CdcRecruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CertificateInfoResult", propOrder={})
public class CertificateInfoResult {

	@XmlElement(name="Vacancy_Number")
	private String vacancyNumber;
	@XmlElement(name="Announcement_Number")
	private String announcementNumber;
	@XmlElement(name="Certificate_Number")
	private String certificateNumber;
	@XmlElement(name="Certificate_Type")
	private String certificateType;
	@XmlElement(name="Certificate_Audit_Complete")
	private String certificateAuditComplete;
	@XmlElement(name="Date_Certificate_Issued")
	private String dateCertificateIssued;
	@XmlElement(name="Date_Certificate_Sent_To_SO")
	private String dateCertificateSentToSO;
	@XmlElement(name="Date_Certificate_Due")
	private String dateCertificateDue;
	@XmlElement(name="Position_Title")
	private String positionTitle;
	@XmlElement(name="Pay_Plan_Series_Grade")
	private String payPlanSeriesGrade;
	
	public CertificateInfoResult() {
		this.vacancyNumber = "";
		this.announcementNumber= "";
		this.certificateNumber = "";
		this.certificateType = "";
		this.certificateAuditComplete = "";
	    this.dateCertificateIssued = "";
	    this.dateCertificateSentToSO = "";
	    this.dateCertificateDue = "";
	    this.positionTitle = "";
	    this.payPlanSeriesGrade = "";
	}

	public CertificateInfoResult(String vacancyNumber, String announcementNumber,
			String certificateNumber, String certificateType, String certificateAuditComplete,
			String dateCertificateIssued, String dateCertificateSentToSO, String dateCertificateDue,
			String positionTitle, String payPlanSeriesGrade) {
		this.vacancyNumber = vacancyNumber;
		this.announcementNumber = announcementNumber;
		this.certificateNumber = certificateNumber;
		this.certificateType = certificateType;
		this.certificateAuditComplete = certificateAuditComplete;
		this.dateCertificateIssued = dateCertificateIssued;
		this.dateCertificateSentToSO = dateCertificateSentToSO;
		this.dateCertificateDue = dateCertificateDue;
		this.positionTitle = positionTitle;
		this.payPlanSeriesGrade = payPlanSeriesGrade;
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

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateAuditComplete() {
		return certificateAuditComplete;
	}

	public void setCertificateAuditComplete(String certificateAuditComplete) {
		this.certificateAuditComplete = certificateAuditComplete;
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

	public String getDateCertificateDue() {
		return dateCertificateDue;
	}

	public void setDateCertificateDue(String dateCertificateDue) {
		this.dateCertificateDue = dateCertificateDue;
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

	@Override
	public String toString() {
		return "CertificateInfoResult [vacancyIdentificationNumber=" + vacancyNumber
				+ ", vacancyAnnouncementNumber=" + announcementNumber + ", certificateNumber="
				+ certificateNumber + ", certificateType=" + certificateType + ", certificateAuditComplete="
				+ certificateAuditComplete + ", dateCertificateIssued=" + dateCertificateIssued
				+ ", dateCertificateSentToSO=" + dateCertificateSentToSO + ", dateCertificateDue=" + dateCertificateDue
				+ ", positionTitle=" + positionTitle + ", payPlanSeriesGrade=" + payPlanSeriesGrade + "]";
	}
	
}
