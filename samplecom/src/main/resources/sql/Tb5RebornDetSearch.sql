SELECT
      a.`REBORN_ID`
    , a.`REBORN_BN`
    , a.`PREV_DET_INFO`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    TB5_REBORN_DET a 
WHERE
    1 = 1 
    AND a.`REBORN_ID` = :reborn_id 
    AND a.`REBORN_BN` = :reborn_bn 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`PREV_DET_INFO`)) LIKE UPPER (CONCAT ('%', :prev_det_info, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`REBORN_ID`
    , a.`REBORN_BN`
