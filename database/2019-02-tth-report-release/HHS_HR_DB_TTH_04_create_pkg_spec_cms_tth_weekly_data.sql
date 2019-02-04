CREATE OR REPLACE PACKAGE HHS_HR.CMS_TTH_WEEKLY_DATA_PKS AS
--==========================================================

--------------------------------------------------------------------------
--PROCEDURE: INSERT_CMS_TTH_WEEKLY_DATA
--DESCRIPTION: Insert new records into CMS_TIME_TO_HIRE_WEEKLY_PILOT table
--------------------------------------------------------------------------
PROCEDURE INSERT_CMS_TTH_WEEKLY_DATA;

--------------------------------------------------------------------------
--PROCEDURE: FN_IMPORT_CMS_TTH_WEEKLY_DATA
--DESCRIPTION: FN_IMPORT_CMS_TTH_WEEKLY_DATA will be called by Oracle job, 
--which will call individual procedures in the package.
--------------------------------------------------------------------------
FUNCTION FN_IMPORT_CMS_TTH_WEEKLY_DATA 
RETURN VARCHAR2;

--------------------------------------------------------
--PROCEDURE: ERROR_LOG
--DESCRIPTION: Return SQLCODE and SQLERRM
--------------------------------------------------------
FUNCTION ERROR_LOG 
RETURN VARCHAR2;


END CMS_TTH_WEEKLY_DATA_PKS;
/