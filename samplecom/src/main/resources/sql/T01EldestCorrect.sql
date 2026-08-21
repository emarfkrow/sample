SELECT
      a."bro_id" AS "bro_id"
    , a."eldest_info" AS "eldest_info"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r0."user_sei" FROM MHR_USER r0 WHERE r0."user_id" = CAST (a."insert_user_id" AS INTEGER)) AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = CAST (a."update_user_id" AS INTEGER)) AS "update_user_sei"
FROM
    T01_ELDEST a 
WHERE
    1 = 1 
    AND a."bro_id" = CAST (:bro_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."eldest_info")) LIKE UPPER (CONCAT ('%', :eldest_info, '%')) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."bro_id"
