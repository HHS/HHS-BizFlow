package gov.hhs.usas.dss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:whrsc-report.properties")
})
public class Properties {

	//WHRSC Target database Configuration
	@Value("${whrsc.target.datasource.url}")
	private String whrscDbURL;
	@Value("${whrsc.target.datasource.username}")
	private String whrscDbUsername;
	@Value("${whrsc.target.datasource.password}")
	private String whrscDbPassword;
	@Value("${whrsc.target.datasource.driver-class-name}")
	private String whrscDbDriver;
	@Value("${whrsc.target.datasource.initialize}")
	private boolean initializeWhrscDb;

	//Send Email Notifications- true or false
	@Value("${send.email.notification}")
	private boolean sendEmailNotification ;

	//Email Notification Account
	@Value("${spring.mail.default-encoding}")
	private String emailEncoding;
	@Value("${spring.mail.host}")
	private String emailHost;
	@Value("${spring.mail.username}")
	private String emailUsername;
	@Value("${spring.mail.password}")
	private String emailPassword;
	@Value("${spring.mail.port}")
	private String emailPort;
	@Value("${spring.mail.protocol}")
	private String emailProtocol;
	@Value("${spring.mail.test-connection}")
	private boolean testEmailConnection;
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private boolean smtpAuth;
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private boolean enableSmtpStartTLS;

	//Email Notification properties
	@Value("${emailid.from}")
	private String emailFrom;
	@Value("${emailid.to}")
	private String[] emailTo;

	@Value("${email.subject}")
	private String emailSubject;
	@Value("${email.message}")
	private String emailMessage;
	@Value("${email.html.message}")
	private String htmlMessage;

	//Logging properties
	@Value("${logging.config}")
	private String loggingConfig;

	// Must be one of ("trace", "debug", "info", "warn", or "error")
	@Value("${logging.level.root}")
	private String loggingLevel;

	//output logs to a file
	@Value("${logging.file}")
	private String logFile;

	//Save a file of the report to the directory for debugging purposes- true or false value
	@Value("${save.report.file}")
	private boolean saveReport ;

	//////////////////////////////////////////////////////////////////////////////////////////
	//// CONFIGURATION FOR WHRSC DATASTORE REPORTS
	//////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////
	//// REPORT STATUSES
	//////////////////////////////////////////////////////////////////////
	@Value("${report.off}")
	private String reportOffMessage;
	@Value("${report.success}")
	private String reportSuccessMessage;
	@Value("${report.error}")
	private String reportErrorMessage;
	@Value("${report.fail}")
	private String reportFailMessage;

	//////////////////////////////////////////////////////////////////////
	//// REPORT PROPERTIES
	//////////////////////////////////////////////////////////////////////

	//Applicant Notifications (an) Report
	@Value("${an.search.path}")
	private String anSearchPath;
	@Value("${an.intg.type}")
	private String anIntgType;
	@Value("${an.file.name}")
	private String anFileName;
	@Value("${an.report.name}")
	private String anReportName;
	@Value("${an.step.name}")
	private String anStepName;
	@Value("${an.truncate}")
	private String anTruncateProcName;
	@Value("${an.run.report}")
	private boolean runANReport;

	//Certificate Series Locations (cl) Report
	@Value("${cl.search.path}")
	private String clSearchPath;
	@Value("${cl.intg.type}")
	private String clIntgType;
	@Value("${cl.file.name}")
	private String clFileName;
	@Value("${cl.report.name}")
	private String clReportName;
	@Value("${cl.step.name}")
	private String clStepName;
	@Value("${cl.truncate}")
	private String clTruncateProcName;
	@Value("${cl.run.report}")
	private boolean runCLReport ;

	//Certificates (c) Report
	@Value("${c.search.path}")
	private String cSearchPath;
	@Value("${c.intg.type}")
	private String cIntgType;
	@Value("${c.file.name}")
	private String cFileName;
	@Value("${c.report.name}")
	private String cReportName;
	@Value("${c.step.name}")
	private String cStepName;
	@Value("${c.truncate}")
	private String cTruncateProcName;
	@Value("${c.run.report}")
	private boolean runCReport;

	//Permission Profiles (pp) Report
	@Value("${pp.search.path}")
	private String ppSearchPath;
	@Value("${pp.intg.type}")
	private String ppIntgType;
	@Value("${pp.file.name}")
	private String ppFileName;
	@Value("${pp.report.name}")
	private String ppReportName;
	@Value("${pp.step.name}")
	private String ppStepName;
	@Value("${pp.truncate}")
	private String ppTruncateProcName;
	@Value("${pp.run.report}")
	private boolean runPPReport;

	//New Hire Forms (nhf) Report
	@Value("${nhf.search.path}")
	private String nhfSearchPath;
	@Value("${nhf.intg.type}")
	private String nhfIntgType;
	@Value("${nhf.file.name}")
	private String nhfFileName;
	@Value("${nhf.report.name}")
	private String nhfReportName;
	@Value("${nhf.step.name}")
	private String nhfStepName;
	@Value("${nhf.truncate}")
	private String nhfTruncateProcName;
	@Value("${nhf.run.report}")
	private boolean runNHFReport;

	//New Hire Onboarding Documents (nhod) Report
	@Value("${nhod.search.path}")
	private String nhodSearchPath;
	@Value("${nhod.intg.type}")
	private String nhodIntgType;
	@Value("${nhod.file.name}")
	private String nhodFileName;
	@Value("${nhod.report.name}")
	private String nhodReportName;
	@Value("${nhod.step.name}")
	private String nhodStepName;
	@Value("${nhod.truncate}")
	private String nhodTruncateProcName;
	@Value("${nhod.run.report}")
	private boolean runNHODReport;

	//New Hire Task (nht) Report
	@Value("${nht.search.path}")
	private String nhtSearchPath;
	@Value("${nht.intg.type}")
	private String nhtIntgType;
	@Value("${nht.file.name}")
	private String nhtFileName;
	@Value("${nht.report.name}")
	private String nhtReportName;
	@Value("${nht.step.name}")
	private String nhtStepName;
	@Value("${nht.truncate}")
	private String nhtTruncateProcName;
	@Value("${nht.run.report}")
	private boolean runNHTReport;

	//New Hire Vacancy Request (nhvr) Report
	@Value("${nhvr.search.path}")
	private String nhvrSearchPath;
	@Value("${nhvr.intg.type}")
	private String nhvrIntgType;
	@Value("${nhvr.file.name}")
	private String nhvrFileName;
	@Value("${nhvr.report.name}")
	private String nhvrReportName;
	@Value("${nhvr.step.name}")
	private String nhvrStepName;
	@Value("${nhvr.truncate}")
	private String nhvrTruncateProcName;
	@Value("${nhvr.run.report}")
	private boolean runNHVRPath;

	//New Hires (nh) Report
	@Value("${nh.search.path}")
	private String nhSearchPath;
	@Value("${nh.intg.type}")
	private String nhIntgType;
	@Value("${nh.file.name}")
	private String nhFileName;
	@Value("${nh.report.name}")
	private String nhReportName;
	@Value("${nh.step.name}")
	private String nhStepName;
	@Value("${nh.truncate}")
	private String nhTruncateProcName;
	@Value("${nh.run.report}")
	private boolean runNHReport;

	//Request Locations (rl) Report
	@Value("${rl.search.path}")
	private String rlSearchPath;
	@Value("${rl.intg.type}")
	private String rlIntgType;
	@Value("${rl.file.name}")
	private String rlFileName;
	@Value("${rl.report.name}")
	private String rlReportName;
	@Value("${rl.step.name}")
	private String rlStepName;
	@Value("${rl.truncate}")
	private String rlTruncateProcName;
	@Value("${rl.run.report}")
	private boolean runRLReport;

	//Request Rating Combinations (rrc) Report
	@Value("${rrc.search.path}")
	private String rrcSearchPath;
	@Value("${rrc.intg.type}")
	private String rrcIntgType;
	@Value("${rrc.file.name}")
	private String rrcFileName;
	@Value("${rrc.report.name}")
	private String rrcReportName;
	@Value("${rrc.step.name}")
	private String rrcStepName;
	@Value("${rrc.truncate}")
	private String rrcTruncateProcName;
	@Value("${rrc.run.report}")
	private boolean runRRCReport;

	//Request Vacancy Combinations (rvc) Report
	@Value("${rvc.search.path}")
	private String rvcSearchPath;
	@Value("${rvc.intg.type}")
	private String rvcIntgType;
	@Value("${rvc.file.name}")
	private String rvcFileName;
	@Value("${rvc.report.name}")
	private String rvcReportName;
	@Value("${rvc.step.name}")
	private String rvcStepName;
	@Value("${rvc.truncate}")
	private String rvcTruncateProcName;
	@Value("${rvc.run.report}")
	private boolean runRVCReport;

	//Requests (req) Report
	@Value("${req.search.path}")
	private String reqSearchPath;
	@Value("${req.intg.type}")
	private String reqIntgType;
	@Value("${req.file.name}")
	private String reqFileName;
	@Value("${req.report.name}")
	private String reqReportName;
	@Value("${req.step.name}")
	private String reqStepname;
	@Value("${req.truncate}")
	private String reqTruncateProcName;
	@Value("${req.run.report}")
	private boolean runREQReport ;

	//Vacancy (vac) Report
	@Value("${vac.search.path}")
	private String vacSearchPath;
	@Value("${vac.intg.type}")
	private String vacIntgType;
	@Value("${vac.file.name}")
	private String vacFileName;
	@Value("${vac.report.name}")
	private String vacReportName;
	@Value("${vac.step.name}")
	private String vacStepName;
	@Value("${vac.truncate}")
	private String vacTruncateProcName;
	@Value("${vac.run.report}")
	private boolean runVACReport;

	//Vacancy Eligibilities (ve) Report
	@Value("${ve.search.path}")
	private String veSearchPath;
	@Value("${ve.intg.type}")
	private String veIntgType;
	@Value("${ve.file.name}")
	private String veFileName;
	@Value("${ve.report.name}")
	private String veReportName;
	@Value("${ve.step.name}")
	private String veStepName;
	@Value("${ve.truncate}")
	private String veTruncateProcName;
	@Value("${ve.run.report}")
	private boolean runVEReport ;

	//Vacancy Locations (vl) Report
	@Value("${vl.search.path}")
	private String vlSearchPath;
	@Value("${vl.intg.type}")
	private String vlIntgType;
	@Value("${vl.file.name}")
	private String vlFileName;
	@Value("${vl.report.name}")
	private String vlReportName;
	@Value("${vl.step.name}")
	private String vlStepName;
	@Value("${vl.truncate}")
	private String vlTruncateProcName;
	@Value("${vl.run.report}")
	private boolean runVLReport ;

	//Vacancy Mission Critical Occupations (vmco) Report
	@Value("${vmco.search.path}")
	private String vmcoSearchPath;
	@Value("${vmco.intg.type}")
	private String vmcoIntgType;
	@Value("${vmco.file.name}")
	private String vmcoFileName;
	@Value("${vmco.report.name}")
	private String vmcoReportName;
	@Value("${vmco.step.name}")
	private String vmcoStepName;
	@Value("${vmco.truncate}")
	private String vmcoTruncateProcName;
	@Value("${vmco.run.report}")
	private boolean runVMCOReport;

	//Vacancy Rating Combinations (vrc) Report
	@Value("${vrc.search.path}")
	private String vrcSearchPath;
	@Value("${vrc.intg.type}")
	private String vrcIntgType;
	@Value("${vrc.file.name}")
	private String vrcFileName;
	@Value("${vrc.report.name}")
	private String vrcReportName;
	@Value("${vrc.step.name}")
	private String vrcStepName;
	@Value("${vrc.truncate}")
	private String vrcTruncateProcName;
	@Value("${vrc.run.report}")
	private boolean runVRCReport;
	
	public String getWhrscDbURL() {
		return whrscDbURL;
	}
	public String getWhrscDbUsername() {
		return whrscDbUsername;
	}
	public String getWhrscDbPassword() {
		return whrscDbPassword;
	}
	public String getWhrscDbDriver() {
		return whrscDbDriver;
	}
	public boolean initializeWhrscDb() {
		return initializeWhrscDb;
	}
	public boolean sendEmailNotification() {
		return sendEmailNotification;
	}
	public String getEmailEncoding() {
		return emailEncoding;
	}
	public String getEmailHost() {
		return emailHost;
	}
	public String getEmailUsername() {
		return emailUsername;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public String getEmailPort() {
		return emailPort;
	}
	public String getEmailProtocol() {
		return emailProtocol;
	}
	public boolean testEmailConnection() {
		return testEmailConnection;
	}
	public boolean isSmtpAuth() {
		return smtpAuth;
	}
	public boolean enableSmtpStartTLS() {
		return enableSmtpStartTLS;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public String[] getEmailTo() {
		return emailTo;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public String getEmailMessage() {
		return emailMessage;
	}
	public String getHtmlMessage() {
		return htmlMessage;
	}
	public String getLoggingConfig() {
		return loggingConfig;
	}
	public String getLoggingLevel() {
		return loggingLevel;
	}
	public String getLogFile() {
		return logFile;
	}
	public boolean saveReport() {
		return saveReport;
	}
	public String getReportOffMessage() {
		return reportOffMessage;
	}
	public String getReportSuccessMessage() {
		return reportSuccessMessage;
	}
	public String getReportErrorMessage() {
		return reportErrorMessage;
	}
	public String getReportFailMessage() {
		return reportFailMessage;
	}
	public String getAnSearchPath() {
		return anSearchPath;
	}
	public String getAnIntgType() {
		return anIntgType;
	}
	public String getAnFileName() {
		return anFileName;
	}
	public String getAnReportName() {
		return anReportName;
	}
	public String getAnStepName() {
		return anStepName;
	}
	public String getAnTruncateProcName() {
		return anTruncateProcName;
	}
	public boolean runANReport() {
		return runANReport;
	}
	public String getClSearchPath() {
		return clSearchPath;
	}
	public String getClIntgType() {
		return clIntgType;
	}
	public String getClFileName() {
		return clFileName;
	}
	public String getClReportName() {
		return clReportName;
	}
	public String getClStepName() {
		return clStepName;
	}
	public String getClTruncateProcName() {
		return clTruncateProcName;
	}
	public boolean runCLReport() {
		return runCLReport;
	}
	public String getcSearchPath() {
		return cSearchPath;
	}
	public String getcIntgType() {
		return cIntgType;
	}
	public String getcFileName() {
		return cFileName;
	}
	public String getcReportName() {
		return cReportName;
	}
	public String getcStepName() {
		return cStepName;
	}
	public String getcTruncateProcName() {
		return cTruncateProcName;
	}
	public boolean runCReport() {
		return runCReport;
	}
	public String getPpSearchPath() {
		return ppSearchPath;
	}
	public String getPpIntgType() {
		return ppIntgType;
	}
	public String getPpFileName() {
		return ppFileName;
	}
	public String getPpReportName() {
		return ppReportName;
	}
	public String getPpStepName() {
		return ppStepName;
	}
	public String getPpTruncateProcName() {
		return ppTruncateProcName;
	}
	public boolean runPPReport() {
		return runPPReport;
	}
	public String getNhfSearchPath() {
		return nhfSearchPath;
	}
	public String getNhfIntgType() {
		return nhfIntgType;
	}
	public String getNhfFileName() {
		return nhfFileName;
	}
	public String getNhfReportName() {
		return nhfReportName;
	}
	public String getNhfStepName() {
		return nhfStepName;
	}
	public String getNhfTruncateProcName() {
		return nhfTruncateProcName;
	}
	public boolean runNHFReport() {
		return runNHFReport;
	}
	public String getNhodSearchPath() {
		return nhodSearchPath;
	}
	public String getNhodIntgType() {
		return nhodIntgType;
	}
	public String getNhodFileName() {
		return nhodFileName;
	}
	public String getNhodReportName() {
		return nhodReportName;
	}
	public String getNhodStepName() {
		return nhodStepName;
	}
	public String getNhodTruncateProcName() {
		return nhodTruncateProcName;
	}
	public boolean runNHODReport() {
		return runNHODReport;
	}
	public String getNhtSearchPath() {
		return nhtSearchPath;
	}
	public String getNhtIntgType() {
		return nhtIntgType;
	}
	public String getNhtFileName() {
		return nhtFileName;
	}
	public String getNhtReportName() {
		return nhtReportName;
	}
	public String getNhtStepName() {
		return nhtStepName;
	}
	public String getNhtTruncateProcName() {
		return nhtTruncateProcName;
	}
	public boolean runNHTReport() {
		return runNHTReport;
	}
	public String getNhvrSearchPath() {
		return nhvrSearchPath;
	}
	public String getNhvrIntgType() {
		return nhvrIntgType;
	}
	public String getNhvrFileName() {
		return nhvrFileName;
	}
	public String getNhvrReportName() {
		return nhvrReportName;
	}
	public String getNhvrStepName() {
		return nhvrStepName;
	}
	public String getNhvrTruncateProcName() {
		return nhvrTruncateProcName;
	}
	public boolean runNHVRPath() {
		return runNHVRPath;
	}
	public String getNhSearchPath() {
		return nhSearchPath;
	}
	public String getNhIntgType() {
		return nhIntgType;
	}
	public String getNhFileName() {
		return nhFileName;
	}
	public String getNhReportName() {
		return nhReportName;
	}
	public String getNhStepName() {
		return nhStepName;
	}
	public String getNhTruncateProcName() {
		return nhTruncateProcName;
	}
	public boolean runNHReport() {
		return runNHReport;
	}
	public String getRlSearchPath() {
		return rlSearchPath;
	}
	public String getRlIntgType() {
		return rlIntgType;
	}
	public String getRlFileName() {
		return rlFileName;
	}
	public String getRlReportName() {
		return rlReportName;
	}
	public String getRlStepName() {
		return rlStepName;
	}
	public String getRlTruncateProcName() {
		return rlTruncateProcName;
	}
	public boolean runRLReport() {
		return runRLReport;
	}
	public String getRrcSearchPath() {
		return rrcSearchPath;
	}
	public String getRrcIntgType() {
		return rrcIntgType;
	}
	public String getRrcFileName() {
		return rrcFileName;
	}
	public String getRrcReportName() {
		return rrcReportName;
	}
	public String getRrcStepName() {
		return rrcStepName;
	}
	public String getRrcTruncateProcName() {
		return rrcTruncateProcName;
	}
	public boolean runRRCReport() {
		return runRRCReport;
	}
	public String getRvcSearchPath() {
		return rvcSearchPath;
	}
	public String getRvcIntgType() {
		return rvcIntgType;
	}
	public String getRvcFileName() {
		return rvcFileName;
	}
	public String getRvcReportName() {
		return rvcReportName;
	}
	public String getRvcStepName() {
		return rvcStepName;
	}
	public String getRvcTruncateProcName() {
		return rvcTruncateProcName;
	}
	public boolean runRVCReport() {
		return runRVCReport;
	}
	public String getReqSearchPath() {
		return reqSearchPath;
	}
	public String getReqIntgType() {
		return reqIntgType;
	}
	public String getReqFileName() {
		return reqFileName;
	}
	public String getReqReportName() {
		return reqReportName;
	}
	public String getReqStepname() {
		return reqStepname;
	}
	public String getReqTruncateProcName() {
		return reqTruncateProcName;
	}
	public boolean runREQReport() {
		return runREQReport;
	}
	public String getVacSearchPath() {
		return vacSearchPath;
	}
	public String getVacIntgType() {
		return vacIntgType;
	}
	public String getVacFileName() {
		return vacFileName;
	}
	public String getVacReportName() {
		return vacReportName;
	}
	public String getVacStepName() {
		return vacStepName;
	}
	public String getVacTruncateProcName() {
		return vacTruncateProcName;
	}
	public boolean runVACReport() {
		return runVACReport;
	}
	public String getVeSearchPath() {
		return veSearchPath;
	}
	public String getVeIntgType() {
		return veIntgType;
	}
	public String getVeFileName() {
		return veFileName;
	}
	public String getVeReportName() {
		return veReportName;
	}
	public String getVeStepName() {
		return veStepName;
	}
	public String getVeTruncateProcName() {
		return veTruncateProcName;
	}
	public boolean runVEReport() {
		return runVEReport;
	}
	public String getVlSearchPath() {
		return vlSearchPath;
	}
	public String getVlIntgType() {
		return vlIntgType;
	}
	public String getVlFileName() {
		return vlFileName;
	}
	public String getVlReportName() {
		return vlReportName;
	}
	public String getVlStepName() {
		return vlStepName;
	}
	public String getVlTruncateProcName() {
		return vlTruncateProcName;
	}
	public boolean runVLReport() {
		return runVLReport;
	}
	public String getVmcoSearchPath() {
		return vmcoSearchPath;
	}
	public String getVmcoIntgType() {
		return vmcoIntgType;
	}
	public String getVmcoFileName() {
		return vmcoFileName;
	}
	public String getVmcoReportName() {
		return vmcoReportName;
	}
	public String getVmcoStepName() {
		return vmcoStepName;
	}
	public String getVmcoTruncateProcName() {
		return vmcoTruncateProcName;
	}
	public boolean runVMCOReport() {
		return runVMCOReport;
	}
	public String getVrcSearchPath() {
		return vrcSearchPath;
	}
	public String getVrcIntgType() {
		return vrcIntgType;
	}
	public String getVrcFileName() {
		return vrcFileName;
	}
	public String getVrcReportName() {
		return vrcReportName;
	}
	public String getVrcStepName() {
		return vrcStepName;
	}
	public String getVrcTruncateProcName() {
		return vrcTruncateProcName;
	}
	public boolean runVRCReport() {
		return runVRCReport;
	}

}
