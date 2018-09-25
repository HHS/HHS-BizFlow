package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class JobCodeTags {

    private static String jobCodesTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES";
    private static String jobcodeTag = "JOBCODE";
    private static String primaryJobcodeTag = "GVT_PRIMARY_JCODE";
    private static String regRegionTag = "REG_REGION";
    private static String desiredFullPartTag = "DESIRED_FULL_PART";
    private static String desiredRegTempTag = "DESIRED_REG_TEMP";
    private static String stdHrsTag = "STD_HOURS";
    private static String stdHrsFreqTag = "STD_HRS_FREQUENCY";
    private static String desiredShiftTag = "DESIRED_SHIFT";
    private static String rqsnSalFromTag = "GVT_RQSN_SAL_FROM";
    private static String rqsnSalToTag = "GVT_RQSN_SAL_TO";
    private static String payFreqAbbrevTag = "PAY_FREQ_ABBRV";
    private static String currencyCdTag = "CURRENCY_CD";
    private static String salAdminPlanTag = "SAL_ADMIN_PLAN";
    private static String gradeTag = "GRADE";
    private static String travelPerctTag = "GVT_TRAVEL_PERCENT";
    private static String managerLvlTag = "MANAGER_LEVEL";
    private static String flsaStatusTag = "FLSA_STATUS";
    private static String summerApptTag = "GVT_SUMMER_APPT";
    private static String nteDateTag = "GVT_NTE_DATE";
    private static String nteDaysTag = "GVT_NTE_DAYS";
    private static String leoPositionTag = "GVT_LEO_POSITION";
    private static String posnSensCdTag = "GVT_POSN_SENS_CD";
    private static String apptTypeTag = "GVT_TYPE_OF_APPT";
	
    public static String getJobCodesTag() {
		return jobCodesTag;
	}
	public static String getJobcodeTag() {
		return jobcodeTag;
	}
	public static String getPrimaryJobcodeTag() {
		return primaryJobcodeTag;
	}
	public static String getRegRegionTag() {
		return regRegionTag;
	}
	public static String getDesiredFullPartTag() {
		return desiredFullPartTag;
	}
	public static String getDesiredRegTempTag() {
		return desiredRegTempTag;
	}
	public static String getStdHrsTag() {
		return stdHrsTag;
	}
	public static String getStdHrsFreqTag() {
		return stdHrsFreqTag;
	}
	public static String getDesiredShiftTag() {
		return desiredShiftTag;
	}
	public static String getRqsnSalFromTag() {
		return rqsnSalFromTag;
	}
	public static String getRqsnSalToTag() {
		return rqsnSalToTag;
	}
	public static String getPayFreqAbbrevTag() {
		return payFreqAbbrevTag;
	}
	public static String getCurrencyCdTag() {
		return currencyCdTag;
	}
	public static String getSalAdminPlanTag() {
		return salAdminPlanTag;
	}
	public static String getGradeTag() {
		return gradeTag;
	}
	public static String getTravelPerctTag() {
		return travelPerctTag;
	}
	public static String getManagerLvlTag() {
		return managerLvlTag;
	}
	public static String getFlsaStatusTag() {
		return flsaStatusTag;
	}
	public static String getSummerApptTag() {
		return summerApptTag;
	}
	public static String getNteDateTag() {
		return nteDateTag;
	}
	public static String getNteDaysTag() {
		return nteDaysTag;
	}
	public static String getLeoPositionTag() {
		return leoPositionTag;
	}
	public static String getPosnSensCdTag() {
		return posnSensCdTag;
	}
	public static String getApptTypeTag() {
		return apptTypeTag;
	}
       
}
