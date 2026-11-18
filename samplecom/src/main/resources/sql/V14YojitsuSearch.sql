SELECT
      RTRIM (RTRIM (a."TABLE_NAME"), '　') AS "TABLE_NAME"
    , a."KOUTEI_ID" AS "KOUTEI_ID"
    , a."TASK_ID" AS "TASK_ID"
    , a."TASK_MEI" AS "TASK_MEI"
    , a."TASK_START" AS "TASK_START"
    , a."TASK_UNTIL" AS "TASK_UNTIL"
    , a."DEPENDENCIES" AS "DEPENDENCIES"
    , a."TASK_BEG" AS "TASK_BEG"
    , a."TASK_END" AS "TASK_END"
FROM
    V14_YOJITSU a 
WHERE
    1 = 1 
    AND a."KOUTEI_ID" = :koutei_id 
    AND a."TASK_ID" = :task_id 
    AND UPPER (RTRIM (RTRIM (a."TASK_MEI"), '　')) LIKE UPPER ('%' || :task_mei || '%') 
    AND UPPER (RTRIM (RTRIM (a."TASK_START"), '　')) LIKE UPPER ('%' || :task_start || '%') 
    AND UPPER (RTRIM (RTRIM (a."TASK_UNTIL"), '　')) LIKE UPPER ('%' || :task_until || '%') 
    AND UPPER (RTRIM (RTRIM (a."DEPENDENCIES"), '　')) LIKE UPPER ('%' || :dependencies || '%') 
    AND UPPER (RTRIM (RTRIM (a."TASK_BEG"), '　')) LIKE UPPER ('%' || :task_beg || '%') 
    AND UPPER (RTRIM (RTRIM (a."TASK_END"), '　')) LIKE UPPER ('%' || :task_end || '%') 
