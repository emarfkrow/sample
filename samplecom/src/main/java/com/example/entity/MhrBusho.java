package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 部署マスタ
 * @author emarfkrow
 */
public class MhrBusho implements IEntity {

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

    /** 部署ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer bushoId;

    /** @return 部署ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BUSHO_ID", index = 2)
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

    /** 部署名 */
    private String bushoMei;

    /** @return 部署名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BUSHO_MEI", index = 3)
    public String getBushoMei() {
        return this.bushoMei;
    }

    /** @param o 部署名 */
    public void setBushoMei(final Object o) {
        if (o != null) {
            this.bushoMei = o.toString();
        } else {
            this.bushoMei = null;
        }
    }

    /** 親部署ID */
    private Integer oyaBushoId;

    /** @return 親部署ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_BUSHO_ID", index = 4)
    public Integer getOyaBushoId() {
        return this.oyaBushoId;
    }

    /** @param o 親部署ID */
    public void setOyaBushoId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaBushoId = Integer.valueOf(o.toString());
        } else {
            this.oyaBushoId = null;
        }
    }

    /** 親部署ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String oyaBushoMei;

    /** @return 親部署ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_BUSHO_MEI", index = 5)
    public String getOyaBushoMei() {
        return this.oyaBushoMei;
    }

    /** @param o 親部署ID参照 */
    public void setOyaBushoMei(final Object o) {
        if (o != null) {
            this.oyaBushoMei = o.toString();
        } else {
            this.oyaBushoMei = null;
        }
    }

    /** 適用日 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate tekiyoBi;

    /** @return 適用日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TEKIYO_BI", index = 6)
    public java.time.LocalDate getTekiyoBi() {
        return this.tekiyoBi;
    }

    /** @param o 適用日 */
    public void setTekiyoBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.tekiyoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.tekiyoBi = null;
        }
    }

    /** 廃止日 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate haishiBi;

    /** @return 廃止日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HAISHI_BI", index = 7)
    public java.time.LocalDate getHaishiBi() {
        return this.haishiBi;
    }

    /** @param o 廃止日 */
    public void setHaishiBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.haishiBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.haishiBi = null;
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
     * 部署マスタ照会
     * @param param1 部署ID
     * @return 部署マスタ
     */
    public static MhrBusho get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`BUSHO_ID` = :busho_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`BUSHO_ID` \n";
        sql += "    , a.`BUSHO_MEI` \n";
        sql += "    , a.`OYA_BUSHO_ID` \n";
        sql += "    , a.`TEKIYO_BI` AS TEKIYO_BI \n";
        sql += "    , a.`HAISHI_BI` AS HAISHI_BI \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    MHR_BUSHO a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("busho_id", param1);
        return Queries.get(sql, map, MhrBusho.class);
    }

    /**
     * 部署マスタ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 部署IDの採番処理
        numbering();

        // 部署マスタの登録
        String sql = "INSERT INTO MHR_BUSHO(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`BUSHO_ID` -- :busho_id");
        nameList.add("`BUSHO_MEI` -- :busho_mei");
        nameList.add("`OYA_BUSHO_ID` -- :oya_busho_id");
        nameList.add("`TEKIYO_BI` -- :tekiyo_bi");
        nameList.add("`HAISHI_BI` -- :haishi_bi");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":busho_id");
        valueList.add(":busho_mei");
        valueList.add(":oya_busho_id");
        valueList.add(":tekiyo_bi");
        valueList.add(":haishi_bi");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 部署IDの採番処理 */
    private void numbering() {
        if (this.bushoId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`BUSHO_ID`) IS NULL THEN 0 ELSE MAX(e.`BUSHO_ID`) * 1 END + 1 AS `BUSHO_ID` FROM MHR_BUSHO e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("BUSHO_ID");
        this.setBushoId(o);
    }

    /**
     * 部署マスタ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 部署マスタの登録
        String sql = "UPDATE MHR_BUSHO\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`BUSHO_ID` = :busho_id");
        setList.add("`BUSHO_MEI` = :busho_mei");
        setList.add("`OYA_BUSHO_ID` = :oya_busho_id");
        setList.add("`TEKIYO_BI` = :tekiyo_bi");
        setList.add("`HAISHI_BI` = :haishi_bi");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 部署マスタ削除
     * @return 削除件数
     */
    public int delete() {

        // 部署マスタの削除
        String sql = "DELETE FROM MHR_BUSHO WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
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
        map.put("busho_id", this.bushoId);
        map.put("busho_mei", this.bushoMei);
        map.put("oya_busho_id", this.oyaBushoId);
        map.put("tekiyo_bi", this.tekiyoBi);
        map.put("haishi_bi", this.haishiBi);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
