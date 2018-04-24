package gov.hhs.usas.rest.report.model.Appointment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_Orientation", propOrder={})
public class Orientation {
	
	@XmlElement(name = "Request__Number", required = true)
    private String requestNumber;
    @XmlElement(name = "Vacancy__Identification__Number")
    private String vacancyIdentificationNumber;
    @XmlElement(name = "Appointee_x0027s__Email__Address__for__Orientation__Contact")
    private String appointeesEmailAddressForOrientationContact;
    @XmlElement(name = "Date__Official__Offer__Letter__Sent")
    private String dateOfficialOfferLetterSent;
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
	public String getAppointeesEmailAddressForOrientationContact() {
		return appointeesEmailAddressForOrientationContact;
	}
	public void setAppointeesEmailAddressForOrientationContact(String appointeesEmailAddressForOrientationContact) {
		this.appointeesEmailAddressForOrientationContact = appointeesEmailAddressForOrientationContact;
	}
	public String getDateOfficialOfferLetterSent() {
		return dateOfficialOfferLetterSent;
	}
	public void setDateOfficialOfferLetterSent(String dateOfficialOfferLetterSent) {
		this.dateOfficialOfferLetterSent = dateOfficialOfferLetterSent;
	}

}
