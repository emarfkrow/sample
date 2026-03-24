SELECT
      a."USER_ID" AS "USER_ID"
    , a."USER_SEI" AS "USER_SEI"
    , a."USER_MEI" AS "USER_MEI"
    , a."E_MAIL" AS "E_MAIL"
    , a."PASSWORD" AS "PASSWORD"
    , TO_CHAR (a."TEKIYO_BI", 'YYYY-MM-DD') AS "TEKIYO_BI"
    , TO_CHAR (a."HAISHI_BI", 'YYYY-MM-DD') AS "HAISHI_BI"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r0."USER_SEI" FROM MHR_USER r0 WHERE r0."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE r1."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    MHR_USER a 
WHERE
    1 = 1 
    AND a."USER_ID" = :user_id 
    AND UPPER (RTRIM (RTRIM (a."USER_SEI"), '　')) LIKE UPPER ('%' || :user_sei || '%') 
    AND UPPER (RTRIM (RTRIM (a."USER_MEI"), '　')) LIKE UPPER ('%' || :user_mei || '%') 
    AND UPPER (RTRIM (RTRIM (a."E_MAIL"), '　')) LIKE UPPER ('%' || :e_mail || '%') 
    AND UPPER (RTRIM (RTRIM (a."PASSWORD"), '　')) LIKE UPPER ('%' || :password || '%') 
    AND a."TEKIYO_BI" = TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."TEKIYO_BI" >= TO_DATE (SUBSTR (:tekiyo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."TEKIYO_BI" <= TO_DATE (SUBSTR (:tekiyo_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."HAISHI_BI" = TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."HAISHI_BI" >= TO_DATE (SUBSTR (:haishi_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."HAISHI_BI" <= TO_DATE (SUBSTR (:haishi_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."USER_ID"
