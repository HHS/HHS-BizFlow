------------------------------------
--DDL for table ADMINISTRATIVE_CODE
----------------------------------
ALTER TABLE HHS_HR.ADMINISTRATIVE_CODE
MODIFY (EEOC_OPDIV VARCHAR2(30));


---------------------------------
--Create index on EMPLOYEE_LOOKUP
---------------------------------
CREATE INDEX EMPLOYEE_LOOKUP_IDX1 ON HHS_HR.EMPLOYEE_LOOKUP (EMPLID);