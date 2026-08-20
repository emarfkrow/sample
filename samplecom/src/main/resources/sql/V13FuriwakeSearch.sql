SELECT
      a."table_name" AS "table_name"
    , a."src_id$dest_id" AS "src_id$dest_id"
    , a."info" AS "info"
FROM
    V13_FURIWAKE a 
WHERE
    1 = 1 
    AND a."src_id$dest_id" = CAST (:src_id_dest_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."info")) LIKE UPPER (CONCAT ('%', :info, '%')) 
