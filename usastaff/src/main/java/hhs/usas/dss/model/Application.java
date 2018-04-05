package hhs.usas.dss.model;

public class Application extends Report {
	
	public Application() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Application Data Self Service']");
		this.setIntgType("APPLICATION");
		this.setFileName("ApplicationDSS");
		this.setParmNum(2);
		this.setSvpName("parm_StaffingDateType");
		this.setSvpUseval("ApplicationLastUpdateDate");
		this.setSvpDisplay("Application Last Update Date");
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateIncrement(-25);
		this.setEndDate(""); //01/01/2015
		this.setSpTruncate("SP_TRUNC_APPLICATION_TABLE");
		this.setRunReport(true);
	}

	
}
