WITH RECURSIVE child(lv, id, parent, name, tree) AS (
    SELECT
        0 AS lv
        , b1.busho_id AS id
        , b1.oya_busho_id AS parent
        , b1.busho_mei AS name
        , CAST(b1.busho_id AS CHAR (10))
    FROM
        m_busho b1
    WHERE
        b1.oya_busho_id IS NULL
    UNION ALL
    SELECT
        child.lv + 1
        , b2.busho_id
        , b2.oya_busho_id
        , b2.busho_mei
        , CONCAT (child.tree, ',', b2.busho_id)
    FROM
        m_busho b2
        INNER JOIN child
            ON b2.oya_busho_id = child.id
)
SELECT
    lv
    , id
    , parent
    , name
    , tree
FROM
    child
ORDER BY
    tree
