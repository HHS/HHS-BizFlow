package gov.hhs.usas.rest.report.model.Appointment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import gov.hhs.usas.rest.report.model.Appointment.VacancyAnnouncementResult;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="USAStaffing_Appointment")
public class USAStaffingAppointmentResult {

	@XmlAttribute(name="RequestNumber")
	@XmlID
	private String requestNumber;
	@XmlAttribute(name="VacancyCount")
	private int vacancyCount;
	@XmlElementWrapper(name="Vacancies")
	@XmlElement(name="Vacancy_Announcement")
	private List<VacancyAnnouncementResult> vacancyAnnouncementList;
	
	public USAStaffingAppointmentResult() {
		this.requestNumber = "";
		this.vacancyCount = 0;
		this.vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
	}
	
	public USAStaffingAppointmentResult(String requestNumber, int vacancyCount,
			List<VacancyAnnouncementResult> vacancyAnnouncementList) {
		this.requestNumber = requestNumber;
		this.vacancyCount = vacancyCount;
		this.vacancyAnnouncementList = vacancyAnnouncementList;
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
	
	@Override
	public String toString(){
		return "requestNumber: " + this.getRequestNumber() + " vacancyCount: " + this.getVacancyCount()
		+ " vacancyAnnouncementList: " + this.getVacancyAnnouncementList();
	}
	
	
}
