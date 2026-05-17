SELECT
      'D0002' AS table_name
    , o.oya_id
    , o.oya_info
    , k.ko_bn
    , k.ko_info 
FROM
    t01_oya o 
    LEFT OUTER JOIN t01_ko k 
        ON k.oya_id = o.oya_id 
WHERE
    1 = 1 
    AND a.`OYA_ID` = :oya_id 
    AND UPPER (TRIM (TRAILING ' ' FROM a.`OYA_INFO`)) LIKE UPPER (CONCAT ('%', :oya_info, '%')) 
    AND a.`KO_BN` = :ko_bn 
    AND UPPER (TRIM (TRAILING ' ' FROM a.`KO_INFO`)) LIKE UPPER (CONCAT ('%', :ko_info, '%')) 
ORDER BY
    o.oya_id
    , k.ko_bn
