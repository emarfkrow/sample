SELECT
      a."ref2_id" AS "ref2_id"
    , a."ref2_mei" AS "ref2_mei"
    , TRIM(TRAILING ' ' FROM a."delete_f") AS "delete_f"
    , TO_CHAR (a."tekiyo_bi", 'YYYY-MM-DD') AS "tekiyo_bi"
    , TO_CHAR (a."haishi_bi", 'YYYY-MM-DD') AS "haishi_bi"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r0."user_sei" FROM MHR_USER r0 WHERE r0."user_id" = a."insert_user_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = a."update_user_id") AS "update_user_sei"
FROM
    M04_REF2 a 
WHERE
    1 = 1 
    AND IFNULL (a.DELETE_F, 0) != 1 
    AND IFNULL (a.TEKIYO_BI, sysdate()) <= sysdate() 
    AND DATE_ADD(IFNULL (a.HAISHI_BI, sysdate()), INTERVAL 1 DAY) > sysdate() 
    AND a."ref2_id" = CAST (:ref_2_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."ref2_mei")) LIKE UPPER (CONCAT ('%', :ref_2_mei, '%')) 
    AND CASE WHEN TRIM(TRAILING ' ' FROM a."delete_f") IS NULL THEN '0' ELSE TO_CHAR (a."delete_f") END IN (:delete_f) 
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
    AND EXISTS ( 
        SELECT
              * 
        FROM
            T04_COMP1 p 
        WHERE
            1 = 1 
            AND p.REF1_ID = :ref_1_id 
            AND p.REF2_ID = a.REF2_ID 
    ) 
ORDER BY
    a."ref2_id"
