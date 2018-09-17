SET DEFINE OFF;


/*
DROP TABLE LIST_MEM_JOB_OPEN_SEARCH CASCADE CONSTRAINTS ;
DROP TABLE CANDIDATE CASCADE CONSTRAINTS ;
DROP TABLE LIST CASCADE CONSTRAINTS ;
DROP TABLE CANDIDATE_LIST CASCADE CONSTRAINTS ;
DROP TABLE SEARCH_OCC_SERIES CASCADE CONSTRAINTS ;
DROP TABLE SEARCH_GRADE CASCADE CONSTRAINTS ;
DROP TABLE LIST_SEARCH_CANDIDATE CASCADE CONSTRAINTS ;
DROP TABLE ELIGIBILITY_LOC_PREFER CASCADE CONSTRAINTS ;
DROP TABLE CANDIDATE_GRADE CASCADE CONSTRAINTS ;
DROP TABLE CANDIDATE_OCC_SERIES CASCADE CONSTRAINTS ;
DROP TABLE ATTACHMENT CASCADE CONSTRAINTS ;
DROP TABLE USER_PERMISSION CASCADE CONSTRAINTS ;
DROP TABLE HHS_LIST_MANAGER_LOOKUP CASCADE CONSTRAINTS ;
DROP SEQUENCE CANDIDATE_SEQ;
DROP SEQUENCE LIST_SEQ;
DROP SEQUENCE LIST_MEM_JOB_OPEN_SEARCH_SEQ;
DROP SEQUENCE USER_PERMISSION_SEQ;
DROP SEQUENCE HHS_LIST_MANAGER_LOOKUP_SEQ;
*/


--------------------------------------------------------
--  DDL for Table CANDIDATE
--------------------------------------------------------

CREATE TABLE CANDIDATE 
(
	CANDIDATE_ID NUMBER(15), 
	FIRST_NAME VARCHAR2(100), 
	MIDDLE_INITIAL VARCHAR2(1), 
	LAST_NAME VARCHAR2(100), 
	HHSID NUMBER(10), 
	SEPARATION_DATE DATE, 
	CREATING_ORG_CODE VARCHAR2(20), 
	PERFORMANCE_RATING_CODE VARCHAR2(40), 
	PERFORMANCE_PD_START DATE, 
	PERFORMANCE_PD_END DATE, 
	ELIGIBILITY_START_DATE  DATE,
	ELIGIBILITY_END_DATE  DATE,
	VETERAN_STATUS_CODE VARCHAR2(20), 
	EMPLOYEE_TYPE_CODE VARCHAR2(100), 
	BASIS_FOR_ELIGIBILITY_CODE VARCHAR2(100), 
	COMMENTS VARCHAR2(4000), 
	HHS_EMPLMT_STATUS_CODE VARCHAR2(20), 
	HHS_EMPLMT_STATUS_AS_OF DATE, 
	EMAIL_ADDRESS VARCHAR2(100), 
	ADDRESS_LINE1 VARCHAR2(100), 
	ADDRESS_LINE2 VARCHAR2(100), 
	ADDRESS_CITY VARCHAR2(100), 
	ADDRESS_STATE VARCHAR2(2), 
	ADDRESS_ZIP VARCHAR2(10), 
	ADDRESS_LATITUDE VARCHAR2(10), 
	ADDRESS_LONGITUDE VARCHAR2(10), 
	LIST_ELIGIBLE_FLAG VARCHAR2(1),
	CREATED_BY VARCHAR2(10),
	CREATION_DATE DATE,
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE
) ;

--------------------------------------------------------
--  DDL for Index CANDIDATE_PK
--------------------------------------------------------

CREATE UNIQUE INDEX CANDIDATE_PK ON CANDIDATE (CANDIDATE_ID);

--------------------------------------------------------
--  Constraints for Table CANDIDATE
--------------------------------------------------------

ALTER TABLE CANDIDATE ADD CONSTRAINT CANDIDATE_PK PRIMARY KEY (CANDIDATE_ID);

--------------------------------------------------------
--  DDL for SEQLUENCE CANDIDATE_SEQ
--------------------------------------------------------

CREATE SEQUENCE CANDIDATE_SEQ
	INCREMENT BY 1
	START WITH 100000000000000
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for TRIGER CANDIDATE_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER CANDIDATE_TRG
BEFORE INSERT ON CANDIDATE
FOR EACH ROW
BEGIN
	SELECT CANDIDATE_SEQ.NEXTVAL
	INTO :NEW.CANDIDATE_ID
	FROM DUAL;
END;

/


--------------------------------------------------------
--  DDL for Table LIST
--------------------------------------------------------

CREATE TABLE LIST 
(
	LIST_ID  NUMBER(15), 
	LIST_TYPE  VARCHAR2(30), 
	LIST_NAME  VARCHAR2(100), 
	LIST_DESCRIPTION  VARCHAR2(100),
	OWNING_ORG_CODE  VARCHAR2(100),
	LIST_EFF_START_DATE DATE,
	LIST_EFF_END_DATE DATE,
	ELIGIBILITY_DURATION_IN_DAYS NUMBER (4),
	CREATED_BY VARCHAR2(10),
	CREATION_DATE DATE,
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE
) ;

--------------------------------------------------------
--  DDL for Index LIST_PK
--------------------------------------------------------

CREATE UNIQUE INDEX LIST_PK ON LIST (LIST_ID);

--------------------------------------------------------
--  Constraints for Table LIST
--------------------------------------------------------

ALTER TABLE LIST ADD CONSTRAINT LIST_PK PRIMARY KEY (LIST_ID);


--------------------------------------------------------
--  DDL for SEQLUENCE LIST_SEQ
--------------------------------------------------------

CREATE SEQUENCE LIST_SEQ
	INCREMENT BY 1
	START WITH 100000000000000
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for TRIGER LIST_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER LIST_TRG
BEFORE INSERT ON LIST
FOR EACH ROW
BEGIN
	SELECT LIST_SEQ.NEXTVAL
	INTO :NEW.LIST_ID
	FROM DUAL;
END;

/


--------------------------------------------------------
--  DDL for Table CANDIDATE_LIST
--------------------------------------------------------

CREATE TABLE CANDIDATE_LIST 
(
	CANDIDATE_ID NUMBER (15),
	LIST_ID  NUMBER (15),
	LIST_ELIGIBILITY_START_DATE DATE,
	LIST_ELIGIBILITY_END_DATE DATE,
	CREATING_ORG_CODE VARCHAR2(20),
	CREATED_BY VARCHAR2(10),
	CREATION_DATE DATE,
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE
) ;

--------------------------------------------------------
--  DDL for Index CANDIDATE_LIST_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX CANDIDATE_LIST_INDEX ON CANDIDATE_LIST (CANDIDATE_ID, LIST_ID);

--------------------------------------------------------
--  Constraints for Table CANDIDATE_LIST
--------------------------------------------------------

ALTER TABLE CANDIDATE_LIST ADD UNIQUE (CANDIDATE_ID, LIST_ID);
ALTER TABLE CANDIDATE_LIST MODIFY (CANDIDATE_ID NOT NULL);
ALTER TABLE CANDIDATE_LIST MODIFY (LIST_ID NOT NULL);

--------------------------------------------------------
--  Ref Constraints for Table CANDIDATE_LIST
--------------------------------------------------------

ALTER TABLE CANDIDATE_LIST ADD FOREIGN KEY (CANDIDATE_ID) REFERENCES CANDIDATE (CANDIDATE_ID) ;
ALTER TABLE CANDIDATE_LIST ADD FOREIGN KEY (LIST_ID) REFERENCES LIST (LIST_ID) ;


--------------------------------------------------------
--  DDL for Table LIST_MEM_JOB_OPEN_SEARCH
--------------------------------------------------------

CREATE TABLE LIST_MEM_JOB_OPEN_SEARCH 
(
	SEARCH_ID  NUMBER (10),
	HRS_JOB_OPENING_ID   NUMBER (15),
	LIST_ID  NUMBER (15),
	PREF_LOC_TO_JOB_DISTANCE NUMBER(20),
	VALID_FLAG VARCHAR2(1) DEFAULT 'T',
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE,
	CREATED_BY VARCHAR2(10),
	CREATION_DATE DATE	
) ;

--------------------------------------------------------
--  DDL for Index LIST_MEM_JOB_OPEN_SEARCH_PK 
--  DDL for Index LIST_MEM_JOB_OPEN_SEARCH_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX LIST_MEM_JOB_OPEN_SEARCH_PK ON LIST_MEM_JOB_OPEN_SEARCH (SEARCH_ID);
CREATE UNIQUE INDEX LIST_MEM_JOB_OPEN_SEARCH_INDEX ON LIST_MEM_JOB_OPEN_SEARCH (HRS_JOB_OPENING_ID, LIST_ID);


ALTER TABLE LIST_MEM_JOB_OPEN_SEARCH ADD UNIQUE (HRS_JOB_OPENING_ID, LIST_ID);
ALTER TABLE LIST_MEM_JOB_OPEN_SEARCH MODIFY (HRS_JOB_OPENING_ID NOT NULL);
ALTER TABLE LIST_MEM_JOB_OPEN_SEARCH MODIFY (LIST_ID NOT NULL);

--------------------------------------------------------
--  Constraints for Table LIST_MEM_JOB_OPEN_SEARCH
--------------------------------------------------------

ALTER TABLE LIST_MEM_JOB_OPEN_SEARCH ADD CONSTRAINT LIST_MEM_JOB_OPEN_SEARCH_PK PRIMARY KEY (SEARCH_ID);

--------------------------------------------------------
--  Ref Constraints for Table LIST_MEM_JOB_OPEN_SEARCH
--------------------------------------------------------

--ALTER TABLE LIST_MEM_JOB_OPEN_SEARCH ADD FOREIGN KEY (HRS_JOB_OPENING_ID) REFERENCES PS_HRS_JOB_OPENING (HRS_JOB_OPENING_ID) ;
ALTER TABLE LIST_MEM_JOB_OPEN_SEARCH ADD FOREIGN KEY (LIST_ID) REFERENCES LIST (LIST_ID) ;

--------------------------------------------------------
--  DDL for SEQLUENCE LIST_MEM_JOB_OPEN_SEARCH_SEQ
--------------------------------------------------------

CREATE SEQUENCE LIST_MEM_JOB_OPEN_SEARCH_SEQ
	INCREMENT BY 1
	START WITH 1
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for TRIGER LIST_MEM_JOB_OPEN_SEARCH_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER LIST_MEM_JOB_OPEN_SEARCH_TRG
BEFORE INSERT ON LIST_MEM_JOB_OPEN_SEARCH
FOR EACH ROW
BEGIN
	SELECT LIST_MEM_JOB_OPEN_SEARCH_SEQ.NEXTVAL
	INTO :NEW.SEARCH_ID
	FROM DUAL;
END;

/


--------------------------------------------------------
--  DDL for Table SEARCH_OCC_SERIES
--------------------------------------------------------

CREATE TABLE SEARCH_OCC_SERIES 
(
	SEARCH_ID  NUMBER (10),
	OCC_SERIES   VARCHAR2 (8)
) ;

--------------------------------------------------------
--  DDL for Index SEARCH_OCC_SERIES_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX SEARCH_OCC_SERIES_INDEX ON SEARCH_OCC_SERIES (SEARCH_ID, OCC_SERIES);

--------------------------------------------------------
--  Constraints for Table SEARCH_OCC_SERIES
--------------------------------------------------------

ALTER TABLE SEARCH_OCC_SERIES ADD UNIQUE (SEARCH_ID, OCC_SERIES);
ALTER TABLE SEARCH_OCC_SERIES MODIFY (SEARCH_ID NOT NULL );
ALTER TABLE SEARCH_OCC_SERIES MODIFY (OCC_SERIES NOT NULL );

--------------------------------------------------------
--  Ref Constraints for Table SEARCH_OCC_SERIES
--------------------------------------------------------

ALTER TABLE SEARCH_OCC_SERIES ADD FOREIGN KEY (SEARCH_ID) REFERENCES LIST_MEM_JOB_OPEN_SEARCH (SEARCH_ID) ;
--ALTER TABLE SEARCH_OCC_SERIES ADD FOREIGN KEY (OCC_SERIES) REFERENCES OCCUPATIONAL_SERIES (POSITION_SERIES) ;


--------------------------------------------------------
--  DDL for Table SEARCH_GRADE
--------------------------------------------------------

CREATE TABLE SEARCH_GRADE 
(
	SEARCH_ID  NUMBER (10),
	GRADE_CODE  VARCHAR2 (2)
) ;

--------------------------------------------------------
--  DDL for Index SEARCH_GRADE_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX SEARCH_GRADE_INDEX ON SEARCH_GRADE (SEARCH_ID) ;

--------------------------------------------------------
--  Constraints for Table SEARCH_GRADE
--------------------------------------------------------

ALTER TABLE SEARCH_GRADE ADD UNIQUE (SEARCH_ID);

ALTER TABLE SEARCH_GRADE MODIFY (SEARCH_ID NOT NULL );

--------------------------------------------------------
--  Ref Constraints for Table SEARCH_GRADE
--------------------------------------------------------

ALTER TABLE SEARCH_GRADE ADD FOREIGN KEY (SEARCH_ID) REFERENCES LIST_MEM_JOB_OPEN_SEARCH (SEARCH_ID) ;


--------------------------------------------------------
--  DDL for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

CREATE TABLE LIST_SEARCH_CANDIDATE 
(
	SEARCH_ID  NUMBER (10),
	CANDIDATE_ID NUMBER (15),
	CLEARING_ACTION_CODE VARCHAR2(20),
	EMAIL_SENT_TO_CANDIDATE_DATE DATE,
	ELIGIBILITY_END_REASON_CODE  VARCHAR2(60),
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE,
	CREATED_BY VARCHAR2(10),
	CREATION_DATE DATE
) ;

--------------------------------------------------------
--  DDL for Index LIST_SEARCH_CANDIDATE_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX LIST_SEARCH_CANDIDATE_INDEX ON LIST_SEARCH_CANDIDATE (SEARCH_ID, CANDIDATE_ID) ;
--------------------------------------------------------
--  Constraints for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

ALTER TABLE LIST_SEARCH_CANDIDATE ADD UNIQUE (SEARCH_ID, CANDIDATE_ID);
ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (SEARCH_ID NOT NULL );
ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (CANDIDATE_ID NOT NULL );

--------------------------------------------------------
--  Ref Constraints for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

ALTER TABLE LIST_SEARCH_CANDIDATE ADD FOREIGN KEY (SEARCH_ID) REFERENCES LIST_MEM_JOB_OPEN_SEARCH (SEARCH_ID) ;
ALTER TABLE LIST_SEARCH_CANDIDATE ADD FOREIGN KEY (CANDIDATE_ID) REFERENCES CANDIDATE (CANDIDATE_ID) ;


--------------------------------------------------------
--  DDL for Table ELIGIBILITY_LOC_PREFER
--------------------------------------------------------

CREATE TABLE ELIGIBILITY_LOC_PREFER 
(
	CANDIDATE_ID NUMBER(15),
	LOCATION VARCHAR2 (10)
) ;

--------------------------------------------------------
--  DDL for Index ELIGIBILITY_LOC_PREFER_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX ELIGIBILITY_LOC_PREFER_INDEX ON ELIGIBILITY_LOC_PREFER (CANDIDATE_ID, LOCATION);

--------------------------------------------------------
--  Constraints for Table ELIGIBILITY_LOC_PREFER
--------------------------------------------------------

ALTER TABLE ELIGIBILITY_LOC_PREFER ADD UNIQUE (CANDIDATE_ID, LOCATION);
ALTER TABLE ELIGIBILITY_LOC_PREFER MODIFY (CANDIDATE_ID NOT NULL );
ALTER TABLE ELIGIBILITY_LOC_PREFER MODIFY (LOCATION NOT NULL );

 --------------------------------------------------------
--  Ref Constraints for Table ELIGIBILITY_LOC_PREFER
--------------------------------------------------------

ALTER TABLE ELIGIBILITY_LOC_PREFER ADD FOREIGN KEY (CANDIDATE_ID)  REFERENCES CANDIDATE (CANDIDATE_ID);
--ALTER TABLE ELIGIBILITY_LOC_PREFER ADD FOREIGN KEY (LOCATION)  REFERENCES PS_HRS_LOCATION_I (LOCATION);


--------------------------------------------------------
--  DDL for Table CANDIDATE_GRADE
--------------------------------------------------------

CREATE TABLE CANDIDATE_GRADE 
(
	CANDIDATE_ID NUMBER(15),
	GRADE_CODE  VARCHAR2 (2),
	CREATED_BY VARCHAR2(10),
	CREATION_DATE	DATE,
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE
) ;

--------------------------------------------------------
--  DDL for Index CANDIDATE_GRADE_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX CANDIDATE_GRADE_INDEX ON CANDIDATE_GRADE (CANDIDATE_ID);

--------------------------------------------------------
--  Constraints for Table CANDIDATE_GRADE
--------------------------------------------------------

ALTER TABLE CANDIDATE_GRADE ADD UNIQUE (CANDIDATE_ID);
ALTER TABLE CANDIDATE_GRADE MODIFY (CANDIDATE_ID NOT NULL );

 --------------------------------------------------------
--  Ref Constraints for Table CANDIDATE_GRADE
--------------------------------------------------------

ALTER TABLE CANDIDATE_GRADE ADD FOREIGN KEY (CANDIDATE_ID)  REFERENCES CANDIDATE (CANDIDATE_ID);


--------------------------------------------------------
--  DDL for Table CANDIDATE_OCC_SERIES
--------------------------------------------------------

CREATE TABLE CANDIDATE_OCC_SERIES 
(
	CANDIDATE_ID NUMBER(15),
	OCC_SERIES   VARCHAR2 (8),
	CREATED_BY VARCHAR2(10),
	CREATION_DATE	DATE,
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE
) ;

 --------------------------------------------------------
--  DDL for Index CANDIDATE_OCC_SERIES_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX CANDIDATE_OCC_SERIES_INDEX ON CANDIDATE_OCC_SERIES (CANDIDATE_ID, OCC_SERIES);

--------------------------------------------------------
--  Constraints for Table CANDIDATE_OCC_SERIES
--------------------------------------------------------

ALTER TABLE CANDIDATE_OCC_SERIES ADD UNIQUE (CANDIDATE_ID, OCC_SERIES);
ALTER TABLE CANDIDATE_OCC_SERIES MODIFY (CANDIDATE_ID NOT NULL );
ALTER TABLE CANDIDATE_OCC_SERIES MODIFY (OCC_SERIES NOT NULL );

--------------------------------------------------------
--  Ref Constraints for Table CANDIDATE_OCC_SERIES
--------------------------------------------------------

ALTER TABLE CANDIDATE_OCC_SERIES ADD FOREIGN KEY (CANDIDATE_ID) REFERENCES CANDIDATE (CANDIDATE_ID) ;
--ALTER TABLE CANDIDATE_OCC_SERIES ADD FOREIGN KEY (OCC_SERIES) REFERENCES OCCUPATIONAL_SERIES (POSITION_SERIES) ;


--------------------------------------------------------
--  DDL for Table ATTACHMENT
--------------------------------------------------------

CREATE TABLE ATTACHMENT 
(
	DOCUMENT_ID VARCHAR2(15),
	DOCUMENT_NAME VARCHAR2 (256),
	CANDIDATE_ID NUMBER(15),
	DOCUMENT_TYPE_CODE VARCHAR2(100),
	DOCUMENT_DESC VARCHAR2 (50),
	CREATED_BY VARCHAR2(10),
	CREATION_DATE	DATE,
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE
) ;

 --------------------------------------------------------
--  DDL for Index ATTACHMENT_PK
--  DDL for Index ATTACHMENT_INDEX
--------------------------------------------------------

CREATE UNIQUE INDEX ATTACHMENT_PK ON ATTACHMENT (DOCUMENT_ID);
CREATE UNIQUE INDEX ATTACHMENT_INDEX ON ATTACHMENT (CANDIDATE_ID);

--------------------------------------------------------
--  Constraints for Table ATTACHMENT
--------------------------------------------------------

ALTER TABLE ATTACHMENT ADD CONSTRAINT ATTACHMENT_PK  PRIMARY KEY (DOCUMENT_ID);
ALTER TABLE ATTACHMENT ADD UNIQUE (CANDIDATE_ID);
ALTER TABLE ATTACHMENT MODIFY (CANDIDATE_ID NOT NULL );

 --------------------------------------------------------
--  Ref Constraints for Table ATTACHMENT
--------------------------------------------------------

ALTER TABLE ATTACHMENT ADD FOREIGN KEY (CANDIDATE_ID)  REFERENCES CANDIDATE (CANDIDATE_ID);


--------------------------------------------------------
--  DDL for Table USER_PERMISSION
--------------------------------------------------------

CREATE TABLE USER_PERMISSION 
(
	PERMISSION_ID NUMBER(10),
	GROUP_NAME VARCHAR2(100),
	LIST_TYPE  VARCHAR2(30), 
	USER_ID VARCHAR2(10),
	CREATED_BY VARCHAR2(10),
	CREATION_DATE	DATE,
	LAST_UPDATED_BY VARCHAR2(10),
	LAST_UPDATE_DATE DATE
) ;

--------------------------------------------------------
--  DDL for SEQLUENCE USER_PERMISSION_SEQ
--------------------------------------------------------

CREATE SEQUENCE USER_PERMISSION_SEQ
	INCREMENT BY 1
	START WITH 1
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for TRIGER USER_PERMISSION_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER USER_PERMISSION_TRG
BEFORE INSERT ON USER_PERMISSION
FOR EACH ROW
BEGIN
	SELECT USER_PERMISSION_SEQ.NEXTVAL
	INTO :NEW.PERMISSION_ID
	FROM DUAL;
END;

/


--------------------------------------------------------
--  DDL for Table HHS_LIST_MANAGER_LOOKUP
--------------------------------------------------------

CREATE TABLE HHS_LIST_MANAGER_LOOKUP 
(	
	ID NUMBER(10), 
	LOOKUP_NAME VARCHAR2(70), 
	LOOKUP_DESCRIPTION VARCHAR2(100), 
	LOOKUP_CODE VARCHAR2(70), 
	CONDITION_1 VARCHAR2(1028), 
	CONDITION_2 VARCHAR2(1028), 
	DISP_ORDER NUMBER(10)
) ;


--------------------------------------------------------
--  DDL for Index HHS_LIST_MANAGER_LOOKUP_INDEX1
--------------------------------------------------------

CREATE INDEX HHS_LIST_MANAGER_LOOKUP_INDEX1 ON HHS_LIST_MANAGER_LOOKUP (ID);


--------------------------------------------------------
--  DDL for SEQLUENCE HHS_LIST_MANAGER_LOOKUP_SEQ
--------------------------------------------------------

CREATE SEQUENCE HHS_LIST_MANAGER_LOOKUP_SEQ
	INCREMENT BY 1
	START WITH 1
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for TRIGER HHS_LIST_MANAGER_LOOKUP_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER HHS_LIST_MANAGER_LOOKUP_TRG
BEFORE INSERT ON HHS_LIST_MANAGER_LOOKUP
FOR EACH ROW
BEGIN
	SELECT HHS_LIST_MANAGER_LOOKUP_SEQ.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;

/

