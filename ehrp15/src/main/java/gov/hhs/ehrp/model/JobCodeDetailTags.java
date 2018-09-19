package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class JobCodeDetailTags {

    private static String jobcodeDetailTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL";
    private static String salAdminPlanTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL/SAL_ADMIN_PLAN";
    private static String gradeTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL/GRADE";
    private static String payPlanTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL/GVT_PAY_PLAN";
    private static String seriesTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL/GVT_OCC_SERIES";
    private static String officialDescrTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL/GVT_OFFICIAL_DESCR";
    private static String finDisclReqTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL/GVT_EXEC_FIN_DISCL";
    private static String targetGradeTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/JOBCODE_DETAIL/GVT_TARGET_GRADE";
	
    public static String getJobcodeDetailTag() {
		return jobcodeDetailTag;
	}
	public static String getSalAdminPlanTag() {
		return salAdminPlanTag;
	}
	public static String getGradeTag() {
		return gradeTag;
	}
	public static String getPayPlanTag() {
		return payPlanTag;
	}
	public static String getSeriesTag() {
		return seriesTag;
	}
	public static String getOfficialDescrTag() {
		return officialDescrTag;
	}
	public static String getFinDisclReqTag() {
		return finDisclReqTag;
	}
	public static String getTargetGradeTag() {
		return targetGradeTag;
	}
     
}
