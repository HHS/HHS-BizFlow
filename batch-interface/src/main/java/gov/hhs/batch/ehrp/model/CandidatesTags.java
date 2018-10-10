package gov.hhs.batch.ehrp.model;

import org.springframework.stereotype.Component;

@Component
public class CandidatesTags {

    //Candidates
    private static String applicantsTag = "HE_EWITS_RECRUIT_OB/MsgData/Transaction/REQUISITION_DETAIL/CANDIDATES";
    private static String seqNbrTag = "SEQUENCE_NBR";
    private static String applicantNameTag = "NAME";
	
    public static String getApplicantsTag() {
		return applicantsTag;
	}
	public static String getSeqNbrTag() {
		return seqNbrTag;
	}
	public static String getApplicantNameTag() {
		return applicantNameTag;
	}
    
}
