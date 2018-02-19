package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lst_VacancyDocuments")		
public class VacancyDocuments{
	
	private static final String INSERT_VACANCY_DOCUMENT = "INSERT INTO DSS_VACANCY_DOCUMENT(VACANCY_NUMBER, SUPPORTING_DOC_TYPE, SUPPORTING_DOC_CUSTM_TITLE, REQUIRED_DOC) VALUES (:VacancyNum, :DocType, :DocTitle, :RequiredDoc)";
	
	private Integer vacancyNum;
	private String docType;
	private String docTitle;
	private String requiredDoc;
	
	public VacancyDocuments() {
		super();
	}
	
	public VacancyDocuments(Integer vacancyNum, String docType, String docTitle, String requiredDoc) {
		super();
		this.vacancyNum = vacancyNum;
		this.docType = docType;
		this.docTitle = docTitle;
		this.requiredDoc = requiredDoc;
	}
		
	public static String getInsertVacancyDocument() {
		return INSERT_VACANCY_DOCUMENT;
	}

	@XmlElement(name = "Vacancy__Number")
	public Integer getVacancyNum() {
		return vacancyNum;
	}

	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}
	@XmlElement(name = "Vacancy__Supporting__Document__Type")
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	@XmlElement(name = "Vacancy__Supporting__Document__Custom__Title")
	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	@XmlElement(name = "Vacancy__Required__Document")
	public String getRequiredDoc() {
		return requiredDoc;
	}

	public void setRequiredDoc(String requiredDoc) {
		this.requiredDoc = requiredDoc;
	}	
}