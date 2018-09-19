package gov.hhs.ehrp.model;

public class JobCodes {

	private String jobReqNbr;  
    private String jobCode;
    private String primaryJobCode;
    private String regRegion;
    private String desiredFullPart;
    private String desiredRegTemp;
    private String stdHrs;
    private String stdHrsFreq;
    private String desiredShift;
    private String gvtRqsnSalFrom;
    private String gvtRqsnSalTo;
    private String payFreqAbbrev;
    private String currencyCd;
    private String salAdminPlan;
    private String grade;
    private String travelPct;
    private String managerLvl;
    private String flsaStatus;
    private String summerAppt;
    private String nteDate;
    private String nteDays;
    private String leoPosition;
    private String posnSensCd;
    private String typeOfAppt;
    
    public JobCodes() {
    	this.jobReqNbr = "";
    	this.jobCode = "";
    	this.primaryJobCode = "";
    	this.regRegion = "";
    	this.desiredFullPart = "";
    	this.desiredRegTemp = "";
    	this.stdHrs = "";
    	this.stdHrsFreq = "";
    	this.desiredShift = "";
    	this.gvtRqsnSalFrom = "";
    	this.gvtRqsnSalTo = ""; 
    	this.payFreqAbbrev = "";
    	this.currencyCd = "";
    	this.salAdminPlan = "";
    	this.grade = "";
    	this.travelPct = "";
    	this.managerLvl = "";
    	this.flsaStatus = "";
    	this.summerAppt = "";
    	this.nteDate = "";
    	this.nteDays = "";
    	this.leoPosition = "";
    	this.posnSensCd = "";
    	this.typeOfAppt = "";
    }

	public JobCodes(String jobReqNbr, String jobCode, String primaryJobCode, String regRegion,
			String desiredFullPart, String desiredRegTemp, String stdHrs, String stdHrsFreq, String desiredShift,
			String gvtRqsnSalFrom, String gvtRqsnSalTo, String payFreqAbbrev, String currencyCd, String salAdminPlan,
			String grade, String travelPct, String managerLvl, String flsaStatus, String summerAppt, String nteDate,
			String nteDays, String leoPosition, String posnSensCd, String typeOfAppt) {
		this.jobReqNbr = jobReqNbr;
		this.jobCode = jobCode;
		this.primaryJobCode = primaryJobCode;
		this.regRegion = regRegion;
		this.desiredFullPart = desiredFullPart;
		this.desiredRegTemp = desiredRegTemp;
		this.stdHrs = stdHrs;
		this.stdHrsFreq = stdHrsFreq;
		this.desiredShift = desiredShift;
		this.gvtRqsnSalFrom = gvtRqsnSalFrom;
		this.gvtRqsnSalTo = gvtRqsnSalTo;
		this.payFreqAbbrev = payFreqAbbrev;
		this.currencyCd = currencyCd;
		this.salAdminPlan = salAdminPlan;
		this.grade = grade;
		this.travelPct = travelPct;
		this.managerLvl = managerLvl;
		this.flsaStatus = flsaStatus;
		this.summerAppt = summerAppt;
		this.nteDate = nteDate;
		this.nteDays = nteDays;
		this.leoPosition = leoPosition;
		this.posnSensCd = posnSensCd;
		this.typeOfAppt = typeOfAppt;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getPrimaryJobCode() {
		return primaryJobCode;
	}

	public void setPrimaryJobCode(String primaryJobCode) {
		this.primaryJobCode = primaryJobCode;
	}

	public String getRegRegion() {
		return regRegion;
	}

	public void setRegRegion(String regRegion) {
		this.regRegion = regRegion;
	}

	public String getDesiredFullPart() {
		return desiredFullPart;
	}

	public void setDesiredFullPart(String desiredFullPart) {
		this.desiredFullPart = desiredFullPart;
	}

	public String getDesiredRegTemp() {
		return desiredRegTemp;
	}

	public void setDesiredRegTemp(String desiredRegTemp) {
		this.desiredRegTemp = desiredRegTemp;
	}

	public String getStdHrs() {
		return stdHrs;
	}

	public void setStdHrs(String stdHrs) {
		this.stdHrs = stdHrs;
	}

	public String getStdHrsFreq() {
		return stdHrsFreq;
	}

	public void setStdHrsFreq(String stdHrsFreq) {
		this.stdHrsFreq = stdHrsFreq;
	}

	public String getDesiredShift() {
		return desiredShift;
	}

	public void setDesiredShift(String desiredShift) {
		this.desiredShift = desiredShift;
	}

	public String getGvtRqsnSalFrom() {
		return gvtRqsnSalFrom;
	}

	public void setGvtRqsnSalFrom(String gvtRqsnSalFrom) {
		this.gvtRqsnSalFrom = gvtRqsnSalFrom;
	}

	public String getGvtRqsnSalTo() {
		return gvtRqsnSalTo;
	}

	public void setGvtRqsnSalTo(String gvtRqsnSalTo) {
		this.gvtRqsnSalTo = gvtRqsnSalTo;
	}

	public String getPayFreqAbbrev() {
		return payFreqAbbrev;
	}

	public void setPayFreqAbbrev(String payFreqAbbrev) {
		this.payFreqAbbrev = payFreqAbbrev;
	}

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	public String getSalAdminPlan() {
		return salAdminPlan;
	}

	public void setSalAdminPlan(String salAdminPlan) {
		this.salAdminPlan = salAdminPlan;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTravelPct() {
		return travelPct;
	}

	public void setTravelPct(String travelPct) {
		this.travelPct = travelPct;
	}

	public String getManagerLvl() {
		return managerLvl;
	}

	public void setManagerLvl(String managerLvl) {
		this.managerLvl = managerLvl;
	}

	public String getFlsaStatus() {
		return flsaStatus;
	}

	public void setFlsaStatus(String flsaStatus) {
		this.flsaStatus = flsaStatus;
	}

	public String getSummerAppt() {
		return summerAppt;
	}

	public void setSummerAppt(String summerAppt) {
		this.summerAppt = summerAppt;
	}

	public String getNteDate() {
		return nteDate;
	}

	public void setNteDate(String nteDate) {
		this.nteDate = nteDate;
	}

	public String getNteDays() {
		return nteDays;
	}

	public void setNteDays(String nteDays) {
		this.nteDays = nteDays;
	}

	public String getLeoPosition() {
		return leoPosition;
	}

	public void setLeoPosition(String leoPosition) {
		this.leoPosition = leoPosition;
	}

	public String getPosnSensCd() {
		return posnSensCd;
	}

	public void setPosnSensCd(String posnSensCd) {
		this.posnSensCd = posnSensCd;
	}

	public String getTypeOfAppt() {
		return typeOfAppt;
	}

	public void setTypeOfAppt(String typeOfAppt) {
		this.typeOfAppt = typeOfAppt;
	}

	@Override
	public String toString() {
		return "JobCodesResult [jobReqNbr=" + jobReqNbr + ", jobCode=" + jobCode + ", primaryJobCode=" + primaryJobCode
				+ ", regRegion=" + regRegion + ", desiredFullPart=" + desiredFullPart + ", desiredRegTemp="
				+ desiredRegTemp + ", stdHrs=" + stdHrs + ", stdHrsFreq=" + stdHrsFreq + ", desiredShift="
				+ desiredShift + ", gvtRqsnSalFrom=" + gvtRqsnSalFrom + ", gvtRqsnSalTo=" + gvtRqsnSalTo
				+ ", payFreqAbbrev=" + payFreqAbbrev + ", currencyCd=" + currencyCd + ", salAdminPlan=" + salAdminPlan
				+ ", grade=" + grade + ", travelPct=" + travelPct + ", managerLvl=" + managerLvl + ", flsaStatus="
				+ flsaStatus + ", summerAppt=" + summerAppt + ", nteDate=" + nteDate + ", nteDays=" + nteDays
				+ ", leoPosition=" + leoPosition + ", posnSensCd=" + posnSensCd + ", typeOfAppt=" + typeOfAppt + "]";
	}
    
}
