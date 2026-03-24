SELECT
      a."TABLE_NAME" AS "TABLE_NAME"
    , a."SRC_ID$DEST_ID" AS "SRC_ID$DEST_ID"
    , a."INFO" AS "INFO"
FROM
    V13_FURIWAKE a 
WHERE
    1 = 1 
    AND a."SRC_ID$DEST_ID" = :src_id_dest_id 
    AND UPPER (RTRIM (RTRIM (a."INFO"), '　')) LIKE UPPER ('%' || :info || '%') 
