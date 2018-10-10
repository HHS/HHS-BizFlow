package gov.hhs.batch.biis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:biis.properties")
public class BIISProperties {

	//Interface Name
	@Value("${biis.interface.name}")
	private String biisInterfaceName;
	
	//Log File Name
	@Value("${biis.log.name}")
	private String biisLogFileName;
	
	//Module Status
	@Value("${module.off}")
	private String moduleOffStatus;
	@Value("${module.success}")
	private String moduleSuccessStatus;
	@Value("${module.error}")
	private String moduleErrorStatus;
	
	//Module Names
	@Value("${biis.person.name}")
	private String biisPersonName;
	@Value("${biis.refData.name}")
	private String biisRefDataName;
	@Value("${ehrp.refData.name}")
	private String ehrpRefDataName;
	
	//Email Message Configurations
	@Value("${biis.email.html.style}")
	private String emailHtmlStyle;
	@Value("${biis.email.html.header}")
	private String emailHtmlHeader;
	@Value("${biis.email.html.columnh1}")
	private String emailHtmlColumnH1;
	@Value("${biis.email.html.columnh2}")
	private String emailHtmlColumnH2;

	//Run PL/SQL Function- True or False
	@Value("${import.biis.person}")
	private String importBiisPerson;
	@Value("${import.biis.ref.data}")
	private String importBiisRefData;
	@Value("${import.ehrp.ref.data}")
	private String importEhrpRefData;

	//PL/SQL Stored Function properties
	@Value("${plsql.employee.catalog}")
	private String plsqlEmployeeCatalog;
	@Value("${plsql.employee.schema}")
	private String plsqlEmployeeSchema;
	@Value("${plsql.employee.function}")
	private String plsqlEmployeeFunction;
	
	@Value("${plsql.biis.refdata.catalog}")
	private String plsqlBiisRefDataCatalog;
	@Value("${plsql.biis.refdata.schema}")
	private String plsqlBiisRefDataSchema;
	@Value("${plsql.biis.refdata.function}")
	private String plsqBiisRefDataFunction;

	@Value("${plsql.ehrp.refdata.catalog}")
	private String plsqlEhrpRefDataCatalog;
	@Value("${plsql.ehrp.refdata.schema}")
	private String plsqlEhrpRefDataSchema;
	@Value("${plsql.ehrp.refdata.function}")
	private String plsqEhrpRefDataFunction;

	public String getBiisInterfaceName() {
		return biisInterfaceName;
	}
	public void setBiisInterfaceName(String biisInterfaceName) {
		this.biisInterfaceName = biisInterfaceName;
	}
	public String getBiisLogFileName() {
		return biisLogFileName;
	}
	public void setBiisLogFileName(String biisLogFileName) {
		this.biisLogFileName = biisLogFileName;
	}
	public String getModuleOffStatus() {
		return moduleOffStatus;
	}
	public void setModuleOffStatus(String moduleOffStatus) {
		this.moduleOffStatus = moduleOffStatus;
	}
	public String getModuleSuccessStatus() {
		return moduleSuccessStatus;
	}
	public void setModuleSuccessStatus(String moduleSuccessStatus) {
		this.moduleSuccessStatus = moduleSuccessStatus;
	}
	public String getModuleErrorStatus() {
		return moduleErrorStatus;
	}
	public void setModuleErrorStatus(String moduleErrorStatus) {
		this.moduleErrorStatus = moduleErrorStatus;
	}
	public String getBiisPersonName() {
		return biisPersonName;
	}
	public void setBiisPersonName(String biisPersonName) {
		this.biisPersonName = biisPersonName;
	}
	public String getBiisRefDataName() {
		return biisRefDataName;
	}
	public void setBiisRefDataName(String biisRefDataName) {
		this.biisRefDataName = biisRefDataName;
	}
	public String getEhrpRefDataName() {
		return ehrpRefDataName;
	}
	public void setEhrpRefDataName(String ehrpRefDataName) {
		this.ehrpRefDataName = ehrpRefDataName;
	}
	public String getEmailHtmlStyle() {
		return emailHtmlStyle;
	}
	public void setEmailHtmlStyle(String emailHtmlStyle) {
		this.emailHtmlStyle = emailHtmlStyle;
	}
	public String getEmailHtmlHeader() {
		return emailHtmlHeader;
	}
	public void setEmailHtmlHeader(String emailHtmlHeader) {
		this.emailHtmlHeader = emailHtmlHeader;
	}
	public String getEmailHtmlColumnH1() {
		return emailHtmlColumnH1;
	}
	public void setEmailHtmlColumnH1(String emailHtmlColumnH1) {
		this.emailHtmlColumnH1 = emailHtmlColumnH1;
	}
	public String getEmailHtmlColumnH2() {
		return emailHtmlColumnH2;
	}
	public void setEmailHtmlColumnH2(String emailHtmlColumnH2) {
		this.emailHtmlColumnH2 = emailHtmlColumnH2;
	}
	public String getImportBiisPerson() {
		return importBiisPerson;
	}
	public void setImportBiisPerson(String importBiisPerson) {
		this.importBiisPerson = importBiisPerson;
	}
	public String getImportBiisRefData() {
		return importBiisRefData;
	}
	public void setImportBiisRefData(String importBiisRefData) {
		this.importBiisRefData = importBiisRefData;
	}
	public String getImportEhrpRefData() {
		return importEhrpRefData;
	}
	public void setImportEhrpRefData(String importEhrpRefData) {
		this.importEhrpRefData = importEhrpRefData;
	}
	public String getPlsqlEmployeeCatalog() {
		return plsqlEmployeeCatalog;
	}
	public void setPlsqlEmployeeCatalog(String plsqlEmployeeCatalog) {
		this.plsqlEmployeeCatalog = plsqlEmployeeCatalog;
	}
	public String getPlsqlEmployeeSchema() {
		return plsqlEmployeeSchema;
	}
	public void setPlsqlEmployeeSchema(String plsqlEmployeeSchema) {
		this.plsqlEmployeeSchema = plsqlEmployeeSchema;
	}
	public String getPlsqlEmployeeFunction() {
		return plsqlEmployeeFunction;
	}
	public void setPlsqlEmployeeFunction(String plsqlEmployeeFunction) {
		this.plsqlEmployeeFunction = plsqlEmployeeFunction;
	}
	public String getPlsqlBiisRefDataCatalog() {
		return plsqlBiisRefDataCatalog;
	}
	public void setPlsqlBiisRefDataCatalog(String plsqlBiisRefDataCatalog) {
		this.plsqlBiisRefDataCatalog = plsqlBiisRefDataCatalog;
	}
	public String getPlsqlBiisRefDataSchema() {
		return plsqlBiisRefDataSchema;
	}
	public void setPlsqlBiisRefDataSchema(String plsqlBiisRefDataSchema) {
		this.plsqlBiisRefDataSchema = plsqlBiisRefDataSchema;
	}
	public String getPlsqBiisRefDataFunction() {
		return plsqBiisRefDataFunction;
	}
	public void setPlsqBiisRefDataFunction(String plsqBiisRefDataFunction) {
		this.plsqBiisRefDataFunction = plsqBiisRefDataFunction;
	}
	public String getPlsqlEhrpRefDataCatalog() {
		return plsqlEhrpRefDataCatalog;
	}
	public void setPlsqlEhrpRefDataCatalog(String plsqlEhrpRefDataCatalog) {
		this.plsqlEhrpRefDataCatalog = plsqlEhrpRefDataCatalog;
	}
	public String getPlsqlEhrpRefDataSchema() {
		return plsqlEhrpRefDataSchema;
	}
	public void setPlsqlEhrpRefDataSchema(String plsqlEhrpRefDataSchema) {
		this.plsqlEhrpRefDataSchema = plsqlEhrpRefDataSchema;
	}
	public String getPlsqEhrpRefDataFunction() {
		return plsqEhrpRefDataFunction;
	}
	public void setPlsqEhrpRefDataFunction(String plsqEhrpRefDataFunction) {
		this.plsqEhrpRefDataFunction = plsqEhrpRefDataFunction;
	}
	
}
