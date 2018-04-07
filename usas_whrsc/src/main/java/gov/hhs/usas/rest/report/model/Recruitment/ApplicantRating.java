package gov.hhs.usas.rest.report.model.Recruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_ApplicantRating", propOrder={})
public class ApplicantRating
{
  @XmlElement(name="Request__Number", required=true)
  private String requestNumber;
  @XmlElement(name="Vacancy__Identification__Number")
  private String vacancyIdentificationNumber;
  @XmlElement(name="Announcement__Number")
  private String announcementNumber;
  @XmlElement(name="Total__Number__of__Applicants")
  private String totalNumberOfApplicants;
  @XmlElement(name="Total__Number__of__Eligible__Applicants")
  private String totalNumberOfEligibleApplicants;
  @XmlElement(name="Total__Number__of__Referred__Applicants")
  private String totalNumberOfUniqueReferredApplicants;
  
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
}

