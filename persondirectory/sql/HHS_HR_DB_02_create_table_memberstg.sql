--------------------------------------------------------
-- DDL for Table MEMBERSTG
--------------------------------------------------------
	CREATE TABLE MEMBERSTG
	(HHSID		VARCHAR2(10),
    NAME			VARCHAR2(100),
    EMAIL		VARCHAR2(300),
    DEPTNAME	VARCHAR2(6),
    ACTIVEIND 	VARCHAR2(1)
	);
	  
   COMMENT ON TABLE MEMBERSTG IS 'Member Staging table';
	
	COMMENT ON COLUMN MEMBERSTG.HHSID IS 'HHSID of the employee';
			
	COMMENT ON COLUMN MEMBERSTG.NAME IS 'The name of the employee';
		
	COMMENT ON COLUMN MEMBERSTG.EMAIL IS 'The email address of the employee';
	
	COMMENT ON COLUMN MEMBERSTG.DEPTNAME IS 'The department name of the employee';
	
	COMMENT ON COLUMN MEMBERSTG.ACTIVEIND IS 'Indicates if the employee is active. ''Y'' is active, ''N'' is inactive';
	
	
--=============================================================================================================================================

--------------------------------------------------------
--BACKOUT SCRIPT
--------------------------------------------------------  
/*   
	DROP TABLE MEMBERSTG;

*/	