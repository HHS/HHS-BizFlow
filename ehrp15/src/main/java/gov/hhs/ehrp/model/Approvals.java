package gov.hhs.ehrp.model;

public class Approvals {

	private String jobReqNbr;
	private String step;
	private String status;
	private String statusDt;
	private String oprid;
	private String emplid;
	private String comments;
	
    public Approvals() {
    	this.jobReqNbr = "";
    	this.step = "";
    	this.status = "";
    	this.statusDt = "";
    	this.oprid = "";
    	this.emplid = "";
    	this.comments = "";
    }

	public Approvals(String jobReqNbr, String step, String status, String statusDt, String oprid, String emplid,
			String comments) {
		this.jobReqNbr = jobReqNbr;
		this.step = step;
		this.status = status;
		this.statusDt = statusDt;
		this.oprid = oprid;
		this.emplid = emplid;
		this.comments = comments;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDt() {
		return statusDt;
	}

	public void setStatusDt(String statusDt) {
		this.statusDt = statusDt;
	}

	public String getOprid() {
		return oprid;
	}

	public void setOprid(String oprid) {
		this.oprid = oprid;
	}

	public String getEmplid() {
		return emplid;
	}

	public void setEmplid(String emplid) {
		this.emplid = emplid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Approvals [jobReqNbr=" + jobReqNbr + ", step=" + step + ", status=" + status + ", statusDt=" + statusDt
				+ ", oprid=" + oprid + ", emplid=" + emplid + ", comments=" + comments + "]";
	}
    
}
