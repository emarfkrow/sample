SELECT
      RTRIM (RTRIM (a."TABLE_NAME"), '　') AS "TABLE_NAME"
    , a."SRC_ID" AS "SRC_ID"
    , a."DEST_INFO" AS "DEST_INFO"
FROM
    V13_HENKAN a 
WHERE
    1 = 1 
    AND a."SRC_ID" = :src_id 
    AND UPPER (RTRIM (RTRIM (a."DEST_INFO"), '　')) LIKE UPPER ('%' || :dest_info || '%') 
