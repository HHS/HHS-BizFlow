
SET DEFINE OFF;


--STORED PROCEDURE: SP_TRUNC_APPLICATION_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_APPLICATION_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS Application Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_APPLICATION_DETAIL';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_APPLICATION_DOCUMENT';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_APPLICATION_ELIGIBILITY';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_APPLICATION_LOCATION';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_APPLICATION_RATING';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_APPLICANT_PHONE';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/
--STORED PROCEDURE: SP_TRUNC_ANNOUNCEMENT_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_ANNOUNCEMENT_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS Announcement Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_ANNOUNCEMENT_DETAIL';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_ANNOUNCEMENT_APPT_TYPE';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_ANNOUNCEMENT_LOCATION';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_ANNOUNCEMENT_WORK_SCHED';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/
--STORED PROCEDURE: SP_TRUNC_CERTIFICATE_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_CERTIFICATE_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS Certificate Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CERTIFICATE';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CERTIFICATE_APP';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/
--STORED PROCEDURE: SP_TRUNC_NEWHIRE_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_NEWHIRE_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS New Hire Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_NEW_HIRE';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/
--STORED PROCEDURE: SP_TRUNC_REQUEST_TABLE
create or replace PROCEDURE SP_TRUNC_REQUEST_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS Request Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REQUEST_DETAIL';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REQUEST_APPT_TYPE';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REQUEST_WORK_SCHED';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REQUEST_LOCATION';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REQUEST_POSITION';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REQUEST_SPECIALTY';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REQUEST_VACANCY';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/
--STORED PROCEDURE: SP_TRUNC_REVIEW_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_REVIEW_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS Review Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_REVIEW_DETAIL';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/
--STORED PROCEDURE: SP_TRUNC_TASK_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_TASK_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS Task Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_TASK_DETAIL';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/
--STORED PROCEDURE: SP_TRUNC_VACANCY_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_VACANCY_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS Vacancy Report Tables
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_VACANCY_DETAIL';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_VACANCY_CUSTOMER';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_VACANCY_DOCUMENT';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_VACANCY_ELIGIBILITY';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_VACANCY_POSITION';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_VACANCY_SPECIALTY';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_VACANCY_REQUEST';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_TIME2OFFER_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_TIME2OFFER_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the Time to Offer Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_TIME_TO_OFFER_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_TIME2STAFF_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_TIME2STAFF_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the Time to Staff Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_TIME_TO_STAFF_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_IHS_VAC_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_IHS_VAC_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the custom IHS - Fill a Vacancy Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_IHS_VAC_ANNOUNCEMENT_STG';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_IHS_VAC_CERTIFICATE_STG';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_IHS_VAC_NEW_HIRE_STG';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_IHS_VAC_ANN_REVIEW_STG';
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_IHS_VAC_ANN_LOCATION_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/


--STORED PROCEDURE: SP_TRUNC_CDC_TIME2OFFER_TABLE
CREATE OR REPLACE PROCEDURE HHS_HR.SP_TRUNC_CDC_TIME2OFFER_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the CDC Time to Offer Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE HHS_HR.DSS_CDC_TIME_TO_OFFER_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_CDC_TIME2STAFF_TABLE
CREATE OR REPLACE PROCEDURE HHS_HR.SP_TRUNC_CDC_TIME2STAFF_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the CDC Time to Staff Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE HHS_HR.DSS_CDC_TIME_TO_STAFF_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_CDC_CERT_TABLE
CREATE OR REPLACE PROCEDURE HHS_HR.SP_TRUNC_CDC_CERT_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the CDC Certificate Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE HHS_HR.DSS_CDC_CERTIFICATE_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_CDC_AUDIT_TABLE
CREATE OR REPLACE PROCEDURE HHS_HR.SP_TRUNC_CDC_AUDIT_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the CDC Cert Audit Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE HHS_HR.DSS_CDC_CERT_AUDIT_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_CDC_ANN_TABLE
CREATE OR REPLACE PROCEDURE HHS_HR.SP_TRUNC_CDC_ANN_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the CDC Announcement Report Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE HHS_HR.DSS_CDC_ANNOUNCEMENT_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_CMS_POSSESS_TABLE
create or replace PROCEDURE  HHS_HR.SP_TRUNC_CMS_POSSESS_TABLE
AS
LAST_RUN    NUMBER;
BEGIN
--DESCRIPTION: Truncates the CMS Time of Possession Table
	SELECT COUNT(*) INTO  LAST_RUN FROM batch_step_execution WHERE TO_CHAR(START_TIME,'DD-MM-YY') = TO_CHAR(SYSDATE,'DD-MM-YY')
    AND step_name IN('executeCMSPossessReportStep','executeCMSPossessApptmntReportStep');
    
    IF LAST_RUN = 0 THEN --FOR RE-USING SAME PROCEDURES BETWEEN TOP RECRUITMENT AND APPOINTMENT
        EXECUTE IMMEDIATE 'TRUNCATE TABLE HHS_HR.DSS_CMS_TIME_OF_POSSESS_STG';
    END IF;
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/


--STORED PROCEDURE: SP_TRUNC_CMS_TIME2HIRE_TABLE
CREATE OR REPLACE PROCEDURE HHS_HR.SP_TRUNC_CMS_TIME2HIRE_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the CMS Time to Hire Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE HHS_HR.DSS_CMS_TIME_TO_HIRE_STG';
EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/

--STORED PROCEDURE: SP_TRUNC_CMS_REQUEST_TABLE
CREATE OR REPLACE PROCEDURE SP_TRUNC_CMS_REQUEST_TABLE
AS
BEGIN
--DESCRIPTION: Truncates the DSS CMS Requests Table
	EXECUTE IMMEDIATE 'TRUNCATE TABLE DSS_CMS_REQUESTS_STG';

EXCEPTION
	WHEN OTHERS THEN
		SP_ERROR_LOG();
END;
/