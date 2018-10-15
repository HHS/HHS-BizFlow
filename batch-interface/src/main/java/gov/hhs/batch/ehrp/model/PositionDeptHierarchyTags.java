package gov.hhs.batch.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class PositionDeptHierarchyTags {

    private static String deptHierarchyTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS";
    private static String positionNbrTag = "POSITION_NBR";
    private static String setIdTag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/SETID";
    private static String deptIdTag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/DEPTID";
    private static String deptDescTag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/DESCR";
    private static String deptId2Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_LINE2";
    private static String deptDesc2Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_DESCR2";
    private static String deptId3Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_LINE3";
    private static String deptDesc3Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_DESCR3";
    private static String deptId4Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_LINE4";
    private static String deptDesc4Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_DESCR4";
    private static String deptId5Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_LINE5";
    private static String deptDesc5Tag = "POSITION_DETAIL/POSITION_DEPARTMENT_HIERARCHY/GVT_PAR_DESCR5";
	
    public static String getDeptHierarchyTag() {
		return deptHierarchyTag;
	}
	public static String getPositionNbrTag() {
		return positionNbrTag;
	}
	public static String getSetIdTag() {
		return setIdTag;
	}
	public static String getDeptIdTag() {
		return deptIdTag;
	}
	public static String getDeptDescTag() {
		return deptDescTag;
	}
	public static String getDeptId2Tag() {
		return deptId2Tag;
	}
	public static String getDeptDesc2Tag() {
		return deptDesc2Tag;
	}
	public static String getDeptId3Tag() {
		return deptId3Tag;
	}
	public static String getDeptDesc3Tag() {
		return deptDesc3Tag;
	}
	public static String getDeptId4Tag() {
		return deptId4Tag;
	}
	public static String getDeptDesc4Tag() {
		return deptDesc4Tag;
	}
	public static String getDeptId5Tag() {
		return deptId5Tag;
	}
	public static String getDeptDesc5Tag() {
		return deptDesc5Tag;
	}
    
}
