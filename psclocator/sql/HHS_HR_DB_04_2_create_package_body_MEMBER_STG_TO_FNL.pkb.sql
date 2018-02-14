CREATE OR REPLACE PACKAGE BODY MEMBER_STG_TO_FNL AS 

--======================================================
--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -

--GLOBAL VARIABLES

--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
GCV_UPDATE				CONSTANT MEMBERHISTORY.DMLTYPE%TYPE	 		:= 'UPDATE';
GCV_INSERT				CONSTANT MEMBERHISTORY.DMLTYPE%TYPE	 		:= 'INSERT';
GCV_ACTIVE_STATE		CONSTANT BIZFLOW.MEMBER.STATE%TYPE			:= 'N';
GCV_INACTIVE_STATE	CONSTANT	BIZFLOW.MEMBER.STATE%TYPE			:= 'D';
GCV_INACTIVE_IND		CONSTANT MEMBERSTG.ACTIVEIND%TYPE			:= 'N';
GCV_ACTIVE_IND			CONSTANT MEMBERSTG.ACTIVEIND%TYPE			:= 'Y';
GCV_TYPE_USER			CONSTANT BIZFLOW.MEMBER.TYPE%TYPE			:= 'U';
GCV_TYPE_OU				CONSTANT BIZFLOW.MEMBER.TYPE%TYPE			:= 'D';
GCV_SVRID				CONSTANT BIZFLOW.MEMBER.SVRID%TYPE			:= '0000001001';
GCV_MANAGERID			CONSTANT BIZFLOW.MEMBER.MANAGERID%TYPE		:= '0000000000';
GCV_NAME             CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE  := 'NAME';
GCV_EMAIL            CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE  := 'EMAIL';
GCV_LOGINID          CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE  := 'LOGINID';
GCV_STATE            CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE  := 'STATE';
GCV_CMS              CONSTANT MEMBERSTG.DEPTNAME%TYPE          := 'CMS';
GCV_CMS_OU  			CONSTANT BIZFLOW.MEMBER.DEPTNAME%TYPE		:= 'CMS';  --check deptname
GCV_CMS_PASSWD			CONSTANT BIZFLOW.MEMBER.PASSWD%TYPE			:= '201154212138023223104248255105051090116157000013'; -- cms#u$er

GV_CMS_DEPTID			BIZFLOW.MEMBER.DEPTID%TYPE;

--======================================================
--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -

--PROCEDURES

--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
--------------------------------------------------------
--PROCEDURE: SP_INITALIZE
--DESCRIPTION: Initalize global variables in the program
--------------------------------------------------------
PROCEDURE SP_INITALIZE
IS
BEGIN

   --Add a new statement for each additional agency
   SELECT MEMBERID
   INTO GV_CMS_DEPTID
   FROM BIZFLOW.MEMBER 
   WHERE TYPE = GCV_TYPE_OU 
   AND STATE = GCV_ACTIVE_STATE 
   AND NAME = GCV_CMS_OU;
END;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBER
--DESCRIPTION: Insert new records into member table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBER
	(I_TBL_MEM IN TYP_MEMBER)
IS
BEGIN
	FOR i IN I_TBL_MEM.FIRST.. I_TBL_MEM.LAST LOOP
		INSERT INTO BIZFLOW.MEMBER
			(MEMBERID,
			 TYPE,
			 STATE,
			 NAME,
			 LOGINID,
			 SVRID,
			 DEPTID,
			 DEPTNAME,
			 SHORTNAME,
			 EMAIL,
			 MANAGERID,
			 PASSWD)
		VALUES 
			(I_TBL_MEM(i).MEMBERID,
			 I_TBL_MEM(i).TYPE,
			 I_TBL_MEM(i).STATE,
			 I_TBL_MEM(i).NAME,
			 I_TBL_MEM(i).LOGINID,
			 I_TBL_MEM(i).SVRID,
			 I_TBL_MEM(i).DEPTID,
			 I_TBL_MEM(i).DEPTNAME,
			 I_TBL_MEM(i).SHORTNAME,
			 I_TBL_MEM(i).EMAIL,
			 I_TBL_MEM(i).MANAGERID,
			 I_TBL_MEM(i).PASSWD);
	END LOOP;
END;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERINFO
--DESCRIPTION: Insert new records into memberinfo table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERINFO
	(I_TBL_INFO IN TYP_MEMBERINFO)
IS
BEGIN
	FOR i IN I_TBL_INFO.FIRST.. I_TBL_INFO.LAST LOOP
		INSERT INTO BIZFLOW.MEMBERINFO 
			(MEMBERID,
			 CUSTOMB)
		VALUES 
			(I_TBL_INFO(i).MEMBERID,
			 I_TBL_INFO(i).CUSTOMB);									
	END LOOP;
END;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERHISTORY
--DESCRIPTION: Insert new records into memberhistory table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERHISTORY
	(I_TBL_HST	IN TYP_MEMBERHISTORY)
IS
BEGIN
	FORALL i IN I_TBL_HST.FIRST.. I_TBL_HST.LAST
		INSERT INTO MEMBERHISTORY VALUES I_TBL_HST(i);	
END;

--------------------------------------------------------
--PROCEDURE: SP_UPDATE_MEMBER
--DESCRIPTION: Update record type 'U' in member table
--------------------------------------------------------
PROCEDURE SP_UPDATE_MEMBER
	(I_TBL_MEM	IN TYP_MEMBER)
IS
BEGIN
	FOR i IN I_TBL_MEM.FIRST.. I_TBL_MEM.LAST LOOP
		UPDATE BIZFLOW.MEMBER
		SET NAME =		CASE 
								WHEN I_TBL_MEM(i).NAME IS NOT NULL THEN I_TBL_MEM(i).NAME
								ELSE NAME
							END,
			EMAIL =		CASE 
								WHEN I_TBL_MEM(i).EMAIL IS NOT NULL THEN I_TBL_MEM(i).EMAIL
								ELSE EMAIL
							END,
			LOGINID =	CASE 
								WHEN I_TBL_MEM(i).LOGINID IS NOT NULL THEN I_TBL_MEM(i).LOGINID
								ELSE LOGINID
							END,
			STATE =		CASE 
								WHEN I_TBL_MEM(i).STATE IS NOT NULL THEN I_TBL_MEM(i).STATE
								ELSE STATE
							END,
			SHORTNAME = CASE 
								WHEN I_TBL_MEM(i).SHORTNAME IS NOT NULL THEN I_TBL_MEM(i).SHORTNAME
								ELSE SHORTNAME
							END					
		WHERE MEMBERID = I_TBL_MEM(i).MEMBERID;
	END LOOP;
END;

--------------------------------------------------------
--PROCEDURE: SP_CHECK_MEMBER
--DESCRIPTION: Checks if member records should be updated
--------------------------------------------------------
PROCEDURE SP_CHECK_MEMBER
	(I_REC_STG 	   IN CUR_MEMBERSTG%ROWTYPE,
	 I_REC_USERS   IN CUR_USERS%ROWTYPE,
	 IO_TBL_MEM		IN OUT TYP_MEMBER,
	 IO_TBL_HST		IN OUT TYP_MEMBERHISTORY)
IS
	V_REC_MEM	BIZFLOW.MEMBER%ROWTYPE;
	V_REC_HST	MEMBERHISTORY%ROWTYPE;
	V_LOGINID	BIZFLOW.MEMBER.LOGINID%TYPE;
BEGIN

	IF I_REC_USERS.HHSID = I_REC_STG.HHSID AND I_REC_USERS.STATE = GCV_ACTIVE_STATE THEN

		V_LOGINID := SUBSTR(I_REC_STG.EMAIL, 1, 100);
		
		--Check if member name changed
		IF (I_REC_USERS.NAME != I_REC_STG.NAME) THEN
         V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.NAME       := I_REC_STG.NAME;
			V_REC_MEM.SHORTNAME  := SUBSTR(I_REC_STG.NAME, 1, 30);

			V_REC_HST.HISTORYID		:= MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE    := SYSDATE;
			V_REC_HST.MEMBERID		:= V_REC_MEM.MEMBERID;
			V_REC_HST.HHSID			:= I_REC_STG.HHSID;
			V_REC_HST.DMLTYPE		   := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED	:= GCV_NAME;
			V_REC_HST.OLDVALUE		:= I_REC_USERS.NAME;
			V_REC_HST.NEWVALUE		:= V_REC_MEM.NAME;
			
			IO_TBL_HST(IO_TBL_HST.COUNT) := V_REC_HST;		
		END IF;		
		--Check if member email changed
		IF (I_REC_USERS.EMAIL != SUBSTR(I_REC_STG.EMAIL, 1, 100)) THEN
         V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.EMAIL      := SUBSTR(I_REC_STG.EMAIL, 1, 100);
							
			V_REC_HST.HISTORYID		:= MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE	   := SYSDATE;
			V_REC_HST.MEMBERID		:= V_REC_MEM.MEMBERID;				
			V_REC_HST.HHSID			:= I_REC_STG.HHSID;
			V_REC_HST.DMLTYPE		   := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED	:= GCV_EMAIL;
			V_REC_HST.OLDVALUE		:= I_REC_USERS.EMAIL;
			V_REC_HST.NEWVALUE		:= V_REC_MEM.EMAIL;
			
			IO_TBL_HST(IO_TBL_HST.COUNT) := V_REC_HST;	
		END IF;
		---Check if member loginid changed
		IF (I_REC_USERS.LOGINID != V_LOGINID) THEN
         V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.LOGINID    := V_LOGINID;
			
			V_REC_HST.HISTORYID		:= MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE	   := SYSDATE;
			V_REC_HST.MEMBERID		:= V_REC_MEM.MEMBERID;				
			V_REC_HST.HHSID			:= I_REC_STG.HHSID;
			V_REC_HST.DMLTYPE		   := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED	:= GCV_LOGINID;
			V_REC_HST.OLDVALUE		:= I_REC_USERS.LOGINID;
			V_REC_HST.NEWVALUE		:= V_REC_MEM.LOGINID;
			
			IO_TBL_HST(IO_TBL_HST.COUNT)	:= V_REC_HST;	
		END IF;
		--Check if member active status changed
		IF I_REC_STG.ACTIVEIND = GCV_INACTIVE_IND THEN
         V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.STATE      := GCV_INACTIVE_STATE;
				
			V_REC_HST.HISTORYID		:= MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE	   := SYSDATE;
			V_REC_HST.MEMBERID		:= V_REC_MEM.MEMBERID;				
			V_REC_HST.HHSID			:= I_REC_STG.HHSID;
			V_REC_HST.DMLTYPE		   := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED	:= GCV_STATE;
			V_REC_HST.OLDVALUE		:= I_REC_USERS.STATE;
			V_REC_HST.NEWVALUE		:= V_REC_MEM.STATE;
			
			IO_TBL_HST(IO_TBL_HST.COUNT)	:= V_REC_HST;
		END IF;			
	END IF;
	
		IO_TBL_MEM(IO_TBL_MEM.COUNT) := V_REC_MEM;
END;


--------------------------------------------------------
--PROCEDURE: SP_INACTIVATE_MEMBER
--DESCRIPTION: There is an existing member, but it is 
-- no longer active on the staging table. Inactive the member
-- record
--------------------------------------------------------
PROCEDURE SP_INACTIVATE_MEMBER
	(I_REC_USERS 	IN CUR_USERS%ROWTYPE,
	 O_REC_MEM		OUT BIZFLOW.MEMBER%ROWTYPE,
	 O_REC_HST		OUT MEMBERHISTORY%ROWTYPE)
IS
BEGIN

	--Change member active status to inactive
	O_REC_MEM.MEMBERID	:= I_REC_USERS.MEMBERID;
	O_REC_MEM.STATE 		:= GCV_INACTIVE_STATE;
			
	O_REC_HST.HISTORYID	   := MEMBERHISTORY_SEQ.NEXTVAL;
	O_REC_HST.CHANGEDATE	   := SYSDATE;
	O_REC_HST.MEMBERID	   := I_REC_USERS.MEMBERID;				
	O_REC_HST.HHSID		   := I_REC_USERS.HHSID;
	O_REC_HST.DMLTYPE		   := GCV_UPDATE;
	O_REC_HST.FIELDCHANGED	:= GCV_STATE;
	O_REC_HST.OLDVALUE		:= I_REC_USERS.STATE;
	O_REC_HST.NEWVALUE		:= O_REC_MEM.STATE ;

END;


--------------------------------------------------------
--PROCEDURE: SP_PROCESS_MEMBER
--DESCRIPTION:
--------------------------------------------------------
PROCEDURE SP_PROCESS_MEMBER
	(I_TBL_STG 	      IN TYP_MEMBERSTG,
	 I_TBL_USERS 		IN TYP_USERS)
IS
	V_TBL_INS_MEM		TYP_MEMBER;
	V_TBL_UPDT_MEM		TYP_MEMBER;	
	V_TBL_INFO	      TYP_MEMBERINFO;
	V_TBL_HST			TYP_MEMBERHISTORY;	
	V_TBL_USR_CACHE	TYP_USERS_CACHE;
	V_TBL_INS_CACHE	TYP_USERS_CACHE;
	V_NEWID				BIZFLOW.MEMBER.MEMBERID%TYPE;
	V_MEMBERID			BIZFLOW.MEMBER.MEMBERID%TYPE;
	V_REC_MEM		   BIZFLOW.MEMBER%ROWTYPE;
	V_REC_HST		   MEMBERHISTORY%ROWTYPE;
	V_MEM_IDX 			NUMBER;
	V_INFO_IDX 			NUMBER;
	V_HST_IDX 		   NUMBER;
BEGIN
	IF I_TBL_USERS.COUNT > 0 THEN 
		FOR j IN I_TBL_USERS.FIRST.. I_TBL_USERS.LAST LOOP
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).LOGINID 		 	   := I_TBL_USERS(j).LOGINID;
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).NAME 		 		   := I_TBL_USERS(j).NAME;
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).EMAIL 		 		   := I_TBL_USERS(j).EMAIL;
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).MEMBERID	 		   := I_TBL_USERS(j).MEMBERID;
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).DEPTNAME	 		   := I_TBL_USERS(j).DEPTNAME;
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).STATE 		 		   := I_TBL_USERS(j).STATE;
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).HHSID 		 		   := I_TBL_USERS(j).HHSID;
			V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).ACTV_STG_REC_IND   := I_TBL_USERS(j).ACTV_STG_REC_IND;

			--Check if there is an active member record that is not on the staging table
			IF I_TBL_USERS(j).ACTV_STG_REC_IND = GCV_INACTIVE_IND AND I_TBL_USERS(j).STATE = GCV_ACTIVE_STATE THEN 
				SP_INACTIVATE_MEMBER(I_TBL_USERS(j), V_REC_MEM, V_REC_HST);
				--Adds records into a collection
				V_TBL_UPDT_MEM(V_TBL_UPDT_MEM.COUNT)   := V_REC_MEM;
				V_TBL_HST(V_TBL_HST.COUNT) 		      := V_REC_HST;
			END IF;			
		END LOOP;
	END IF;

	FOR i IN I_TBL_STG.FIRST..I_TBL_STG.LAST LOOP
		IF V_TBL_USR_CACHE.COUNT > 0 
		AND V_TBL_USR_CACHE.EXISTS(I_TBL_STG(i).HHSID) THEN
			--Member record already exists for employee
			--Create collections to update member
			SP_CHECK_MEMBER(I_TBL_STG(i), V_TBL_USR_CACHE(I_TBL_STG(i).HHSID), V_TBL_UPDT_MEM, V_TBL_HST);
		
		ELSIF I_TBL_STG(i).ACTIVEIND = GCV_ACTIVE_IND
		AND NOT V_TBL_INS_CACHE.EXISTS(I_TBL_STG(i).HHSID) THEN
			--Member record does not exist for active employee; A new record will be inserted into the MEMBER table
			-- Generate ID for new user
			BIZFLOW.SP_GET_ID(GCV_SVRID, 'MemberID', 1, V_NEWID);
			V_MEMBERID	:= LPAD(TO_CHAR(V_NEWID), 10, '0');
			
			V_MEM_IDX 	:= V_TBL_INS_MEM.COUNT;
			V_INFO_IDX 	:= V_TBL_INFO.COUNT;
			V_HST_IDX	:= V_TBL_HST.COUNT;
			
			--Create collection to insert into member
			V_TBL_INS_MEM(V_MEM_IDX).MEMBERID   := V_MEMBERID;
			V_TBL_INS_MEM(V_MEM_IDX).TYPE			:= GCV_TYPE_USER;
			V_TBL_INS_MEM(V_MEM_IDX).STATE		:= GCV_ACTIVE_STATE;
			V_TBL_INS_MEM(V_MEM_IDX).NAME       := SUBSTR(I_TBL_STG(i).NAME, 1, 100);
			V_TBL_INS_MEM(V_MEM_IDX).LOGINID    := SUBSTR(I_TBL_STG(i).EMAIL, 1, 100);
			V_TBL_INS_MEM(V_MEM_IDX).SVRID      := GCV_SVRID;
			V_TBL_INS_MEM(V_MEM_IDX).DEPTID     := CASE  --Edit case statement when adding additional agencies
                                                   WHEN I_TBL_STG(i).DEPTNAME = GCV_CMS 
                                                   THEN GV_CMS_DEPTID
                                                END;
			V_TBL_INS_MEM(V_MEM_IDX).DEPTNAME   := CASE  --Edit case statement when adding additional agencies
                                                   WHEN I_TBL_STG(i).DEPTNAME = GCV_CMS 
                                                   THEN GCV_CMS_OU
                                                END; 
			V_TBL_INS_MEM(V_MEM_IDX).SHORTNAME  := SUBSTR(I_TBL_STG(i).NAME, 1, 30);
			V_TBL_INS_MEM(V_MEM_IDX).EMAIL      := SUBSTR(I_TBL_STG(i).EMAIL, 1, 100);
			V_TBL_INS_MEM(V_MEM_IDX).MANAGERID	:= GCV_MANAGERID;	
			V_TBL_INS_MEM(V_MEM_IDX).PASSWD     := CASE  --Edit case statement when adding additional agencies
                                                   WHEN I_TBL_STG(i).DEPTNAME = GCV_CMS 
                                                   THEN GCV_CMS_PASSWD
                                                END;	
			
			--Create collection to insert into memberinfo
			V_TBL_INFO(V_INFO_IDX).MEMBERID	:= V_MEMBERID;
			V_TBL_INFO(V_INFO_IDX).CUSTOMB 	:= I_TBL_STG(i).HHSID;
			
			--Create collection to insert into memberhistory
			V_TBL_HST(V_HST_IDX).HISTORYID	:= MEMBERHISTORY_SEQ.NEXTVAL;
			V_TBL_HST(V_HST_IDX).CHANGEDATE	:= SYSDATE;
			V_TBL_HST(V_HST_IDX).MEMBERID		:= V_MEMBERID;
			V_TBL_HST(V_HST_IDX).HHSID			:= I_TBL_STG(i).HHSID;
			V_TBL_HST(V_HST_IDX).DMLTYPE		:= GCV_INSERT;
			
			--Add collection to insert cache to prevent duplicate inserted entries
			V_TBL_INS_CACHE(V_TBL_INFO(V_INFO_IDX).CUSTOMB).HHSID := V_TBL_INFO(V_INFO_IDX).CUSTOMB;
			
		END IF;
	END LOOP;	

	--Update member records
	IF V_TBL_UPDT_MEM.COUNT > 0 THEN 
		SP_UPDATE_MEMBER(V_TBL_UPDT_MEM);
	END IF;
	
	--Insert new member records
	IF V_TBL_INS_MEM.COUNT > 0 THEN
		SP_INSERT_MEMBER(V_TBL_INS_MEM);
		SP_INSERT_MEMBERINFO(V_TBL_INFO);
	END IF;

	--Insert memberhistory records
	IF V_TBL_HST.COUNT > 0 THEN 
		SP_INSERT_MEMBERHISTORY(V_TBL_HST);	
	END  IF;
	
END;

--------------------------------------------------------
--PROCEDURE: SP_CLEAR_MEMBERSTG
--DESCRIPTION: Truncates the memberstg table
--------------------------------------------------------
PROCEDURE SP_CLEAR_MEMBERSTG
IS
BEGIN
	EXECUTE IMMEDIATE 'TRUNCATE TABLE MEMBERSTG';
END;

--======================================================
--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -

--FUNCTIONS

--	- - -	- - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
--------------------------------------------------------                            
--FUNCTION: FN_PROCESS_STG_TO_FNL
--DESCRIPTION:
--------------------------------------------------------
FUNCTION FN_PROCESS_STG_TO_FNL
	(O_ERRMSG		OUT VARCHAR2)
RETURN NUMBER
IS
	V_TBL_STG   TYP_MEMBERSTG;
	V_TBL_USERS TYP_USERS;
BEGIN

	SP_INITALIZE; 

	--Fetch existing user records
	BEGIN 
		OPEN CUR_USERS;
		FETCH CUR_USERS
		BULK COLLECT INTO V_TBL_USERS;
		CLOSE CUR_USERS;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN 
			NULL;
	END;
	
	BEGIN 
		--Fetch records from memberstg table
		OPEN CUR_MEMBERSTG;
		FETCH CUR_MEMBERSTG
		BULK COLLECT INTO V_TBL_STG;
		CLOSE CUR_MEMBERSTG;

		IF V_TBL_STG.COUNT = 0 THEN 
			RAISE NO_DATA_FOUND;
		END IF;
		
	END;

	IF V_TBL_STG.COUNT > 0 THEN
		SP_PROCESS_MEMBER(V_TBL_STG, V_TBL_USERS);
	END IF;
	
	SP_CLEAR_MEMBERSTG;

	O_ERRMSG := SQLERRM || ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE;
	COMMIT;
	RETURN SQLCODE;
EXCEPTION
	WHEN OTHERS THEN
		ROLLBACK;
		O_ERRMSG := SQLERRM || ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE;
		RETURN SQLCODE;
END;

END MEMBER_STG_TO_FNL;
/