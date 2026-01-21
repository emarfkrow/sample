SELECT
      a.`REFER1_ID`
    , (SELECT r0.`REFER1_MEI` FROM TB1_REFER1 r0 WHERE r0.`REFER1_ID` = a.`REFER1_ID`) AS `REFER1_MEI`
    , a.`REFER2_ID`
    , (SELECT r1.`REFER2_MEI` FROM TB1_REFER2 r1 WHERE r1.`REFER2_ID` = a.`REFER2_ID`) AS `REFER2_MEI`
    , a.`REFER3_ID`
    , (SELECT r2.`REFER3_MEI` FROM TB1_REFER3 r2 WHERE r2.`REFER3_ID` = a.`REFER3_ID`) AS `REFER3_MEI`
    , a.`TEKIYO_BI` AS `TEKIYO_BI`
    , a.`COMBO2_INFO`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r3.`USER_SEI` FROM MHR_USER r3 WHERE r3.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r4.`USER_SEI` FROM MHR_USER r4 WHERE r4.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    TB1_COMBO2 a 
WHERE
    1 = 1 
    AND a.`REFER1_ID` = :refer_1_id 
    AND a.`REFER2_ID` = :refer_2_id 
    AND a.`REFER3_ID` = :refer_3_id 
    AND a.`TEKIYO_BI` = :tekiyo_bi 
    AND a.`TEKIYO_BI` >= :tekiyo_bi_1 
    AND a.`TEKIYO_BI` <= :tekiyo_bi_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COMBO2_INFO`)) LIKE UPPER (CONCAT ('%', :combo_2_info, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`REFER1_ID`
    , a.`REFER2_ID`
    , a.`REFER3_ID`
    , a.`TEKIYO_BI`
