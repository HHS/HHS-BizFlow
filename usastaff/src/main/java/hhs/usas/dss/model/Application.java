package hhs.usas.dss.model;

public class Application extends Report {
	
	public Application() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Application Data Self Service']");
		this.setIntgType("APPLICATION");
		this.setParmNum(2);
		this.setSvpName("parm_StaffingDateType");
		this.setSvpUseval("ApplicationLastUpdateDate");
		this.setSvpDisplay("Application Last Update Date");
		this.setRvpName("parm_StaffingDateRange");
		this.setRvpStartUseval("2018-01-01T00:00:00.000");
		this.setRvpStartDisplay("Jan 1, 2018 12:00 AM");
		this.setRvpEndUseval("2018-01-31T00:00:00.000");
		this.setRvpEndDisplay("Jan 31, 2018 12:00 AM");
	}

	
}
