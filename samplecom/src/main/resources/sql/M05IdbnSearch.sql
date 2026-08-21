SELECT
      a."idref_id" AS "idref_id"
    , (SELECT r0."idref_mei" FROM M05_ID r0 WHERE r0."idref_id" = a."idref_id") AS "idref_mei"
    , a."idbn_bn" AS "idbn_bn"
    , TRIM(TRAILING ' ' FROM a."idbn_no") AS "idbn_no"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = CAST (a."insert_user_id" AS INTEGER)) AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r2."user_sei" FROM MHR_USER r2 WHERE r2."user_id" = CAST (a."update_user_id" AS INTEGER)) AS "update_user_sei"
FROM
    M05_IDBN a 
WHERE
    1 = 1 
    AND a."idref_id" = CAST (:idref_id AS INTEGER) 
    AND a."idbn_bn" = CAST (:idbn_bn AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."idbn_no")) LIKE UPPER (CONCAT ('%', :idbn_no, '%')) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."idref_id"
    , a."idbn_bn"
