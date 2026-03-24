SELECT
      a."REF1_ID" AS "REF1_ID"
    , (SELECT r0."REF1_MEI" FROM M05_REF1 r0 WHERE r0."REF1_ID" = a."REF1_ID") AS "REF1_MEI"
    , a."REF2_ID" AS "REF2_ID"
    , (SELECT r1."REF2_MEI" FROM M05_REF2 r1 WHERE r1."REF2_ID" = a."REF2_ID") AS "REF2_MEI"
    , a."COMP1_MEI" AS "COMP1_MEI"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r2."USER_SEI" FROM MHR_USER r2 WHERE r2."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r3."USER_SEI" FROM MHR_USER r3 WHERE r3."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    T05_COMP1 a 
    INNER JOIN M05_REF1 c1 
        ON 1 = 1 
        AND NVL (c1.DELETE_F, 0) != 1 
        AND NVL (c1.TEKIYO_BI, SYSDATE) <= SYSDATE 
        AND NVL (c1.HAISHI_BI, SYSDATE) + 1 > SYSDATE
        AND c1.REF1_ID = a.REF1_ID 
    INNER JOIN M05_REF2 c2 
        ON 1 = 1 
        AND NVL (c2.DELETE_F, 0) != 1 
        AND NVL (c2.TEKIYO_BI, SYSDATE) <= SYSDATE 
        AND NVL (c2.HAISHI_BI, SYSDATE) + 1 > SYSDATE
        AND c2.REF2_ID = a.REF2_ID 
WHERE
    1 = 1 
    AND a."REF1_ID" = :ref_1_id 
    AND a."REF2_ID" = :ref_2_id 
    AND UPPER (RTRIM (RTRIM (a."COMP1_MEI"), '　')) LIKE UPPER ('%' || :comp_1_mei || '%') 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."REF1_ID"
    , a."REF2_ID"
