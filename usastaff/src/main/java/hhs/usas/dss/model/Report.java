package hhs.usas.dss.model;

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
	
	//Intg Type for inserting into intg_data_dtl table
	private static String intgType;
	
	//Number of Prompts
	private static int parmNum;
	
	//Number of times to pull the report
	private static int rptIteration;
	
	//the number of days to pull back for each report iteration
	private static int dateRange;
	
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

	public static String getIntgType() {
		return intgType;
	}

	public static void setIntgType(String intgType) {
		Report.intgType = intgType;
	}

	public static int getParmNum() {
		return parmNum;
	}

	public static void setParmNum(int parmNum) {
		Report.parmNum = parmNum;
	}
	
	public static int getRptIteration() {
		return rptIteration;
	}

	public static void setRptIteration(int rptIteration) {
		Report.rptIteration = rptIteration;
	}

	public static int getDateRange() {
		return dateRange;
	}

	public static void setDateRange(int dateRange) {
		Report.dateRange = dateRange;
	}

	public Report() {
		super();
	}
	
	
}
