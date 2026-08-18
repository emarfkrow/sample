SELECT
      a."DERIVE2_ID" AS "DERIVE2_ID"
    , a."ORG_INFO" AS "ORG_INFO"
    , a."ORG_ID" AS "ORG_ID"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , RTRIM (RTRIM (a."INSERT_USER_ID"), '　') AS "INSERT_USER_ID"
    , (SELECT r0."USER_SEI" FROM MHR_USER r0 WHERE TO_CHAR (r0."USER_ID") = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , RTRIM (RTRIM (a."UPDATE_USER_ID"), '　') AS "UPDATE_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE TO_CHAR (r1."USER_ID") = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    T07_DERIVE2 a 
WHERE
    1 = 1 
    AND a."DERIVE2_ID" = :derive_2_id 
    AND UPPER (RTRIM (RTRIM (a."ORG_INFO"), '　')) LIKE UPPER ('%' || :org_info || '%') 
    AND a."ORG_ID" = :org_id 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."INSERT_USER_ID"), '　')) LIKE UPPER ('%' || :insert_user_id || '%') 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."UPDATE_USER_ID"), '　')) LIKE UPPER ('%' || :update_user_id || '%') 
ORDER BY
    a."DERIVE2_ID"
