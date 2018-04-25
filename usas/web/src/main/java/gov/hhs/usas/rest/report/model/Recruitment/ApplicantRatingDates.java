package gov.hhs.usas.rest.report.model.Recruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_ApplicantRatingDates", propOrder={})
public class ApplicantRatingDates
{
  @XmlElement(name="Request__Number", required=true)
  private String requestNumber;
  //@XmlElement(name="Vacancy__Identification__Number")
  @XmlElement(name="Vacancy__Number")
  private String vacancyIdentificationNumber;
  @XmlElement(name="Announcement__Number")
  private String announcementNumber;
  @XmlElement(name="Date__Applicants__Notified__of__Qual_x002fElig__Status")
  private String dateApplicantsNotifiedEligibilityStatus;
  @XmlElement(name="Date__Applicants__Notified__of__Referral__Status")
  private String dateApplicantsNotifiedReferralStatus;
  
  public String getRequestNumber()
  {
    return this.requestNumber;
  }
  
  public void setRequestNumber(String requestNumber)
  {
    this.requestNumber = requestNumber;
  }
  
  public String getVacancyIdentificationNumber()
  {
    return this.vacancyIdentificationNumber;
  }
  
  public void setVacancyIdentificationNumber(String vacancyIdentificationNumber)
  {
    this.vacancyIdentificationNumber = vacancyIdentificationNumber;
  }
  
  public String getAnnouncementNumber()
  {
    return this.announcementNumber;
  }
  
  public void setAnnouncementNumber(String announcementNumber)
  {
    this.announcementNumber = announcementNumber;
  }
  
  public String getDateApplicantsNotifiedEligibilityStatus()
  {
    return this.dateApplicantsNotifiedEligibilityStatus;
  }
  
  public void setDateApplicantsNotifiedEligibilityStatus(String dateApplicantsNotifiedEligibilityStatus)
  {
    this.dateApplicantsNotifiedEligibilityStatus = dateApplicantsNotifiedEligibilityStatus;
  }
  
  public String getDateApplicantsNotifiedReferralStatus()
  {
    return this.dateApplicantsNotifiedReferralStatus;
  }
  
  public void setDateApplicantsNotifiedReferralStatus(String dateApplicantsNotifiedReferralStatus)
  {
    this.dateApplicantsNotifiedReferralStatus = dateApplicantsNotifiedReferralStatus;
  }
}

