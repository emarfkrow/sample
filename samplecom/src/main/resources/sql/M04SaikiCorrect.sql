SELECT
      a."SAIKI_ID" AS "SAIKI_ID"
    , a."SAIKI_MEI" AS "SAIKI_MEI"
    , a."IDREF_ID" AS "IDREF_ID"
    , (SELECT r0."IDREF_MEI" FROM M04_ID r0 WHERE r0."IDREF_ID" = a."IDREF_ID") AS "IDREF_MEI"
    , RTRIM (RTRIM (a."CDREF_CD"), '　') AS "CDREF_CD"
    , (SELECT r1."CDREF_MEI" FROM M04_CD r1 WHERE r1."CDREF_CD" = a."CDREF_CD") AS "CDREF_MEI"
    , RTRIM (RTRIM (a."NOREF_NO"), '　') AS "NOREF_NO"
    , (SELECT r2."NOREF_MEI" FROM M04_NO r2 WHERE r2."NOREF_NO" = a."NOREF_NO") AS "NOREF_MEI"
    , a."EX_IDREF_ID" AS "EX_IDREF_ID"
    , (SELECT r3."IDREF_MEI" FROM M04_ID r3 WHERE r3."IDREF_ID" = a."EX_IDREF_ID") AS "EX_IDREF_MEI"
    , a."EX_IDBN_BN" AS "EX_IDBN_BN"
    , a."OYA_SAIKI_ID" AS "OYA_SAIKI_ID"
    , (SELECT r4."SAIKI_MEI" FROM M04_SAIKI r4 WHERE r4."SAIKI_ID" = a."OYA_SAIKI_ID") AS "OYA_SAIKI_MEI"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r5."USER_SEI" FROM MHR_USER r5 WHERE r5."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r6."USER_SEI" FROM MHR_USER r6 WHERE r6."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    M04_SAIKI a 
WHERE
    1 = 1 
    AND a."SAIKI_ID" = :saiki_id 
    AND UPPER (RTRIM (RTRIM (a."SAIKI_MEI"), '　')) LIKE UPPER ('%' || :saiki_mei || '%') 
    AND a."IDREF_ID" = :idref_id 
    AND UPPER (RTRIM (RTRIM (a."CDREF_CD"), '　')) LIKE UPPER ('%' || :cdref_cd || '%') 
    AND UPPER (RTRIM (RTRIM (a."NOREF_NO"), '　')) LIKE UPPER ('%' || :noref_no || '%') 
    AND a."EX_IDREF_ID" = :ex_idref_id 
    AND a."EX_IDBN_BN" = :ex_idbn_bn 
    AND a."OYA_SAIKI_ID" = :oya_saiki_id 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."SAIKI_ID"
