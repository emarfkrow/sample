SELECT
      a."a_mei" AS "a_mei"
    , a."b_mei" AS "b_mei"
    , a."c_mei" AS "c_mei"
    , a."d_mei" AS "d_mei"
    , a."e_mei" AS "e_mei"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r0."user_sei" FROM MHR_USER r0 WHERE r0."user_id" = a."insert_user_iduser_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = a."update_user_iduser_id") AS "update_user_sei"
FROM
    T00_UNIQUE a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a."a_mei")) LIKE UPPER (CONCAT ('%', :a_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."b_mei")) LIKE UPPER (CONCAT ('%', :b_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."c_mei")) LIKE UPPER (CONCAT ('%', :c_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."d_mei")) = UPPER (:d_mei_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."d_mei")) LIKE UPPER (CONCAT ('%', :d_mei, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."e_mei")) = UPPER (:e_mei_full) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."e_mei")) LIKE UPPER (CONCAT ('%', :e_mei, '%')) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."d_mei"
    , a."e_mei"
