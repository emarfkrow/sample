SELECT
      a."saiki_id" AS "saiki_id"
    , a."saiki_mei" AS "saiki_mei"
    , a."idref_id" AS "idref_id"
    , (SELECT r0."idref_mei" FROM M05_ID r0 WHERE r0."idref_id" = a."idref_id") AS "idref_mei"
    , TRIM(TRAILING ' ' FROM a."cdref_cd") AS "cdref_cd"
    , (SELECT r1."cdref_mei" FROM M05_CD r1 WHERE r1."cdref_cd" = a."cdref_cd") AS "cdref_mei"
    , TRIM(TRAILING ' ' FROM a."noref_no") AS "noref_no"
    , (SELECT r2."noref_mei" FROM M05_NO r2 WHERE r2."noref_no" = a."noref_no") AS "noref_mei"
    , a."ex_idref_id" AS "ex_idref_id"
    , (SELECT r3."idref_mei" FROM M05_ID r3 WHERE r3."idref_id" = a."ex_idref_id") AS "ex_idref_mei"
    , a."ex_idbn_bn" AS "ex_idbn_bn"
    , (SELECT r4."idbn_no" FROM M05_IDBN r4 WHERE r4."idref_id" = a."ex_idref_id" AND r4."idbn_bn" = a."ex_idbn_bn") AS "ex_idbn_no"
    , a."oya_saiki_id" AS "oya_saiki_id"
    , (SELECT r5."saiki_mei" FROM M05_SAIKI r5 WHERE r5."saiki_id" = a."oya_saiki_id") AS "oya_saiki_mei"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r6."user_sei" FROM MHR_USER r6 WHERE r6."user_id" = a."insert_user_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r7."user_sei" FROM MHR_USER r7 WHERE r7."user_id" = a."update_user_id") AS "update_user_sei"
FROM
    M05_SAIKI a 
WHERE
    1 = 1 
    AND a."saiki_id" = CAST (:saiki_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."saiki_mei")) LIKE UPPER (CONCAT ('%', :saiki_mei, '%')) 
    AND a."idref_id" = CAST (:idref_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."cdref_cd")) LIKE UPPER (CONCAT ('%', :cdref_cd, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."noref_no")) LIKE UPPER (CONCAT ('%', :noref_no, '%')) 
    AND a."ex_idref_id" = CAST (:ex_idref_id AS INTEGER) 
    AND a."ex_idbn_bn" = CAST (:ex_idbn_bn AS INTEGER) 
    AND a."oya_saiki_id" = CAST (:oya_saiki_id AS INTEGER) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."saiki_id"
