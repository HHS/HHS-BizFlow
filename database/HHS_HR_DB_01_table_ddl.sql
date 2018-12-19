
/*
--------------------------------------------------------
--  Backout statement
--------------------------------------------------------

DROP TABLE ERROR_LOG;

DROP SEQUENCE ERROR_LOG_SEQ;


DROP TABLE HHS_HR.BATCH_JOB_EXECUTION ;
DROP TABLE HHS_HR.BATCH_JOB_EXECUTION_CONTEXT ;
DROP TABLE HHS_HR.BATCH_JOB_EXECUTION_PARAMS ;
DROP TABLE HHS_HR.BATCH_JOB_INSTANCE ;
DROP TABLE HHS_HR.BATCH_STEP_EXECUTION ; 
DROP TABLE HHS_HR.BATCH_STEP_EXECUTION_CONTEXT ; 


DROP SEQUENCE  HHS_HR.BATCH_JOB_EXECUTION_SEQ ;
DROP SEQUENCE  HHS_HR.BATCH_JOB_SEQ ;
DROP SEQUENCE  HHS_HR.BATCH_STEP_EXECUTION_SEQ ;

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
DROP TABLE LISTMANAGER_FORM_DTL CASCADE CONSTRAINTS ;
DROP SEQUENCE CANDIDATE_SEQ;
DROP SEQUENCE LIST_SEQ;
DROP SEQUENCE LIST_MEM_JOB_OPEN_SEARCH_SEQ;
DROP SEQUENCE USER_PERMISSION_SEQ;
DROP SEQUENCE HHS_LIST_MANAGER_LOOKUP_SEQ;
DROP SEQUENCE ATTACHMENT_SEQ;
DROP SEQUENCE LIST_SEARCH_CANDIDATE_SEQ;
DROP SEQUENC LISTMANAGER_FORM_DTL_SEQ;


*/



SET DEFINE OFF;



--=============================================================================
-- Create TABLE and associated objects
--=============================================================================


--------------------------------------------------------
--  DDL for Table ERROR_LOG
--------------------------------------------------------

CREATE TABLE ERROR_LOG
(
	ID                  INTEGER
	, ERROR_CD          INTEGER
	, ERROR_MSG         VARCHAR2(4000)
	, BACKTRACE         CLOB
	, CALLSTACK         CLOB
	, CRT_DT            DATE
	, CRT_USR           VARCHAR2(50)
);

ALTER TABLE ERROR_LOG ADD CONSTRAINT ERROR_LOG_PK PRIMARY KEY (ID);
/



COMMENT ON COLUMN ERROR_LOG.ID IS 'Unique primary key';
COMMENT ON COLUMN ERROR_LOG.ERROR_CD IS 'Error code';
COMMENT ON COLUMN ERROR_LOG.ERROR_MSG IS 'Error message';
COMMENT ON COLUMN ERROR_LOG.BACKTRACE IS 'Error trace';
COMMENT ON COLUMN ERROR_LOG.CALLSTACK IS 'PL/SQL call stack that leads to the error';
COMMENT ON COLUMN ERROR_LOG.CRT_DT IS 'Creation Date';
COMMENT ON COLUMN ERROR_LOG.CRT_USR IS 'Creation User';



CREATE SEQUENCE ERROR_LOG_SEQ
	INCREMENT BY 1
	START WITH 1
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/


CREATE OR REPLACE TRIGGER ERROR_LOG_BIR
BEFORE INSERT ON ERROR_LOG
FOR EACH ROW
BEGIN
	SELECT ERROR_LOG_SEQ.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;

/








--=============================================================================
-- Create TABLE for Spring Batch Framework
--=============================================================================

--------------------------------------------------------
--  DDL for Table BATCH_JOB_EXECUTION
--------------------------------------------------------

CREATE TABLE HHS_HR.BATCH_JOB_EXECUTION 
(
	JOB_EXECUTION_ID                NUMBER(19,0), 
	VERSION                         NUMBER(19,0), 
	JOB_INSTANCE_ID                 NUMBER(19,0), 
	CREATE_TIME                     TIMESTAMP (6), 
	START_TIME                      TIMESTAMP (6) DEFAULT NULL, 
	END_TIME                        TIMESTAMP (6) DEFAULT NULL, 
	STATUS                          VARCHAR2(10 BYTE), 
	EXIT_CODE                       VARCHAR2(2500 BYTE), 
	EXIT_MESSAGE                    VARCHAR2(2500 BYTE), 
	LAST_UPDATED                    TIMESTAMP (6), 
	JOB_CONFIGURATION_LOCATION      VARCHAR2(2500 BYTE)
);

--------------------------------------------------------
--  DDL for Index SYS_C0033703
--------------------------------------------------------

CREATE UNIQUE INDEX HHS_HR.BATCH_JOB_EXECUTION_PK ON HHS_HR.BATCH_JOB_EXECUTION (JOB_EXECUTION_ID);

--------------------------------------------------------
--  Constraints for Table BATCH_JOB_EXECUTION
--------------------------------------------------------

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION MODIFY (JOB_EXECUTION_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION MODIFY (JOB_INSTANCE_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION MODIFY (CREATE_TIME NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION ADD PRIMARY KEY (JOB_EXECUTION_ID);




--------------------------------------------------------
--  DDL for Sequence BATCH_JOB_EXECUTION_SEQ
--------------------------------------------------------

CREATE SEQUENCE  HHS_HR.BATCH_JOB_EXECUTION_SEQ  
	MINVALUE 0 MAXVALUE 9223372036854775807 
	INCREMENT BY 1 
	START WITH 480 
	CACHE 20 NOORDER NOCYCLE ;










--------------------------------------------------------
--  DDL for Table BATCH_JOB_EXECUTION_CONTEXT
--------------------------------------------------------

CREATE TABLE HHS_HR.BATCH_JOB_EXECUTION_CONTEXT 
(
	JOB_EXECUTION_ID                NUMBER(19,0), 
	SHORT_CONTEXT                   VARCHAR2(2500 BYTE), 
	SERIALIZED_CONTEXT              CLOB
);

--------------------------------------------------------
--  DDL for Index SYS_C0033723
--------------------------------------------------------

CREATE UNIQUE INDEX HHS_HR.BATCH_JOB_EXECUTION_CONTEXT_PK ON HHS_HR.BATCH_JOB_EXECUTION_CONTEXT (JOB_EXECUTION_ID);

--------------------------------------------------------
--  Constraints for Table BATCH_JOB_EXECUTION_CONTEXT
--------------------------------------------------------

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION_CONTEXT MODIFY (JOB_EXECUTION_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION_CONTEXT MODIFY (SHORT_CONTEXT NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION_CONTEXT ADD PRIMARY KEY (JOB_EXECUTION_ID);




--------------------------------------------------------
--  DDL for Table BATCH_JOB_EXECUTION_PARAMS
--------------------------------------------------------

CREATE TABLE HHS_HR.BATCH_JOB_EXECUTION_PARAMS 
(
	JOB_EXECUTION_ID                NUMBER(19,0), 
	TYPE_CD                         VARCHAR2(6 BYTE), 
	KEY_NAME                        VARCHAR2(100 BYTE), 
	STRING_VAL                      VARCHAR2(250 BYTE), 
	DATE_VAL                        TIMESTAMP (6) DEFAULT NULL, 
	LONG_VAL                        NUMBER(19,0), 
	DOUBLE_VAL                      NUMBER, 
	IDENTIFYING                     CHAR(1 BYTE)
);

--------------------------------------------------------
--  Constraints for Table BATCH_JOB_EXECUTION_PARAMS
--------------------------------------------------------

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION_PARAMS MODIFY (JOB_EXECUTION_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION_PARAMS MODIFY (TYPE_CD NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION_PARAMS MODIFY (KEY_NAME NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_EXECUTION_PARAMS MODIFY (IDENTIFYING NOT NULL ENABLE);




--------------------------------------------------------
--  DDL for Table BATCH_JOB_INSTANCE
--------------------------------------------------------

CREATE TABLE HHS_HR.BATCH_JOB_INSTANCE 
(
	JOB_INSTANCE_ID                 NUMBER(19,0), 
	VERSION                         NUMBER(19,0), 
	JOB_NAME                        VARCHAR2(100 BYTE), 
	JOB_KEY                         VARCHAR2(32 BYTE)
);

--------------------------------------------------------
--  DDL for Index SYS_C0033698
--------------------------------------------------------

CREATE UNIQUE INDEX HHS_HR.BATCH_JOB_INSTANCE_PK ON HHS_HR.BATCH_JOB_INSTANCE (JOB_INSTANCE_ID);

--------------------------------------------------------
--  DDL for Index JOB_INST_UN
--------------------------------------------------------

CREATE UNIQUE INDEX HHS_HR.JOB_INST_UN ON HHS_HR.BATCH_JOB_INSTANCE (JOB_NAME, JOB_KEY);

--------------------------------------------------------
--  Constraints for Table BATCH_JOB_INSTANCE
--------------------------------------------------------

ALTER TABLE HHS_HR.BATCH_JOB_INSTANCE ADD CONSTRAINT JOB_INST_UN UNIQUE (JOB_NAME, JOB_KEY);

ALTER TABLE HHS_HR.BATCH_JOB_INSTANCE MODIFY (JOB_INSTANCE_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_INSTANCE MODIFY (JOB_NAME NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_INSTANCE MODIFY (JOB_KEY NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_JOB_INSTANCE ADD PRIMARY KEY (JOB_INSTANCE_ID);


--------------------------------------------------------
--  DDL for Sequence BATCH_JOB_SEQ
--------------------------------------------------------

CREATE SEQUENCE  HHS_HR.BATCH_JOB_SEQ  
	MINVALUE 0 MAXVALUE 9223372036854775807 
	INCREMENT BY 1 
	START WITH 500 
	CACHE 20 NOORDER  NOCYCLE ;




--------------------------------------------------------
--  DDL for Table BATCH_STEP_EXECUTION
--------------------------------------------------------

CREATE TABLE HHS_HR.BATCH_STEP_EXECUTION 
(
	STEP_EXECUTION_ID               NUMBER(19,0), 
	VERSION                         NUMBER(19,0), 
	STEP_NAME                       VARCHAR2(100 BYTE), 
	JOB_EXECUTION_ID                NUMBER(19,0), 
	START_TIME                      TIMESTAMP (6), 
	END_TIME                        TIMESTAMP (6) DEFAULT NULL, 
	STATUS                          VARCHAR2(10 BYTE), 
	COMMIT_COUNT                    NUMBER(19,0), 
	READ_COUNT                      NUMBER(19,0), 
	FILTER_COUNT                    NUMBER(19,0), 
	WRITE_COUNT                     NUMBER(19,0), 
	READ_SKIP_COUNT                 NUMBER(19,0), 
	WRITE_SKIP_COUNT                NUMBER(19,0), 
	PROCESS_SKIP_COUNT              NUMBER(19,0), 
	ROLLBACK_COUNT                  NUMBER(19,0), 
	EXIT_CODE                       VARCHAR2(2500 BYTE), 
	EXIT_MESSAGE                    VARCHAR2(2500 BYTE), 
	LAST_UPDATED                    TIMESTAMP (6)
);

--------------------------------------------------------
--  DDL for Index SYS_C0033715
--------------------------------------------------------

CREATE UNIQUE INDEX HHS_HR.BATCH_STEP_EXECUTION_PK ON HHS_HR.BATCH_STEP_EXECUTION (STEP_EXECUTION_ID);

--------------------------------------------------------
--  Constraints for Table BATCH_STEP_EXECUTION
--------------------------------------------------------

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION MODIFY (STEP_EXECUTION_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION MODIFY (VERSION NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION MODIFY (STEP_NAME NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION MODIFY (JOB_EXECUTION_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION MODIFY (START_TIME NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION ADD PRIMARY KEY (STEP_EXECUTION_ID);




--------------------------------------------------------
--  DDL for Sequence BATCH_STEP_EXECUTION_SEQ
--------------------------------------------------------

CREATE SEQUENCE  HHS_HR.BATCH_STEP_EXECUTION_SEQ  
	MINVALUE 0 MAXVALUE 9223372036854775807 
	INCREMENT BY 1 
	START WITH 440 
	CACHE 20 NOORDER  NOCYCLE ;




--------------------------------------------------------
--  DDL for Table BATCH_STEP_EXECUTION_CONTEXT
--------------------------------------------------------

CREATE TABLE HHS_HR.BATCH_STEP_EXECUTION_CONTEXT 
(
	STEP_EXECUTION_ID               NUMBER(19,0), 
	SHORT_CONTEXT                   VARCHAR2(2500 BYTE), 
	SERIALIZED_CONTEXT              CLOB
);

--------------------------------------------------------
--  DDL for Index SYS_C0033719
--------------------------------------------------------

CREATE UNIQUE INDEX HHS_HR.BATCH_STEP_EXEC_CONTEXT_PK ON HHS_HR.BATCH_STEP_EXECUTION_CONTEXT (STEP_EXECUTION_ID);

--------------------------------------------------------
--  Constraints for Table BATCH_STEP_EXECUTION_CONTEXT
--------------------------------------------------------

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION_CONTEXT MODIFY (STEP_EXECUTION_ID NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION_CONTEXT MODIFY (SHORT_CONTEXT NOT NULL ENABLE);

ALTER TABLE HHS_HR.BATCH_STEP_EXECUTION_CONTEXT ADD PRIMARY KEY (STEP_EXECUTION_ID);


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
	ADDRESS_LATITUDE	NUMBER(8,6), 
	ADDRESS_LONGITUDE NUMBER(9,6), 
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

ALTER TABLE CANDIDATE ADD PROCID NUMBER(10);
ALTER TABLE CANDIDATE ADD EMPLID VARCHAR2(50);
ALTER TABLE CANDIDATE MODIFY HHSID VARCHAR2(64);
ALTER TABLE CANDIDATE MODIFY LAST_NAME VARCHAR2(150);
ALTER TABLE CANDIDATE MODIFY MIDDLE_INITIAL VARCHAR2(80);
ALTER TABLE CANDIDATE MODIFY FIRST_NAME VARCHAR2(150);
ALTER TABLE CANDIDATE ADD PAY_PLAN VARCHAR2(20);
ALTER TABLE CANDIDATE ADD ADMIN_CODE VARCHAR2(50);
ALTER TABLE CANDIDATE ADD OPDIV VARCHAR2(100);
ALTER TABLE CANDIDATE ADD STAFF_DIV VARCHAR2(100);
ALTER TABLE CANDIDATE ADD ORG_TITILE VARCHAR2(100);
ALTER TABLE CANDIDATE ADD PHONE_NUMBER VARCHAR2(30);
ALTER TABLE CANDIDATE ADD POSITION_OCCUPIED VARCHAR2(100);
ALTER TABLE CANDIDATE ADD TENURE_CODE VARCHAR2(100);
ALTER TABLE CANDIDATE ADD EMPL_DUTY_STATION VARCHAR2(100);
ALTER TABLE CANDIDATE ADD LOCATION VARCHAR2(100);


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

ALTER TABLE LIST ADD PRIORITY VARCHAR2(10);

ALTER TABLE HHS_HR.LIST MODIFY LIST_DESCRIPTION VARCHAR2(200);


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

ALTER TABLE CANDIDATE_LIST ADD HR_NORTIFIED_ELIG_DT  DATE;
ALTER TABLE CANDIDATE_LIST ADD EMPL_NORTIFIED_ELIG_DT  DATE;
ALTER TABLE CANDIDATE_LIST ADD BASIS_FOR_ELIGIBILITY_CODE  VARCHAR2(100);
ALTER TABLE CANDIDATE_LIST ADD ELIGIBILITY_OCC_SERIES  VARCHAR2(10);
ALTER TABLE CANDIDATE_LIST ADD ELIGIBILITY_GRADE VARCHAR2(2);
ALTER TABLE CANDIDATE_LIST ADD ELIGIBILITY_END_REASON VARCHAR2(150);


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

CREATE INDEX SEARCH_OCC_SERIES_INDEX ON SEARCH_OCC_SERIES (SEARCH_ID);

--------------------------------------------------------
--  Constraints for Table SEARCH_OCC_SERIES
--------------------------------------------------------

--ALTER TABLE SEARCH_OCC_SERIES ADD UNIQUE (SEARCH_ID, OCC_SERIES);
ALTER TABLE SEARCH_OCC_SERIES MODIFY (SEARCH_ID NOT NULL );
ALTER TABLE SEARCH_OCC_SERIES MODIFY (OCC_SERIES NOT NULL );

ALTER TABLE SEARCH_OCC_SERIES MODIFY OCC_SERIES VARCHAR2(10);


--------------------------------------------------------
--  Ref Constraints for Table SEARCH_OCC_SERIES
--------------------------------------------------------

--ALTER TABLE SEARCH_OCC_SERIES ADD FOREIGN KEY (SEARCH_ID) REFERENCES LIST_MEM_JOB_OPEN_SEARCH (SEARCH_ID) ;
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

CREATE INDEX SEARCH_GRADE_INDEX ON SEARCH_GRADE (SEARCH_ID) ;

--------------------------------------------------------
--  Constraints for Table SEARCH_GRADE
--------------------------------------------------------

--ALTER TABLE SEARCH_GRADE ADD UNIQUE (SEARCH_ID);

ALTER TABLE SEARCH_GRADE MODIFY (SEARCH_ID NOT NULL );

--------------------------------------------------------
--  Ref Constraints for Table SEARCH_GRADE
--------------------------------------------------------

--ALTER TABLE SEARCH_GRADE ADD FOREIGN KEY (SEARCH_ID) REFERENCES LIST_MEM_JOB_OPEN_SEARCH (SEARCH_ID) ;


--------------------------------------------------------
--  DDL for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

CREATE TABLE LIST_SEARCH_CANDIDATE 
(
	ID	NUMBER (10),
	SEARCH_ID  NUMBER (10),
	CANDIDATE_ID NUMBER (15),
	LIST_ID NUMBER(15),
	CLEARING_ACTION_CODE VARCHAR2(20),
	COMMENTS VARCHAR2(1000),
	JOB_OPENING_ID VARCHAR2(30),
	PAY_PLAN VARCHAR2(20),
	OCC_SERIES   VARCHAR2 (8),
	GRADE_CODE  VARCHAR2 (2),
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

CREATE UNIQUE INDEX LIST_SEARCH_CANDIDATE_INDEX ON LIST_SEARCH_CANDIDATE(ID);

--------------------------------------------------------
--  Constraints for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

--ALTER TABLE LIST_SEARCH_CANDIDATE ADD UNIQUE (CANDIDATE_ID);
ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (SEARCH_ID NOT NULL );
ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (ID NOT NULL );
--ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (CANDIDATE_ID NOT NULL );
--ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (LIST_ID NOT NULL );

ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY CLEARING_ACTION_CODE VARCHAR2(100);

ALTER TABLE LIST_SEARCH_CANDIDATE ADD PRIORITY VARCHAR2(10);



--------------------------------------------------------
--  Ref Constraints for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

--ALTER TABLE LIST_SEARCH_CANDIDATE ADD FOREIGN KEY (CANDIDATE_ID) REFERENCES CANDIDATE (CANDIDATE_ID) ;

--------------------------------------------------------
--  DDL for SEQLUENCE LIST_SEARCH_CANDIDATE_SEQ
--------------------------------------------------------

CREATE SEQUENCE LIST_SEARCH_CANDIDATE_SEQ
	INCREMENT BY 1
	START WITH 1000000000
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for TRIGER LIST_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER LIST_SEARCH_CANDIDATE_TRG
BEFORE INSERT ON LIST_SEARCH_CANDIDATE
FOR EACH ROW
BEGIN
	SELECT LIST_SEARCH_CANDIDATE_SEQ.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;

/

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

ALTER TABLE CANDIDATE_OCC_SERIES MODIFY OCC_SERIES VARCHAR2(10);

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
	DOCUMENT_ID NUMBER(15),
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
--CREATE UNIQUE INDEX ATTACHMENT_INDEX ON ATTACHMENT (CANDIDATE_ID);

--------------------------------------------------------
--  Constraints for Table ATTACHMENT
--------------------------------------------------------

ALTER TABLE ATTACHMENT ADD CONSTRAINT ATTACHMENT_PK  PRIMARY KEY (DOCUMENT_ID);
--ALTER TABLE ATTACHMENT ADD UNIQUE (CANDIDATE_ID);
ALTER TABLE ATTACHMENT MODIFY (CANDIDATE_ID NOT NULL );

ALTER TABLE ATTACHMENT ADD PROCID NUMBER(10);
ALTER TABLE ATTACHMENT ADD ATTACHSEQ NUMBER(10);


 --------------------------------------------------------
--  Ref Constraints for Table ATTACHMENT
--------------------------------------------------------

ALTER TABLE ATTACHMENT ADD FOREIGN KEY (CANDIDATE_ID)  REFERENCES CANDIDATE (CANDIDATE_ID);

--------------------------------------------------------
--  DDL for SEQLUENCE LIST_SEQ
--------------------------------------------------------

CREATE SEQUENCE ATTACHMENT_SEQ
	INCREMENT BY 1
	START WITH 100000000000000
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for TRIGER ATTACHMENT_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER ATTACHMENT_TRG
BEFORE INSERT ON ATTACHMENT
FOR EACH ROW
BEGIN
	SELECT LIST_SEQ.NEXTVAL
	INTO :NEW.DOCUMENT_ID
	FROM DUAL;
END;

/

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

ALTER TABLE HHS_LIST_MANAGER_LOOKUP MODIFY LOOKUP_DESCRIPTION VARCHAR2(150);
ALTER TABLE HHS_LIST_MANAGER_LOOKUP MODIFY LOOKUP_CODE VARCHAR2(150);

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

CREATE TABLE LISTMANAGER_FORM_DTL
(
	ID                      NUMBER(20) NOT NULL
	, PROCID                NUMBER(10)
	, FIELD_DATA            XMLTYPE
	, CRT_DT                TIMESTAMP
	, CRT_USR               VARCHAR2(50)
);

ALTER TABLE LISTMANAGER_FORM_DTL ADD CONSTRAINT LISTMANAGER_FORM_DTL_PK PRIMARY KEY (ID);

--DROP INDEX LISTMANAGER_FORM_DTL_NK1

CREATE SEQUENCE LISTMANAGER_FORM_DTL_SEQ
	INCREMENT BY 1
	START WITH 1
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

CREATE OR REPLACE TRIGGER LISTMANAGER_FORM_DTL_BIR
BEFORE INSERT ON LISTMANAGER_FORM_DTL
FOR EACH ROW
BEGIN
	SELECT LISTMANAGER_FORM_DTL_SEQ.NEXTVAL
	INTO :NEW.ID
	FROM DUAL
	;
END
;

/