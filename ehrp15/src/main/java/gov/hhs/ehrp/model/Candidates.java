package gov.hhs.ehrp.model;

public class Candidates {

	private String jobReqNbr;
	private String sequenceNbr;
	private String name;
	
    public Candidates() {
    	this.jobReqNbr = "";
    	this.sequenceNbr = "";
    	this.name = "";
    }

	public Candidates(String jobReqNbr, String sequenceNbr, String name) {
		this.jobReqNbr = jobReqNbr;
		this.sequenceNbr = sequenceNbr;
		this.name = name;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getSequenceNbr() {
		return sequenceNbr;
	}

	public void setSequenceNbr(String sequenceNbr) {
		this.sequenceNbr = sequenceNbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Candidates [jobReqNbr=" + jobReqNbr + ", sequenceNbr=" + sequenceNbr + ", name=" + name + "]";
	}
    
}
