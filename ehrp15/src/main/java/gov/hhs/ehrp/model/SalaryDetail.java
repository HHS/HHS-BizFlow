package gov.hhs.ehrp.model;

public class SalaryDetail {

	private String jobReqNbr;
	private String minSalary;
	private String maxSalary;
	
    public SalaryDetail() {
    	this.jobReqNbr = "";
    	this.minSalary = "";
    	this.maxSalary = "";
    }

	public SalaryDetail(String jobReqNbr, String minSalary, String maxSalary) {
		this.jobReqNbr = jobReqNbr;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
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
		return "SalaryDetail [jobReqNbr=" + jobReqNbr + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + "]";
	}
    
}
