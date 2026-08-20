SELECT
      a.`KOUTEI_ID` AS `KOUTEI_ID`
    , (SELECT r0.`KOUTEI_MEI` FROM T14_KOUTEI r0 WHERE r0.`KOUTEI_ID` = a.`KOUTEI_ID`) AS `KOUTEI_MEI`
    , a.`JISSEKI_BN` AS `JISSEKI_BN`
    , TRIM(TRAILING ' ' FROM a.`JISSHI_YMD`) AS `JISSHI_YMD`
    , TRIM(TRAILING ' ' FROM a.`KANRYO_YMD`) AS `KANRYO_YMD`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS `INSERT_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS `UPDATE_USER_ID`
    , (SELECT r2.`USER_SEI` FROM MHR_USER r2 WHERE r2.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T14_JISSEKI a 
WHERE
    1 = 1 
    AND a.`KOUTEI_ID` = :koutei_id 
    AND a.`JISSEKI_BN` = :jisseki_bn 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`JISSHI_YMD`)) LIKE UPPER (CONCAT ('%', :jisshi_ymd, '%')) 
    AND a.`JISSHI_YMD` >= :jisshi_ymd_1 
    AND a.`JISSHI_YMD` <= :jisshi_ymd_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KANRYO_YMD`)) LIKE UPPER (CONCAT ('%', :kanryo_ymd, '%')) 
    AND a.`KANRYO_YMD` >= :kanryo_ymd_1 
    AND a.`KANRYO_YMD` <= :kanryo_ymd_2 
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
