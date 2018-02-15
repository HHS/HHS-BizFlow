------------------------------------------------------------------
CONTENTS
------------------------------------------------------------------
•src - Contains the java code
   *src -> main -> java:  Contains the source code 
   *src -> main -> resources : Contains the application.properties file
•sql - Contains the SQL scripts
   *HHS_HR_DB_01_bizflow_grants.sql: Contains a grants script to give the HHS_HR schema access to the BizFlow objects: MEMBER, MEMBERINFO, SP_GET_ID
   *HHS_HR_DB_02_create_table_memberstg.sql: The ddl for the MEMBERSTG table, which is the staging table for the member table.
   *HHS_HR_DB_03_create_table_memberhistory.sql: The ddl for the MEMBERHISTORY table, which logs the transaction history of the BizFlow MEMBER table each time a record is inserted or updated.
   *HHS_HR_DB_04_1_create_package_spec_MEMBER_STG_TO_FNL.pks.sql: The package spec of MEMBER_STG_TO_FNL. This will need to be compiled before the package body.
   *HHS_HR_DB_04_2_create_package_body_MEMBER_STG_TO_FNL.pkb.sql: The package body of MEMBER_STG_TO_FNL. This package is called on while the batch job MEMBER_STG_TO_FNL runs.
•lib - Contains the source jar files
•build - Contains the ANT build script and stores the compiled classes
•dist - Stores the source jars and the compiled PSC Locator jar
•logs- Stores the log files
      
------------------------------------------------------------------
INSTRUCTIONS FOR COMPILING IN THE DATABASE
------------------------------------------------------------------
Compile the SQL files first
1.The HHS_HR_DB_01_bizflow_grants.sql script needs to be run in the BIZFLOW schema.
3.Run the following scripts in the HHS_HR schema.
	•First, compile the following tables:
		*HHS_HR_DB_02_create_table_memberstg.sql
		*HHS_HR_DB_03_create_table_memberhistory.sql
	•Finally, compile the packages in the following order, once the tables have been compiled
		*HHS_HR_DB_04_1_create_package_spec_MEMBER_STG_TO_FNL.pks.sql
		*HHS_HR_DB_04_2_create_package_body_MEMBER_STG_TO_FNL.pkb.sql
           
------------------------------------------------------------------
UPDATING THE application.properties FILE (Located in the src-> main->resources folder)
------------------------------------------------------------------	
The application.properties file needs to be updated for DEV, QA, and PROD in order to have the correct login parameters. The following parameters will need to be modified in the file:

•source.datasource.url=Update with the correct JDBC URL for either the TEST or PROD environment for the PSC Locator database
•source.datasource.username= = Update with the correct corresponding username for either the TEST or PROD environment for the PSC Locator database
•source.datasource.password=Update with the correct corresponding password for either the TEST or PROD environment for the PSC Locator database

•target.datasource.url=Update with the correct JDBC URL for either the DEV, QA, or PROD environment for the HHS_HR database
•target.datasource.username=HHS_HR, Confirm the HHS_HR schema name for the DEV, QA, and PROD environments
•target.datasource.password=Update with the password DEV, QA, or PROD password for the HHS_HR database

•spring.mail.host=Update with the correct smtp host for the sending mail system
•spring.mail.username=Update with the sending mail system's username
•spring.mail.password=Update with the sending mail system's password
•spring.mail.port=Update with the correct mail port
•spring.mail.protocol=Update with the correct protocol

•emailid.from=Update with the email address of the system that is sending out the email alerts
•emailid.to=Update with a list of all the email recipients who will recieve the email alerts. Seperate email addresses with a comma (,)

•chunk.size=Update with the preferred chunk size for reading/writing records to the staging table. Do not change the default chunk size unless there are problems with database performance

•plsql.schema=Update with the schema that the package MEMBER_STG_TO_FNL is compiled in. Should be the HHS_HR schema.


------------------------------------------------------------------
Building the Source code
------------------------------------------------------------------
1. Edit the file path in the build.sh shell script so that it points to the build folder that contains the build.xml file, ex: '/locator/build'
2. Run the following command to build the code

./build.sh


------------------------------------------------------------------
SETTING UP THE CRON JOB
------------------------------------------------------------------
1. Edit the CLASS_PATH variable in the run.sh shell script so that it points to the path of the locator folder, ex: '/home/user/Desktop/locator'
2. The job will run at 9PM every night. 
	Create a new crontab with the following command:  

0 21 * * * ./run.sh

