package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lst_VacancyPosition")	
public class VacancyPosition{
	
    private static final String INSERT_VACANCY_POSITION = "INSERT INTO DSS_VACANCY_POSITION(VACANCY_NUMBER, POSITION_DESCRIPTION, POSITION_DESCRIPTION_TITLE) VALUES (:VacancyNum, :PosDesc, :PosDescTitle);";
	
	private Integer vacancyNum;
	private String posDesc;
	private String posDescTitle;
		
	public VacancyPosition() {
		super();
	}

	public VacancyPosition(Integer vacancyNum, String posDesc, String posDescTitle) {
		super();
		this.vacancyNum = vacancyNum;
		this.posDesc = posDesc;
		this.posDescTitle = posDescTitle;
	}

	public static String getInsertVacancyPosition() {
		return INSERT_VACANCY_POSITION;
	}
	@XmlElement(name = "Vacancy__Number")	
	public Integer getVacancyNum() {
		return vacancyNum;
	}

	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}
	@XmlElement(name = "Vacancy__Position__Description__Numbe")	
	public String getPosDesc() {
		return posDesc;
	}

	public void setPosDesc(String posDesc) {
		this.posDesc = posDesc;
	}
	@XmlElement(name = "Vacancy__Position__Description__Title")	
	public String getPosDescTitle() {
		return posDescTitle;
	}

	public void setPosDescTitle(String posDescTitle) {
		this.posDescTitle = posDescTitle;
	}
	
}