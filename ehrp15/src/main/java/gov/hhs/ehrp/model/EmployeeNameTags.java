package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeNameTags {

	private static String employeeNameTags =  "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/Employee_Name";
    private static String viceNameTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/Employee_Name/Vice_Name";
	
    public static String getEmployeeNameTags() {
		return employeeNameTags;
	}
	public static String getViceNameTag() {
		return viceNameTag;
	}
    
}
