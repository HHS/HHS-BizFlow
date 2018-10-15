package gov.hhs.usas.rest.report.model.Recruitment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CertificateResult", propOrder={})
public class CertificateResult
{
  @XmlElement(name="Announcement_Number")
  private String announcementNumber;
  @XmlElement(name="Certificate_Type")
  private String certificateType;
  @XmlElement(name="Certificate_Number")
  private String certificateNumber;
  @XmlElement(name="Position_Title")
  private String positionTitle;
  @XmlTransient
  private List<String> seriesList;
  @XmlElement(name="Series")
  private String series;
  @XmlTransient
  private List<String> gradeList;
  @XmlTransient
  private List<String> dutyLocationList;
  @XmlElement(name="Grade")
  private String grade;
  @XmlElement(name="Duty_Location")
  private String dutyLocation;
  @XmlElement(name="Date_Certificate_Issued")
  private String dateCertificateIssued;
  @XmlElement(name="Date_Certificate_Sent_To_SO")
  private String dateCertificateSentToSO;
  @XmlElement(name="Selection_Made")
  private String selectionMade;
  @XmlElement(name="Action_Taken")
  private String actionTaken;
  @XmlElement(name="Date_Hiring_Decision_Received_In_HR")
  private String dateHiringDecisionRecievedInHR;
  @XmlElement(name="Date_Final_Applicant_Statuses_Set")
  private String dateFinalApplcantStatusesSet;
  @XmlElement(name="Date_Audit_Completed")
  private String dateAuditCompleted;
  
  public CertificateResult()
  {
    this.announcementNumber = "";
    this.certificateType = "";
    this.certificateNumber = "";
    this.positionTitle = "";
    this.seriesList = new ArrayList<String>();
    this.series = "";
    this.gradeList = new ArrayList<String>();
    this.dutyLocationList = new ArrayList<String>();
    this.dateCertificateIssued = "";
    this.dateCertificateSentToSO = "";
    this.selectionMade = "";
    this.actionTaken = "";
    this.dateHiringDecisionRecievedInHR = "";
    this.dateFinalApplcantStatusesSet = "";
    this.dateAuditCompleted = "";
  }
  
  public CertificateResult(String announcementNumber, String certificateType, String certificateNumber, String positionTitle,
		List<String> seriesList, String series, List<String> gradeList, List<String> dutyLocationList, String grade,
		String dutyLocation, String dateCertificateIssued, String dateCertificateSentToSO, String selectionMade,
		String actionTaken, String dateHiringDecisionRecievedInHR, String dateFinalApplcantStatusesSet,
		String dateAuditCompleted) {
	this.announcementNumber = announcementNumber;
	this.certificateType = certificateType;
	this.certificateNumber = certificateNumber;
	this.positionTitle = positionTitle;
	this.seriesList = seriesList;
	this.series = series;
	this.gradeList = gradeList;
	this.dutyLocationList = dutyLocationList;
	this.grade = grade;
	this.dutyLocation = dutyLocation;
	this.dateCertificateIssued = dateCertificateIssued;
	this.dateCertificateSentToSO = dateCertificateSentToSO;
	this.selectionMade = selectionMade;
	this.actionTaken = actionTaken;
	this.dateHiringDecisionRecievedInHR = dateHiringDecisionRecievedInHR;
	this.dateFinalApplcantStatusesSet = dateFinalApplcantStatusesSet;
	this.dateAuditCompleted = dateAuditCompleted;
}



public String getAnnouncementNumber()
  {
    return this.announcementNumber;
  }
  
  public void setAnnouncementNumber(String announcementNumber)
  {
    this.announcementNumber = announcementNumber;
  }
  
  public String getCertificateType()
  {
    return this.certificateType;
  }
  
  public void setCertificateType(String certificateType)
  {
    this.certificateType = certificateType;
  }
  
  public String getCertificateNumber()
  {
    return this.certificateNumber;
  }
  
  public void setCertificateNumber(String certificateNumber)
  {
    this.certificateNumber = certificateNumber;
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
    this.grade = gradesStr.toString();
    return this.grade;
  }
  
  public void setGrades(List<String> grades)
  {
    this.gradeList = grades;
    this.grade = getGrades();
  }
  
  public void addGrade(String grade)
  {
    if ((!this.gradeList.contains(grade)) && (grade.trim().length() > 0)) {
      this.gradeList.add(grade);
    }
    this.grade = getGrades();
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
    this.dutyLocation = dutyLocationStr.toString();
    return this.dutyLocation;
  }
  
  public void setDutyLocation(List<String> dutyLocation)
  {
    this.dutyLocationList = dutyLocation;
    this.dutyLocation = getDutyLocation();
  }
  
  public void addDutyLocation(String dutyLocation)
  {
    if ((!this.dutyLocationList.contains(dutyLocation)) && (dutyLocation.trim().length() > 0)) {
      this.dutyLocationList.add(dutyLocation);
    }
    this.dutyLocation = getDutyLocation();
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
  
  @Override
public String toString()
  {
    return "CertificateResult [announcementNumber: " + getAnnouncementNumber() + "| certificateType: " + getCertificateType() 
    		+ "| certificateNumber: " + getCertificateNumber() + "| positionTitle: " + getPositionTitle() + "| series: " + getSeries() 
    		+ "| gradeList: " + getGrades() + "| dutyLocationList: " + getDutyLocation() + "| dateCertificateIssued: " + getDateCertificateIssued() 
    		+ "| dateCertificateSentToSO: " + getDateCertificateSentToSO() + "| selectionMade: " + getSelectionMade() + "| actionTaken: " + getActionTaken()
    		+ "| dateHiringDecisionRecievedInHR: " + getDateHiringDecisionRecievedInHR() + "| dateFinalApplcantStatusesSet: " + getDateFinalApplcantStatusesSet() 
    		+ "| dateAuditCompleted: " + getDateAuditCompleted() + "]";
  }
}
