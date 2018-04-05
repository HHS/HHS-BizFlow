package hhs.usas.dss.model;

public class Request extends Report {

	public Request() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Request Data Self Service']");
		this.setIntgType("REQUEST");
		this.setFileName("RequestDSS");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateIncrement(-60);
		this.setEndDate("");
		this.setSpTruncate("SP_TRUNC_REQUEST_TABLE");
		this.setRunReport(true);
	}

}
