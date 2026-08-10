SELECT
      a.`table_name` AS `table_name`
    , a.`SRC_ID$DEST_ID` AS `SRC_ID$DEST_ID`
    , a.`info` AS `info`
FROM
    V13_FURIWAKE a 
WHERE
    1 = 1 
    AND a.`SRC_ID$DEST_ID` = :src_id_dest_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`info`)) LIKE UPPER (CONCAT ('%', :info, '%')) 
