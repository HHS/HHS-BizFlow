package hhs.usas.dss.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import hhs.usas.dss.JaxbDateAdapter;

@XmlRootElement(name = "lst_VacancyDetail")
public class VacancyDetail{
	
    private static final String INSERT_VACANCY_DETAIL = "INSERT INTO DSS_VACANCY_DETAIL(VACANCY_NUMBER, VACANCY_STATUS, JOB_TITLE, VACANCY_DESCRIPTION, VACANCY_TYPE, DISPLAY_TYPE, IS_INTERNAL_MERIT_PROMO,IS_PUBLIC, IS_STATUS, CREATION_DATE, LAST_UPDATE_DATE, ANNOUNCEMENT_NUMBER, IS_UNDER_LITIGATION, ORGANIZATION_NAME,ORGANIZATION_CODE, OFFICE_NAME, OFFICE_CODE, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CITY, STATE_ABBREV, POSTALCODE,COUNTRY, HIRING_ORGANIZATION_NAME, ACWA, AGE_SCREENING, APPLICANT_UPDT_RESTRICTED, APPLY_ONLINE, CITIZENSHIP_SCREENING,IS_AGE_FORMULA, HAS_MAX_AGE, HAS_MIN_AGE, MAX_AGE, MIN_AGE, PERIOD_OF_ELIGIBILITY, RELOCATION, RNO, SECURITY_CLEARANCE,SUPERVISORY_POSITION, TRAVEL_PREFERENCE) VALUES (:VacancyNum, :VacancyStatus, :JobTitle, :VacancyDesc, :VacancyType, :DisplayType, :InternalMeritPromo,:IsPublic, :IsStatus, :CreationDate, :LastUpdateDate, :AnnouncementNum, :IsUnderLitigation,:OrgName, :OrgCode, :OfficeName, :OfficeCode, :Address1, :Address2, :Address3, :City, :State, :PostalCode, :Country, :HiringOrgName, :ACWA, :AgeScreening, :ApplicantUpdateRestricted, :ApplyOnline, :CitizenshipScreening,:IsAgeFormula, :HasMaxAge, :HasMinAge, :MaxAge, :MinAge, :EligibilityPeriod, :Relocation, :RNO, :SecurityClearance, :SupervisoryPosition, :TravelPref)";    
	
	private Integer vacancyNum;
	private String vacancyStatus;
	private String jobTitle;
	private String vacancyDesc;
	private String vacancyType;
	private String displayType;
	private String internalMeritPromo;
	private String isPublic;
	private String isStatus;
	private Date creationDate;
	private Date lastUpdateDate;
	private String announcementNum;
	private String isUnderLitigation;
	private String orgName;
	private String orgCode;
	private String officeName;
	private String officeCode;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String hiringOrgName;
	private String ACWA;
	private String ageScreening;
	private String applicantUpdateRestricted;
	private String applyOnline;
	private String citizenshipScreening;
	private String isAgeFormula;
	private String hasMaxAge;
	private String hasMinAge;
	private Integer maxAge;
	private Integer minAge;
	private Integer eligibilityPeriod;
	private String relocation;
	private String RNO;
	private String securityClearance;
	private String supervisoryPosition;
	private String travelPref;	
	
	public static String getInsertVacancyDetail() {
		return INSERT_VACANCY_DETAIL;
	}
	
	public VacancyDetail() {
		super();
	}

	public VacancyDetail(Integer vacancyNum, String vacancyStatus, String jobTitle, String vacancyDesc,
			String vacancyType, String displayType, String internalMeritPromo, String isPublic, String isStatus,
			Date creationDate, Date lastUpdateDate, String announcementNum, String isUnderLitigation,
			String orgName, String orgCode, String officeName, String officeCode, String address1, String address2,
			String address3, String city, String state, String postalCode, String country, String hiringOrgName,
			String aCWA, String ageScreening, String applicantUpdateRestricted, String applyOnline,
			String citizenshipScreening, String isAgeFormula, String hasMaxAge, String hasMinAge, Integer maxAge,
			Integer minAge, Integer eligibilityPeriod, String relocation, String rNO, String securityClearance,
			String supervisoryPosition, String travelPref) {
		super();
		this.vacancyNum = vacancyNum;
		this.vacancyStatus = vacancyStatus;
		this.jobTitle = jobTitle;
		this.vacancyDesc = vacancyDesc;
		this.vacancyType = vacancyType;
		this.displayType = displayType;
		this.internalMeritPromo = internalMeritPromo;
		this.isPublic = isPublic;
		this.isStatus = isStatus;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
		this.announcementNum = announcementNum;
		this.isUnderLitigation = isUnderLitigation;
		this.orgName = orgName;
		this.orgCode = orgCode;
		this.officeName = officeName;
		this.officeCode = officeCode;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.hiringOrgName = hiringOrgName;
		ACWA = aCWA;
		this.ageScreening = ageScreening;
		this.applicantUpdateRestricted = applicantUpdateRestricted;
		this.applyOnline = applyOnline;
		this.citizenshipScreening = citizenshipScreening;
		this.isAgeFormula = isAgeFormula;
		this.hasMaxAge = hasMaxAge;
		this.hasMinAge = hasMinAge;
		this.maxAge = maxAge;
		this.minAge = minAge;
		this.eligibilityPeriod = eligibilityPeriod;
		this.relocation = relocation;
		RNO = rNO;
		this.securityClearance = securityClearance;
		this.supervisoryPosition = supervisoryPosition;
		this.travelPref = travelPref;
	}
	
	@XmlElement(name = "Vacancy__Number")
	public Integer getVacancyNum() {
		return vacancyNum;
	}
	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}
	@XmlElement(name = "Vacancy__Status")
	public String getVacancyStatus() {
		return vacancyStatus;
	}
	public void setVacancyStatus(String vacancyStatus) {
		this.vacancyStatus = vacancyStatus;
	}
	@XmlElement(name = "Vacancy__USAJOBS__Job__Title")
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	@XmlElement(name = "Vacancy__Description")
	public String getVacancyDesc() {
		return vacancyDesc;
	}
	public void setVacancyDesc(String vacancyDesc) {
		this.vacancyDesc = vacancyDesc;
	}
	@XmlElement(name = "Vacancy__Type")
	public String getVacancyType() {
		return vacancyType;
	}
	public void setVacancyType(String vacancyType) {
		this.vacancyType = vacancyType;
	}
	@XmlElement(name = "Vacancy__USAJOBS__Display__Type")
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	@XmlElement(name = "Vacancy__USAJOBS__Announcement__Type___x0028Is__Internal__Merit__Promotion_x0029")
	public String getInternalMeritPromo() {
		return internalMeritPromo;
	}
	public void setInternalMeritPromo(String internalMeritPromo) {
		this.internalMeritPromo = internalMeritPromo;
	}
	@XmlElement(name = "Vacancy__USAJOBS__Announcement__Type___x0028Is__Public_x0029")
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	@XmlElement(name = "Vacancy__USAJOBS__Announcement__Type___x0028Is__Status_x0029")
	public String getIsStatus() {
		return isStatus;
	}
	public void setIsStatus(String isStatus) {
		this.isStatus = isStatus;
	}
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	@XmlElement(name = "Vacancy__Creation__Date")
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	@XmlElement(name = "Vacancy__Last__Update__Date_x002fTime")
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	@XmlElement(name = "Announcement__Number")
	public String getAnnouncementNum() {
		return announcementNum;
	}
	public void setAnnouncementNum(String announcementNum) {
		this.announcementNum = announcementNum;
	}
	@XmlElement(name = "Vacancy__Is__Under__Litigation")
	public String getIsUnderLitigation() {
		return isUnderLitigation;
	}
	public void setIsUnderLitigation(String isUnderLitigation) {
		this.isUnderLitigation = isUnderLitigation;
	}
	@XmlElement(name = "Vacancy__Staffing__Organization__Name")
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@XmlElement(name = "Vacancy__Staffing__Organization__Code")
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Name")
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Code")
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Address__Line__1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Address__Line__2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Address__Line__3")
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Address__City")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Address__State__Abbreviation")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Address__Postal__Code")
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@XmlElement(name = "Vacancy__Staffing__Office__Address__Country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@XmlElement(name = "Vacancy__Staffing__Hiring__Organization__Name")
	public String getHiringOrgName() {
		return hiringOrgName;
	}
	public void setHiringOrgName(String hiringOrgName) {
		this.hiringOrgName = hiringOrgName;
	}
	@XmlElement(name = "Vacancy__ACWA")
	public String getACWA() {
		return ACWA;
	}
	public void setACWA(String aCWA) {
		ACWA = aCWA;
	}
	@XmlElement(name = "Vacancy__Age__Screening")	
	public String getAgeScreening() {
		return ageScreening;
	}
	public void setAgeScreening(String ageScreening) {
		this.ageScreening = ageScreening;
	}
	@XmlElement(name = "Vacancy__Applicant__Update__Restricted")		
	public String getApplicantUpdateRestricted() {
		return applicantUpdateRestricted;
	}
	public void setApplicantUpdateRestricted(String applicantUpdateRestricted) {
		this.applicantUpdateRestricted = applicantUpdateRestricted;
	}
	@XmlElement(name = "Vacancy__Apply__Online")		
	public String getApplyOnline() {
		return applyOnline;
	}
	public void setApplyOnline(String applyOnline) {
		this.applyOnline = applyOnline;
	}
	@XmlElement(name = "Vacancy__Citizenship__Screening")	
	public String getCitizenshipScreening() {
		return citizenshipScreening;
	}
	public void setCitizenshipScreening(String citizenshipScreening) {
		this.citizenshipScreening = citizenshipScreening;
	}
	@XmlElement(name = "Vacancy__Is__Age__Formula")		
	public String getIsAgeFormula() {
		return isAgeFormula;
	}
	public void setIsAgeFormula(String isAgeFormula) {
		this.isAgeFormula = isAgeFormula;
	}
	@XmlElement(name = "Vacancy__Has__Maximum__Age")	
	public String getHasMaxAge() {
		return hasMaxAge;
	}
	public void setHasMaxAge(String hasMaxAge) {
		this.hasMaxAge = hasMaxAge;
	}
	@XmlElement(name = "Vacancy__Has__Minimum__Age")	
	public String getHasMinAge() {
		return hasMinAge;
	}
	public void setHasMinAge(String hasMinAge) {
		this.hasMinAge = hasMinAge;
	}
	@XmlElement(name = "Vacancy__Maximum__Age")		
	public Integer getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
	@XmlElement(name = "Vacancy__Minimum__Age")		
	public Integer getMinAge() {
		return minAge;
	}
	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}
	@XmlElement(name = "Vacancy__Period__of__Eligibility")		
	public Integer getEligibilityPeriod() {
		return eligibilityPeriod;
	}
	public void setEligibilityPeriod(Integer eligibilityPeriod) {
		this.eligibilityPeriod = eligibilityPeriod;
	}
	@XmlElement(name = "Vacancy__Relocation")		
	public String getRelocation() {
		return relocation;
	}
	public void setRelocation(String relocation) {
		this.relocation = relocation;
	}
	@XmlElement(name = "Vacancy__RNO")	
	public String getRNO() {
		return RNO;
	}
	public void setRNO(String rNO) {
		RNO = rNO;
	}
	@XmlElement(name = "Vacancy__Security__Clearance")		
	public String getSecurityClearance() {
		return securityClearance;
	}
	public void setSecurityClearance(String securityClearance) {
		this.securityClearance = securityClearance;
	}
	@XmlElement(name = "Vacancy__Supervisory__Position")		
	public String getSupervisoryPosition() {
		return supervisoryPosition;
	}
	public void setSupervisoryPosition(String supervisoryPosition) {
		this.supervisoryPosition = supervisoryPosition;
	}
	@XmlElement(name = "Vacancy__Travel__Preference")	
	public String getTravelPref() {
		return travelPref;
	}
	public void setTravelPref(String travelPref) {
		this.travelPref = travelPref;
	}
			
}
