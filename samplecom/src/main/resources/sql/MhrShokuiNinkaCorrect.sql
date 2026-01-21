SELECT
      a.`BUSHO_ID`
    , (SELECT r0.`BUSHO_MEI` FROM MHR_BUSHO r0 WHERE r0.`BUSHO_ID` = a.`BUSHO_ID`) AS `BUSHO_MEI`
    , a.`SHOKUI_ID`
    , (SELECT r1.`SHOKUI_MEI` FROM MHR_SHOKUI r1 WHERE r1.`SHOKUI_ID` = a.`SHOKUI_ID`) AS `SHOKUI_MEI`
    , a.`KINO_NM`
    , a.`KENGEN_KB`
    , a.`TEKIYO_BI` AS `TEKIYO_BI`
    , a.`HAISHI_BI` AS `HAISHI_BI`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r2.`USER_SEI` FROM MHR_USER r2 WHERE r2.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r3.`USER_SEI` FROM MHR_USER r3 WHERE r3.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    MHR_SHOKUI_NINKA a 
    INNER JOIN MHR_BUSHO c1 
        ON 1 = 1 
        AND IFNULL (c1.TEKIYO_BI, sysdate()) <= sysdate() 
        AND c1.BUSHO_ID = a.BUSHO_ID 
    INNER JOIN MHR_SHOKUI c2 
        ON 1 = 1 
        AND IFNULL (c2.TEKIYO_BI, sysdate()) <= sysdate() 
        AND c2.SHOKUI_ID = a.SHOKUI_ID 
WHERE
    1 = 1 
    AND IFNULL (a.TEKIYO_BI, sysdate()) <= sysdate() 
    AND a.`BUSHO_ID` = :busho_id 
    AND a.`SHOKUI_ID` = :shokui_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KINO_NM`)) = UPPER (:kino_nm_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`KINO_NM`)) LIKE UPPER (CONCAT ('%', :kino_nm, '%')) 
    AND TRIM(TRAILING ' ' FROM a.`KENGEN_KB`) IN (:kengen_kb) 
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
    a.`BUSHO_ID`
    , a.`SHOKUI_ID`
    , a.`KINO_NM`
