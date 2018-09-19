package gov.hhs.ehrp.model;

public class EmployeeName {

	private String jobReqNbr;
	private String viceName;
	
    public EmployeeName() {
    	this.jobReqNbr = "";
    	this.viceName = "";
    }

	public EmployeeName(String jobReqNbr, String viceName) {
		this.jobReqNbr = jobReqNbr;
		this.viceName = viceName;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getViceName() {
		return viceName;
	}

	public void setViceName(String viceName) {
		this.viceName = viceName;
	}

	@Override
	public String toString() {
		return "EmployeeName [jobReqNbr=" + jobReqNbr + ", viceName=" + viceName + "]";
	}
        
}
