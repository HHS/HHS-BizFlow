create or replace PROCEDURE        SP_UPDATE_CMS_POSSESS_TABLE
(
	I_ID                IN      NUMBER,
    I_TYPE_RPT         IN      VARCHAR2
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CMS_POSSESS_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');
    
	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CMS_POSSESS_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;
    -- 
	BEGIN
		--------------------------------
		-- DSS_CMS_TIME_OF_POSSESS_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CMS_TIME_OF_POSSESS_STG table');
        
        IF I_TYPE_RPT = 'CMS-POSSESSION-APPOINTMENT' THEN
            INSERT INTO HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
                (
                 REQUEST_NUMBER   
                , REQUEST_APPROVAL_DATE
                , NEW_HIRE_CREATE_DATE
                , SEND_TENT_OFFR_CMPL_DATE
                , TENT_OFFR_RSPNS_DATE
                , RCVE_BKGRND_INVST_DATE
                , EOD_DATE
                , SEND_OFCL_OFFR_CMPL_DATE
                , INIT_BKGRND_INVST_DATE
                , REQUEST_TYPE
                , REQUEST_STATUS
                , ARRVL_VERIF_CMPL_DATE)
            SELECT
                X.REQUEST_NUMBER
                , TO_DATE(SUBSTR(X.REQUEST_APPROVAL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_APPROVAL_DATE
                , TO_DATE(SUBSTR(X.NEW_HIRE_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS NEW_HIRE_CREATE_DATE
                , TO_DATE(SUBSTR(X.SEND_TENT_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_TENT_OFFR_CMPL_DATE
                , TO_DATE(SUBSTR(X.TENT_OFFR_RSPNS_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS TENT_OFFR_RSPNS_DATE
                , TO_DATE(SUBSTR(X.RCVE_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RCVE_BKGRND_INVST_DATE
                , TO_DATE(SUBSTR(X.EOD_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS EOD_DATE
                , TO_DATE(SUBSTR(X.SEND_OFCL_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_OFCL_OFFR_CMPL_DATE
                , TO_DATE(SUBSTR(X.INIT_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS INIT_BKGRND_INVST_DATE
                , X.REQUEST_TYPE
                 ,X.REQUEST_STATUS
                , TO_DATE(SUBSTR(X.ARRVL_VERIF_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ARRVL_VERIF_CMPL_DATE    		    		
            FROM HHS_HR.INTG_DATA_DTL IDX
                , XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "List1"]'
                    PASSING IDX.FIELD_DATA
                    COLUMNS
                          REQUEST_NUMBER                        VARCHAR2(202)   PATH 'Request__Number'
                        , REQUEST_APPROVAL_DATE_STR             VARCHAR2(50)    PATH 'Request__Approval__Date'
                        , NEW_HIRE_CREATE_DATE_STR              VARCHAR2(50)    PATH 'New__Hire__Creation__Date'
                        , SEND_TENT_OFFR_CMPL_DATE_STR          VARCHAR2(50)    PATH 'Send__Tentative__Offer__Complete__Date'
                        , TENT_OFFR_RSPNS_DATE_STR              VARCHAR2(50)    PATH 'Tentative__Job__Offer__Response__Date'
                        , RCVE_BKGRND_INVST_DATE_STR            VARCHAR2(50)    PATH 'Receive__Background__Investigation_x002fSecurity__Clearance__Complete__Date'
                        , EOD_DATE_STR                          VARCHAR2(50)    PATH 'EOD__Date'
                        , SEND_OFCL_OFFR_CMPL_DATE_STR          VARCHAR2(50)    PATH 'Send__Official__Offer__Complete__Date'
                        , INIT_BKGRND_INVST_DATE_STR            VARCHAR2(50)    PATH 'Initiate__Background__Investigation__Complete__Date'
                        , REQUEST_TYPE                          VARCHAR2(1002)  PATH 'Request__Type'
                        , REQUEST_STATUS                        VARCHAR2(50)    PATH 'Request__Status'
                        , ARRVL_VERIF_CMPL_DATE_STR             VARCHAR2(50)    PATH 'New__Hire__Arrival__Verified__Complete__Date' 
                ) X
            WHERE IDX.ID = I_ID;
            ELSIF I_TYPE_RPT = 'CMS-POSSESSION' THEN   
                INSERT INTO HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG
                (REQUEST_NUMBER
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
                , INIT_BKGRND_INVST_DATE
                , REQUEST_TYPE
                , REQUEST_STATUS
                , REQUEST_CREATE_DATE
                , ARRVL_VERIF_CMPL_DATE)
            SELECT
                X.REQUEST_NUMBER
                , TO_DATE(SUBSTR(X.REQUEST_APPROVAL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_APPROVAL_DATE
                , X.ANNOUNCEMENT_NUMBER
                , TO_DATE(SUBSTR(X.HM_ANN_RVW_SENT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS HM_ANN_RVW_SENT_DATE
                , TO_DATE(SUBSTR(X.HM_ANN_RVW_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS HM_ANN_RVW_CMPL_DATE
                , TO_DATE(SUBSTR(X.ANNOUNCEMENT_OPEN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_OPEN_DATE
                , TO_DATE(SUBSTR(X.ANNOUNCEMENT_CLOSE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_CLOSE_DATE
                , X.CERTIFICATE_NUMBER
                , TO_DATE(SUBSTR(X.CERTIFICATE_ISSUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERTIFICATE_ISSUE_DATE
                , TO_DATE(SUBSTR(X.REVIEW_SENT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_SENT_DATE
                , TO_DATE(SUBSTR(X.REVIEW_RETURN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_RETURN_DATE
                , TO_DATE(SUBSTR(X.INITIAL_AUDIT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS INITIAL_AUDIT_DATE   
                , TO_DATE(SUBSTR(X.NEW_HIRE_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS NEW_HIRE_CREATE_DATE
                , TO_DATE(SUBSTR(X.SEND_TENT_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_TENT_OFFR_CMPL_DATE
                , TO_DATE(SUBSTR(X.TENT_OFFR_RSPNS_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS TENT_OFFR_RSPNS_DATE
                , TO_DATE(SUBSTR(X.RCVE_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RCVE_BKGRND_INVST_DATE
                , TO_DATE(SUBSTR(X.EOD_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS EOD_DATE
                , TO_DATE(SUBSTR(X.SEND_OFCL_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_OFCL_OFFR_CMPL_DATE
                , TO_DATE(SUBSTR(X.INIT_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS INIT_BKGRND_INVST_DATE
                , X.REQUEST_TYPE
                , X.REQUEST_STATUS
                , TO_DATE(SUBSTR(X.REQUEST_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_CREATE_DATE
                , TO_DATE(SUBSTR(X.ARRVL_VERIF_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ARRVL_VERIF_CMPL_DATE    		    		
            FROM HHS_HR.INTG_DATA_DTL IDX
                , XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_TimeToPossess"]'
                    PASSING IDX.FIELD_DATA
                    COLUMNS
                          REQUEST_NUMBER                        VARCHAR2(202)   PATH 'Request__Number'
                        , REQUEST_APPROVAL_DATE_STR             VARCHAR2(50)    PATH 'Request__Approval__Date'
                        , ANNOUNCEMENT_NUMBER                   VARCHAR2(56)    PATH 'Announcement__Number'
                        , HM_ANN_RVW_SENT_DATE_STR              VARCHAR2(50)    PATH 'HM__Announcement__Review__Sent__Date'
                        , HM_ANN_RVW_CMPL_DATE_STR              VARCHAR2(50)    PATH 'HM__Announcement__Review__Completion__Date'
                        , ANNOUNCEMENT_OPEN_DATE_STR            VARCHAR2(50)    PATH 'Announcement__Open__Date'
                        , ANNOUNCEMENT_CLOSE_DATE_STR           VARCHAR2(50)    PATH 'Announcement__Close__Date'
                        , CERTIFICATE_NUMBER                    VARCHAR2(102)   PATH 'Certificate__Number'
                        , CERTIFICATE_ISSUE_DATE_STR            VARCHAR2(50)    PATH 'Certificate__Issue__Date'
                        , REVIEW_SENT_DATE_STR                  VARCHAR2(50)    PATH 'Certificate__Review__Sent__Date'
                        , REVIEW_RETURN_DATE_STR                VARCHAR2(50)    PATH 'Certificate__Review__Returned__Date'
                        , INITIAL_AUDIT_DATE_STR                VARCHAR2(50)    PATH 'Certificate__Initial__Audit__Complete__Date'
                        , NEW_HIRE_CREATE_DATE_STR              VARCHAR2(50)    PATH 'New__Hire__Creation__Date'
                        , SEND_TENT_OFFR_CMPL_DATE_STR          VARCHAR2(50)    PATH 'Send__Tentative__Offer__Complete__Date'
                        , TENT_OFFR_RSPNS_DATE_STR              VARCHAR2(50)    PATH 'Tentative__Job__Offer__Response__Date'
                        , RCVE_BKGRND_INVST_DATE_STR            VARCHAR2(50)    PATH 'Receive__Background__Investigation_x002fSecurity__Clearance__Complete__Date'
                        , EOD_DATE_STR                          VARCHAR2(50)    PATH 'EOD__Date'
                        , SEND_OFCL_OFFR_CMPL_DATE_STR          VARCHAR2(50)    PATH 'Send__Official__Offer__Complete__Date'
                        , INIT_BKGRND_INVST_DATE_STR            VARCHAR2(50)    PATH 'Initiate__Background__Investigation__Complete__Date'
                        , REQUEST_TYPE                          VARCHAR2(1002)  PATH 'Request__Type'
                        , REQUEST_STATUS                        VARCHAR2(1002)  PATH 'Request__Status'
                        , REQUEST_CREATE_DATE_STR               VARCHAR2(50)    PATH 'Request__Creation__Date'
                        , ARRVL_VERIF_CMPL_DATE_STR             VARCHAR2(50)    PATH 'New__Hire__Arrival__Verified__Complete__Date' 
                ) X
            WHERE IDX.ID = I_ID;
           -- END;
        END IF;
        
		
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CMS_POSSESS_TABLE: Invalid CMS Time of Possession data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;
    
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CMS_POSSESS_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CMS_POSSESS_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CMS_POSSESS_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CMS_POSSESS_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;