package gov.hhs.ehrp.model;

public class JobCodeDetail {

	private String jobReqNbr;
	private String salAdminPlan;
	private String grade;
	private String payPlan;
	private String series;
	private String officialDescr;
	private String execFinDiscl;
	private String targetGrade;
	
    public JobCodeDetail() {
    	this.jobReqNbr = "";
    	this.salAdminPlan = "";
    	this.grade = "";
    	this.payPlan = "";
    	this.series = "";
    	this.officialDescr = "";
    	this.execFinDiscl = "";
    	this.targetGrade = "";
    }

	public JobCodeDetail(String jobReqNbr, String salAdminPlan, String grade, String payPlan, String series,
			String officialDescr, String execFinDiscl, String targetGrade) {
		this.jobReqNbr = jobReqNbr;
		this.salAdminPlan = salAdminPlan;
		this.grade = grade;
		this.payPlan = payPlan;
		this.series = series;
		this.officialDescr = officialDescr;
		this.execFinDiscl = execFinDiscl;
		this.targetGrade = targetGrade;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
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

	public String getPayPlan() {
		return payPlan;
	}

	public void setPayPlan(String payPlan) {
		this.payPlan = payPlan;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getOfficialDescr() {
		return officialDescr;
	}

	public void setOfficialDescr(String officialDescr) {
		this.officialDescr = officialDescr;
	}

	public String getExecFinDiscl() {
		return execFinDiscl;
	}

	public void setExecFinDiscl(String execFinDiscl) {
		this.execFinDiscl = execFinDiscl;
	}

	public String getTargetGrade() {
		return targetGrade;
	}

	public void setTargetGrade(String targetGrade) {
		this.targetGrade = targetGrade;
	}

	@Override
	public String toString() {
		return "JobCodeDetail [jobReqNbr=" + jobReqNbr + ", salAdminPlan=" + salAdminPlan + ", grade=" + grade
				+ ", payPlan=" + payPlan + ", series=" + series + ", officialDescr=" + officialDescr + ", execFinDiscl="
				+ execFinDiscl + ", targetGrade=" + targetGrade + "]";
	}
    
}
