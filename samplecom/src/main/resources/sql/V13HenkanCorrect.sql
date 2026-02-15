SELECT
      a.`TABLE_NAME` AS `TABLE_NAME`
    , a.`SRC_ID` AS `SRC_ID`
    , a.`DEST_INFO` AS `DEST_INFO`
FROM
    V13_HENKAN a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`TABLE_NAME`)) LIKE UPPER (CONCAT ('%', :table_name, '%')) 
    AND a.`SRC_ID` = :src_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`DEST_INFO`)) LIKE UPPER (CONCAT ('%', :dest_info, '%')) 
