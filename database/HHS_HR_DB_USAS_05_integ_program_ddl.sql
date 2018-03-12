

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
		MERGE INTO DSS_ANNOUNCEMENT_DETAIL TRG
		USING
		(
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
						ANNOUNCEMENT_NUMBER                 VARCHAR2(30)    PATH 'Announcement__Number'
						, VACANCY_NUMBER                    NUMBER(10)      PATH 'Vacancy__Number'
						, ANN_CONTROL_NUMBER                NUMBER(10)      PATH 'Announcement__Control__Number'
						, ANNOUNCEMENT_STATUS               VARCHAR2(30)    PATH 'Announcement__Status'
						, IS_RELEASED                       VARCHAR2(3)     PATH 'Announcement__Is__Released'
						, RELEASED_DATE_STR                 VARCHAR2(50)    PATH 'Announcement__Released__Date_x002fTime'
						, LAST_UPDATE_DATE_STR              VARCHAR2(50)    PATH 'Announcement__Last__Update__Date_x002fTime'
						, EXTERNAL_CONTACT_NAME             VARCHAR2(100)   PATH 'Announcement__External__Contact__Name'
						, INTERNAL_CONTACT_NAME             VARCHAR2(100)   PATH 'Announcement__Internal__Contact__Name'
						, SALARY_TYPE                       VARCHAR2(20)    PATH 'Announcement__Salary__Type'
						, MINIMUM_SALARY                    NUMBER(8,2)     PATH 'Announcement__Minimum__Salary'
						, MAXIMUM_SALARY                    NUMBER(8,2)     PATH 'Announcement__Maximum__Salary'
						, OPEN_DATE_STR                     VARCHAR2(50)    PATH 'Announcement__Open__Date'
						, CLOSE_DATE_STR                    VARCHAR2(50)    PATH 'Announcement__Close__Date'
						, TOTAL_VACANCIES                   VARCHAR2(4)     PATH 'Announcement__Total__Vacancies'
						, PART_TIME_HOURS                   NUMBER(2)       PATH 'Announcement__Part__Time__Hours'
						, NOT_TO_EXCEED                     VARCHAR2(20)    PATH 'Announcement__Not__To__Exceed'
						, WHO_MAY_APPLY                     VARCHAR2(100)   PATH 'Announcement__Who__May__Apply'
						, TEMPLATE                          VARCHAR2(200)   PATH 'Announcement__Template'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.ANNOUNCEMENT_NUMBER = TRG.ANNOUNCEMENT_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			, TRG.ANN_CONTROL_NUMBER            = SRC.ANN_CONTROL_NUMBER
			, TRG.ANNOUNCEMENT_STATUS           = SRC.ANNOUNCEMENT_STATUS
			, TRG.IS_RELEASED                   = SRC.IS_RELEASED
			, TRG.RELEASED_DATE                 = SRC.RELEASED_DATE
			, TRG.LAST_UPDATE_DATE              = SRC.LAST_UPDATE_DATE
			, TRG.EXTERNAL_CONTACT_NAME         = SRC.EXTERNAL_CONTACT_NAME
			, TRG.INTERNAL_CONTACT_NAME         = SRC.INTERNAL_CONTACT_NAME
			, TRG.SALARY_TYPE                   = SRC.SALARY_TYPE
			, TRG.MINIMUM_SALARY                = SRC.MINIMUM_SALARY
			, TRG.MAXIMUM_SALARY                = SRC.MAXIMUM_SALARY
			, TRG.OPEN_DATE                     = SRC.OPEN_DATE
			, TRG.CLOSE_DATE                    = SRC.CLOSE_DATE
			, TRG.TOTAL_VACANCIES               = SRC.TOTAL_VACANCIES
			, TRG.PART_TIME_HOURS               = SRC.PART_TIME_HOURS
			, TRG.NOT_TO_EXCEED                 = SRC.NOT_TO_EXCEED
			, TRG.WHO_MAY_APPLY                 = SRC.WHO_MAY_APPLY
			, TRG.TEMPLATE                      = SRC.TEMPLATE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.ANNOUNCEMENT_NUMBER
			, TRG.VACANCY_NUMBER
			, TRG.ANN_CONTROL_NUMBER
			, TRG.ANNOUNCEMENT_STATUS
			, TRG.IS_RELEASED
			, TRG.RELEASED_DATE
			, TRG.LAST_UPDATE_DATE
			, TRG.EXTERNAL_CONTACT_NAME
			, TRG.INTERNAL_CONTACT_NAME
			, TRG.SALARY_TYPE
			, TRG.MINIMUM_SALARY
			, TRG.MAXIMUM_SALARY
			, TRG.OPEN_DATE
			, TRG.CLOSE_DATE
			, TRG.TOTAL_VACANCIES
			, TRG.PART_TIME_HOURS
			, TRG.NOT_TO_EXCEED
			, TRG.WHO_MAY_APPLY
			, TRG.TEMPLATE
		)
		VALUES
		(
			SRC.ANNOUNCEMENT_NUMBER
			, SRC.VACANCY_NUMBER
			, SRC.ANN_CONTROL_NUMBER
			, SRC.ANNOUNCEMENT_STATUS
			, SRC.IS_RELEASED
			, SRC.RELEASED_DATE
			, SRC.LAST_UPDATE_DATE
			, SRC.EXTERNAL_CONTACT_NAME
			, SRC.INTERNAL_CONTACT_NAME
			, SRC.SALARY_TYPE
			, SRC.MINIMUM_SALARY
			, SRC.MAXIMUM_SALARY
			, SRC.OPEN_DATE
			, SRC.CLOSE_DATE
			, SRC.TOTAL_VACANCIES
			, SRC.PART_TIME_HOURS
			, SRC.NOT_TO_EXCEED
			, SRC.WHO_MAY_APPLY
			, SRC.TEMPLATE
		)
		;


		--------------------------------
		-- DSS_ANNOUNCEMENT_APPT_TYPE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_ANNOUNCEMENT_APPT_TYPE table');
		MERGE INTO DSS_ANNOUNCEMENT_APPT_TYPE TRG
		USING
		(
			SELECT
				X.ANNOUNCEMENT_NUMBER
				, X.APPOINTMENT_TYPE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnouncementAppointmentType"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						ANNOUNCEMENT_NUMBER                 VARCHAR2(30)    PATH 'Announcement__Number'
						, APPOINTMENT_TYPE                  VARCHAR2(35)    PATH 'Announcement__Appointment__Type'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.ANNOUNCEMENT_NUMBER = TRG.ANNOUNCEMENT_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.APPOINTMENT_TYPE                = SRC.APPOINTMENT_TYPE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.ANNOUNCEMENT_NUMBER
			, TRG.APPOINTMENT_TYPE
		)
		VALUES
		(
			SRC.ANNOUNCEMENT_NUMBER
			, SRC.APPOINTMENT_TYPE
		)
		;


		--------------------------------
		-- DSS_ANNOUNCEMENT_WORK_SCHED table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_ANNOUNCEMENT_WORK_SCHED table');
		MERGE INTO DSS_ANNOUNCEMENT_WORK_SCHED TRG
		USING
		(
			SELECT
				X.ANNOUNCEMENT_NUMBER
				, X.WORK_SCHEDULE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_AnnouncementWorkSchedule"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						ANNOUNCEMENT_NUMBER                 VARCHAR2(30)    PATH 'Announcement__Number'
						, WORK_SCHEDULE                     VARCHAR2(18)    PATH 'Announcement__Work__Schedule'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.ANNOUNCEMENT_NUMBER = TRG.ANNOUNCEMENT_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.WORK_SCHEDULE                   = SRC.WORK_SCHEDULE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.ANNOUNCEMENT_NUMBER
			, TRG.WORK_SCHEDULE
		)
		VALUES
		(
			SRC.ANNOUNCEMENT_NUMBER
			, SRC.WORK_SCHEDULE
		)
		;


		--------------------------------
		-- DSS_ANNOUNCEMENT_LOCATION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_ANNOUNCEMENT_LOCATION table');
		MERGE INTO DSS_ANNOUNCEMENT_LOCATION TRG
		USING
		(
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
						ANNOUNCEMENT_NUMBER                 VARCHAR2(30)    PATH 'Announcement__Number'
						, LOCATION_DESCRIPTION              VARCHAR2(50)    PATH 'Announcement__Location__Description'
						, LOCATION_OPENINGS                 VARCHAR2(4)     PATH 'Announcement__Location__Openings'
						, CITY                              VARCHAR2(50)    PATH 'Announcement__Location__City'
						, STATE_ABBREV                      VARCHAR2(3)     PATH 'Announcement__Location__State__Abbreviation'
						, COUNTY                            VARCHAR2(50)    PATH 'Announcement__Location__County'
						, COUNTRY                           VARCHAR2(50)    PATH 'Announcement__Location__Country'
						, LOCATION_CODE                     VARCHAR2(10)    PATH 'Announcement__Location__Code'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.ANNOUNCEMENT_NUMBER = TRG.ANNOUNCEMENT_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.LOCATION_DESCRIPTION            = SRC.LOCATION_DESCRIPTION
			, TRG.LOCATION_OPENINGS             = SRC.LOCATION_OPENINGS
			, TRG.CITY                          = SRC.CITY
			, TRG.STATE_ABBREV                  = SRC.STATE_ABBREV
			, TRG.COUNTY                        = SRC.COUNTY
			, TRG.COUNTRY                       = SRC.COUNTRY
			, TRG.LOCATION_CODE                 = SRC.LOCATION_CODE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.ANNOUNCEMENT_NUMBER
			, TRG.LOCATION_DESCRIPTION
			, TRG.LOCATION_OPENINGS
			, TRG.CITY
			, TRG.STATE_ABBREV
			, TRG.COUNTY
			, TRG.COUNTRY
			, TRG.LOCATION_CODE
		)
		VALUES
		(
			SRC.ANNOUNCEMENT_NUMBER
			, SRC.LOCATION_DESCRIPTION
			, SRC.LOCATION_OPENINGS
			, SRC.CITY
			, SRC.STATE_ABBREV
			, SRC.COUNTY
			, SRC.COUNTRY
			, SRC.LOCATION_CODE
		)
		;


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
		MERGE INTO DSS_APPLICATION_DETAIL TRG
		USING
		(
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
						APPLICATION_NUMBER                  VARCHAR2(10)    PATH 'Application__Number'
						, VACANCY_NUMBER                    NUMBER(10)      PATH 'Vacancy__Number'
						, ANNOUNCEMENT_NUMBER               VARCHAR2(30)    PATH 'Announcement__Number'
						, APP_CONTROL_NUMBER                NUMBER(10)      PATH 'Application__Control__Number'
						, APPLICATION_STATUS                VARCHAR2(40)    PATH 'Application__Status'
						, LAST_SUBMITTED_DATE_STR           VARCHAR2(50)    PATH 'Application__Last__Submitted__Date_x002fTime'
						, FIRST_NAME                        VARCHAR2(50)    PATH 'Applicant__First__Name'
						, MIDDLE_NAME                       VARCHAR2(50)    PATH 'Applicant__Middle__Name'
						, LAST_NAME                         VARCHAR2(50)    PATH 'Applicant__Last__Name'
						, SUFFIX                            VARCHAR2(3)     PATH 'Applicant__Suffix'
						, ADDRESS_1                         VARCHAR2(75)    PATH 'Applicant__Address__Line__1'
						, ADDRESS_2                         VARCHAR2(75)    PATH 'Applicant__Address__Line__2'
						, ADDRESS_3                         VARCHAR2(75)    PATH 'Applicant__Address__Line__3'
						, POSTAL_CODE                       VARCHAR2(10)    PATH 'Applicant__Address__Postal__Code'
						, CITY                              VARCHAR2(50)    PATH 'Applicant__Address__City'
						, STATE_ABBREV                      VARCHAR2(3)     PATH 'Applicant__Address__State__Abbreviation'
						, COUNTRY                           VARCHAR2(50)    PATH 'Applicant__Address__Country'
						, CITIZENSHIP                       VARCHAR2(50)    PATH 'Applicant__Citizenship'
						, EMAIL                             VARCHAR2(100)   PATH 'Applicant__Email'
						, RECORD_STATUS_DESCRIPTION         VARCHAR2(100)   PATH 'Application__Record__Status__Description'
						, RECORD_STATUS_CODE                VARCHAR2(2)     PATH 'Application__Record__Status__Code'
						, CLAIMED_VET_PREF                  VARCHAR2(130)   PATH 'Application__Veterans__Preference__Claimed'
						, CLAIMED_VET_PREF_CODE             VARCHAR2(3)     PATH 'Application__Veterans__Preference__Claimed__Code'
						, ADJ_VET_PREF                      VARCHAR2(130)   PATH 'Application__Veterans__Preference__Adjudicated'
						, ADJ_VET_PREF_CODE                 VARCHAR2(3)     PATH 'Application__Veterans__Preference__Adjudicated__Code'
						, VET_DOC_DATE_STR                  VARCHAR2(50)    PATH 'Application__Veterans__Document__Date'
						, LOWEST_GRADE                      VARCHAR2(2)     PATH 'Application__Lowest__Acceptable__Grade'
						, ELIGIBILITY_START_DATE_STR        VARCHAR2(50)    PATH 'Application__Eligibility__Start__Date'
						, ELIGIBILITY_END_DATE_STR          VARCHAR2(50)    PATH 'Application__Eligibility__End__Date'
						, IS_FOLLOWUP                       VARCHAR2(3)     PATH 'Application__Is__Followup'
						, IS_REVIEWED                       VARCHAR2(3)     PATH 'Application__Is__Reviewed'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.APPLICATION_NUMBER = TRG.APPLICATION_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			, TRG.ANNOUNCEMENT_NUMBER           = SRC.ANNOUNCEMENT_NUMBER
			, TRG.APP_CONTROL_NUMBER            = SRC.APP_CONTROL_NUMBER
			, TRG.APPLICATION_STATUS            = SRC.APPLICATION_STATUS
			, TRG.LAST_SUBMITTED_DATE           = SRC.LAST_SUBMITTED_DATE
			, TRG.FIRST_NAME                    = SRC.FIRST_NAME
			, TRG.MIDDLE_NAME                   = SRC.MIDDLE_NAME
			, TRG.LAST_NAME                     = SRC.LAST_NAME
			, TRG.SUFFIX                        = SRC.SUFFIX
			, TRG.ADDRESS_1                     = SRC.ADDRESS_1
			, TRG.ADDRESS_2                     = SRC.ADDRESS_2
			, TRG.ADDRESS_3                     = SRC.ADDRESS_3
			, TRG.POSTAL_CODE                   = SRC.POSTAL_CODE
			, TRG.CITY                          = SRC.CITY
			, TRG.STATE_ABBREV                  = SRC.STATE_ABBREV
			, TRG.COUNTRY                       = SRC.COUNTRY
			, TRG.CITIZENSHIP                   = SRC.CITIZENSHIP
			, TRG.EMAIL                         = SRC.EMAIL
			, TRG.RECORD_STATUS_DESCRIPTION     = SRC.RECORD_STATUS_DESCRIPTION
			, TRG.RECORD_STATUS_CODE            = SRC.RECORD_STATUS_CODE
			, TRG.CLAIMED_VET_PREF              = SRC.CLAIMED_VET_PREF
			, TRG.CLAIMED_VET_PREF_CODE         = SRC.CLAIMED_VET_PREF_CODE
			, TRG.ADJ_VET_PREF                  = SRC.ADJ_VET_PREF
			, TRG.ADJ_VET_PREF_CODE             = SRC.ADJ_VET_PREF_CODE
			, TRG.VET_DOC_DATE                  = SRC.VET_DOC_DATE
			, TRG.LOWEST_GRADE                  = SRC.LOWEST_GRADE
			, TRG.ELIGIBILITY_START_DATE        = SRC.ELIGIBILITY_START_DATE
			, TRG.ELIGIBILITY_END_DATE          = SRC.ELIGIBILITY_END_DATE
			, TRG.IS_FOLLOWUP                   = SRC.IS_FOLLOWUP
			, TRG.IS_REVIEWED                   = SRC.IS_REVIEWED
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.APPLICATION_NUMBER
			, TRG.VACANCY_NUMBER
			, TRG.ANNOUNCEMENT_NUMBER
			, TRG.APP_CONTROL_NUMBER
			, TRG.APPLICATION_STATUS
			, TRG.LAST_SUBMITTED_DATE
			, TRG.FIRST_NAME
			, TRG.MIDDLE_NAME
			, TRG.LAST_NAME
			, TRG.SUFFIX
			, TRG.ADDRESS_1
			, TRG.ADDRESS_2
			, TRG.ADDRESS_3
			, TRG.POSTAL_CODE
			, TRG.CITY
			, TRG.STATE_ABBREV
			, TRG.COUNTRY
			, TRG.CITIZENSHIP
			, TRG.EMAIL
			, TRG.RECORD_STATUS_DESCRIPTION
			, TRG.RECORD_STATUS_CODE
			, TRG.CLAIMED_VET_PREF
			, TRG.CLAIMED_VET_PREF_CODE
			, TRG.ADJ_VET_PREF
			, TRG.ADJ_VET_PREF_CODE
			, TRG.VET_DOC_DATE
			, TRG.LOWEST_GRADE
			, TRG.ELIGIBILITY_START_DATE
			, TRG.ELIGIBILITY_END_DATE
			, TRG.IS_FOLLOWUP
			, TRG.IS_REVIEWED
		)
		VALUES
		(
			SRC.APPLICATION_NUMBER
			, SRC.VACANCY_NUMBER
			, SRC.ANNOUNCEMENT_NUMBER
			, SRC.APP_CONTROL_NUMBER
			, SRC.APPLICATION_STATUS
			, SRC.LAST_SUBMITTED_DATE
			, SRC.FIRST_NAME
			, SRC.MIDDLE_NAME
			, SRC.LAST_NAME
			, SRC.SUFFIX
			, SRC.ADDRESS_1
			, SRC.ADDRESS_2
			, SRC.ADDRESS_3
			, SRC.POSTAL_CODE
			, SRC.CITY
			, SRC.STATE_ABBREV
			, SRC.COUNTRY
			, SRC.CITIZENSHIP
			, SRC.EMAIL
			, SRC.RECORD_STATUS_DESCRIPTION
			, SRC.RECORD_STATUS_CODE
			, SRC.CLAIMED_VET_PREF
			, SRC.CLAIMED_VET_PREF_CODE
			, SRC.ADJ_VET_PREF
			, SRC.ADJ_VET_PREF_CODE
			, SRC.VET_DOC_DATE
			, SRC.LOWEST_GRADE
			, SRC.ELIGIBILITY_START_DATE
			, SRC.ELIGIBILITY_END_DATE
			, SRC.IS_FOLLOWUP
			, SRC.IS_REVIEWED
		)
		;


		--------------------------------
		-- DSS_APPLICATION_DOCUMENT table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_DOCUMENT table');
		MERGE INTO DSS_APPLICATION_DOCUMENT TRG
		USING
		(
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
						APPLICATION_NUMBER                  VARCHAR2(10)    PATH 'Application__Number'
						, DOC_NAME                          VARCHAR2(100)   PATH 'Application__Document__Name'
						, DOC_TYPE                          VARCHAR2(50)    PATH 'Application__Document__Type'
						, DOC_PROCESSED_DATE_STR            VARCHAR2(50)    PATH 'Application__Document__Processed__Date_x002fTime'
						, APP_RETREIVED_DATE_STR            VARCHAR2(50)    PATH 'Application__Document__Retrieved__Date_x002fTime'
						, DOC_HM_VIEWABLE                   VARCHAR2(3)     PATH 'Application__Document__HM__Viewable'
						, DOC_NH_VIEWABLE                   VARCHAR2(3)     PATH 'Application__Document__NH__Viewable'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.APPLICATION_NUMBER = TRG.APPLICATION_NUMBER AND SRC.DOC_NAME = TRG.DOC_NAME)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.DOC_TYPE                        = SRC.DOC_TYPE
			, TRG.DOC_PROCESSED_DATE            = SRC.DOC_PROCESSED_DATE
			, TRG.APP_RETREIVED_DATE            = SRC.APP_RETREIVED_DATE
			, TRG.DOC_HM_VIEWABLE               = SRC.DOC_HM_VIEWABLE
			, TRG.DOC_NH_VIEWABLE               = SRC.DOC_NH_VIEWABLE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.APPLICATION_NUMBER
			, TRG.DOC_NAME
			, TRG.DOC_TYPE
			, TRG.DOC_PROCESSED_DATE
			, TRG.APP_RETREIVED_DATE
			, TRG.DOC_HM_VIEWABLE
			, TRG.DOC_NH_VIEWABLE
		)
		VALUES
		(
			SRC.APPLICATION_NUMBER
			, SRC.DOC_NAME
			, SRC.DOC_TYPE
			, SRC.DOC_PROCESSED_DATE
			, SRC.APP_RETREIVED_DATE
			, SRC.DOC_HM_VIEWABLE
			, SRC.DOC_NH_VIEWABLE
		)
		;


		--------------------------------
		-- DSS_APPLICATION_ELIGIBILITY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_ELIGIBILITY table');
		MERGE INTO DSS_APPLICATION_ELIGIBILITY TRG
		USING
		(
			SELECT
				X.APPLICATION_NUMBER
				, X.ELIGIBILITY
				, X.ELIGIBILITY_ADJ
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationEligibility"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						APPLICATION_NUMBER                  VARCHAR2(10)    PATH 'Application__Number'
						, ELIGIBILITY                       VARCHAR2(100)   PATH 'Application__Eligibility'
						, ELIGIBILITY_ADJ                   VARCHAR2(10)    PATH 'Application__Eligibility__Adjudication'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.APPLICATION_NUMBER = TRG.APPLICATION_NUMBER AND SRC.ELIGIBILITY = TRG.ELIGIBILITY)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.ELIGIBILITY_ADJ                 = SRC.ELIGIBILITY_ADJ
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.APPLICATION_NUMBER
			, TRG.ELIGIBILITY
			, TRG.ELIGIBILITY_ADJ
		)
		VALUES
		(
			SRC.APPLICATION_NUMBER
			, SRC.ELIGIBILITY
			, SRC.ELIGIBILITY_ADJ
		)
		;


		--------------------------------
		-- DSS_APPLICATION_LOCATION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_LOCATION table');
		MERGE INTO DSS_APPLICATION_LOCATION TRG
		USING
		(
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
						APPLICATION_NUMBER                  VARCHAR2(10)    PATH 'Application__Number'
						, LOCATION_DESCRIPTION              VARCHAR2(50)    PATH 'Application__Location__Description'
						, CITY                              VARCHAR2(50)    PATH 'Application__Location__City'
						, STATE_ABBREV                      VARCHAR2(3)     PATH 'Application__Location__State__Abbreviation'
						, COUNTY                            VARCHAR2(50)    PATH 'Application__Location__County'
						, COUNTRY                           VARCHAR2(50)    PATH 'Application__Location__Country'
						, LOCATION_CODE                     VARCHAR2(10)    PATH 'Application__Location__Code'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.APPLICATION_NUMBER = TRG.APPLICATION_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.LOCATION_DESCRIPTION            = SRC.LOCATION_DESCRIPTION
			, TRG.CITY                          = SRC.CITY
			, TRG.STATE_ABBREV                  = SRC.STATE_ABBREV
			, TRG.COUNTY                        = SRC.COUNTY
			, TRG.COUNTRY                       = SRC.COUNTRY
			, TRG.LOCATION_CODE                 = SRC.LOCATION_CODE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.APPLICATION_NUMBER
			, TRG.LOCATION_DESCRIPTION
			, TRG.CITY
			, TRG.STATE_ABBREV
			, TRG.COUNTY
			, TRG.COUNTRY
			, TRG.LOCATION_CODE
		)
		VALUES
		(
			SRC.APPLICATION_NUMBER
			, SRC.LOCATION_DESCRIPTION
			, SRC.CITY
			, SRC.STATE_ABBREV
			, SRC.COUNTY
			, SRC.COUNTRY
			, SRC.LOCATION_CODE
		)
		;


		--------------------------------
		-- DSS_APPLICANT_PHONE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICANT_PHONE table');
		MERGE INTO DSS_APPLICANT_PHONE TRG
		USING
		(
			SELECT
				X.APPLICATION_NUMBER
				, X.PHONE_TYPE
				, X.PHONE_NUMBER
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_ApplicationPhone"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						APPLICATION_NUMBER                  VARCHAR2(10)    PATH 'Application__Number'
						, PHONE_TYPE                        VARCHAR2(8)     PATH 'Applicant__Phone__Type'
						, PHONE_NUMBER                      VARCHAR2(30)    PATH 'Applicant__Phone__Number'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.APPLICATION_NUMBER = TRG.APPLICATION_NUMBER AND SRC.PHONE_TYPE = TRG.PHONE_TYPE)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.PHONE_NUMBER                    = SRC.PHONE_NUMBER
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.APPLICATION_NUMBER
			, TRG.PHONE_TYPE
			, TRG.PHONE_NUMBER
		)
		VALUES
		(
			SRC.APPLICATION_NUMBER
			, SRC.PHONE_TYPE
			, SRC.PHONE_NUMBER
		)
		;


		--------------------------------
		-- DSS_APPLICATION_RATING table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_APPLICATION_RATING table');
		MERGE INTO DSS_APPLICATION_RATING TRG
		USING
		(
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
						APPLICATION_NUMBER                  VARCHAR2(10)    PATH 'Application__Number'
						, SERIES                            VARCHAR2(4)     PATH 'Application__Series'
						, GRADE                             VARCHAR2(2)     PATH 'Application__Grade'
						, SPECIALTY                         VARCHAR2(100)   PATH 'Application__Specialty'
						, RATING_MSG_CODE                   VARCHAR2(4)     PATH 'Application__Rating__Notification__Message__Code'
						, DISPLAY_RATING                    VARCHAR2(10)    PATH 'Application__Display__Rating'
						, FINAL_RATING                      NUMBER(7,4)     PATH 'Application__Final__Rating'
						, AUGMENTED_RATING                  NUMBER(7,4)     PATH 'Application__Augmented__Rating'
						, RATING_CREATION_DATE_STR          VARCHAR2(50)    PATH 'Application__Rating__Creation__Date_x002fTime'
						, RATING_AVAIL_STATUS               VARCHAR2(20)    PATH 'Application__Rating__Availability__Status'
						, RATING_CATEGORY_LBL               VARCHAR2(20)    PATH 'Application__Rating__Category__Label'
						, IS_OVERRIDE                       VARCHAR2(3)     PATH 'Application__Rating__Is__Override'
						, RATING_MODIFIED_DATE_STR          VARCHAR2(50)    PATH 'Application__Rating__Modified__Date_x002fTime'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.APPLICATION_NUMBER = TRG.APPLICATION_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.SERIES                          = SRC.SERIES
			, TRG.GRADE                         = SRC.GRADE
			, TRG.SPECIALTY                     = SRC.SPECIALTY
			, TRG.RATING_MSG_CODE               = SRC.RATING_MSG_CODE
			, TRG.DISPLAY_RATING                = SRC.DISPLAY_RATING
			, TRG.FINAL_RATING                  = SRC.FINAL_RATING
			, TRG.AUGMENTED_RATING              = SRC.AUGMENTED_RATING
			, TRG.RATING_CREATION_DATE          = SRC.RATING_CREATION_DATE
			, TRG.RATING_AVAIL_STATUS           = SRC.RATING_AVAIL_STATUS
			, TRG.RATING_CATEGORY_LBL           = SRC.RATING_CATEGORY_LBL
			, TRG.IS_OVERRIDE                   = SRC.IS_OVERRIDE
			, TRG.RATING_MODIFIED_DATE          = SRC.RATING_MODIFIED_DATE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.APPLICATION_NUMBER
			, TRG.SERIES
			, TRG.GRADE
			, TRG.SPECIALTY
			, TRG.RATING_MSG_CODE
			, TRG.DISPLAY_RATING
			, TRG.FINAL_RATING
			, TRG.AUGMENTED_RATING
			, TRG.RATING_CREATION_DATE
			, TRG.RATING_AVAIL_STATUS
			, TRG.RATING_CATEGORY_LBL
			, TRG.IS_OVERRIDE
			, TRG.RATING_MODIFIED_DATE
		)
		VALUES
		(
			SRC.APPLICATION_NUMBER
			, SRC.SERIES
			, SRC.GRADE
			, SRC.SPECIALTY
			, SRC.RATING_MSG_CODE
			, SRC.DISPLAY_RATING
			, SRC.FINAL_RATING
			, SRC.AUGMENTED_RATING
			, SRC.RATING_CREATION_DATE
			, SRC.RATING_AVAIL_STATUS
			, SRC.RATING_CATEGORY_LBL
			, SRC.IS_OVERRIDE
			, SRC.RATING_MODIFIED_DATE
		)
		;


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
		MERGE INTO DSS_CERTIFICATE TRG
		USING
		(
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
						CERTIFICATE_NUMBER                  VARCHAR2(20)    PATH 'Certificate__Number'
	                    , AUDITED                           VARCHAR2(3)     PATH 'Certificate__Audited'
						, AUDITOR                           VARCHAR2(100)   PATH 'Certificate__Auditor'
						, CUTOFF_NUMBER                     NUMBER(4)       PATH 'Certificate__Cutoff__Number'
						, FINAL_AUDIT_DATE_STR              VARCHAR2(50)    PATH 'Certificate__Final__Audit__Complete__Date'
						, INITIAL_AUDIT_DATE_STR            VARCHAR2(50)    PATH 'Certificate__Initial__Audit__Complete__Date'
						, ISSUE_DATE_STR                    VARCHAR2(50)    PATH 'Certificate__Issue__Date'
						, ISSUER                            VARCHAR2(100)   PATH 'Certificate__Issuer'
						, LAST_UPDATE_DATE_STR              VARCHAR2(50)    PATH 'Certificate__Last__Updated__Date_x002fTime'
						, CERT_ORDER                        VARCHAR2(10)    PATH 'Certificate__Order'
						, PRIORITY_ORDER                    VARCHAR2(40)    PATH 'Certificate__Priority__Order'
						, QUALIFIED_SCORE                   NUMBER(3)       PATH 'Certificate__Qualified__Score'
						, RANK_BY_DESCRIPTION               VARCHAR2(40)    PATH 'Certificate__Rank__By__Description'
						, REFER_METHOD                      VARCHAR2(20)    PATH 'Certificate__Refer__Method'
						, TIE_BREAKER                       VARCHAR2(20)    PATH 'Certificate__Tie__Breaker'
						, CERTIFICATE_TYPE                  VARCHAR2(30)    PATH 'Certificate__Type'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.CERTIFICATE_NUMBER = TRG.CERTIFICATE_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.AUDITED                         = SRC.AUDITED
			, TRG.AUDITOR                       = SRC.AUDITOR
			, TRG.CUTOFF_NUMBER                 = SRC.CUTOFF_NUMBER
			, TRG.FINAL_AUDIT_DATE              = SRC.FINAL_AUDIT_DATE
			, TRG.INITIAL_AUDIT_DATE            = SRC.INITIAL_AUDIT_DATE
			, TRG.ISSUE_DATE                    = SRC.ISSUE_DATE
			, TRG.ISSUER                        = SRC.ISSUER
			, TRG.LAST_UPDATE_DATE              = SRC.LAST_UPDATE_DATE
			, TRG.CERT_ORDER                    = SRC.CERT_ORDER
			, TRG.PRIORITY_ORDER                = SRC.PRIORITY_ORDER
			, TRG.QUALIFIED_SCORE               = SRC.QUALIFIED_SCORE
			, TRG.RANK_BY_DESCRIPTION           = SRC.RANK_BY_DESCRIPTION
			, TRG.REFER_METHOD                  = SRC.REFER_METHOD
			, TRG.TIE_BREAKER                   = SRC.TIE_BREAKER
			, TRG.CERTIFICATE_TYPE              = SRC.CERTIFICATE_TYPE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.CERTIFICATE_NUMBER
			, TRG.AUDITED
			, TRG.AUDITOR
			, TRG.CUTOFF_NUMBER
			, TRG.FINAL_AUDIT_DATE
			, TRG.INITIAL_AUDIT_DATE
			, TRG.ISSUE_DATE
			, TRG.ISSUER
			, TRG.LAST_UPDATE_DATE
			, TRG.CERT_ORDER
			, TRG.PRIORITY_ORDER
			, TRG.QUALIFIED_SCORE
			, TRG.RANK_BY_DESCRIPTION
			, TRG.REFER_METHOD
			, TRG.TIE_BREAKER
			, TRG.CERTIFICATE_TYPE
		)
		VALUES
		(
			SRC.CERTIFICATE_NUMBER
			, SRC.AUDITED
			, SRC.AUDITOR
			, SRC.CUTOFF_NUMBER
			, SRC.FINAL_AUDIT_DATE
			, SRC.INITIAL_AUDIT_DATE
			, SRC.ISSUE_DATE
			, SRC.ISSUER
			, SRC.LAST_UPDATE_DATE
			, SRC.CERT_ORDER
			, SRC.PRIORITY_ORDER
			, SRC.QUALIFIED_SCORE
			, SRC.RANK_BY_DESCRIPTION
			, SRC.REFER_METHOD
			, SRC.TIE_BREAKER
			, SRC.CERTIFICATE_TYPE
		)
		;


		--------------------------------
		-- DSS_CERTIFICATE_APP table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_CERTIFICATE_APP table');
		MERGE INTO DSS_CERTIFICATE_APP TRG
		USING
		(
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
						APPLICATION_NUMBER                  VARCHAR2(10)    PATH 'Certificate__Application__Number'
						, ADDED                             VARCHAR2(3)     PATH 'Certificate__Application__Added'
						, ADD_DATE_STR                      VARCHAR2(50)    PATH 'Certificate__Application__Add__Date'
						, AUDIT_CODE                        VARCHAR2(20)    PATH 'Certificate__Application__Audit__Code'
						, AUDIT_DATE_STR                    VARCHAR2(50)    PATH 'Certificate__Application__Audit__Date'
						, CERTIFIED_DATE_STR                VARCHAR2(50)    PATH 'Certificate__Application__Certified__Date'
						, FIRST_NAME                        VARCHAR2(50)    PATH 'Certificate__Application__First__Name'
						, MIDDLE_NAME                       VARCHAR2(50)    PATH 'Certificate__Application__Middle__Name'
						, LAST_NAME                         VARCHAR2(50)    PATH 'Certificate__Application__Last__Name'
						, SUFFIX                            VARCHAR2(3)     PATH 'Certificate__Application__Suffix'
						, LOCATION_DESCRIPTION              VARCHAR2(50)    PATH 'Certificate__Application__Hired__Location__Description'
						, CITY                              VARCHAR2(50)    PATH 'Certificate__Application__Hired__Location__City'
						, STATE                             VARCHAR2(50)    PATH 'Certificate__Application__Hired__Location__State'
						, COUNTRY                           VARCHAR2(50)    PATH 'Certificate__Application__Hired__Location__Country'
						, PD_NUMBER                         VARCHAR2(20)    PATH 'Certificate__Application__Hired__Position__Description__Number'
						, POSITION_TITLE                    VARCHAR2(100)   PATH 'Certificate__Application__Hired__Position__Title'
						, SERIES                            VARCHAR2(4)     PATH 'Certificate__Application__Hired__Series'
						, SERIES_TITLE                      VARCHAR2(100)   PATH 'Certificate__Application__Hired__Series__Title'
						, PRIORITY_DESCRIPTION              VARCHAR2(50)    PATH 'Certificate__Application__Priority__Description'
						, RANK_ORDER                        NUMBER(3)       PATH 'Certificate__Application__Rank__Order'
						, RATING                            VARCHAR2(4)     PATH 'Certificate__Application__Rating'
						, REORDERED                         VARCHAR2(3)     PATH 'Certificate__Application__Reordered'
						, RETURN_STATUS                     VARCHAR2(20)    PATH 'Certificate__Application__Return__Status'
						, VET_PREF_CODE                     VARCHAR2(3)     PATH 'Certificate__Application__Veterans__Preference__Code'
						, VET_PREF_DESCRIPTION              VARCHAR2(250)   PATH 'Certificate__Application__Veterans__Preference__Description'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.APPLICATION_NUMBER = TRG.APPLICATION_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.ADDED                           = SRC.ADDED
			, TRG.ADD_DATE                      = SRC.ADD_DATE
			, TRG.AUDIT_CODE                    = SRC.AUDIT_CODE
			, TRG.AUDIT_DATE                    = SRC.AUDIT_DATE
			, TRG.CERTIFIED_DATE                = SRC.CERTIFIED_DATE
			, TRG.FIRST_NAME                    = SRC.FIRST_NAME
			, TRG.MIDDLE_NAME                   = SRC.MIDDLE_NAME
			, TRG.LAST_NAME                     = SRC.LAST_NAME
			, TRG.SUFFIX                        = SRC.SUFFIX
			, TRG.LOCATION_DESCRIPTION          = SRC.LOCATION_DESCRIPTION
			, TRG.CITY                          = SRC.CITY
			, TRG.STATE                         = SRC.STATE
			, TRG.COUNTRY                       = SRC.COUNTRY
			, TRG.PD_NUMBER                     = SRC.PD_NUMBER
			, TRG.POSITION_TITLE                = SRC.POSITION_TITLE
			, TRG.SERIES                        = SRC.SERIES
			, TRG.SERIES_TITLE                  = SRC.SERIES_TITLE
			, TRG.PRIORITY_DESCRIPTION          = SRC.PRIORITY_DESCRIPTION
			, TRG.RANK_ORDER                    = SRC.RANK_ORDER
			, TRG.RATING                        = SRC.RATING
			, TRG.REORDERED                     = SRC.REORDERED
			, TRG.RETURN_STATUS                 = SRC.RETURN_STATUS
			, TRG.VET_PREF_CODE                 = SRC.VET_PREF_CODE
			, TRG.VET_PREF_DESCRIPTION          = SRC.VET_PREF_DESCRIPTION
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.APPLICATION_NUMBER
			, TRG.ADDED
			, TRG.ADD_DATE
			, TRG.AUDIT_CODE
			, TRG.AUDIT_DATE
			, TRG.CERTIFIED_DATE
			, TRG.FIRST_NAME
			, TRG.MIDDLE_NAME
			, TRG.LAST_NAME
			, TRG.SUFFIX
			, TRG.LOCATION_DESCRIPTION
			, TRG.CITY
			, TRG.STATE
			, TRG.COUNTRY
			, TRG.PD_NUMBER
			, TRG.POSITION_TITLE
			, TRG.SERIES
			, TRG.SERIES_TITLE
			, TRG.PRIORITY_DESCRIPTION
			, TRG.RANK_ORDER
			, TRG.RATING
			, TRG.REORDERED
			, TRG.RETURN_STATUS
			, TRG.VET_PREF_CODE
			, TRG.VET_PREF_DESCRIPTION
		)
		VALUES
		(
			SRC.APPLICATION_NUMBER
			, SRC.ADDED
			, SRC.ADD_DATE
			, SRC.AUDIT_CODE
			, SRC.AUDIT_DATE
			, SRC.CERTIFIED_DATE
			, SRC.FIRST_NAME
			, SRC.MIDDLE_NAME
			, SRC.LAST_NAME
			, SRC.SUFFIX
			, SRC.LOCATION_DESCRIPTION
			, SRC.CITY
			, SRC.STATE
			, SRC.COUNTRY
			, SRC.PD_NUMBER
			, SRC.POSITION_TITLE
			, SRC.SERIES
			, SRC.SERIES_TITLE
			, SRC.PRIORITY_DESCRIPTION
			, SRC.RANK_ORDER
			, SRC.RATING
			, SRC.REORDERED
			, SRC.RETURN_STATUS
			, SRC.VET_PREF_CODE
			, SRC.VET_PREF_DESCRIPTION
		)
		;


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
		MERGE INTO DSS_NEW_HIRE TRG
		USING
		(
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
						NEW_HIRE_NUMBER                     VARCHAR2(10)    PATH 'New__Hire__Number'
						, NEW_HIRE_FIRST_NAME               VARCHAR2(50)    PATH 'New__Hire__First__Name'
						, NEW_HIRE_MIDDLE_NAME              VARCHAR2(50)    PATH 'New__Hire__Middle__Name'
						, NEW_HIRE_LAST_NAME                VARCHAR2(50)    PATH 'New__Hire__Last__Name'
						, NEW_HIRE_SUFFIX                   VARCHAR2(3)     PATH 'New__Hire__Suffix'
						, NEW_HIRE_MAIDEN_NAME              VARCHAR2(50)    PATH 'New__Hire__Maiden__Name'
						, NEW_HIRE_NAME                     VARCHAR2(100)   PATH 'New__Hire__Name'
						, NEW_HIRE_EMAIL                    VARCHAR2(100)   PATH 'New__Hire__Email'
						, NEW_HIRE_ADDRESS_1                VARCHAR2(75)    PATH 'New__Hire__Address__1'
						, NEW_HIRE_ADDRESS_2                VARCHAR2(75)    PATH 'New__Hire__Address__2'
						, NEW_HIRE_APT                      VARCHAR2(20)    PATH 'New__Hire__Apt_x002fSuite'
						, NEW_HIRE_CITY                     VARCHAR2(50)    PATH 'New__Hire__City'
						, NEW_HIRE_STATE                    VARCHAR2(50)    PATH 'New__Hire__State'
						, NEW_HIRE_COUNTRY                  VARCHAR2(50)    PATH 'New__Hire__Country'
						, NEW_HIRE_POSTAL_CODE              VARCHAR2(10)    PATH 'New__Hire__Postal__Code'
						, AGENCY                            VARCHAR2(100)   PATH 'New__Hire__Agency_x002fDepartment'
						, AGENCY_ADDRESS_1                  VARCHAR2(75)    PATH 'New__Hire__Agency_x002fDepartment__Address__1'
						, AGENCY_ADDRESS_2                  VARCHAR2(75)    PATH 'New__Hire__Agency_x002fDepartment__Address__2'
						, AGENCY_ADDRESS_3                  VARCHAR2(75)    PATH 'New__Hire__Agency_x002fDepartment__Address__3'
						, AGENCY_CITY                       VARCHAR2(50)    PATH 'New__Hire__Agency_x002fDepartment__Address__City'
						, AGENCY_STATE                      VARCHAR2(50)    PATH 'New__Hire__Agency_x002fDepartment__Address__State'
						, AGENCY_COUNTRY                    VARCHAR2(50)    PATH 'New__Hire__Agency_x002fDepartment__Address__Country'
						, AGENCY_POSTAL_CODE                VARCHAR2(10)    PATH 'New__Hire__Agency_x002fDepartment__Address__Postal__Code'
						, BRANCH                            VARCHAR2(100)   PATH 'New__Hire__Branch_x002fOrganization'
						, BUREAU                            VARCHAR2(100)   PATH 'New__Hire__Bureau_x002fDivision'
						, UNIT                              VARCHAR2(30)    PATH 'New__Hire__Activity_x002fUnit'
						, PD_NUMBER                         VARCHAR2(50)    PATH 'New__Hire__Position__Description__Number'
						, POSITION_TITLE                    VARCHAR2(100)   PATH 'New__Hire__Position__Title'
						, PAY_PLAN                          VARCHAR2(2)     PATH 'New__Hire__Pay__Plan'
						, SERIES                            VARCHAR2(4)     PATH 'New__Hire__Series'
						, GRADE                             VARCHAR2(2)     PATH 'New__Hire__Grade'
						, DUTY_LOCATION                     VARCHAR2(100)   PATH 'New__Hire__Duty__Location'
						, DUTY_LOCATION_CODE                VARCHAR2(50)    PATH 'New__Hire__Duty__Location__Code'
						, PROJECTED_START_DATE_STR          VARCHAR2(50)    PATH 'New__Hire__Projected__Start__Date'
						, PROLONGED_START_DATE_RSN          VARCHAR2(50)    PATH 'New__Hire__Prolonged__Start__Date__Reason'
						, ACTUAL_START_DATE_STR             VARCHAR2(50)    PATH 'New__Hire__Actual__Start__Date'
						, VET_PREF_STATUS                   VARCHAR2(130)   PATH 'New__Hire__Veterans__Preference__Status'
						, LAST_UPDATE_DATE_STR              VARCHAR2(50)    PATH 'New__Hire__Last__Update__Date_x002fTime'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.NEW_HIRE_NUMBER = TRG.NEW_HIRE_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.NEW_HIRE_FIRST_NAME             = SRC.NEW_HIRE_FIRST_NAME
			, TRG.NEW_HIRE_MIDDLE_NAME          = SRC.NEW_HIRE_MIDDLE_NAME
			, TRG.NEW_HIRE_LAST_NAME            = SRC.NEW_HIRE_LAST_NAME
			, TRG.NEW_HIRE_SUFFIX               = SRC.NEW_HIRE_SUFFIX
			, TRG.NEW_HIRE_MAIDEN_NAME          = SRC.NEW_HIRE_MAIDEN_NAME
			, TRG.NEW_HIRE_NAME                 = SRC.NEW_HIRE_NAME
			, TRG.NEW_HIRE_EMAIL                = SRC.NEW_HIRE_EMAIL
			, TRG.NEW_HIRE_ADDRESS_1            = SRC.NEW_HIRE_ADDRESS_1
			, TRG.NEW_HIRE_ADDRESS_2            = SRC.NEW_HIRE_ADDRESS_2
			, TRG.NEW_HIRE_APT                  = SRC.NEW_HIRE_APT
			, TRG.NEW_HIRE_CITY                 = SRC.NEW_HIRE_CITY
			, TRG.NEW_HIRE_STATE                = SRC.NEW_HIRE_STATE
			, TRG.NEW_HIRE_COUNTRY              = SRC.NEW_HIRE_COUNTRY
			, TRG.NEW_HIRE_POSTAL_CODE          = SRC.NEW_HIRE_POSTAL_CODE
			, TRG.AGENCY                        = SRC.AGENCY
			, TRG.AGENCY_ADDRESS_1              = SRC.AGENCY_ADDRESS_1
			, TRG.AGENCY_ADDRESS_2              = SRC.AGENCY_ADDRESS_2
			, TRG.AGENCY_ADDRESS_3              = SRC.AGENCY_ADDRESS_3
			, TRG.AGENCY_CITY                   = SRC.AGENCY_CITY
			, TRG.AGENCY_STATE                  = SRC.AGENCY_STATE
			, TRG.AGENCY_COUNTRY                = SRC.AGENCY_COUNTRY
			, TRG.AGENCY_POSTAL_CODE            = SRC.AGENCY_POSTAL_CODE
			, TRG.BRANCH                        = SRC.BRANCH
			, TRG.BUREAU                        = SRC.BUREAU
			, TRG.UNIT                          = SRC.UNIT
			, TRG.PD_NUMBER                     = SRC.PD_NUMBER
			, TRG.POSITION_TITLE                = SRC.POSITION_TITLE
			, TRG.PAY_PLAN                      = SRC.PAY_PLAN
			, TRG.SERIES                        = SRC.SERIES
			, TRG.GRADE                         = SRC.GRADE
			, TRG.DUTY_LOCATION                 = SRC.DUTY_LOCATION
			, TRG.DUTY_LOCATION_CODE            = SRC.DUTY_LOCATION_CODE
			, TRG.PROJECTED_START_DATE          = SRC.PROJECTED_START_DATE
			, TRG.PROLONGED_START_DATE_RSN      = SRC.PROLONGED_START_DATE_RSN
			, TRG.ACTUAL_START_DATE             = SRC.ACTUAL_START_DATE
			, TRG.VET_PREF_STATUS               = SRC.VET_PREF_STATUS
			, TRG.LAST_UPDATE_DATE              = SRC.LAST_UPDATE_DATE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.NEW_HIRE_NUMBER
			, TRG.NEW_HIRE_FIRST_NAME
			, TRG.NEW_HIRE_MIDDLE_NAME
			, TRG.NEW_HIRE_LAST_NAME
			, TRG.NEW_HIRE_SUFFIX
			, TRG.NEW_HIRE_MAIDEN_NAME
			, TRG.NEW_HIRE_NAME
			, TRG.NEW_HIRE_EMAIL
			, TRG.NEW_HIRE_ADDRESS_1
			, TRG.NEW_HIRE_ADDRESS_2
			, TRG.NEW_HIRE_APT
			, TRG.NEW_HIRE_CITY
			, TRG.NEW_HIRE_STATE
			, TRG.NEW_HIRE_COUNTRY
			, TRG.NEW_HIRE_POSTAL_CODE
			, TRG.AGENCY
			, TRG.AGENCY_ADDRESS_1
			, TRG.AGENCY_ADDRESS_2
			, TRG.AGENCY_ADDRESS_3
			, TRG.AGENCY_CITY
			, TRG.AGENCY_STATE
			, TRG.AGENCY_COUNTRY
			, TRG.AGENCY_POSTAL_CODE
			, TRG.BRANCH
			, TRG.BUREAU
			, TRG.UNIT
			, TRG.PD_NUMBER
			, TRG.POSITION_TITLE
			, TRG.PAY_PLAN
			, TRG.SERIES
			, TRG.GRADE
			, TRG.DUTY_LOCATION
			, TRG.DUTY_LOCATION_CODE
			, TRG.PROJECTED_START_DATE
			, TRG.PROLONGED_START_DATE_RSN
			, TRG.ACTUAL_START_DATE
			, TRG.VET_PREF_STATUS
			, TRG.LAST_UPDATE_DATE
		)
		VALUES
		(
			SRC.NEW_HIRE_NUMBER
			, SRC.NEW_HIRE_FIRST_NAME
			, SRC.NEW_HIRE_MIDDLE_NAME
			, SRC.NEW_HIRE_LAST_NAME
			, SRC.NEW_HIRE_SUFFIX
			, SRC.NEW_HIRE_MAIDEN_NAME
			, SRC.NEW_HIRE_NAME
			, SRC.NEW_HIRE_EMAIL
			, SRC.NEW_HIRE_ADDRESS_1
			, SRC.NEW_HIRE_ADDRESS_2
			, SRC.NEW_HIRE_APT
			, SRC.NEW_HIRE_CITY
			, SRC.NEW_HIRE_STATE
			, SRC.NEW_HIRE_COUNTRY
			, SRC.NEW_HIRE_POSTAL_CODE
			, SRC.AGENCY
			, SRC.AGENCY_ADDRESS_1
			, SRC.AGENCY_ADDRESS_2
			, SRC.AGENCY_ADDRESS_3
			, SRC.AGENCY_CITY
			, SRC.AGENCY_STATE
			, SRC.AGENCY_COUNTRY
			, SRC.AGENCY_POSTAL_CODE
			, SRC.BRANCH
			, SRC.BUREAU
			, SRC.UNIT
			, SRC.PD_NUMBER
			, SRC.POSITION_TITLE
			, SRC.PAY_PLAN
			, SRC.SERIES
			, SRC.GRADE
			, SRC.DUTY_LOCATION
			, SRC.DUTY_LOCATION_CODE
			, SRC.PROJECTED_START_DATE
			, SRC.PROLONGED_START_DATE_RSN
			, SRC.ACTUAL_START_DATE
			, SRC.VET_PREF_STATUS
			, SRC.LAST_UPDATE_DATE
		)
		;


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
		MERGE INTO DSS_REQUEST_DETAIL TRG
		USING
		(
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
						REQUEST_NUMBER                      VARCHAR2(50)    PATH 'Request__Number'
						, REQUEST_DESCRIPTION               VARCHAR2(30)    PATH 'Request__Description'
						, REQUEST_STATUS                    VARCHAR2(30)    PATH 'Request__Status'
						, REQUEST_TYPE                      VARCHAR2(20)    PATH 'Request__Type'
						, REQUEST_SOURCE                    VARCHAR2(10)    PATH 'Request__Source'
						, LAST_UPDATE_DATE_STR              VARCHAR2(50)    PATH 'Request__Last__Update__Date_x002fTime'
						, CREATION_DATE_STR                 VARCHAR2(50)    PATH 'Request__Creation__Date'
						, SUBMISSION_DATE_STR               VARCHAR2(50)    PATH 'Request__Submission__Date'
						, REQUESTER_NAME                    VARCHAR2(100)   PATH 'Requester__Name'
						, REQUESTER_EMAIL                   VARCHAR2(100)   PATH 'Requester__Email'
						, APPROVER_NAME                     VARCHAR2(100)   PATH 'Request__Approver__Name'
						, APPROVER_EMAIL                    VARCHAR2(100)   PATH 'Request__Approver__Email'
						, APPROVAL_DATE_STR                 VARCHAR2(50)    PATH 'Request__Approval__Date'
						, CUSTOMER_NAME                     VARCHAR2(100)   PATH 'Request__Customer__Name'
						, CUSTOMER_DEPARTMENT_NAME          VARCHAR2(100)   PATH 'Request__Customer__Department__Name'
						, CUSTOMER_DEPARTMENT_CODE          VARCHAR2(2)     PATH 'Request__Customer__Department__Code'
						, CUSTOMER_AGENCY_NAME              VARCHAR2(100)   PATH 'Request__Customer__Agency__Name'
						, CUSTOMER_AGENCY_CODE              VARCHAR2(4)     PATH 'Request__Customer__Agency__Code'
						, CUSTOMER_ADDRESS_LINE_1           VARCHAR2(75)    PATH 'Request__Customer__Address__Line__1'
						, CUSTOMER_ADDRESS_LINE_2           VARCHAR2(75)    PATH 'Request__Customer__Address__Line__2'
						, CUSTOMER_ADDRESS_LINE_3           VARCHAR2(75)    PATH 'Request__Customer__Address__Line__3'
						, CUSTOMER_CITY                     VARCHAR2(50)    PATH 'Request__Customer__Address__City'
						, CUSTOMER_STATE                    VARCHAR2(50)    PATH 'Request__Customer__Address__State'
						, CUSTOMER_POSTAL_CODE              VARCHAR2(10)    PATH 'Request__Customer__Address__Postal__Code'
						, CUSTOMER_COUNTRY                  VARCHAR2(50)    PATH 'Request__Customer__Address__Country'
						, HIRING_ORGANIZATION               VARCHAR2(100)   PATH 'Request__Hiring__Organization'
						, STAFFING_ORGANIZATION             VARCHAR2(100)   PATH 'Request__Staffing__Organization'
						, PERSONNEL_ACTION_DATE_STR         VARCHAR2(50)    PATH 'Request__Personnel__Action__Date'
						, MAXIMUM_AGE                       NUMBER(3)       PATH 'Request__Maximum__Age'
						, MINIMUM_AGE                       NUMBER(3)       PATH 'Request__Minimum__Age'
						, RELOCATION                        VARCHAR2(3)     PATH 'Request__Relocation'
						, SECURITY_CLEARANCE                VARCHAR2(50)    PATH 'Request__Security__Clearance'
						, SUPERVISORY_POSITION              VARCHAR2(3)     PATH 'Request__Supervisory__Position'
						, TRAVEL_PREFERENCE                 VARCHAR2(20)    PATH 'Request__Travel__Preference'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.REQUEST_DESCRIPTION             = SRC.REQUEST_DESCRIPTION
			, TRG.REQUEST_STATUS                = SRC.REQUEST_STATUS
			, TRG.REQUEST_TYPE                  = SRC.REQUEST_TYPE
			, TRG.REQUEST_SOURCE                = SRC.REQUEST_SOURCE
			, TRG.LAST_UPDATE_DATE              = SRC.LAST_UPDATE_DATE
			, TRG.CREATION_DATE                 = SRC.CREATION_DATE
			, TRG.SUBMISSION_DATE               = SRC.SUBMISSION_DATE
			, TRG.REQUESTER_NAME                = SRC.REQUESTER_NAME
			, TRG.REQUESTER_EMAIL               = SRC.REQUESTER_EMAIL
			, TRG.APPROVER_NAME                 = SRC.APPROVER_NAME
			, TRG.APPROVER_EMAIL                = SRC.APPROVER_EMAIL
			, TRG.APPROVAL_DATE                 = SRC.APPROVAL_DATE
			, TRG.CUSTOMER_NAME                 = SRC.CUSTOMER_NAME
			, TRG.CUSTOMER_DEPARTMENT_NAME      = SRC.CUSTOMER_DEPARTMENT_NAME
			, TRG.CUSTOMER_DEPARTMENT_CODE      = SRC.CUSTOMER_DEPARTMENT_CODE
			, TRG.CUSTOMER_AGENCY_NAME          = SRC.CUSTOMER_AGENCY_NAME
			, TRG.CUSTOMER_AGENCY_CODE          = SRC.CUSTOMER_AGENCY_CODE
			, TRG.CUSTOMER_ADDRESS_LINE_1       = SRC.CUSTOMER_ADDRESS_LINE_1
			, TRG.CUSTOMER_ADDRESS_LINE_2       = SRC.CUSTOMER_ADDRESS_LINE_2
			, TRG.CUSTOMER_ADDRESS_LINE_3       = SRC.CUSTOMER_ADDRESS_LINE_3
			, TRG.CUSTOMER_CITY                 = SRC.CUSTOMER_CITY
			, TRG.CUSTOMER_STATE                = SRC.CUSTOMER_STATE
			, TRG.CUSTOMER_POSTAL_CODE          = SRC.CUSTOMER_POSTAL_CODE
			, TRG.CUSTOMER_COUNTRY              = SRC.CUSTOMER_COUNTRY
			, TRG.HIRING_ORGANIZATION           = SRC.HIRING_ORGANIZATION
			, TRG.STAFFING_ORGANIZATION         = SRC.STAFFING_ORGANIZATION
			, TRG.PERSONNEL_ACTION_DATE         = SRC.PERSONNEL_ACTION_DATE
			, TRG.MAXIMUM_AGE                   = SRC.MAXIMUM_AGE
			, TRG.MINIMUM_AGE                   = SRC.MINIMUM_AGE
			, TRG.RELOCATION                    = SRC.RELOCATION
			, TRG.SECURITY_CLEARANCE            = SRC.SECURITY_CLEARANCE
			, TRG.SUPERVISORY_POSITION          = SRC.SUPERVISORY_POSITION
			, TRG.TRAVEL_PREFERENCE             = SRC.TRAVEL_PREFERENCE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.REQUEST_NUMBER
			, TRG.REQUEST_DESCRIPTION
			, TRG.REQUEST_STATUS
			, TRG.REQUEST_TYPE
			, TRG.REQUEST_SOURCE
			, TRG.LAST_UPDATE_DATE
			, TRG.CREATION_DATE
			, TRG.SUBMISSION_DATE
			, TRG.REQUESTER_NAME
			, TRG.REQUESTER_EMAIL
			, TRG.APPROVER_NAME
			, TRG.APPROVER_EMAIL
			, TRG.APPROVAL_DATE
			, TRG.CUSTOMER_NAME
			, TRG.CUSTOMER_DEPARTMENT_NAME
			, TRG.CUSTOMER_DEPARTMENT_CODE
			, TRG.CUSTOMER_AGENCY_NAME
			, TRG.CUSTOMER_AGENCY_CODE
			, TRG.CUSTOMER_ADDRESS_LINE_1
			, TRG.CUSTOMER_ADDRESS_LINE_2
			, TRG.CUSTOMER_ADDRESS_LINE_3
			, TRG.CUSTOMER_CITY
			, TRG.CUSTOMER_STATE
			, TRG.CUSTOMER_POSTAL_CODE
			, TRG.CUSTOMER_COUNTRY
			, TRG.HIRING_ORGANIZATION
			, TRG.STAFFING_ORGANIZATION
			, TRG.PERSONNEL_ACTION_DATE
			, TRG.MAXIMUM_AGE
			, TRG.MINIMUM_AGE
			, TRG.RELOCATION
			, TRG.SECURITY_CLEARANCE
			, TRG.SUPERVISORY_POSITION
			, TRG.TRAVEL_PREFERENCE
		)
		VALUES
		(
			SRC.REQUEST_NUMBER
			, SRC.REQUEST_DESCRIPTION
			, SRC.REQUEST_STATUS
			, SRC.REQUEST_TYPE
			, SRC.REQUEST_SOURCE
			, SRC.LAST_UPDATE_DATE
			, SRC.CREATION_DATE
			, SRC.SUBMISSION_DATE
			, SRC.REQUESTER_NAME
			, SRC.REQUESTER_EMAIL
			, SRC.APPROVER_NAME
			, SRC.APPROVER_EMAIL
			, SRC.APPROVAL_DATE
			, SRC.CUSTOMER_NAME
			, SRC.CUSTOMER_DEPARTMENT_NAME
			, SRC.CUSTOMER_DEPARTMENT_CODE
			, SRC.CUSTOMER_AGENCY_NAME
			, SRC.CUSTOMER_AGENCY_CODE
			, SRC.CUSTOMER_ADDRESS_LINE_1
			, SRC.CUSTOMER_ADDRESS_LINE_2
			, SRC.CUSTOMER_ADDRESS_LINE_3
			, SRC.CUSTOMER_CITY
			, SRC.CUSTOMER_STATE
			, SRC.CUSTOMER_POSTAL_CODE
			, SRC.CUSTOMER_COUNTRY
			, SRC.HIRING_ORGANIZATION
			, SRC.STAFFING_ORGANIZATION
			, SRC.PERSONNEL_ACTION_DATE
			, SRC.MAXIMUM_AGE
			, SRC.MINIMUM_AGE
			, SRC.RELOCATION
			, SRC.SECURITY_CLEARANCE
			, SRC.SUPERVISORY_POSITION
			, SRC.TRAVEL_PREFERENCE
		)
		;


		--------------------------------
		-- DSS_REQUEST_APPT_TYPE table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_APPT_TYPE table');
		MERGE INTO DSS_REQUEST_APPT_TYPE TRG
		USING
		(
			SELECT
				X.REQUEST_NUMBER
				, X.APPOINTMENT_TYPE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestAppointmentType"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						REQUEST_NUMBER                      VARCHAR2(50)    PATH 'Request__Number'
						, APPOINTMENT_TYPE                  VARCHAR2(35)    PATH 'Request__Appointment__Type'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER)
		WHEN MATCHED THEN UPDATE SET
			TRG.APPOINTMENT_TYPE                = SRC.APPOINTMENT_TYPE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.REQUEST_NUMBER
			, TRG.APPOINTMENT_TYPE
		)
		VALUES
		(
			SRC.REQUEST_NUMBER
			, SRC.APPOINTMENT_TYPE
		)
		;


		--------------------------------
		-- DSS_REQUEST_LOCATION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_LOCATION table');
		MERGE INTO DSS_REQUEST_LOCATION TRG
		USING
		(
			SELECT
				X.REQUEST_NUMBER
				, X.LOCATION_DESCRIPTION
				, LOCATION_OPENINGS
				, CITY
				, STATE
				, COUNTY
				, COUNTRY
				, LOCATION_CODE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestLocation"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						REQUEST_NUMBER                      VARCHAR2(50)    PATH 'Request__Number'
						, LOCATION_DESCRIPTION              VARCHAR2(50)    PATH 'Request__Location__Description'
						, LOCATION_OPENINGS                 VARCHAR2(4)     PATH 'Request__Location__Openings'
						, CITY                              VARCHAR2(50)    PATH 'Request__Location__City'
						, STATE                             VARCHAR2(50)    PATH 'Request__Location__State'
						, COUNTY                            VARCHAR2(50)    PATH 'Request__Location__County'
						, COUNTRY                           VARCHAR2(50)    PATH 'Request__Location__Country'
						, LOCATION_CODE                     VARCHAR2(10)    PATH 'Request__Location__Code'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER AND SRC.LOCATION_CODE = TRG.LOCATION_CODE )

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.LOCATION_DESCRIPTION            = SRC.LOCATION_DESCRIPTION
			, TRG.LOCATION_OPENINGS             = SRC.LOCATION_OPENINGS
			, TRG.CITY                          = SRC.CITY
			, TRG.STATE                         = SRC.STATE
			, TRG.COUNTY                        = SRC.COUNTY
			, TRG.COUNTRY                       = SRC.COUNTRY
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.REQUEST_NUMBER
			, TRG.LOCATION_CODE
			, TRG.LOCATION_DESCRIPTION
			, TRG.LOCATION_OPENINGS
			, TRG.CITY
			, TRG.STATE
			, TRG.COUNTY
			, TRG.COUNTRY
		)
		VALUES
		(
			SRC.REQUEST_NUMBER
			, SRC.LOCATION_CODE
			, SRC.LOCATION_DESCRIPTION
			, SRC.LOCATION_OPENINGS
			, SRC.CITY
			, SRC.STATE
			, SRC.COUNTY
			, SRC.COUNTRY
		)
		;


		--------------------------------
		-- DSS_REQUEST_POSITION table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_POSITION table');
		MERGE INTO DSS_REQUEST_POSITION TRG
		USING
		(
			SELECT
				X.REQUEST_NUMBER
				, X.PD_NUMBER
				, X.PD_TITLE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestPosition"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						REQUEST_NUMBER                      VARCHAR2(50)    PATH 'Request__Number'
						, PD_NUMBER                         VARCHAR2(50)    PATH 'Request__Position__Description__Number'
						, PD_TITLE                          VARCHAR2(100)   PATH 'Request__Position__Description__Title'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER AND SRC.PD_NUMBER = TRG.PD_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.PD_TITLE                        = SRC.PD_TITLE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.REQUEST_NUMBER
			, TRG.PD_NUMBER
			, TRG.PD_TITLE
		)
		VALUES
		(
			SRC.REQUEST_NUMBER
			, SRC.PD_NUMBER
			, SRC.PD_TITLE
		)
		;


		--------------------------------
		-- DSS_REQUEST_SPECIALTY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_SPECIALTY table');
		MERGE INTO DSS_REQUEST_SPECIALTY TRG
		USING
		(
			SELECT
				X.REQUEST_NUMBER
				, X.SPECIALTY
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestSpecialty"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						REQUEST_NUMBER                      VARCHAR2(50)    PATH 'Request__Number'
						, SPECIALTY                         VARCHAR2(50)    PATH 'Request__Specialty'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.SPECIALTY                       = SRC.SPECIALTY
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.REQUEST_NUMBER
			, TRG.SPECIALTY
		)
		VALUES
		(
			SRC.REQUEST_NUMBER
			, SRC.SPECIALTY
		)
		;


		--------------------------------
		-- DSS_REQUEST_VACANCY table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_VACANCY table');
		MERGE INTO DSS_REQUEST_VACANCY TRG
		USING
		(
			SELECT
				X.REQUEST_NUMBER
				, X.VACANCY_NUMBER
				, X.VACANCY_STATUS
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestVacancy"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						REQUEST_NUMBER                      VARCHAR2(50)    PATH 'Request__Number'
						, VACANCY_NUMBER                    NUMBER(10)      PATH 'Vacancy__Number'
						, VACANCY_STATUS                    VARCHAR2(10)    PATH 'Vacancy__Status'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.VACANCY_NUMBER                  = SRC.VACANCY_NUMBER
			, TRG.VACANCY_STATUS                = SRC.VACANCY_STATUS
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.REQUEST_NUMBER
			, TRG.VACANCY_NUMBER
			, TRG.VACANCY_STATUS
		)
		VALUES
		(
			SRC.REQUEST_NUMBER
			, SRC.VACANCY_NUMBER
			, SRC.VACANCY_STATUS
		)
		;


		--------------------------------
		-- DSS_REQUEST_WORK_SCHED table
		--------------------------------
		--DBMS_OUTPUT.PUT_LINE('    DSS_REQUEST_WORK_SCHED table');
		MERGE INTO DSS_REQUEST_WORK_SCHED TRG
		USING
		(
			SELECT
				X.REQUEST_NUMBER
				, X.WORK_SCHEDULE
			FROM INTG_DATA_DTL IDX
				, XMLTABLE(XMLNAMESPACES(DEFAULT 'http://www.ibm.com/xmlns/prod/cognos/dataSet/201006'), '/dataSet/dataTable/row[../id/text() = "lst_RequestWorkSchedule"]'
					PASSING IDX.FIELD_DATA
					COLUMNS
						REQUEST_NUMBER                      VARCHAR2(50)    PATH 'Request__Number'
						, WORK_SCHEDULE                     VARCHAR2(18)    PATH 'Request__Work__Schedule'
				) X
			WHERE IDX.ID = I_ID
		) SRC ON (SRC.REQUEST_NUMBER = TRG.REQUEST_NUMBER)

--TODO: finalize the match condition

		WHEN MATCHED THEN UPDATE SET
			TRG.WORK_SCHEDULE                   = SRC.WORK_SCHEDULE
		WHEN NOT MATCHED THEN INSERT
		(
			TRG.REQUEST_NUMBER
			, TRG.WORK_SCHEDULE
		)
		VALUES
		(
			SRC.REQUEST_NUMBER
			, SRC.WORK_SCHEDULE
		)
		;


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
	ELSIF V_INTG_TYPE = 'VACANCY' THEN
		SP_UPDATE_VACANCY_TABLE(V_ID);
	END IF;
	

	COMMIT;

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
		--DBMS_OUTPUT.PUT_LINE('Error occurred while executing SP_UPDATE_INTG_DATA -------------------');
END;

/