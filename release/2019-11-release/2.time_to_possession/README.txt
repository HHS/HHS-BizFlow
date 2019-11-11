--------------------
- Server
--------------------
1. Log into EWITS 2.0 Linux server
2. Replace /hrts/prod/usas/usasdss-0.0.1-SNAPSHOT.jar with new version in this folder.
3. Open report.properties file by using any text editir like vi
4. Find cms.possess.run.report in the report.properties file
5. Add new line, copy and paste configuration section below.
6. Save the file. No need to restart any service

#CMS Time of Possession Appointment Report
cms.possessApptmnt.search.path=/content/folder[@name='USA Staffing Packages and Folders']/folder[@name='HHS']/folder[@name='Organization Shared']/folder[@name='Centers for Medicare and Medicaid Services']/folder[@name='Custom DSS']/report[@name='Time of Possession Appointment']
cms.possessApptmnt.intg.type=CMS-POSSESSION-APPOINTMENT
cms.possessApptmnt.file.name=CmsTimeOfPossessionAppointment
cms.possessApptmnt.report.name=CMS-Time of Possession Appointment
cms.possessApptmnt.parm.num=1
cms.possessApptmnt.rvp.name=parm_StaffingDateRange
cms.possessApptmnt.rpt.iteration=1
cms.possessApptmnt.date.interval=25
cms.possessApptmnt.end.date=10/01/2016
cms.possessApptmnt.truncate=SP_TRUNC_CMS_POSSESS_TABLE
cms.possessApptmnt.stgToFnl=SP_CMS_POSSESS_STG2FNL
cms.possessApptmnt.run.report=true


--------------------
- Database
--------------------
1. Log into EWITS 2.0 Database with HHS_HR account
2. Run SP_CMS_POSSESS_STG2FNL.sql to HHS_HR schema
3. Run SP_TRUNC_CMS_POSSESS_TABLE.sql to HHS_HR schema
4. Run SP_UPDATE_CMS_POSSESS_TABLE.sql to HHS_HR schema
5. Run SP_UPDATE_INTG_DATA.sql