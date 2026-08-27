SELECT
      'D0002' AS table_name
    , o.oya_id
    , o.oya_info
    , k.ko_bn
    , k.ko_info
    , m.mago_bn
    , m.mago_info 
FROM
    t02_oya o 
    LEFT OUTER JOIN t02_ko k 
        ON k.oya_id = o.oya_id 
    LEFT OUTER JOIN t02_mago m 
        ON m.oya_id = k.oya_id 
        AND m.ko_bn = k.ko_bn 
WHERE
    1 = 1 
    AND o."OYA_ID" = :oya_id 
    AND UPPER (RTRIM (RTRIM (o."OYA_INFO"), '�@')) LIKE UPPER ('%' || :oya_info || '%') 
    AND k."KO_BN" = :ko_bn 
    AND UPPER (RTRIM (RTRIM (k."KO_INFO"), '�@')) LIKE UPPER ('%' || :ko_info || '%') 
    AND m."MAGO_BN" = :mago_bn 
    AND UPPER (RTRIM (RTRIM (m."MAGO_INFO"), '�@')) LIKE UPPER ('%' || :mago_info || '%') 
ORDER BY
    o.oya_id
    , k.ko_bn
    , m.mago_bn
