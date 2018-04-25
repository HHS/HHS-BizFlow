package gov.hhs.usas.rest.model;

import org.springframework.stereotype.Component;

@Component
public class USASResponse
{
  private int responseCode;
  private String errorMessage;
  private String xmlResponse;
  
  public USASResponse() {
	this.responseCode = 0;
	this.errorMessage = "";
	this.xmlResponse = "";
}

public int getResponseCode()
  {
    return this.responseCode;
  }
  
  public void setResponseCode(int responseCode)
  {
    this.responseCode = responseCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public void setErrorMessage(String errorMessage)
  {
    this.errorMessage = errorMessage;
  }
  
  public String getResponse()
  {
    return this.xmlResponse;
  }
  
  public void setResponse(String responseXML)
  {
    this.xmlResponse = responseXML;
  }
}
