package gov.hhs.usas.rest.report.model.CdcRecruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ApplicantsResult", propOrder={})
public class ApplicantsResult {

	@XmlElement(name="Applicant_Name")
	private String applicantName;
	@XmlElement(name="Applicant_First_Name")
	private String applicantFirstName;
	@XmlElement(name="Applicant_Middle_Name")
	private String applicantMiddleName;
	@XmlElement(name="Applicant_Last_Name")
	private String applicantLastName;
	@XmlElement(name="Audit_Code")
	private String auditCode;
	@XmlElement(name="Selectee_Request_Number")
	private String selecteeRequestNumber;
	
	public ApplicantsResult() {
		this.applicantName = "";
		this.applicantFirstName = "";
		this.applicantMiddleName = "";
		this.applicantLastName = "";
		this.auditCode = "";
		this.selecteeRequestNumber = "";
	}

	public ApplicantsResult(String applicantName, String applicantFirstName, String applicantMiddleName,
			String applicantLastName, String auditCode, String selecteeRequestNumber) {
		this.applicantName = applicantName;
		this.applicantFirstName = applicantFirstName;
		this.applicantMiddleName = applicantMiddleName;
		this.applicantLastName = applicantLastName;
		this.auditCode = auditCode;
		this.selecteeRequestNumber = selecteeRequestNumber;
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

	@Override
	public String toString() {
		return "ApplicantsResult [applicantName=" + applicantName + ", applicantFirstName=" + applicantFirstName
				+ ", applicantMiddleName=" + applicantMiddleName + ", applicantLastName=" + applicantLastName
				+ ", auditCode=" + auditCode + ", selecteeRequestNumber=" + selecteeRequestNumber + "]";
	}
	
}
