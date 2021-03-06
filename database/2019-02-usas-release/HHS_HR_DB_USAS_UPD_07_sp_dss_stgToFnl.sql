--------------------------------------------------------
--  DDL for Procedure SP_CDC_TIME2STAFF_STG2FNL
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE HHS_HR.SP_CDC_TIME2STAFF_STG2FNL
IS
	V_STG_CNT                   NUMBER;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	CURSOR CUR_TIME2STAFF_STG
	IS
		SELECT STAFFING_ORGANIZATION
			, REQUEST_NUMBER
			, REQUEST_CREATE_DATE
			, REQUEST_APPROVAL_DATE
			, REQUEST_STATUS
			, REQUEST_TYPE
			, POSITION_TITLE
			, PAYPLAN_SERIES_GRADE
			, AREA_CONSIDER
			, CERTIFICATE_NUMBER
			, CERTIFICATE_SERIES
			, CERTIFICATE_GRADE
			, CERTIFICATE_LOCATION
			, CERTIFICATE_ISSUE_DATE
			, REVIEW_RETURN_DATE
		FROM HHS_HR.DSS_CDC_TIME_TO_STAFF_STG;

		TYPE TYPE_TIME2STAFF_STG IS TABLE OF CUR_TIME2STAFF_STG%ROWTYPE
			INDEX BY PLS_INTEGER;

		V_TBL_TIME2STAFF_STG TYPE_TIME2STAFF_STG;
BEGIN
	BEGIN
		SELECT COUNT(*)
		INTO V_STG_CNT
		FROM HHS_HR.DSS_CDC_TIME_TO_STAFF_STG;
		
		IF V_STG_CNT > 0 THEN
			EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CDC_TIME_TO_STAFF';
			OPEN CUR_TIME2STAFF_STG;
			LOOP
				FETCH CUR_TIME2STAFF_STG
				BULK COLLECT INTO V_TBL_TIME2STAFF_STG
				LIMIT 1000;
				
				FORALL i IN V_TBL_TIME2STAFF_STG.FIRST..V_TBL_TIME2STAFF_STG.LAST SAVE EXCEPTIONS
					INSERT INTO DSS_CDC_TIME_TO_STAFF VALUES V_TBL_TIME2STAFF_STG(i);
				COMMIT;
				
				EXIT WHEN CUR_TIME2STAFF_STG%NOTFOUND;
			END LOOP;
			CLOSE CUR_TIME2STAFF_STG;
		END IF;
	EXCEPTION
		WHEN OTHERS THEN
			SP_ERROR_LOG();
			V_ERRCODE := SQLCODE;
			V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_TIME2STAFF_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
	END;
	--DBMS_OUTPUT.PUT_LINE('SP_CDC_TIME2STAFF_STG2FNL - END ==========================');
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_TIME2STAFF_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/


--------------------------------------------------------
--  DDL for Procedure SP_CDC_TIME2OFFER_STG2FNL
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE HHS_HR.SP_CDC_TIME2OFFER_STG2FNL
IS
	V_STG_CNT                   NUMBER;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	CURSOR CUR_TIME2OFFER_STG
	IS
		SELECT STAFFING_ORGANIZATION
			, REQUEST_NUMBER
			, PD_NUMBER
			, NEW_HIRE_CREATE_DATE
			, REQUEST_STATUS
			, REQUEST_TYPE
			, POSITION_TITLE
			, AREA_CONSIDER
			, NEW_HIRE_PAY_PLAN
			, NEW_HIRE_SERIES
			, NEW_HIRE_GRADE
			, SEND_TENT_OFFR_CMPL_DATE
			, INIT_BKGRND_INVST_DATE
			, RCVE_BKGRND_INVST_DATE
			, SEND_OFCL_OFFR_CMPL_DATE
			, NEW_HIRE_NAME
			, EOD_DATE
		FROM HHS_HR.DSS_CDC_TIME_TO_OFFER_STG;

		TYPE TYPE_TIME2OFFER_STG IS TABLE OF CUR_TIME2OFFER_STG%ROWTYPE
			INDEX BY PLS_INTEGER;

		V_TBL_TIME2OFFER_STG TYPE_TIME2OFFER_STG;
BEGIN
	BEGIN
		SELECT COUNT(*)
		INTO V_STG_CNT
		FROM HHS_HR.DSS_CDC_TIME_TO_OFFER_STG;
		
		IF V_STG_CNT > 0 THEN
			EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CDC_TIME_TO_OFFER';
			OPEN CUR_TIME2OFFER_STG;
			LOOP
				FETCH CUR_TIME2OFFER_STG
				BULK COLLECT INTO V_TBL_TIME2OFFER_STG
				LIMIT 1000;
				
				FORALL i IN V_TBL_TIME2OFFER_STG.FIRST..V_TBL_TIME2OFFER_STG.LAST SAVE EXCEPTIONS
					INSERT INTO DSS_CDC_TIME_TO_OFFER VALUES V_TBL_TIME2OFFER_STG(i);
				COMMIT;
				
				EXIT WHEN CUR_TIME2OFFER_STG%NOTFOUND;
			END LOOP;
			CLOSE CUR_TIME2OFFER_STG;
		END IF;
	EXCEPTION
		WHEN OTHERS THEN
			SP_ERROR_LOG();
			V_ERRCODE := SQLCODE;
			V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_TIME2OFFER_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
	END;
	--DBMS_OUTPUT.PUT_LINE('SP_CDC_TIME2OFFER_STG2FNL - END ==========================');
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_TIME2OFFER_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/


--------------------------------------------------------
--  DDL for Procedure SP_CDC_CERT_STG2FNL
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE HHS_HR.SP_CDC_CERT_STG2FNL
IS
	V_STG_CNT                   NUMBER;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	CURSOR CUR_CERT_STG
	IS
		SELECT REQUEST_NUMBER
		    , REQUEST_TYPE
			, CERTIFICATE_NUMBER
			, VACANCY_NUMBER
			, POSITION_TITLE
			, PAYPLAN_SERIES_GRADE
			, CERTIFICATE_SERIES
			, CERTIFICATE_GRADE
			, ANNOUNCEMENT_NUMBER
			, ANNOUNCEMENT_CTRL_NUMBER
			, ANNOUNCEMENT_OPEN_DATE
			, ANNOUNCEMENT_CLOSE_DATE
			, CERTIFICATE_ISSUE_DATE
			, REVIEW_RETURN_DATE
			, CERT_SIGNED_DATE
			, CERT_EXPIRED_DATE
			, TOTAL_APPLICANTS
			, HIRING_AUTHORITY
		FROM HHS_HR.DSS_CDC_CERTIFICATE_STG;

		TYPE TYPE_CERT_STG IS TABLE OF CUR_CERT_STG%ROWTYPE
			INDEX BY PLS_INTEGER;

		V_TBL_CERT_STG TYPE_CERT_STG;
BEGIN
	BEGIN
		SELECT COUNT(*)
		INTO V_STG_CNT
		FROM HHS_HR.DSS_CDC_CERTIFICATE_STG;
		
		IF V_STG_CNT > 0 THEN
			EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CDC_CERTIFICATE';
			OPEN CUR_CERT_STG;
			LOOP
				FETCH CUR_CERT_STG
				BULK COLLECT INTO V_TBL_CERT_STG
				LIMIT 1000;
				
				FORALL i IN V_TBL_CERT_STG.FIRST..V_TBL_CERT_STG.LAST SAVE EXCEPTIONS
					INSERT INTO DSS_CDC_CERTIFICATE VALUES V_TBL_CERT_STG(i);
				COMMIT;
				
				EXIT WHEN CUR_CERT_STG%NOTFOUND;
			END LOOP;
			CLOSE CUR_CERT_STG;
		END IF;
	EXCEPTION
		WHEN OTHERS THEN
			SP_ERROR_LOG();
			V_ERRCODE := SQLCODE;
			V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_CERT_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
	END;
	--DBMS_OUTPUT.PUT_LINE('SP_CDC_CERT_STG2FNL - END ==========================');
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_CERT_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

--------------------------------------------------------
--  DDL for Procedure SP_CDC_AUDIT_STG2FNL
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE HHS_HR.SP_CDC_AUDIT_STG2FNL
IS
	V_STG_CNT                   NUMBER;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	CURSOR CUR_AUDIT_STG
	IS
		SELECT REQUEST_NUMBER
			, CERTIFICATE_NUMBER
			, AUDIT_CODE
			, AUDIT_DATE
			, CERT_LAST_UPDATE_DATE
		FROM HHS_HR.DSS_CDC_CERT_AUDIT_STG;

		TYPE TYPE_AUDIT_STG IS TABLE OF CUR_AUDIT_STG%ROWTYPE
			INDEX BY PLS_INTEGER;

		V_TBL_AUDIT_STG TYPE_AUDIT_STG;
BEGIN
	BEGIN
		SELECT COUNT(*)
		INTO V_STG_CNT
		FROM HHS_HR.DSS_CDC_CERT_AUDIT_STG;
		
		IF V_STG_CNT > 0 THEN
			EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CDC_CERT_AUDIT';
			OPEN CUR_AUDIT_STG;
			LOOP
				FETCH CUR_AUDIT_STG
				BULK COLLECT INTO V_TBL_AUDIT_STG
				LIMIT 1000;
				
				FORALL i IN V_TBL_AUDIT_STG.FIRST..V_TBL_AUDIT_STG.LAST SAVE EXCEPTIONS
					INSERT INTO DSS_CDC_CERT_AUDIT VALUES V_TBL_AUDIT_STG(i);
				COMMIT;
				
				EXIT WHEN CUR_AUDIT_STG%NOTFOUND;
			END LOOP;
			CLOSE CUR_AUDIT_STG;
		END IF;
	EXCEPTION
		WHEN OTHERS THEN
			SP_ERROR_LOG();
			V_ERRCODE := SQLCODE;
			V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_AUDIT_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
	END;
	--DBMS_OUTPUT.PUT_LINE('SP_CDC_AUDIT_STG2FNL - END ==========================');
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_AUDIT_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

--------------------------------------------------------
--  DDL for Procedure SP_CDC_ANN_STG2FNL
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE HHS_HR.SP_CDC_ANN_STG2FNL
IS
	V_STG_CNT                   NUMBER;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	CURSOR CUR_ANN_STG
	IS
		SELECT REQUEST_NUMBER
			, ANNOUNCEMENT_NUMBER
			, ANNOUNCEMENT_CTRL_NUMBER
			, ANNOUNCEMENT_OPEN_DATE
			, ANNOUNCEMENT_CLOSE_DATE
			, ANNOUNCEMENT_RVW_STATUS
			, ANN_RVW_CMPL_DATE
			, ANN_LAST_UPDATE_DATE
		FROM HHS_HR.DSS_CDC_ANNOUNCEMENT_STG;

		TYPE TYPE_ANN_STG IS TABLE OF CUR_ANN_STG%ROWTYPE
			INDEX BY PLS_INTEGER;

		V_TBL_ANN_STG TYPE_ANN_STG;
BEGIN
	BEGIN
		SELECT COUNT(*)
		INTO V_STG_CNT
		FROM HHS_HR.DSS_CDC_ANNOUNCEMENT_STG;
		
		IF V_STG_CNT > 0 THEN
			EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CDC_ANNOUNCEMENT';
			OPEN CUR_ANN_STG;
			LOOP
				FETCH CUR_ANN_STG
				BULK COLLECT INTO V_TBL_ANN_STG
				LIMIT 1000;
				
				FORALL i IN V_TBL_ANN_STG.FIRST..V_TBL_ANN_STG.LAST SAVE EXCEPTIONS
					INSERT INTO DSS_CDC_ANNOUNCEMENT VALUES V_TBL_ANN_STG(i);
				COMMIT;
				
				EXIT WHEN CUR_ANN_STG%NOTFOUND;
			END LOOP;
			CLOSE CUR_ANN_STG;
		END IF;
	EXCEPTION
		WHEN OTHERS THEN
			SP_ERROR_LOG();
			V_ERRCODE := SQLCODE;
			V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_ANN_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
	END;
	--DBMS_OUTPUT.PUT_LINE('SP_CDC_ANN_STG2FNL - END ==========================');
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CDC_ANN_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

--------------------------------------------------------
--  DDL for Procedure SP_CMS_POSSESS_STG2FNL
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE HHS_HR.SP_CMS_POSSESS_STG2FNL
IS
	V_STG_CNT                   NUMBER;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	CURSOR CUR_POSS_STG
	IS
		SELECT REQUEST_NUMBER
    		, REQUEST_APPROVAL_DATE
    		, ANNOUNCEMENT_NUMBER
    		, HM_ANN_RVW_SENT_DATE
    		, HM_ANN_RVW_CMPL_DATE
    		, ANNOUNCEMENT_OPEN_DATE
    		, ANNOUNCEMENT_CLOSE_DATE
    		, CERTIFICATE_NUMBER
    		, CERTIFICATE_ISSUE_DATE
    		, REVIEW_SENT_DATE
    		, REVIEW_RETURN_DATE
    		, INITIAL_AUDIT_DATE   
    		, NEW_HIRE_CREATE_DATE
    		, SEND_TENT_OFFR_CMPL_DATE
    		, TENT_OFFR_RSPNS_DATE
    		, RCVE_BKGRND_INVST_DATE
    		, EOD_DATE
    		, SEND_OFCL_OFFR_CMPL_DATE
		FROM HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG;

		TYPE TYPE_POSS_STG IS TABLE OF CUR_POSS_STG%ROWTYPE
			INDEX BY PLS_INTEGER;

		V_TBL_POSS_STG TYPE_POSS_STG;
BEGIN
	BEGIN
		SELECT COUNT(*)
		INTO V_STG_CNT
		FROM HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG;
		
		IF V_STG_CNT > 0 THEN
			EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CMS_TIME_OF_POSSESS';
			OPEN CUR_POSS_STG;
			LOOP
				FETCH CUR_POSS_STG
				BULK COLLECT INTO V_TBL_POSS_STG
				LIMIT 1000;
				
				FORALL i IN V_TBL_POSS_STG.FIRST..V_TBL_POSS_STG.LAST SAVE EXCEPTIONS
					INSERT INTO DSS_CMS_TIME_OF_POSSESS VALUES V_TBL_POSS_STG(i);
				COMMIT;
				
				EXIT WHEN CUR_POSS_STG%NOTFOUND;
			END LOOP;
			CLOSE CUR_POSS_STG;
		END IF;
	EXCEPTION
		WHEN OTHERS THEN
			SP_ERROR_LOG();
			V_ERRCODE := SQLCODE;
			V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CMS_POSSESS_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
	END;
	--DBMS_OUTPUT.PUT_LINE('SP_CMS_POSSESS_STG2FNL - END ==========================');
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CMS_POSSESS_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

--------------------------------------------------------
--  DDL for Procedure SP_CMS_TIME2HIRE_STG2FNL
--------------------------------------------------------
CREATE OR REPLACE PROCEDURE HHS_HR.SP_CMS_TIME2HIRE_STG2FNL
IS
	V_STG_CNT                   NUMBER;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	CURSOR CUR_TIME2HIRE_STG
	IS
		SELECT REQUEST_NUMBER
		    , REQUEST_CREATE_DATE
    		, REQUEST_STATUS
    		, REQUEST_TYPE
    		, ANNOUNCEMENT_NUMBER
    		, ANNOUNCEMENT_OPEN_DATE
    		, ANNOUNCEMENT_CLOSE_DATE
    		, CERTIFICATE_NUMBER
    		, REVIEW_SENT_DATE
    		, REVIEW_RETURN_DATE
    		, EOD_DATE
		FROM HHS_HR.DSS_CMS_TIME_TO_HIRE_STG;

		TYPE TYPE_TIME2HIRE_STG IS TABLE OF CUR_TIME2HIRE_STG%ROWTYPE
			INDEX BY PLS_INTEGER;

		V_TBL_TIME2HIRE_STG TYPE_TIME2HIRE_STG;
BEGIN
	BEGIN
		SELECT COUNT(*)
		INTO V_STG_CNT
		FROM HHS_HR.DSS_CMS_TIME_TO_HIRE_STG;
		
		IF V_STG_CNT > 0 THEN
			EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CMS_TIME_TO_HIRE';
			OPEN CUR_TIME2HIRE_STG;
			LOOP
				FETCH CUR_TIME2HIRE_STG
				BULK COLLECT INTO V_TBL_TIME2HIRE_STG
				LIMIT 1000;
				
				FORALL i IN V_TBL_TIME2HIRE_STG.FIRST..V_TBL_TIME2HIRE_STG.LAST SAVE EXCEPTIONS
					INSERT INTO DSS_CMS_TIME_TO_HIRE VALUES V_TBL_TIME2HIRE_STG(i);
				COMMIT;
				
				EXIT WHEN CUR_TIME2HIRE_STG%NOTFOUND;
			END LOOP;
			CLOSE CUR_TIME2HIRE_STG;
		END IF;
	EXCEPTION
		WHEN OTHERS THEN
			SP_ERROR_LOG();
			V_ERRCODE := SQLCODE;
			V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CMS_TIME2HIRE_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
	END;
	--DBMS_OUTPUT.PUT_LINE('SP_CMS_TIME2HIRE_STG2FNL - END ==========================');
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_CMS_TIME2HIRE_STG2FNL -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/