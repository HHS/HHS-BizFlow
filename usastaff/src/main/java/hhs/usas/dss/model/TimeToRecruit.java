package hhs.usas.dss.model;

public class TimeToRecruit extends Report {

	public TimeToRecruit() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/folder[@name='HHS']/folder[@name='Organization Shared']/folder[@name='Centers for Medicare and Medicaid Services']/folder[@name='Custom DSS']/report[@name='Time to Recruit']");
		this.setIntgType("TIME2RECRUIT");
		this.setFileName("TimeToRecruit");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateIncrement(-365);
		this.setEndDate("10/01/2016");
		this.setSpTruncate("SP_TRUNC_TIME2RECRUIT_TABLE");
		this.setRunReport(true);
	}

}
