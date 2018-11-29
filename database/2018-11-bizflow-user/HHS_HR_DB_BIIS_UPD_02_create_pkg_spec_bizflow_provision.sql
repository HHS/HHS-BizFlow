CREATE OR REPLACE PACKAGE HHS_HR.BIZFLOW_PROVISION_PKG AS

--------------------------------------------------------
--PROCEDURE: ASSIGN_LICENSE
--DESCRIPTION: assign user license
--------------------------------------------------------
PROCEDURE ASSIGN_LICENSE;

--------------------------------------------------------
--PROCEDURE: ASSIGN_AUTH_GRP
--DESCRIPTION: assign user authority group
--------------------------------------------------------
PROCEDURE ASSIGN_AUTH_GRP;

--------------------------------------------------------
--FUNCTION: FN_ACTIVATE_USERS
--DESCRIPTION: Enable user access for all members
--------------------------------------------------------
FUNCTION FN_ACTIVATE_USERS
	(O_ERRMSG       OUT VARCHAR2)
RETURN NUMBER;

END BIZFLOW_PROVISION_PKG;
/