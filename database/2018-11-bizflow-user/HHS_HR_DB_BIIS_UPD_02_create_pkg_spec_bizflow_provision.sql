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
--PROCEDURE: ENABLE_RDR_VISITOR
--DESCRIPTION: Enable RDR Visitor for all members
--------------------------------------------------------
PROCEDURE ENABLE_RDR_VISITOR;

--------------------------------------------------------
--FUNCTION: FN_ACTIVATE_USERS
--DESCRIPTION: Enable user access for all members
--------------------------------------------------------
FUNCTION FN_ACTIVATE_USERS
	(O_ERRMSG       OUT VARCHAR2)
RETURN NUMBER;

END BIZFLOW_PROVISION_PKG;
/