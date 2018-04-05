package hhs.usas.dss.model;

public class IHSVacancy extends Report{
	
	public IHSVacancy() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/folder[@name='HHS']/folder[@name='Organization Shared']/folder[@name='Indian Health Service']/folder[@name='Custom DSS']/report[@name='IHS Custom Report - Fill a Vacancy']");
		this.setIntgType("IHS-VACANCY");
		this.setFileName("IHSFillAVacancy");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateIncrement(-60);
		this.setEndDate(""); //01/01/2015
		this.setSpTruncate("SP_TRUNC_IHS_VAC_TABLE");
		this.setRunReport(true);
	}
	
}
