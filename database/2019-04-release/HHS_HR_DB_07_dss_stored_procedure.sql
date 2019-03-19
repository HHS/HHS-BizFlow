CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CMS_TIME2HIRE_TABLE
(
	I_ID                IN      NUMBER
)
IS
	V_REC_CNT                   NUMBER(10);
	V_XMLDOC                    XMLTYPE;
	V_XMLVALUE                  XMLTYPE;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	E_INVALID_REC_ID            EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_REC_ID, -20960);
	E_INVALID_REQUEST_DATA      EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_REQUEST_DATA, -20961);
BEGIN
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CMS_TIME2HIRE_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CMS_TIME2HIRE_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CMS_TIME_TO_HIRE_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CMS_TIME_TO_HIRE_STG table');
		INSERT INTO HHS_HR.DSS_CMS_TIME_TO_HIRE_STG
			(REQUEST_NUMBER
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
    		, CERTIFICATE_ISSUE_DATE
    		, SEND_TENT_OFFR_CMPL_DATE
    		, TENT_OFFR_RSPNS_DATE
    		, INIT_BKGRND_INVST_DATE    
    		, RCVE_BKGRND_INVST_DATE
    		, SEND_OFCL_OFFR_CMPL_DATE
    		, ARRVL_VERIF_CMPL_DATE)
		SELECT
			X.REQUEST_NUMBER
			, TO_DATE(SUBSTR(X.REQUEST_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_CREATE_DATE
			, X.REQUEST_STATUS
			, X.REQUEST_TYPE
			, X.ANNOUNCEMENT_NUMBER
    		, TO_DATE(SUBSTR(X.ANNOUNCEMENT_OPEN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_OPEN_DATE
    		, TO_DATE(SUBSTR(X.ANNOUNCEMENT_CLOSE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_CLOSE_DATE
    		, X.CERTIFICATE_NUMBER
    		, TO_DATE(SUBSTR(X.REVIEW_SENT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_SENT_DATE
    		, TO_DATE(SUBSTR(X.REVIEW_RETURN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_RETURN_DATE
    		, TO_DATE(SUBSTR(X.EOD_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS EOD_DATE
    		, TO_DATE(SUBSTR(X.CERTIFICATE_ISSUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERTIFICATE_ISSUE_DATE
    		, TO_DATE(SUBSTR(X.SEND_TENT_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_TENT_OFFR_CMPL_DATE
    		, TO_DATE(SUBSTR(X.TENT_OFFR_RSPNS_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS TENT_OFFR_RSPNS_DATE
    		, TO_DATE(SUBSTR(X.INIT_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS INIT_BKGRND_INVST_DATE
    		, TO_DATE(SUBSTR(X.RCVE_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RCVE_BKGRND_INVST_DATE
    		, TO_DATE(SUBSTR(X.SEND_OFCL_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_OFCL_OFFR_CMPL_DATE
    		, TO_DATE(SUBSTR(X.ARRVL_VERIF_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ARRVL_VERIF_CMPL_DATE    		
		FROM HHS_HR.INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_TimeToHire"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)   PATH 'Certificate__Request__Number'
					, REQUEST_CREATE_DATE_STR           VARCHAR2(50)    PATH 'Certificate__Request__Creation__Date'
    				, REQUEST_STATUS                    VARCHAR2(1002)  PATH 'Certificate__Request__Status'
    				, REQUEST_TYPE                      VARCHAR2(1002)  PATH 'Certificate__Request__Type'
    				, ANNOUNCEMENT_NUMBER               VARCHAR2(56)    PATH 'Certificate__Announcement__Number'
    				, ANNOUNCEMENT_OPEN_DATE_STR        VARCHAR2(50)    PATH 'Certificate__Announcement__Open__Date'
    				, ANNOUNCEMENT_CLOSE_DATE_STR       VARCHAR2(50)    PATH 'Certificate__Announcement__Close__Date'
    				, CERTIFICATE_NUMBER                VARCHAR2(102)   PATH 'Certificate__Number'
    				, REVIEW_SENT_DATE_STR              VARCHAR2(50)    PATH 'Certificate__Review__Sent__Date'
    				, REVIEW_RETURN_DATE_STR            VARCHAR2(50)    PATH 'Certificate__Review__Returned__Date'
    				, EOD_DATE_STR                      VARCHAR2(50)    PATH 'EOD__Date'
    				, CERTIFICATE_ISSUE_DATE_STR        VARCHAR2(50)    PATH 'Certificate__Issue__Date'
					, SEND_TENT_OFFR_CMPL_DATE_STR      VARCHAR2(50)    PATH 'Send__Tentative__Offer__Complete__Date'
					, TENT_OFFR_RSPNS_DATE_STR          VARCHAR2(50)    PATH 'Tentative__Job__Offer__Response__Date'
					, INIT_BKGRND_INVST_DATE_STR        VARCHAR2(50)    PATH 'Initiate__Background__Investigation_x002fSecurity__Clearance__Complete__Date'
					, RCVE_BKGRND_INVST_DATE_STR        VARCHAR2(50)    PATH 'Receive__Background__Investigation_x002fSecurity__Clearance__Results__Complete__Date'
					, SEND_OFCL_OFFR_CMPL_DATE_STR      VARCHAR2(50)    PATH 'Send__Official__Offer__Complete__Date'
					, ARRVL_VERIF_CMPL_DATE_STR         VARCHAR2(50)    PATH 'New__Hire__Arrival__Verified__Complete__Date'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CMS_TIME2HIRE_TABLE: Invalid CMS Time to Hire data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CMS_TIME2HIRE_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CMS_TIME2HIRE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CMS_TIME2HIRE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CMS_TIME2HIRE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_INTG_DATA
--------------------------------------------------------
/**
 * Stores the integration data in the integration data detail table (INTG_DATA_DTL).
 *
 * @param IO_ID - ID number the row of the INTG_DATA_DTL table to be inserted or updated.  It will be also used as the return object.
 * @param I_INTG_TYPE - Integration Type to indicate the source data name, which will be
 * 				used to distinguish the xml structure.
 * @param I_FIELD_DATA - CLOB representation of the integration data.
 * @param I_USER - Indicates the user who
 *
 * @return IO_ID - ID number of the row of the INTG_DATA_DTL table inserted or updated.
 */
CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_INTG_DATA
(
	IO_ID               IN OUT  NUMBER
	, I_INTG_TYPE       IN      VARCHAR2
	, I_FIELD_DATA      IN      CLOB
	, I_USER            IN      VARCHAR2
)
IS
	V_ID                        NUMBER(20);
	V_INTG_TYPE                 VARCHAR2(50);
	V_USER                      VARCHAR2(50);
	V_REC_CNT                   NUMBER(10);
	V_MAX_ID                    NUMBER(20);
	V_XMLDOC                    XMLTYPE;
BEGIN
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    ID IS NULL?  = ' || (CASE WHEN IO_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    ID           = ' || TO_CHAR(IO_ID));
	--DBMS_OUTPUT.PUT_LINE('    I_INTG_TYPE  = ' || I_INTG_TYPE);
	--DBMS_OUTPUT.PUT_LINE('    I_FIELD_DATA = ' || I_FIELD_DATA);
	--DBMS_OUTPUT.PUT_LINE('    I_USER       = ' || I_USER);
	--DBMS_OUTPUT.PUT_LINE(' ----------------');


	V_ID := IO_ID;

	--DBMS_OUTPUT.PUT_LINE('ID to be used is determined: ' || TO_CHAR(V_ID));


	BEGIN
		SELECT COUNT(*) INTO V_REC_CNT FROM HHS_HR.INTG_DATA_DTL WHERE ID = V_ID;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			V_REC_CNT := -1;
	END;

	V_INTG_TYPE := I_INTG_TYPE;
	V_USER := I_USER;

	--DBMS_OUTPUT.PUT_LINE('Inspected existence of same record.');
	--DBMS_OUTPUT.PUT_LINE('    V_ID       = ' || TO_CHAR(V_ID));
	--DBMS_OUTPUT.PUT_LINE('    V_REC_CNT  = ' || TO_CHAR(V_REC_CNT));

	V_XMLDOC := XMLTYPE(I_FIELD_DATA);

	IF V_REC_CNT > 0 THEN
		--DBMS_OUTPUT.PUT_LINE('Record found so that field data will be updated on the same record.');

		UPDATE HHS_HR.INTG_DATA_DTL
		SET
			INTG_TYPE = V_INTG_TYPE
			, FIELD_DATA = V_XMLDOC
			, MOD_DT = SYSDATE
			, MOD_USR = V_USER
		WHERE ID = V_ID
		;

	ELSE
		--DBMS_OUTPUT.PUT_LINE('No record found so that new record will be inserted.');

		INSERT INTO HHS_HR.INTG_DATA_DTL
		(
			INTG_TYPE
			, FIELD_DATA
			, CRT_DT
			, CRT_USR
		)
		VALUES
		(
			V_INTG_TYPE
			, V_XMLDOC
			, SYSDATE
			, V_USER
		)
		RETURNING ID INTO V_ID
		;
	END IF;


	--------------------------------------------
	-- Parse XML data into respective tables
	--------------------------------------------
	IF V_INTG_TYPE = 'ANNOUNCEMENT' THEN
		SP_UPDATE_ANNOUNCEMENT_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'APPLICATION' THEN
		SP_UPDATE_APPLICATION_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CERTIFICATE' THEN
		SP_UPDATE_CERTIFICATE_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'NEWHIRE' THEN
		SP_UPDATE_NEWHIRE_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'REQUEST' THEN
		SP_UPDATE_REQUEST_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'REVIEW' THEN
		SP_UPDATE_REVIEW_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'TASK' THEN
		SP_UPDATE_TASK_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'VACANCY' THEN
		SP_UPDATE_VACANCY_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'TIME2OFFER' THEN
		SP_UPDATE_TIME2OFFER_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'TIME2STAFF' THEN
		SP_UPDATE_TIME2STAFF_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'IHS-VACANCY' THEN
		SP_UPDATE_IHS_VAC_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CDCTIME2OFFER' THEN
		SP_UPDATE_CDC_TIME2OFFER_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CDCTIME2STAFF' THEN
		SP_UPDATE_CDC_TIME2STAFF_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CDC-CERT' THEN
		SP_UPDATE_CDC_CERT_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CDC-AUDIT' THEN
		SP_UPDATE_CDC_AUDIT_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CDC-ANNOUNCEMENT' THEN
		SP_UPDATE_CDC_ANN_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CMS-POSSESSION' THEN
		SP_UPDATE_CMS_POSSESS_TABLE(V_ID);
	ELSIF V_INTG_TYPE = 'CMS-TIME2HIRE' THEN
		SP_UPDATE_CMS_TIME2HIRE_TABLE(V_ID);		
	END IF;
	

	COMMIT;

EXCEPTION
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('Error occurred while executing SP_UPDATE_INTG_DATA -------------------');
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
    		, CERTIFICATE_ISSUE_DATE
    		, SEND_TENT_OFFR_CMPL_DATE
    		, TENT_OFFR_RSPNS_DATE
    		, INIT_BKGRND_INVST_DATE
    		, RCVE_BKGRND_INVST_DATE
    		, SEND_OFCL_OFFR_CMPL_DATE
    		, ARRVL_VERIF_CMPL_DATE
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