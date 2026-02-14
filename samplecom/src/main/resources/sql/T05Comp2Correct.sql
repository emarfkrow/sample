SELECT
      a.`REF1_ID`
    , (SELECT r0.`REF1_MEI` FROM M05_REF1 r0 WHERE r0.`REF1_ID` = a.`REF1_ID`) AS `REF1_MEI`
    , a.`REF2_ID`
    , (SELECT r1.`REF2_MEI` FROM M05_REF2 r1 WHERE r1.`REF2_ID` = a.`REF2_ID`) AS `REF2_MEI`
    , a.`REF3_ID`
    , (SELECT r2.`REF3_MEI` FROM M05_REF3 r2 WHERE r2.`REF3_ID` = a.`REF3_ID`) AS `REF3_MEI`
    , a.`TEKIYO_BI` AS `TEKIYO_BI`
    , a.`COMP2_INFO`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r3.`USER_SEI` FROM MHR_USER r3 WHERE r3.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r4.`USER_SEI` FROM MHR_USER r4 WHERE r4.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    T05_COMP2 a 
    INNER JOIN M05_REF1 c1 
        ON 1 = 1 
        AND IFNULL (c1.DELETE_F, 0) != 1 
        AND IFNULL (c1.TEKIYO_BI, sysdate()) <= sysdate() 
        AND DATE_ADD(IFNULL (c1.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate()
        AND c1.REF1_ID = a.REF1_ID 
    INNER JOIN M05_REF2 c2 
        ON 1 = 1 
        AND IFNULL (c2.DELETE_F, 0) != 1 
        AND IFNULL (c2.TEKIYO_BI, sysdate()) <= sysdate() 
        AND DATE_ADD(IFNULL (c2.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate()
        AND c2.REF2_ID = a.REF2_ID 
    INNER JOIN M05_REF3 c3 
        ON 1 = 1 
        AND IFNULL (c3.DELETE_F, 0) != 1 
        AND IFNULL (c3.TEKIYO_BI, sysdate()) <= sysdate() 
        AND DATE_ADD(IFNULL (c3.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate()
        AND c3.REF3_ID = a.REF3_ID 
WHERE
    1 = 1 
    AND IFNULL (a.TEKIYO_BI, sysdate()) <= sysdate() 
    AND a.`REF1_ID` = :ref_1_id 
    AND a.`REF2_ID` = :ref_2_id 
    AND a.`REF3_ID` = :ref_3_id 
    AND a.`TEKIYO_BI` = :tekiyo_bi 
    AND a.`TEKIYO_BI` >= :tekiyo_bi_1 
    AND a.`TEKIYO_BI` <= :tekiyo_bi_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`COMP2_INFO`)) LIKE UPPER (CONCAT ('%', :comp_2_info, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`REF1_ID`
    , a.`REF2_ID`
    , a.`REF3_ID`
    , a.`TEKIYO_BI`
