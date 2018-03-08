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
		this.setRptIteration(3);
		this.setDateRange(-60);		
	}

	
}
