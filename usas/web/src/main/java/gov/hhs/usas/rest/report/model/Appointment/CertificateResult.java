package gov.hhs.usas.rest.report.model.Appointment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CertificateResult", propOrder={})
public class CertificateResult {
	
	@XmlElement(name="Certificate_Number")
	private String certificateNumber;
	@XmlElement(name="Certificate_Type")
	private String certificateType;
	@XmlElement(name="Position_Title")
	private String positionTitle;
	@XmlElement(name="Pay_Plan")
	private String payPlan;
	@XmlElement(name="Series")
	private String series;
	@XmlElement(name="Grade")
	private String grade;
	@XmlElement(name="Full_Performance_Level")
	private String fullPerformanceLevel;
	@XmlElementWrapper(name="Duty_Stations")
//	@XmlElement(name="Duty_Station")
	@XmlElement(name="record")
	private List<DutyStationResult> dutyStationList;
	@XmlElement(name="Date_Certificate_Sent_To_SO")
	private String dateCertificateSentToSO;
	@XmlElement(name="Date_Hiring_Decision_Received_In_HR")
	private String dateHiringDecisionReceivedInHR;
	@XmlElement(name="Date_Of_Tentative_Job_Offer")
	private String dateOfTentativeJobOffer;
	@XmlElement(name="Date_Of_Official_Job_Offer")
	private String dateOfOfficialJobOffer;
	@XmlElement(name="Appointees_Email_Address_For_Orientation_Contact")
	private String appointeesEmailAddressForOrientationContact;
	@XmlElement(name="Date_Official_Offer_Sent")
	private String dateOfficialOfferSent;
	
	public CertificateResult() {
		this.certificateNumber = "";
		this.certificateType = "";
		this.positionTitle = "";
		this.payPlan = "";
		this.series = "";
		this.grade = "";
		this.fullPerformanceLevel = "";
		this.dutyStationList = new ArrayList<DutyStationResult>();
		this.dateCertificateSentToSO = "";
		this.dateHiringDecisionReceivedInHR = "";
		this.dateOfTentativeJobOffer = "";
		this.dateOfOfficialJobOffer = "";
		this.appointeesEmailAddressForOrientationContact = "";
		this.dateOfficialOfferSent = "";
	}

	public CertificateResult(String certificateNumber, String certificateType, String positionTitle, String payPlan,
			String series, String grade, String fullPerformanceLevel, List<DutyStationResult> dutyStationList,
			String dateCertificateSentToSO, String dateHiringDecisionReceivedInHR, String dateOfTentativeJobOffer,
			String dateOfOfficialJobOffer, String appointeesEmailAddressForOrientationContact,
			String dateOfficialOfferSent) {
		this.certificateNumber = certificateNumber;
		this.certificateType = certificateType;
		this.positionTitle = positionTitle;
		this.payPlan = payPlan;
		this.series = series;
		this.grade = grade;
		this.fullPerformanceLevel = fullPerformanceLevel;
		this.dutyStationList = dutyStationList;
		this.dateCertificateSentToSO = dateCertificateSentToSO;
		this.dateHiringDecisionReceivedInHR = dateHiringDecisionReceivedInHR;
		this.dateOfTentativeJobOffer = dateOfTentativeJobOffer;
		this.dateOfOfficialJobOffer = dateOfOfficialJobOffer;
		this.appointeesEmailAddressForOrientationContact = appointeesEmailAddressForOrientationContact;
		this.dateOfficialOfferSent = dateOfficialOfferSent;
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

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public String getPayPlan() {
		return payPlan;
	}

	public void setPayPlan(String payPlan) {
		this.payPlan = payPlan;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getFullPerformanceLevel() {
		return fullPerformanceLevel;
	}

	public void setFullPerformanceLevel(String fullPerformanceLevel) {
		this.fullPerformanceLevel = fullPerformanceLevel;
	}

	public List<DutyStationResult> getDutyStationList() {
		return dutyStationList;
	}

	public void setDutyStationList(List<DutyStationResult> dutyStationList) {
		this.dutyStationList = dutyStationList;
	}

	public String getDateCertificateSentToSO() {
		return dateCertificateSentToSO;
	}

	public void setDateCertificateSentToSO(String dateCertificateSentToSO) {
		this.dateCertificateSentToSO = dateCertificateSentToSO;
	}

	public String getDateHiringDecisionReceivedInHR() {
		return dateHiringDecisionReceivedInHR;
	}

	public void setDateHiringDecisionReceivedInHR(String dateHiringDecisionReceivedInHR) {
		this.dateHiringDecisionReceivedInHR = dateHiringDecisionReceivedInHR;
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

	public String getAppointeesEmailAddressForOrientationContact() {
		return appointeesEmailAddressForOrientationContact;
	}

	public void setAppointeesEmailAddressForOrientationContact(String appointeesEmailAddressForOrientationContact) {
		this.appointeesEmailAddressForOrientationContact = appointeesEmailAddressForOrientationContact;
	}

	public String getDateOfficialOfferSent() {
		return dateOfficialOfferSent;
	}

	public void setDateOfficialOfferSent(String dateOfficialOfferSent) {
		this.dateOfficialOfferSent = dateOfficialOfferSent;
	}
	
	@Override
	public String toString(){
		return "CertificateResult [certificateNumber: " + this.getCertificateNumber() + "| certificateType: " + this.getCertificateType() + "| positionTitle: " + this.getPositionTitle()
				+ "| payPlan: " + this.getPayPlan() + "| series: " + this.getSeries() + "| grade: " + this.getGrade() + "| fullPerformanceLevel: " + this.getFullPerformanceLevel()
				+ "| dutyStations: " + this.getDutyStationList()
				+ "| dateCertificateSentToSO: " + this.getDateCertificateSentToSO() + "| dateHiringDecisionReceivedInHR: " + this.getDateHiringDecisionReceivedInHR()
				+ "| dateOfTentativeJobOffer: " + this.getDateOfTentativeJobOffer() + "| dateOfOfficialJobOffer: " + this.getDateOfOfficialJobOffer()
				+ "| appointeesEmailAddressForOrientationContact: " + this.getAppointeesEmailAddressForOrientationContact()
				+ "| dateOfficialOfferSent: " + this.getDateOfficialOfferSent() + "]";
	}
	

}
