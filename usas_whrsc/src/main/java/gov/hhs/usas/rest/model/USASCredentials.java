package gov.hhs.usas.rest.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class USASCredentials
{
  @Value("${credentials.namespace}")
  private String NameSpace;
  @Value("${credentials.username}")
  private String UserName;
  @Value("${credentials.password}")
  private String Password;
  
  public String getNameSpace()
  {
    return this.NameSpace;
  }
  
  public String getUserName()
  {
    return this.UserName;
  }
  
  public String getPassword()
  {
    return this.Password;
  }
}
