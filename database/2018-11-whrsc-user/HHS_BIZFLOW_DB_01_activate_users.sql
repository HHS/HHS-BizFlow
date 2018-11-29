
-------------------------------------------------------
-- Inspect member records for license and authority
-------------------------------------------------------
SELECT M.MEMBERID, M.NAME, M.TYPE, M.LOGINID, M.STATE, M.LICTYPE
FROM BIZFLOW.MEMBER M
WHERE 1=1
	--AND (M.TYPE = 'G' OR M.TYPE = 'H')
	--AND M.NAME = 'Visitor'
	AND M.MEMBERID = 'licsgrp004'  -- user license
	--AND M.MEMBERID = 'licsgrp007'  -- report user license
	--AND M.MEMBERID = 'authgrp005'  -- user authority
	--AND M.MEMBERID = 'authgrp008'  -- report user authority
;


-------------------------------------------------------
-- Inspect parent-child relationship of members
-------------------------------------------------------
SELECT P.PARENTID, PM.NAME AS PARENTNAME, PM.TYPE AS PARENTTYPE, P.MEMBERID, CM.NAME AS CHILDNAME, CM.TYPE AS CHILDTYPE, P.TYPE, P.MEMBERPATH
FROM BIZFLOW.PARENTMEMBER P
	INNER JOIN BIZFLOW.MEMBER PM ON PM.MEMBERID = P.PARENTID
	INNER JOIN BIZFLOW.MEMBER CM ON CM.MEMBERID = P.MEMBERID
WHERE 1=1
	--AND (PM.NAME = 'WHRSC' OR CM.NAME = 'WHRSC' OR PM.NAME = 'RDR' OR CM.NAME = 'RDR' OR PM.NAME = 'Visitor' OR CM.NAME = 'Visitor')
	--AND (PM.NAME = 'Visitor' OR CM.NAME = 'Visitor')
	AND P.MEMBERPATH = '/WHRSC/RDR/Visitor'
;



-------------------------------------------------------
-- Inspect user group, license, authority assignment of members
-------------------------------------------------------
SELECT  UGP.*,
	G.MEMBERID AS GID, G.NAME AS GRPNAME, G.DEPTID AS GRPDEPT
	, M.MEMBERID AS MID, M.NAME AS USRNAME, M.DEPTID AS USRDEPT 
	--, H.MEMBERID AS HID, H.NAME AS HIERNAME
FROM
	BIZFLOW.USRGRPPRTCP UGP
	INNER JOIN BIZFLOW.MEMBER G ON G.MEMBERID = UGP.USRGRPID
	INNER JOIN BIZFLOW.MEMBER M ON M.MEMBERID = UGP.PRTCP
	--INNER JOIN BIZFLOW.MEMBER H ON H.MEMBERID = UGP.USRGRPHID
WHERE
	1=1
	--AND G.NAME = 'Visitor'
	--AND M.NAME = 'Visitor'
	AND G.MEMBERID = 'licsgrp004'  -- user license
	--AND G.MEMBERID = 'licsgrp007'  -- report user license
	--AND G.MEMBERID = 'authgrp005'  -- user authority
	--AND G.MEMBERID = 'authgrp008'  -- report user authority
;

--=============================================================================



/*


----------------------------------------
-- Create backup of USRGRPPRTCP table before making data change
----------------------------------------
CREATE USRGRPPRTCP_BACKUP_20181009 AS SELECT * FROM USRGRPPRTCP;

--==========================================
-- Enable RDR Visitor for all members
--==========================================
DECLARE
	V_USRGRPID          VARCHAR2(10);
	V_USRGRPHID       VARCHAR2(10);
BEGIN

	SELECT MEMBERID, DEPTID
	INTO V_USRGRPID, V_USRGRPHID
	FROM MEMBER
	WHERE MEMBERID = (SELECT MEMBERID FROM PARENTMEMBER WHERE MEMBERPATH = '/WHRSC/RDR/Visitor');

	MERGE INTO USRGRPPRTCP TRG
	USING
	(
		SELECT
			V_USRGRPID AS USRGRPID
			, MEMBERID AS PRTCP
			, TYPE AS PRTCPTYPE
			, 0 AS DISPORDER
			, V_USRGRPHID AS USRGRPHID
		FROM MEMBER
		WHERE TYPE = 'U'
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
*/


----------------------------------------
-- Create backup of USRGRPPRTCP table before making data change
----------------------------------------
CREATE TABLE USRGRPPRTCP_BACKUP_20181128 AS SELECT * FROM USRGRPPRTCP;

--==========================================
-- Enable user access for all members
--==========================================
DECLARE
	V_USRGRPID        VARCHAR2(10);
BEGIN

	-- MEMBERID = 'licsgrp004'  -- user license
	-- MEMBERID = 'licsgrp007'  -- report user license
	-- MEMBERID = 'authgrp005'  -- user authority
	-- MEMBERID = 'authgrp008'  -- report user authority

	-------------------------------
	-- assign user license
	-------------------------------
	SELECT MEMBERID
	INTO V_USRGRPID
	FROM MEMBER
	WHERE MEMBERID = 'licsgrp004'  -- user license
	;

	MERGE INTO USRGRPPRTCP TRG
	USING
	(
		SELECT
			V_USRGRPID AS USRGRPID
			, MEMBERID AS PRTCP
			, TYPE     AS PRTCPTYPE
			, 100      AS DISPORDER
			, NULL     AS USRGRPHID
		FROM MEMBER
		WHERE TYPE = 'U'
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


	-------------------------------
	-- assign user authority group
	-------------------------------
	SELECT MEMBERID
	INTO V_USRGRPID
	FROM MEMBER
	WHERE MEMBERID = 'authgrp005'  -- user authority
	;

	MERGE INTO USRGRPPRTCP TRG
	USING
	(
		SELECT
			V_USRGRPID AS USRGRPID
			, MEMBERID AS PRTCP
			, TYPE     AS PRTCPTYPE
			, 100      AS DISPORDER
			, NULL     AS USRGRPHID
		FROM MEMBER
		WHERE TYPE = 'U'
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

	COMMIT;
END;


--==========================================
-- Activate all users
--==========================================
BEGIN
	-- Create backup of MEMBER table before making data change
	CREATE TABLE MEMBER_BACKUP_20181128 AS SELECT * FROM MEMBER;

	UPDATE MEMBER SET STATE = 'N', INHERITTYPE = 'N' WHERE TYPE = 'U' AND STATE = 'D';

	COMMIT;
END;

