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
    PROCEDURE logMaskingTask(confVersion in varchar2
                            , groupId in varchar2
                            , schema_name in varchar2
                            , table_name in varchar2
                            , column_name in varchar2
                            , xpath in varchar2
                            , mask_type in varchar2
                            , mask_value in varchar2
                            , log_message in varchar2) PARALLEL_ENABLE;
        --PRAGMA restrict_references (maskFieldStringValue, WNDS);
    
    PROCEDURE maskFields(conf_version in varchar2, conf_groupId in varchar2, conf_debugMode in varchar2, conf_mainSchema varchar2) PARALLEL_ENABLE;    
        --PRAGMA restrict_references (maskFieldStringValue, WNDS);
    
END BFPS_PDAF;
/


CREATE OR REPLACE PACKAGE BODY BFPS_PDAF AS
  
    PROCEDURE logMaskingTask(confVersion in varchar2
                            , groupId in varchar2
                            , schema_name in varchar2
                            , table_name in varchar2
                            , column_name in varchar2
                            , xpath in varchar2
                            , mask_type in varchar2
                            , mask_value in varchar2
                            , log_message in varchar2) PARALLEL_ENABLE as
        runDegree NUMBER(38);                            
    BEGIN
    
        runDegree := PDAF_PII_RUNDEGREE_SEQ.nextval;
        
        DBMS_OUTPUT.PUT_LINE('>logMaskingTask');
        
        INSERT 
                INTO PDAF_PII_LOG (SEQNO, RUNDEGREE, VRSN, GRP_ID, SCHM_NM, TBL_NM, CLMN_NM, XPATH, MSK_TP_ID, MSK, "LOG")
                VALUES (PDAF_PII_LOG_SEQ.nextval, runDegree, confVersion, groupId, schema_name, table_name, column_name, xpath, mask_type, mask_value, log_message);
        
    END logMaskingTask;
                            

    PROCEDURE maskFields(conf_version in varchar2, conf_groupId in varchar2, conf_debugMode in varchar2, conf_mainSchema varchar2) PARALLEL_ENABLE as
        -- Number of record processed
        idxTotal NUMBER(38,0) := 0;
        idxXMLTotal NUMBER(38,0) := 0;
    
        --- Dynamic Cursor block
        TYPE curtype IS REF CURSOR;
        src_cur  curtype;
        stmt_str VARCHAR2(4000);
        
        --- Dynamic PL/SQL block
        plsql_block VARCHAR2(4000);
        mask_from VARCHAR2(1000);
        mask_to VARCHAR2(1000);
        fillOptionChar CHAR(1);
        fillOptionLengthStr VARCHAR2(100);
        fillOptionLength NUMBER(38,0);
        maskMethodInXMLUpdate VARCHAR2(2000);
        
        -- Cursor FIELD META
        cfm_VRSN VARCHAR2(20);
        cfm_GRP_ID VARCHAR2(100);
        cfm_SCHM_NM VARCHAR2(100);
        cfm_TBL_NM VARCHAR2(100);
        cfm_CLMN_NM VARCHAR2(100);
        cfm_CLMN_TP_ID VARCHAR2(100);
        cfm_CLMN_LNGTH NUMBER(38,0);
        cfm_MSK_TP_ID VARCHAR2(100);
        cfm_MSK VARCHAR2(4000);
        cfm_DSBLD CHAR(1);
        
        -- Cursor XML META
        cxm_VRSN VARCHAR2(20);
        cxm_GRP_ID VARCHAR2(100);
        cxm_SCHM_NM VARCHAR2(100);
        cxm_TBL_NM VARCHAR2(100);
        cxm_CLMN_NM VARCHAR2(100);
        cxm_XPATH VARCHAR2(4000);
        cxm_MSK_TP_ID VARCHAR2(100);
        cxm_MSK VARCHAR2(4000);
        
        CURSOR cur_field_meta (i_version in varchar2, i_grpid in varchar2)
            IS
                SELECT VRSN, GRP_ID, SCHM_NM, TBL_NM, CLMN_NM, CLMN_TP_ID, CLMN_LNGTH, upper(MSK_TP_ID), MSK, DSBLD
                  FROM HHS_HR.PDAF_PII_FIELD_META
                 WHERE VRSN = i_version 
                   AND GRP_ID = i_grpid
                    --AND  CLMN_TP_ID != 'XMLTYPE'    
                 ORDER BY GRP_ID, SCHM_NM, CLMN_NM ASC;
                 
        CURSOR cur_xml_meta (i_version in varchar2, i_grpid in varchar2, i_schema in varchar2, i_table in varchar2, i_colmn in varchar2)
            IS
                SELECT VRSN, GRP_ID, SCHM_NM, TBL_NM, CLMN_NM, XPATH, upper(MSK_TP_ID), MSK
                  FROM HHS_HR.PDAF_PII_FIELD_XML_META
                 WHERE VRSN = i_version 
                   AND GRP_ID = i_grpid
                   AND SCHM_NM = i_schema
                   AND TBL_NM = i_table
                   AND CLMN_NM = i_colmn
                 ORDER BY SCHM_NM, GRP_ID, CLMN_NM ASC;
        
    BEGIN
        

        DBMS_OUTPUT.ENABLE(buffer_size => NULL);
        DBMS_OUTPUT.PUT_LINE('Starting Data Masking with BizFlow PII Disclosure Avoidance Package at ' || TO_CHAR(sysdate, 'mm/dd/yyyy HH24:MI:SS') || '...');
        HHS_HR.BFPS_PDAF.logMaskingTask(conf_version
                                        , conf_groupId
                                        , NULL
                                        , NULL
                                        , NULL
                                        , NULL
                                        , NULL
                                        , NULL
                                        , 'Starting Data Masking with BizFlow PII Disclosure Avoidance Package at ' || TO_CHAR(sysdate, 'mm/dd/yyyy HH24:MI:SS') || '...');                    
                                                    
        idxTotal := 0;

        OPEN cur_field_meta (conf_version, conf_groupId);
        
        LOOP
        
            FETCH cur_field_meta
            INTO cfm_VRSN, cfm_GRP_ID, cfm_SCHM_NM, cfm_TBL_NM, cfm_CLMN_NM, cfm_CLMN_TP_ID, cfm_CLMN_LNGTH, cfm_MSK_TP_ID, cfm_MSK, cfm_DSBLD;
            --DBMS_OUTPUT.PUT_LINE('fetching cur_field_meta...');
            EXIT WHEN cur_field_meta%NOTFOUND;
            
            idxTotal := idxTotal + 1;
            -- Reset variables
            plsql_block := NULL;
            mask_from := NULL;
            mask_to := NULL;
            fillOptionChar := NULL;
            fillOptionLengthStr := NULL;
            fillOptionLength := 0;
    
            DBMS_OUTPUT.PUT_LINE('[' || idxTotal || '] ' || cfm_SCHM_NM || '.' || cfm_TBL_NM || '.' || cfm_CLMN_NM || ' - ' || cfm_CLMN_TP_ID || ', ' || cfm_MSK_TP_ID || ', ' || cfm_MSK || ', ' || cfm_DSBLD);
            HHS_HR.BFPS_PDAF.logMaskingTask(conf_version
                                            , conf_groupId
                                            , cfm_SCHM_NM
                                            , cfm_TBL_NM
                                            , cfm_CLMN_NM
                                            , NULL --XPATH
                                            , cfm_MSK_TP_ID
                                            , cfm_MSK
                                            , '[' || idxTotal || '] ' || cfm_SCHM_NM || '.' || cfm_TBL_NM || '.' || cfm_CLMN_NM || ' - ' || cfm_CLMN_TP_ID || ', ' || cfm_MSK_TP_ID || ', ' || cfm_MSK || ', ' || cfm_DSBLD);
                                            
            IF cfm_CLMN_TP_ID is not null and cfm_CLMN_TP_ID != 'XMLTYPE' THEN
            
                IF cfm_MSK_TP_ID = 'SCRUB' THEN
    
                    plsql_block := ' BEGIN '
                                   || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                   ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.scrubString( ' || cfm_CLMN_NM || ' ) '
                                   ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                   ' END; ';
                    
                ELSIF cfm_MSK_TP_ID = 'RANDOM-NUMBER' THEN
                    
                    IF cfm_MSK IS NULL THEN
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.randomNumber() '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                        
                    ELSE
                        mask_from := SUBSTR(cfm_MSK, 1, INSTR(cfm_MSK, ',') -1);
                        mask_to := SUBSTR(cfm_MSK, INSTR(cfm_MSK, ',') + 1, 4000);
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.randomNumber( ' || mask_from || ', ' || mask_to || ' ) '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF cfm_MSK_TP_ID = 'RANDOM-DATE' THEN
                
                    IF cfm_MSK IS NULL THEN
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.randomDate() '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    ELSE
                        mask_from := SUBSTR(cfm_MSK, 1, INSTR(cfm_MSK, ',') -1);
                        mask_to := SUBSTR(cfm_MSK, INSTR(cfm_MSK, ',') + 1, 4000);
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.randomDate( ''' || mask_from || ''', ''' || mask_to || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    END IF;
                                
                ELSIF cfm_MSK_TP_ID = 'RANDOM-EMAIL' THEN
    
                    IF cfm_MSK IS NULL THEN
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.randomEmail() '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    ELSE                    
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.randomEmail( ''' || cfm_MSK || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF cfm_MSK_TP_ID = 'LOOKUP-STRING' THEN
    
                    IF cfm_MSK IS NOT NULL THEN
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.lookupString( ''' || cfm_MSK || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    END IF;
    
                    
                ELSIF cfm_MSK_TP_ID = 'LOOKUP-NUMBER' THEN
    
                    IF cfm_MSK IS NOT NULL THEN
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.lookupNumber( ' || cfm_MSK || ' ) '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF cfm_MSK_TP_ID = 'LOOKUP-DATE' THEN
    
                    IF cfm_MSK IS NOT NULL THEN
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.lookupDate( ' || cfm_MSK || ' ) '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF cfm_MSK_TP_ID = 'MASK' THEN
                
                    IF cfm_MSK IS NOT NULL THEN
                        plsql_block := ' BEGIN '
                                       || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                       ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.maskString( ''' || cfm_MSK || ''' ) '
                                       ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                       ' END; ';
                    END IF;
                    
                ELSIF cfm_MSK_TP_ID = 'FILL' THEN
    
                    IF cfm_MSK IS NOT NULL THEN
                        fillOptionChar := REGEXP_SUBSTR(cfm_MSK, '[^,]+', 1, 1);
                        fillOptionLengthStr := REGEXP_SUBSTR(cfm_MSK, '[^,]+', 1, 2);
    
                        IF fillOptionLengthStr IS NOT NULL and length(fillOptionLengthStr) > 0 THEN
                            fillOptionLength := TO_NUMBER(fillOptionLengthStr);
                        ELSE
                            DBMS_OUTPUT.PUT_LINE('fillLengthString is null.');
                        END IF;
                    
                        IF fillOptionChar IS NOT NULL and fillOptionLength > 0 THEN
                            plsql_block := ' BEGIN '
                                           || ' UPDATE ' || cfm_SCHM_NM || '.' || cfm_TBL_NM
                                           ||    ' SET ' || cfm_CLMN_NM || ' = ' || conf_mainSchema || '.BFPS_DATAMASK.fillString( ''' || fillOptionChar || ''',' || fillOptionLength || ' ) '
                                           ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                           ' END; ';           
                        END IF;
                        
                    END IF;
                
                END IF;
                
                IF plsql_block IS NOT NULL THEN

                    DBMS_OUTPUT.PUT_LINE(LPAD(' ', 2) || plsql_block);
                    HHS_HR.BFPS_PDAF.logMaskingTask(conf_version
                                                    , conf_groupId
                                                    , cfm_SCHM_NM
                                                    , cfm_TBL_NM
                                                    , cfm_CLMN_NM
                                                    , NULL --XPATH
                                                    , cfm_MSK_TP_ID
                                                    , cfm_MSK
                                                    , plsql_block);

                    EXECUTE IMMEDIATE plsql_block; -- USING IN conf_debugMode;

                END IF;            

            -------------------------------------------------- XMLTYPE ------------------------------------------------------------
            ELSIF cfm_CLMN_TP_ID is not null and cfm_CLMN_TP_ID = 'XMLTYPE' THEN 
                
                DBMS_OUTPUT.PUT_LINE(LPAD(' ', 2) || 'XMLTYPE = ' || cfm_SCHM_NM || '.' || cfm_TBL_NM || '.' || cfm_CLMN_NM);
                HHS_HR.BFPS_PDAF.logMaskingTask(conf_version
                                                , conf_groupId
                                                , cfm_SCHM_NM
                                                , cfm_TBL_NM
                                                , cfm_CLMN_NM
                                                , NULL --XPATH
                                                , NULL
                                                , NULL
                                                , LPAD(' ', 2) || 'XMLTYPE = ' || cfm_SCHM_NM || '.' || cfm_TBL_NM || '.' || cfm_CLMN_NM);
    
                
                --DBMS_OUTPUT.PUT_LINE(LPAD(' ', 2) || 'Opening cur_xml_meta-->');
                OPEN cur_xml_meta (cfm_VRSN, cfm_GRP_ID, cfm_SCHM_NM, cfm_TBL_NM, cfm_CLMN_NM);
            
                --TODO: RESET VARIABLES
                idxXMLTotal := 0;
                LOOP
                    FETCH cur_xml_meta
                    INTO cxm_VRSN, cxm_GRP_ID, cxm_SCHM_NM, cxm_TBL_NM, cxm_CLMN_NM, cxm_XPATH, cxm_MSK_TP_ID, cxm_MSK;
                    --DBMS_OUTPUT.PUT_LINE('Retrieving defined XPATHs of the XMLTYPE');
                    EXIT WHEN cur_xml_meta%NOTFOUND;
                    
                    idxXMLTotal := idxXMLTotal + 1;
                    --PER XMLPATH in a Column
                    DBMS_OUTPUT.PUT_LINE( LPAD(' ', 2) 
                                        || '[' || idxTotal || '.' || idxXMLTotal || ']'
                                        || ' XPATH = ' || cxm_XPATH 
                                        || ' MASK = ' || nvl(cxm_MSK_TP_ID, '') || ' / ' || nvl(cxm_MSK, ''));
                    HHS_HR.BFPS_PDAF.logMaskingTask(cxm_VRSN
                                                    , cxm_GRP_ID
                                                    , cxm_SCHM_NM
                                                    , cxm_TBL_NM
                                                    , cxm_CLMN_NM
                                                    , cxm_XPATH --XPATH
                                                    , cxm_MSK_TP_ID
                                                    , cxm_MSK
                                                    , LPAD(' ', 2) 
                                                        || '[' || idxTotal || '.' || idxXMLTotal || ']'
                                                        || ' XPATH = ' || cxm_XPATH 
                                                        || ' MASK = ' || nvl(cxm_MSK_TP_ID, '') || ' / ' || nvl(cxm_MSK, ''));
                    
                    maskMethodInXMLUpdate := '';
                    
                    IF cxm_MSK_TP_ID = 'SCRUB' THEN
    
                        DBMS_OUTPUT.PUT_LINE('SCRUB is not supported for XMLTYPE');
                        
                    ELSIF cxm_MSK_TP_ID = 'RANDOM-NUMBER' THEN
                        
                        IF cxm_MSK IS NULL THEN
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.randomNumber() ';
                        ELSE
                            mask_from := SUBSTR(cxm_MSK, 1, INSTR(cxm_MSK, ',') -1);
                            mask_to := SUBSTR(cxm_MSK, INSTR(cxm_MSK, ',') + 1, 4000);
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.randomNumber( ' || mask_from || ', ' || mask_to || ' ) ';
                        END IF;
                        
                    ELSIF cfm_MSK_TP_ID = 'RANDOM-DATE' THEN
                    
                        IF cxm_MSK IS NULL THEN
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.randomDate() ';
                        ELSE
                            mask_from := SUBSTR(cfm_MSK, 1, INSTR(cxm_MSK, ',') -1);
                            mask_to := SUBSTR(cfm_MSK, INSTR(cxm_MSK, ',') + 1, 4000);
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.randomDate( ''' || mask_from || ''', ''' || mask_to || ''' ) ';
                        END IF;
                                    
                    ELSIF cxm_MSK_TP_ID = 'RANDOM-EMAIL' THEN
        
                        IF cxm_MSK IS NULL THEN
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.randomEmail() ';
                        ELSE
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.randomEmail( ''' || cxm_MSK || ''' ) ';
                        END IF;
                        
                    ELSIF cxm_MSK_TP_ID = 'LOOKUP-STRING' THEN
        
                        IF cxm_MSK IS NOT NULL THEN
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.lookupString( ''' || cxm_MSK || ''' ) ';
                        END IF;
        
                    ELSIF cxm_MSK_TP_ID = 'LOOKUP-NUMBER' THEN
    
                        IF cxm_MSK IS NOT NULL THEN
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.lookupNumber( ''' || cxm_MSK || ''' ) ';
                        END IF;
                            
                    ELSIF cxm_MSK_TP_ID = 'LOOKUP-DATE' THEN
        
                        IF cxm_MSK IS NOT NULL THEN
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.lookupDate( ''' || cxm_MSK || ''' ) ';
                        END IF;
                            
                    ELSIF cxm_MSK_TP_ID = 'MASK' THEN
                    
                        IF cxm_MSK IS NOT NULL THEN
                            maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.maskString( ''' || cxm_MSK || ''' ) ';
                        END IF;
                        
                    ELSIF cxm_MSK_TP_ID = 'FILL' THEN
        
                        IF cxm_MSK IS NOT NULL THEN
                        
                            fillOptionChar := REGEXP_SUBSTR(cxm_MSK, '[^,]+', 1, 1);
                            fillOptionLengthStr := REGEXP_SUBSTR(cxm_MSK, '[^,]+', 1, 2);
                            
                            IF fillOptionLengthStr IS NOT NULL and length(fillOptionLengthStr) > 0 THEN
                                fillOptionLength := TO_NUMBER(fillOptionLengthStr);
                            ELSE
                                DBMS_OUTPUT.PUT_LINE( LPAD(' ', 6) || 'fillLengthString is null.');
                            END IF;
                        
                            IF fillOptionChar IS NOT NULL and fillOptionLength > 0 THEN
                                maskMethodInXMLUpdate := conf_mainSchema || '.BFPS_DATAMASK.fillString( ''' || fillOptionChar || ''',' || fillOptionLength || ' ) ';
                            END IF;
                            
                        ELSE
                            plsql_block := NULL;
                            DBMS_OUTPUT.PUT_LINE( LPAD(' ', 6) || 'Filling Format value is emtpty. It is requried for Fill method.');
                        END IF;
                    
                    ELSE
                        
                        DBMS_OUTPUT.PUT_LINE('Not supported masking method [' || cxm_MSK_TP_ID || ']');
                        
                    END IF;
                            
                    plsql_block := 'BEGIN'
                                   || ' UPDATE ' || cxm_SCHM_NM || '.' || cxm_TBL_NM
                                   ||    ' SET ' || cxm_CLMN_NM || ' = updateXML(' || cxm_CLMN_NM || ', ''' || cxm_XPATH || ''' , ' || maskMethodInXMLUpdate || ' ) '
                                   ||    ' WHERE ''N'' = ''' || conf_debugMode || '''; ' ||
                                   'END;';
                    
                    DBMS_OUTPUT.PUT_LINE( LPAD(' ', 6) || plsql_block);
                    HHS_HR.BFPS_PDAF.logMaskingTask(conf_version
                                                    , conf_groupId
                                                    , cxm_SCHM_NM
                                                    , cxm_TBL_NM
                                                    , cxm_CLMN_NM
                                                    , cxm_XPATH
                                                    , cxm_MSK_TP_ID
                                                    , cxm_MSK
                                                    , plsql_block);                    
                    EXECUTE IMMEDIATE plsql_block; -- USING IN conf_debugMode;
                    
                END LOOP; -- cur_xml_meta
                
                --DBMS_OUTPUT.PUT_LINE(LPAD(' ', 2) || '<--Closing cur_xml_meta');
                CLOSE cur_xml_meta;
            
                            
            END IF; -- end of columnn type [XMLTYPE vs Non-XMLTYPE]
            
        END LOOP;

        CLOSE cur_field_meta;
        
        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing ' || SQLERRM);
            ROLLBACK;
            
        WHEN OTHERS THEN
            --err_code := SQLCODE;
            --err_msg := SUBSTR(SQLERRM, 1, 2000);
            DBMS_OUTPUT.PUT_LINE('ERROR occurred while executing ' || SQLERRM);
            ROLLBACK;
    
    END maskFields;


END BFPS_PDAF;
/
