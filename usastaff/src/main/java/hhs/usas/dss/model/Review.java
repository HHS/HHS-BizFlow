package hhs.usas.dss.model;

public class Review extends Report {
	
	public Review() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Review Data Self Service']");
		this.setIntgType("REVIEW");
		this.setFileName("ReviewDSS");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(3);
		this.setDateRange(-60);		
	}

}
