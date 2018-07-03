package gov.hhs.usas.rest.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.report.service.Properties;

@Component
public class USASRequest
{
	@Autowired
	private Properties properties;
//  @Value("${server.url}")
  private String serverURL;
  private String requestMethod;
//  @Value("${request.user.agent.property}")
  private String userAgentProperty;
//  @Value("${request.user.agent}")
  private String userAgent;
//  @Value("${request.accept.language.property}")
  private String acceptLanguageProperty;
//  @Value("${request.accept.language}")
  private String acceptLanguage;
//  @Value("${request.content.type.property}")
  private String contentTypeProperty;
//  @Value("${request.content.type}")
  private String contentType;
  private String POSTParameters;
//  @Value("${request.cookie.property}")
  private String cookieProperty;
  private String cookie;
  
  
  
/*  public USASRequest() {
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
}*/

public String getServerURL()
  {
    return properties.getServerURL();
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
    return properties.getUserAgentProperty();
  }
  
  public String getUserAgent()
  {
    return properties.getUserAgent();
  }
  
  public String getAcceptLanguageProperty()
  {
    return properties.getAcceptLanguageProperty();
  }
  
  public String getAcceptLanguage()
  {
    return properties.getAcceptLanguage();
  }
  
  public String getContentTypeProperty()
  {
    return properties.getContentTypeProperty();
  }
  
  public String getContentType()
  {
    return properties.getContentType();
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
    return properties.getCookieProperty();
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
