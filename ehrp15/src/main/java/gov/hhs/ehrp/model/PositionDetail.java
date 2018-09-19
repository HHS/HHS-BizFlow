package gov.hhs.ehrp.model;

public class PositionDetail {

	private String jobReqNbr;
	private String reportsTo;
	private String location;
	private String stdHrsDflt;
	private String bargUnit;
	private String payPlan;
	private String workSched;
	private String orgTtlDescr;
	private String drugTestReq;
	private String series;
	private String posnSensCd;
	private String securityClearance;
	private String empFinInt;
	private String gradeDflt;
	
    public PositionDetail() {
    	this.jobReqNbr = "";
    	this.reportsTo = "";
    	this.location = "";
    	this.stdHrsDflt = "";
    	this.bargUnit = "";
    	this.payPlan = "";
    	this.workSched = "";
    	this.orgTtlDescr = "";
    	this.drugTestReq = "";
    	this.series = "";
    	this.posnSensCd = "";
    	this.securityClearance = "";
    	this.empFinInt = "";
    	this.gradeDflt = "";
    }
	
	public PositionDetail(String jobReqNbr, String reportsTo, String location, String stdHrsDflt, String bargUnit,
			String payPlan, String workSched, String orgTtlDescr, String drugTestReq, String series, String posnSensCd,
			String securityClearance, String empFinInt, String gradeDflt) {
		this.jobReqNbr = jobReqNbr;
		this.reportsTo = reportsTo;
		this.location = location;
		this.stdHrsDflt = stdHrsDflt;
		this.bargUnit = bargUnit;
		this.payPlan = payPlan;
		this.workSched = workSched;
		this.orgTtlDescr = orgTtlDescr;
		this.drugTestReq = drugTestReq;
		this.series = series;
		this.posnSensCd = posnSensCd;
		this.securityClearance = securityClearance;
		this.empFinInt = empFinInt;
		this.gradeDflt = gradeDflt;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStdHrsDflt() {
		return stdHrsDflt;
	}

	public void setStdHrsDflt(String stdHrsDflt) {
		this.stdHrsDflt = stdHrsDflt;
	}

	public String getBargUnit() {
		return bargUnit;
	}

	public void setBargUnit(String bargUnit) {
		this.bargUnit = bargUnit;
	}

	public String getPayPlan() {
		return payPlan;
	}

	public void setPayPlan(String payPlan) {
		this.payPlan = payPlan;
	}

	public String getWorkSched() {
		return workSched;
	}

	public void setWorkSched(String workSched) {
		this.workSched = workSched;
	}

	public String getOrgTtlDescr() {
		return orgTtlDescr;
	}

	public void setOrgTtlDescr(String orgTtlDescr) {
		this.orgTtlDescr = orgTtlDescr;
	}

	public String getDrugTestReq() {
		return drugTestReq;
	}

	public void setDrugTestReq(String drugTestReq) {
		this.drugTestReq = drugTestReq;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getPosnSensCd() {
		return posnSensCd;
	}

	public void setPosnSensCd(String posnSensCd) {
		this.posnSensCd = posnSensCd;
	}

	public String getSecurityClearance() {
		return securityClearance;
	}

	public void setSecurityClearance(String securityClearance) {
		this.securityClearance = securityClearance;
	}

	public String getEmpFinInt() {
		return empFinInt;
	}

	public void setEmpFinInt(String empFinInt) {
		this.empFinInt = empFinInt;
	}

	public String getGradeDflt() {
		return gradeDflt;
	}

	public void setGradeDflt(String gradeDflt) {
		this.gradeDflt = gradeDflt;
	}

	@Override
	public String toString() {
		return "PositionDetail [jobReqNbr=" + jobReqNbr + ", reportsTo=" + reportsTo + ", location=" + location
				+ ", stdHrsDflt=" + stdHrsDflt + ", bargUnit=" + bargUnit + ", payPlan=" + payPlan + ", workSched="
				+ workSched + ", orgTtlDescr=" + orgTtlDescr + ", drugTestReq=" + drugTestReq + ", series=" + series
				+ ", posnSensCd=" + posnSensCd + ", securityClearance=" + securityClearance + ", empFinInt=" + empFinInt
				+ ", gradeDflt=" + gradeDflt + "]";
	}
	
}
