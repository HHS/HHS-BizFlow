package gov.hhs.batch.ehrp.model;

public class Openings {

	private String jobReqNbr;
	private String location;
	private String primaryLocationFlag;
	private String descr;
	
	
    public Openings() {
    	this.jobReqNbr = "";
    	this.location = "";
    	this.primaryLocationFlag = "";
    	this.descr = "";
    }


	public Openings(String jobReqNbr, String location, String primaryLocationFlag, String descr) {
		this.jobReqNbr = jobReqNbr;
		this.location = location;
		this.primaryLocationFlag = primaryLocationFlag;
		this.descr = descr;
	}


	public String getJobReqNbr() {
		return jobReqNbr;
	}


	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPrimaryLocationFlag() {
		return primaryLocationFlag;
	}


	public void setPrimaryLocationFlag(String primaryLocationFlag) {
		this.primaryLocationFlag = primaryLocationFlag;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}


	@Override
	public String toString() {
		return "Openings [jobReqNbr=" + jobReqNbr + ", location=" + location + ", primaryLocationFlag="
				+ primaryLocationFlag + ", descr=" + descr + "]";
	}
 
    
}
