package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class ApprovalsTags {

    private static String approvalsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS";
    private static String stepTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS/Step";
    private static String statusTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS/Status";
    private static String statusDtTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS/STATUS_DT"; 
    private static String opridTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS/OPRID"; 
    private static String emplidTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS/EMPLID";
    private static String commentsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS/COMMENTS";
	
    public static String getApprovalsTag() {
		return approvalsTag;
	}
	public static String getStepTag() {
		return stepTag;
	}
	public static String getStatusTag() {
		return statusTag;
	}
	public static String getStatusDtTag() {
		return statusDtTag;
	}
	public static String getOpridTag() {
		return opridTag;
	}
	public static String getEmplidTag() {
		return emplidTag;
	}
	public static String getCommentsTag() {
		return commentsTag;
	}  
    
}
