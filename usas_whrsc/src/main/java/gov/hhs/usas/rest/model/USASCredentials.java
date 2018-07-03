package gov.hhs.usas.rest.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.report.service.Properties;

@Component
public class USASCredentials
{
	@Autowired
	private Properties properties;
//  @Value("${credentials.namespace}")
  private String NameSpace;
//  @Value("${credentials.username}")
  private String UserName;
//  @Value("${credentials.password}")
  private String Password;
  
  
  
/*  public USASCredentials() {
	NameSpace = properties.getNameSpace();
	UserName = properties.getUserName();
	Password = properties.getPassword();
}*/

public String getNameSpace()
  {
    return properties.getNameSpace();
  }
  
  public String getUserName()
  {
    return properties.getUserName();
  }
  
  public String getPassword()
  {
    return properties.getPassword();
  }
}
