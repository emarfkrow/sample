SELECT
      a.`FLOW_ID` AS `FLOW_ID`
    , a.`TABLE_NM` AS `TABLE_NM`
    , a.`PRIMARY_KEYS` AS `PRIMARY_KEYS`
    , a.`STATUS_KB` AS `STATUS_KB`
    , LEFT(DATE_FORMAT (a.`KESSAI_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `KESSAI_TS`
    , a.`KESSAI_ID` AS `KESSAI_ID`
    , a.`KESSAI_TX` AS `KESSAI_TX`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS `INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS `UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T03_STATUS_KB a 
WHERE
    1 = 1 
    AND a.`FLOW_ID` = :flow_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`TABLE_NM`)) LIKE UPPER (CONCAT ('%', :table_nm, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`PRIMARY_KEYS`)) LIKE UPPER (CONCAT ('%', :primary_keys, '%')) 
    AND TRIM(TRAILING ' ' FROM a.`STATUS_KB`) IN (:status_kb) 
    AND a.`KESSAI_TS` = :kessai_ts 
    AND a.`KESSAI_TS` >= :kessai_ts_1 
    AND a.`KESSAI_TS` <= :kessai_ts_2 
    AND a.`KESSAI_ID` = :kessai_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KESSAI_TX`)) LIKE UPPER (CONCAT ('%', :kessai_tx, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`)) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`)) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a.`FLOW_ID`
