/**
setparameter oya_id 1
setparameter ko_bn 1
setparameter mago_bn 1
*/
SELECT
      o.oya_id
    , o.oya_info
    , o.insert_ts
    , o.insert_user_id
    , o.update_ts AS "T01_OYA.UPDATE_TS"
    , o.update_user_id
    , k.ko_bn
    , k.ko_info
    , k.update_ts AS "T01_KO.UPDATE_TS"
    , m.mago_bn
    , m.mago_info
    , m.update_ts AS "T01_MAGO.UPDATE_TS" 
FROM
    t01_oya o 
    LEFT OUTER JOIN t01_ko k 
        ON k.oya_id = o.oya_id 
    LEFT OUTER JOIN t01_mago m 
        ON m.oya_id = k.oya_id 
        AND m.ko_bn = k.ko_bn 
WHERE
    o.oya_id = :oya_id 
    AND k.ko_bn = :ko_bn 
    AND m.mago_bn = :mago_bn
