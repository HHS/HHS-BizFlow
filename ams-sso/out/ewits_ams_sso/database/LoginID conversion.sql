/*
--  Update BizFlow Login ID with HHS ID.
--    bizflow.member.memberid = bizflow.memberinfo.customb
--    Conver Login ID from email to HHSID
--    By Taeho Lee on March 11, 2019
*/


-- Find user does not have memberinfo
SELECT COUNT(1) CNT
FROM MEMBER M
WHERE M.TYPE = 'U'
  AND NOT EXISTS (
            SELECT *
              FROM MEMBERINFO MI
             WHERE MI.MEMBERID = M.MEMBERID
             )
;

-- Find user does not have CUSTOMB OR loginid and customb is different
SELECT M.MEMBERID, M.NAME, M.LOGINID, MI.CUSTOMB
FROM BIZFLOW.MEMBER M
    LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
WHERE M.TYPE = 'U'
  AND ( 
        M.LOGINID != MI.CUSTOMB
        OR
        MI.CUSTOMB IS NULL
        )
;

--------------------------------------------------------------------------------------------------------------------------------
--Get user info (CUSTOMA: Admin Code, CUSTOMB: HHSID
SELECT M.LOGINID, M.DSCPT, MI.CUSTOMB, M.MEMBERID, M.NAME, M.EMAIL,  MI.MEMBERID as MIMEMBERID, MI.CUSTOMA,  MI.CUSTOMC, MI.CUSTOMD, MI.CUSTOME
  FROM MEMBER M
       LEFT OUTER JOIN MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
 WHERE 1=1
   --AND M.NAME LIKE '%Taeho%'
;


-- Backup current loginid to EMPNO
UPDATE MEMBER
   SET DSCPT = LOGINID
 WHERE TYPE = 'U'
   --AND NAME LIKE '%Tae%'
;

--COMMIT;

-- Update loginid with HHSID (CustomB)
UPDATE
(
    SELECT M.MEMBERID, M.NAME, M.LOGINID, M.EMAIL, MI.MEMBERID AS MI_MEMBERID, MI.CUSTOMA, MI.CUSTOMB, MI.CUSTOMC, MI.CUSTOMD, MI.CUSTOME
      FROM BIZFLOW.MEMBER M
        LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
    WHERE M.TYPE = 'U'
      AND MI.MEMBERID IS NOT NULL
      --AND UPPER(M.NAME) LIKE '%TAEHO%'
      
) T
   SET T.LOGINID = T.CUSTOMB
 WHERE T.CUSTOMB IS NOT NULL
   --AND T.NAME LIKE '%Taeho%'
;

--COMMIT;

--Rollback
UPDATE MEMBER
   SET LOGINID = DSCPT
 WHERE TYPE = 'U'
   AND DSCPT IS NOT NULL
   --AND NAME LIKE '%Taeho%'
;

