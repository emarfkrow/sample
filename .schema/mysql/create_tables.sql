-- Project Name : emarf
-- Date/Time    : 2026/01/21 8:24:02
-- Author       : KTC0966
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- 部署マスタ
drop table if exists MHR_BUSHO cascade;

create table MHR_BUSHO (
  BUSHO_ID INT not null comment '部署ID'
  , BUSHO_MEI VARCHAR(60) not null comment '部署名'
  , OYA_BUSHO_ID INT comment '親部署ID'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MHR_BUSHO_PKC primary key (BUSHO_ID)
) comment '部署マスタ' ;

-- 職位マスタ
drop table if exists MHR_SHOKUI cascade;

create table MHR_SHOKUI (
  SHOKUI_ID INT not null comment '職位ID'
  , SHOKUI_MEI VARCHAR(60) not null comment '職位名'
  , SHOKUI_ON INT not null comment '職位順'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MHR_SHOKUI_PKC primary key (SHOKUI_ID)
) comment '職位マスタ' ;

-- 認可マスタ
drop table if exists MHR_SHOKUI_NINKA cascade;

create table MHR_SHOKUI_NINKA (
  BUSHO_ID INT not null comment '部署ID'
  , SHOKUI_ID INT not null comment '職位ID'
  , KINO_NM VARCHAR(20) not null comment '機能名称'
  , KENGEN_KB VARCHAR(2) not null comment '権限区分'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MHR_SHOKUI_NINKA_PKC primary key (BUSHO_ID,SHOKUI_ID,KINO_NM)
) comment '認可マスタ' ;

-- ユーザマスタ
drop table if exists MHR_USER cascade;

create table MHR_USER (
  USER_ID INT not null comment 'ユーザID'
  , USER_SEI VARCHAR(60) not null comment 'ユーザ姓'
  , USER_MEI VARCHAR(60) not null comment 'ユーザ名'
  , E_MAIL VARCHAR(300) not null comment 'メールアドレス'
  , PASSWORD VARCHAR(300) not null comment 'パスワード'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MHR_USER_PKC primary key (USER_ID)
) comment 'ユーザマスタ' ;

-- 所属マスタ
drop table if exists MHR_USER_POS cascade;

create table MHR_USER_POS (
  BUSHO_ID INT not null comment '部署ID'
  , SHOKUI_ID INT not null comment '職位ID'
  , USER_ID INT not null comment 'ユーザID'
  , TEKIYO_BI DATE not null comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MHR_USER_POS_PKC primary key (BUSHO_ID,SHOKUI_ID,USER_ID,TEKIYO_BI)
) comment '所属マスタ' ;

-- 稼働日マスタ
drop table if exists MSY_KADOBI cascade;

create table MSY_KADOBI (
  KADO_BI DATE comment '稼働日'
  , BUSHO_ID INT comment '部署ID'
  , KADOBI_F CHAR(1) not null comment '稼働日フラグ'
  , MEMO VARCHAR(300) comment 'メモ'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MSY_KADOBI_PKC primary key (KADO_BI,BUSHO_ID)
) comment '稼働日マスタ' ;

-- 区分マスタ
drop table if exists MSY_KBN cascade;

create table MSY_KBN (
  KBN_NM VARCHAR(20) not null comment '区分名称'
  , KBN_MEI VARCHAR(60) not null comment '区分名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MSY_KBN_PKC primary key (KBN_NM)
) comment '区分マスタ' ;

-- 区分値マスタ
drop table if exists MSY_KBN_VAL cascade;

create table MSY_KBN_VAL (
  KBN_NM VARCHAR(20) not null comment '区分名称'
  , KBN_VAL VARCHAR(2) not null comment '区分値'
  , KBN_VAL_MEI VARCHAR(60) not null comment '区分値名'
  , HYOJI_ON INT comment '表示順'
  , CRITERIA VARCHAR(300) comment '取得条件'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MSY_KBN_VAL_PKC primary key (KBN_NM,KBN_VAL)
) comment '区分値マスタ' ;

-- 税マスタ
drop table if exists MSY_TAX cascade;

create table MSY_TAX (
  TAX_KB VARCHAR(2) comment '税区分'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , TAX_RT DECIMAL(5,2) not null comment '税率'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MSY_TAX_PKC primary key (TAX_KB,TEKIYO_BI)
) comment '税マスタ' ;

-- 通貨マスタ
drop table if exists MSY_TSUKA cascade;

create table MSY_TSUKA (
  TSUKA_KB VARCHAR(2) comment '通貨区分'
  , TEKIYO_BI DATE comment '適用日'
  , TTS DECIMAL(5,2) not null comment '販売レート'
  , TTB DECIMAL(5,2) not null comment '買取レート'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint MSY_TSUKA_PKC primary key (TSUKA_KB,TEKIYO_BI)
) comment '通貨マスタ' ;

-- エンティティ
drop table if exists TB0_ENTITY cascade;

create table TB0_ENTITY (
  ENTITY_ID INT not null comment 'エンティティID'
  , ENTITY_NM VARCHAR(20) not null comment 'エンティティ名称'
  , ENTITY_MEI VARCHAR(60) not null comment 'エンティティ名'
  , CHECK_F CHAR(1) not null comment 'チェックフラグ'
  , RADIO_KB VARCHAR(2) not null comment 'ラジオ区分'
  , PULLDOWN_KB VARCHAR(2) not null comment 'プルダウン区分'
  , PULLDOWN_SB VARCHAR(2) not null comment 'プルダウン種別'
  , MEMO_TX VARCHAR(300) not null comment 'メモ'
  , MEMO VARCHAR(300) not null comment '１行メモ'
  , TENPU_FILE VARCHAR(300) not null comment '添付ファイル'
  , NENGAPPI_Y CHAR(4) not null comment '年月日年'
  , NENGAPPI_M CHAR(2) not null comment '年月日月'
  , NENGAPPI_D CHAR(2) not null comment '年月日日'
  , NENGETSU_YM CHAR(6) not null comment '年月'
  , NENGAPPI_YMD CHAR(8) not null comment '年月日'
  , TIMESTAMP_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment 'タイムスタンプ'
  , NICHIJI_DT DATETIME not null comment '日時'
  , HIDUKE_BI DATE not null comment '日付'
  , JIKOKU_HM TIME not null comment '時刻'
  , JIKAN_TM VARCHAR(9) not null comment '時間'
  , SURYO_QT DECIMAL(11,3) not null comment '数量'
  , TSUKA_KB VARCHAR(2) not null comment '通貨区分'
  , JUCHU_PR DECIMAL(11,2) not null comment '受注単価'
  , JUCHU_AM DECIMAL(11,2) not null comment '受注金額'
  , HACHU_PR DECIMAL(11,2) not null comment '発注単価'
  , HACHU_AM DECIMAL(11,2) not null comment '発注金額'
  , DELETE_F CHAR(1) default 0 comment '削除フラグ:必須チェックにかかるのでNOTNULLにしない'
  , STATUS_KB VARCHAR(2) default 0 comment 'ステータス区分:必須チェックにかかるのでNOTNULLにしない'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB0_ENTITY_PKC primary key (ENTITY_ID)
) comment 'エンティティ' ;

-- 主キーなし
drop table if exists TB0_NOKEY cascade;

create table TB0_NOKEY (
  COL_A VARCHAR(60) comment '列Ａ'
  , COL_B VARCHAR(60) comment '列Ｂ'
  , COL_C VARCHAR(60) comment '列Ｃ'
  , COL_D VARCHAR(60) comment '列Ｄ'
  , COL_E VARCHAR(60) comment '列Ｅ'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
) comment '主キーなし' ;

create unique index TB0_NOKEY_IX1
  on TB0_NOKEY(COL_A,COL_B,COL_C);

create unique index TB0_NOKEY_IX2
  on TB0_NOKEY(COL_D,COL_E);

-- CD参照マスタ
drop table if exists TB1_CDREF cascade;

create table TB1_CDREF (
  CDREF_CD CHAR(10) comment '参照CD'
  , CDREF_MEI VARCHAR(60) not null comment '参照CD名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_CDREF_PKC primary key (CDREF_CD)
) comment 'CD参照マスタ' ;

-- 複合１
drop table if exists TB1_COMBO1 cascade;

create table TB1_COMBO1 (
  REFER1_ID INT comment '参照１ID'
  , REFER2_ID INT comment '参照２ID'
  , COMBO1_INFO VARCHAR(300) comment '複合１情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_COMBO1_PKC primary key (REFER1_ID,REFER2_ID)
) comment '複合１' ;

-- 複合２
drop table if exists TB1_COMBO2 cascade;

create table TB1_COMBO2 (
  REFER1_ID INT comment '参照１ID'
  , REFER2_ID INT comment '参照２ID'
  , REFER3_ID INT comment '参照３ID'
  , TEKIYO_BI DATE comment '適用日'
  , COMBO2_INFO VARCHAR(300) comment '複合２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_COMBO2_PKC primary key (REFER1_ID,REFER2_ID,REFER3_ID,TEKIYO_BI)
) comment '複合２' ;

-- ID連番マスタ
drop table if exists TB1_IDBN cascade;

create table TB1_IDBN (
  IDREF_ID INT comment '参照ID'
  , IDBN_BN INT comment '参照ID連番'
  , IDBN_NO CHAR(10) not null comment 'ID連番NO'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_IDBN_PKC primary key (IDREF_ID,IDBN_BN)
) comment 'ID連番マスタ' ;

-- ID参照マスタ
drop table if exists TB1_IDREF cascade;

create table TB1_IDREF (
  IDREF_ID INT comment '参照ID'
  , IDREF_MEI VARCHAR(60) not null comment '参照ID名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_IDREF_PKC primary key (IDREF_ID)
) comment 'ID参照マスタ' ;

-- NO参照マスタ
drop table if exists TB1_NOREF cascade;

create table TB1_NOREF (
  NOREF_NO CHAR(10) comment '参照NO'
  , NOREF_MEI VARCHAR(60) not null comment '参照NO名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_NOREF_PKC primary key (NOREF_NO)
) comment 'NO参照マスタ' ;

-- 参照１マスタ
drop table if exists TB1_REFER1 cascade;

create table TB1_REFER1 (
  REFER1_ID INT comment '参照１ID'
  , REFER1_MEI VARCHAR(60) not null comment '参照１名'
  , DELETE_F CHAR(1) comment '削除フラグ'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_REFER1_PKC primary key (REFER1_ID)
) comment '参照１マスタ' ;

-- 参照２マスタ
drop table if exists TB1_REFER2 cascade;

create table TB1_REFER2 (
  REFER2_ID INT comment '参照２ID'
  , REFER2_MEI VARCHAR(60) not null comment '参照２名'
  , DELETE_F CHAR(1) comment '削除フラグ'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_REFER2_PKC primary key (REFER2_ID)
) comment '参照２マスタ' ;

-- 参照３マスタ
drop table if exists TB1_REFER3 cascade;

create table TB1_REFER3 (
  REFER3_ID INT comment '参照３ID'
  , REFER3_MEI VARCHAR(60) not null comment '参照３名'
  , DELETE_F CHAR(1) comment '削除フラグ'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_REFER3_PKC primary key (REFER3_ID)
) comment '参照３マスタ' ;

-- 再帰
drop table if exists TB1_SAIKI cascade;

create table TB1_SAIKI (
  SAIKI_ID INT comment '再帰ID'
  , SAIKI_MEI VARCHAR(60) not null comment '再帰名'
  , IDREF_ID INT comment '参照ID'
  , CDREF_CD CHAR(10) comment '参照CD'
  , NOREF_NO CHAR(10) comment '参照NO'
  , EX_IDREF_ID INT comment '別参照ID'
  , IDBN_BN INT comment 'ID連番'
  , OYA_SAIKI_ID INT comment '親再帰ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB1_SAIKI_PKC primary key (SAIKI_ID)
) comment '再帰' ;

-- 長兄
drop table if exists TB2_ELDEST cascade;

create table TB2_ELDEST (
  BRO_ID INT comment '兄弟ID'
  , ELDEST_INFO VARCHAR(300) comment '長兄情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB2_ELDEST_PKC primary key (BRO_ID)
) comment '長兄' ;

-- 里子
drop table if exists TB2_FOSTER cascade;

create table TB2_FOSTER (
  BRO_ID INT comment '兄弟ID'
  , FOSTER_INFO VARCHAR(300) comment '里子情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB2_FOSTER_PKC primary key (BRO_ID)
) comment '里子' ;

-- 弟
drop table if exists TB2_YOUNGER cascade;

create table TB2_YOUNGER (
  BRO_ID INT comment '兄弟ID'
  , YOUNGER_INFO VARCHAR(300) comment '弟情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB2_YOUNGER_PKC primary key (BRO_ID)
) comment '弟' ;

-- 末弟
drop table if exists TB2_YOUNGEST cascade;

create table TB2_YOUNGEST (
  BRO_ID INT comment '兄弟ID'
  , YOUNGEST_INFO VARCHAR(300) comment '末弟情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB2_YOUNGEST_PKC primary key (BRO_ID)
) comment '末弟' ;

-- 当初
drop table if exists TB3_BEGIN cascade;

create table TB3_BEGIN (
  BEGIN_ID INT comment '当初ID'
  , BEGIN_INFO VARCHAR(300) comment '当初情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB3_BEGIN_PKC primary key (BEGIN_ID)
) comment '当初' ;

-- 履歴
drop table if exists TB3_BEGIN_HIS cascade;

create table TB3_BEGIN_HIS (
  BEGIN_ID INT comment '当初ID'
  , RIREKI_BN INT comment '履歴枝番'
  , BEGIN_INFO VARCHAR(300) comment '当初情報'
  , REASON VARCHAR(300) not null comment '変更理由'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB3_BEGIN_HIS_PKC primary key (BEGIN_ID,RIREKI_BN)
) comment '履歴' ;

-- 子
drop table if exists TB4_KO cascade;

create table TB4_KO (
  OYA_ID INT comment '親ID'
  , KO_BN INT comment '子枝番'
  , KO_INFO VARCHAR(300) comment '子情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB4_KO_PKC primary key (OYA_ID,KO_BN)
) comment '子' ;

-- 子なし
drop table if exists TB4_KO_DINKS cascade;

create table TB4_KO_DINKS (
  OYA_ID INT comment '親ID'
  , KO_BN INT comment '子枝番'
  , DINKS_INFO VARCHAR(300) comment '子なし情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB4_KO_DINKS_PKC primary key (OYA_ID,KO_BN)
) comment '子なし' ;

-- 孤児
drop table if exists TB4_KO_ORPHANS cascade;

create table TB4_KO_ORPHANS (
  OYA_ID INT comment '親ID'
  , KO_BN INT comment '子枝番'
  , ORPHANS_INFO VARCHAR(300) comment '孤児情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB4_KO_ORPHANS_PKC primary key (OYA_ID,KO_BN)
) comment '孤児' ;

-- 孫
drop table if exists TB4_MAGO cascade;

create table TB4_MAGO (
  OYA_ID INT comment '親ID'
  , KO_BN INT comment '子枝番'
  , MAGO_BN INT comment '孫枝番'
  , MAGO_INFO VARCHAR(300) comment '孫情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB4_MAGO_PKC primary key (OYA_ID,KO_BN,MAGO_BN)
) comment '孫' ;

-- 親
drop table if exists TB4_OYA cascade;

create table TB4_OYA (
  OYA_ID INT comment '親ID'
  , OYA_INFO VARCHAR(300) comment '親情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB4_OYA_PKC primary key (OYA_ID)
) comment '親' ;

-- 派生
drop table if exists TB5_DERIVE cascade;

create table TB5_DERIVE (
  DERIVE_ID INT comment '派生ID'
  , PREV_ID INT comment '前世ID'
  , PREV_INFO VARCHAR(300) comment '前世情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB5_DERIVE_PKC primary key (DERIVE_ID)
) comment '派生' ;

-- 統合
drop table if exists TB5_MERGE cascade;

create table TB5_MERGE (
  MERGE_ID INT comment '統合ID'
  , PREV_ID INT not null comment '前世ID'
  , PREV_INFO VARCHAR(300) comment '前世情報'
  , ORG_ID INT not null comment '起源ID'
  , ORG_INFO VARCHAR(300) comment '起源情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB5_MERGE_PKC primary key (MERGE_ID)
) comment '統合' ;

-- 前世
drop table if exists TB5_PREV cascade;

create table TB5_PREV (
  PREV_ID INT comment '前世ID'
  , PREV_INFO VARCHAR(300) comment '前世情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB5_PREV_PKC primary key (PREV_ID)
) comment '前世' ;

-- 前世明細
drop table if exists TB5_PREV_DET cascade;

create table TB5_PREV_DET (
  PREV_ID INT comment '前世ID'
  , PREV_BN INT comment '前世明細枝番'
  , PREV_DET_INFO VARCHAR(300) comment '前世明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB5_PREV_DET_PKC primary key (PREV_ID,PREV_BN)
) comment '前世明細' ;

-- 転生
drop table if exists TB5_REBORN cascade;

create table TB5_REBORN (
  REBORN_ID INT comment '転生ID'
  , PREV_ID INT not null comment '前世ID'
  , PREV_INFO VARCHAR(300) comment '前世情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB5_REBORN_PKC primary key (REBORN_ID)
) comment '転生' ;

-- 転生明細
drop table if exists TB5_REBORN_DET cascade;

create table TB5_REBORN_DET (
  REBORN_ID INT comment '転生ID'
  , REBORN_BN INT comment '転生明細枝番'
  , PREV_DET_INFO VARCHAR(300) comment '前世明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB5_REBORN_DET_PKC primary key (REBORN_ID,REBORN_BN)
) comment '転生明細' ;

-- 派生１
drop table if exists TB6_DERIVE1 cascade;

create table TB6_DERIVE1 (
  DERIVE1_ID INT comment '派生１ID'
  , ORG_ID INT not null comment '起源ID'
  , ORG_INFO VARCHAR(300) comment '起源情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB6_DERIVE1_PKC primary key (DERIVE1_ID)
) comment '派生１' ;

-- 派生１明細
drop table if exists TB6_DERIVE1_DET cascade;

create table TB6_DERIVE1_DET (
  DERIVE1_ID INT comment '派生１ID'
  , DERIVE1_BN INT comment '派生１枝番'
  , ORG_DET_INFO VARCHAR(300) comment '起源明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB6_DERIVE1_DET_PKC primary key (DERIVE1_ID,DERIVE1_BN)
) comment '派生１明細' ;

-- 派生２
drop table if exists TB6_DERIVE2 cascade;

create table TB6_DERIVE2 (
  DERIVE2_ID INT comment '派生２ID'
  , ORG_ID INT not null comment '起源ID'
  , ORG_INFO VARCHAR(300) comment '起源情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB6_DERIVE2_PKC primary key (DERIVE2_ID)
) comment '派生２' ;

-- 派生２明細
drop table if exists TB6_DERIVE2_DET cascade;

create table TB6_DERIVE2_DET (
  DERIVE2_ID INT comment '派生２ID'
  , DERIVE2_BN INT comment '派生２枝番'
  , ORG_DET_INFO VARCHAR(300) comment '起源明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB6_DERIVE2_DET_PKC primary key (DERIVE2_ID,DERIVE2_BN)
) comment '派生２明細' ;

-- 起源
drop table if exists TB6_ORG cascade;

create table TB6_ORG (
  ORG_ID INT comment '起源ID'
  , ORG_INFO VARCHAR(300) comment '起源情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB6_ORG_PKC primary key (ORG_ID)
) comment '起源' ;

-- 起源明細
drop table if exists TB6_ORG_DET cascade;

create table TB6_ORG_DET (
  ORG_ID INT comment '起源ID'
  , ORG_BN INT comment '起源明細枝番'
  , ORG_DET_INFO VARCHAR(300) comment '起源明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB6_ORG_DET_PKC primary key (ORG_ID,ORG_BN)
) comment '起源明細' ;

-- 集約
drop table if exists TB7_SUM cascade;

create table TB7_SUM (
  SUM_ID INT comment '集約ID'
  , SUM_INFO VARCHAR(300) comment '集約情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB7_SUM_PKC primary key (SUM_ID)
) comment '集約' ;

-- 単位１
drop table if exists TB7_UNIT1 cascade;

create table TB7_UNIT1 (
  UNIT1_ID INT comment '単位１ID'
  , SUM_ID INT comment '集約ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB7_UNIT1_PKC primary key (UNIT1_ID)
) comment '単位１' ;

-- 単位２
drop table if exists TB7_UNIT2 cascade;

create table TB7_UNIT2 (
  UNIT2_ID INT comment '単位２ID'
  , SUM_ID INT comment '集約ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB7_UNIT2_PKC primary key (UNIT2_ID)
) comment '単位２' ;

-- 選抜
drop table if exists TB8_CHOICE cascade;

create table TB8_CHOICE (
  CHOICE_ID INT comment '選抜ID'
  , SUM_ID INT comment '集約ID'
  , SUM_INFO VARCHAR(300) comment '集約情報'
  , SUM2_ID INT comment '集約２ID'
  , SUM2_INFO VARCHAR(300) comment '集約２情報'
  , SUM3_ID INT comment '集約３ID'
  , SUM3_INFO VARCHAR(300) comment '集約３情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB8_CHOICE_PKC primary key (CHOICE_ID)
) comment '選抜' ;

-- 前世２
drop table if exists TB8_PREV2 cascade;

create table TB8_PREV2 (
  PREV2_ID INT comment '前世２ID'
  , PREV2_INFO VARCHAR(300) comment '前世２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB8_PREV2_PKC primary key (PREV2_ID)
) comment '前世２' ;

-- 転生２
drop table if exists TB8_REBORN2 cascade;

create table TB8_REBORN2 (
  REBORN2_ID INT comment '転生２ID'
  , TASHO2_ID INT not null comment '他生２ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB8_REBORN2_PKC primary key (REBORN2_ID)
) comment '転生２' ;

-- 集約２
drop table if exists TB8_SUM2 cascade;

create table TB8_SUM2 (
  SUM2_ID INT comment '集約２ID'
  , SUM2_INFO VARCHAR(300) comment '集約２情報'
  , PREV2_ID INT not null comment '前世２ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB8_SUM2_PKC primary key (SUM2_ID)
) comment '集約２' ;

-- 集約３
drop table if exists TB8_SUM3 cascade;

create table TB8_SUM3 (
  SUM3_ID INT comment '集約３ID'
  , SUM3_INFO VARCHAR(300) comment '集約３情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB8_SUM3_PKC primary key (SUM3_ID)
) comment '集約３' ;

-- 他生１
drop table if exists TB8_TASHO1 cascade;

create table TB8_TASHO1 (
  TASHO1_ID INT comment '他生１ID'
  , SUM2_ID INT comment '集約２ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB8_TASHO1_PKC primary key (TASHO1_ID)
) comment '他生１' ;

-- 他生２
drop table if exists TB8_TASHO2 cascade;

create table TB8_TASHO2 (
  TASHO2_ID INT comment '他生２ID'
  , SUM3_ID INT comment '集約３ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB8_TASHO2_PKC primary key (TASHO2_ID)
) comment '他生２' ;

-- 変換先
drop table if exists TB9_DEST cascade;

create table TB9_DEST (
  DEST_ID INT comment '変換先ID'
  , DEST_INFO VARCHAR(300) comment '変換先情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB9_DEST_PKC primary key (DEST_ID)
) comment '変換先' ;

-- 変換元
drop table if exists TB9_SRC cascade;

create table TB9_SRC (
  SRC_ID INT comment '変換元ID'
  , SRC_INFO VARCHAR(300) comment '変換元情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint TB9_SRC_PKC primary key (SRC_ID)
) comment '変換元' ;

-- 振分ビュー
drop view if exists TB9_FURIWAKE;

create view TB9_FURIWAKE as 
SELECT
    a.table_name                                -- テーブル名
    , a.src_id$dest_id                          -- ID
    , a.info                                    -- 情報
FROM
    ( 
        SELECT
            'TB9_SRC' AS table_name
            , s.src_id AS src_id$dest_id
            , s.src_info AS info 
        FROM
            tb9_src s 
        UNION 
        SELECT
            'TB9_DEST'
            , s.dest_id
            , s.dest_info 
        FROM
            tb9_dest s
    ) a

;

-- 変換ビュー
drop view if exists TB9_HENKAN;

create view TB9_HENKAN as 
SELECT
    'TB9_DEST' AS table_name                    -- テーブル名
    , s.src_id                                  -- 変換元ID
    , s.src_info AS dest_info                   -- 変換元情報
FROM
    tb9_src s

;

