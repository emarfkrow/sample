SELECT
      a."KOUTEI_ID" AS "KOUTEI_ID"
    , (SELECT r0."KOUTEI_MEI" FROM T14_KOUTEI r0 WHERE r0."KOUTEI_ID" = a."KOUTEI_ID") AS "KOUTEI_MEI"
    , a."JISSEKI_BN" AS "JISSEKI_BN"
    , RTRIM (RTRIM (a."JISSHI_YMD"), '　') AS "JISSHI_YMD"
    , RTRIM (RTRIM (a."KANRYO_YMD"), '　') AS "KANRYO_YMD"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , RTRIM (RTRIM (a."INSERT_USER_ID"), '　') AS "INSERT_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE TO_CHAR (r1."USER_ID") = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , RTRIM (RTRIM (a."UPDATE_USER_ID"), '　') AS "UPDATE_USER_ID"
    , (SELECT r2."USER_SEI" FROM MHR_USER r2 WHERE TO_CHAR (r2."USER_ID") = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    T14_JISSEKI a 
WHERE
    1 = 1 
    AND a."KOUTEI_ID" = :koutei_id 
    AND a."JISSEKI_BN" = :jisseki_bn 
    AND UPPER (RTRIM (RTRIM (a."JISSHI_YMD"), '　')) LIKE UPPER ('%' || :jisshi_ymd || '%') 
    AND a."JISSHI_YMD" >= :jisshi_ymd_1 
    AND a."JISSHI_YMD" <= :jisshi_ymd_2 
    AND UPPER (RTRIM (RTRIM (a."KANRYO_YMD"), '　')) LIKE UPPER ('%' || :kanryo_ymd || '%') 
    AND a."KANRYO_YMD" >= :kanryo_ymd_1 
    AND a."KANRYO_YMD" <= :kanryo_ymd_2 
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
    , a."JISSEKI_BN"
