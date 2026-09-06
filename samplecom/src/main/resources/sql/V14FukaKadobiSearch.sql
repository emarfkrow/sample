SELECT
      RTRIM (RTRIM (a."LABELS"), '　') AS "LABELS"
    , RTRIM (RTRIM (a."TYPE"), '　') AS "TYPE"
    , RTRIM (RTRIM (a."STACK"), '　') AS "STACK"
    , RTRIM (RTRIM (a."LABEL"), '　') AS "LABEL"
    , a."DATA" AS "DATA"
FROM
    V14_FUKA_KADOBI a 
WHERE
    1 = 1 
    AND UPPER (RTRIM (RTRIM (a."LABELS"), '　')) LIKE UPPER ('%' || :labels || '%') 
    AND a."LABELS" >= :labels_1 
    AND a."LABELS" <= :labels_2 
    AND UPPER (RTRIM (RTRIM (a."TYPE"), '　')) LIKE UPPER ('%' || :type || '%') 
    AND UPPER (RTRIM (RTRIM (a."STACK"), '　')) LIKE UPPER ('%' || :stack || '%') 
    AND UPPER (RTRIM (RTRIM (a."LABEL"), '　')) LIKE UPPER ('%' || :label || '%') 
    AND a."DATA" = :data 
