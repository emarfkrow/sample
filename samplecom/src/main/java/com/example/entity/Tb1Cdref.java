package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * CD参照マスタ
 * @author emarfkrow
 */
public class Tb1Cdref implements IEntity {

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

    /** 参照CD */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String cdrefCd;

    /** @return 参照CD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CDREF_CD", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getCdrefCd() {
        return this.cdrefCd;
    }

    /** @param o 参照CD */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setCdrefCd(final Object o) {
        if (o != null) {
            this.cdrefCd = o.toString();
        } else {
            this.cdrefCd = null;
        }
    }

    /** 参照CD名 */
    private String cdrefMei;

    /** @return 参照CD名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CDREF_MEI", index = 3)
    public String getCdrefMei() {
        return this.cdrefMei;
    }

    /** @param o 参照CD名 */
    public void setCdrefMei(final Object o) {
        if (o != null) {
            this.cdrefMei = o.toString();
        } else {
            this.cdrefMei = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 4)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 5)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 9)
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
     * CD参照マスタ照会
     * @param param1 参照CD
     * @return CD参照マスタ
     */
    public static Tb1Cdref get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("TRIM(TRAILING ' ' FROM `CDREF_CD`) = TRIM(TRAILING ' ' FROM :cdref_cd)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      TRIM(TRAILING ' ' FROM a.`CDREF_CD`) AS CDREF_CD \n";
        sql += "    , a.`CDREF_MEI` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB1_CDREF a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cdref_cd", param1);
        return Queries.get(sql, map, Tb1Cdref.class);
    }

    /**
     * CD参照マスタ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // CD参照マスタの登録
        String sql = "INSERT INTO TB1_CDREF(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`CDREF_CD` -- :cdref_cd");
        nameList.add("`CDREF_MEI` -- :cdref_mei");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":cdref_cd");
        valueList.add(":cdref_mei");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * CD参照マスタ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // CD参照マスタの登録
        String sql = "UPDATE TB1_CDREF\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`CDREF_CD` = :cdref_cd");
        setList.add("`CDREF_MEI` = :cdref_mei");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * CD参照マスタ削除
     * @return 削除件数
     */
    public int delete() {

        // CD参照マスタの削除
        String sql = "DELETE FROM TB1_CDREF WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("TRIM(TRAILING ' ' FROM `CDREF_CD`) = TRIM(TRAILING ' ' FROM :cdref_cd)");
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
        map.put("cdref_cd", this.cdrefCd);
        map.put("cdref_mei", this.cdrefMei);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
