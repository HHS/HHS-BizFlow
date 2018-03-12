

----------------------------------------------------
-- DBA statment to inspect deadlock and resolve
----------------------------------------------------
--SELECT s.sid, s.serial#, s.status, p.spid
--FROM v$session s, v$process p
--WHERE s.username = 'CMS'
--	AND p.addr(+) = s.paddr
--;
--ALTER SYSTEM KILL SESSION '22, 7157';


-------------------------------------------------------------------------------
-- DBA statement to change default profile to lift password expiration
-------------------------------------------------------------------------------
--SELECT * FROM DBA_USERS;
--SELECT * FROM DBA_PROFILES WHERE PROFILE='DEFAULT';
--ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;


----------------------------------------------------
-- DBA statement to reset password 
----------------------------------------------------

--ALTER USER HHSADMIN IDENTIFIED BY <replace_with_password>;
--ALTER USER HHS_HR IDENTIFIED BY <replace_with_password>;
--ALTER USER HHSDEV IDENTIFIED BY <replace_with_password>;


----------------------------------------------------
-- backout statement
----------------------------------------------------

--DROP USER HHSADMIN CASCADE;
--DROP TABLESPACE HHS_HR_TS;
--DROP USER HHS_HR CASCADE;
--DROP USER HHSDEV CASCADE;
--DROP ROLE HHS_HR_RW_ROLE;
--DROP ROLE HHS_HR_DEV_ROLE;
-- BF_DEV_ROLE might be created by some other script
----DROP ROLE BF_DEV_ROLE;



--=============================================================================
-- Create HHSADMIN user for DBA for HHS project
-------------------------------------------------------------------------------

CREATE USER HHSADMIN IDENTIFIED BY <replace_with_password>;
GRANT CONNECT, RESOURCE, DBA TO HHSADMIN;



--=============================================================================
-- Create TABLESPACE, USER for HHS project
-------------------------------------------------------------------------------

-- Make sure the directory to store the datafile actually exists on the server where DBMS is installed.
CREATE TABLESPACE HHS_HR_TS DATAFILE 'C:\bizflowdb\HHS_HR.DBF' SIZE 30M AUTOEXTEND ON NEXT 3M MAXSIZE UNLIMITED
;





CREATE USER HHS_HR IDENTIFIED BY <replace_with_password>
	DEFAULT TABLESPACE HHS_HR_TS
--	TEMPORARY TABLESPACE HHSTST
	QUOTA UNLIMITED ON HHS_HR_TS
;

-- developer user
CREATE USER HHSDEV IDENTIFIED BY <replace_with_password>
	DEFAULT TABLESPACE HHS_HR_TS
	QUOTA UNLIMITED ON HHS_HR_TS
;


-- create role and grant privilege
CREATE ROLE HHS_HR_RW_ROLE;
CREATE ROLE HHS_HR_DEV_ROLE;
--CREATE ROLE BF_DEV_ROLE;  -- already created as part of CMS project

-- grant HHS role to HHS user
GRANT CONNECT, RESOURCE, HHS_HR_RW_ROLE TO HHS_HR;
GRANT CONNECT, RESOURCE, HHS_HR_DEV_ROLE TO HHSDEV;

-- grant HHS database privileges to HHS role
GRANT ALTER SESSION, CREATE CLUSTER, CREATE DATABASE LINK
		, CREATE SEQUENCE, CREATE SESSION, CREATE SYNONYM, CREATE TABLE
		, CREATE VIEW, CREATE PROCEDURE
	TO HHS_HR_RW_ROLE
;

-- grant HHS database privileges to HHS DEV role
GRANT ALTER SESSION, CREATE CLUSTER, CREATE DATABASE LINK
		, CREATE SEQUENCE, CREATE SESSION, CREATE SYNONYM, CREATE TABLE
		, CREATE VIEW, CREATE PROCEDURE
	TO HHS_HR_DEV_ROLE
;


-- Grant workflow table access to role.
-- It may have already been granted as part of CMS project.
--BEGIN
--	FOR ATAB IN (SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER = 'BIZFLOW') LOOP
--		EXECUTE IMMEDIATE 'GRANT ALL ON BIZFLOW.'||ATAB.TABLE_NAME||' TO BF_DEV_ROLE';
--	END LOOP;
--END;





---------------------------------
-- CROSS schema access
---------------------------------

-- grant the HHS database access role to bizflow database user

GRANT HHS_HR_RW_ROLE TO BIZFLOW;


-- grant WORKFLOW database access role to HHS_HR database user

GRANT BF_DEV_ROLE TO HHS_HR;


-- grant WORKFLOW database access role to HHSDEV database user

GRANT BF_DEV_ROLE TO HHSDEV;



-- create link to BIIS database
CREATE DATABASE LINK BIIS_DBLINK
CONNECT TO EWITSUSR IDENTIFIED BY <replace_with_password>
USING 
	'(DESCRIPTION =
		(ADDRESS = (PROTOCOL = TCP)(HOST = <replace_with_db_host>)(PORT = <replace_with_db_port>))
		(CONNECT_DATA = (SERVICE_NAME = <replace_with_service_name>))
	)';
