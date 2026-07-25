SELECT
      a.`labels` AS `labels`
    , a.`type` AS `type`
    , TRIM(TRAILING ' ' FROM a.`stack`) AS `stack`
    , TRIM(TRAILING ' ' FROM a.`label`) AS `label`
    , a.`DATA` AS `DATA`
FROM
    V14_FUKA_SAGYOKU a 
WHERE
    1 = 1 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`labels`)) LIKE UPPER (CONCAT ('%', :labels, '%')) 
    AND a.`labels` >= :labels_1 
    AND a.`labels` <= :labels_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`type`)) LIKE UPPER (CONCAT ('%', :type, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`stack`)) LIKE UPPER (CONCAT ('%', :stack, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`label`)) LIKE UPPER (CONCAT ('%', :label, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`DATA`)) LIKE UPPER (CONCAT ('%', :data, '%')) 
