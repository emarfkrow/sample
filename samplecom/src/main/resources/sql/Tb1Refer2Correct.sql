SELECT
      a.`REFER2_ID`
    , a.`REFER2_MEI`
    , TRIM(TRAILING ' ' FROM a.`DELETE_F`) AS `DELETE_F`
    , a.`TEKIYO_BI` AS `TEKIYO_BI`
    , a.`HAISHI_BI` AS `HAISHI_BI`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    TB1_REFER2 a 
WHERE
    1 = 1 
    AND IFNULL (a.DELETE_F, 0) != 1 
    AND IFNULL (a.TEKIYO_BI, sysdate()) <= sysdate() 
    AND a.`REFER2_ID` = :refer_2_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`REFER2_MEI`)) LIKE UPPER (CONCAT ('%', :refer_2_mei, '%')) 
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
    AND EXISTS ( 
        SELECT
              * 
        FROM
            TB1_COMBO1 p 
        WHERE
            1 = 1 
            AND p.REFER1_ID = :refer_1_id 
            AND p.REFER2_ID = a.REFER2_ID 
    ) 
ORDER BY
    a.`REFER2_ID`
