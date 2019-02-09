CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CDC_TIME2STAFF_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_TIME2STAFF_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CDC_TIME2STAFF_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CDC_TIME_TO_STAFF_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CDC_TIME_TO_STAFF_STG table');
		INSERT INTO HHS_HR.DSS_CDC_TIME_TO_STAFF_STG
			(STAFFING_ORGANIZATION
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
			, REVIEW_RETURN_DATE)
		SELECT
			 X.STAFFING_ORGANIZATION
			, X.REQUEST_NUMBER
			, TO_DATE(SUBSTR(X.REQUEST_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_CREATE_DATE
			, TO_DATE(SUBSTR(X.REQUEST_APPROVAL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_APPROVAL_DATE
			, X.REQUEST_STATUS
			, X.REQUEST_TYPE
			, X.POSITION_TITLE
			, X.PAYPLAN_SERIES_GRADE
			, X.AREA_CONSIDER
			, X.CERTIFICATE_NUMBER
			, X.CERTIFICATE_SERIES
			, X.CERTIFICATE_GRADE
			, X.CERTIFICATE_LOCATION
			, TO_DATE(SUBSTR(X.CERTIFICATE_ISSUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERTIFICATE_ISSUE_DATE
			, TO_DATE(SUBSTR(X.REVIEW_RETURN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_RETURN_DATE
		FROM HHS_HR.INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_TimeToStaff"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					STAFFING_ORGANIZATION             VARCHAR2(122)     PATH 'Certificate__Vacancy__Staffing__Organization__Name'
					, REQUEST_NUMBER                  VARCHAR2(202)     PATH 'Certificate__Request__Number'
					, REQUEST_CREATE_DATE_STR         VARCHAR2(50)      PATH 'Certificate__Request__Creation__Date'
					, REQUEST_APPROVAL_DATE_STR       VARCHAR2(50)      PATH 'Certificate__Request__Approval__Date'
					, REQUEST_STATUS                  VARCHAR2(1002)    PATH 'Certificate__Request__Status'
					, REQUEST_TYPE                    VARCHAR2(1002)    PATH 'Certificate__Request__Type'
					, POSITION_TITLE                  VARCHAR2(202)     PATH 'Position__Title'
					, PAYPLAN_SERIES_GRADE            VARCHAR2(1000)    PATH 'Pay__Plan_x002dSeries_x002dGrade'
					, AREA_CONSIDER                   VARCHAR2(24)      PATH 'Area__of__Consideration'
					, CERTIFICATE_NUMBER              VARCHAR2(102)     PATH 'Certificate__Number'
					, CERTIFICATE_SERIES              VARCHAR2(1028)    PATH 'Certificate__Series'
					, CERTIFICATE_GRADE               VARCHAR2(502)     PATH 'Certificate__Grade'
					, CERTIFICATE_LOCATION            VARCHAR2(2050)    PATH 'Certificate__Location'
					, CERTIFICATE_ISSUE_DATE_STR      VARCHAR2(50)      PATH 'Certificate__Issue__Date'
					, REVIEW_RETURN_DATE_STR          VARCHAR2(50)      PATH 'Certificate__Review__Returned__Date'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CDC_TIME2STAFF_TABLE: Invalid TIME TO STAFF data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_TIME2STAFF_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CDC_TIME2OFFER_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_TIME2OFFER_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CDC_TIME2OFFER_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CDC_TIME_TO_OFFER_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CDC_TIME_TO_OFFER_STG table');
		INSERT INTO HHS_HR.DSS_CDC_TIME_TO_OFFER_STG
			(STAFFING_ORGANIZATION
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
			, EOD_DATE)
		SELECT
			X.STAFFING_ORGANIZATION
			, X.REQUEST_NUMBER
			, X.PD_NUMBER
			, TO_DATE(SUBSTR(X.NEW_HIRE_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS NEW_HIRE_CREATE_DATE
			, X.REQUEST_STATUS
			, X.REQUEST_TYPE
			, X.POSITION_TITLE
			, X.AREA_CONSIDER
			, X.NEW_HIRE_PAY_PLAN
			, X.NEW_HIRE_SERIES
			, X.NEW_HIRE_GRADE
			, TO_DATE(SUBSTR(X.SEND_TENT_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_TENT_OFFR_CMPL_DATE
			, TO_DATE(SUBSTR(X.INIT_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS INIT_BKGRND_INVST_DATE
			, TO_DATE(SUBSTR(X.RCVE_BKGRND_INVST_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RCVE_BKGRND_INVST_DATE
			, TO_DATE(SUBSTR(X.SEND_OFCL_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_OFCL_OFFR_CMPL_DATE
			, X.NEW_HIRE_NAME
			, TO_DATE(SUBSTR(X.EOD_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS EOD_DATE
		FROM HHS_HR.INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_TimeToOffer"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					STAFFING_ORGANIZATION             VARCHAR2(122)     PATH 'New__Hire__Staffing__Organization'
					, REQUEST_NUMBER                  VARCHAR2(202)     PATH 'New__Hire__Request__Number'
					, PD_NUMBER                       VARCHAR2(2050)    PATH 'New__Hire__Position__Description__Number'
					, NEW_HIRE_CREATE_DATE_STR        VARCHAR2(50)      PATH 'New__Hire__Creation__Date'
					, REQUEST_STATUS                  VARCHAR2(1002)    PATH 'New__Hire__Request__Status'
					, REQUEST_TYPE                    VARCHAR2(1002)    PATH 'New__Hire__Request__Type'
					, POSITION_TITLE                  VARCHAR2(2050)    PATH 'Position__Title'
					, AREA_CONSIDER                   VARCHAR2(24)      PATH 'Area__of__Consideration'
					, NEW_HIRE_PAY_PLAN               VARCHAR2(2050)    PATH 'Pay__Plan'
					, NEW_HIRE_SERIES                 VARCHAR2(2050)    PATH 'Series'
					, NEW_HIRE_GRADE                  VARCHAR2(2050)    PATH 'Grade'
					, SEND_TENT_OFFR_CMPL_DATE_STR    VARCHAR2(50)      PATH 'Send__Tentative__Offer__Complete__Date'
					, INIT_BKGRND_INVST_DATE_STR      VARCHAR2(50)      PATH 'Initiate__Background__Investigation__Complete__Date'
					, RCVE_BKGRND_INVST_DATE_STR      VARCHAR2(50)      PATH 'Receive__Background__Investigation_x002fSecurity__Clearance__Complete__Date'
					, SEND_OFCL_OFFR_CMPL_DATE_STR    VARCHAR2(50)      PATH 'Send__Official__Offer__Complete__Date'
					, NEW_HIRE_NAME                   VARCHAR2(2050)    PATH 'New__Hire__Name'
					, EOD_DATE_STR                    VARCHAR2(50)      PATH 'Entrance__On__Duty__Date'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CDC_TIME2OFFER_TABLE: Invalid TIME TO OFFER data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_TIME2OFFER_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2OFFER_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2OFFER_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2OFFER_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/


CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CDC_CERT_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_CERT_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CDC_CERT_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CDC_CERTIFICATE_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CDC_CERTIFICATE_STG table');
		INSERT INTO HHS_HR.DSS_CDC_CERTIFICATE_STG
			(REQUEST_NUMBER
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
			, HIRING_AUTHORITY)
		SELECT
			X.REQUEST_NUMBER
			, X.REQUEST_TYPE
			, X.CERTIFICATE_NUMBER
			, X.VACANCY_NUMBER
			, X.POSITION_TITLE
			, X.PAYPLAN_SERIES_GRADE
			, X.CERTIFICATE_SERIES
			, X.CERTIFICATE_GRADE
			, X.ANNOUNCEMENT_NUMBER
			, X.ANNOUNCEMENT_CTRL_NUMBER
			, TO_DATE(SUBSTR(X.ANNOUNCEMENT_OPEN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_OPEN_DATE
			, TO_DATE(SUBSTR(X.ANNOUNCEMENT_CLOSE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_CLOSE_DATE
			, TO_DATE(SUBSTR(X.CERTIFICATE_ISSUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERTIFICATE_ISSUE_DATE
			, TO_DATE(SUBSTR(X.REVIEW_RETURN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_RETURN_DATE
			, TO_DATE(SUBSTR(X.CERT_SIGNED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERT_SIGNED_DATE
			, TO_DATE(SUBSTR(X.CERT_EXPIRED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERT_EXPIRED_DATE
			, X.TOTAL_APPLICANTS
			, X.HIRING_AUTHORITY
		FROM HHS_HR.INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_Certificates"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                    VARCHAR2(202)   PATH 'Request__Number'
					, REQUEST_TYPE                    VARCHAR2(1002)  PATH 'Request__Type'
					, CERTIFICATE_NUMBER              VARCHAR2(102)   PATH 'Certificate__Number'
					, VACANCY_NUMBER                  NUMBER(10)      PATH 'Vacancy__Number'
					, POSITION_TITLE                  VARCHAR2(202)   PATH 'Position__Title'
					, PAYPLAN_SERIES_GRADE            VARCHAR2(1000)  PATH 'Pay__Plan__Series__Grade'
					, CERTIFICATE_SERIES              VARCHAR2(502)   PATH 'Certificate__Series'
					, CERTIFICATE_GRADE	              VARCHAR2(56)    PATH 'Certificate__Grade'
					, ANNOUNCEMENT_NUMBER             VARCHAR2(56)    PATH 'Announcement__Number'
					, ANNOUNCEMENT_CTRL_NUMBER        NUMBER(10,0)    PATH 'Announcement__Control__Number'
					, ANNOUNCEMENT_OPEN_DATE_STR      VARCHAR2(50)    PATH 'Announcement__Open__Date'
					, ANNOUNCEMENT_CLOSE_DATE_STR     VARCHAR2(50)    PATH 'Announcement__Close__Date'
					, CERTIFICATE_ISSUE_DATE_STR      VARCHAR2(50)    PATH 'Certificate__Issue__Date'
					, REVIEW_RETURN_DATE_STR          VARCHAR2(50)    PATH 'Certificate__Review__Returned__Date'
					, CERT_SIGNED_DATE_STR            VARCHAR2(50)    PATH 'Certificate__Signed__Date'
					, CERT_EXPIRED_DATE_STR           VARCHAR2(50)    PATH 'Certificate__Expired_Date'
					, TOTAL_APPLICANTS                NUMBER(4)       PATH 'Total__Applicants'
					, HIRING_AUTHORITY                VARCHAR2(202)   PATH 'Hiring__Authority'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CDC_CERT_TABLE: Invalid TIME TO OFFER data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_CERT_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_CERT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_CERT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_CERT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CDC_AUDIT_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_AUDIT_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CDC_AUDIT_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CDC_CERT_AUDIT_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CDC_CERT_AUDIT_STG table');
		INSERT INTO HHS_HR.DSS_CDC_CERT_AUDIT_STG
			(REQUEST_NUMBER
			, CERTIFICATE_NUMBER
			, AUDIT_CODE
			, AUDIT_DATE
			, CERT_LAST_UPDATE_DATE)
		SELECT
			X.REQUEST_NUMBER
			, X.CERTIFICATE_NUMBER
			, X.AUDIT_CODE
			, TO_DATE(SUBSTR(X.AUDIT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS AUDIT_DATE
			, TO_DATE(SUBSTR(X.CERT_LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERT_LAST_UPDATE_DATE
		FROM HHS_HR.INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_CertAuditCodes"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                    VARCHAR2(202)   PATH 'Request__Number'
					, CERTIFICATE_NUMBER              VARCHAR2(102)   PATH 'Certificate__Number'
					, AUDIT_CODE                      VARCHAR2(56)    PATH 'Audit__Code'
					, AUDIT_DATE_STR                  VARCHAR2(50)    PATH 'Audit__Date'
					, CERT_LAST_UPDATE_DATE_STR       VARCHAR2(50)    PATH 'Certificate__Last__Update__Date'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CDC_AUDIT_TABLE: Invalid CDC audit data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_AUDIT_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_AUDIT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_AUDIT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_AUDIT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CDC_TIME2STAFF_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_TIME2STAFF_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CDC_TIME2STAFF_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CDC_TIME_TO_STAFF_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CDC_TIME_TO_STAFF_STG table');
		INSERT INTO HHS_HR.DSS_CDC_TIME_TO_STAFF_STG
			(STAFFING_ORGANIZATION
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
			, REVIEW_RETURN_DATE)
		SELECT
			 X.STAFFING_ORGANIZATION
			, X.REQUEST_NUMBER
			, TO_DATE(SUBSTR(X.REQUEST_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_CREATE_DATE
			, TO_DATE(SUBSTR(X.REQUEST_APPROVAL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_APPROVAL_DATE
			, X.REQUEST_STATUS
			, X.REQUEST_TYPE
			, X.POSITION_TITLE
			, X.PAYPLAN_SERIES_GRADE
			, X.AREA_CONSIDER
			, X.CERTIFICATE_NUMBER
			, X.CERTIFICATE_SERIES
			, X.CERTIFICATE_GRADE
			, X.CERTIFICATE_LOCATION
			, TO_DATE(SUBSTR(X.CERTIFICATE_ISSUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERTIFICATE_ISSUE_DATE
			, TO_DATE(SUBSTR(X.REVIEW_RETURN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_RETURN_DATE
		FROM HHS_HR.INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_TimeToStaff"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					STAFFING_ORGANIZATION             VARCHAR2(122)     PATH 'Certificate__Vacancy__Staffing__Organization__Name'
					, REQUEST_NUMBER                  VARCHAR2(202)     PATH 'Certificate__Request__Number'
					, REQUEST_CREATE_DATE_STR         VARCHAR2(50)      PATH 'Certificate__Request__Creation__Date'
					, REQUEST_APPROVAL_DATE_STR       VARCHAR2(50)      PATH 'Certificate__Request__Approval__Date'
					, REQUEST_STATUS                  VARCHAR2(1002)    PATH 'Certificate__Request__Status'
					, REQUEST_TYPE                    VARCHAR2(1002)    PATH 'Certificate__Request__Type'
					, POSITION_TITLE                  VARCHAR2(202)     PATH 'Position__Title'
					, PAYPLAN_SERIES_GRADE            VARCHAR2(1000)    PATH 'Pay__Plan_x002dSeries_x002dGrade'
					, AREA_CONSIDER                   VARCHAR2(24)      PATH 'Area__of__Consideration'
					, CERTIFICATE_NUMBER              VARCHAR2(102)     PATH 'Certificate__Number'
					, CERTIFICATE_SERIES              VARCHAR2(1028)    PATH 'Certificate__Series'
					, CERTIFICATE_GRADE               VARCHAR2(502)     PATH 'Certificate__Grade'
					, CERTIFICATE_LOCATION            VARCHAR2(2050)    PATH 'Certificate__Location'
					, CERTIFICATE_ISSUE_DATE_STR      VARCHAR2(50)      PATH 'Certificate__Issue__Date'
					, REVIEW_RETURN_DATE_STR          VARCHAR2(50)      PATH 'Certificate__Review__Returned__Date'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CDC_TIME2STAFF_TABLE: Invalid TIME TO STAFF data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_TIME2STAFF_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CMS_POSSESS_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CMS_POSSESS_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CMS_POSSESS_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CMS_TIME_OF_POSSESS_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CMS_TIME_OF_POSSESS_STG table');
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
    		, SEND_OFCL_OFFR_CMPL_DATE)
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
			) X
		WHERE IDX.ID = I_ID;
		
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
/

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
    		, EOD_DATE)
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

CREATE OR REPLACE PROCEDURE HHS_HR.SP_UPDATE_CDC_ANN_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_ANN_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_CDC_ANN_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CDC_ANNOUNCEMENT_STG table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CDC_ANNOUNCEMENT_STG table');
		INSERT INTO HHS_HR.DSS_CDC_ANNOUNCEMENT_STG
			(REQUEST_NUMBER
			, ANNOUNCEMENT_NUMBER
			, ANNOUNCEMENT_CTRL_NUMBER
			, ANNOUNCEMENT_OPEN_DATE
			, ANNOUNCEMENT_CLOSE_DATE
			, ANNOUNCEMENT_RVW_STATUS
			, ANN_RVW_CMPL_DATE
			, ANN_LAST_UPDATE_DATE)
		SELECT
			X.REQUEST_NUMBER
			, X.ANNOUNCEMENT_NUMBER
			, X.ANNOUNCEMENT_CTRL_NUMBER
			, TO_DATE(SUBSTR(X.ANNOUNCEMENT_OPEN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_OPEN_DATE
			, TO_DATE(SUBSTR(X.ANNOUNCEMENT_CLOSE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANNOUNCEMENT_CLOSE_DATE
			, X.ANNOUNCEMENT_RVW_STATUS
			, TO_DATE(SUBSTR(X.ANN_RVW_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANN_RVW_CMPL_DATE
			, TO_DATE(SUBSTR(X.ANN_LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ANN_LAST_UPDATE_DATE
		FROM HHS_HR.INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_Announcement"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                    VARCHAR2(202)   PATH 'Request__Number'
					, ANNOUNCEMENT_NUMBER             VARCHAR2(56)    PATH 'Announcement__Number'
					, ANNOUNCEMENT_CTRL_NUMBER        NUMBER(10,0)    PATH 'Announcement__Control__Number'
					, ANNOUNCEMENT_OPEN_DATE_STR      VARCHAR2(50)    PATH 'Announcement__Open__Date'
					, ANNOUNCEMENT_CLOSE_DATE_STR     VARCHAR2(50)    PATH 'Announcement__Close__Date'
					, ANNOUNCEMENT_RVW_STATUS         VARCHAR2(1002)  PATH 'Announcement__Review__Status'
					, ANN_RVW_CMPL_DATE_STR           VARCHAR2(50)    PATH 'Announcement__Review__Completion__Date'
					, ANN_LAST_UPDATE_DATE_STR        VARCHAR2(50)    PATH 'Announcement__Last__Update__Date'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_CDC_ANN_TABLE: Invalid CDC audit data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CDC_ANN_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_ANN_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		HHS_HR.SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_ANN_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		HHS_HR.SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CDC_ANN_TABLE -------------------');
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