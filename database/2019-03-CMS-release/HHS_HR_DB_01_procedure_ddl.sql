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