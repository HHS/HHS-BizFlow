CREATE OR REPLACE PACKAGE EHRP_REF_DATA_PKS AS

  /* TODO enter package declarations (types, exceptions, methods etc) here */ 
--======================================================

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_DEPT_TBL
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_DEPT_TBL table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_DEPT_TBL;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HE_EWIT_DEPT_1
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HE_EWIT_DEPT_1 table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HE_EWIT_DEPT_1;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HE_RECRUIT_EWIT
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HE_RECRUIT_EWIT table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HE_RECRUIT_EWIT;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HRS_JO_LOC
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HRS_JO_LOC table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_LOC;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HRS_JO_NAME
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HRS_JO_NAME table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_NAME;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HRS_JO_POSN
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HRS_JO_POSN table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_POSN;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HRS_JO_RPL
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HRS_JO_RPL table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_RPL;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HRS_JO_RQMT
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HRS_JO_RQMT table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JO_RQMT;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_HRS_JOB_OPENING
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_HRS_JOB_OPENING table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_HRS_JOB_OPENING;


--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_JOBCODE_TBL
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_JOBCODE_TBL table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_JOBCODE_TBL;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_POSITION_DATA
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_POSITION_DATA table
--------------------------------------------------------
PROCEDURE INSERT_EHRP_PS_POSITION_DATA;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EHRP_PS_SAL_GRADE_TBL
--DESCRIPTION: Insert new records into SP_INSERT_EHRP_PS_SAL_GRADE_TBL table
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

--------------------------------------------------------
--PROCEDURE: FN_IMPORT_REF_DATA
--DESCRIPTION: FN_IMPORT_REF_DATA will be called by spring batch, which will call individual procedures in the package.
--------------------------------------------------------
FUNCTION FN_IMPORT_EHRP_REF_DATA 
RETURN VARCHAR2;

--------------------------------------------------------
--PROCEDURE: SP_ERROR_LOG
--DESCRIPTION: Return SQLCODE and SQLERRM
--------------------------------------------------------
FUNCTION ERROR_LOG 
RETURN VARCHAR2;

END EHRP_REF_DATA_PKS;
/
