package gov.hhs.usas.rest.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class USASRequest
{
  @Value("${server.url}")
  private String serverURL;
  private String requestMethod;
  @Value("${request.user.agent.property}")
  private String userAgentProperty;
  @Value("${request.user.agent}")
  private String userAgent;
  @Value("${request.accept.language.property}")
  private String acceptLanguageProperty;
  @Value("${request.accept.language}")
  private String acceptLanguage;
  @Value("${request.content.type.property}")
  private String contentTypeProperty;
  @Value("${request.content.type}")
  private String contentType;
  private String POSTParameters;
  @Value("${request.cookie.property}")
  private String cookieProperty;
  private String cookie;
  
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
