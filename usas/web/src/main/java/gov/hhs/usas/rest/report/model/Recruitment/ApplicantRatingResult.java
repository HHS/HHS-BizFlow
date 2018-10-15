package gov.hhs.usas.rest.report.model.Recruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicantRatingResult
{
  @XmlElement(name="Vacancy_Identification_Number")
  private String vacancyIdentificationNumber;
  @XmlElement(name="Announcement_Number")
  private String announcementNumber;
  @XmlElement(name="Total_Number_Of_Applicants")
  private String totalNumberOfApplicants;
  @XmlElement(name="Total_Number_Of_Eligible_Applicants")
  private String totalNumberOfEligibleApplicants;
  @XmlElement(name="Total_Number_Of_Unique_Referred_Applicants")
  private String totalNumberOfUniqueReferredApplicants;
  @XmlElement(name="Date_Applicants_Notified_Eligibility_Status")
  private String dateApplicantsNotifiedEligibilityStatus;
  @XmlElement(name="Date_Applicants_Notified_Referral_Status")
  private String dateApplicantsNotifiedReferralStatus;
  
  public ApplicantRatingResult() {}
  
  public ApplicantRatingResult(String vacancyAnnouncementNumber, String announcementNumber, String totalNumberOfApplicants, String totalNumberOfEligibleApplicants, String totalNumberOfUniqueReferredApplicants, String dateApplicantsNotifiedEligibilityStatus, String dateApplicantsNotifiedReferralStatus)
  {
    this.vacancyIdentificationNumber = vacancyAnnouncementNumber;
    this.announcementNumber = announcementNumber;
    this.totalNumberOfApplicants = totalNumberOfApplicants;
    this.totalNumberOfEligibleApplicants = totalNumberOfEligibleApplicants;
    this.totalNumberOfUniqueReferredApplicants = totalNumberOfUniqueReferredApplicants;
    this.dateApplicantsNotifiedEligibilityStatus = dateApplicantsNotifiedEligibilityStatus;
    this.dateApplicantsNotifiedReferralStatus = dateApplicantsNotifiedReferralStatus;
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
  
  public String getTotalNumberOfApplicants()
  {
    return this.totalNumberOfApplicants;
  }
  
  public void setTotalNumberOfApplicants(String totalNumberOfApplicants)
  {
    this.totalNumberOfApplicants = totalNumberOfApplicants;
  }
  
  public String getTotalNumberOfEligibleApplicants()
  {
    return this.totalNumberOfEligibleApplicants;
  }
  
  public void setTotalNumberOfEligibleApplicants(String totalNumberOfEligibleApplicants)
  {
    this.totalNumberOfEligibleApplicants = totalNumberOfEligibleApplicants;
  }
  
  public String getTotalNumberOfUniqueReferredApplicants()
  {
    return this.totalNumberOfUniqueReferredApplicants;
  }
  
  public void setTotalNumberOfUniqueReferredApplicants(String totalNumberOfUniqueReferredApplicants)
  {
    this.totalNumberOfUniqueReferredApplicants = totalNumberOfUniqueReferredApplicants;
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
  
  @Override
public String toString()
  {
    return "ApplicantRatingResult [announcementNumber: " + getAnnouncementNumber() + "| totalNumberOfApplicants: " + getTotalNumberOfApplicants() 
    		+ "| totalNumberOfEligibleApplicants: " + getTotalNumberOfEligibleApplicants() + "| totalNumberOfUniqueReferredApplicants: " + getTotalNumberOfUniqueReferredApplicants() 
    		+ "|  dateApplicantsNotifiedEligibilityStatus: " + getDateApplicantsNotifiedEligibilityStatus() + "| dateApplicantsNotifiedReferralStatus: " + getDateApplicantsNotifiedReferralStatus() + "]";
  }
}

