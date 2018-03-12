package hhs.usas.dss.model;

public class Vacancy extends Report{
	
	public Vacancy() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Vacancy Data Self Service']");
		this.setIntgType("VACANCY");
		this.setFileName("VacancyDSS");
		this.setParmNum(2);
		this.setSvpName("parm_StaffingDateType");
		this.setSvpUseval("VacancyLastUpdateDate");
		this.setSvpDisplay("Vacancy Last Update Date");
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(3);
		this.setDateRange(-60);		
	}

	
}
