SELECT
      a."KOUTEI_ID" AS "KOUTEI_ID"
    , a."KOUTEI_TX" AS "KOUTEI_TX"
    , RTRIM (RTRIM (a."KAISHI_YMD"), '　') AS "KAISHI_YMD"
    , RTRIM (RTRIM (a."SHURYO_YMD"), '　') AS "SHURYO_YMD"
    , RTRIM (RTRIM (a."SAGYOKU_CD"), '　') AS "SAGYOKU_CD"
    , a."OYA_KOUTEI_ID" AS "OYA_KOUTEI_ID"
    , RTRIM (RTRIM (a."JISSHI_YMD"), '　') AS "JISSHI_YMD"
    , RTRIM (RTRIM (a."KANRYO_YMD"), '　') AS "KANRYO_YMD"
    , a."DEPENDENCIES" AS "DEPENDENCIES"
    , a."KOUTEI_PATH" AS "KOUTEI_PATH"
    , a."ROOT" AS "ROOT"
FROM
    V14_YOJITSU a 
WHERE
    1 = 1 
    AND a."KOUTEI_ID" = :koutei_id 
    AND UPPER (RTRIM (RTRIM (a."KOUTEI_TX"), '　')) LIKE UPPER ('%' || :koutei_tx || '%') 
    AND UPPER (RTRIM (RTRIM (a."KAISHI_YMD"), '　')) LIKE UPPER ('%' || :kaishi_ymd || '%') 
    AND a."KAISHI_YMD" >= :kaishi_ymd_1 
    AND a."KAISHI_YMD" <= :kaishi_ymd_2 
    AND UPPER (RTRIM (RTRIM (a."SHURYO_YMD"), '　')) LIKE UPPER ('%' || :shuryo_ymd || '%') 
    AND a."SHURYO_YMD" >= :shuryo_ymd_1 
    AND a."SHURYO_YMD" <= :shuryo_ymd_2 
    AND UPPER (RTRIM (RTRIM (a."SAGYOKU_CD"), '　')) LIKE UPPER ('%' || :sagyoku_cd || '%') 
    AND a."OYA_KOUTEI_ID" = :oya_koutei_id 
    AND UPPER (RTRIM (RTRIM (a."JISSHI_YMD"), '　')) LIKE UPPER ('%' || :jisshi_ymd || '%') 
    AND a."JISSHI_YMD" >= :jisshi_ymd_1 
    AND a."JISSHI_YMD" <= :jisshi_ymd_2 
    AND UPPER (RTRIM (RTRIM (a."KANRYO_YMD"), '　')) LIKE UPPER ('%' || :kanryo_ymd || '%') 
    AND a."KANRYO_YMD" >= :kanryo_ymd_1 
    AND a."KANRYO_YMD" <= :kanryo_ymd_2 
    AND UPPER (RTRIM (RTRIM (a."DEPENDENCIES"), '　')) LIKE UPPER ('%' || :dependencies || '%') 
    AND UPPER (RTRIM (RTRIM (a."KOUTEI_PATH"), '　')) LIKE UPPER ('%' || :koutei_path || '%') 
    AND a."ROOT" = :root 
