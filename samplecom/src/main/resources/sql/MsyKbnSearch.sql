SELECT
      a.`KBN_NM`
    , a.`KBN_MEI`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    MSY_KBN a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KBN_NM`)) = UPPER (:kbn_nm_full) 
    AND UPPER (:kbn_nm) LIKE UPPER (CONCAT ('%', TRIM(TRAILING ' ' FROM a.`KBN_NM`))) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KBN_MEI`)) LIKE UPPER (CONCAT ('%', :kbn_mei, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`KBN_NM`
