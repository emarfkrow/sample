SELECT
      a.`KYOSEI_ID` AS `KYOSEI_ID`
    , a.`KISEI1_ID` AS `KISEI1_ID`
    , a.`KISEI1_INFO` AS `KISEI1_INFO`
    , a.`KISEI2_ID` AS `KISEI2_ID`
    , a.`KISEI2_INFO` AS `KISEI2_INFO`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID` AS `INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID` AS `UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T08_KYOSEI a 
WHERE
    1 = 1 
    AND a.`KYOSEI_ID` = :kyosei_id 
    AND a.`KISEI1_ID` = :kisei_1_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KISEI1_INFO`)) LIKE UPPER (CONCAT ('%', :kisei_1_info, '%')) 
    AND a.`KISEI2_ID` = :kisei_2_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KISEI2_INFO`)) LIKE UPPER (CONCAT ('%', :kisei_2_info, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`KYOSEI_ID`
