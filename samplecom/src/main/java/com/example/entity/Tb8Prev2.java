package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 前世２
 * @author emarfkrow
 */
public class Tb8Prev2 implements IEntity {

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

    /** 前世２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer prev2Id;

    /** @return 前世２ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PREV2_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getPrev2Id() {
        return this.prev2Id;
    }

    /** @param o 前世２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setPrev2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.prev2Id = Integer.valueOf(o.toString());
        } else {
            this.prev2Id = null;
        }
    }

    /** 前世２情報 */
    private String prev2Info;

    /** @return 前世２情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PREV2_INFO", index = 3)
    public String getPrev2Info() {
        return this.prev2Info;
    }

    /** @param o 前世２情報 */
    public void setPrev2Info(final Object o) {
        if (o != null) {
            this.prev2Info = o.toString();
        } else {
            this.prev2Info = null;
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
     * 前世２照会
     * @param param1 前世２ID
     * @return 前世２
     */
    public static Tb8Prev2 get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`PREV2_ID` = :prev_2_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`PREV2_ID` \n";
        sql += "    , a.`PREV2_INFO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB8_PREV2 a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("prev_2_id", param1);
        return Queries.get(sql, map, Tb8Prev2.class);
    }

    /**
     * 前世２追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 前世２IDの採番処理
        numbering();

        // 前世２の登録
        String sql = "INSERT INTO TB8_PREV2(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`PREV2_ID` -- :prev_2_id");
        nameList.add("`PREV2_INFO` -- :prev_2_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":prev_2_id");
        valueList.add(":prev_2_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 前世２IDの採番処理 */
    private void numbering() {
        if (this.prev2Id != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`PREV2_ID`) IS NULL THEN 0 ELSE MAX(e.`PREV2_ID`) * 1 END + 1 AS `PREV2_ID` FROM TB8_PREV2 e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("PREV2_ID");
        this.setPrev2Id(o);
    }

    /**
     * 前世２更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 前世２の登録
        String sql = "UPDATE TB8_PREV2\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`PREV2_ID` = :prev_2_id");
        setList.add("`PREV2_INFO` = :prev_2_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 前世２削除
     * @return 削除件数
     */
    public int delete() {

        // 前世２の削除
        String sql = "DELETE FROM TB8_PREV2 WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`PREV2_ID` = :prev_2_id");
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
        map.put("prev_2_id", this.prev2Id);
        map.put("prev_2_info", this.prev2Info);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 転生先：集約２
     */

    /** 集約２のリスト */
    private List<Tb8Sum2> tb8Sum2s;

    /** @return 集約２のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb8Sum2s", index = 10)
    public List<Tb8Sum2> getTb8Sum2s() {
        return this.tb8Sum2s;
    }

    /** @param list 集約２のリスト */
    public void setTb8Sum2s(final List<Tb8Sum2> list) {
        this.tb8Sum2s = list;
    }

    /** @param tb8Sum2 */
    public void addTb8Sum2s(final Tb8Sum2 tb8Sum2) {
        if (this.tb8Sum2s == null) {
            this.tb8Sum2s = new ArrayList<Tb8Sum2>();
        }
        this.tb8Sum2s.add(tb8Sum2);
    }

    /** @return 集約２のリスト */
    public List<Tb8Sum2> referTb8Sum2s() {
        this.tb8Sum2s = Tb8Prev2.referTb8Sum2s(this.prev2Id);
        return this.tb8Sum2s;
    }

    /**
     * @param param1 prev2Id
     * @return List<Tb8Sum2>
     */
    public static List<Tb8Sum2> referTb8Sum2s(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("PREV2_ID = :prev_2_id");
        String sql = "SELECT ";
        sql += "`SUM2_ID`";
        sql += ", `SUM2_INFO`";
        sql += ", `PREV2_ID`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB8_SUM2 a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "SUM2_ID";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("prev_2_id", param1);
        List<Tb8Sum2> list = Queries.select(sql, map, Tb8Sum2.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb8Sum2>();
    }
}
