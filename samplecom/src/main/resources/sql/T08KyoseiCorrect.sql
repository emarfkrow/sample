SELECT
      a."kyosei_id" AS "kyosei_id"
    , a."kisei1_id" AS "kisei1_id"
    , a."kisei1_info" AS "kisei1_info"
    , a."kisei2_id" AS "kisei2_id"
    , a."kisei2_info" AS "kisei2_info"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r0."user_sei" FROM MHR_USER r0 WHERE r0."user_id" = a."insert_user_iduser_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = a."update_user_iduser_id") AS "update_user_sei"
FROM
    T08_KYOSEI a 
WHERE
    1 = 1 
    AND a."kyosei_id" = CAST (:kyosei_id AS INTEGER) 
    AND a."kisei1_id" = CAST (:kisei_1_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kisei1_info")) LIKE UPPER (CONCAT ('%', :kisei_1_info, '%')) 
    AND a."kisei2_id" = CAST (:kisei_2_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kisei2_info")) LIKE UPPER (CONCAT ('%', :kisei_2_info, '%')) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."kyosei_id"
