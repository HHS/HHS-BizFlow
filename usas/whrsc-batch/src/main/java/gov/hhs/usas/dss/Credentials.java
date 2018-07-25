package gov.hhs.usas.dss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class Credentials {
	
	@Value("${cognos.username}")
	private String USERNAME;
	
	@Value("${cognos.password}")
	private String PASSWORD;
	
	@Value("${cognos.namespace}")
	private String NAMESPACE;
	
	@Value("${cognos.url}")
	private String COGNOSURL;
	
	@Value("${cognos.format}")
	private String FORMAT;
	
	
	public Credentials() {

	}
	
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}	
	
	public void setNAMESPACE(String nAMESPACE) {
		NAMESPACE = nAMESPACE;
	}
	public String getNAMESPACE() {
		return NAMESPACE;
	}	
	
	public void setCOGNOSURL(String cOGNOSURL) {
		COGNOSURL = cOGNOSURL;
	}
	public String getCOGNOSURL() {
		return COGNOSURL;
	}	
	
	public void setFORMAT(String fORMAT) {
		FORMAT = fORMAT;
	}
	public String getFORMAT() {
		return FORMAT;
	}
	
}
