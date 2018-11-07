SET DEFINE OFF;

DROP TABLE LIST_SEARCH_CANDIDATE CASCADE CONSTRAINTS ;
--DROP SEQUENCE LIST_SEARCH_CANDIDATE_SEQ;
DROP TABLE SEARCH_OCC_SERIES CASCADE CONSTRAINTS ;
DROP TABLE SEARCH_GRADE CASCADE CONSTRAINTS ;


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
ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (CANDIDATE_ID NOT NULL );
ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY (LIST_ID NOT NULL );


ALTER TABLE LIST_SEARCH_CANDIDATE MODIFY CLEARING_ACTION_CODE VARCHAR2(100);



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

/*
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
*/

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





	
