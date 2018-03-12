package hhs.usas.dss.model;

public class TimeToRecruit extends Report {

	public TimeToRecruit() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/folder[@name='HHS']/folder[@name='Organization Shared']/folder[@name='Centers for Medicare and Medicaid Services']/report[@name='Time to Recruit']");
		this.setIntgType("TimeToRecruit");
		this.setFileName("TimeToRecruit");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateRange(-365);		
	}

}
