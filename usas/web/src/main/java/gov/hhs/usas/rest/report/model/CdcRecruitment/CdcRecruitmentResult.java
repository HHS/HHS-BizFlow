package gov.hhs.usas.rest.report.model.CdcRecruitment;

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
@XmlRootElement(name="CDC_Recruitment")
public class CdcRecruitmentResult {

	@XmlAttribute(name="RequestNumber")
	@XmlID
	private String requestNumber;
	@XmlAttribute(name="VacancyCount")
	private int vacancyCount;
	@XmlElementWrapper(name="Vacancies")
	@XmlElement(name="record")
	private List<VacancyResult> vacancyList;
	@XmlElement(name="Result_Code")
	private String resultCode;
	@XmlElement(name="Failure_Message")
	private String failureMessage;
	
	public CdcRecruitmentResult() {
		this.requestNumber = "";
		this.vacancyCount = 0;
		this.vacancyList = new ArrayList<VacancyResult>();
		this.resultCode = "";
		this.failureMessage = "";
	}
	
	public CdcRecruitmentResult(String requestNumber, int vacancyCount, List<VacancyResult> vacancyList)
	{
		this.requestNumber = requestNumber;
		this.vacancyCount = vacancyCount;
		this.vacancyList = vacancyList;
		this.resultCode = "Success";
		this.failureMessage = "";
	}
	
	public CdcRecruitmentResult(String requestNumber, int vacancyCount,
			List<VacancyResult> vacancyList, String resultCode,
			String failureMessage) {
		this.requestNumber = requestNumber;
		this.vacancyCount = vacancyCount;
		this.vacancyList = vacancyList;
		this.resultCode = resultCode;
		this.failureMessage = failureMessage;
	}
	
	public CdcRecruitmentResult(String resultCode, String failureMessage) {
		this();
		this.resultCode = resultCode;
		this.failureMessage = failureMessage;
	}
	
	public CdcRecruitmentResult(String requestNumber, String resultCode, String failureMessage) {
		this();
		this.requestNumber = requestNumber;
		this.resultCode = resultCode;
		this.failureMessage = failureMessage;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public int getVacancyCount() {
		return vacancyCount;
	}

	public void setVacancyCount(int vacancyCount) {
		this.vacancyCount = vacancyCount;
	}

	public List<VacancyResult> getVacancyList() {
		return vacancyList;
	}

	public void setVacancyList(List<VacancyResult> vacancyList) {
		this.vacancyList = vacancyList;
		setVacancyCount(vacancyList.size());
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
	public String toString() {
		return "CdcRecruitmentResult [requestNumber=" + requestNumber + ", vacancyCount=" + vacancyCount
				+ ", vacancyList=" + vacancyList + ", resultCode=" + resultCode
				+ ", failureMessage=" + failureMessage + "]";
	}

}
