package gov.hhs.usas.rest.report.model.Recruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_CertificateInformation", propOrder={})
public class CertificateInformation
{
  @XmlElement(name="Request__Number", required=true)
  private String requestNumber;
  @XmlElement(name="Vacancy__Identification__Number")
  private String vacancyIdentificationNumber;
  @XmlElement(name="Announcement__Number")
  private String announcementNumber;
  @XmlElement(name="Certificate__Number")
  private String certificateNumber;
  @XmlElement(name="Certificate__Type")
  private String certificateType;
  @XmlElement(name="Position__Title")
  private String positionTitle;
  @XmlElement(name="Series")
  private String series;
  @XmlElement(name="Grade")
  private String grade;
  @XmlElement(name="Duty__Location")
  private String dutyLocation;
  @XmlElement(name="Date__Certificate__Issued")
  private String dateCertificateIssued;
  @XmlElement(name="Date__Certificate__Sent__to__SO")
  private String dateCertificateSentToSO;
  @XmlElement(name="Selections__Made")
  private String selectionMade;
  @XmlElement(name="Action__Taken")
  private String actionTaken;
  @XmlElement(name="Date__Hiring__Decision__Rec_x0027d__in__HR")
  private String dateHiringDecisionRecievedInHR;
  @XmlElement(name="Date__Final__Applicant__Statuses__Set")
  private String dateFinalApplcantStatusesSet;
  @XmlElement(name="Date__Audit__Completed")
  private String dateAuditCompleted;
  
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
  
  public String getCertificateNumber()
  {
    return this.certificateNumber;
  }
  
  public void setCertificateNumber(String certificateNumber)
  {
    this.certificateNumber = certificateNumber;
  }
  
  public String getCertificateType()
  {
    return this.certificateType;
  }
  
  public void setCertificateType(String certificateType)
  {
    this.certificateType = certificateType;
  }
  
  public String getPositionTitle()
  {
    return this.positionTitle;
  }
  
  public void setPositionTitle(String positionTitle)
  {
    this.positionTitle = positionTitle;
  }
  
  public String getSeries()
  {
    return this.series;
  }
  
  public void setSeries(String series)
  {
    this.series = series;
  }
  
  public String getGrade()
  {
    return this.grade;
  }
  
  public void setGrade(String grade)
  {
    this.grade = grade;
  }
  
  public String getDutyLocation()
  {
    return this.dutyLocation;
  }
  
  public void setDutyLocation(String dutyLocation)
  {
    this.dutyLocation = dutyLocation;
  }
  
  public String getDateCertificateIssued()
  {
    return this.dateCertificateIssued;
  }
  
  public void setDateCertificateIssued(String dateCertificateIssued)
  {
    this.dateCertificateIssued = dateCertificateIssued;
  }
  
  public String getDateCertificateSentToSO()
  {
    return this.dateCertificateSentToSO;
  }
  
  public void setDateCertificateSentToSO(String dateCertificateSentToSO)
  {
    this.dateCertificateSentToSO = dateCertificateSentToSO;
  }
  
  public String getSelectionMade()
  {
    return this.selectionMade;
  }
  
  public void setSelectionMade(String selectionMade)
  {
    this.selectionMade = selectionMade;
  }
  
  public String getActionTaken()
  {
    return this.actionTaken;
  }
  
  public void setActionTaken(String actionTaken)
  {
    this.actionTaken = actionTaken;
  }
  
  public String getDateHiringDecisionRecievedInHR()
  {
    return this.dateHiringDecisionRecievedInHR;
  }
  
  public void setDateHiringDecisionRecievedInHR(String dateHiringDecisionRecievedInHR)
  {
    this.dateHiringDecisionRecievedInHR = dateHiringDecisionRecievedInHR;
  }
  
  public String getDateFinalApplcantStatusesSet()
  {
    return this.dateFinalApplcantStatusesSet;
  }
  
  public void setDateFinalApplcantStatusesSet(String dateFinalApplcantStatusesSet)
  {
    this.dateFinalApplcantStatusesSet = dateFinalApplcantStatusesSet;
  }
  
  public String getDateAuditCompleted()
  {
    return this.dateAuditCompleted;
  }
  
  public void setDateAuditCompleted(String dateAuditCompleted)
  {
    this.dateAuditCompleted = dateAuditCompleted;
  }
}

