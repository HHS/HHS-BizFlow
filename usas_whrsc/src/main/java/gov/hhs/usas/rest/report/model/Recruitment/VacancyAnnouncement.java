package gov.hhs.usas.rest.report.model.Recruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_VacancyAnnouncement", propOrder={})
public class VacancyAnnouncement
{
  @XmlElement(name="Request__Number", required=true)
  private String requestNumber;
  @XmlElement(name="Vacancy__Identification__Number")
  private String vacancyIdentificationNumber;
  @XmlElement(name="Number__of__Positions__Advertised")
  private String numberOfPositionsAdvertised;
  @XmlElement(name="Areas__of__Consideration")
  private String areaOfConsideration;
  @XmlElement(name="Interdisciplinary__Position")
  private String interdisciplinaryPosition;
  @XmlElement(name="Vacancy__Announcement__Number")
  private String vacancyAnnouncementNumber;
  @XmlElement(name="Announcement__Type")
  private String announcementType;
  @XmlElement(name="Date__Announcement__Posted")
  private String dateAnnouncementPosted;
  @XmlElement(name="Date__Announcement__Opened")
  private String dateAnnouncementOpened;
  @XmlElement(name="Date__Announcement__Closed")
  private String dateAnnouncementClosed;
  @XmlElement(name="Date__Announcement__Cancelled")
  private String dateAnnouncementCancelled;
  @XmlElement(name="Position__Title")
  private String positionTitle;
  @XmlElement(name="Pay__Plan")
  private String payPlan;
  @XmlElement(name="Series")
  private String series;
  @XmlElement(name="Grade")
  private String grade;
  @XmlElement(name="Full__Performance__Level")
  private String fullPerformanceLevel;
  @XmlElement(name="Duty__Location")
  private String dutyLocation;
  
  public VacancyAnnouncement() {}
  
  public VacancyAnnouncement(String requestNumber, String vacancyIdentificationNumber, String numberOfPositionsAdvertised, String areaOfConsideration, String interdisciplinaryPosition, String vacancyAnnouncementNumber, String announcementType, String dateAnnouncementPosted, String dateAnnouncementOpened, String dateAnnouncementClosed, String dateAnnouncementCancelled, String positionTitle, String payPlan, String series, String grade, String fullPerformanceLevel, String dutyLocation)
  {
    this.requestNumber = requestNumber;
    this.vacancyIdentificationNumber = vacancyIdentificationNumber;
    this.numberOfPositionsAdvertised = numberOfPositionsAdvertised;
    this.areaOfConsideration = areaOfConsideration;
    this.interdisciplinaryPosition = interdisciplinaryPosition;
    this.vacancyAnnouncementNumber = vacancyAnnouncementNumber;
    this.announcementType = announcementType;
    this.dateAnnouncementPosted = dateAnnouncementPosted;
    this.dateAnnouncementOpened = dateAnnouncementOpened;
    this.dateAnnouncementClosed = dateAnnouncementClosed;
    this.dateAnnouncementCancelled = dateAnnouncementCancelled;
    this.positionTitle = positionTitle;
    this.payPlan = payPlan;
    this.series = series;
    this.grade = grade;
    this.fullPerformanceLevel = fullPerformanceLevel;
    this.dutyLocation = dutyLocation;
  }
  
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
  
  public String getNumberOfPositionsAdvertised()
  {
    return this.numberOfPositionsAdvertised;
  }
  
  public void setNumberOfPositionsAdvertised(String numberOfPositionsAdvertised)
  {
    this.numberOfPositionsAdvertised = numberOfPositionsAdvertised;
  }
  
  public String getAreaOfConsideration()
  {
    return this.areaOfConsideration;
  }
  
  public void setAreaOfConsideration(String areaOfConsideration)
  {
    this.areaOfConsideration = areaOfConsideration;
  }
  
  public String getInterdisciplinaryPosition()
  {
    return this.interdisciplinaryPosition;
  }
  
  public void setInterdisciplinaryPosition(String interdisciplinaryPosition)
  {
    this.interdisciplinaryPosition = interdisciplinaryPosition;
  }
  
  public String getVacancyAnnouncementNumber()
  {
    return this.vacancyAnnouncementNumber;
  }
  
  public void setVacancyAnnouncementNumber(String vacancyAnnouncementNumber)
  {
    this.vacancyAnnouncementNumber = vacancyAnnouncementNumber;
  }
  
  public String getAnnouncementType()
  {
    return this.announcementType;
  }
  
  public void setAnnouncementType(String announcementType)
  {
    this.announcementType = announcementType;
  }
  
  public String getDateAnnouncementPosted()
  {
    return this.dateAnnouncementPosted;
  }
  
  public void setDateAnnouncementPosted(String dateAnnouncementPosted)
  {
    this.dateAnnouncementPosted = dateAnnouncementPosted;
  }
  
  public String getDateAnnouncementOpened()
  {
    return this.dateAnnouncementOpened;
  }
  
  public void setDateAnnouncementOpened(String dateAnnouncementOpened)
  {
    this.dateAnnouncementOpened = dateAnnouncementOpened;
  }
  
  public String getDateAnnouncementClosed()
  {
    return this.dateAnnouncementClosed;
  }
  
  public void setDateAnnouncementClosed(String dateAnnouncementClosed)
  {
    this.dateAnnouncementClosed = dateAnnouncementClosed;
  }
  
  public String getDateAnnouncementCancelled()
  {
    return this.dateAnnouncementCancelled;
  }
  
  public void setDateAnnouncementCancelled(String dateAnnouncementCancelled)
  {
    this.dateAnnouncementCancelled = dateAnnouncementCancelled;
  }
  
  public String getPositionTitle()
  {
    return this.positionTitle;
  }
  
  public void setPositionTitle(String positionTitle)
  {
    this.positionTitle = positionTitle;
  }
  
  public String getPayPlan()
  {
    return this.payPlan;
  }
  
  public void setPayPlan(String payPlan)
  {
    this.payPlan = payPlan;
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
  
  public String getFullPerformanceLevel()
  {
    return this.fullPerformanceLevel;
  }
  
  public void setFullPerformanceLevel(String fullPerformanceLevel)
  {
    this.fullPerformanceLevel = fullPerformanceLevel;
  }
  
  public String getDutyLocation()
  {
    return this.dutyLocation;
  }
  
  public void setDutyLocation(String dutyLocation)
  {
    this.dutyLocation = dutyLocation;
  }
}

