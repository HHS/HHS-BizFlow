--------------------------------------------------------
--  File created - Thursday-October-24-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function HHS_FN_GET_BUSDAYSDIFF
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BIZFLOW"."HHS_FN_GET_BUSDAYSDIFF" (
	I_FROMDATE             IN      DATE
	, I_TODATE             IN      DATE
)
RETURN INT
IS
	V_DAYS INT;
    TEMP_DT DATE;
    TEMP_FROMDATE  DATE;
    TEMP_TODATE    DATE;
    MULTIPLIER    INT DEFAULT 1;
BEGIN
   TEMP_DT := I_FROMDATE;
   TEMP_FROMDATE :=I_FROMDATE;
   TEMP_TODATE := I_TODATE;

   IF TO_DATE(I_FROMDATE,'DD-MM-YY') > TO_DATE(I_TODATE,'DD-MM-YY') THEN
         TEMP_DT := I_TODATE;
         TEMP_TODATE := TEMP_FROMDATE;
         TEMP_FROMDATE := TEMP_DT;
         MULTIPLIER := -1;
   END IF;

    SELECT COUNT(1) INTO V_DAYS
        FROM CAL C INNER JOIN CALHEAD CH ON CH.DAYOFWEEK = C.DAYOFWEEK
        WHERE CH.DAYTYPE <> 'H'
            AND C.CALDTIME NOT IN (SELECT CALDTIME FROM MEMBERCAL WHERE DAYTYPE = 'H' AND MEMBERID = '0000000000') -- AND memberid = calendarID)
            AND C.CALDTIME > TEMP_FROMDATE
            AND C.CALDTIME <= TEMP_TODATE
            AND CH.MEMBERID = '0000000000';          
        RETURN NVL(V_DAYS, 0) * MULTIPLIER;
END;

/
