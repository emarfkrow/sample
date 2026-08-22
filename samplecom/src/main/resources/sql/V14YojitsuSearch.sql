SELECT
      a."koutei_id" AS "koutei_id"
    , a."koutei_tx" AS "koutei_tx"
    , a."kaishi_ymd" AS "kaishi_ymd"
    , a."shuryo_ymd" AS "shuryo_ymd"
    , TRIM(TRAILING ' ' FROM a."sagyoku_cd") AS "sagyoku_cd"
    , a."oya_koutei_id" AS "oya_koutei_id"
    , a."jisshi_ymd" AS "jisshi_ymd"
    , a."kanryo_ymd" AS "kanryo_ymd"
    , a."dependencies" AS "dependencies"
    , a."koutei_path" AS "koutei_path"
    , a."root" AS "root"
FROM
    V14_YOJITSU a 
WHERE
    1 = 1 
    AND a."koutei_id" = CAST (:koutei_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."koutei_tx")) LIKE UPPER (CONCAT ('%', :koutei_tx, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kaishi_ymd")) LIKE UPPER (CONCAT ('%', :kaishi_ymd, '%')) 
    AND a."kaishi_ymd" >= :kaishi_ymd_1 
    AND a."kaishi_ymd" <= :kaishi_ymd_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."shuryo_ymd")) LIKE UPPER (CONCAT ('%', :shuryo_ymd, '%')) 
    AND a."shuryo_ymd" >= :shuryo_ymd_1 
    AND a."shuryo_ymd" <= :shuryo_ymd_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."sagyoku_cd")) LIKE UPPER (CONCAT ('%', :sagyoku_cd, '%')) 
    AND a."oya_koutei_id" = CAST (:oya_koutei_id AS INTEGER) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."jisshi_ymd")) LIKE UPPER (CONCAT ('%', :jisshi_ymd, '%')) 
    AND a."jisshi_ymd" >= :jisshi_ymd_1 
    AND a."jisshi_ymd" <= :jisshi_ymd_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."kanryo_ymd")) LIKE UPPER (CONCAT ('%', :kanryo_ymd, '%')) 
    AND a."kanryo_ymd" >= :kanryo_ymd_1 
    AND a."kanryo_ymd" <= :kanryo_ymd_2 
    AND UPPER (TRIM(TRAILING ' ' FROM a."dependencies")) LIKE UPPER (CONCAT ('%', :dependencies, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a."koutei_path")) LIKE UPPER (CONCAT ('%', :koutei_path, '%')) 
    AND a."root" = CAST (:root AS INTEGER) 
