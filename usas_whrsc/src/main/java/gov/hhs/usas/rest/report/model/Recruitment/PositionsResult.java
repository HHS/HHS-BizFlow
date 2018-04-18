package gov.hhs.usas.rest.report.model.Recruitment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PositionsResult
{
  @XmlAttribute(name="PositionCount")
  private int positionCount;
  @XmlElement(name="Number_Of_Positions_To_Be_Advertised")
  private String numberOfPositionsToBeAdvertised;
  @XmlElement(name="Clearance_Level_Required_For_Position")
  private String clearanceLevelRequiredForPosition;
  @XmlElement(name="Position")
  private List<PositionResult> positionList;
  
  public PositionsResult()
  {
    this.positionCount = 0;
    this.numberOfPositionsToBeAdvertised = "";
    this.clearanceLevelRequiredForPosition = "";
    this.positionList = new ArrayList<PositionResult>();
  }
  
  public PositionsResult(int positionCount, String numberOfPositionsToBeAdvertised, String clearanceLevelRequiredForPosition, List<PositionResult> positionList)
  {
    this.positionCount = positionCount;
    this.numberOfPositionsToBeAdvertised = numberOfPositionsToBeAdvertised;
    this.clearanceLevelRequiredForPosition = clearanceLevelRequiredForPosition;
    this.positionList = positionList;
  }
  
  public int getPositionCount()
  {
    return this.positionCount;
  }
  
  public void setPositionCount(int positionCount)
  {
    this.positionCount = positionCount;
  }
  
  public String getNumberOfPositionsToBeAdvertised()
  {
    return this.numberOfPositionsToBeAdvertised;
  }
  
  public void setNumberOfPositionsToBeAdvertised(String numberOfPositionsToBeAdvertised)
  {
    this.numberOfPositionsToBeAdvertised = numberOfPositionsToBeAdvertised;
  }
  
  public String getClearanceLevelRequiredForPosition()
  {
    return this.clearanceLevelRequiredForPosition;
  }
  
  public void setClearanceLevelRequiredForPosition(String clearanceLevelRequiredForPosition)
  {
    this.clearanceLevelRequiredForPosition = clearanceLevelRequiredForPosition;
  }
  
  public List<PositionResult> getPositionList()
  {
    return this.positionList;
  }
  
  public void setPositionList(List<PositionResult> positionList)
  {
    this.positionList = positionList;
  }
  
  public void addPosition(PositionResult newPosition)
  {
    if (!this.positionList.contains(newPosition))
    {
      this.positionList.add(newPosition);
      this.positionCount += 1;
    }
  }
  
  @Override
public String toString()
  {
    return " positionCount: " + getPositionCount() + " numberOfPositionsToBeAdvertised: " + getNumberOfPositionsToBeAdvertised() + " clearanceLevelRequiredForPosition: " + getClearanceLevelRequiredForPosition() + " positions: " + getPositionList();
  }
}

