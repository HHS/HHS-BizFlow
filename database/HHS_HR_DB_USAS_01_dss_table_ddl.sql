--------------------------------------------
-- Backout statement
--------------------------------------------
/*
DROP TABLE DSS_ANNOUNCEMENT_DETAIL;
DROP TABLE DSS_ANNOUNCEMENT_APPT_TYPE;
DROP TABLE DSS_ANNOUNCEMENT_WORK_SCHED;
DROP TABLE DSS_ANNOUNCEMENT_LOCATION;
DROP TABLE DSS_APPLICATION_DETAIL;
DROP TABLE DSS_APPLICATION_DOCUMENT;
DROP TABLE DSS_APPLICATION_LOCATION;
DROP TABLE DSS_APPLICATION_ELIGIBILITY;
DROP TABLE DSS_APPLICANT_PHONE;
DROP TABLE DSS_APPLICATION_RATING;
DROP TABLE DSS_CERTIFICATE;
DROP TABLE DSS_CERTIFICATE_APP;
DROP TABLE DSS_NEW_HIRE;
DROP TABLE DSS_NEW_HIRE_PHONE;
DROP TABLE DSS_REQUEST_DETAIL;
DROP TABLE DSS_REQUEST_APPT_TYPE;
DROP TABLE DSS_REQUEST_SPECIALTY;
DROP TABLE DSS_REQUEST_POSITION;
DROP TABLE DSS_REQUEST_LOCATION;
DROP TABLE DSS_REQUEST_WORK_SCHED;
DROP TABLE DSS_REQUEST_VACANCY;
DROP TABLE DSS_REVIEW_DETAIL;
DROP TABLE DSS_REVIEWERS;
DROP TABLE DSS_TASK_DETAIL;
DROP TABLE DSS_VACANCY_DETAIL;
DROP TABLE DSS_VACANCY_CUSTOMER;
DROP TABLE DSS_VACANCY_ELIGIBILITY;
DROP TABLE DSS_VACANCY_POSITION;
DROP TABLE DSS_VACANCY_SPECIALTY;
DROP TABLE DSS_VACANCY_DOCUMENT;
DROP TABLE DSS_VACANCY_REQUEST;
DROP TABLE DSS_VACANCY_APP_CNT;
*/


--==================================
--ANNOUNCEMENT TABLES
--==================================

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_DETAIL
------------------------------------
CREATE TABLE DSS_ANNOUNCEMENT_DETAIL
(
    ANNOUNCEMENT_NUMBER     VARCHAR2(30),
    VACANCY_NUMBER          NUMBER(10),
    ANN_CONTROL_NUMBER      NUMBER(10),
    ANNOUNCEMENT_STATUS     VARCHAR2(30),
    IS_RELEASED             VARCHAR2(3),
    RELEASED_DATE           DATE,
    LAST_UPDATE_DATE        DATE,
    EXTERNAL_CONTACT_NAME   VARCHAR2(100),
    INTERNAL_CONTACT_NAME   VARCHAR2(100),
    SALARY_TYPE             VARCHAR2(20),
    MINIMUM_SALARY          NUMBER(8,2),
    MAXIMUM_SALARY          NUMBER(8,2),
    OPEN_DATE               DATE,
    CLOSE_DATE              DATE,
    TOTAL_VACANCIES         VARCHAR2(4),
    PART_TIME_HOURS         NUMBER(2),
    NOT_TO_EXCEED           VARCHAR2(20),
    WHO_MAY_APPLY           VARCHAR2(100),
    TEMPLATE                VARCHAR2(200)
);

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_APPT_TYPE
------------------------------------
CREATE TABLE DSS_ANNOUNCEMENT_APPT_TYPE
(
    ANNOUNCEMENT_NUMBER  VARCHAR2(30),
    APPOINTMENT_TYPE     VARCHAR2(35)
);

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_WORK_SCHED
------------------------------------
CREATE TABLE DSS_ANNOUNCEMENT_WORK_SCHED
(
    ANNOUNCEMENT_NUMBER  VARCHAR2(30),
    WORK_SCHEDULE        VARCHAR2(18)
);

------------------------------------
--DDL for table DSS_ANNOUNCEMENT_LOCATION
------------------------------------
CREATE TABLE DSS_ANNOUNCEMENT_LOCATION
(
    ANNOUNCEMENT_NUMBER  VARCHAR2(30),
    LOCATION_DESCRIPTION VARCHAR2(50),
    LOCATION_OPENINGS    VARCHAR2(4),
    CITY                 VARCHAR2(50),
    STATE_ABBREV         VARCHAR2(3),
    COUNTY               VARCHAR2(50),
    COUNTRY              VARCHAR2(50),
    LOCATION_CODE        VARCHAR2(10)
);




--==================================
--APPLICATION TABLES
--==================================

------------------------------------
--DDL for table DSS_APPLICATION_DETAIL
------------------------------------
CREATE TABLE DSS_APPLICATION_DETAIL
(
    APPLICATION_NUMBER         VARCHAR2(10),
    VACANCY_NUMBER             NUMBER(10),
    ANNOUNCEMENT_NUMBER        VARCHAR2(30),
    APP_CONTROL_NUMBER         NUMBER(10),
    APPLICATION_STATUS         VARCHAR2(40),
    LAST_SUBMITTED_DATE        DATE,
    FIRST_NAME                 VARCHAR2(50),
    MIDDLE_NAME                VARCHAR2(50),
    LAST_NAME                  VARCHAR2(50),
    SUFFIX                     VARCHAR2(3),
    ADDRESS_1                  VARCHAR2(75),
    ADDRESS_2                  VARCHAR2(75),
    ADDRESS_3                  VARCHAR2(75),
    POSTAL_CODE                VARCHAR2(10),
    CITY                       VARCHAR2(50),
    STATE_ABBREV               VARCHAR2(3),
    COUNTRY                    VARCHAR2(50),
    CITIZENSHIP                VARCHAR2(50),
    EMAIL                      VARCHAR2(100),
    RECORD_STATUS_DESCRIPTION  VARCHAR2(100),
    RECORD_STATUS_CODE         VARCHAR2(2),
    CLAIMED_VET_PREF           VARCHAR2(130),
    CLAIMED_VET_PREF_CODE      VARCHAR2(3),
    ADJ_VET_PREF               VARCHAR2(130),
    ADJ_VET_PREF_CODE          VARCHAR2(3),
    VET_DOC_DATE               DATE,
    LOWEST_GRADE               VARCHAR2(2),
    ELIGIBILITY_START_DATE     DATE,
    ELIGIBILITY_END_DATE       DATE,
    IS_FOLLOWUP                VARCHAR2(3),
    IS_REVIEWED                VARCHAR2(3)
);

------------------------------------
--DDL for table DSS_APPLICATION_DOCUMENT
------------------------------------
CREATE TABLE DSS_APPLICATION_DOCUMENT
(
    APPLICATION_NUMBER   VARCHAR2(10),
    DOC_NAME             VARCHAR2(100),
    DOC_TYPE             VARCHAR2(50),
    DOC_PROCESSED_DATE   DATE,
    APP_RETREIVED_DATE   DATE,
    DOC_HM_VIEWABLE      VARCHAR2(3),
    DOC_NH_VIEWABLE      VARCHAR2(3)
);

------------------------------------
--DDL for table DSS_APPLICATION_LOCATION
------------------------------------
CREATE TABLE DSS_APPLICATION_LOCATION
(
    APPLICATION_NUMBER   VARCHAR2(10),
    LOCATION_DESCRIPTION VARCHAR2(50),
    CITY                 VARCHAR2(50),
    STATE_ABBREV         VARCHAR2(3),
    COUNTY               VARCHAR2(50),
    COUNTRY              VARCHAR2(50),
    LOCATION_CODE        VARCHAR2(10)
);

------------------------------------
--DDL for table DSS_APPLICATION_ELIGIBILITY
------------------------------------
CREATE TABLE DSS_APPLICATION_ELIGIBILITY
(
    APPLICATION_NUMBER   VARCHAR2(10),
    ELIGIBILITY          VARCHAR2(100),
    ELIGIBILITY_ADJ      VARCHAR2(10)
);

------------------------------------
--DDL for table DSS_APPLICANT_PHONE
------------------------------------
CREATE TABLE DSS_APPLICANT_PHONE
(
    APPLICATION_NUMBER   VARCHAR2(10),
    PHONE_NUMBER         VARCHAR2(30),
    PHONE_TYPE           VARCHAR2(8)
);

------------------------------------
--DDL for table DSS_APPLICATION_RATING
------------------------------------
CREATE TABLE DSS_APPLICATION_RATING
(
    APPLICATION_NUMBER   VARCHAR2(10),
    SERIES               VARCHAR2(4),
    GRADE                VARCHAR2(2),
    SPECIALTY            VARCHAR2(100),
    RATING_MSG_CODE      VARCHAR2(4),
    DISPLAY_RATING       VARCHAR2(10),
    FINAL_RATING         NUMBER(7,4),
    AUGMENTED_RATING     NUMBER(7,4),
    RATING_CREATION_DATE DATE,
    RATING_AVAIL_STATUS  VARCHAR2(20),
    RATING_CATEGORY_LBL  VARCHAR2(20),
    IS_OVERRIDE          VARCHAR2(3),
    RATING_MODIFIED_DATE DATE
);




--==================================
--CERTIFICATE TABLES
--==================================

------------------------------------
--DDL for table DSS_CERTIFICATE
------------------------------------
CREATE TABLE DSS_CERTIFICATE
(
    CERTIFICATE_NUMBER   VARCHAR2(20),
    AUDITED              VARCHAR2(3),
    AUDITOR              VARCHAR2(100),
    CUTOFF_NUMBER        NUMBER(4),
    FINAL_AUDIT_DATE     DATE,
    INITIAL_AUDIT_DATE   DATE,
    ISSUE_DATE           DATE,
    ISSUER               VARCHAR2(100),
    LAST_UPDATE_DATE     DATE,
    CERT_ORDER           VARCHAR2(10),
    PRIORITY_ORDER       VARCHAR2(40),
    QUALIFIED_SCORE      NUMBER(3),
    RANK_BY_DESCRIPTION  VARCHAR2(40),
    REFER_METHOD         VARCHAR2(20),
    TIE_BREAKER          VARCHAR2(20),
    CERTIFICATE_TYPE     VARCHAR2(30)
);

------------------------------------
--DDL for table DSS_CERTIFICATE_APP
------------------------------------
CREATE TABLE DSS_CERTIFICATE_APP
(
    ADD_DATE                DATE,
    ADDED                   VARCHAR2(3),
    AUDIT_CODE              VARCHAR2(20),
    AUDIT_DATE              DATE,
    CERTIFIED_DATE          DATE,
    FIRST_NAME              VARCHAR2(50),
    CITY                    VARCHAR2(50),
    COUNTRY                 VARCHAR2(50),
    LOCATION_DESCRIPTION    VARCHAR2(50),
    STATE                   VARCHAR2(50),
    PD_NUMBER               VARCHAR2(20),
    POSITION_TITLE          VARCHAR2(100),
    SERIES                  VARCHAR2(4),
    SERIES_TITLE            VARCHAR2(100),
    LAST_NAME               VARCHAR2(50),
    MIDDLE_NAME             VARCHAR2(50),
    APPLICATION_NUMBER      VARCHAR2(10),
    PRIORITY_DESCRIPTION    VARCHAR2(50),
    RANK_ORDER              NUMBER(3),
    RATING                  VARCHAR2(4),
    REORDERED               VARCHAR2(3),
    RETURN_STATUS           VARCHAR2(20),
    SUFFIX                  VARCHAR2(3),
    VET_PREF_CODE           VARCHAR2(3),
    VET_PREF_DESCRIPTION    VARCHAR2(250)
);




--==================================
--NEW HIRE TABLES
--==================================

------------------------------------
--DDL for table DSS_NEW_HIRE
------------------------------------
CREATE TABLE DSS_NEW_HIRE
(
    UNIT                       VARCHAR2(30),
    ACTUAL_START_DATE          DATE,
    NEW_HIRE_ADDRESS_1         VARCHAR2(75),
    NEW_HIRE_ADDRESS_2         VARCHAR2(75),
    AGENCY                     VARCHAR2(100),
    AGENCY_ADDRESS_1           VARCHAR2(75),
    AGENCY_ADDRESS_2           VARCHAR2(75),
    AGENCY_ADDRESS_3           VARCHAR2(75),
    AGENCY_CITY                VARCHAR2(50),
    AGENCY_COUNTRY             VARCHAR2(50),
    AGENCY_POSTAL_CODE         VARCHAR2(10),
    AGENCY_STATE               VARCHAR2(50),
    NEW_HIRE_APT               VARCHAR2(20),
    BRANCH                     VARCHAR2(100),
    BUREAU                     VARCHAR2(100),
    NEW_HIRE_CITY              VARCHAR2(50),
    NEW_HIRE_COUNTRY           VARCHAR2(50),
    DUTY_LOCATION              VARCHAR2(100),
    DUTY_LOCATION_CODE         VARCHAR2(50),
    NEW_HIRE_EMAIL             VARCHAR2(100),
    NEW_HIRE_FIRST_NAME        VARCHAR2(50),
    GRADE                      VARCHAR2(2),
    LAST_UPDATE_DATE           DATE,
    NEW_HIRE_LAST_NAME         VARCHAR2(50),
    NEW_HIRE_MAIDEN_NAME       VARCHAR2(50),
    NEW_HIRE_MIDDLE_NAME       VARCHAR2(50),
    NEW_HIRE_NAME              VARCHAR2(100),
    NEW_HIRE_NUMBER            VARCHAR2(10),
    PAY_PLAN                   VARCHAR2(2),
    PD_NUMBER                  VARCHAR2(50),
    POSITION_TITLE             VARCHAR2(100),
    NEW_HIRE_POSTAL_CODE       VARCHAR2(10),
    PROJECTED_START_DATE       DATE,
    PROLONGED_START_DATE_RSN   VARCHAR2(50),
    SERIES                     VARCHAR2(4),
    NEW_HIRE_STATE             VARCHAR2(50),
    NEW_HIRE_SUFFIX            VARCHAR2(3),
    VET_PREF_STATUS            VARCHAR2(130)
);

------------------------------------
--DDL for table DSS_NEW_HIRE_PHONE
------------------------------------
CREATE TABLE DSS_NEW_HIRE_PHONE
(
    PHONE_NUMBER   VARCHAR2(30),
    PHONE_TYPE     VARCHAR2(8)
);




--==================================
--REQUEST TABLES
--==================================

------------------------------------
--DDL for table DSS_REQUEST_DETAIL
------------------------------------
CREATE TABLE DSS_REQUEST_DETAIL
(
    REQUEST_NUMBER             VARCHAR2(50),
    REQUEST_DESCRIPTION        VARCHAR2(30),
    REQUEST_STATUS             VARCHAR2(30),
    REQUEST_TYPE               VARCHAR2(20),
    REQUEST_SOURCE             VARCHAR2(10),
    LAST_UPDATE_DATE           DATE,
    CREATION_DATE              DATE,
    SUBMISSION_DATE            DATE,
    REQUESTER_NAME             VARCHAR2(100),
    REQUESTER_EMAIL            VARCHAR2(100),
    APPROVER_NAME              VARCHAR2(100),
    APPROVER_EMAIL             VARCHAR2(100),
    APPROVAL_DATE              DATE,
    CUSTOMER_NAME              VARCHAR2(100),
    CUSTOMER_DEPARTMENT_NAME   VARCHAR2(100),
    CUSTOMER_DEPARTMENT_CODE   VARCHAR2(2),
    CUSTOMER_AGENCY_NAME       VARCHAR2(100),
    CUSTOMER_AGENCY_CODE       VARCHAR2(4),
    CUSTOMER_ADDRESS_LINE_1    VARCHAR2(75),
    CUSTOMER_ADDRESS_LINE_2    VARCHAR2(75),
    CUSTOMER_ADDRESS_LINE_3    VARCHAR2(75),
    CUSTOMER_CITY              VARCHAR2(50),
    CUSTOMER_STATE             VARCHAR2(50),
    CUSTOMER_POSTAL_CODE       VARCHAR2(10),
    CUSTOMER_COUNTRY           VARCHAR2(50),
    HIRING_ORGANIZATION        VARCHAR2(100),
    STAFFING_ORGANIZATION      VARCHAR2(100),
    PERSONNEL_ACTION_DATE      DATE,
    MAXIMUM_AGE                NUMBER(3),
    MINIMUM_AGE                NUMBER(3),
    RELOCATION                 VARCHAR2(3),
    SECURITY_CLEARANCE         VARCHAR2(50),
    SUPERVISORY_POSITION       VARCHAR2(3),
    TRAVEL_PREFERENCE          VARCHAR2(20)
);

------------------------------------
--DDL for table DSS_REQUEST_APPT_TYPE
------------------------------------
CREATE TABLE DSS_REQUEST_APPT_TYPE
(
    REQUEST_NUMBER    VARCHAR2(50),
    APPOINTMENT_TYPE  VARCHAR2(35)
);

------------------------------------
--DDL for table DSS_REQUEST_SPECIALTY
------------------------------------
CREATE TABLE DSS_REQUEST_SPECIALTY
(
    REQUEST_NUMBER VARCHAR2(50),
    SPECIALTY      VARCHAR2(50)
);

------------------------------------
--DDL for table DSS_REQUEST_POSITION
------------------------------------
CREATE TABLE DSS_REQUEST_POSITION
(
    REQUEST_NUMBER VARCHAR2(50),
    PD_NUMBER      VARCHAR2(50),
    PD_TITLE       VARCHAR2(100)
);


------------------------------------
--DDL for table DSS_REQUEST_LOCATION
------------------------------------
CREATE TABLE DSS_REQUEST_LOCATION
(
    REQUEST_NUMBER       VARCHAR2(50),
    LOCATION_DESCRIPTION VARCHAR2(50),
    LOCATION_OPENINGS    VARCHAR2(4),
    CITY                 VARCHAR2(50),
    STATE                VARCHAR2(50),
    COUNTY               VARCHAR2(50),
    COUNTRY              VARCHAR2(50),
    LOCATION_CODE        VARCHAR2(10)
);

------------------------------------
--DDL for table DSS_REQUEST_WORK_SCHED
------------------------------------
CREATE TABLE DSS_REQUEST_WORK_SCHED
(
    REQUEST_NUMBER VARCHAR2(50),
    WORK_SCHEDULE  VARCHAR2(18)
);

------------------------------------
--DDL for table DSS_REQUEST_VACANCY
------------------------------------
CREATE TABLE DSS_REQUEST_VACANCY
(
    REQUEST_NUMBER    VARCHAR2(50),
    VACANCY_NUMBER    NUMBER(10),
    VACANCY_STATUS    VARCHAR2(10)
);




--==================================
--REVIEW TABLES
--==================================

------------------------------------
--DDL for table DSS_REVIEW_DETAIL
------------------------------------
CREATE TABLE DSS_REVIEW_DETAIL
(
    CREATION_DATE           DATE,
    RECALL_STATUS_DATE      DATE,
    REVIEW_DUE_DATE         DATE,
    REVIEW_INSTRUCTIONS     VARCHAR2(1000),
    IS_ANNOUNCEMENT_QNR     VARCHAR2(3),
    IS_ANNOUNCEMENT_TEXT    VARCHAR2(3),
    IS_CERTIFICATE_REVIEW   VARCHAR2(3),
    LAST_UPDATE_DATE        DATE,
    NAME                    VARCHAR2(200),
    OWNER                   VARCHAR2(100),
    RECALL_REASON           VARCHAR2(100),
    REVIEW_RETURNED_DATE    DATE,
    REVIEW_SENT_DATE        DATE,
    REVIEW_STATUS           VARCHAR2(10)
);

------------------------------------
--DDL for table DSS_REVIEWERS
------------------------------------
CREATE TABLE DSS_REVIEWERS
(
    REVIEWER_NAME     VARCHAR2(100),
    COMPLETION_DATE   DATE,
    ASSIGNMENT_TYPE   VARCHAR2(30),
    REVIEWER_STATUS   VARCHAR2(30)
);




--==================================
--TASK TABLES
--==================================

------------------------------------
--DDL for table DSS_TASK_DETAIL
------------------------------------
CREATE TABLE DSS_TASK_DETAIL
(
    VACANCY_STAFFING_OFFICE_NAME  VARCHAR2(100),
    TASK_ID                       NUMBER(10),
    ACTIVATION_DATE               DATE,
    COMPLETED_DATE                DATE,
    CREATION_DATE                 DATE,
    DAYS_TO_COMPLETE              NUMBER(3),
    DUE_DATE                      DATE,
    LAST_UPDATE_DATE              DATE,
    TASK_NAME                     VARCHAR2(100),
    OWNER_FIRST_NAME              VARCHAR2(50),
    OWNER_LAST_NAME               VARCHAR2(50),
    OWNER_NAME                    VARCHAR2(100),
    TASK_STATUS                   VARCHAR2(10),
    ACTUAL_DAYS_TO_COMPLETE       NUMBER(3),
    TASK_TYPE                     VARCHAR2(100),
    REQUEST_NUMBER                VARCHAR2(50),
    VACANCY_NUMBER                NUMBER(10)
);




--==================================
--VACANCY TABLES
--==================================

------------------------------------
--DDL for table DSS_VACANCY_DETAIL
------------------------------------
CREATE TABLE DSS_VACANCY_DETAIL
(
    VACANCY_NUMBER                NUMBER(10),
    VACANCY_STATUS                VARCHAR2(10),
    JOB_TITLE                     VARCHAR2(100),
    VACANCY_DESCRIPTION           VARCHAR2(50),
    VACANCY_TYPE                  VARCHAR2(30),
    DISPLAY_TYPE                  VARCHAR2(30),
    IS_INTERNAL_MERIT_PROMO       VARCHAR2(3),
    IS_PUBLIC                     VARCHAR2(3),
    IS_STATUS                     VARCHAR2(3),
    CREATION_DATE                 DATE,
    LAST_UPDATE_DATE              DATE,
    ANNOUNCEMENT_NUMBER           VARCHAR2(30),
    IS_UNDER_LITIGATION           VARCHAR2(3),
    ORGANIZATION_NAME             VARCHAR2(100),
    ORGANIZATION_CODE             VARCHAR2(4),
    OFFICE_NAME                   VARCHAR2(100),
    OFFICE_CODE                   VARCHAR2(4),
    ADDRESS_LINE_1                VARCHAR2(75),
    ADDRESS_LINE_2                VARCHAR2(75),
    ADDRESS_LINE_3                VARCHAR2(75),
    CITY                          VARCHAR2(50),
    STATE_ABBREV                  VARCHAR2(3),
    POSTALCODE                    VARCHAR2(10),
    COUNTRY                       VARCHAR2(50),
    HIRING_ORGANIZATION_NAME      VARCHAR2(100),
    ACWA                          VARCHAR2(3),
    AGE_SCREENING                 VARCHAR2(3),
    APPLICANT_UPDT_RESTRICTED     VARCHAR2(3),
    APPLY_ONLINE                  VARCHAR2(3),
    CITIZENSHIP_SCREENING         VARCHAR2(3),
    IS_AGE_FORMULA                VARCHAR2(3),
    HAS_MAX_AGE                   VARCHAR2(3),
    HAS_MIN_AGE                   VARCHAR2(3),
    MAX_AGE                       NUMBER(3),
    MIN_AGE                       NUMBER(3),
    PERIOD_OF_ELIGIBILITY         NUMBER(2),
    RELOCATION                    VARCHAR2(3),
    RNO                           VARCHAR2(3),
    SECURITY_CLEARANCE            VARCHAR2(50),
    SUPERVISORY_POSITION          VARCHAR2(3),
    TRAVEL_PREFERENCE             VARCHAR2(25)
);

------------------------------------
--DDL for table DSS_VACANCY_CUSTOMER
------------------------------------
CREATE TABLE DSS_VACANCY_CUSTOMER
(
    VACANCY_NUMBER    NUMBER(10),
    CUSTOMER_NAME     VARCHAR2(100),
    DEPARTMENT_NAME   VARCHAR2(100),
    DEPARTMENT_CODE   VARCHAR2(4),
    AGENCY_NAME       VARCHAR2(100),
    AGENCY_CODE       VARCHAR2(4)
);

------------------------------------
--DDL for table DSS_VACANCY_ELIGIBILITY
------------------------------------
CREATE TABLE DSS_VACANCY_ELIGIBILITY
(
    VACANCY_NUMBER    NUMBER(10),
    ELIGIBILITY       VARCHAR2(100),
    ELIGIBILITY_LABEL VARCHAR2(30)
);

------------------------------------
--DDL for table DSS_VACANCY_POSITION
------------------------------------
CREATE TABLE DSS_VACANCY_POSITION
(
    VACANCY_NUMBER             NUMBER(10),
    POSITION_DESCRIPTION       VARCHAR2(50),
    POSITION_DESCRIPTION_TITLE VARCHAR2(100)
);

------------------------------------
--DDL for table DSS_VACANCY_SPECIALTY
------------------------------------
CREATE TABLE DSS_VACANCY_SPECIALTY
(
    VACANCY_NUMBER NUMBER(10),
    SPECIALTY      VARCHAR2(50)
);

------------------------------------
--DDL for table DSS_VACANCY_DOCUMENT
------------------------------------
CREATE TABLE DSS_VACANCY_DOCUMENT
(
    VACANCY_NUMBER                NUMBER(10),
    SUPPORTING_DOC_TYPE           VARCHAR2(50),
    SUPPORTING_DOC_CUSTM_TITLE    VARCHAR2(100),
    REQUIRED_DOC                  VARCHAR2(3)
);

------------------------------------
--DDL for table DSS_VACANCY_REQUEST
------------------------------------
CREATE TABLE DSS_VACANCY_REQUEST
(
    VACANCY_NUMBER    NUMBER(10),
    REQUEST_NUMBER    VARCHAR2(50),
    REQUEST_STATUS    VARCHAR2(30)
);


------------------------------------
--DDL for table DSS_VACANCY_APP_CNT
------------------------------------
CREATE TABLE DSS_VACANCY_APP_CNT
(
    VACANCY_NUMBER    NUMBER(10),
    APPLICATION_CNT   NUMBER(4)
);



