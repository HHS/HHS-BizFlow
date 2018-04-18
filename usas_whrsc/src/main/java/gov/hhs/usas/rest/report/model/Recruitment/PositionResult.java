package gov.hhs.usas.rest.report.model.Recruitment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="PositionResult", propOrder={})
@XmlRootElement(name="PositionResult")
public class PositionResult
{
  @XmlElement(name="Position_Title")
  private String title;
  @XmlTransient
  private List<String> payPlanList;
  @XmlElement(name="Pay_Plan")
  private String payPlan;
  @XmlTransient
  private List<String> seriesList;
  @XmlElement(name="Series")
  private String series;
  @XmlTransient
  private List<String> gradeList;
  @XmlElement(name="Grade")
  private String grades;
  @XmlElement(name="Full_Performance_Level")
  private String fullPerformanceLevel;
  @XmlTransient
  private List<String> dutyLocationList;
  @XmlElement(name="Duty_Location")
  private String dutyLocations;
  
  public PositionResult()
  {
    this.title = "";
    this.payPlanList = new ArrayList<String>();
    this.payPlan = "";
    this.seriesList = new ArrayList<String>();
    this.series = "";
    this.gradeList = new ArrayList<String>();
    this.grades = "";
    this.fullPerformanceLevel = "";
    this.dutyLocationList = new ArrayList<String>();
    this.dutyLocations = "";
  }
  
  
  public PositionResult(String title, List<String> payPlanList, String payPlan, List<String> seriesList, String series,
		List<String> gradeList, String grades, String fullPerformanceLevel, List<String> dutyLocationList,
		String dutyLocations) {
	this.title = title;
	this.payPlanList = payPlanList;
	this.payPlan = payPlan;
	this.seriesList = seriesList;
	this.series = series;
	this.gradeList = gradeList;
	this.grades = grades;
	this.fullPerformanceLevel = fullPerformanceLevel;
	this.dutyLocationList = dutyLocationList;
	this.dutyLocations = dutyLocations;
}



public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getPayPlan()
  {
    StringBuffer payPlanStr = new StringBuffer();
    for (int i = 0; i < this.payPlanList.size(); i++) {
      if (i > 0) {
    	  payPlanStr.append("," + (String)this.payPlanList.get(i));
      } else {
    	  payPlanStr.append((String)this.payPlanList.get(i));
      }
    }
    this.payPlan = payPlanStr.toString();
    return this.payPlan;
  }
  
  public void setPayPlan(List<String> payPlan)
  {
    this.payPlanList = payPlan;
    this.payPlan = getPayPlan();
  }
  
  public void addPayPlan(String payPlan)
  {
    if ((!this.payPlanList.contains(payPlan)) && (payPlan.trim().length() > 0)) {
      this.payPlanList.add(payPlan);
    }
    this.payPlan = getPayPlan();
  }
  
  
  public String getSeries()
 {
   StringBuffer seriesStr = new StringBuffer();
   for (int i = 0; i < this.seriesList.size(); i++) {
     if (i > 0) {
   	  seriesStr.append("," + (String)this.seriesList.get(i));
     } else {
   	  seriesStr.append((String)this.seriesList.get(i));
     }
   }
   this.series = seriesStr.toString();
   return this.series;
 }
 
 public void setSeries(List<String> series)
 {
   this.seriesList = series;
   this.series = getSeries();
 }
 
 public void addSeries(String series)
 {
   if ((!this.seriesList.contains(series)) && (series.trim().length() > 0)) {
     this.seriesList.add(series);
   }
   this.series = getSeries();
 }
  
  public String getGrades()
  {
    StringBuffer gradesStr = new StringBuffer();
    for (int i = 0; i < this.gradeList.size(); i++) {
      if (i > 0) {
        gradesStr.append("," + (String)this.gradeList.get(i));
      } else {
        gradesStr.append((String)this.gradeList.get(i));
      }
    }
    this.grades = gradesStr.toString();
    return this.grades;
  }
  
  public void setGrades(List<String> grades)
  {
    this.gradeList = grades;
    this.grades = getGrades();
  }
  
  public void addGrade(String grade)
  {
    if ((!this.gradeList.contains(grade)) && (grade.trim().length() > 0)) {
      this.gradeList.add(grade);
    }
    this.grades = getGrades();
  }
  
  public String getDutyLocations()
  {
    return this.dutyLocations;
  }
  
  public void setDutyLocations(String dutyLocations)
  {
    this.dutyLocations = dutyLocations;
  }
  
  public void setGrades(String grades)
  {
    this.grades = grades;
  }
  
  public String getFullPerformanceLevel()
  {
    return this.fullPerformanceLevel;
  }
  
  public void setFullPerformanceLevel(String fullPerformanceLevel)
  {
    this.fullPerformanceLevel = fullPerformanceLevel;
  }
  
  public List<String> getDutyLocationList()
  {
    return this.dutyLocationList;
  }
  
  public String getDutyLocation()
  {
    StringBuffer dutyLocationStr = new StringBuffer();
    for (int i = 0; i < this.dutyLocationList.size(); i++) {
      if (i > 0) {
        dutyLocationStr.append(";" + (String)this.dutyLocationList.get(i));
      } else {
        dutyLocationStr.append((String)this.dutyLocationList.get(i));
      }
    }
    this.dutyLocations = dutyLocationStr.toString();
    return this.dutyLocations;
  }
  
  public void setDutyLocation(List<String> dutyLocation)
  {
    this.dutyLocationList = dutyLocation;
    this.dutyLocations = getDutyLocation();
  }
  
  public void addDutyLocation(String dutyLocation)
  {
    if ((!this.dutyLocationList.contains(dutyLocation)) && (dutyLocation.trim().length() > 0)) {
      this.dutyLocationList.add(dutyLocation);
    }
    this.dutyLocations = getDutyLocation();
  }
  
  @Override
public String toString()
  {
    return " positionTitle: " + getTitle() + " payPlan: " + getPayPlan() + " series: " + getSeries() + " grade: " + getGrades() + " fullPerformanceLevel: " + getFullPerformanceLevel() + " dutyLocation: " + getDutyLocation();
  }
}

