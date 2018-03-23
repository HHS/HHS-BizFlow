CREATE OR REPLACE PACKAGE BFPS_DATAMASK AS 

    ------------------------------------------------------------------------------------------
    --	Name				:	BFPS_DATAMASK-package.sql
    --  Script/package name	: 	BFPS_DATAMASK
    --	Author				:	Taeho Lee <thee@bizflow.com>
    --	Copyright			:	BizFlow Corp.	
    --	
    --	Project				:	BizFlow Oracle Data Masking library
    --	Purpose				:	Library package of BizFlow Oracle common utilities for Data Masking
    --	
    --  Example
    --  To use in SQL statements:
    --      select BFPS_DATAMASK.ramdomNumber from dual;
    --      insert into mytable (price) values (BFPS_DATAMASK.ramdomNumber());
    --      execute :x := BFPS_DATAMASK.ramdomNumber;
    --
    --  Usage                : "opt" specifies that the returned string may contain:
    --                          L = An uppercase Letter.	
    --                          l = A lowercase letter.	
    --                          M = A letter (upper or lower).
    --                          V = An uppercase Vowel.
    --                          v = A lowercase vowel.
    --                          W = A vowel (upper or lower).
    --                          C = An uppercase Consonant.	
    --                          c = A lowercase consonant.
    --                          E = A consonant (upper or lower).
    --                          N = Any number, 0-9.
    --                          n = Any number, 1-9.
    --                          H = An Hexidecimal number (0-F)
    --                          X = any alpha-numeric characters (upper) 
    --                          x = any alpha-numeric characters (lower) 
    --                          Z = any alpha-numeric characters (lower) 
    --                          P = any printable char (ASCII subset) 
    --       
    -- 	WHEN		WHO			WHAT		
    -- 	-----------	--------	-------------------------------------------------------
    -- 	03/05/2018	THLEE		Created
    --  03/08/2018  THLEE       String API
    --  03/13/2018  THLEE       Number, Date API
    --  03/15/2018  THLEE       Lookup
    --  03/19/2018  THLEE       Bug fix - wrong delimiter use in Regular Expression.
    ------------------------------------------------------------------------------------------

    /**
        PRAGMA is an instruction or a hint or information to the compiler. Pragmas are processed at compile time, not at run time.
        
        CREATE OR REPLACE PACKAGE pkg_salary
        IS
        function get_emp_salary(p_empno integer) return number;    
        PRAGMA restrict_references(get_emp_salary, RNDS, RNPS, WNDS, WNPS);
        END pkg_salary;
        
        RNDS – Read No Database State. Asserts that the function not to read or query tables
        RNDS – Read No Package State. Asserts that the function not to read or reference package variables
        WNDS – Write No Database State. Asserts that the function not modify database tables
        WNPS – Write No Package State. Asserts that the function not modify package variables
        TRUST – Asserts that the function can be trusted not to violate one or more rules. Used only when C or JAVA routines are called from PL/SQL.
    **/

    /**
    *   Common Dynamic Data Masking Library Section
    **/

    TYPE NUM_ARRAY IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;

    -- Initialization Section ------------------------------------------------------------
    -- Seed with a binary integer
    PROCEDURE SEED(VAL IN BINARY_INTEGER);
    PRAGMA RESTRICT_REFERENCES (SEED, WNDS);
    -- Seed with a string (up to length 2000)
    PROCEDURE SEED(VAL IN VARCHAR2);
    PRAGMA RESTRICT_REFERENCES (SEED, WNDS);


    -- Numberic Section ------------------------------------------------------------
    -- Get a random 38-digit precision number, 0.0 <= value < 1.0
    FUNCTION RANDOMNUMBER RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (RANDOMNUMBER, WNDS);
    -- get a random Oracle number x, low <= x < high
    FUNCTION RANDOMNUMBER (LOW IN NUMBER, HIGH IN NUMBER) RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (RANDOMNUMBER, WNDS);
    -- get a random number from a normal distribution
    FUNCTION NORMAL RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (NORMAL, WNDS);


    -- Date Section ------------------------------------------------------------
    -- get a random date from 01/01/1990 to present
    FUNCTION RANDOMDATE RETURN DATE PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (RANDOMDATE, WNDS);
    -- get a random date between startDate (mm/dd/yyyy) and endDate (mm/dd/yyyy)
    FUNCTION RANDOMDATE(STARTDATE VARCHAR2, ENDDATE VARCHAR2) RETURN DATE PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (RANDOMDATE, WNDS);


    -- Email Section ------------------------------------------------------------
    FUNCTION RANDOMEMAIL RETURN VARCHAR2 PARALLEL_ENABLE;    
        PRAGMA RESTRICT_REFERENCES (RANDOMEMAIL, WNDS);
    FUNCTION RANDOMEMAIL(DOMAINNAME VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (RANDOMEMAIL, WNDS);

    -- Lookup Section ------------------------------------------------------------
    FUNCTION LOOKUPSTRING(ITEMS VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (LOOKUPSTRING, WNDS);
    FUNCTION LOOKUPDATE(ITEMS VARCHAR2) RETURN DATE PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (LOOKUPDATE, WNDS);
    FUNCTION LOOKUPNUMBER(ITEMS VARCHAR2) RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (LOOKUPNUMBER, WNDS);

    -- String Section ------------------------------------------------------------
    -- get a random string
    /* "opt" specifies that the returned string may contain:
        L : An uppercase Letter.	
        l : A lowercase letter.	
        M : A letter (upper or lower).
        V : An uppercase Vowel.
        v : A lowercase vowel.
        W : A vowel (upper or lower).
        C : An uppercase Consonant.	
        c : A lowercase consonant.
        E : A consonant (upper or lower).
        N : Any number, 0-9.
        n : Any number, 1-9.
        H : An Hexidecimal number (0-F)
        X: any alpha-numeric characters (upper) 
        x: any alpha-numeric characters (lower) 
        Z: any alpha-numeric characters (lower) 
        P: any printable char (ASCII subset) 
    */    
    FUNCTION FILLSTRING (OPT CHAR, LEN NUMBER) RETURN VARCHAR2 PARALLEL_ENABLE;  -- string of <len> characters
        PRAGMA RESTRICT_REFERENCES (FILLSTRING, WNDS);
    -- get a random string
    -- "udmask" is a set of opt i.e) LLLnnHH
    FUNCTION MASKSTRING (UD_MASK VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE;  -- string of <len> characters
        PRAGMA RESTRICT_REFERENCES (MASKSTRING, WNDS);
    -- get a random string
    FUNCTION SCRUBSTRING(WORD IN VARCHAR2)RETURN VARCHAR2 PARALLEL_ENABLE;    
        PRAGMA RESTRICT_REFERENCES (SCRUBSTRING, WNDS);
    -- get function string for Dynamic PL SQL block
    FUNCTION MASKFIELDSTRINGVALUE(FIELDNAME IN VARCHAR2, FIELDVALUE IN VARCHAR2, MASKTYPE IN VARCHAR2, MASKVALUE IN VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (MASKFIELDSTRINGVALUE, WNDS);
    FUNCTION CONSTANCTSTRING(MASKVALUE IN VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA RESTRICT_REFERENCES (CONSTANCTSTRING, WNDS);


END BFPS_DATAMASK;
/


CREATE OR REPLACE PACKAGE BODY BFPS_DATAMASK AS

    V_NUM_ARRAY             num_array;
    V_COUNTER               BINARY_INTEGER := 55;
    V_SAVED_NORM_DIST       NUMBER := NULL;
    V_NEED_INIT             BOOLEAN := TRUE;

    PROCEDURE SEED(VAL IN BINARY_INTEGER) IS
    BEGIN
        SEED(TO_CHAR(VAL));
    END SEED;

    PROCEDURE SEED(VAL IN VARCHAR2) IS
        JUNK     VARCHAR2(2000);
        PIECE    VARCHAR2(20);
        RANDVAL  NUMBER;
        MYTEMP   NUMBER;
        J        BINARY_INTEGER;
    BEGIN
        V_NEED_INIT         := FALSE;
        V_SAVED_NORM_DIST   := NULL;
        V_COUNTER           := 0;
        JUNK                := TO_SINGLE_BYTE(VAL);
        
        FOR I IN 0..54 LOOP
            PIECE   := SUBSTR(JUNK,1,19);
            RANDVAL := 0;
            J       := 1;

            -- CONVERT 19 CHARACTERS TO A 38-DIGIT NUMBER
            FOR J IN 1..19 LOOP
                RANDVAL := 1E2*RANDVAL + NVL(ASCII(SUBSTR(PIECE,J,1)),0.0);
            END LOOP;

            -- try to avoid lots of zeros
            RANDVAL := RANDVAL*1E-38+I*.01020304050607080910111213141516171819;
            V_NUM_ARRAY(I)  := RANDVAL - TRUNC(RANDVAL);

            -- we've handled these first 19 characters already; move on
            JUNK    := substr(JUNK,20);
        END LOOP;

        RANDVAL := V_NUM_ARRAY(54);

        FOR J IN 0..10 LOOP
            FOR I IN 0..54 LOOP
                -- barrelshift V_NUM_ARRAY(i-1) by 24 digits
                RANDVAL := RANDVAL * 1E24;
                MYTEMP  := TRUNC(RANDVAL);
                RANDVAL := (RANDVAL - MYTEMP) + (MYTEMP * 1E-38);

                -- add it to V_NUM_ARRAY(i)
                RANDVAL := V_NUM_ARRAY(I)+RANDVAL;
                IF (RANDVAL >= 1.0) THEN
                    RANDVAL := RANDVAL - 1.0;
                END IF;

                V_NUM_ARRAY(I) := RANDVAL;
            END LOOP;
        END LOOP;
    END SEED;


    -- Numberic Section ------------------------------------------------------------
    FUNCTION RANDOMNUMBER RETURN NUMBER  PARALLEL_ENABLE IS
        RANDVAL  NUMBER;
    BEGIN
        V_COUNTER := V_COUNTER + 1;
        IF V_COUNTER >= 55 THEN
            -- initialize if needed
            IF (V_NEED_INIT = TRUE) THEN
                SEED(TO_CHAR(SYSDATE,'MM-DD-YYYY HH24:MI:SS') ||
                     USER || USERENV('SESSIONID'));
            ELSE
                -- need to generate 55 more results
                FOR I IN 0..30 LOOP
                    RANDVAL := V_NUM_ARRAY(I+24) + V_NUM_ARRAY(I);
                    IF (RANDVAL >= 1.0) THEN
                        RANDVAL := RANDVAL - 1.0;
                    END IF;
                    V_NUM_ARRAY(I) := RANDVAL;

                END LOOP;
                FOR I IN 31..54 LOOP
                    RANDVAL := V_NUM_ARRAY(I-31) + V_NUM_ARRAY(I);
                    IF (RANDVAL >= 1.0) THEN
                        RANDVAL := RANDVAL - 1.0;
                    END IF;
                    V_NUM_ARRAY(I) := RANDVAL;
                END LOOP;
            END IF;
            V_COUNTER := 0;
        END IF;
        RETURN V_NUM_ARRAY(V_COUNTER);
    END RANDOMNUMBER;

    -- Random 38-digit number between LOW and HIGH.
    FUNCTION RANDOMNUMBER ( LOW IN NUMBER, HIGH IN NUMBER) RETURN NUMBER PARALLEL_ENABLE IS
    BEGIN
        RETURN (RANDOMNUMBER*(HIGH-LOW))+LOW;
    END RANDOMNUMBER;

    -- Random numbers in a normal distribution.
    FUNCTION NORMAL RETURN NUMBER PARALLEL_ENABLE IS  
        V1  NUMBER;
        V2  NUMBER;
        R2  NUMBER;
        FAC NUMBER;
    BEGIN
        IF V_SAVED_NORM_DIST IS NOT NULL THEN     -- saved from last time
            V1 := V_SAVED_NORM_DIST;              -- to be returned this time
            V_SAVED_NORM_DIST := NULL;
        ELSE
            R2 := 2;
            -- Find two independent uniform variables
            WHILE R2 > 1 OR R2 = 0 LOOP
                V1 := RANDOMNUMBER();
                V1 := V1 + V1 - 1;
                V2 := RANDOMNUMBER();
                V2 := V2 + V2 - 1;
                R2 := V1*V1 + V2*V2;  -- r2 is radius
            END LOOP;      -- 0 < r2 <= 1:  in unit circle
            /* Now derive two independent normally-distributed variables */
            FAC := SQRT(-2*ln(R2)/R2);
            V1 := V1*FAC;          -- to be returned this time
            V_SAVED_NORM_DIST := V2*FAC;  -- to be saved for next time
        END IF;
        RETURN V1;
    END  NORMAL;


    -- Date Section ------------------------------------------------------------    
    FUNCTION RANDOMDATE RETURN DATE PARALLEL_ENABLE AS
    BEGIN
        RETURN RANDOMDATE('01/01/1990', TO_CHAR(SYSDATE, 'mm/dd/yyyy'));
    END RANDOMDATE;

    -- get a random date between startDate (mm/dd/yyyy) and endDate (mm/dd/yyyy)
    FUNCTION RANDOMDATE(startdate VARCHAR2, enddate VARCHAR2) RETURN DATE PARALLEL_ENABLE AS
        DT DATE;
        DT_START DATE;
        DT_END DATE;
    BEGIN
        --date format mm/dd/yyyy
        DT_START := TO_DATE(startdate, 'mm/dd/yyyy');
        DT_END := TO_DATE(enddate, 'mm/dd/yyyy');
        DT := TO_DATE( TRUNC( RANDOMNUMBER(TO_CHAR(DT_START,'J'), TO_CHAR(DT_END,'J')) ),'J');
        RETURN DT;
    END RANDOMDATE;


    -- Email Section ------------------------------------------------------------
    FUNCTION RANDOMEMAIL RETURN VARCHAR2 PARALLEL_ENABLE AS
    BEGIN

        RETURN SCRUBSTRING('aaaaa.aaaaa@aaaaa') || '.com';

    END RANDOMEMAIL;

    FUNCTION RANDOMEMAIL(DOMAINNAME VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE AS
    BEGIN

        RETURN SCRUBSTRING('aaaaa.aaaaa') || '@' || DOMAINNAME;

    END RANDOMEMAIL;

    -- Lookup Section ------------------------------------------------------------
    FUNCTION LOOKUPSTRING(ITEMS VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE AS
        SELECTED_ITEM VARCHAR2(2000);
        IDX NUMBER;
        NUMBER_OF_ITEMS NUMBER;
    BEGIN
        NUMBER_OF_ITEMS := REGEXP_COUNT(ITEMS, '\|') + 1;
        IDX := TRUNC(RANDOMNUMBER(1, NUMBER_OF_ITEMS + 0.1));
        SELECTED_ITEM := REGEXP_SUBSTR(ITEMS, '[^|]+', 1, IDX);
        RETURN SELECTED_ITEM;
    END LOOKUPSTRING;

    FUNCTION LOOKUPDATE(ITEMS VARCHAR2) RETURN DATE PARALLEL_ENABLE AS
        SELECTED_ITEM VARCHAR2(2000);
    BEGIN
        SELECTED_ITEM := LOOKUPSTRING(ITEMS);
        RETURN TO_DATE(SELECTED_ITEM, 'mm/dd/yyyy');
    END LOOKUPDATE;

    FUNCTION LOOKUPNUMBER(ITEMS VARCHAR2) RETURN NUMBER PARALLEL_ENABLE AS
        SELECTED_ITEM VARCHAR2(2000);
    BEGIN
        SELECTED_ITEM := LOOKUPSTRING(ITEMS);
        RETURN TO_NUMBER(SELECTED_ITEM);
    END LOOKUPNUMBER;


    -- String Section ------------------------------------------------------------

    -- Random string.
    FUNCTION FILLSTRING (OPT CHAR, LEN NUMBER) 
        RETURN VARCHAR2 PARALLEL_ENABLE IS
        
        LEN_OF_CHAR_SET     NUMBER; 
        N                   BINARY_INTEGER; 
        CANDIDATE_CHAR_SET  VARCHAR2 (128);
        RESULT_STR          VARCHAR2 (4000) := NULL; 
        
    BEGIN 

        IF OPT IS NULL THEN
            RESULT_STR := NULL;
        ELSIF OPT = 'L' THEN --L : An uppercase Letter.	
            CANDIDATE_CHAR_SET := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
            LEN_OF_CHAR_SET := 26;
        ELSIF OPT = 'l' THEN --l : A lowercase letter.	
            CANDIDATE_CHAR_SET := 'abcdefghijklmnopqrstuvwxyz'; 
            LEN_OF_CHAR_SET := 26;
        ELSIF OPT = 'M' THEN --M : A letter (upper or lower).
            CANDIDATE_CHAR_SET := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
                                    || 'abcdefghijklmnopqrstuvwxyz';
            LEN_OF_CHAR_SET := 52;
        ELSIF OPT = 'V' THEN --V : An uppercase Vowel.
            CANDIDATE_CHAR_SET := 'AEIOU';
            LEN_OF_CHAR_SET := 5;
        ELSIF OPT = 'v' THEN --v : A lowercase vowel.
            CANDIDATE_CHAR_SET := 'aeiou'; 
            LEN_OF_CHAR_SET := 5;
        ELSIF OPT = 'W' THEN --W : A vowel (upper or lower).
            CANDIDATE_CHAR_SET := 'AEIOU'
                                    || 'aeiou';
            LEN_OF_CHAR_SET := 10;
        ELSIF OPT = 'C' THEN --C : An uppercase Consonant.	
            CANDIDATE_CHAR_SET := 'BCDFGHJKLMNPQRSTVWXYZ';
            LEN_OF_CHAR_SET := 21;
        ELSIF OPT = 'c' THEN --c : A lowercase consonant.
            CANDIDATE_CHAR_SET := 'bcdfghjklmnpqrstvwxyz';
            LEN_OF_CHAR_SET := 21;
        ELSIF OPT = 'E' THEN --E : A consonant (upper or lower).
            CANDIDATE_CHAR_SET := 'BCDFGHJKLMNPQRSTVWXYZ'
                                    || 'bcdfghjklmnpqrstvwxyz';
            LEN_OF_CHAR_SET := 42;
        ELSIF OPT = 'N' THEN --N : Any number, 0-9.
            CANDIDATE_CHAR_SET := '0123456789';
            LEN_OF_CHAR_SET := 10;        	
        ELSIF OPT = 'n' THEN --N : Any number, 1-9.
            CANDIDATE_CHAR_SET := '123456789';
            LEN_OF_CHAR_SET := 9;
        ELSIF OPT = 'H' THEN --H : An Hexidecimal number (0-F)
            CANDIDATE_CHAR_SET := '0123456789ABCDEF';
            LEN_OF_CHAR_SET := 16;
        ELSIF OPT = 'X' THEN    --X: any alpha-numeric characters (upper) 
            CANDIDATE_CHAR_SET := '0123456789'
                                    || 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
            LEN_OF_CHAR_SET := 36;
        ELSIF OPT = 'x' THEN    --x: any alpha-numeric characters (lower) 
            CANDIDATE_CHAR_SET := '0123456789'
                                    || 'abcdefghijklmnopqrstuvwxyz'; 
            LEN_OF_CHAR_SET := 36;
        ELSIF OPT = 'Y' THEN    --Y: any alpha-numeric characters (lower) 
            CANDIDATE_CHAR_SET := '0123456789' 
                                    || 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
                                    || 'abcdefghijklmnopqrstuvwxyz'; 
            LEN_OF_CHAR_SET := 62;
        ELSIF OPT = 'P' THEN    --P: any printable char (ASCII subset) 
            CANDIDATE_CHAR_SET := ' !"#$%&''()*+,-./' 
                                    || '0123456789' 
                                    || ':;<=>?@' 
                                    || 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' 
                                    || '[\]^_`' 
                                    || 'abcdefghijklmnopqrstuvwxyz' 
                                    || '{|}~' ; 
            LEN_OF_CHAR_SET := 95; 
        ELSE 
            CANDIDATE_CHAR_SET := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
            LEN_OF_CHAR_SET := 26;
        END IF;

        FOR I IN 1 .. least(LEN,4000) LOOP 
            /* Get random integer within specified range */ 
            N := TRUNC(LEN_OF_CHAR_SET * RANDOMNUMBER) + 1; 
            /* Append character to string  */ 
            RESULT_STR := RESULT_STR || substr(CANDIDATE_CHAR_SET,N,1); 
        END LOOP; 
        RETURN RESULT_STR; 

    END FILLSTRING; 

    -- Random string with given user defined mask
    FUNCTION MASKSTRING (UD_MASK VARCHAR2)
        RETURN VARCHAR2 PARALLEL_ENABLE IS -- string of <len> characters 
        LEN  NUMBER;
        RESULT_STR VARCHAR2 (4000) := NULL;
        XCHR CHAR(1);
    BEGIN 

        IF UD_MASK IS NULL THEN
            RESULT_STR := NULL;
        ELSE 
            LEN := LENGTH(UD_MASK);

            FOR I IN 1 .. len LOOP 

                XCHR := substr(UD_MASK, I, 1);

                IF XCHR = 'u'
                    OR XCHR = 'L'
                    OR XCHR = 'l'
                    OR XCHR = 'M'
                    OR XCHR = 'V'
                    OR XCHR = 'v'
                    OR XCHR = 'W'
                    OR XCHR = 'C'
                    OR XCHR = 'c'
                    OR XCHR = 'E'
                    OR XCHR = 'N'
                    OR XCHR = 'n'
                    OR XCHR = 'H'
                    OR XCHR = 'X'
                    OR XCHR = 'x'
                    OR XCHR = 'Y'
                    OR XCHR = 'P' THEN

                    XCHR := FILLSTRING(XCHR, 1);

                ELSE

                    XCHR := XCHR;
                END IF;

                RESULT_STR := RESULT_STR || XCHR;

            END LOOP;

        END IF; 

        RETURN RESULT_STR; 
    END MASKSTRING;

    -- Replace word with ramdon alphanumeric letters.
    FUNCTION SCRUBSTRING(WORD IN VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE AS
        XCHR CHAR(1);
        RESULT_STR VARCHAR2(4000);
        LEN INT;
    BEGIN

        LEN := LENGTH(WORD);

        FOR I IN 1 .. len LOOP 
            XCHR := substr(WORD, I, 1);

            IF REGEXP_LIKE (XCHR,'[A-Za-z]') THEN
                XCHR := MASKSTRING('M');

            ELSIF REGEXP_LIKE (XCHR,'[0-9]') THEN
                XCHR := MASKSTRING('N');
            ELSE
                XCHR := XCHR;
            END IF;

            RESULT_STR := RESULT_STR || XCHR;
        END LOOP;

        RETURN RESULT_STR;

    END SCRUBSTRING;



/*
    function maskDateString(dateMask varchar2) RETURN DATE PARALLEL_ENABLE as

    begin

        RANDOMDATE(dateMask varchar2, startDate varchar2, endDate varchar2) 

        return to_date(TO_CHAR(SYSDATE, dateMask), dateMask);

    end maskDateString;
*/

    FUNCTION MASKFIELDSTRINGVALUE(FIELDNAME IN VARCHAR2, FIELDVALUE IN VARCHAR2, MASKTYPE IN VARCHAR2, MASKVALUE IN VARCHAR2) 
        RETURN VARCHAR2 PARALLEL_ENABLE AS

        newfieldvalue VARCHAR2(4000);
        masktypeid VARCHAR2(100);

        masktypechar CHAR(1);
        filllengthstring VARCHAR2(100);
        filllength INT := 0;

    BEGIN
        masktypeid := UPPER(masktype);

        IF masktype = 'SCRUB' THEN
            newfieldvalue := SCRUBSTRING(fieldvalue);
        ELSIF masktype = 'MASK' THEN
            newfieldvalue := MASKSTRING(maskvalue);
        ELSIF masktype = 'FILL' THEN

            masktypechar := substr(maskvalue, 1, 1);
            filllengthstring := substr(maskvalue, 3, 100);

            IF filllengthstring IS NOT NULL AND LENGTH(filllengthstring) > 0 THEN
                filllength := TO_NUMBER(filllengthstring);
            END IF;

            newfieldvalue := FILLSTRING(masktypechar,filllength);

        ELSE
            newfieldvalue := fieldvalue;
        END IF;

        RETURN newfieldvalue;

    END MASKFIELDSTRINGVALUE;

    FUNCTION constanctstring(maskvalue IN VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE AS
    BEGIN
        --TODO:IMPLEMENT LOGIC
        RETURN maskvalue;
    END constanctstring;
    
END BFPS_DATAMASK;
/
