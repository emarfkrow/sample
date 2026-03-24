SELECT
      a."KBN_NM" AS "KBN_NM"
    , (SELECT r0."KBN_MEI" FROM MSY_KBN r0 WHERE r0."KBN_NM" = a."KBN_NM") AS "KBN_MEI"
    , a."KBN_VAL" AS "KBN_VAL"
    , a."KBN_VAL_MEI" AS "KBN_VAL_MEI"
    , a."HYOJI_ON" AS "HYOJI_ON"
    , a."CRITERIA" AS "CRITERIA"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE r1."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r2."USER_SEI" FROM MHR_USER r2 WHERE r2."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    MSY_KBN_VAL a 
WHERE
    1 = 1 
    AND UPPER (RTRIM (RTRIM (a."KBN_NM"), '　')) = UPPER (:kbn_nm_full) 
    AND UPPER (:kbn_nm) LIKE UPPER ('%' || RTRIM (RTRIM (a."KBN_NM"), '　')) 
    AND UPPER (RTRIM (RTRIM (a."KBN_VAL"), '　')) = UPPER (:kbn_val_full) 
    AND UPPER (RTRIM (RTRIM (a."KBN_VAL"), '　')) LIKE UPPER ('%' || :kbn_val || '%') 
    AND UPPER (RTRIM (RTRIM (a."KBN_VAL_MEI"), '　')) LIKE UPPER ('%' || :kbn_val_mei || '%') 
    AND a."HYOJI_ON" = :hyoji_on 
    AND UPPER (RTRIM (RTRIM (a."CRITERIA"), '　')) LIKE UPPER ('%' || :criteria || '%') 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."KBN_NM"
    , a."KBN_VAL"
    , a."HYOJI_ON"
