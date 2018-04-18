package gov.hhs.usas.rest.report.model.Recruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="lst_PreRecruitment", propOrder={})
public class PreRecruitment
{
  @XmlElement(name="Request__Number", required=true)
  private String requestNumber;
  @XmlElement(name="Vacancy__Identification__Number")
  private String vacancyIdentificationNumber;
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
  @XmlElement(name="Number__of__Positions__to__be__Advertised")
  private String numberOfPositionsToBeAdvertised;
  @XmlElement(name="Clearance__Level__Required__for__Position")
  private String clearanceLevelRequiredForPosition;
  
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
  
  public String getNumberOfPositionsToBeAdvertised()
  {
    return this.numberOfPositionsToBeAdvertised;
  }
  
  public void setNumberOfPositionsToBeAdvertised(String numberOfPositionsToBeAdvertised)
  {
    this.numberOfPositionsToBeAdvertised = numberOfPositionsToBeAdvertised;
  }
  
  public String getClearanceLevelRequiredForPosition()
  {
    return this.clearanceLevelRequiredForPosition;
  }
  
  public void setClearanceLevelRequiredForPosition(String clearanceLevelRequiredForPosition)
  {
    this.clearanceLevelRequiredForPosition = clearanceLevelRequiredForPosition;
  }
  
  @Override
public String toString()
  {
    return "requestNumber: " + this.requestNumber + " vacancyIdentificationNumber: " + this.vacancyIdentificationNumber + " positionTitle: " + this.positionTitle + " payPlan: " + this.payPlan + " series: " + this.series + " grade: " + this.grade + " fullPerformanceLevel: " + this.fullPerformanceLevel + " dutyLocation: " + this.dutyLocation + " numberOfPositionsToBeAdvertised: " + this.numberOfPositionsToBeAdvertised + " clearanceLevelRequiredForPosition: " + this.clearanceLevelRequiredForPosition;
  }
}

