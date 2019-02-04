
----------------------------------
-- grant for HHS_HR_RW_ROLE
----------------------------------

GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.LIST_MEM_JOB_OPEN_SEARCH TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.CANDIDATE TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.LIST TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.CANDIDATE_LIST TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.SEARCH_OCC_SERIES TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.SEARCH_GRADE TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.LIST_SEARCH_CANDIDATE TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.ELIGIBILITY_LOC_PREFER TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.CANDIDATE_GRADE TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.CANDIDATE_OCC_SERIES TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.ATTACHMENT TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.USER_PERMISSION TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.HHS_LIST_MANAGER_LOOKUP TO HHS_HR_RW_ROLE;
GRANT DELETE, INSERT, SELECT, UPDATE ON HHS_HR.ATTACHMENT TO BIZFLOW;


GRANT EXECUTE ON HHS_HR.FN_GET_DISTANCE TO HHS_HR_RW_ROLE;
GRANT EXECUTE ON HHS_HR.FN_GET_SEARCH_ID TO HHS_HR_RW_ROLE;
