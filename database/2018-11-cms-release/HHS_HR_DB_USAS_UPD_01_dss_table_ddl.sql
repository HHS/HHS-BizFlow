--------------------------------------------
-- Backout statement
--------------------------------------------
/*
DROP TABLE HHS_HR.DSS_TIME_TO_OFFER_STG;
DROP TABLE HHS_HR.DSS_TIME_TO_STAFF_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANNOUNCEMENT_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANN_LOCATION_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANN_REVIEW_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_CERTIFICATE_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_NEW_HIRE_STG;
DROP TABLE HHS_HR.DSS_TIME_TO_OFFER;
*/


SET DEFINE OFF;

--==================================

--Recreate DSS_TIME_TO_OFFER

--==================================
DROP TABLE HHS_HR.DSS_TIME_TO_OFFER;

------------------------------------
--DDL for table DSS_TIME_TO_OFFER_
------------------------------------
CREATE TABLE HHS_HR.DSS_TIME_TO_OFFER
(
    STAFFING_ORGANIZATION           VARCHAR2(122),
    REQUEST_NUMBER                  VARCHAR2(202),
    PD_NUMBER                       VARCHAR2(2050),
    NEW_HIRE_CREATE_DATE            DATE,
    REQUEST_STATUS                  VARCHAR2(1002),
    REQUEST_TYPE                    VARCHAR2(1002),
    POSITION_TITLE                  VARCHAR2(2050),
    AREA_CONSIDER                   VARCHAR2(24),
    NEW_HIRE_PAY_PLAN               VARCHAR2(2050),
    NEW_HIRE_SERIES                 VARCHAR2(2050),
    NEW_HIRE_GRADE                  VARCHAR2(2050),
    SEND_TENT_OFFR_CMPL_DATE        DATE,
    INIT_BKGRND_INVST_DATE          DATE,
    RCVE_BKGRND_INVST_DATE          DATE,
    SEND_OFCL_OFFR_CMPL_DATE        DATE,
    NEW_HIRE_NAME                   VARCHAR2(2050),
    EOD_DATE                        DATE
);

----------------------------------------------
--DDL for index DSS_TIME_TO_OFFER_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_TIME_TO_OFFER_I1 ON DSS_TIME_TO_OFFER (REQUEST_NUMBER);


--==================================

--STAGING TABLES

--==================================
--==================================
--CUSTOM REPORT TABLES
--==================================
---------------------
--CMS
---------------------

------------------------------------
--DDL for table DSS_TIME_TO_STAFF_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_TIME_TO_STAFF_STG
(
    STAFFING_ORGANIZATION           VARCHAR2(122),
    REQUEST_NUMBER                  VARCHAR2(202),
    REQUEST_CREATE_DATE             DATE,
    REQUEST_APPROVAL_DATE           DATE,
    REQUEST_STATUS                  VARCHAR2(1002),
    REQUEST_TYPE                    VARCHAR2(1002),
    POSITION_TITLE                  VARCHAR2(202),
    PAYPLAN_SERIES_GRADE            VARCHAR2(1000),
    AREA_CONSIDER                   VARCHAR2(24),
    CERTIFICATE_NUMBER              VARCHAR2(102),
    CERTIFICATE_SERIES              VARCHAR2(1028),
    CERTIFICATE_GRADE               VARCHAR2(502),
    CERTIFICATE_LOCATION            VARCHAR2(2050),
    CERTIFICATE_ISSUE_DATE          DATE,
    REVIEW_RETURN_DATE              DATE
);

----------------------------------------------
--DDL for index DSS_TIME_TO_STAFF_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_TIME_TO_STAFF_STG_I1 ON DSS_TIME_TO_STAFF_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_TIME_TO_OFFER_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_TIME_TO_OFFER_STG
(
    STAFFING_ORGANIZATION           VARCHAR2(122),
    REQUEST_NUMBER                  VARCHAR2(202),
    PD_NUMBER                       VARCHAR2(2050),
    NEW_HIRE_CREATE_DATE            DATE,
    REQUEST_STATUS                  VARCHAR2(1002),
    REQUEST_TYPE                    VARCHAR2(1002),
    POSITION_TITLE                  VARCHAR2(2050),
    AREA_CONSIDER                   VARCHAR2(24),
    NEW_HIRE_PAY_PLAN               VARCHAR2(2050),
    NEW_HIRE_SERIES                 VARCHAR2(2050),
    NEW_HIRE_GRADE                  VARCHAR2(2050),
    SEND_TENT_OFFR_CMPL_DATE        DATE,
    INIT_BKGRND_INVST_DATE          DATE,
    RCVE_BKGRND_INVST_DATE          DATE,
    SEND_OFCL_OFFR_CMPL_DATE        DATE,
    NEW_HIRE_NAME                   VARCHAR2(2050),
    EOD_DATE                        DATE
);

----------------------------------------------
--DDL for index DSS_TIME_TO_OFFER_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_TIME_TO_OFFER_STG_I1 ON DSS_TIME_TO_OFFER_STG (REQUEST_NUMBER);

---------------------
--IHS
---------------------

--==================================
--CUSTOM REPORT TABLES
--==================================
------------------------------------
--DDL for table DSS_IHS_VAC_ANNOUNCEMENT_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_ANNOUNCEMENT_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    VIN                         NUMBER(10),
    REQUEST_CREATE_DATE         DATE,
    REQUEST_STATUS              VARCHAR2(1002),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    VACANCY_TYPE                VARCHAR2(1002),
    VACANCY_STATUS              VARCHAR2(1002),
    JOB_TITLE                   VARCHAR2(202),
    PAY_PLAN                    VARCHAR2(102),
    SERIES                      VARCHAR2(22),
    GRADE                       VARCHAR2(6),
    OPEN_DATE                   DATE,
    CLOSE_DATE                  DATE,
    ANNOUNCEMENT_TYPE           VARCHAR2(24),
    ANNOUNCEMENT_CTRL_NUMBER    NUMBER(10),
    ANNOUNCEMENT_STATUS         VARCHAR2(1002),
    IS_RELEASED                 VARCHAR2(8),
    RELEASED_DATE               DATE,
    LAST_UPDATE_DATE            DATE,
    REQUEST_CANCEL_DATE         DATE,
    REQUEST_CANCEL_REASON       VARCHAR2(2050)
);

----------------------------------------------
--DDL for index DSS_IHS_VAC_ANN_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_ANN_STG_I1 ON DSS_IHS_VAC_ANNOUNCEMENT_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_ANN_LOCATION_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_ANN_LOCATION_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    VIN                         NUMBER(10),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    LOCATION                    VARCHAR2(334)
);

----------------------------------------------
--DDL for index DSS_IHS_VAC_ANN_LOC_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_ANN_LOC_STG_I1 ON DSS_IHS_VAC_ANN_LOCATION_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_ANN_REVIEW_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_ANN_REVIEW_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    VIN                         NUMBER(10),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    REVIEW_STATUS               VARCHAR2(1002),
    REVIEW_JOA_DATE             DATE,
    REVIEW_JOA_SENT_DATE        DATE,
    REVIEW_JOA_RETURN_DATE      DATE,
    IS_ANNOUNCEMENT_TEXT        VARCHAR2(8),
    IS_CERTIFICATE_REVIEW       VARCHAR2(8)
);

----------------------------------------------
--DDL for index DSS_IHS_VAC_ANN_REVIEW_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_ANN_REVIEW_STG_I1 ON DSS_IHS_VAC_ANN_REVIEW_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_CERTIFICATE_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_CERTIFICATE_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    VIN                         NUMBER(10),
    REQUEST_STATUS              VARCHAR2(1002),
    CERTIFICATE_NUMBER          VARCHAR2(102),
    CERTIFICATE_TYPE            VARCHAR2(82),
    VACANCY_STATUS              VARCHAR2(1002),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    IS_PUBLIC                   VARCHAR2(8),
    IS_STATUS                   VARCHAR2(8),
    DISPLAY_TYPE                VARCHAR2(24),
    ISSUE_DATE                  DATE,
    REVIEW_STATUS               VARCHAR2(1002),
    REVIEW_DUE_DATE             DATE,
    REVIEW_RETURN_DATE          DATE,
    RETURN_STATUS               VARCHAR2(1002),
    AUDIT_CODE                  VARCHAR2(82),
    AUDIT_DATE                  DATE,
    LAST_UPDATE_DATE            DATE,
    POSITION_TITLE              VARCHAR2(202),
    DUTY_LOCATION               VARCHAR2(334),
    PAYPLAN_SERIES_GRADE        VARCHAR2(1000),
    HIRING_PLAN                 VARCHAR2(6),
    APPLICANT_LIST_NAME         VARCHAR2(6),
    CERTIFICATION_STATUS        VARCHAR2(1508),
    ELIGIBILITY_FILTER          VARCHAR2(202)
);

----------------------------------------------
--DDL for index DSS_IHS_VAC_CERTIFICATE_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_CERTIFICATE_STG_I1 ON DSS_IHS_VAC_CERTIFICATE_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_NEW_HIRE_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_NEW_HIRE_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    NEW_HIRE_NUMBER             VARCHAR2(22),
    NEW_HIRE_STATUS             VARCHAR2(1002),
    NEW_HIRE_NAME               VARCHAR2(2050),
    POSITION_TITLE              VARCHAR2(2050),
    DUTY_LOCATION               VARCHAR2(2050),
    PAYPLAN_SERIES_GRADE        VARCHAR2(1000),
    PAY_PLAN                    VARCHAR2(102),
    SERIES                      VARCHAR2(22),
    GRADE                       VARCHAR2(6),
    SEND_TENT_OFFR_CMPL_DATE    DATE,
    SEND_OFCL_OFFR_CMPL_DATE    DATE,
    EFFECTIVE_DATE              DATE,
    LAST_UPDATE_DATE            DATE,
    VET_PREF_STATUS             VARCHAR2(2050),
    PROJ_START_DATE             DATE,
    ARRVL_VERIF_CMPL_DATE       DATE
);

----------------------------------------------
--DDL for index DSS_IHS_VAC_NEW_HIRE_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_NEW_HIRE_STG_I1 ON DSS_IHS_VAC_NEW_HIRE_STG (REQUEST_NUMBER);
