package hhs.usas.dss.model;

public class Task extends Report{
	
	public Task() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Task Data Self Service']");
		this.setIntgType("TASK");
		this.setFileName("TaskDSS");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateIncrement(-25);
		this.setEndDate(""); //01/01/2015
		this.setSpTruncate("SP_TRUNC_TASK_TABLE");
		this.setRunReport(true);
	}
	
}
