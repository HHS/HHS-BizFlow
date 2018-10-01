package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class EwitsDetailsTags {

    //eWITS Details
    private static String ewitsDetailsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/eWITS_Details";
    private static String nonStandardPay = "Non_Standard_Pay";
    private static String physicianDentistPay = "Physician_Dentist_Pay";
    private static String physicianCompAllowance = "Physician_Comp_Allowance";
    private static String relocationIncentive = "Relocation_Incentive";
    private static String recruitmentIncentive = "Recruitment_Incentive";
    private static String positionDescription = "Position_Description";
    private static String can = "CAN";
	
    public static String getEwitsDetailsTag() {
		return ewitsDetailsTag;
	}
	public static String getNonStandardPay() {
		return nonStandardPay;
	}
	public static String getPhysicianDentistPay() {
		return physicianDentistPay;
	}
	public static String getPhysicianCompAllowance() {
		return physicianCompAllowance;
	}
	public static String getRelocationIncentive() {
		return relocationIncentive;
	}
	public static String getRecruitmentIncentive() {
		return recruitmentIncentive;
	}
	public static String getPositionDescription() {
		return positionDescription;
	}
	public static String getCan() {
		return can;
	}
    
    
}
