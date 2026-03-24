SELECT
      a."IDREF_ID" AS "IDREF_ID"
    , (SELECT r0."IDREF_MEI" FROM M04_ID r0 WHERE r0."IDREF_ID" = a."IDREF_ID") AS "IDREF_MEI"
    , a."IDBN_BN" AS "IDBN_BN"
    , RTRIM (RTRIM (a."IDBN_NO"), '　') AS "IDBN_NO"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE r1."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r2."USER_SEI" FROM MHR_USER r2 WHERE r2."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    M04_IDBN a 
WHERE
    1 = 1 
    AND a."IDREF_ID" = :idref_id 
    AND a."IDBN_BN" = :idbn_bn 
    AND UPPER (RTRIM (RTRIM (a."IDBN_NO"), '　')) LIKE UPPER ('%' || :idbn_no || '%') 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."IDREF_ID"
    , a."IDBN_BN"
