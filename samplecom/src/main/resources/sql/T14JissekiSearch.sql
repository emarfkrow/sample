SELECT
      a."KOUTEI_ID" AS "KOUTEI_ID"
    , (SELECT r0."KOUTEI_MEI" FROM T14_KOUTEI r0 WHERE r0."KOUTEI_ID" = a."KOUTEI_ID") AS "KOUTEI_MEI"
    , a."JISSEKI_BN" AS "JISSEKI_BN"
    , TO_CHAR (a."JISSHI_BI", 'YYYY-MM-DD') AS "JISSHI_BI"
    , TO_CHAR (a."KANRYO_BI", 'YYYY-MM-DD') AS "KANRYO_BI"
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
    AND a."JISSHI_BI" = TO_DATE (SUBSTR (:jisshi_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."JISSHI_BI" >= TO_DATE (SUBSTR (:jisshi_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."JISSHI_BI" <= TO_DATE (SUBSTR (:jisshi_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."KANRYO_BI" = TO_DATE (SUBSTR (:kanryo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."KANRYO_BI" >= TO_DATE (SUBSTR (:kanryo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."KANRYO_BI" <= TO_DATE (SUBSTR (:kanryo_bi_2 , 0, 10), 'YYYY-MM-DD')
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
