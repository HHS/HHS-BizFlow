package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lst_VacancySpecialty")	
public class VacancySpecialty{
	
	private static final String INSERT_VACANCY_SPECIALTY = "INSERT INTO DSS_VACANCY_SPECIALTY(VACANCY_NUMBER, SPECIALTY) VALUES (:VacancyNum, :VacancySpecialty)";
	
	private Integer vacancyNum;
	private String vacancySpecialty;
	
	public VacancySpecialty() {
		super();
	}
	
	public VacancySpecialty(Integer vacancyNum, String vacancySpecialty) {
		super();
		this.vacancyNum = vacancyNum;
		this.vacancySpecialty = vacancySpecialty;
	}
	
	public static String getInsertVacancySpecialty() {
		return INSERT_VACANCY_SPECIALTY;
	}

	@XmlElement(name = "Vacancy__Number")
	public Integer getVacancyNum() {
		return vacancyNum;
	}

	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}
	@XmlElement(name = "Vacancy__Specialty")
	public String getVacancySpecialty() {
		return vacancySpecialty;
	}

	public void setVacancySpecialty(String vacancySpecialty) {
		this.vacancySpecialty = vacancySpecialty;
	}
	
}