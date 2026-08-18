SELECT
      RTRIM (RTRIM (a."KADO_YMD"), '　') AS "KADO_YMD"
    , a."BUSHO_ID" AS "BUSHO_ID"
    , (SELECT r0."BUSHO_MEI" FROM MHR_BUSHO r0 WHERE r0."BUSHO_ID" = a."BUSHO_ID") AS "BUSHO_MEI"
    , RTRIM (RTRIM (a."KADOBI_F"), '　') AS "KADOBI_F"
    , a."MEMO" AS "MEMO"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , RTRIM (RTRIM (a."INSERT_USER_ID"), '　') AS "INSERT_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE TO_CHAR (r1."USER_ID") = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , RTRIM (RTRIM (a."UPDATE_USER_ID"), '　') AS "UPDATE_USER_ID"
    , (SELECT r2."USER_SEI" FROM MHR_USER r2 WHERE TO_CHAR (r2."USER_ID") = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    MSY_KADOBI a 
WHERE
    1 = 1 
    AND UPPER (RTRIM (RTRIM (a."KADO_YMD"), '　')) = UPPER (:kado_ymd_full) 
    AND UPPER (RTRIM (RTRIM (a."KADO_YMD"), '　')) LIKE UPPER ('%' || :kado_ymd || '%') 
    AND a."KADO_YMD" >= :kado_ymd_1 
    AND a."KADO_YMD" <= :kado_ymd_2 
    AND a."BUSHO_ID" = :busho_id 
    AND CASE WHEN RTRIM (RTRIM (a."KADOBI_F"), '　') IS NULL THEN '0' ELSE TO_CHAR (a."KADOBI_F") END IN (:kadobi_f) 
    AND UPPER (RTRIM (RTRIM (a."MEMO"), '　')) LIKE UPPER ('%' || :memo || '%') 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."INSERT_USER_ID"), '　')) LIKE UPPER ('%' || :insert_user_id || '%') 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (RTRIM (RTRIM (a."UPDATE_USER_ID"), '　')) LIKE UPPER ('%' || :update_user_id || '%') 
ORDER BY
    a."KADO_YMD"
    , a."BUSHO_ID"
