package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class SalaryDetailTags {

    private static String salaryDetailTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/SALARY_DETAIL";
    private static String salaryMinTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/SALARY_DETAIL/MIN_RT_ANNUAL";
    private static String salaryMaxTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/JOBCODES/SALARY_DETAIL/MAX_RT_ANNUAL";
	
    public static String getSalaryDetailTag() {
		return salaryDetailTag;
	}
	public static String getSalaryMinTag() {
		return salaryMinTag;
	}
	public static String getSalaryMaxTag() {
		return salaryMaxTag;
	}
    
}
