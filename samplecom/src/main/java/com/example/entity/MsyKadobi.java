package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 稼働日マスタ
 * @author emarfkrow
 */
public class MsyKadobi implements IEntity {

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

    /** 稼働日 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private java.time.LocalDate kadoBi;

    /** @return 稼働日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KADO_BI", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public java.time.LocalDate getKadoBi() {
        return this.kadoBi;
    }

    /** @param o 稼働日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKadoBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kadoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.kadoBi = null;
        }
    }

    /** 部署ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer bushoId;

    /** @return 部署ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BUSHO_ID", index = 3)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getBushoId() {
        return this.bushoId;
    }

    /** @param o 部署ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setBushoId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.bushoId = Integer.valueOf(o.toString());
        } else {
            this.bushoId = null;
        }
    }

    /** 部署ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String bushoMei;

    /** @return 部署ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BUSHO_MEI", index = 4)
    public String getBushoMei() {
        return this.bushoMei;
    }

    /** @param o 部署ID参照 */
    public void setBushoMei(final Object o) {
        if (o != null) {
            this.bushoMei = o.toString();
        } else {
            this.bushoMei = null;
        }
    }

    /** 稼働日フラグ */
    private String kadobiF = "0";

    /** @return 稼働日フラグ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KADOBI_F", index = 5)
    public String getKadobiF() {
        return this.kadobiF;
    }

    /** @param o 稼働日フラグ */
    public void setKadobiF(final Object o) {
        if (o != null) {
            this.kadobiF = o.toString();
        } else {
            this.kadobiF = null;
        }
    }

    /** メモ */
    private String memo;

    /** @return メモ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MEMO", index = 6)
    public String getMemo() {
        return this.memo;
    }

    /** @param o メモ */
    public void setMemo(final Object o) {
        if (o != null) {
            this.memo = o.toString();
        } else {
            this.memo = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 12)
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
     * 稼働日マスタ照会
     * @param param1 稼働日
     * @param param2 部署ID
     * @return 稼働日マスタ
     */
    public static MsyKadobi get(final Object param1, final Object param2) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KADO_BI` = :kado_bi");
        whereList.add("`BUSHO_ID` = :busho_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`KADO_BI` AS KADO_BI \n";
        sql += "    , a.`BUSHO_ID` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`KADOBI_F`) AS KADOBI_F \n";
        sql += "    , a.`MEMO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    MSY_KADOBI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("kado_bi", param1);
        map.put("busho_id", param2);
        return Queries.get(sql, map, MsyKadobi.class);
    }

    /**
     * 稼働日マスタ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 稼働日マスタの登録
        String sql = "INSERT INTO MSY_KADOBI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`KADO_BI` -- :kado_bi");
        nameList.add("`BUSHO_ID` -- :busho_id");
        nameList.add("`KADOBI_F` -- :kadobi_f");
        nameList.add("`MEMO` -- :memo");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":kado_bi");
        valueList.add(":busho_id");
        valueList.add(":kadobi_f");
        valueList.add(":memo");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 稼働日マスタ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 稼働日マスタの登録
        String sql = "UPDATE MSY_KADOBI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`KADO_BI` = :kado_bi");
        setList.add("`BUSHO_ID` = :busho_id");
        setList.add("`KADOBI_F` = :kadobi_f");
        setList.add("`MEMO` = :memo");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 稼働日マスタ削除
     * @return 削除件数
     */
    public int delete() {

        // 稼働日マスタの削除
        String sql = "DELETE FROM MSY_KADOBI WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KADO_BI` = :kado_bi");
        whereList.add("`BUSHO_ID` = :busho_id");
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
        map.put("kado_bi", this.kadoBi);
        map.put("busho_id", this.bushoId);
        map.put("kadobi_f", this.kadobiF);
        map.put("memo", this.memo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
