CREATE OR REPLACE package BFPS_DATAMASK as 

    ------------
    --  OVERVIEW
    --
    --------
    --  USAGE
    --
    --  This is a random number generator.  Do not use for cryptography.
    --
    --  By default, the package is initialized with the current user
    --  name, current time down to the second, and the current session.
    --
    --  If this package is seeded twice with the same seed, then accessed
    --  in the same way, it will produce the same results in both cases.
    --
    --------
    --  EXAMPLES
    --
    --  To initialize or reset the generator, call the seed procedure as in:
    --      execute hhshrworkflowpdaf.seed(12345678);
    --    or
    --      execute hhshrworkflowpdaf.seed(TO_CHAR(SYSDATE,'MM-DD-YYYY HH24:MI:SS'));
    --  To get the random number, simply call the function, e.g.
    --      my_random_real NUMBER;
    --      my_random_real := hhshrworkflowpdaf.ramdomPrecisionNumber;
    --  To use in SQL statements:
    --      select hhshrworkflowpdaf.ramdomPrecisionNumber from dual;
    --      insert into a values (hhshrworkflowpdaf.ramdomPrecisionNumber);
    --      variable x NUMBER;
    --      execute :x := hhshrworkflowpdaf.ramdomPrecisionNumber;
    --      update a set a2=a2+1 where a1 < :x;

/*

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

*/

    /**
    *   Common Dynamic Data Masking Library Section
    **/

    TYPE num_array IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;

    -- Initialization Section ------------------------------------------------------------
    -- Seed with a binary integer
    PROCEDURE seed(val IN BINARY_INTEGER);
    PRAGMA restrict_references (seed, WNDS);
    -- Seed with a string (up to length 2000)
    PROCEDURE seed(val IN VARCHAR2);
    PRAGMA restrict_references (seed, WNDS);


    -- Numberic Section ------------------------------------------------------------
    -- Get a random 38-digit precision number, 0.0 <= value < 1.0
    FUNCTION randomNumber RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA restrict_references (randomNumber, WNDS);
    -- get a random Oracle number x, low <= x < high
    FUNCTION randomNumber (low IN NUMBER, high IN NUMBER) RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA restrict_references (randomNumber, WNDS);
    -- get a random number from a normal distribution
    FUNCTION normal RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA restrict_references (normal, WNDS);


    -- Date Section ------------------------------------------------------------
    -- get a random date from 01/01/1990 to present
    FUNCTION randomDate RETURN DATE PARALLEL_ENABLE;
        PRAGMA restrict_references (randomDate, WNDS);
    -- get a random date between startDate (mm/dd/yyyy) and endDate (mm/dd/yyyy)
    FUNCTION randomDate(startDate varchar2, endDate varchar2) RETURN DATE PARALLEL_ENABLE;
        PRAGMA restrict_references (randomDate, WNDS);


    -- Email Section ------------------------------------------------------------
    FUNCTION randomEmail RETURN VARCHAR2 PARALLEL_ENABLE;    
        PRAGMA restrict_references (randomEmail, WNDS);
    FUNCTION randomEmail(domainName varchar2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA restrict_references (randomEmail, WNDS);

    -- Lookup Section ------------------------------------------------------------
    FUNCTION lookupString(items varchar2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA restrict_references (lookupString, WNDS);
    FUNCTION lookupDate(items varchar2) RETURN DATE PARALLEL_ENABLE;
        PRAGMA restrict_references (lookupDate, WNDS);
    FUNCTION lookupNumber(items varchar2) RETURN NUMBER PARALLEL_ENABLE;
        PRAGMA restrict_references (lookupNumber, WNDS);

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
    FUNCTION fillString (opt char, len NUMBER) RETURN VARCHAR2 PARALLEL_ENABLE;  -- string of <len> characters
        PRAGMA restrict_references (fillString, WNDS);
    -- get a random string
    -- "udmask" is a set of opt i.e) LLLnnHH
    FUNCTION maskString (udmask VARCHAR2) RETURN VARCHAR2 PARALLEL_ENABLE;  -- string of <len> characters
        PRAGMA restrict_references (maskString, WNDS);
    -- get a random string
    FUNCTION scrubString(word in varchar2)RETURN varchar2 PARALLEL_ENABLE;    
        PRAGMA restrict_references (scrubString, WNDS);
    -- get function string for Dynamic PL SQL block
    FUNCTION maskFieldStringValue(fieldName in varchar2, fieldValue in varchar2, maskType in varchar2, maskValue in varchar2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA restrict_references (maskFieldStringValue, WNDS);
    FUNCTION constanctString(maskValue in varchar2) RETURN VARCHAR2 PARALLEL_ENABLE;
        PRAGMA restrict_references (constanctString, WNDS);


end BFPS_DATAMASK;
/


CREATE OR REPLACE package body BFPS_DATAMASK as


    mem        num_array;           -- big internal state hidden from the user
    counter    BINARY_INTEGER := 55;-- counter through the results
    saved_norm NUMBER := NULL;      -- unused random normally distributed value
    need_init  BOOLEAN := TRUE;     -- do we still need to initialize


    -- Seed the random number generator with a binary_integer
    PROCEDURE seed(val IN BINARY_INTEGER) IS
    BEGIN
        seed(TO_CHAR(val));
    END seed;

    -- Seed the random number generator with a string.
    PROCEDURE seed(val IN VARCHAR2) IS
        junk     VARCHAR2(2000);
        piece    VARCHAR2(20);
        randval  NUMBER;
        mytemp   NUMBER;
        j        BINARY_INTEGER;
    BEGIN
        need_init   := FALSE;
        saved_norm  := NULL;
        counter     := 0;
        junk        := TO_SINGLE_BYTE(val);
        FOR i IN 0..54 LOOP
            piece   := SUBSTR(junk,1,19);
            randval := 0;
            j       := 1;

            -- convert 19 characters to a 38-digit number
            FOR j IN 1..19 LOOP
                randval := 1e2*randval + NVL(ASCII(SUBSTR(piece,j,1)),0.0);
            END LOOP;

            -- try to avoid lots of zeros
            randval := randval*1e-38+i*.01020304050607080910111213141516171819;
            mem(i)  := randval - TRUNC(randval);

            -- we've handled these first 19 characters already; move on
            junk    := SUBSTR(junk,20);
        END LOOP;

        randval := mem(54);

        FOR j IN 0..10 LOOP
            FOR i IN 0..54 LOOP

                -- barrelshift mem(i-1) by 24 digits
                randval := randval * 1e24;
                mytemp  := TRUNC(randval);
                randval := (randval - mytemp) + (mytemp * 1e-38);

                -- add it to mem(i)
                randval := mem(i)+randval;
                IF (randval >= 1.0) THEN
                    randval := randval - 1.0;
                END IF;

		-- record the result
                mem(i) := randval;
            END LOOP;
        END LOOP;
    END seed;

    -- Numberic Section ------------------------------------------------------------
    -- give values to the user
    -- Delayed Fibonacci
    FUNCTION randomNumber RETURN NUMBER  PARALLEL_ENABLE IS
    randval  NUMBER;
    BEGIN
        counter := counter + 1;
        IF counter >= 55 THEN
            --dbms_output.put_line('counter=' || to_char(counter));

            -- initialize if needed
            IF (need_init = TRUE) THEN
                seed(TO_CHAR(SYSDATE,'MM-DD-YYYY HH24:MI:SS') ||
                     USER || USERENV('SESSIONID'));
            ELSE
                -- need to generate 55 more results
                FOR i IN 0..30 LOOP
                    randval := mem(i+24) + mem(i);
                    IF (randval >= 1.0) THEN
                        randval := randval - 1.0;
                    END IF;
                    mem(i) := randval;
                    --dbms_output.put_line('mem1(' || to_char(i) || ')=' || randval);
                END LOOP;
                FOR i IN 31..54 LOOP
                    randval := mem(i-31) + mem(i);
                    IF (randval >= 1.0) THEN
                        randval := randval - 1.0;
                    END IF;
                    mem(i) := randval;
                    --dbms_output.put_line('mem2(' || to_char(i) || ')=' || randval);
                END LOOP;
            END IF;

            counter := 0;
        END IF;

        --dbms_output.put_line('VALUE counter=' || TO_CHAR(counter) || ', mem(counter)=' || TO_CHAR(mem(counter)));
        RETURN mem(counter);
    END randomNumber;

    -- Random 38-digit number between LOW and HIGH.
    FUNCTION randomNumber ( low in NUMBER, high in NUMBER) RETURN NUMBER 
                   PARALLEL_ENABLE is
    BEGIN
        RETURN (randomNumber*(high-low))+low;
    END randomNumber;

    -- Random numbers in a normal distribution.
    FUNCTION normal RETURN NUMBER PARALLEL_ENABLE is  
                    -- 38 decimal places: Mean 0, Variance 1
        v1  NUMBER;
        v2  NUMBER;
        r2  NUMBER;
        fac NUMBER;
    BEGIN
        IF saved_norm is not NULL THEN     -- saved from last time
            v1 := saved_norm;              -- to be returned this time
            saved_norm := NULL;
        ELSE
            r2 := 2;
            -- Find two independent uniform variables
            WHILE r2 > 1 OR r2 = 0 LOOP
                v1 := randomNumber();
                v1 := v1 + v1 - 1;
                v2 := randomNumber();
                v2 := v2 + v2 - 1;
                r2 := v1*v1 + v2*v2;  -- r2 is radius
            END LOOP;      -- 0 < r2 <= 1:  in unit circle
            /* Now derive two independent normally-distributed variables */
            fac := sqrt(-2*ln(r2)/r2);
            v1 := v1*fac;          -- to be returned this time
            saved_norm := v2*fac;  -- to be saved for next time
        END IF;
        RETURN v1;
    END  normal;


    -- Date Section ------------------------------------------------------------    
    FUNCTION randomDate RETURN DATE PARALLEL_ENABLE AS
    BEGIN

        RETURN randomDate('01/01/1990', to_char(sysdate, 'mm/dd/yyyy'));

    END randomDate;

    -- get a random date between startDate (mm/dd/yyyy) and endDate (mm/dd/yyyy)
    FUNCTION randomDate(startDate varchar2, endDate varchar2) RETURN DATE PARALLEL_ENABLE as
        dt DATE;
        dtStart DATE;
        dtEnd DATE;
    BEGIN
        --date format mm/dd/yyyy
        dtStart := to_date(startDate, 'mm/dd/yyyy');
        dtEnd := to_date(endDate, 'mm/dd/yyyy');

        dt := TO_DATE(
                              TRUNC(
                                    randomNumber(TO_CHAR(dtStart,'J'), TO_CHAR(dtEnd,'J'))
                                    ),'J'
                               );
        RETURN dt;

    END randomDate;


    -- Email Section ------------------------------------------------------------
    FUNCTION randomEmail RETURN VARCHAR2 PARALLEL_ENABLE as
    BEGIN

        return scrubString('aaaaa.aaaaa@aaaaa') || '.com';

    END randomEmail;

    FUNCTION randomEmail(domainName varchar2) RETURN VARCHAR2 PARALLEL_ENABLE as
    BEGIN

        return scrubString('aaaaa.aaaaa') || '@' || domainName;

    END randomEmail;

    -- Lookup Section ------------------------------------------------------------
    FUNCTION lookupString(items varchar2) RETURN VARCHAR2 PARALLEL_ENABLE AS
        selectedItem VARCHAR2(2000);
        idx NUMBER;
        noOfItems NUMBER;
    BEGIN
        noOfItems := REGEXP_COUNT(items, '\|') + 1;
        idx := TRUNC(randomNumber(1, noOfItems + 0.1));
        selectedItem := REGEXP_SUBSTR(items, '[^|]+', 1, idx);
        
        DBMS_OUTPUT.PUT_LINE('items=' || items || ', noOfItems=' || noOfItems || ' , idx=' || idx || ', selectedItem=' || selectedItem); 
        
        
        return selectedItem;
    END lookupString;

    FUNCTION lookupDate(items varchar2) RETURN DATE PARALLEL_ENABLE AS
        selectedItem VARCHAR2(2000);
    BEGIN
        selectedItem := lookupString(items);
        return TO_DATE(selectedItem, 'mm/dd/yyyy');
    END lookupDate;

    FUNCTION lookupNumber(items varchar2) RETURN NUMBER PARALLEL_ENABLE AS
        selectedItem VARCHAR2(2000);
    BEGIN
        selectedItem := lookupString(items);
        return TO_NUMBER(selectedItem);
    END lookupNumber;


    -- String Section ------------------------------------------------------------

    -- Random string.
    FUNCTION fillString (opt char, len NUMBER) 
        RETURN VARCHAR2 PARALLEL_ENABLE is      -- string of <len> characters  
        rng  NUMBER; 
        n    BINARY_INTEGER; 
        ccs  VARCHAR2 (128);    -- candidate character subset 
        xstr VARCHAR2 (4000) := NULL; 
    BEGIN 

        IF opt IS NULL THEN
            xstr := NULL;
        ELSIF opt = 'L' THEN --L : An uppercase Letter.	
            ccs := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
            rng := 26;
        ELSIF opt = 'l' THEN --l : A lowercase letter.	
            ccs := 'abcdefghijklmnopqrstuvwxyz'; 
            rng := 26;
        ELSIF opt = 'M' THEN --M : A letter (upper or lower).
            ccs := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
                    || 'abcdefghijklmnopqrstuvwxyz';
            rng := 52;
        ELSIF opt = 'V' THEN --V : An uppercase Vowel.
            ccs := 'AEIOU';
            rng := 5;
        ELSIF opt = 'v' THEN --v : A lowercase vowel.
            ccs := 'aeiou'; 
            rng := 5;
        ELSIF opt = 'W' THEN --W : A vowel (upper or lower).
            ccs := 'AEIOU'
                    || 'aeiou';
            rng := 10;
        ELSIF opt = 'C' THEN --C : An uppercase Consonant.	
            ccs := 'BCDFGHJKLMNPQRSTVWXYZ';
            rng := 21;
        ELSIF opt = 'c' THEN --c : A lowercase consonant.
            ccs := 'bcdfghjklmnpqrstvwxyz';
            rng := 21;
        ELSIF opt = 'E' THEN --E : A consonant (upper or lower).
            ccs := 'BCDFGHJKLMNPQRSTVWXYZ'
                    || 'bcdfghjklmnpqrstvwxyz';
            rng := 42;
        ELSIF opt = 'N' THEN --N : Any number, 0-9.
            ccs := '0123456789';
            rng := 10;        	
        ELSIF opt = 'n' THEN --N : Any number, 1-9.
            ccs := '123456789';
            rng := 9;
        ELSIF opt = 'H' THEN --H : An Hexidecimal number (0-F)
            ccs := '0123456789ABCDEF';
            rng := 16;
        ELSIF opt = 'X' THEN    --X: any alpha-numeric characters (upper) 
            ccs := '0123456789'
                  || 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
            rng := 36;
        ELSIF opt = 'x' THEN    --x: any alpha-numeric characters (lower) 
            ccs := '0123456789'
                  || 'abcdefghijklmnopqrstuvwxyz'; 
            rng := 36;
        ELSIF opt = 'Y' THEN    --Y: any alpha-numeric characters (lower) 
            ccs := '0123456789' 
                  || 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
                  || 'abcdefghijklmnopqrstuvwxyz'; 
            rng := 62;
        ELSIF opt = 'P' THEN    --P: any printable char (ASCII subset) 
            ccs := ' !"#$%&''()*+,-./' 
                    || '0123456789' 
                    || ':;<=>?@' 
                    || 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' 
                    || '[\]^_`' 
                    || 'abcdefghijklmnopqrstuvwxyz' 
                    || '{|}~' ; 
            rng := 95; 
        ELSE 
            ccs := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
            rng := 26;          -- default to upper case 
        END IF;

        FOR i IN 1 .. least(len,4000) LOOP 
            /* Get random integer within specified range */ 
            n := TRUNC(rng * randomNumber) + 1; 
            /* Append character to string  */ 
            xstr := xstr || SUBSTR(ccs,n,1); 
        END LOOP; 
        RETURN xstr; 

    END fillString; 

    -- Random string with given user defined mask
    FUNCTION maskString (udmask varchar2)
        RETURN VARCHAR2 PARALLEL_ENABLE is -- string of <len> characters 
        len  NUMBER;
        rng  NUMBER; 
        n    BINARY_INTEGER; 
        ccs  VARCHAR2 (128);    -- candidate character subset 
        xstr VARCHAR2 (4000) := NULL;
        xchr CHAR(1);
    BEGIN 

        --DBMS_OUTPUT.PUT_LINE('scrubing udmask=' || NVL(udmask, ''));

        IF udmask IS NULL THEN
            --DBMS_OUTPUT.PUT_LINE('DEBUG-A');
            xstr := NULL;
        ELSE 
            len := length(udmask);

            FOR i IN 1 .. len LOOP 

                xchr := substr(udmask, i, 1);

                IF xchr = 'u'
                    or xchr = 'L'
                    or xchr = 'l'
                    or xchr = 'M'
                    or xchr = 'V'
                    or xchr = 'v'
                    or xchr = 'W'
                    or xchr = 'C'
                    or xchr = 'c'
                    or xchr = 'E'
                    or xchr = 'N'
                    or xchr = 'n'
                    or xchr = 'H'
                    or xchr = 'X'
                    or xchr = 'x'
                    or xchr = 'Y'
                    or xchr = 'P' THEN

                    xchr := fillString(xchr, 1);

                ELSE

                    xchr := xchr;
                END IF;

                xstr := xstr || xchr;

            END LOOP;

        END IF; 

        --DBMS_OUTPUT.PUT_LINE('scrubbed=' || NVL(xstr, 'NULL') || '!!!');
        RETURN xstr; 
    END maskString;

    -- Replace word with ramdon alphanumeric letters.
    function scrubString(word in varchar2) return varchar2 PARALLEL_ENABLE as
        xchr char(1);
        xstr varchar2(4000);
        len int;
    begin

        len := length(word);

        FOR i IN 1 .. len LOOP 
            xchr := substr(word, i, 1);

            --dbms_output.put_line('xchr.0=[' || xchr || ']');
            if REGEXP_LIKE (xchr,'[A-Za-z]') then
                xchr := maskString('M');
                --dbms_output.put_line('xchr.1=[' || xchr || ']');

            elsif REGEXP_LIKE (xchr,'[0-9]') then
                xchr := maskString('N');
                --dbms_output.put_line('xchr.2=[' || xchr || ']');
            else
                xchr := xchr;
                --dbms_output.put_line('xchr.3=[' || xchr || ']');
            end if;

            xstr := xstr || xchr;
        END LOOP;

        return xstr;

    end scrubString;



/*
    function maskDateString(dateMask varchar2) RETURN DATE PARALLEL_ENABLE as

    begin

        randomDate(dateMask varchar2, startDate varchar2, endDate varchar2) 

        return to_date(to_char(sysdate, dateMask), dateMask);

    end maskDateString;
*/



    function maskFieldStringValue(fieldName in varchar2, fieldValue in varchar2, maskType in varchar2, maskValue in varchar2) 
        RETURN VARCHAR2 PARALLEL_ENABLE as

        newFieldValue VARCHAR2(4000);
        maskTypeID VARCHAR2(100);

        maskTypeChar CHAR(1);
        fillLengthString VARCHAR2(100);
        fillLength int := 0;

    begin
        maskTypeId := UPPER(maskType);

        --DBMS_OUTPUT.PUT_LINE('maskFieldStringValue-maskValue=' || maskValue);

        IF maskType = 'SCRUB' THEN
            newFieldValue := scrubString(fieldValue);
        ELSIF maskType = 'MASK' THEN
            newFieldValue := maskString(maskValue);
        ELSIF maskType = 'FILL' THEN

            maskTypeChar := SUBSTR(maskValue, 1, 1);
            fillLengthString := SUBSTR(maskValue, 3, 100);
            --DBMS_OUTPUT.PUT_LINE('maskValue=' || maskValue ||', maskTypeChar=' || maskTypeChar || ', fillLengthString=' || fillLengthString);

            IF fillLengthString IS NOT NULL and length(fillLengthString) > 0 THEN
                fillLength := TO_NUMBER(fillLengthString);
            ELSE
                DBMS_OUTPUT.PUT_LINE('fillLengthString is null or empty.');
            END IF;

            newFieldValue := fillString(maskTypeChar,fillLength);

        ELSE
            newFieldValue := fieldValue;
        END IF;

        return newFieldValue;

    end maskFieldStringValue;

    FUNCTION constanctString(maskValue in varchar2) RETURN VARCHAR2 PARALLEL_ENABLE as
    BEGIN
        return maskValue;
    END constanctString;
    
end BFPS_DATAMASK;
/
