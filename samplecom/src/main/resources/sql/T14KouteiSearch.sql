SELECT
      a."KOUTEI_ID" AS "KOUTEI_ID"
    , a."KOUTEI_MEI" AS "KOUTEI_MEI"
    , TO_CHAR (a."KAISHI_BI", 'YYYY-MM-DD') AS "KAISHI_BI"
    , TO_CHAR (a."SHURYO_BI", 'YYYY-MM-DD') AS "SHURYO_BI"
    , RTRIM (RTRIM (a."SAGYOKU_CD"), '　') AS "SAGYOKU_CD"
    , a."OYA_KOUTEI_ID" AS "OYA_KOUTEI_ID"
    , (SELECT r0."KOUTEI_MEI" FROM T14_KOUTEI r0 WHERE r0."KOUTEI_ID" = a."OYA_KOUTEI_ID") AS "OYA_KOUTEI_MEI"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , RTRIM (RTRIM (a."INSERT_USER_ID"), '　') AS "INSERT_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE TO_CHAR (r1."USER_ID") = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , RTRIM (RTRIM (a."UPDATE_USER_ID"), '　') AS "UPDATE_USER_ID"
    , (SELECT r2."USER_SEI" FROM MHR_USER r2 WHERE TO_CHAR (r2."USER_ID") = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    T14_KOUTEI a 
WHERE
    1 = 1 
    AND a."KOUTEI_ID" = :koutei_id 
    AND UPPER (RTRIM (RTRIM (a."KOUTEI_MEI"), '　')) LIKE UPPER ('%' || :koutei_mei || '%') 
    AND a."KAISHI_BI" = TO_DATE (SUBSTR (:kaishi_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."KAISHI_BI" >= TO_DATE (SUBSTR (:kaishi_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."KAISHI_BI" <= TO_DATE (SUBSTR (:kaishi_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."SHURYO_BI" = TO_DATE (SUBSTR (:shuryo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."SHURYO_BI" >= TO_DATE (SUBSTR (:shuryo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."SHURYO_BI" <= TO_DATE (SUBSTR (:shuryo_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND UPPER (RTRIM (RTRIM (a."SAGYOKU_CD"), '　')) LIKE UPPER ('%' || :sagyoku_cd || '%') 
    AND a."OYA_KOUTEI_ID" = :oya_koutei_id 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."INSERT_USER_ID"), '　')) LIKE UPPER ('%' || :insert_user_id || '%') 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."UPDATE_USER_ID"), '　')) LIKE UPPER ('%' || :update_user_id || '%') 
ORDER BY
    a."KOUTEI_ID"
