CREATE OR REPLACE PACKAGE BFPS_PDAF AS 

    ------------------------------------------------------------------------------------------
    --	Name				:	BFPS_PDAF-package.sql
    --  Script/package name	: 	BFPS-DATAMASK
    --	Author				:	Taeho Lee <thee@bizflow.com>
    --	Copyright			:	BizFlow Corp.	
    --	
    --	Project				:	BizFlow Oracle PII DISCLOSURE AVOIDANCE FRAMEWORK library
    --	Purpose				:	Tasking Processing package of BizFlow Oracle PII Disclosure Avoidance.
    --
    --                          Task descriptions are configured and registered in PDAF_PII_FIELD_META and
    --                          PDAF_PII_FIELD_XML_MEATA tables. LOG is generated in PDAF_PII_LOG
    --
    --  Notes               :   The user who runs this packages must have write permission to target tables.
    --  
    --  Usage               : 
    --                          conf_version = version number of the configuration. if you want to have version control
    --                          conf_groupId = group id if you separte the tasks by group. like per each agencies or department.	
    --                          conf_debugMode = [ 'Y' | 'N' ] 
    --                                      If 'Y', not database fields update. only generating a log having SQL queries to be executed.
    --                                      If 'N', perform database update.
    --                          conf_mainSchema = database schema name where BFPS_PDAF AND BFPS_DATAMASK packages exists.
    --       
    -- 	WHEN		WHO			WHAT		
    -- 	-----------	--------	-------------------------------------------------------
    -- 	03/07/2018	THLEE		Created
    --  03/14/2018  THLEE       Non-XML type logic
    --  03/19/2018  THLEE       XMLTYPE logic
    --  03/20/2018  THLEE       Bug fix - wrong delimiter use in Regular Expression.
    ------------------------------------------------------------------------------------------
    
    -- get function string for Dynamic PL SQL block
    PROCEDURE LOGMASKINGTASK(CONFVERSION IN VARCHAR2
                            , GROUPID IN VARCHAR2
                            , SCHEMA_NAME IN VARCHAR2
                            , TABLE_NAME IN VARCHAR2
                            , COLUMN_NAME IN VARCHAR2
                            , XPATH IN VARCHAR2
                            , MASK_TYPE IN VARCHAR2
                            , MASK_VALUE IN VARCHAR2
                            , LOG_MESSAGE IN VARCHAR2) PARALLEL_ENABLE;
        --PRAGMA restrict_references (maskFieldStringValue, WNDS);
    
    PROCEDURE MASKFIELDS(CONF_VERSION IN VARCHAR2, CONF_GROUPID IN VARCHAR2, CONF_DEBUGMODE IN VARCHAR2, CONF_MAINSCHEMA VARCHAR2) PARALLEL_ENABLE;    
        --PRAGMA restrict_references (maskFieldStringValue, WNDS);
    
END BFPS_PDAF;
/


CREATE OR REPLACE PACKAGE BODY BFPS_PDAF AS
  
    PROCEDURE LOGMASKINGTASK(CONFVERSION IN VARCHAR2
                            , GROUPID IN VARCHAR2
                            , SCHEMA_NAME IN VARCHAR2
                            , TABLE_NAME IN VARCHAR2
                            , COLUMN_NAME IN VARCHAR2
                            , XPATH IN VARCHAR2
                            , MASK_TYPE IN VARCHAR2
                            , MASK_VALUE IN VARCHAR2
                            , LOG_MESSAGE IN VARCHAR2) PARALLEL_ENABLE AS
        RUNDEGREE NUMBER(38);                            
    BEGIN
    
        RUNDEGREE := PDAF_PII_RUNDEGREE_SEQ.NEXTVAL;
        
        INSERT 
                INTO PDAF_PII_LOG (SEQNO, RUNDEGREE, VRSN, GRP_ID, SCHM_NM, TBL_NM, CLMN_NM, XPATH, MSK_TP_ID, MSK, "LOG")
                VALUES (PDAF_PII_LOG_SEQ.NEXTVAL, RUNDEGREE, CONFVERSION, GROUPID, SCHEMA_NAME, TABLE_NAME, COLUMN_NAME, XPATH, MASK_TYPE, MASK_VALUE, LOG_MESSAGE);
        
    END LOGMASKINGTASK;
                            

    PROCEDURE MASKFIELDS(CONF_VERSION IN VARCHAR2, CONF_GROUPID IN VARCHAR2, CONF_DEBUGMODE IN VARCHAR2, CONF_MAINSCHEMA VARCHAR2) PARALLEL_ENABLE AS
        -- NUMBER OF RECORD PROCESSED
        IDXTOTAL NUMBER(38,0) := 0;
        IDXXMLTOTAL NUMBER(38,0) := 0;
    
        --- DYNAMIC CURSOR BLOCK
        TYPE CURTYPE IS REF CURSOR;
        SRC_CUR  CURTYPE;
        STMT_STR VARCHAR2(4000);
        
        --- DYNAMIC PL/SQL BLOCK
        PLSQL_BLOCK VARCHAR2(4000);
        MASK_FROM VARCHAR2(1000);
        MASK_TO VARCHAR2(1000);
        FILLOPTIONCHAR CHAR(1);
        FILLOPTIONLENGTHSTR VARCHAR2(100);
        FILLOPTIONLENGTH NUMBER(38,0);
        MASKMETHODINXMLUPDATE VARCHAR2(2000);
        
        -- CURSOR FIELD META
        CFM_VRSN VARCHAR2(20);
        CFM_GRP_ID VARCHAR2(100);
        CFM_SCHM_NM VARCHAR2(100);
        CFM_TBL_NM VARCHAR2(100);
        CFM_CLMN_NM VARCHAR2(100);
        CFM_CLMN_TP_ID VARCHAR2(100);
        CFM_CLMN_LNGTH NUMBER(38,0);
        CFM_MSK_TP_ID VARCHAR2(100);
        CFM_MSK VARCHAR2(4000);
        CFM_DSBLD CHAR(1);
        
        -- CURSOR XML META
        CXM_VRSN VARCHAR2(20);
        CXM_GRP_ID VARCHAR2(100);
        CXM_SCHM_NM VARCHAR2(100);
        CXM_TBL_NM VARCHAR2(100);
        CXM_CLMN_NM VARCHAR2(100);
        CXM_XPATH VARCHAR2(4000);
        CXM_MSK_TP_ID VARCHAR2(100);
        CXM_MSK VARCHAR2(4000);
        
        CURSOR CUR_FIELD_META (I_VERSION IN VARCHAR2, I_GRPID IN VARCHAR2)
            IS
                SELECT VRSN, GRP_ID, SCHM_NM, TBL_NM, CLMN_NM, CLMN_TP_ID, CLMN_LNGTH, UPPER(MSK_TP_ID), MSK, DSBLD
                  FROM HHS_HR.PDAF_PII_FIELD_META
                 WHERE VRSN = I_VERSION 
                   AND GRP_ID = I_GRPID
                    --AND  CLMN_TP_ID != 'XMLTYPE'    
                 ORDER BY GRP_ID, SCHM_NM, CLMN_NM ASC;
                 
        CURSOR CUR_XML_META (I_VERSION IN VARCHAR2, I_GRPID IN VARCHAR2, I_SCHEMA IN VARCHAR2, I_TABLE IN VARCHAR2, I_COLMN IN VARCHAR2)
            IS
                SELECT VRSN, GRP_ID, SCHM_NM, TBL_NM, CLMN_NM, XPATH, UPPER(MSK_TP_ID), MSK
                  FROM HHS_HR.PDAF_PII_FIELD_XML_META
                 WHERE VRSN = I_VERSION 
                   AND GRP_ID = I_GRPID
                   AND SCHM_NM = I_SCHEMA
                   AND TBL_NM = I_TABLE
                   AND CLMN_NM = I_COLMN
                 ORDER BY SCHM_NM, GRP_ID, CLMN_NM ASC;
        
    BEGIN
        
        HHS_HR.BFPS_PDAF.LOGMASKINGTASK(CONF_VERSION
                                        , CONF_GROUPID
                                        , NULL
                                        , NULL
                                        , NULL
                                        , NULL
                                        , NULL
                                        , NULL
                                        , 'STARTING DATA MASKING WITH BIZFLOW PII DISCLOSURE AVOIDANCE PACKAGE AT ' || TO_CHAR(SYSDATE, 'MM/DD/YYYY HH24:MI:SS') || '...');                    
                                                    
        IDXTOTAL := 0;

        OPEN CUR_FIELD_META (CONF_VERSION, CONF_GROUPID);
        
        LOOP
        
            FETCH CUR_FIELD_META
            INTO CFM_VRSN, CFM_GRP_ID, CFM_SCHM_NM, CFM_TBL_NM, CFM_CLMN_NM, CFM_CLMN_TP_ID, CFM_CLMN_LNGTH, CFM_MSK_TP_ID, CFM_MSK, CFM_DSBLD;
            EXIT WHEN CUR_FIELD_META%NOTFOUND;
            
            IDXTOTAL := IDXTOTAL + 1;
            -- RESET VARIABLES
            PLSQL_BLOCK := NULL;
            MASK_FROM := NULL;
            MASK_TO := NULL;
            FILLOPTIONCHAR := NULL;
            FILLOPTIONLENGTHSTR := NULL;
            FILLOPTIONLENGTH := 0;
    
            HHS_HR.BFPS_PDAF.LOGMASKINGTASK(CONF_VERSION
                                            , CONF_GROUPID
                                            , CFM_SCHM_NM
                                            , CFM_TBL_NM
                                            , CFM_CLMN_NM
                                            , NULL --XPATH
                                            , CFM_MSK_TP_ID
                                            , CFM_MSK
                                            , '[' || IDXTOTAL || '] ' || CFM_SCHM_NM || '.' || CFM_TBL_NM || '.' || CFM_CLMN_NM || ' - ' || CFM_CLMN_TP_ID || ', ' || CFM_MSK_TP_ID || ', ' || CFM_MSK || ', ' || CFM_DSBLD);
                                            
            IF CFM_CLMN_TP_ID IS NOT NULL AND CFM_CLMN_TP_ID != 'XMLTYPE' THEN
            
                IF CFM_MSK_TP_ID = 'SCRUB' THEN
    
                    PLSQL_BLOCK := ' BEGIN '
                                   || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                   ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.SCRUBSTRING( ' || CFM_CLMN_NM || ' ) '
                                   ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                   ' END; ';
                    
                ELSIF CFM_MSK_TP_ID = 'RANDOM-NUMBER' THEN
                    
                    IF CFM_MSK IS NULL THEN
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMNUMBER() '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                        
                    ELSE
                        MASK_FROM := SUBSTR(CFM_MSK, 1, INSTR(CFM_MSK, ',') -1);
                        MASK_TO := SUBSTR(CFM_MSK, INSTR(CFM_MSK, ',') + 1, 4000);
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMNUMBER( ' || MASK_FROM || ', ' || MASK_TO || ' ) '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF CFM_MSK_TP_ID = 'RANDOM-DATE' THEN
                
                    IF CFM_MSK IS NULL THEN
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMDATE() '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    ELSE
                        MASK_FROM := SUBSTR(CFM_MSK, 1, INSTR(CFM_MSK, ',') -1);
                        MASK_TO := SUBSTR(CFM_MSK, INSTR(CFM_MSK, ',') + 1, 4000);
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMDATE( ''' || MASK_FROM || ''', ''' || MASK_TO || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    END IF;
                                
                ELSIF CFM_MSK_TP_ID = 'RANDOM-EMAIL' THEN
    
                    IF CFM_MSK IS NULL THEN
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMEMAIL() '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    ELSE                    
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMEMAIL( ''' || CFM_MSK || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF CFM_MSK_TP_ID = 'LOOKUP-STRING' THEN
    
                    IF CFM_MSK IS NOT NULL THEN
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.LOOKUPSTRING( ''' || CFM_MSK || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    END IF;
    
                    
                ELSIF CFM_MSK_TP_ID = 'LOOKUP-NUMBER' THEN
    
                    IF CFM_MSK IS NOT NULL THEN
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.LOOKUPNUMBER( ' || CFM_MSK || ' ) '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF CFM_MSK_TP_ID = 'LOOKUP-DATE' THEN
    
                    IF CFM_MSK IS NOT NULL THEN
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.LOOKUPDATE( ' || CFM_MSK || ' ) '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF CFM_MSK_TP_ID = 'MASK' THEN
                
                    IF CFM_MSK IS NOT NULL THEN
                        PLSQL_BLOCK := ' BEGIN '
                                       || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                       ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.MASKSTRING( ''' || CFM_MSK || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF CFM_MSK_TP_ID = 'FILL' THEN
    
                    IF CFM_MSK IS NOT NULL THEN
                        FILLOPTIONCHAR := REGEXP_SUBSTR(CFM_MSK, '[^,]+', 1, 1);
                        FILLOPTIONLENGTHSTR := REGEXP_SUBSTR(CFM_MSK, '[^,]+', 1, 2);
    
                        IF FILLOPTIONLENGTHSTR IS NOT NULL AND LENGTH(FILLOPTIONLENGTHSTR) > 0 THEN
                            FILLOPTIONLENGTH := TO_NUMBER(FILLOPTIONLENGTHSTR);
                        END IF;
                    
                        IF FILLOPTIONCHAR IS NOT NULL AND FILLOPTIONLENGTH > 0 THEN
                            PLSQL_BLOCK := ' BEGIN '
                                           || ' UPDATE ' || CFM_SCHM_NM || '.' || CFM_TBL_NM
                                           ||    ' SET ' || CFM_CLMN_NM || ' = ' || CONF_MAINSCHEMA || '.BFPS_DATAMASK.FILLSTRING( ''' || FILLOPTIONCHAR || ''',' || FILLOPTIONLENGTH || ' ) '
                                           ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                           ' END; ';           
                        END IF;
                        
                    END IF;
                
                END IF;
                
                IF PLSQL_BLOCK IS NOT NULL THEN

                    HHS_HR.BFPS_PDAF.LOGMASKINGTASK(CONF_VERSION
                                                    , CONF_GROUPID
                                                    , CFM_SCHM_NM
                                                    , CFM_TBL_NM
                                                    , CFM_CLMN_NM
                                                    , NULL --XPATH
                                                    , CFM_MSK_TP_ID
                                                    , CFM_MSK
                                                    , PLSQL_BLOCK);

                    EXECUTE IMMEDIATE PLSQL_BLOCK; -- USING IN CONF_DEBUGMODE;

                END IF;            

            -------------------------------------------------- XMLTYPE ------------------------------------------------------------
            ELSIF CFM_CLMN_TP_ID IS NOT NULL AND CFM_CLMN_TP_ID = 'XMLTYPE' THEN 
                
                HHS_HR.BFPS_PDAF.LOGMASKINGTASK(CONF_VERSION
                                                , CONF_GROUPID
                                                , CFM_SCHM_NM
                                                , CFM_TBL_NM
                                                , CFM_CLMN_NM
                                                , NULL --XPATH
                                                , NULL
                                                , NULL
                                                , LPAD(' ', 2) || 'XMLTYPE = ' || CFM_SCHM_NM || '.' || CFM_TBL_NM || '.' || CFM_CLMN_NM);
    
                
                OPEN CUR_XML_META (CFM_VRSN, CFM_GRP_ID, CFM_SCHM_NM, CFM_TBL_NM, CFM_CLMN_NM);
            
                --TODO: RESET VARIABLES
                IDXXMLTOTAL := 0;
                LOOP
                    FETCH CUR_XML_META
                    INTO CXM_VRSN, CXM_GRP_ID, CXM_SCHM_NM, CXM_TBL_NM, CXM_CLMN_NM, CXM_XPATH, CXM_MSK_TP_ID, CXM_MSK;
                    EXIT WHEN CUR_XML_META%NOTFOUND;
                    
                    IDXXMLTOTAL := IDXXMLTOTAL + 1;
                    --PER XMLPATH IN A COLUMN
                    HHS_HR.BFPS_PDAF.LOGMASKINGTASK(CXM_VRSN
                                                    , CXM_GRP_ID
                                                    , CXM_SCHM_NM
                                                    , CXM_TBL_NM
                                                    , CXM_CLMN_NM
                                                    , CXM_XPATH --XPATH
                                                    , CXM_MSK_TP_ID
                                                    , CXM_MSK
                                                    , LPAD(' ', 2) 
                                                        || '[' || IDXTOTAL || '.' || IDXXMLTOTAL || ']'
                                                        || ' XPATH = ' || CXM_XPATH 
                                                        || ' MASK = ' || NVL(CXM_MSK_TP_ID, '') || ' / ' || NVL(CXM_MSK, ''));
                    
                    MASKMETHODINXMLUPDATE := '';
                    
                    IF CXM_MSK_TP_ID = 'SCRUB' THEN
                        
                        --SCRUB IS NOT SUPPORTED AT THIS POINT FOR PERFORMANCE ISSUE.
                        CXM_MSK_TP_ID := CXM_MSK_TP_ID;
                        
                    ELSIF CXM_MSK_TP_ID = 'RANDOM-NUMBER' THEN
                        
                        IF CXM_MSK IS NULL THEN
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMNUMBER() ';
                        ELSE
                            MASK_FROM := SUBSTR(CXM_MSK, 1, INSTR(CXM_MSK, ',') -1);
                            MASK_TO := SUBSTR(CXM_MSK, INSTR(CXM_MSK, ',') + 1, 4000);
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMNUMBER( ' || MASK_FROM || ', ' || MASK_TO || ' ) ';
                        END IF;
                        
                    ELSIF CFM_MSK_TP_ID = 'RANDOM-DATE' THEN
                    
                        IF CXM_MSK IS NULL THEN
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMDATE() ';
                        ELSE
                            MASK_FROM := SUBSTR(CFM_MSK, 1, INSTR(CXM_MSK, ',') -1);
                            MASK_TO := SUBSTR(CFM_MSK, INSTR(CXM_MSK, ',') + 1, 4000);
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMDATE( ''' || MASK_FROM || ''', ''' || MASK_TO || ''' ) ';
                        END IF;
                                    
                    ELSIF CXM_MSK_TP_ID = 'RANDOM-EMAIL' THEN
        
                        IF CXM_MSK IS NULL THEN
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMEMAIL() ';
                        ELSE
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.RANDOMEMAIL( ''' || CXM_MSK || ''' ) ';
                        END IF;
                        
                    ELSIF CXM_MSK_TP_ID = 'LOOKUP-STRING' THEN
        
                        IF CXM_MSK IS NOT NULL THEN
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.LOOKUPSTRING( ''' || CXM_MSK || ''' ) ';
                        END IF;
        
                    ELSIF CXM_MSK_TP_ID = 'LOOKUP-NUMBER' THEN
    
                        IF CXM_MSK IS NOT NULL THEN
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.LOOKUPNUMBER( ''' || CXM_MSK || ''' ) ';
                        END IF;
                            
                    ELSIF CXM_MSK_TP_ID = 'LOOKUP-DATE' THEN
        
                        IF CXM_MSK IS NOT NULL THEN
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.LOOKUPDATE( ''' || CXM_MSK || ''' ) ';
                        END IF;
                            
                    ELSIF CXM_MSK_TP_ID = 'MASK' THEN
                    
                        IF CXM_MSK IS NOT NULL THEN
                            MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.MASKSTRING( ''' || CXM_MSK || ''' ) ';
                        END IF;
                        
                    ELSIF CXM_MSK_TP_ID = 'FILL' THEN
        
                        IF CXM_MSK IS NOT NULL THEN
                        
                            FILLOPTIONCHAR := REGEXP_SUBSTR(CXM_MSK, '[^,]+', 1, 1);
                            FILLOPTIONLENGTHSTR := REGEXP_SUBSTR(CXM_MSK, '[^,]+', 1, 2);
                            
                            IF FILLOPTIONLENGTHSTR IS NOT NULL AND LENGTH(FILLOPTIONLENGTHSTR) > 0 THEN
                                FILLOPTIONLENGTH := TO_NUMBER(FILLOPTIONLENGTHSTR);
                            END IF;
                        
                            IF FILLOPTIONCHAR IS NOT NULL AND FILLOPTIONLENGTH > 0 THEN
                                MASKMETHODINXMLUPDATE := CONF_MAINSCHEMA || '.BFPS_DATAMASK.FILLSTRING( ''' || FILLOPTIONCHAR || ''',' || FILLOPTIONLENGTH || ' ) ';
                            END IF;
                            
                        ELSE
                            PLSQL_BLOCK := NULL;
                        END IF;
                    
                    END IF;
                            
                    PLSQL_BLOCK := 'BEGIN'
                                   || ' UPDATE ' || CXM_SCHM_NM || '.' || CXM_TBL_NM
                                   ||    ' SET ' || CXM_CLMN_NM || ' = UPDATEXML(' || CXM_CLMN_NM || ', ''' || CXM_XPATH || ''' , ' || MASKMETHODINXMLUPDATE || ' ) '
                                   ||    ' WHERE ''N'' = ''' || CONF_DEBUGMODE || '''; ' ||
                                   'END;';
                    
                    HHS_HR.BFPS_PDAF.LOGMASKINGTASK(CONF_VERSION
                                                    , CONF_GROUPID
                                                    , CXM_SCHM_NM
                                                    , CXM_TBL_NM
                                                    , CXM_CLMN_NM
                                                    , CXM_XPATH
                                                    , CXM_MSK_TP_ID
                                                    , CXM_MSK
                                                    , PLSQL_BLOCK);                    
                    EXECUTE IMMEDIATE PLSQL_BLOCK; -- USING IN CONF_DEBUGMODE;
                    
                END LOOP; -- CUR_XML_META
                
                CLOSE CUR_XML_META;
                            
            END IF; -- END OF COLUMNN TYPE [XMLTYPE VS NON-XMLTYPE]
            
        END LOOP;

        CLOSE CUR_FIELD_META;
        
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            ROLLBACK;
            
        WHEN OTHERS THEN
            --ERR_CODE := SQLCODE;
            --ERR_MSG := SUBSTR(SQLERRM, 1, 2000);
            ROLLBACK;
    
    END MASKFIELDS;


END BFPS_PDAF;
/
