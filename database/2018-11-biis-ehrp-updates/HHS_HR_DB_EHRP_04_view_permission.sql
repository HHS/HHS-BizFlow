
----------------------------------
-- grant for HHS_HR_RW_ROLE
----------------------------------

GRANT SELECT ON HHS_HR.VW_EHRP_15_MIN TO HHS_HR_RW_ROLE;

----------------------------------
-- grant for HHS_HR_DEV_ROLE
----------------------------------

GRANT SELECT ON HHS_HR.VW_EHRP_15_MIN TO HHS_HR_DEV_ROLE;

----------------------------------
-- grant for BIZFLOW
----------------------------------
GRANT SELECT ON HHS_HR.VW_EHRP_15_MIN TO BIZFLOW;

----------------------------------
-- grants for CDC
----------------------------------
GRANT SELECT ON HHS_HR.VW_EHRP_15_MIN TO HHS_CDC_HR;
GRANT SELECT ON HHS_HR.VW_EHRP_15_MIN TO HHS_CDC_HR_RW_ROLE;
GRANT SELECT ON HHS_HR.VW_EHRP_15_MIN TO HHS_CDC_HR_DEV_ROLE;
