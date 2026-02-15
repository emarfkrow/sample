SELECT
      a.`TRANS_ID` AS `TRANS_ID`
    , a.`TRANS_BN` AS `TRANS_BN`
    , a.`TRANS_INFO` AS `TRANS_INFO`
    , a.`RIYU_TX` AS `RIYU_TX`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID` AS `INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID` AS `UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T03_TRANS_HIS a 
WHERE
    1 = 1 
    AND a.`TRANS_ID` = :trans_id 
    AND a.`TRANS_BN` = :trans_bn 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`TRANS_INFO`)) LIKE UPPER (CONCAT ('%', :trans_info, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`RIYU_TX`)) LIKE UPPER (CONCAT ('%', :riyu_tx, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`TRANS_ID`
    , a.`TRANS_BN`
