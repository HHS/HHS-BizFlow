package gov.hhs.usas.rest.report.model.Recruitment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="USAStaffing_Recruitment")
public class USAStaffingRecruitmentResult
{
	@XmlAttribute(name="RequestNumber")
	@XmlID
	private String requestNumber;
	@XmlAttribute(name="VacancyCount")
	private int vacancyCount;
	@XmlAttribute(name="PositionCount")
	private int positionCount;
	@XmlElementWrapper(name="Vacancies")
	@XmlElement(name="Vacancy_Announcement")
	private List<VacancyAnnouncementResult> vacancyAnnouncementList;
	@XmlElement(name="Positions")
	private PositionsResult positions;
	@XmlElement(name="Result_Code")
	private String resultCode;
	@XmlElement(name="Failure_Message")
	private String failureMessage;

	public USAStaffingRecruitmentResult()
	{
		this.requestNumber = "";
		this.vacancyCount = 0;
		this.positionCount = 0;
		this.vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
		this.positions = new PositionsResult();
		this.resultCode = "";
		this.failureMessage = "";
	}

	public USAStaffingRecruitmentResult(String requestNumber, int vacancyCount, int positionCount, List<VacancyAnnouncementResult> vacancyAnnouncementList, PositionsResult positions)
	{
		this.requestNumber = requestNumber;
		this.vacancyCount = vacancyCount;
		this.positionCount = positionCount;
		this.vacancyAnnouncementList = vacancyAnnouncementList;
		this.positions = positions;
		this.resultCode = "Success";
		this.failureMessage = "";
	}

	public USAStaffingRecruitmentResult(String requestNumber, int vacancyCount, int positionCount,
			List<VacancyAnnouncementResult> vacancyAnnouncementList, PositionsResult positions, String resultCode,
			String failureMessage) {
		this.requestNumber = requestNumber;
		this.vacancyCount = vacancyCount;
		this.positionCount = positionCount;
		this.vacancyAnnouncementList = vacancyAnnouncementList;
		this.positions = positions;
		this.resultCode = resultCode;
		this.failureMessage = failureMessage;
	}

	public USAStaffingRecruitmentResult(String resultCode, String failureMessage) {
		this();
		this.resultCode = resultCode;
		this.failureMessage = failureMessage;
	}

	public String getRequestNumber()
	{
		return this.requestNumber;
	}

	public void setRequestNumber(String requestNumber)
	{
		this.requestNumber = requestNumber;
	}

	public int getVacancyCount()
	{
		return this.vacancyCount;
	}

	public void setVacancyCount(int vacancyCount)
	{
		this.vacancyCount = vacancyCount;
	}

	public int getPositionCount()
	{
		return this.positionCount;
	}

	public void setPositionCount(int positionCount)
	{
		this.positionCount = positionCount;
	}

	public List<VacancyAnnouncementResult> getVacancyAnnouncementList()
	{
		return this.vacancyAnnouncementList;
	}

	public void setVacancyAnnouncementList(List<VacancyAnnouncementResult> vacancyAnnouncementList)
	{
		this.vacancyAnnouncementList = vacancyAnnouncementList;
		setVacancyCount(vacancyAnnouncementList.size());
	}

	public PositionsResult getPositions()
	{
		return this.positions;
	}

	public void setPositions(PositionsResult positions)
	{
		this.positions = positions;
		setPositionCount(positions.getPositionList().size());
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	@Override
	public String toString()
	{
		return "requestNumber: " + getRequestNumber() + " vacancyCount: " + getVacancyCount() + " positionCount: " + getPositionCount() + " vacancyAnnouncementList: " + getVacancyAnnouncementList() + " positions: " + getPositions();
	}
}

