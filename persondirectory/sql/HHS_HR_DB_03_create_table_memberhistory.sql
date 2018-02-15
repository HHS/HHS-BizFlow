--------------------------------------------------------  
--DDL for Table MEMBERHISTORY
--------------------------------------------------------  
	CREATE TABLE MEMBERHISTORY
	(HISTORYID   	NUMBER(38),
	CHANGEDATE		DATE,
	MEMBERID			VARCHAR2(10),
	HHSID				VARCHAR2(10),			
	DMLTYPE			VARCHAR2(10),			
	FIELDCHANGED	VARCHAR2(30),
	OLDVALUE			VARCHAR2(100),
	NEWVALUE			VARCHAR2(100)
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
  
--===================================================================================================================================================== 

--------------------------------------------------------
--BACKOUT SCRIPT
--------------------------------------------------------
/*   
	DROP TABLE MEMBERHISTORY;
	DROP SEQUENCE MEMBERHISTORY_SEQ;
	DROP TRIGGER MEMBERHISTORY_TRG;
*/		 