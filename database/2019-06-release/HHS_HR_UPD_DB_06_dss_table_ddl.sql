------------------------------------
--DDL for table DSS_CMS_REQUESTS
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_REQUESTS
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_CREATE_DATE         DATE,
    REQUEST_STATUS              VARCHAR2(1002),
    REQUEST_TYPE				VARCHAR2(1002),
    CUSTOMER_NAME               VARCHAR2(202),
	SERIES                      VARCHAR2(22),
	GRADE                       VARCHAR2(6),
	POSITION_TITLE              VARCHAR2(202),
	APPROVER_NAME               VARCHAR2(206)
);

----------------------------------------------
--DDL for index DSS_CMS_REQUESTS_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CMS_REQUESTS_I1 ON DSS_CMS_REQUESTS (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CMS_REQUESTS_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_REQUESTS_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_CREATE_DATE         DATE,
    REQUEST_STATUS              VARCHAR2(1002),
    REQUEST_TYPE				VARCHAR2(1002),
    CUSTOMER_NAME               VARCHAR2(202),
	SERIES                      VARCHAR2(22),
	GRADE                       VARCHAR2(6),
	POSITION_TITLE              VARCHAR2(202),
	APPROVER_NAME               VARCHAR2(206)
);

----------------------------------------------
--DDL for index DSS_CMS_REQUESTS_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CMS_REQUESTS_STG_I1 ON DSS_CMS_REQUESTS_STG (REQUEST_NUMBER);


---------------------------------------
--DDL for table DSS_CMS_TIME_OF_POSSESS
---------------------------------------
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS
	ADD INIT_BKGRND_INVST_DATE DATE;
	
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS 
	ADD (REQUEST_TYPE VARCHAR2(1002));

ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS 
	ADD (REQUEST_STATUS VARCHAR2(1002));
	
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS
	ADD REQUEST_CREATE_DATE DATE;
	
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS
	ADD ARRVL_VERIF_CMPL_DATE DATE;	
		
-------------------------------------------
--DDL for table DSS_CMS_TIME_OF_POSSESS_STG
-------------------------------------------
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
	ADD INIT_BKGRND_INVST_DATE DATE;
	
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
	ADD (REQUEST_TYPE VARCHAR2(1002));

ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
	ADD (REQUEST_STATUS VARCHAR2(1002));
	
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
	ADD REQUEST_CREATE_DATE DATE;
	
ALTER TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
	ADD ARRVL_VERIF_CMPL_DATE DATE;
	
	
----------------------------------------------
--DDL for index DSS_TIME_TO_OFFER
----------------------------------------------	
CREATE INDEX HHS_HR.DSS_TIME_TO_OFFER_I2 ON DSS_TIME_TO_OFFER (NEW_HIRE_NAME);
CREATE INDEX HHS_HR.DSS_TIME_TO_OFFER_STG_I2 ON DSS_TIME_TO_OFFER_STG (NEW_HIRE_NAME);