package hhs.usas.dss.model;

public class Announcement extends Report {
	
	public Announcement() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Announcement Data Self Service']");
		this.setIntgType("ANNOUNCEMENT");
		this.setFileName("AnnouncementDSS");
		this.setParmNum(2);
		this.setSvpName("parm_StaffingDateType");
		this.setSvpUseval("Announcement Last Update");
		this.setSvpDisplay("Announcement Last Update");
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(3);
		this.setDateRange(-60);
	}
	
}
