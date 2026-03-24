SELECT
      a.`REF1_ID` AS `REF1_ID`
    , (SELECT r0.`REF1_MEI` FROM M05_REF1 r0 WHERE r0.`REF1_ID` = a.`REF1_ID`) AS `REF1_MEI`
    , a.`REF2_ID` AS `REF2_ID`
    , (SELECT r1.`REF2_MEI` FROM M05_REF2 r1 WHERE r1.`REF2_ID` = a.`REF2_ID`) AS `REF2_MEI`
    , a.`COMP1_MEI` AS `COMP1_MEI`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID` AS `INSERT_USER_ID`
    , (SELECT r2.`USER_SEI` FROM MHR_USER r2 WHERE r2.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID` AS `UPDATE_USER_ID`
    , (SELECT r3.`USER_SEI` FROM MHR_USER r3 WHERE r3.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T05_COMP1 a 
WHERE
    1 = 1 
    AND a.`REF1_ID` = :ref_1_id 
    AND a.`REF2_ID` = :ref_2_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COMP1_MEI`)) LIKE UPPER (CONCAT ('%', :comp_1_mei, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`REF1_ID`
    , a.`REF2_ID`
