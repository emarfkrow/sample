SELECT
      a."kbn_nm" AS "kbn_nm"
    , (SELECT r0."kbn_mei" FROM MSY_KBN r0 WHERE r0."kbn_nm" = a."kbn_nmkbn_nm") AS "kbn_mei"
    , a."kbn_val" AS "kbn_val"
    , a."kbn_val_mei" AS "kbn_val_mei"
    , a."hyoji_on" AS "hyoji_on"
    , a."criteria" AS "criteria"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = a."insert_user_iduser_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r2."user_sei" FROM MHR_USER r2 WHERE r2."user_id" = a."update_user_iduser_id") AS "update_user_sei"
FROM
    MSY_KBN_VAL a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kbn_nm")) = UPPER (:kbn_nm_full) 
    AND UPPER (:kbn_nm) LIKE UPPER (CONCAT ('%', TRIM(TRAILING ' ' FROM a."kbn_nm"))) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kbn_val")) = UPPER (:kbn_val_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kbn_val")) LIKE UPPER (CONCAT ('%', :kbn_val, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kbn_val_mei")) LIKE UPPER (CONCAT ('%', :kbn_val_mei, '%')) 
    AND a."hyoji_on" = CAST (:hyoji_on AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."criteria")) LIKE UPPER (CONCAT ('%', :criteria, '%')) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."kbn_nm"
    , a."kbn_val"
    , a."hyoji_on"
