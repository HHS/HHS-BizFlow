

SET DEFINE OFF;




--------------------------------------------------------
--  DDL for Procedure SP_ERROR_LOG
--------------------------------------------------------

/**
 * Stores database errors to ERROR_LOG table to help troubleshooting.
 *
 */
CREATE OR REPLACE PROCEDURE SP_ERROR_LOG
IS
	PRAGMA AUTONOMOUS_TRANSACTION;
	V_CODE      PLS_INTEGER := SQLCODE;
	V_MSG       VARCHAR2(32767) := SQLERRM;
BEGIN
	INSERT INTO ERROR_LOG
	(
		ERROR_CD
		, ERROR_MSG
		, BACKTRACE
		, CALLSTACK
		, CRT_DT
		, CRT_USR
	)
	VALUES (
		V_CODE
		, V_MSG
		, SYS.DBMS_UTILITY.FORMAT_ERROR_BACKTRACE
		, SYS.DBMS_UTILITY.FORMAT_CALL_STACK
		, SYSDATE
		, USER
	);

	COMMIT;
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
CREATE OR REPLACE PROCEDURE SP_UPDATE_INTG_DATA
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
		SELECT COUNT(*) INTO V_REC_CNT FROM INTG_DATA_DTL WHERE ID = V_ID;
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

		UPDATE INTG_DATA_DTL
		SET
			INTG_TYPE = V_INTG_TYPE
			, FIELD_DATA = V_XMLDOC
			, MOD_DT = SYSDATE
			, MOD_USR = V_USER
		WHERE ID = V_ID
		;

	ELSE
		--DBMS_OUTPUT.PUT_LINE('No record found so that new record will be inserted.');

		INSERT INTO INTG_DATA_DTL
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

	IF V_INTG_TYPE = 'VACANCY' THEN
		SP_UPDATE_VACANCY_TABLE(V_ID);
	END IF;

	COMMIT;

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('Error occurred while executing SP_UPDATE_INTG_DATA -------------------');
END;

/






--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_VACANCY_TABLE
--------------------------------------------------------

/**
 * Parses Vacancy XML data and stores it
 * into the operational tables for Vacancy.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_VACANCY_TABLE
(
	I_ID                IN      NUMBER
)
IS
	V_JOB_REQ_ID                NUMBER(20);
	V_JOB_REQ_NUM               NVARCHAR2(50);
	V_CLOBVALUE                 CLOB;
	V_VALUE                     NVARCHAR2(4000);
	V_VALUE_LOOKUP              NVARCHAR2(2000);
	V_REC_CNT                   NUMBER(10);
	V_XMLDOC                    XMLTYPE;
	V_XMLVALUE                  XMLTYPE;
	V_ERRCODE                   NUMBER(10);
	V_ERRMSG                    VARCHAR2(512);
	E_INVALID_REC_ID            EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_REC_ID, -20910);
	E_INVALID_VACANCY_DATA     EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_VACANCY_DATA, -20911);
BEGIN
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_VACANCY_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20910, 'SP_UPDATE_VACANCY_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN

		--------------------------------
		-- DSS_VACANCY_DETAIL table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_DETAIL table');
		MERGE INTO DSS_VACANCY_DETAIL TRG
		USING
		(
			SELECT
				X.VACANCY_NUMBER
				, X.VACANCY_STATUS
				, X.JOB_TITLE
				, X.VACANCY_DESCRIPTION
				, X.VACANCY_TYPE
				, X.DISPLAY_TYPE
				, X.IS_INTERNAL_MERIT_PROMO
				, X.IS_PUBLIC
				, X.IS_STATUS
				, TO_DATE(SUBSTR(X.CREATION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CREATION_DATE
				, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
				, X.ANNOUNCEMENT_NUMBER
				, X.IS_UNDER_LITIGATION
				, X.ORGANIZATION_NAME
				, X.ORGANIZATION_CODE
				, X.OFFICE_NAME
				, X.OFFICE_CODE
				, X.ADDRESS_LINE_1
				, X.ADDRESS_LINE_2
				, X.ADDRESS_LINE_3
				, X.CITY
				, X.STATE_ABBREV
				, X.POSTALCODE
				, X.COUNTRY
				, X.HIRING_ORGANIZATION_NAME
				, X.ACWA
				, X.AGE_SCREENING
				, X.APPLICANT_UPDT_RESTRICTED
				, X.APPLY_ONLINE
				, X.CITIZENSHIP_SCREENING
				, X.IS_AGE_FORMULA
				, X.HAS_MAX_AGE
				, X.HAS_MIN_AGE
				, X.MAX_AGE
				, X.MIN_AGE
				, X.PERIOD_OF_ELIGIBILITY
				, X.RELOCATION
				, X.RNO
				, X.SECURITY_CLEARANCE
				, X.SUPERVISORY_POSITION
				, X.TRAVEL_PREFERENCE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyDetail"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
						, VACANCY_STATUS                    VARCHAR2(10)    PATH 'Vacancy__Status'
						, JOB_TITLE                         VARCHAR2(100)   PATH 'Vacancy__USAJOBS__Job__Title'
						, VACANCY_DESCRIPTION               VARCHAR2(50)    PATH 'Vacancy__Description'
						, VACANCY_TYPE                      VARCHAR2(30)    PATH 'Vacancy__Type'
						, DISPLAY_TYPE                      VARCHAR2(30)    PATH 'Vacancy__USAJOBS__Display__Type'
						, IS_INTERNAL_MERIT_PROMO           VARCHAR2(3)     PATH 'Vacancy__USAJOBS__Announcement__Type___x0028Is__Internal__Merit__Promotion_x0029'
						, IS_PUBLIC                         VARCHAR2(3)     PATH 'Vacancy__USAJOBS__Announcement__Type___x0028Is__Public_x0029'
						, IS_STATUS                         VARCHAR2(3)     PATH 'Vacancy__USAJOBS__Announcement__Type___x0028Is__Status_x0029'
						, CREATION_DATE_STR                 VARCHAR2(50)    PATH 'Vacancy__Creation__Date'
						, LAST_UPDATE_DATE_STR              VARCHAR2(50)    PATH 'Vacancy__Last__Update__Date_x002fTime'
						, ANNOUNCEMENT_NUMBER               VARCHAR2(30)    PATH 'Announcement__Number'
						, IS_UNDER_LITIGATION               VARCHAR2(3)     PATH 'Vacancy__Is__Under__Litigation'
						, ORGANIZATION_NAME                 VARCHAR2(100)   PATH 'Vacancy__Staffing__Organization__Name'
						, ORGANIZATION_CODE                 VARCHAR2(4)     PATH 'Vacancy__Staffing__Organization__Code'
						, OFFICE_NAME                       VARCHAR2(100)   PATH 'Vacancy__Staffing__Office__Name'
						, OFFICE_CODE                       VARCHAR2(4)     PATH 'Vacancy__Staffing__Office__Code'
						, ADDRESS_LINE_1                    VARCHAR2(75)    PATH 'Vacancy__Staffing__Office__Address__Line__1'
						, ADDRESS_LINE_2                    VARCHAR2(75)    PATH 'Vacancy__Staffing__Office__Address__Line__2'
						, ADDRESS_LINE_3                    VARCHAR2(75)    PATH 'Vacancy__Staffing__Office__Address__Line__3'
						, CITY                              VARCHAR2(50)    PATH 'Vacancy__Staffing__Office__Address__City'
						, STATE_ABBREV                      VARCHAR2(3)     PATH 'Vacancy__Staffing__Office__Address__State__Abbreviation'
						, POSTALCODE                        VARCHAR2(10)    PATH 'Vacancy__Staffing__Office__Address__Postal__Code'
						, COUNTRY                           VARCHAR2(50)    PATH 'Vacancy__Staffing__Office__Address__Country'
						, HIRING_ORGANIZATION_NAME          VARCHAR2(100)   PATH 'Vacancy__Staffing__Hiring__Organization__Name'
						, ACWA                              VARCHAR2(3)     PATH 'Vacancy__ACWA'
						, AGE_SCREENING                     VARCHAR2(3)     PATH 'Vacancy__Age__Screening'
						, APPLICANT_UPDT_RESTRICTED         VARCHAR2(3)     PATH 'Vacancy__Applicant__Update__Restricted'
						, APPLY_ONLINE                      VARCHAR2(3)     PATH 'Vacancy__Apply__Online'
						, CITIZENSHIP_SCREENING             VARCHAR2(3)     PATH 'Vacancy__Citizenship__Screening'
						, IS_AGE_FORMULA                    VARCHAR2(3)     PATH 'Vacancy__Is__Age__Formula'
						, HAS_MAX_AGE                       VARCHAR2(3)     PATH 'Vacancy__Has__Maximum__Age'
						, HAS_MIN_AGE                       VARCHAR2(3)     PATH 'Vacancy__Has__Minimum__Age'
						, MAX_AGE                           NUMBER(3)       PATH 'Vacancy__Maximum__Age'
						, MIN_AGE                           NUMBER(3)       PATH 'Vacancy__Minimum__Age'
						, PERIOD_OF_ELIGIBILITY             NUMBER(2)       PATH 'Vacancy__Period__of__Eligibility'
						, RELOCATION                        VARCHAR2(3)     PATH 'Vacancy__Relocation'
						, RNO                               VARCHAR2(3)     PATH 'Vacancy__RNO'
						, SECURITY_CLEARANCE                VARCHAR2(50)    PATH 'Vacancy__Security__Clearance'
						, SUPERVISORY_POSITION              VARCHAR2(3)     PATH 'Vacancy__Supervisory__Position'
						, TRAVEL_PREFERENCE                 VARCHAR2(25)    PATH 'Vacancy__Travel__Preference'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.VACANCY_NUMBER = TRG.VACANCY_NUMBER)
		WHEN MATCHED THEN UPDATE SET
			--TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			TRG.VACANCY_STATUS                  = SRC.VACANCY_STATUS
			, TRG.JOB_TITLE                     = SRC.JOB_TITLE
			, TRG.VACANCY_DESCRIPTION           = SRC.VACANCY_DESCRIPTION
			, TRG.VACANCY_TYPE                  = SRC.VACANCY_TYPE
			, TRG.DISPLAY_TYPE                  = SRC.DISPLAY_TYPE
			, TRG.IS_INTERNAL_MERIT_PROMO       = SRC.IS_INTERNAL_MERIT_PROMO
			, TRG.IS_PUBLIC                     = SRC.IS_PUBLIC
			, TRG.IS_STATUS                     = SRC.IS_STATUS
			, TRG.CREATION_DATE                 = SRC.CREATION_DATE
			, TRG.LAST_UPDATE_DATE              = SRC.LAST_UPDATE_DATE
			, TRG.ANNOUNCEMENT_NUMBER           = SRC.ANNOUNCEMENT_NUMBER
			, TRG.IS_UNDER_LITIGATION           = SRC.IS_UNDER_LITIGATION
			, TRG.ORGANIZATION_NAME             = SRC.ORGANIZATION_NAME
			, TRG.ORGANIZATION_CODE             = SRC.ORGANIZATION_CODE
			, TRG.OFFICE_NAME                   = SRC.OFFICE_NAME
			, TRG.OFFICE_CODE                   = SRC.OFFICE_CODE
			, TRG.ADDRESS_LINE_1                = SRC.ADDRESS_LINE_1
			, TRG.ADDRESS_LINE_2                = SRC.ADDRESS_LINE_2
			, TRG.ADDRESS_LINE_3                = SRC.ADDRESS_LINE_3
			, TRG.CITY                          = SRC.CITY
			, TRG.STATE_ABBREV                  = SRC.STATE_ABBREV
			, TRG.POSTALCODE                    = SRC.POSTALCODE
			, TRG.COUNTRY                       = SRC.COUNTRY
			, TRG.HIRING_ORGANIZATION_NAME      = SRC.HIRING_ORGANIZATION_NAME
			, TRG.ACWA                          = SRC.ACWA
			, TRG.AGE_SCREENING                 = SRC.AGE_SCREENING
			, TRG.APPLICANT_UPDT_RESTRICTED     = SRC.APPLICANT_UPDT_RESTRICTED
			, TRG.APPLY_ONLINE                  = SRC.APPLY_ONLINE
			, TRG.CITIZENSHIP_SCREENING         = SRC.CITIZENSHIP_SCREENING
			, TRG.IS_AGE_FORMULA                = SRC.IS_AGE_FORMULA
			, TRG.HAS_MAX_AGE                   = SRC.HAS_MAX_AGE
			, TRG.HAS_MIN_AGE                   = SRC.HAS_MIN_AGE
			, TRG.MAX_AGE                       = SRC.MAX_AGE
			, TRG.MIN_AGE                       = SRC.MIN_AGE
			, TRG.PERIOD_OF_ELIGIBILITY         = SRC.PERIOD_OF_ELIGIBILITY
			, TRG.RELOCATION                    = SRC.RELOCATION
			, TRG.RNO                           = SRC.RNO
			, TRG.SECURITY_CLEARANCE            = SRC.SECURITY_CLEARANCE
			, TRG.SUPERVISORY_POSITION          = SRC.SUPERVISORY_POSITION
			, TRG.TRAVEL_PREFERENCE             = SRC.TRAVEL_PREFERENCE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.VACANCY_NUMBER
			, TRG.VACANCY_STATUS
			, TRG.JOB_TITLE
			, TRG.VACANCY_DESCRIPTION
			, TRG.VACANCY_TYPE
			, TRG.DISPLAY_TYPE
			, TRG.IS_INTERNAL_MERIT_PROMO
			, TRG.IS_PUBLIC
			, TRG.IS_STATUS
			, TRG.CREATION_DATE
			, TRG.LAST_UPDATE_DATE
			, TRG.ANNOUNCEMENT_NUMBER
			, TRG.IS_UNDER_LITIGATION
			, TRG.ORGANIZATION_NAME
			, TRG.ORGANIZATION_CODE
			, TRG.OFFICE_NAME
			, TRG.OFFICE_CODE
			, TRG.ADDRESS_LINE_1
			, TRG.ADDRESS_LINE_2
			, TRG.ADDRESS_LINE_3
			, TRG.CITY
			, TRG.STATE_ABBREV
			, TRG.POSTALCODE
			, TRG.COUNTRY
			, TRG.HIRING_ORGANIZATION_NAME
			, TRG.ACWA
			, TRG.AGE_SCREENING
			, TRG.APPLICANT_UPDT_RESTRICTED
			, TRG.APPLY_ONLINE
			, TRG.CITIZENSHIP_SCREENING
			, TRG.IS_AGE_FORMULA
			, TRG.HAS_MAX_AGE
			, TRG.HAS_MIN_AGE
			, TRG.MAX_AGE
			, TRG.MIN_AGE
			, TRG.PERIOD_OF_ELIGIBILITY
			, TRG.RELOCATION
			, TRG.RNO
			, TRG.SECURITY_CLEARANCE
			, TRG.SUPERVISORY_POSITION
			, TRG.TRAVEL_PREFERENCE
		)
		VALUES
		(
			SRC.VACANCY_NUMBER
			, SRC.VACANCY_STATUS
			, SRC.JOB_TITLE
			, SRC.VACANCY_DESCRIPTION
			, SRC.VACANCY_TYPE
			, SRC.DISPLAY_TYPE
			, SRC.IS_INTERNAL_MERIT_PROMO
			, SRC.IS_PUBLIC
			, SRC.IS_STATUS
			, SRC.CREATION_DATE
			, SRC.LAST_UPDATE_DATE
			, SRC.ANNOUNCEMENT_NUMBER
			, SRC.IS_UNDER_LITIGATION
			, SRC.ORGANIZATION_NAME
			, SRC.ORGANIZATION_CODE
			, SRC.OFFICE_NAME
			, SRC.OFFICE_CODE
			, SRC.ADDRESS_LINE_1
			, SRC.ADDRESS_LINE_2
			, SRC.ADDRESS_LINE_3
			, SRC.CITY
			, SRC.STATE_ABBREV
			, SRC.POSTALCODE
			, SRC.COUNTRY
			, SRC.HIRING_ORGANIZATION_NAME
			, SRC.ACWA
			, SRC.AGE_SCREENING
			, SRC.APPLICANT_UPDT_RESTRICTED
			, SRC.APPLY_ONLINE
			, SRC.CITIZENSHIP_SCREENING
			, SRC.IS_AGE_FORMULA
			, SRC.HAS_MAX_AGE
			, SRC.HAS_MIN_AGE
			, SRC.MAX_AGE
			, SRC.MIN_AGE
			, SRC.PERIOD_OF_ELIGIBILITY
			, SRC.RELOCATION
			, SRC.RNO
			, SRC.SECURITY_CLEARANCE
			, SRC.SUPERVISORY_POSITION
			, SRC.TRAVEL_PREFERENCE
		)
		;


		--------------------------------
		-- DSS_VACANCY_CUSTOMER table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_CUSTOMER table');
		MERGE INTO DSS_VACANCY_CUSTOMER TRG
		USING
		(
			SELECT
				X.VACANCY_NUMBER
				, X.CUSTOMER_NAME
				, X.DEPARTMENT_NAME
				, X.DEPARTMENT_CODE
				, X.AGENCY_NAME
				, X.AGENCY_CODE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyCustomer"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
						, CUSTOMER_NAME                     VARCHAR2(100)   PATH 'Vacancy__Customer__Name'
						, DEPARTMENT_NAME                   VARCHAR2(100)   PATH 'Vacancy__Customer__Department__Name'
						, DEPARTMENT_CODE                   VARCHAR2(4)     PATH 'Vacancy__Customer__Department__Code'
						, AGENCY_NAME                       VARCHAR2(100)   PATH 'Vacancy__Customer__Agency__Name'
						, AGENCY_CODE                       VARCHAR2(4)     PATH 'Vacancy__Customer__Agency__Code'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.VACANCY_NUMBER = TRG.VACANCY_NUMBER AND SRC.CUSTOMER_NAME = TRG.CUSTOMER_NAME)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			--TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			--TRG.CUSTOMER_NAME                   = SRC.CUSTOMER_NAME
			TRG.DEPARTMENT_NAME                 = SRC.DEPARTMENT_NAME
			, TRG.DEPARTMENT_CODE               = SRC.DEPARTMENT_CODE
			, TRG.AGENCY_NAME                   = SRC.AGENCY_NAME
			, TRG.AGENCY_CODE                   = SRC.AGENCY_CODE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.VACANCY_NUMBER
			, TRG.CUSTOMER_NAME
			, TRG.DEPARTMENT_NAME
			, TRG.DEPARTMENT_CODE
			, TRG.AGENCY_NAME
			, TRG.AGENCY_CODE
		)
		VALUES
		(
			SRC.VACANCY_NUMBER
			, SRC.CUSTOMER_NAME
			, SRC.DEPARTMENT_NAME
			, SRC.DEPARTMENT_CODE
			, SRC.AGENCY_NAME
			, SRC.AGENCY_CODE
		)
		;


		--------------------------------
		-- DSS_VACANCY_ELIGIBILITY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_ELIGIBILITY table');
		MERGE INTO DSS_VACANCY_ELIGIBILITY TRG
		USING
		(
			SELECT
				X.VACANCY_NUMBER
				, X.ELIGIBILITY
				, X.ELIGIBILITY_LABEL
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyEligibility"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
						, ELIGIBILITY                       VARCHAR2(100)   PATH 'Vacancy__Eligibility'
						, ELIGIBILITY_LABEL                 VARCHAR2(30)    PATH 'Vacancy__Eligibility__Label'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.VACANCY_NUMBER = TRG.VACANCY_NUMBER AND SRC.ELIGIBILITY = TRG.ELIGIBILITY)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			--TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			--TRG.ELIGIBILITY                     = SRC.ELIGIBILITY
			TRG.ELIGIBILITY_LABEL               = SRC.ELIGIBILITY_LABEL
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.VACANCY_NUMBER
			, TRG.ELIGIBILITY
			, TRG.ELIGIBILITY_LABEL
		)
		VALUES
		(
			SRC.VACANCY_NUMBER
			, SRC.ELIGIBILITY
			, SRC.ELIGIBILITY_LABEL
		)
		;


		--------------------------------
		-- DSS_VACANCY_POSITION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_POSITION table');
		MERGE INTO DSS_VACANCY_POSITION TRG
		USING
		(
			SELECT
				X.VACANCY_NUMBER
				, X.POSITION_DESCRIPTION
				, X.POSITION_DESCRIPTION_TITLE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyPosition"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
						, POSITION_DESCRIPTION              VARCHAR2(50)    PATH 'Vacancy__Position__Description__Number'
						, POSITION_DESCRIPTION_TITLE        VARCHAR2(100)   PATH 'Vacancy__Position__Description__Title'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.VACANCY_NUMBER = TRG.VACANCY_NUMBER AND SRC.POSITION_DESCRIPTION = TRG.POSITION_DESCRIPTION)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			--TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			--TRG.POSITION_DESCRIPTION            = SRC.POSITION_DESCRIPTION
			TRG.POSITION_DESCRIPTION_TITLE      = SRC.POSITION_DESCRIPTION_TITLE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.VACANCY_NUMBER
			, TRG.POSITION_DESCRIPTION
			, TRG.POSITION_DESCRIPTION_TITLE
		)
		VALUES
		(
			SRC.VACANCY_NUMBER
			, SRC.POSITION_DESCRIPTION
			, SRC.POSITION_DESCRIPTION_TITLE
		)
		;


		--------------------------------
		-- DSS_VACANCY_SPECIALTY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_SPECIALTY table');
		MERGE INTO DSS_VACANCY_SPECIALTY TRG
		USING
		(
			SELECT
				X.VACANCY_NUMBER
				, X.SPECIALTY
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancySpecialty"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
						, SPECIALTY                         VARCHAR2(50)    PATH 'Vacancy__Specialty'

--TODO: older xml has other specialty detail fields (Vacancy__Grade, Vacancy__Series).  Which one is correct?
--      If only two columns, update should be removed, only insert makes sense

				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.VACANCY_NUMBER = TRG.VACANCY_NUMBER AND SRC.SPECIALTY = TRG.SPECIALTY)

--TODO: finalize the match condition

		--WHEN MATCHED THEN UPDATE SET
			--TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
		--	TRG.SPECIALTY                       = SRC.SPECIALTY
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.VACANCY_NUMBER
			, TRG.SPECIALTY
		)
		VALUES
		(
			SRC.VACANCY_NUMBER
			, SRC.SPECIALTY
		)
		;


		--------------------------------
		-- DSS_VACANCY_DOCUMENT table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_DOCUMENT table');
		MERGE INTO DSS_VACANCY_DOCUMENT TRG
		USING
		(
			SELECT
				X.VACANCY_NUMBER
				, X.SUPPORTING_DOC_TYPE
				, X.SUPPORTING_DOC_CUSTM_TITLE
				, X.REQUIRED_DOC
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyDocuments"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
						, SUPPORTING_DOC_TYPE               VARCHAR2(50)    PATH 'Vacancy__Supporting__Document__Type'
						, SUPPORTING_DOC_CUSTM_TITLE        VARCHAR2(100)   PATH 'Vacancy__Supporting__Document__Custom__Title'
						, REQUIRED_DOC                      VARCHAR2(3)     PATH 'Vacancy__Required__Document'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.VACANCY_NUMBER = TRG.VACANCY_NUMBER AND SRC.SUPPORTING_DOC_TYPE = TRG.SUPPORTING_DOC_TYPE)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			--TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			--TRG.SUPPORTING_DOC_TYPE             = SRC.SUPPORTING_DOC_TYPE
			TRG.SUPPORTING_DOC_CUSTM_TITLE      = SRC.SUPPORTING_DOC_CUSTM_TITLE
			, TRG.REQUIRED_DOC                  = SRC.REQUIRED_DOC
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.VACANCY_NUMBER
			, TRG.SUPPORTING_DOC_TYPE
			, TRG.SUPPORTING_DOC_CUSTM_TITLE
			, TRG.REQUIRED_DOC
		)
		VALUES
		(
			SRC.VACANCY_NUMBER
			, SRC.SUPPORTING_DOC_TYPE
			, SRC.SUPPORTING_DOC_CUSTM_TITLE
			, SRC.REQUIRED_DOC
		)
		;


		--------------------------------
		-- DSS_VACANCY_REQUEST table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_REQUEST table');
		MERGE INTO DSS_VACANCY_REQUEST TRG
		USING
		(
			SELECT
				X.VACANCY_NUMBER
				, X.REQUEST_NUMBER
				, X.REQUEST_STATUS
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyRequest"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
						, REQUEST_NUMBER                    VARCHAR2(50)    PATH 'Request__Number'
						, REQUEST_STATUS                    VARCHAR2(30)    PATH 'Request__Status'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.VACANCY_NUMBER = TRG.VACANCY_NUMBER AND SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			--TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			--TRG.REQUEST_NUMBER                  = SRC.REQUEST_NUMBER
			TRG.REQUEST_STATUS                  = SRC.REQUEST_STATUS
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.VACANCY_NUMBER
			, TRG.REQUEST_NUMBER
			, TRG.REQUEST_STATUS
		)
		VALUES
		(
			SRC.VACANCY_NUMBER
			, SRC.REQUEST_NUMBER
			, SRC.REQUEST_STATUS
		)
		;


	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20911, 'SP_UPDATE_VACANCY_TABLE: Invalid VACANCY data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_VACANCY_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_VACANCY_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_VACANCY_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_VACANCY_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_VACANCY_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;

/