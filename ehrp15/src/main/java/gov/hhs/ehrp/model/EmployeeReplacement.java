package gov.hhs.ehrp.model;

public class EmployeeReplacement {

	private String jobReqNbr;
	private String viceEmplid;
	private String dateVacated;
	
    public EmployeeReplacement() {
    	this.jobReqNbr = "";
    	this.viceEmplid = "";
    	this.dateVacated = "";
    }

	public EmployeeReplacement(String jobReqNbr, String viceEmplid, String dateVacated) {
		this.jobReqNbr = jobReqNbr;
		this.viceEmplid = viceEmplid;
		this.dateVacated = dateVacated;
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

	@Override
	public String toString() {
		return "EmployeeReplacement [jobReqNbr=" + jobReqNbr + ", viceEmplid=" + viceEmplid + ", dateVacated="
				+ dateVacated + "]";
	}
       
}
