package gov.hhs.usas.rest.report.model.Appointment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="USAStaffing_Appointment")
public class USAStaffingAppointmentResult {

	@XmlAttribute(name="RequestNumber")
	@XmlID
	private String requestNumber;
	@XmlAttribute(name="VacancyCount")
	private int vacancyCount;
	@XmlElement(name="Vacancy")
	private List<VacancyAnnouncementResult> vacancyAnnouncementList;
	@XmlElement(name="Result_Code")
	private String resultCode;
	@XmlElement(name="Failure_Message")
	private String failureMessage;
	
	public USAStaffingAppointmentResult() {
		this.requestNumber = "";
		this.vacancyCount = 0;
		this.vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
		this.resultCode = "";
		this.failureMessage = "";
	}
	
	public USAStaffingAppointmentResult(String requestNumber, int vacancyCount,
			List<VacancyAnnouncementResult> vacancyAnnouncementList) {
		this.requestNumber = requestNumber;
		this.vacancyCount = vacancyCount;
		this.vacancyAnnouncementList = vacancyAnnouncementList;
		this.resultCode = "Success";
		this.failureMessage = "";
	}
	

	public USAStaffingAppointmentResult(String requestNumber, int vacancyCount,
			List<VacancyAnnouncementResult> vacancyAnnouncementList, String resultCode, String failureMessage) {
		this.requestNumber = requestNumber;
		this.vacancyCount = vacancyCount;
		this.vacancyAnnouncementList = vacancyAnnouncementList;
		this.resultCode = resultCode;
		this.failureMessage = failureMessage;
	}
	
	public USAStaffingAppointmentResult(String resultCode, String failureMessage) {
		this();
		this.resultCode = resultCode;
		this.failureMessage = failureMessage;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public int getVacancyCount() {
		return vacancyCount;
	}

	public void setVacancyCount(int vacancyCount) {
		this.vacancyCount = vacancyCount;
	}

	public List<VacancyAnnouncementResult> getVacancyAnnouncementList() {
		return vacancyAnnouncementList;
	}

	public void setVacancyAnnouncementList(List<VacancyAnnouncementResult> vacancyAnnouncementList) {
		this.vacancyAnnouncementList = vacancyAnnouncementList;
	}
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	@Override
	public String toString(){
		return "requestNumber: " + this.getRequestNumber() + " vacancyCount: " + this.getVacancyCount()
		+ " vacancyAnnouncementList: " + this.getVacancyAnnouncementList();
	}
	
	
}
