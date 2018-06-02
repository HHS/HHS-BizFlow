
--------------------------------------------------------
--  Backout statement
--------------------------------------------------------
--DROP TABLE INTG_DATA_DTL;

--DROP SEQUENCE INTG_DATA_DTL_ID_SEQ;



SET DEFINE OFF;



--=============================================================================
-- Create TABLE and associated objects
--=============================================================================

--------------------------------------------------------
--  DDL for Table INTG_DATA_DTL
--------------------------------------------------------

CREATE TABLE INTG_DATA_DTL
(
	ID                      NUMBER(20) NOT NULL
	, DATA_GRP_ID           NUMBER(20)
	, INTG_TYPE             VARCHAR2(50)
	, FIELD_DATA            XMLTYPE
	, CRT_DT                TIMESTAMP
	, CRT_USR               VARCHAR2(50)
	, MOD_DT                TIMESTAMP
	, MOD_USR               VARCHAR2(50)
);

ALTER TABLE INTG_DATA_DTL ADD CONSTRAINT INTG_DATA_DTL_PK PRIMARY KEY (ID);

-----------------------------------------------------
-- JSON support is added from Oracle 12c (12.1.0.2).
-----------------------------------------------------
--ALTER TABLE INTG_DATA_DTL ADD CONSTRAINT INTG_DATA_DTL_CK1 CHECK ( FIELD_DATA IS JSON ) ENABLE;

--DROP INDEX INTG_DATA_DTL_NK1;
CREATE INDEX INTG_DATA_DTL_NK1 ON INTG_DATA_DTL (DATA_GRP_ID)
;


COMMENT ON COLUMN INTG_DATA_DTL.ID IS 'Unique primary key';
COMMENT ON COLUMN INTG_DATA_DTL.DATA_GRP_ID IS 'Data Group ID.  Indicates the grouping of the integration data, in case there is a need to break down the dataset into multiple pieces due to the large volume of the source data.';
COMMENT ON COLUMN INTG_DATA_DTL.INTG_TYPE IS 'Integration Type.  Indicates what form data is stored in the record';
COMMENT ON COLUMN INTG_DATA_DTL.FIELD_DATA IS 'Integration data content in XML format';
COMMENT ON COLUMN INTG_DATA_DTL.CRT_DT IS 'Creation Date';
COMMENT ON COLUMN INTG_DATA_DTL.CRT_USR IS 'Creation User';
COMMENT ON COLUMN INTG_DATA_DTL.MOD_DT IS 'Modification Date';
COMMENT ON COLUMN INTG_DATA_DTL.MOD_USR IS 'Modification User';


CREATE SEQUENCE INTG_DATA_DTL_ID_SEQ
	INCREMENT BY 1
	START WITH 1
	NOMAXVALUE
	NOCYCLE
	NOCACHE;

/

CREATE OR REPLACE TRIGGER INTG_DATA_DTL_BIR
BEFORE INSERT ON INTG_DATA_DTL
FOR EACH ROW
BEGIN
	SELECT INTG_DATA_DTL_ID_SEQ.NEXTVAL
	INTO :NEW.ID
	FROM DUAL
	;
END
;

/









