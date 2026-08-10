package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T00_ENTITY
 * @author emarfkrow
 */
public class T00Entity implements IEntity {

    /** デフォルトコンストラクタ */
    public T00Entity() {
    }

    /** @param values */
    public T00Entity(final String[] values) {
        this.setEntityId(values[0]);
        this.setEntityNm(values[1]);
        this.setEntityMei(values[2]);
        this.setBitB(values[3]);
        this.setCheckF(values[4]);
        this.setRadioKb(values[5]);
        this.setPulldownKb(values[6]);
        this.setPulldownSb(values[7]);
        this.setMemoTx(values[8]);
        this.setMemo(values[9]);
        this.setTenpuFile(values[10]);
        this.setNenY(values[11]);
        this.setTsukiM(values[12]);
        this.setHiD(values[13]);
        this.setNengetsuYm(values[14]);
        this.setNengappiYmd(values[15]);
        this.setTimestampTs(values[16]);
        this.setNichijiDt(values[17]);
        this.setHidukeBi(values[18]);
        this.setJikokuHm(values[19]);
        this.setJikanTm(values[20]);
        this.setTsukaKb(values[21]);
        this.setJuchuQt(values[22]);
        this.setJuchuPr(values[23]);
        this.setJuchuAm(values[24]);
        this.setHacchuQt(values[25]);
        this.setHacchuPr(values[26]);
        this.setHacchuAm(values[27]);
        this.setDeleteF(values[28]);
        this.setStatusKb(values[29]);
        this.setInsertTs(values[30]);
        this.setInsertUserId(values[31]);
        this.setUpdateTs(values[32]);
        this.setUpdateUserId(values[33]);
    }

    /** @param map */
    public T00Entity(final java.util.Map<String, Object> map) {
        this.setEntityId(IgnoreCaseLinkedMap.get(map, "ENTITY_ID"));
        this.setEntityNm(IgnoreCaseLinkedMap.get(map, "ENTITY_NM"));
        this.setEntityMei(IgnoreCaseLinkedMap.get(map, "ENTITY_MEI"));
        this.setBitB(IgnoreCaseLinkedMap.get(map, "BIT_B"));
        this.setCheckF(IgnoreCaseLinkedMap.get(map, "CHECK_F"));
        this.setRadioKb(IgnoreCaseLinkedMap.get(map, "RADIO_KB"));
        this.setPulldownKb(IgnoreCaseLinkedMap.get(map, "PULLDOWN_KB"));
        this.setPulldownSb(IgnoreCaseLinkedMap.get(map, "PULLDOWN_SB"));
        this.setMemoTx(IgnoreCaseLinkedMap.get(map, "MEMO_TX"));
        this.setMemo(IgnoreCaseLinkedMap.get(map, "MEMO"));
        this.setTenpuFile(IgnoreCaseLinkedMap.get(map, "TENPU_FILE"));
        this.setNenY(IgnoreCaseLinkedMap.get(map, "NEN_Y"));
        this.setTsukiM(IgnoreCaseLinkedMap.get(map, "TSUKI_M"));
        this.setHiD(IgnoreCaseLinkedMap.get(map, "HI_D"));
        this.setNengetsuYm(IgnoreCaseLinkedMap.get(map, "NENGETSU_YM"));
        this.setNengappiYmd(IgnoreCaseLinkedMap.get(map, "NENGAPPI_YMD"));
        this.setTimestampTs(IgnoreCaseLinkedMap.get(map, "TIMESTAMP_TS"));
        this.setNichijiDt(IgnoreCaseLinkedMap.get(map, "NICHIJI_DT"));
        this.setHidukeBi(IgnoreCaseLinkedMap.get(map, "HIDUKE_BI"));
        this.setJikokuHm(IgnoreCaseLinkedMap.get(map, "JIKOKU_HM"));
        this.setJikanTm(IgnoreCaseLinkedMap.get(map, "JIKAN_TM"));
        this.setTsukaKb(IgnoreCaseLinkedMap.get(map, "TSUKA_KB"));
        this.setJuchuQt(IgnoreCaseLinkedMap.get(map, "JUCHU_QT"));
        this.setJuchuPr(IgnoreCaseLinkedMap.get(map, "JUCHU_PR"));
        this.setJuchuAm(IgnoreCaseLinkedMap.get(map, "JUCHU_AM"));
        this.setHacchuQt(IgnoreCaseLinkedMap.get(map, "HACCHU_QT"));
        this.setHacchuPr(IgnoreCaseLinkedMap.get(map, "HACCHU_PR"));
        this.setHacchuAm(IgnoreCaseLinkedMap.get(map, "HACCHU_AM"));
        this.setDeleteF(IgnoreCaseLinkedMap.get(map, "DELETE_F"));
        this.setStatusKb(IgnoreCaseLinkedMap.get(map, "STATUS_KB"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.entityId)) {
            isNew = true;
        }
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.updateTs)) {
            isNew = true;
        }
        return isNew;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.entityNm == null || this.entityNm.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.entityMei == null || this.entityMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.bitB == null || this.bitB.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.checkF == null || this.checkF.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.radioKb == null || this.radioKb.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.pulldownKb == null || this.pulldownKb.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.pulldownSb == null || this.pulldownSb.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.memoTx == null || this.memoTx.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.memo == null || this.memo.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.tenpuFile == null || this.tenpuFile.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.nenY == null || this.nenY.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.tsukiM == null || this.tsukiM.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.hiD == null || this.hiD.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.nengetsuYm == null || this.nengetsuYm.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.nengappiYmd == null || this.nengappiYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.timestampTs == null || this.timestampTs.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.nichijiDt == null || this.nichijiDt.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.hidukeBi == null || this.hidukeBi.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.jikokuHm == null || this.jikokuHm.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.jikanTm == null || this.jikanTm.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.tsukaKb == null || this.tsukaKb.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.juchuQt == null || this.juchuQt.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.juchuPr == null || this.juchuPr.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.juchuAm == null || this.juchuAm.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.hacchuQt == null || this.hacchuQt.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.hacchuPr == null || this.hacchuPr.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.hacchuAm == null || this.hacchuAm.toString().replaceAll("　| ", "").equals("");
        return isEmpty;
    }

    /** SlickGridのDataView用ID */
    @jp.co.golorp.emarf.validation.GridViewRowId
    private Integer id;

    /** @return id */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id", index = 1)
    public final Integer getId() {
        return id;
    }

    /** @param o id */
    public final void setId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.id = Integer.valueOf(o.toString());
        } else {
            this.id = null;
        }
    }

    /** ENTITY_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer entityId;

    /** @return ENTITY_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ENTITY_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getEntityId() {
        return this.entityId;
    }

    /** @param o ENTITY_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setEntityId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.entityId = Integer.valueOf(o.toString());
        } else {
            this.entityId = null;
        }
    }

    /** ENTITY_NM */
    private String entityNm;

    /** @return ENTITY_NM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ENTITY_NM", index = 3)
    public String getEntityNm() {
        return this.entityNm;
    }

    /** @param o ENTITY_NM */
    public void setEntityNm(final Object o) {
        if (o != null) {
            this.entityNm = o.toString();
        } else {
            this.entityNm = null;
        }
    }

    /** ENTITY_MEI */
    private String entityMei;

    /** @return ENTITY_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ENTITY_MEI", index = 4)
    public String getEntityMei() {
        return this.entityMei;
    }

    /** @param o ENTITY_MEI */
    public void setEntityMei(final Object o) {
        if (o != null) {
            this.entityMei = o.toString();
        } else {
            this.entityMei = null;
        }
    }

    /** BIT_B */
    private Integer bitB;

    /** @return BIT_B */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BIT_B", index = 5)
    public Integer getBitB() {
        return this.bitB;
    }

    /** @param o BIT_B */
    public void setBitB(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.bitB = Integer.valueOf(o.toString());
        } else {
            this.bitB = null;
        }
    }

    /** CHECK_F */
    private String checkF = "0";

    /** @return CHECK_F */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CHECK_F", index = 6)
    public String getCheckF() {
        return this.checkF;
    }

    /** @param o CHECK_F */
    public void setCheckF(final Object o) {
        if (o != null) {
            this.checkF = o.toString();
        } else {
            this.checkF = null;
        }
    }

    /** RADIO_KB */
    private String radioKb;

    /** @return RADIO_KB */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "RADIO_KB", index = 7)
    public String getRadioKb() {
        return this.radioKb;
    }

    /** @param o RADIO_KB */
    public void setRadioKb(final Object o) {
        if (o != null) {
            this.radioKb = o.toString();
        } else {
            this.radioKb = null;
        }
    }

    /** PULLDOWN_KB */
    private String pulldownKb;

    /** @return PULLDOWN_KB */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PULLDOWN_KB", index = 8)
    public String getPulldownKb() {
        return this.pulldownKb;
    }

    /** @param o PULLDOWN_KB */
    public void setPulldownKb(final Object o) {
        if (o != null) {
            this.pulldownKb = o.toString();
        } else {
            this.pulldownKb = null;
        }
    }

    /** PULLDOWN_SB */
    private String pulldownSb;

    /** @return PULLDOWN_SB */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PULLDOWN_SB", index = 9)
    public String getPulldownSb() {
        return this.pulldownSb;
    }

    /** @param o PULLDOWN_SB */
    public void setPulldownSb(final Object o) {
        if (o != null) {
            this.pulldownSb = o.toString();
        } else {
            this.pulldownSb = null;
        }
    }

    /** MEMO_TX */
    private String memoTx;

    /** @return MEMO_TX */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MEMO_TX", index = 10)
    public String getMemoTx() {
        return this.memoTx;
    }

    /** @param o MEMO_TX */
    public void setMemoTx(final Object o) {
        if (o != null) {
            this.memoTx = o.toString();
        } else {
            this.memoTx = null;
        }
    }

    /** MEMO */
    private String memo;

    /** @return MEMO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MEMO", index = 11)
    public String getMemo() {
        return this.memo;
    }

    /** @param o MEMO */
    public void setMemo(final Object o) {
        if (o != null) {
            this.memo = o.toString();
        } else {
            this.memo = null;
        }
    }

    /** TENPU_FILE */
    private String tenpuFile;

    /** @return TENPU_FILE */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TENPU_FILE", index = 12)
    public String getTenpuFile() {
        return this.tenpuFile;
    }

    /** @param o TENPU_FILE */
    public void setTenpuFile(final Object o) {
        if (o != null) {
            this.tenpuFile = o.toString();
        } else {
            this.tenpuFile = null;
        }
    }

    /** NEN_Y */
    private String nenY;

    /** @return NEN_Y */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NEN_Y", index = 13)
    public String getNenY() {
        return this.nenY;
    }

    /** @param o NEN_Y */
    public void setNenY(final Object o) {
        if (o != null) {
            this.nenY = o.toString();
        } else {
            this.nenY = null;
        }
    }

    /** TSUKI_M */
    private String tsukiM;

    /** @return TSUKI_M */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TSUKI_M", index = 14)
    public String getTsukiM() {
        return this.tsukiM;
    }

    /** @param o TSUKI_M */
    public void setTsukiM(final Object o) {
        if (o != null) {
            this.tsukiM = o.toString();
        } else {
            this.tsukiM = null;
        }
    }

    /** HI_D */
    private String hiD;

    /** @return HI_D */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HI_D", index = 15)
    public String getHiD() {
        return this.hiD;
    }

    /** @param o HI_D */
    public void setHiD(final Object o) {
        if (o != null) {
            this.hiD = o.toString();
        } else {
            this.hiD = null;
        }
    }

    /** NENGETSU_YM */
    private String nengetsuYm;

    /** @return NENGETSU_YM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NENGETSU_YM", index = 16)
    public String getNengetsuYm() {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.nengetsuYm)) {
            return this.nengetsuYm.substring(0, 4) + "-" + this.nengetsuYm.substring(4);
        }
        return this.nengetsuYm;
    }

    /** @param o NENGETSU_YM */
    public void setNengetsuYm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.nengetsuYm = String.valueOf(o.toString().replace("-", ""));
        } else {
            this.nengetsuYm = null;
        }
    }

    /** NENGAPPI_YMD */
    private String nengappiYmd;

    /** @return NENGAPPI_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NENGAPPI_YMD", index = 17)
    public String getNengappiYmd() {
        return this.nengappiYmd;
    }

    /** @param o NENGAPPI_YMD */
    public void setNengappiYmd(final Object o) {
        if (o != null) {
            this.nengappiYmd = o.toString();
        } else {
            this.nengappiYmd = null;
        }
    }

    /** TIMESTAMP_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime timestampTs;

    /** @return TIMESTAMP_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TIMESTAMP_TS", index = 18)
    public java.time.LocalDateTime getTimestampTs() {
        return this.timestampTs;
    }

    /** @param o TIMESTAMP_TS */
    public void setTimestampTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.timestampTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.timestampTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.timestampTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.timestampTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.timestampTs = null;
        }
    }

    /** NICHIJI_DT */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime nichijiDt;

    /** @return NICHIJI_DT */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NICHIJI_DT", index = 19)
    public java.time.LocalDateTime getNichijiDt() {
        return this.nichijiDt;
    }

    /** @param o NICHIJI_DT */
    public void setNichijiDt(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.nichijiDt = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.nichijiDt = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.nichijiDt = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.nichijiDt = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.nichijiDt = null;
        }
    }

    /** HIDUKE_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate hidukeBi;

    /** @return HIDUKE_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HIDUKE_BI", index = 20)
    public java.time.LocalDate getHidukeBi() {
        return this.hidukeBi;
    }

    /** @param o HIDUKE_BI */
    public void setHidukeBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hidukeBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.hidukeBi = null;
        }
    }

    /** JIKOKU_HM */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "hh:mm")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer.class)
    private java.time.LocalTime jikokuHm;

    /** @return JIKOKU_HM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JIKOKU_HM", index = 21)
    public java.time.LocalTime getJikokuHm() {
        return this.jikokuHm;
    }

    /** @param o JIKOKU_HM */
    public void setJikokuHm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            String text = o.toString().replaceFirst("^\\d+[\\/|\\-]\\d+[\\/|\\-]\\d+ ", "");
            this.jikokuHm = java.time.LocalTime.parse(text);
        } else {
            this.jikokuHm = null;
        }
    }

    /** JIKAN_TM */
    private String jikanTm;

    /** @return JIKAN_TM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JIKAN_TM", index = 22)
    public String getJikanTm() {
        return this.jikanTm;
    }

    /** @param o JIKAN_TM */
    public void setJikanTm(final Object o) {
        if (o != null) {
            this.jikanTm = o.toString();
        } else {
            this.jikanTm = null;
        }
    }

    /** TSUKA_KB */
    private String tsukaKb;

    /** @return TSUKA_KB */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TSUKA_KB", index = 23)
    public String getTsukaKb() {
        return this.tsukaKb;
    }

    /** @param o TSUKA_KB */
    public void setTsukaKb(final Object o) {
        if (o != null) {
            this.tsukaKb = o.toString();
        } else {
            this.tsukaKb = null;
        }
    }

    /** JUCHU_QT */
    private java.math.BigDecimal juchuQt;

    /** @return JUCHU_QT */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JUCHU_QT", index = 24)
    public java.math.BigDecimal getJuchuQt() {
        return this.juchuQt;
    }

    /** @param o JUCHU_QT */
    public void setJuchuQt(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.juchuQt = new java.math.BigDecimal(o.toString());
        } else {
            this.juchuQt = null;
        }
    }

    /** JUCHU_PR */
    private java.math.BigDecimal juchuPr;

    /** @return JUCHU_PR */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JUCHU_PR", index = 25)
    public java.math.BigDecimal getJuchuPr() {
        return this.juchuPr;
    }

    /** @param o JUCHU_PR */
    public void setJuchuPr(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.juchuPr = new java.math.BigDecimal(o.toString());
        } else {
            this.juchuPr = null;
        }
    }

    /** JUCHU_AM */
    private java.math.BigDecimal juchuAm;

    /** @return JUCHU_AM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JUCHU_AM", index = 26)
    public java.math.BigDecimal getJuchuAm() {
        return this.juchuAm;
    }

    /** @param o JUCHU_AM */
    public void setJuchuAm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.juchuAm = new java.math.BigDecimal(o.toString());
        } else {
            this.juchuAm = null;
        }
    }

    /** HACCHU_QT */
    private java.math.BigDecimal hacchuQt;

    /** @return HACCHU_QT */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HACCHU_QT", index = 27)
    public java.math.BigDecimal getHacchuQt() {
        return this.hacchuQt;
    }

    /** @param o HACCHU_QT */
    public void setHacchuQt(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hacchuQt = new java.math.BigDecimal(o.toString());
        } else {
            this.hacchuQt = null;
        }
    }

    /** HACCHU_PR */
    private java.math.BigDecimal hacchuPr;

    /** @return HACCHU_PR */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HACCHU_PR", index = 28)
    public java.math.BigDecimal getHacchuPr() {
        return this.hacchuPr;
    }

    /** @param o HACCHU_PR */
    public void setHacchuPr(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hacchuPr = new java.math.BigDecimal(o.toString());
        } else {
            this.hacchuPr = null;
        }
    }

    /** HACCHU_AM */
    private java.math.BigDecimal hacchuAm;

    /** @return HACCHU_AM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HACCHU_AM", index = 29)
    public java.math.BigDecimal getHacchuAm() {
        return this.hacchuAm;
    }

    /** @param o HACCHU_AM */
    public void setHacchuAm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hacchuAm = new java.math.BigDecimal(o.toString());
        } else {
            this.hacchuAm = null;
        }
    }

    /** DELETE_F */
    private String deleteF = "0";

    /** @return DELETE_F */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DELETE_F", index = 30)
    public String getDeleteF() {
        return this.deleteF;
    }

    /** @param o DELETE_F */
    public void setDeleteF(final Object o) {
        if (o != null) {
            this.deleteF = o.toString();
        } else {
            this.deleteF = null;
        }
    }

    /** STATUS_KB */
    private String statusKb;

    /** @return STATUS_KB */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "STATUS_KB", index = 31)
    public String getStatusKb() {
        return this.statusKb;
    }

    /** @param o STATUS_KB */
    public void setStatusKb(final Object o) {
        if (o != null) {
            this.statusKb = o.toString();
        } else {
            this.statusKb = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 32)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o INSERT_TS */
    public void setInsertTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.insertTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** INSERT_USER_ID */
    private String insertUserId;

    /** @return INSERT_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 33)
    public String getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o INSERT_USER_ID */
    public void setInsertUserId(final Object o) {
        if (o != null) {
            this.insertUserId = o.toString();
        } else {
            this.insertUserId = null;
        }
    }

    /** 作成者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String insertUserSei;

    /** @return 作成者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 34)
    public String getInsertUserSei() {
        return this.insertUserSei;
    }

    /** @param o 作成者参照 */
    public void setInsertUserSei(final Object o) {
        if (o != null) {
            this.insertUserSei = o.toString();
        } else {
            this.insertUserSei = null;
        }
    }

    /** UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 35)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o UPDATE_TS */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.updateTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** UPDATE_USER_ID */
    private String updateUserId;

    /** @return UPDATE_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 36)
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o UPDATE_USER_ID */
    public void setUpdateUserId(final Object o) {
        if (o != null) {
            this.updateUserId = o.toString();
        } else {
            this.updateUserId = null;
        }
    }

    /** 更新者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String updateUserSei;

    /** @return 更新者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 37)
    public String getUpdateUserSei() {
        return this.updateUserSei;
    }

    /** @param o 更新者参照 */
    public void setUpdateUserSei(final Object o) {
        if (o != null) {
            this.updateUserSei = o.toString();
        } else {
            this.updateUserSei = null;
        }
    }

    /** riyuTx */
    private String riyuTx;

    /** @return riyuTx */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "riyu_tx", index = 38)
    public String getRiyuTx() {
        return this.riyuTx;
    }

    /** @param o riyuTx */
    public void setRiyuTx(final Object o) {
        if (o != null) {
            this.riyuTx = o.toString();
        }
    }

    /**
     * エンティティ照会
     * @param param1 エンティティID
     * @return エンティティ
     */
    public static T00Entity get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`ENTITY_ID` = :entity_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`ENTITY_ID` \n";
        sql += "    , a.`ENTITY_NM` \n";
        sql += "    , a.`ENTITY_MEI` \n";
        sql += "    , a.`BIT_B` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`CHECK_F`) AS CHECK_F \n";
        sql += "    , a.`RADIO_KB` \n";
        sql += "    , a.`PULLDOWN_KB` \n";
        sql += "    , a.`PULLDOWN_SB` \n";
        sql += "    , a.`MEMO_TX` \n";
        sql += "    , a.`MEMO` \n";
        sql += "    , a.`TENPU_FILE` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NEN_Y`) AS NEN_Y \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`TSUKI_M`) AS TSUKI_M \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`HI_D`) AS HI_D \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NENGETSU_YM`) AS NENGETSU_YM \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NENGAPPI_YMD`) AS NENGAPPI_YMD \n";
        sql += "    , LEFT(DATE_FORMAT (a.`TIMESTAMP_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS TIMESTAMP_TS \n";
        sql += "    , LEFT(DATE_FORMAT (a.`NICHIJI_DT`, '%Y-%m-%dT%H:%i:%s'), 19) AS NICHIJI_DT \n";
        sql += "    , a.`HIDUKE_BI` AS HIDUKE_BI \n";
        sql += "    , a.`JIKOKU_HM` \n";
        sql += "    , a.`JIKAN_TM` \n";
        sql += "    , a.`TSUKA_KB` \n";
        sql += "    , a.`JUCHU_QT` \n";
        sql += "    , a.`JUCHU_PR` \n";
        sql += "    , a.`JUCHU_AM` \n";
        sql += "    , a.`HACCHU_QT` \n";
        sql += "    , a.`HACCHU_PR` \n";
        sql += "    , a.`HACCHU_AM` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`DELETE_F`) AS DELETE_F \n";
        sql += "    , a.`STATUS_KB` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS INSERT_USER_ID \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T00_ENTITY a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("entity_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T00Entity.class);
    }

    /**
     * エンティティ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime now, final String execId) {

        // エンティティIDの採番処理
        numbering();

        // エンティティの登録
        String sql = "INSERT INTO T00_ENTITY(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("`ENTITY_ID` -- :entity_id");
        nameList.add("`ENTITY_NM` -- :entity_nm");
        nameList.add("`ENTITY_MEI` -- :entity_mei");
        nameList.add("`BIT_B` -- :bit_b");
        nameList.add("`CHECK_F` -- :check_f");
        nameList.add("`RADIO_KB` -- :radio_kb");
        nameList.add("`PULLDOWN_KB` -- :pulldown_kb");
        nameList.add("`PULLDOWN_SB` -- :pulldown_sb");
        nameList.add("`MEMO_TX` -- :memo_tx");
        nameList.add("`MEMO` -- :memo");
        nameList.add("`TENPU_FILE` -- :tenpu_file");
        nameList.add("`NEN_Y` -- :nen_y");
        nameList.add("`TSUKI_M` -- :tsuki_m");
        nameList.add("`HI_D` -- :hi_d");
        nameList.add("`NENGETSU_YM` -- :nengetsu_ym");
        nameList.add("`NENGAPPI_YMD` -- :nengappi_ymd");
        nameList.add("`TIMESTAMP_TS` -- :timestamp_ts");
        nameList.add("`NICHIJI_DT` -- :nichiji_dt");
        nameList.add("`HIDUKE_BI` -- :hiduke_bi");
        nameList.add("`JIKOKU_HM` -- :jikoku_hm");
        nameList.add("`JIKAN_TM` -- :jikan_tm");
        nameList.add("`TSUKA_KB` -- :tsuka_kb");
        nameList.add("`JUCHU_QT` -- :juchu_qt");
        nameList.add("`JUCHU_PR` -- :juchu_pr");
        nameList.add("`JUCHU_AM` -- :juchu_am");
        nameList.add("`HACCHU_QT` -- :hacchu_qt");
        nameList.add("`HACCHU_PR` -- :hacchu_pr");
        nameList.add("`HACCHU_AM` -- :hacchu_am");
        nameList.add("`DELETE_F` -- :delete_f");
        nameList.add("`STATUS_KB` -- :status_kb");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":entity_id");
        valueList.add(":entity_nm");
        valueList.add(":entity_mei");
        valueList.add(":bit_b");
        valueList.add(":check_f");
        valueList.add(":radio_kb");
        valueList.add(":pulldown_kb");
        valueList.add(":pulldown_sb");
        valueList.add(":memo_tx");
        valueList.add(":memo");
        valueList.add(":tenpu_file");
        valueList.add(":nen_y");
        valueList.add(":tsuki_m");
        valueList.add(":hi_d");
        valueList.add(":nengetsu_ym");
        valueList.add(":nengappi_ymd");
        valueList.add("LEFT(DATE_FORMAT (now(3), '%Y-%m-%dT%H:%i:%s.%f'), 23)");
        valueList.add(":nichiji_dt");
        valueList.add(":hiduke_bi");
        valueList.add(":jikoku_hm");
        valueList.add(":jikan_tm");
        valueList.add(":tsuka_kb");
        valueList.add(":juchu_qt");
        valueList.add(":juchu_pr");
        valueList.add(":juchu_am");
        valueList.add(":hacchu_qt");
        valueList.add(":hacchu_pr");
        valueList.add(":hacchu_am");
        valueList.add(":delete_f");
        valueList.add(":status_kb");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** エンティティIDの採番処理 */
    private void numbering() {
        if (this.entityId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`ENTITY_ID`) IS NULL THEN 0 ELSE MAX(e.`ENTITY_ID`) * 1 END + 1 AS `ENTITY_ID` FROM T00_ENTITY e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("ENTITY_ID");
        this.setEntityId(o);
    }

    /**
     * エンティティ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime now, final String execId) {

        // 決裁フローの登録
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.statusKb) && !jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.riyuTx)) {
            T03StatusKb t03StatusKb = new T03StatusKb();
            t03StatusKb.setTableNm("T00_ENTITY");
            t03StatusKb.setPrimaryKeys(String.join(",", this.getEntityId().toString()));
            t03StatusKb.setStatusKb(this.statusKb);
            t03StatusKb.setKessaiTs(now);
            t03StatusKb.setKessaiId(execId);
            t03StatusKb.setRiyuTx(this.riyuTx);
            t03StatusKb.setInsertTs(this.insertTs);
            t03StatusKb.setInsertUserId(this.insertUserId);
            t03StatusKb.setUpdateTs(this.updateTs);
            t03StatusKb.setUpdateUserId(this.updateUserId);
            t03StatusKb.insert(now, execId);
        }

        // エンティティの登録
        String sql = "UPDATE T00_ENTITY\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("`ENTITY_ID` = :entity_id");
        setList.add("`ENTITY_NM` = :entity_nm");
        setList.add("`ENTITY_MEI` = :entity_mei");
        setList.add("`BIT_B` = :bit_b");
        setList.add("`CHECK_F` = :check_f");
        setList.add("`RADIO_KB` = :radio_kb");
        setList.add("`PULLDOWN_KB` = :pulldown_kb");
        setList.add("`PULLDOWN_SB` = :pulldown_sb");
        setList.add("`MEMO_TX` = :memo_tx");
        setList.add("`MEMO` = :memo");
        setList.add("`TENPU_FILE` = :tenpu_file");
        setList.add("`NEN_Y` = :nen_y");
        setList.add("`TSUKI_M` = :tsuki_m");
        setList.add("`HI_D` = :hi_d");
        setList.add("`NENGETSU_YM` = :nengetsu_ym");
        setList.add("`NENGAPPI_YMD` = :nengappi_ymd");
        setList.add("`TIMESTAMP_TS` = :timestamp_ts");
        setList.add("`NICHIJI_DT` = :nichiji_dt");
        setList.add("`HIDUKE_BI` = :hiduke_bi");
        setList.add("`JIKOKU_HM` = :jikoku_hm");
        setList.add("`JIKAN_TM` = :jikan_tm");
        setList.add("`TSUKA_KB` = :tsuka_kb");
        setList.add("`JUCHU_QT` = :juchu_qt");
        setList.add("`JUCHU_PR` = :juchu_pr");
        setList.add("`JUCHU_AM` = :juchu_am");
        setList.add("`HACCHU_QT` = :hacchu_qt");
        setList.add("`HACCHU_PR` = :hacchu_pr");
        setList.add("`HACCHU_AM` = :hacchu_am");
        setList.add("`DELETE_F` = :delete_f");
        setList.add("`STATUS_KB` = :status_kb");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * エンティティ全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // エンティティの削除
        String sql = "TRUNCATE TABLE T00_ENTITY";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime now, final String execId) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("entity_id", this.entityId);
        map.put("entity_nm", this.entityNm);
        map.put("entity_mei", this.entityMei);
        map.put("bit_b", this.bitB);
        map.put("check_f", this.checkF);
        map.put("radio_kb", this.radioKb);
        map.put("pulldown_kb", this.pulldownKb);
        map.put("pulldown_sb", this.pulldownSb);
        map.put("memo_tx", this.memoTx);
        map.put("memo", this.memo);
        map.put("tenpu_file", this.tenpuFile);
        map.put("nen_y", this.nenY);
        map.put("tsuki_m", this.tsukiM);
        map.put("hi_d", this.hiD);
        map.put("nengetsu_ym", this.nengetsuYm);
        map.put("nengappi_ymd", this.nengappiYmd);
        map.put("timestamp_ts", this.timestampTs);
        map.put("nichiji_dt", this.nichijiDt);
        map.put("hiduke_bi", this.hidukeBi);
        map.put("jikoku_hm", this.jikokuHm);
        map.put("jikan_tm", this.jikanTm);
        map.put("tsuka_kb", this.tsukaKb);
        map.put("juchu_qt", this.juchuQt);
        map.put("juchu_pr", this.juchuPr);
        map.put("juchu_am", this.juchuAm);
        map.put("hacchu_qt", this.hacchuQt);
        map.put("hacchu_pr", this.hacchuPr);
        map.put("hacchu_am", this.hacchuAm);
        map.put("delete_f", this.deleteF);
        map.put("status_kb", this.statusKb);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`ENTITY_ID` = :entity_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }
}
