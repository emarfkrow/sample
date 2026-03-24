SELECT
      a."A_MEI" AS "A_MEI"
    , a."B_MEI" AS "B_MEI"
    , a."C_MEI" AS "C_MEI"
    , a."D_MEI" AS "D_MEI"
    , a."E_MEI" AS "E_MEI"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r0."USER_SEI" FROM MHR_USER r0 WHERE r0."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE r1."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    T00_UNIQUE a 
WHERE
    1 = 1 
    AND UPPER (RTRIM (RTRIM (a."A_MEI"), '　')) LIKE UPPER ('%' || :a_mei || '%') 
    AND UPPER (RTRIM (RTRIM (a."B_MEI"), '　')) LIKE UPPER ('%' || :b_mei || '%') 
    AND UPPER (RTRIM (RTRIM (a."C_MEI"), '　')) LIKE UPPER ('%' || :c_mei || '%') 
    AND UPPER (RTRIM (RTRIM (a."D_MEI"), '　')) = UPPER (:d_mei_full) 
    AND UPPER (RTRIM (RTRIM (a."D_MEI"), '　')) LIKE UPPER ('%' || :d_mei || '%') 
    AND UPPER (RTRIM (RTRIM (a."E_MEI"), '　')) = UPPER (:e_mei_full) 
    AND UPPER (RTRIM (RTRIM (a."E_MEI"), '　')) LIKE UPPER ('%' || :e_mei || '%') 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."D_MEI"
    , a."E_MEI"
