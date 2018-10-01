package gov.hhs.ehrp.model;

public class Positions {

	private String jobReqNbr;
	private String positionNbr;
	private String primaryPositionFlag;
	
    public Positions() {
    	this.jobReqNbr = "";
    	this.positionNbr = "";
    	this.primaryPositionFlag = "";
    }

	public Positions(String jobReqNbr, String positionNbr, String primaryPositionFlag) {
		this.jobReqNbr = jobReqNbr;
		this.positionNbr = positionNbr;
		this.primaryPositionFlag = primaryPositionFlag;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getPositionNbr() {
		return positionNbr;
	}

	public void setPositionNbr(String positionNbr) {
		this.positionNbr = positionNbr;
	}

	public String getPrimaryPositionFlag() {
		return primaryPositionFlag;
	}

	public void setPrimaryPositionFlag(String primaryPositionFlag) {
		this.primaryPositionFlag = primaryPositionFlag;
	}

	@Override
	public String toString() {
		return "PositionsResult [jobReqNbr=" + jobReqNbr + ", positionNbr=" + positionNbr + ", primaryPositionFlag="
				+ primaryPositionFlag + "]";
	}
    
}
