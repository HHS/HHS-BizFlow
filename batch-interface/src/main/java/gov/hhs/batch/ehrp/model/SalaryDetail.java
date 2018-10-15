package gov.hhs.batch.ehrp.model;

public class SalaryDetail {

	private String jobReqNbr;
	private String jobCode;
	private String minSalary;
	private String maxSalary;
	
    public SalaryDetail() {
    	this.jobReqNbr = "";
    	this.jobCode = "";
    	this.minSalary = "";
    	this.maxSalary = "";
    }

	public SalaryDetail(String jobReqNbr, String jobCode, String minSalary, String maxSalary) {
		this.jobReqNbr = jobReqNbr;
		this.jobCode = jobCode;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
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

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	@Override
	public String toString() {
		return "SalaryDetail [jobReqNbr=" + jobReqNbr + ", jobCode=" + jobCode + ", minSalary=" + minSalary
				+ ", maxSalary=" + maxSalary + "]";
	}
    
}
