package hhs.usas.dss.model;

public class Task extends Report{
	
	public Task() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Task Data Self Service']");
		this.setIntgType("TASK");
		this.setFileName("TaskDSS");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(3);
		this.setDateRange(-60);		
	}
	
}
