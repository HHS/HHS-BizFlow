package hhs.usas.dss.model;

public class TimeToOffer extends Report {

	public TimeToOffer() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/folder[@name='HHS']/folder[@name='Organization Shared']/folder[@name='Centers for Medicare and Medicaid Services']/folder[@name='Custom DSS']/report[@name='Time to Offer']");
		this.setIntgType("TIME2OFFER");
		this.setFileName("TimeToOffer");
		this.setParmNum(1);
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(1);
		this.setDateIncrement(-365);
		this.setEndDate("10/01/2016");
		this.setSpTruncate("SP_TRUNC_TIME2OFFER_TABLE");
	}

}
