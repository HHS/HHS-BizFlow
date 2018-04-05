
SET DEFINE OFF;


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