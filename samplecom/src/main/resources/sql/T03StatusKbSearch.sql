SELECT
      a."FLOW_ID" AS "FLOW_ID"
    , a."TABLE_NM" AS "TABLE_NM"
    , a."PRIMARY_KEYS" AS "PRIMARY_KEYS"
    , a."STATUS_KB" AS "STATUS_KB"
    , TO_CHAR (a."KESSAI_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "KESSAI_TS"
    , a."KESSAI_ID" AS "KESSAI_ID"
    , a."RIYU_TX" AS "RIYU_TX"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , RTRIM (RTRIM (a."INSERT_USER_ID"), '　') AS "INSERT_USER_ID"
    , (SELECT r0."USER_SEI" FROM MHR_USER r0 WHERE TO_CHAR (r0."USER_ID") = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , RTRIM (RTRIM (a."UPDATE_USER_ID"), '　') AS "UPDATE_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE TO_CHAR (r1."USER_ID") = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    T03_STATUS_KB a 
WHERE
    1 = 1 
    AND a."FLOW_ID" = :flow_id 
    AND UPPER (RTRIM (RTRIM (a."TABLE_NM"), '　')) LIKE UPPER ('%' || :table_nm || '%') 
    AND UPPER (RTRIM (RTRIM (a."PRIMARY_KEYS"), '　')) LIKE UPPER ('%' || :primary_keys || '%') 
    AND RTRIM (RTRIM (a."STATUS_KB"), '　') IN (:status_kb) 
    AND a."KESSAI_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:kessai_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."KESSAI_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:kessai_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."KESSAI_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:kessai_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."KESSAI_ID" = :kessai_id 
    AND UPPER (RTRIM (RTRIM (a."RIYU_TX"), '　')) LIKE UPPER ('%' || :riyu_tx || '%') 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."INSERT_USER_ID"), '　')) LIKE UPPER ('%' || :insert_user_id || '%') 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."UPDATE_USER_ID"), '　')) LIKE UPPER ('%' || :update_user_id || '%') 
ORDER BY
    a."FLOW_ID"
