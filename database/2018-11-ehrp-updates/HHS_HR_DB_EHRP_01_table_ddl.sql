--------------------------------------------
-- Backout statement
--------------------------------------------
/*
DROP TABLE HHS_HR.EHRP_REQ_DTL;
DROP TABLE HHS_HR.EHRP_JOBCODES;
DROP TABLE HHS_HR.EHRP_POSITIONS;
DROP TABLE HHS_HR.EHRP_OPENINGS;
DROP TABLE HHS_HR.EHRP_CANDIDATES;
DROP TABLE HHS_HR.EHRP_DEPT;
DROP TABLE HHS_HR.EHRP_APPROVALS;
DROP TABLE HHS_HR.EHRP_EWITS_DTL;
DROP TABLE HHS_HR.EHRP_EMPL_RPL;
DROP TABLE HHS_HR.EHRP_POSITION_DTL;
DROP TABLE HHS_HR.EHRP_JOBCODE_DTL;
DROP TABLE HHS_HR.EHRP_SALARY_DTL;
DROP TABLE HHS_HR.EHRP_POSITION_DEPT;
*/

--------------------------------------------------------  
--DDL for Table EHRP_REQ_DTL
--Requisition Detail
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_REQ_DTL
    (HRS_JOB_OPENING_ID     NUMBER(15),
    ORIGINATOR_ID           VARCHAR2(11),
    OPEN_DT                 DATE,
    JOB_REQ_STATUS          VARCHAR2(3),
    BUSINESS_UNIT           VARCHAR2(10),
    DEPTID                  VARCHAR2(10),
    GVT_RECR_OFFICE         VARCHAR2(40),
    HE_APPROVALO_OPRID      VARCHAR2(30),
    GVT_SEL_OFFICIAL        VARCHAR2(30),
    STATUS_DT               DATE,
    OPENINGS_TARGET         NUMBER(38,0),
    SETID_DEPT              VARCHAR2(10),
    COMPANY                 VARCHAR2(3),
    JOBCODE                 VARCHAR2(6),
    POSITION_NBR            VARCHAR2(8),
    LOCATION                VARCHAR2(10),
    POSTING_TITLE           VARCHAR2(200),
    DESIRED_START_DT        DATE,
    AUTHORIZATION_DT        DATE,
    COUNTRY                 VARCHAR2(3),
    GVT_STAFF_SPCLST        VARCHAR2(30),
    GVT_CONSIDER_AREA       VARCHAR2(1),
    GVT_RQSN_TYPE           VARCHAR2(1),
    INITIATOR_OPRID         VARCHAR2(30),
    HE_COMMENTS             CLOB,
    CREATE_DATE             DATE
    );
    
    CREATE UNIQUE INDEX EHRP_REQ_DTL_PK ON HHS_HR.EHRP_REQ_DTL (HRS_JOB_OPENING_ID);

--------------------------------------------------------  
--DDL for Table EHRP_JOBCODES
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_JOBCODES
    (HRS_JOB_OPENING_ID     NUMBER(15),
    JOBCODE                 VARCHAR2(8),
    GVT_PRIMARY_JCODE       VARCHAR2(1),
    REG_REGION              VARCHAR2(5),
    DESIRED_FULL_PART       VARCHAR2(1),
    DESIRED_REG_TEMP        VARCHAR2(1),
    STD_HOURS               NUMBER(6,2),
    STD_HRS_FREQUENCY       VARCHAR2(5),
    DESIRED_SHIFT           VARCHAR2(1),
    GVT_RQSN_SAL_FROM       NUMBER(18,6),
    GVT_RQSN_SAL_TO         NUMBER(18,6),
    PAY_FREQ_ABBRV          VARCHAR2(1),
    CURRENCY_CD             VARCHAR2(3),
    SAL_ADMIN_PLAN          VARCHAR2(10),
    GRADE                   VARCHAR2(3),
    GVT_TRAVEL_PERCENT      VARCHAR2(1),
    MANAGER_LEVEL           VARCHAR2(2),
    FLSA_STATUS             VARCHAR2(1),
    GVT_SUMMER_APPT         VARCHAR2(1),
    GVT_NTE_DATE            DATE,
    GVT_NTE_DAYS            NUMBER(22),
    GVT_LEO_POSITION        VARCHAR2(10),
    GVT_POSN_SENS_CD        VARCHAR2(1),
    GVT_TYPE_OF_APPT        VARCHAR2(2),
    CREATE_DATE             DATE
    );

    CREATE UNIQUE INDEX EHRP_JOBCODES_PK ON HHS_HR.EHRP_JOBCODES (HRS_JOB_OPENING_ID, JOBCODE);
    
--------------------------------------------------------  
--DDL for Table EHRP_POSITIONS
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_POSITIONS
    (HRS_JOB_OPENING_ID         NUMBER(15),
    POSITION_NBR                VARCHAR2(8),
    HRS_JO_PRM_PSN_FLG          VARCHAR2(1),
    CREATE_DATE                 DATE
    );
    
    CREATE UNIQUE INDEX EHRP_POSITIONS_PK ON HHS_HR.EHRP_POSITIONS (HRS_JOB_OPENING_ID, POSITION_NBR);

--------------------------------------------------------  
--DDL for Table EHRP_OPENINGS
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_OPENINGS
    (HRS_JOB_OPENING_ID         NUMBER(15),
    LOCATION                    VARCHAR2(10),
    HRS_JO_PRM_LOC_FLG          VARCHAR2(1),
    DESCR                       VARCHAR2(30),
    CREATE_DATE                 DATE
    );
    
    CREATE UNIQUE INDEX EHRP_OPENINGS_PK ON HHS_HR.EHRP_OPENINGS (HRS_JOB_OPENING_ID, LOCATION);

--------------------------------------------------------  
--DDL for Table EHRP_CANDIDATES
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_CANDIDATES
    (HRS_JOB_OPENING_ID     NUMBER(15),
    SEQUENCE_NBR            NUMBER(38,0),
    NAME                    VARCHAR2(50),
    CREATE_DATE             DATE
    );

    CREATE UNIQUE INDEX EHRP_CANDIDATES_PK ON HHS_HR.EHRP_CANDIDATES (HRS_JOB_OPENING_ID, SEQUENCE_NBR);
    
--------------------------------------------------------  
--DDL for Table EHRP_DEPT
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_DEPT
    (HRS_JOB_OPENING_ID     NUMBER(15),
    SETID                   VARCHAR2(10),
    DEPTID                  VARCHAR2(10),
    DESCR                   VARCHAR2(40),
    GVT_PAR_LINE2           VARCHAR2(10),
    GVT_PAR_DESCR2          VARCHAR2(40),
    GVT_PAR_LINE3           VARCHAR2(10),
    GVT_PAR_DESCR3          VARCHAR2(40),
    GVT_PAR_LINE4           VARCHAR2(10),
    GVT_PAR_DESCR4          VARCHAR2(40),
    GVT_PAR_LINE5           VARCHAR2(10),
    GVT_PAR_DESCR5          VARCHAR2(40),
    CREATE_DATE             DATE
    );
    
    CREATE UNIQUE INDEX EHRP_DEPT_PK ON HHS_HR.EHRP_DEPT (HRS_JOB_OPENING_ID);

--------------------------------------------------------  
--DDL for Table EHRP_APPROVALS
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_APPROVALS
    (HRS_JOB_OPENING_ID     NUMBER(15),
    STEP                    NUMBER(5,2),
    STATUS                  VARCHAR2(3),
    STATUS_DT               DATE,
    OPRID                   VARCHAR2(30),
    EMPLID                  VARCHAR2(11),
    COMMENTS                CLOB,
    CREATE_DATE             DATE
    );
    
    CREATE UNIQUE INDEX EHRP_APPROVALS_PK ON HHS_HR.EHRP_APPROVALS (HRS_JOB_OPENING_ID, STEP);

-------------------------------------------------------  
--DDL for Table EHRP_EWITS_DTL
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_EWITS_DTL
    (HRS_JOB_OPENING_ID         NUMBER(15),
    PHYSICIAN_COMP_ALLOWANCE    VARCHAR2(1),
    PHYSICIAN_DENTIST_PAY       VARCHAR2(1),
    NON_STANDARD_PAY            VARCHAR2(1),
    POSITION_DESCRIPTION        VARCHAR2(1),
    RECRUITMENT_INCENTIVE       VARCHAR2(1),
    RELOCATION_INCENTIVE        VARCHAR2(1),
    CAN                         VARCHAR2(25),
    CREATE_DATE                 DATE
    );

    CREATE UNIQUE INDEX EHRP_EWITS_DTL_PK ON HHS_HR.EHRP_EWITS_DTL (HRS_JOB_OPENING_ID);
    
--------------------------------------------------------  
--DDL for Table EHRP_EMPL_RPL
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_EMPL_RPL
    (HRS_JOB_OPENING_ID     NUMBER(15),
    VICE_EMPLID             VARCHAR2(11),
    DATE_VACATED            DATE,
    VICE_NAME               VARCHAR2(50),
    CREATE_DATE             DATE
    );

    CREATE UNIQUE INDEX EHRP_EMPL_RPL_PK ON HHS_HR.EHRP_EMPL_RPL (HRS_JOB_OPENING_ID, VICE_EMPLID);
    
--------------------------------------------------------  
--DDL for Table EHRP_POSITION_DTL
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_POSITION_DTL
    (HRS_JOB_OPENING_ID         NUMBER(15),
    POSITION_NBR                VARCHAR2(8),
    REPORTS_TO                  VARCHAR2(8),
    LOCATION                    VARCHAR2(10),
    STD_HRS_DEFAULT             NUMBER(6,2),
    BARG_UNIT                   VARCHAR2(4),
    GVT_PAY_PLAN                VARCHAR2(2),
    GVT_WORK_SCHED              VARCHAR2(1),
    GVT_ORG_TTL_DESCR           VARCHAR2(70),
    GVT_DRUG_TEST_REQ           VARCHAR2(1),
    GVT_OCC_SERIES              VARCHAR2(4),
    GVT_POSN_SENS_CD            VARCHAR2(1),
    SECURITY_CLEARANCE          VARCHAR2(1),
    GVT_EMP_FIN_INT             VARCHAR2(1),
    GRADE_DEFAULT               VARCHAR2(3),
    CREATE_DATE                 DATE
    );
    
    CREATE UNIQUE INDEX EHRP_POSITION_DTL_PK ON HHS_HR.EHRP_POSITION_DTL (HRS_JOB_OPENING_ID, POSITION_NBR);

--------------------------------------------------------  
--DDL for Table EHRP_JOBCODE_DTL
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_JOBCODE_DTL
    (HRS_JOB_OPENING_ID     NUMBER(15),
    JOBCODE                 VARCHAR2(8),
    SAL_ADMIN_PLAN          VARCHAR2(10),
    GRADE                   VARCHAR2(3),
    GVT_PAY_PLAN            VARCHAR2(2),
    GVT_OCC_SERIES          VARCHAR2(4),
    GVT_OFFICIAL_DESCR      VARCHAR2(70),
    GVT_EXEC_FIN_DISCL      VARCHAR2(1),
    GVT_TARGET_GRADE        VARCHAR2(2),
    CREATE_DATE             DATE
    );
    
    CREATE UNIQUE INDEX EHRP_JOBCODE_DTL_PK ON HHS_HR.EHRP_JOBCODE_DTL (HRS_JOB_OPENING_ID, JOBCODE);

--------------------------------------------------------  
--DDL for Table EHRP_SALARY_DTL
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_SALARY_DTL
    (HRS_JOB_OPENING_ID     NUMBER(15),
    JOBCODE                 VARCHAR2(8),
    MIN_RT_ANNUAL           NUMBER(18,3),
    MAX_RT_ANNUAL           NUMBER(18,3),
    CREATE_DATE             DATE
    );
    
    CREATE UNIQUE INDEX EHRP_SALARY_DTL_PK ON HHS_HR.EHRP_SALARY_DTL (HRS_JOB_OPENING_ID, JOBCODE);

--------------------------------------------------------  
--DDL for Table EHRP_POSITION_DEPT
--------------------------------------------------------  
    CREATE TABLE HHS_HR.EHRP_POSITION_DEPT
    (HRS_JOB_OPENING_ID     NUMBER(15),
    POSITION_NBR            VARCHAR2(8),
    SETID                   VARCHAR2(10),
    DEPTID                  VARCHAR2(10),
    DESCR                   VARCHAR2(40),
    GVT_PAR_LINE2           VARCHAR2(10),
    GVT_PAR_DESCR2          VARCHAR2(40),
    GVT_PAR_LINE3           VARCHAR2(10),
    GVT_PAR_DESCR3          VARCHAR2(40),
    GVT_PAR_LINE4           VARCHAR2(10),
    GVT_PAR_DESCR4          VARCHAR2(40),
    GVT_PAR_LINE5           VARCHAR2(10),
    GVT_PAR_DESCR5          VARCHAR2(40),
    CREATE_DATE             DATE
    );
    
    CREATE UNIQUE INDEX EHRP_POSITION_DEPT_PK ON HHS_HR.EHRP_POSITION_DEPT (HRS_JOB_OPENING_ID, POSITION_NBR);