
----------------------------------
-- grant for HHS_HR_RW_ROLE
----------------------------------

GRANT EXECUTE ON HHS_HR.SP_ERROR_LOG TO HHS_HR_RW_ROLE;
GRANT EXECUTE ON HHS_HR.SP_INTERFACE_ERROR_LOGGER TO HHS_HR_RW_ROLE;
GRANT EXECUTE ON HHS_HR.SP_SEND_MAIL TO HHS_HR_RW_ROLE;


----------------------------------
-- grant for HHS_HR_DEV_ROLE
----------------------------------

GRANT EXECUTE ON HHS_HR.SP_ERROR_LOG TO HHS_HR_DEV_ROLE;
GRANT EXECUTE ON HHS_HR.SP_INTERFACE_ERROR_LOGGER TO HHS_HR_DEV_ROLE;
GRANT EXECUTE ON HHS_HR.SP_SEND_MAIL TO HHS_HR_DEV_ROLE;

----------------------------------
-- grant for HHS_CMS_HR_RW_ROLE
----------------------------------

GRANT EXECUTE ON HHS_HR.SP_SEND_MAIL TO HHS_CMS_HR_RW_ROLE;

----------------------------------
-- grant for HHS_CMS_HR_DEV_ROLE
----------------------------------

GRANT EXECUTE ON HHS_HR.SP_SEND_MAIL  TO HHS_CMS_HR_DEV_ROLE;

----------------------------------
-- grant for HHS_CMS_HR
----------------------------------

GRANT EXECUTE ON HHS_HR.SP_SEND_MAIL  TO HHS_CMS_HR;
