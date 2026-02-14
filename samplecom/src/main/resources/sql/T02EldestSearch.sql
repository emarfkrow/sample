SELECT
      a.`BRO_ID`
    , a.`ELDEST_INFO`
    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
    , c1.`YOUNGER_INFO`
    , c2.`YOUNGEST_INFO`
FROM
    T02_ELDEST a 
    INNER JOIN T02_YOUNGER c1 
        ON 1 = 1 
        AND c1.BRO_ID = a.BRO_ID 
    INNER JOIN T02_YOUNGEST c2 
        ON 1 = 1 
        AND c2.BRO_ID = a.BRO_ID 
WHERE
    1 = 1 
    AND a.`BRO_ID` = :bro_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`ELDEST_INFO`)) LIKE UPPER (CONCAT ('%', :eldest_info, '%')) 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`BRO_ID`
