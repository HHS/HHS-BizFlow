package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeReplacementTags {

    private static String employeeReplacementTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/Employee_Replacement"; 
    private static String viceEmplidTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/Employee_Replacement/Vice_EMPLID";
    private static String dateVacatedTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/Employee_Replacement/Date_Vacated";
	
    public static String getEmployeeReplacementTag() {
		return employeeReplacementTag;
	}
	public static String getViceEmplidTag() {
		return viceEmplidTag;
	}
	public static String getDateVacatedTag() {
		return dateVacatedTag;
	}    
    
}
