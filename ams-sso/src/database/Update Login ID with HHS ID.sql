/*
    Update BizFlow Login ID with HHS ID.
    bizflow.member.memberid = bizflow.memberinfo.customb
*/

--------------------------------------------------------------------------------
-- BACKUP 
UPDATE
(
    SELECT M.MEMBERID, M.NAME, M.LOGINID, M.EMAIL, MI.MEMBERID AS MI_MEMBERID, MI.CUSTOMA, MI.CUSTOMB, MI.CUSTOMC, MI.CUSTOMD, MI.CUSTOME
      FROM BIZFLOW.MEMBER M
           LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
     WHERE M.TYPE = 'U'
       AND MI.CUSTOMB IS NOT NULL
      
) T
SET T.CUSTOME = T.LOGINID
;
/
ROLLBACK;

--------------------------------------------------------------------------------
-- CONVERT 
UPDATE
(
    SELECT M.MEMBERID, M.NAME, M.LOGINID, M.EMAIL, MI.MEMBERID AS MI_MEMBERID, MI.CUSTOMA, MI.CUSTOMB, MI.CUSTOMC, MI.CUSTOMD, MI.CUSTOME
      FROM BIZFLOW.MEMBER M
           LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
     WHERE M.TYPE = 'U'
       AND MI.CUSTOMB IS NOT NULL
      
) T
SET T.LOGINID = T.CUSTOMB
;
/
ROLLBACK;

--------------------------------------------------------------------------------
-- ROLLBACK
/*

UPDATE
(
    SELECT M.MEMBERID, M.NAME, M.LOGINID, M.EMAIL, MI.MEMBERID AS MI_MEMBERID, MI.CUSTOMA, MI.CUSTOMB, MI.CUSTOMC, MI.CUSTOMD, MI.CUSTOME
      FROM BIZFLOW.MEMBER M
           LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
    WHERE M.TYPE = 'U'
      AND MI.CUSTOMB IS NOT NULL
      AND MI.CUSTOME IS NOT NULL
      
) T
SET T.LOGINID = T.CUSTOME
;

*/

--------------------------------------------------------------------------------

/*
 
-- Finding Users having multiple BizFlow accounts with same HHSID
SELECT M.MEMBERID, M.NAME, M.LOGINID, M.STATE, MI.CUSTOMA, MI.CUSTOMB, MI.CUSTOMC, MI.CUSTOMD, MI.CUSTOME, m.PASSWDDTIME
  FROM BIZFLOW.MEMBER M
       LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
 WHERE M.MEMBERID IN ( 
                        SELECT MEMBERID
                          FROM MEMBERINFO
                         WHERE CUSTOMB IN ( 
                                             SELECT CUSTOMB
                                              FROM BIZFLOW.MEMBERINFO
                                             WHERE CUSTOMB IS NOT NULL
                                             GROUP BY CUSTOMB
                                             HAVING COUNT(*) > 1
                                          )
                                                  
                    )
  ORDER BY CUSTOMB, MEMBERID DESC 
;

-- Find login IDs having no MEMBERINFO
SELECT M.MEMBERID, M.NAME, M.LOGINID, MI.CUSTOMB
  FROM BIZFLOW.MEMBER M
       LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
 WHERE NOT EXISTS (
                        SELECT *
                          FROM MEMBERINFO MI 
                          WHERE MI.MEMBERID = M.MEMBERID
                   )
   AND M.TYPE = 'U'
ORDER BY NAME
;


-- Find login IDs having no HHSID ----------------------------------------------------------------------------------------------
SELECT M.MEMBERID, M.NAME, M.LOGINID, MI.CUSTOMB
FROM BIZFLOW.MEMBER M
    LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
WHERE M.TYPE = 'U'
  AND MI.CUSTOMB IS NULL
;


-- Find logind IDs need to be converted to HHSID -------------------------------------------------------------------------------
SELECT M.MEMBERID, M.NAME, M.LOGINID, MI.CUSTOMB
FROM BIZFLOW.MEMBER M
    LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
WHERE M.TYPE = 'U'
  AND ( 
        M.LOGINID != MI.CUSTOMB
        AND
        MI.CUSTOMB IS NOT NULL
        )
;


SELECT M.MEMBERID, M.NAME, M.LOGINID, M.EMAIL, MI.MEMBERID AS MI_MEMBERID, MI.CUSTOMA, MI.CUSTOMB, MI.CUSTOMC, MI.CUSTOMD, MI.CUSTOME
  FROM BIZFLOW.MEMBER M
    LEFT OUTER JOIN BIZFLOW.MEMBERINFO MI ON MI.MEMBERID = M.MEMBERID
WHERE M.TYPE = 'U'
  AND MI.CUSTOMB IS NOT NULL
  AND M.MEMBERID = '0000044014'
;

*/