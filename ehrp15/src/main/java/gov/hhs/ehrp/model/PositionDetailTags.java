package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class PositionDetailTags {

	private static String positionDetailTag =  "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL";
	private static String reportsToTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/REPORTS_TO";
	private static String positionLocationTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/LOCATION";
	private static String numHoursTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/STD_HRS_DEFAULT";
	private static String bargainUnitTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/BARG_UNIT";
	private static String payPlanTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GVT_PAY_PLAN";
	private static String workScheduleTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GVT_WORK_SCHED";
	private static String positionTitleTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GVT_ORG_TTL_DESCR";
	private static String drugTestReqTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GVT_DRUG_TEST_REQ";
	private static String seriesTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GVT_OCC_SERIES";
	private static String positionSensCodeTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GVT_POSN_SENS_CD";
	private static String secClearanceTypeTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/SECURITY_CLEARANCE";
	private static String empFinIntTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GVT_EMP_FIN_INT";
	private static String gradeTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_DETAIL/GRADE_DFLT";
	
	public static String getPositionDetailTag() {
		return positionDetailTag;
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
