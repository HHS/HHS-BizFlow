package gov.hhs.batch.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class OpeningsTags {

    private static String openingsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/OPENINGS";
    private static String locationTag = "LOCATION";
    private static String primaryLocTag = "HRS_JO_PRM_LOC_FLG";
    private static String descrTag  = "OPENING_DETAIL/DESCR";
	
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
