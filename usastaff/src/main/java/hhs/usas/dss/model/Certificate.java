package hhs.usas.dss.model;

public class Certificate extends Report {
	
	public Certificate() {
		super();
		this.setSearchPath("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Certificate Data Self Service']");
		this.setIntgType("CERTIFICATE");
		this.setFileName("CertificateDSS");
		this.setParmNum(2);
		this.setSvpName("parm_StaffingDateType");
		this.setSvpUseval("CertificateLastUpdateDate");
		this.setSvpDisplay("Certificate Last Update Date");
		this.setRvpName("parm_StaffingDateRange");
		this.setRptIteration(3);
		this.setDateRange(-60);		

	}

}
