package gov.hhs.usas.rest.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.report.service.Properties;

@Component
public class USASRequest
{
	@Autowired
	private Properties properties;
  private String serverURL;
  private String requestMethod;
  private String userAgentProperty;
  private String userAgent;
  private String acceptLanguageProperty;
  private String acceptLanguage;
  private String contentTypeProperty;
  private String contentType;
  private String POSTParameters;
  private String cookieProperty;
  private String cookie;
  
  @PostConstruct
	public void init(){	
	  this.serverURL = properties.getServerURL();
		this.requestMethod = "";
		this.userAgentProperty = properties.getUserAgentProperty();
		this.userAgent = properties.getUserAgent();
		this.acceptLanguageProperty = properties.getAcceptLanguageProperty();
		this.acceptLanguage = properties.getAcceptLanguage();
		this.contentTypeProperty = properties.getContentTypeProperty();
		this.contentType = properties.getContentType();
		this.POSTParameters = "";
		this.cookieProperty = properties.getCookieProperty();
		this.cookie = "";
	}
  

public String getServerURL()
  {
    return this.serverURL;
  }
  
  public String getRequestMethod()
  {
    return this.requestMethod;
  }
  
  public void setRequestMethod(String requestMethod)
  {
    this.requestMethod = requestMethod;
  }
  
  public String getUserAgentProperty()
  {
    return this.userAgentProperty;
  }
  
  public String getUserAgent()
  {
    return this.userAgent;
  }
  
  public String getAcceptLanguageProperty()
  {
    return this.acceptLanguageProperty;
  }
  
  public String getAcceptLanguage()
  {
    return this.acceptLanguage;
  }
  
  public String getContentTypeProperty()
  {
    return this.contentTypeProperty;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public String getPOSTParameters()
  {
    return this.POSTParameters;
  }
  
  public void setPOSTParameters(String xmlDataTemplate, USASCredentials credentials)
  {
    String xmlData = xmlDataTemplate.replace("NAMESPACE_PLACEHOLDER", credentials.getNameSpace()).replace("USERNAME_PLACEHOLDER", credentials.getUserName()).replace("PASSWORD_PLACEHOLDER", credentials.getPassword());
    this.POSTParameters = ("xmlData=" + xmlData);
  }
  
  public void setPOSTParameters(String xmlDataTemplate, Prompt reportPrompt)
  {
    String xmlData = xmlDataTemplate.replace("PROMPT_ID", reportPrompt.getId()).replace("USE_VALUE", reportPrompt.getUseValue()).replace("DISPLAY_VALUE", reportPrompt.getDisplayValue());
    this.POSTParameters = ("fmt=dataset&xmlData=" + xmlData);
  }
  
  public String getCookieProperty()
  {
    return this.cookieProperty;
  }
  
  public String getCookie()
  {
    return this.cookie;
  }
  
  public void setCookie(String cookie)
  {
    this.cookie = cookie;
  }
}
