package gov.hhs.usas.rest.report.model.Recruitment;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class VacancyAnnouncementResult
{
  @XmlAttribute(name="VacancyPositionCount")
  private int vacancyPositionCount;
  @XmlAttribute(name="VacancyCertificateCount")
  private int vacancyCertificateCount;
  @XmlElement(name="Number_Of_Positions_Advertised")
  private String numberOfPositionsAdvertised;
  @XmlTransient
  private List<String> areaOfConsiderationList;
  @XmlElement(name="Area_Of_Consideration")
  private String areaOfConsideration;
  @XmlElement(name="Interdisciplinary_Position")
  private String interdisciplinaryPosition;
  @XmlElement(name="Vacancy_Identification_Number")
  private String vacancyIdentificationNumber;
  @XmlElement(name="Vacancy_Announcement_Number")
  private String vacancyAnnouncementNumber;
  @XmlElement(name="Announcement_Type")
  private String announcementType;
  @XmlElement(name="Date_Announcement_Posted")
  private String dateAnnouncementPosted;
  @XmlElement(name="Date_Announcement_Opened")
  private String dateAnnouncementOpened;
  @XmlElement(name="Date_Announcement_Closed")
  private String dateAnnouncementClosed;
  @XmlElement(name="Date_Announcement_Cancelled")
  private String dateAnnouncementCancelled;
  @XmlElementWrapper(name="Positions")
//  @XmlElement(name="Position")
  @XmlElement(name="record")
  private List<PositionResult> positionList;
  @XmlElement(name="Applicants")
  private ApplicantRatingResult applicants;
  @XmlElementWrapper(name="Certificates")
//  @XmlElement(name="Certificate")
  @XmlElement(name="record")
  private List<CertificateResult> certificateList;
  
  public VacancyAnnouncementResult()
  {
    this.vacancyPositionCount = 0;
    this.vacancyCertificateCount = 0;
    this.numberOfPositionsAdvertised = "";
    this.areaOfConsiderationList = new ArrayList<String>();
    this.areaOfConsideration = "";
    this.interdisciplinaryPosition = "";
    this.vacancyIdentificationNumber = "";
    this.vacancyAnnouncementNumber = "";
    this.announcementType = "";
    this.dateAnnouncementPosted = "";
    this.dateAnnouncementOpened = "";
    this.dateAnnouncementClosed = "";
    this.dateAnnouncementCancelled = "";
    this.positionList = new ArrayList<PositionResult>();
    this.applicants = new ApplicantRatingResult();
    this.certificateList = new ArrayList<CertificateResult>();
  }
  
  public VacancyAnnouncementResult(int vacancyPositionCount, int vacancyCertificateCount, String numberOfPositionsAdvertised,
		List<String> areaOfConsiderationList, String areaOfConsideration, String interdisciplinaryPosition,
		String vacancyIdentificationNumber, String vacancyAnnouncementNumber, String announcementType,
		String dateAnnouncementPosted, String dateAnnouncementOpened, String dateAnnouncementClosed,
		String dateAnnouncementCancelled, List<PositionResult> positionList, ApplicantRatingResult applicants,
		List<CertificateResult> certificateList) {
	this.vacancyPositionCount = vacancyPositionCount;
	this.vacancyCertificateCount = vacancyCertificateCount;
	this.numberOfPositionsAdvertised = numberOfPositionsAdvertised;
	this.areaOfConsiderationList = areaOfConsiderationList;
	this.areaOfConsideration = areaOfConsideration;
	this.interdisciplinaryPosition = interdisciplinaryPosition;
	this.vacancyIdentificationNumber = vacancyIdentificationNumber;
	this.vacancyAnnouncementNumber = vacancyAnnouncementNumber;
	this.announcementType = announcementType;
	this.dateAnnouncementPosted = dateAnnouncementPosted;
	this.dateAnnouncementOpened = dateAnnouncementOpened;
	this.dateAnnouncementClosed = dateAnnouncementClosed;
	this.dateAnnouncementCancelled = dateAnnouncementCancelled;
	this.positionList = positionList;
	this.applicants = applicants;
	this.certificateList = certificateList;
}



public int getVacancyPositionCount()
  {
    return this.vacancyPositionCount;
  }
  
  public void setVacancyPositionCount(int vacancyPositionCount)
  {
    this.vacancyPositionCount = vacancyPositionCount;
  }
  
  public int getVacancyCertificateCount()
  {
    return this.vacancyCertificateCount;
  }
  
  public void setVacancyCertificateCount(int vacancyCertificateCount)
  {
    this.vacancyCertificateCount = vacancyCertificateCount;
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
   StringBuffer areaOfConsiderationStr = new StringBuffer();
   for (int i = 0; i < this.areaOfConsiderationList.size(); i++) {
     if (i > 0) {
    	 areaOfConsiderationStr.append(";" + (String)this.areaOfConsiderationList.get(i));
     } else {
    	 areaOfConsiderationStr.append((String)this.areaOfConsiderationList.get(i));
     }
   }
   this.areaOfConsideration = areaOfConsiderationStr.toString();
   return this.areaOfConsideration;
 }
 
 public void setAreaOfConsideration(List<String> areaOfConsideration)
 {
   this.areaOfConsiderationList = areaOfConsideration;
   this.areaOfConsideration = getAreaOfConsideration();
 }
 
 public void addAreaOfConsideration(String areaOfConsideration)
 {
   if ((!this.areaOfConsiderationList.contains(areaOfConsideration)) && (areaOfConsideration.trim().length() > 0)) {
     this.areaOfConsiderationList.add(areaOfConsideration);
   }
   this.areaOfConsideration = getAreaOfConsideration();
 }
  
  public String getInterdisciplinaryPosition()
  {
    return this.interdisciplinaryPosition;
  }
  
  public void setInterdisciplinaryPosition(String interdisciplinaryPosition)
  {
    this.interdisciplinaryPosition = interdisciplinaryPosition;
  }
  
  public String getVacancyIdentificationNumber()
  {
    return this.vacancyIdentificationNumber;
  }
  
  public void setVacancyIdentificationNumber(String vacancyIdentificationNumber)
  {
    this.vacancyIdentificationNumber = vacancyIdentificationNumber;
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
  
  public List<PositionResult> getPositionList()
  {
    return this.positionList;
  }
  
  public void setPositionList(List<PositionResult> positionList)
  {
    this.positionList = positionList;
    this.setVacancyPositionCount(this.positionList.size());
  }
  
  public void addPosition(PositionResult newPosition)
  {
    if (!this.positionList.contains(newPosition))
    {
      this.positionList.add(newPosition);
      this.vacancyPositionCount += 1;
    }
  }
  
  public ApplicantRatingResult getApplicants()
  {
    return this.applicants;
  }
  
  public void setApplicants(ApplicantRatingResult applicants)
  {
    this.applicants = applicants;
  }
  
  public List<CertificateResult> getCertificateList()
  {
    return this.certificateList;
  }
  
  public void setCertificateList(List<CertificateResult> certificate)
  {
    this.certificateList = certificate;
    this.setVacancyCertificateCount(this.certificateList.size());
  }
  
  public void addCertificate(CertificateResult newCertificate)
  {
    if (!this.certificateList.contains(newCertificate))
    {
      this.certificateList.add(newCertificate);
      this.vacancyCertificateCount += 1;
    }
  }
  
  @Override
public String toString()
  {
    return "VacancyAnnouncementResult [vacancyPositionCount: " + getVacancyPositionCount() + "| vacancyCertificateCount: " 
    		+ getVacancyCertificateCount() + "| numberOfPositionsAdvertised: " + getNumberOfPositionsAdvertised() + "|  areaOfConsideration: " 
    		+ getAreaOfConsideration() + "|  interdisciplinaryPosition: " + getInterdisciplinaryPosition() + "|  vacancyIdentificationNumber: " 
    		+ getVacancyIdentificationNumber() + "|  vacancyAnnouncementNumber: " + getVacancyAnnouncementNumber() + "|  announcementType: " 
    		+ getAnnouncementType() + "|  dateAnnouncementPosted: " + getDateAnnouncementPosted() + "|  dateAnnouncementOpened: " 
    		+ getDateAnnouncementOpened() + "|  dateAnnouncementClosed: " + getDateAnnouncementClosed() + "|  dateAnnouncementCancelled: " 
    		+ getDateAnnouncementCancelled() + "| positionList: " + getPositionList() + "| applicants: " + getApplicants() + "| certificate: " + getCertificateList() + "]";
  }
}

