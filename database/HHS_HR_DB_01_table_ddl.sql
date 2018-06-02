
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

