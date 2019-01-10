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
DROP SEQUENCE ATTACHMENT_SEQ;
--DROP SEQUENCE LIST_SEARCH_CANDIDATE_SEQ;

SET DEFINE OFF;



--------------------------------------------------------
--  DDL for Table CANDIDATE
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."CANDIDATE" 
   (	"CANDIDATE_ID" NUMBER(15,0), 
	"FIRST_NAME" VARCHAR2(150 BYTE), 
	"MIDDLE_INITIAL" VARCHAR2(80 BYTE), 
	"LAST_NAME" VARCHAR2(150 BYTE), 
	"HHSID" VARCHAR2(64 BYTE), 
	"SEPARATION_DATE" DATE, 
	"CREATING_ORG_CODE" VARCHAR2(20 BYTE), 
	"PERFORMANCE_RATING_CODE" VARCHAR2(40 BYTE), 
	"PERFORMANCE_PD_START" DATE, 
	"PERFORMANCE_PD_END" DATE, 
	"ELIGIBILITY_START_DATE" DATE, 
	"ELIGIBILITY_END_DATE" DATE, 
	"VETERAN_STATUS_CODE" VARCHAR2(20 BYTE), 
	"EMPLOYEE_TYPE_CODE" VARCHAR2(100 BYTE), 
	"BASIS_FOR_ELIGIBILITY_CODE" VARCHAR2(100 BYTE), 
	"COMMENTS" VARCHAR2(4000 BYTE), 
	"HHS_EMPLMT_STATUS_CODE" VARCHAR2(20 BYTE), 
	"HHS_EMPLMT_STATUS_AS_OF" DATE, 
	"EMAIL_ADDRESS" VARCHAR2(100 BYTE), 
	"ADDRESS_LINE1" VARCHAR2(100 BYTE), 
	"ADDRESS_LINE2" VARCHAR2(100 BYTE), 
	"ADDRESS_CITY" VARCHAR2(100 BYTE), 
	"ADDRESS_STATE" VARCHAR2(2 BYTE), 
	"ADDRESS_ZIP" VARCHAR2(10 BYTE), 
	"ADDRESS_LATITUDE" VARCHAR2(10 BYTE), 
	"ADDRESS_LONGITUDE" VARCHAR2(10 BYTE), 
	"LIST_ELIGIBLE_FLAG" VARCHAR2(1 BYTE), 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE, 
	"PROCID" NUMBER(10,0), 
	"EMPLID" VARCHAR2(50 BYTE), 
	"PAY_PLAN" VARCHAR2(20 BYTE), 
	"ADMIN_CODE" VARCHAR2(50 BYTE), 
	"OPDIV" VARCHAR2(100 BYTE), 
	"STAFF_DIV" VARCHAR2(100 BYTE), 
	"ORG_TITILE" VARCHAR2(100 BYTE), 
	"PHONE_NUMBER" VARCHAR2(30 BYTE), 
	"POSITION_OCCUPIED" VARCHAR2(100 BYTE), 
	"TENURE_CODE" VARCHAR2(100 BYTE), 
	"EMPL_DUTY_STATION" VARCHAR2(100 BYTE), 
	"LOCATION" VARCHAR2(100 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Index CANDIDATE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."CANDIDATE_PK" ON "HHS_HR"."CANDIDATE" ("CANDIDATE_ID") ;
--------------------------------------------------------
--  Constraints for Table CANDIDATE
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."CANDIDATE" ADD CONSTRAINT "CANDIDATE_PK" PRIMARY KEY ("CANDIDATE_ID");

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
--  DDL for Trigger CANDIDATE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HHS_HR"."CANDIDATE_TRG" 
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

  CREATE TABLE "HHS_HR"."LIST" 
   (	"LIST_ID" NUMBER(15,0), 
	"LIST_TYPE" VARCHAR2(30 BYTE), 
	"LIST_NAME" VARCHAR2(100 BYTE), 
	"LIST_DESCRIPTION" VARCHAR2(200 BYTE), 
	"OWNING_ORG_CODE" VARCHAR2(100 BYTE), 
	"LIST_EFF_START_DATE" DATE, 
	"LIST_EFF_END_DATE" DATE, 
	"ELIGIBILITY_DURATION_IN_DAYS" NUMBER(4,0), 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE, 
	"PRIORITY" VARCHAR2(10 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Index LIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."LIST_PK" ON "HHS_HR"."LIST" ("LIST_ID")  ;
--------------------------------------------------------
--  Constraints for Table LIST
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."LIST" ADD CONSTRAINT "LIST_PK" PRIMARY KEY ("LIST_ID");



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
--  DDL for Trigger LIST_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HHS_HR"."LIST_TRG" 
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

  CREATE TABLE "HHS_HR"."CANDIDATE_LIST" 
   (	"CANDIDATE_ID" NUMBER(15,0), 
	"LIST_ID" NUMBER(15,0), 
	"LIST_ELIGIBILITY_START_DATE" DATE, 
	"LIST_ELIGIBILITY_END_DATE" DATE, 
	"CREATING_ORG_CODE" VARCHAR2(20 BYTE), 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE, 
	"HR_NORTIFIED_ELIG_DT" DATE, 
	"EMPL_NORTIFIED_ELIG_DT" DATE, 
	"BASIS_FOR_ELIGIBILITY_CODE" VARCHAR2(100 BYTE), 
	"ADDRESS_LATITUDE" NUMBER(8,6), 
	"ADDRESS_LONGITUDE" NUMBER(9,6), 
	"ELIGIBILITY_OCC_SERIES" VARCHAR2(10 BYTE), 
	"ELIGIBILITY_GRADE" VARCHAR2(2 BYTE), 
	"ELIGIBILITY_END_REASON" VARCHAR2(150 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Index CANDIDATE_LIST_INDEX
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."CANDIDATE_LIST_INDEX" ON "HHS_HR"."CANDIDATE_LIST" ("CANDIDATE_ID", "LIST_ID") ;
 
--------------------------------------------------------
--  Constraints for Table CANDIDATE_LIST
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."CANDIDATE_LIST" ADD UNIQUE ("CANDIDATE_ID", "LIST_ID");
 
  ALTER TABLE "HHS_HR"."CANDIDATE_LIST" MODIFY ("CANDIDATE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "HHS_HR"."CANDIDATE_LIST" MODIFY ("LIST_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CANDIDATE_LIST
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."CANDIDATE_LIST" ADD FOREIGN KEY ("CANDIDATE_ID")
	  REFERENCES "HHS_HR"."CANDIDATE" ("CANDIDATE_ID") ENABLE;
 
  ALTER TABLE "HHS_HR"."CANDIDATE_LIST" ADD FOREIGN KEY ("LIST_ID")
	  REFERENCES "HHS_HR"."LIST" ("LIST_ID") ENABLE;


--------------------------------------------------------
--  DDL for Table LIST_MEM_JOB_OPEN_SEARCH
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" 
   (	"SEARCH_ID" NUMBER(10,0), 
	"HRS_JOB_OPENING_ID" NUMBER(15,0), 
	"LIST_ID" NUMBER(15,0), 
	"PREF_LOC_TO_JOB_DISTANCE" NUMBER(20,0), 
	"VALID_FLAG" VARCHAR2(1 BYTE) DEFAULT 'T', 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE, 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE
   );
--------------------------------------------------------
--  DDL for Index LIST_MEM_JOB_OPEN_SEARCH_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH_PK" ON "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" ("SEARCH_ID") ;

--------------------------------------------------------
--  DDL for Index LIST_MEM_JOB_OPEN_SEARCH_INDEX
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH_INDEX" ON "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" ("HRS_JOB_OPENING_ID", "LIST_ID"); 
--------------------------------------------------------
--  Constraints for Table LIST_MEM_JOB_OPEN_SEARCH
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" ADD CONSTRAINT "LIST_MEM_JOB_OPEN_SEARCH_PK" PRIMARY KEY ("SEARCH_ID");
 
  ALTER TABLE "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" ADD UNIQUE ("HRS_JOB_OPENING_ID", "LIST_ID");

 
  ALTER TABLE "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" MODIFY ("HRS_JOB_OPENING_ID" NOT NULL ENABLE);
 
  ALTER TABLE "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" MODIFY ("LIST_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table LIST_MEM_JOB_OPEN_SEARCH
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH" ADD FOREIGN KEY ("LIST_ID")
	  REFERENCES "HHS_HR"."LIST" ("LIST_ID") ENABLE;

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
--  DDL for Trigger LIST_MEM_JOB_OPEN_SEARCH_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HHS_HR"."LIST_MEM_JOB_OPEN_SEARCH_TRG" 
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

  CREATE TABLE "HHS_HR"."SEARCH_OCC_SERIES" 
   (	"SEARCH_ID" NUMBER(10,0), 
	"OCC_SERIES" VARCHAR2(10 BYTE)
   );
--------------------------------------------------------
--  DDL for Index SEARCH_OCC_SERIES_INDEX
--------------------------------------------------------

  CREATE INDEX "HHS_HR"."SEARCH_OCC_SERIES_INDEX" ON "HHS_HR"."SEARCH_OCC_SERIES" ("SEARCH_ID");
  
--------------------------------------------------------
--  Constraints for Table SEARCH_OCC_SERIES
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."SEARCH_OCC_SERIES" MODIFY ("SEARCH_ID" NOT NULL ENABLE);
 
  ALTER TABLE "HHS_HR"."SEARCH_OCC_SERIES" MODIFY ("OCC_SERIES" NOT NULL ENABLE);


--------------------------------------------------------
--  DDL for Table SEARCH_GRADE
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."SEARCH_GRADE" 
   (	"SEARCH_ID" NUMBER(10,0), 
	"GRADE_CODE" VARCHAR2(2 BYTE)
   );
--------------------------------------------------------
--  DDL for Index SEARCH_GRADE_INDEX
--------------------------------------------------------

  CREATE INDEX "HHS_HR"."SEARCH_GRADE_INDEX" ON "HHS_HR"."SEARCH_GRADE" ("SEARCH_ID");
--------------------------------------------------------
--  Constraints for Table SEARCH_GRADE
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."SEARCH_GRADE" MODIFY ("SEARCH_ID" NOT NULL ENABLE);


--------------------------------------------------------
--  DDL for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."LIST_SEARCH_CANDIDATE" 
   (	"ID" NUMBER(10,0), 
	"SEARCH_ID" NUMBER(10,0), 
	"CANDIDATE_ID" NUMBER(15,0), 
	"LIST_ID" NUMBER(15,0), 
	"CLEARING_ACTION_CODE" VARCHAR2(100 BYTE), 
	"COMMENTS" VARCHAR2(1000 BYTE), 
	"JOB_OPENING_ID" VARCHAR2(30 BYTE), 
	"PAY_PLAN" VARCHAR2(20 BYTE), 
	"OCC_SERIES" VARCHAR2(8 BYTE), 
	"GRADE_CODE" VARCHAR2(2 BYTE), 
	"EMAIL_SENT_TO_CANDIDATE_DATE" DATE, 
	"ELIGIBILITY_END_REASON_CODE" VARCHAR2(60 BYTE), 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE, 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"PRIORITY" VARCHAR2(10 BYTE)
   );
--------------------------------------------------------
--  DDL for Index LIST_SEARCH_CANDIDATE_INDEX
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."LIST_SEARCH_CANDIDATE_INDEX" ON "HHS_HR"."LIST_SEARCH_CANDIDATE" ("ID");

--------------------------------------------------------
--  Constraints for Table LIST_SEARCH_CANDIDATE
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."LIST_SEARCH_CANDIDATE" MODIFY ("SEARCH_ID" NOT NULL ENABLE);
 
  ALTER TABLE "HHS_HR"."LIST_SEARCH_CANDIDATE" MODIFY ("ID" NOT NULL ENABLE);

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
--  DDL for Trigger LIST_SEARCH_CANDIDATE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HHS_HR"."LIST_SEARCH_CANDIDATE_TRG" 
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

  CREATE TABLE "HHS_HR"."ELIGIBILITY_LOC_PREFER" 
   (	"CANDIDATE_ID" NUMBER(15,0), 
	"LOCATION" VARCHAR2(10 BYTE)
   );
--------------------------------------------------------
--  DDL for Index ELIGIBILITY_LOC_PREFER_INDEX
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."ELIGIBILITY_LOC_PREFER_INDEX" ON "HHS_HR"."ELIGIBILITY_LOC_PREFER" ("CANDIDATE_ID", "LOCATION") ;
  
--------------------------------------------------------
--  Constraints for Table ELIGIBILITY_LOC_PREFER
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."ELIGIBILITY_LOC_PREFER" ADD UNIQUE ("CANDIDATE_ID", "LOCATION");
 
  ALTER TABLE "HHS_HR"."ELIGIBILITY_LOC_PREFER" MODIFY ("CANDIDATE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "HHS_HR"."ELIGIBILITY_LOC_PREFER" MODIFY ("LOCATION" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ELIGIBILITY_LOC_PREFER
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."ELIGIBILITY_LOC_PREFER" ADD FOREIGN KEY ("CANDIDATE_ID")
	  REFERENCES "HHS_HR"."CANDIDATE" ("CANDIDATE_ID") ENABLE;


--------------------------------------------------------
--  DDL for Table CANDIDATE_GRADE
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."CANDIDATE_GRADE" 
   (	"CANDIDATE_ID" NUMBER(15,0), 
	"GRADE_CODE" VARCHAR2(2 BYTE), 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE
   );
--------------------------------------------------------
--  DDL for Index CANDIDATE_GRADE_INDEX
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."CANDIDATE_GRADE_INDEX" ON "HHS_HR"."CANDIDATE_GRADE" ("CANDIDATE_ID");
  
--------------------------------------------------------
--  Constraints for Table CANDIDATE_GRADE
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."CANDIDATE_GRADE" ADD UNIQUE ("CANDIDATE_ID");
 
  ALTER TABLE "HHS_HR"."CANDIDATE_GRADE" MODIFY ("CANDIDATE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CANDIDATE_GRADE
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."CANDIDATE_GRADE" ADD FOREIGN KEY ("CANDIDATE_ID")
	  REFERENCES "HHS_HR"."CANDIDATE" ("CANDIDATE_ID") ENABLE;


--------------------------------------------------------
--  DDL for Table CANDIDATE_OCC_SERIES
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."CANDIDATE_OCC_SERIES" 
   (	"CANDIDATE_ID" NUMBER(15,0), 
	"OCC_SERIES" VARCHAR2(10 BYTE), 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE
   );
--------------------------------------------------------
--  DDL for Index CANDIDATE_OCC_SERIES_INDEX
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."CANDIDATE_OCC_SERIES_INDEX" ON "HHS_HR"."CANDIDATE_OCC_SERIES" ("CANDIDATE_ID", "OCC_SERIES");

--------------------------------------------------------
--  Constraints for Table CANDIDATE_OCC_SERIES
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."CANDIDATE_OCC_SERIES" ADD UNIQUE ("CANDIDATE_ID", "OCC_SERIES");
  
  ALTER TABLE "HHS_HR"."CANDIDATE_OCC_SERIES" MODIFY ("CANDIDATE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "HHS_HR"."CANDIDATE_OCC_SERIES" MODIFY ("OCC_SERIES" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CANDIDATE_OCC_SERIES
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."CANDIDATE_OCC_SERIES" ADD FOREIGN KEY ("CANDIDATE_ID")
	  REFERENCES "HHS_HR"."CANDIDATE" ("CANDIDATE_ID") ENABLE;


--------------------------------------------------------
--  DDL for Table ATTACHMENT
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."ATTACHMENT" 
   (	"DOCUMENT_ID" NUMBER(15,0), 
	"DOCUMENT_NAME" VARCHAR2(256 BYTE), 
	"CANDIDATE_ID" NUMBER(15,0), 
	"DOCUMENT_TYPE_CODE" VARCHAR2(100 BYTE), 
	"DOCUMENT_DESC" VARCHAR2(50 BYTE), 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE, 
	"PROCID" NUMBER(10,0), 
	"ATTACHSEQ" NUMBER(10,0)
   ); 
--------------------------------------------------------
--  DDL for Index ATTACHMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HHS_HR"."ATTACHMENT_PK" ON "HHS_HR"."ATTACHMENT" ("DOCUMENT_ID");

--------------------------------------------------------
--  Constraints for Table ATTACHMENT
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."ATTACHMENT" ADD CONSTRAINT "ATTACHMENT_PK" PRIMARY KEY ("DOCUMENT_ID");
 
  ALTER TABLE "HHS_HR"."ATTACHMENT" MODIFY ("CANDIDATE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ATTACHMENT
--------------------------------------------------------

  ALTER TABLE "HHS_HR"."ATTACHMENT" ADD FOREIGN KEY ("CANDIDATE_ID")
	  REFERENCES "HHS_HR"."CANDIDATE" ("CANDIDATE_ID") ENABLE;

--------------------------------------------------------
--  DDL for SEQLUENCE ATTACHMENT_SEQ
--------------------------------------------------------

CREATE SEQUENCE ATTACHMENT_SEQ
	INCREMENT BY 1
	START WITH 100000000000000
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

--------------------------------------------------------
--  DDL for Trigger ATTACHMENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HHS_HR"."ATTACHMENT_TRG" 
BEFORE INSERT ON ATTACHMENT
FOR EACH ROW
BEGIN
	SELECT ATTACHMENT_SEQ.NEXTVAL
	INTO :NEW.DOCUMENT_ID
	FROM DUAL;
END;
/

--------------------------------------------------------
--  DDL for Table USER_PERMISSION
--------------------------------------------------------

  CREATE TABLE "HHS_HR"."USER_PERMISSION" 
   (	"PERMISSION_ID" NUMBER(10,0), 
	"GROUP_NAME" VARCHAR2(100 BYTE), 
	"LIST_TYPE" VARCHAR2(30 BYTE), 
	"USER_ID" NUMBER(10,0), 
	"CREATED_BY" VARCHAR2(10 BYTE), 
	"CREATION_DATE" DATE, 
	"LAST_UPDATED_BY" VARCHAR2(10 BYTE), 
	"LAST_UPDATE_DATE" DATE
   );

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
--  DDL for Trigger USER_PERMISSION_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HHS_HR"."USER_PERMISSION_TRG" 
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

  CREATE TABLE "HHS_HR"."HHS_LIST_MANAGER_LOOKUP" 
   (	"ID" NUMBER(10,0), 
	"LOOKUP_NAME" VARCHAR2(70 BYTE), 
	"LOOKUP_DESCRIPTION" VARCHAR2(150 BYTE), 
	"LOOKUP_CODE" VARCHAR2(150 BYTE), 
	"CONDITION_1" VARCHAR2(1028 BYTE), 
	"CONDITION_2" VARCHAR2(1028 BYTE), 
	"DISP_ORDER" NUMBER(10,0)
   );
--------------------------------------------------------
--  DDL for Index HHS_LIST_MANAGER_LOOKUP_INDEX1
--------------------------------------------------------

  CREATE INDEX "HHS_HR"."HHS_LIST_MANAGER_LOOKUP_INDEX1" ON "HHS_HR"."HHS_LIST_MANAGER_LOOKUP" ("ID");

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
--  DDL for Trigger HHS_LIST_MANAGER_LOOKUP_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HHS_HR"."HHS_LIST_MANAGER_LOOKUP_TRG" 
BEFORE INSERT ON HHS_LIST_MANAGER_LOOKUP
FOR EACH ROW
BEGIN
	SELECT HHS_LIST_MANAGER_LOOKUP_SEQ.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/


