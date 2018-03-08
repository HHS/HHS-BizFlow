
--------------------------------------------------------
--BACKOUT SCRIPT
--------------------------------------------------------  
/*   
	DROP TABLE MEMBERSTG;
	DROP TABLE MEMBERHISTORY;
	DROP SEQUENCE MEMBERHISTORY_SEQ;
	DROP TRIGGER MEMBERHISTORY_TRG;
	DROP TABLE EMPLOYEE_LOOKUP;
*/		 



SET DEFINE OFF;



--------------------------------------------------------
-- DDL for Table MEMBERSTG
--------------------------------------------------------
CREATE TABLE MEMBERSTG
(
	HHSID                       VARCHAR2(10)
	, NAME                      VARCHAR2(100)
	, EMAIL                     VARCHAR2(300)
	, DEPTNAME                  VARCHAR2(6)
	, ACTIVEIND                 VARCHAR2(1)
);
	  
COMMENT ON TABLE MEMBERSTG IS 'Member Staging table';
COMMENT ON COLUMN MEMBERSTG.HHSID IS 'HHSID of the employee';
COMMENT ON COLUMN MEMBERSTG.NAME IS 'The name of the employee';
COMMENT ON COLUMN MEMBERSTG.EMAIL IS 'The email address of the employee';
COMMENT ON COLUMN MEMBERSTG.DEPTNAME IS 'The department name of the employee';
COMMENT ON COLUMN MEMBERSTG.ACTIVEIND IS 'Indicates if the employee is active. ''Y'' is active, ''N'' is inactive';
	
	


--------------------------------------------------------
--DDL for Table MEMBERHISTORY
--------------------------------------------------------
CREATE TABLE MEMBERHISTORY
(
	HISTORYID                   NUMBER(38)
	, CHANGEDATE                DATE
	, MEMBERID                  VARCHAR2(10)
	, HHSID                     VARCHAR2(10)	
	, DMLTYPE                   VARCHAR2(10)
	, FIELDCHANGED              VARCHAR2(30)
	, OLDVALUE                  VARCHAR2(100)
	, NEWVALUE                  VARCHAR2(100)
);
	 
COMMENT ON TABLE MEMBERHISTORY IS 'Provides historical information on the transactions of the Bizflow MEMBER table';
COMMENT ON COLUMN MEMBERHISTORY.HISTORYID IS 'The unique memberhistory ID';
COMMENT ON COLUMN MEMBERHISTORY.CHANGEDATE IS 'The date that the transaction took place on the Bizflow MEMBER table';
COMMENT ON COLUMN MEMBERHISTORY.MEMBERID IS 'Corresponds to the memberid on the BizFlow MEMBER and MEMBERINFO tables';	
COMMENT ON COLUMN MEMBERHISTORY.HHSID IS 'The HHS ID of the employee';		
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
--DDL for Table EMPLOYEE_LOOKUP
--------------------------------------------------------
CREATE TABLE EMPLOYEE_LOOKUP
(
	EMPLID                      VARCHAR2(50)
	, FIRST_NAME                VARCHAR2(150)
	, MI                        VARCHAR2(64)
	, LAST_NAME                 VARCHAR2(150)
	, EMAIL_ADDR                VARCHAR2(256)
	, POSITION_TITLE            VARCHAR2(255)
	, POSITION_NUMBER           VARCHAR2(255)
	, JOB_CODE                  VARCHAR2(50)
	, PAY_PLAN                  VARCHAR2(50)
	, SERIES                    VARCHAR2(50)
	, GRADE                     VARCHAR2(2)
	, STEP                      VARCHAR2(20)
	, PAY_BASIS                 VARCHAR2(50)
	, BASIC_PAY                 VARCHAR2(50)
	, ADJUSTED_BASIC_PAY        VARCHAR2(50)
	, CAN                       VARCHAR2(50)
);

COMMENT ON TABLE EMPLOYEE_LOOKUP IS 'Provides historical information on the transactions of the Bizflow MEMBER table';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.EMPLID IS 'Employee ID';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.FIRST_NAME IS 'First Name';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.MI IS 'Middle Name Initial';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.LAST_NAME IS 'Last Name';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.EMAIL_ADDR IS 'Email Address';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.POSITION_TITLE IS 'Position Title';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.POSITION_NUMBER IS 'Position Number';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.JOB_CODE IS 'Job Code';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.PAY_PLAN IS 'Pay Plan';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.SERIES IS 'Series';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.GRADE IS 'Grade';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.STEP IS 'Step';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.PAY_BASIS IS 'Pay Basis';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.BASIC_PAY IS 'Basic Pay';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.ADJUSTED_BASIC_PAY IS 'Adjusted Basic Pay';
COMMENT ON COLUMN EMPLOYEE_LOOKUP.CAN IS 'CAN - Common Accounting Number';


--------------------------------------------------------
-- Constraints for Table EMPLOYEE_LOOKUP
-------------------------------------------------------- 
ALTER TABLE EMPLOYEE_LOOKUP ADD CONSTRAINT EMPLOYEE_LOOKUP_PK PRIMARY KEY (EMPLID) ENABLE;
ALTER TABLE EMPLOYEE_LOOKUP MODIFY (FIRST_NAME NOT NULL ENABLE);
ALTER TABLE EMPLOYEE_LOOKUP MODIFY (LAST_NAME NOT NULL ENABLE);
