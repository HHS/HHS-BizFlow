package gov.hhs.usas.rest.model;

import org.springframework.stereotype.Component;

@Component
public class Prompt
{
  private String id;
  private String useValue;
  private String displayValue;
  
  public Prompt() {
		this.id = "";
		this.useValue = "";
		this.displayValue = "";
	}
  
  public Prompt(String id, String useValue, String displayValue) {
	this.id = id;
	this.useValue = useValue;
	this.displayValue = displayValue;
}

public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getUseValue()
  {
    return this.useValue;
  }
  
  public void setUseValue(String useValue)
  {
    this.useValue = useValue;
  }
  
  public String getDisplayValue()
  {
    return this.displayValue;
  }
  
  public void setDisplayValue(String displayValue)
  {
    this.displayValue = displayValue;
  }
}
