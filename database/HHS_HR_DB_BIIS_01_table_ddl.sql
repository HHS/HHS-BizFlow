--------------------------------------------
-- Backout statement
--------------------------------------------
/*
DROP TABLE MEMBERSTG;
DROP TABLE MEMBERHISTORY;
DROP SEQUENCE MEMBERHISTORY_SEQ;
DROP TABLE EMPLOYEE_LOOKUP;
*/

SET DEFINE OFF;

--------------------------------------------------------
-- DDL for Table MEMBERSTG
--------------------------------------------------------
    CREATE TABLE MEMBERSTG
    (HHSID          VARCHAR2(64),
    FIRSTNAME       VARCHAR2(150),
    MIDDLENAME      VARCHAR2(80),
    LASTNAME        VARCHAR2(150),
    EMAIL           VARCHAR2(256),
    DEPTNAME        VARCHAR2(8),
    LASTUPDATE      DATE
    );

    COMMENT ON TABLE MEMBERSTG IS 'Member Staging table';
    COMMENT ON COLUMN MEMBERSTG.HHSID IS 'HHSID of the employee';
    COMMENT ON COLUMN MEMBERSTG.FIRSTNAME IS 'The first name of the employee';
    COMMENT ON COLUMN MEMBERSTG.MIDDLENAME IS 'The middle name of the employee';
    COMMENT ON COLUMN MEMBERSTG.LASTNAME IS 'The last name of the employee';
    COMMENT ON COLUMN MEMBERSTG.EMAIL IS 'The email address of the employee';
    COMMENT ON COLUMN MEMBERSTG.DEPTNAME IS 'The department name (OpDiv) of the employee';
    COMMENT ON COLUMN MEMBERSTG.LASTUPDATE IS 'The last update time from the Person System';
    
--------------------------------------------------------  
--DDL for Table MEMBERHISTORY
--------------------------------------------------------  
    CREATE TABLE MEMBERHISTORY
    (HISTORYID      NUMBER(38),
    CHANGEDATE      DATE,
    MEMBERID        VARCHAR2(10),
    HHSID           VARCHAR2(10),
    OPDIV           VARCHAR2(8),
    DMLTYPE         VARCHAR2(10),
    FIELDCHANGED    VARCHAR2(30),
    OLDVALUE        VARCHAR2(100),
    NEWVALUE        VARCHAR2(100)
    );
 
   COMMENT ON TABLE MEMBERHISTORY IS 'Provides historical information on the transactions of the Bizflow MEMBER table';
   COMMENT ON COLUMN MEMBERHISTORY.HISTORYID IS 'The unique memberhistory ID';
   COMMENT ON COLUMN MEMBERHISTORY.CHANGEDATE IS 'The date that the transaction took place on the Bizflow MEMBER table';
   COMMENT ON COLUMN MEMBERHISTORY.MEMBERID IS 'Corresponds to the memberid on the BizFlow MEMBER and MEMBERINFO tables';
   COMMENT ON COLUMN MEMBERHISTORY.HHSID IS 'The HHS ID of the employee';
   COMMENT ON COLUMN MEMBERHISTORY.OPDIV IS 'The Operating Division of the employee';
   COMMENT ON COLUMN MEMBERHISTORY.DMLTYPE IS 'The type of DML: ''INSERT'' or ''UPDATE''';
   COMMENT ON COLUMN MEMBERHISTORY.FIELDCHANGED IS 'The field that was updated on the Bizflow MEMBER table';
   COMMENT ON COLUMN MEMBERHISTORY.OLDVALUE IS 'The old value on the Bizflow MEMBER table';
   COMMENT ON COLUMN MEMBERHISTORY.NEWVALUE IS 'The new value on the Bizflow MEMBER table';
   
--------------------------------------------------------
--  DDL for Index MEMBERHISTORY_PK
--------------------------------------------------------
    CREATE UNIQUE INDEX MEMBERHISTORY_PK ON MEMBERHISTORY (HISTORYID);

--------------------------------------------------------
--  DDL for Index MEMBERHISTORY_I1
--------------------------------------------------------
    CREATE INDEX MEMBERHISTORY_I1 ON MEMBERHISTORY(HHSID);

--------------------------------------------------------  
-- DDL for Sequence MEMBERHISTORY_SEQ
--------------------------------------------------------  
    CREATE SEQUENCE MEMBERHISTORY_SEQ nocache;


--------------------------------------------------------  
--  DDL for Trigger MEMBERHISTORY_TRG
--------------------------------------------------------  
    CREATE OR REPLACE TRIGGER MEMBERHISTORY_TRG
    BEFORE INSERT ON MEMBERHISTORY
    FOR EACH ROW
    BEGIN
        <<COLUMN_SEQUENCES>>
        BEGIN
            IF INSERTING AND :NEW.HISTORYID IS NULL THEN
                SELECT MEMBERHISTORY_SEQ.NEXTVAL INTO :NEW.HISTORYID FROM SYS.DUAL;
            END IF;
        END COLUMN_SEQUENCES;
    END;
    /
    ALTER TRIGGER MEMBERHISTORY_TRG ENABLE;
    
--------------------------------------------------------
-- Constraints for Table MEMBERHISTORY
-------------------------------------------------------- 
    ALTER TABLE MEMBERHISTORY ADD CONSTRAINT MEMBERHISTORY_PK PRIMARY KEY (HISTORYID) ENABLE;
    ALTER TABLE MEMBERHISTORY MODIFY (HISTORYID NOT NULL ENABLE);
    ALTER TABLE MEMBERHISTORY MODIFY (CHANGEDATE NOT NULL ENABLE);
    ALTER TABLE MEMBERHISTORY MODIFY (MEMBERID NOT NULL ENABLE);
    
    
--------------------------------------------------------
-- DDL for Table EMPLOYEE_LOOKUP
--------------------------------------------------------
    CREATE TABLE EMPLOYEE_LOOKUP
    (LAST_NAME                      VARCHAR2(150),
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

