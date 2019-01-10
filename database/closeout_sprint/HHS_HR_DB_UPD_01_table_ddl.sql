

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