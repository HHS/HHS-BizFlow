package gov.hhs.batch.ehrp.model;

public class EmployeeReplacement {

	private String jobReqNbr;
	private String viceEmplid;
	private String dateVacated;
	private String viceName;
	
    public EmployeeReplacement() {
    	this.jobReqNbr = "";
    	this.viceEmplid = "";
    	this.dateVacated = "";
    	this.viceName = "";
    }

	public EmployeeReplacement(String jobReqNbr, String viceEmplid, String dateVacated, String viceName) {
		this.jobReqNbr = jobReqNbr;
		this.viceEmplid = viceEmplid;
		this.dateVacated = dateVacated;
		this.viceName = viceName;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getViceEmplid() {
		return viceEmplid;
	}

	public void setViceEmplid(String viceEmplid) {
		this.viceEmplid = viceEmplid;
	}

	public String getDateVacated() {
		return dateVacated;
	}

	public void setDateVacated(String dateVacated) {
		this.dateVacated = dateVacated;
	}

	public String getViceName() {
		return viceName;
	}

	public void setViceName(String viceName) {
		this.viceName = viceName;
	}

	@Override
	public String toString() {
		return "EmployeeReplacement [jobReqNbr=" + jobReqNbr + ", viceEmplid=" + viceEmplid + ", dateVacated="
				+ dateVacated + ", viceName=" + viceName + "]";
	}
       
}
