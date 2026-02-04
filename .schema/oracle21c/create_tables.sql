-- Project Name : emarf
-- Date/Time    : 2026/02/04 19:51:38
-- Author       : t_fuk
-- RDBMS Type   : Oracle Database
-- Application  : A5:SQL Mk-2

-- CDマスタ
create table M04_CD (
  CDREF_CD CHAR(10)
  , CDREF_MEI VARCHAR2(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M04_CD_PKC primary key (CDREF_CD)
) ;

-- IDマスタ
create table M04_ID (
  IDREF_ID NUMBER(10)
  , IDREF_MEI VARCHAR2(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M04_ID_PKC primary key (IDREF_ID)
) ;

-- ID連番マスタ
create table M04_IDBN (
  IDREF_ID NUMBER(10)
  , IDBN_BN NUMBER(10)
  , IDBN_NO CHAR(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M04_IDBN_PKC primary key (IDREF_ID,IDBN_BN)
) ;

-- NOマスタ
create table M04_NO (
  NOREF_NO CHAR(10)
  , NOREF_MEI VARCHAR2(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M04_NO_PKC primary key (NOREF_NO)
) ;

-- 再帰
create table M04_SAIKI (
  SAIKI_ID NUMBER(10)
  , SAIKI_MEI VARCHAR2(60) not null
  , IDREF_ID NUMBER(10)
  , CDREF_CD CHAR(10)
  , NOREF_NO CHAR(10)
  , EX_IDREF_ID NUMBER(10)
  , EX_IDBN_BN NUMBER(10)
  , OYA_SAIKI_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M04_SAIKI_PKC primary key (SAIKI_ID)
) ;

-- マスタ参照１
create table M05_REF1 (
  REF1_ID NUMBER(10)
  , REF1_MEI VARCHAR2(60) not null
  , DELETE_F CHAR(1)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M05_REF1_PKC primary key (REF1_ID)
) ;

-- マスタ参照２
create table M05_REF2 (
  REF2_ID NUMBER(10)
  , REF2_MEI VARCHAR2(60) not null
  , DELETE_F CHAR(1)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M05_REF2_PKC primary key (REF2_ID)
) ;

-- マスタ参照３
create table M05_REF3 (
  REF3_ID NUMBER(10)
  , REF3_MEI VARCHAR2(60) not null
  , DELETE_F CHAR(1)
  , TEKIYO_BI DATE
  , HAISHI_BI DATE
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint M05_REF3_PKC primary key (REF3_ID)
) ;

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
create table T00_ENTITY (
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
  , constraint T00_ENTITY_PKC primary key (ENTITY_ID)
) ;

-- 主キーなし
create table T00_NOKEY (
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

create unique index T00_NOKEY_IX1
  on T00_NOKEY(COL_A,COL_B,COL_C);

create unique index T00_NOKEY_IX2
  on T00_NOKEY(COL_D,COL_E);

-- 子なし
create table T01_DINKS (
  OYA_ID NUMBER(10) not null
  , KO_BN NUMBER(10)
  , DINKS_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T01_DINKS_PKC primary key (OYA_ID,KO_BN)
) ;

-- 子
create table T01_KO (
  OYA_ID NUMBER(10)
  , KO_BN NUMBER(10)
  , KO_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T01_KO_PKC primary key (OYA_ID,KO_BN)
) ;

-- 孫
create table T01_MAGO (
  OYA_ID NUMBER(10)
  , KO_BN NUMBER(10)
  , MAGO_BN NUMBER(10)
  , MAGO_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T01_MAGO_PKC primary key (OYA_ID,KO_BN,MAGO_BN)
) ;

-- 孤児
create table T01_ORPHAN (
  OYA_ID NUMBER(10)
  , KO_BN NUMBER(10)
  , ORPHAN_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T01_ORPHAN_PKC primary key (OYA_ID,KO_BN)
) ;

-- 親
create table T01_OYA (
  OYA_ID NUMBER(10)
  , OYA_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T01_OYA_PKC primary key (OYA_ID)
) ;

-- 長兄
create table T02_ELDEST (
  BRO_ID NUMBER(10)
  , ELDEST_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T02_ELDEST_PKC primary key (BRO_ID)
) ;

-- 里子
create table T02_FOSTER (
  BRO_ID NUMBER(10)
  , FOSTER_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T02_FOSTER_PKC primary key (BRO_ID)
) ;

-- 弟
create table T02_YOUNGER (
  BRO_ID NUMBER(10)
  , YOUNGER_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T02_YOUNGER_PKC primary key (BRO_ID)
) ;

-- 末弟
create table T02_YOUNGEST (
  BRO_ID NUMBER(10)
  , YOUNGEST_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T02_YOUNGEST_PKC primary key (BRO_ID)
) ;

-- 変遷
create table T03_TRANS (
  TRANS_ID NUMBER(10)
  , TRANS_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T03_TRANS_PKC primary key (TRANS_ID)
) ;

-- 変遷履歴
create table T03_TRANS_HIS (
  TRANS_ID NUMBER(10)
  , TRANS_BN NUMBER(10)
  , TRANS_INFO VARCHAR2(300)
  , RIYU_TX VARCHAR2(300) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T03_TRANS_HIS_PKC primary key (TRANS_ID,TRANS_BN)
) ;

-- 複合１
create table T05_COMP1 (
  REF1_ID NUMBER(10)
  , REF2_ID NUMBER(10)
  , COMP1_MEI VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T05_COMP1_PKC primary key (REF1_ID,REF2_ID)
) ;

-- 複合２
create table T05_COMP2 (
  REF1_ID NUMBER(10)
  , REF2_ID NUMBER(10)
  , REF3_ID NUMBER(10)
  , TEKIYO_BI DATE
  , COMP2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T05_COMP2_PKC primary key (REF1_ID,REF2_ID,REF3_ID,TEKIYO_BI)
) ;

-- 派生１
create table T06_DERIVE1 (
  DERIVE1_ID NUMBER(10)
  , ORG_INFO VARCHAR2(300)
  , ORG_ID NUMBER(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T06_DERIVE1_PKC primary key (DERIVE1_ID)
) ;

-- 派生１明細
create table T06_DERIVE1_DET (
  DERIVE1_ID NUMBER(10)
  , DERIVE1_BN NUMBER(10)
  , DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T06_DERIVE1_DET_PKC primary key (DERIVE1_ID,DERIVE1_BN)
) ;

-- 派生２
create table T06_DERIVE2 (
  DERIVE2_ID NUMBER(10)
  , ORG_INFO VARCHAR2(300)
  , ORG_ID NUMBER(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T06_DERIVE2_PKC primary key (DERIVE2_ID)
) ;

-- 派生２明細
create table T06_DERIVE2_DET (
  DERIVE2_ID NUMBER(10)
  , DERIVE2_BN NUMBER(10)
  , DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T06_DERIVE2_DET_PKC primary key (DERIVE2_ID,DERIVE2_BN)
) ;

-- 起源
create table T06_ORG (
  ORG_ID NUMBER(10)
  , ORG_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T06_ORG_PKC primary key (ORG_ID)
) ;

-- 起源明細
create table T06_ORG_DET (
  ORG_ID NUMBER(10)
  , ORG_BN NUMBER(10)
  , DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T06_ORG_DET_PKC primary key (ORG_ID,ORG_BN)
) ;

-- 前世
create table T07_PREV (
  PREV_ID NUMBER(10)
  , PREV_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T07_PREV_PKC primary key (PREV_ID)
) ;

-- 前世明細
create table T07_PREV_DET (
  PREV_ID NUMBER(10)
  , PREV_BN NUMBER(10)
  , DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T07_PREV_DET_PKC primary key (PREV_ID,PREV_BN)
) ;

-- 転生
create table T07_REBORN (
  REBORN_ID NUMBER(10)
  , PREV_INFO VARCHAR2(300)
  , PREV_ID NUMBER(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T07_REBORN_PKC primary key (REBORN_ID)
) ;

-- 転生明細
create table T07_REBORN_DET (
  REBORN_ID NUMBER(10)
  , REBORN_BN NUMBER(10)
  , DET_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T07_REBORN_DET_PKC primary key (REBORN_ID,REBORN_BN)
) ;

-- 寄生１
create table T08_KISEI1 (
  KISEI1_ID NUMBER(10)
  , KISEI1_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T08_KISEI1_PKC primary key (KISEI1_ID)
) ;

-- 寄生２
create table T08_KISEI2 (
  KISEI2_ID NUMBER(10)
  , KISEI2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T08_KISEI2_PKC primary key (KISEI2_ID)
) ;

-- 共生
create table T08_KYOSEI (
  KYOSEI_ID NUMBER(10)
  , KISEI1_ID NUMBER(10) not null
  , KISEI1_INFO VARCHAR2(300)
  , KISEI2_ID NUMBER(10) not null
  , KISEI2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T08_KYOSEI_PKC primary key (KYOSEI_ID)
) ;

-- 集団１
create table T09_GRP1 (
  GRP1_ID NUMBER(10)
  , SUM_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T09_GRP1_PKC primary key (GRP1_ID)
) ;

-- 集団２
create table T09_GRP2 (
  GRP2_ID NUMBER(10)
  , SUM_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T09_GRP2_PKC primary key (GRP2_ID)
) ;

-- 集約
create table T09_SUM (
  SUM_ID NUMBER(10)
  , SUM_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T09_SUM_PKC primary key (SUM_ID)
) ;

-- 選抜
create table T10_CHOICE (
  CHOICE_ID NUMBER(10)
  , KOHO1_ID NUMBER(10)
  , KOHO1_INFO VARCHAR2(300)
  , KOHO2_ID NUMBER(10)
  , KOHO2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T10_CHOICE_PKC primary key (CHOICE_ID)
) ;

-- 候補１
create table T10_KOHO1 (
  KOHO1_ID NUMBER(10)
  , KOHO1_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T10_KOHO1_PKC primary key (KOHO1_ID)
) ;

-- 候補２
create table T10_KOHO2 (
  KOHO2_ID NUMBER(10)
  , KOHO2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T10_KOHO2_PKC primary key (KOHO2_ID)
) ;

-- 前世２
create table T11_PREV2 (
  PREV2_ID NUMBER(10)
  , PREV2_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T11_PREV2_PKC primary key (PREV2_ID)
) ;

-- 転生２
create table T11_REBORN2 (
  REBORN2_ID NUMBER(10)
  , PREV2_INFO VARCHAR2(300)
  , PREV2_ID NUMBER(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T11_REBORN2_PKC primary key (REBORN2_ID)
) ;

-- 他生１
create table T11_TASHO1 (
  TASHO1_ID NUMBER(10)
  , REBORN2_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T11_TASHO1_PKC primary key (TASHO1_ID)
) ;

-- 候補３
create table T12_KOHO3 (
  KOHO3_ID NUMBER(10)
  , KOHO3_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T12_KOHO3_PKC primary key (KOHO3_ID)
) ;

-- 転生３
create table T12_REBORN3 (
  REBORN3_ID NUMBER(10)
  , TASHO2_ID NUMBER(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T12_REBORN3_PKC primary key (REBORN3_ID)
) ;

-- 他生２
create table T12_TASHO2 (
  TASHO2_ID NUMBER(10)
  , KOHO3_ID NUMBER(10)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T12_TASHO2_PKC primary key (TASHO2_ID)
) ;

-- 変換先
create table T13_DEST (
  DEST_ID NUMBER(10)
  , DEST_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T13_DEST_PKC primary key (DEST_ID)
) ;

-- 変換元
create table T13_SRC (
  SRC_ID NUMBER(10)
  , SRC_INFO VARCHAR2(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID NUMBER(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID NUMBER(10) not null
  , constraint T13_SRC_PKC primary key (SRC_ID)
) ;

-- 振分ビュー
create view V13_FURIWAKE as 
SELECT
    a.table_name                                -- テーブル名
    , a."SRC_ID$DEST_ID"                        -- 振分ID
    , a.info                                    -- 情報
FROM
    ( 
        SELECT
            'T13_SRC' AS table_name
            , s.src_id AS "SRC_ID$DEST_ID"
            , s.src_info AS info 
        FROM
            t13_src s 
        UNION 
        SELECT
            'T13_DEST'
            , s.dest_id
            , s.dest_info 
        FROM
            t13_dest s
    ) a

;

-- 変換ビュー
create view V13_HENKAN as 
SELECT
    'T13_DEST' AS table_name                    -- テーブル名
    , s.src_id                                  -- 変換元ID
    , s.src_info AS dest_info                   -- 変換元情報
FROM
    t13_src s

;

comment on table M04_CD is 'CDマスタ';
comment on column M04_CD.CDREF_CD is '参照CD';
comment on column M04_CD.CDREF_MEI is 'CD参照名';
comment on column M04_CD.INSERT_TS is '作成タイムスタンプ';
comment on column M04_CD.INSERT_USER_ID is '作成者';
comment on column M04_CD.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_CD.UPDATE_USER_ID is '更新者';

comment on table M04_ID is 'IDマスタ';
comment on column M04_ID.IDREF_ID is '参照ID';
comment on column M04_ID.IDREF_MEI is 'ID参照名';
comment on column M04_ID.INSERT_TS is '作成タイムスタンプ';
comment on column M04_ID.INSERT_USER_ID is '作成者';
comment on column M04_ID.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_ID.UPDATE_USER_ID is '更新者';

comment on table M04_IDBN is 'ID連番マスタ';
comment on column M04_IDBN.IDREF_ID is '参照ID';
comment on column M04_IDBN.IDBN_BN is '参照連番';
comment on column M04_IDBN.IDBN_NO is 'ID連番NO';
comment on column M04_IDBN.INSERT_TS is '作成タイムスタンプ';
comment on column M04_IDBN.INSERT_USER_ID is '作成者';
comment on column M04_IDBN.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_IDBN.UPDATE_USER_ID is '更新者';

comment on table M04_NO is 'NOマスタ';
comment on column M04_NO.NOREF_NO is '参照NO';
comment on column M04_NO.NOREF_MEI is 'NO参照名';
comment on column M04_NO.INSERT_TS is '作成タイムスタンプ';
comment on column M04_NO.INSERT_USER_ID is '作成者';
comment on column M04_NO.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_NO.UPDATE_USER_ID is '更新者';

comment on table M04_SAIKI is '再帰';
comment on column M04_SAIKI.SAIKI_ID is '再帰ID';
comment on column M04_SAIKI.SAIKI_MEI is '再帰名';
comment on column M04_SAIKI.IDREF_ID is '参照ID';
comment on column M04_SAIKI.CDREF_CD is '参照CD';
comment on column M04_SAIKI.NOREF_NO is '参照NO';
comment on column M04_SAIKI.EX_IDREF_ID is 'ID連番ID';
comment on column M04_SAIKI.EX_IDBN_BN is 'ID連番';
comment on column M04_SAIKI.OYA_SAIKI_ID is '親再帰ID';
comment on column M04_SAIKI.INSERT_TS is '作成タイムスタンプ';
comment on column M04_SAIKI.INSERT_USER_ID is '作成者';
comment on column M04_SAIKI.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_SAIKI.UPDATE_USER_ID is '更新者';

comment on table M05_REF1 is 'マスタ参照１';
comment on column M05_REF1.REF1_ID is '参照１ID';
comment on column M05_REF1.REF1_MEI is '参照１名';
comment on column M05_REF1.DELETE_F is '削除フラグ';
comment on column M05_REF1.TEKIYO_BI is '適用日';
comment on column M05_REF1.HAISHI_BI is '廃止日';
comment on column M05_REF1.INSERT_TS is '作成タイムスタンプ';
comment on column M05_REF1.INSERT_USER_ID is '作成者';
comment on column M05_REF1.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_REF1.UPDATE_USER_ID is '更新者';

comment on table M05_REF2 is 'マスタ参照２';
comment on column M05_REF2.REF2_ID is '参照２ID';
comment on column M05_REF2.REF2_MEI is '参照２名';
comment on column M05_REF2.DELETE_F is '削除フラグ';
comment on column M05_REF2.TEKIYO_BI is '適用日';
comment on column M05_REF2.HAISHI_BI is '廃止日';
comment on column M05_REF2.INSERT_TS is '作成タイムスタンプ';
comment on column M05_REF2.INSERT_USER_ID is '作成者';
comment on column M05_REF2.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_REF2.UPDATE_USER_ID is '更新者';

comment on table M05_REF3 is 'マスタ参照３';
comment on column M05_REF3.REF3_ID is '参照３ID';
comment on column M05_REF3.REF3_MEI is '参照３名';
comment on column M05_REF3.DELETE_F is '削除フラグ';
comment on column M05_REF3.TEKIYO_BI is '適用日';
comment on column M05_REF3.HAISHI_BI is '廃止日';
comment on column M05_REF3.INSERT_TS is '作成タイムスタンプ';
comment on column M05_REF3.INSERT_USER_ID is '作成者';
comment on column M05_REF3.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_REF3.UPDATE_USER_ID is '更新者';

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
comment on column MHR_SHOKUI_NINKA.KINO_NM is '機能名称:機能名の正規表現';
comment on column MHR_SHOKUI_NINKA.KENGEN_KB is '権限区分:1:参照,2:出力,3:更新削除,4:追加,5:承認,6:否認';
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

comment on table T00_ENTITY is 'エンティティ';
comment on column T00_ENTITY.ENTITY_ID is 'エンティティID';
comment on column T00_ENTITY.ENTITY_NM is 'エンティティ名称';
comment on column T00_ENTITY.ENTITY_MEI is 'エンティティ名';
comment on column T00_ENTITY.CHECK_F is 'チェックフラグ';
comment on column T00_ENTITY.RADIO_KB is 'ラジオ区分';
comment on column T00_ENTITY.PULLDOWN_KB is 'プルダウン区分';
comment on column T00_ENTITY.PULLDOWN_SB is 'プルダウン種別';
comment on column T00_ENTITY.MEMO_TX is 'メモ';
comment on column T00_ENTITY.MEMO is '１行メモ';
comment on column T00_ENTITY.TENPU_FILE is '添付ファイル';
comment on column T00_ENTITY.NENGAPPI_Y is '年月日年';
comment on column T00_ENTITY.NENGAPPI_M is '年月日月';
comment on column T00_ENTITY.NENGAPPI_D is '年月日日';
comment on column T00_ENTITY.NENGETSU_YM is '年月';
comment on column T00_ENTITY.NENGAPPI_YMD is '年月日';
comment on column T00_ENTITY.TIMESTAMP_TS is 'タイムスタンプ';
comment on column T00_ENTITY.NICHIJI_DT is '日時';
comment on column T00_ENTITY.HIDUKE_BI is '日付';
comment on column T00_ENTITY.JIKOKU_HM is '時刻';
comment on column T00_ENTITY.JIKAN_TM is '時間';
comment on column T00_ENTITY.SURYO_QT is '数量';
comment on column T00_ENTITY.TSUKA_KB is '通貨区分';
comment on column T00_ENTITY.JUCHU_PR is '受注単価';
comment on column T00_ENTITY.JUCHU_AM is '受注金額';
comment on column T00_ENTITY.HACHU_PR is '発注単価';
comment on column T00_ENTITY.HACHU_AM is '発注金額';
comment on column T00_ENTITY.DELETE_F is '削除フラグ:必須チェックにかかるのでNOTNULLにしない';
comment on column T00_ENTITY.STATUS_KB is 'ステータス区分:必須チェックにかかるのでNOTNULLにしない';
comment on column T00_ENTITY.INSERT_TS is '作成タイムスタンプ';
comment on column T00_ENTITY.INSERT_USER_ID is '作成者';
comment on column T00_ENTITY.UPDATE_TS is '更新タイムスタンプ';
comment on column T00_ENTITY.UPDATE_USER_ID is '更新者';

comment on table T00_NOKEY is '主キーなし';
comment on column T00_NOKEY.COL_A is '列Ａ';
comment on column T00_NOKEY.COL_B is '列Ｂ';
comment on column T00_NOKEY.COL_C is '列Ｃ';
comment on column T00_NOKEY.COL_D is '列Ｄ';
comment on column T00_NOKEY.COL_E is '列Ｅ';
comment on column T00_NOKEY.INSERT_TS is '作成タイムスタンプ';
comment on column T00_NOKEY.INSERT_USER_ID is '作成者';
comment on column T00_NOKEY.UPDATE_TS is '更新タイムスタンプ';
comment on column T00_NOKEY.UPDATE_USER_ID is '更新者';

comment on table T01_DINKS is '子なし';
comment on column T01_DINKS.OYA_ID is '親ID';
comment on column T01_DINKS.KO_BN is '子枝番';
comment on column T01_DINKS.DINKS_INFO is '子なし情報';
comment on column T01_DINKS.INSERT_TS is '作成タイムスタンプ';
comment on column T01_DINKS.INSERT_USER_ID is '作成者';
comment on column T01_DINKS.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_DINKS.UPDATE_USER_ID is '更新者';

comment on table T01_KO is '子';
comment on column T01_KO.OYA_ID is '親ID';
comment on column T01_KO.KO_BN is '子枝番';
comment on column T01_KO.KO_INFO is '子情報';
comment on column T01_KO.INSERT_TS is '作成タイムスタンプ';
comment on column T01_KO.INSERT_USER_ID is '作成者';
comment on column T01_KO.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_KO.UPDATE_USER_ID is '更新者';

comment on table T01_MAGO is '孫';
comment on column T01_MAGO.OYA_ID is '親ID';
comment on column T01_MAGO.KO_BN is '子枝番';
comment on column T01_MAGO.MAGO_BN is '孫枝番';
comment on column T01_MAGO.MAGO_INFO is '孫情報';
comment on column T01_MAGO.INSERT_TS is '作成タイムスタンプ';
comment on column T01_MAGO.INSERT_USER_ID is '作成者';
comment on column T01_MAGO.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_MAGO.UPDATE_USER_ID is '更新者';

comment on table T01_ORPHAN is '孤児';
comment on column T01_ORPHAN.OYA_ID is '親ID';
comment on column T01_ORPHAN.KO_BN is '子枝番';
comment on column T01_ORPHAN.ORPHAN_INFO is '孤児情報';
comment on column T01_ORPHAN.INSERT_TS is '作成タイムスタンプ';
comment on column T01_ORPHAN.INSERT_USER_ID is '作成者';
comment on column T01_ORPHAN.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_ORPHAN.UPDATE_USER_ID is '更新者';

comment on table T01_OYA is '親';
comment on column T01_OYA.OYA_ID is '親ID';
comment on column T01_OYA.OYA_INFO is '親情報';
comment on column T01_OYA.INSERT_TS is '作成タイムスタンプ';
comment on column T01_OYA.INSERT_USER_ID is '作成者';
comment on column T01_OYA.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_OYA.UPDATE_USER_ID is '更新者';

comment on table T02_ELDEST is '長兄';
comment on column T02_ELDEST.BRO_ID is '兄弟ID';
comment on column T02_ELDEST.ELDEST_INFO is '長兄情報';
comment on column T02_ELDEST.INSERT_TS is '作成タイムスタンプ';
comment on column T02_ELDEST.INSERT_USER_ID is '作成者';
comment on column T02_ELDEST.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_ELDEST.UPDATE_USER_ID is '更新者';

comment on table T02_FOSTER is '里子';
comment on column T02_FOSTER.BRO_ID is '兄弟ID';
comment on column T02_FOSTER.FOSTER_INFO is '里子情報';
comment on column T02_FOSTER.INSERT_TS is '作成タイムスタンプ';
comment on column T02_FOSTER.INSERT_USER_ID is '作成者';
comment on column T02_FOSTER.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_FOSTER.UPDATE_USER_ID is '更新者';

comment on table T02_YOUNGER is '弟';
comment on column T02_YOUNGER.BRO_ID is '兄弟ID';
comment on column T02_YOUNGER.YOUNGER_INFO is '弟情報';
comment on column T02_YOUNGER.INSERT_TS is '作成タイムスタンプ';
comment on column T02_YOUNGER.INSERT_USER_ID is '作成者';
comment on column T02_YOUNGER.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_YOUNGER.UPDATE_USER_ID is '更新者';

comment on table T02_YOUNGEST is '末弟';
comment on column T02_YOUNGEST.BRO_ID is '兄弟ID';
comment on column T02_YOUNGEST.YOUNGEST_INFO is '末弟情報';
comment on column T02_YOUNGEST.INSERT_TS is '作成タイムスタンプ';
comment on column T02_YOUNGEST.INSERT_USER_ID is '作成者';
comment on column T02_YOUNGEST.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_YOUNGEST.UPDATE_USER_ID is '更新者';

comment on table T03_TRANS is '変遷';
comment on column T03_TRANS.TRANS_ID is '変遷ID';
comment on column T03_TRANS.TRANS_INFO is '変遷情報';
comment on column T03_TRANS.INSERT_TS is '作成タイムスタンプ';
comment on column T03_TRANS.INSERT_USER_ID is '作成者';
comment on column T03_TRANS.UPDATE_TS is '更新タイムスタンプ';
comment on column T03_TRANS.UPDATE_USER_ID is '更新者';

comment on table T03_TRANS_HIS is '変遷履歴';
comment on column T03_TRANS_HIS.TRANS_ID is '変遷ID';
comment on column T03_TRANS_HIS.TRANS_BN is '変遷枝番';
comment on column T03_TRANS_HIS.TRANS_INFO is '変遷情報';
comment on column T03_TRANS_HIS.RIYU_TX is '変更理由';
comment on column T03_TRANS_HIS.INSERT_TS is '作成タイムスタンプ';
comment on column T03_TRANS_HIS.INSERT_USER_ID is '作成者';
comment on column T03_TRANS_HIS.UPDATE_TS is '更新タイムスタンプ';
comment on column T03_TRANS_HIS.UPDATE_USER_ID is '更新者';

comment on table T05_COMP1 is '複合１';
comment on column T05_COMP1.REF1_ID is '参照１ID';
comment on column T05_COMP1.REF2_ID is '参照２ID';
comment on column T05_COMP1.COMP1_MEI is '複合１名';
comment on column T05_COMP1.INSERT_TS is '作成タイムスタンプ';
comment on column T05_COMP1.INSERT_USER_ID is '作成者';
comment on column T05_COMP1.UPDATE_TS is '更新タイムスタンプ';
comment on column T05_COMP1.UPDATE_USER_ID is '更新者';

comment on table T05_COMP2 is '複合２';
comment on column T05_COMP2.REF1_ID is '参照１ID';
comment on column T05_COMP2.REF2_ID is '参照２ID';
comment on column T05_COMP2.REF3_ID is '参照３ID';
comment on column T05_COMP2.TEKIYO_BI is '適用日';
comment on column T05_COMP2.COMP2_INFO is '複合２情報';
comment on column T05_COMP2.INSERT_TS is '作成タイムスタンプ';
comment on column T05_COMP2.INSERT_USER_ID is '作成者';
comment on column T05_COMP2.UPDATE_TS is '更新タイムスタンプ';
comment on column T05_COMP2.UPDATE_USER_ID is '更新者';

comment on table T06_DERIVE1 is '派生１';
comment on column T06_DERIVE1.DERIVE1_ID is '派生１ID';
comment on column T06_DERIVE1.ORG_INFO is '起源情報';
comment on column T06_DERIVE1.ORG_ID is '起源ID';
comment on column T06_DERIVE1.INSERT_TS is '作成タイムスタンプ';
comment on column T06_DERIVE1.INSERT_USER_ID is '作成者';
comment on column T06_DERIVE1.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_DERIVE1.UPDATE_USER_ID is '更新者';

comment on table T06_DERIVE1_DET is '派生１明細';
comment on column T06_DERIVE1_DET.DERIVE1_ID is '派生１ID';
comment on column T06_DERIVE1_DET.DERIVE1_BN is '派生１枝番';
comment on column T06_DERIVE1_DET.DET_INFO is '明細情報';
comment on column T06_DERIVE1_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T06_DERIVE1_DET.INSERT_USER_ID is '作成者';
comment on column T06_DERIVE1_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_DERIVE1_DET.UPDATE_USER_ID is '更新者';

comment on table T06_DERIVE2 is '派生２';
comment on column T06_DERIVE2.DERIVE2_ID is '派生２ID';
comment on column T06_DERIVE2.ORG_INFO is '起源情報';
comment on column T06_DERIVE2.ORG_ID is '起源ID';
comment on column T06_DERIVE2.INSERT_TS is '作成タイムスタンプ';
comment on column T06_DERIVE2.INSERT_USER_ID is '作成者';
comment on column T06_DERIVE2.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_DERIVE2.UPDATE_USER_ID is '更新者';

comment on table T06_DERIVE2_DET is '派生２明細';
comment on column T06_DERIVE2_DET.DERIVE2_ID is '派生２ID';
comment on column T06_DERIVE2_DET.DERIVE2_BN is '派生２枝番';
comment on column T06_DERIVE2_DET.DET_INFO is '明細情報';
comment on column T06_DERIVE2_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T06_DERIVE2_DET.INSERT_USER_ID is '作成者';
comment on column T06_DERIVE2_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_DERIVE2_DET.UPDATE_USER_ID is '更新者';

comment on table T06_ORG is '起源';
comment on column T06_ORG.ORG_ID is '起源ID';
comment on column T06_ORG.ORG_INFO is '起源情報';
comment on column T06_ORG.INSERT_TS is '作成タイムスタンプ';
comment on column T06_ORG.INSERT_USER_ID is '作成者';
comment on column T06_ORG.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_ORG.UPDATE_USER_ID is '更新者';

comment on table T06_ORG_DET is '起源明細';
comment on column T06_ORG_DET.ORG_ID is '起源ID';
comment on column T06_ORG_DET.ORG_BN is '起源枝番';
comment on column T06_ORG_DET.DET_INFO is '明細情報';
comment on column T06_ORG_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T06_ORG_DET.INSERT_USER_ID is '作成者';
comment on column T06_ORG_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_ORG_DET.UPDATE_USER_ID is '更新者';

comment on table T07_PREV is '前世';
comment on column T07_PREV.PREV_ID is '前世ID';
comment on column T07_PREV.PREV_INFO is '前世情報';
comment on column T07_PREV.INSERT_TS is '作成タイムスタンプ';
comment on column T07_PREV.INSERT_USER_ID is '作成者';
comment on column T07_PREV.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_PREV.UPDATE_USER_ID is '更新者';

comment on table T07_PREV_DET is '前世明細';
comment on column T07_PREV_DET.PREV_ID is '前世ID';
comment on column T07_PREV_DET.PREV_BN is '前世枝番';
comment on column T07_PREV_DET.DET_INFO is '明細情報';
comment on column T07_PREV_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T07_PREV_DET.INSERT_USER_ID is '作成者';
comment on column T07_PREV_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_PREV_DET.UPDATE_USER_ID is '更新者';

comment on table T07_REBORN is '転生';
comment on column T07_REBORN.REBORN_ID is '転生ID';
comment on column T07_REBORN.PREV_INFO is '前世情報';
comment on column T07_REBORN.PREV_ID is '前世ID';
comment on column T07_REBORN.INSERT_TS is '作成タイムスタンプ';
comment on column T07_REBORN.INSERT_USER_ID is '作成者';
comment on column T07_REBORN.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_REBORN.UPDATE_USER_ID is '更新者';

comment on table T07_REBORN_DET is '転生明細';
comment on column T07_REBORN_DET.REBORN_ID is '転生ID';
comment on column T07_REBORN_DET.REBORN_BN is '転生枝番';
comment on column T07_REBORN_DET.DET_INFO is '明細情報';
comment on column T07_REBORN_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T07_REBORN_DET.INSERT_USER_ID is '作成者';
comment on column T07_REBORN_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_REBORN_DET.UPDATE_USER_ID is '更新者';

comment on table T08_KISEI1 is '寄生１';
comment on column T08_KISEI1.KISEI1_ID is '寄生１ID';
comment on column T08_KISEI1.KISEI1_INFO is '寄生１情報';
comment on column T08_KISEI1.INSERT_TS is '作成タイムスタンプ';
comment on column T08_KISEI1.INSERT_USER_ID is '作成者';
comment on column T08_KISEI1.UPDATE_TS is '更新タイムスタンプ';
comment on column T08_KISEI1.UPDATE_USER_ID is '更新者';

comment on table T08_KISEI2 is '寄生２';
comment on column T08_KISEI2.KISEI2_ID is '寄生２ID';
comment on column T08_KISEI2.KISEI2_INFO is '寄生２情報';
comment on column T08_KISEI2.INSERT_TS is '作成タイムスタンプ';
comment on column T08_KISEI2.INSERT_USER_ID is '作成者';
comment on column T08_KISEI2.UPDATE_TS is '更新タイムスタンプ';
comment on column T08_KISEI2.UPDATE_USER_ID is '更新者';

comment on table T08_KYOSEI is '共生';
comment on column T08_KYOSEI.KYOSEI_ID is '共生ID';
comment on column T08_KYOSEI.KISEI1_ID is '寄生１ID';
comment on column T08_KYOSEI.KISEI1_INFO is '寄生１情報';
comment on column T08_KYOSEI.KISEI2_ID is '寄生２ID';
comment on column T08_KYOSEI.KISEI2_INFO is '寄生２情報';
comment on column T08_KYOSEI.INSERT_TS is '作成タイムスタンプ';
comment on column T08_KYOSEI.INSERT_USER_ID is '作成者';
comment on column T08_KYOSEI.UPDATE_TS is '更新タイムスタンプ';
comment on column T08_KYOSEI.UPDATE_USER_ID is '更新者';

comment on table T09_GRP1 is '集団１';
comment on column T09_GRP1.GRP1_ID is '集団１ID';
comment on column T09_GRP1.SUM_ID is '集約ID';
comment on column T09_GRP1.INSERT_TS is '作成タイムスタンプ';
comment on column T09_GRP1.INSERT_USER_ID is '作成者';
comment on column T09_GRP1.UPDATE_TS is '更新タイムスタンプ';
comment on column T09_GRP1.UPDATE_USER_ID is '更新者';

comment on table T09_GRP2 is '集団２';
comment on column T09_GRP2.GRP2_ID is '集団２ID';
comment on column T09_GRP2.SUM_ID is '集約ID';
comment on column T09_GRP2.INSERT_TS is '作成タイムスタンプ';
comment on column T09_GRP2.INSERT_USER_ID is '作成者';
comment on column T09_GRP2.UPDATE_TS is '更新タイムスタンプ';
comment on column T09_GRP2.UPDATE_USER_ID is '更新者';

comment on table T09_SUM is '集約';
comment on column T09_SUM.SUM_ID is '集約ID';
comment on column T09_SUM.SUM_INFO is '集約情報';
comment on column T09_SUM.INSERT_TS is '作成タイムスタンプ';
comment on column T09_SUM.INSERT_USER_ID is '作成者';
comment on column T09_SUM.UPDATE_TS is '更新タイムスタンプ';
comment on column T09_SUM.UPDATE_USER_ID is '更新者';

comment on table T10_CHOICE is '選抜';
comment on column T10_CHOICE.CHOICE_ID is '選抜ID';
comment on column T10_CHOICE.KOHO1_ID is '候補１ID';
comment on column T10_CHOICE.KOHO1_INFO is '候補１情報';
comment on column T10_CHOICE.KOHO2_ID is '候補２ID';
comment on column T10_CHOICE.KOHO2_INFO is '候補２情報';
comment on column T10_CHOICE.INSERT_TS is '作成タイムスタンプ';
comment on column T10_CHOICE.INSERT_USER_ID is '作成者';
comment on column T10_CHOICE.UPDATE_TS is '更新タイムスタンプ';
comment on column T10_CHOICE.UPDATE_USER_ID is '更新者';

comment on table T10_KOHO1 is '候補１';
comment on column T10_KOHO1.KOHO1_ID is '候補１ID';
comment on column T10_KOHO1.KOHO1_INFO is '候補１情報';
comment on column T10_KOHO1.INSERT_TS is '作成タイムスタンプ';
comment on column T10_KOHO1.INSERT_USER_ID is '作成者';
comment on column T10_KOHO1.UPDATE_TS is '更新タイムスタンプ';
comment on column T10_KOHO1.UPDATE_USER_ID is '更新者';

comment on table T10_KOHO2 is '候補２';
comment on column T10_KOHO2.KOHO2_ID is '候補２ID';
comment on column T10_KOHO2.KOHO2_INFO is '候補２情報';
comment on column T10_KOHO2.INSERT_TS is '作成タイムスタンプ';
comment on column T10_KOHO2.INSERT_USER_ID is '作成者';
comment on column T10_KOHO2.UPDATE_TS is '更新タイムスタンプ';
comment on column T10_KOHO2.UPDATE_USER_ID is '更新者';

comment on table T11_PREV2 is '前世２';
comment on column T11_PREV2.PREV2_ID is '前世２ID';
comment on column T11_PREV2.PREV2_INFO is '前世２情報';
comment on column T11_PREV2.INSERT_TS is '作成タイムスタンプ';
comment on column T11_PREV2.INSERT_USER_ID is '作成者';
comment on column T11_PREV2.UPDATE_TS is '更新タイムスタンプ';
comment on column T11_PREV2.UPDATE_USER_ID is '更新者';

comment on table T11_REBORN2 is '転生２';
comment on column T11_REBORN2.REBORN2_ID is '転生２ID';
comment on column T11_REBORN2.PREV2_INFO is '前世２情報';
comment on column T11_REBORN2.PREV2_ID is '前世２ID';
comment on column T11_REBORN2.INSERT_TS is '作成タイムスタンプ';
comment on column T11_REBORN2.INSERT_USER_ID is '作成者';
comment on column T11_REBORN2.UPDATE_TS is '更新タイムスタンプ';
comment on column T11_REBORN2.UPDATE_USER_ID is '更新者';

comment on table T11_TASHO1 is '他生１';
comment on column T11_TASHO1.TASHO1_ID is '他生１ID';
comment on column T11_TASHO1.REBORN2_ID is '転生２ID';
comment on column T11_TASHO1.INSERT_TS is '作成タイムスタンプ';
comment on column T11_TASHO1.INSERT_USER_ID is '作成者';
comment on column T11_TASHO1.UPDATE_TS is '更新タイムスタンプ';
comment on column T11_TASHO1.UPDATE_USER_ID is '更新者';

comment on table T12_KOHO3 is '候補３';
comment on column T12_KOHO3.KOHO3_ID is '候補３ID';
comment on column T12_KOHO3.KOHO3_INFO is '候補３情報';
comment on column T12_KOHO3.INSERT_TS is '作成タイムスタンプ';
comment on column T12_KOHO3.INSERT_USER_ID is '作成者';
comment on column T12_KOHO3.UPDATE_TS is '更新タイムスタンプ';
comment on column T12_KOHO3.UPDATE_USER_ID is '更新者';

comment on table T12_REBORN3 is '転生３';
comment on column T12_REBORN3.REBORN3_ID is '転生３ID';
comment on column T12_REBORN3.TASHO2_ID is '他生２ID';
comment on column T12_REBORN3.INSERT_TS is '作成タイムスタンプ';
comment on column T12_REBORN3.INSERT_USER_ID is '作成者';
comment on column T12_REBORN3.UPDATE_TS is '更新タイムスタンプ';
comment on column T12_REBORN3.UPDATE_USER_ID is '更新者';

comment on table T12_TASHO2 is '他生２';
comment on column T12_TASHO2.TASHO2_ID is '他生２ID';
comment on column T12_TASHO2.KOHO3_ID is '候補３ID';
comment on column T12_TASHO2.INSERT_TS is '作成タイムスタンプ';
comment on column T12_TASHO2.INSERT_USER_ID is '作成者';
comment on column T12_TASHO2.UPDATE_TS is '更新タイムスタンプ';
comment on column T12_TASHO2.UPDATE_USER_ID is '更新者';

comment on table T13_DEST is '変換先';
comment on column T13_DEST.DEST_ID is '変換先ID';
comment on column T13_DEST.DEST_INFO is '変換先情報';
comment on column T13_DEST.INSERT_TS is '作成タイムスタンプ';
comment on column T13_DEST.INSERT_USER_ID is '作成者';
comment on column T13_DEST.UPDATE_TS is '更新タイムスタンプ';
comment on column T13_DEST.UPDATE_USER_ID is '更新者';

comment on table T13_SRC is '変換元';
comment on column T13_SRC.SRC_ID is '変換元ID';
comment on column T13_SRC.SRC_INFO is '変換元情報';
comment on column T13_SRC.INSERT_TS is '作成タイムスタンプ';
comment on column T13_SRC.INSERT_USER_ID is '作成者';
comment on column T13_SRC.UPDATE_TS is '更新タイムスタンプ';
comment on column T13_SRC.UPDATE_USER_ID is '更新者';

comment on table V13_FURIWAKE is '振分ビュー';
comment on column V13_FURIWAKE.table_name is 'テーブル名';
comment on column V13_FURIWAKE."SRC_ID$DEST_ID" is '振分ID';
comment on column V13_FURIWAKE.info is '情報';

comment on table V13_HENKAN is '変換ビュー';
comment on column V13_HENKAN.table_name is 'テーブル名';
comment on column V13_HENKAN.src_id is '変換元ID';
comment on column V13_HENKAN.dest_info is '変換元情報';

