package gov.hhs.batch.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class ApprovalsTags {

    private static String approvalsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/APPROVALS"; 
    private static String stepTag = "Step";
    private static String statusTag = "Status";
    private static String statusDtTag = "STATUS_DT"; 
    private static String opridTag = "OPRID"; 
    private static String emplidTag = "EMPLID";
    private static String commentsTag = "COMMENTS";
	
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
