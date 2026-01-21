SELECT
      * 
FROM
    t_sosen a 
    INNER JOIN t_oya b 
        ON b.sosen_id = a.sosen_id 
    INNER JOIN t_entity c 
        ON c.sosen_id = b.sosen_id 
        AND c.oya_sn = b.oya_sn 
    INNER JOIN t_entity2 d 
        ON d.sosen_id = c.sosen_id 
        AND d.oya_sn = c.oya_sn 
        AND d.entity_sn = c.entity_sn 
WHERE
    c.sosen_id = :sosen_id 
    AND c.oya_sn = :oya_sn 
    AND c.entity_sn = :entity_sn

