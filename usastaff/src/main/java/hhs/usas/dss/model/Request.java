package hhs.usas.dss.model;

public class Request extends Report {

	public Request() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Request Data Self Service']");
		this.setIntgType("REQUEST");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRvpStartUseval("2018-01-01T00:00:00.000");
		this.setRvpStartDisplay("Jan 1, 2018 12:00 AM");
		this.setRvpEndUseval("2018-01-31T00:00:00.000");
		this.setRvpEndDisplay("Jan 31, 2018 12:00 AM");
	}

	
}
