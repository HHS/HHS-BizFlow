CREATE OR REPLACE PACKAGE HHS_HR.EHRP_REF_DATA_PKS AS

  /* TODO enter package declarations (types, exceptions, methods etc) here */ 
--======================================================

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_DEPT_TBL
--DESCRIPTION: Insert new records into PS_DEPT_TBL table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_DEPT_TBL;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HE_RECRUIT_EWIT
--DESCRIPTION: Insert new records into PS_HE_RECRUIT_EWIT table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HE_RECRUIT_EWIT;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HRS_JO_LOC
--DESCRIPTION: Insert new records into PS_HRS_JO_LOC table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_LOC;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HRS_JO_NAME
--DESCRIPTION: Insert new records into PS_HRS_JO_NAME table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_NAME;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HRS_JO_POSN
--DESCRIPTION: Insert new records into PS_HRS_JO_POSN table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_POSN;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HRS_JO_RPL
--DESCRIPTION: Insert new records into PS_HRS_JO_RPL table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_RPL;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HRS_JO_RQMT
--DESCRIPTION: Insert new records into PS_HRS_JO_RQMT table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_RQMT;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HRS_JOB_OPENING
--DESCRIPTION: Insert new records into PS_HRS_JOB_OPENING table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JOB_OPENING;


--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_JOBCODE_TBL
--DESCRIPTION: Insert new records into PS_JOBCODE_TBL table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_JOBCODE_TBL;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_POSITION_DATA
--DESCRIPTION: Insert new records into PS_POSITION_DATA table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_POSITION_DATA;

--------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_SAL_GRADE_TBL
--DESCRIPTION: Insert new records into PS_SAL_GRADE_TBL table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_SAL_GRADE_TBL;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HRS_LOC
--DESCRIPTION : Inserts new records into
-- PS_HRS_LOCATION_I table, from BIIS
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_LOC;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_PERSONAL_VW
--DESCRIPTION : Inserts new records into
-- PS_PERSONAL_DATA_VW table, from BIIS
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_PERSONAL_VW;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_GVT_RQSN_JOBCD
--DESCRIPTION : Inserts new records into
-- PS_GVT_RQSN_JOBCD table, from BIIS
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_GVT_RQSN_JOBCD;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_GVT_RQSN_POSN
--DESCRIPTION : Inserts new records into
-- PS_GVT_RQSN_POSN table, from BIIS
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_GVT_RQSN_POSN;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HE_GVT_RQSN_PRT
--DESCRIPTION : Inserts new records into
-- PS_HE_GVT_RQSN_PRT table, from BIIS
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HE_GVT_RQSN_PRT;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_HE_JO_APPR_COMM
--DESCRIPTION : Inserts new records into
-- PS_HE_JO_APPR_COMM table, from BIIS
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HE_JO_APPR_COMM;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_OPR_DEFN
--DESCRIPTION : Inserts new records into
-- PS_OPR_DEFN table
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_OPR_DEFN;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_GVT_EMPL
--DESCRIPTION : Inserts new records into
-- PS_GVT_EMPLOYMENT table
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_GVT_EMPL;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_GVT_JOB
--DESCRIPTION : Inserts new records into
-- PS_GVT_JOB table
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_GVT_JOB;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_EMPL_RVW
--DESCRIPTION : Inserts new records into
-- PS_EMPLOYEE_REVIEW table
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_EMPL_RVW;

-------------------------------------------------------------
--PROCEDURE: INSERT_EHRP_PS_PAR_RMKS
--DESCRIPTION : Inserts new records into
-- PS_GVT_PAR_REMARKS table
-------------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_PAR_RMKS;

--------------------------------------------------------
--PROCEDURE: FN_IMPORT_REF_DATA
--DESCRIPTION: FN_IMPORT_REF_DATA will be called by spring batch, which will call individual procedures in the package.
--------------------------------------------------------
FUNCTION FN_IMPORT_EHRP_REF_DATA 
RETURN VARCHAR2;

--------------------------------------------------------
--PROCEDURE: ERROR_LOG
--DESCRIPTION: Return SQLCODE and SQLERRM
--------------------------------------------------------
FUNCTION ERROR_LOG 
RETURN VARCHAR2;

END EHRP_REF_DATA_PKS;
/
