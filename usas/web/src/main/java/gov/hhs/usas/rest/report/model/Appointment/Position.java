package gov.hhs.usas.rest.report.model.Appointment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_Position", propOrder={})
public class Position {
	
	@XmlElement(name = "Request__Number", required = true)
    private String requestNumber;
    @XmlElement(name = "Vacancy__Identification__Number")
    private String vacancyIdentificationNumber;
    @XmlElement(name = "Position__Title")
    private String positionTitle;
    @XmlElement(name = "Pay__Plan")
    private String payPlan;
    @XmlElement(name = "Grade")
    private String grade;
    @XmlElement(name = "Series")
    private String series;
    @XmlElement(name = "Full__Performance__Level")
    private String fullPerformanceLevel;
    @XmlElement(name = "Duty__Station")
    private String dutyStation;
    @XmlElement(name = "Duty__Station__Code")
    private String dutyStationCode;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getFullPerformanceLevel() {
		return fullPerformanceLevel;
	}
	public void setFullPerformanceLevel(String fullPerformanceLevel) {
		this.fullPerformanceLevel = fullPerformanceLevel;
	}
	public String getDutyStation() {
		return dutyStation;
	}
	public void setDutyStation(String dutyStation) {
		this.dutyStation = dutyStation;
	}
	public String getDutyStationCode() {
		return dutyStationCode;
	}
	public void setDutyStationCode(String dutyStationCode) {
		this.dutyStationCode = dutyStationCode;
	}


}
