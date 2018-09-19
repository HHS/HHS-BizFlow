package gov.hhs.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class OpeningsTags {

    private static String openingsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/OPENINGS";
    private static String locationTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/OPENINGS/LOCATION";
    private static String primaryLocTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/OPENINGS/HRS_JO_PRM_LOC_FLG";
    private static String descrTag  = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/OPENINGS/OPENING_DETAIL/DESCR";
	
    public static String getOpeningsTag() {
		return openingsTag;
	}
	public static String getLocationTag() {
		return locationTag;
	}
	public static String getPrimaryLocTag() {
		return primaryLocTag;
	}
	public static String getDescrTag() {
		return descrTag;
	}   
    
}
