SELECT
      a."BUSHO_ID" AS "BUSHO_ID"
    , (SELECT r0."BUSHO_MEI" FROM MHR_BUSHO r0 WHERE r0."BUSHO_ID" = a."BUSHO_ID") AS "BUSHO_MEI"
    , a."SHOKUI_ID" AS "SHOKUI_ID"
    , (SELECT r1."SHOKUI_MEI" FROM MHR_SHOKUI r1 WHERE r1."SHOKUI_ID" = a."SHOKUI_ID") AS "SHOKUI_MEI"
    , a."TABLE_RE" AS "TABLE_RE"
    , a."KENGEN_B" AS "KENGEN_B"
    , TO_CHAR (a."TEKIYO_BI", 'YYYY-MM-DD') AS "TEKIYO_BI"
    , TO_CHAR (a."HAISHI_BI", 'YYYY-MM-DD') AS "HAISHI_BI"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r2."USER_SEI" FROM MHR_USER r2 WHERE r2."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r3."USER_SEI" FROM MHR_USER r3 WHERE r3."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    MHR_SHOKUI_NINKA a 
    INNER JOIN MHR_BUSHO c1 
        ON 1 = 1 
        AND NVL (c1.TEKIYO_BI, SYSDATE) <= SYSDATE 
        AND NVL (c1.HAISHI_BI, SYSDATE) + 1 > SYSDATE
        AND c1.BUSHO_ID = a.BUSHO_ID 
    INNER JOIN MHR_SHOKUI c2 
        ON 1 = 1 
        AND NVL (c2.TEKIYO_BI, SYSDATE) <= SYSDATE 
        AND NVL (c2.HAISHI_BI, SYSDATE) + 1 > SYSDATE
        AND c2.SHOKUI_ID = a.SHOKUI_ID 
WHERE
    1 = 1 
    AND NVL (a.TEKIYO_BI, SYSDATE) <= SYSDATE 
    AND NVL (a.HAISHI_BI, SYSDATE) + 1 > SYSDATE 
    AND a."BUSHO_ID" = :busho_id 
    AND a."SHOKUI_ID" = :shokui_id 
    AND UPPER (RTRIM (RTRIM (a."TABLE_RE"), '　')) = UPPER (:table_re_full) 
    AND UPPER (RTRIM (RTRIM (a."TABLE_RE"), '　')) LIKE UPPER ('%' || :table_re || '%') 
    AND a."KENGEN_B" = :kengen_b 
    AND a."TEKIYO_BI" = TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."TEKIYO_BI" >= TO_DATE (SUBSTR (:tekiyo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."TEKIYO_BI" <= TO_DATE (SUBSTR (:tekiyo_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."HAISHI_BI" = TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."HAISHI_BI" >= TO_DATE (SUBSTR (:haishi_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."HAISHI_BI" <= TO_DATE (SUBSTR (:haishi_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."BUSHO_ID"
    , a."SHOKUI_ID"
    , a."TABLE_RE"
