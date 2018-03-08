

------------------------------------
-- Backout statement
------------------------------------
/*

DROP TABLE HISTDBA.CYBERSECURITY_CD_TBL;
DROP TABLE HISTDBA.DES_BIIS_PERSON_MV;
DROP TABLE HISTDBA.DUTY_STATION;
DROP TABLE HISTDBA.EHRP_APPT_TYPE_CD_TBL;
DROP TABLE HISTDBA.LEGAL_AUTHORITY;
DROP TABLE HISTDBA.MD715_SERIES;
DROP TABLE HISTDBA.NATURE_OF_ACTION;
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




------------------------------------
--DDL for table DUTY_STATION
------------------------------------
CREATE TABLE HISTDBA.DUTY_STATION
(
	DUTY_STATION_CD                 VARCHAR2(15)    NOT NULL
	, CITY_OR_COUNTRY_NAME          VARCHAR2(30)
	, STATE_OR_COUNTRY_CD           VARCHAR2(2)
	, STATE_OR_COUNTRY_NAME         VARCHAR2(30)
	, STATE_OR_COUNTRY_ABBR         VARCHAR2(2)
	, COUNTY                        VARCHAR2(30)
);




------------------------------------
--DDL for table EHRP_APPT_TYPE_CD_TBL
------------------------------------
CREATE TABLE HISTDBA.EHRP_APPT_TYPE_CD_TBL
(
	APPT_TYPE_CD                    VARCHAR2(15)
	, DESCR                         VARCHAR2(80)
);




------------------------------------
--DDL for table LEGAL_AUTHORITY
------------------------------------
CREATE TABLE HISTDBA.LEGAL_AUTHORITY
(
	LEGAL_AUTH_CD                   CHAR(3)         NOT NULL
	, LEGAL_AUTH_TXT                VARCHAR2(250)
	, STATUS                        VARCHAR2(25)
	, EFFECTIVE_DATE                DATE
	, AS_OF_DATE                    DATE
);




------------------------------------
--DDL for table MD715_SERIES
------------------------------------
-- occupation codes - generic OPM descriptions
CREATE TABLE HISTDBA.MD715_SERIES
(
	SERIES                          VARCHAR2(4)     NOT NULL
	, SERIES_DESCR                  VARCHAR2(80)
);


 
 
------------------------------------
--DDL for table NATURE_OF_ACTION
------------------------------------
CREATE TABLE HISTDBA.NATURE_OF_ACTION
(
	NOA_CD                          VARCHAR2(3)     NOT NULL
	, NOA_SUFFIX_CD                 CHAR(1)         NOT NULL 
	, NOA_DESC                      VARCHAR2(250)
	, LOAD_DTE                      DATE       
);




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



