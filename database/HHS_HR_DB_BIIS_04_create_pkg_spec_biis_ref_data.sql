CREATE OR REPLACE PACKAGE REF_DATA_PKS AS

--======================================================

--------------------------------------------------------
--PROCEDURE: SP_INSERT_DUTY_STATION
--DESCRIPTION: Insert new records into DUTY_STATION table
--------------------------------------------------------
PROCEDURE SP_INSERT_DUTY_STATION;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_PAY_PLAN
--DESCRIPTION: Insert new records into PAY_PLAN table
--------------------------------------------------------
PROCEDURE SP_INSERT_PAY_PLAN;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_LEGAL_AUTHORITY
--DESCRIPTION: Insert new records into LEGAL_AUTHORITY table
--------------------------------------------------------
PROCEDURE SP_INSERT_LEGAL_AUTHORITY;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_NATURE_OF_ACTION
--DESCRIPTION: Insert new records into NATURE_OF_ACTION table
--------------------------------------------------------
PROCEDURE SP_INSERT_NATURE_OF_ACTION;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_OCCUPATIONAL_SERIES
--DESCRIPTION: Insert new records into OCCUPATIONAL_SERIES table
--------------------------------------------------------
PROCEDURE SP_INSERT_OCCUPATIONAL_SERIES;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_CYBERSECURITY_CODE
--DESCRIPTION: Insert new records into CYBERSECURITY_CODE table
--------------------------------------------------------
PROCEDURE SP_INSERT_CYBERSECURITY_CODE;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_ADMIN_CODE
--DESCRIPTION: Insert new records into ADMINISTRATIVE_CODE table
--------------------------------------------------------
PROCEDURE SP_INSERT_ADMINCODE;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_APPOINTMENT_TYPE
--DESCRIPTION: Insert new records into APPOINTMENT TYPE table
--------------------------------------------------------
PROCEDURE SP_INSERT_APPOINTMENT_TYPE;

--------------------------------------------------------
--PROCEDURE: FN_IMPORT_REF_DATA
--DESCRIPTION: FN_IMPORT_REF_DATA will be called by spring batch, which will call individual procedures in the package.
--------------------------------------------------------
FUNCTION FN_IMPORT_REF_DATA 
RETURN VARCHAR2;

--------------------------------------------------------
--PROCEDURE: SP_ERROR_LOG
--DESCRIPTION: Return SQLCODE and SQLERRM
--------------------------------------------------------
FUNCTION ERROR_LOG
RETURN VARCHAR2;

END REF_DATA_PKS;
/
