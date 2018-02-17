package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lst_VacancyRequest")		
public class VacancyRequest{
	
    private static final String INSERT_VACANCY_REQUEST = "INSERT INTO DSS_VACANCY_REQUEST(VACANCY_NUMBER, REQUEST_NUMBER, REQUEST_STATUS) VALUES (:VacancyNum, :RequestNum, :RequestStatus);";
	
	private Integer vacancyNum;
	private Integer requestNum;
	private String requestStatus;
	
	public VacancyRequest() {
		super();
	}
	
	public VacancyRequest(Integer vacancyNum, Integer requestNum, String requestStatus) {
		super();
		this.vacancyNum = vacancyNum;
		this.requestNum = requestNum;
		this.requestStatus = requestStatus;
	}
	
	public static String getInsertVacancyRequest() {
		return INSERT_VACANCY_REQUEST;
	}

	@XmlElement(name = "Vacancy__Number")
	public Integer getVacancyNum() {
		return vacancyNum;
	} 

	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}
	@XmlElement(name = "Request__Number")
	public Integer getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(Integer requestNum) {
		this.requestNum = requestNum;
	}
	@XmlElement(name = "Request__Status")
	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	
}