SELECT
      a.`COL_A`
    , a.`COL_B`
    , a.`COL_C`
    , a.`COL_D`
    , a.`COL_E`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T00_NOKEY a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COL_A`)) LIKE UPPER (CONCAT ('%', :col_a, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COL_B`)) LIKE UPPER (CONCAT ('%', :col_b, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COL_C`)) LIKE UPPER (CONCAT ('%', :col_c, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COL_D`)) = UPPER (:col_d_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COL_D`)) LIKE UPPER (CONCAT ('%', :col_d, '%')) 
    AND a.`COL_D` >= :col_d_1 
    AND a.`COL_D` <= :col_d_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COL_E`)) = UPPER (:col_e_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COL_E`)) LIKE UPPER (CONCAT ('%', :col_e, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`COL_D`
    , a.`COL_E`
