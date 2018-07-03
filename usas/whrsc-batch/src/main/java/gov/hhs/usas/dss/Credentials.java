package gov.hhs.usas.dss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Credentials {

/*	private static String USERNAME;
	private static String PASSWORD;
	private static String NAMESPACE;
	private static String COGNOSURL;
	private static String FORMAT;*/
	
	private String USERNAME;
	private String PASSWORD;
	private String NAMESPACE;
	private String COGNOSURL;
	private String FORMAT;
	
	
	public Credentials() {
/*		COGNOSURL="https://data.stage.usastaffing.gov/ibmcognos/bi/v1/disp";
		NAMESPACE="DSS_CAP";
		USERNAME="stagedssihsdev1";
		PASSWORD="$tageDS$D@vihs8361";
		FORMAT="DataSet";*/
	}
	@Value("${cognos.username}")
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	@Value("${cognos.password}")
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}	
	@Value("${cognos.namespace}")
	public void setNAMESPACE(String nAMESPACE) {
		NAMESPACE = nAMESPACE;
	}
	public String getNAMESPACE() {
		return NAMESPACE;
	}	
	@Value("${cognos.url}")
	public void setCOGNOSURL(String cOGNOSURL) {
		COGNOSURL = cOGNOSURL;
	}
	public String getCOGNOSURL() {
		return COGNOSURL;
	}	
	@Value("${cognos.format}")
	public void setFORMAT(String fORMAT) {
		FORMAT = fORMAT;
	}
	public String getFORMAT() {
		return FORMAT;
	}
	
}
