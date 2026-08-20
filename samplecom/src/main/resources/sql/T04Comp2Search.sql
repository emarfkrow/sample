SELECT
      a."ref1_id" AS "ref1_id"
    , (SELECT r0."ref1_mei" FROM M04_REF1 r0 WHERE r0."ref1_id" = a."ref1_idref1_id") AS "ref1_mei"
    , a."ref2_id" AS "ref2_id"
    , (SELECT r1."ref2_mei" FROM M04_REF2 r1 WHERE r1."ref2_id" = a."ref2_idref2_id") AS "ref2_mei"
    , a."ref3_id" AS "ref3_id"
    , (SELECT r2."ref3_mei" FROM M04_REF3 r2 WHERE r2."ref3_id" = a."ref3_idref3_id") AS "ref3_mei"
    , TO_CHAR (a."tekiyo_bi", 'YYYY-MM-DD') AS "tekiyo_bi"
    , a."comp2_info" AS "comp2_info"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r3."user_sei" FROM MHR_USER r3 WHERE r3."user_id" = a."insert_user_iduser_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r4."user_sei" FROM MHR_USER r4 WHERE r4."user_id" = a."update_user_iduser_id") AS "update_user_sei"
FROM
    T04_COMP2 a 
WHERE
    1 = 1 
    AND a."ref1_id" = CAST (:ref_1_id AS INTEGER) 
    AND a."ref2_id" = CAST (:ref_2_id AS INTEGER) 
    AND a."ref3_id" = CAST (:ref_3_id AS INTEGER) 
    AND a."tekiyo_bi" = TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."tekiyo_bi" >= TO_DATE (SUBSTR (:tekiyo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."tekiyo_bi" <= TO_DATE (SUBSTR (:tekiyo_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND UPPER (TRIM(TRAILING ' ' FROM a."comp2_info")) LIKE UPPER (CONCAT ('%', :comp_2_info, '%')) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."ref1_id"
    , a."ref2_id"
    , a."ref3_id"
    , a."tekiyo_bi"
