package gov.hhs.usas.rest.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.report.service.Properties;

@Component
public class USASCredentials
{
	@Autowired
	private Properties properties;
	private String NameSpace;
	private String UserName;
	private String Password;

	@PostConstruct
	public void init(){	
		NameSpace = properties.getNameSpace();
		UserName = properties.getUserName();
		Password = properties.getPassword();
	}

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
