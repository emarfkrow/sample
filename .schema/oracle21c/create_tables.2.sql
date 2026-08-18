-- Project Name : emarf
-- Date/Time    : 2026/08/17 8:27:54
-- Author       : KTC0966
-- RDBMS Type   : Oracle Database
-- Application  : A5:SQL Mk-2

-- 実績
create table T14_JISSEKI (
  KOUTEI_ID NUMBER(10)
  , JISSEKI_BN NUMBER(10)
  , JISSHI_YMD CHAR(8) not null
  , KANRYO_YMD CHAR(8) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID CHAR(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID CHAR(10) not null
  , constraint T14_JISSEKI_PKC primary key (KOUTEI_ID,JISSEKI_BN)
) ;

-- 工程
create table T14_KOUTEI (
  KOUTEI_ID NUMBER(10)
  , KOUTEI_MEI VARCHAR2(60) not null
  , KAISHI_YMD CHAR(8) not null
  , SHURYO_YMD CHAR(8) not null
  , SAGYOKU_CD CHAR(10) not null
  , OYA_KOUTEI_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID CHAR(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID CHAR(10) not null
  , constraint T14_KOUTEI_PKC primary key (KOUTEI_ID)
) ;

-- 稼働日負荷
create view V14_FUKA_KADOBI as 
SELECT
      b.kado_ymd                   AS labels
    , 'bar'                        AS type
    , 'stack'                      AS stack
    , b.sagyoku_cd                 AS label
    , COALESCE (k.koutei_count, 0) AS DATA 
FROM
    ( 
        SELECT
              * 
        FROM
            (SELECT DISTINCT b.kado_ymd FROM msy_kadobi b) b 
            CROSS JOIN (SELECT DISTINCT k.sagyoku_cd FROM t14_koutei k) k
    ) b 
    LEFT OUTER JOIN ( 
        SELECT
              b.kado_ymd
            , k.sagyoku_cd
            , COUNT(k.koutei_id) AS koutei_count 
        FROM
            ( 
                SELECT DISTINCT
                      b.kado_ymd 
                FROM
                    msy_kadobi b 
                WHERE
                    b.kadobi_f = '1'
            ) b 
            INNER JOIN t14_koutei k 
                ON k.kaishi_ymd <= b.kado_ymd 
                AND b.kado_ymd <= k.shuryo_ymd 
        GROUP BY
            b.kado_ymd
            , k.sagyoku_cd
    ) k 
        ON k.kado_ymd = b.kado_ymd 
        AND k.sagyoku_cd = b.sagyoku_cd 
ORDER BY
    b.kado_ymd
    , b.sagyoku_cd

;

-- 作業区負荷
create view V14_FUKA_SAGYOKU as 
SELECT
      b.kado_ymd                   AS labels
    , 'line'                       AS type
    , b.sagyoku_cd                 AS stack
    , b.sagyoku_cd                 AS label
    , COALESCE (k.koutei_count, 0) AS DATA 
FROM
    ( 
        SELECT
              * 
        FROM
            (SELECT DISTINCT b.kado_ymd FROM msy_kadobi b) b 
            CROSS JOIN (SELECT DISTINCT k.sagyoku_cd FROM t14_koutei k) k
    ) b 
    LEFT OUTER JOIN ( 
        SELECT
              b.kado_ymd
            , k.sagyoku_cd
            , COUNT(k.koutei_id) AS koutei_count 
        FROM
            ( 
                SELECT DISTINCT
                      b.kado_ymd 
                FROM
                    msy_kadobi b 
                WHERE
                    b.kadobi_f = '1'
            ) b 
            INNER JOIN t14_koutei k 
                ON k.kaishi_ymd <= b.kado_ymd 
                AND b.kado_ymd <= k.shuryo_ymd 
        GROUP BY
            b.kado_ymd
            , k.sagyoku_cd
    ) k 
        ON k.kado_ymd = b.kado_ymd 
        AND k.sagyoku_cd = b.sagyoku_cd 
ORDER BY
    b.kado_ymd
    , b.sagyoku_cd

;

-- 予実
create view V14_YOJITSU as 
SELECT
      * 
FROM
    ( 
        SELECT
              a.koutei_id
            , a.koutei_mei                                      AS koutei_tx
            , a.kaishi_ymd
            , a.shuryo_ymd
            , a.sagyoku_cd
            , a.oya_koutei_id
            , j.jisshi_ymd
            , j.kanryo_ymd
            , b.dependencies                    --前工程
            , SUBSTR (sys_connect_by_path(a.koutei_id, ','), 2) AS koutei_path
            , CONNECT_BY_ROOT a.koutei_id                       AS root 
        FROM
            t14_koutei a 
            LEFT OUTER JOIN t14_jisseki j 
                ON j.koutei_id = a.koutei_id 
            LEFT OUTER JOIN ( 
                SELECT
                      oya_koutei_id
                    , LISTAGG (koutei_id, ',') WITHIN GROUP (ORDER BY koutei_id) AS dependencies 
                FROM
                    t14_koutei 
                WHERE
                    oya_koutei_id IS NOT NULL 
                GROUP BY
                    oya_koutei_id
            ) b 
                ON b.oya_koutei_id = a.koutei_id 
        START WITH
            a.oya_koutei_id IS NULL 
        CONNECT BY
            PRIOR a.koutei_id = a.oya_koutei_id
    ) a 
ORDER BY
    a.koutei_path DESC

;

comment on table T14_JISSEKI is '実績';
comment on column T14_JISSEKI.KOUTEI_ID is '工程ID';
comment on column T14_JISSEKI.JISSEKI_BN is '実績連番';
comment on column T14_JISSEKI.JISSHI_YMD is '実施日';
comment on column T14_JISSEKI.KANRYO_YMD is '完了日';
comment on column T14_JISSEKI.INSERT_TS is '作成タイムスタンプ';
comment on column T14_JISSEKI.INSERT_USER_ID is '作成者';
comment on column T14_JISSEKI.UPDATE_TS is '更新タイムスタンプ';
comment on column T14_JISSEKI.UPDATE_USER_ID is '更新者';

comment on table T14_KOUTEI is '工程';
comment on column T14_KOUTEI.KOUTEI_ID is '工程ID';
comment on column T14_KOUTEI.KOUTEI_MEI is '工程名';
comment on column T14_KOUTEI.KAISHI_YMD is '開始年月日';
comment on column T14_KOUTEI.SHURYO_YMD is '終了年月日';
comment on column T14_KOUTEI.SAGYOKU_CD is '作業区CD';
comment on column T14_KOUTEI.OYA_KOUTEI_ID is '親工程ID';
comment on column T14_KOUTEI.INSERT_TS is '作成タイムスタンプ';
comment on column T14_KOUTEI.INSERT_USER_ID is '作成者';
comment on column T14_KOUTEI.UPDATE_TS is '更新タイムスタンプ';
comment on column T14_KOUTEI.UPDATE_USER_ID is '更新者';

comment on table V14_FUKA_KADOBI is '稼働日負荷';
comment on column V14_FUKA_KADOBI.labels is 'labels';
comment on column V14_FUKA_KADOBI.type is 'type';
comment on column V14_FUKA_KADOBI.stack is 'stack';
comment on column V14_FUKA_KADOBI.label is 'label';
comment on column V14_FUKA_KADOBI.DATA is 'DATA';

comment on table V14_FUKA_SAGYOKU is '作業区負荷';
comment on column V14_FUKA_SAGYOKU.labels is 'labels';
comment on column V14_FUKA_SAGYOKU.type is 'type';
comment on column V14_FUKA_SAGYOKU.stack is 'stack';
comment on column V14_FUKA_SAGYOKU.label is 'label';
comment on column V14_FUKA_SAGYOKU.DATA is 'DATA';

comment on table V14_YOJITSU is '予実:oracle';
comment on column V14_YOJITSU.koutei_id is 'koutei_id';
comment on column V14_YOJITSU.koutei_tx is 'koutei_tx';
comment on column V14_YOJITSU.kaishi_ymd is 'kaishi_ymd';
comment on column V14_YOJITSU.shuryo_ymd is 'shuryo_ymd';
comment on column V14_YOJITSU.sagyoku_cd is 'sagyoku_cd';
comment on column V14_YOJITSU.oya_koutei_id is 'oya_koutei_id';
comment on column V14_YOJITSU.jisshi_ymd is 'jisshi_ymd';
comment on column V14_YOJITSU.kanryo_ymd is 'kanryo_ymd';
comment on column V14_YOJITSU.dependencies is 'dependencies';
comment on column V14_YOJITSU.koutei_path is 'koutei_path';
comment on column V14_YOJITSU.root is 'root';

