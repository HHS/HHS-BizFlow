package gov.hhs.usas.rest.report.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

	private static final Logger log = LoggerFactory.getLogger(Properties.class);

	@Value("${xml.data.login.template}")
	private String xmlDataLoginTemplate;
	@Value("${xml.data.report.template}")
	private String xmlDataReportTemplate;	
	@Value("${path.logon}")
	private String logonPath;
	@Value("${path.logoff}")
	private String logoffPath;
	@Value("${path.reportdata}")
	private String reportDataPath;

	@Value("${report.id.recruitment}")
	private String recruitmentReportID;
	@Value("${report.id.appointment}")
	private String appointmentReportID;
	@Value("${report.name.recruitment}")
	private String recruitmentReportName;
	@Value("${report.name.appointment}")
	private String appointmentReportName;
	@Value("${report.format}")
	private String reportFormat;	

	@Value("${credentials.namespace}")
	private String NameSpace;
	@Value("${credentials.username}")
	private String UserName;
	@Value("${credentials.password}")
	private String Password;

	@Value("${server.url}")
	private String serverURL;
	@Value("${request.user.agent.property}")
	private String userAgentProperty;
	@Value("${request.user.agent}")
	private String userAgent;
	@Value("${request.accept.language.property}")
	private String acceptLanguageProperty;
	@Value("${request.accept.language}")
	private String acceptLanguage;
	@Value("${request.content.type.property}")
	private String contentTypeProperty;
	@Value("${request.content.type}")
	private String contentType;
	@Value("${request.cookie.property}")
	private String cookieProperty;

	public String getXmlDataLoginTemplate() {
		return xmlDataLoginTemplate;
	}
	public void setXmlDataLoginTemplate(String xmlDataLoginTemplate) {
		this.xmlDataLoginTemplate = xmlDataLoginTemplate;
	}
	public String getXmlDataReportTemplate() {
		return xmlDataReportTemplate;
	}
	public void setXmlDataReportTemplate(String xmlDataReportTemplate) {
		this.xmlDataReportTemplate = xmlDataReportTemplate;
	}
	public String getLogonPath() {
		return logonPath;
	}
	public void setLogonPath(String logonPath) {
		this.logonPath = logonPath;
	}
	public String getLogoffPath() {
		return logoffPath;
	}
	public void setLogoffPath(String logoffPath) {
		this.logoffPath = logoffPath;
	}
	public String getReportDataPath() {
		return reportDataPath;
	}
	public void setReportDataPath(String reportDataPath) {
		this.reportDataPath = reportDataPath;
	}
	public String getRecruitmentReportID() {
		return recruitmentReportID;
	}
	public void setRecruitmentReportID(String recruitmentReportID) {
		this.recruitmentReportID = recruitmentReportID;
	}
	public String getAppointmentReportID() {
		return appointmentReportID;
	}
	public void setAppointmentReportID(String appointmentReportID) {
		this.appointmentReportID = appointmentReportID;
	}
	public String getRecruitmentReportName() {
		return recruitmentReportName;
	}
	public void setRecruitmentReportName(String recruitmentReportName) {
		this.recruitmentReportName = recruitmentReportName;
	}
	public String getAppointmentReportName() {
		return appointmentReportName;
	}
	public void setAppointmentReportName(String appointmentReportName) {
		this.appointmentReportName = appointmentReportName;
	}
	public String getReportFormat() {
		return reportFormat;
	}
	public void setReportFormat(String reportFormat) {
		this.reportFormat = reportFormat;
	}
	public String getNameSpace() {
		return NameSpace;
	}
	public void setNameSpace(String nameSpace) {
		NameSpace = nameSpace;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getServerURL() {
		return serverURL;
	}
	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}
	public String getUserAgentProperty() {
		return userAgentProperty;
	}
	public void setUserAgentProperty(String userAgentProperty) {
		this.userAgentProperty = userAgentProperty;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getAcceptLanguageProperty() {
		return acceptLanguageProperty;
	}
	public void setAcceptLanguageProperty(String acceptLanguageProperty) {
		this.acceptLanguageProperty = acceptLanguageProperty;
	}
	public String getAcceptLanguage() {
		return acceptLanguage;
	}
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}
	public String getContentTypeProperty() {
		return contentTypeProperty;
	}
	public void setContentTypeProperty(String contentTypeProperty) {
		this.contentTypeProperty = contentTypeProperty;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCookieProperty() {
		return cookieProperty;
	}
	public void setCookieProperty(String cookieProperty) {
		this.cookieProperty = cookieProperty;
	}


/*	@PostConstruct
	public void writeConfigurationToLog() {
		log.info("Starting application by using configuration: {}", this);
	}*/


}
