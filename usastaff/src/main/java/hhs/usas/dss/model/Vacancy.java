package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataSet")
public class Vacancy {
	
	//Vacancy Report Classes
	private VacancyDetail vacancyDetail;
	private VacancyCustomer vacancyCustomer;
	private VacancyEligibility vacancyEligibility;
	private VacancyPosition vacancyPosition;
	private VacancySpecialty vacancySpecialty;
	private VacancyDocuments vacancyDocuments;
	private VacancyRequest vacancyRequest;
	private VacancyAppCount vacancyAppCount;

	//Vacancy Report Search Path
	private static String SEARCH_PATH = "/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Vacancy Data Self Service']";
	
	//Staffing Date Type Prompt
	private static String SVP_NAME ="parm_StaffingDateType";
	private static String SVP_USEVAL="VacancyLastUpdateDate";
	private static String SVP_DISPLAY="Vacancy Last Update Date";
	
	//Staffing Date Range Prompt
	private static String RVP_NAME="parm_StaffingDateRange";
	private static String RVP_START_USEVAL="2018-01-01T00:00:00.000";
	private static String RVP_START_DISPLAY="Jan 1, 2018 12:00 AM";
	private static String RVP_END_USEVAL="2018-01-31T00:00:00.000";
	private static String RVP_END_DISPLAY="Jan 31, 2018 12:00 AM";
	
	private static String fileName = "VacancyDSS";
	
	private static int parmNum = 2;
		
	public VacancyDetail getVacancyDetail() {
		return vacancyDetail;
	}

	public void setVacancyDetail(VacancyDetail vacancyDetail) {
		this.vacancyDetail = vacancyDetail;
	}

	public VacancyCustomer getVacancyCustomer() {
		return vacancyCustomer;
	}

	public void setVacancyCustomer(VacancyCustomer vacancyCustomer) {
		this.vacancyCustomer = vacancyCustomer;
	}

	public VacancyEligibility getVacancyEligibility() {
		return vacancyEligibility;
	}

	public void setVacancyEligibility(VacancyEligibility vacancyEligibility) {
		this.vacancyEligibility = vacancyEligibility;
	}

	public VacancyPosition getVacancyPosition() {
		return vacancyPosition;
	}

	public void setVacancyPosition(VacancyPosition vacancyPosition) {
		this.vacancyPosition = vacancyPosition;
	}

	public VacancySpecialty getVacancySpecialty() {
		return vacancySpecialty;
	}

	public void setVacancySpecialty(VacancySpecialty vacancySpecialty) {
		this.vacancySpecialty = vacancySpecialty;
	}

	public VacancyDocuments getVacancyDocuments() {
		return vacancyDocuments;
	}

	public void setVacancyDocuments(VacancyDocuments vacancyDocuments) {
		this.vacancyDocuments = vacancyDocuments;
	}

	public VacancyRequest getVacancyRequest() {
		return vacancyRequest;
	}

	public void setVacancyRequest(VacancyRequest vacancyRequest) {
		this.vacancyRequest = vacancyRequest;
	}

	public VacancyAppCount getVacancyAppCount() {
		return vacancyAppCount;
	}

	public void setVacancyAppCount(VacancyAppCount vacancyAppCount) {
		this.vacancyAppCount = vacancyAppCount;
	}
	
	public static String getSEARCH_PATH() {
		return SEARCH_PATH;
	}

	public static void setSEARCH_PATH(String sEARCH_PATH) {
		SEARCH_PATH = sEARCH_PATH;
	}

	public static String getSVP_NAME() {
		return SVP_NAME;
	}

	public static void setSVP_NAME(String sVP_NAME) {
		SVP_NAME = sVP_NAME;
	}

	public static String getSVP_USEVAL() {
		return SVP_USEVAL;
	}

	public static void setSVP_USEVAL(String sVP_USEVAL) {
		SVP_USEVAL = sVP_USEVAL;
	}

	public static String getSVP_DISPLAY() {
		return SVP_DISPLAY;
	}

	public static void setSVP_DISPLAY(String sVP_DISPLAY) {
		SVP_DISPLAY = sVP_DISPLAY;
	}

	public static String getRVP_NAME() {
		return RVP_NAME;
	}

	public static void setRVP_NAME(String rVP_NAME) {
		RVP_NAME = rVP_NAME;
	}

	public static String getRVP_START_USEVAL() {
		return RVP_START_USEVAL;
	}

	public static void setRVP_START_USEVAL(String rVP_START_USEVAL) {
		RVP_START_USEVAL = rVP_START_USEVAL;
	}

	public static String getRVP_START_DISPLAY() {
		return RVP_START_DISPLAY;
	}

	public static void setRVP_START_DISPLAY(String rVP_START_DISPLAY) {
		RVP_START_DISPLAY = rVP_START_DISPLAY;
	}

	public static String getRVP_END_USEVAL() {
		return RVP_END_USEVAL;
	}

	public static void setRVP_END_USEVAL(String rVP_END_USEVAL) {
		RVP_END_USEVAL = rVP_END_USEVAL;
	}

	public static String getRVP_END_DISPLAY() {
		return RVP_END_DISPLAY;
	}

	public static void setRVP_END_DISPLAY(String rVP_END_DISPLAY) {
		RVP_END_DISPLAY = rVP_END_DISPLAY;
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		Vacancy.fileName = fileName;
	}
	
	public static int getParmNum() {
		return parmNum;
	}

	public static void setParmNum(int parmNum) {
		Vacancy.parmNum = parmNum;
	}

	public Vacancy() {
		super();
	}

	public Vacancy(VacancyDetail vacancyDetail, VacancyCustomer vacancyCustomer, VacancyEligibility vacancyEligibility,
			VacancyPosition vacancyPosition, VacancySpecialty vacancySpecialty, VacancyDocuments vacancyDocuments,
			VacancyRequest vacancyRequest, VacancyAppCount vacancyAppCount) {
		super();
		this.vacancyDetail = vacancyDetail;
		this.vacancyCustomer = vacancyCustomer;
		this.vacancyEligibility = vacancyEligibility;
		this.vacancyPosition = vacancyPosition;
		this.vacancySpecialty = vacancySpecialty;
		this.vacancyDocuments = vacancyDocuments;
		this.vacancyRequest = vacancyRequest;
		this.vacancyAppCount = vacancyAppCount;
	}
	
}
