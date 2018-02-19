package hhs.usas.dss.model;

public class Review {

	//Review Report Search Path
	private static String SEARCH_PATH = "/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Review Data Self Service']";
	
	//Staffing Date Range Prompt
	private static String RVP_NAME="parm_StaffingDateRange";
	private static String RVP_START_USEVAL="2018-01-01T00:00:00.000";
	private static String RVP_START_DISPLAY="Jan 1, 2018 12:00 AM";
	private static String RVP_END_USEVAL="2018-01-31T00:00:00.000";
	private static String RVP_END_DISPLAY="Jan 31, 2018 12:00 AM";
	
	private static String fileName = "ReviewDSS";
	
	private static int parmNum = 1;

	public static String getSEARCH_PATH() {
		return SEARCH_PATH;
	}

	public static void setSEARCH_PATH(String sEARCH_PATH) {
		SEARCH_PATH = sEARCH_PATH;
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
		Review.fileName = fileName;
	}

	public static int getParmNum() {
		return parmNum;
	}

	public static void setParmNum(int parmNum) {
		Review.parmNum = parmNum;
	}

	public Review() {
		super();

	}
	
	
}
