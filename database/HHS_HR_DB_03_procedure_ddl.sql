
SET DEFINE OFF;

--------------------------------------------------------
--  DDL for FUNCTION  DISTANCE
--------------------------------------------------------

create or replace FUNCTION FN_GET_DISTANCE (Lat1 IN NUMBER,
                                     Lon1 IN NUMBER,
                                     Lat2 IN NUMBER,
                                     Lon2 IN NUMBER,
                                     Radius IN NUMBER DEFAULT 3963) RETURN NUMBER IS
-- Convert degrees to radians
DegToRad NUMBER := 57.29577951;

BEGIN
  RETURN(NVL(Radius,0) * ACOS((sin(NVL(Lat1,0) / DegToRad) * SIN(NVL(Lat2,0) / DegToRad)) +
        (COS(NVL(Lat1,0) / DegToRad) * COS(NVL(Lat2,0) / DegToRad) *
         COS(NVL(Lon2,0) / DegToRad - NVL(Lon1,0)/ DegToRad))));
  
END;

/
--------------------------------------------------------
--  DDL for Procedure SP_ERROR_LOG
--------------------------------------------------------
/**
 * Stores database errors to ERROR_LOG table to help troubleshooting.
 *
 */
CREATE OR REPLACE PROCEDURE SP_ERROR_LOG
IS
	PRAGMA AUTONOMOUS_TRANSACTION;
	V_CODE      PLS_INTEGER := SQLCODE;
	V_MSG       VARCHAR2(32767) := SQLERRM;
BEGIN
	INSERT INTO ERROR_LOG
	(
		ERROR_CD
		, ERROR_MSG
		, BACKTRACE
		, CALLSTACK
		, CRT_DT
		, CRT_USR
	)
	VALUES (
		V_CODE
		, V_MSG
		, SYS.DBMS_UTILITY.FORMAT_ERROR_BACKTRACE
		, SYS.DBMS_UTILITY.FORMAT_CALL_STACK
		, SYSDATE
		, USER
	);

	COMMIT;
END;
/

--------------------------------------------------------
--  DDL for Procedure SP_INTERFACE_ERROR_LOGGER
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE SP_INTERFACE_ERROR_LOGGER 
(
  ERR_CODE IN NUMBER 
, MESSAGE IN VARCHAR2 
) AS 
---------------------------------------------------------------------------------------------------------------
--This procedure will log interface ref data errors to error log table for error tracking
--sql errors will be saved during bulk insert, then logged errors to table after the bulk insert operation
--ERR_CODE: ERROR CODE at nth record during insert.
--MESSAGE: ERROR MESSAGE at nth record during insert.
---------------------------------------------------------------------------------------------------------------
BEGIN
	INSERT INTO ERROR_LOG
	(
		ERROR_CD
		, ERROR_MSG
		, BACKTRACE
		, CALLSTACK
		, CRT_DT
		, CRT_USR
	)
	VALUES (
		ERR_CODE
		, MESSAGE
		, SYS.DBMS_UTILITY.FORMAT_ERROR_BACKTRACE
		, SYS.DBMS_UTILITY.FORMAT_CALL_STACK
		, SYSDATE
		, USER
	);

	COMMIT;
END SP_INTERFACE_ERROR_LOGGER;
/


create or replace Function FN_GET_SEARCH_ID ( t NUMBER)
   RETURN number
IS
  searchid number;
  maxserachid number;
  
  cursor c1 is
  SELECT SEARCH_ID FROM HHS_HR.LIST_SEARCH_CANDIDATE;
  cursor c2 is 
  SELECT max(SEARCH_ID)+ 1 FROM HHS_HR.LIST_SEARCH_CANDIDATE;
BEGIN

  open c1;
  fetch c1 into searchid;
  open c2;
  fetch c2 into maxserachid;

  if c1%notfound then
     searchid := 1000000000;
  else
    searchid := maxserachid;
  end if;

  close c1;
  close c2;

RETURN searchid;

EXCEPTION
WHEN OTHERS THEN
   raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
END;

/

--------------------------------------------------------
--  DDL for Procedure SP_SEND_MAIL
--------------------------------------------------------
/**
 * Procedure to send notification emails.
 *
 */
CREATE OR REPLACE PROCEDURE SP_SEND_MAIL (I_TO        IN VARCHAR2,
                                       I_CC        IN VARCHAR2 DEFAULT NULL,
                                       I_BCC       IN VARCHAR2 DEFAULT NULL,
                                       I_FROM      IN VARCHAR2,
                                       I_SUBJECT   IN VARCHAR2,
                                       I_TEXT_MSG  IN VARCHAR2 DEFAULT NULL,
                                       I_HTML_MSG  IN VARCHAR2 DEFAULT NULL)
AS
  V_MAIL_CONN   UTL_SMTP.CONNECTION;
  V_SMTP_HOST VARCHAR2(50) := 'localhost';
  V_SMTP_PORT NUMBER := 25;
  V_BOUNDARY    VARCHAR2(50) := '----=*#abc1234321cba#*=';
  V_PARTIES VARCHAR2(2000);
    
BEGIN
	--Process recipients
	FOR I IN (SELECT LEVEL AS ID, REGEXP_SUBSTR(I_TO || ';' || I_CC || ';' || I_BCC, '[^;]+', 1, LEVEL) AS TO_EMAIL_NAME
	  FROM DUAL
		  CONNECT BY REGEXP_SUBSTR(I_TO || ';' || I_CC || ';' || I_BCC, '[^;]+', 1, LEVEL) IS NOT NULL) LOOP
		  
		  V_MAIL_CONN := UTL_SMTP.OPEN_CONNECTION(V_SMTP_HOST, V_SMTP_PORT);
		  UTL_SMTP.HELO(V_MAIL_CONN, V_SMTP_HOST);
		  UTL_SMTP.MAIL(V_MAIL_CONN, I_FROM);
		  UTL_SMTP.RCPT(V_MAIL_CONN, I.TO_EMAIL_NAME);

		  UTL_SMTP.OPEN_DATA(V_MAIL_CONN);
		  
		  UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'Date: ' || TO_CHAR(SYSDATE, 'DD-MON-YYYY HH24:MI:SS') || UTL_TCP.CRLF);
		  UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'To: ' || I_TO || UTL_TCP.CRLF);
		  IF TRIM(I_CC) IS NOT NULL THEN
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'CC: ' || REPLACE(I_CC, ',', ';') || UTL_TCP.CRLF);
		  END IF;
		  IF TRIM(I_BCC) IS NOT NULL THEN
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'BCC: ' || REPLACE(I_BCC, ',', ';') || UTL_TCP.CRLF);
		  END IF;
		  UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'From: ' || I_FROM || UTL_TCP.CRLF);
		  UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'Subject: ' || I_SUBJECT || UTL_TCP.CRLF);
		  UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'MIME-Version: 1.0' || UTL_TCP.CRLF);
		  UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'Content-Type: multipart/alternative; boundary="' || V_BOUNDARY || '"' || UTL_TCP.CRLF || UTL_TCP.CRLF);
		  
		  IF I_TEXT_MSG IS NOT NULL THEN
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, '--' || V_BOUNDARY || UTL_TCP.CRLF);
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'Content-Type: text/plain; charset="iso-8859-1"' || UTL_TCP.CRLF || UTL_TCP.CRLF);

			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, I_TEXT_MSG);
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, UTL_TCP.CRLF || UTL_TCP.CRLF);
		  END IF;

		  IF I_HTML_MSG IS NOT NULL THEN
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, '--' || V_BOUNDARY || UTL_TCP.CRLF);
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, 'Content-Type: text/html; charset="iso-8859-1"' || UTL_TCP.CRLF || UTL_TCP.CRLF);

			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, I_HTML_MSG);
			UTL_SMTP.WRITE_DATA(V_MAIL_CONN, UTL_TCP.CRLF || UTL_TCP.CRLF);
		  END IF;

		  UTL_SMTP.WRITE_DATA(V_MAIL_CONN, '--' || V_BOUNDARY || '--' || UTL_TCP.CRLF);
		  UTL_SMTP.CLOSE_DATA(V_MAIL_CONN);

		  UTL_SMTP.QUIT(V_MAIL_CONN);
		END LOOP; 
	COMMIT; 
END;
/