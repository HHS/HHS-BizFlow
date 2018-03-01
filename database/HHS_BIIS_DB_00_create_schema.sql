

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
--ALTER USER EWITSUSR IDENTIFIED BY <replace_with_password>;
--ALTER USER HISTDBA IDENTIFIED BY <replace_with_password>;


----------------------------------------------------
-- backout statement
----------------------------------------------------

--DROP USER HHSADMIN CASCADE;
--DROP TABLESPACE HHS_BIIS_TS;
--DROP USER EWITSUSR CASCADE;
--DROP USER HISTDBA CASCADE;
--DROP ROLE HHS_BIIS_VIEW_ROLE;
--DROP ROLE HHS_BIIS_OWNER_ROLE;



--=============================================================================
-- Create HHSADMIN user for DBA for HHS project
-------------------------------------------------------------------------------

--CREATE USER HHSADMIN IDENTIFIED BY <replace_with_password>;
--GRANT CONNECT, RESOURCE, DBA TO HHSADMIN;



--=============================================================================
-- Create TABLESPACE, USER for HHS project
-------------------------------------------------------------------------------

-- Make sure the directory to store the datafile actually exists on the server where DBMS is installed.
CREATE TABLESPACE HHS_BIIS_TS DATAFILE 'C:\bizflowdb\HHS_BIIS.DBF' SIZE 30M AUTOEXTEND ON NEXT 3M MAXSIZE UNLIMITED
;




-- user schema
CREATE USER EWITSUSR IDENTIFIED BY <replace_with_password>
	DEFAULT TABLESPACE HHS_BIIS_TS
--	TEMPORARY TABLESPACE HHSTST
	QUOTA UNLIMITED ON HHS_BIIS_TS
;

-- view schema
CREATE USER HISTDBA IDENTIFIED BY <replace_with_password>
	DEFAULT TABLESPACE HHS_BIIS_TS
	QUOTA UNLIMITED ON HHS_BIIS_TS
;


-- create role and grant privilege
CREATE ROLE HHS_BIIS_VIEW_ROLE;
CREATE ROLE HHS_BIIS_OWNER_ROLE;

-- grant view role to user
GRANT CONNECT, RESOURCE, HHS_BIIS_VIEW_ROLE TO EWITSUSR;
GRANT CONNECT, RESOURCE, HHS_BIIS_OWNER_ROLE TO HISTDBA;

-- grant view database privileges to user role
GRANT ALTER SESSION
		, CREATE SEQUENCE, CREATE SESSION, CREATE SYNONYM, CREATE TABLE
		, CREATE VIEW, CREATE PROCEDURE
	TO HHS_BIIS_VIEW_ROLE
;

-- grant owner database privileges to owner role
GRANT ALTER SESSION, CREATE CLUSTER, CREATE DATABASE LINK
		, CREATE SEQUENCE, CREATE SESSION, CREATE SYNONYM, CREATE TABLE
		, CREATE VIEW, CREATE PROCEDURE
	TO HHS_BIIS_OWNER_ROLE
;



