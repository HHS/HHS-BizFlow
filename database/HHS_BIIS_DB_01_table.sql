

------------------------------------
-- Backout statement
------------------------------------
/*

DROP TABLE HISTDBA.CYBERSECURITY_CD_TBL;
DROP TABLE HISTDBA.DES_BIIS_PERSON_MV;
DROP TABLE HISTDBA.DUTY_STATION;
DROP TABLE HISTDBA.EHRP_APPT_TYPE_CD_TBL;
DROP TABLE HISTDBA.EWITS_BIIS_PERSON_MV;
DROP TABLE HISTDBA.LEGAL_AUTHORITY;
DROP TABLE HISTDBA.MD715_SERIES;
DROP TABLE HISTDBA.NATURE_OF_ACTION;
DROP TABLE HISTDBA.PAY_PLAN_TBL;
DROP TABLE HISTDBA.SAC_HIST_EXTENDED;

*/


SET DEFINE OFF;


------------------------------------
--DDL for table CYBERSECURITY_CD_TBL
------------------------------------
CREATE TABLE HISTDBA.CYBERSECURITY_CD_TBL
(
	CYBERSECURITY_CD                VARCHAR2(2)
	, DESCR                         VARCHAR2(200)
);

/




------------------------------------
--DDL for table DES_BIIS_PERSON_MV
------------------------------------
CREATE TABLE HISTDBA.DES_BIIS_PERSON_MV
(
	LAST_NAME                       VARCHAR2(150)
	, FIRST_NAME                    VARCHAR2(150)
	, EMAIL_ADDR                    VARCHAR2(256)
	, HHSID                         VARCHAR2(64)
	, USERTYPE                      VARCHAR2(100)
	, PIV_CARD_STATUS               VARCHAR2(64)
	, SCMS_STATUS                   VARCHAR2(64)
	, EMPLID                        VARCHAR2(50)
	, PAY_PLAN                      VARCHAR2(20)
	, GRADE                         VARCHAR2(2)
	, POSITION_TITLE_NAME           VARCHAR2(255)
	, SERIES                        VARCHAR2(10)
	, BARG_UNIT                     VARCHAR2(4)
	, OPDIV                         VARCHAR2(8)
	, ORG_CD                        VARCHAR2(50)
);

/




------------------------------------
--DDL for table DUTY_STATION
------------------------------------
CREATE TABLE HISTDBA.DUTY_STATION
(
	DUTY_STATION_CD                 VARCHAR2(15)
	, CITY_OR_COUNTRY_NAME          VARCHAR2(30)
	, STATE_OR_COUNTRY_CD           VARCHAR2(2)
	, STATE_OR_COUNTRY_NAME         VARCHAR2(30)
	, STATE_OR_COUNTRY_ABBR         VARCHAR2(2)
	, COUNTY                        VARCHAR2(30)
);

/

ALTER TABLE HISTDBA.DUTY_STATION ADD CONSTRAINT DUTYSTAT_PK PRIMARY KEY (DUTY_STATION_CD);

/




------------------------------------
--DDL for table EHRP_APPT_TYPE_CD_TBL
------------------------------------
CREATE TABLE HISTDBA.EHRP_APPT_TYPE_CD_TBL
(
	APPT_TYPE_CD                    VARCHAR2(15)
	, DESCR                         VARCHAR2(80)
);

/




------------------------------------
--DDL for table EWITS_BIIS_PERSON_MV
------------------------------------
CREATE TABLE HISTDBA.EWITS_BIIS_PERSON_MV
(
	LAST_NAME                           VARCHAR2(150)
	, FIRST_NAME                        VARCHAR2(150)
	, MIDDLE_NAME                       VARCHAR2(80)
	, EMAIL_ADDR                        VARCHAR2(256)
	, HHSID                             VARCHAR2(64)
	, USERTYPE                          VARCHAR2(100)
	, PIV_CARD_STATUS                   VARCHAR2(64)
	, SCMS_STATUS                       VARCHAR2(64)
	, EMPLID                            VARCHAR2(50)
	, PAY_PLAN                          VARCHAR2(20)
	, GRADE                             VARCHAR2(2)
	, POSITION_TITLE_NAME               VARCHAR2(255)
	, SERIES                            VARCHAR2(10)
	, BARG_UNIT                         VARCHAR2(4)
	, OPDIV                             VARCHAR2(100)
	, ORG_CD                            VARCHAR2(50)
	, PAY_BASIS                         VARCHAR2(2)
	, STEP                              VARCHAR2(2)
	, BASIC_PAY                         NUMBER(10,2)
	, ADJ_BASIC_PAY                     NUMBER(10,2)
	, CAN_CD                            VARCHAR2(50)
	, EMP_STATUS_FROM_PERS_SYSTEM       VARCHAR2(50)
	, LAST_UPDT_FROM_PERS_SYSTEM_DT     DATE
);

/





------------------------------------
--DDL for table LEGAL_AUTHORITY
------------------------------------
CREATE TABLE HISTDBA.LEGAL_AUTHORITY
(
	LEGAL_AUTH_CD                   CHAR(3)
	, LEGAL_AUTH_TXT                VARCHAR2(250)
	, STATUS                        VARCHAR2(25)
	, EFFECTIVE_DATE                DATE
	, AS_OF_DATE                    DATE
);

/

ALTER TABLE HISTDBA.LEGAL_AUTHORITY ADD CONSTRAINT LEGAL_AUTHORITY_PK PRIMARY KEY (LEGAL_AUTH_CD);

/




------------------------------------
--DDL for table MD715_SERIES
------------------------------------
-- occupation codes - generic OPM descriptions
CREATE TABLE HISTDBA.MD715_SERIES
(
	SERIES                          VARCHAR2(4)
	, SERIES_DESCR                  VARCHAR2(80)
);

/

ALTER TABLE HISTDBA.MD715_SERIES ADD CONSTRAINT MD715_SERIES_PK PRIMARY KEY (SERIES);

/


 
 
------------------------------------
--DDL for table NATURE_OF_ACTION
------------------------------------
CREATE TABLE HISTDBA.NATURE_OF_ACTION
(
	NOA_CD                          VARCHAR2(3)
	, NOA_SUFFIX_CD                 CHAR(1)
	, NOA_DESC                      VARCHAR2(250)
	, LOAD_DTE                      DATE       
);

/

ALTER TABLE HISTDBA.NATURE_OF_ACTION ADD CONSTRAINT NOA_PK PRIMARY KEY (NOA_CD, NOA_SUFFIX_CD);

/




------------------------------------
--DDL for table PAY_PLAN_TBL
------------------------------------
CREATE TABLE HISTDBA.PAY_PLAN_TBL
(
	PAY_PLAN_CD                    VARCHAR2(15)
	, DESCR                         VARCHAR2(80)
);

/




------------------------------------
--DDL for table SAC_HIST_EXTENDED
------------------------------------
-- Administrative codes
CREATE TABLE HISTDBA.SAC_HIST_EXTENDED
(
	ORG_CD                          VARCHAR2(15)
	, ORG_TITLE                     VARCHAR2(72)
	, OPDIV                         VARCHAR2(8)
	, OPDIV_NAME                    VARCHAR2(72)
	, STAFFDIV                      VARCHAR2(4)
	, STAFFDIV_NAME                 VARCHAR2(72)
	, DATE_CREATED                  DATE
	, LAST_UPDATE_DATE              DATE
	, EEOC_OPDIV                    VARCHAR2(20)
	, ARCHIVE_IND                   VARCHAR2(1)
);

/

COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.ORG_CD IS 'THE LOWEST ADMINISTRATIVE SUBDIVISION OF AN AGENCY TO WHICH AN EMPLOYEE IS ASSIGNED';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.ORG_TITLE IS 'THE NAME OF THE LOWEST ADMINISTRATIVE SUBDIVISION OF AN AGENCY TO WHICH AN EMPLOYEE IS ASSIGNED';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.OPDIV IS 'HHS OPERATING DIVISION ACRONYM';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.OPDIV_NAME IS 'HHS OPERATING DIVISION NAME SPELLED OUT';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.STAFFDIV IS 'LEADING CHARACTERS DESIGNATING STAFF DIVISION';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.STAFFDIV_NAME IS 'STAFF DIVISION NAME';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.DATE_CREATED IS 'DATE ORG CODE WAS CREATED';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.LAST_UPDATE_DATE IS 'DATE ORG CODE WAS LAST UPDATED';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.EEOC_OPDIV IS 'HHS OPERATING DIVISION GROUPING USED FOR EEOC REPORTS';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.ARCHIVE_IND IS 'BIIS GENERATED ARCHIVE INDICATOR';
COMMENT ON COLUMN HISTDBA.SAC_HIST_EXTENDED.EEOC_OPDIV IS 'HHS OPDIV GROUPING USED FOR EEOC REPORTS';


--ALTER TABLE HISTDBA.SAC_HIST_EXTENDED ADD CONSTRAINT SAC_HIST_EXTENDED_PK PRIMARY KEY (ORG_CD);

CREATE INDEX HISTDBA.SAC_HIST_EXTENDED_NK1 ON HISTDBA.SAC_HIST_EXTENDED (OPDIV ASC, ORG_CD ASC);

/


 

