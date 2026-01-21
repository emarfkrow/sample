SELECT
      * 
FROM
    t_entity e 
WHERE
    1 = 1 
    AND e.ancestor_id = :ancestor_id 
    AND e.parent_seq = :parent_seq 
    AND e.entity_seq = :entity_seq 
    AND e.entity_mei = :entity_mei

