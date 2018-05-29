CREATE OR REPLACE PACKAGE HHS_HR.BIIS_PERSON AS

--======================================================
-- - - -- - - - - - - - - - - - - - - - - - - - - - - -

--CURSORS

-- - - - - - - - - - - - - - - - - - - - - - - - - - - -
--======================================================

--------------------------------------------------------
--CURSOR: CUR_BIIS_PERSON
--DESCRIPTION: Cursor retrieves records from the BIIS
-- EWITS_BIIS_PERSON_MV view across a database link
--------------------------------------------------------
CURSOR CUR_BIIS_PERSON
IS
	SELECT HHSID,
			LAST_NAME,
			FIRST_NAME,
			MIDDLE_NAME,
			LOWER(EMAIL_ADDR) AS EMAIL_ADDR,
			USERTYPE,
			PIV_CARD_STATUS,
			SCMS_STATUS,
			EMPLID,
			PAY_PLAN,
			GRADE,
			POSITION_TITLE_NAME,
			SERIES,
			BARG_UNIT,
			OPDIV,
			ORG_CD,
			PAY_BASIS,
			STEP,
			BASIC_PAY,
			ADJ_BASIC_PAY,
			CAN_CD,
			JOB_CODE,
			POSITION_NUM,
			EMP_STATUS_FROM_PERS_SYSTEM,
			LAST_UPDT_FROM_PERS_SYSTEM_DT
	FROM HISTDBA.EWITS_BIIS_PERSON_MV@BIIS_DBLINK
	WHERE OPDIV IN ('CMS', 'CDC', 'IHS', 'OS', 'ACF', 'ACL','AHRQ', 'PSC', 'SAMHSA')
		AND HHSID IS NOT NULL
		AND EMAIL_ADDR IS NOT NULL
		AND ((USERTYPE = 'Employee' AND EMP_STATUS_FROM_PERS_SYSTEM != 'Terminated')
		OR (USERTYPE != 'Employee' AND EMP_STATUS_FROM_PERS_SYSTEM = 'Active'));

	TYPE TYP_BIIS_PERSON IS TABLE OF CUR_BIIS_PERSON%ROWTYPE
		INDEX BY PLS_INTEGER;

--------------------------------------------------------
--CURSOR: CUR_MEMBERSTG
--DESCRIPTION: Cursor retrieves records from memberstg
--------------------------------------------------------
CURSOR CUR_MEMBERSTG
IS
	WITH DUPL_EMAIL AS
	(
		SELECT HHSID, EMAIL FROM
		(
			SELECT HHSID,
					EMAIL,
					RANK() OVER 
					(PARTITION BY EMAIL ORDER BY HHSID) AS RANK
			FROM MEMBERSTG
		)
		WHERE RANK > 1
	),
	MULTI_DEPT AS
	(
		SELECT HHSID, DEPTNAME FROM
		(
			SELECT HHSID,
					DEPTNAME,
					RANK() OVER 
					(PARTITION BY HHSID ORDER BY DEPTNAME) AS RANK
			FROM MEMBERSTG
		)
		WHERE RANK > 1
	)
	SELECT  STG.HHSID,
			STG.FIRSTNAME,
			STG.MIDDLENAME,
			STG.LASTNAME,
			STG.EMAIL,
			STG.DEPTNAME,
			STG.LASTUPDATE,
			CASE
				WHEN DUPL.ROWID IS NOT NULL
				THEN 'Y'
				WHEN MULTI.ROWID IS NOT NULL
				THEN 'Y'
				ELSE 'N'
			END AS EXCLUDE_RECORD
	FROM MEMBERSTG STG
		LEFT JOIN DUPL_EMAIL DUPL
		ON STG.EMAIL = DUPL.EMAIL
		LEFT JOIN MULTI_DEPT MULTI
		ON STG.HHSID = MULTI.HHSID
	ORDER BY LASTUPDATE DESC;

	TYPE TYP_CUR_MEMBERSTG IS TABLE OF CUR_MEMBERSTG%ROWTYPE
		INDEX BY PLS_INTEGER;

--------------------------------------------------------
--CURSOR: CUR_USERS
--DESCRIPTION: Cursor retrieves existing member records
--------------------------------------------------------
CURSOR CUR_USERS
IS
	SELECT M.LOGINID,
			M.NAME,
			M.SHORTNAME,
			M.EMAIL,
			M.MEMBERID,
			M.DEPTNAME,
			M.DEPTID,
			M.STATE,
			I.CUSTOMB AS HHSID,
			CASE WHEN I.ROWID IS NOT NULL
				THEN 'Y'
				ELSE 'N'
			END AS MEMINFO_REC_IND
	FROM BIZFLOW.MEMBER M
		LEFT OUTER JOIN BIZFLOW.MEMBERINFO I
		ON M.MEMBERID = I.MEMBERID
		LEFT OUTER JOIN MEMBERSTG STG
		ON I.CUSTOMB = STG.HHSID
	WHERE M.TYPE = 'U';

	TYPE TYP_USERS IS TABLE OF CUR_USERS%ROWTYPE
		INDEX BY PLS_INTEGER;

--======================================================
-- - - - - - - - - - - - - - - - - - - - - - - - - - - -

--TYPES

-- - - - - - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
TYPE TYP_MEMBER IS TABLE OF BIZFLOW.MEMBER%ROWTYPE
	INDEX BY PLS_INTEGER;

TYPE TYP_MEMBERINFO IS TABLE OF BIZFLOW.MEMBERINFO%ROWTYPE
	INDEX BY PLS_INTEGER;

TYPE TYP_MEMBERHISTORY IS TABLE OF MEMBERHISTORY%ROWTYPE
	INDEX BY PLS_INTEGER;

TYPE TYP_MEMBERSTG IS TABLE OF MEMBERSTG%ROWTYPE
	INDEX BY PLS_INTEGER;

TYPE TYP_USERS_CACHE IS TABLE OF CUR_USERS%ROWTYPE
	INDEX BY VARCHAR2(200);

TYPE TYPE_EMP_LOOKUP IS TABLE OF EMPLOYEE_LOOKUP%ROWTYPE
	INDEX BY PLS_INTEGER;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBER
--DESCRIPTION: Insert new records into member table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBER
	(I_TBL_MEM  IN TYP_MEMBER);

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERINFO
--DESCRIPTION: Insert new records into MEMBERINFO table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERINFO
	(I_TBL_INFO IN TYP_MEMBERINFO);

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERHISTORY
--DESCRIPTION: Insert new records into MEMBERHISTORY table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERHISTORY
	(I_TBL_HST  IN TYP_MEMBERHISTORY);

--------------------------------------------------------
--PROCEDURE: SP_UPDATE_MEMBER
--DESCRIPTION: Update record type 'U' in MEMBER table
--------------------------------------------------------
PROCEDURE SP_UPDATE_MEMBER
	(I_TBL_MEM  IN TYP_MEMBER);

--------------------------------------------------------
--PROCEDURE: SP_INSERT_BIIS_DATA
--DESCRIPTION: Insert BIIS data onto staging tables
--------------------------------------------------------
PROCEDURE SP_INSERT_BIIS_DATA
	(I_TBL_BIIS     IN TYP_BIIS_PERSON);

--------------------------------------------------------
--PROCEDURE: SP_CHECK_MEMBER
--DESCRIPTION: Checks if member records should be updated
--------------------------------------------------------
PROCEDURE SP_CHECK_MEMBER
	(I_REC_STG      IN CUR_MEMBERSTG%ROWTYPE,
	I_REC_USERS     IN CUR_USERS%ROWTYPE,
	IO_TBL_MEM      IN OUT TYP_MEMBER,
	IO_TBL_HST      IN OUT TYP_MEMBERHISTORY);

--------------------------------------------------------
--PROCEDURE: SP_ADD_HHSID
--DESCRIPTION: Adds HHSID to existing member record
--------------------------------------------------------
PROCEDURE SP_ADD_HHSID
	(I_REC_STG          IN CUR_MEMBERSTG%ROWTYPE,
	I_REC_USERS         IN CUR_USERS%ROWTYPE,
	IO_TBL_INS_INFO     IN OUT TYP_MEMBERINFO,
	IO_TBL_UPDT_INFO    IN OUT TYP_MEMBERINFO);

--------------------------------------------------------
--PROCEDURE: SP_PROCESS_MEMBER
--DESCRIPTION:
--------------------------------------------------------
PROCEDURE SP_PROCESS_MEMBER
	(I_TBL_STG     IN TYP_CUR_MEMBERSTG,
	I_TBL_USERS   IN TYP_USERS);

--------------------------------------------------------
--FUNCTION: FN_IMPORT_BIIS_PERSON
--DESCRIPTION:
--------------------------------------------------------
FUNCTION FN_IMPORT_BIIS_PERSON
	(O_ERRMSG   OUT VARCHAR2)
RETURN NUMBER;

END BIIS_PERSON;
/