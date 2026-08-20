SELECT
      a."busho_id" AS "busho_id"
    , (SELECT r0."busho_mei" FROM MHR_BUSHO r0 WHERE r0."busho_id" = a."busho_idbusho_id") AS "busho_mei"
    , a."shokui_id" AS "shokui_id"
    , (SELECT r1."shokui_mei" FROM MHR_SHOKUI r1 WHERE r1."shokui_id" = a."shokui_idshokui_id") AS "shokui_mei"
    , a."table_re" AS "table_re"
    , a."kengen_b" AS "kengen_b"
    , TO_CHAR (a."tekiyo_bi", 'YYYY-MM-DD') AS "tekiyo_bi"
    , TO_CHAR (a."haishi_bi", 'YYYY-MM-DD') AS "haishi_bi"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r2."user_sei" FROM MHR_USER r2 WHERE r2."user_id" = a."insert_user_iduser_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r3."user_sei" FROM MHR_USER r3 WHERE r3."user_id" = a."update_user_iduser_id") AS "update_user_sei"
FROM
    MHR_SHOKUI_NINKA a 
    INNER JOIN MHR_BUSHO c1 
        ON 1 = 1 
        AND IFNULL (c1.TEKIYO_BI, sysdate()) <= sysdate() 
        AND DATE_ADD(IFNULL (c1.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate()
        AND c1.BUSHO_ID = a.BUSHO_ID 
    INNER JOIN MHR_SHOKUI c2 
        ON 1 = 1 
        AND IFNULL (c2.TEKIYO_BI, sysdate()) <= sysdate() 
        AND DATE_ADD(IFNULL (c2.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate()
        AND c2.SHOKUI_ID = a.SHOKUI_ID 
WHERE
    1 = 1 
    AND IFNULL (a.TEKIYO_BI, sysdate()) <= sysdate() 
    AND DATE_ADD(IFNULL (a.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate() 
    AND a."busho_id" = CAST (:busho_id AS INTEGER) 
    AND a."shokui_id" = CAST (:shokui_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."table_re")) = UPPER (:table_re_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."table_re")) LIKE UPPER (CONCAT ('%', :table_re, '%')) 
    AND a."kengen_b" = CAST (:kengen_b AS INTEGER) 
    AND a."tekiyo_bi" = TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."tekiyo_bi" >= TO_DATE (SUBSTR (:tekiyo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."tekiyo_bi" <= TO_DATE (SUBSTR (:tekiyo_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."haishi_bi" = TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."haishi_bi" >= TO_DATE (SUBSTR (:haishi_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."haishi_bi" <= TO_DATE (SUBSTR (:haishi_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."busho_id"
    , a."shokui_id"
    , a."table_re"
