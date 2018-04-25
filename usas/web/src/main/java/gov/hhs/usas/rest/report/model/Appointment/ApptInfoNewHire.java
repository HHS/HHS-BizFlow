package gov.hhs.usas.rest.report.model.Appointment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_ApptInfoNewHire", propOrder={})
public class ApptInfoNewHire {
	
	@XmlElement(name = "Request__Number", required = true)
    private String requestNumber;
    @XmlElement(name = "Vacancy__Identification__Number")
    private String vacancyIdentificationNumber;
    @XmlElement(name = "Job__Code")
    private String jobCode;
    @XmlElement(name = "OF_x002d306__Assigned__in__Onboarding__Manager")
    private String of306AssignedInOnboardingManager;
    @XmlElement(name = "EOD")
    private String eod;
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
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getOf306AssignedInOnboardingManager() {
		return of306AssignedInOnboardingManager;
	}
	public void setOf306AssignedInOnboardingManager(String of306AssignedInOnboardingManager) {
		this.of306AssignedInOnboardingManager = of306AssignedInOnboardingManager;
	}
	public String getEod() {
		return eod;
	}
	public void setEod(String eod) {
		this.eod = eod;
	}

}
