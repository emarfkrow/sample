SELECT
      a.`KOUTEI_ID` AS `KOUTEI_ID`
    , (SELECT r0.`KOUTEI_MEI` FROM T00_KOUTEI r0 WHERE r0.`KOUTEI_ID` = a.`KOUTEI_ID`) AS `KOUTEI_MEI`
    , a.`JISSEKI_BN` AS `JISSEKI_BN`
    , a.`JISSHI_BI` AS `JISSHI_BI`
    , a.`KANRYO_BI` AS `KANRYO_BI`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS `INSERT_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS `UPDATE_USER_ID`
    , (SELECT r2.`USER_SEI` FROM MHR_USER r2 WHERE r2.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T00_JISSEKI a 
WHERE
    1 = 1 
    AND a.`KOUTEI_ID` = :koutei_id 
    AND a.`JISSEKI_BN` = :jisseki_bn 
    AND a.`JISSHI_BI` = :jisshi_bi 
    AND a.`JISSHI_BI` >= :jisshi_bi_1 
    AND a.`JISSHI_BI` <= :jisshi_bi_2 
    AND a.`KANRYO_BI` = :kanryo_bi 
    AND a.`KANRYO_BI` >= :kanryo_bi_1 
    AND a.`KANRYO_BI` <= :kanryo_bi_2 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`)) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`)) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a.`KOUTEI_ID`
    , a.`JISSEKI_BN`
