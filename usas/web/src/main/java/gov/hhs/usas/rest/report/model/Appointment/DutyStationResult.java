package gov.hhs.usas.rest.report.model.Appointment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DutyStation", propOrder={})
public class DutyStationResult {
	
	@XmlElement(name="Name")
	private String dutyStationName;
	@XmlElement(name="Code")
	private String dutyStationCode;
	
	public DutyStationResult() {
		this.dutyStationName = "";
		this.dutyStationCode = "";
	}
	public DutyStationResult(String dutyStationName, String dutyStationCode) {
		this.dutyStationName = dutyStationName;
		this.dutyStationCode = dutyStationCode;
	}
	public String getDutyStationName() {
		return dutyStationName;
	}
	public void setDutyStationName(String dutyStationName) {
		this.dutyStationName = dutyStationName;
	}
	public String getDutyStationCode() {
		return dutyStationCode;
	}
	public void setDutyStationCode(String dutyStationCode) {
		this.dutyStationCode = dutyStationCode;
	}

}
