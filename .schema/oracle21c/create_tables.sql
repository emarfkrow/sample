-- Project Name : emarf
-- Date/Time    : 2026/01/21 8:28:27
-- Author       : KTC0966
-- RDBMS Type   : Oracle Database
-- Application  : A5:SQL Mk-2

-- 部署マスタ
create table MHR_BUSHO (
  BUSHO_ID NUMBER(10) not null
  , BUSHO_MEI VARCHAR2(60) not null
  , OYA_BUSHO_ID NUMBER(10)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MHR_BUSHO_PKC primary key (BUSHO_ID)
) ;

-- 職位マスタ
create table MHR_SHOKUI (
  SHOKUI_ID NUMBER(10) not null
  , SHOKUI_MEI VARCHAR2(60) not null
  , SHOKUI_ON NUMBER(10) not null
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MHR_SHOKUI_PKC primary key (SHOKUI_ID)
) ;

-- 認可マスタ
create table MHR_SHOKUI_NINKA (
  BUSHO_ID NUMBER(10) not null
  , SHOKUI_ID NUMBER(10) not null
  , KINO_NM VARCHAR2(20) not null
  , KENGEN_KB VARCHAR2(2) not null
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MHR_SHOKUI_NINKA_PKC primary key (BUSHO_ID,SHOKUI_ID,KINO_NM)
) ;

-- ユーザマスタ
create table MHR_USER (
  USER_ID NUMBER(10) not null
  , USER_SEI VARCHAR2(60) not null
  , USER_MEI VARCHAR2(60) not null
  , E_MAIL VARCHAR2(300) not null
  , PASSWORD VARCHAR2(300) not null
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MHR_USER_PKC primary key (USER_ID)
) ;

-- 所属マスタ
create table MHR_USER_POS (
  BUSHO_ID NUMBER(10) not null
  , SHOKUI_ID NUMBER(10) not null
  , USER_ID NUMBER(10) not null
  , TEKIYO_BI DATE not null
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MHR_USER_POS_PKC primary key (BUSHO_ID,SHOKUI_ID,USER_ID,TEKIYO_BI)
) ;

-- 稼働日マスタ
create table MSY_KADOBI (
  KADO_BI DATE
  , BUSHO_ID NUMBER(10)
  , KADOBI_F CHAR(1) not null
  , MEMO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MSY_KADOBI_PKC primary key (KADO_BI,BUSHO_ID)
) ;

-- 区分マスタ
create table MSY_KBN (
  KBN_NM VARCHAR2(20) not null
  , KBN_MEI VARCHAR2(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MSY_KBN_PKC primary key (KBN_NM)
) ;

-- 区分値マスタ
create table MSY_KBN_VAL (
  KBN_NM VARCHAR2(20) not null
  , KBN_VAL VARCHAR2(2) not null
  , KBN_VAL_MEI VARCHAR2(60) not null
  , HYOJI_ON NUMBER(10)
  , CRITERIA VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MSY_KBN_VAL_PKC primary key (KBN_NM,KBN_VAL)
) ;

-- 税マスタ
create table MSY_TAX (
  TAX_KB VARCHAR2(2)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , TAX_RT NUMBER(5,2) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MSY_TAX_PKC primary key (TAX_KB,TEKIYO_BI)
) ;

-- 通貨マスタ
create table MSY_TSUKA (
  TSUKA_KB VARCHAR2(2)
  , TEKIYO_BI DATE
  , TTS NUMBER(5,2) not null
  , TTB NUMBER(5,2) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint MSY_TSUKA_PKC primary key (TSUKA_KB,TEKIYO_BI)
) ;

-- エンティティ
create table TB0_ENTITY (
  ENTITY_ID NUMBER(10) not null
  , ENTITY_NM VARCHAR2(20) not null
  , ENTITY_MEI VARCHAR2(60) not null
  , CHECK_F CHAR(1) not null
  , RADIO_KB VARCHAR2(2) not null
  , PULLDOWN_KB VARCHAR2(2) not null
  , PULLDOWN_SB VARCHAR2(2) not null
  , MEMO_TX VARCHAR2(300) not null
  , MEMO VARCHAR2(300) not null
  , TENPU_FILE VARCHAR2(300) not null
  , NENGAPPI_Y CHAR(4) not null
  , NENGAPPI_M CHAR(2) not null
  , NENGAPPI_D CHAR(2) not null
  , NENGETSU_YM CHAR(6) not null
  , NENGAPPI_YMD CHAR(8) not null
  , TIMESTAMP_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , NICHIJI_DT DATE not null
  , HIDUKE_BI DATE not null
  , JIKOKU_HM DATE not null
  , JIKAN_TM VARCHAR2(9) not null
  , SURYO_QT NUMBER(11,3) not null
  , TSUKA_KB VARCHAR2(2) not null
  , JUCHU_PR NUMBER(11,2) not null
  , JUCHU_AM NUMBER(11,2) not null
  , HACHU_PR NUMBER(11,2) not null
  , HACHU_AM NUMBER(11,2) not null
  , DELETE_F CHAR(1) default 0
  , STATUS_KB VARCHAR2(2) default 0
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB0_ENTITY_PKC primary key (ENTITY_ID)
) ;

-- 主キーなし
create table TB0_NOKEY (
  COL_A VARCHAR2(60)
  , COL_B VARCHAR2(60)
  , COL_C VARCHAR2(60)
  , COL_D VARCHAR2(60)
  , COL_E VARCHAR2(60)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
) ;

create unique index TB0_NOKEY_IX1
  on TB0_NOKEY(COL_A,COL_B,COL_C);

create unique index TB0_NOKEY_IX2
  on TB0_NOKEY(COL_D,COL_E);

-- CD参照マスタ
create table TB1_CDREF (
  CDREF_CD CHAR(10)
  , CDREF_MEI VARCHAR2(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_CDREF_PKC primary key (CDREF_CD)
) ;

-- 複合１
create table TB1_COMBO1 (
  REFER1_ID NUMBER(10)
  , REFER2_ID NUMBER(10)
  , COMBO1_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_COMBO1_PKC primary key (REFER1_ID,REFER2_ID)
) ;

-- 複合２
create table TB1_COMBO2 (
  REFER1_ID NUMBER(10)
  , REFER2_ID NUMBER(10)
  , REFER3_ID NUMBER(10)
  , TEKIYO_BI DATE
  , COMBO2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_COMBO2_PKC primary key (REFER1_ID,REFER2_ID,REFER3_ID,TEKIYO_BI)
) ;

-- ID連番マスタ
create table TB1_IDBN (
  IDREF_ID NUMBER(10)
  , IDBN_BN NUMBER(10)
  , IDBN_NO CHAR(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_IDBN_PKC primary key (IDREF_ID,IDBN_BN)
) ;

-- ID参照マスタ
create table TB1_IDREF (
  IDREF_ID NUMBER(10)
  , IDREF_MEI VARCHAR2(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_IDREF_PKC primary key (IDREF_ID)
) ;

-- NO参照マスタ
create table TB1_NOREF (
  NOREF_NO CHAR(10)
  , NOREF_MEI VARCHAR2(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_NOREF_PKC primary key (NOREF_NO)
) ;

-- 参照１マスタ
create table TB1_REFER1 (
  REFER1_ID NUMBER(10)
  , REFER1_MEI VARCHAR2(60) not null
  , DELETE_F CHAR(1)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_REFER1_PKC primary key (REFER1_ID)
) ;

-- 参照２マスタ
create table TB1_REFER2 (
  REFER2_ID NUMBER(10)
  , REFER2_MEI VARCHAR2(60) not null
  , DELETE_F CHAR(1)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_REFER2_PKC primary key (REFER2_ID)
) ;

-- 参照３マスタ
create table TB1_REFER3 (
  REFER3_ID NUMBER(10)
  , REFER3_MEI VARCHAR2(60) not null
  , DELETE_F CHAR(1)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_REFER3_PKC primary key (REFER3_ID)
) ;

-- 再帰
create table TB1_SAIKI (
  SAIKI_ID NUMBER(10)
  , SAIKI_MEI VARCHAR2(60) not null
  , IDREF_ID NUMBER(10)
  , CDREF_CD CHAR(10)
  , NOREF_NO CHAR(10)
  , EX_IDREF_ID NUMBER(10)
  , IDBN_BN NUMBER(10)
  , OYA_SAIKI_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB1_SAIKI_PKC primary key (SAIKI_ID)
) ;

-- 長兄
create table TB2_ELDEST (
  BRO_ID NUMBER(10)
  , ELDEST_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB2_ELDEST_PKC primary key (BRO_ID)
) ;

-- 里子
create table TB2_FOSTER (
  BRO_ID NUMBER(10)
  , FOSTER_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB2_FOSTER_PKC primary key (BRO_ID)
) ;

-- 弟
create table TB2_YOUNGER (
  BRO_ID NUMBER(10)
  , YOUNGER_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB2_YOUNGER_PKC primary key (BRO_ID)
) ;

-- 末弟
create table TB2_YOUNGEST (
  BRO_ID NUMBER(10)
  , YOUNGEST_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB2_YOUNGEST_PKC primary key (BRO_ID)
) ;

-- 当初
create table TB3_BEGIN (
  BEGIN_ID NUMBER(10)
  , BEGIN_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB3_BEGIN_PKC primary key (BEGIN_ID)
) ;

-- 履歴
create table TB3_BEGIN_HIS (
  BEGIN_ID NUMBER(10)
  , RIREKI_BN NUMBER(10)
  , BEGIN_INFO VARCHAR2(300)
  , REASON VARCHAR2(300) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB3_BEGIN_HIS_PKC primary key (BEGIN_ID,RIREKI_BN)
) ;

-- 子
create table TB4_KO (
  OYA_ID NUMBER(10)
  , KO_BN NUMBER(10)
  , KO_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB4_KO_PKC primary key (OYA_ID,KO_BN)
) ;

-- 子なし
create table TB4_KO_DINKS (
  OYA_ID NUMBER(10)
  , KO_BN NUMBER(10)
  , DINKS_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB4_KO_DINKS_PKC primary key (OYA_ID,KO_BN)
) ;

-- 孤児
create table TB4_KO_ORPHANS (
  OYA_ID NUMBER(10)
  , KO_BN NUMBER(10)
  , ORPHANS_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB4_KO_ORPHANS_PKC primary key (OYA_ID,KO_BN)
) ;

-- 孫
create table TB4_MAGO (
  OYA_ID NUMBER(10)
  , KO_BN NUMBER(10)
  , MAGO_BN NUMBER(10)
  , MAGO_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB4_MAGO_PKC primary key (OYA_ID,KO_BN,MAGO_BN)
) ;

-- 親
create table TB4_OYA (
  OYA_ID NUMBER(10)
  , OYA_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB4_OYA_PKC primary key (OYA_ID)
) ;

-- 派生
create table TB5_DERIVE (
  DERIVE_ID NUMBER(10)
  , PREV_ID NUMBER(10)
  , PREV_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB5_DERIVE_PKC primary key (DERIVE_ID)
) ;

-- 統合
create table TB5_MERGE (
  MERGE_ID NUMBER(10)
  , PREV_ID NUMBER(10) not null
  , PREV_INFO VARCHAR2(300)
  , ORG_ID NUMBER(10) not null
  , ORG_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB5_MERGE_PKC primary key (MERGE_ID)
) ;

-- 前世
create table TB5_PREV (
  PREV_ID NUMBER(10)
  , PREV_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB5_PREV_PKC primary key (PREV_ID)
) ;

-- 前世明細
create table TB5_PREV_DET (
  PREV_ID NUMBER(10)
  , PREV_BN NUMBER(10)
  , PREV_DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB5_PREV_DET_PKC primary key (PREV_ID,PREV_BN)
) ;

-- 転生
create table TB5_REBORN (
  REBORN_ID NUMBER(10)
  , PREV_ID NUMBER(10) not null
  , PREV_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB5_REBORN_PKC primary key (REBORN_ID)
) ;

-- 転生明細
create table TB5_REBORN_DET (
  REBORN_ID NUMBER(10)
  , REBORN_BN NUMBER(10)
  , PREV_DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB5_REBORN_DET_PKC primary key (REBORN_ID,REBORN_BN)
) ;

-- 派生１
create table TB6_DERIVE1 (
  DERIVE1_ID NUMBER(10)
  , ORG_ID NUMBER(10) not null
  , ORG_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB6_DERIVE1_PKC primary key (DERIVE1_ID)
) ;

-- 派生１明細
create table TB6_DERIVE1_DET (
  DERIVE1_ID NUMBER(10)
  , DERIVE1_BN NUMBER(10)
  , ORG_DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB6_DERIVE1_DET_PKC primary key (DERIVE1_ID,DERIVE1_BN)
) ;

-- 派生２
create table TB6_DERIVE2 (
  DERIVE2_ID NUMBER(10)
  , ORG_ID NUMBER(10) not null
  , ORG_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB6_DERIVE2_PKC primary key (DERIVE2_ID)
) ;

-- 派生２明細
create table TB6_DERIVE2_DET (
  DERIVE2_ID NUMBER(10)
  , DERIVE2_BN NUMBER(10)
  , ORG_DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB6_DERIVE2_DET_PKC primary key (DERIVE2_ID,DERIVE2_BN)
) ;

-- 起源
create table TB6_ORG (
  ORG_ID NUMBER(10)
  , ORG_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB6_ORG_PKC primary key (ORG_ID)
) ;

-- 起源明細
create table TB6_ORG_DET (
  ORG_ID NUMBER(10)
  , ORG_BN NUMBER(10)
  , ORG_DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB6_ORG_DET_PKC primary key (ORG_ID,ORG_BN)
) ;

-- 集約
create table TB7_SUM (
  SUM_ID NUMBER(10)
  , SUM_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB7_SUM_PKC primary key (SUM_ID)
) ;

-- 単位１
create table TB7_UNIT1 (
  UNIT1_ID NUMBER(10)
  , SUM_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB7_UNIT1_PKC primary key (UNIT1_ID)
) ;

-- 単位２
create table TB7_UNIT2 (
  UNIT2_ID NUMBER(10)
  , SUM_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB7_UNIT2_PKC primary key (UNIT2_ID)
) ;

-- 選抜
create table TB8_CHOICE (
  CHOICE_ID NUMBER(10)
  , SUM_ID NUMBER(10)
  , SUM_INFO VARCHAR2(300)
  , SUM2_ID NUMBER(10)
  , SUM2_INFO VARCHAR2(300)
  , SUM3_ID NUMBER(10)
  , SUM3_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB8_CHOICE_PKC primary key (CHOICE_ID)
) ;

-- 前世２
create table TB8_PREV2 (
  PREV2_ID NUMBER(10)
  , PREV2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB8_PREV2_PKC primary key (PREV2_ID)
) ;

-- 転生２
create table TB8_REBORN2 (
  REBORN2_ID NUMBER(10)
  , TASHO2_ID NUMBER(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB8_REBORN2_PKC primary key (REBORN2_ID)
) ;

-- 集約２
create table TB8_SUM2 (
  SUM2_ID NUMBER(10)
  , SUM2_INFO VARCHAR2(300)
  , PREV2_ID NUMBER(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB8_SUM2_PKC primary key (SUM2_ID)
) ;

-- 集約３
create table TB8_SUM3 (
  SUM3_ID NUMBER(10)
  , SUM3_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB8_SUM3_PKC primary key (SUM3_ID)
) ;

-- 他生１
create table TB8_TASHO1 (
  TASHO1_ID NUMBER(10)
  , SUM2_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB8_TASHO1_PKC primary key (TASHO1_ID)
) ;

-- 他生２
create table TB8_TASHO2 (
  TASHO2_ID NUMBER(10)
  , SUM3_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB8_TASHO2_PKC primary key (TASHO2_ID)
) ;

-- 変換先
create table TB9_DEST (
  DEST_ID NUMBER(10)
  , DEST_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB9_DEST_PKC primary key (DEST_ID)
) ;

-- 変換元
create table TB9_SRC (
  SRC_ID NUMBER(10)
  , SRC_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint TB9_SRC_PKC primary key (SRC_ID)
) ;

-- 振分ビュー
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
create view TB9_HENKAN as 
SELECT
    'TB9_DEST' AS table_name                    -- テーブル名
    , s.src_id                                  -- 変換元ID
    , s.src_info AS dest_info                   -- 変換元情報
FROM
    tb9_src s

;

comment on table MHR_BUSHO is '部署マスタ';
comment on column MHR_BUSHO.BUSHO_ID is '部署ID';
comment on column MHR_BUSHO.BUSHO_MEI is '部署名';
comment on column MHR_BUSHO.OYA_BUSHO_ID is '親部署ID';
comment on column MHR_BUSHO.TEKIYO_BI is '適用日';
comment on column MHR_BUSHO.HAISHI_BI is '廃止日';
comment on column MHR_BUSHO.INSERT_TS is '作成タイムスタンプ';
comment on column MHR_BUSHO.INSERT_USER_ID is '作成者';
comment on column MHR_BUSHO.UPDATE_TS is '更新タイムスタンプ';
comment on column MHR_BUSHO.UPDATE_USER_ID is '更新者';

comment on table MHR_SHOKUI is '職位マスタ';
comment on column MHR_SHOKUI.SHOKUI_ID is '職位ID';
comment on column MHR_SHOKUI.SHOKUI_MEI is '職位名';
comment on column MHR_SHOKUI.SHOKUI_ON is '職位順';
comment on column MHR_SHOKUI.TEKIYO_BI is '適用日';
comment on column MHR_SHOKUI.HAISHI_BI is '廃止日';
comment on column MHR_SHOKUI.INSERT_TS is '作成タイムスタンプ';
comment on column MHR_SHOKUI.INSERT_USER_ID is '作成者';
comment on column MHR_SHOKUI.UPDATE_TS is '更新タイムスタンプ';
comment on column MHR_SHOKUI.UPDATE_USER_ID is '更新者';

comment on table MHR_SHOKUI_NINKA is '認可マスタ';
comment on column MHR_SHOKUI_NINKA.BUSHO_ID is '部署ID';
comment on column MHR_SHOKUI_NINKA.SHOKUI_ID is '職位ID';
comment on column MHR_SHOKUI_NINKA.KINO_NM is '機能名称';
comment on column MHR_SHOKUI_NINKA.KENGEN_KB is '権限区分';
comment on column MHR_SHOKUI_NINKA.TEKIYO_BI is '適用日';
comment on column MHR_SHOKUI_NINKA.HAISHI_BI is '廃止日';
comment on column MHR_SHOKUI_NINKA.INSERT_TS is '作成タイムスタンプ';
comment on column MHR_SHOKUI_NINKA.INSERT_USER_ID is '作成者';
comment on column MHR_SHOKUI_NINKA.UPDATE_TS is '更新タイムスタンプ';
comment on column MHR_SHOKUI_NINKA.UPDATE_USER_ID is '更新者';

comment on table MHR_USER is 'ユーザマスタ';
comment on column MHR_USER.USER_ID is 'ユーザID';
comment on column MHR_USER.USER_SEI is 'ユーザ姓';
comment on column MHR_USER.USER_MEI is 'ユーザ名';
comment on column MHR_USER.E_MAIL is 'メールアドレス';
comment on column MHR_USER.PASSWORD is 'パスワード';
comment on column MHR_USER.TEKIYO_BI is '適用日';
comment on column MHR_USER.HAISHI_BI is '廃止日';
comment on column MHR_USER.INSERT_TS is '作成タイムスタンプ';
comment on column MHR_USER.INSERT_USER_ID is '作成者';
comment on column MHR_USER.UPDATE_TS is '更新タイムスタンプ';
comment on column MHR_USER.UPDATE_USER_ID is '更新者';

comment on table MHR_USER_POS is '所属マスタ';
comment on column MHR_USER_POS.BUSHO_ID is '部署ID';
comment on column MHR_USER_POS.SHOKUI_ID is '職位ID';
comment on column MHR_USER_POS.USER_ID is 'ユーザID';
comment on column MHR_USER_POS.TEKIYO_BI is '適用日';
comment on column MHR_USER_POS.HAISHI_BI is '廃止日';
comment on column MHR_USER_POS.INSERT_TS is '作成タイムスタンプ';
comment on column MHR_USER_POS.INSERT_USER_ID is '作成者';
comment on column MHR_USER_POS.UPDATE_TS is '更新タイムスタンプ';
comment on column MHR_USER_POS.UPDATE_USER_ID is '更新者';

comment on table MSY_KADOBI is '稼働日マスタ';
comment on column MSY_KADOBI.KADO_BI is '稼働日';
comment on column MSY_KADOBI.BUSHO_ID is '部署ID';
comment on column MSY_KADOBI.KADOBI_F is '稼働日フラグ';
comment on column MSY_KADOBI.MEMO is 'メモ';
comment on column MSY_KADOBI.INSERT_TS is '作成タイムスタンプ';
comment on column MSY_KADOBI.INSERT_USER_ID is '作成者';
comment on column MSY_KADOBI.UPDATE_TS is '更新タイムスタンプ';
comment on column MSY_KADOBI.UPDATE_USER_ID is '更新者';

comment on table MSY_KBN is '区分マスタ';
comment on column MSY_KBN.KBN_NM is '区分名称';
comment on column MSY_KBN.KBN_MEI is '区分名';
comment on column MSY_KBN.INSERT_TS is '作成タイムスタンプ';
comment on column MSY_KBN.INSERT_USER_ID is '作成者';
comment on column MSY_KBN.UPDATE_TS is '更新タイムスタンプ';
comment on column MSY_KBN.UPDATE_USER_ID is '更新者';

comment on table MSY_KBN_VAL is '区分値マスタ';
comment on column MSY_KBN_VAL.KBN_NM is '区分名称';
comment on column MSY_KBN_VAL.KBN_VAL is '区分値';
comment on column MSY_KBN_VAL.KBN_VAL_MEI is '区分値名';
comment on column MSY_KBN_VAL.HYOJI_ON is '表示順';
comment on column MSY_KBN_VAL.CRITERIA is '取得条件';
comment on column MSY_KBN_VAL.INSERT_TS is '作成タイムスタンプ';
comment on column MSY_KBN_VAL.INSERT_USER_ID is '作成者';
comment on column MSY_KBN_VAL.UPDATE_TS is '更新タイムスタンプ';
comment on column MSY_KBN_VAL.UPDATE_USER_ID is '更新者';

comment on table MSY_TAX is '税マスタ';
comment on column MSY_TAX.TAX_KB is '税区分';
comment on column MSY_TAX.TEKIYO_BI is '適用日';
comment on column MSY_TAX.HAISHI_BI is '廃止日';
comment on column MSY_TAX.TAX_RT is '税率';
comment on column MSY_TAX.INSERT_TS is '作成タイムスタンプ';
comment on column MSY_TAX.INSERT_USER_ID is '作成者';
comment on column MSY_TAX.UPDATE_TS is '更新タイムスタンプ';
comment on column MSY_TAX.UPDATE_USER_ID is '更新者';

comment on table MSY_TSUKA is '通貨マスタ';
comment on column MSY_TSUKA.TSUKA_KB is '通貨区分';
comment on column MSY_TSUKA.TEKIYO_BI is '適用日';
comment on column MSY_TSUKA.TTS is '販売レート';
comment on column MSY_TSUKA.TTB is '買取レート';
comment on column MSY_TSUKA.INSERT_TS is '作成タイムスタンプ';
comment on column MSY_TSUKA.INSERT_USER_ID is '作成者';
comment on column MSY_TSUKA.UPDATE_TS is '更新タイムスタンプ';
comment on column MSY_TSUKA.UPDATE_USER_ID is '更新者';

comment on table TB0_ENTITY is 'エンティティ';
comment on column TB0_ENTITY.ENTITY_ID is 'エンティティID';
comment on column TB0_ENTITY.ENTITY_NM is 'エンティティ名称';
comment on column TB0_ENTITY.ENTITY_MEI is 'エンティティ名';
comment on column TB0_ENTITY.CHECK_F is 'チェックフラグ';
comment on column TB0_ENTITY.RADIO_KB is 'ラジオ区分';
comment on column TB0_ENTITY.PULLDOWN_KB is 'プルダウン区分';
comment on column TB0_ENTITY.PULLDOWN_SB is 'プルダウン種別';
comment on column TB0_ENTITY.MEMO_TX is 'メモ';
comment on column TB0_ENTITY.MEMO is '１行メモ';
comment on column TB0_ENTITY.TENPU_FILE is '添付ファイル';
comment on column TB0_ENTITY.NENGAPPI_Y is '年月日年';
comment on column TB0_ENTITY.NENGAPPI_M is '年月日月';
comment on column TB0_ENTITY.NENGAPPI_D is '年月日日';
comment on column TB0_ENTITY.NENGETSU_YM is '年月';
comment on column TB0_ENTITY.NENGAPPI_YMD is '年月日';
comment on column TB0_ENTITY.TIMESTAMP_TS is 'タイムスタンプ';
comment on column TB0_ENTITY.NICHIJI_DT is '日時';
comment on column TB0_ENTITY.HIDUKE_BI is '日付';
comment on column TB0_ENTITY.JIKOKU_HM is '時刻';
comment on column TB0_ENTITY.JIKAN_TM is '時間';
comment on column TB0_ENTITY.SURYO_QT is '数量';
comment on column TB0_ENTITY.TSUKA_KB is '通貨区分';
comment on column TB0_ENTITY.JUCHU_PR is '受注単価';
comment on column TB0_ENTITY.JUCHU_AM is '受注金額';
comment on column TB0_ENTITY.HACHU_PR is '発注単価';
comment on column TB0_ENTITY.HACHU_AM is '発注金額';
comment on column TB0_ENTITY.DELETE_F is '削除フラグ:必須チェックにかかるのでNOTNULLにしない';
comment on column TB0_ENTITY.STATUS_KB is 'ステータス区分:必須チェックにかかるのでNOTNULLにしない';
comment on column TB0_ENTITY.INSERT_TS is '作成タイムスタンプ';
comment on column TB0_ENTITY.INSERT_USER_ID is '作成者';
comment on column TB0_ENTITY.UPDATE_TS is '更新タイムスタンプ';
comment on column TB0_ENTITY.UPDATE_USER_ID is '更新者';

comment on table TB0_NOKEY is '主キーなし';
comment on column TB0_NOKEY.COL_A is '列Ａ';
comment on column TB0_NOKEY.COL_B is '列Ｂ';
comment on column TB0_NOKEY.COL_C is '列Ｃ';
comment on column TB0_NOKEY.COL_D is '列Ｄ';
comment on column TB0_NOKEY.COL_E is '列Ｅ';
comment on column TB0_NOKEY.INSERT_TS is '作成タイムスタンプ';
comment on column TB0_NOKEY.INSERT_USER_ID is '作成者';
comment on column TB0_NOKEY.UPDATE_TS is '更新タイムスタンプ';
comment on column TB0_NOKEY.UPDATE_USER_ID is '更新者';

comment on table TB1_CDREF is 'CD参照マスタ';
comment on column TB1_CDREF.CDREF_CD is '参照CD';
comment on column TB1_CDREF.CDREF_MEI is '参照CD名';
comment on column TB1_CDREF.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_CDREF.INSERT_USER_ID is '作成者';
comment on column TB1_CDREF.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_CDREF.UPDATE_USER_ID is '更新者';

comment on table TB1_COMBO1 is '複合１';
comment on column TB1_COMBO1.REFER1_ID is '参照１ID';
comment on column TB1_COMBO1.REFER2_ID is '参照２ID';
comment on column TB1_COMBO1.COMBO1_INFO is '複合１情報';
comment on column TB1_COMBO1.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_COMBO1.INSERT_USER_ID is '作成者';
comment on column TB1_COMBO1.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_COMBO1.UPDATE_USER_ID is '更新者';

comment on table TB1_COMBO2 is '複合２';
comment on column TB1_COMBO2.REFER1_ID is '参照１ID';
comment on column TB1_COMBO2.REFER2_ID is '参照２ID';
comment on column TB1_COMBO2.REFER3_ID is '参照３ID';
comment on column TB1_COMBO2.TEKIYO_BI is '適用日';
comment on column TB1_COMBO2.COMBO2_INFO is '複合２情報';
comment on column TB1_COMBO2.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_COMBO2.INSERT_USER_ID is '作成者';
comment on column TB1_COMBO2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_COMBO2.UPDATE_USER_ID is '更新者';

comment on table TB1_IDBN is 'ID連番マスタ';
comment on column TB1_IDBN.IDREF_ID is '参照ID';
comment on column TB1_IDBN.IDBN_BN is '参照ID連番';
comment on column TB1_IDBN.IDBN_NO is 'ID連番NO';
comment on column TB1_IDBN.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_IDBN.INSERT_USER_ID is '作成者';
comment on column TB1_IDBN.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_IDBN.UPDATE_USER_ID is '更新者';

comment on table TB1_IDREF is 'ID参照マスタ';
comment on column TB1_IDREF.IDREF_ID is '参照ID';
comment on column TB1_IDREF.IDREF_MEI is '参照ID名';
comment on column TB1_IDREF.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_IDREF.INSERT_USER_ID is '作成者';
comment on column TB1_IDREF.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_IDREF.UPDATE_USER_ID is '更新者';

comment on table TB1_NOREF is 'NO参照マスタ';
comment on column TB1_NOREF.NOREF_NO is '参照NO';
comment on column TB1_NOREF.NOREF_MEI is '参照NO名';
comment on column TB1_NOREF.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_NOREF.INSERT_USER_ID is '作成者';
comment on column TB1_NOREF.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_NOREF.UPDATE_USER_ID is '更新者';

comment on table TB1_REFER1 is '参照１マスタ';
comment on column TB1_REFER1.REFER1_ID is '参照１ID';
comment on column TB1_REFER1.REFER1_MEI is '参照１名';
comment on column TB1_REFER1.DELETE_F is '削除フラグ';
comment on column TB1_REFER1.TEKIYO_BI is '適用日';
comment on column TB1_REFER1.HAISHI_BI is '廃止日';
comment on column TB1_REFER1.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_REFER1.INSERT_USER_ID is '作成者';
comment on column TB1_REFER1.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_REFER1.UPDATE_USER_ID is '更新者';

comment on table TB1_REFER2 is '参照２マスタ';
comment on column TB1_REFER2.REFER2_ID is '参照２ID';
comment on column TB1_REFER2.REFER2_MEI is '参照２名';
comment on column TB1_REFER2.DELETE_F is '削除フラグ';
comment on column TB1_REFER2.TEKIYO_BI is '適用日';
comment on column TB1_REFER2.HAISHI_BI is '廃止日';
comment on column TB1_REFER2.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_REFER2.INSERT_USER_ID is '作成者';
comment on column TB1_REFER2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_REFER2.UPDATE_USER_ID is '更新者';

comment on table TB1_REFER3 is '参照３マスタ';
comment on column TB1_REFER3.REFER3_ID is '参照３ID';
comment on column TB1_REFER3.REFER3_MEI is '参照３名';
comment on column TB1_REFER3.DELETE_F is '削除フラグ';
comment on column TB1_REFER3.TEKIYO_BI is '適用日';
comment on column TB1_REFER3.HAISHI_BI is '廃止日';
comment on column TB1_REFER3.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_REFER3.INSERT_USER_ID is '作成者';
comment on column TB1_REFER3.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_REFER3.UPDATE_USER_ID is '更新者';

comment on table TB1_SAIKI is '再帰';
comment on column TB1_SAIKI.SAIKI_ID is '再帰ID';
comment on column TB1_SAIKI.SAIKI_MEI is '再帰名';
comment on column TB1_SAIKI.IDREF_ID is '参照ID';
comment on column TB1_SAIKI.CDREF_CD is '参照CD';
comment on column TB1_SAIKI.NOREF_NO is '参照NO';
comment on column TB1_SAIKI.EX_IDREF_ID is '別参照ID';
comment on column TB1_SAIKI.IDBN_BN is 'ID連番';
comment on column TB1_SAIKI.OYA_SAIKI_ID is '親再帰ID';
comment on column TB1_SAIKI.INSERT_TS is '作成タイムスタンプ';
comment on column TB1_SAIKI.INSERT_USER_ID is '作成者';
comment on column TB1_SAIKI.UPDATE_TS is '更新タイムスタンプ';
comment on column TB1_SAIKI.UPDATE_USER_ID is '更新者';

comment on table TB2_ELDEST is '長兄';
comment on column TB2_ELDEST.BRO_ID is '兄弟ID';
comment on column TB2_ELDEST.ELDEST_INFO is '長兄情報';
comment on column TB2_ELDEST.INSERT_TS is '作成タイムスタンプ';
comment on column TB2_ELDEST.INSERT_USER_ID is '作成者';
comment on column TB2_ELDEST.UPDATE_TS is '更新タイムスタンプ';
comment on column TB2_ELDEST.UPDATE_USER_ID is '更新者';

comment on table TB2_FOSTER is '里子';
comment on column TB2_FOSTER.BRO_ID is '兄弟ID';
comment on column TB2_FOSTER.FOSTER_INFO is '里子情報';
comment on column TB2_FOSTER.INSERT_TS is '作成タイムスタンプ';
comment on column TB2_FOSTER.INSERT_USER_ID is '作成者';
comment on column TB2_FOSTER.UPDATE_TS is '更新タイムスタンプ';
comment on column TB2_FOSTER.UPDATE_USER_ID is '更新者';

comment on table TB2_YOUNGER is '弟';
comment on column TB2_YOUNGER.BRO_ID is '兄弟ID';
comment on column TB2_YOUNGER.YOUNGER_INFO is '弟情報';
comment on column TB2_YOUNGER.INSERT_TS is '作成タイムスタンプ';
comment on column TB2_YOUNGER.INSERT_USER_ID is '作成者';
comment on column TB2_YOUNGER.UPDATE_TS is '更新タイムスタンプ';
comment on column TB2_YOUNGER.UPDATE_USER_ID is '更新者';

comment on table TB2_YOUNGEST is '末弟';
comment on column TB2_YOUNGEST.BRO_ID is '兄弟ID';
comment on column TB2_YOUNGEST.YOUNGEST_INFO is '末弟情報';
comment on column TB2_YOUNGEST.INSERT_TS is '作成タイムスタンプ';
comment on column TB2_YOUNGEST.INSERT_USER_ID is '作成者';
comment on column TB2_YOUNGEST.UPDATE_TS is '更新タイムスタンプ';
comment on column TB2_YOUNGEST.UPDATE_USER_ID is '更新者';

comment on table TB3_BEGIN is '当初';
comment on column TB3_BEGIN.BEGIN_ID is '当初ID';
comment on column TB3_BEGIN.BEGIN_INFO is '当初情報';
comment on column TB3_BEGIN.INSERT_TS is '作成タイムスタンプ';
comment on column TB3_BEGIN.INSERT_USER_ID is '作成者';
comment on column TB3_BEGIN.UPDATE_TS is '更新タイムスタンプ';
comment on column TB3_BEGIN.UPDATE_USER_ID is '更新者';

comment on table TB3_BEGIN_HIS is '履歴';
comment on column TB3_BEGIN_HIS.BEGIN_ID is '当初ID';
comment on column TB3_BEGIN_HIS.RIREKI_BN is '履歴枝番';
comment on column TB3_BEGIN_HIS.BEGIN_INFO is '当初情報';
comment on column TB3_BEGIN_HIS.REASON is '変更理由';
comment on column TB3_BEGIN_HIS.INSERT_TS is '作成タイムスタンプ';
comment on column TB3_BEGIN_HIS.INSERT_USER_ID is '作成者';
comment on column TB3_BEGIN_HIS.UPDATE_TS is '更新タイムスタンプ';
comment on column TB3_BEGIN_HIS.UPDATE_USER_ID is '更新者';

comment on table TB4_KO is '子';
comment on column TB4_KO.OYA_ID is '親ID';
comment on column TB4_KO.KO_BN is '子枝番';
comment on column TB4_KO.KO_INFO is '子情報';
comment on column TB4_KO.INSERT_TS is '作成タイムスタンプ';
comment on column TB4_KO.INSERT_USER_ID is '作成者';
comment on column TB4_KO.UPDATE_TS is '更新タイムスタンプ';
comment on column TB4_KO.UPDATE_USER_ID is '更新者';

comment on table TB4_KO_DINKS is '子なし';
comment on column TB4_KO_DINKS.OYA_ID is '親ID';
comment on column TB4_KO_DINKS.KO_BN is '子枝番';
comment on column TB4_KO_DINKS.DINKS_INFO is '子なし情報';
comment on column TB4_KO_DINKS.INSERT_TS is '作成タイムスタンプ';
comment on column TB4_KO_DINKS.INSERT_USER_ID is '作成者';
comment on column TB4_KO_DINKS.UPDATE_TS is '更新タイムスタンプ';
comment on column TB4_KO_DINKS.UPDATE_USER_ID is '更新者';

comment on table TB4_KO_ORPHANS is '孤児';
comment on column TB4_KO_ORPHANS.OYA_ID is '親ID';
comment on column TB4_KO_ORPHANS.KO_BN is '子枝番';
comment on column TB4_KO_ORPHANS.ORPHANS_INFO is '孤児情報';
comment on column TB4_KO_ORPHANS.INSERT_TS is '作成タイムスタンプ';
comment on column TB4_KO_ORPHANS.INSERT_USER_ID is '作成者';
comment on column TB4_KO_ORPHANS.UPDATE_TS is '更新タイムスタンプ';
comment on column TB4_KO_ORPHANS.UPDATE_USER_ID is '更新者';

comment on table TB4_MAGO is '孫';
comment on column TB4_MAGO.OYA_ID is '親ID';
comment on column TB4_MAGO.KO_BN is '子枝番';
comment on column TB4_MAGO.MAGO_BN is '孫枝番';
comment on column TB4_MAGO.MAGO_INFO is '孫情報';
comment on column TB4_MAGO.INSERT_TS is '作成タイムスタンプ';
comment on column TB4_MAGO.INSERT_USER_ID is '作成者';
comment on column TB4_MAGO.UPDATE_TS is '更新タイムスタンプ';
comment on column TB4_MAGO.UPDATE_USER_ID is '更新者';

comment on table TB4_OYA is '親';
comment on column TB4_OYA.OYA_ID is '親ID';
comment on column TB4_OYA.OYA_INFO is '親情報';
comment on column TB4_OYA.INSERT_TS is '作成タイムスタンプ';
comment on column TB4_OYA.INSERT_USER_ID is '作成者';
comment on column TB4_OYA.UPDATE_TS is '更新タイムスタンプ';
comment on column TB4_OYA.UPDATE_USER_ID is '更新者';

comment on table TB5_DERIVE is '派生';
comment on column TB5_DERIVE.DERIVE_ID is '派生ID';
comment on column TB5_DERIVE.PREV_ID is '前世ID';
comment on column TB5_DERIVE.PREV_INFO is '前世情報';
comment on column TB5_DERIVE.INSERT_TS is '作成タイムスタンプ';
comment on column TB5_DERIVE.INSERT_USER_ID is '作成者';
comment on column TB5_DERIVE.UPDATE_TS is '更新タイムスタンプ';
comment on column TB5_DERIVE.UPDATE_USER_ID is '更新者';

comment on table TB5_MERGE is '統合';
comment on column TB5_MERGE.MERGE_ID is '統合ID';
comment on column TB5_MERGE.PREV_ID is '前世ID';
comment on column TB5_MERGE.PREV_INFO is '前世情報';
comment on column TB5_MERGE.ORG_ID is '起源ID';
comment on column TB5_MERGE.ORG_INFO is '起源情報';
comment on column TB5_MERGE.INSERT_TS is '作成タイムスタンプ';
comment on column TB5_MERGE.INSERT_USER_ID is '作成者';
comment on column TB5_MERGE.UPDATE_TS is '更新タイムスタンプ';
comment on column TB5_MERGE.UPDATE_USER_ID is '更新者';

comment on table TB5_PREV is '前世';
comment on column TB5_PREV.PREV_ID is '前世ID';
comment on column TB5_PREV.PREV_INFO is '前世情報';
comment on column TB5_PREV.INSERT_TS is '作成タイムスタンプ';
comment on column TB5_PREV.INSERT_USER_ID is '作成者';
comment on column TB5_PREV.UPDATE_TS is '更新タイムスタンプ';
comment on column TB5_PREV.UPDATE_USER_ID is '更新者';

comment on table TB5_PREV_DET is '前世明細';
comment on column TB5_PREV_DET.PREV_ID is '前世ID';
comment on column TB5_PREV_DET.PREV_BN is '前世明細枝番';
comment on column TB5_PREV_DET.PREV_DET_INFO is '前世明細情報';
comment on column TB5_PREV_DET.INSERT_TS is '作成タイムスタンプ';
comment on column TB5_PREV_DET.INSERT_USER_ID is '作成者';
comment on column TB5_PREV_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column TB5_PREV_DET.UPDATE_USER_ID is '更新者';

comment on table TB5_REBORN is '転生';
comment on column TB5_REBORN.REBORN_ID is '転生ID';
comment on column TB5_REBORN.PREV_ID is '前世ID';
comment on column TB5_REBORN.PREV_INFO is '前世情報';
comment on column TB5_REBORN.INSERT_TS is '作成タイムスタンプ';
comment on column TB5_REBORN.INSERT_USER_ID is '作成者';
comment on column TB5_REBORN.UPDATE_TS is '更新タイムスタンプ';
comment on column TB5_REBORN.UPDATE_USER_ID is '更新者';

comment on table TB5_REBORN_DET is '転生明細';
comment on column TB5_REBORN_DET.REBORN_ID is '転生ID';
comment on column TB5_REBORN_DET.REBORN_BN is '転生明細枝番';
comment on column TB5_REBORN_DET.PREV_DET_INFO is '前世明細情報';
comment on column TB5_REBORN_DET.INSERT_TS is '作成タイムスタンプ';
comment on column TB5_REBORN_DET.INSERT_USER_ID is '作成者';
comment on column TB5_REBORN_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column TB5_REBORN_DET.UPDATE_USER_ID is '更新者';

comment on table TB6_DERIVE1 is '派生１';
comment on column TB6_DERIVE1.DERIVE1_ID is '派生１ID';
comment on column TB6_DERIVE1.ORG_ID is '起源ID';
comment on column TB6_DERIVE1.ORG_INFO is '起源情報';
comment on column TB6_DERIVE1.INSERT_TS is '作成タイムスタンプ';
comment on column TB6_DERIVE1.INSERT_USER_ID is '作成者';
comment on column TB6_DERIVE1.UPDATE_TS is '更新タイムスタンプ';
comment on column TB6_DERIVE1.UPDATE_USER_ID is '更新者';

comment on table TB6_DERIVE1_DET is '派生１明細';
comment on column TB6_DERIVE1_DET.DERIVE1_ID is '派生１ID';
comment on column TB6_DERIVE1_DET.DERIVE1_BN is '派生１枝番';
comment on column TB6_DERIVE1_DET.ORG_DET_INFO is '起源明細情報';
comment on column TB6_DERIVE1_DET.INSERT_TS is '作成タイムスタンプ';
comment on column TB6_DERIVE1_DET.INSERT_USER_ID is '作成者';
comment on column TB6_DERIVE1_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column TB6_DERIVE1_DET.UPDATE_USER_ID is '更新者';

comment on table TB6_DERIVE2 is '派生２';
comment on column TB6_DERIVE2.DERIVE2_ID is '派生２ID';
comment on column TB6_DERIVE2.ORG_ID is '起源ID';
comment on column TB6_DERIVE2.ORG_INFO is '起源情報';
comment on column TB6_DERIVE2.INSERT_TS is '作成タイムスタンプ';
comment on column TB6_DERIVE2.INSERT_USER_ID is '作成者';
comment on column TB6_DERIVE2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB6_DERIVE2.UPDATE_USER_ID is '更新者';

comment on table TB6_DERIVE2_DET is '派生２明細';
comment on column TB6_DERIVE2_DET.DERIVE2_ID is '派生２ID';
comment on column TB6_DERIVE2_DET.DERIVE2_BN is '派生２枝番';
comment on column TB6_DERIVE2_DET.ORG_DET_INFO is '起源明細情報';
comment on column TB6_DERIVE2_DET.INSERT_TS is '作成タイムスタンプ';
comment on column TB6_DERIVE2_DET.INSERT_USER_ID is '作成者';
comment on column TB6_DERIVE2_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column TB6_DERIVE2_DET.UPDATE_USER_ID is '更新者';

comment on table TB6_ORG is '起源';
comment on column TB6_ORG.ORG_ID is '起源ID';
comment on column TB6_ORG.ORG_INFO is '起源情報';
comment on column TB6_ORG.INSERT_TS is '作成タイムスタンプ';
comment on column TB6_ORG.INSERT_USER_ID is '作成者';
comment on column TB6_ORG.UPDATE_TS is '更新タイムスタンプ';
comment on column TB6_ORG.UPDATE_USER_ID is '更新者';

comment on table TB6_ORG_DET is '起源明細';
comment on column TB6_ORG_DET.ORG_ID is '起源ID';
comment on column TB6_ORG_DET.ORG_BN is '起源明細枝番';
comment on column TB6_ORG_DET.ORG_DET_INFO is '起源明細情報';
comment on column TB6_ORG_DET.INSERT_TS is '作成タイムスタンプ';
comment on column TB6_ORG_DET.INSERT_USER_ID is '作成者';
comment on column TB6_ORG_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column TB6_ORG_DET.UPDATE_USER_ID is '更新者';

comment on table TB7_SUM is '集約';
comment on column TB7_SUM.SUM_ID is '集約ID';
comment on column TB7_SUM.SUM_INFO is '集約情報';
comment on column TB7_SUM.INSERT_TS is '作成タイムスタンプ';
comment on column TB7_SUM.INSERT_USER_ID is '作成者';
comment on column TB7_SUM.UPDATE_TS is '更新タイムスタンプ';
comment on column TB7_SUM.UPDATE_USER_ID is '更新者';

comment on table TB7_UNIT1 is '単位１';
comment on column TB7_UNIT1.UNIT1_ID is '単位１ID';
comment on column TB7_UNIT1.SUM_ID is '集約ID';
comment on column TB7_UNIT1.INSERT_TS is '作成タイムスタンプ';
comment on column TB7_UNIT1.INSERT_USER_ID is '作成者';
comment on column TB7_UNIT1.UPDATE_TS is '更新タイムスタンプ';
comment on column TB7_UNIT1.UPDATE_USER_ID is '更新者';

comment on table TB7_UNIT2 is '単位２';
comment on column TB7_UNIT2.UNIT2_ID is '単位２ID';
comment on column TB7_UNIT2.SUM_ID is '集約ID';
comment on column TB7_UNIT2.INSERT_TS is '作成タイムスタンプ';
comment on column TB7_UNIT2.INSERT_USER_ID is '作成者';
comment on column TB7_UNIT2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB7_UNIT2.UPDATE_USER_ID is '更新者';

comment on table TB8_CHOICE is '選抜';
comment on column TB8_CHOICE.CHOICE_ID is '選抜ID';
comment on column TB8_CHOICE.SUM_ID is '集約ID';
comment on column TB8_CHOICE.SUM_INFO is '集約情報';
comment on column TB8_CHOICE.SUM2_ID is '集約２ID';
comment on column TB8_CHOICE.SUM2_INFO is '集約２情報';
comment on column TB8_CHOICE.SUM3_ID is '集約３ID';
comment on column TB8_CHOICE.SUM3_INFO is '集約３情報';
comment on column TB8_CHOICE.INSERT_TS is '作成タイムスタンプ';
comment on column TB8_CHOICE.INSERT_USER_ID is '作成者';
comment on column TB8_CHOICE.UPDATE_TS is '更新タイムスタンプ';
comment on column TB8_CHOICE.UPDATE_USER_ID is '更新者';

comment on table TB8_PREV2 is '前世２';
comment on column TB8_PREV2.PREV2_ID is '前世２ID';
comment on column TB8_PREV2.PREV2_INFO is '前世２情報';
comment on column TB8_PREV2.INSERT_TS is '作成タイムスタンプ';
comment on column TB8_PREV2.INSERT_USER_ID is '作成者';
comment on column TB8_PREV2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB8_PREV2.UPDATE_USER_ID is '更新者';

comment on table TB8_REBORN2 is '転生２';
comment on column TB8_REBORN2.REBORN2_ID is '転生２ID';
comment on column TB8_REBORN2.TASHO2_ID is '他生２ID';
comment on column TB8_REBORN2.INSERT_TS is '作成タイムスタンプ';
comment on column TB8_REBORN2.INSERT_USER_ID is '作成者';
comment on column TB8_REBORN2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB8_REBORN2.UPDATE_USER_ID is '更新者';

comment on table TB8_SUM2 is '集約２';
comment on column TB8_SUM2.SUM2_ID is '集約２ID';
comment on column TB8_SUM2.SUM2_INFO is '集約２情報';
comment on column TB8_SUM2.PREV2_ID is '前世２ID';
comment on column TB8_SUM2.INSERT_TS is '作成タイムスタンプ';
comment on column TB8_SUM2.INSERT_USER_ID is '作成者';
comment on column TB8_SUM2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB8_SUM2.UPDATE_USER_ID is '更新者';

comment on table TB8_SUM3 is '集約３';
comment on column TB8_SUM3.SUM3_ID is '集約３ID';
comment on column TB8_SUM3.SUM3_INFO is '集約３情報';
comment on column TB8_SUM3.INSERT_TS is '作成タイムスタンプ';
comment on column TB8_SUM3.INSERT_USER_ID is '作成者';
comment on column TB8_SUM3.UPDATE_TS is '更新タイムスタンプ';
comment on column TB8_SUM3.UPDATE_USER_ID is '更新者';

comment on table TB8_TASHO1 is '他生１';
comment on column TB8_TASHO1.TASHO1_ID is '他生１ID';
comment on column TB8_TASHO1.SUM2_ID is '集約２ID';
comment on column TB8_TASHO1.INSERT_TS is '作成タイムスタンプ';
comment on column TB8_TASHO1.INSERT_USER_ID is '作成者';
comment on column TB8_TASHO1.UPDATE_TS is '更新タイムスタンプ';
comment on column TB8_TASHO1.UPDATE_USER_ID is '更新者';

comment on table TB8_TASHO2 is '他生２';
comment on column TB8_TASHO2.TASHO2_ID is '他生２ID';
comment on column TB8_TASHO2.SUM3_ID is '集約３ID';
comment on column TB8_TASHO2.INSERT_TS is '作成タイムスタンプ';
comment on column TB8_TASHO2.INSERT_USER_ID is '作成者';
comment on column TB8_TASHO2.UPDATE_TS is '更新タイムスタンプ';
comment on column TB8_TASHO2.UPDATE_USER_ID is '更新者';

comment on table TB9_DEST is '変換先';
comment on column TB9_DEST.DEST_ID is '変換先ID';
comment on column TB9_DEST.DEST_INFO is '変換先情報';
comment on column TB9_DEST.INSERT_TS is '作成タイムスタンプ';
comment on column TB9_DEST.INSERT_USER_ID is '作成者';
comment on column TB9_DEST.UPDATE_TS is '更新タイムスタンプ';
comment on column TB9_DEST.UPDATE_USER_ID is '更新者';

comment on table TB9_FURIWAKE is '振分ビュー';
comment on column TB9_FURIWAKE.table_name is 'テーブル名';
comment on column TB9_FURIWAKE."src_id$dest_id" is 'ID';
comment on column TB9_FURIWAKE.info is '情報';

comment on table TB9_HENKAN is '変換ビュー';
comment on column TB9_HENKAN.table_name is 'テーブル名';
comment on column TB9_HENKAN.src_id is '変換元ID';
comment on column TB9_HENKAN.dest_info is '変換元情報';

comment on table TB9_SRC is '変換元';
comment on column TB9_SRC.SRC_ID is '変換元ID';
comment on column TB9_SRC.SRC_INFO is '変換元情報';
comment on column TB9_SRC.INSERT_TS is '作成タイムスタンプ';
comment on column TB9_SRC.INSERT_USER_ID is '作成者';
comment on column TB9_SRC.UPDATE_TS is '更新タイムスタンプ';
comment on column TB9_SRC.UPDATE_USER_ID is '更新者';

