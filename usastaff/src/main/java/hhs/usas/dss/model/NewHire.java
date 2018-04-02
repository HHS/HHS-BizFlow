package hhs.usas.dss.model;

public class NewHire extends Report {
	
	public NewHire() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='New Hire Data Self Service']");
		this.setIntgType("NEWHIRE");
		this.setFileName("NewHireDSS");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateIncrement(-60);
		this.setEndDate("");
		this.setSpTruncate("SP_TRUNC_NEWHIRE_TABLE");
	}
	
}
