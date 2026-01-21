package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * エンティティ
 * @author emarfkrow
 */
public class Tb0Entity implements IEntity {

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

    /** エンティティID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer entityId;

    /** @return エンティティID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ENTITY_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getEntityId() {
        return this.entityId;
    }

    /** @param o エンティティID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setEntityId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.entityId = Integer.valueOf(o.toString());
        } else {
            this.entityId = null;
        }
    }

    /** エンティティ名称 */
    private String entityNm;

    /** @return エンティティ名称 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ENTITY_NM", index = 3)
    public String getEntityNm() {
        return this.entityNm;
    }

    /** @param o エンティティ名称 */
    public void setEntityNm(final Object o) {
        if (o != null) {
            this.entityNm = o.toString();
        } else {
            this.entityNm = null;
        }
    }

    /** エンティティ名 */
    private String entityMei;

    /** @return エンティティ名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ENTITY_MEI", index = 4)
    public String getEntityMei() {
        return this.entityMei;
    }

    /** @param o エンティティ名 */
    public void setEntityMei(final Object o) {
        if (o != null) {
            this.entityMei = o.toString();
        } else {
            this.entityMei = null;
        }
    }

    /** チェックフラグ */
    private String checkF = "0";

    /** @return チェックフラグ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CHECK_F", index = 5)
    public String getCheckF() {
        return this.checkF;
    }

    /** @param o チェックフラグ */
    public void setCheckF(final Object o) {
        if (o != null) {
            this.checkF = o.toString();
        } else {
            this.checkF = null;
        }
    }

    /** ラジオ区分 */
    private String radioKb;

    /** @return ラジオ区分 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "RADIO_KB", index = 6)
    public String getRadioKb() {
        return this.radioKb;
    }

    /** @param o ラジオ区分 */
    public void setRadioKb(final Object o) {
        if (o != null) {
            this.radioKb = o.toString();
        } else {
            this.radioKb = null;
        }
    }

    /** プルダウン区分 */
    private String pulldownKb;

    /** @return プルダウン区分 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PULLDOWN_KB", index = 7)
    public String getPulldownKb() {
        return this.pulldownKb;
    }

    /** @param o プルダウン区分 */
    public void setPulldownKb(final Object o) {
        if (o != null) {
            this.pulldownKb = o.toString();
        } else {
            this.pulldownKb = null;
        }
    }

    /** プルダウン種別 */
    private String pulldownSb;

    /** @return プルダウン種別 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PULLDOWN_SB", index = 8)
    public String getPulldownSb() {
        return this.pulldownSb;
    }

    /** @param o プルダウン種別 */
    public void setPulldownSb(final Object o) {
        if (o != null) {
            this.pulldownSb = o.toString();
        } else {
            this.pulldownSb = null;
        }
    }

    /** メモ */
    private String memoTx;

    /** @return メモ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MEMO_TX", index = 9)
    public String getMemoTx() {
        return this.memoTx;
    }

    /** @param o メモ */
    public void setMemoTx(final Object o) {
        if (o != null) {
            this.memoTx = o.toString();
        } else {
            this.memoTx = null;
        }
    }

    /** １行メモ */
    private String memo;

    /** @return １行メモ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MEMO", index = 10)
    public String getMemo() {
        return this.memo;
    }

    /** @param o １行メモ */
    public void setMemo(final Object o) {
        if (o != null) {
            this.memo = o.toString();
        } else {
            this.memo = null;
        }
    }

    /** 添付ファイル */
    private String tenpuFile;

    /** @return 添付ファイル */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TENPU_FILE", index = 11)
    public String getTenpuFile() {
        return this.tenpuFile;
    }

    /** @param o 添付ファイル */
    public void setTenpuFile(final Object o) {
        if (o != null) {
            this.tenpuFile = o.toString();
        } else {
            this.tenpuFile = null;
        }
    }

    /** 年月日年 */
    private String nengappiY;

    /** @return 年月日年 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NENGAPPI_Y", index = 12)
    public String getNengappiY() {
        return this.nengappiY;
    }

    /** @param o 年月日年 */
    public void setNengappiY(final Object o) {
        if (o != null) {
            this.nengappiY = o.toString();
        } else {
            this.nengappiY = null;
        }
    }

    /** 年月日月 */
    private String nengappiM;

    /** @return 年月日月 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NENGAPPI_M", index = 13)
    public String getNengappiM() {
        return this.nengappiM;
    }

    /** @param o 年月日月 */
    public void setNengappiM(final Object o) {
        if (o != null) {
            this.nengappiM = o.toString();
        } else {
            this.nengappiM = null;
        }
    }

    /** 年月日日 */
    private String nengappiD;

    /** @return 年月日日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NENGAPPI_D", index = 14)
    public String getNengappiD() {
        return this.nengappiD;
    }

    /** @param o 年月日日 */
    public void setNengappiD(final Object o) {
        if (o != null) {
            this.nengappiD = o.toString();
        } else {
            this.nengappiD = null;
        }
    }

    /** 年月 */
    private String nengetsuYm;

    /** @return 年月 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NENGETSU_YM", index = 15)
    public String getNengetsuYm() {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.nengetsuYm)) {
            return this.nengetsuYm.substring(0, 4) + "-" + this.nengetsuYm.substring(4);
        }
        return this.nengetsuYm;
    }

    /** @param o 年月 */
    public void setNengetsuYm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.nengetsuYm = String.valueOf(o.toString().replace("-", ""));
        } else {
            this.nengetsuYm = null;
        }
    }

    /** 年月日 */
    private String nengappiYmd;

    /** @return 年月日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NENGAPPI_YMD", index = 16)
    public String getNengappiYmd() {
        return this.nengappiYmd;
    }

    /** @param o 年月日 */
    public void setNengappiYmd(final Object o) {
        if (o != null) {
            this.nengappiYmd = o.toString();
        } else {
            this.nengappiYmd = null;
        }
    }

    /** タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime timestampTs;

    /** @return タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TIMESTAMP_TS", index = 17)
    public java.time.LocalDateTime getTimestampTs() {
        return this.timestampTs;
    }

    /** @param o タイムスタンプ */
    public void setTimestampTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.timestampTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.timestampTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.timestampTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.timestampTs = null;
        }
    }

    /** 日時 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime nichijiDt;

    /** @return 日時 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NICHIJI_DT", index = 18)
    public java.time.LocalDateTime getNichijiDt() {
        return this.nichijiDt;
    }

    /** @param o 日時 */
    public void setNichijiDt(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.nichijiDt = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.nichijiDt = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.nichijiDt = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.nichijiDt = null;
        }
    }

    /** 日付 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate hidukeBi;

    /** @return 日付 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HIDUKE_BI", index = 19)
    public java.time.LocalDate getHidukeBi() {
        return this.hidukeBi;
    }

    /** @param o 日付 */
    public void setHidukeBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hidukeBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.hidukeBi = null;
        }
    }

    /** 時刻 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "hh:mm")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer.class)
    private java.time.LocalTime jikokuHm;

    /** @return 時刻 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JIKOKU_HM", index = 20)
    public java.time.LocalTime getJikokuHm() {
        return this.jikokuHm;
    }

    /** @param o 時刻 */
    public void setJikokuHm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            String text = o.toString().replaceFirst("^\\d+[\\/|\\-]\\d+[\\/|\\-]\\d+ ", "");
            this.jikokuHm = java.time.LocalTime.parse(text);
        } else {
            this.jikokuHm = null;
        }
    }

    /** 時間 */
    private String jikanTm;

    /** @return 時間 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JIKAN_TM", index = 21)
    public String getJikanTm() {
        return this.jikanTm;
    }

    /** @param o 時間 */
    public void setJikanTm(final Object o) {
        if (o != null) {
            this.jikanTm = o.toString();
        } else {
            this.jikanTm = null;
        }
    }

    /** 数量 */
    private java.math.BigDecimal suryoQt;

    /** @return 数量 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SURYO_QT", index = 22)
    public java.math.BigDecimal getSuryoQt() {
        return this.suryoQt;
    }

    /** @param o 数量 */
    public void setSuryoQt(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.suryoQt = new java.math.BigDecimal(o.toString());
        } else {
            this.suryoQt = null;
        }
    }

    /** 通貨区分 */
    private String tsukaKb;

    /** @return 通貨区分 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TSUKA_KB", index = 23)
    public String getTsukaKb() {
        return this.tsukaKb;
    }

    /** @param o 通貨区分 */
    public void setTsukaKb(final Object o) {
        if (o != null) {
            this.tsukaKb = o.toString();
        } else {
            this.tsukaKb = null;
        }
    }

    /** 受注単価 */
    private java.math.BigDecimal juchuPr;

    /** @return 受注単価 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JUCHU_PR", index = 24)
    public java.math.BigDecimal getJuchuPr() {
        return this.juchuPr;
    }

    /** @param o 受注単価 */
    public void setJuchuPr(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.juchuPr = new java.math.BigDecimal(o.toString());
        } else {
            this.juchuPr = null;
        }
    }

    /** 受注金額 */
    private java.math.BigDecimal juchuAm;

    /** @return 受注金額 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JUCHU_AM", index = 25)
    public java.math.BigDecimal getJuchuAm() {
        return this.juchuAm;
    }

    /** @param o 受注金額 */
    public void setJuchuAm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.juchuAm = new java.math.BigDecimal(o.toString());
        } else {
            this.juchuAm = null;
        }
    }

    /** 発注単価 */
    private java.math.BigDecimal hachuPr;

    /** @return 発注単価 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HACHU_PR", index = 26)
    public java.math.BigDecimal getHachuPr() {
        return this.hachuPr;
    }

    /** @param o 発注単価 */
    public void setHachuPr(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hachuPr = new java.math.BigDecimal(o.toString());
        } else {
            this.hachuPr = null;
        }
    }

    /** 発注金額 */
    private java.math.BigDecimal hachuAm;

    /** @return 発注金額 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HACHU_AM", index = 27)
    public java.math.BigDecimal getHachuAm() {
        return this.hachuAm;
    }

    /** @param o 発注金額 */
    public void setHachuAm(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hachuAm = new java.math.BigDecimal(o.toString());
        } else {
            this.hachuAm = null;
        }
    }

    /** 削除フラグ */
    private String deleteF = "0";

    /** @return 削除フラグ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DELETE_F", index = 28)
    public String getDeleteF() {
        return this.deleteF;
    }

    /** @param o 削除フラグ */
    public void setDeleteF(final Object o) {
        if (o != null) {
            this.deleteF = o.toString();
        } else {
            this.deleteF = null;
        }
    }

    /** ステータス区分 */
    private String statusKb;

    /** @return ステータス区分 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "STATUS_KB", index = 29)
    public String getStatusKb() {
        return this.statusKb;
    }

    /** @param o ステータス区分 */
    public void setStatusKb(final Object o) {
        if (o != null) {
            this.statusKb = o.toString();
        } else {
            this.statusKb = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 30)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o 作成タイムスタンプ */
    public void setInsertTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** 作成者 */
    private Integer insertUserId;

    /** @return 作成者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 31)
    public Integer getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o 作成者 */
    public void setInsertUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertUserId = Integer.valueOf(o.toString());
        } else {
            this.insertUserId = null;
        }
    }

    /** 作成者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String insertUserSei;

    /** @return 作成者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 32)
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

    /** 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 33)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** 更新者 */
    private Integer updateUserId;

    /** @return 更新者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 34)
    public Integer getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o 更新者 */
    public void setUpdateUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateUserId = Integer.valueOf(o.toString());
        } else {
            this.updateUserId = null;
        }
    }

    /** 更新者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String updateUserSei;

    /** @return 更新者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 35)
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

    /**
     * エンティティ照会
     * @param param1 エンティティID
     * @return エンティティ
     */
    public static Tb0Entity get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`ENTITY_ID` = :entity_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`ENTITY_ID` \n";
        sql += "    , a.`ENTITY_NM` \n";
        sql += "    , a.`ENTITY_MEI` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`CHECK_F`) AS CHECK_F \n";
        sql += "    , a.`RADIO_KB` \n";
        sql += "    , a.`PULLDOWN_KB` \n";
        sql += "    , a.`PULLDOWN_SB` \n";
        sql += "    , a.`MEMO_TX` \n";
        sql += "    , a.`MEMO` \n";
        sql += "    , a.`TENPU_FILE` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NENGAPPI_Y`) AS NENGAPPI_Y \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NENGAPPI_M`) AS NENGAPPI_M \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NENGAPPI_D`) AS NENGAPPI_D \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NENGETSU_YM`) AS NENGETSU_YM \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NENGAPPI_YMD`) AS NENGAPPI_YMD \n";
        sql += "    , a.`TIMESTAMP_TS` AS TIMESTAMP_TS \n";
        sql += "    , a.`NICHIJI_DT` AS NICHIJI_DT \n";
        sql += "    , a.`HIDUKE_BI` AS HIDUKE_BI \n";
        sql += "    , a.`JIKOKU_HM` \n";
        sql += "    , a.`JIKAN_TM` \n";
        sql += "    , a.`SURYO_QT` \n";
        sql += "    , a.`TSUKA_KB` \n";
        sql += "    , a.`JUCHU_PR` \n";
        sql += "    , a.`JUCHU_AM` \n";
        sql += "    , a.`HACHU_PR` \n";
        sql += "    , a.`HACHU_AM` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`DELETE_F`) AS DELETE_F \n";
        sql += "    , a.`STATUS_KB` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB0_ENTITY a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity_id", param1);
        return Queries.get(sql, map, Tb0Entity.class);
    }

    /**
     * エンティティ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // エンティティIDの採番処理
        numbering();

        // エンティティの登録
        String sql = "INSERT INTO TB0_ENTITY(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`ENTITY_ID` -- :entity_id");
        nameList.add("`ENTITY_NM` -- :entity_nm");
        nameList.add("`ENTITY_MEI` -- :entity_mei");
        nameList.add("`CHECK_F` -- :check_f");
        nameList.add("`RADIO_KB` -- :radio_kb");
        nameList.add("`PULLDOWN_KB` -- :pulldown_kb");
        nameList.add("`PULLDOWN_SB` -- :pulldown_sb");
        nameList.add("`MEMO_TX` -- :memo_tx");
        nameList.add("`MEMO` -- :memo");
        nameList.add("`TENPU_FILE` -- :tenpu_file");
        nameList.add("`NENGAPPI_Y` -- :nengappi_y");
        nameList.add("`NENGAPPI_M` -- :nengappi_m");
        nameList.add("`NENGAPPI_D` -- :nengappi_d");
        nameList.add("`NENGETSU_YM` -- :nengetsu_ym");
        nameList.add("`NENGAPPI_YMD` -- :nengappi_ymd");
        nameList.add("`TIMESTAMP_TS` -- :timestamp_ts");
        nameList.add("`NICHIJI_DT` -- :nichiji_dt");
        nameList.add("`HIDUKE_BI` -- :hiduke_bi");
        nameList.add("`JIKOKU_HM` -- :jikoku_hm");
        nameList.add("`JIKAN_TM` -- :jikan_tm");
        nameList.add("`SURYO_QT` -- :suryo_qt");
        nameList.add("`TSUKA_KB` -- :tsuka_kb");
        nameList.add("`JUCHU_PR` -- :juchu_pr");
        nameList.add("`JUCHU_AM` -- :juchu_am");
        nameList.add("`HACHU_PR` -- :hachu_pr");
        nameList.add("`HACHU_AM` -- :hachu_am");
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
        List<String> valueList = new ArrayList<String>();
        valueList.add(":entity_id");
        valueList.add(":entity_nm");
        valueList.add(":entity_mei");
        valueList.add(":check_f");
        valueList.add(":radio_kb");
        valueList.add(":pulldown_kb");
        valueList.add(":pulldown_sb");
        valueList.add(":memo_tx");
        valueList.add(":memo");
        valueList.add(":tenpu_file");
        valueList.add(":nengappi_y");
        valueList.add(":nengappi_m");
        valueList.add(":nengappi_d");
        valueList.add(":nengetsu_ym");
        valueList.add(":nengappi_ymd");
        valueList.add("now(3)");
        valueList.add(":nichiji_dt");
        valueList.add(":hiduke_bi");
        valueList.add(":jikoku_hm");
        valueList.add(":jikan_tm");
        valueList.add(":suryo_qt");
        valueList.add(":tsuka_kb");
        valueList.add(":juchu_pr");
        valueList.add(":juchu_am");
        valueList.add(":hachu_pr");
        valueList.add(":hachu_am");
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
        String sql = "SELECT CASE WHEN MAX(e.`ENTITY_ID`) IS NULL THEN 0 ELSE MAX(e.`ENTITY_ID`) * 1 END + 1 AS `ENTITY_ID` FROM TB0_ENTITY e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("ENTITY_ID");
        this.setEntityId(o);
    }

    /**
     * エンティティ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // エンティティの登録
        String sql = "UPDATE TB0_ENTITY\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`ENTITY_ID` = :entity_id");
        setList.add("`ENTITY_NM` = :entity_nm");
        setList.add("`ENTITY_MEI` = :entity_mei");
        setList.add("`CHECK_F` = :check_f");
        setList.add("`RADIO_KB` = :radio_kb");
        setList.add("`PULLDOWN_KB` = :pulldown_kb");
        setList.add("`PULLDOWN_SB` = :pulldown_sb");
        setList.add("`MEMO_TX` = :memo_tx");
        setList.add("`MEMO` = :memo");
        setList.add("`TENPU_FILE` = :tenpu_file");
        setList.add("`NENGAPPI_Y` = :nengappi_y");
        setList.add("`NENGAPPI_M` = :nengappi_m");
        setList.add("`NENGAPPI_D` = :nengappi_d");
        setList.add("`NENGETSU_YM` = :nengetsu_ym");
        setList.add("`NENGAPPI_YMD` = :nengappi_ymd");
        setList.add("`TIMESTAMP_TS` = :timestamp_ts");
        setList.add("`NICHIJI_DT` = :nichiji_dt");
        setList.add("`HIDUKE_BI` = :hiduke_bi");
        setList.add("`JIKOKU_HM` = :jikoku_hm");
        setList.add("`JIKAN_TM` = :jikan_tm");
        setList.add("`SURYO_QT` = :suryo_qt");
        setList.add("`TSUKA_KB` = :tsuka_kb");
        setList.add("`JUCHU_PR` = :juchu_pr");
        setList.add("`JUCHU_AM` = :juchu_am");
        setList.add("`HACHU_PR` = :hachu_pr");
        setList.add("`HACHU_AM` = :hachu_am");
        setList.add("`DELETE_F` = :delete_f");
        setList.add("`STATUS_KB` = :status_kb");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`ENTITY_ID` = :entity_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private Map<String, Object> toMap(final LocalDateTime now, final String execId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity_id", this.entityId);
        map.put("entity_nm", this.entityNm);
        map.put("entity_mei", this.entityMei);
        map.put("check_f", this.checkF);
        map.put("radio_kb", this.radioKb);
        map.put("pulldown_kb", this.pulldownKb);
        map.put("pulldown_sb", this.pulldownSb);
        map.put("memo_tx", this.memoTx);
        map.put("memo", this.memo);
        map.put("tenpu_file", this.tenpuFile);
        map.put("nengappi_y", this.nengappiY);
        map.put("nengappi_m", this.nengappiM);
        map.put("nengappi_d", this.nengappiD);
        map.put("nengetsu_ym", this.nengetsuYm);
        map.put("nengappi_ymd", this.nengappiYmd);
        map.put("timestamp_ts", this.timestampTs);
        map.put("nichiji_dt", this.nichijiDt);
        map.put("hiduke_bi", this.hidukeBi);
        map.put("jikoku_hm", this.jikokuHm);
        map.put("jikan_tm", this.jikanTm);
        map.put("suryo_qt", this.suryoQt);
        map.put("tsuka_kb", this.tsukaKb);
        map.put("juchu_pr", this.juchuPr);
        map.put("juchu_am", this.juchuAm);
        map.put("hachu_pr", this.hachuPr);
        map.put("hachu_am", this.hachuAm);
        map.put("delete_f", this.deleteF);
        map.put("status_kb", this.statusKb);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
