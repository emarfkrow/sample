SELECT
      a.`SAIKI_ID`
    , a.`SAIKI_MEI`
    , a.`IDREF_ID`
    , (SELECT r0.`IDREF_MEI` FROM M04_ID r0 WHERE r0.`IDREF_ID` = a.`IDREF_ID`) AS `IDREF_MEI`
    , TRIM(TRAILING ' ' FROM a.`CDREF_CD`) AS `CDREF_CD`
    , (SELECT r1.`CDREF_MEI` FROM M04_CD r1 WHERE r1.`CDREF_CD` = a.`CDREF_CD`) AS `CDREF_MEI`
    , TRIM(TRAILING ' ' FROM a.`NOREF_NO`) AS `NOREF_NO`
    , (SELECT r2.`NOREF_MEI` FROM M04_NO r2 WHERE r2.`NOREF_NO` = a.`NOREF_NO`) AS `NOREF_MEI`
    , a.`IDBN_ID`
    , a.`IDBN_BN`
    , a.`OYA_SAIKI_ID`
    , (SELECT r3.`SAIKI_MEI` FROM M04_SAIKI r3 WHERE r3.`SAIKI_ID` = a.`OYA_SAIKI_ID`) AS `OYA_SAIKI_MEI`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r4.`USER_SEI` FROM MHR_USER r4 WHERE r4.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r5.`USER_SEI` FROM MHR_USER r5 WHERE r5.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    M04_SAIKI a 
WHERE
    1 = 1 
    AND a.`SAIKI_ID` = :saiki_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`SAIKI_MEI`)) LIKE UPPER (CONCAT ('%', :saiki_mei, '%')) 
    AND a.`IDREF_ID` = :idref_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`CDREF_CD`)) LIKE UPPER (CONCAT ('%', :cdref_cd, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`NOREF_NO`)) LIKE UPPER (CONCAT ('%', :noref_no, '%')) 
    AND a.`IDBN_ID` = :idbn_id 
    AND a.`IDBN_BN` = :idbn_bn 
    AND a.`OYA_SAIKI_ID` = :oya_saiki_id 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`SAIKI_ID`
