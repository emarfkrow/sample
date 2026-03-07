SELECT
      a.`table_name` AS `table_name`
    , a.`src_id` AS `src_id`
    , a.`dest_info` AS `dest_info`
FROM
    V13_HENKAN a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`table_name`)) LIKE UPPER (CONCAT ('%', :table_name, '%')) 
    AND a.`src_id` = :src_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`dest_info`)) LIKE UPPER (CONCAT ('%', :dest_info, '%')) 
