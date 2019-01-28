CREATE OR REPLACE PACKAGE BODY HHS_HR.BIZFLOW_PROVISION_PKG AS

--======================================================
--  - - -   - - - - - - - - - - - - - - - - - - - - - - 

--GLOBAL VARIABLES

--- -  -  -- - - - - - - - - - - - - - - - - - - - - - -
--======================================================
	GCV_USR_LICENSE     CONSTANT   BIZFLOW.MEMBER.MEMBERID%TYPE     := 'licsgrp004';
	GCV_USR_AUTHORITY   CONSTANT   BIZFLOW.MEMBER.MEMBERID%TYPE     := 'authgrp005';
	GCV_USR_TYPE        CONSTANT   BIZFLOW.MEMBER.TYPE%TYPE         := 'U';
	GCV_GRP_TYPE        CONSTANT   BIZFLOW.MEMBER.TYPE%TYPE         := 'G';
	GCV_VISITOR_NAME    CONSTANT   BIZFLOW.MEMBER.NAME%TYPE         := 'Visitor';
	GCV_DEPT_WHRSC      CONSTANT   BIZFLOW.MEMBER.DEPTNAME%TYPE     := 'WHRSC';


--======================================================
--  - - - - - - - - - - - - - - - - - - - - - - - - - - -

--PROCEDURES

--  - - -   - - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
--------------------------------------------------------
--PROCEDURE: ASSIGN_LICENSE
--DESCRIPTION: assign user license
--------------------------------------------------------
PROCEDURE ASSIGN_LICENSE
IS
	V_USRGRPID        VARCHAR2(10);
BEGIN

	SELECT MEMBERID
	INTO V_USRGRPID
	FROM BIZFLOW.MEMBER
	WHERE MEMBERID = GCV_USR_LICENSE  -- user license
	;

	MERGE INTO BIZFLOW.USRGRPPRTCP TRG
	USING
	(
		SELECT
			V_USRGRPID AS USRGRPID
			, MEMBERID AS PRTCP
			, TYPE     AS PRTCPTYPE
			, 100      AS DISPORDER
			, NULL     AS USRGRPHID
		FROM BIZFLOW.MEMBER
		WHERE TYPE = GCV_USR_TYPE
		AND DEPTNAME = GCV_DEPT_WHRSC
	) SRC ON (SRC.USRGRPID = TRG.USRGRPID AND SRC.PRTCP = TRG.PRTCP)
	WHEN NOT MATCHED THEN INSERT
	(
		TRG.USRGRPID
		, TRG.PRTCP
		, TRG.PRTCPTYPE
		, TRG.DISPORDER
		, TRG.USRGRPHID
	)
	VALUES
	(
		SRC.USRGRPID
		, SRC.PRTCP
		, SRC.PRTCPTYPE
		, SRC.DISPORDER
		, SRC.USRGRPHID
	)
	;
END;

--------------------------------------------------------
--PROCEDURE: ASSIGN_AUTH_GRP
--DESCRIPTION: assign user authority group
--------------------------------------------------------
PROCEDURE ASSIGN_AUTH_GRP
IS
	V_USRGRPID        VARCHAR2(10);
BEGIN

	SELECT MEMBERID
	INTO V_USRGRPID
	FROM BIZFLOW.MEMBER
	WHERE MEMBERID = GCV_USR_AUTHORITY  -- user authority
	;

	MERGE INTO BIZFLOW.USRGRPPRTCP TRG
	USING
	(
		SELECT
			V_USRGRPID AS USRGRPID
			, MEMBERID AS PRTCP
			, TYPE     AS PRTCPTYPE
			, 100      AS DISPORDER
			, NULL     AS USRGRPHID
		FROM BIZFLOW.MEMBER
		WHERE TYPE = GCV_USR_TYPE
		AND DEPTNAME = GCV_DEPT_WHRSC
	) SRC ON (SRC.USRGRPID = TRG.USRGRPID AND SRC.PRTCP = TRG.PRTCP)
	WHEN NOT MATCHED THEN INSERT
	(
		TRG.USRGRPID
		, TRG.PRTCP
		, TRG.PRTCPTYPE
		, TRG.DISPORDER
		, TRG.USRGRPHID
	)
	VALUES
	(
		SRC.USRGRPID
		, SRC.PRTCP
		, SRC.PRTCPTYPE
		, SRC.DISPORDER
		, SRC.USRGRPHID
	)
	;
END;

--------------------------------------------------------
--PROCEDURE: ENABLE_RDR_VISITOR
--DESCRIPTION: Enable RDR Visitor for all members
--------------------------------------------------------
PROCEDURE ENABLE_RDR_VISITOR
IS
	V_USRGRPID        VARCHAR2(10);
	V_USRGRPHID       VARCHAR2(10);
BEGIN

	SELECT MEMBERID, DEPTID
	INTO V_USRGRPID, V_USRGRPHID
	FROM BIZFLOW.MEMBER
	WHERE MEMBERID = (SELECT MEMBERID FROM BIZFLOW.MEMBER
					  WHERE NAME = GCV_VISITOR_NAME
					  AND TYPE = GCV_GRP_TYPE);

	MERGE INTO BIZFLOW.USRGRPPRTCP TRG
	USING
	(
		SELECT
			V_USRGRPID AS USRGRPID
			, MEMBERID AS PRTCP
			, TYPE     AS PRTCPTYPE
			, 0        AS DISPORDER
			, V_USRGRPHID AS USRGRPHID
		FROM BIZFLOW.MEMBER
		WHERE TYPE = GCV_USR_TYPE
		AND DEPTNAME = GCV_DEPT_WHRSC
	) SRC ON (SRC.USRGRPID = TRG.USRGRPID AND SRC.PRTCP = TRG.PRTCP)
	WHEN NOT MATCHED THEN INSERT
	(
		TRG.USRGRPID
		, TRG.PRTCP
		, TRG.PRTCPTYPE
		, TRG.DISPORDER
		, TRG.USRGRPHID
	)
	VALUES
	(
		SRC.USRGRPID
		, SRC.PRTCP
		, SRC.PRTCPTYPE
		, SRC.DISPORDER
		, SRC.USRGRPHID
	)
	;
END;


--======================================================
-- - - - - - - - - - - - - - - - - - - - - - - - - - - -

--FUNCTIONS

-- - - -- - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
--------------------------------------------------------
--FUNCTION: FN_ACTIVATE_USERS
--DESCRIPTION: Enable user access for all members
--------------------------------------------------------
FUNCTION FN_ACTIVATE_USERS
	(O_ERRMSG       OUT VARCHAR2)
RETURN NUMBER
IS
BEGIN

	ASSIGN_LICENSE;
	ASSIGN_AUTH_GRP;
	ENABLE_RDR_VISITOR;
	
	O_ERRMSG := SQLERRM || ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE;
	COMMIT;
	RETURN SQLCODE;
EXCEPTION
	WHEN OTHERS THEN
		ROLLBACK;
		O_ERRMSG := SQLERRM || ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE;
		RETURN SQLCODE;
END;

END BIZFLOW_PROVISION_PKG;
/
