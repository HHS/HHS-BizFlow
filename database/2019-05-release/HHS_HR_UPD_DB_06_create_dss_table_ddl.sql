------------------------------------
--DDL for table DSS_CMS_REQUESTS
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_REQUESTS
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_CREATE_DATE         DATE,
    REQUEST_STATUS              VARCHAR2(1002),
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
