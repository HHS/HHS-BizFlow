package gov.hhs.batch.ehrp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ehrp.properties")
public class EHRPProperties {
	
	@Value("${ehrp.interface.name}")
	private String ehrpInterfaceName;
	
	//Log File Name
	@Value("${ehrp.log.name}")
	private String ehrpLogFileName;

	@Value("${archive.name}")
	private String archiveName;
	@Value("${error.name}")
	private String errorName;
	@Value("${noFiles.name}")
	private String noFilesName;
	@Value("${fileCount.email.message}")
	private String fileCountMsg;
	@Value("${noFiles.email.message}")
	private String noFilesMsg;
	@Value("${scriptError.email.message}")
	private String scriptErrorMsg;
	
	@Value("${ehrp.script.name}")
	private String ehrpScriptName;
	@Value("${ehrp.script.path}")
	private String ehrpScriptPath;
	
	//Directories
	@Value("${inbound.directory}")
	private String inboundDir;
	@Value("${processing.directory}")
	private String processingDir;
	@Value("${archive.directory}")
	private String archiveDir;
	@Value("${error.directory}")
	private String errorDir;
	
	//Oracle Table Names
	@Value("${reqDetail.table}")
	private String reqDetailTblName;
	@Value("${jobcode.table}")
	private String jobCodeTblName;
	@Value("${positions.table}")
	private String positionsTblName;
	@Value("${openings.table}")
	private String openingsTblName;	
	@Value("${candidates.table}")
	private String candidatesTblName;
	@Value("${dept.table}")
	private String deptTblName;
	@Value("${approvals.table}")
	private String approvalsTblName;
	@Value("${ewits.table}")
	private String ewitsTblName;
	@Value("${emplRpl.table}")
	private String emplRplTblName;
	@Value("${positionDtl.table}")
	private String positionDtlTblName;
	@Value("${jobcodeDtl.table}")
	private String jobcodeDtlTblName;	
	@Value("${salaryDtl.table}")
	private String salaryDtlTblName;		
	@Value("${positionDept.table}")
	private String positionDeptTblName;		
	
	//SQL Select Statements
	@Value("${sql.select.jobOpeningNbr}")
	private String sqlSelectJobOpeningNbr;
	
	//SQL Insert Statements
	@Value("${sql.insert.reqDetail}")
	private String sqlInsertReqDetail;
	@Value("${sql.insert.jobcodes}")
	private String sqlInsertJobcodes;
	@Value("${sql.insert.positions}")
	private String sqlInsertPositions;
	@Value("${sql.insert.openings}")
	private String sqlInsertOpenings;
	@Value("${sql.insert.candidates}")
	private String sqlInsertCandidates;
	@Value("${sql.insert.dept}")
	private String sqlInsertDept;
	@Value("${sql.insert.approvals}")
	private String sqlInsertApprovals;
	@Value("${sql.insert.ewits}")
	private String sqlInsertEwits;
	@Value("${sql.insert.emplRpl}")
	private String sqlInsertEmplRpl;
	@Value("${sql.insert.positionDtl}")
	private String sqlInsertPositionDtl;
	@Value("${sql.insert.jobcodeDtl}")
	private String sqlInsertJobcodeDtl;
	@Value("${sql.insert.salaryDtl}")
	private String sqlInsertSalaryDtl;
	@Value("${sql.insert.positionDept}")
	private String sqlInsertPositionDept;
	
	
	public String getEhrpInterfaceName() {
		return ehrpInterfaceName;
	}
	public void setEhrpInterfaceName(String ehrpInterfaceName) {
		this.ehrpInterfaceName = ehrpInterfaceName;
	}
	public String getEhrpLogFileName() {
		return ehrpLogFileName;
	}
	public void setEhrpLogFileName(String ehrpLogFileName) {
		this.ehrpLogFileName = ehrpLogFileName;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getNoFilesName() {
		return noFilesName;
	}
	public void setNoFilesName(String noFilesName) {
		this.noFilesName = noFilesName;
	}
	public String getFileCountMsg() {
		return fileCountMsg;
	}
	public void setFileCountMsg(String fileCountMsg) {
		this.fileCountMsg = fileCountMsg;
	}
	public String getNoFilesMsg() {
		return noFilesMsg;
	}
	public void setNoFilesMsg(String noFilesMsg) {
		this.noFilesMsg = noFilesMsg;
	}
	public String getScriptErrorMsg() {
		return scriptErrorMsg;
	}
	public void setScriptErrorMsg(String scriptErrorMsg) {
		this.scriptErrorMsg = scriptErrorMsg;
	}
	public String getEhrpScriptName() {
		return ehrpScriptName;
	}
	public void setEhrpScriptName(String ehrpScriptName) {
		this.ehrpScriptName = ehrpScriptName;
	}
	public String getEhrpScriptPath() {
		return ehrpScriptPath;
	}
	public void setEhrpScriptPath(String ehrpScriptPath) {
		this.ehrpScriptPath = ehrpScriptPath;
	}
	public String getInboundDir() {
		return inboundDir;
	}
	public void setInboundDir(String inboundDir) {
		this.inboundDir = inboundDir;
	}
	public String getProcessingDir() {
		return processingDir;
	}
	public void setProcessingDir(String processingDir) {
		this.processingDir = processingDir;
	}
	public String getArchiveDir() {
		return archiveDir;
	}
	public void setArchiveDir(String archiveDir) {
		this.archiveDir = archiveDir;
	}
	public String getErrorDir() {
		return errorDir;
	}
	public void setErrorDir(String errorDir) {
		this.errorDir = errorDir;
	}
	public void setSqlSelectJobOpeningNbr(String sqlSelectJobOpeningNbr) {
		this.sqlSelectJobOpeningNbr = sqlSelectJobOpeningNbr;
	}
	public String getreqDetailTblName() {
		return reqDetailTblName;
	}
	public void setreqDetailTblName(String reqDetailTblName) {
		this.reqDetailTblName = reqDetailTblName;
	}
	public String getReqDetailTblName() {
		return reqDetailTblName;
	}
	public void setReqDetailTblName(String reqDetailTblName) {
		this.reqDetailTblName = reqDetailTblName;
	}
	public String getJobCodeTblName() {
		return jobCodeTblName;
	}
	public void setJobCodeTblName(String jobCodeTblName) {
		this.jobCodeTblName = jobCodeTblName;
	}
	public String getPositionsTblName() {
		return positionsTblName;
	}
	public void setPositionsTblName(String positionsTblName) {
		this.positionsTblName = positionsTblName;
	}
	public String getOpeningsTblName() {
		return openingsTblName;
	}
	public void setOpeningsTblName(String openingsTblName) {
		this.openingsTblName = openingsTblName;
	}
	public String getCandidatesTblName() {
		return candidatesTblName;
	}
	public void setCandidatesTblName(String candidatesTblName) {
		this.candidatesTblName = candidatesTblName;
	}
	public String getDeptTblName() {
		return deptTblName;
	}
	public void setDeptTblName(String deptTblName) {
		this.deptTblName = deptTblName;
	}
	public String getApprovalsTblName() {
		return approvalsTblName;
	}
	public void setApprovalsTblName(String approvalsTblName) {
		this.approvalsTblName = approvalsTblName;
	}
	public String getEwitsTblName() {
		return ewitsTblName;
	}
	public void setEwitsTblName(String ewitsTblName) {
		this.ewitsTblName = ewitsTblName;
	}
	public String getEmplRplTblName() {
		return emplRplTblName;
	}
	public void setEmplRplTblName(String emplRplTblName) {
		this.emplRplTblName = emplRplTblName;
	}
	public String getPositionDtlTblName() {
		return positionDtlTblName;
	}
	public void setPositionDtlTblName(String positionDtlTblName) {
		this.positionDtlTblName = positionDtlTblName;
	}
	public String getJobcodeDtlTblName() {
		return jobcodeDtlTblName;
	}
	public void setJobcodeDtlTblName(String jobcodeDtlTblName) {
		this.jobcodeDtlTblName = jobcodeDtlTblName;
	}
	public String getSalaryDtlTblName() {
		return salaryDtlTblName;
	}
	public void setSalaryDtlTblName(String salaryDtlTblName) {
		this.salaryDtlTblName = salaryDtlTblName;
	}
	public String getPositionDeptTblName() {
		return positionDeptTblName;
	}
	public void setPositionDeptTblName(String positionDeptTblName) {
		this.positionDeptTblName = positionDeptTblName;
	}
	public String getSqlSelectJobOpeningNbr() {
		return sqlSelectJobOpeningNbr;
	}
	public String getSqlInsertReqDetail() {
		return sqlInsertReqDetail;
	}
	public void setSqlInsertReqDetail(String sqlInsertReqDetail) {
		this.sqlInsertReqDetail = sqlInsertReqDetail;
	}
	public String getSqlInsertJobcodes() {
		return sqlInsertJobcodes;
	}
	public void setSqlInsertJobcodes(String sqlInsertJobcodes) {
		this.sqlInsertJobcodes = sqlInsertJobcodes;
	}
	public String getSqlInsertPositions() {
		return sqlInsertPositions;
	}
	public void setSqlInsertPositions(String sqlInsertPositions) {
		this.sqlInsertPositions = sqlInsertPositions;
	}
	public String getSqlInsertOpenings() {
		return sqlInsertOpenings;
	}
	public void setSqlInsertOpenings(String sqlInsertOpenings) {
		this.sqlInsertOpenings = sqlInsertOpenings;
	}
	public String getSqlInsertCandidates() {
		return sqlInsertCandidates;
	}
	public void setSqlInsertCandidates(String sqlInsertCandidates) {
		this.sqlInsertCandidates = sqlInsertCandidates;
	}
	public String getSqlInsertDept() {
		return sqlInsertDept;
	}
	public void setSqlInsertDept(String sqlInsertDept) {
		this.sqlInsertDept = sqlInsertDept;
	}
	public String getSqlInsertApprovals() {
		return sqlInsertApprovals;
	}
	public void setSqlInsertApprovals(String sqlInsertApprovals) {
		this.sqlInsertApprovals = sqlInsertApprovals;
	}
	public String getSqlInsertEwits() {
		return sqlInsertEwits;
	}
	public void setSqlInsertEwits(String sqlInsertEwits) {
		this.sqlInsertEwits = sqlInsertEwits;
	}
	public String getSqlInsertEmplRpl() {
		return sqlInsertEmplRpl;
	}
	public void setSqlInsertEmplRpl(String sqlInsertEmplRpl) {
		this.sqlInsertEmplRpl = sqlInsertEmplRpl;
	}
	public String getSqlInsertPositionDtl() {
		return sqlInsertPositionDtl;
	}
	public void setSqlInsertPositionDtl(String sqlInsertPositionDtl) {
		this.sqlInsertPositionDtl = sqlInsertPositionDtl;
	}
	public String getSqlInsertJobcodeDtl() {
		return sqlInsertJobcodeDtl;
	}
	public void setSqlInsertJobcodeDtl(String sqlInsertJobcodeDtl) {
		this.sqlInsertJobcodeDtl = sqlInsertJobcodeDtl;
	}
	public String getSqlInsertSalaryDtl() {
		return sqlInsertSalaryDtl;
	}
	public void setSqlInsertSalaryDtl(String sqlInsertSalaryDtl) {
		this.sqlInsertSalaryDtl = sqlInsertSalaryDtl;
	}
	public String getSqlInsertPositionDept() {
		return sqlInsertPositionDept;
	}
	public void setSqlInsertPositionDept(String sqlInsertPositionDept) {
		this.sqlInsertPositionDept = sqlInsertPositionDept;
	}	

}
