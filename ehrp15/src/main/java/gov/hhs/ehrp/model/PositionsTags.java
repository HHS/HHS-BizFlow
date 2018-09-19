package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class PositionsTags {

    //Positions
    private static String positionsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS";
    private static String positionNbrTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/POSITION_NBR";
    private static String primaryPosnTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/POSITIONS/HRS_JO_PRM_PSN_FLG";
	
    public static String getPositionsTag() {
		return positionsTag;
	}
	public static String getPositionNbrTag() {
		return positionNbrTag;
	}
	public static String getPrimaryPosnTag() {
		return primaryPosnTag;
	}
       
}
