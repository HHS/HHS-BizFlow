CREATE OR REPLACE PACKAGE MEMBER_STG_TO_FNL AS
	
--======================================================
--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -

--CURSORS

--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -
--======================================================		
	
--------------------------------------------------------
--CURSOR: CUR_MEMBERSTG
--DESCRIPTION: Cursor retrieves records from memberstg
--------------------------------------------------------
CURSOR CUR_MEMBERSTG
IS
	SELECT HHSID,
			 NAME,
			 DEPTNAME,
			 EMAIL,
			 ACTIVEIND
	FROM MEMBERSTG;

	TYPE TYP_MEMBERSTG IS TABLE OF CUR_MEMBERSTG%ROWTYPE
		INDEX BY PLS_INTEGER;
	
	
--------------------------------------------------------
--CURSOR: CUR_USERS
--DESCRIPTION: Cursor retrieves existing member records
--------------------------------------------------------
CURSOR CUR_USERS
IS
	SELECT M.LOGINID,
			 M.NAME,
			 M.EMAIL,
			 M.MEMBERID,
			 M.DEPTNAME,
			 M.STATE,
			 I.CUSTOMB AS HHSID,
          CASE WHEN STG.ROWID IS NOT NULL 
					AND M.STATE = 'N'
               THEN 'Y'
               ELSE 'N'
          END AS ACTV_STG_REC_IND
	FROM BIZFLOW.MEMBER M
	LEFT OUTER JOIN BIZFLOW.MEMBERINFO I
	ON M.MEMBERID = I.MEMBERID
   LEFT OUTER JOIN MEMBERSTG STG
   ON I.CUSTOMB = STG.HHSID
	WHERE M.TYPE = 'U'
   AND I.CUSTOMB IS NOT NULL;

	TYPE TYP_USERS IS TABLE OF CUR_USERS%ROWTYPE
		INDEX BY PLS_INTEGER;
		
--======================================================
--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -

--TYPES

--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -
--======================================================	
TYPE TYP_MEMBER IS TABLE OF BIZFLOW.MEMBER%ROWTYPE
	INDEX BY PLS_INTEGER;
	
TYPE TYP_MEMBERINFO IS TABLE OF BIZFLOW.MEMBERINFO%ROWTYPE
	INDEX BY PLS_INTEGER;
	
TYPE TYP_MEMBERHISTORY IS TABLE OF MEMBERHISTORY%ROWTYPE
	INDEX BY PLS_INTEGER;

TYPE TYP_USERS_CACHE IS TABLE OF CUR_USERS%ROWTYPE
	INDEX BY VARCHAR2(200);			

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBER
--DESCRIPTION: Insert new records into member table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBER
	(I_TBL_MEM	IN TYP_MEMBER);
	
--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERINFO
--DESCRIPTION: Insert new records into MEMBERINFO table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERINFO
	(I_TBL_INFO	IN TYP_MEMBERINFO);

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERHISTORY
--DESCRIPTION: Insert new records into MEMBERHISTORY table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERHISTORY
	(I_TBL_HST	IN TYP_MEMBERHISTORY);
	

--------------------------------------------------------
--PROCEDURE: SP_UPDATE_MEMBER
--DESCRIPTION: Update record type 'U' in MEMBER table
--------------------------------------------------------
PROCEDURE SP_UPDATE_MEMBER
	(I_TBL_MEM	IN TYP_MEMBER);

--------------------------------------------------------
--PROCEDURE: SP_CHECK_MEMBER
--DESCRIPTION: Checks if member records should be updated
--------------------------------------------------------
PROCEDURE SP_CHECK_MEMBER
	(I_REC_STG	   IN CUR_MEMBERSTG%ROWTYPE,
	 I_REC_USERS   IN CUR_USERS%ROWTYPE,
	 IO_TBL_MEM		IN OUT TYP_MEMBER,
	 IO_TBL_HST		IN OUT TYP_MEMBERHISTORY);
	 
--------------------------------------------------------
--PROCEDURE: SP_INACTIVATE_MEMBER
--DESCRIPTION: There is an existing CMS member, but it is 
-- no longer active on the staging table. Inactive the member
-- record
--------------------------------------------------------
PROCEDURE SP_INACTIVATE_MEMBER
	(I_REC_USERS 	IN CUR_USERS%ROWTYPE,
	 O_REC_MEM		OUT BIZFLOW.MEMBER%ROWTYPE,
	 O_REC_HST		OUT MEMBERHISTORY%ROWTYPE);	 

--------------------------------------------------------
--PROCEDURE: SP_PROCESS_MEMBER
--DESCRIPTION:
--------------------------------------------------------
PROCEDURE SP_PROCESS_MEMBER
	(I_TBL_STG	   IN TYP_MEMBERSTG,
	 I_TBL_USERS   IN TYP_USERS);

--------------------------------------------------------
--FUNCTION: FN_PROCESS_STG_TO_FNL
--DESCRIPTION:
--------------------------------------------------------
FUNCTION FN_PROCESS_STG_TO_FNL
	(O_ERRMSG	OUT VARCHAR2)
RETURN NUMBER;
		
END MEMBER_STG_TO_FNL;
/