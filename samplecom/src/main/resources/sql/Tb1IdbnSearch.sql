SELECT
      a.`IDREF_ID`
    , (SELECT r0.`IDREF_MEI` FROM TB1_IDREF r0 WHERE r0.`IDREF_ID` = a.`IDREF_ID`) AS `IDREF_MEI`
    , a.`IDBN_BN`
    , TRIM(TRAILING ' ' FROM a.`IDBN_NO`) AS `IDBN_NO`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r2.`USER_SEI` FROM MHR_USER r2 WHERE r2.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    TB1_IDBN a 
WHERE
    1 = 1 
    AND a.`IDREF_ID` = :idref_id 
    AND a.`IDBN_BN` = :idbn_bn 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`IDBN_NO`)) LIKE UPPER (CONCAT ('%', :idbn_no, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`IDREF_ID`
    , a.`IDBN_BN`
