SELECT
      a.`koutei_id` AS `koutei_id`
    , a.`koutei_tx` AS `koutei_tx`
    , a.`kaishi_bi` AS `kaishi_bi`
    , a.`shuryo_bi` AS `shuryo_bi`
    , a.`oya_koutei_id` AS `oya_koutei_id`
    , a.`jisshi_bi` AS `jisshi_bi`
    , a.`kanryo_bi` AS `kanryo_bi`
FROM
    V00_YOJITSU a 
WHERE
    1 = 1 
    AND a.`koutei_id` = :koutei_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`koutei_tx`)) LIKE UPPER (CONCAT ('%', :koutei_tx, '%')) 
    AND a.`kaishi_bi` = :kaishi_bi 
    AND a.`kaishi_bi` >= :kaishi_bi_1 
    AND a.`kaishi_bi` <= :kaishi_bi_2 
    AND a.`shuryo_bi` = :shuryo_bi 
    AND a.`shuryo_bi` >= :shuryo_bi_1 
    AND a.`shuryo_bi` <= :shuryo_bi_2 
    AND a.`oya_koutei_id` = :oya_koutei_id 
    AND a.`jisshi_bi` = :jisshi_bi 
    AND a.`jisshi_bi` >= :jisshi_bi_1 
    AND a.`jisshi_bi` <= :jisshi_bi_2 
    AND a.`kanryo_bi` = :kanryo_bi 
    AND a.`kanryo_bi` >= :kanryo_bi_1 
    AND a.`kanryo_bi` <= :kanryo_bi_2 
