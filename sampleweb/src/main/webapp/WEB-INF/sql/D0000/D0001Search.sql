SELECT
'D0002'as table_name,
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
    AND o.oya_id = :oya_id 
    AND UPPER (RTRIM (RTRIM (o."OYA_INFO"), '�@')) LIKE UPPER ('%' || :oya_info || '%') 
    AND o.ko_bn = :ko_bn 
    AND UPPER (RTRIM (RTRIM (o."KO_INFO"), '�@')) LIKE UPPER ('%' || :ko_info || '%') 
ORDER BY
    o.oya_id
    , k.ko_bn
