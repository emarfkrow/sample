SELECT
      a."ENTITY_ID" AS "ENTITY_ID"
    , a."ENTITY_NM" AS "ENTITY_NM"
    , a."ENTITY_MEI" AS "ENTITY_MEI"
    , a."BIT_B" AS "BIT_B"
    , RTRIM (RTRIM (a."CHECK_F"), '　') AS "CHECK_F"
    , a."RADIO_KB" AS "RADIO_KB"
    , a."PULLDOWN_KB" AS "PULLDOWN_KB"
    , a."PULLDOWN_SB" AS "PULLDOWN_SB"
    , a."MEMO_TX" AS "MEMO_TX"
    , a."MEMO" AS "MEMO"
    , a."TENPU_FILE" AS "TENPU_FILE"
    , RTRIM (RTRIM (a."NEN_Y"), '　') AS "NEN_Y"
    , RTRIM (RTRIM (a."TSUKI_M"), '　') AS "TSUKI_M"
    , RTRIM (RTRIM (a."HI_D"), '　') AS "HI_D"
    , RTRIM (RTRIM (a."NENGETSU_YM"), '　') AS "NENGETSU_YM"
    , RTRIM (RTRIM (a."NENGAPPI_YMD"), '　') AS "NENGAPPI_YMD"
    , TO_CHAR (a."TIMESTAMP_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "TIMESTAMP_TS"
    , TO_CHAR (a."NICHIJI_DT", 'YYYY-MM-DD HH24:MI:SS') AS "NICHIJI_DT"
    , TO_CHAR (a."HIDUKE_BI", 'YYYY-MM-DD') AS "HIDUKE_BI"
    , TO_CHAR (a."JIKOKU_HM", 'HH24:MI') AS "JIKOKU_HM"
    , a."JIKAN_TM" AS "JIKAN_TM"
    , a."TSUKA_KB" AS "TSUKA_KB"
    , a."JUCHU_QT" AS "JUCHU_QT"
    , a."JUCHU_PR" AS "JUCHU_PR"
    , a."JUCHU_AM" AS "JUCHU_AM"
    , a."HACCHU_QT" AS "HACCHU_QT"
    , a."HACCHU_PR" AS "HACCHU_PR"
    , a."HACCHU_AM" AS "HACCHU_AM"
    , RTRIM (RTRIM (a."DELETE_F"), '　') AS "DELETE_F"
    , a."STATUS_KB" AS "STATUS_KB"
    , TO_CHAR (a."INSERT_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "INSERT_TS"
    , a."INSERT_USER_ID" AS "INSERT_USER_ID"
    , (SELECT r0."USER_SEI" FROM MHR_USER r0 WHERE r0."USER_ID" = a."INSERT_USER_ID") AS "INSERT_USER_SEI"
    , TO_CHAR (a."UPDATE_TS", 'YYYY-MM-DD HH24:MI:SS.FF3') AS "UPDATE_TS"
    , a."UPDATE_USER_ID" AS "UPDATE_USER_ID"
    , (SELECT r1."USER_SEI" FROM MHR_USER r1 WHERE r1."USER_ID" = a."UPDATE_USER_ID") AS "UPDATE_USER_SEI"
FROM
    T00_ENTITY a 
WHERE
    1 = 1 
    AND a."ENTITY_ID" = :entity_id 
    AND UPPER (RTRIM (RTRIM (a."ENTITY_NM"), '　')) LIKE UPPER ('%' || :entity_nm || '%') 
    AND UPPER (RTRIM (RTRIM (a."ENTITY_MEI"), '　')) LIKE UPPER ('%' || :entity_mei || '%') 
    AND a."BIT_B" = :bit_b 
    AND CASE WHEN RTRIM (RTRIM (a."CHECK_F"), '　') IS NULL THEN '0' ELSE TO_CHAR (a."CHECK_F") END IN (:check_f) 
    AND RTRIM (RTRIM (a."RADIO_KB"), '　') IN (:radio_kb) 
    AND RTRIM (RTRIM (a."PULLDOWN_KB"), '　') IN (:pulldown_kb) 
    AND RTRIM (RTRIM (a."PULLDOWN_SB"), '　') IN (:pulldown_sb) 
    AND UPPER (RTRIM (RTRIM (a."MEMO_TX"), '　')) LIKE UPPER ('%' || :memo_tx || '%') 
    AND UPPER (RTRIM (RTRIM (a."MEMO"), '　')) LIKE UPPER ('%' || :memo || '%') 
    AND UPPER (RTRIM (RTRIM (a."TENPU_FILE"), '　')) LIKE UPPER ('%' || :tenpu_file || '%') 
    AND UPPER (RTRIM (RTRIM (a."NEN_Y"), '　')) LIKE UPPER ('%' || :nen_y || '%') 
    AND a."NEN_Y" >= :nen_y_1 
    AND a."NEN_Y" <= :nen_y_2 
    AND UPPER (RTRIM (RTRIM (a."TSUKI_M"), '　')) LIKE UPPER ('%' || :tsuki_m || '%') 
    AND a."TSUKI_M" >= :tsuki_m_1 
    AND a."TSUKI_M" <= :tsuki_m_2 
    AND UPPER (RTRIM (RTRIM (a."HI_D"), '　')) LIKE UPPER ('%' || :hi_d || '%') 
    AND a."HI_D" >= :hi_d_1 
    AND a."HI_D" <= :hi_d_2 
    AND UPPER (RTRIM (RTRIM (a."NENGETSU_YM"), '　')) LIKE UPPER ('%' || :nengetsu_ym || '%') 
    AND a."NENGETSU_YM" >= :nengetsu_ym_1 
    AND a."NENGETSU_YM" <= :nengetsu_ym_2 
    AND UPPER (RTRIM (RTRIM (a."NENGAPPI_YMD"), '　')) LIKE UPPER ('%' || :nengappi_ymd || '%') 
    AND a."NENGAPPI_YMD" >= :nengappi_ymd_1 
    AND a."NENGAPPI_YMD" <= :nengappi_ymd_2 
    AND a."TIMESTAMP_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:timestamp_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."TIMESTAMP_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:timestamp_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."TIMESTAMP_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:timestamp_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."NICHIJI_DT" = TO_TIMESTAMP (REPLACE (SUBSTR (:nichiji_dt, 0, 19), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS') 
    AND a."NICHIJI_DT" >= TO_TIMESTAMP (REPLACE (SUBSTR (:nichiji_dt_1 , 0, 19), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS')
    AND a."NICHIJI_DT" <= TO_TIMESTAMP (REPLACE (SUBSTR (:nichiji_dt_2 , 0, 19), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS')
    AND a."HIDUKE_BI" = TO_DATE (SUBSTR (:hiduke_bi, 0, 10), 'YYYY-MM-DD') 
    AND a."HIDUKE_BI" >= TO_DATE (SUBSTR (:hiduke_bi_1 , 0, 10), 'YYYY-MM-DD')
    AND a."HIDUKE_BI" <= TO_DATE (SUBSTR (:hiduke_bi_2 , 0, 10), 'YYYY-MM-DD')
    AND a."JIKOKU_HM" = :jikoku_hm 
    AND a."JIKOKU_HM" >= :jikoku_hm_1 
    AND a."JIKOKU_HM" <= :jikoku_hm_2 
    AND UPPER (RTRIM (RTRIM (a."JIKAN_TM"), '　')) LIKE UPPER ('%' || :jikan_tm || '%') 
    AND a."JIKAN_TM" >= :jikan_tm_1 
    AND a."JIKAN_TM" <= :jikan_tm_2 
    AND RTRIM (RTRIM (a."TSUKA_KB"), '　') IN (:tsuka_kb) 
    AND a."JUCHU_QT" = :juchu_qt 
    AND a."JUCHU_QT" >= :juchu_qt_1 
    AND a."JUCHU_QT" <= :juchu_qt_2 
    AND a."JUCHU_PR" = :juchu_pr 
    AND a."JUCHU_PR" >= :juchu_pr_1 
    AND a."JUCHU_PR" <= :juchu_pr_2 
    AND a."JUCHU_AM" = :juchu_am 
    AND a."JUCHU_AM" >= :juchu_am_1 
    AND a."JUCHU_AM" <= :juchu_am_2 
    AND a."HACCHU_QT" = :hacchu_qt 
    AND a."HACCHU_QT" >= :hacchu_qt_1 
    AND a."HACCHU_QT" <= :hacchu_qt_2 
    AND a."HACCHU_PR" = :hacchu_pr 
    AND a."HACCHU_PR" >= :hacchu_pr_1 
    AND a."HACCHU_PR" <= :hacchu_pr_2 
    AND a."HACCHU_AM" = :hacchu_am 
    AND a."HACCHU_AM" >= :hacchu_am_1 
    AND a."HACCHU_AM" <= :hacchu_am_2 
    AND CASE WHEN RTRIM (RTRIM (a."DELETE_F"), '　') IS NULL THEN '0' ELSE TO_CHAR (a."DELETE_F") END IN (:delete_f) 
    AND RTRIM (RTRIM (a."STATUS_KB"), '　') IN (:status_kb) 
    AND a."INSERT_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."INSERT_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."INSERT_USER_ID" = :insert_user_id 
    AND a."UPDATE_TS" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3') 
    AND a."UPDATE_TS" >= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_1 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_TS" <= TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts_2 , 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')
    AND a."UPDATE_USER_ID" = :update_user_id 
ORDER BY
    a."ENTITY_ID"
