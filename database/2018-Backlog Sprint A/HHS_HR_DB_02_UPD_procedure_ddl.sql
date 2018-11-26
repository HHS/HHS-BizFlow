
SET DEFINE OFF;

--------------------------------------------------------
--  DDL for FUNCTION  DISTANCE
--------------------------------------------------------

create or replace FUNCTION FN_GET_DISTANCE (Lat1 IN NUMBER,
                                     Lon1 IN NUMBER,
                                     Lat2 IN NUMBER,
                                     Lon2 IN NUMBER,
                                     Radius IN NUMBER DEFAULT 3963) RETURN NUMBER IS
-- Convert degrees to radians
DegToRad NUMBER := 57.29577951;

BEGIN
  RETURN(NVL(Radius,0) * ACOS((sin(NVL(Lat1,0) / DegToRad) * SIN(NVL(Lat2,0) / DegToRad)) +
        (COS(NVL(Lat1,0) / DegToRad) * COS(NVL(Lat2,0) / DegToRad) *
         COS(NVL(Lon2,0) / DegToRad - NVL(Lon1,0)/ DegToRad))));
  
END;

/

create or replace Function FN_GET_SEARCH_ID ( t NUMBER)
   RETURN number
IS
  searchid number;
  maxserachid number;
  
  cursor c1 is
  SELECT SEARCH_ID FROM HHS_HR.LIST_SEARCH_CANDIDATE;
  cursor c2 is 
  SELECT max(SEARCH_ID)+ 1 FROM HHS_HR.LIST_SEARCH_CANDIDATE;
BEGIN

  open c1;
  fetch c1 into searchid;
  open c2;
  fetch c2 into maxserachid;

  if c1%notfound then
     searchid := 1000000000;
  else
    searchid := maxserachid;
  end if;

  close c1;
  close c2;

RETURN searchid;

EXCEPTION
WHEN OTHERS THEN
   raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
END;

/