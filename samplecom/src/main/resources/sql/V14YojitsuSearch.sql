SELECT
      a."KOUTEI_ID" AS "KOUTEI_ID"
    , a."KOUTEI_TX" AS "KOUTEI_TX"
    , TO_CHAR (a."KAISHI_BI", 'YYYY-MM-DD') AS "KAISHI_BI"
    , TO_CHAR (a."SHURYO_BI", 'YYYY-MM-DD') AS "SHURYO_BI"
    , RTRIM (RTRIM (a."SAGYOKU_CD"), '　') AS "SAGYOKU_CD"
    , a."OYA_KOUTEI_ID" AS "OYA_KOUTEI_ID"
    , TO_CHAR (a."JISSHI_BI", 'YYYY-MM-DD') AS "JISSHI_BI"
    , TO_CHAR (a."KANRYO_BI", 'YYYY-MM-DD') AS "KANRYO_BI"
    , a."DEPENDENCIES" AS "DEPENDENCIES"
    , a."KOUTEI_PATH" AS "KOUTEI_PATH"
    , a."ROOT" AS "ROOT"
FROM
    V14_YOJITSU a 
WHERE
    1 = 1 
    AND a."KOUTEI_ID" = :koutei_id 
    AND UPPER (RTRIM (RTRIM (a."KOUTEI_TX"), '　')) LIKE UPPER ('%' || :koutei_tx || '%') 
    AND a."KAISHI_BI" = TO_DATE (SUBSTR (:kaishi_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."KAISHI_BI" >= TO_DATE (SUBSTR (:kaishi_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."KAISHI_BI" <= TO_DATE (SUBSTR (:kaishi_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."SHURYO_BI" = TO_DATE (SUBSTR (:shuryo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."SHURYO_BI" >= TO_DATE (SUBSTR (:shuryo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."SHURYO_BI" <= TO_DATE (SUBSTR (:shuryo_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND UPPER (RTRIM (RTRIM (a."SAGYOKU_CD"), '　')) LIKE UPPER ('%' || :sagyoku_cd || '%') 
    AND a."OYA_KOUTEI_ID" = :oya_koutei_id 
    AND a."JISSHI_BI" = TO_DATE (SUBSTR (:jisshi_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."JISSHI_BI" >= TO_DATE (SUBSTR (:jisshi_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."JISSHI_BI" <= TO_DATE (SUBSTR (:jisshi_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."KANRYO_BI" = TO_DATE (SUBSTR (:kanryo_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."KANRYO_BI" >= TO_DATE (SUBSTR (:kanryo_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."KANRYO_BI" <= TO_DATE (SUBSTR (:kanryo_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND UPPER (RTRIM (RTRIM (a."DEPENDENCIES"), '　')) LIKE UPPER ('%' || :dependencies || '%') 
    AND UPPER (RTRIM (RTRIM (a."KOUTEI_PATH"), '　')) LIKE UPPER ('%' || :koutei_path || '%') 
    AND a."ROOT" = :root 
