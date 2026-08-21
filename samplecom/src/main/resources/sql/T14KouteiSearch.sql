SELECT
      a."koutei_id" AS "koutei_id"
    , a."koutei_mei" AS "koutei_mei"
    , TRIM(TRAILING ' ' FROM a."kaishi_ymd") AS "kaishi_ymd"
    , TRIM(TRAILING ' ' FROM a."shuryo_ymd") AS "shuryo_ymd"
    , TRIM(TRAILING ' ' FROM a."sagyoku_cd") AS "sagyoku_cd"
    , a."oya_koutei_id" AS "oya_koutei_id"
    , (SELECT r0."koutei_mei" FROM T14_KOUTEI r0 WHERE r0."koutei_id" = a."oya_koutei_id") AS "oya_koutei_mei"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = CAST (a."insert_user_id" AS INTEGER)) AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r2."user_sei" FROM MHR_USER r2 WHERE r2."user_id" = CAST (a."update_user_id" AS INTEGER)) AS "update_user_sei"
FROM
    T14_KOUTEI a 
WHERE
    1 = 1 
    AND a."koutei_id" = CAST (:koutei_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."koutei_mei")) LIKE UPPER (CONCAT ('%', :koutei_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kaishi_ymd")) LIKE UPPER (CONCAT ('%', :kaishi_ymd, '%')) 
    AND a."kaishi_ymd" >= :kaishi_ymd_1 
    AND a."kaishi_ymd" <= :kaishi_ymd_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."shuryo_ymd")) LIKE UPPER (CONCAT ('%', :shuryo_ymd, '%')) 
    AND a."shuryo_ymd" >= :shuryo_ymd_1 
    AND a."shuryo_ymd" <= :shuryo_ymd_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."sagyoku_cd")) LIKE UPPER (CONCAT ('%', :sagyoku_cd, '%')) 
    AND a."oya_koutei_id" = CAST (:oya_koutei_id AS INTEGER) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."koutei_id"
