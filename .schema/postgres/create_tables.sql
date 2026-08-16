-- Project Name : emarf
-- Date/Time    : 2026/08/16 10:51:07
-- Author       : t_fuk
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

-- マスタ参照１
create table M04_REF1 (
  REF1_ID integer
  , REF1_MEI character varying(60) not null
  , DELETE_F character(1)
  , TEKIYO_BI date
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M04_REF1_PKC primary key (REF1_ID)
) ;

-- マスタ参照２
create table M04_REF2 (
  REF2_ID integer
  , REF2_MEI character varying(60) not null
  , DELETE_F character(1)
  , TEKIYO_BI date
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M04_REF2_PKC primary key (REF2_ID)
) ;

-- マスタ参照３
create table M04_REF3 (
  REF3_ID integer
  , REF3_MEI character varying(60) not null
  , DELETE_F character(1)
  , TEKIYO_BI date
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M04_REF3_PKC primary key (REF3_ID)
) ;

-- CDマスタ
create table M05_CD (
  CDREF_CD character(10)
  , CDREF_MEI character varying(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M05_CD_PKC primary key (CDREF_CD)
) ;

-- IDマスタ
create table M05_ID (
  IDREF_ID integer
  , IDREF_MEI character varying(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M05_ID_PKC primary key (IDREF_ID)
) ;

-- ID連番マスタ
create table M05_IDBN (
  IDREF_ID integer
  , IDBN_BN integer
  , IDBN_NO character(10) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M05_IDBN_PKC primary key (IDREF_ID,IDBN_BN)
) ;

-- NOマスタ
create table M05_NO (
  NOREF_NO character(10)
  , NOREF_MEI character varying(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M05_NO_PKC primary key (NOREF_NO)
) ;

-- 再帰
create table M05_SAIKI (
  SAIKI_ID integer
  , SAIKI_MEI character varying(60) not null
  , IDREF_ID integer
  , CDREF_CD character(10)
  , NOREF_NO character(10)
  , EX_IDREF_ID integer
  , EX_IDBN_BN integer
  , OYA_SAIKI_ID integer
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint M05_SAIKI_PKC primary key (SAIKI_ID)
) ;

-- 部署マスタ
create table MHR_BUSHO (
  BUSHO_ID integer not null
  , BUSHO_MEI character varying(60) not null
  , OYA_BUSHO_ID integer
  , TEKIYO_BI date
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MHR_BUSHO_PKC primary key (BUSHO_ID)
) ;

-- 職位マスタ
create table MHR_SHOKUI (
  SHOKUI_ID integer not null
  , SHOKUI_MEI character varying(60) not null
  , SHOKUI_ON integer not null
  , TEKIYO_BI date
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MHR_SHOKUI_PKC primary key (SHOKUI_ID)
) ;

-- 認可マスタ
create table MHR_SHOKUI_NINKA (
  BUSHO_ID integer not null
  , SHOKUI_ID integer not null
  , TABLE_RE character varying(20) not null
  , KENGEN_B integer not null
  , TEKIYO_BI date
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MHR_SHOKUI_NINKA_PKC primary key (BUSHO_ID,SHOKUI_ID,TABLE_RE)
) ;

-- ユーザマスタ
create table MHR_USER (
  USER_ID integer not null
  , USER_SEI character varying(60) not null
  , USER_MEI character varying(60) not null
  , E_MAIL character varying(300) not null
  , PASSWORD character varying(300) not null
  , TEKIYO_BI date
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MHR_USER_PKC primary key (USER_ID)
) ;

-- 所属マスタ
create table MHR_USER_POS (
  BUSHO_ID integer not null
  , SHOKUI_ID integer not null
  , USER_ID integer not null
  , TEKIYO_BI date not null
  , HAISHI_BI date
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MHR_USER_POS_PKC primary key (BUSHO_ID,SHOKUI_ID,USER_ID,TEKIYO_BI)
) ;

-- 稼働日マスタ
create table MSY_KADOBI (
  KADO_BI date
  , BUSHO_ID integer
  , KADOBI_F character(1)
  , MEMO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MSY_KADOBI_PKC primary key (KADO_BI,BUSHO_ID)
) ;

-- 区分マスタ
create table MSY_KBN (
  KBN_NM character varying(20) not null
  , KBN_MEI character varying(60) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MSY_KBN_PKC primary key (KBN_NM)
) ;

-- 区分値マスタ
create table MSY_KBN_VAL (
  KBN_NM character varying(20) not null
  , KBN_VAL character varying(2) not null
  , KBN_VAL_MEI character varying(60) not null
  , HYOJI_ON integer
  , CRITERIA character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MSY_KBN_VAL_PKC primary key (KBN_NM,KBN_VAL)
) ;

-- 税マスタ
create table MSY_TAX (
  TAX_KB character varying(2)
  , TEKIYO_BI date
  , HAISHI_BI date
  , TAX_RT numeric(5,2) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MSY_TAX_PKC primary key (TAX_KB,TEKIYO_BI)
) ;

-- 通貨マスタ
create table MSY_TSUKA (
  TSUKA_KB character varying(2)
  , TEKIYO_BI date
  , TTS numeric(5,2) not null
  , TTB numeric(5,2) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint MSY_TSUKA_PKC primary key (TSUKA_KB,TEKIYO_BI)
) ;

-- エンティティ
create table T00_ENTITY (
  ENTITY_ID integer not null
  , ENTITY_NM character varying(20) not null
  , ENTITY_MEI character varying(60) not null
  , BIT_B integer not null
  , CHECK_F character(1) not null
  , RADIO_KB character varying(2) not null
  , PULLDOWN_KB character varying(2) not null
  , PULLDOWN_SB character varying(2) not null
  , MEMO_TX character varying(300) not null
  , MEMO character varying(300) not null
  , TENPU_FILE character varying(300) not null
  , NEN_Y character(4) not null
  , TSUKI_M character(2) not null
  , HI_D character(2) not null
  , NENGETSU_YM character(6) not null
  , NENGAPPI_YMD character(8) not null
  , TIMESTAMP_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , NICHIJI_DT timestamp not null
  , HIDUKE_BI date not null
  , JIKOKU_HM time not null
  , JIKAN_TM character varying(9) not null
  , TSUKA_KB character varying(2) not null
  , JUCHU_QT numeric(11,3) not null
  , JUCHU_PR numeric(11,2) not null
  , JUCHU_AM numeric(11,2) not null
  , HACCHU_QT numeric(11,3) not null
  , HACCHU_PR numeric(11,2) not null
  , HACCHU_AM numeric(11,2) not null
  , DELETE_F character(1) default 0
  , STATUS_KB character varying(2)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T00_ENTITY_PKC primary key (ENTITY_ID)
) ;

-- キーなし
create table T00_NOKEY (
  A_MEI character varying(60)
  , B_MEI character varying(60)
  , C_MEI character varying(60)
  , D_MEI character varying(60)
  , E_MEI character varying(60)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
) ;

-- ユニークキー
create table T00_UNIQUE (
  A_MEI character varying(60)
  , B_MEI character varying(60)
  , C_MEI character varying(60)
  , D_MEI character varying(60)
  , E_MEI character varying(60)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
) ;

create unique index T00_UNIQUE_IX1
  on T00_UNIQUE(A_MEI,B_MEI,C_MEI);

create unique index T00_UNIQUE_IX2
  on T00_UNIQUE(D_MEI,E_MEI);

-- 長兄
create table T01_ELDEST (
  BRO_ID integer
  , ELDEST_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T01_ELDEST_PKC primary key (BRO_ID)
) ;

-- 里子
create table T01_FOSTER (
  BRO_ID integer
  , FOSTER_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T01_FOSTER_PKC primary key (BRO_ID)
) ;

-- 弟
create table T01_YOUNGER (
  BRO_ID integer
  , YOUNGER_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T01_YOUNGER_PKC primary key (BRO_ID)
) ;

-- 末弟
create table T01_YOUNGEST (
  BRO_ID integer
  , YOUNGEST_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T01_YOUNGEST_PKC primary key (BRO_ID)
) ;

-- 子なし
create table T02_DINKS (
  OYA_ID integer not null
  , KO_BN integer
  , DINKS_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T02_DINKS_PKC primary key (OYA_ID,KO_BN)
) ;

-- 子
create table T02_KO (
  OYA_ID integer
  , KO_BN integer
  , KO_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T02_KO_PKC primary key (OYA_ID,KO_BN)
) ;

-- 孫
create table T02_MAGO (
  OYA_ID integer
  , KO_BN integer
  , MAGO_BN integer
  , MAGO_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T02_MAGO_PKC primary key (OYA_ID,KO_BN,MAGO_BN)
) ;

-- 孤児
create table T02_ORPHAN (
  OYA_ID integer
  , KO_BN integer
  , ORPHAN_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T02_ORPHAN_PKC primary key (OYA_ID,KO_BN)
) ;

-- 親
create table T02_OYA (
  OYA_ID integer
  , OYA_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T02_OYA_PKC primary key (OYA_ID)
) ;

-- 決裁フロー
create table T03_STATUS_KB (
  FLOW_ID integer
  , TABLE_NM character varying(20)
  , PRIMARY_KEYS character varying(300)
  , STATUS_KB character varying(2)
  , KESSAI_TS TIMESTAMP
  , KESSAI_ID integer
  , RIYU_TX character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T03_STATUS_KB_PKC primary key (FLOW_ID)
) ;

-- 変遷
create table T03_TRANS (
  TRANS_ID integer
  , TRANS_INFO character varying(300)
  , STATUS_KB character varying(2)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T03_TRANS_PKC primary key (TRANS_ID)
) ;

-- 変遷履歴
create table T03_TRANS_HIS (
  TRANS_ID integer
  , TRANS_BN integer
  , TRANS_INFO character varying(300)
  , STATUS_KB character varying(2)
  , RIYU_TX character varying(300) not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T03_TRANS_HIS_PKC primary key (TRANS_ID,TRANS_BN)
) ;

-- 複合１
create table T04_COMP1 (
  REF1_ID integer
  , REF2_ID integer
  , COMP1_MEI character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T04_COMP1_PKC primary key (REF1_ID,REF2_ID)
) ;

-- 複合２
create table T04_COMP2 (
  REF1_ID integer
  , REF2_ID integer
  , REF3_ID integer
  , TEKIYO_BI date
  , COMP2_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T04_COMP2_PKC primary key (REF1_ID,REF2_ID,REF3_ID,TEKIYO_BI)
) ;

-- 前世
create table T06_PREV (
  PREV_ID integer
  , PREV_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T06_PREV_PKC primary key (PREV_ID)
) ;

-- 前世明細
create table T06_PREV_DET (
  PREV_ID integer
  , PREV_BN integer
  , DET_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T06_PREV_DET_PKC primary key (PREV_ID,PREV_BN)
) ;

-- 転生
create table T06_REBORN (
  REBORN_ID integer
  , PREV_INFO character varying(300)
  , PREV_ID integer not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T06_REBORN_PKC primary key (REBORN_ID)
) ;

-- 転生明細
create table T06_REBORN_DET (
  REBORN_ID integer
  , REBORN_BN integer
  , DET_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T06_REBORN_DET_PKC primary key (REBORN_ID,REBORN_BN)
) ;

-- 派生１
create table T07_DERIVE1 (
  DERIVE1_ID integer
  , ORG_INFO character varying(300)
  , ORG_ID integer not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T07_DERIVE1_PKC primary key (DERIVE1_ID)
) ;

-- 派生１明細
create table T07_DERIVE1_DET (
  DERIVE1_ID integer
  , DERIVE1_BN integer
  , DET_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T07_DERIVE1_DET_PKC primary key (DERIVE1_ID,DERIVE1_BN)
) ;

-- 派生２
create table T07_DERIVE2 (
  DERIVE2_ID integer
  , ORG_INFO character varying(300)
  , ORG_ID integer not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T07_DERIVE2_PKC primary key (DERIVE2_ID)
) ;

-- 派生２明細
create table T07_DERIVE2_DET (
  DERIVE2_ID integer
  , DERIVE2_BN integer
  , DET_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T07_DERIVE2_DET_PKC primary key (DERIVE2_ID,DERIVE2_BN)
) ;

-- 起源
create table T07_ORG (
  ORG_ID integer
  , ORG_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T07_ORG_PKC primary key (ORG_ID)
) ;

-- 起源明細
create table T07_ORG_DET (
  ORG_ID integer
  , ORG_BN integer
  , DET_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T07_ORG_DET_PKC primary key (ORG_ID,ORG_BN)
) ;

-- 寄生１
create table T08_KISEI1 (
  KISEI1_ID integer
  , KISEI1_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T08_KISEI1_PKC primary key (KISEI1_ID)
) ;

-- 寄生２
create table T08_KISEI2 (
  KISEI2_ID integer
  , KISEI2_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T08_KISEI2_PKC primary key (KISEI2_ID)
) ;

-- 共生
create table T08_KYOSEI (
  KYOSEI_ID integer
  , KISEI1_ID integer not null
  , KISEI1_INFO character varying(300)
  , KISEI2_ID integer not null
  , KISEI2_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T08_KYOSEI_PKC primary key (KYOSEI_ID)
) ;

-- 選択
create table T09_CHOICE (
  CHOICE_ID integer
  , KOHO1_ID integer
  , KOHO1_INFO character varying(300)
  , KOHO2_ID integer
  , KOHO2_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T09_CHOICE_PKC primary key (CHOICE_ID)
) ;

-- 候補１
create table T09_KOHO1 (
  KOHO1_ID integer
  , KOHO1_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T09_KOHO1_PKC primary key (KOHO1_ID)
) ;

-- 候補２
create table T09_KOHO2 (
  KOHO2_ID integer
  , KOHO2_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T09_KOHO2_PKC primary key (KOHO2_ID)
) ;

-- 集団１
create table T10_GRP1 (
  GRP1_ID integer
  , SUM_ID integer
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T10_GRP1_PKC primary key (GRP1_ID)
) ;

-- 集団２
create table T10_GRP2 (
  GRP2_ID integer
  , SUM_ID integer
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T10_GRP2_PKC primary key (GRP2_ID)
) ;

-- 集約
create table T10_SUM (
  SUM_ID integer
  , SUM_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T10_SUM_PKC primary key (SUM_ID)
) ;

-- 前世２
create table T11_PREV2 (
  PREV2_ID integer
  , PREV2_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T11_PREV2_PKC primary key (PREV2_ID)
) ;

-- 転生２
create table T11_REBORN2 (
  REBORN2_ID integer
  , PREV2_INFO character varying(300)
  , PREV2_ID integer not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T11_REBORN2_PKC primary key (REBORN2_ID)
) ;

-- 他生１
create table T11_TASHO1 (
  TASHO1_ID integer
  , REBORN2_ID integer
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T11_TASHO1_PKC primary key (TASHO1_ID)
) ;

-- 候補３
create table T12_KOHO3 (
  KOHO3_ID integer
  , KOHO3_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T12_KOHO3_PKC primary key (KOHO3_ID)
) ;

-- 転生３
create table T12_REBORN3 (
  REBORN3_ID integer
  , TASHO2_ID integer not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T12_REBORN3_PKC primary key (REBORN3_ID)
) ;

-- 他生２
create table T12_TASHO2 (
  TASHO2_ID integer
  , KOHO3_ID integer
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T12_TASHO2_PKC primary key (TASHO2_ID)
) ;

-- 変換先
create table T13_DEST (
  DEST_ID integer
  , DEST_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T13_DEST_PKC primary key (DEST_ID)
) ;

-- 変換元
create table T13_SRC (
  SRC_ID integer
  , SRC_INFO character varying(300)
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T13_SRC_PKC primary key (SRC_ID)
) ;

-- 実績
create table T14_JISSEKI (
  KOUTEI_ID integer
  , JISSEKI_BN integer
  , JISSHI_BI date not null
  , KANRYO_BI date not null
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T14_JISSEKI_PKC primary key (KOUTEI_ID,JISSEKI_BN)
) ;

-- 工程
create table T14_KOUTEI (
  KOUTEI_ID integer
  , KOUTEI_MEI character varying(60) not null
  , KAISHI_BI date not null
  , SHURYO_BI date not null
  , SAGYOKU_CD character(10) not null
  , OYA_KOUTEI_ID integer
  , INSERT_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , INSERT_USER_ID character(10) not null
  , UPDATE_TS TIMESTAMP default CURRENT_TIMESTAMP not null
  , UPDATE_USER_ID character(10) not null
  , constraint T14_KOUTEI_PKC primary key (KOUTEI_ID)
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

-- 稼働日負荷
create view V14_FUKA_KADOBI as 
SELECT
      TO_CHAR (b.kado_bi, 'YYYYMMDD') AS labels
    , 'bar'                           AS type
    , 'stack'                         AS stack
    , b.sagyoku_cd                    AS label
    , COALESCE (k.koutei_count, 0)    AS DATA 
FROM
    ( 
        SELECT
              * 
        FROM
            (SELECT DISTINCT b.kado_bi FROM msy_kadobi b) b 
            CROSS JOIN (SELECT DISTINCT k.sagyoku_cd FROM t14_koutei k) k
    ) b 
    LEFT OUTER JOIN ( 
        SELECT
              b.kado_bi
            , k.sagyoku_cd
            , COUNT (k.koutei_id) AS koutei_count 
        FROM
            ( 
                SELECT DISTINCT
                      b.kado_bi 
                FROM
                    msy_kadobi b 
                WHERE
                    b.kadobi_f = '1'
            ) b 
            INNER JOIN t14_koutei k 
                ON k.kaishi_bi <= b.kado_bi 
                AND b.kado_bi <= k.shuryo_bi 
        GROUP BY
            b.kado_bi
            , k.sagyoku_cd
    ) k 
        ON k.kado_bi = b.kado_bi 
        AND k.sagyoku_cd = b.sagyoku_cd 
ORDER BY
    b.kado_bi
    , b.sagyoku_cd

;

-- 作業区負荷
create view V14_FUKA_SAGYOKU as 
SELECT
      TO_CHAR (b.kado_bi, 'YYYYMMDD') AS labels
    , 'line'                          AS type
    , b.sagyoku_cd                    AS stack
    , b.sagyoku_cd                    AS label
    , COALESCE (k.koutei_count, 0)    AS DATA 
FROM
    ( 
        SELECT
              * 
        FROM
            (SELECT DISTINCT b.kado_bi FROM msy_kadobi b) b 
            CROSS JOIN (SELECT DISTINCT k.sagyoku_cd FROM t14_koutei k) k
    ) b 
    LEFT OUTER JOIN ( 
        SELECT
              b.kado_bi
            , k.sagyoku_cd
            , COUNT (k.koutei_id) AS koutei_count 
        FROM
            ( 
                SELECT DISTINCT
                      b.kado_bi 
                FROM
                    msy_kadobi b 
                WHERE
                    b.kadobi_f = '1'
            ) b 
            INNER JOIN t14_koutei k 
                ON k.kaishi_bi <= b.kado_bi 
                AND b.kado_bi <= k.shuryo_bi 
        GROUP BY
            b.kado_bi
            , k.sagyoku_cd
    ) k 
        ON k.kado_bi = b.kado_bi 
        AND k.sagyoku_cd = b.sagyoku_cd 
ORDER BY
    b.kado_bi
    , b.sagyoku_cd

;

-- 予実
create view V14_YOJITSU as 
WITH RECURSIVE                                  -- 1. 前工程（dependencies）を集約
deps AS ( 
    SELECT
          oya_koutei_id
        , string_agg(koutei_id ::text, ',' ORDER BY koutei_id) AS dependencies 
    FROM
        t14_koutei 
    WHERE
        oya_koutei_id IS NOT NULL 
    GROUP BY
        oya_koutei_id
) 
,                                               -- 2. 階層構造（CONNECT BY / SYS_CONNECT_BY_PATH / CONNECT_BY_ROOT の代替）を再帰CTEで構築
tree AS ( 
                                                -- アンカーメンバー (START WITH a.oya_koutei_id IS NULL)
    SELECT
          a.koutei_id
        , a.koutei_mei
        , a.kaishi_bi
        , a.shuryo_bi
        , a.sagyoku_cd
        , a.oya_koutei_id
        , a.koutei_id ::text                           AS koutei_path-- SYS_CONNECT_BY_PATH(a.koutei_id, ',') の初期値
        , a.koutei_id                                  AS root-- CONNECT_BY_ROOT a.koutei_id
    FROM
        t14_koutei a 
    WHERE
        a.oya_koutei_id IS NULL 
    UNION ALL                                   -- 再帰メンバー (CONNECT BY PRIOR a.koutei_id = a.oya_koutei_id)
    SELECT
          child.koutei_id
        , child.koutei_mei
        , child.kaishi_bi
        , child.shuryo_bi
        , child.sagyoku_cd
        , child.oya_koutei_id
        , parent.koutei_path || ',' || child.koutei_id AS koutei_path
        , parent.root 
    FROM
        t14_koutei child 
        INNER JOIN tree parent 
            ON child.oya_koutei_id = parent.koutei_id
)                                               -- 3. 実績テーブル(jisseki)・集約データ(deps)を結合して最終取得
SELECT
      t.koutei_id
    , t.koutei_mei AS koutei_tx
    , t.kaishi_bi
    , t.shuryo_bi
    , t.sagyoku_cd
    , t.oya_koutei_id
    , j.jisshi_bi
    , j.kanryo_bi
    , b.dependencies
    , t.koutei_path
    , t.root 
FROM
    tree t 
    LEFT OUTER JOIN t14_jisseki j 
        ON j.koutei_id = t.koutei_id 
    LEFT OUTER JOIN deps b 
        ON b.oya_koutei_id = t.koutei_id 
ORDER BY
    t.koutei_path DESC;

;

comment on table M04_REF1 is 'マスタ参照１';
comment on column M04_REF1.REF1_ID is '参照１ID';
comment on column M04_REF1.REF1_MEI is '参照１名';
comment on column M04_REF1.DELETE_F is '削除フラグ';
comment on column M04_REF1.TEKIYO_BI is '適用日';
comment on column M04_REF1.HAISHI_BI is '廃止日';
comment on column M04_REF1.INSERT_TS is '作成タイムスタンプ';
comment on column M04_REF1.INSERT_USER_ID is '作成者';
comment on column M04_REF1.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_REF1.UPDATE_USER_ID is '更新者';

comment on table M04_REF2 is 'マスタ参照２';
comment on column M04_REF2.REF2_ID is '参照２ID';
comment on column M04_REF2.REF2_MEI is '参照２名';
comment on column M04_REF2.DELETE_F is '削除フラグ';
comment on column M04_REF2.TEKIYO_BI is '適用日';
comment on column M04_REF2.HAISHI_BI is '廃止日';
comment on column M04_REF2.INSERT_TS is '作成タイムスタンプ';
comment on column M04_REF2.INSERT_USER_ID is '作成者';
comment on column M04_REF2.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_REF2.UPDATE_USER_ID is '更新者';

comment on table M04_REF3 is 'マスタ参照３';
comment on column M04_REF3.REF3_ID is '参照３ID';
comment on column M04_REF3.REF3_MEI is '参照３名';
comment on column M04_REF3.DELETE_F is '削除フラグ';
comment on column M04_REF3.TEKIYO_BI is '適用日';
comment on column M04_REF3.HAISHI_BI is '廃止日';
comment on column M04_REF3.INSERT_TS is '作成タイムスタンプ';
comment on column M04_REF3.INSERT_USER_ID is '作成者';
comment on column M04_REF3.UPDATE_TS is '更新タイムスタンプ';
comment on column M04_REF3.UPDATE_USER_ID is '更新者';

comment on table M05_CD is 'CDマスタ';
comment on column M05_CD.CDREF_CD is '参照CD';
comment on column M05_CD.CDREF_MEI is 'CD参照名';
comment on column M05_CD.INSERT_TS is '作成タイムスタンプ';
comment on column M05_CD.INSERT_USER_ID is '作成者';
comment on column M05_CD.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_CD.UPDATE_USER_ID is '更新者';

comment on table M05_ID is 'IDマスタ';
comment on column M05_ID.IDREF_ID is '参照ID';
comment on column M05_ID.IDREF_MEI is 'ID参照名';
comment on column M05_ID.INSERT_TS is '作成タイムスタンプ';
comment on column M05_ID.INSERT_USER_ID is '作成者';
comment on column M05_ID.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_ID.UPDATE_USER_ID is '更新者';

comment on table M05_IDBN is 'ID連番マスタ';
comment on column M05_IDBN.IDREF_ID is '参照ID';
comment on column M05_IDBN.IDBN_BN is '参照連番';
comment on column M05_IDBN.IDBN_NO is 'ID連番NO';
comment on column M05_IDBN.INSERT_TS is '作成タイムスタンプ';
comment on column M05_IDBN.INSERT_USER_ID is '作成者';
comment on column M05_IDBN.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_IDBN.UPDATE_USER_ID is '更新者';

comment on table M05_NO is 'NOマスタ';
comment on column M05_NO.NOREF_NO is '参照NO';
comment on column M05_NO.NOREF_MEI is 'NO参照名';
comment on column M05_NO.INSERT_TS is '作成タイムスタンプ';
comment on column M05_NO.INSERT_USER_ID is '作成者';
comment on column M05_NO.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_NO.UPDATE_USER_ID is '更新者';

comment on table M05_SAIKI is '再帰';
comment on column M05_SAIKI.SAIKI_ID is '再帰ID';
comment on column M05_SAIKI.SAIKI_MEI is '再帰名';
comment on column M05_SAIKI.IDREF_ID is '参照ID';
comment on column M05_SAIKI.CDREF_CD is '参照CD';
comment on column M05_SAIKI.NOREF_NO is '参照NO';
comment on column M05_SAIKI.EX_IDREF_ID is 'ID連番ID';
comment on column M05_SAIKI.EX_IDBN_BN is 'ID連番';
comment on column M05_SAIKI.OYA_SAIKI_ID is '親再帰ID';
comment on column M05_SAIKI.INSERT_TS is '作成タイムスタンプ';
comment on column M05_SAIKI.INSERT_USER_ID is '作成者';
comment on column M05_SAIKI.UPDATE_TS is '更新タイムスタンプ';
comment on column M05_SAIKI.UPDATE_USER_ID is '更新者';

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
comment on column MHR_SHOKUI_NINKA.TABLE_RE is 'テーブル正規表現:テーブル名の正規表現';
comment on column MHR_SHOKUI_NINKA.KENGEN_B is '権限ビット';
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
comment on column T00_ENTITY.BIT_B is 'ビットフラグ';
comment on column T00_ENTITY.CHECK_F is 'チェックフラグ';
comment on column T00_ENTITY.RADIO_KB is 'ラジオ区分';
comment on column T00_ENTITY.PULLDOWN_KB is 'プルダウン区分';
comment on column T00_ENTITY.PULLDOWN_SB is 'プルダウン種別';
comment on column T00_ENTITY.MEMO_TX is 'メモ';
comment on column T00_ENTITY.MEMO is '１行メモ';
comment on column T00_ENTITY.TENPU_FILE is '添付ファイル';
comment on column T00_ENTITY.NEN_Y is '年';
comment on column T00_ENTITY.TSUKI_M is '月';
comment on column T00_ENTITY.HI_D is '日';
comment on column T00_ENTITY.NENGETSU_YM is '年月';
comment on column T00_ENTITY.NENGAPPI_YMD is '年月日';
comment on column T00_ENTITY.TIMESTAMP_TS is 'タイムスタンプ';
comment on column T00_ENTITY.NICHIJI_DT is '日時';
comment on column T00_ENTITY.HIDUKE_BI is '日付';
comment on column T00_ENTITY.JIKOKU_HM is '時刻';
comment on column T00_ENTITY.JIKAN_TM is '時間';
comment on column T00_ENTITY.TSUKA_KB is '通貨区分';
comment on column T00_ENTITY.JUCHU_QT is '受注数量';
comment on column T00_ENTITY.JUCHU_PR is '受注単価';
comment on column T00_ENTITY.JUCHU_AM is '受注金額';
comment on column T00_ENTITY.HACCHU_QT is '発注数量';
comment on column T00_ENTITY.HACCHU_PR is '発注単価';
comment on column T00_ENTITY.HACCHU_AM is '発注金額';
comment on column T00_ENTITY.DELETE_F is '削除フラグ:必須チェックにかかるのでNOTNULLにしない';
comment on column T00_ENTITY.STATUS_KB is 'ステータス区分:必須チェックにかかるのでNOTNULLにしない';
comment on column T00_ENTITY.INSERT_TS is '作成タイムスタンプ';
comment on column T00_ENTITY.INSERT_USER_ID is '作成者';
comment on column T00_ENTITY.UPDATE_TS is '更新タイムスタンプ';
comment on column T00_ENTITY.UPDATE_USER_ID is '更新者';

comment on table T00_NOKEY is 'キーなし';
comment on column T00_NOKEY.A_MEI is '列Ａ';
comment on column T00_NOKEY.B_MEI is '列Ｂ';
comment on column T00_NOKEY.C_MEI is '列Ｃ';
comment on column T00_NOKEY.D_MEI is '列Ｄ';
comment on column T00_NOKEY.E_MEI is '列Ｅ';
comment on column T00_NOKEY.INSERT_TS is '作成タイムスタンプ';
comment on column T00_NOKEY.INSERT_USER_ID is '作成者';
comment on column T00_NOKEY.UPDATE_TS is '更新タイムスタンプ';
comment on column T00_NOKEY.UPDATE_USER_ID is '更新者';

comment on table T00_UNIQUE is 'ユニークキー';
comment on column T00_UNIQUE.A_MEI is '列Ａ';
comment on column T00_UNIQUE.B_MEI is '列Ｂ';
comment on column T00_UNIQUE.C_MEI is '列Ｃ';
comment on column T00_UNIQUE.D_MEI is '列Ｄ';
comment on column T00_UNIQUE.E_MEI is '列Ｅ';
comment on column T00_UNIQUE.INSERT_TS is '作成タイムスタンプ';
comment on column T00_UNIQUE.INSERT_USER_ID is '作成者';
comment on column T00_UNIQUE.UPDATE_TS is '更新タイムスタンプ';
comment on column T00_UNIQUE.UPDATE_USER_ID is '更新者';

comment on table T01_ELDEST is '長兄';
comment on column T01_ELDEST.BRO_ID is '兄弟ID';
comment on column T01_ELDEST.ELDEST_INFO is '長兄情報';
comment on column T01_ELDEST.INSERT_TS is '作成タイムスタンプ';
comment on column T01_ELDEST.INSERT_USER_ID is '作成者';
comment on column T01_ELDEST.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_ELDEST.UPDATE_USER_ID is '更新者';

comment on table T01_FOSTER is '里子';
comment on column T01_FOSTER.BRO_ID is '兄弟ID';
comment on column T01_FOSTER.FOSTER_INFO is '里子情報';
comment on column T01_FOSTER.INSERT_TS is '作成タイムスタンプ';
comment on column T01_FOSTER.INSERT_USER_ID is '作成者';
comment on column T01_FOSTER.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_FOSTER.UPDATE_USER_ID is '更新者';

comment on table T01_YOUNGER is '弟';
comment on column T01_YOUNGER.BRO_ID is '兄弟ID';
comment on column T01_YOUNGER.YOUNGER_INFO is '弟情報';
comment on column T01_YOUNGER.INSERT_TS is '作成タイムスタンプ';
comment on column T01_YOUNGER.INSERT_USER_ID is '作成者';
comment on column T01_YOUNGER.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_YOUNGER.UPDATE_USER_ID is '更新者';

comment on table T01_YOUNGEST is '末弟';
comment on column T01_YOUNGEST.BRO_ID is '兄弟ID';
comment on column T01_YOUNGEST.YOUNGEST_INFO is '末弟情報';
comment on column T01_YOUNGEST.INSERT_TS is '作成タイムスタンプ';
comment on column T01_YOUNGEST.INSERT_USER_ID is '作成者';
comment on column T01_YOUNGEST.UPDATE_TS is '更新タイムスタンプ';
comment on column T01_YOUNGEST.UPDATE_USER_ID is '更新者';

comment on table T02_DINKS is '子なし';
comment on column T02_DINKS.OYA_ID is '親ID';
comment on column T02_DINKS.KO_BN is '子枝番';
comment on column T02_DINKS.DINKS_INFO is '子なし情報';
comment on column T02_DINKS.INSERT_TS is '作成タイムスタンプ';
comment on column T02_DINKS.INSERT_USER_ID is '作成者';
comment on column T02_DINKS.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_DINKS.UPDATE_USER_ID is '更新者';

comment on table T02_KO is '子';
comment on column T02_KO.OYA_ID is '親ID';
comment on column T02_KO.KO_BN is '子枝番';
comment on column T02_KO.KO_INFO is '子情報';
comment on column T02_KO.INSERT_TS is '作成タイムスタンプ';
comment on column T02_KO.INSERT_USER_ID is '作成者';
comment on column T02_KO.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_KO.UPDATE_USER_ID is '更新者';

comment on table T02_MAGO is '孫';
comment on column T02_MAGO.OYA_ID is '親ID';
comment on column T02_MAGO.KO_BN is '子枝番';
comment on column T02_MAGO.MAGO_BN is '孫枝番';
comment on column T02_MAGO.MAGO_INFO is '孫情報';
comment on column T02_MAGO.INSERT_TS is '作成タイムスタンプ';
comment on column T02_MAGO.INSERT_USER_ID is '作成者';
comment on column T02_MAGO.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_MAGO.UPDATE_USER_ID is '更新者';

comment on table T02_ORPHAN is '孤児';
comment on column T02_ORPHAN.OYA_ID is '親ID';
comment on column T02_ORPHAN.KO_BN is '子枝番';
comment on column T02_ORPHAN.ORPHAN_INFO is '孤児情報';
comment on column T02_ORPHAN.INSERT_TS is '作成タイムスタンプ';
comment on column T02_ORPHAN.INSERT_USER_ID is '作成者';
comment on column T02_ORPHAN.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_ORPHAN.UPDATE_USER_ID is '更新者';

comment on table T02_OYA is '親';
comment on column T02_OYA.OYA_ID is '親ID';
comment on column T02_OYA.OYA_INFO is '親情報';
comment on column T02_OYA.INSERT_TS is '作成タイムスタンプ';
comment on column T02_OYA.INSERT_USER_ID is '作成者';
comment on column T02_OYA.UPDATE_TS is '更新タイムスタンプ';
comment on column T02_OYA.UPDATE_USER_ID is '更新者';

comment on table T03_STATUS_KB is '決裁フロー';
comment on column T03_STATUS_KB.FLOW_ID is 'フローID';
comment on column T03_STATUS_KB.TABLE_NM is 'テーブル名称';
comment on column T03_STATUS_KB.PRIMARY_KEYS is '主キー';
comment on column T03_STATUS_KB.STATUS_KB is 'ステータス区分';
comment on column T03_STATUS_KB.KESSAI_TS is '決裁タイムスタンプ';
comment on column T03_STATUS_KB.KESSAI_ID is '決裁者ID';
comment on column T03_STATUS_KB.RIYU_TX is '決裁理由';
comment on column T03_STATUS_KB.INSERT_TS is '作成タイムスタンプ';
comment on column T03_STATUS_KB.INSERT_USER_ID is '作成者';
comment on column T03_STATUS_KB.UPDATE_TS is '更新タイムスタンプ';
comment on column T03_STATUS_KB.UPDATE_USER_ID is '更新者';

comment on table T03_TRANS is '変遷';
comment on column T03_TRANS.TRANS_ID is '変遷ID';
comment on column T03_TRANS.TRANS_INFO is '変遷情報';
comment on column T03_TRANS.STATUS_KB is 'ステータス区分';
comment on column T03_TRANS.INSERT_TS is '作成タイムスタンプ';
comment on column T03_TRANS.INSERT_USER_ID is '作成者';
comment on column T03_TRANS.UPDATE_TS is '更新タイムスタンプ';
comment on column T03_TRANS.UPDATE_USER_ID is '更新者';

comment on table T03_TRANS_HIS is '変遷履歴';
comment on column T03_TRANS_HIS.TRANS_ID is '変遷ID';
comment on column T03_TRANS_HIS.TRANS_BN is '変遷枝番';
comment on column T03_TRANS_HIS.TRANS_INFO is '変遷情報';
comment on column T03_TRANS_HIS.STATUS_KB is 'ステータス区分';
comment on column T03_TRANS_HIS.RIYU_TX is '変更理由';
comment on column T03_TRANS_HIS.INSERT_TS is '作成タイムスタンプ';
comment on column T03_TRANS_HIS.INSERT_USER_ID is '作成者';
comment on column T03_TRANS_HIS.UPDATE_TS is '更新タイムスタンプ';
comment on column T03_TRANS_HIS.UPDATE_USER_ID is '更新者';

comment on table T04_COMP1 is '複合１';
comment on column T04_COMP1.REF1_ID is '参照１ID';
comment on column T04_COMP1.REF2_ID is '参照２ID';
comment on column T04_COMP1.COMP1_MEI is '複合１名';
comment on column T04_COMP1.INSERT_TS is '作成タイムスタンプ';
comment on column T04_COMP1.INSERT_USER_ID is '作成者';
comment on column T04_COMP1.UPDATE_TS is '更新タイムスタンプ';
comment on column T04_COMP1.UPDATE_USER_ID is '更新者';

comment on table T04_COMP2 is '複合２';
comment on column T04_COMP2.REF1_ID is '参照１ID';
comment on column T04_COMP2.REF2_ID is '参照２ID';
comment on column T04_COMP2.REF3_ID is '参照３ID';
comment on column T04_COMP2.TEKIYO_BI is '適用日';
comment on column T04_COMP2.COMP2_INFO is '複合２情報';
comment on column T04_COMP2.INSERT_TS is '作成タイムスタンプ';
comment on column T04_COMP2.INSERT_USER_ID is '作成者';
comment on column T04_COMP2.UPDATE_TS is '更新タイムスタンプ';
comment on column T04_COMP2.UPDATE_USER_ID is '更新者';

comment on table T06_PREV is '前世';
comment on column T06_PREV.PREV_ID is '前世ID';
comment on column T06_PREV.PREV_INFO is '前世情報';
comment on column T06_PREV.INSERT_TS is '作成タイムスタンプ';
comment on column T06_PREV.INSERT_USER_ID is '作成者';
comment on column T06_PREV.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_PREV.UPDATE_USER_ID is '更新者';

comment on table T06_PREV_DET is '前世明細';
comment on column T06_PREV_DET.PREV_ID is '前世ID';
comment on column T06_PREV_DET.PREV_BN is '前世枝番';
comment on column T06_PREV_DET.DET_INFO is '明細情報';
comment on column T06_PREV_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T06_PREV_DET.INSERT_USER_ID is '作成者';
comment on column T06_PREV_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_PREV_DET.UPDATE_USER_ID is '更新者';

comment on table T06_REBORN is '転生';
comment on column T06_REBORN.REBORN_ID is '転生ID';
comment on column T06_REBORN.PREV_INFO is '前世情報';
comment on column T06_REBORN.PREV_ID is '前世ID';
comment on column T06_REBORN.INSERT_TS is '作成タイムスタンプ';
comment on column T06_REBORN.INSERT_USER_ID is '作成者';
comment on column T06_REBORN.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_REBORN.UPDATE_USER_ID is '更新者';

comment on table T06_REBORN_DET is '転生明細';
comment on column T06_REBORN_DET.REBORN_ID is '転生ID';
comment on column T06_REBORN_DET.REBORN_BN is '転生枝番';
comment on column T06_REBORN_DET.DET_INFO is '明細情報';
comment on column T06_REBORN_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T06_REBORN_DET.INSERT_USER_ID is '作成者';
comment on column T06_REBORN_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T06_REBORN_DET.UPDATE_USER_ID is '更新者';

comment on table T07_DERIVE1 is '派生１';
comment on column T07_DERIVE1.DERIVE1_ID is '派生１ID';
comment on column T07_DERIVE1.ORG_INFO is '起源情報';
comment on column T07_DERIVE1.ORG_ID is '起源ID';
comment on column T07_DERIVE1.INSERT_TS is '作成タイムスタンプ';
comment on column T07_DERIVE1.INSERT_USER_ID is '作成者';
comment on column T07_DERIVE1.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_DERIVE1.UPDATE_USER_ID is '更新者';

comment on table T07_DERIVE1_DET is '派生１明細';
comment on column T07_DERIVE1_DET.DERIVE1_ID is '派生１ID';
comment on column T07_DERIVE1_DET.DERIVE1_BN is '派生１枝番';
comment on column T07_DERIVE1_DET.DET_INFO is '明細情報';
comment on column T07_DERIVE1_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T07_DERIVE1_DET.INSERT_USER_ID is '作成者';
comment on column T07_DERIVE1_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_DERIVE1_DET.UPDATE_USER_ID is '更新者';

comment on table T07_DERIVE2 is '派生２';
comment on column T07_DERIVE2.DERIVE2_ID is '派生２ID';
comment on column T07_DERIVE2.ORG_INFO is '起源情報';
comment on column T07_DERIVE2.ORG_ID is '起源ID';
comment on column T07_DERIVE2.INSERT_TS is '作成タイムスタンプ';
comment on column T07_DERIVE2.INSERT_USER_ID is '作成者';
comment on column T07_DERIVE2.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_DERIVE2.UPDATE_USER_ID is '更新者';

comment on table T07_DERIVE2_DET is '派生２明細';
comment on column T07_DERIVE2_DET.DERIVE2_ID is '派生２ID';
comment on column T07_DERIVE2_DET.DERIVE2_BN is '派生２枝番';
comment on column T07_DERIVE2_DET.DET_INFO is '明細情報';
comment on column T07_DERIVE2_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T07_DERIVE2_DET.INSERT_USER_ID is '作成者';
comment on column T07_DERIVE2_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_DERIVE2_DET.UPDATE_USER_ID is '更新者';

comment on table T07_ORG is '起源';
comment on column T07_ORG.ORG_ID is '起源ID';
comment on column T07_ORG.ORG_INFO is '起源情報';
comment on column T07_ORG.INSERT_TS is '作成タイムスタンプ';
comment on column T07_ORG.INSERT_USER_ID is '作成者';
comment on column T07_ORG.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_ORG.UPDATE_USER_ID is '更新者';

comment on table T07_ORG_DET is '起源明細';
comment on column T07_ORG_DET.ORG_ID is '起源ID';
comment on column T07_ORG_DET.ORG_BN is '起源枝番';
comment on column T07_ORG_DET.DET_INFO is '明細情報';
comment on column T07_ORG_DET.INSERT_TS is '作成タイムスタンプ';
comment on column T07_ORG_DET.INSERT_USER_ID is '作成者';
comment on column T07_ORG_DET.UPDATE_TS is '更新タイムスタンプ';
comment on column T07_ORG_DET.UPDATE_USER_ID is '更新者';

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

comment on table T09_CHOICE is '選択';
comment on column T09_CHOICE.CHOICE_ID is '選択ID';
comment on column T09_CHOICE.KOHO1_ID is '候補１ID';
comment on column T09_CHOICE.KOHO1_INFO is '候補１情報';
comment on column T09_CHOICE.KOHO2_ID is '候補２ID';
comment on column T09_CHOICE.KOHO2_INFO is '候補２情報';
comment on column T09_CHOICE.INSERT_TS is '作成タイムスタンプ';
comment on column T09_CHOICE.INSERT_USER_ID is '作成者';
comment on column T09_CHOICE.UPDATE_TS is '更新タイムスタンプ';
comment on column T09_CHOICE.UPDATE_USER_ID is '更新者';

comment on table T09_KOHO1 is '候補１';
comment on column T09_KOHO1.KOHO1_ID is '候補１ID';
comment on column T09_KOHO1.KOHO1_INFO is '候補１情報';
comment on column T09_KOHO1.INSERT_TS is '作成タイムスタンプ';
comment on column T09_KOHO1.INSERT_USER_ID is '作成者';
comment on column T09_KOHO1.UPDATE_TS is '更新タイムスタンプ';
comment on column T09_KOHO1.UPDATE_USER_ID is '更新者';

comment on table T09_KOHO2 is '候補２';
comment on column T09_KOHO2.KOHO2_ID is '候補２ID';
comment on column T09_KOHO2.KOHO2_INFO is '候補２情報';
comment on column T09_KOHO2.INSERT_TS is '作成タイムスタンプ';
comment on column T09_KOHO2.INSERT_USER_ID is '作成者';
comment on column T09_KOHO2.UPDATE_TS is '更新タイムスタンプ';
comment on column T09_KOHO2.UPDATE_USER_ID is '更新者';

comment on table T10_GRP1 is '集団１';
comment on column T10_GRP1.GRP1_ID is '集団１ID';
comment on column T10_GRP1.SUM_ID is '集約ID';
comment on column T10_GRP1.INSERT_TS is '作成タイムスタンプ';
comment on column T10_GRP1.INSERT_USER_ID is '作成者';
comment on column T10_GRP1.UPDATE_TS is '更新タイムスタンプ';
comment on column T10_GRP1.UPDATE_USER_ID is '更新者';

comment on table T10_GRP2 is '集団２';
comment on column T10_GRP2.GRP2_ID is '集団２ID';
comment on column T10_GRP2.SUM_ID is '集約ID';
comment on column T10_GRP2.INSERT_TS is '作成タイムスタンプ';
comment on column T10_GRP2.INSERT_USER_ID is '作成者';
comment on column T10_GRP2.UPDATE_TS is '更新タイムスタンプ';
comment on column T10_GRP2.UPDATE_USER_ID is '更新者';

comment on table T10_SUM is '集約';
comment on column T10_SUM.SUM_ID is '集約ID';
comment on column T10_SUM.SUM_INFO is '集約情報';
comment on column T10_SUM.INSERT_TS is '作成タイムスタンプ';
comment on column T10_SUM.INSERT_USER_ID is '作成者';
comment on column T10_SUM.UPDATE_TS is '更新タイムスタンプ';
comment on column T10_SUM.UPDATE_USER_ID is '更新者';

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

comment on table T14_JISSEKI is '実績';
comment on column T14_JISSEKI.KOUTEI_ID is '工程ID';
comment on column T14_JISSEKI.JISSEKI_BN is '実績連番';
comment on column T14_JISSEKI.JISSHI_BI is '実施日';
comment on column T14_JISSEKI.KANRYO_BI is '完了日';
comment on column T14_JISSEKI.INSERT_TS is '作成タイムスタンプ';
comment on column T14_JISSEKI.INSERT_USER_ID is '作成者';
comment on column T14_JISSEKI.UPDATE_TS is '更新タイムスタンプ';
comment on column T14_JISSEKI.UPDATE_USER_ID is '更新者';

comment on table T14_KOUTEI is '工程';
comment on column T14_KOUTEI.KOUTEI_ID is '工程ID';
comment on column T14_KOUTEI.KOUTEI_MEI is '工程名';
comment on column T14_KOUTEI.KAISHI_BI is '開始日';
comment on column T14_KOUTEI.SHURYO_BI is '終了日';
comment on column T14_KOUTEI.SAGYOKU_CD is '作業区CD';
comment on column T14_KOUTEI.OYA_KOUTEI_ID is '親工程ID';
comment on column T14_KOUTEI.INSERT_TS is '作成タイムスタンプ';
comment on column T14_KOUTEI.INSERT_USER_ID is '作成者';
comment on column T14_KOUTEI.UPDATE_TS is '更新タイムスタンプ';
comment on column T14_KOUTEI.UPDATE_USER_ID is '更新者';

comment on view V13_FURIWAKE is '振分ビュー';
comment on column V13_FURIWAKE.table_name is 'テーブル名';
comment on column V13_FURIWAKE."SRC_ID$DEST_ID" is '振分ID';
comment on column V13_FURIWAKE.info is '情報';

comment on view V13_HENKAN is '変換ビュー';
comment on column V13_HENKAN.table_name is 'テーブル名';
comment on column V13_HENKAN.src_id is '変換元ID';
comment on column V13_HENKAN.dest_info is '変換元情報';

comment on view V14_FUKA_KADOBI is '稼働日負荷';
comment on column V14_FUKA_KADOBI.labels is 'labels';
comment on column V14_FUKA_KADOBI.type is 'type';
comment on column V14_FUKA_KADOBI.stack is 'stack';
comment on column V14_FUKA_KADOBI.label is 'label';
comment on column V14_FUKA_KADOBI.DATA is 'DATA';

comment on view V14_FUKA_SAGYOKU is '作業区負荷';
comment on column V14_FUKA_SAGYOKU.labels is 'labels';
comment on column V14_FUKA_SAGYOKU.type is 'type';
comment on column V14_FUKA_SAGYOKU.stack is 'stack';
comment on column V14_FUKA_SAGYOKU.label is 'label';
comment on column V14_FUKA_SAGYOKU.DATA is 'DATA';

comment on view V14_YOJITSU is '予実';
comment on column V14_YOJITSU.oya_koutei_id is 'oya_koutei_id';
comment on column V14_YOJITSU.dependencies is 'dependencies';

comment on view V14_YOJITSU is '予実';
comment on column V14_YOJITSU.koutei_id is 'koutei_id';
comment on column V14_YOJITSU.koutei_tx is 'koutei_tx';
comment on column V14_YOJITSU.kaishi_bi is 'kaishi_bi';
comment on column V14_YOJITSU.shuryo_bi is 'shuryo_bi';
comment on column V14_YOJITSU.sagyoku_cd is 'sagyoku_cd';
comment on column V14_YOJITSU.oya_koutei_id is 'oya_koutei_id';
comment on column V14_YOJITSU.jisshi_bi is 'jisshi_bi';
comment on column V14_YOJITSU.kanryo_bi is 'kanryo_bi';
comment on column V14_YOJITSU.dependencies is 'dependencies';
comment on column V14_YOJITSU.koutei_path is 'koutei_path';
comment on column V14_YOJITSU.root is 'root';

