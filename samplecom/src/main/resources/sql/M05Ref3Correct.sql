SELECT
      a.`REF3_ID` AS `REF3_ID`
    , a.`REF3_MEI` AS `REF3_MEI`
    , TRIM(TRAILING ' ' FROM a.`DELETE_F`) AS `DELETE_F`
    , a.`TEKIYO_BI` AS `TEKIYO_BI`
    , a.`HAISHI_BI` AS `HAISHI_BI`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID` AS `INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID` AS `UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    M05_REF3 a 
WHERE
    1 = 1 
    AND IFNULL (a.DELETE_F, 0) != 1 
    AND IFNULL (a.TEKIYO_BI, sysdate()) <= sysdate() 
    AND DATE_ADD(IFNULL (a.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate() 
    AND a.`REF3_ID` = :ref_3_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`REF3_MEI`)) LIKE UPPER (CONCAT ('%', :ref_3_mei, '%')) 
    AND CASE WHEN TRIM(TRAILING ' ' FROM a.`DELETE_F`) IS NULL THEN '0' ELSE TO_CHAR (a.`DELETE_F`) END IN (:delete_f) 
    AND a.`TEKIYO_BI` = :tekiyo_bi 
    AND a.`TEKIYO_BI` >= :tekiyo_bi_1 
    AND a.`TEKIYO_BI` <= :tekiyo_bi_2 
    AND a.`HAISHI_BI` = :haishi_bi 
    AND a.`HAISHI_BI` >= :haishi_bi_1 
    AND a.`HAISHI_BI` <= :haishi_bi_2 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`REF3_ID`
