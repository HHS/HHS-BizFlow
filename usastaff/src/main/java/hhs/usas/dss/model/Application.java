package hhs.usas.dss.model;

public class Application {

	//Application Report Search Path
	private static String SEARCH_PATH = "/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Application Data Self Service']";
	
	//Staffing Date Type Prompt
	private static String SVP_NAME ="parm_StaffingDateType";
	private static String SVP_USEVAL="ApplicationLastUpdateDate";
	private static String SVP_DISPLAY="Application Last Update Date";
	
	//Staffing Date Range Prompt
	private static String RVP_NAME="parm_StaffingDateRange";
	private static String RVP_START_USEVAL="2018-01-01T00:00:00.000";
	private static String RVP_START_DISPLAY="Jan 1, 2018 12:00 AM";
	private static String RVP_END_USEVAL="2018-01-31T00:00:00.000";
	private static String RVP_END_DISPLAY="Jan 31, 2018 12:00 AM";
	
	private static String fileName = "ApplicationDSS";
	
	private static int parmNum = 2;

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
		Application.fileName = fileName;
	}

	public static int getParmNum() {
		return parmNum;
	}

	public static void setParmNum(int parmNum) {
		Application.parmNum = parmNum;
	}

	public Application() {
		super();
	}
	
	
}
