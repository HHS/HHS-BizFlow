package hhs.usas.dss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Credentials {

	private static String USERNAME;
	private static String PASSWORD;
	private static String NAMESPACE;
	private static String COGNOSURL;
	private static String FORMAT;
	
	
	@Value("${cognos.username}")
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public static String getUSERNAME() {
		return USERNAME;
	}
	@Value("${cognos.password}")
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public static String getPASSWORD() {
		return PASSWORD;
	}	
	@Value("${cognos.namespace}")
	public void setNAMESPACE(String nAMESPACE) {
		NAMESPACE = nAMESPACE;
	}
	public static String getNAMESPACE() {
		return NAMESPACE;
	}	
	@Value("${cognos.url}")
	public void setCOGNOSURL(String cOGNOSURL) {
		COGNOSURL = cOGNOSURL;
	}
	public static String getCOGNOSURL() {
		return COGNOSURL;
	}	
	@Value("${cognos.format}")
	public void setFORMAT(String fORMAT) {
		FORMAT = fORMAT;
	}
	public static String getFORMAT() {
		return FORMAT;
	}
	
}
