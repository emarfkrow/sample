SELECT
      a.`USER_ID`
    , a.`USER_SEI`
    , a.`USER_MEI`
    , a.`E_MAIL`
    , a.`PASSWORD`
    , a.`TEKIYO_BI` AS `TEKIYO_BI`
    , a.`HAISHI_BI` AS `HAISHI_BI`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    MHR_USER a 
WHERE
    1 = 1 
    AND IFNULL (a.TEKIYO_BI, sysdate()) <= sysdate() 
    AND a.`USER_ID` = :user_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`USER_SEI`)) LIKE UPPER (CONCAT ('%', :user_sei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`USER_MEI`)) LIKE UPPER (CONCAT ('%', :user_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`E_MAIL`)) LIKE UPPER (CONCAT ('%', :e_mail, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`PASSWORD`)) LIKE UPPER (CONCAT ('%', :password, '%')) 
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
    a.`USER_ID`
