SELECT
      a.`KBN_NM`
    , (SELECT r0.`KBN_MEI` FROM MSY_KBN r0 WHERE r0.`KBN_NM` = a.`KBN_NM`) AS `KBN_MEI`
    , a.`KBN_VAL`
    , a.`KBN_VAL_MEI`
    , a.`HYOJI_ON`
    , a.`CRITERIA`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r2.`USER_SEI` FROM MHR_USER r2 WHERE r2.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    MSY_KBN_VAL a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KBN_NM`)) = UPPER (:kbn_nm_full) 
    AND UPPER (:kbn_nm) LIKE UPPER (CONCAT ('%', TRIM(TRAILING ' ' FROM a.`KBN_NM`))) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KBN_VAL`)) = UPPER (:kbn_val_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KBN_VAL`)) LIKE UPPER (CONCAT ('%', :kbn_val, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KBN_VAL_MEI`)) LIKE UPPER (CONCAT ('%', :kbn_val_mei, '%')) 
    AND a.`HYOJI_ON` = :hyoji_on 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`CRITERIA`)) LIKE UPPER (CONCAT ('%', :criteria, '%')) 
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
    , a.`KBN_VAL`
    , a.`HYOJI_ON`
