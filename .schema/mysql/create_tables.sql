-- Project Name : emarf
-- Date/Time    : 2026/01/24 21:52:00
-- Author       : t_fuk
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- CDマスタ
create table M04_CD (
  CDREF_CD CHAR(10) comment '参照CD'
  , CDREF_MEI VARCHAR(60) not null comment 'CD参照名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M04_CD_PKC primary key (CDREF_CD)
) comment 'CDマスタ' ;

-- IDマスタ
create table M04_ID (
  IDREF_ID INT comment '参照ID'
  , IDREF_MEI VARCHAR(60) not null comment 'ID参照名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M04_ID_PKC primary key (IDREF_ID)
) comment 'IDマスタ' ;

-- ID連番マスタ
create table M04_IDBN (
  IDBN_ID INT comment '参照ID'
  , IDBN_BN INT comment '参照連番'
  , IDBN_NO CHAR(10) not null comment 'ID連番NO'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M04_IDBN_PKC primary key (IDBN_ID,IDBN_BN)
) comment 'ID連番マスタ' ;

-- NOマスタ
create table M04_NO (
  NOREF_NO CHAR(10) comment '参照NO'
  , NOREF_MEI VARCHAR(60) not null comment 'NO参照名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M04_NO_PKC primary key (NOREF_NO)
) comment 'NOマスタ' ;

-- 再帰
create table M04_SAIKI (
  SAIKI_ID INT comment '再帰ID'
  , SAIKI_MEI VARCHAR(60) not null comment '再帰名'
  , IDREF_ID INT comment '参照ID'
  , CDREF_CD CHAR(10) comment '参照CD'
  , NOREF_NO CHAR(10) comment '参照NO'
  , IDBN_ID INT comment 'ID連番ID'
  , IDBN_BN INT comment 'ID連番'
  , OYA_SAIKI_ID INT comment '親再帰ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M04_SAIKI_PKC primary key (SAIKI_ID)
) comment '再帰' ;

-- マスタ参照１
create table M05_REF1 (
  REF1_ID INT comment '参照１ID'
  , REF1_MEI VARCHAR(60) not null comment '参照１名'
  , DELETE_F CHAR(1) comment '削除フラグ'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M05_REF1_PKC primary key (REF1_ID)
) comment 'マスタ参照１' ;

-- マスタ参照２
create table M05_REF2 (
  REF2_ID INT comment '参照２ID'
  , REF2_MEI VARCHAR(60) not null comment '参照２名'
  , DELETE_F CHAR(1) comment '削除フラグ'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M05_REF2_PKC primary key (REF2_ID)
) comment 'マスタ参照２' ;

-- マスタ参照３
create table M05_REF3 (
  REF3_ID INT comment '参照３ID'
  , REF3_MEI VARCHAR(60) not null comment '参照３名'
  , DELETE_F CHAR(1) comment '削除フラグ'
  , TEKIYO_BI DATE comment '適用日'
  , HAISHI_BI DATE comment '廃止日'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint M05_REF3_PKC primary key (REF3_ID)
) comment 'マスタ参照３' ;

-- 部署マスタ
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
create table T00_ENTITY (
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
  , constraint T00_ENTITY_PKC primary key (ENTITY_ID)
) comment 'エンティティ' ;

-- 主キーなし
create table T00_NOKEY (
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

create unique index T00_NOKEY_IX1
  on T00_NOKEY(COL_A,COL_B,COL_C);

create unique index T00_NOKEY_IX2
  on T00_NOKEY(COL_D,COL_E);

-- 子なし
create table T01_DINKS (
  OYA_ID INT not null comment '親ID'
  , KO_BN INT comment '子枝番'
  , DINKS_INFO VARCHAR(300) comment '子なし情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T01_DINKS_PKC primary key (OYA_ID,KO_BN)
) comment '子なし' ;

-- 子
create table T01_KO (
  OYA_ID INT comment '親ID'
  , KO_BN INT comment '子枝番'
  , KO_INFO VARCHAR(300) comment '子情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T01_KO_PKC primary key (OYA_ID,KO_BN)
) comment '子' ;

-- 孫
create table T01_MAGO (
  OYA_ID INT comment '親ID'
  , KO_BN INT comment '子枝番'
  , MAGO_BN INT comment '孫枝番'
  , MAGO_INFO VARCHAR(300) comment '孫情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T01_MAGO_PKC primary key (OYA_ID,KO_BN,MAGO_BN)
) comment '孫' ;

-- 孤児
create table T01_ORPHAN (
  OYA_ID INT comment '親ID'
  , KO_BN INT comment '子枝番'
  , ORPHAN_INFO VARCHAR(300) comment '孤児情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T01_ORPHAN_PKC primary key (OYA_ID,KO_BN)
) comment '孤児' ;

-- 親
create table T01_OYA (
  OYA_ID INT comment '親ID'
  , OYA_INFO VARCHAR(300) comment '親情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T01_OYA_PKC primary key (OYA_ID)
) comment '親' ;

-- 長兄
create table T02_ELDEST (
  BRO_ID INT comment '兄弟ID'
  , ELDEST_INFO VARCHAR(300) comment '長兄情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T02_ELDEST_PKC primary key (BRO_ID)
) comment '長兄' ;

-- 里子
create table T02_FOSTER (
  BRO_ID INT comment '兄弟ID'
  , FOSTER_INFO VARCHAR(300) comment '里子情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T02_FOSTER_PKC primary key (BRO_ID)
) comment '里子' ;

-- 弟
create table T02_YOUNGER (
  BRO_ID INT comment '兄弟ID'
  , YOUNGER_INFO VARCHAR(300) comment '弟情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T02_YOUNGER_PKC primary key (BRO_ID)
) comment '弟' ;

-- 末弟
create table T02_YOUNGEST (
  BRO_ID INT comment '兄弟ID'
  , YOUNGEST_INFO VARCHAR(300) comment '末弟情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T02_YOUNGEST_PKC primary key (BRO_ID)
) comment '末弟' ;

-- 変遷
create table T03_TRANS (
  TRANS_ID INT comment '変遷ID'
  , TRANS_INFO VARCHAR(300) comment '変遷情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T03_TRANS_PKC primary key (TRANS_ID)
) comment '変遷' ;

-- 変遷履歴
create table T03_TRANS_HIS (
  TRANS_ID INT comment '変遷ID'
  , TRANS_BN INT comment '変遷枝番'
  , TRANS_INFO VARCHAR(300) comment '変遷情報'
  , RIYU_TX VARCHAR(300) not null comment '変更理由'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T03_TRANS_HIS_PKC primary key (TRANS_ID,TRANS_BN)
) comment '変遷履歴' ;

-- 複合１
create table T05_COMP1 (
  REF1_ID INT comment '参照１ID'
  , REF2_ID INT comment '参照２ID'
  , COMP1_MEI VARCHAR(300) comment '複合１名'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T05_COMP1_PKC primary key (REF1_ID,REF2_ID)
) comment '複合１' ;

-- 複合２
create table T05_COMP2 (
  REF1_ID INT comment '参照１ID'
  , REF2_ID INT comment '参照２ID'
  , REF3_ID INT comment '参照３ID'
  , TEKIYO_BI DATE comment '適用日'
  , COMP2_INFO VARCHAR(300) comment '複合２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T05_COMP2_PKC primary key (REF1_ID,REF2_ID,REF3_ID,TEKIYO_BI)
) comment '複合２' ;

-- 派生１
create table T06_DERIVE1 (
  DERIVE1_ID INT comment '派生１ID'
  , ORG_INFO VARCHAR(300) comment '起源情報'
  , ORG_ID INT not null comment '起源ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T06_DERIVE1_PKC primary key (DERIVE1_ID)
) comment '派生１' ;

-- 派生１明細
create table T06_DERIVE1_DET (
  DERIVE1_ID INT comment '派生１ID'
  , DERIVE1_BN INT comment '派生１枝番'
  , DET_INFO VARCHAR(300) comment '明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T06_DERIVE1_DET_PKC primary key (DERIVE1_ID,DERIVE1_BN)
) comment '派生１明細' ;

-- 派生２
create table T06_DERIVE2 (
  DERIVE2_ID INT comment '派生２ID'
  , ORG_INFO VARCHAR(300) comment '起源情報'
  , ORG_ID INT not null comment '起源ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T06_DERIVE2_PKC primary key (DERIVE2_ID)
) comment '派生２' ;

-- 派生２明細
create table T06_DERIVE2_DET (
  DERIVE2_ID INT comment '派生２ID'
  , DERIVE2_BN INT comment '派生２枝番'
  , DET_INFO VARCHAR(300) comment '明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T06_DERIVE2_DET_PKC primary key (DERIVE2_ID,DERIVE2_BN)
) comment '派生２明細' ;

-- 起源
create table T06_ORG (
  ORG_ID INT comment '起源ID'
  , ORG_INFO VARCHAR(300) comment '起源情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T06_ORG_PKC primary key (ORG_ID)
) comment '起源' ;

-- 起源明細
create table T06_ORG_DET (
  ORG_ID INT comment '起源ID'
  , ORG_BN INT comment '起源枝番'
  , DET_INFO VARCHAR(300) comment '明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T06_ORG_DET_PKC primary key (ORG_ID,ORG_BN)
) comment '起源明細' ;

-- 前世
create table T07_PREV (
  PREV_ID INT comment '前世ID'
  , PREV_INFO VARCHAR(300) comment '前世情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T07_PREV_PKC primary key (PREV_ID)
) comment '前世' ;

-- 前世明細
create table T07_PREV_DET (
  PREV_ID INT comment '前世ID'
  , PREV_BN INT comment '前世枝番'
  , DET_INFO VARCHAR(300) comment '明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T07_PREV_DET_PKC primary key (PREV_ID,PREV_BN)
) comment '前世明細' ;

-- 転生
create table T07_REBORN (
  REBORN_ID INT comment '転生ID'
  , PREV_INFO VARCHAR(300) comment '前世情報'
  , PREV_ID INT not null comment '前世ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T07_REBORN_PKC primary key (REBORN_ID)
) comment '転生' ;

-- 転生明細
create table T07_REBORN_DET (
  REBORN_ID INT comment '転生ID'
  , REBORN_BN INT comment '転生枝番'
  , DET_INFO VARCHAR(300) comment '明細情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T07_REBORN_DET_PKC primary key (REBORN_ID,REBORN_BN)
) comment '転生明細' ;

-- 寄生１
create table T08_KISEI1 (
  KISEI1_ID INT comment '寄生１ID'
  , KISEI1_INFO VARCHAR(300) comment '寄生１情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T08_KISEI1_PKC primary key (KISEI1_ID)
) comment '寄生１' ;

-- 寄生２
create table T08_KISEI2 (
  KISEI2_ID INT comment '寄生２ID'
  , KISEI2_INFO VARCHAR(300) comment '寄生２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T08_KISEI2_PKC primary key (KISEI2_ID)
) comment '寄生２' ;

-- 共生
create table T08_KYOSEI (
  KYOSEI_ID INT comment '共生ID'
  , KISEI1_ID INT not null comment '寄生１ID'
  , KISEI1_INFO VARCHAR(300) comment '寄生１情報'
  , KISEI2_ID INT not null comment '寄生２ID'
  , KISEI2_INFO VARCHAR(300) comment '寄生２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T08_KYOSEI_PKC primary key (KYOSEI_ID)
) comment '共生' ;

-- 集団１
create table T09_GRP1 (
  GRP1_ID INT comment '集団１ID'
  , SUM_ID INT comment '集約ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T09_GRP1_PKC primary key (GRP1_ID)
) comment '集団１' ;

-- 集団２
create table T09_GRP2 (
  GRP2_ID INT comment '集団２ID'
  , SUM_ID INT comment '集約ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T09_GRP2_PKC primary key (GRP2_ID)
) comment '集団２' ;

-- 集約
create table T09_SUM (
  SUM_ID INT comment '集約ID'
  , SUM_INFO VARCHAR(300) comment '集約情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T09_SUM_PKC primary key (SUM_ID)
) comment '集約' ;

-- 選抜
create table T10_CHOICE (
  CHOICE_ID INT comment '選抜ID'
  , KOHO1_ID INT comment '候補１ID'
  , KOHO1_INFO VARCHAR(300) comment '候補１情報'
  , KOHO2_ID INT comment '候補２ID'
  , KOHO2_INFO VARCHAR(300) comment '候補２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T10_CHOICE_PKC primary key (CHOICE_ID)
) comment '選抜' ;

-- 候補１
create table T10_KOHO1 (
  KOHO1_ID INT comment '候補１ID'
  , KOHO1_INFO VARCHAR(300) comment '候補１情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T10_KOHO1_PKC primary key (KOHO1_ID)
) comment '候補１' ;

-- 候補２
create table T10_KOHO2 (
  KOHO2_ID INT comment '候補２ID'
  , KOHO2_INFO VARCHAR(300) comment '候補２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T10_KOHO2_PKC primary key (KOHO2_ID)
) comment '候補２' ;

-- 前世２
create table T11_PREV2 (
  PREV2_ID INT comment '前世２ID'
  , PREV2_INFO VARCHAR(300) comment '前世２情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T11_PREV2_PKC primary key (PREV2_ID)
) comment '前世２' ;

-- 転生２
create table T11_REBORN2 (
  REBORN2_ID INT comment '転生２ID'
  , PREV2_INFO VARCHAR(300) comment '前世２情報'
  , PREV2_ID INT not null comment '前世２ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T11_REBORN2_PKC primary key (REBORN2_ID)
) comment '転生２' ;

-- 他生１
create table T11_TASHO1 (
  TASHO1_ID INT comment '他生１ID'
  , REBORN2_ID INT comment '転生２ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T11_TASHO1_PKC primary key (TASHO1_ID)
) comment '他生１' ;

-- 候補３
create table T12_KOHO3 (
  KOHO3_ID INT comment '候補３ID'
  , KOHO3_INFO VARCHAR(300) comment '候補３情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T12_KOHO3_PKC primary key (KOHO3_ID)
) comment '候補３' ;

-- 転生３
create table T12_REBORN3 (
  REBORN3_ID INT comment '転生３ID'
  , TASHO2_ID INT not null comment '他生２ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T12_REBORN3_PKC primary key (REBORN3_ID)
) comment '転生３' ;

-- 他生２
create table T12_TASHO2 (
  TASHO2_ID INT comment '他生２ID'
  , KOHO3_ID INT comment '候補３ID'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T12_TASHO2_PKC primary key (TASHO2_ID)
) comment '他生２' ;

-- 変換先
create table T13_DEST (
  DEST_ID INT comment '変換先ID'
  , DEST_INFO VARCHAR(300) comment '変換先情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T13_DEST_PKC primary key (DEST_ID)
) comment '変換先' ;

-- 変換元
create table T13_SRC (
  SRC_ID INT comment '変換元ID'
  , SRC_INFO VARCHAR(300) comment '変換元情報'
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '作成タイムスタンプ'
  , INSERT_USER_ID INT not null comment '作成者'
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null comment '更新タイムスタンプ'
  , UPDATE_USER_ID INT not null comment '更新者'
  , constraint T13_SRC_PKC primary key (SRC_ID)
) comment '変換元' ;

-- 振分ビュー
create view V13_FURIWAKE as 
SELECT
    a.table_name                                -- テーブル名
    , a.src_id$dest_id                          -- 振分ID
    , a.info                                    -- 情報
FROM
    ( 
        SELECT
            'TB9_SRC' AS table_name
            , s.src_id AS src_id$dest_id
            , s.src_info AS info 
        FROM
            t13_src s 
        UNION 
        SELECT
            'TB9_DEST'
            , s.dest_id
            , s.dest_info 
        FROM
            t13_dest s
    ) a

;

-- 変換ビュー
create view V13_HENKAN as 
SELECT
    'TB9_DEST' AS table_name                    -- テーブル名
    , s.src_id                                  -- 変換元ID
    , s.src_info AS dest_info                   -- 変換元情報
FROM
    t13_src s

;

