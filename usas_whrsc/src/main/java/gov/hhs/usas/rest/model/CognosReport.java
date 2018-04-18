package gov.hhs.usas.rest.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CognosReport
{
  private String name;
  private String id;
  private String format;
  @Autowired
  private Prompt prompt;
  
  public CognosReport() {
		this.name = "";
		this.id = "";
		this.format = "";
		this.prompt = new Prompt();
	}
  
  public CognosReport(String name, String id, String format, Prompt prompt) {
	this.name = name;
	this.id = id;
	this.format = format;
	this.prompt = prompt;
}

public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public void setFormat(String format)
  {
    this.format = format;
  }
  
  public Prompt getPrompt()
  {
    return this.prompt;
  }
  
  public void setPrompt(Prompt prompt)
  {
    this.prompt = prompt;
  }
}
