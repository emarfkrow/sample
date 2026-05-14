SELECT
      o.oya_id
    , o.oya_info
    , k.ko_bn
    , k.ko_info 
FROM
    t01_oya o 
    LEFT OUTER JOIN t01_ko k 
        ON k.oya_id = o.oya_id 
WHERE
    1 = 1 
    AND a."OYA_ID" = :oya_id 
    AND UPPER (RTRIM (RTRIM (a."OYA_INFO"), 'Å@')) LIKE UPPER ('%' || :oya_info || '%') 
    AND a."KO_BN" = :ko_bn 
    AND UPPER (RTRIM (RTRIM (a."KO_INFO"), 'Å@')) LIKE UPPER ('%' || :ko_info || '%') 
ORDER BY
    o.oya_id
    , k.ko_bn
