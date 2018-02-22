package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lst_VacancyEligibility")
public class VacancyEligibility{
	
	private static final String INSERT_VACANCY_ELIGIBILITY = "INSERT INTO DSS_VACANCY_ELIGIBILITY(VACANCY_NUMBER, ELIGIBILITY, ELIGIBILITY_LABEL) VALUES (:VacancyNum, :Eligib, :EligibLabel)";
	
	private Integer vacancyNum;
	private String eligib;
	private String eligibLabel;
	
	public static String getInsertVacancyEligibility() {
		return INSERT_VACANCY_ELIGIBILITY;
	}
	
	public VacancyEligibility() {
		super();
	}
	
	public VacancyEligibility(Integer vacancyNum, String eligib, String eligibLabel) {
		super();
		this.vacancyNum = vacancyNum;
		this.eligib = eligib;
		this.eligibLabel = eligibLabel;
	}
	@XmlElement(name = "Vacancy__Number")
	public Integer getVacancyNum() {
		return vacancyNum;
	}

	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}
	@XmlElement(name = "Vacancy__Eligibility")
	public String getEligib() {
		return eligib;
	}

	public void setEligib(String eligib) {
		this.eligib = eligib;
	}
	@XmlElement(name = "Vacancy__Eligibility__Label")
	public String getEligibLabel() {
		return eligibLabel;
	}

	public void setEligibLabel(String eligibLabel) {
		this.eligibLabel = eligibLabel;
	}	
	
}