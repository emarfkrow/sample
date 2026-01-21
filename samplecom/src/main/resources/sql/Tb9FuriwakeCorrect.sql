SELECT
      a.`TABLE_NAME`
    , a.`SRC_ID$DEST_ID`
    , a.`INFO`
FROM
    TB9_FURIWAKE a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`TABLE_NAME`)) LIKE UPPER (CONCAT ('%', :table_name, '%')) 
    AND a.`SRC_ID$DEST_ID` = :src_id$dest_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`INFO`)) LIKE UPPER (CONCAT ('%', :info, '%')) 
