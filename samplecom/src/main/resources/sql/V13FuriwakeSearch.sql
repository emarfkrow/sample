SELECT
      a.`TABLE_NAME` AS `TABLE_NAME`
    , a.`SRC_ID$DEST_ID` AS `SRC_ID$DEST_ID`
    , a.`INFO` AS `INFO`
FROM
    V13_FURIWAKE a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`TABLE_NAME`)) LIKE UPPER (CONCAT ('%', :table_name, '%')) 
    AND a.`SRC_ID$DEST_ID` = :src_id_dest_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`INFO`)) LIKE UPPER (CONCAT ('%', :info, '%')) 
