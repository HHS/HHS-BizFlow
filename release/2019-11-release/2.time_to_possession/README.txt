--------------------
- Server
--------------------
1. Log into EWITS 2.0 Linux server
2. Replace /hrts/prod/usas/usasdss-0.0.1-SNAPSHOT.jar with new version in this folder.
3. No need to restart any service

--------------------
- Database
--------------------
1. Log into EWITS 2.0 Database with HHS_HR account
2. Run SP_CMS_POSSESS_STG2FNL.sql to HHS_HR schema
3. Run SP_TRUNC_CMS_POSSESS_TABLE.sql to HHS_HR schema
4. Run SP_UPDATE_CMS_POSSESS_TABLE.sql to HHS_HR schema
5. Run SP_UPDATE_INTG_DATA.sql
