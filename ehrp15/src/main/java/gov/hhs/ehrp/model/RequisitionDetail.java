package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

public class RequisitionDetail {
	
	private String jobReqNbr;
	private String originatorId;
	private String openDt;
	private String jobReqStatus;
	private String businessUnit;
	private String deptId;
	private String gvtRecrOffice;
	private String heApprovalOprid;
	private String gvtSelOfficial;
	private String statusDt;
	private String openingsTarget;
	private String setIdDept;
	private String company;
	private String jobcode;
	private String positionNbr;
	private String location;
	private String postingTitle;
	private String desiredStartDt;
	private String authorizationDt;
	private String country;
	private String gvtStaffSpclst;
	private String gvtConsiderArea;
	private String gvtRqsnType;
	private String initiatorOprid;
	private String comments;
	
	public RequisitionDetail() {
		this.jobReqNbr = "";
		this.originatorId = "";
		this.openDt = "";
		this.jobReqStatus = "";
		this.businessUnit = "";
		this.deptId = "";
		this.gvtRecrOffice = "";
		this.heApprovalOprid = "";
		this.gvtSelOfficial = "";
		this.statusDt = "";
		this.openingsTarget = "";
		this.setIdDept = "";
		this.company = "";
		this.jobcode = "";
		this.positionNbr = "";
		this.location = "";
		this.postingTitle = "";
		this.desiredStartDt = "";
		this.authorizationDt = "";
		this.country = "";
		this.gvtStaffSpclst = "";
		this.gvtConsiderArea = "";
		this.gvtRqsnType = "";
		this.initiatorOprid = "";
		this.comments = "";
	}

	public RequisitionDetail(String jobReqNbr, String originatorId, String openDt, String jobReqStatus,
			String businessUnit, String deptId, String gvtRecrOffice, String heApprovalOprid, String gvtSelOfficial,
			String statusDt, String openingsTarget, String setIdDept, String company, String jobcode,
			String positionNbr, String location, String postingTitle, String desiredStartDt, String authorizationDt,
			String country, String gvtStaffSpclst, String gvtConsiderArea, String gvtRqsnType, String initiatorOprid,
			String comments) {
		this.jobReqNbr = jobReqNbr;
		this.originatorId = originatorId;
		this.openDt = openDt;
		this.jobReqStatus = jobReqStatus;
		this.businessUnit = businessUnit;
		this.deptId = deptId;
		this.gvtRecrOffice = gvtRecrOffice;
		this.heApprovalOprid = heApprovalOprid;
		this.gvtSelOfficial = gvtSelOfficial;
		this.statusDt = statusDt;
		this.openingsTarget = openingsTarget;
		this.setIdDept = setIdDept;
		this.company = company;
		this.jobcode = jobcode;
		this.positionNbr = positionNbr;
		this.location = location;
		this.postingTitle = postingTitle;
		this.desiredStartDt = desiredStartDt;
		this.authorizationDt = authorizationDt;
		this.country = country;
		this.gvtStaffSpclst = gvtStaffSpclst;
		this.gvtConsiderArea = gvtConsiderArea;
		this.gvtRqsnType = gvtRqsnType;
		this.initiatorOprid = initiatorOprid;
		this.comments = comments;
	}

	public String getJobReqNbr() {
		return jobReqNbr;
	}

	public void setJobReqNbr(String jobReqNbr) {
		this.jobReqNbr = jobReqNbr;
	}

	public String getOriginatorId() {
		return originatorId;
	}

	public void setOriginatorId(String originatorId) {
		this.originatorId = originatorId;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getJobReqStatus() {
		return jobReqStatus;
	}

	public void setJobReqStatus(String jobReqStatus) {
		this.jobReqStatus = jobReqStatus;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getGvtRecrOffice() {
		return gvtRecrOffice;
	}

	public void setGvtRecrOffice(String gvtRecrOffice) {
		this.gvtRecrOffice = gvtRecrOffice;
	}

	public String getHeApprovalOprid() {
		return heApprovalOprid;
	}

	public void setHeApprovalOprid(String heApprovalOprid) {
		this.heApprovalOprid = heApprovalOprid;
	}

	public String getGvtSelOfficial() {
		return gvtSelOfficial;
	}

	public void setGvtSelOfficial(String gvtSelOfficial) {
		this.gvtSelOfficial = gvtSelOfficial;
	}

	public String getStatusDt() {
		return statusDt;
	}

	public void setStatusDt(String statusDt) {
		this.statusDt = statusDt;
	}

	public String getOpeningsTarget() {
		return openingsTarget;
	}

	public void setOpeningsTarget(String openingsTarget) {
		this.openingsTarget = openingsTarget;
	}

	public String getSetIdDept() {
		return setIdDept;
	}

	public void setSetIdDept(String setIdDept) {
		this.setIdDept = setIdDept;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobcode() {
		return jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	public String getPositionNbr() {
		return positionNbr;
	}

	public void setPositionNbr(String positionNbr) {
		this.positionNbr = positionNbr;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostingTitle() {
		return postingTitle;
	}

	public void setPostingTitle(String postingTitle) {
		this.postingTitle = postingTitle;
	}

	public String getDesiredStartDt() {
		return desiredStartDt;
	}

	public void setDesiredStartDt(String desiredStartDt) {
		this.desiredStartDt = desiredStartDt;
	}

	public String getAuthorizationDt() {
		return authorizationDt;
	}

	public void setAuthorizationDt(String authorizationDt) {
		this.authorizationDt = authorizationDt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGvtStaffSpclst() {
		return gvtStaffSpclst;
	}

	public void setGvtStaffSpclst(String gvtStaffSpclst) {
		this.gvtStaffSpclst = gvtStaffSpclst;
	}

	public String getGvtConsiderArea() {
		return gvtConsiderArea;
	}

	public void setGvtConsiderArea(String gvtConsiderArea) {
		this.gvtConsiderArea = gvtConsiderArea;
	}

	public String getGvtRqsnType() {
		return gvtRqsnType;
	}

	public void setGvtRqsnType(String gvtRqsnType) {
		this.gvtRqsnType = gvtRqsnType;
	}

	public String getInitiatorOprid() {
		return initiatorOprid;
	}

	public void setInitiatorOprid(String initiatorOprid) {
		this.initiatorOprid = initiatorOprid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "RequisitionDetailResult [jobReqNbr=" + jobReqNbr + ", originatorId=" + originatorId + ", openDt="
				+ openDt + ", jobReqStatus=" + jobReqStatus + ", businessUnit=" + businessUnit + ", deptId=" + deptId
				+ ", gvtRecrOffice=" + gvtRecrOffice + ", heApprovalOprid=" + heApprovalOprid + ", gvtSelOfficial="
				+ gvtSelOfficial + ", statusDt=" + statusDt + ", openingsTarget=" + openingsTarget + ", setIdDept="
				+ setIdDept + ", company=" + company + ", jobcode=" + jobcode + ", positionNbr=" + positionNbr
				+ ", location=" + location + ", postingTitle=" + postingTitle + ", desiredStartDt=" + desiredStartDt
				+ ", authorizationDt=" + authorizationDt + ", country=" + country + ", gvtStaffSpclst=" + gvtStaffSpclst
				+ ", gvtConsiderArea=" + gvtConsiderArea + ", gvtRqsnType=" + gvtRqsnType + ", initiatorOprid="
				+ initiatorOprid + ", comments=" + comments + "]";
	}

}
