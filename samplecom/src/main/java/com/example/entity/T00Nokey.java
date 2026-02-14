package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 主キーなし
 * @author emarfkrow
 */
public class T00Nokey implements IEntity {

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

    /** 列Ａ */
    private String colA;

    /** @return 列Ａ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COL_A", index = 2)
    public String getColA() {
        return this.colA;
    }

    /** @param o 列Ａ */
    public void setColA(final Object o) {
        if (o != null) {
            this.colA = o.toString();
        } else {
            this.colA = null;
        }
    }

    /** 列Ｂ */
    private String colB;

    /** @return 列Ｂ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COL_B", index = 3)
    public String getColB() {
        return this.colB;
    }

    /** @param o 列Ｂ */
    public void setColB(final Object o) {
        if (o != null) {
            this.colB = o.toString();
        } else {
            this.colB = null;
        }
    }

    /** 列Ｃ */
    private String colC;

    /** @return 列Ｃ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COL_C", index = 4)
    public String getColC() {
        return this.colC;
    }

    /** @param o 列Ｃ */
    public void setColC(final Object o) {
        if (o != null) {
            this.colC = o.toString();
        } else {
            this.colC = null;
        }
    }

    /** 列Ｄ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String colD;

    /** @return 列Ｄ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COL_D", index = 5)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getColD() {
        return this.colD;
    }

    /** @param o 列Ｄ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setColD(final Object o) {
        if (o != null) {
            this.colD = o.toString();
        } else {
            this.colD = null;
        }
    }

    /** 列Ｅ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String colE;

    /** @return 列Ｅ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COL_E", index = 6)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getColE() {
        return this.colE;
    }

    /** @param o 列Ｅ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setColE(final Object o) {
        if (o != null) {
            this.colE = o.toString();
        } else {
            this.colE = null;
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
     * 主キーなし照会
     * @param param1 列Ｄ
     * @param param2 列Ｅ
     * @return 主キーなし
     */
    public static T00Nokey get(final Object param1, final Object param2) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`COL_D` = :col_d");
        whereList.add("`COL_E` = :col_e");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`COL_A` \n";
        sql += "    , a.`COL_B` \n";
        sql += "    , a.`COL_C` \n";
        sql += "    , a.`COL_D` \n";
        sql += "    , a.`COL_E` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    T00_NOKEY a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("col_d", param1);
        map.put("col_e", param2);
        return Queries.get(sql, map, T00Nokey.class);
    }

    /**
     * 主キーなし追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 主キーなしの登録
        String sql = "INSERT INTO T00_NOKEY(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`COL_A` -- :col_a");
        nameList.add("`COL_B` -- :col_b");
        nameList.add("`COL_C` -- :col_c");
        nameList.add("`COL_D` -- :col_d");
        nameList.add("`COL_E` -- :col_e");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":col_a");
        valueList.add(":col_b");
        valueList.add(":col_c");
        valueList.add(":col_d");
        valueList.add(":col_e");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 主キーなし更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 主キーなしの登録
        String sql = "UPDATE T00_NOKEY\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`COL_A` = :col_a");
        setList.add("`COL_B` = :col_b");
        setList.add("`COL_C` = :col_c");
        setList.add("`COL_D` = :col_d");
        setList.add("`COL_E` = :col_e");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 主キーなし削除
     * @return 削除件数
     */
    public int delete() {

        // 主キーなしの削除
        String sql = "DELETE FROM T00_NOKEY WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`COL_D` = :col_d");
        whereList.add("`COL_E` = :col_e");
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
        map.put("col_a", this.colA);
        map.put("col_b", this.colB);
        map.put("col_c", this.colC);
        map.put("col_d", this.colD);
        map.put("col_e", this.colE);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
