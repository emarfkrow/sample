SELECT
      a.sosen_id
    , a.sosen_mei
    , b.oya_sn
    , b.oya_mei
    , c.entity_sn
    , c.entity_mei
    , c.sansho1_id
    , c.sansho1_mei
    , c.sansho2_cd
    , c.sansho2_mei
    , c.betsu_sansho1_id
    , c.betsu_sansho1_mei
    , d.null_entity2_mei
    , d.entity2_mei
    , d.check_f
    , d.radio_kb
    , d.pulldown_kb
    , d.memo_tx
    , d.hiduke_ymd
    , d.nengetsu_ym
    , d.sample_y
    , d.sample_m
    , d.nichiji_dt
    , d.jikoku_hm
    , d.jikan_tm
    , d.suryo_qt
    , d.tanka_am
    , d.kingaku_am
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
    LEFT OUTER JOIN t_ko e
        ON e.sosen_id = c.sosen_id
        AND e.oya_sn = c.oya_sn
        AND e.entity_sn = c.entity_sn
    LEFT OUTER JOIN t_shison f
        ON f.sosen_id = e.sosen_id
        AND f.oya_sn = e.oya_sn
        AND f.entity_sn = e.entity_sn
        AND f.ko_sn = e.ko_sn
WHERE
    1 = 1
    AND a.sosen_id = :sosen_id
    AND a.sosen_mei LIKE CONCAT ('%', :sosen_mei, '%')
    AND b.oya_sn = :oya_sn
    AND b.oya_mei LIKE CONCAT ('%', :oya_mei, '%')
    AND c.entity_sn = :entity_sn
    AND c.entity_mei LIKE CONCAT ('%', :entity_mei, '%')
    AND c.sansho1_id = :sansho1_id
    AND c.sansho1_mei LIKE CONCAT ('%', :sansho1_mei, '%')
    AND c.sansho2_cd = :sansho2_id
    AND c.sansho2_mei LIKE CONCAT ('%', :sansho2_mei, '%')
    AND c.betsu_sansho1_id = :betsu_sansho1_id
    AND c.betsu_sansho1_mei LIKE CONCAT ('%', :betsu_sansho1_mei, '%')
    AND c.insert_dt = :insert_dt
    AND c.insert_dt >= :insert_dt_1
    AND c.insert_dt <= :insert_dt_2
    AND c.insert_by = :insert_by
    AND c.update_dt = :update_dt
    AND c.update_dt >= :update_dt_1
    AND c.update_dt <= :update_dt_2
    AND c.update_by = :update_by
    /*:delete_f*/
    AND CASE
        WHEN c.delete_f IS NULL
            THEN '0'
        ELSE c.delete_f
        END IN (:delete_f)
    /*:delete_f*/
    AND d.null_entity2_mei LIKE CONCAT ('%', :null_entity2_mei, '%')
    AND d.entity2_mei LIKE CONCAT ('%', :entity2_mei, '%')
    /*:check_f*/
    AND CASE
        WHEN d.check_f IS NULL
            THEN '0'
        ELSE d.check_f
        END IN (:check_f)
    /*:check_f*/
    AND d.radio_kb IN (:radio_kb)
    AND d.pulldown_kb IN (:pulldown_kb)
    AND d.memo_tx = :memo_tx
    AND d.hiduke_ymd = :hiduke_ymd
    AND d.hiduke_ymd >= :hiduke_ymd_1
    AND d.hiduke_ymd <= :hiduke_ymd_2
    AND d.nengetsu_ym = :nengetsu_ym
    AND d.nengetsu_ym >= :nengetsu_ym_1
    AND d.nengetsu_ym <= :nengetsu_ym_2
    AND d.sample_y = :sample_y
    AND d.sample_y >= :sample_y_1
    AND d.sample_y <= :sample_y_2
    AND d.sample_m = :sample_m
    AND d.sample_m >= :sample_m_1
    AND d.sample_m <= :sample_m_2
    AND d.nichiji_dt = :nichiji_dt
    AND d.nichiji_dt >= :nichiji_dt_1
    AND d.nichiji_dt <= :nichiji_dt_2
    AND d.jikoku_hm = :jikoku_hm
    AND d.jikoku_hm >= :jikoku_hm_1
    AND d.jikoku_hm <= :jikoku_hm_2
    AND d.jikan_tm = :jikan_tm
    AND d.jikan_tm >= :jikan_tm_1
    AND d.jikan_tm <= :jikan_tm_2
    AND d.suryo_qt = :suryo_qt
    AND d.suryo_qt >= :suryo_qt_1
    AND d.suryo_qt <= :suryo_qt_2
    AND d.tanka_am = :tanka_am
    AND d.tanka_am >= :tanka_am_1
    AND d.tanka_am <= :tanka_am_2
    AND d.kingaku_am = :kingaku_am
    AND d.kingaku_am >= :kingaku_am_1
    AND d.kingaku_am <= :kingaku_am_2
ORDER BY
    a.sosen_id
    , b.oya_sn
    , c.entity_sn
    , e.ko_sn
    , f.shison_sn

