--------------------------------------------
-- Backout statement
--------------------------------------------
/*

-- person directory module
DROP TABLE HHS_HR.EMPLOYEE_LOOKUP;
DROP TABLE HHS_HR.MEMBERHISTORY;
DROP TABLE HHS_HR.MEMBERSTG;

DROP SEQUENCE HHS_HR.MEMBERHISTORY_SEQ;


-- ref table
DROP TABLE HHS_HR.ADMINISTRATIVE_CODE;
DROP TABLE HHS_HR.APPOINTMENT_TYPE;
DROP TABLE HHS_HR.CYBERSECURITY_CODE;
DROP TABLE HHS_HR.DUTY_STATION;
DROP TABLE HHS_HR.LEGAL_AUTHORITY;
DROP TABLE HHS_HR.NATURE_OF_ACTION;
DROP TABLE HHS_HR.OCCUPATIONAL_SERIES;
DROP TABLE HHS_HR.PAY_PLAN;


-- ehrp module
DROP TABLE HHS_HR.PS_DEPT_TBL;
DROP TABLE HHS_HR.PS_HE_RECRUIT_EWIT;
DROP TABLE HHS_HR.PS_HRS_JO_LOC;
DROP TABLE HHS_HR.PS_HRS_JO_NAME;
DROP TABLE HHS_HR.PS_HRS_JO_POSN;
DROP TABLE HHS_HR.PS_HRS_JO_RPL;
DROP TABLE HHS_HR.PS_HRS_JO_RQMT;
DROP TABLE HHS_HR.PS_HRS_JOB_OPENING;
DROP TABLE HHS_HR.PS_HRS_LOCATION_I;
DROP TABLE HHS_HR.PS_JOBCODE_TBL;
DROP TABLE HHS_HR.PS_PERSONAL_DATA_VW;
DROP TABLE HHS_HR.PS_POSITION_DATA;
DROP TABLE HHS_HR.PS_SAL_GRADE_TBL;
DROP TABLE HHS_HR.PS_GVT_RQSN_JOBCD;
DROP TABLE HHS_HR.PS_GVT_RQSN_POSN;
DROP TABLE HHS_HR.PS_HE_GVT_RQSN_PRT;
DROP TABLE HHS_HR.PS_HE_JO_APPR_COMM;

*/

SET DEFINE OFF;


--=============================================================================
-- Person Directory module
--=============================================================================

--------------------------------------------------------
-- DDL for Table EMPLOYEE_LOOKUP
--------------------------------------------------------
CREATE TABLE HHS_HR.EMPLOYEE_LOOKUP
(
	LAST_NAME                       VARCHAR2(150),
	FIRST_NAME                      VARCHAR2(150),
	MIDDLE_NAME                     VARCHAR2(80),
	EMAIL_ADDR                      VARCHAR2(256),
	HHSID                           VARCHAR2(64),
	USERTYPE                        VARCHAR2(100),
	PIV_CARD_STATUS                 VARCHAR2(64),
	SCMS_STATUS                     VARCHAR2(64),
	EMPLID                          VARCHAR2(50),
	PAY_PLAN                        VARCHAR2(20),
	GRADE                           VARCHAR2(2),
	POSITION_TITLE_NAME             VARCHAR2(255),
	SERIES                          VARCHAR2(10),
	BARG_UNIT                       VARCHAR2(4),
	OPDIV                           VARCHAR2(100),
	ORG_CD                          VARCHAR2(50),
	PAY_BASIS                       VARCHAR2(2),
	STEP                            VARCHAR2(2),
	BASIC_PAY                       NUMBER(10,2),
	ADJ_BASIC_PAY                   NUMBER(10,2),
	CAN_CD                          VARCHAR2(50),
	JOB_CODE                        VARCHAR2(50),
	POSITION_NUM                    VARCHAR2(50),
	EMP_STATUS_FROM_PERS_SYSTEM     VARCHAR2(50),
	LAST_UPDT_FROM_PERS_SYSTEM_DT   DATE
);



    
--------------------------------------------------------  
--DDL for Table MEMBERHISTORY
--------------------------------------------------------  
 CREATE TABLE HHS_HR.MEMBERHISTORY
 (
	HISTORYID       NUMBER(38),
	CHANGEDATE      DATE,
	MEMBERID        VARCHAR2(10),
	HHSID           VARCHAR2(10),
	OPDIV           VARCHAR2(8),
	DMLTYPE         VARCHAR2(10),
	FIELDCHANGED    VARCHAR2(30),
	OLDVALUE        VARCHAR2(100),
	NEWVALUE        VARCHAR2(100)
);
 
COMMENT ON TABLE HHS_HR.MEMBERHISTORY IS 'Provides historical information on the transactions of the Bizflow MEMBER table';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.HISTORYID IS 'The unique memberhistory ID';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.CHANGEDATE IS 'The date that the transaction took place on the Bizflow MEMBER table';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.MEMBERID IS 'Corresponds to the memberid on the BizFlow MEMBER and MEMBERINFO tables';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.HHSID IS 'The HHS ID of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.OPDIV IS 'The Operating Division of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.DMLTYPE IS 'The type of DML: ''INSERT'' or ''UPDATE''';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.FIELDCHANGED IS 'The field that was updated on the Bizflow MEMBER table';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.OLDVALUE IS 'The old value on the Bizflow MEMBER table';
COMMENT ON COLUMN HHS_HR.MEMBERHISTORY.NEWVALUE IS 'The new value on the Bizflow MEMBER table';
   
--------------------------------------------------------
--  DDL for Index MEMBERHISTORY_PK
--------------------------------------------------------
CREATE UNIQUE INDEX HHS_HR.MEMBERHISTORY_PK ON HHS_HR.MEMBERHISTORY (HISTORYID);

--------------------------------------------------------
--  DDL for Index MEMBERHISTORY_I1
--------------------------------------------------------
CREATE INDEX HHS_HR.MEMBERHISTORY_I1 ON HHS_HR.MEMBERHISTORY(HHSID);

--------------------------------------------------------  
-- DDL for Sequence MEMBERHISTORY_SEQ
--------------------------------------------------------  
CREATE SEQUENCE HHS_HR.MEMBERHISTORY_SEQ NOCACHE;

--------------------------------------------------------  
--  DDL for Trigger MEMBERHISTORY_TRG
--------------------------------------------------------  
CREATE OR REPLACE TRIGGER HHS_HR.MEMBERHISTORY_TRG
BEFORE INSERT ON HHS_HR.MEMBERHISTORY
FOR EACH ROW
BEGIN
	<<COLUMN_SEQUENCES>>
	BEGIN
		IF INSERTING AND :NEW.HISTORYID IS NULL THEN
			SELECT HHS_HR.MEMBERHISTORY_SEQ.NEXTVAL INTO :NEW.HISTORYID FROM SYS.DUAL;
		END IF;
	END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER HHS_HR.MEMBERHISTORY_TRG ENABLE;




--------------------------------------------------------
-- DDL for Table MEMBERSTG
--------------------------------------------------------
CREATE TABLE HHS_HR.MEMBERSTG
(
	HHSID           VARCHAR2(64),
	FIRSTNAME       VARCHAR2(150),
	MIDDLENAME      VARCHAR2(80),
	LASTNAME        VARCHAR2(150),
	EMAIL           VARCHAR2(256),
	DEPTNAME        VARCHAR2(8),
	LASTUPDATE      DATE
);

COMMENT ON TABLE HHS_HR.MEMBERSTG IS 'Member Staging table';
COMMENT ON COLUMN HHS_HR.MEMBERSTG.HHSID IS 'HHSID of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERSTG.FIRSTNAME IS 'The first name of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERSTG.MIDDLENAME IS 'The middle name of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERSTG.LASTNAME IS 'The last name of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERSTG.EMAIL IS 'The email address of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERSTG.DEPTNAME IS 'The department name (OpDiv) of the employee';
COMMENT ON COLUMN HHS_HR.MEMBERSTG.LASTUPDATE IS 'The last update time from the Person System';




--------------------------------------------------------
-- Constraints for Table MEMBERHISTORY
-------------------------------------------------------- 
ALTER TABLE HHS_HR.MEMBERHISTORY ADD CONSTRAINT MEMBERHISTORY_PK PRIMARY KEY (HISTORYID) ENABLE;
ALTER TABLE HHS_HR.MEMBERHISTORY MODIFY (HISTORYID NOT NULL ENABLE);
ALTER TABLE HHS_HR.MEMBERHISTORY MODIFY (CHANGEDATE NOT NULL ENABLE);
ALTER TABLE HHS_HR.MEMBERHISTORY MODIFY (MEMBERID NOT NULL ENABLE);








--=============================================================================
-- Reference Table module
--=============================================================================

--------------------------------------------------------
--  DDL for Table ADMINISTRATIVE_CODE
--------------------------------------------------------
CREATE TABLE HHS_HR.ADMINISTRATIVE_CODE
(
	ADMIN_CODE              VARCHAR2(15),
	ADMIN_CODE_DESC         VARCHAR2(72),
	OPDIV                   VARCHAR2(8),
	OPDIV_NAME              VARCHAR2(72),
	STAFFDIV                VARCHAR2(4),
	STAFFDIV_NAME           VARCHAR2(72),
	DATE_CREATED            DATE,
	LAST_UPDATE_DATE        DATE,
	EEOC_OPDIV              VARCHAR2(20),
	ARCHIVE_IND             VARCHAR2(1)
);




--------------------------------------------------------
--  DDL for Table APPOINTMENT_TYPE
--------------------------------------------------------
CREATE TABLE HHS_HR.APPOINTMENT_TYPE
(
	APPMNT_CD          VARCHAR2(20),
	DESCRIPTION        VARCHAR2(80)
);




--------------------------------------------------------
--  DDL for Table CYBERSECURITY_CODE
--------------------------------------------------------

CREATE TABLE HHS_HR.CYBERSECURITY_CODE
(
	CYBERSECURITY_CODE           VARCHAR2(2),
	CYBERSECURITY_CD_DESC        VARCHAR2(100)
);




--------------------------------------------------------
--  DDL for Table DUTY_STATION
--------------------------------------------------------
CREATE TABLE HHS_HR.DUTY_STATION
(
	STATE_OR_COUNTRY_NAME        VARCHAR2(30),
	GEO_CODE                     VARCHAR2(12),
	STATE_ABBRV                  VARCHAR2(2),
	CITY_OR_COUNTRY_NAME         VARCHAR2(50),
	COUNTY                       VARCHAR2(50),
	STATE_OR_COUNTRY_CD          VARCHAR2(2)
);




--------------------------------------------------------
--  DDL for Table LEGAL_AUTHORITY
--------------------------------------------------------
CREATE TABLE HHS_HR.LEGAL_AUTHORITY
(
	AUTH_CODE            VARCHAR2(20),
	AUTH_DESC            VARCHAR2(100),
	STATUS               VARCHAR2(25),
	EFFECTIVE_DATE       DATE,
	AS_OF_DATE           DATE
) ;




--------------------------------------------------------
--  DDL for Table NATURE_OF_ACTION
--------------------------------------------------------
CREATE TABLE HHS_HR.NATURE_OF_ACTION
(
	NOA_CODE             VARCHAR2(20),
	NOA_DESC             VARCHAR2(100),
	NOA_SUFFIX_CD        VARCHAR2(1),
	LOAD_DATE            DATE
);




--------------------------------------------------------
--  DDL for Table OCCUPATIONAL_SERIES
--------------------------------------------------------
CREATE TABLE HHS_HR.OCCUPATIONAL_SERIES
(
	POSITION_SERIES        VARCHAR2(8),
	SERIES_DESC            VARCHAR2(100)
);




--------------------------------------------------------
--  DDL for Table PAY_PLAN
--------------------------------------------------------
CREATE TABLE HHS_HR.PAY_PLAN
(
	POSITION_PAY_PLAN        VARCHAR2(2),
	PAY_PLAN_DESC            VARCHAR2(100)
);








--=============================================================================
-- EHRP module
--=============================================================================

--------------------------------------------------------
--  DDL for Table PS_DEPT_TBL
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_DEPT_TBL 
(
	SETID                       VARCHAR2(5)     NOT NULL, 
	DEPTID                      VARCHAR2(10)    NOT NULL, 
	EFFDT                       DATE            NOT NULL, 
	EFF_STATUS                  VARCHAR2(1)     NOT NULL, 
	DESCR                       VARCHAR2(30)    NOT NULL, 
	DESCRSHORT                  VARCHAR2(10)    NOT NULL, 
	COMPANY                     VARCHAR2(3)     NOT NULL, 
	SETID_LOCATION              VARCHAR2(5)     NOT NULL, 
	LOCATION                    VARCHAR2(10)    NOT NULL, 
	TAX_LOCATION_CD             VARCHAR2(10)    NOT NULL, 
	MANAGER_ID                  VARCHAR2(11)    NOT NULL, 
	MANAGER_POSN                VARCHAR2(8)     NOT NULL, 
	BUDGET_YR_END_DT            NUMBER(*,0)     NOT NULL, 
	BUDGET_LVL                  VARCHAR2(1)     NOT NULL, 
	GL_EXPENSE                  VARCHAR2(35)    NOT NULL, 
	EEO4_FUNCTION               VARCHAR2(2)     NOT NULL, 
	CAN_IND_SECTOR              VARCHAR2(3)     NOT NULL, 
	ACCIDENT_INS                VARCHAR2(3)     NOT NULL, 
	SI_ACCIDENT_NUM             VARCHAR2(15)    NOT NULL, 
	HAZARD                      VARCHAR2(4)     NOT NULL, 
	ESTABID                     VARCHAR2(12)    NOT NULL, 
	RISKCD                      VARCHAR2(6)     NOT NULL, 
	GRADE                       VARCHAR2(3)     NOT NULL, 
	GVT_DESCR40                 VARCHAR2(40)    NOT NULL, 
	GVT_SUB_AGENCY              VARCHAR2(2)     NOT NULL, 
	GVT_PAR_LINE2               VARCHAR2(10)    NOT NULL, 
	GVT_PAR_LINE3               VARCHAR2(10)    NOT NULL, 
	GVT_PAR_LINE4               VARCHAR2(10)    NOT NULL, 
	GVT_PAR_LINE5               VARCHAR2(10)    NOT NULL, 
	GVT_PAR_DESCR2              VARCHAR2(40)    NOT NULL, 
	GVT_PAR_DESCR3              VARCHAR2(40)    NOT NULL, 
	GVT_PAR_DESCR4              VARCHAR2(40)    NOT NULL, 
	GVT_PAR_DESCR5              VARCHAR2(40)    NOT NULL, 
	FTE_EDIT_INDC               VARCHAR2(1)     NOT NULL, 
	DEPT_TENURE_FLG             VARCHAR2(1)     NOT NULL, 
	TL_DISTRIB_INFO             VARCHAR2(1)     NOT NULL, 
	USE_BUDGETS                 VARCHAR2(1)     NOT NULL, 
	USE_ENCUMBRANCES            VARCHAR2(1)     NOT NULL, 
	USE_DISTRIBUTION            VARCHAR2(1)     NOT NULL, 
	BUDGET_DEPTID               VARCHAR2(10)    NOT NULL, 
	HP_STATS_DEPT_CD            VARCHAR2(3)     NOT NULL, 
	HP_STATS_FACULTY            VARCHAR2(5)     NOT NULL, 
	MANAGER_NAME                VARCHAR2(30)    NOT NULL, 
	ACCOUNTING_OWNER            VARCHAR2(30)    NOT NULL, 
	COUNTRY_GRP                 VARCHAR2(18)    NOT NULL, 
	CLASS_UNIT_NZL              VARCHAR2(5)     NOT NULL, 
	ORG_UNIT_AUS                VARCHAR2(4)     NOT NULL, 
	WORK_SECTOR_AUS             VARCHAR2(1)     NOT NULL, 
	APS_AGENT_CD_AUS            NUMBER(*,0)     NOT NULL, 
	IND_COMMITTEE_BEL           VARCHAR2(3)     NOT NULL, 
	NACE_CD_BEL                 VARCHAR2(10)    NOT NULL
);

CREATE INDEX HHS_HR.PS_DEPT_TBL_IDX1 ON HHS_HR.PS_DEPT_TBL(SETID, DEPTID, EFFDT);

CREATE INDEX HHS_HR.PS_DEPT_TBL_IDX2 ON HHS_HR.PS_DEPT_TBL(EFF_STATUS);

--------------------------------------------------------
--  DDL for Table PS_HE_RECRUIT_EWIT
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HE_RECRUIT_EWIT
(
	HRS_JOB_OPENING_ID          NUMBER(15,0)    NOT NULL, 
	HE_COMP_ALLOWANCE           VARCHAR2(1)     NOT NULL, 
	HE_DENTIST_PAY              VARCHAR2(1)     NOT NULL, 
	HE_NON_STANDARD_PA          VARCHAR2(1)     NOT NULL, 
	HE_POSITION_DESCR           VARCHAR2(1)     NOT NULL, 
	HE_RECRUIT_INCENT           VARCHAR2(1)     NOT NULL, 
	HE_RELOCATIONBONUS          VARCHAR2(1)     NOT NULL, 
	ACCT_CD                     VARCHAR2(25)    NOT NULL
);

CREATE INDEX HHS_HR.PS_HE_RECRUIT_EWIT_IDX1 ON HHS_HR.PS_HE_RECRUIT_EWIT(HRS_JOB_OPENING_ID);

--------------------------------------------------------
--  DDL for Table PS_HRS_JO_LOC
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HRS_JO_LOC 
(
	HRS_JOB_OPENING_ID          NUMBER(15,0)    NOT NULL, 
	LOCATION                    VARCHAR2(10)    NOT NULL, 
	OPENINGS_TARGET             NUMBER(*,0)     NOT NULL, 
	HRS_JO_PRM_LOC_FLG          VARCHAR2(1)     NOT NULL, 
	HRS_ROW_ADD_DTTM            TIMESTAMP (6), 
	HRS_ROW_ADD_OPRID           VARCHAR2(30)    NOT NULL, 
	HRS_ROW_UPD_DTTM            TIMESTAMP (6), 
	HRS_ROW_UPD_OPRID           VARCHAR2(30)    NOT NULL
);

CREATE INDEX HHS_HR.PS_HRS_JO_LOC_IDX1 ON HHS_HR.PS_HRS_JO_LOC(HRS_JOB_OPENING_ID);

CREATE INDEX HHS_HR.PS_HRS_JO_LOC_IDX2 ON HHS_HR.PS_HRS_JO_LOC(LOCATION);

--------------------------------------------------------
--  DDL for Table PS_HRS_JO_NAME
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HRS_JO_NAME 
(
	HRS_JOB_OPENING_ID          NUMBER(15,0)    NOT NULL, 
	SEQUENCE_NBR                NUMBER(*,0)     NOT NULL, 
	NAME                        VARCHAR2(50)    NOT NULL, 
	HRS_ROW_ADD_DTTM            TIMESTAMP (6), 
	HRS_ROW_ADD_OPRID           VARCHAR2(30)    NOT NULL, 
	HRS_ROW_UPD_DTTM            TIMESTAMP (6), 
	HRS_ROW_UPD_OPRID           VARCHAR2(30)    NOT NULL
);

CREATE INDEX HHS_HR.PS_HRS_JO_NAME_IDX1 ON HHS_HR.PS_HRS_JO_NAME(HRS_JOB_OPENING_ID);


--------------------------------------------------------
--  DDL for Table PS_HRS_JO_POSN
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HRS_JO_POSN 
(
	HRS_JOB_OPENING_ID          NUMBER(15,0)    NOT NULL, 
	POSITION_NBR                VARCHAR2(8)     NOT NULL, 
	HRS_JO_PRM_PSN_FLG          VARCHAR2(1)     NOT NULL, 
	HRS_ROW_ADD_DTTM            TIMESTAMP (6), 
	HRS_ROW_ADD_OPRID           VARCHAR2(30)    NOT NULL, 
	HRS_ROW_UPD_DTTM            TIMESTAMP (6), 
	HRS_ROW_UPD_OPRID           VARCHAR2(30)    NOT NULL
);

CREATE INDEX HHS_HR.PS_HRS_JO_POSN_IDX1 ON HHS_HR.PS_HRS_JO_POSN(HRS_JOB_OPENING_ID, POSITION_NBR);

--------------------------------------------------------
--  DDL for Table PS_HRS_JO_RPL
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HRS_JO_RPL 
(
	HRS_JOB_OPENING_ID          NUMBER(15,0)    NOT NULL, 
	EMPLID                      VARCHAR2(11)    NOT NULL, 
	HE_VACATED_DT               DATE, 
	HRS_ROW_ADD_DTTM            TIMESTAMP (6), 
	HRS_ROW_ADD_OPRID           VARCHAR2(30)    NOT NULL, 
	HRS_ROW_UPD_DTTM            TIMESTAMP (6), 
	HRS_ROW_UPD_OPRID           VARCHAR2(30)    NOT NULL
);

CREATE INDEX HHS_HR.PPS_HRS_JO_RPL_IDX1 ON HHS_HR.PS_HRS_JO_RPL(HRS_JOB_OPENING_ID);

--------------------------------------------------------
--  DDL for Table PS_HRS_JO_RQMT
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HRS_JO_RQMT 
(
	HRS_JOB_OPENING_ID          NUMBER(15,0)    NOT NULL, 
	HRS_JO_RQMT_SEQ             NUMBER(*,0)     NOT NULL, 
	JOBCODE                     VARCHAR2(6)     NOT NULL, 
	HRS_JO_PRM_JCD_FLG          VARCHAR2(1)     NOT NULL, 
	GVT_NUM_APPS_CONS           NUMBER(*,0)     NOT NULL, 
	GVT_RQSN_CERT_NBR           VARCHAR2(10)    NOT NULL, 
	GVT_RQSN_CERT_SRC           VARCHAR2(1)     NOT NULL, 
	GVT_RQSN_CERT_STS           VARCHAR2(1)     NOT NULL, 
	DT_DUE                      DATE, 
	DT_ISSUED                   DATE, 
	DT_RECVD                    DATE, 
	DT_REQUESTED                DATE, 
	DT_RETURNED                 DATE, 
	GVT_DT_EXTENDED             DATE, 
	GVT_DT_RET_FRM_SO           DATE, 
	GVT_DT_SENT_TO_SO           DATE, 
	REG_REGION                  VARCHAR2(5)     NOT NULL, 
	FULL_PART_TIME              VARCHAR2(1)     NOT NULL, 
	REG_TEMP                    VARCHAR2(1)     NOT NULL, 
	BEGIN_DT                    DATE, 
	END_DT                      DATE, 
	STD_HOURS                   NUMBER(6,2)     NOT NULL, 
	STD_HRS_FREQUENCY           VARCHAR2(5)     NOT NULL, 
	SHIFT                       VARCHAR2(1)     NOT NULL, 
	HRS_JO_MIN_RT               NUMBER(21,6)    NOT NULL, 
	HRS_JO_MAX_RT               NUMBER(21,6)    NOT NULL, 
	PAY_FREQ_ABBRV              VARCHAR2(1)     NOT NULL, 
	CURRENCY_CD                 VARCHAR2(3)     NOT NULL, 
	SAL_ADMIN_PLAN              VARCHAR2(4)     NOT NULL, 
	GRADE_FROM                  VARCHAR2(3)     NOT NULL, 
	GRADE_TO                    VARCHAR2(3)     NOT NULL, 
	STEP_FROM                   NUMBER(*,0)     NOT NULL, 
	STEP_TO                     NUMBER(*,0)     NOT NULL, 
	HRS_TRAVEL_PERCENT          VARCHAR2(1)     NOT NULL, 
	MANAGER_LEVEL               VARCHAR2(2)     NOT NULL, 
	FLSA_STATUS                 VARCHAR2(1)     NOT NULL, 
	GVT_SUMMER_APPT             VARCHAR2(1)     NOT NULL, 
	GVT_NTE_DATE                DATE, 
	GVT_NTE_DAYS                NUMBER(*,0)     NOT NULL, 
	GVT_LEO_POSITION            VARCHAR2(1)     NOT NULL, 
	GVT_POSN_SENS_CD            VARCHAR2(1)     NOT NULL, 
	GVT_TYPE_OF_APPT            VARCHAR2(2)     NOT NULL, 
	HRS_ROW_ADD_DTTM            TIMESTAMP (6), 
	HRS_ROW_ADD_OPRID           VARCHAR2(30)    NOT NULL, 
	HRS_ROW_UPD_DTTM            TIMESTAMP (6), 
	HRS_ROW_UPD_OPRID           VARCHAR2(30)    NOT NULL
);

CREATE INDEX HHS_HR.PS_HRS_JO_RQMT_IDX1 ON HHS_HR.PS_HRS_JO_RQMT(HRS_JOB_OPENING_ID);

--------------------------------------------------------
--  DDL for Table PS_HRS_JOB_OPENING
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HRS_JOB_OPENING 
(
	HRS_JOB_OPENING_ID          NUMBER(15,0)    NOT NULL, 
	HRS_RCRT_TMPL_ID            NUMBER(15,0)    NOT NULL, 
	HRS_JO_TYPE                 VARCHAR2(1)     NOT NULL, 
	REFERRAL_PGM_ID             VARCHAR2(12)    NOT NULL, 
	ORIGINATOR_ID               VARCHAR2(11)    NOT NULL, 
	MANAGER_ID                  VARCHAR2(11)    NOT NULL, 
	RECRUITER_ID                VARCHAR2(11)    NOT NULL, 
	GVT_SEL_OFFICIAL            VARCHAR2(11)    NOT NULL, 
	OPEN_DT                     DATE, 
	CLOSE_DT                    DATE, 
	STATUS_CODE                 VARCHAR2(3)     NOT NULL, 
	STATUS_REASON               VARCHAR2(3)     NOT NULL, 
	STATUS_DT                   DATE            NOT NULL, 
	HRS_OPENING_LIMIT           VARCHAR2(1)     NOT NULL, 
	OPENINGS_CNT                NUMBER(*,0)     NOT NULL, 
	OPENINGS_TARGET             NUMBER(*,0)     NOT NULL, 
	HOT_JOB                     VARCHAR2(1)     NOT NULL, 
	BUSINESS_UNIT               VARCHAR2(5)     NOT NULL, 
	SETID_DEPT                  VARCHAR2(5)     NOT NULL, 
	DEPTID                      VARCHAR2(10)    NOT NULL, 
	COMPANY                     VARCHAR2(3)     NOT NULL, 
	HRS_PRM_JOBCODE             VARCHAR2(6)     NOT NULL, 
	HRS_PRM_POSITION            VARCHAR2(8)     NOT NULL, 
	HRS_PRM_LOCATION            VARCHAR2(10)    NOT NULL, 
	HRS_PRM_LOC_AREA            NUMBER(15,0)    NOT NULL, 
	HRS_PRM_PST_TITLE           VARCHAR2(200)   NOT NULL, 
	DESIRED_START_DT            DATE, 
	WC_COUNCIL_ID               VARCHAR2(9)     NOT NULL, 
	ENCUMB_DT_INDC              VARCHAR2(1)     NOT NULL, 
	PROJECTED_FILL_DT           DATE, 
	AUTHORIZATION_DT            DATE, 
	ESTABID                     VARCHAR2(12)    NOT NULL, 
	COUNTRY                     VARCHAR2(3)     NOT NULL, 
	CITIZENSHIP_STATUS          VARCHAR2(1)     NOT NULL, 
	MIN_AGE                     NUMBER(*,0)     NOT NULL, 
	MAX_AGE                     NUMBER(*,0)     NOT NULL, 
	SEX                         VARCHAR2(1)     NOT NULL, 
	HRS_CONTACT_ID              NUMBER(15,0)    NOT NULL, 
	GVT_STAFF_SPCLST            VARCHAR2(11)    NOT NULL, 
	GVT_CONSIDER_AREA           VARCHAR2(1)     NOT NULL, 
	GVT_DRAFT_STATUS            VARCHAR2(1)     NOT NULL, 
	HRS_G_JO_TYPE               VARCHAR2(1)     NOT NULL, 
	JOB_FAMILY                  VARCHAR2(6)     NOT NULL, 
	HRS_ROW_ADD_DTTM            TIMESTAMP (6), 
	HRS_ROW_ADD_OPRID           VARCHAR2(30)    NOT NULL, 
	HRS_ROW_UPD_DTTM            TIMESTAMP (6), 
	HRS_ROW_UPD_OPRID           VARCHAR2(30)    NOT NULL, 
	GVT_RECR_OFFICE             VARCHAR2(10)    NOT NULL, 
	HE_APPROVALO_OPRID          VARCHAR2(30)    NOT NULL, 
	HE_COMMENTS                 LONG
);

CREATE INDEX HHS_HR.PS_HRS_JOB_OPENING_IDX1 ON HHS_HR.PS_HRS_JOB_OPENING(HRS_JOB_OPENING_ID);

CREATE INDEX HHS_HR.PS_HRS_JOB_OPENING_IDX2 ON HHS_HR.PS_HRS_JOB_OPENING(OPEN_DT);

--------------------------------------------------------
--  DDL for Table PS_HRS_LOCATION_I
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HRS_LOCATION_I 
(
	SETID                       VARCHAR2(5), 
	LOCATION                    VARCHAR2(10), 
	EFFDT                       DATE, 
	COUNTRY                     VARCHAR2(3), 
	STATE                       VARCHAR2(6), 
	DESCR                       VARCHAR2(30), 
	DESCRSHORT                  VARCHAR2(10)
);

CREATE INDEX HHS_HR.PS_HRS_LOCATION_I_IDX1 ON HHS_HR.PS_HRS_LOCATION_I(LOCATION, EFFDT);

--------------------------------------------------------
--  DDL for Table PS_JOBCODE_TBL
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_JOBCODE_TBL 
(
	SETID                       VARCHAR2(5)     NOT NULL, 
	JOBCODE                     VARCHAR2(6)     NOT NULL, 
	EFFDT                       DATE            NOT NULL, 
	EFF_STATUS                  VARCHAR2(1)     NOT NULL, 
	DESCR                       VARCHAR2(30)    NOT NULL, 
	DESCRSHORT                  VARCHAR2(10)    NOT NULL, 
	JOB_FUNCTION                VARCHAR2(3)     NOT NULL, 
	SETID_SALARY                VARCHAR2(5)     NOT NULL, 
	SAL_ADMIN_PLAN              VARCHAR2(4)     NOT NULL, 
	GRADE                       VARCHAR2(3)     NOT NULL, 
	STEP                        NUMBER(*,0)     NOT NULL, 
	MANAGER_LEVEL               VARCHAR2(2)     NOT NULL, 
	SURVEY_SALARY               NUMBER(*,0)     NOT NULL, 
	SURVEY_JOB_CODE             VARCHAR2(8)     NOT NULL, 
	UNION_CD                    VARCHAR2(3)     NOT NULL, 
	RETRO_RATE                  NUMBER(6,4)     NOT NULL, 
	RETRO_PERCENT               NUMBER(6,4)     NOT NULL, 
	CURRENCY_CD                 VARCHAR2(3)     NOT NULL, 
	STD_HOURS                   NUMBER(6,2)     NOT NULL, 
	STD_HRS_FREQUENCY           VARCHAR2(5)     NOT NULL, 
	COMP_FREQUENCY              VARCHAR2(5)     NOT NULL, 
	WORKERS_COMP_CD             VARCHAR2(4)     NOT NULL, 
	JOB_FAMILY                  VARCHAR2(6)     NOT NULL, 
	JOB_KNOWHOW_POINTS          NUMBER(*,0)     NOT NULL, 
	JOB_ACCNTAB_POINTS          NUMBER(*,0)     NOT NULL, 
	JOB_PROBSLV_POINTS          NUMBER(*,0)     NOT NULL, 
	JOB_POINTS_TOTAL            NUMBER(*,0)     NOT NULL, 
	JOB_KNOWHOW_PCT             NUMBER(4,1)     NOT NULL, 
	JOB_ACCNTAB_PCT             NUMBER(4,1)     NOT NULL, 
	JOB_PROBSLV_PCT             NUMBER(4,1)     NOT NULL, 
	REG_TEMP                    VARCHAR2(1)     NOT NULL, 
	DIRECTLY_TIPPED             VARCHAR2(1)     NOT NULL, 
	MED_CHKUP_REQ               VARCHAR2(1)     NOT NULL, 
	FLSA_STATUS                 VARCHAR2(1)     NOT NULL, 
	EEO1CODE                    VARCHAR2(1)     NOT NULL, 
	EEO4CODE                    VARCHAR2(1)     NOT NULL, 
	EEO5CODE                    VARCHAR2(2)     NOT NULL, 
	EEO6CODE                    VARCHAR2(1)     NOT NULL, 
	EEO_JOB_GROUP               VARCHAR2(4)     NOT NULL, 
	US_SOC_CD                   VARCHAR2(10)    NOT NULL, 
	IPEDSSCODE                  VARCHAR2(1)     NOT NULL, 
	US_OCC_CD                   VARCHAR2(3)     NOT NULL, 
	CAN_PAYEQ_JOB_CLS           VARCHAR2(3)     NOT NULL, 
	CAN_NOC_CD                  VARCHAR2(4)     NOT NULL, 
	SEASONAL                    VARCHAR2(1)     NOT NULL, 
	BPS_ACTIVITY_CD             VARCHAR2(6)     NOT NULL, 
	FUNCTION_CD                 VARCHAR2(2)     NOT NULL, 
	BA_CD                       VARCHAR2(3)     NOT NULL, 
	TECHNICAL                   VARCHAR2(1)     NOT NULL, 
	MED_SURV_REQ                VARCHAR2(1)     NOT NULL, 
	EMP_CATEGRY_FRA             VARCHAR2(3)     NOT NULL, 
	ACTIVITY_TYPE_FRA           VARCHAR2(3)     NOT NULL, 
	INSEE_CD_FRA                VARCHAR2(4)     NOT NULL, 
	JOB_CTG_FRA_CD              VARCHAR2(2)     NOT NULL, 
	UK_SOC_CD                   VARCHAR2(2)     NOT NULL, 
	GVT_PAY_PLAN                VARCHAR2(2)     NOT NULL, 
	GVT_OCC_SERIES              VARCHAR2(4)     NOT NULL, 
	TRN_PROGRAM                 VARCHAR2(6)     NOT NULL, 
	COMPANY                     VARCHAR2(3)     NOT NULL, 
	GVT_FUNC_CLASS              VARCHAR2(2)     NOT NULL, 
	GVT_POSN_TITLE_CD           VARCHAR2(4)     NOT NULL, 
	GVT_OFFICIAL_DESCR          VARCHAR2(70)    NOT NULL, 
	GVT_ORG_TTL_CD              VARCHAR2(4)     NOT NULL, 
	GVT_ORG_TTL_DESCR           VARCHAR2(70)    NOT NULL, 
	GVT_PAY_BASIS               VARCHAR2(2)     NOT NULL, 
	GVT_SUB_AGENCY              VARCHAR2(2)     NOT NULL, 
	GVT_POI                     VARCHAR2(4)     NOT NULL, 
	GVT_PAREN_TITLE             VARCHAR2(1)     NOT NULL, 
	GVT_OPM_CERT_NBR            VARCHAR2(8)     NOT NULL, 
	GVT_POSN_CLASS_STD          VARCHAR2(254)   NOT NULL, 
	GVT_POSN_SENS_CD            VARCHAR2(1)     NOT NULL, 
	GVT_IA_ACTIONS              VARCHAR2(1)     NOT NULL, 
	GVT_EXEC_FIN_DISCL          VARCHAR2(1)     NOT NULL, 
	GVT_EMP_FIN_INT             VARCHAR2(1)     NOT NULL, 
	GVT_PATCOB_CD               VARCHAR2(1)     NOT NULL, 
	GVT_CLS_STANDARD            VARCHAR2(15)    NOT NULL, 
	GVT_CLASSIFIER_ID           VARCHAR2(11)    NOT NULL, 
	GVT_DT_CLASSIFIED           DATE, 
	BARG_UNIT                   VARCHAR2(4)     NOT NULL, 
	GVT_FUND_SOURCE             VARCHAR2(1)     NOT NULL, 
	GVT_LEO_POSITION            VARCHAR2(1)     NOT NULL, 
	GVT_PERF_PLAN               VARCHAR2(8)     NOT NULL, 
	GVT_TARGET_GRADE            VARCHAR2(2)    NOT NULL, 
	GVT_PI_UPD_IND              VARCHAR2(1)     NOT NULL, 
	ENCUMBER_INDC               VARCHAR2(1)     NOT NULL, 
	POSN_MGMT_INDC              VARCHAR2(1)     NOT NULL, 
	EG_ACADEMIC_RANK            VARCHAR2(3)     NOT NULL, 
	EG_GROUP                    VARCHAR2(6)     NOT NULL, 
	HP_STATS_DUTIES             VARCHAR2(2)     NOT NULL, 
	HP_STATS_RPT_FLAG           VARCHAR2(1)     NOT NULL, 
	ENCUMB_SAL_OPTN             VARCHAR2(3)     NOT NULL, 
	ENCUMB_SAL_AMT              NUMBER(18,3)    NOT NULL, 
	INAIL_CODE                  VARCHAR2(11)    NOT NULL, 
	ASCO_CD_AUS                 VARCHAR2(6)     NOT NULL, 
	PKG_TEMPLATE_ID             VARCHAR2(10)    NOT NULL, 
	PKG_RULE_ID                 VARCHAR2(10)    NOT NULL, 
	FUNCTION_AUS                VARCHAR2(1)     NOT NULL, 
	ANN_CNTACT_HRS_AUS          NUMBER(6,2)     NOT NULL, 
	TEACH_WEEKS_AUS             NUMBER(*,0)     NOT NULL, 
	CASUAL_TYPE_AUS             VARCHAR2(1)     NOT NULL, 
	WORK_DAY_HOURS              NUMBER(6,2)     NOT NULL, 
	FA_PAY_PROGRAM              VARCHAR2(3)     NOT NULL, 
	ELECTION_GROUP              VARCHAR2(5)     NOT NULL, 
	LABOR_AGREEMENT             VARCHAR2(6)     NOT NULL, 
	FP_PROF_CATG                VARCHAR2(3)     NOT NULL, 
	FP_JOB_FMLY                 VARCHAR2(4)     NOT NULL, 
	FP_OFF_COLAG                VARCHAR2(1)     NOT NULL, 
	FP_MATRIX_TYP               VARCHAR2(3)     NOT NULL, 
	FP_MATRIX_CD                VARCHAR2(4)     NOT NULL, 
	FP_BUSINESS_CD              VARCHAR2(4)     NOT NULL, 
	FP_JOBCD_ACC                VARCHAR2(1)     NOT NULL, 
	FP_ATCH_AREA                VARCHAR2(4)     NOT NULL, 
	FP_JOB_TYP                  VARCHAR2(2)     NOT NULL, 
	FP_AUTO_RATFY               VARCHAR2(1)     NOT NULL, 
	LAST_UPDATE_DATE            DATE, 
	REG_REGION                  VARCHAR2(5)     NOT NULL, 
	SAL_RANGE_MIN_RATE          NUMBER(18,6)    NOT NULL, 
	SAL_RANGE_MID_RATE          NUMBER(18,6)    NOT NULL, 
	SAL_RANGE_MAX_RATE          NUMBER(18,6)    NOT NULL, 
	SAL_RANGE_CURRENCY          VARCHAR2(3)     NOT NULL, 
	SAL_RANGE_FREQ              VARCHAR2(5)     NOT NULL, 
	JOB_PROFILE_ID              VARCHAR2(8)     NOT NULL, 
	DESCRLONG                   LONG
);

CREATE INDEX HHS_HR.PS_JOBCODE_TBL_IDX1 ON HHS_HR.PS_JOBCODE_TBL (SETID ASC, JOBCODE ASC, EFFDT ASC);

CREATE INDEX HHS_HR.PS_JOBCODE_TBL_IDX2 ON HHS_HR.PS_JOBCODE_TBL (EFF_STATUS ASC);


--------------------------------------------------------
--  DDL for Table PS_PERSONAL_DATA_VW
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_PERSONAL_DATA_VW 
(
	EMPLID                      VARCHAR2(11), 
	COUNTRY_NM_FORMAT           VARCHAR2(3), 
	NAME                        VARCHAR2(50), 
	NAME_INITIALS               VARCHAR2(6), 
	NAME_PREFIX                 VARCHAR2(4), 
	NAME_SUFFIX                 VARCHAR2(15), 
	NAME_ROYAL_PREFIX           VARCHAR2(15), 
	NAME_ROYAL_SUFFIX           VARCHAR2(15), 
	NAME_TITLE                  VARCHAR2(30), 
	LAST_NAME_SRCH              VARCHAR2(30), 
	FIRST_NAME_SRCH             VARCHAR2(30), 
	LAST_NAME                   VARCHAR2(30), 
	FIRST_NAME                  VARCHAR2(30), 
	MIDDLE_NAME                 VARCHAR2(30), 
	SECOND_LAST_NAME            VARCHAR2(30), 
	SECOND_LAST_SRCH            VARCHAR2(30), 
	NAME_AC                     VARCHAR2(50), 
	PREF_FIRST_NAME             VARCHAR2(30), 
	PARTNER_LAST_NAME           VARCHAR2(30), 
	PARTNER_ROY_PREFIX          VARCHAR2(15), 
	LAST_NAME_PREF_NLD          VARCHAR2(1), 
	NAME_DISPLAY                VARCHAR2(50), 
	NAME_FORMAL                 VARCHAR2(60), 
	CAMPUS_ID                   VARCHAR2(16), 
	COUNTRY                     VARCHAR2(3), 
	ADDRESS1                    VARCHAR2(55), 
	ADDRESS2                    VARCHAR2(55), 
	ADDRESS3                    VARCHAR2(55), 
	ADDRESS4                    VARCHAR2(55), 
	CITY                        VARCHAR2(30), 
	NUM1                        VARCHAR2(6), 
	NUM2                        VARCHAR2(6), 
	HOUSE_TYPE                  VARCHAR2(2), 
	ADDR_FIELD1                 VARCHAR2(2), 
	ADDR_FIELD2                 VARCHAR2(4), 
	ADDR_FIELD3                 VARCHAR2(4), 
	COUNTY                      VARCHAR2(30), 
	STATE                       VARCHAR2(6), 
	POSTAL                      VARCHAR2(12), 
	GEO_CODE                    VARCHAR2(11), 
	IN_CITY_LIMIT               VARCHAR2(1), 
	COUNTRY_OTHER               VARCHAR2(3), 
	ADDRESS1_OTHER              VARCHAR2(55), 
	ADDRESS2_OTHER              VARCHAR2(55), 
	ADDRESS3_OTHER              VARCHAR2(55), 
	ADDRESS4_OTHER              VARCHAR2(55), 
	CITY_OTHER                  VARCHAR2(30), 
	COUNTY_OTHER                VARCHAR2(30), 
	STATE_OTHER                 VARCHAR2(6), 
	POSTAL_OTHER                VARCHAR2(12), 
	NUM1_OTHER                  VARCHAR2(6), 
	NUM2_OTHER                  VARCHAR2(6), 
	HOUSE_TYPE_OTHER            VARCHAR2(2), 
	ADDR_FIELD1_OTHER           VARCHAR2(2), 
	ADDR_FIELD2_OTHER           VARCHAR2(4), 
	ADDR_FIELD3_OTHER           VARCHAR2(4), 
	IN_CITY_LMT_OTHER           VARCHAR2(1), 
	GEO_CODE_OTHER              VARCHAR2(11), 
	COUNTRY_CODE                VARCHAR2(3), 
	PHONE                       VARCHAR2(24), 
	EXTENSION                   VARCHAR2(6), 
	VA_BENEFIT                  VARCHAR2(1), 
	DEATH_CERTIF_NBR            VARCHAR2(10), 
	FERPA                       VARCHAR2(1), 
	PLACE_OF_DEATH              VARCHAR2(30), 
	US_WORK_ELIGIBILTY          VARCHAR2(1), 
	MILITARY_STATUS             VARCHAR2(1), 
	CITIZEN_PROOF1              VARCHAR2(10), 
	CITIZEN_PROOF2              VARCHAR2(10), 
	MEDICARE_ENTLD_DT           DATE, 
	HONSEKI_JPN                 VARCHAR2(2), 
	MILITARY_STAT_ITA           VARCHAR2(1), 
	MILITARY_TYPE_ITA           VARCHAR2(2), 
	MILITARY_RANK_ITA           VARCHAR2(50), 
	MILITARY_END_ITA            DATE, 
	ENTRY_DT_FRA                DATE, 
	MILIT_SITUATN_FRA           VARCHAR2(3), 
	CPAMID                      VARCHAR2(6), 
	BILINGUALISM_CODE           VARCHAR2(1), 
	HEALTH_CARE_NBR             VARCHAR2(12), 
	HEALTH_CARE_STATE           VARCHAR2(6), 
	MILIT_SITUATN_ESP           VARCHAR2(3), 
	SOC_SEC_AFF_DT              DATE, 
	MILITARY_STAT_GER           VARCHAR2(1), 
	EXPCTD_MILITARY_DT          DATE, 
	HR_RESPONSIBLE_ID           VARCHAR2(11), 
	SMOKER                      VARCHAR2(1), 
	SMOKER_DT                   DATE, 
	GVT_CRED_MIL_SVCE           VARCHAR2(4), 
	GVT_MILITARY_COMP           VARCHAR2(1), 
	GVT_MIL_GRADE               VARCHAR2(3), 
	GVT_MIL_RESRVE_CAT          VARCHAR2(1), 
	GVT_MIL_SEP_RET             VARCHAR2(1), 
	GVT_MIL_SVCE_END            DATE, 
	GVT_MIL_SVCE_START          DATE, 
	GVT_MIL_VERIFY              VARCHAR2(1), 
	GVT_PAR_NBR_LAST            NUMBER(38,0), 
	GVT_UNIF_SVC_CTR            VARCHAR2(1), 
	GVT_VET_PREF_APPT           VARCHAR2(1), 
	GVT_VET_PREF_RIF            VARCHAR2(1), 
	GVT_CHANGE_FLAG             VARCHAR2(1), 
	GVT_DRAFT_STATUS            VARCHAR2(1), 
	GVT_YR_ATTAINED             DATE, 
	GRADE                       VARCHAR2(3), 
	SAL_ADMIN_PLAN              VARCHAR2(4), 
	GVT_CURR_AGCY_EMPL          VARCHAR2(1), 
	GVT_CURR_FED_EMPL           VARCHAR2(1), 
	GVT_HIGH_PAY_PLAN           VARCHAR2(2), 
	GVT_HIGH_GRADE              VARCHAR2(3), 
	GVT_PREV_AGCY_EMPL          VARCHAR2(1), 
	GVT_PREV_FED_EMPL           VARCHAR2(1), 
	GVT_SEP_INCENTIVE           VARCHAR2(1), 
	GVT_SEP_INCENT_DT           DATE, 
	GVT_TENURE                  VARCHAR2(1), 
	GVT_PAY_PLAN                VARCHAR2(2), 
	BARG_UNIT                   VARCHAR2(4), 
	LASTUPDDTTM                 TIMESTAMP (6), 
	BIRTHPLACE                  VARCHAR2(30), 
	BIRTHCOUNTRY                VARCHAR2(3), 
	BIRTHSTATE                  VARCHAR2(6), 
	HIGHEST_EDUC_LVL            VARCHAR2(2), 
	FT_STUDENT                  VARCHAR2(1), 
	LANG_CD                     VARCHAR2(3), 
	ALTER_EMPLID                VARCHAR2(11), 
	ADDRESS1_AC                 VARCHAR2(55), 
	ADDRESS2_AC                 VARCHAR2(55), 
	ADDRESS3_AC                 VARCHAR2(55), 
	CITY_AC                     VARCHAR2(30), 
	HE_ERI                      VARCHAR2(6)
);



--------------------------------------------------------
--  DDL for Table PS_POSITION_DATA
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_POSITION_DATA 
(
	POSITION_NBR                VARCHAR2(8)     NOT NULL, 
	EFFDT                       DATE            NOT NULL, 
	EFF_STATUS                  VARCHAR2(1)     NOT NULL, 
	DESCR                       VARCHAR2(30)    NOT NULL, 
	DESCRSHORT                  VARCHAR2(10)    NOT NULL, 
	ACTION                      VARCHAR2(3)     NOT NULL, 
	ACTION_REASON               VARCHAR2(3)     NOT NULL, 
	ACTION_DT                   DATE, 
	BUSINESS_UNIT               VARCHAR2(5)     NOT NULL, 
	DEPTID                      VARCHAR2(10)    NOT NULL, 
	JOBCODE                     VARCHAR2(6)     NOT NULL, 
	POSN_STATUS                 VARCHAR2(1)     NOT NULL, 
	STATUS_DT                   DATE, 
	BUDGETED_POSN               VARCHAR2(1)     NOT NULL, 
	CONFIDENTIAL_POSN           VARCHAR2(1)     NOT NULL, 
	KEY_POSITION                VARCHAR2(1)     NOT NULL, 
	JOB_SHARE                   VARCHAR2(1)     NOT NULL, 
	MAX_HEAD_COUNT              NUMBER(*,0)     NOT NULL, 
	UPDATE_INCUMBENTS           VARCHAR2(1)     NOT NULL, 
	REPORTS_TO                  VARCHAR2(8)     NOT NULL, 
	REPORT_DOTTED_LINE          VARCHAR2(8)     NOT NULL, 
	ORGCODE                     VARCHAR2(60)    NOT NULL, 
	ORGCODE_FLAG                VARCHAR2(1)     NOT NULL, 
	LOCATION                    VARCHAR2(10)    NOT NULL, 
	MAIL_DROP                   VARCHAR2(50)    NOT NULL, 
	COUNTRY_CODE                VARCHAR2(3)     NOT NULL, 
	PHONE                       VARCHAR2(24)    NOT NULL, 
	COMPANY                     VARCHAR2(3)     NOT NULL, 
	STD_HOURS                   NUMBER(6,2)     NOT NULL, 
	STD_HRS_FREQUENCY           VARCHAR2(5)     NOT NULL, 
	UNION_CD                    VARCHAR2(3)     NOT NULL, 
	SHIFT                       VARCHAR2(1)     NOT NULL, 
	REG_TEMP                    VARCHAR2(1)     NOT NULL, 
	FULL_PART_TIME              VARCHAR2(1)     NOT NULL, 
	MON_HRS                     NUMBER(4,2)     NOT NULL, 
	TUES_HRS                    NUMBER(4,2)     NOT NULL, 
	WED_HRS                     NUMBER(4,2)     NOT NULL, 
	THURS_HRS                   NUMBER(4,2)     NOT NULL, 
	FRI_HRS                     NUMBER(4,2)     NOT NULL, 
	SAT_HRS                     NUMBER(4,2)     NOT NULL, 
	SUN_HRS                     NUMBER(4,2)     NOT NULL, 
	BARG_UNIT                   VARCHAR2(4)     NOT NULL, 
	GVT_PAY_PLAN                VARCHAR2(2)     NOT NULL, 
	SEASONAL                    VARCHAR2(1)     NOT NULL, 
	TRN_PROGRAM                 VARCHAR2(6)     NOT NULL, 
	LANGUAGE_SKILL              VARCHAR2(2)     NOT NULL, 
	MANAGER_LEVEL               VARCHAR2(2)     NOT NULL, 
	FLSA_STATUS                 VARCHAR2(1)     NOT NULL, 
	GVT_WIP_STATUS              VARCHAR2(3)     NOT NULL, 
	GVT_STATUS_TYPE             VARCHAR2(3)     NOT NULL, 
	GVT_WORK_SCHED              VARCHAR2(1)     NOT NULL, 
	GVT_SUB_AGENCY              VARCHAR2(2)     NOT NULL, 
	GVT_DT_POSN_ESTAB           DATE, 
	GVT_COMP_AREA               VARCHAR2(2)     NOT NULL, 
	GVT_COMP_LEVEL              VARCHAR2(4)     NOT NULL, 
	GVT_ORG_TTL_CD              VARCHAR2(4)     NOT NULL, 
	GVT_ORG_TTL_DESCR           VARCHAR2(70)    NOT NULL, 
	GVT_DRUG_TEST_REQ           VARCHAR2(1)     NOT NULL, 
	GVT_FUND_SOURCE             VARCHAR2(1)     NOT NULL, 
	GVT_INTEL_POSN              VARCHAR2(1)     NOT NULL, 
	GVT_LEO_POSITION            VARCHAR2(1)     NOT NULL, 
	GVT_MOB_POSN_IND            VARCHAR2(1)     NOT NULL, 
	GVT_PROC_INTEG_PSN          VARCHAR2(1)     NOT NULL, 
	GVT_PRESIDENT_APPT          VARCHAR2(1)     NOT NULL, 
	GVT_NTE_DATE                DATE, 
	GVT_OCC_SERIES              VARCHAR2(4)     NOT NULL, 
	GVT_PAR_NBR                 VARCHAR2(15)    NOT NULL, 
	GVT_PAREN_TITLE             VARCHAR2(1)     NOT NULL, 
	GVT_PERF_PLAN               VARCHAR2(8)     NOT NULL, 
	GVT_POI                     VARCHAR2(4)     NOT NULL, 
	GVT_POSN_LOC                VARCHAR2(1)     NOT NULL, 
	GVT_POSN_OCCUPIED           VARCHAR2(1)     NOT NULL, 
	GVT_POSN_SENS_CD            VARCHAR2(1)     NOT NULL, 
	SECURITY_CLEARANCE          VARCHAR2(1)     NOT NULL, 
	GVT_STAFF_LINE              VARCHAR2(1)     NOT NULL, 
	GVT_LAST_AUDIT_DT           DATE, 
	GVT_AUDITED_BY_ID           VARCHAR2(11)    NOT NULL, 
	GVT_OBLIGATED_TO            VARCHAR2(11)    NOT NULL, 
	GVT_OBLIG_EXPIR_DT          DATE, 
	GVT_TARGET_GRADE            VARCHAR2(2)     NOT NULL, 
	GVT_PI_UPD_IND              VARCHAR2(1)     NOT NULL, 
	GVT_EXEC_FIN_DISCL          VARCHAR2(1)     NOT NULL, 
	GVT_EMP_FIN_INT             VARCHAR2(1)     NOT NULL, 
	REG_REGION                  VARCHAR2(5)     NOT NULL, 
	CLASS_INDC                  VARCHAR2(1)     NOT NULL, 
	ENCUMBER_INDC               VARCHAR2(1)     NOT NULL, 
	FTE                         NUMBER(7,6)     NOT NULL, 
	POSITION_POOL_ID            VARCHAR2(3)     NOT NULL, 
	EG_ACADEMIC_RANK            VARCHAR2(3)     NOT NULL, 
	EG_GROUP                    VARCHAR2(6)     NOT NULL, 
	ENCUMB_SAL_OPTN             VARCHAR2(3)     NOT NULL, 
	ENCUMB_SAL_AMT              NUMBER(18,3)    NOT NULL, 
	HEALTH_CERTIFICATE          VARCHAR2(1)     NOT NULL, 
	SIGN_AUTHORITY              VARCHAR2(1)     NOT NULL, 
	ADDS_TO_FTE_ACTUAL          VARCHAR2(1)     NOT NULL, 
	SAL_ADMIN_PLAN              VARCHAR2(4)     NOT NULL, 
	GRADE                       VARCHAR2(3)     NOT NULL, 
	GRADE_FROM                  VARCHAR2(3)     NOT NULL, 
	STEP_FROM                   NUMBER(*,0)     NOT NULL, 
	GRADE_TO                    VARCHAR2(3)     NOT NULL, 
	STEP_TO                     NUMBER(*,0)     NOT NULL, 
	STEP                        NUMBER(*,0)     NOT NULL, 
	JOB_PROFILE_ID              VARCHAR2(8)     NOT NULL, 
	PKG_TEMPLATE_ID             VARCHAR2(10)    NOT NULL, 
	PKG_RULE_ID                 VARCHAR2(10)    NOT NULL, 
	SUPV_LVL_ID                 VARCHAR2(8)     NOT NULL, 
	INCLUDE_SALPLN_FLG          VARCHAR2(1)     NOT NULL, 
	POSN_DATA_MESSAGE           VARCHAR2(1)     NOT NULL, 
	HE_MED_OFF_IND              VARCHAR2(1)     NOT NULL, 
	HE_SE_TYPE                  VARCHAR2(1)     NOT NULL, 
	HE_TERM_ID                  VARCHAR2(2)     NOT NULL, 
	HE_POS_SUBJECT_TO           VARCHAR2(1)     NOT NULL, 
	HE_ACTIVITY_FUNC            VARCHAR2(4)     NOT NULL, 
	HE_REASON_CODE              VARCHAR2(1)     NOT NULL, 
	FUNCTION_CD                 VARCHAR2(2)     NOT NULL, 
	DESCRLONG                   LONG
);

CREATE INDEX HHS_HR.PS_POSITION_DATA_IDX1 ON HHS_HR.PS_POSITION_DATA (POSITION_NBR ASC);

CREATE INDEX HHS_HR.PS_POSITION_DATA_IDX2 ON HHS_HR.PS_POSITION_DATA (BUSINESS_UNIT ASC, JOBCODE ASC);

CREATE INDEX HHS_HR.PS_POSITION_DATA_IDX3 ON HHS_HR.PS_POSITION_DATA (POSITION_NBR ASC, EFFDT ASC);

CREATE INDEX HHS_HR.PS_POSITION_DATA_IDX4 ON HHS_HR.PS_POSITION_DATA (JOBCODE ASC);

CREATE INDEX HHS_HR.PS_POSITION_DATA_IDX5 ON HHS_HR.PS_POSITION_DATA (EFF_STATUS ASC);




--------------------------------------------------------
--  DDL for Table PS_SAL_GRADE_TBL
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_SAL_GRADE_TBL 
(
	SETID                       VARCHAR2(5)     NOT NULL, 
	SAL_ADMIN_PLAN              VARCHAR2(4)     NOT NULL, 
	GRADE                       VARCHAR2(3)     NOT NULL, 
	EFFDT                       DATE            NOT NULL, 
	EFF_STATUS                  VARCHAR2(1)     NOT NULL, 
	DESCR                       VARCHAR2(30)    NOT NULL, 
	DESCRSHORT                  VARCHAR2(10)    NOT NULL, 
	SALARY_MATRIX_CD            VARCHAR2(5)     NOT NULL, 
	CURRENCY_CD                 VARCHAR2(3)     NOT NULL, 
	MIN_RT_HOURLY               NUMBER(18,6)    NOT NULL, 
	MID_RT_HOURLY               NUMBER(18,6)    NOT NULL, 
	MAX_RT_HOURLY               NUMBER(18,6)    NOT NULL, 
	MIN_RT_MONTHLY              NUMBER(18,3)    NOT NULL, 
	MID_RT_MONTHLY              NUMBER(18,3)    NOT NULL, 
	MAX_RT_MONTHLY              NUMBER(18,3)    NOT NULL, 
	MIN_RT_ANNUAL               NUMBER(18,3)    NOT NULL, 
	MID_RT_ANNUAL               NUMBER(18,3)    NOT NULL, 
	MAX_RT_ANNUAL               NUMBER(18,3)    NOT NULL, 
	STEP_INCREM_TYPE            VARCHAR2(1)     NOT NULL, 
	STEP_INCREM_ACCUM           VARCHAR2(3)     NOT NULL, 
	MIN_RT_DAILY                NUMBER(18,3)    NOT NULL, 
	MID_RT_DAILY                NUMBER(18,3)    NOT NULL, 
	MAX_RT_DAILY                NUMBER(18,3)    NOT NULL, 
	LABOR_AGREEMENT             VARCHAR2(6)     NOT NULL, 
	EMPL_CTG                    VARCHAR2(6)     NOT NULL, 
	EMPL_CTG_L1                 VARCHAR2(6)     NOT NULL, 
	EMPL_CTG_L2                 VARCHAR2(6)     NOT NULL, 
	GVT_MAX_RT_BIWK             NUMBER(9,2)     NOT NULL, 
	GVT_MID_RT_BIWK             NUMBER(9,2)     NOT NULL, 
	GVT_MIN_RT_BIWK             NUMBER(9,2)     NOT NULL, 
	GRADE_TITLE_JPN             VARCHAR2(60)    NOT NULL, 
	MIN_YRS_GRADE               NUMBER(*,0)     NOT NULL, 
	MAX_YRS_GRADE               NUMBER(*,0)     NOT NULL, 
	MIN_GRD_AGE                 NUMBER(*,0)     NOT NULL, 
	REVIEW_COUNT                NUMBER(*,0)     NOT NULL, 
	ELIGIBILITY_POINTS          NUMBER(4,1)     NOT NULL, 
	REG_REGION                  VARCHAR2(5)     NOT NULL, 
	JOB_PROFILE_ID              VARCHAR2(8)     NOT NULL
);

CREATE INDEX HHS_HR.PS_SAL_GRADE_TBL_IDX1 ON HHS_HR.PS_SAL_GRADE_TBL(SETID, SAL_ADMIN_PLAN, GRADE, EFFDT);

CREATE INDEX HHS_HR.PS_SAL_GRADE_TBL_IDX2 ON HHS_HR.PS_SAL_GRADE_TBL(EFF_STATUS);

--------------------------------------------------------
--  DDL for Table PS_GVT_RQSN_JOBCD
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_GVT_RQSN_JOBCD
(
	JOB_REQ_NBR             VARCHAR2(6) NOT NULL,
	JOBCODE                 VARCHAR2(6) NOT NULL,
	GVT_RQSN_WQL_SCORE      NUMBER(*, 0) NOT NULL,
	GVT_RQSN_BQL_SCORE      NUMBER(*, 0) NOT NULL,
	GVT_RQSN_SAL_FROM       NUMBER(18, 6) NOT NULL,
	GVT_RQSN_SAL_TO         NUMBER(18, 6) NOT NULL,
	PAY_FREQ_ABBRV          VARCHAR2(1) NOT NULL,
	MANAGER_LEVEL           VARCHAR2(2) NOT NULL,
	FLSA_STATUS             VARCHAR2(1) NOT NULL,
	DESIRED_FULL_PART       VARCHAR2(1) NOT NULL,
	DESIRED_SHIFT           VARCHAR2(1) NOT NULL,
	STD_HOURS               NUMBER(6, 2) NOT NULL,
	DESIRED_REG_TEMP        VARCHAR2(1) NOT NULL,
	GVT_SUMMER_APPT         VARCHAR2(1) NOT NULL,
	GVT_NTE_DATE            DATE,
	GVT_NTE_DAYS            NUMBER(*, 0) NOT NULL,
	GVT_LEO_POSITION        VARCHAR2(1) NOT NULL,
	GVT_POSN_SENS_CD        VARCHAR2(1) NOT NULL,
	GVT_TRAVEL_PERCENT      VARCHAR2(1) NOT NULL,
	GVT_TYPE_OF_APPT        VARCHAR2(2) NOT NULL,
	GVT_PATCOB_CD           VARCHAR2(1) NOT NULL,
	GVT_PAY_PLAN            VARCHAR2(2) NOT NULL,
	GRADE                   VARCHAR2(3) NOT NULL,
	GVT_PRIMARY_JCODE       VARCHAR2(1) NOT NULL,
	GVT_NUM_APPS_CONS       NUMBER(*, 0) NOT NULL,
	EDUCATION_LVL           VARCHAR2(2) NOT NULL,
	GVT_REQUIRED            VARCHAR2(1) NOT NULL,
	GVT_MQ_MET_SCORE        NUMBER(*, 0) NOT NULL,
	GVT_MQ_NMET_SCORE       NUMBER(*, 0) NOT NULL,
	GVT_MQ_PASS_RAN_FR      NUMBER(*, 0) NOT NULL,
	GVT_MQ_PASS_RAN_TO      NUMBER(*, 0) NOT NULL,
	GVT_MQ_FAIL_RAN_FR      NUMBER(*, 0) NOT NULL,
	GVT_MQ_FAIL_RAN_TO      NUMBER(*, 0) NOT NULL,
	GVT_PNL_SCORE_LMT       NUMBER(*, 0) NOT NULL,
	GVT_MQ_PNL_SCORE        NUMBER(*, 0) NOT NULL,
	GVT_TRANSMUT_SCORE      VARCHAR2(1) NOT NULL,
	GVT_AUG_SCORE_LMT       NUMBER(*, 0) NOT NULL,
	GVT_PNL_AUG_SCORE       NUMBER(*, 0) NOT NULL,
	GVT_CONSIDER_AF         VARCHAR2(1) NOT NULL,
	GVT_CONSIDER_VP         VARCHAR2(1) NOT NULL,
	GVT_VP_SCORE_LMT        NUMBER(*, 0) NOT NULL,
	GVT_AUG_VP_SCORE        NUMBER(*, 0) NOT NULL,
	DT_DUE                  DATE,
	DT_ISSUED               DATE,
	DT_RECVD                DATE,
	DT_REQUESTED            DATE,
	DT_RETURNED             DATE,
	GVT_CONSID_VP_COMP      VARCHAR2(1) NOT NULL,
	GVT_CONSID_VP_NCMP      VARCHAR2(1) NOT NULL,
	GVT_DT_EXTENDED         DATE,
	GVT_DT_RET_FRM_SO       DATE,
	GVT_DT_SENT_TO_SO       DATE,
	GVT_OCC_SERIES          VARCHAR2(4) NOT NULL,
	GVT_RANK_COMP           VARCHAR2(1) NOT NULL,
	GVT_RANK_COMP_CAT1      VARCHAR2(1) NOT NULL,
	GVT_RANK_COMP_CAT2      VARCHAR2(1) NOT NULL,
	GVT_RANK_COMP_CAT3      VARCHAR2(1) NOT NULL,
	GVT_RANK_COMP_CAT4      VARCHAR2(1) NOT NULL,
	GVT_RANK_COMP_TYP       VARCHAR2(1) NOT NULL,
	GVT_RANK_JOBCODE        VARCHAR2(1) NOT NULL,
	GVT_RANK_NCMP_CAT1      VARCHAR2(1) NOT NULL,
	GVT_RANK_NCMP_CAT2      VARCHAR2(1) NOT NULL,
	GVT_RANK_NCMP_CAT3      VARCHAR2(1) NOT NULL,
	GVT_RANK_NCMP_CAT4      VARCHAR2(1) NOT NULL,
	GVT_RANK_NCOMP_TYP      VARCHAR2(1) NOT NULL,
	GVT_RANK_NONCOMP        VARCHAR2(1) NOT NULL,
	GVT_RQSN_CERT_NBR       VARCHAR2(10) NOT NULL,
	GVT_RQSN_CERT_SRC       VARCHAR2(1) NOT NULL,
	GVT_RQSN_CERT_STS       VARCHAR2(1) NOT NULL,
	GVT_TIE_BREAKER         NUMBER(*, 0) NOT NULL,
	GVT_APPLY_TIE           VARCHAR2(1) NOT NULL
);


--------------------------------------------------------
--  DDL for Table PS_GVT_RQSN_POSN
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_GVT_RQSN_POSN
(
	JOB_REQ_NBR             VARCHAR2(6) NOT NULL,
	POSITION_NBR            VARCHAR2(8) NOT NULL,
	JOBCODE                 VARCHAR2(6) NOT NULL,
	GVT_RQSN_WQL_SCORE      NUMBER(*, 0) NOT NULL,
	GVT_RQSN_BQL_SCORE      NUMBER(*, 0) NOT NULL,
	GVT_PRIMARY_JCODE       VARCHAR2(1) NOT NULL
);

--------------------------------------------------------
--  DDL for Table PS_HE_GVT_RQSN_PRT
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HE_GVT_RQSN_PRT
(
	OPRID                   VARCHAR2(30) NOT NULL,
	RUN_CNTL_ID             VARCHAR2(30) NOT NULL,
	GVT_WIP_RECORD          VARCHAR2(25) NOT NULL,
	JOB_REQ_NBR             VARCHAR2(6) NOT NULL,
	GVT_PAR_CUR_STATUS      VARCHAR2(3) NOT NULL,
	LOCATION                VARCHAR2(10) NOT NULL,
	GVT_RECR_OFFICE         VARCHAR2(10) NOT NULL,
	POSITION_NBR            VARCHAR2(8) NOT NULL,
	JOBCODE                 VARCHAR2(6) NOT NULL,
	JOB_REQ_STATUS          VARCHAR2(3) NOT NULL,
	GVT_RQSN_TYPE           VARCHAR2(1) NOT NULL,
	GVT_RQSN_REASON         VARCHAR2(1) NOT NULL,
	GVT_WIP_STATUS          VARCHAR2(3) NOT NULL,
	GRADE                   VARCHAR2(3) NOT NULL,
	GVT_PAY_PLAN            VARCHAR2(2) NOT NULL,
	GVT_OCC_SERIES          VARCHAR2(4) NOT NULL,
	GVT_OFFICIAL_DESCR      VARCHAR2(70) NOT NULL,
	GVT_DATE_WRK            DATE
);

--------------------------------------------------------
--  DDL for Table PS_HE_JO_APPR_COMM
--------------------------------------------------------
CREATE TABLE HHS_HR.PS_HE_JO_APPR_COMM
(
	HRS_JOB_OPENING_ID      NUMBER(15) NOT NULL,
	AWTHREAD_ID             NUMBER(10) NOT NULL,
	STEP_NBR                NUMBER(5,2) NOT NULL,
	AWSTEP_STATUS           VARCHAR2(1) NOT NULL,
	STATUS_DT               DATE,
	OPRID                   VARCHAR2(30) NOT NULL,
	EMPLID                  VARCHAR2(11),
	COMMENTS                LONG
);

CREATE INDEX HHS_HR.PS_HE_JO_APPR_COMM_IDX1 ON HHS_HR.PS_HE_JO_APPR_COMM(HRS_JOB_OPENING_ID);