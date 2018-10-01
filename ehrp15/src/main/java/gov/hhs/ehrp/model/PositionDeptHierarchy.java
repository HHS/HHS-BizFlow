package gov.hhs.ehrp.model;

public class PositionDeptHierarchy {

	private String jobReqNbr;
	private String positionNbr;
	private String setId;
	private String deptId;
	private String descr;
	private String parLine2;
	private String parDescr2;
	private String parLine3;
	private String parDescr3;
	private String parLine4;
	private String parDescr4;
	private String parLine5;
	private String parDescr5;
	
    public PositionDeptHierarchy() {
    	this.jobReqNbr = "";
    	this.positionNbr = "";
    	this.setId = "";
    	this.deptId = "";
    	this.descr = "";
    	this.parLine2 = "";
    	this.parDescr2 = "";
    	this.parLine3 = "";
    	this.parDescr3 = "";
    	this.parLine4 = "";
    	this.parDescr4 = "";
    	this.parLine5 = "";
    	this.parDescr5 = "";
    }

	public PositionDeptHierarchy(String jobReqNbr, String positionNbr, String setId, String deptId, String descr, String parLine2,
			String parDescr2, String parLine3, String parDescr3, String parLine4, String parDescr4, String parLine5,
			String parDescr5) {
		this.jobReqNbr = jobReqNbr;
		this.positionNbr = positionNbr;
		this.setId = setId;
		this.deptId = deptId;
		this.descr = descr;
		this.parLine2 = parLine2;
		this.parDescr2 = parDescr2;
		this.parLine3 = parLine3;
		this.parDescr3 = parDescr3;
		this.parLine4 = parLine4;
		this.parDescr4 = parDescr4;
		this.parLine5 = parLine5;
		this.parDescr5 = parDescr5;
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

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getParLine2() {
		return parLine2;
	}

	public void setParLine2(String parLine2) {
		this.parLine2 = parLine2;
	}

	public String getParDescr2() {
		return parDescr2;
	}

	public void setParDescr2(String parDescr2) {
		this.parDescr2 = parDescr2;
	}

	public String getParLine3() {
		return parLine3;
	}

	public void setParLine3(String parLine3) {
		this.parLine3 = parLine3;
	}

	public String getParDescr3() {
		return parDescr3;
	}

	public void setParDescr3(String parDescr3) {
		this.parDescr3 = parDescr3;
	}

	public String getParLine4() {
		return parLine4;
	}

	public void setParLine4(String parLine4) {
		this.parLine4 = parLine4;
	}

	public String getParDescr4() {
		return parDescr4;
	}

	public void setParDescr4(String parDescr4) {
		this.parDescr4 = parDescr4;
	}

	public String getParLine5() {
		return parLine5;
	}

	public void setParLine5(String parLine5) {
		this.parLine5 = parLine5;
	}

	public String getParDescr5() {
		return parDescr5;
	}

	public void setParDescr5(String parDescr5) {
		this.parDescr5 = parDescr5;
	}

	@Override
	public String toString() {
		return "PositionDeptHierarchy [jobReqNbr=" + jobReqNbr + ", positionNbr=" + positionNbr + ", setId=" + setId
				+ ", deptId=" + deptId + ", descr=" + descr + ", parLine2=" + parLine2 + ", parDescr2=" + parDescr2
				+ ", parLine3=" + parLine3 + ", parDescr3=" + parDescr3 + ", parLine4=" + parLine4 + ", parDescr4="
				+ parDescr4 + ", parLine5=" + parLine5 + ", parDescr5=" + parDescr5 + "]";
	}
    
}
