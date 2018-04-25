package gov.hhs.usas.rest.report.model.Appointment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_PayPlan", propOrder={})
public class PayPlan {
	
	@XmlElement(name = "Request__Number", required = true)
    private String requestNumber;
    @XmlElement(name = "Vacancy__Identification__Number")
    private String vacancyIdentificationNumber;
    @XmlElement(name = "Announcement__Number")
    private String announcementNumber;
    @XmlElement(name = "Pay__Plan")
    private String payPlan;
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
	public String getPayPlan() {
		return payPlan;
	}
	public void setPayPlan(String payPlan) {
		this.payPlan = payPlan;
	}
	

}
