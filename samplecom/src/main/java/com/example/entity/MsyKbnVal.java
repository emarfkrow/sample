package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 区分値マスタ
 * @author emarfkrow
 */
public class MsyKbnVal implements IEntity {

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

    /** 区分名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kbnNm;

    /** @return 区分名称 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_NM", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKbnNm() {
        return this.kbnNm;
    }

    /** @param o 区分名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKbnNm(final Object o) {
        if (o != null) {
            this.kbnNm = o.toString();
        } else {
            this.kbnNm = null;
        }
    }

    /** 区分名称参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String kbnMei;

    /** @return 区分名称参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_MEI", index = 3)
    public String getKbnMei() {
        return this.kbnMei;
    }

    /** @param o 区分名称参照 */
    public void setKbnMei(final Object o) {
        if (o != null) {
            this.kbnMei = o.toString();
        } else {
            this.kbnMei = null;
        }
    }

    /** 区分値 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kbnVal;

    /** @return 区分値 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_VAL", index = 4)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKbnVal() {
        return this.kbnVal;
    }

    /** @param o 区分値 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKbnVal(final Object o) {
        if (o != null) {
            this.kbnVal = o.toString();
        } else {
            this.kbnVal = null;
        }
    }

    /** 区分値名 */
    private String kbnValMei;

    /** @return 区分値名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_VAL_MEI", index = 5)
    public String getKbnValMei() {
        return this.kbnValMei;
    }

    /** @param o 区分値名 */
    public void setKbnValMei(final Object o) {
        if (o != null) {
            this.kbnValMei = o.toString();
        } else {
            this.kbnValMei = null;
        }
    }

    /** 表示順 */
    private Integer hyojiOn;

    /** @return 表示順 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HYOJI_ON", index = 6)
    public Integer getHyojiOn() {
        return this.hyojiOn;
    }

    /** @param o 表示順 */
    public void setHyojiOn(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.hyojiOn = Integer.valueOf(o.toString());
        } else {
            this.hyojiOn = null;
        }
    }

    /** 取得条件 */
    private String criteria;

    /** @return 取得条件 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CRITERIA", index = 7)
    public String getCriteria() {
        return this.criteria;
    }

    /** @param o 取得条件 */
    public void setCriteria(final Object o) {
        if (o != null) {
            this.criteria = o.toString();
        } else {
            this.criteria = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 12)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 13)
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
     * 区分値マスタ照会
     * @param param1 区分名称
     * @param param2 区分値
     * @return 区分値マスタ
     */
    public static MsyKbnVal get(final Object param1, final Object param2) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KBN_NM` = :kbn_nm");
        whereList.add("`KBN_VAL` = :kbn_val");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`KBN_NM` \n";
        sql += "    , a.`KBN_VAL` \n";
        sql += "    , a.`KBN_VAL_MEI` \n";
        sql += "    , a.`HYOJI_ON` \n";
        sql += "    , a.`CRITERIA` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    MSY_KBN_VAL a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("kbn_nm", param1);
        map.put("kbn_val", param2);
        return Queries.get(sql, map, MsyKbnVal.class);
    }

    /**
     * 区分値マスタ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 区分値マスタの登録
        String sql = "INSERT INTO MSY_KBN_VAL(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`KBN_NM` -- :kbn_nm");
        nameList.add("`KBN_VAL` -- :kbn_val");
        nameList.add("`KBN_VAL_MEI` -- :kbn_val_mei");
        nameList.add("`HYOJI_ON` -- :hyoji_on");
        nameList.add("`CRITERIA` -- :criteria");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":kbn_nm");
        valueList.add(":kbn_val");
        valueList.add(":kbn_val_mei");
        valueList.add(":hyoji_on");
        valueList.add(":criteria");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 区分値マスタ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 区分値マスタの登録
        String sql = "UPDATE MSY_KBN_VAL\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`KBN_NM` = :kbn_nm");
        setList.add("`KBN_VAL` = :kbn_val");
        setList.add("`KBN_VAL_MEI` = :kbn_val_mei");
        setList.add("`HYOJI_ON` = :hyoji_on");
        setList.add("`CRITERIA` = :criteria");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 区分値マスタ削除
     * @return 削除件数
     */
    public int delete() {

        // 区分値マスタの削除
        String sql = "DELETE FROM MSY_KBN_VAL WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KBN_NM` = :kbn_nm");
        whereList.add("`KBN_VAL` = :kbn_val");
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
        map.put("kbn_nm", this.kbnNm);
        map.put("kbn_val", this.kbnVal);
        map.put("kbn_val_mei", this.kbnValMei);
        map.put("hyoji_on", this.hyojiOn);
        map.put("criteria", this.criteria);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
