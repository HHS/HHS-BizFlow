package gov.hhs.usas.dss.model;

public class Report {

	//Report Search Path
	private static String searchPath;
	
	//Staffing Date Type Prompt
	private static String svpName;
	private static String svpUseval;
	private static String svpDisplay;
	
	//Staffing Date Range Prompt
	private static String rvpName;
	private static String rvpStartUseval;
	private static String rvpStartDisplay;
	private static String rvpEndUseval;
	private static String rvpEndDisplay;
	
	//File Name for Saving
	private static String fileName;
	
	//Report Name
	private static String reportName;
	
	//Intg Type for inserting into intg_data_dtl table
	private static String intgType;
	
	//Number of Prompts
	private static Integer parmNum;
	
	//Number of times to pull the report
	private static int rptIteration;
	
	//the number of days to pull back for each report iteration
	private static Integer dateInterval;
	
	//End date value-- pulls report from current date to end date value
	private static String endDate;
	
	//Stores Stored procedure for truncating report tables
	private static String spTruncate;
	
	//Determines if report should be run, true or false value
	private static boolean runReport;
	
	public static String getSearchPath() {
		return searchPath;
	}

	public static void setSearchPath(String searchPath) {
		Report.searchPath = searchPath;
	}

	public static String getSvpName() {
		return svpName;
	}

	public static void setSvpName(String svpName) {
		Report.svpName = svpName;
	}

	public static String getSvpUseval() {
		return svpUseval;
	}

	public static void setSvpUseval(String svpUseval) {
		Report.svpUseval = svpUseval;
	}

	public static String getSvpDisplay() {
		return svpDisplay;
	}

	public static void setSvpDisplay(String svpDisplay) {
		Report.svpDisplay = svpDisplay;
	}

	public static String getRvpName() {
		return rvpName;
	}

	public static void setRvpName(String rvpName) {
		Report.rvpName = rvpName;
	}

	public static String getRvpStartUseval() {
		return rvpStartUseval;
	}

	public static void setRvpStartUseval(String rvpStartUseval) {
		Report.rvpStartUseval = rvpStartUseval;
	}

	public static String getRvpStartDisplay() {
		return rvpStartDisplay;
	}

	public static void setRvpStartDisplay(String rvpStartDisplay) {
		Report.rvpStartDisplay = rvpStartDisplay;
	}

	public static String getRvpEndUseval() {
		return rvpEndUseval;
	}

	public static void setRvpEndUseval(String rvpEndUseval) {
		Report.rvpEndUseval = rvpEndUseval;
	}

	public static String getRvpEndDisplay() {
		return rvpEndDisplay;
	}

	public static void setRvpEndDisplay(String rvpEndDisplay) {
		Report.rvpEndDisplay = rvpEndDisplay;
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		Report.fileName = fileName;
	}

	public static String getReportName() {
		return reportName;
	}

	public static void setReportName(String reportName) {
		Report.reportName = reportName;
	}

	public static String getIntgType() {
		return intgType;
	}

	public static void setIntgType(String intgType) {
		Report.intgType = intgType;
	}

	public static Integer getParmNum() {
		return parmNum;
	}

	public static void setParmNum(Integer parmNum) {
		Report.parmNum = parmNum;
	}
	
	public static int getRptIteration() {
		return rptIteration;
	}

	public static void setRptIteration(int rptIteration) {
		Report.rptIteration = rptIteration;
	}

	public static Integer getDateInterval() {
		return dateInterval;
	}

	public static void setDateInterval(Integer dateInterval) {
		Report.dateInterval = dateInterval;
	}
	
	public static String getEndDate() {
		return endDate;
	}

	public static void setEndDate(String endDate) {
		Report.endDate = endDate;
	}

	public static String getSpTruncate() {
		return spTruncate;
	}

	public static void setSpTruncate(String spTruncate) {
		Report.spTruncate = spTruncate;
	}

	public static boolean isRunReport() {
		return runReport;
	}

	public static void setRunReport(boolean runReport) {
		Report.runReport = runReport;
	}

	public Report() {

	}

}
