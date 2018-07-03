package gov.hhs.usas.dss.whrsc.model;

public class Report {

	//Report Search Path
	private String searchPath;
	
	//Staffing Date Type Prompt
	private String svpName;
	private String svpUseval;
	private String svpDisplay;
	
	//Staffing Date Range Prompt
	private String rvpName;
	private String rvpStartUseval;
	private String rvpStartDisplay;
	private String rvpEndUseval;
	private String rvpEndDisplay;
	
	//File Name for Saving
	private String fileName;
	
	//Report Name
	private String reportName;
	
	//Intg Type for inserting into intg_data_dtl table
	private String intgType;
	
	//Number of Prompts
	private Integer parmNum;
	
	//Number of times to pull the report
	private int rptIteration;
	
	//the number of days to pull back for each report iteration
	private Integer dateInterval;
	
	//End date value-- pulls report from current date to end date value
	private String endDate;
	
	//Stores Stored procedure for truncating report tables
	private String spTruncate;
	
	//Determines if report should be run, true or false value
	private boolean runReport;
	
	public String getSearchPath() {
		return searchPath;
	}

	public void setSearchPath(String searchPath) {
		this.searchPath = searchPath;
	}

	public String getSvpName() {
		return svpName;
	}

	public void setSvpName(String svpName) {
		this.svpName = svpName;
	}

	public String getSvpUseval() {
		return svpUseval;
	}

	public void setSvpUseval(String svpUseval) {
		this.svpUseval = svpUseval;
	}

	public String getSvpDisplay() {
		return svpDisplay;
	}

	public void setSvpDisplay(String svpDisplay) {
		this.svpDisplay = svpDisplay;
	}

	public String getRvpName() {
		return rvpName;
	}

	public void setRvpName(String rvpName) {
		this.rvpName = rvpName;
	}

	public String getRvpStartUseval() {
		return rvpStartUseval;
	}

	public void setRvpStartUseval(String rvpStartUseval) {
		this.rvpStartUseval = rvpStartUseval;
	}

	public String getRvpStartDisplay() {
		return rvpStartDisplay;
	}

	public void setRvpStartDisplay(String rvpStartDisplay) {
		this.rvpStartDisplay = rvpStartDisplay;
	}

	public String getRvpEndUseval() {
		return rvpEndUseval;
	}

	public void setRvpEndUseval(String rvpEndUseval) {
		this.rvpEndUseval = rvpEndUseval;
	}

	public String getRvpEndDisplay() {
		return rvpEndDisplay;
	}

	public void setRvpEndDisplay(String rvpEndDisplay) {
		this.rvpEndDisplay = rvpEndDisplay;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getIntgType() {
		return intgType;
	}

	public void setIntgType(String intgType) {
		this.intgType = intgType;
	}

	public Integer getParmNum() {
		return parmNum;
	}

	public void setParmNum(Integer parmNum) {
		this.parmNum = parmNum;
	}
	
	public int getRptIteration() {
		return rptIteration;
	}

	public void setRptIteration(int rptIteration) {
		this.rptIteration = rptIteration;
	}

	public Integer getDateInterval() {
		return dateInterval;
	}

	public void setDateInterval(Integer dateInterval) {
		this.dateInterval = dateInterval;
	}
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSpTruncate() {
		return spTruncate;
	}

	public void setSpTruncate(String spTruncate) {
		this.spTruncate = spTruncate;
	}

	public boolean isRunReport() {
		return runReport;
	}

	public void setRunReport(boolean runReport) {
		this.runReport = runReport;
	}

	public Report() {
		super();
	}

}
