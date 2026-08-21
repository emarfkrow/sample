SELECT
      a."entity_id" AS "entity_id"
    , a."entity_nm" AS "entity_nm"
    , a."entity_mei" AS "entity_mei"
    , a."bit_b" AS "bit_b"
    , TRIM(TRAILING ' ' FROM a."check_f") AS "check_f"
    , a."radio_kb" AS "radio_kb"
    , a."pulldown_kb" AS "pulldown_kb"
    , a."pulldown_sb" AS "pulldown_sb"
    , a."memo_tx" AS "memo_tx"
    , a."memo" AS "memo"
    , a."tenpu_file" AS "tenpu_file"
    , TRIM(TRAILING ' ' FROM a."nen_y") AS "nen_y"
    , TRIM(TRAILING ' ' FROM a."tsuki_m") AS "tsuki_m"
    , TRIM(TRAILING ' ' FROM a."hi_d") AS "hi_d"
    , TRIM(TRAILING ' ' FROM a."nengetsu_ym") AS "nengetsu_ym"
    , TRIM(TRAILING ' ' FROM a."nengappi_ymd") AS "nengappi_ymd"
    , TO_CHAR (a."timestamp_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "timestamp_ts"
    , TO_CHAR (a."nichiji_dt", 'YYYY-MM-DD HH24:MI:SS') AS "nichiji_dt"
    , TO_CHAR (a."hiduke_bi", 'YYYY-MM-DD') AS "hiduke_bi"
    , TO_CHAR (a."jikoku_hm", 'HH24:MI') AS "jikoku_hm"
    , a."jikan_tm" AS "jikan_tm"
    , a."tsuka_kb" AS "tsuka_kb"
    , a."juchu_qt" AS "juchu_qt"
    , a."juchu_pr" AS "juchu_pr"
    , a."juchu_am" AS "juchu_am"
    , a."hacchu_qt" AS "hacchu_qt"
    , a."hacchu_pr" AS "hacchu_pr"
    , a."hacchu_am" AS "hacchu_am"
    , TRIM(TRAILING ' ' FROM a."delete_f") AS "delete_f"
    , a."status_kb" AS "status_kb"
    , TO_CHAR (a."insert_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "insert_ts"
    , TRIM(TRAILING ' ' FROM a."insert_user_id") AS "insert_user_id"
    , (SELECT r0."user_sei" FROM MHR_USER r0 WHERE r0."user_id" = a."insert_user_id") AS "insert_user_sei"
    , TO_CHAR (a."update_ts", 'YYYY-MM-DD HH24:MI:SS.MS') AS "update_ts"
    , TRIM(TRAILING ' ' FROM a."update_user_id") AS "update_user_id"
    , (SELECT r1."user_sei" FROM MHR_USER r1 WHERE r1."user_id" = a."update_user_id") AS "update_user_sei"
FROM
    T00_ENTITY a 
WHERE
    1 = 1 
    AND IFNULL (a.DELETE_F, 0) != 1 
    AND a."entity_id" = CAST (:entity_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."entity_nm")) LIKE UPPER (CONCAT ('%', :entity_nm, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."entity_mei")) LIKE UPPER (CONCAT ('%', :entity_mei, '%')) 
    AND a."bit_b" = CAST (:bit_b AS INTEGER) 
    AND CASE WHEN TRIM(TRAILING ' ' FROM a."check_f") IS NULL THEN '0' ELSE TO_CHAR (a."check_f") END IN (:check_f) 
    AND TRIM(TRAILING ' ' FROM a."radio_kb") IN (:radio_kb) 
    AND TRIM(TRAILING ' ' FROM a."pulldown_kb") IN (:pulldown_kb) 
    AND TRIM(TRAILING ' ' FROM a."pulldown_sb") IN (:pulldown_sb) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."memo_tx")) LIKE UPPER (CONCAT ('%', :memo_tx, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."memo")) LIKE UPPER (CONCAT ('%', :memo, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."tenpu_file")) LIKE UPPER (CONCAT ('%', :tenpu_file, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."nen_y")) LIKE UPPER (CONCAT ('%', :nen_y, '%')) 
    AND a."nen_y" >= :nen_y_1 
    AND a."nen_y" <= :nen_y_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."tsuki_m")) LIKE UPPER (CONCAT ('%', :tsuki_m, '%')) 
    AND a."tsuki_m" >= :tsuki_m_1 
    AND a."tsuki_m" <= :tsuki_m_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."hi_d")) LIKE UPPER (CONCAT ('%', :hi_d, '%')) 
    AND a."hi_d" >= :hi_d_1 
    AND a."hi_d" <= :hi_d_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."nengetsu_ym")) LIKE UPPER (CONCAT ('%', :nengetsu_ym, '%')) 
    AND a."nengetsu_ym" >= :nengetsu_ym_1 
    AND a."nengetsu_ym" <= :nengetsu_ym_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."nengappi_ymd")) LIKE UPPER (CONCAT ('%', :nengappi_ymd, '%')) 
    AND a."nengappi_ymd" >= :nengappi_ymd_1 
    AND a."nengappi_ymd" <= :nengappi_ymd_2 
    AND a."timestamp_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:timestamp_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."timestamp_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:timestamp_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."timestamp_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:timestamp_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."nichiji_dt" = TO_TIMESTAMP (REPLACE (SUBSTR (:nichiji_dt, 0, 19), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS') 
    AND a."nichiji_dt" >= TO_TIMESTAMP (REPLACE (SUBSTR (:nichiji_dt_1 , 0, 19), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS')
    AND a."nichiji_dt" <= TO_TIMESTAMP (REPLACE (SUBSTR (:nichiji_dt_2 , 0, 19), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS')
    AND a."hiduke_bi" = TO_DATE (SUBSTR (:hiduke_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."hiduke_bi" >= TO_DATE (SUBSTR (:hiduke_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."hiduke_bi" <= TO_DATE (SUBSTR (:hiduke_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."jikoku_hm" = :jikoku_hm 
    AND a."jikoku_hm" >= :jikoku_hm_1 
    AND a."jikoku_hm" <= :jikoku_hm_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."jikan_tm")) LIKE UPPER (CONCAT ('%', :jikan_tm, '%')) 
    AND a."jikan_tm" >= :jikan_tm_1 
    AND a."jikan_tm" <= :jikan_tm_2 
    AND TRIM(TRAILING ' ' FROM a."tsuka_kb") IN (:tsuka_kb) 
    AND a."juchu_qt" = :juchu_qt 
    AND a."juchu_qt" >= :juchu_qt_1 
    AND a."juchu_qt" <= :juchu_qt_2 
    AND a."juchu_pr" = :juchu_pr 
    AND a."juchu_pr" >= :juchu_pr_1 
    AND a."juchu_pr" <= :juchu_pr_2 
    AND a."juchu_am" = :juchu_am 
    AND a."juchu_am" >= :juchu_am_1 
    AND a."juchu_am" <= :juchu_am_2 
    AND a."hacchu_qt" = :hacchu_qt 
    AND a."hacchu_qt" >= :hacchu_qt_1 
    AND a."hacchu_qt" <= :hacchu_qt_2 
    AND a."hacchu_pr" = :hacchu_pr 
    AND a."hacchu_pr" >= :hacchu_pr_1 
    AND a."hacchu_pr" <= :hacchu_pr_2 
    AND a."hacchu_am" = :hacchu_am 
    AND a."hacchu_am" >= :hacchu_am_1 
    AND a."hacchu_am" <= :hacchu_am_2 
    AND CASE WHEN TRIM(TRAILING ' ' FROM a."delete_f") IS NULL THEN '0' ELSE TO_CHAR (a."delete_f") END IN (:delete_f) 
    AND TRIM(TRAILING ' ' FROM a."status_kb") IN (:status_kb) 
    AND a."insert_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."insert_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."insert_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."insert_user_id")) LIKE UPPER (CONCAT ('%', :insert_user_id, '%')) 
    AND a."update_ts" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."update_ts" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."update_ts" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND UPPER (TRIM(TRAILING ' ' FROM a."update_user_id")) LIKE UPPER (CONCAT ('%', :update_user_id, '%')) 
ORDER BY
    a."entity_id"
