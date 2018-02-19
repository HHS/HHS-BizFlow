package hhs.usas.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lst_VacancyCustomer")
public class VacancyCustomer{

	private static final String INSERT_VACANCY_CUSTOMER = "INSERT INTO DSS_VACANCY_CUSTOMER(VACANCY_NUMBER, CUSTOMER_NAME, DEPARTMENT_NAME, DEPARTMENT_CODE, AGENCY_NAME, AGENCY_CODE) VALUES (:VacancyNum, :CustomerName, :DeptName, :DeptCode, :AgencyName, :AgencyCode)";

	private Integer vacancyNum;
	private String customerName;
	private String deptName;
	private String deptCode;
	private String agencyName;
	private String agencyCode;
	
	public VacancyCustomer() {
		super();
	}
	
	public VacancyCustomer(Integer vacancyNum, String customerName, String deptName, String deptCode,
			String agencyName, String agencyCode) {
		super();
		this.vacancyNum = vacancyNum;
		this.customerName = customerName;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.agencyName = agencyName;
		this.agencyCode = agencyCode;
	}
	
	public static String getInsertVacancyCustomer() {
		return INSERT_VACANCY_CUSTOMER;
	}

	@XmlElement(name = "Vacancy__Number")
	public Integer getVacancyNum() {
		return vacancyNum;
	}

	public void setVacancyNum(Integer vacancyNum) {
		this.vacancyNum = vacancyNum;
	}

	@XmlElement(name = "Vacancy__Customer__Name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@XmlElement(name = "Vacancy__Customer__Department__Name")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@XmlElement(name = "Vacancy__Customer__Department__Code")
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@XmlElement(name = "Vacancy__Customer__Agency__Name")
	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	@XmlElement(name = "Vacancy__Customer__Agency__Code")
	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	
}
