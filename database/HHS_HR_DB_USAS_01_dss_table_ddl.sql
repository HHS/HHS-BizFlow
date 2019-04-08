--------------------------------------------
-- Backout statement
--------------------------------------------
/*
DROP TABLE HHS_HR.DSS_ANNOUNCEMENT_DETAIL;
DROP TABLE HHS_HR.DSS_ANNOUNCEMENT_APPT_TYPE;
DROP TABLE HHS_HR.DSS_ANNOUNCEMENT_WORK_SCHED;
DROP TABLE HHS_HR.DSS_ANNOUNCEMENT_LOCATION;
DROP TABLE HHS_HR.DSS_APPLICATION_DETAIL;
DROP TABLE HHS_HR.DSS_APPLICATION_DOCUMENT;
DROP TABLE HHS_HR.DSS_APPLICATION_LOCATION;
DROP TABLE HHS_HR.DSS_APPLICATION_ELIGIBILITY;
DROP TABLE HHS_HR.DSS_APPLICANT_PHONE;
DROP TABLE HHS_HR.DSS_APPLICATION_RATING;
DROP TABLE HHS_HR.DSS_CERTIFICATE;
DROP TABLE HHS_HR.DSS_CERTIFICATE_APP;
DROP TABLE HHS_HR.DSS_NEW_HIRE;
DROP TABLE HHS_HR.DSS_REQUEST_DETAIL;
DROP TABLE HHS_HR.DSS_REQUEST_APPT_TYPE;
DROP TABLE HHS_HR.DSS_REQUEST_SPECIALTY;
DROP TABLE HHS_HR.DSS_REQUEST_POSITION;
DROP TABLE HHS_HR.DSS_REQUEST_LOCATION;
DROP TABLE HHS_HR.DSS_REQUEST_WORK_SCHED;
DROP TABLE HHS_HR.DSS_REQUEST_VACANCY;
DROP TABLE HHS_HR.DSS_REVIEW_DETAIL;
DROP TABLE HHS_HR.DSS_TASK_DETAIL;
DROP TABLE HHS_HR.DSS_VACANCY_DETAIL;
DROP TABLE HHS_HR.DSS_VACANCY_CUSTOMER;
DROP TABLE HHS_HR.DSS_VACANCY_ELIGIBILITY;
DROP TABLE HHS_HR.DSS_VACANCY_POSITION;
DROP TABLE HHS_HR.DSS_VACANCY_SPECIALTY;
DROP TABLE HHS_HR.DSS_VACANCY_DOCUMENT;
DROP TABLE HHS_HR.DSS_VACANCY_REQUEST;
DROP TABLE HHS_HR.DSS_TIME_TO_OFFER;
DROP TABLE HHS_HR.DSS_TIME_TO_STAFF;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANNOUNCEMENT;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANN_LOCATION;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANN_REVIEW;
DROP TABLE HHS_HR.DSS_IHS_VAC_CERTIFICATE;
DROP TABLE HHS_HR.DSS_IHS_VAC_NEW_HIRE;
DROP TABLE HHS_HR.AREA_CONSIDERATION;
DROP TABLE HHS_HR.DSS_TIME_TO_OFFER_STG;
DROP TABLE HHS_HR.DSS_TIME_TO_STAFF_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANNOUNCEMENT_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANN_LOCATION_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_ANN_REVIEW_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_CERTIFICATE_STG;
DROP TABLE HHS_HR.DSS_IHS_VAC_NEW_HIRE_STG;
DROP TABLE HHS_HR.DSS_CDC_TIME_TO_OFFER;
DROP TABLE HHS_HR.DSS_CDC_TIME_TO_STAFF;
DROP TABLE HHS_HR.DSS_CDC_CERTIFICATE;
DROP TABLE HHS_HR.DSS_CDC_TIME_TO_OFFER_STG;
DROP TABLE HHS_HR.DSS_CDC_TIME_TO_STAFF_STG;
DROP TABLE HHS_HR.DSS_CDC_CERTIFICATE_STG;
DROP TABLE HHS_HR.DSS_CDC_CERT_AUDIT;
DROP TABLE HHS_HR.DSS_CDC_CERT_AUDIT_STG;
DROP TABLE HHS_HR.DSS_CDC_ANNOUNCEMENT;
DROP TABLE HHS_HR.DSS_CDC_ANNOUNCEMENT_STG;
DROP TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS;
DROP TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG;
DROP TABLE HHS_HR.DSS_CMS_TIME_TO_HIRE;
DROP TABLE HHS_HR.DSS_CMS_TIME_TO_HIRE_STG;
DROP TABLE HHS_HR.DSS_CMS_REQUESTS;
DROP TABLE HHS_HR.DSS_CMS_REQUESTS_STG;
*/



SET DEFINE OFF;


--==================================
--ANNOUNCEMENT TABLES
--==================================

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_DETAIL
------------------------------------
CREATE TABLE HHS_HR.DSS_ANNOUNCEMENT_DETAIL
(
    ANNOUNCEMENT_NUMBER     VARCHAR2(56),
    VACANCY_NUMBER          NUMBER(10),
    ANN_CONTROL_NUMBER      NUMBER(10),
    ANNOUNCEMENT_STATUS     VARCHAR2(1002),
    IS_RELEASED             VARCHAR2(8),
    RELEASED_DATE           DATE,
    LAST_UPDATE_DATE        DATE,
    EXTERNAL_CONTACT_NAME   VARCHAR2(206),
    INTERNAL_CONTACT_NAME   VARCHAR2(206),
    SALARY_TYPE             VARCHAR2(1002),
    MINIMUM_SALARY          NUMBER(19,4),
    MAXIMUM_SALARY          NUMBER(19,4),
    OPEN_DATE               DATE,
    CLOSE_DATE              DATE,
    TOTAL_VACANCIES         VARCHAR2(12),
    PART_TIME_HOURS         NUMBER(10),
    NOT_TO_EXCEED           VARCHAR2(26),
    WHO_MAY_APPLY           VARCHAR2(1002),
    TEMPLATE                VARCHAR2(2050)
);

----------------------------------------------
--DDL for index DSS_ANNOUNCEMENT_DETAIL_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_ANNOUNCEMENT_DETAIL_I1 ON DSS_ANNOUNCEMENT_DETAIL (ANNOUNCEMENT_NUMBER);

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_APPT_TYPE
------------------------------------
CREATE TABLE HHS_HR.DSS_ANNOUNCEMENT_APPT_TYPE
(
    ANNOUNCEMENT_NUMBER  VARCHAR2(56),
    APPOINTMENT_TYPE     VARCHAR2(1002)
);

----------------------------------------------
--DDL for index DSS_ANNOUNCEMENT_APPT_TYPE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_ANNOUNCEMENT_APPT_TYPE_I1 ON DSS_ANNOUNCEMENT_APPT_TYPE (ANNOUNCEMENT_NUMBER);

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_WORK_SCHED
------------------------------------
CREATE TABLE HHS_HR.DSS_ANNOUNCEMENT_WORK_SCHED
(
    ANNOUNCEMENT_NUMBER  VARCHAR2(56),
    WORK_SCHEDULE        VARCHAR2(1002)
);

----------------------------------------------
--DDL for index DSS_ANNOUNCEMENT_WORK_SCHED_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_ANNOUNCEMENT_WORK_SCHED_I1 ON DSS_ANNOUNCEMENT_WORK_SCHED (ANNOUNCEMENT_NUMBER);

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_LOCATION
------------------------------------
CREATE TABLE HHS_HR.DSS_ANNOUNCEMENT_LOCATION
(
    ANNOUNCEMENT_NUMBER  VARCHAR2(56),
    LOCATION_DESCRIPTION VARCHAR2(334),
    LOCATION_OPENINGS    VARCHAR2(12),
    CITY                 VARCHAR2(122),
    STATE_ABBREV         VARCHAR2(8),
    COUNTY               VARCHAR2(202),
    COUNTRY              VARCHAR2(202),
    LOCATION_CODE        VARCHAR2(34)
);

----------------------------------------------
--DDL for index DSS_ANNOUNCEMENT_LOCATION_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_ANNOUNCEMENT_LOCATION_I1 ON DSS_ANNOUNCEMENT_LOCATION (ANNOUNCEMENT_NUMBER);


--==================================
--APPLICATION TABLES
--==================================

------------------------------------
--DDL for table DSS_APPLICATION_DETAIL
------------------------------------
CREATE TABLE HHS_HR.DSS_APPLICATION_DETAIL
(
    APPLICATION_NUMBER         VARCHAR2(22),
    VACANCY_NUMBER             NUMBER(10),
    ANNOUNCEMENT_NUMBER        VARCHAR2(56),
    APP_CONTROL_NUMBER         NUMBER(10),
    APPLICATION_STATUS         VARCHAR2(1002),
    LAST_SUBMITTED_DATE        DATE,
    FIRST_NAME                 VARCHAR2(62),
    MIDDLE_NAME                VARCHAR2(62),
    LAST_NAME                  VARCHAR2(62),
    SUFFIX                     VARCHAR2(22),
    ADDRESS_1                  VARCHAR2(202),
    ADDRESS_2                  VARCHAR2(202),
    ADDRESS_3                  VARCHAR2(202),
    POSTAL_CODE                VARCHAR2(42),
    CITY                       VARCHAR2(122),
    STATE_ABBREV               VARCHAR2(8),
    COUNTRY                    VARCHAR2(202),
    CITIZENSHIP                VARCHAR2(202),
    EMAIL                      VARCHAR2(258),
    RECORD_STATUS_DESCRIPTION  VARCHAR2(1002),
    RECORD_STATUS_CODE         VARCHAR2(102),
    CLAIMED_VET_PREF           VARCHAR2(1002),
    CLAIMED_VET_PREF_CODE      VARCHAR2(22),
    ADJ_VET_PREF               VARCHAR2(1002),
    ADJ_VET_PREF_CODE          VARCHAR2(22),
    VET_DOC_DATE               DATE,
    LOWEST_GRADE               VARCHAR2(6),
    ELIGIBILITY_START_DATE     DATE,
    ELIGIBILITY_END_DATE       DATE,
    IS_FOLLOWUP                VARCHAR2(8),
    IS_REVIEWED                VARCHAR2(8)
);

----------------------------------------------
--DDL for index DSS_APPLICATION_DETAIL_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_APPLICATION_DETAIL_I1 ON DSS_APPLICATION_DETAIL (APPLICATION_NUMBER);

------------------------------------
--DDL for table DSS_APPLICATION_DOCUMENT
------------------------------------
CREATE TABLE HHS_HR.DSS_APPLICATION_DOCUMENT
(
    APPLICATION_NUMBER   VARCHAR2(22),
    DOC_NAME             VARCHAR2(202),
    DOC_TYPE             VARCHAR2(1002),
    DOC_PROCESSED_DATE   DATE,
    APP_RETREIVED_DATE   DATE,
    DOC_HM_VIEWABLE      VARCHAR2(8),
    DOC_NH_VIEWABLE      VARCHAR2(8)
);

----------------------------------------------
--DDL for index DSS_APPLICATION_DOCUMENT_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_APPLICATION_DOCUMENT_I1 ON DSS_APPLICATION_DOCUMENT (APPLICATION_NUMBER);

------------------------------------
--DDL for table DSS_APPLICATION_ELIGIBILITY
------------------------------------
CREATE TABLE HHS_HR.DSS_APPLICATION_ELIGIBILITY
(
    APPLICATION_NUMBER   VARCHAR2(22),
    ELIGIBILITY          VARCHAR2(202),
    ELIGIBILITY_ADJ      VARCHAR2(1002)
);

----------------------------------------------
--DDL for index DSS_APPLICATION_ELIGIBILITY_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_APPLICATION_ELIGIBILITY_I1 ON DSS_APPLICATION_ELIGIBILITY (APPLICATION_NUMBER);

------------------------------------
--DDL for table DSS_APPLICATION_LOCATION
------------------------------------
CREATE TABLE HHS_HR.DSS_APPLICATION_LOCATION
(
    APPLICATION_NUMBER   VARCHAR2(22),
    LOCATION_DESCRIPTION VARCHAR2(334),
    CITY                 VARCHAR2(122),
    STATE_ABBREV         VARCHAR2(8),
    COUNTY               VARCHAR2(202),
    COUNTRY              VARCHAR2(202),
    LOCATION_CODE        VARCHAR2(34)
);

----------------------------------------------
--DDL for index DSS_APPLICATION_LOCATION_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_APPLICATION_LOCATION_I1 ON DSS_APPLICATION_LOCATION (APPLICATION_NUMBER);

------------------------------------
--DDL for table DSS_APPLICANT_PHONE
------------------------------------
CREATE TABLE HHS_HR.DSS_APPLICANT_PHONE
(
    APPLICATION_NUMBER   VARCHAR2(22),
    PHONE_NUMBER         VARCHAR2(52),
    PHONE_TYPE           VARCHAR2(102)
);

----------------------------------------------
--DDL for index DSS_APPLICANT_PHONE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_APPLICANT_PHONE_I1 ON DSS_APPLICANT_PHONE (APPLICATION_NUMBER);

------------------------------------
--DDL for table DSS_APPLICATION_RATING
------------------------------------
CREATE TABLE HHS_HR.DSS_APPLICATION_RATING
(
    APPLICATION_NUMBER   VARCHAR2(22),
    SERIES               VARCHAR2(22),
    GRADE                VARCHAR2(6),
    SPECIALTY            VARCHAR2(102),
    RATING_MSG_CODE      VARCHAR2(22),
    DISPLAY_RATING       VARCHAR2(32),
    FINAL_RATING         NUMBER(12,4),
    AUGMENTED_RATING     NUMBER(12,4),
    RATING_CREATION_DATE DATE,
    RATING_AVAIL_STATUS  VARCHAR2(1002),
    RATING_CATEGORY_LBL  VARCHAR2(202),
    IS_OVERRIDE          VARCHAR2(8),
    RATING_MODIFIED_DATE DATE
);

----------------------------------------------
--DDL for index DSS_APPLICATION_RATING_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_APPLICATION_RATING_I1 ON DSS_APPLICATION_RATING (APPLICATION_NUMBER);


--==================================
--CERTIFICATE TABLES
--==================================

------------------------------------
--DDL for table DSS_CERTIFICATE
------------------------------------
CREATE TABLE HHS_HR.DSS_CERTIFICATE
(
    CERTIFICATE_NUMBER   VARCHAR2(102),
    AUDITED              VARCHAR2(8),
    AUDITOR              VARCHAR2(206),
    CUTOFF_NUMBER        NUMBER(18,2),
    FINAL_AUDIT_DATE     DATE,
    INITIAL_AUDIT_DATE   DATE,
    ISSUE_DATE           DATE,
    ISSUER               VARCHAR2(206),
    LAST_UPDATE_DATE     DATE,
    CERT_ORDER           VARCHAR2(1002),
    PRIORITY_ORDER       VARCHAR2(1002),
    QUALIFIED_SCORE      NUMBER(18,2),
    RANK_BY_DESCRIPTION  VARCHAR2(1002),
    REFER_METHOD         VARCHAR2(1002),
    TIE_BREAKER          VARCHAR2(1002),
    CERTIFICATE_TYPE     VARCHAR2(82)
);

----------------------------------------------
--DDL for index DSS_CERTIFICATE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CERTIFICATE_I1 ON DSS_CERTIFICATE (CERTIFICATE_NUMBER);

------------------------------------
--DDL for table DSS_CERTIFICATE_APP
------------------------------------
CREATE TABLE HHS_HR.DSS_CERTIFICATE_APP
(
    APPLICATION_NUMBER      VARCHAR2(22),
    ADD_DATE                DATE,
    ADDED                   VARCHAR2(8),
    AUDIT_CODE              VARCHAR2(82),
    AUDIT_DATE              DATE,
    CERTIFIED_DATE          DATE,
    FIRST_NAME              VARCHAR2(62),
    MIDDLE_NAME             VARCHAR2(62),
    LAST_NAME               VARCHAR2(62),
    SUFFIX                  VARCHAR2(22),
    LOCATION_DESCRIPTION    VARCHAR2(334),
    CITY                    VARCHAR2(122),
    STATE                   VARCHAR2(202),
    COUNTRY                 VARCHAR2(202),
    PD_NUMBER               VARCHAR2(202),
    POSITION_TITLE          VARCHAR2(202),
    SERIES                  VARCHAR2(22),
    SERIES_TITLE            VARCHAR2(202),
    PRIORITY_DESCRIPTION    VARCHAR2(1002),
    RANK_ORDER              NUMBER(10),
    RATING                  VARCHAR2(32),
    REORDERED               VARCHAR2(8),
    RETURN_STATUS           VARCHAR2(1002),
    VET_PREF_CODE           VARCHAR2(22),
    VET_PREF_DESCRIPTION    VARCHAR2(602)
);

----------------------------------------------
--DDL for index DSS_CERTIFICATE_APP_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CERTIFICATE_APP_I1 ON DSS_CERTIFICATE_APP (APPLICATION_NUMBER);


--==================================
--NEW HIRE TABLES
--==================================

------------------------------------
--DDL for table DSS_NEW_HIRE
------------------------------------
CREATE TABLE HHS_HR.DSS_NEW_HIRE
(
    NEW_HIRE_NUMBER            VARCHAR2(22),
    NEW_HIRE_FIRST_NAME        VARCHAR2(2050),
    NEW_HIRE_MIDDLE_NAME       VARCHAR2(2050),
    NEW_HIRE_LAST_NAME         VARCHAR2(2050),
    NEW_HIRE_SUFFIX            VARCHAR2(2050),
    NEW_HIRE_MAIDEN_NAME       VARCHAR2(2050),
    NEW_HIRE_NAME              VARCHAR2(2050),
    NEW_HIRE_EMAIL             VARCHAR2(2050),
    NEW_HIRE_ADDRESS_1         VARCHAR2(2050),
    NEW_HIRE_ADDRESS_2         VARCHAR2(2050),
    NEW_HIRE_APT               VARCHAR2(2050),
    NEW_HIRE_CITY              VARCHAR2(2050),
    NEW_HIRE_STATE             VARCHAR2(2050),
    NEW_HIRE_COUNTRY           VARCHAR2(2050),
    NEW_HIRE_POSTAL_CODE       VARCHAR2(2050),
    AGENCY                     VARCHAR2(2050),
    AGENCY_ADDRESS_1           VARCHAR2(2050),
    AGENCY_ADDRESS_2           VARCHAR2(2050),
    AGENCY_ADDRESS_3           VARCHAR2(2050),
    AGENCY_CITY                VARCHAR2(2050),
    AGENCY_STATE               VARCHAR2(2050),
    AGENCY_COUNTRY             VARCHAR2(2050),
    AGENCY_POSTAL_CODE         VARCHAR2(2050),
    BRANCH                     VARCHAR2(2050),
    BUREAU                     VARCHAR2(2050),
    UNIT                       VARCHAR2(2050),
    PD_NUMBER                  VARCHAR2(2050),
    POSITION_TITLE             VARCHAR2(2050),
    PAY_PLAN                   VARCHAR2(2050),
    SERIES                     VARCHAR2(2050),
    GRADE                      VARCHAR2(2050),
    DUTY_LOCATION              VARCHAR2(2050),
    DUTY_LOCATION_CODE         VARCHAR2(2050),
    PROJECTED_START_DATE       DATE,
    PROLONGED_START_DATE_RSN   VARCHAR2(2050),
    ACTUAL_START_DATE          DATE,
    VET_PREF_STATUS            VARCHAR2(2050),
    LAST_UPDATE_DATE           DATE
);

----------------------------------------------
--DDL for index DSS_NEW_HIRE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_NEW_HIRE_I1 ON DSS_NEW_HIRE (NEW_HIRE_NUMBER);

--==================================
--REQUEST TABLES
--==================================

------------------------------------
--DDL for table DSS_REQUEST_DETAIL
------------------------------------
CREATE TABLE HHS_HR.DSS_REQUEST_DETAIL
(
    REQUEST_NUMBER             VARCHAR2(202),
    REQUEST_DESCRIPTION        CLOB,
    REQUEST_STATUS             VARCHAR2(1002),
    REQUEST_TYPE               VARCHAR2(1002),
    REQUEST_SOURCE             VARCHAR2(1002),
    LAST_UPDATE_DATE           DATE,
    CREATION_DATE              DATE,
    SUBMISSION_DATE            DATE,
    REQUESTER_NAME             VARCHAR2(206),
    REQUESTER_EMAIL            VARCHAR2(242),
    APPROVER_NAME              VARCHAR2(206),
    APPROVER_EMAIL             VARCHAR2(242),
    APPROVAL_DATE              DATE,
    CUSTOMER_NAME              VARCHAR2(202),
    CUSTOMER_DEPARTMENT_NAME   VARCHAR2(202),
    CUSTOMER_DEPARTMENT_CODE   VARCHAR2(10),
    CUSTOMER_AGENCY_NAME       VARCHAR2(202),
    CUSTOMER_AGENCY_CODE       VARCHAR2(10),
    CUSTOMER_ADDRESS_LINE_1    VARCHAR2(202),
    CUSTOMER_ADDRESS_LINE_2    VARCHAR2(202),
    CUSTOMER_ADDRESS_LINE_3    VARCHAR2(202),
    CUSTOMER_CITY              VARCHAR2(122),
    CUSTOMER_STATE             VARCHAR2(202),
    CUSTOMER_POSTAL_CODE       VARCHAR2(42),
    CUSTOMER_COUNTRY           VARCHAR2(202),
    HIRING_ORGANIZATION        VARCHAR2(202),
    STAFFING_ORGANIZATION      VARCHAR2(122),
    PERSONNEL_ACTION_DATE      DATE,
    MAXIMUM_AGE                NUMBER(3),
    MINIMUM_AGE                NUMBER(3),
    RELOCATION                 VARCHAR2(8),
    SECURITY_CLEARANCE         VARCHAR2(1002),
    SUPERVISORY_POSITION       VARCHAR2(8),
    TRAVEL_PREFERENCE          VARCHAR2(1002)
);


----------------------------------------------
--DDL for index DSS_REQUEST_DETAIL_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REQUEST_DETAIL_I1 ON DSS_REQUEST_DETAIL (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_REQUEST_APPT_TYPE
------------------------------------
CREATE TABLE HHS_HR.DSS_REQUEST_APPT_TYPE
(
    REQUEST_NUMBER    VARCHAR2(202),
    APPOINTMENT_TYPE  VARCHAR2(1002)
);


----------------------------------------------
--DDL for index DSS_REQUEST_APPT_TYPE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REQUEST_APPT_TYPE_I1 ON DSS_REQUEST_APPT_TYPE (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_REQUEST_LOCATION
------------------------------------
CREATE TABLE HHS_HR.DSS_REQUEST_LOCATION
(
    REQUEST_NUMBER       VARCHAR2(202),
    LOCATION_CODE        VARCHAR2(34),
    LOCATION_DESCRIPTION VARCHAR2(334),
    LOCATION_OPENINGS    VARCHAR2(12),
    CITY                 VARCHAR2(122),
    STATE                VARCHAR2(202),
    COUNTY               VARCHAR2(202),
    COUNTRY              VARCHAR2(202)
);

----------------------------------------------
--DDL for index DSS_REQUEST_LOCATION_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REQUEST_LOCATION_I1 ON DSS_REQUEST_LOCATION (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_REQUEST_POSITION
------------------------------------
CREATE TABLE HHS_HR.DSS_REQUEST_POSITION
(
    REQUEST_NUMBER VARCHAR2(202),
    PD_NUMBER      VARCHAR2(202),
    PD_TITLE       VARCHAR2(202)
);

----------------------------------------------
--DDL for index DSS_REQUEST_LOCATION_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REQUEST_POSITION_I1 ON DSS_REQUEST_POSITION (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_REQUEST_SPECIALTY
------------------------------------
CREATE TABLE HHS_HR.DSS_REQUEST_SPECIALTY
(
    REQUEST_NUMBER VARCHAR2(202),
    SPECIALTY      VARCHAR2(102)
);

----------------------------------------------
--DDL for index DSS_REQUEST_SPECIALTY_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REQUEST_SPECIALTY_I1 ON DSS_REQUEST_SPECIALTY (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_REQUEST_VACANCY
------------------------------------
CREATE TABLE HHS_HR.DSS_REQUEST_VACANCY
(
    REQUEST_NUMBER    VARCHAR2(202),
    VACANCY_NUMBER    NUMBER(10),
    VACANCY_STATUS    VARCHAR2(1002)
);

----------------------------------------------
--DDL for index DSS_REQUEST_VACANCY_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REQUEST_VACANCY_I1 ON DSS_REQUEST_VACANCY (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_REQUEST_WORK_SCHED
------------------------------------
CREATE TABLE HHS_HR.DSS_REQUEST_WORK_SCHED
(
    REQUEST_NUMBER VARCHAR2(202),
    WORK_SCHEDULE  VARCHAR2(1002)
);

----------------------------------------------
--DDL for index DSS_REQUEST_WORK_SCHED_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REQUEST_WORK_SCHED_I1 ON DSS_REQUEST_WORK_SCHED (REQUEST_NUMBER);


--==================================
--REVIEW TABLES
--==================================

------------------------------------
--DDL for table DSS_REVIEW_DETAIL
------------------------------------
CREATE TABLE HHS_HR.DSS_REVIEW_DETAIL
(
    REVIEW_NAME             VARCHAR2(202),
    OWNER                   VARCHAR2(206),
    REVIEW_STATUS           VARCHAR2(1002),
    CREATION_DATE           DATE,
    REVIEW_SENT_DATE        DATE,
    REVIEW_DUE_DATE         DATE,
    RECALL_STATUS_DATE      DATE,
    RECALL_REASON           CLOB,
    REVIEW_RETURNED_DATE    DATE,
    REVIEW_INSTRUCTIONS     CLOB,
    IS_ANNOUNCEMENT_QNR     VARCHAR2(8),
    IS_ANNOUNCEMENT_TEXT    VARCHAR2(8),
    IS_CERTIFICATE_REVIEW   VARCHAR2(8),
    LAST_UPDATE_DATE        DATE
);

----------------------------------------------
--DDL for index DSS_REVIEW_DETAIL_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_REVIEW_DETAIL_I1 ON DSS_REVIEW_DETAIL (REVIEW_NAME);


--==================================
--TASK TABLES
--==================================

------------------------------------
--DDL for table DSS_TASK_DETAIL
------------------------------------
CREATE TABLE HHS_HR.DSS_TASK_DETAIL
(
    TASK_ID                       NUMBER(10),
    VACANCY_STAFFING_OFFICE_NAME  VARCHAR2(202),
    ACTIVATION_DATE               DATE,
    COMPLETED_DATE                DATE,
    CREATION_DATE                 DATE,
    DAYS_TO_COMPLETE              NUMBER(10),
    DUE_DATE                      DATE,
    LAST_UPDATE_DATE              DATE,
    TASK_NAME                     VARCHAR2(202),
    OWNER_FIRST_NAME              VARCHAR2(102),
    OWNER_LAST_NAME               VARCHAR2(102),
    OWNER_NAME                    VARCHAR2(206),
    TASK_STATUS                   VARCHAR2(1002),
    ACTUAL_DAYS_TO_COMPLETE       NUMBER(10),
    TASK_TYPE                     VARCHAR2(1002),
    REQUEST_NUMBER                VARCHAR2(202),
    VACANCY_NUMBER                NUMBER(10)
);

----------------------------------------------
--DDL for index DSS_TASK_DETAIL_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_TASK_DETAIL_I1 ON DSS_TASK_DETAIL (TASK_ID);


--==================================
--VACANCY TABLES
--==================================

------------------------------------
--DDL for table DSS_VACANCY_DETAIL
------------------------------------
CREATE TABLE HHS_HR.DSS_VACANCY_DETAIL
(
    VACANCY_NUMBER                NUMBER(10),
    VACANCY_STATUS                VARCHAR2(1002),
    JOB_TITLE                     VARCHAR2(202),
    VACANCY_DESCRIPTION           VARCHAR2(1002),
    VACANCY_TYPE                  VARCHAR2(1002),
    DISPLAY_TYPE                  VARCHAR2(24),
    IS_INTERNAL_MERIT_PROMO       VARCHAR2(8),
    IS_PUBLIC                     VARCHAR2(8),
    IS_STATUS                     VARCHAR2(8),
    CREATION_DATE                 DATE,
    LAST_UPDATE_DATE              DATE,
    ANNOUNCEMENT_NUMBER           VARCHAR2(56),
    IS_UNDER_LITIGATION           VARCHAR2(8),
    ORGANIZATION_NAME             VARCHAR2(122),
    ORGANIZATION_CODE             VARCHAR2(10),
    OFFICE_NAME                   VARCHAR2(202),
    OFFICE_CODE                   VARCHAR2(10),
    ADDRESS_LINE_1                VARCHAR2(202),
    ADDRESS_LINE_2                VARCHAR2(202),
    ADDRESS_LINE_3                VARCHAR2(202),
    CITY                          VARCHAR2(122),
    STATE_ABBREV                  VARCHAR2(8),
    POSTALCODE                    VARCHAR2(42),
    COUNTRY                       VARCHAR2(202),
    HIRING_ORGANIZATION_NAME      VARCHAR2(102),
    ACWA                          VARCHAR2(8),
    AGE_SCREENING                 VARCHAR2(8),
    APPLICANT_UPDT_RESTRICTED     VARCHAR2(8),
    APPLY_ONLINE                  VARCHAR2(8),
    CITIZENSHIP_SCREENING         VARCHAR2(8),
    IS_AGE_FORMULA                VARCHAR2(8),
    HAS_MAX_AGE                   VARCHAR2(8),
    HAS_MIN_AGE                   VARCHAR2(8),
    MAXIMUM_AGE                   NUMBER(3),
    MINIMUM_AGE                   NUMBER(3),
    PERIOD_OF_ELIGIBILITY         NUMBER(10),
    RELOCATION                    VARCHAR2(8),
    RNO                           VARCHAR2(8),
    SECURITY_CLEARANCE            VARCHAR2(1002),
    SUPERVISORY_POSITION          VARCHAR2(8),
    TRAVEL_PREFERENCE             VARCHAR2(1002)
);

----------------------------------------------
--DDL for index DSS_VACANCY_DETAIL_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_VACANCY_DETAIL_I1 ON DSS_VACANCY_DETAIL (VACANCY_NUMBER);

------------------------------------
--DDL for table DSS_VACANCY_CUSTOMER
------------------------------------
CREATE TABLE HHS_HR.DSS_VACANCY_CUSTOMER
(
    VACANCY_NUMBER    NUMBER(10),
    CUSTOMER_NAME     VARCHAR2(202),
    DEPARTMENT_NAME   VARCHAR2(202),
    DEPARTMENT_CODE   VARCHAR2(10),
    AGENCY_NAME       VARCHAR2(202),
    AGENCY_CODE       VARCHAR2(10)
);

----------------------------------------------
--DDL for index DSS_VACANCY_CUSTOMER_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_VACANCY_CUSTOMER_I1 ON DSS_VACANCY_CUSTOMER (VACANCY_NUMBER);

------------------------------------
--DDL for table DSS_VACANCY_ELIGIBILITY
------------------------------------
CREATE TABLE HHS_HR.DSS_VACANCY_ELIGIBILITY
(
    VACANCY_NUMBER    NUMBER(10),
    ELIGIBILITY       VARCHAR2(202),
    ELIGIBILITY_LABEL VARCHAR2(34)
);

----------------------------------------------
--DDL for index DSS_VACANCY_ELIGIBILITY_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_VACANCY_ELIGIBILITY_I1 ON DSS_VACANCY_ELIGIBILITY (VACANCY_NUMBER);

------------------------------------
--DDL for table DSS_VACANCY_POSITION
------------------------------------
CREATE TABLE HHS_HR.DSS_VACANCY_POSITION
(
    VACANCY_NUMBER             NUMBER(10),
    POSITION_DESCRIPTION       VARCHAR2(202),
    POSITION_DESCRIPTION_TITLE VARCHAR2(202)
);

----------------------------------------------
--DDL for index DSS_VACANCY_POSITION_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_VACANCY_POSITION_I1 ON DSS_VACANCY_POSITION (VACANCY_NUMBER);


------------------------------------
--DDL for table DSS_VACANCY_SPECIALTY
------------------------------------
CREATE TABLE HHS_HR.DSS_VACANCY_SPECIALTY
(
    VACANCY_NUMBER NUMBER(10),
    SPECIALTY      VARCHAR2(102)
);

----------------------------------------------
--DDL for index DSS_VACANCY_SPECIALTY_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_VACANCY_SPECIALTY_I1 ON DSS_VACANCY_SPECIALTY (VACANCY_NUMBER);

------------------------------------
--DDL for table DSS_VACANCY_DOCUMENT
------------------------------------
CREATE TABLE HHS_HR.DSS_VACANCY_DOCUMENT
(
    VACANCY_NUMBER                NUMBER(10),
    SUPPORTING_DOC_TYPE           VARCHAR2(1002),
    SUPPORTING_DOC_CUSTM_TITLE    VARCHAR2(1002),
    REQUIRED_DOC                  VARCHAR2(8)
);

----------------------------------------------
--DDL for index DSS_VACANCY_DOCUMENT_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_VACANCY_DOCUMENT_I1 ON DSS_VACANCY_DOCUMENT (VACANCY_NUMBER);

------------------------------------
--DDL for table DSS_VACANCY_REQUEST
------------------------------------
CREATE TABLE HHS_HR.DSS_VACANCY_REQUEST
(
    VACANCY_NUMBER    NUMBER(10),
    REQUEST_NUMBER    VARCHAR2(202),
    REQUEST_STATUS    VARCHAR2(1002)
);

----------------------------------------------
--DDL for index DSS_VACANCY_REQUEST_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_VACANCY_REQUEST_I1 ON DSS_VACANCY_REQUEST (VACANCY_NUMBER);

 
--==================================
--CUSTOM REPORT TABLES
--==================================
---------------------
--CMS
---------------------

------------------------------------
--DDL for table DSS_TIME_TO_STAFF
------------------------------------
CREATE TABLE HHS_HR.DSS_TIME_TO_STAFF
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
--DDL for index DSS_TIME_TO_STAFF_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_TIME_TO_STAFF_I1 ON DSS_TIME_TO_STAFF (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_TIME_TO_OFFER
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

---------------------
--IHS
---------------------

--==================================
--CUSTOM REPORT TABLES
--==================================
------------------------------------
--DDL for table DSS_IHS_VAC_ANNOUNCEMENT
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_ANNOUNCEMENT
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
--DDL for index DSS_IHS_VAC_ANNOUNCEMENT_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_ANNOUNCEMENT_I1 ON DSS_IHS_VAC_ANNOUNCEMENT (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_ANN_LOCATION
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_ANN_LOCATION
(
    REQUEST_NUMBER              VARCHAR2(202),
    VIN                         NUMBER(10),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    LOCATION                    VARCHAR2(334)
);

----------------------------------------------
--DDL for index DSS_IHS_VAC_ANNOUNCEMENT_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_ANN_LOCATION_I1 ON DSS_IHS_VAC_ANN_LOCATION (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_ANN_REVIEW
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_ANN_REVIEW
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
--DDL for index DSS_IHS_VAC_ANN_REVIEW_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_ANN_REVIEW_I1 ON DSS_IHS_VAC_ANN_REVIEW (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_CERTIFICATE
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_CERTIFICATE
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
--DDL for index DSS_IHS_VAC_CERTIFICATE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_CERTIFICATE_I1 ON DSS_IHS_VAC_CERTIFICATE (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_IHS_VAC_NEW_HIRE
------------------------------------
CREATE TABLE HHS_HR.DSS_IHS_VAC_NEW_HIRE
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
--DDL for index DSS_IHS_VAC_NEW_HIRE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_IHS_VAC_NEW_HIRE_I1 ON DSS_IHS_VAC_NEW_HIRE (REQUEST_NUMBER);


--==================================
--REFERENCE TABLES
--==================================
------------------------------------
--DDL for table AREA_CONSIDERATION
------------------------------------
CREATE TABLE HHS_HR.AREA_CONSIDERATION
(
    AREA_CONSIDER_CODE        VARCHAR2(8),
    AREA_CONSIDER_DESC        VARCHAR2(30)
);


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

------------------------------------
--DDL for table DSS_CDC_TIME_TO_OFFER
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_TIME_TO_OFFER
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
CREATE INDEX HHS_HR.DSS_CDC_TIME_TO_OFFER_I1 ON DSS_CDC_TIME_TO_OFFER (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CDC_TIME_TO_STAFF
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_TIME_TO_STAFF
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
--DDL for index DSS_CDC_TIME_TO_STAFF_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_TIME_TO_STAFF_I1 ON DSS_CDC_TIME_TO_STAFF (REQUEST_NUMBER);


------------------------------------
--DDL for table DSS_CDC_CERTIFICATE
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_CERTIFICATE
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_TYPE                VARCHAR2(1002),
    CERTIFICATE_NUMBER          VARCHAR2(102),
    VACANCY_NUMBER              NUMBER(10),
    POSITION_TITLE              VARCHAR2(202),
    PAYPLAN_SERIES_GRADE        VARCHAR2(1000),
    CERTIFICATE_SERIES          VARCHAR2(1028),
    CERTIFICATE_GRADE           VARCHAR2(502),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    ANNOUNCEMENT_CTRL_NUMBER    NUMBER(10,0),
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    CERTIFICATE_ISSUE_DATE      DATE,
    REVIEW_RETURN_DATE          DATE,
    CERT_SIGNED_DATE            DATE,
    CERT_EXPIRED_DATE           DATE,
    TOTAL_APPLICANTS            NUMBER(4),
    HIRING_AUTHORITY            VARCHAR2(202)
);

----------------------------------------------
--DDL for index DSS_CDC_CERTIFICATE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_CERTIFICATE_I1 ON DSS_CDC_CERTIFICATE (REQUEST_NUMBER);


------------------------------------
--DDL for table DSS_CDC_TIME_TO_STAFF_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_TIME_TO_STAFF_STG
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
--DDL for index DSS_CDC_TIME_TO_STAFF_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_TIME_TO_STAFF_STG_I1 ON DSS_CDC_TIME_TO_STAFF_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CDC_TIME_TO_OFFER_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_TIME_TO_OFFER_STG
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
--DDL for index DSS_CDC_TIME_TO_OFFER_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_TIME_TO_OFFER_STG_I1 ON DSS_CDC_TIME_TO_OFFER_STG (REQUEST_NUMBER);


------------------------------------
--DDL for table DSS_CDC_CERTIFICATE_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_CERTIFICATE_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_TYPE                VARCHAR2(1002),
    CERTIFICATE_NUMBER          VARCHAR2(102),
    VACANCY_NUMBER              NUMBER(10),
    POSITION_TITLE              VARCHAR2(202),
    PAYPLAN_SERIES_GRADE        VARCHAR2(1000),
    CERTIFICATE_SERIES          VARCHAR2(1028),
    CERTIFICATE_GRADE           VARCHAR2(502),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    ANNOUNCEMENT_CTRL_NUMBER    NUMBER(10,0),
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    CERTIFICATE_ISSUE_DATE      DATE,
    REVIEW_RETURN_DATE          DATE,
    CERT_SIGNED_DATE            DATE,
    CERT_EXPIRED_DATE           DATE,
    TOTAL_APPLICANTS            NUMBER(4),
    HIRING_AUTHORITY            VARCHAR2(202)
);

----------------------------------------------
--DDL for index DSS_CDC_CERTIFICATE_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_CERTIFICATE_STG_I1 ON DSS_CDC_CERTIFICATE_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CDC_CERT_AUDIT
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_CERT_AUDIT
(
    REQUEST_NUMBER              VARCHAR2(202),
    CERTIFICATE_NUMBER          VARCHAR2(102),
    AUDIT_CODE                  VARCHAR2(82),
    AUDIT_DATE                  DATE,
    CERT_LAST_UPDATE_DATE       DATE
);

----------------------------------------------
--DDL for index DSS_CDC_CERT_AUDIT_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_CERT_AUDIT_I1 ON DSS_CDC_CERT_AUDIT (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CDC_CERT_AUDIT_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_CERT_AUDIT_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    CERTIFICATE_NUMBER          VARCHAR2(102),
    AUDIT_CODE                  VARCHAR2(82),
    AUDIT_DATE                  DATE,
    CERT_LAST_UPDATE_DATE       DATE
);

----------------------------------------------
--DDL for index DSS_CDC_CERT_AUDIT_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_CERT_AUDIT_STG_I1 ON DSS_CDC_CERT_AUDIT_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CDC_ANNOUNCEMENT
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_ANNOUNCEMENT
(
    REQUEST_NUMBER              VARCHAR2(202),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    ANNOUNCEMENT_CTRL_NUMBER    NUMBER(10,0),
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    ANNOUNCEMENT_RVW_STATUS     VARCHAR2(1002),
    ANN_RVW_CMPL_DATE           DATE,
    ANN_LAST_UPDATE_DATE        DATE
);

----------------------------------------------
--DDL for index DSS_CDC_ANNOUNCEMENT_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_ANNOUNCEMENT_I1 ON DSS_CDC_ANNOUNCEMENT (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CDC_ANNOUNCEMENT_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CDC_ANNOUNCEMENT_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    ANNOUNCEMENT_CTRL_NUMBER    NUMBER(10,0),
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    ANNOUNCEMENT_RVW_STATUS     VARCHAR2(1002),
    ANN_RVW_CMPL_DATE           DATE,
    ANN_LAST_UPDATE_DATE        DATE
);

----------------------------------------------
--DDL for index DSS_CDC_ANNOUNCEMENT_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CDC_ANNOUNCEMENT_STG_I1 ON DSS_CDC_ANNOUNCEMENT_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CMS_TIME_OF_POSSESS
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_APPROVAL_DATE       DATE,
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    HM_ANN_RVW_SENT_DATE        DATE,
    HM_ANN_RVW_CMPL_DATE        DATE,
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    CERTIFICATE_NUMBER          VARCHAR2(102),
    CERTIFICATE_ISSUE_DATE      DATE,
    REVIEW_SENT_DATE            DATE,
    REVIEW_RETURN_DATE          DATE,
    INITIAL_AUDIT_DATE          DATE,   
    NEW_HIRE_CREATE_DATE        DATE,
    SEND_TENT_OFFR_CMPL_DATE    DATE,
    TENT_OFFR_RSPNS_DATE        DATE,
    RCVE_BKGRND_INVST_DATE      DATE,
    EOD_DATE                    DATE,
    SEND_OFCL_OFFR_CMPL_DATE    DATE
);

----------------------------------------------
--DDL for index DSS_CMS_TIME_OF_POSSESS_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CMS_TIME_OF_POSSESS_I1 ON DSS_CMS_TIME_OF_POSSESS (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CMS_TIME_OF_POSSESS_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_APPROVAL_DATE       DATE,
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    HM_ANN_RVW_SENT_DATE        DATE,
    HM_ANN_RVW_CMPL_DATE        DATE,
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    CERTIFICATE_NUMBER          VARCHAR2(102),
    CERTIFICATE_ISSUE_DATE      DATE,
    REVIEW_SENT_DATE            DATE,
    REVIEW_RETURN_DATE          DATE,
    INITIAL_AUDIT_DATE          DATE,   
    NEW_HIRE_CREATE_DATE        DATE,
    SEND_TENT_OFFR_CMPL_DATE    DATE,
    TENT_OFFR_RSPNS_DATE        DATE,
    RCVE_BKGRND_INVST_DATE      DATE,
    EOD_DATE                    DATE,
    SEND_OFCL_OFFR_CMPL_DATE    DATE
);

----------------------------------------------
--DDL for index DSS_CMS_TIME_OF_POSSESS_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG_I1 ON DSS_CMS_TIME_OF_POSSESS_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CMS_TIME_TO_HIRE
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_TIME_TO_HIRE
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_CREATE_DATE         DATE,
    REQUEST_STATUS              VARCHAR2(1002),
    REQUEST_TYPE                VARCHAR2(1002),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    CERTIFICATE_NUMBER          VARCHAR2(102),
    REVIEW_SENT_DATE            DATE,
    REVIEW_RETURN_DATE          DATE,
    EOD_DATE                    DATE,
    CERTIFICATE_ISSUE_DATE      DATE,
    SEND_TENT_OFFR_CMPL_DATE    DATE,
    TENT_OFFR_RSPNS_DATE        DATE,
    INIT_BKGRND_INVST_DATE      DATE,
    RCVE_BKGRND_INVST_DATE      DATE,
    SEND_OFCL_OFFR_CMPL_DATE    DATE,
    ARRVL_VERIF_CMPL_DATE       DATE
);

----------------------------------------------
--DDL for index DSS_CMS_TIME_TO_HIRE_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CMS_TIME_TO_HIRE_I1 ON DSS_CMS_TIME_TO_HIRE (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CMS_TIME_TO_HIRE_STG
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_TIME_TO_HIRE_STG
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_CREATE_DATE         DATE,
    REQUEST_STATUS              VARCHAR2(1002),
    REQUEST_TYPE                VARCHAR2(1002),
    ANNOUNCEMENT_NUMBER         VARCHAR2(56),
    ANNOUNCEMENT_OPEN_DATE      DATE,
    ANNOUNCEMENT_CLOSE_DATE     DATE,
    CERTIFICATE_NUMBER          VARCHAR2(102),
    REVIEW_SENT_DATE            DATE,
    REVIEW_RETURN_DATE          DATE,
    EOD_DATE                    DATE,
    CERTIFICATE_ISSUE_DATE      DATE,
    SEND_TENT_OFFR_CMPL_DATE    DATE,
    TENT_OFFR_RSPNS_DATE        DATE,
    INIT_BKGRND_INVST_DATE      DATE,
    RCVE_BKGRND_INVST_DATE      DATE,
    SEND_OFCL_OFFR_CMPL_DATE    DATE,
    ARRVL_VERIF_CMPL_DATE       DATE
);

----------------------------------------------
--DDL for index DSS_CMS_TIME_TO_HIRE_STG_I1
----------------------------------------------
CREATE INDEX HHS_HR.DSS_CMS_TIME_TO_HIRE_STG_I1 ON DSS_CMS_TIME_TO_HIRE_STG (REQUEST_NUMBER);

------------------------------------
--DDL for table DSS_CMS_REQUESTS
------------------------------------
CREATE TABLE HHS_HR.DSS_CMS_REQUESTS
(
    REQUEST_NUMBER              VARCHAR2(202),
    REQUEST_CREATE_DATE         DATE,
    REQUEST_STATUS              VARCHAR2(1002),
    REQUEST_TYPE                VARCHAR2(1002),
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
    REQUEST_TYPE                VARCHAR2(1002),
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

