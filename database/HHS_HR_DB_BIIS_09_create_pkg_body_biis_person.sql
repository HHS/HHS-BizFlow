CREATE OR REPLACE PACKAGE BODY HHS_HR.BIIS_PERSON AS

--======================================================
--  - - -   - - - - - - - - - - - - - - - - - - - - - - 

--GLOBAL VARIABLES

--- -  -  -- - - - - - - - - - - - - - - - - - - - - - -
--======================================================
GCV_UPDATE              CONSTANT MEMBERHISTORY.DMLTYPE%TYPE         := 'UPDATE';
GCV_INSERT              CONSTANT MEMBERHISTORY.DMLTYPE%TYPE         := 'INSERT';
GCV_YES                 CONSTANT VARCHAR2(1)                        := 'Y';
GCV_NO                  CONSTANT VARCHAR2(1)                        := 'N';
GCV_ACTIVE_STATE        CONSTANT BIZFLOW.MEMBER.STATE%TYPE          := 'N';
GCV_INACTIVE_STATE      CONSTANT BIZFLOW.MEMBER.STATE%TYPE          := 'D';
GCV_TYPE_USER           CONSTANT BIZFLOW.MEMBER.TYPE%TYPE           := 'U';
GCV_TYPE_OU             CONSTANT BIZFLOW.MEMBER.TYPE%TYPE           := 'D';
GCV_SVRID               CONSTANT BIZFLOW.MEMBER.SVRID%TYPE          := '0000001001';
GCV_MANAGERID           CONSTANT BIZFLOW.MEMBER.MANAGERID%TYPE      := '0000000000';
GCV_NAME                CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE    := 'NAME';
GCV_EMAIL               CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE    := 'EMAIL';
GCV_LOGINID             CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE    := 'LOGINID';
GCV_STATE               CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE    := 'STATE';
GCV_SHORTNAME           CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE    := 'SHORTNAME';
GCV_DEPTNAME            CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE    := 'DEPTNAME';
GCV_DEPTID              CONSTANT MEMBERHISTORY.FIELDCHANGED%TYPE    := 'DEPTID';
GCV_CMS                 CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'CMS';
GCV_CMS_OU              CONSTANT BIZFLOW.MEMBER.DEPTNAME%TYPE       := 'CMS';
GCV_CMS_PASSWD          CONSTANT BIZFLOW.MEMBER.PASSWD%TYPE         := '231031242161138254069026166039124217216115131073';
GCV_CDC                 CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'CDC';
GCV_CDC_OU              CONSTANT BIZFLOW.MEMBER.DEPTNAME%TYPE       := 'CDC';
GCV_CDC_PASSWD          CONSTANT BIZFLOW.MEMBER.PASSWD%TYPE         := '250046180195211242149111169103065116020120153105';
GCV_IHS                 CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'IHS';
GCV_IHS_OU              CONSTANT BIZFLOW.MEMBER.DEPTNAME%TYPE       := 'IHS';
GCV_IHS_PASSWD          CONSTANT BIZFLOW.MEMBER.PASSWD%TYPE         := '095008053220033074048054222060025038040075187098';
GCV_OS                  CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'OS';
GCV_ACF                 CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'ACF';
GCV_ACL                 CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'ACL';
GCV_AHRQ                CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'AHRQ';
GCV_PSC                 CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'PSC';
GCV_SAMHSA              CONSTANT MEMBERSTG.DEPTNAME%TYPE            := 'SAMHSA';
GCV_WHRSC_OU            CONSTANT BIZFLOW.MEMBER.DEPTNAME%TYPE       := 'WHRSC';
GCV_WHRSC_PASSWD        CONSTANT BIZFLOW.MEMBER.PASSWD%TYPE         := '218116209099033239051251169139045111151098037236';

GV_CMS_DEPTID           BIZFLOW.MEMBER.DEPTID%TYPE;
GV_CDC_DEPTID           BIZFLOW.MEMBER.DEPTID%TYPE;
GV_IHS_DEPTID           BIZFLOW.MEMBER.DEPTID%TYPE;
GV_WHRSC_DEPTID         BIZFLOW.MEMBER.DEPTID%TYPE;

--======================================================
--  - - - - - - - - - - - - - - - - - - - - - - - - - - -

--PROCEDURES

--  - - -   - - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
--------------------------------------------------------
--PROCEDURE: SP_INITALIZE
--DESCRIPTION: Initalize global variables in the program
--------------------------------------------------------
PROCEDURE SP_INITALIZE
IS
BEGIN

	BEGIN
		SELECT MEMBERID
		INTO GV_CMS_DEPTID
		FROM BIZFLOW.MEMBER
		WHERE TYPE = GCV_TYPE_OU
			AND STATE = GCV_ACTIVE_STATE
			AND NAME = GCV_CMS_OU;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			NULL;
	END;

	BEGIN
		SELECT MEMBERID
		INTO GV_CDC_DEPTID
		FROM BIZFLOW.MEMBER
		WHERE TYPE = GCV_TYPE_OU
			AND STATE = GCV_ACTIVE_STATE
			AND NAME = GCV_CDC_OU;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			NULL;
	END;

	BEGIN
		SELECT MEMBERID
		INTO GV_IHS_DEPTID
		FROM BIZFLOW.MEMBER
		WHERE TYPE = GCV_TYPE_OU
			AND STATE = GCV_ACTIVE_STATE
			AND NAME = GCV_IHS_OU;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			NULL;
	END;

	BEGIN
		SELECT MEMBERID
		INTO GV_WHRSC_DEPTID
		FROM BIZFLOW.MEMBER
		WHERE TYPE = GCV_TYPE_OU
			AND STATE = GCV_ACTIVE_STATE
			AND NAME = GCV_WHRSC_OU;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			NULL;
	END;

END;

--------------------------------------------------------
--PROCEDURE: SP_LOGGER
--DESCRIPTION: Procedure to log bulk errors to error_log 
--             table, thrown during forall bulk insert.
--------------------------------------------------------
PROCEDURE SP_LOGGER
AS
	V_ERR PLS_INTEGER;
	V_MSG VARCHAR2(32767);
BEGIN
	FOR CODE IN 1..SQL%BULK_EXCEPTIONS.COUNT LOOP
		V_ERR := SQL%BULK_EXCEPTIONS(CODE).ERROR_CODE;
		V_MSG := SQLERRM(V_ERR);
		SP_INTERFACE_ERROR_LOGGER(V_ERR,V_MSG);
	END LOOP;
END;

--------------------------------------------------------
--PROCEDURE: SP_SINGLE_LOGGER
--DESCRIPTION: Procedure to log all errors at once
--------------------------------------------------------
PROCEDURE SP_SINGLE_LOGGER
AS
BEGIN
	IF SQLCODE = -24381 THEN -- bulk error thrown by FORALL insert
		SP_LOGGER();
	ELSE --anything else
		SP_ERROR_LOG();
	END IF;
END;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_EMPLOYEE_LOOKUP
--DESCRIPTION: Insert new records into EMPLOYEE_LOOKUP table
--------------------------------------------------------
PROCEDURE SP_INSERT_EMPLOYEE_LOOKUP
	(I_TBL_EMP  IN TYPE_EMP_LOOKUP)
IS
BEGIN
	EXECUTE IMMEDIATE 'TRUNCATE TABLE EMPLOYEE_LOOKUP';
		FORALL i IN I_TBL_EMP.FIRST.. I_TBL_EMP.LAST SAVE EXCEPTIONS
		INSERT INTO EMPLOYEE_LOOKUP VALUES I_TBL_EMP(i);
EXCEPTION
	WHEN OTHERS THEN
		SP_SINGLE_LOGGER();
END;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERSTG
--DESCRIPTION: Insert new records into memberstg table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERSTG
	(I_TBL_STG  IN TYP_MEMBERSTG)
IS
BEGIN
	FORALL i IN I_TBL_STG.FIRST.. I_TBL_STG.LAST SAVE EXCEPTIONS
		INSERT INTO MEMBERSTG VALUES I_TBL_STG(i);
EXCEPTION
	WHEN OTHERS THEN
		SP_SINGLE_LOGGER();
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
		BEGIN
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
		EXCEPTION
			WHEN OTHERS THEN
				SP_ERROR_LOG();
		END;
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
		BEGIN
			INSERT INTO BIZFLOW.MEMBERINFO
				(MEMBERID,
				CUSTOMB)
			VALUES
				(I_TBL_INFO(i).MEMBERID,
				I_TBL_INFO(i).CUSTOMB);
		EXCEPTION
			WHEN OTHERS THEN
				SP_ERROR_LOG();
		END;
	END LOOP;
END;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_MEMBERHISTORY
--DESCRIPTION: Insert new records into memberhistory table
--------------------------------------------------------
PROCEDURE SP_INSERT_MEMBERHISTORY
	(I_TBL_HST  IN TYP_MEMBERHISTORY)
IS
BEGIN
	FORALL i IN I_TBL_HST.FIRST.. I_TBL_HST.LAST SAVE EXCEPTIONS
		INSERT INTO MEMBERHISTORY VALUES I_TBL_HST(i);
EXCEPTION
	WHEN OTHERS THEN
		SP_SINGLE_LOGGER();
END;

--------------------------------------------------------
--PROCEDURE: SP_UPDATE_MEMBERINFO
--DESCRIPTION: Update existing MEMBERINFO record with HHSID
--------------------------------------------------------
PROCEDURE SP_UPDATE_MEMBERINFO
	(I_TBL_INFO  IN TYP_MEMBERINFO)
IS
BEGIN
	FOR i IN I_TBL_INFO.FIRST.. I_TBL_INFO.LAST LOOP
		BEGIN
			UPDATE BIZFLOW.MEMBERINFO
			SET CUSTOMB = I_TBL_INFO(i).CUSTOMB
			WHERE MEMBERID = I_TBL_INFO(i).MEMBERID;
		EXCEPTION
			WHEN OTHERS THEN
				SP_ERROR_LOG();
		END;
	END LOOP;
END;

--------------------------------------------------------
--PROCEDURE: SP_UPDATE_MEMBER
--DESCRIPTION: Update record type 'U' in member table
--------------------------------------------------------
PROCEDURE SP_UPDATE_MEMBER
    (I_TBL_MEM  IN TYP_MEMBER)
IS
BEGIN
	FOR i IN I_TBL_MEM.FIRST.. I_TBL_MEM.LAST LOOP
		BEGIN
			UPDATE BIZFLOW.MEMBER
			SET NAME =      CASE
								WHEN I_TBL_MEM(i).NAME IS NOT NULL THEN I_TBL_MEM(i).NAME
								ELSE NAME
							END,
				EMAIL =     CASE
								WHEN I_TBL_MEM(i).EMAIL IS NOT NULL THEN I_TBL_MEM(i).EMAIL
								ELSE EMAIL
							END,
				LOGINID =   CASE
								WHEN I_TBL_MEM(i).LOGINID IS NOT NULL THEN I_TBL_MEM(i).LOGINID
								ELSE LOGINID
							END,
				SHORTNAME = CASE
								WHEN I_TBL_MEM(i).SHORTNAME IS NOT NULL THEN I_TBL_MEM(i).SHORTNAME
								ELSE SHORTNAME
							END,
				DEPTNAME =  CASE
								WHEN I_TBL_MEM(i).DEPTNAME IS NOT NULL THEN I_TBL_MEM(i).DEPTNAME
								ELSE DEPTNAME
							END,
				DEPTID =    CASE
								WHEN I_TBL_MEM(i).DEPTID IS NOT NULL THEN I_TBL_MEM(i).DEPTID
								ELSE DEPTID
							END
			WHERE MEMBERID = I_TBL_MEM(i).MEMBERID;
		EXCEPTION
			WHEN OTHERS THEN
				SP_ERROR_LOG();
		END;
	END LOOP;
END;

--------------------------------------------------------
--PROCEDURE: SP_INSERT_BIIS_DATA
--DESCRIPTION: Insert BIIS data onto member staging table
-- and employee lookup table
--------------------------------------------------------
PROCEDURE SP_INSERT_BIIS_DATA
	(I_TBL_BIIS     IN TYP_BIIS_PERSON)
IS
	V_TBL_MEM   TYP_MEMBERSTG;
	V_TBL_EMP   TYPE_EMP_LOOKUP;
BEGIN

	FOR i IN I_TBL_BIIS.FIRST .. I_TBL_BIIS.LAST LOOP
		--Add records to memberstg collection
		IF I_TBL_BIIS(i).EMP_STATUS_FROM_PERS_SYSTEM = 'Active' THEN
            V_TBL_MEM(i).HHSID          := I_TBL_BIIS(i).HHSID;
            V_TBL_MEM(i).FIRSTNAME      := I_TBL_BIIS(i).FIRST_NAME;
            V_TBL_MEM(i).MIDDLENAME     := I_TBL_BIIS(i).MIDDLE_NAME;
            V_TBL_MEM(i).LASTNAME       := I_TBL_BIIS(i).LAST_NAME;
            V_TBL_MEM(i).EMAIL          := I_TBL_BIIS(i).EMAIL_ADDR;
            V_TBL_MEM(i).DEPTNAME       := I_TBL_BIIS(i).OPDIV;
            V_TBL_MEM(i).LASTUPDATE     := I_TBL_BIIS(i).LAST_UPDT_FROM_PERS_SYSTEM_DT;
		END IF;
		
		--Add records to employee lookup collection
		V_TBL_EMP(i).LAST_NAME                      := I_TBL_BIIS(i).LAST_NAME;
		V_TBL_EMP(i).FIRST_NAME                     := I_TBL_BIIS(i).FIRST_NAME;
		V_TBL_EMP(i).MIDDLE_NAME                    := I_TBL_BIIS(i).MIDDLE_NAME;
		V_TBL_EMP(i).EMAIL_ADDR                     := I_TBL_BIIS(i).EMAIL_ADDR;
		V_TBL_EMP(i).HHSID                          := I_TBL_BIIS(i).HHSID;
		V_TBL_EMP(i).USERTYPE                       := I_TBL_BIIS(i).USERTYPE;
		V_TBL_EMP(i).PIV_CARD_STATUS                := I_TBL_BIIS(i).PIV_CARD_STATUS;
		V_TBL_EMP(i).SCMS_STATUS                    := I_TBL_BIIS(i).SCMS_STATUS;
		V_TBL_EMP(i).EMPLID                         := I_TBL_BIIS(i).EMPLID;
		V_TBL_EMP(i).PAY_PLAN                       := I_TBL_BIIS(i).PAY_PLAN;
		V_TBL_EMP(i).GRADE                          := I_TBL_BIIS(i).GRADE;
		V_TBL_EMP(i).POSITION_TITLE_NAME            := I_TBL_BIIS(i).POSITION_TITLE_NAME;
		V_TBL_EMP(i).SERIES                         := I_TBL_BIIS(i).SERIES;
		V_TBL_EMP(i).BARG_UNIT                      := I_TBL_BIIS(i).BARG_UNIT;
		V_TBL_EMP(i).OPDIV                          := I_TBL_BIIS(i).OPDIV;
		V_TBL_EMP(i).ORG_CD                         := I_TBL_BIIS(i).ORG_CD;
		V_TBL_EMP(i).PAY_BASIS                      := I_TBL_BIIS(i).PAY_BASIS;
		V_TBL_EMP(i).STEP                           := I_TBL_BIIS(i).STEP;
		V_TBL_EMP(i).BASIC_PAY                      := I_TBL_BIIS(i).BASIC_PAY;
		V_TBL_EMP(i).ADJ_BASIC_PAY                  := I_TBL_BIIS(i).ADJ_BASIC_PAY;
		V_TBL_EMP(i).CAN_CD                         := I_TBL_BIIS(i).CAN_CD;
		V_TBL_EMP(i).JOB_CODE                       := I_TBL_BIIS(i).JOB_CODE;
		V_TBL_EMP(i).POSITION_NUM                   := I_TBL_BIIS(i).POSITION_NUM;
		V_TBL_EMP(i).EMP_STATUS_FROM_PERS_SYSTEM    := I_TBL_BIIS(i).EMP_STATUS_FROM_PERS_SYSTEM;
		V_TBL_EMP(i).LAST_UPDT_FROM_PERS_SYSTEM_DT  := I_TBL_BIIS(i).LAST_UPDT_FROM_PERS_SYSTEM_DT;
		V_TBL_EMP(i).FULL_NAME                      := UPPER(I_TBL_BIIS(i).LAST_NAME) || ', ' || UPPER(I_TBL_BIIS(i).FIRST_NAME); 
	
	END LOOP;

	--Insert records to MEMBERSTG
	IF V_TBL_MEM.COUNT > 0 THEN
		SP_INSERT_MEMBERSTG(V_TBL_MEM);
	END IF;

	--Insert records to EMPLOYEE_LOOKUP
	IF V_TBL_EMP.COUNT > 0 THEN
		SP_INSERT_EMPLOYEE_LOOKUP(V_TBL_EMP);
	END IF;

END;

--------------------------------------------------------
--PROCEDURE: SP_CHECK_MEMBER
--DESCRIPTION: Checks if member records should be updated
--------------------------------------------------------
PROCEDURE SP_CHECK_MEMBER
	(I_REC_STG      IN CUR_MEMBERSTG%ROWTYPE,
	I_REC_USERS     IN CUR_USERS%ROWTYPE,
	IO_TBL_MEM      IN OUT TYP_MEMBER,
	IO_TBL_HST      IN OUT TYP_MEMBERHISTORY)
IS
	V_REC_MEM   BIZFLOW.MEMBER%ROWTYPE;
	V_REC_HST   MEMBERHISTORY%ROWTYPE;
	V_DEPTNAME  MEMBERHISTORY.OPDIV%TYPE;
BEGIN

	IF I_REC_USERS.HHSID = I_REC_STG.HHSID AND I_REC_USERS.STATE = GCV_ACTIVE_STATE
		AND I_REC_USERS.DEPTNAME IN (GCV_CMS_OU, GCV_CDC_OU, GCV_IHS_OU, GCV_WHRSC_OU) THEN

		V_DEPTNAME :=   CASE
							WHEN I_REC_STG.DEPTNAME IN (GCV_OS,GCV_ACF,GCV_ACL,GCV_AHRQ,GCV_PSC,GCV_SAMHSA)
							THEN GCV_WHRSC_OU
							ELSE I_REC_STG.DEPTNAME
						END;
	
		--Check if member name changed
		IF (I_REC_USERS.NAME != SUBSTR(I_REC_STG.LASTNAME || ', ' || I_REC_STG.FIRSTNAME || ' ' || SUBSTR(I_REC_STG.MIDDLENAME, 0, 1), 1, 100)) THEN
			V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.NAME       := SUBSTR(I_REC_STG.LASTNAME || ', ' || I_REC_STG.FIRSTNAME || ' ' || SUBSTR(I_REC_STG.MIDDLENAME, 0, 1), 1, 100);

			V_REC_MEM.SHORTNAME  := SUBSTR(I_REC_STG.LASTNAME || ', ' || I_REC_STG.FIRSTNAME || ' ' || SUBSTR(I_REC_STG.MIDDLENAME, 0, 1), 1, 30);

			V_REC_HST.HISTORYID     := MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE    := SYSDATE;
			V_REC_HST.MEMBERID      := V_REC_MEM.MEMBERID;
			V_REC_HST.HHSID         := I_REC_STG.HHSID;
			V_REC_HST.OPDIV         := V_DEPTNAME;
			V_REC_HST.DMLTYPE       := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED  := GCV_NAME;
			V_REC_HST.OLDVALUE      := I_REC_USERS.NAME;
			V_REC_HST.NEWVALUE      := V_REC_MEM.NAME;

			IO_TBL_HST(IO_TBL_HST.COUNT) := V_REC_HST;

			V_REC_HST.HISTORYID     := MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE    := SYSDATE;
			V_REC_HST.MEMBERID      := V_REC_MEM.MEMBERID;
			V_REC_HST.HHSID         := I_REC_STG.HHSID;
			V_REC_HST.OPDIV         := V_DEPTNAME;
			V_REC_HST.DMLTYPE       := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED  := GCV_SHORTNAME;
			V_REC_HST.OLDVALUE      := I_REC_USERS.SHORTNAME;
			V_REC_HST.NEWVALUE      := V_REC_MEM.SHORTNAME;

			IO_TBL_HST(IO_TBL_HST.COUNT) := V_REC_HST;

		END IF;
		--Check if member email changed
		IF (I_REC_USERS.EMAIL != SUBSTR(I_REC_STG.EMAIL, 1, 100)) THEN
			V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.EMAIL      := SUBSTR(I_REC_STG.EMAIL, 1, 100);
		
			V_REC_HST.HISTORYID     := MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE    := SYSDATE;
			V_REC_HST.MEMBERID      := V_REC_MEM.MEMBERID;
			V_REC_HST.HHSID         := I_REC_STG.HHSID;
			V_REC_HST.OPDIV         := V_DEPTNAME;
			V_REC_HST.DMLTYPE       := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED  := GCV_EMAIL;
			V_REC_HST.OLDVALUE      := I_REC_USERS.EMAIL;
			V_REC_HST.NEWVALUE      := V_REC_MEM.EMAIL;
		
			IO_TBL_HST(IO_TBL_HST.COUNT) := V_REC_HST;
		END IF;
		--Check if member loginid changed
		IF (I_REC_USERS.LOGINID != SUBSTR(I_REC_STG.EMAIL, 1, 100)) THEN
			V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.LOGINID    := SUBSTR(I_REC_STG.EMAIL, 1, 100);
		
			V_REC_HST.HISTORYID     := MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE    := SYSDATE;
			V_REC_HST.MEMBERID      := V_REC_MEM.MEMBERID;
			V_REC_HST.HHSID         := I_REC_STG.HHSID;
			V_REC_HST.OPDIV         := V_DEPTNAME;
			V_REC_HST.DMLTYPE       := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED  := GCV_LOGINID;
			V_REC_HST.OLDVALUE      := I_REC_USERS.LOGINID;
			V_REC_HST.NEWVALUE      := V_REC_MEM.LOGINID;
			
			IO_TBL_HST(IO_TBL_HST.COUNT)    := V_REC_HST;
		END IF;
		--Check if member deptname changed
		IF (I_REC_USERS.DEPTNAME != V_DEPTNAME) THEN
			V_REC_MEM.MEMBERID   := I_REC_USERS.MEMBERID;
			V_REC_MEM.DEPTNAME   := V_DEPTNAME;
			V_REC_MEM.DEPTID     := CASE
										WHEN I_REC_STG.DEPTNAME = GCV_CMS
										THEN GV_CMS_DEPTID
										WHEN I_REC_STG.DEPTNAME = GCV_CDC
										THEN GV_CDC_DEPTID
										WHEN I_REC_STG.DEPTNAME = GCV_IHS
										THEN GV_IHS_DEPTID
										WHEN I_REC_STG.DEPTNAME IN (GCV_OS,GCV_ACF,GCV_ACL,GCV_AHRQ,GCV_PSC,GCV_SAMHSA)
										THEN GV_WHRSC_DEPTID
									END;
		
			V_REC_HST.HISTORYID     := MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE    := SYSDATE;
			V_REC_HST.MEMBERID      := V_REC_MEM.MEMBERID;
			V_REC_HST.HHSID         := I_REC_STG.HHSID;
			V_REC_HST.OPDIV         := V_DEPTNAME;
			V_REC_HST.DMLTYPE       := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED  := GCV_DEPTNAME;
			V_REC_HST.OLDVALUE      := I_REC_USERS.DEPTNAME;
			V_REC_HST.NEWVALUE      := V_REC_MEM.DEPTNAME;
			
			IO_TBL_HST(IO_TBL_HST.COUNT)    := V_REC_HST;
			
			V_REC_HST.HISTORYID     := MEMBERHISTORY_SEQ.NEXTVAL;
			V_REC_HST.CHANGEDATE    := SYSDATE;
			V_REC_HST.MEMBERID      := V_REC_MEM.MEMBERID;
			V_REC_HST.HHSID         := I_REC_STG.HHSID;
			V_REC_HST.OPDIV         := V_DEPTNAME;
			V_REC_HST.DMLTYPE       := GCV_UPDATE;
			V_REC_HST.FIELDCHANGED  := GCV_DEPTID;
			V_REC_HST.OLDVALUE      := I_REC_USERS.DEPTID;
			V_REC_HST.NEWVALUE      := V_REC_MEM.DEPTID;
			
			IO_TBL_HST(IO_TBL_HST.COUNT)    := V_REC_HST;
		END IF;
	END IF;

	IO_TBL_MEM(IO_TBL_MEM.COUNT) := V_REC_MEM;
END;

--------------------------------------------------------
--PROCEDURE: SP_ADD_HHSID
--DESCRIPTION: Adds HHSID to existing member record
--------------------------------------------------------
PROCEDURE SP_ADD_HHSID
	(I_REC_STG          IN CUR_MEMBERSTG%ROWTYPE,
	I_REC_USERS         IN CUR_USERS%ROWTYPE,
	IO_TBL_INS_INFO     IN OUT TYP_MEMBERINFO,
	IO_TBL_UPDT_INFO    IN OUT TYP_MEMBERINFO)
IS
	V_REC_INFO   BIZFLOW.MEMBERINFO%ROWTYPE;
BEGIN
	--If an existing memberinfo record exists, then add 
	--the HHSID to a collection to update the record
	IF I_REC_USERS.MEMINFO_REC_IND = GCV_YES THEN
		V_REC_INFO.MEMBERID     := I_REC_USERS.MEMBERID;
		V_REC_INFO.CUSTOMB      := I_REC_STG.HHSID;
		
		IO_TBL_UPDT_INFO(IO_TBL_UPDT_INFO.COUNT) := V_REC_INFO;
		
	--If a memberinfo record does not already exist, then a new
	--record will be created with the HHSID
	ELSIF I_REC_USERS.MEMINFO_REC_IND = GCV_NO THEN
		V_REC_INFO.MEMBERID     := I_REC_USERS.MEMBERID;
		V_REC_INFO.CUSTOMB      := I_REC_STG.HHSID;
		
		IO_TBL_INS_INFO(IO_TBL_INS_INFO.COUNT) := V_REC_INFO;
	END IF;

END;

--------------------------------------------------------
--PROCEDURE: SP_INACTIVATE_MEMBER
--DESCRIPTION: There is an existing member, but it is 
-- no longer active on the staging table. Inactive the member
-- record
--------------------------------------------------------
PROCEDURE SP_INACTIVATE_MEMBER
	(I_REC_USERS    IN CUR_USERS%ROWTYPE,
	O_REC_MEM       OUT BIZFLOW.MEMBER%ROWTYPE,
	O_REC_HST       OUT MEMBERHISTORY%ROWTYPE)
IS
BEGIN

	--Change member active status to inactive
	O_REC_MEM.MEMBERID  := I_REC_USERS.MEMBERID;
	O_REC_MEM.STATE     := GCV_INACTIVE_STATE;

	O_REC_HST.HISTORYID     := MEMBERHISTORY_SEQ.NEXTVAL;
	O_REC_HST.CHANGEDATE    := SYSDATE;
	O_REC_HST.MEMBERID      := I_REC_USERS.MEMBERID;
	O_REC_HST.HHSID         := I_REC_USERS.HHSID;
	O_REC_HST.OPDIV         := I_REC_USERS.DEPTNAME;
	O_REC_HST.DMLTYPE       := GCV_UPDATE;
	O_REC_HST.FIELDCHANGED  := GCV_STATE;
	O_REC_HST.OLDVALUE      := I_REC_USERS.STATE;
	O_REC_HST.NEWVALUE      := O_REC_MEM.STATE;

END;

--------------------------------------------------------
--PROCEDURE: SP_PROCESS_MEMBER
--DESCRIPTION:
--------------------------------------------------------
PROCEDURE SP_PROCESS_MEMBER
	(I_TBL_STG          IN TYP_CUR_MEMBERSTG,
	I_TBL_USERS         IN TYP_USERS)
IS
	V_TBL_INS_MEM       TYP_MEMBER;
	V_TBL_UPDT_MEM      TYP_MEMBER;
	V_TBL_INS_INFO      TYP_MEMBERINFO;
	V_TBL_UPDT_INFO     TYP_MEMBERINFO;
	V_TBL_HST           TYP_MEMBERHISTORY;
	V_TBL_USR_CACHE     TYP_USERS_CACHE;
	V_TBL_INS_CACHE     TYP_USERS_CACHE;
	V_TBL_UPDT_CACHE    TYP_USERS_CACHE;
	V_LOGINID_CACHE     TYP_USERS_CACHE;
	V_NEWID             BIZFLOW.MEMBER.MEMBERID%TYPE;
	V_MEMBERID          BIZFLOW.MEMBER.MEMBERID%TYPE;
	V_REC_MEM           BIZFLOW.MEMBER%ROWTYPE;
	V_REC_HST           MEMBERHISTORY%ROWTYPE;
	V_MEM_IDX           NUMBER;
	V_INFO_IDX          NUMBER;
	V_HST_IDX           NUMBER;
BEGIN
	IF I_TBL_USERS.COUNT > 0 THEN
		--Loop through existing members
		FOR j IN I_TBL_USERS.FIRST.. I_TBL_USERS.LAST LOOP
			--Create a cache for existing members, indexed on the HHSID
			IF I_TBL_USERS(j).HHSID IS NOT NULL THEN 
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).LOGINID               := I_TBL_USERS(j).LOGINID;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).NAME                  := I_TBL_USERS(j).NAME;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).SHORTNAME             := I_TBL_USERS(j).SHORTNAME;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).EMAIL                 := I_TBL_USERS(j).EMAIL;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).MEMBERID              := I_TBL_USERS(j).MEMBERID;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).DEPTNAME              := I_TBL_USERS(j).DEPTNAME;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).DEPTID                := I_TBL_USERS(j).DEPTID;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).STATE                 := I_TBL_USERS(j).STATE;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).HHSID                 := I_TBL_USERS(j).HHSID;
				V_TBL_USR_CACHE(I_TBL_USERS(j).HHSID).ACTV_STG_REC_IND      := I_TBL_USERS(j).ACTV_STG_REC_IND;
			END IF;

			--Create a cache collection, indexed on the loginid
			V_LOGINID_CACHE(I_TBL_USERS(j).LOGINID).LOGINID            := I_TBL_USERS(j).LOGINID;
			V_LOGINID_CACHE(I_TBL_USERS(j).LOGINID).MEMBERID           := I_TBL_USERS(j).MEMBERID;
			V_LOGINID_CACHE(I_TBL_USERS(j).LOGINID).MEMINFO_REC_IND    := I_TBL_USERS(j).MEMINFO_REC_IND;

			/*--Check if there is an active member record that is not on the staging table
			--The record needs to be made inactive on the member table
			IF I_TBL_USERS(j).ACTV_STG_REC_IND = GCV_NO 
			AND I_TBL_USERS(j).STATE = GCV_ACTIVE_STATE 
			AND I_TBL_USERS(j).HHSID IS NOT NULL THEN 
				SP_INACTIVATE_MEMBER(I_TBL_USERS(j), V_REC_MEM, V_REC_HST);
				--Adds records into a collection
				V_TBL_UPDT_MEM(V_TBL_UPDT_MEM.COUNT)   := V_REC_MEM;
				V_TBL_HST(V_TBL_HST.COUNT)             := V_REC_HST;
			END IF; */
		END LOOP;
	END IF;
	--Loop through staging table
	FOR i IN I_TBL_STG.FIRST..I_TBL_STG.LAST LOOP
		IF I_TBL_STG(i).EXCLUDE_RECORD = GCV_NO THEN
			--Use the HHSID to check if a member record already exists for an employee
			IF V_TBL_USR_CACHE.COUNT > 0
			AND V_TBL_USR_CACHE.EXISTS(I_TBL_STG(i).HHSID)
			AND ((I_TBL_STG(i).DEPTNAME = GCV_CMS AND GV_CMS_DEPTID IS NOT NULL)
			OR (I_TBL_STG(i).DEPTNAME = GCV_CDC AND GV_CDC_DEPTID IS NOT NULL)
			OR (I_TBL_STG(i).DEPTNAME = GCV_IHS AND GV_IHS_DEPTID IS NOT NULL)
			OR (I_TBL_STG(i).DEPTNAME IN (GCV_OS,GCV_ACF,GCV_ACL,GCV_AHRQ,GCV_PSC,GCV_SAMHSA) AND GV_WHRSC_DEPTID IS NOT NULL)) THEN
				IF NOT V_TBL_UPDT_CACHE.EXISTS(I_TBL_STG(i).HHSID) THEN
					--Create collections to update member
					SP_CHECK_MEMBER(I_TBL_STG(i), V_TBL_USR_CACHE(I_TBL_STG(i).HHSID), V_TBL_UPDT_MEM, V_TBL_HST);
					
					--Add collection to update cache to prevent overwriting updates with older records
					V_TBL_UPDT_CACHE(I_TBL_STG(i).HHSID).HHSID := I_TBL_STG(i).HHSID;
				END IF;
				
			--Member record exists without a HHSID. Add the HHSID to the MEMBERINFO table
			ELSIF V_LOGINID_CACHE.EXISTS(I_TBL_STG(i).EMAIL) 
			AND NOT V_TBL_USR_CACHE.EXISTS(I_TBL_STG(i).HHSID) THEN
			
				SP_ADD_HHSID(I_TBL_STG(i), V_LOGINID_CACHE(I_TBL_STG(i).EMAIL), V_TBL_INS_INFO, V_TBL_UPDT_INFO);
			
			--Member record does not exist for an active employee; A new record will be inserted into the MEMBER table
			ELSIF NOT V_TBL_INS_CACHE.EXISTS(I_TBL_STG(i).HHSID) 
			AND ((I_TBL_STG(i).DEPTNAME = GCV_CMS AND GV_CMS_DEPTID IS NOT NULL)
			OR (I_TBL_STG(i).DEPTNAME = GCV_CDC AND GV_CDC_DEPTID IS NOT NULL)
			OR (I_TBL_STG(i).DEPTNAME = GCV_IHS AND GV_IHS_DEPTID IS NOT NULL)
			OR (I_TBL_STG(i).DEPTNAME IN (GCV_OS,GCV_ACF,GCV_ACL,GCV_AHRQ,GCV_PSC,GCV_SAMHSA) AND GV_WHRSC_DEPTID IS NOT NULL)) THEN
			
				-- Generate ID for new user
				BIZFLOW.SP_GET_ID(GCV_SVRID, 'MemberID', 1, V_NEWID);
				V_MEMBERID  := LPAD(TO_CHAR(V_NEWID), 10, '0');
		
				V_MEM_IDX   := V_TBL_INS_MEM.COUNT;
				V_INFO_IDX  := V_TBL_INS_INFO.COUNT;
				V_HST_IDX   := V_TBL_HST.COUNT;
				
				--Create collection to insert a new member
				V_TBL_INS_MEM(V_MEM_IDX).MEMBERID   := V_MEMBERID;
				V_TBL_INS_MEM(V_MEM_IDX).TYPE       := GCV_TYPE_USER;
				V_TBL_INS_MEM(V_MEM_IDX).STATE      := GCV_ACTIVE_STATE;
				V_TBL_INS_MEM(V_MEM_IDX).NAME       := SUBSTR(I_TBL_STG(i).LASTNAME || ', ' || I_TBL_STG(i).FIRSTNAME || ' ' || SUBSTR(I_TBL_STG(i).MIDDLENAME, 0, 1), 1, 100);
				V_TBL_INS_MEM(V_MEM_IDX).LOGINID    := SUBSTR(I_TBL_STG(i).EMAIL, 1, 100);
				V_TBL_INS_MEM(V_MEM_IDX).SVRID      := GCV_SVRID;
				V_TBL_INS_MEM(V_MEM_IDX).DEPTID     :=  CASE
															WHEN I_TBL_STG(i).DEPTNAME = GCV_CMS
															THEN GV_CMS_DEPTID
															WHEN I_TBL_STG(i).DEPTNAME = GCV_CDC
															THEN GV_CDC_DEPTID
															WHEN I_TBL_STG(i).DEPTNAME = GCV_IHS
															THEN GV_IHS_DEPTID
															WHEN I_TBL_STG(i).DEPTNAME IN (GCV_OS,GCV_ACF,GCV_ACL,GCV_AHRQ,GCV_PSC,GCV_SAMHSA)
															THEN GV_WHRSC_DEPTID
														END;
				V_TBL_INS_MEM(V_MEM_IDX).DEPTNAME   :=  CASE
															WHEN I_TBL_STG(i).DEPTNAME IN (GCV_OS,GCV_ACF,GCV_ACL,GCV_AHRQ,GCV_PSC,GCV_SAMHSA)
															THEN GCV_WHRSC_OU
															ELSE I_TBL_STG(i).DEPTNAME
														END;
				V_TBL_INS_MEM(V_MEM_IDX).SHORTNAME  := SUBSTR(I_TBL_STG(i).LASTNAME || ', ' || I_TBL_STG(i).FIRSTNAME || ' ' || SUBSTR(I_TBL_STG(i).MIDDLENAME, 0, 1), 1, 30);
				V_TBL_INS_MEM(V_MEM_IDX).EMAIL      := SUBSTR(I_TBL_STG(i).EMAIL, 1, 100);
				V_TBL_INS_MEM(V_MEM_IDX).MANAGERID  := GCV_MANAGERID;
				V_TBL_INS_MEM(V_MEM_IDX).PASSWD     :=  CASE
															WHEN I_TBL_STG(i).DEPTNAME = GCV_CMS
															THEN GCV_CMS_PASSWD
															WHEN I_TBL_STG(i).DEPTNAME = GCV_CDC
															THEN GCV_CDC_PASSWD
															WHEN I_TBL_STG(i).DEPTNAME = GCV_IHS
															THEN GCV_IHS_PASSWD
															WHEN I_TBL_STG(i).DEPTNAME IN (GCV_OS,GCV_ACF,GCV_ACL,GCV_AHRQ,GCV_PSC,GCV_SAMHSA)
															THEN GCV_WHRSC_PASSWD
														END;
				
				--Create collection to insert into memberinfo
				V_TBL_INS_INFO(V_INFO_IDX).MEMBERID := V_MEMBERID;
				V_TBL_INS_INFO(V_INFO_IDX).CUSTOMB  := I_TBL_STG(i).HHSID;
				
				--Create collection to insert into memberhistory
				V_TBL_HST(V_HST_IDX).HISTORYID  := MEMBERHISTORY_SEQ.NEXTVAL;
				V_TBL_HST(V_HST_IDX).CHANGEDATE := SYSDATE;
				V_TBL_HST(V_HST_IDX).MEMBERID   := V_MEMBERID;
				V_TBL_HST(V_HST_IDX).HHSID      := I_TBL_STG(i).HHSID;
				V_TBL_HST(V_HST_IDX).OPDIV      := V_TBL_INS_MEM(V_MEM_IDX).DEPTNAME;
				V_TBL_HST(V_HST_IDX).DMLTYPE    := GCV_INSERT;
				
				--Add collection to insert cache to prevent duplicate inserted entries
				V_TBL_INS_CACHE(V_TBL_INS_INFO(V_INFO_IDX).CUSTOMB).HHSID := V_TBL_INS_INFO(V_INFO_IDX).CUSTOMB;
			END IF;
		END IF;
	END LOOP;
	
	--Update member records
	IF V_TBL_UPDT_MEM.COUNT > 0 THEN
		SP_UPDATE_MEMBER(V_TBL_UPDT_MEM);
	END IF;
	
	--Update memberinfo records
	IF V_TBL_UPDT_INFO.COUNT > 0 THEN
		SP_UPDATE_MEMBERINFO(V_TBL_UPDT_INFO);
	END IF;
	
	--Insert new member records
	IF V_TBL_INS_MEM.COUNT > 0 THEN
		SP_INSERT_MEMBER(V_TBL_INS_MEM);
	END IF;
	
	--Insert new memberinfo records
	IF V_TBL_INS_INFO.COUNT > 0 THEN
		SP_INSERT_MEMBERINFO(V_TBL_INS_INFO);
	END IF;
	
	--Insert memberhistory records
	IF V_TBL_HST.COUNT > 0 THEN
		SP_INSERT_MEMBERHISTORY(V_TBL_HST);
	END IF;
	
END;

--------------------------------------------------------
--PROCEDURE: SP_TRUNC_MEMBERSTG
--DESCRIPTION: Truncates the MEMBERSTG table
--------------------------------------------------------
PROCEDURE SP_TRUNC_MEMBERSTG
IS
BEGIN
	EXECUTE IMMEDIATE 'TRUNCATE TABLE MEMBERSTG';
END;

--======================================================
-- - - - - - - - - - - - - - - - - - - - - - - - - - - -

--FUNCTIONS

-- - - -- - - - - - - - - - - - - - - - - - - - - - - -
--======================================================
--------------------------------------------------------
--FUNCTION: FN_IMPORT_BIIS_PERSON
--DESCRIPTION:
--------------------------------------------------------
FUNCTION FN_IMPORT_BIIS_PERSON
	(O_ERRMSG       OUT VARCHAR2)
RETURN NUMBER
IS
	V_TBL_BIIS      TYP_BIIS_PERSON;
	V_TBL_MEM_STG   TYP_CUR_MEMBERSTG;
	V_TBL_USERS     TYP_USERS;
BEGIN

	SP_INITALIZE;
	
	SP_TRUNC_MEMBERSTG;
	
	BEGIN
		--Fetch BIIS Person records
		OPEN CUR_BIIS_PERSON;
		FETCH CUR_BIIS_PERSON
		BULK COLLECT INTO V_TBL_BIIS;
		CLOSE CUR_BIIS_PERSON;
	
		IF V_TBL_BIIS.COUNT = 0 THEN
			RAISE NO_DATA_FOUND;
		END IF;
		
	END;
	
	--Insert BIIS data into the member 
	--staging table and the Employee Lookup table
	IF V_TBL_BIIS.COUNT > 0 THEN
		SP_INSERT_BIIS_DATA(V_TBL_BIIS);
	END IF;
	
	--Fetch existing member user records
	BEGIN 
		OPEN CUR_USERS;
		FETCH CUR_USERS
		BULK COLLECT INTO V_TBL_USERS;
		CLOSE CUR_USERS;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN 
			NULL;
	END;
	
	--Fetch records from memberstg table
	BEGIN
		OPEN CUR_MEMBERSTG;
		FETCH CUR_MEMBERSTG
		BULK COLLECT INTO V_TBL_MEM_STG;
		CLOSE CUR_MEMBERSTG;
	
		IF V_TBL_MEM_STG.COUNT = 0 THEN
			RAISE NO_DATA_FOUND;
		END IF;
		
	END;
	
	IF V_TBL_MEM_STG.COUNT > 0 THEN
		SP_PROCESS_MEMBER(V_TBL_MEM_STG, V_TBL_USERS);
	END IF;
	
	O_ERRMSG := SQLERRM || ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE;
	COMMIT;
	RETURN SQLCODE;
EXCEPTION
	WHEN OTHERS THEN
		ROLLBACK;
		O_ERRMSG := SQLERRM || ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE;
		RETURN SQLCODE;
END;

END BIIS_PERSON;
/