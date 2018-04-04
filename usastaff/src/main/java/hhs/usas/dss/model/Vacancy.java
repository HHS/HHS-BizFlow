package hhs.usas.dss.model;

import org.springframework.beans.factory.annotation.Value;

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
		this.setRptIteration(1);
		this.setDateIncrement(-45);
		this.setEndDate(""); //01/01/2015
		this.setSpTruncate("SP_TRUNC_VACANCY_TABLE");
		this.setRunReport(true);
	}

	
}
