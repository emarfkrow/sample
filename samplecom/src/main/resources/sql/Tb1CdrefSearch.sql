SELECT
      TRIM(TRAILING ' ' FROM a.`CDREF_CD`) AS `CDREF_CD`
    , a.`CDREF_MEI`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    TB1_CDREF a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`CDREF_CD`)) = UPPER (:cdref_cd_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`CDREF_CD`)) LIKE UPPER (CONCAT ('%', :cdref_cd, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`CDREF_MEI`)) LIKE UPPER (CONCAT ('%', :cdref_mei, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`CDREF_CD`
