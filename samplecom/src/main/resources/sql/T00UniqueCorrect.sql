SELECT
      a.`A_MEI` AS `A_MEI`
    , a.`B_MEI` AS `B_MEI`
    , a.`C_MEI` AS `C_MEI`
    , a.`D_MEI` AS `D_MEI`
    , a.`E_MEI` AS `E_MEI`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS `INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS `UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T00_UNIQUE a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`A_MEI`)) LIKE UPPER (CONCAT ('%', :a_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`B_MEI`)) LIKE UPPER (CONCAT ('%', :b_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`C_MEI`)) LIKE UPPER (CONCAT ('%', :c_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`D_MEI`)) = UPPER (:d_mei_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`D_MEI`)) LIKE UPPER (CONCAT ('%', :d_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`E_MEI`)) = UPPER (:e_mei_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`E_MEI`)) LIKE UPPER (CONCAT ('%', :e_mei, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`)) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`)) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a.`D_MEI`
    , a.`E_MEI`
