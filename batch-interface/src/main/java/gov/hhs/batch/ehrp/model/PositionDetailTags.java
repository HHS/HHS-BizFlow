package gov.hhs.batch.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class PositionDetailTags {

	private static String positionDetailTag =  "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS";
	private static String positionNbrTag = "POSITION_NBR";
	private static String reportsToTag = "POSITION_DETAIL/REPORTS_TO";
	private static String positionLocationTag = "POSITION_DETAIL/LOCATION";
	private static String numHoursTag = "POSITION_DETAIL/STD_HRS_DEFAULT";
	private static String bargainUnitTag = "POSITION_DETAIL/BARG_UNIT";
	private static String payPlanTag = "POSITION_DETAIL/GVT_PAY_PLAN";
	private static String workScheduleTag = "POSITION_DETAIL/GVT_WORK_SCHED";
	private static String positionTitleTag = "POSITION_DETAIL/GVT_ORG_TTL_DESCR";
	private static String drugTestReqTag = "POSITION_DETAIL/GVT_DRUG_TEST_REQ";
	private static String seriesTag = "POSITION_DETAIL/GVT_OCC_SERIES";
	private static String positionSensCodeTag = "POSITION_DETAIL/GVT_POSN_SENS_CD";
	private static String secClearanceTypeTag = "POSITION_DETAIL/SECURITY_CLEARANCE";
	private static String empFinIntTag = "POSITION_DETAIL/GVT_EMP_FIN_INT";
	private static String gradeTag = "POSITION_DETAIL/GRADE_DFLT";
	
	public static String getPositionDetailTag() {
		return positionDetailTag;
	}
	public static String getPositionNbrTag() {
		return positionNbrTag;
	}
	public static String getReportsToTag() {
		return reportsToTag;
	}
	public static String getPositionLocationTag() {
		return positionLocationTag;
	}
	public static String getNumHoursTag() {
		return numHoursTag;
	}
	public static String getBargainUnitTag() {
		return bargainUnitTag;
	}
	public static String getPayPlanTag() {
		return payPlanTag;
	}
	public static String getWorkScheduleTag() {
		return workScheduleTag;
	}
	public static String getPositionTitleTag() {
		return positionTitleTag;
	}
	public static String getDrugTestReqTag() {
		return drugTestReqTag;
	}
	public static String getSeriesTag() {
		return seriesTag;
	}
	public static String getPositionSensCodeTag() {
		return positionSensCodeTag;
	}
	public static String getSecClearanceTypeTag() {
		return secClearanceTypeTag;
	}
	public static String getEmpFinIntTag() {
		return empFinIntTag;
	}
	public static String getGradeTag() {
		return gradeTag;
	}
	
}
