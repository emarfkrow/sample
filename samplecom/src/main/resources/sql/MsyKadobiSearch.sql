SELECT
      TRIM(TRAILING ' ' FROM a."kado_ymd") AS "kado_ymd"
    , a."busho_id" AS "busho_id"
    , (SELECT r0."busho_mei" FROM MHR_BUSHO r0 WHERE r0."busho_id" = a."busho_id") AS "busho_mei"
    , TRIM(TRAILING ' ' FROM a."kadobi_f") AS "kadobi_f"
    , a."memo" AS "memo"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = a."insert_user_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r2."user_sei" FROM MHR_USER r2 WHERE r2."user_id" = a."update_user_id") AS "update_user_sei"
FROM
    MSY_KADOBI a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kado_ymd")) = UPPER (:kado_ymd_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kado_ymd")) LIKE UPPER (CONCAT ('%', :kado_ymd, '%')) 
    AND a."kado_ymd" >= :kado_ymd_1 
    AND a."kado_ymd" <= :kado_ymd_2 
    AND a."busho_id" = CAST (:busho_id AS INTEGER) 
    AND CASE WHEN TRIM(TRAILING ' ' FROM a."kadobi_f") IS NULL THEN '0' ELSE TO_CHAR (a."kadobi_f") END IN (:kadobi_f) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."memo")) LIKE UPPER (CONCAT ('%', :memo, '%')) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."kado_ymd"
    , a."busho_id"
