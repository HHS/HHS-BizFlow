package gov.hhs.ehrp.model;

public class EwitsDetails {

	private String jobReqNbr;
	private String physCompAllowance;
	private String physDentistPay;
	private String nonStandardPay;
	private String positionDescr;
	private String recruitmentIncentive;
	private String relocationIncentive;
	private String can;
	
    public EwitsDetails() {
    	this.jobReqNbr = "";
    	this.physCompAllowance = "";
    	this.physDentistPay = "";
    	this.nonStandardPay = "";
    	this.positionDescr = "";
    	this.recruitmentIncentive = "";
    	this.relocationIncentive = "";
    	this.can = "";   	
    }

	public EwitsDetails(String jobReqNbr, String physCompAllowance, String physDentistPay, String nonStandardPay,
			String positionDescr, String recruitmentIncentive, String relocationIncentive, String can) {
		this.jobReqNbr = jobReqNbr;
		this.physCompAllowance = physCompAllowance;
		this.physDentistPay = physDentistPay;
		this.nonStandardPay = nonStandardPay;
		this.positionDescr = positionDescr;
		this.recruitmentIncentive = recruitmentIncentive;
		this.relocationIncentive = relocationIncentive;
		this.can = can;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getPhysCompAllowance() {
		return physCompAllowance;
	}

	public void setPhysCompAllowance(String physCompAllowance) {
		this.physCompAllowance = physCompAllowance;
	}

	public String getPhysDentistPay() {
		return physDentistPay;
	}

	public void setPhysDentistPay(String physDentistPay) {
		this.physDentistPay = physDentistPay;
	}

	public String getNonStandardPay() {
		return nonStandardPay;
	}

	public void setNonStandardPay(String nonStandardPay) {
		this.nonStandardPay = nonStandardPay;
	}

	public String getPositionDescr() {
		return positionDescr;
	}

	public void setPositionDescr(String positionDescr) {
		this.positionDescr = positionDescr;
	}

	public String getRecruitmentIncentive() {
		return recruitmentIncentive;
	}

	public void setRecruitmentIncentive(String recruitmentIncentive) {
		this.recruitmentIncentive = recruitmentIncentive;
	}

	public String getRelocationIncentive() {
		return relocationIncentive;
	}

	public void setRelocationIncentive(String relocationIncentive) {
		this.relocationIncentive = relocationIncentive;
	}

	public String getCan() {
		return can;
	}

	public void setCan(String can) {
		this.can = can;
	}

	@Override
	public String toString() {
		return "EwitsDetails [jobReqNbr=" + jobReqNbr + ", physCompAllowance=" + physCompAllowance + ", physDentistPay="
				+ physDentistPay + ", nonStandardPay=" + nonStandardPay + ", positionDescr=" + positionDescr
				+ ", recruitmentIncentive=" + recruitmentIncentive + ", relocationIncentive=" + relocationIncentive
				+ ", can=" + can + "]";
	}
    
}
