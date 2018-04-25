package gov.hhs.usas.rest.report.model.Appointment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_ApptInfoCert", propOrder={})
public class ApptInfoCert {
	
	@XmlElement(name = "Request__Number", required = true)
    private String requestNumber;
    @XmlElement(name = "Vacancy__Identification__Number")
    private String vacancyIdentificationNumber;
    @XmlElement(name = "Announcement__Number")
    private String announcementNumber;
    @XmlElement(name = "Certificate__Number")
    private String certificateNumber;
    @XmlElement(name = "Relationship__to__Recruitment__Action")
    private String relationshipToRecruitmentAction;
    @XmlElement(name = "Certificate__Type")
    private String certificateType;
    @XmlElement(name = "Supervisory__Position")
    private String supervisoryPosition;
    @XmlElement(name = "Date__Cert__Sent__to__Selecting__Official")
    private String dateCertSentToSelectingOfficial;
    @XmlElement(name = "Date__of__Hiring__Decision__in__HR")
    private String dateOfHiringDecisionInHR;
    @XmlElement(name = "Date__of__Tentative__Job__Offer")
    private String dateOfTentativeJobOffer;
    @XmlElement(name = "Date__of__Official__Job__Offer")
    private String dateOfOfficialJobOffer;
    @XmlElement(name = "Clearance__Level__Required__for__Position")
    private String clearanceLevelRequiredForPosition;
    @XmlElement(name = "Type__of__Selection")
    private String typeOfSelection;
	public String getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
	public String getVacancyIdentificationNumber() {
		return vacancyIdentificationNumber;
	}
	public void setVacancyIdentificationNumber(String vacancyIdentificationNumber) {
		this.vacancyIdentificationNumber = vacancyIdentificationNumber;
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
	public String getRelationshipToRecruitmentAction() {
		return relationshipToRecruitmentAction;
	}
	public void setRelationshipToRecruitmentAction(String relationshipToRecruitmentAction) {
		this.relationshipToRecruitmentAction = relationshipToRecruitmentAction;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getSupervisoryPosition() {
		return supervisoryPosition;
	}
	public void setSupervisoryPosition(String supervisoryPosition) {
		this.supervisoryPosition = supervisoryPosition;
	}
	public String getDateCertSentToSelectingOfficial() {
		return dateCertSentToSelectingOfficial;
	}
	public void setDateCertSentToSelectingOfficial(String dateCertSentToSelectingOfficial) {
		this.dateCertSentToSelectingOfficial = dateCertSentToSelectingOfficial;
	}
	public String getDateOfHiringDecisionInHR() {
		return dateOfHiringDecisionInHR;
	}
	public void setDateOfHiringDecisionInHR(String dateOfHiringDecisionInHR) {
		this.dateOfHiringDecisionInHR = dateOfHiringDecisionInHR;
	}
	public String getDateOfTentativeJobOffer() {
		return dateOfTentativeJobOffer;
	}
	public void setDateOfTentativeJobOffer(String dateOfTentativeJobOffer) {
		this.dateOfTentativeJobOffer = dateOfTentativeJobOffer;
	}
	public String getDateOfOfficialJobOffer() {
		return dateOfOfficialJobOffer;
	}
	public void setDateOfOfficialJobOffer(String dateOfOfficialJobOffer) {
		this.dateOfOfficialJobOffer = dateOfOfficialJobOffer;
	}
	public String getClearanceLevelRequiredForPosition() {
		return clearanceLevelRequiredForPosition;
	}
	public void setClearanceLevelRequiredForPosition(String clearanceLevelRequiredForPosition) {
		this.clearanceLevelRequiredForPosition = clearanceLevelRequiredForPosition;
	}
	public String getTypeOfSelection() {
		return typeOfSelection;
	}
	public void setTypeOfSelection(String typeOfSelection) {
		this.typeOfSelection = typeOfSelection;
	}

}
