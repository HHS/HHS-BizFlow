

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
--  DDL for Procedure SP_UPDATE_ANNOUNCEMENT_TABLE
--------------------------------------------------------
/**
 * Parses Announcement XML data and stores it
 * into the operational tables for Announcement.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_ANNOUNCEMENT_TABLE
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
	PRAGMA EXCEPTION_INIT(E_INVALID_REC_ID, -20920);
	E_INVALID_ANNOUNCEMENT_DATA     EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_ANNOUNCEMENT_DATA, -20921);
BEGIN
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_ANNOUNCEMENT_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20920, 'SP_UPDATE_ANNOUNCEMENT_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_ANNOUNCEMENT_DETAIL table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_ANNOUNCEMENT_DETAIL table');
		INSERT INTO DSS_ANNOUNCEMENT_DETAIL
			(ANNOUNCEMENT_NUMBER
			, VACANCY_NUMBER
			, ANN_CONTROL_NUMBER
			, ANNOUNCEMENT_STATUS
			, IS_RELEASED
			, RELEASED_DATE
			, LAST_UPDATE_DATE
			, EXTERNAL_CONTACT_NAME
			, INTERNAL_CONTACT_NAME
			, SALARY_TYPE
			, MINIMUM_SALARY
			, MAXIMUM_SALARY
			, OPEN_DATE
			, CLOSE_DATE
			, TOTAL_VACANCIES
			, PART_TIME_HOURS
			, NOT_TO_EXCEED
			, WHO_MAY_APPLY
			, TEMPLATE)
		SELECT
			X.ANNOUNCEMENT_NUMBER
			, X.VACANCY_NUMBER
			, X.ANN_CONTROL_NUMBER
			, X.ANNOUNCEMENT_STATUS
			, X.IS_RELEASED
			, TO_DATE(SUBSTR(X.RELEASED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RELEASED_DATE
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, X.EXTERNAL_CONTACT_NAME
			, X.INTERNAL_CONTACT_NAME
			, X.SALARY_TYPE
			, X.MINIMUM_SALARY
			, X.MAXIMUM_SALARY
			, TO_DATE(SUBSTR(X.OPEN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS OPEN_DATE
			, TO_DATE(SUBSTR(X.CLOSE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CLOSE_DATE
			, X.TOTAL_VACANCIES
			, X.PART_TIME_HOURS
			, X.NOT_TO_EXCEED
			, X.WHO_MAY_APPLY
			, X.TEMPLATE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnouncementDetail"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					ANNOUNCEMENT_NUMBER                 VARCHAR2(56)      PATH 'Announcement__Number'
					, VACANCY_NUMBER                    NUMBER(10)        PATH 'Vacancy__Number'
					, ANN_CONTROL_NUMBER                NUMBER(10)        PATH 'Announcement__Control__Number'
					, ANNOUNCEMENT_STATUS               VARCHAR2(1002)    PATH 'Announcement__Status'
					, IS_RELEASED                       VARCHAR2(8)       PATH 'Announcement__Is__Released'
					, RELEASED_DATE_STR                 VARCHAR2(50)      PATH 'Announcement__Released__Date_x002fTime'
					, LAST_UPDATE_DATE_STR              VARCHAR2(50)      PATH 'Announcement__Last__Update__Date_x002fTime'
					, EXTERNAL_CONTACT_NAME             VARCHAR2(206)     PATH 'Announcement__External__Contact__Name'
					, INTERNAL_CONTACT_NAME             VARCHAR2(206)     PATH 'Announcement__Internal__Contact__Name'
					, SALARY_TYPE                       VARCHAR2(1002)    PATH 'Announcement__Salary__Type'
					, MINIMUM_SALARY                    NUMBER(19,4)      PATH 'Announcement__Minimum__Salary'
					, MAXIMUM_SALARY                    NUMBER(19,4)      PATH 'Announcement__Maximum__Salary'
					, OPEN_DATE_STR                     VARCHAR2(50)      PATH 'Announcement__Open__Date'
					, CLOSE_DATE_STR                    VARCHAR2(50)      PATH 'Announcement__Close__Date'
					, TOTAL_VACANCIES                   VARCHAR2(12)      PATH 'Announcement__Total__Vacancies'
					, PART_TIME_HOURS                   NUMBER(10)        PATH 'Announcement__Part__Time__Hours'
					, NOT_TO_EXCEED                     VARCHAR2(26)      PATH 'Announcement__Not__To__Exceed'
					, WHO_MAY_APPLY                     VARCHAR2(1002)    PATH 'Announcement__Who__May__Apply'
					, TEMPLATE                          VARCHAR2(2050)    PATH 'Announcement__Template'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_ANNOUNCEMENT_APPT_TYPE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_ANNOUNCEMENT_APPT_TYPE table');
		INSERT INTO DSS_ANNOUNCEMENT_APPT_TYPE
			(ANNOUNCEMENT_NUMBER
			, APPOINTMENT_TYPE)
		SELECT
			X.ANNOUNCEMENT_NUMBER
			, X.APPOINTMENT_TYPE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnouncementAppointmentType"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					ANNOUNCEMENT_NUMBER                 VARCHAR2(56)      PATH 'Announcement__Number'
					, APPOINTMENT_TYPE                  VARCHAR2(1002)    PATH 'Announcement__Appointment__Type'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_ANNOUNCEMENT_WORK_SCHED table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_ANNOUNCEMENT_WORK_SCHED table');
		INSERT INTO DSS_ANNOUNCEMENT_WORK_SCHED
			(ANNOUNCEMENT_NUMBER
			, WORK_SCHEDULE)
		SELECT
			X.ANNOUNCEMENT_NUMBER
			, X.WORK_SCHEDULE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnouncementWorkSchedule"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					ANNOUNCEMENT_NUMBER                 VARCHAR2(56)      PATH 'Announcement__Number'
					, WORK_SCHEDULE                     VARCHAR2(1002)    PATH 'Announcement__Work__Schedule'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_ANNOUNCEMENT_LOCATION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_ANNOUNCEMENT_LOCATION table');
		INSERT INTO DSS_ANNOUNCEMENT_LOCATION
			(ANNOUNCEMENT_NUMBER
			, LOCATION_DESCRIPTION
			, LOCATION_OPENINGS
			, CITY
			, STATE_ABBREV
			, COUNTY
			, COUNTRY
			, LOCATION_CODE)
		SELECT
			X.ANNOUNCEMENT_NUMBER
			, X.LOCATION_DESCRIPTION
			, X.LOCATION_OPENINGS
			, X.CITY
			, X.STATE_ABBREV
			, X.COUNTY
			, X.COUNTRY
			, X.LOCATION_CODE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnouncementLocation"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					ANNOUNCEMENT_NUMBER                 VARCHAR2(56)    PATH 'Announcement__Number'
					, LOCATION_DESCRIPTION              VARCHAR2(334)   PATH 'Announcement__Location__Description'
					, LOCATION_OPENINGS                 VARCHAR2(12)    PATH 'Announcement__Location__Openings'
					, CITY                              VARCHAR2(122)   PATH 'Announcement__Location__City'
					, STATE_ABBREV                      VARCHAR2(8)     PATH 'Announcement__Location__State__Abbreviation'
					, COUNTY                            VARCHAR2(202)   PATH 'Announcement__Location__County'
					, COUNTRY                           VARCHAR2(202)   PATH 'Announcement__Location__Country'
					, LOCATION_CODE                     VARCHAR2(34)    PATH 'Announcement__Location__Code'
			) X
		WHERE IDX.ID = I_ID;


	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20921, 'SP_UPDATE_ANNOUNCEMENT_TABLE: Invalid ANNOUNCEMENT data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_ANNOUNCEMENT_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_ANNOUNCEMENT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_ANNOUNCEMENT_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_ANNOUNCEMENT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_ANNOUNCEMENT_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;

/




--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_APPLICATION_TABLE
--------------------------------------------------------
/**
 * Parses Application XML data and stores it
 * into the operational tables for Application.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_APPLICATION_TABLE
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
	PRAGMA EXCEPTION_INIT(E_INVALID_REC_ID, -20930);
	E_INVALID_APPLICATION_DATA     EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_APPLICATION_DATA, -20931);
BEGIN
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_APPLICATION_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20930, 'SP_UPDATE_APPLICATION_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_APPLICATION_DETAIL table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_DETAIL table');
		INSERT INTO DSS_APPLICATION_DETAIL
			(APPLICATION_NUMBER
			, VACANCY_NUMBER
			, ANNOUNCEMENT_NUMBER
			, APP_CONTROL_NUMBER
			, APPLICATION_STATUS
			, LAST_SUBMITTED_DATE
			, FIRST_NAME
			, MIDDLE_NAME
			, LAST_NAME
			, SUFFIX
			, ADDRESS_1
			, ADDRESS_2
			, ADDRESS_3
			, POSTAL_CODE
			, CITY
			, STATE_ABBREV
			, COUNTRY
			, CITIZENSHIP
			, EMAIL
			, RECORD_STATUS_DESCRIPTION
			, RECORD_STATUS_CODE
			, CLAIMED_VET_PREF
			, CLAIMED_VET_PREF_CODE
			, ADJ_VET_PREF
			, ADJ_VET_PREF_CODE
			, VET_DOC_DATE
			, LOWEST_GRADE
			, ELIGIBILITY_START_DATE
			, ELIGIBILITY_END_DATE
			, IS_FOLLOWUP
			, IS_REVIEWED)
		SELECT
			X.APPLICATION_NUMBER
			, X.VACANCY_NUMBER
			, X.ANNOUNCEMENT_NUMBER
			, X.APP_CONTROL_NUMBER
			, X.APPLICATION_STATUS
			, TO_DATE(SUBSTR(X.LAST_SUBMITTED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_SUBMITTED_DATE
			, X.FIRST_NAME
			, X.MIDDLE_NAME
			, X.LAST_NAME
			, X.SUFFIX
			, X.ADDRESS_1
			, X.ADDRESS_2
			, X.ADDRESS_3
			, X.POSTAL_CODE
			, X.CITY
			, X.STATE_ABBREV
			, X.COUNTRY
			, X.CITIZENSHIP
			, X.EMAIL
			, X.RECORD_STATUS_DESCRIPTION
			, X.RECORD_STATUS_CODE
			, X.CLAIMED_VET_PREF
			, X.CLAIMED_VET_PREF_CODE
			, X.ADJ_VET_PREF
			, X.ADJ_VET_PREF_CODE
			, TO_DATE(SUBSTR(X.VET_DOC_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS VET_DOC_DATE
			, X.LOWEST_GRADE
			, TO_DATE(SUBSTR(X.ELIGIBILITY_START_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ELIGIBILITY_START_DATE
			, TO_DATE(SUBSTR(X.ELIGIBILITY_END_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ELIGIBILITY_END_DATE
			, X.IS_FOLLOWUP
			, X.IS_REVIEWED
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationDetail"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					APPLICATION_NUMBER                  VARCHAR2(22)     PATH 'Application__Number'
					, VACANCY_NUMBER                    NUMBER(10)       PATH 'Vacancy__Number'
					, ANNOUNCEMENT_NUMBER               VARCHAR2(56)     PATH 'Announcement__Number'
					, APP_CONTROL_NUMBER                NUMBER(10)       PATH 'Application__Control__Number'
					, APPLICATION_STATUS                VARCHAR2(1002)   PATH 'Application__Status'
					, LAST_SUBMITTED_DATE_STR           VARCHAR2(50)     PATH 'Application__Last__Submitted__Date_x002fTime'
					, FIRST_NAME                        VARCHAR2(62)     PATH 'Applicant__First__Name'
					, MIDDLE_NAME                       VARCHAR2(62)     PATH 'Applicant__Middle__Name'
					, LAST_NAME                         VARCHAR2(62)     PATH 'Applicant__Last__Name'
					, SUFFIX                            VARCHAR2(22)     PATH 'Applicant__Suffix'
					, ADDRESS_1                         VARCHAR2(202)    PATH 'Applicant__Address__Line__1'
					, ADDRESS_2                         VARCHAR2(202)    PATH 'Applicant__Address__Line__2'
					, ADDRESS_3                         VARCHAR2(202)    PATH 'Applicant__Address__Line__3'
					, POSTAL_CODE                       VARCHAR2(42)     PATH 'Applicant__Address__Postal__Code'
					, CITY                              VARCHAR2(122)    PATH 'Applicant__Address__City'
					, STATE_ABBREV                      VARCHAR2(8)      PATH 'Applicant__Address__State__Abbreviation'
					, COUNTRY                           VARCHAR2(202)    PATH 'Applicant__Address__Country'
					, CITIZENSHIP                       VARCHAR2(202)    PATH 'Applicant__Citizenship'
					, EMAIL                             VARCHAR2(258)    PATH 'Applicant__Email'
					, RECORD_STATUS_DESCRIPTION         VARCHAR2(1002)   PATH 'Application__Record__Status__Description'
					, RECORD_STATUS_CODE                VARCHAR2(102)    PATH 'Application__Record__Status__Code'
					, CLAIMED_VET_PREF                  VARCHAR2(1002)   PATH 'Application__Veterans__Preference__Claimed'
					, CLAIMED_VET_PREF_CODE             VARCHAR2(22)     PATH 'Application__Veterans__Preference__Claimed__Code'
					, ADJ_VET_PREF                      VARCHAR2(1002)   PATH 'Application__Veterans__Preference__Adjudicated'
					, ADJ_VET_PREF_CODE                 VARCHAR2(22)     PATH 'Application__Veterans__Preference__Adjudicated__Code'
					, VET_DOC_DATE_STR                  VARCHAR2(50)     PATH 'Application__Veterans__Document__Date'
					, LOWEST_GRADE                      VARCHAR2(6)      PATH 'Application__Lowest__Acceptable__Grade'
					, ELIGIBILITY_START_DATE_STR        VARCHAR2(50)     PATH 'Application__Eligibility__Start__Date'
					, ELIGIBILITY_END_DATE_STR          VARCHAR2(50)     PATH 'Application__Eligibility__End__Date'
					, IS_FOLLOWUP                       VARCHAR2(8)      PATH 'Application__Is__Followup'
					, IS_REVIEWED                       VARCHAR2(8)      PATH 'Application__Is__Reviewed'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_APPLICATION_DOCUMENT table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_DOCUMENT table');
		INSERT INTO DSS_APPLICATION_DOCUMENT
			(APPLICATION_NUMBER
			, DOC_NAME
			, DOC_TYPE
			, DOC_PROCESSED_DATE
			, APP_RETREIVED_DATE
			, DOC_HM_VIEWABLE
			, DOC_NH_VIEWABLE)
		SELECT
			X.APPLICATION_NUMBER
			, X.DOC_NAME
			, X.DOC_TYPE
			, TO_DATE(SUBSTR(X.DOC_PROCESSED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS DOC_PROCESSED_DATE
			, TO_DATE(SUBSTR(X.APP_RETREIVED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS APP_RETREIVED_DATE
			, X.DOC_HM_VIEWABLE
			, X.DOC_NH_VIEWABLE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationDocuments"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					APPLICATION_NUMBER                  VARCHAR2(22)      PATH 'Application__Number'
					, DOC_NAME                          VARCHAR2(202)     PATH 'Application__Document__Name'
					, DOC_TYPE                          VARCHAR2(1002)    PATH 'Application__Document__Type'
					, DOC_PROCESSED_DATE_STR            VARCHAR2(50)      PATH 'Application__Document__Processed__Date_x002fTime'
					, APP_RETREIVED_DATE_STR            VARCHAR2(50)      PATH 'Application__Document__Retrieved__Date_x002fTime'
					, DOC_HM_VIEWABLE                   VARCHAR2(8)       PATH 'Application__Document__HM__Viewable'
					, DOC_NH_VIEWABLE                   VARCHAR2(8)       PATH 'Application__Document__NH__Viewable'
			) X
		WHERE IDX.ID = I_ID;


		--------------------------------
		-- DSS_APPLICATION_ELIGIBILITY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_ELIGIBILITY table');
		INSERT INTO DSS_APPLICATION_ELIGIBILITY TRG
			(APPLICATION_NUMBER
			, ELIGIBILITY
			, ELIGIBILITY_ADJ)
		SELECT
			X.APPLICATION_NUMBER
			, X.ELIGIBILITY
			, X.ELIGIBILITY_ADJ
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationEligibility"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					APPLICATION_NUMBER                  VARCHAR2(22)     PATH 'Application__Number'
					, ELIGIBILITY                       VARCHAR2(202)    PATH 'Application__Eligibility'
					, ELIGIBILITY_ADJ                   VARCHAR2(1002)   PATH 'Application__Eligibility__Adjudication'
			) X
		WHERE IDX.ID = I_ID;


		--------------------------------
		-- DSS_APPLICATION_LOCATION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_LOCATION table');
		INSERT INTO DSS_APPLICATION_LOCATION
			(APPLICATION_NUMBER
			, LOCATION_DESCRIPTION
			, CITY
			, STATE_ABBREV
			, COUNTY
			, COUNTRY
			, LOCATION_CODE)
		SELECT
			X.APPLICATION_NUMBER
			, X.LOCATION_DESCRIPTION
			, X.CITY
			, X.STATE_ABBREV
			, X.COUNTY
			, X.COUNTRY
			, X.LOCATION_CODE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationLocation"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					APPLICATION_NUMBER                  VARCHAR2(22)     PATH 'Application__Number'
					, LOCATION_DESCRIPTION              VARCHAR2(334)    PATH 'Application__Location__Description'
					, CITY                              VARCHAR2(122)    PATH 'Application__Location__City'
					, STATE_ABBREV                      VARCHAR2(8)      PATH 'Application__Location__State__Abbreviation'
					, COUNTY                            VARCHAR2(202)    PATH 'Application__Location__County'
					, COUNTRY                           VARCHAR2(202)    PATH 'Application__Location__Country'
					, LOCATION_CODE                     VARCHAR2(34)     PATH 'Application__Location__Code'
			) X
		WHERE IDX.ID = I_ID;


		--------------------------------
		-- DSS_APPLICANT_PHONE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICANT_PHONE table');
		INSERT INTO DSS_APPLICANT_PHONE
			(APPLICATION_NUMBER
			, PHONE_TYPE
			, PHONE_NUMBER)
		SELECT
			X.APPLICATION_NUMBER
			, X.PHONE_TYPE
			, X.PHONE_NUMBER
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationPhone"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					APPLICATION_NUMBER                  VARCHAR2(22)     PATH 'Application__Number'
					, PHONE_TYPE                        VARCHAR2(102)    PATH 'Applicant__Phone__Type'
					, PHONE_NUMBER                      VARCHAR2(52)     PATH 'Applicant__Phone__Number'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_APPLICATION_RATING table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_RATING table');
		INSERT INTO DSS_APPLICATION_RATING
			(APPLICATION_NUMBER
			, SERIES
			, GRADE
			, SPECIALTY
			, RATING_MSG_CODE
			, DISPLAY_RATING
			, FINAL_RATING
			, AUGMENTED_RATING
			, RATING_CREATION_DATE
			, RATING_AVAIL_STATUS
			, RATING_CATEGORY_LBL
			, IS_OVERRIDE
			, RATING_MODIFIED_DATE)
		SELECT
			X.APPLICATION_NUMBER
			, X.SERIES
			, X.GRADE
			, X.SPECIALTY
			, X.RATING_MSG_CODE
			, X.DISPLAY_RATING
			, X.FINAL_RATING
			, X.AUGMENTED_RATING
			, TO_DATE(SUBSTR(X.RATING_CREATION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RATING_CREATION_DATE
			, X.RATING_AVAIL_STATUS
			, X.RATING_CATEGORY_LBL
			, X.IS_OVERRIDE
			, TO_DATE(SUBSTR(X.RATING_MODIFIED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RATING_MODIFIED_DATE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationRating"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					APPLICATION_NUMBER                  VARCHAR2(22)      PATH 'Application__Number'
					, SERIES                            VARCHAR2(22)      PATH 'Application__Series'
					, GRADE                             VARCHAR2(6)       PATH 'Application__Grade'
					, SPECIALTY                         VARCHAR2(102)     PATH 'Application__Specialty'
					, RATING_MSG_CODE                   VARCHAR2(22)      PATH 'Application__Rating__Notification__Message__Code'
					, DISPLAY_RATING                    VARCHAR2(32)      PATH 'Application__Display__Rating'
					, FINAL_RATING                      NUMBER(12,4)      PATH 'Application__Final__Rating'
					, AUGMENTED_RATING                  NUMBER(12,4)      PATH 'Application__Augmented__Rating'
					, RATING_CREATION_DATE_STR          VARCHAR2(50)      PATH 'Application__Rating__Creation__Date_x002fTime'
					, RATING_AVAIL_STATUS               VARCHAR2(1002)    PATH 'Application__Rating__Availability__Status'
					, RATING_CATEGORY_LBL               VARCHAR2(202)     PATH 'Application__Rating__Category__Label'
					, IS_OVERRIDE                       VARCHAR2(8)       PATH 'Application__Rating__Is__Override'
					, RATING_MODIFIED_DATE_STR          VARCHAR2(50)      PATH 'Application__Rating__Modified__Date_x002fTime'
			) X
		WHERE IDX.ID = I_ID;


	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20931, 'SP_UPDATE_APPLICATION_TABLE: Invalid APPLICATION data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_APPLICATION_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_APPLICATION_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_APPLICATION_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_APPLICATION_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_APPLICATION_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;

/




--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_CERTIFICATE_TABLE
--------------------------------------------------------
/**
 * Parses Certificate XML data and stores it
 * into the operational tables for Certificate.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_CERTIFICATE_TABLE
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
	PRAGMA EXCEPTION_INIT(E_INVALID_REC_ID, -20940);
	E_INVALID_CERTIFICATE_DATA     EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_CERTIFICATE_DATA, -20941);
BEGIN
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CERTIFICATE_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20940, 'SP_UPDATE_CERTIFICATE_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_CERTIFICATE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CERTIFICATE table');
		INSERT INTO DSS_CERTIFICATE
			(CERTIFICATE_NUMBER
			, AUDITED
			, AUDITOR
			, CUTOFF_NUMBER
			, FINAL_AUDIT_DATE
			, INITIAL_AUDIT_DATE
			, ISSUE_DATE
			, ISSUER
			, LAST_UPDATE_DATE
			, CERT_ORDER
			, PRIORITY_ORDER
			, QUALIFIED_SCORE
			, RANK_BY_DESCRIPTION
			, REFER_METHOD
			, TIE_BREAKER
			, CERTIFICATE_TYPE)
		SELECT
			X.CERTIFICATE_NUMBER
			, X.AUDITED
			, X.AUDITOR
			, X.CUTOFF_NUMBER
			, TO_DATE(SUBSTR(X.FINAL_AUDIT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS FINAL_AUDIT_DATE
			, TO_DATE(SUBSTR(X.INITIAL_AUDIT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS INITIAL_AUDIT_DATE
			, TO_DATE(SUBSTR(X.ISSUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ISSUE_DATE
			, X.ISSUER
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, X.CERT_ORDER
			, X.PRIORITY_ORDER
			, X.QUALIFIED_SCORE
			, X.RANK_BY_DESCRIPTION
			, X.REFER_METHOD
			, X.TIE_BREAKER
			, X.CERTIFICATE_TYPE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "Lst_Certificate"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					CERTIFICATE_NUMBER                  VARCHAR2(102)     PATH 'Certificate__Number'
					, AUDITED                           VARCHAR2(8)       PATH 'Certificate__Audited'
					, AUDITOR                           VARCHAR2(206)     PATH 'Certificate__Auditor'
					, CUTOFF_NUMBER                     NUMBER(18,2)      PATH 'Certificate__Cutoff__Number'
					, FINAL_AUDIT_DATE_STR              VARCHAR2(50)      PATH 'Certificate__Final__Audit__Complete__Date'
					, INITIAL_AUDIT_DATE_STR            VARCHAR2(50)      PATH 'Certificate__Initial__Audit__Complete__Date'
					, ISSUE_DATE_STR                    VARCHAR2(50)      PATH 'Certificate__Issue__Date'
					, ISSUER                            VARCHAR2(206)     PATH 'Certificate__Issuer'
					, LAST_UPDATE_DATE_STR              VARCHAR2(50)      PATH 'Certificate__Last__Updated__Date_x002fTime'
					, CERT_ORDER                        VARCHAR2(1002)    PATH 'Certificate__Order'
					, PRIORITY_ORDER                    VARCHAR2(1002)    PATH 'Certificate__Priority__Order'
					, QUALIFIED_SCORE                   NUMBER(18,2)      PATH 'Certificate__Qualified__Score'
					, RANK_BY_DESCRIPTION               VARCHAR2(1002)    PATH 'Certificate__Rank__By__Description'
					, REFER_METHOD                      VARCHAR2(1002)    PATH 'Certificate__Refer__Method'
					, TIE_BREAKER                       VARCHAR2(1002)    PATH 'Certificate__Tie__Breaker'
					, CERTIFICATE_TYPE                  VARCHAR2(82)      PATH 'Certificate__Type'
			) X
		WHERE IDX.ID = I_ID;


		--------------------------------
		-- DSS_CERTIFICATE_APP table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CERTIFICATE_APP table');
		INSERT INTO DSS_CERTIFICATE_APP
			(APPLICATION_NUMBER
			, ADDED
			, ADD_DATE
			, AUDIT_CODE
			, AUDIT_DATE
			, CERTIFIED_DATE
			, FIRST_NAME
			, MIDDLE_NAME
			, LAST_NAME
			, SUFFIX
			, LOCATION_DESCRIPTION
			, CITY
			, STATE
			, COUNTRY
			, PD_NUMBER
			, POSITION_TITLE
			, SERIES
			, SERIES_TITLE
			, PRIORITY_DESCRIPTION
			, RANK_ORDER
			, RATING
			, REORDERED
			, RETURN_STATUS
			, VET_PREF_CODE
			, VET_PREF_DESCRIPTION)
		SELECT
			X.APPLICATION_NUMBER
			, X.ADDED
			, TO_DATE(SUBSTR(X.ADD_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ADD_DATE
			, X.AUDIT_CODE
			, TO_DATE(SUBSTR(X.AUDIT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS AUDIT_DATE
			, TO_DATE(SUBSTR(X.CERTIFIED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CERTIFIED_DATE
			, X.FIRST_NAME
			, X.MIDDLE_NAME
			, X.LAST_NAME
			, X.SUFFIX
			, X.LOCATION_DESCRIPTION
			, X.CITY
			, X.STATE
			, X.COUNTRY
			, X.PD_NUMBER
			, X.POSITION_TITLE
			, X.SERIES
			, X.SERIES_TITLE
			, X.PRIORITY_DESCRIPTION
			, X.RANK_ORDER
			, X.RATING
			, X.REORDERED
			, X.RETURN_STATUS
			, X.VET_PREF_CODE
			, X.VET_PREF_DESCRIPTION
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "Lst_CertificateApplication"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					APPLICATION_NUMBER                  VARCHAR2(22)      PATH 'Certificate__Application__Number'
					, ADDED                             VARCHAR2(8)       PATH 'Certificate__Application__Added'
					, ADD_DATE_STR                      VARCHAR2(50)      PATH 'Certificate__Application__Add__Date'
					, AUDIT_CODE                        VARCHAR2(82)      PATH 'Certificate__Application__Audit__Code'
					, AUDIT_DATE_STR                    VARCHAR2(50)      PATH 'Certificate__Application__Audit__Date'
					, CERTIFIED_DATE_STR                VARCHAR2(50)      PATH 'Certificate__Application__Certified__Date'
					, FIRST_NAME                        VARCHAR2(62)      PATH 'Certificate__Application__First__Name'
					, MIDDLE_NAME                       VARCHAR2(62)      PATH 'Certificate__Application__Middle__Name'
					, LAST_NAME                         VARCHAR2(62)      PATH 'Certificate__Application__Last__Name'
					, SUFFIX                            VARCHAR2(22)      PATH 'Certificate__Application__Suffix'
					, LOCATION_DESCRIPTION              VARCHAR2(334)     PATH 'Certificate__Application__Hired__Location__Description'
					, CITY                              VARCHAR2(122)     PATH 'Certificate__Application__Hired__Location__City'
					, STATE                             VARCHAR2(202)     PATH 'Certificate__Application__Hired__Location__State'
					, COUNTRY                           VARCHAR2(202)     PATH 'Certificate__Application__Hired__Location__Country'
					, PD_NUMBER                         VARCHAR2(202)     PATH 'Certificate__Application__Hired__Position__Description__Number'
					, POSITION_TITLE                    VARCHAR2(202)     PATH 'Certificate__Application__Hired__Position__Title'
					, SERIES                            VARCHAR2(22)      PATH 'Certificate__Application__Hired__Series'
					, SERIES_TITLE                      VARCHAR2(202)     PATH 'Certificate__Application__Hired__Series__Title'
					, PRIORITY_DESCRIPTION              VARCHAR2(1002)    PATH 'Certificate__Application__Priority__Description'
					, RANK_ORDER                        NUMBER(10)        PATH 'Certificate__Application__Rank__Order'
					, RATING                            VARCHAR2(32)      PATH 'Certificate__Application__Rating'
					, REORDERED                         VARCHAR2(8)       PATH 'Certificate__Application__Reordered'
					, RETURN_STATUS                     VARCHAR2(1002)    PATH 'Certificate__Application__Return__Status'
					, VET_PREF_CODE                     VARCHAR2(22)      PATH 'Certificate__Application__Veterans__Preference__Code'
					, VET_PREF_DESCRIPTION              VARCHAR2(602)     PATH 'Certificate__Application__Veterans__Preference__Description'
			) X
		WHERE IDX.ID = I_ID;


	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20941, 'SP_UPDATE_CERTIFICATE_TABLE: Invalid CERTIFICATE data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_CERTIFICATE_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CERTIFICATE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_CERTIFICATE_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CERTIFICATE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_CERTIFICATE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;

/

--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_NEWHIRE_TABLE
--------------------------------------------------------
/**
 * Parses New Hire report XML data and stores it
 * into the operational tables for New Hire.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_NEWHIRE_TABLE
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
	PRAGMA EXCEPTION_INIT(E_INVALID_REC_ID, -20950);
	E_INVALID_NEWHIRE_DATA      EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_NEWHIRE_DATA, -20951);
BEGIN
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_NEWHIRE_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20950, 'SP_UPDATE_NEWHIRE_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_NEW_HIRE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_NEW_HIRE table');
		INSERT INTO DSS_NEW_HIRE
			(NEW_HIRE_NUMBER
			, NEW_HIRE_FIRST_NAME
			, NEW_HIRE_MIDDLE_NAME
			, NEW_HIRE_LAST_NAME
			, NEW_HIRE_SUFFIX
			, NEW_HIRE_MAIDEN_NAME
			, NEW_HIRE_NAME
			, NEW_HIRE_EMAIL
			, NEW_HIRE_ADDRESS_1
			, NEW_HIRE_ADDRESS_2
			, NEW_HIRE_APT
			, NEW_HIRE_CITY
			, NEW_HIRE_STATE
			, NEW_HIRE_COUNTRY
			, NEW_HIRE_POSTAL_CODE
			, AGENCY
			, AGENCY_ADDRESS_1
			, AGENCY_ADDRESS_2
			, AGENCY_ADDRESS_3
			, AGENCY_CITY
			, AGENCY_STATE
			, AGENCY_COUNTRY
			, AGENCY_POSTAL_CODE
			, BRANCH
			, BUREAU
			, UNIT
			, PD_NUMBER
			, POSITION_TITLE
			, PAY_PLAN
			, SERIES
			, GRADE
			, DUTY_LOCATION
			, DUTY_LOCATION_CODE
			, PROJECTED_START_DATE
			, PROLONGED_START_DATE_RSN
			, ACTUAL_START_DATE
			, VET_PREF_STATUS
			, LAST_UPDATE_DATE)
		SELECT
			X.NEW_HIRE_NUMBER
			, X.NEW_HIRE_FIRST_NAME
			, X.NEW_HIRE_MIDDLE_NAME
			, X.NEW_HIRE_LAST_NAME
			, X.NEW_HIRE_SUFFIX
			, X.NEW_HIRE_MAIDEN_NAME
			, X.NEW_HIRE_NAME
			, X.NEW_HIRE_EMAIL
			, X.NEW_HIRE_ADDRESS_1
			, X.NEW_HIRE_ADDRESS_2
			, X.NEW_HIRE_APT
			, X.NEW_HIRE_CITY
			, X.NEW_HIRE_STATE
			, X.NEW_HIRE_COUNTRY
			, X.NEW_HIRE_POSTAL_CODE
			, X.AGENCY
			, X.AGENCY_ADDRESS_1
			, X.AGENCY_ADDRESS_2
			, X.AGENCY_ADDRESS_3
			, X.AGENCY_CITY
			, X.AGENCY_STATE
			, X.AGENCY_COUNTRY
			, X.AGENCY_POSTAL_CODE
			, X.BRANCH
			, X.BUREAU
			, X.UNIT
			, X.PD_NUMBER
			, X.POSITION_TITLE
			, X.PAY_PLAN
			, X.SERIES
			, X.GRADE
			, X.DUTY_LOCATION
			, X.DUTY_LOCATION_CODE
			, TO_DATE(SUBSTR(X.PROJECTED_START_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS PROJECTED_START_DATE
			, X.PROLONGED_START_DATE_RSN
			, TO_DATE(SUBSTR(X.ACTUAL_START_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ACTUAL_START_DATE
			, X.VET_PREF_STATUS
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_NewHire"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					NEW_HIRE_NUMBER                     VARCHAR2(22)      PATH 'New__Hire__Number'
					, NEW_HIRE_FIRST_NAME               VARCHAR2(2050)    PATH 'New__Hire__First__Name'
					, NEW_HIRE_MIDDLE_NAME              VARCHAR2(2050)    PATH 'New__Hire__Middle__Name'
					, NEW_HIRE_LAST_NAME                VARCHAR2(2050)    PATH 'New__Hire__Last__Name'
					, NEW_HIRE_SUFFIX                   VARCHAR2(2050)    PATH 'New__Hire__Suffix'
					, NEW_HIRE_MAIDEN_NAME              VARCHAR2(2050)    PATH 'New__Hire__Maiden__Name'
					, NEW_HIRE_NAME                     VARCHAR2(2050)    PATH 'New__Hire__Name'
					, NEW_HIRE_EMAIL                    VARCHAR2(2050)    PATH 'New__Hire__Email'
					, NEW_HIRE_ADDRESS_1                VARCHAR2(2050)    PATH 'New__Hire__Address__1'
					, NEW_HIRE_ADDRESS_2                VARCHAR2(2050)    PATH 'New__Hire__Address__2'
					, NEW_HIRE_APT                      VARCHAR2(2050)    PATH 'New__Hire__Apt_x002fSuite'
					, NEW_HIRE_CITY                     VARCHAR2(2050)    PATH 'New__Hire__City'
					, NEW_HIRE_STATE                    VARCHAR2(2050)    PATH 'New__Hire__State'
					, NEW_HIRE_COUNTRY                  VARCHAR2(2050)    PATH 'New__Hire__Country'
					, NEW_HIRE_POSTAL_CODE              VARCHAR2(2050)    PATH 'New__Hire__Postal__Code'
					, AGENCY                            VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment'
					, AGENCY_ADDRESS_1                  VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment__Address__1'
					, AGENCY_ADDRESS_2                  VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment__Address__2'
					, AGENCY_ADDRESS_3                  VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment__Address__3'
					, AGENCY_CITY                       VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment__Address__City'
					, AGENCY_STATE                      VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment__Address__State'
					, AGENCY_COUNTRY                    VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment__Address__Country'
					, AGENCY_POSTAL_CODE                VARCHAR2(2050)    PATH 'New__Hire__Agency_x002fDepartment__Address__Postal__Code'
					, BRANCH                            VARCHAR2(2050)    PATH 'New__Hire__Branch_x002fOrganization'
					, BUREAU                            VARCHAR2(2050)    PATH 'New__Hire__Bureau_x002fDivision'
					, UNIT                              VARCHAR2(2050)    PATH 'New__Hire__Activity_x002fUnit'
					, PD_NUMBER                         VARCHAR2(2050)    PATH 'New__Hire__Position__Description__Number'
					, POSITION_TITLE                    VARCHAR2(2050)    PATH 'New__Hire__Position__Title'
					, PAY_PLAN                          VARCHAR2(2050)    PATH 'New__Hire__Pay__Plan'
					, SERIES                            VARCHAR2(2050)    PATH 'New__Hire__Series'
					, GRADE                             VARCHAR2(2050)    PATH 'New__Hire__Grade'
					, DUTY_LOCATION                     VARCHAR2(2050)    PATH 'New__Hire__Duty__Location'
					, DUTY_LOCATION_CODE                VARCHAR2(2050)    PATH 'New__Hire__Duty__Location__Code'
					, PROJECTED_START_DATE_STR          VARCHAR2(50)      PATH 'New__Hire__Projected__Start__Date'
					, PROLONGED_START_DATE_RSN          VARCHAR2(2050)    PATH 'New__Hire__Prolonged__Start__Date__Reason'
					, ACTUAL_START_DATE_STR             VARCHAR2(50)      PATH 'New__Hire__Actual__Start__Date'
					, VET_PREF_STATUS                   VARCHAR2(2050)    PATH 'New__Hire__Veterans__Preference__Status'
					, LAST_UPDATE_DATE_STR              VARCHAR2(50)      PATH 'New__Hire__Last__Update__Date_x002fTime'
			) X
		WHERE IDX.ID = I_ID;

	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20951, 'SP_UPDATE_NEWHIRE_TABLE: Invalid NEW HIRE data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_NEWHIRE_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_NEWHIRE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_NEWHIRE_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_NEWHIRE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_NEWHIRE_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;

/




--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_REQUEST_TABLE
--------------------------------------------------------
/**
 * Parses Request report XML data and stores it
 * into the operational tables for Request.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_REQUEST_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_REQUEST_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_REQUEST_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_REQUEST_DETAIL table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_DETAIL table');
		INSERT INTO DSS_REQUEST_DETAIL
			(REQUEST_NUMBER
			, REQUEST_DESCRIPTION
			, REQUEST_STATUS
			, REQUEST_TYPE
			, REQUEST_SOURCE
			, LAST_UPDATE_DATE
			, CREATION_DATE
			, SUBMISSION_DATE
			, REQUESTER_NAME
			, REQUESTER_EMAIL
			, APPROVER_NAME
			, APPROVER_EMAIL
			, APPROVAL_DATE
			, CUSTOMER_NAME
			, CUSTOMER_DEPARTMENT_NAME
			, CUSTOMER_DEPARTMENT_CODE
			, CUSTOMER_AGENCY_NAME
			, CUSTOMER_AGENCY_CODE
			, CUSTOMER_ADDRESS_LINE_1
			, CUSTOMER_ADDRESS_LINE_2
			, CUSTOMER_ADDRESS_LINE_3
			, CUSTOMER_CITY
			, CUSTOMER_STATE
			, CUSTOMER_POSTAL_CODE
			, CUSTOMER_COUNTRY
			, HIRING_ORGANIZATION
			, STAFFING_ORGANIZATION
			, PERSONNEL_ACTION_DATE
			, MAXIMUM_AGE
			, MINIMUM_AGE
			, RELOCATION
			, SECURITY_CLEARANCE
			, SUPERVISORY_POSITION
			, TRAVEL_PREFERENCE)
		SELECT
			X.REQUEST_NUMBER
			, X.REQUEST_DESCRIPTION
			, X.REQUEST_STATUS
			, X.REQUEST_TYPE
			, X.REQUEST_SOURCE
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, TO_DATE(SUBSTR(X.CREATION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CREATION_DATE
			, TO_DATE(SUBSTR(X.SUBMISSION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SUBMISSION_DATE
			, X.REQUESTER_NAME
			, X.REQUESTER_EMAIL
			, X.APPROVER_NAME
			, X.APPROVER_EMAIL
			, TO_DATE(SUBSTR(X.APPROVAL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS APPROVAL_DATE
			, X.CUSTOMER_NAME
			, X.CUSTOMER_DEPARTMENT_NAME
			, X.CUSTOMER_DEPARTMENT_CODE
			, X.CUSTOMER_AGENCY_NAME
			, X.CUSTOMER_AGENCY_CODE
			, X.CUSTOMER_ADDRESS_LINE_1
			, X.CUSTOMER_ADDRESS_LINE_2
			, X.CUSTOMER_ADDRESS_LINE_3
			, X.CUSTOMER_CITY
			, X.CUSTOMER_STATE
			, X.CUSTOMER_POSTAL_CODE
			, X.CUSTOMER_COUNTRY
			, X.HIRING_ORGANIZATION
			, X.STAFFING_ORGANIZATION
			, TO_DATE(SUBSTR(X.PERSONNEL_ACTION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS PERSONNEL_ACTION_DATE
			, X.MAXIMUM_AGE
			, X.MINIMUM_AGE
			, X.RELOCATION
			, X.SECURITY_CLEARANCE
			, X.SUPERVISORY_POSITION
			, X.TRAVEL_PREFERENCE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestDetail"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)     PATH 'Request__Number'
					, REQUEST_DESCRIPTION               CLOB              PATH 'Request__Description'
					, REQUEST_STATUS                    VARCHAR2(1002)    PATH 'Request__Status'
					, REQUEST_TYPE                      VARCHAR2(1002)    PATH 'Request__Type'
					, REQUEST_SOURCE                    VARCHAR2(1002)    PATH 'Request__Source'
					, LAST_UPDATE_DATE_STR              VARCHAR2(50)      PATH 'Request__Last__Update__Date_x002fTime'
					, CREATION_DATE_STR                 VARCHAR2(50)      PATH 'Request__Creation__Date'
					, SUBMISSION_DATE_STR               VARCHAR2(50)      PATH 'Request__Submission__Date'
					, REQUESTER_NAME                    VARCHAR2(206)     PATH 'Requester__Name'
					, REQUESTER_EMAIL                   VARCHAR2(242)     PATH 'Requester__Email'
					, APPROVER_NAME                     VARCHAR2(206)     PATH 'Request__Approver__Name'
					, APPROVER_EMAIL                    VARCHAR2(252)     PATH 'Request__Approver__Email'
					, APPROVAL_DATE_STR                 VARCHAR2(50)      PATH 'Request__Approval__Date'
					, CUSTOMER_NAME                     VARCHAR2(202)     PATH 'Request__Customer__Name'
					, CUSTOMER_DEPARTMENT_NAME          VARCHAR2(202)     PATH 'Request__Customer__Department__Name'
					, CUSTOMER_DEPARTMENT_CODE          VARCHAR2(10)      PATH 'Request__Customer__Department__Code'
					, CUSTOMER_AGENCY_NAME              VARCHAR2(202)     PATH 'Request__Customer__Agency__Name'
					, CUSTOMER_AGENCY_CODE              VARCHAR2(10)      PATH 'Request__Customer__Agency__Code'
					, CUSTOMER_ADDRESS_LINE_1           VARCHAR2(202)     PATH 'Request__Customer__Address__Line__1'
					, CUSTOMER_ADDRESS_LINE_2           VARCHAR2(202)     PATH 'Request__Customer__Address__Line__2'
					, CUSTOMER_ADDRESS_LINE_3           VARCHAR2(202)     PATH 'Request__Customer__Address__Line__3'
					, CUSTOMER_CITY                     VARCHAR2(122)     PATH 'Request__Customer__Address__City'
					, CUSTOMER_STATE                    VARCHAR2(202)     PATH 'Request__Customer__Address__State'
					, CUSTOMER_POSTAL_CODE              VARCHAR2(42)      PATH 'Request__Customer__Address__Postal__Code'
					, CUSTOMER_COUNTRY                  VARCHAR2(202)     PATH 'Request__Customer__Address__Country'
					, HIRING_ORGANIZATION               VARCHAR2(202)     PATH 'Request__Hiring__Organization'
					, STAFFING_ORGANIZATION             VARCHAR2(122)     PATH 'Request__Staffing__Organization'
					, PERSONNEL_ACTION_DATE_STR         VARCHAR2(50)      PATH 'Request__Personnel__Action__Date'
					, MAXIMUM_AGE                       NUMBER(3)         PATH 'Request__Maximum__Age'
					, MINIMUM_AGE                       NUMBER(3)         PATH 'Request__Minimum__Age'
					, RELOCATION                        VARCHAR2(8)       PATH 'Request__Relocation'
					, SECURITY_CLEARANCE                VARCHAR2(1002)    PATH 'Request__Security__Clearance'
					, SUPERVISORY_POSITION              VARCHAR2(8)       PATH 'Request__Supervisory__Position'
					, TRAVEL_PREFERENCE                 VARCHAR2(1002)    PATH 'Request__Travel__Preference'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_REQUEST_APPT_TYPE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_APPT_TYPE table');
		INSERT INTO DSS_REQUEST_APPT_TYPE
			(REQUEST_NUMBER
			, APPOINTMENT_TYPE)
		SELECT
			X.REQUEST_NUMBER
			, X.APPOINTMENT_TYPE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestAppointmentType"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)     PATH 'Request__Number'
					, APPOINTMENT_TYPE                  VARCHAR2(1002)    PATH 'Request__Appointment__Type'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_REQUEST_LOCATION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_LOCATION table');
		INSERT INTO DSS_REQUEST_LOCATION
			(REQUEST_NUMBER
			, LOCATION_DESCRIPTION
			, LOCATION_OPENINGS
			, CITY
			, STATE
			, COUNTY
			, COUNTRY
			, LOCATION_CODE)
		SELECT
			X.REQUEST_NUMBER
			, X.LOCATION_DESCRIPTION
			, X.LOCATION_OPENINGS
			, X.CITY
			, X.STATE
			, X.COUNTY
			, X.COUNTRY
			, X.LOCATION_CODE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestLocation"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)    PATH 'Request__Number'
					, LOCATION_DESCRIPTION              VARCHAR2(334)    PATH 'Request__Location__Description'
					, LOCATION_OPENINGS                 VARCHAR2(12)     PATH 'Request__Location__Openings'
					, CITY                              VARCHAR2(122)    PATH 'Request__Location__City'
					, STATE                             VARCHAR2(202)    PATH 'Request__Location__State'
					, COUNTY                            VARCHAR2(202)    PATH 'Request__Location__County'
					, COUNTRY                           VARCHAR2(202)    PATH 'Request__Location__Country'
					, LOCATION_CODE                     VARCHAR2(34)     PATH 'Request__Location__Code'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_REQUEST_POSITION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_POSITION table');
		INSERT INTO DSS_REQUEST_POSITION
			(REQUEST_NUMBER
			, PD_NUMBER
			, PD_TITLE)
		SELECT
			X.REQUEST_NUMBER
			, X.PD_NUMBER
			, X.PD_TITLE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestPosition"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)    PATH 'Request__Number'
					, PD_NUMBER                         VARCHAR2(202)    PATH 'Request__Position__Description__Number'
					, PD_TITLE                          VARCHAR2(202)    PATH 'Request__Position__Description__Title'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_REQUEST_SPECIALTY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_SPECIALTY table');
		INSERT INTO DSS_REQUEST_SPECIALTY
			(REQUEST_NUMBER
			, SPECIALTY)
		SELECT
			X.REQUEST_NUMBER
			, X.SPECIALTY
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestSpecialty"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)    PATH 'Request__Number'
					, SPECIALTY                         VARCHAR2(102)    PATH 'Request__Specialty'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_REQUEST_VACANCY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_VACANCY table');
		INSERT INTO DSS_REQUEST_VACANCY
			(REQUEST_NUMBER
			, VACANCY_NUMBER
			, VACANCY_STATUS)
		SELECT
			X.REQUEST_NUMBER
			, X.VACANCY_NUMBER
			, X.VACANCY_STATUS
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestVacancy"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)     PATH 'Request__Number'
					, VACANCY_NUMBER                    NUMBER(10)        PATH 'Vacancy__Number'
					, VACANCY_STATUS                    VARCHAR2(1002)    PATH 'Vacancy__Status'
			) X
		WHERE IDX.ID = I_ID;


		--------------------------------
		-- DSS_REQUEST_WORK_SCHED table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_WORK_SCHED table');
		INSERT INTO DSS_REQUEST_WORK_SCHED
			(REQUEST_NUMBER
			, WORK_SCHEDULE)
		SELECT
			X.REQUEST_NUMBER
			, X.WORK_SCHEDULE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestWorkSchedule"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                      VARCHAR2(202)     PATH 'Request__Number'
					, WORK_SCHEDULE                     VARCHAR2(1002)    PATH 'Request__Work__Schedule'
			) X
		WHERE IDX.ID = I_ID;

	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_REQUEST_TABLE: Invalid REQUEST data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_REQUEST_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_REQUEST_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_REQUEST_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_REQUEST_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;

/



--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_REVIEW_TABLE
--------------------------------------------------------
/**
 * Parses Review XML data and stores it
 * into the operational tables for Review.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_REVIEW_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_REVIEW_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_REVIEW_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_REVIEW_DETAIL table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REVIEW_DETAIL table');
		INSERT INTO DSS_REVIEW_DETAIL
			(CREATION_DATE
			, RECALL_STATUS_DATE
			, REVIEW_DUE_DATE
			, REVIEW_INSTRUCTIONS
			, IS_ANNOUNCEMENT_QNR
			, IS_ANNOUNCEMENT_TEXT
			, IS_CERTIFICATE_REVIEW
			, LAST_UPDATE_DATE
			, REVIEW_NAME
			, OWNER
			, RECALL_REASON
			, REVIEW_RETURNED_DATE
			, REVIEW_SENT_DATE
			, REVIEW_STATUS)
		SELECT
			  TO_DATE(SUBSTR(X.CREATION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CREATION_DATE
			, TO_DATE(SUBSTR(X.RECALL_STATUS_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RECALL_STATUS_DATE
			, TO_DATE(SUBSTR(X.REVIEW_DUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_DUE_DATE
			, X.REVIEW_INSTRUCTIONS
			, X.IS_ANNOUNCEMENT_QNR
			, X.IS_ANNOUNCEMENT_TEXT
			, X.IS_CERTIFICATE_REVIEW
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, X.REVIEW_NAME
			, X.OWNER
			, X.RECALL_REASON
			, TO_DATE(SUBSTR(X.REVIEW_RETURNED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_RETURNED_DATE
			, TO_DATE(SUBSTR(X.REVIEW_SENT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_SENT_DATE
			, X.REVIEW_STATUS
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ReviewDetail"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					CREATION_DATE_STR                    VARCHAR2(50)      PATH 'Review__Creation__Date'
					, RECALL_STATUS_DATE_STR             VARCHAR2(50)      PATH 'Review__Date__Of__Recall__Status'
					, REVIEW_DUE_DATE_STR                VARCHAR2(50)      PATH 'Review__Due__Date'
					, REVIEW_INSTRUCTIONS                CLOB              PATH 'Review__Instructions'
					, IS_ANNOUNCEMENT_QNR                VARCHAR2(8)       PATH 'Review__Is__Announcement__Questionnaire'
					, IS_ANNOUNCEMENT_TEXT               VARCHAR2(8)       PATH 'Review__Is__Announcement__Text'
					, IS_CERTIFICATE_REVIEW              VARCHAR2(8)       PATH 'Review__Is__Certificate__Review'
					, LAST_UPDATE_DATE_STR               VARCHAR2(50)      PATH 'Review__Last__Updated__Date_x002fTime'
					, REVIEW_NAME                        VARCHAR2(202)     PATH 'Review__Name'
					, OWNER                              VARCHAR2(206)     PATH 'Review__Owner'
					, RECALL_REASON                      CLOB              PATH 'Review__Recall__Reason'
					, REVIEW_RETURNED_DATE_STR           VARCHAR2(50)      PATH 'Review__Returned__Date'
					, REVIEW_SENT_DATE_STR               VARCHAR2(50)      PATH 'Review__Sent__Date'
					, REVIEW_STATUS                      VARCHAR2(1002)    PATH 'Review__Status'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_REVIEW_TABLE: Invalid REVIEW data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_REVIEW_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_REVIEW_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_REVIEW_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_REVIEW_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/


--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_TASK_TABLE
--------------------------------------------------------
/**
 * Parses Task XML data and stores it
 * into the operational tables for Task.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_TASK_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_TASK_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_TASK_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_TASK_DETAIL table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_TASK_DETAIL table');
		INSERT INTO DSS_TASK_DETAIL
			(VACANCY_STAFFING_OFFICE_NAME
			, TASK_ID
			, ACTIVATION_DATE
			, COMPLETED_DATE
			, CREATION_DATE
			, DAYS_TO_COMPLETE
			, DUE_DATE
			, LAST_UPDATE_DATE
			, TASK_NAME
			, OWNER_FIRST_NAME
			, OWNER_LAST_NAME
			, OWNER_NAME
			, TASK_STATUS
			, ACTUAL_DAYS_TO_COMPLETE
			, TASK_TYPE
			, REQUEST_NUMBER
			, VACANCY_NUMBER)
		SELECT
			X.VACANCY_STAFFING_OFFICE_NAME
			, X.TASK_ID
			, TO_DATE(SUBSTR(X.ACTIVATION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ACTIVATION_DATE
			, TO_DATE(SUBSTR(X.COMPLETED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS COMPLETED_DATE
			, TO_DATE(SUBSTR(X.CREATION_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CREATION_DATE
			, X.DAYS_TO_COMPLETE
			, TO_DATE(SUBSTR(X.DUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS DUE_DATE
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, X.TASK_NAME
			, X.OWNER_FIRST_NAME
			, X.OWNER_LAST_NAME
			, X.OWNER_NAME
			, X.TASK_STATUS
			, X.ACTUAL_DAYS_TO_COMPLETE
			, X.TASK_TYPE
			, X.REQUEST_NUMBER
			, X.VACANCY_NUMBER
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_Taskdetail"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					VACANCY_STAFFING_OFFICE_NAME           VARCHAR2(202)    PATH 'Task__Vacancy__Staffing__Office__Name'
					, TASK_ID                              NUMBER(10)       PATH 'Task__ID'
					, ACTIVATION_DATE_STR                  VARCHAR2(50)     PATH 'Task__Activation__Date_x002fTime'
					, COMPLETED_DATE_STR                   VARCHAR2(50)     PATH 'Task__Completed__Date_x002fTime'
					, CREATION_DATE_STR                    VARCHAR2(50)     PATH 'Task__Creation__Date'
					, DAYS_TO_COMPLETE                     NUMBER(10)       PATH 'Task__Days__To__Complete'
					, DUE_DATE_STR                         VARCHAR2(50)     PATH 'Task__Due__Date_x002fTime'
					, LAST_UPDATE_DATE_STR                 VARCHAR2(50)     PATH 'Task__Last__Update__Date_x002fTime'
					, TASK_NAME                            VARCHAR2(202)    PATH 'Task__Name'
					, OWNER_FIRST_NAME                     VARCHAR2(102)    PATH 'Task__Owner__First__Name'
					, OWNER_LAST_NAME                      VARCHAR2(102)    PATH 'Task__Owner__Last__Name'
					, OWNER_NAME                           VARCHAR2(206)    PATH 'Task__Owner__Name'
					, TASK_STATUS                          VARCHAR2(1002)   PATH 'Task__Status'
					, ACTUAL_DAYS_TO_COMPLETE              NUMBER(10)       PATH 'Task__Actual__Days__To__Complete'
					, TASK_TYPE                            VARCHAR2(1002)   PATH 'Task__Type'
					, REQUEST_NUMBER                       VARCHAR2(202)    PATH 'Task__Request__Number'
					, VACANCY_NUMBER                       NUMBER(10)       PATH 'Task__Vacancy__Number'
			) X
		WHERE IDX.ID = I_ID;
		
	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_TASK_TABLE: Invalid TASK data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_TASK_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TASK_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TASK_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TASK_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
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
		INSERT INTO DSS_VACANCY_DETAIL
			(VACANCY_NUMBER
			, VACANCY_STATUS
			, JOB_TITLE
			, VACANCY_DESCRIPTION
			, VACANCY_TYPE
			, DISPLAY_TYPE
			, IS_INTERNAL_MERIT_PROMO
			, IS_PUBLIC
			, IS_STATUS
			, CREATION_DATE
			, LAST_UPDATE_DATE
			, ANNOUNCEMENT_NUMBER
			, IS_UNDER_LITIGATION
			, ORGANIZATION_NAME
			, ORGANIZATION_CODE
			, OFFICE_NAME
			, OFFICE_CODE
			, ADDRESS_LINE_1
			, ADDRESS_LINE_2
			, ADDRESS_LINE_3
			, CITY
			, STATE_ABBREV
			, POSTALCODE
			, COUNTRY
			, HIRING_ORGANIZATION_NAME
			, ACWA
			, AGE_SCREENING
			, APPLICANT_UPDT_RESTRICTED
			, APPLY_ONLINE
			, CITIZENSHIP_SCREENING
			, IS_AGE_FORMULA
			, HAS_MAX_AGE
			, HAS_MIN_AGE
			, MAXIMUM_AGE
			, MINIMUM_AGE
			, PERIOD_OF_ELIGIBILITY
			, RELOCATION
			, RNO
			, SECURITY_CLEARANCE
			, SUPERVISORY_POSITION
			, TRAVEL_PREFERENCE)
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
			, X.MAXIMUM_AGE
			, X.MINIMUM_AGE
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
					VACANCY_NUMBER                      NUMBER(10)        PATH 'Vacancy__Number'
					, VACANCY_STATUS                    VARCHAR2(1002)    PATH 'Vacancy__Status'
					, JOB_TITLE                         VARCHAR2(202)     PATH 'Vacancy__USAJOBS__Job__Title'
					, VACANCY_DESCRIPTION               VARCHAR2(1002)    PATH 'Vacancy__Description'
					, VACANCY_TYPE                      VARCHAR2(1002)    PATH 'Vacancy__Type'
					, DISPLAY_TYPE                      VARCHAR2(24)      PATH 'Vacancy__USAJOBS__Display__Type'
					, IS_INTERNAL_MERIT_PROMO           VARCHAR2(8)       PATH 'Vacancy__USAJOBS__Announcement__Type___x0028Is__Internal__Merit__Promotion_x0029'
					, IS_PUBLIC                         VARCHAR2(8)       PATH 'Vacancy__USAJOBS__Announcement__Type___x0028Is__Public_x0029'
					, IS_STATUS                         VARCHAR2(8)       PATH 'Vacancy__USAJOBS__Announcement__Type___x0028Is__Status_x0029'
					, CREATION_DATE_STR                 VARCHAR2(50)      PATH 'Vacancy__Creation__Date'
					, LAST_UPDATE_DATE_STR              VARCHAR2(50)      PATH 'Vacancy__Last__Update__Date_x002fTime'
					, ANNOUNCEMENT_NUMBER               VARCHAR2(56)      PATH 'Announcement__Number'
					, IS_UNDER_LITIGATION               VARCHAR2(8)       PATH 'Vacancy__Is__Under__Litigation'
					, ORGANIZATION_NAME                 VARCHAR2(122)     PATH 'Vacancy__Staffing__Organization__Name'
					, ORGANIZATION_CODE                 VARCHAR2(10)      PATH 'Vacancy__Staffing__Organization__Code'
					, OFFICE_NAME                       VARCHAR2(202)     PATH 'Vacancy__Staffing__Office__Name'
					, OFFICE_CODE                       VARCHAR2(10)      PATH 'Vacancy__Staffing__Office__Code'
					, ADDRESS_LINE_1                    VARCHAR2(202)     PATH 'Vacancy__Staffing__Office__Address__Line__1'
					, ADDRESS_LINE_2                    VARCHAR2(202)     PATH 'Vacancy__Staffing__Office__Address__Line__2'
					, ADDRESS_LINE_3                    VARCHAR2(202)     PATH 'Vacancy__Staffing__Office__Address__Line__3'
					, CITY                              VARCHAR2(122)     PATH 'Vacancy__Staffing__Office__Address__City'
					, STATE_ABBREV                      VARCHAR2(8)       PATH 'Vacancy__Staffing__Office__Address__State__Abbreviation'
					, POSTALCODE                        VARCHAR2(42)      PATH 'Vacancy__Staffing__Office__Address__Postal__Code'
					, COUNTRY                           VARCHAR2(202)     PATH 'Vacancy__Staffing__Office__Address__Country'
					, HIRING_ORGANIZATION_NAME          VARCHAR2(102)     PATH 'Vacancy__Staffing__Hiring__Organization__Name'
					, ACWA                              VARCHAR2(8)       PATH 'Vacancy__ACWA'
					, AGE_SCREENING                     VARCHAR2(8)       PATH 'Vacancy__Age__Screening'
					, APPLICANT_UPDT_RESTRICTED         VARCHAR2(8)       PATH 'Vacancy__Applicant__Update__Restricted'
					, APPLY_ONLINE                      VARCHAR2(8)       PATH 'Vacancy__Apply__Online'
					, CITIZENSHIP_SCREENING             VARCHAR2(8)       PATH 'Vacancy__Citizenship__Screening'
					, IS_AGE_FORMULA                    VARCHAR2(8)       PATH 'Vacancy__Is__Age__Formula'
					, HAS_MAX_AGE                       VARCHAR2(8)       PATH 'Vacancy__Has__Maximum__Age'
					, HAS_MIN_AGE                       VARCHAR2(8)       PATH 'Vacancy__Has__Minimum__Age'
					, MAXIMUM_AGE                       NUMBER(3)         PATH 'Vacancy__Maximum__Age'
					, MINIMUM_AGE                       NUMBER(3)         PATH 'Vacancy__Minimum__Age'
					, PERIOD_OF_ELIGIBILITY             NUMBER(10)        PATH 'Vacancy__Period__of__Eligibility'
					, RELOCATION                        VARCHAR2(8)       PATH 'Vacancy__Relocation'
					, RNO                               VARCHAR2(8)       PATH 'Vacancy__RNO'
					, SECURITY_CLEARANCE                VARCHAR2(1002)    PATH 'Vacancy__Security__Clearance'
					, SUPERVISORY_POSITION              VARCHAR2(8)       PATH 'Vacancy__Supervisory__Position'
					, TRAVEL_PREFERENCE                 VARCHAR2(1002)    PATH 'Vacancy__Travel__Preference'
			) X
		WHERE IDX.ID = I_ID;
		
		--------------------------------
		-- DSS_VACANCY_CUSTOMER table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_CUSTOMER table');
		INSERT INTO DSS_VACANCY_CUSTOMER
			(VACANCY_NUMBER
			, CUSTOMER_NAME
			, DEPARTMENT_NAME
			, DEPARTMENT_CODE
			, AGENCY_NAME
			, AGENCY_CODE)
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
					VACANCY_NUMBER                      NUMBER(10)       PATH 'Vacancy__Number'
					, CUSTOMER_NAME                     VARCHAR2(202)    PATH 'Vacancy__Customer__Name'
					, DEPARTMENT_NAME                   VARCHAR2(202)    PATH 'Vacancy__Customer__Department__Name'
					, DEPARTMENT_CODE                   VARCHAR2(10)     PATH 'Vacancy__Customer__Department__Code'
					, AGENCY_NAME                       VARCHAR2(202)    PATH 'Vacancy__Customer__Agency__Name'
					, AGENCY_CODE                       VARCHAR2(10)     PATH 'Vacancy__Customer__Agency__Code'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_VACANCY_ELIGIBILITY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_ELIGIBILITY table');
		INSERT INTO DSS_VACANCY_ELIGIBILITY
			(VACANCY_NUMBER
			, ELIGIBILITY
			, ELIGIBILITY_LABEL)
		SELECT
			X.VACANCY_NUMBER
			, X.ELIGIBILITY
			, X.ELIGIBILITY_LABEL
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyEligibility"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					VACANCY_NUMBER                      NUMBER(10)      PATH 'Vacancy__Number'
					, ELIGIBILITY                       VARCHAR2(202)   PATH 'Vacancy__Eligibility'
					, ELIGIBILITY_LABEL                 VARCHAR2(34)    PATH 'Vacancy__Eligibility__Label'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_VACANCY_POSITION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_POSITION table');
		INSERT INTO DSS_VACANCY_POSITION
			(VACANCY_NUMBER
			, POSITION_DESCRIPTION
			, POSITION_DESCRIPTION_TITLE)
		SELECT
			X.VACANCY_NUMBER
			, X.POSITION_DESCRIPTION
			, X.POSITION_DESCRIPTION_TITLE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyPosition"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					VACANCY_NUMBER                      NUMBER(10)       PATH 'Vacancy__Number'
					, POSITION_DESCRIPTION              VARCHAR2(202)    PATH 'Vacancy__Position__Description__Number'
					, POSITION_DESCRIPTION_TITLE        VARCHAR2(202)    PATH 'Vacancy__Position__Description__Title'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_VACANCY_SPECIALTY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_SPECIALTY table');
		INSERT INTO DSS_VACANCY_SPECIALTY
			(VACANCY_NUMBER
			,SPECIALTY)
		SELECT
			X.VACANCY_NUMBER
			, X.SPECIALTY
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancySpecialty"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					VACANCY_NUMBER                      NUMBER(10)       PATH 'Vacancy__Number'
					, SPECIALTY                         VARCHAR2(102)    PATH 'Vacancy__Specialty'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_VACANCY_DOCUMENT table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_DOCUMENT table');
		INSERT INTO DSS_VACANCY_DOCUMENT
			(VACANCY_NUMBER
			, SUPPORTING_DOC_TYPE
			, SUPPORTING_DOC_CUSTM_TITLE
			, REQUIRED_DOC)
		SELECT
			X.VACANCY_NUMBER
			, X.SUPPORTING_DOC_TYPE
			, X.SUPPORTING_DOC_CUSTM_TITLE
			, X.REQUIRED_DOC
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyDocuments"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					VACANCY_NUMBER                      NUMBER(10)        PATH 'Vacancy__Number'
					, SUPPORTING_DOC_TYPE               VARCHAR2(1002)    PATH 'Vacancy__Supporting__Document__Type'
					, SUPPORTING_DOC_CUSTM_TITLE        VARCHAR2(1002)    PATH 'Vacancy__Supporting__Document__Custom__Title'
					, REQUIRED_DOC                      VARCHAR2(8)       PATH 'Vacancy__Required__Document'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_VACANCY_REQUEST table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_VACANCY_REQUEST table');
		INSERT INTO DSS_VACANCY_REQUEST
			(VACANCY_NUMBER
			, REQUEST_NUMBER
			, REQUEST_STATUS)
		SELECT
			X.VACANCY_NUMBER
			, X.REQUEST_NUMBER
			, X.REQUEST_STATUS
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_VacancyRequest"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					VACANCY_NUMBER                      NUMBER(10)        PATH 'Vacancy__Number'
					, REQUEST_NUMBER                    VARCHAR2(202)     PATH 'Request__Number'
					, REQUEST_STATUS                    VARCHAR2(1002)    PATH 'Request__Status'
			) X
		WHERE IDX.ID = I_ID;

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

CREATE OR REPLACE PROCEDURE SP_UPDATE_TIME2STAFF_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_TIME2STAFF_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_TIME2STAFF_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_TIME_TO_STAFF table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_TIME_TO_STAFF table');
		INSERT INTO DSS_TIME_TO_STAFF
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
		FROM INTG_DATA_DTL IDX
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
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_TIME2STAFF_TABLE: Invalid TIME TO STAFF data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_TIME2STAFF_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TIME2STAFF_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/

CREATE OR REPLACE PROCEDURE SP_UPDATE_TIME2OFFER_TABLE
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
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_TIME2OFFER_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20960, 'SP_UPDATE_TIME2OFFER_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_TIME_TO_OFFER table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_TIME_TO_OFFER table');
		INSERT INTO DSS_TIME_TO_OFFER
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
		FROM INTG_DATA_DTL IDX
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
			RAISE_APPLICATION_ERROR(-20961, 'SP_UPDATE_TIME2OFFER_TABLE: Invalid TIME TO OFFER data.  IA_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_TIME2OFFER_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TIME2OFFER_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_REQUEST_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TIME2OFFER_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_TIME2OFFER_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('Error code    = ' || V_ERRCODE);
		--DBMS_OUTPUT.PUT_LINE('Error message = ' || V_ERRMSG);
END;
/


--------------------------------------------------------
--  DDL for Procedure SP_UPDATE_IHS_VAC_TABLE
--------------------------------------------------------
/**
 * Parses IHS Vacancy XML data and stores it
 * into the operational tables for IHS Vacancy.
 *
 * @param I_ID - Record ID
 */
CREATE OR REPLACE PROCEDURE SP_UPDATE_IHS_VAC_TABLE
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
	PRAGMA EXCEPTION_INIT(E_INVALID_REC_ID, -20940);
	E_INVALID_DATA              EXCEPTION;
	PRAGMA EXCEPTION_INIT(E_INVALID_DATA, -20941);
BEGIN
	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_IHS_VAC_TABLE - BEGIN ============================');
	--DBMS_OUTPUT.PUT_LINE('PARAMETERS ----------------');
	--DBMS_OUTPUT.PUT_LINE('    I_ID IS NULL?  = ' || (CASE WHEN I_ID IS NULL THEN 'YES' ELSE 'NO' END));
	--DBMS_OUTPUT.PUT_LINE('    I_ID           = ' || TO_CHAR(I_ID));
	--DBMS_OUTPUT.PUT_LINE(' ----------------');

	--DBMS_OUTPUT.PUT_LINE('Starting xml data retrieval and table update ----------');

	IF I_ID IS NULL THEN
		RAISE_APPLICATION_ERROR(-20940, 'SP_UPDATE_IHS_VAC_TABLE: Input Record ID is invalid.  I_ID = '	|| TO_CHAR(I_ID) );
	END IF;

	BEGIN
		--------------------------------
		-- DSS_IHS_VAC_ANNOUNCEMENT table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_IHS_VAC_ANNOUNCEMENT table');
		INSERT INTO DSS_IHS_VAC_ANNOUNCEMENT
			(REQUEST_NUMBER
			, VIN
			, REQUEST_CREATE_DATE
			, REQUEST_STATUS
			, ANNOUNCEMENT_NUMBER
			, VACANCY_TYPE
			, VACANCY_STATUS
			, JOB_TITLE
			, PAY_PLAN
			, SERIES
			, GRADE
			, OPEN_DATE
			, CLOSE_DATE
			, ANNOUNCEMENT_TYPE
			, ANNOUNCEMENT_CTRL_NUMBER
			, ANNOUNCEMENT_STATUS
			, IS_RELEASED
			, RELEASED_DATE
			, LAST_UPDATE_DATE
			, REQUEST_CANCEL_DATE
			, REQUEST_CANCEL_REASON)
		SELECT
			X.REQUEST_NUMBER
			, X.VIN
			, TO_DATE(SUBSTR(X.REQUEST_CREATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_CREATE_DATE
			, X.REQUEST_STATUS
			, X.ANNOUNCEMENT_NUMBER
			, X.VACANCY_TYPE
			, X.VACANCY_STATUS
			, X.JOB_TITLE
			, X.PAY_PLAN
			, X.SERIES
			, X.GRADE
			, TO_DATE(SUBSTR(X.OPEN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS OPEN_DATE
			, TO_DATE(SUBSTR(X.CLOSE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS CLOSE_DATE
			, X.ANNOUNCEMENT_TYPE
			, X.ANNOUNCEMENT_CTRL_NUMBER
			, X.ANNOUNCEMENT_STATUS
			, X.IS_RELEASED
			, TO_DATE(SUBSTR(X.RELEASED_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS RELEASED_DATE
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, TO_DATE(SUBSTR(X.REQUEST_CANCEL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REQUEST_CANCEL_DATE
			, X.REQUEST_CANCEL_REASON
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnouncementInfo"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                VARCHAR2(202)     PATH 'Request__Number'
					, VIN                         NUMBER(10)        PATH 'Vacancy__Identification__Number'
					, REQUEST_CREATE_DATE_STR     VARCHAR2(50)      PATH 'Request__Creation__Date'
					, REQUEST_STATUS              VARCHAR2(1002)    PATH 'Request__Status'
					, ANNOUNCEMENT_NUMBER         VARCHAR2(56)      PATH 'Announcement__Number'
					, VACANCY_TYPE                VARCHAR2(1002)    PATH 'Vacancy__Type'
					, VACANCY_STATUS              VARCHAR2(1002)    PATH 'Vacancy__Status'
					, JOB_TITLE                 VARCHAR2(202)     PATH 'Vacancy__USAJOBS__Job__Title'
					, PAY_PLAN                  VARCHAR2(102)     PATH 'Vacancy__Pay__Plan'
					, SERIES                    VARCHAR2(22)      PATH 'Vacancy__Series'
					, GRADE                     VARCHAR2(6)       PATH 'Vacancy__Grade'
					, OPEN_DATE_STR               VARCHAR2(50)      PATH 'Announcement__Open__Date'
					, CLOSE_DATE_STR              VARCHAR2(50)      PATH 'Announcement__Close__Date'
					, ANNOUNCEMENT_TYPE           VARCHAR2(24)      PATH 'Announcement__Type'
					, ANNOUNCEMENT_CTRL_NUMBER    NUMBER(10)        PATH 'Announcement__Control__Number'
					, ANNOUNCEMENT_STATUS         VARCHAR2(1002)    PATH 'Announcement__Status'
					, IS_RELEASED                 VARCHAR2(8)       PATH 'Announcement__Is__Released'
					, RELEASED_DATE_STR           VARCHAR2(50)      PATH 'Announcement__Released__Date_x002fTime'
					, LAST_UPDATE_DATE_STR        VARCHAR2(50)      PATH 'Announcement__Last__Update__Date_x002fTime'
					, REQUEST_CANCEL_DATE_STR     VARCHAR2(50)      PATH 'Request__Cancellation__Date'
					, REQUEST_CANCEL_REASON       VARCHAR2(2050)    PATH 'Request__Cancellation__Reason'
			) X
		WHERE IDX.ID = I_ID;
		
		--------------------------------
		-- DSS_IHS_VAC_ANN_LOCATION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_IHS_VAC_ANN_LOCATION table');
		INSERT INTO DSS_IHS_VAC_ANN_LOCATION
			(REQUEST_NUMBER
			, VIN
			, ANNOUNCEMENT_NUMBER
			, LOCATION)
		SELECT
			X.REQUEST_NUMBER
			, X.VIN
			, X.ANNOUNCEMENT_NUMBER
			, X.LOCATION
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnLocation"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                VARCHAR2(202)     PATH 'Request__Number'
					, VIN                         NUMBER(10)        PATH 'Vacancy__Identification__Number'
					, ANNOUNCEMENT_NUMBER         VARCHAR2(56)      PATH 'Announcement__Number'
					, LOCATION                    VARCHAR2(334)    PATH 'Location'
			) X
		WHERE IDX.ID = I_ID;

		--------------------------------
		-- DSS_IHS_VAC_ANN_REVIEW table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_IHS_VAC_ANN_REVIEW table');
		INSERT INTO DSS_IHS_VAC_ANN_REVIEW
			(REQUEST_NUMBER
			, VIN
			, ANNOUNCEMENT_NUMBER
			, REVIEW_STATUS
			, REVIEW_JOA_DATE
			, REVIEW_JOA_SENT_DATE
			, REVIEW_JOA_RETURN_DATE
			, IS_ANNOUNCEMENT_TEXT
			, IS_CERTIFICATE_REVIEW)
		SELECT
			X.REQUEST_NUMBER
			, X.VIN
			, X.ANNOUNCEMENT_NUMBER
			, X.REVIEW_STATUS
			, TO_DATE(SUBSTR(X.REVIEW_JOA_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_JOA_DATE
			, TO_DATE(SUBSTR(X.REVIEW_JOA_SENT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_JOA_SENT_DATE
			, TO_DATE(SUBSTR(X.REVIEW_JOA_RETURN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_JOA_RETURN_DATE
			, X.IS_ANNOUNCEMENT_TEXT
			, X.IS_CERTIFICATE_REVIEW
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnReviewInfo"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                VARCHAR2(202)     PATH 'Request__Number'
					, VIN                         NUMBER(10)        PATH 'Vacancy__Identification__Number'
					, ANNOUNCEMENT_NUMBER         VARCHAR2(56)      PATH 'Announcement__Number'
					, REVIEW_STATUS               VARCHAR2(1002)    PATH 'Announcement__Review__Status'
					, REVIEW_JOA_DATE_STR         VARCHAR2(50)      PATH 'Review__Draft__JOA__Date'
					, REVIEW_JOA_SENT_DATE_STR    VARCHAR2(50)      PATH 'Review__Draft__JOA__Sent__Date'
					, REVIEW_JOA_RETURN_DATE_STR  VARCHAR2(50)      PATH 'Review__Draft__JOA__Returned__Date'
					, IS_ANNOUNCEMENT_TEXT        VARCHAR2(8)       PATH 'Announcement__Review__Is__Announcement__Text'
					, IS_CERTIFICATE_REVIEW       VARCHAR2(8)       PATH 'Announcement__Review__Is__Certificate__Review'
			) X
		WHERE IDX.ID = I_ID;

				--------------------------------
		-- DSS_IHS_VAC_CERTIFICATE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_IHS_VAC_CERTIFICATE table');
		INSERT INTO DSS_IHS_VAC_CERTIFICATE
			(REQUEST_NUMBER
			, VIN
			, REQUEST_STATUS
			, CERTIFICATE_NUMBER
			, CERTIFICATE_TYPE
			, VACANCY_STATUS
			, ANNOUNCEMENT_NUMBER
			, IS_PUBLIC
			, IS_STATUS
			, DISPLAY_TYPE
			, ISSUE_DATE
			, REVIEW_STATUS
			, REVIEW_DUE_DATE
			, REVIEW_RETURN_DATE
			, RETURN_STATUS
			, AUDIT_CODE
			, AUDIT_DATE
			, LAST_UPDATE_DATE
			, POSITION_TITLE
			, DUTY_LOCATION
			, PAYPLAN_SERIES_GRADE
			, HIRING_PLAN
			, APPLICANT_LIST_NAME
			, CERTIFICATION_STATUS
			, ELIGIBILITY_FILTER)
		SELECT
			X.REQUEST_NUMBER
			, X.VIN
			, X.REQUEST_STATUS
			, X.CERTIFICATE_NUMBER
			, X.CERTIFICATE_TYPE
			, X.VACANCY_STATUS
			, X.ANNOUNCEMENT_NUMBER
			, X.IS_PUBLIC
			, X.IS_STATUS
			, X.DISPLAY_TYPE
			, TO_DATE(SUBSTR(X.ISSUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ISSUE_DATE
			, X.REVIEW_STATUS
			, TO_DATE(SUBSTR(X.REVIEW_DUE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_DUE_DATE
			, TO_DATE(SUBSTR(X.REVIEW_RETURN_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS REVIEW_RETURN_DATE
			, X.RETURN_STATUS
			, X.AUDIT_CODE
			, TO_DATE(SUBSTR(X.AUDIT_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS AUDIT_DATE
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, X.POSITION_TITLE
			, X.DUTY_LOCATION
			, X.PAYPLAN_SERIES_GRADE
			, X.HIRING_PLAN
			, X.APPLICANT_LIST_NAME
			, X.CERTIFICATION_STATUS
			, X.ELIGIBILITY_FILTER
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_CertificateInfo"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                VARCHAR2(202)     PATH 'Request__Number'
					, VIN                         NUMBER(10)        PATH 'Vacancy__Identification__Number'
					, REQUEST_STATUS              VARCHAR2(1002)    PATH 'Certificate__Request__Status'
					, CERTIFICATE_NUMBER          VARCHAR2(102)     PATH 'Certificate__Number'
					, CERTIFICATE_TYPE            VARCHAR2(82)      PATH 'Certificate__Type'
					, VACANCY_STATUS              VARCHAR2(1002)    PATH 'Certificate__Vacancy__Status'
					, ANNOUNCEMENT_NUMBER         VARCHAR2(56)      PATH 'Certificate__Announcement__Number'
					, IS_PUBLIC                   VARCHAR2(8)       PATH 'Certificate__Vacancy__USAJOBS__Announcement__Type___x0028Is__Public_x0029'
					, IS_STATUS                   VARCHAR2(8)       PATH 'Certificate__Vacancy__USAJOBS__Announcement__Type___x0028Is__Status_x0029'
					, DISPLAY_TYPE                VARCHAR2(24)      PATH 'Certificate__Vacancy__USAJOBS__Display__Type'
					, ISSUE_DATE_STR              VARCHAR2(50)      PATH 'Certificate__Issue__Date'
					, REVIEW_STATUS               VARCHAR2(1002)    PATH 'Certificate__Review__Status'
					, REVIEW_DUE_DATE_STR         VARCHAR2(50)      PATH 'Certificate__Review__Due__Date'
					, REVIEW_RETURN_DATE_STR      VARCHAR2(50)      PATH 'Certificate__Review__Returned__Date'
					, RETURN_STATUS               VARCHAR2(1002)    PATH 'Certificate__Application__Return__Status'
					, AUDIT_CODE                  VARCHAR2(82)      PATH 'Certificate__Application__Audit__Code'
					, AUDIT_DATE_STR              VARCHAR2(50)      PATH 'Certificate__Application__Audit__Date'
					, LAST_UPDATE_DATE_STR        VARCHAR2(50)      PATH 'Certificate__Last__Updated__Date_x002fTime'
					, POSITION_TITLE              VARCHAR2(202)     PATH 'Position__Title'
					, DUTY_LOCATION               VARCHAR2(334)     PATH 'Duty__Location'
					, PAYPLAN_SERIES_GRADE        VARCHAR2(1000)    PATH 'Pay__Plan_x002dSeries_x002dGrade'
					, HIRING_PLAN                 VARCHAR2(6)       PATH 'Hiring__Plan'
					, APPLICANT_LIST_NAME         VARCHAR2(6)       PATH 'Applicant__List__Name'
					, CERTIFICATION_STATUS        VARCHAR2(1508)    PATH 'Certificate__Filter__Certification__Status'
					, ELIGIBILITY_FILTER          VARCHAR2(202)     PATH 'Certificate__Filter__Eligibility'
			) X
		WHERE IDX.ID = I_ID;
		
				--------------------------------
		-- DSS_IHS_VAC_NEW_HIRE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_IHS_VAC_NEW_HIRE table');
		INSERT INTO DSS_IHS_VAC_NEW_HIRE
			(REQUEST_NUMBER
			, NEW_HIRE_NUMBER
			, NEW_HIRE_STATUS
			, NEW_HIRE_NAME
			, POSITION_TITLE
			, DUTY_LOCATION
			, PAYPLAN_SERIES_GRADE
			, PAY_PLAN
			, SERIES
			, GRADE
			, SEND_TENT_OFFR_CMPL_DATE
			, SEND_OFCL_OFFR_CMPL_DATE
			, EFFECTIVE_DATE
			, LAST_UPDATE_DATE
			, VET_PREF_STATUS
			, PROJ_START_DATE
			, ARRVL_VERIF_CMPL_DATE)
		SELECT
			X.REQUEST_NUMBER
			, X.NEW_HIRE_NUMBER
			, X.NEW_HIRE_STATUS
			, X.NEW_HIRE_NAME
			, X.POSITION_TITLE
			, X.DUTY_LOCATION
			, X.PAYPLAN_SERIES_GRADE
			, X.PAY_PLAN
			, X.SERIES
			, X.GRADE
			, TO_DATE(SUBSTR(X.SEND_TENT_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_TENT_OFFR_CMPL_DATE
			, TO_DATE(SUBSTR(X.SEND_OFCL_OFFR_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS SEND_OFCL_OFFR_CMPL_DATE
			, TO_DATE(SUBSTR(X.EFFECTIVE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS EFFECTIVE_DATE
			, TO_DATE(SUBSTR(X.LAST_UPDATE_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS LAST_UPDATE_DATE
			, X.VET_PREF_STATUS
			, TO_DATE(SUBSTR(X.PROJ_START_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS PROJ_START_DATE
			, TO_DATE(SUBSTR(X.ARRVL_VERIF_CMPL_DATE_STR, 1, 19), 'YYYY-MM-DD"T"HH24:MI:SS') AS ARRVL_VERIF_CMPL_DATE
		FROM INTG_DATA_DTL IDX
			, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_NewHireInfo"]'
				PASSING IDX.FIELD_DATA
				COLUMNS
					REQUEST_NUMBER                    VARCHAR2(202)     PATH 'Request__Number'
					, NEW_HIRE_NUMBER                 VARCHAR2(22)      PATH 'New__Hire__Number'
					, NEW_HIRE_STATUS                 VARCHAR2(1002)    PATH 'New__Hire__Status'
					, NEW_HIRE_NAME                   VARCHAR2(2050)    PATH 'New__Hire__Name'
					, POSITION_TITLE                  VARCHAR2(2050)    PATH 'Position__Title'
					, DUTY_LOCATION                   VARCHAR2(2050)    PATH 'Duty__Location'
					, PAYPLAN_SERIES_GRADE            VARCHAR2(1000)    PATH 'Pay__Plan_x002dSeries_x002dGrade'
					, PAY_PLAN                        VARCHAR2(102)     PATH 'New__Hire__Pay__Plan'
					, SERIES                          VARCHAR2(22)      PATH 'New__Hire__Series'
					, GRADE                           VARCHAR2(6)       PATH 'New__Hire__Grade'
					, SEND_TENT_OFFR_CMPL_DATE_STR    VARCHAR2(50)      PATH 'Send__Tentative__Offer__Complete__Date'
					, SEND_OFCL_OFFR_CMPL_DATE_STR    VARCHAR2(50)      PATH 'Send__Official__Offer__Complete__Date'
					, EFFECTIVE_DATE_STR              VARCHAR2(50)      PATH 'Effective__Date'
					, LAST_UPDATE_DATE_STR            VARCHAR2(50)      PATH 'New__Hire__Last__Update__Date_x002fTime'
					, VET_PREF_STATUS                 VARCHAR2(2050)    PATH 'New__Hire__Veterans__Preference__Status'
					, PROJ_START_DATE_STR             VARCHAR2(50)      PATH 'New__Hire__Projected__Start__Date'
					, ARRVL_VERIF_CMPL_DATE_STR       VARCHAR2(50)      PATH 'New__Hire__Arrival__Verified__Complete__Date'
			) X
		WHERE IDX.ID = I_ID;

	EXCEPTION
		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-20941, 'SP_UPDATE_IHS_VAC_TABLE: Invalid IHS Vacancy data.  I_ID = ' || TO_CHAR(I_ID) );
	END;

	--DBMS_OUTPUT.PUT_LINE('SP_UPDATE_IHS_VAC_TABLE - END ==========================');


EXCEPTION
	WHEN E_INVALID_REC_ID THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_IHS_VAC_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Record ID is not valid');
	WHEN E_INVALID_DATA THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_IHS_VAC_TABLE -------------------');
		--DBMS_OUTPUT.PUT_LINE('ERROR message = ' || 'Invalid data');
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		V_ERRCODE := SQLCODE;
		V_ERRMSG := SQLERRM;
		--DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing SP_UPDATE_IHS_VAC_TABLE -------------------');
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
	END IF;
	

	COMMIT;

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('Error occurred while executing SP_UPDATE_INTG_DATA -------------------');
END;

/