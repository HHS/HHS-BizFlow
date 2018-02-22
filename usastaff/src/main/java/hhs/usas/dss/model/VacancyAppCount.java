package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lst_VacancyApplicationCount")		
public class VacancyAppCount{
	
	private static final String INSERT_VACANCY_APP_CNT = "INSERT INTO DSS_VACANCY_APP_CNT(VACANCY_NUMBER, APPLICATION_CNT) VALUES (:VacancyNum, :AppCount)";
	
	private Integer vacancyNum;
	private Integer appCount;
	
	public VacancyAppCount() {
		super();
	}
	
	public VacancyAppCount(Integer vacancyNum, Integer appCount) {
		super();
		this.vacancyNum = vacancyNum;
		this.appCount = appCount;
	}
		
	public static String getInsertVacancyAppCnt() {
		return INSERT_VACANCY_APP_CNT;
	}

	@XmlElement(name = "Vacancy__Number")
	public Integer getVacancyNum() {
		return vacancyNum;
	}

	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}
	@XmlElement(name = "Count__of__Applications")
	public Integer getAppCount() {
		return appCount;
	}

	public void setAppCount(Integer appCount) {
		this.appCount = appCount;
	}

}