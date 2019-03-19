-----------------------------------------
--DDL for table DSS_CMS_TIME_TO_HIRE
-----------------------------------------
ALTER TABLE
   HHS_HR.DSS_CMS_TIME_TO_HIRE
ADD
   (
    CERTIFICATE_ISSUE_DATE      DATE,
    SEND_TENT_OFFR_CMPL_DATE    DATE,
    TENT_OFFR_RSPNS_DATE        DATE,
    INIT_BKGRND_INVST_DATE      DATE,
    RCVE_BKGRND_INVST_DATE      DATE,
    SEND_OFCL_OFFR_CMPL_DATE    DATE,
    ARRVL_VERIF_CMPL_DATE       DATE
   );
   
   
-----------------------------------------
--DDL for table DSS_CMS_TIME_TO_HIRE_STG
-----------------------------------------
ALTER TABLE
   HHS_HR.DSS_CMS_TIME_TO_HIRE_STG
ADD
   (
    CERTIFICATE_ISSUE_DATE      DATE,
    SEND_TENT_OFFR_CMPL_DATE    DATE,
    TENT_OFFR_RSPNS_DATE        DATE,    
    INIT_BKGRND_INVST_DATE      DATE,
    RCVE_BKGRND_INVST_DATE      DATE,
    SEND_OFCL_OFFR_CMPL_DATE    DATE,
    ARRVL_VERIF_CMPL_DATE       DATE
   );   