package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeReplacementTags {

    private static String employeeReplacementTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/Employee_Replacement"; 
    private static String viceEmplidTag = "Vice_EMPLID";
    private static String dateVacatedTag = "Date_Vacated";
    private static String viceNameTag = "Employee_Name/Vice_Name";
	
    public static String getEmployeeReplacementTag() {
		return employeeReplacementTag;
	}
	public static String getViceEmplidTag() {
		return viceEmplidTag;
	}
	public static String getDateVacatedTag() {
		return dateVacatedTag;
	}
	public static String getViceNameTag() {
		return viceNameTag;
	}
	public static void setViceNameTag(String viceNameTag) {
		EmployeeReplacementTags.viceNameTag = viceNameTag;
	}
	public static void setEmployeeReplacementTag(String employeeReplacementTag) {
		EmployeeReplacementTags.employeeReplacementTag = employeeReplacementTag;
	}
	public static void setViceEmplidTag(String viceEmplidTag) {
		EmployeeReplacementTags.viceEmplidTag = viceEmplidTag;
	}
	public static void setDateVacatedTag(String dateVacatedTag) {
		EmployeeReplacementTags.dateVacatedTag = dateVacatedTag;
	}    
}
