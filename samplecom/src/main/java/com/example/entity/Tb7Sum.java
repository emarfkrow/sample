package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 集約
 * @author emarfkrow
 */
public class Tb7Sum implements IEntity {

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

    /** 集約ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer sumId;

    /** @return 集約ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getSumId() {
        return this.sumId;
    }

    /** @param o 集約ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setSumId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.sumId = Integer.valueOf(o.toString());
        } else {
            this.sumId = null;
        }
    }

    /** 集約情報 */
    private String sumInfo;

    /** @return 集約情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM_INFO", index = 3)
    public String getSumInfo() {
        return this.sumInfo;
    }

    /** @param o 集約情報 */
    public void setSumInfo(final Object o) {
        if (o != null) {
            this.sumInfo = o.toString();
        } else {
            this.sumInfo = null;
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
     * 集約照会
     * @param param1 集約ID
     * @return 集約
     */
    public static Tb7Sum get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`SUM_ID` = :sum_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`SUM_ID` \n";
        sql += "    , a.`SUM_INFO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB7_SUM a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sum_id", param1);
        return Queries.get(sql, map, Tb7Sum.class);
    }

    /**
     * 集約追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 集約IDの採番処理
        numbering();

        // 集約の登録
        String sql = "INSERT INTO TB7_SUM(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`SUM_ID` -- :sum_id");
        nameList.add("`SUM_INFO` -- :sum_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":sum_id");
        valueList.add(":sum_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 集約IDの採番処理 */
    private void numbering() {
        if (this.sumId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`SUM_ID`) IS NULL THEN 0 ELSE MAX(e.`SUM_ID`) * 1 END + 1 AS `SUM_ID` FROM TB7_SUM e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("SUM_ID");
        this.setSumId(o);
    }

    /**
     * 集約更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 集約の登録
        String sql = "UPDATE TB7_SUM\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`SUM_ID` = :sum_id");
        setList.add("`SUM_INFO` = :sum_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 集約削除
     * @return 削除件数
     */
    public int delete() {

        // 集約の削除
        String sql = "DELETE FROM TB7_SUM WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`SUM_ID` = :sum_id");
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
        map.put("sum_id", this.sumId);
        map.put("sum_info", this.sumInfo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 集約元：単位１
     */

    /** 単位１のリスト */
    private List<Tb7Unit1> tb7Unit1s;

    /** @return 単位１のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb7Unit1s", index = 10)
    public List<Tb7Unit1> getTb7Unit1s() {
        return this.tb7Unit1s;
    }

    /** @param list 単位１のリスト */
    public void setTb7Unit1s(final List<Tb7Unit1> list) {
        this.tb7Unit1s = list;
    }

    /** @param tb7Unit1 */
    public void addTb7Unit1s(final Tb7Unit1 tb7Unit1) {
        if (this.tb7Unit1s == null) {
            this.tb7Unit1s = new ArrayList<Tb7Unit1>();
        }
        this.tb7Unit1s.add(tb7Unit1);
    }

    /** @return 単位１のリスト */
    public List<Tb7Unit1> referTb7Unit1s() {
        this.tb7Unit1s = Tb7Sum.referTb7Unit1s(this.sumId);
        return this.tb7Unit1s;
    }

    /**
     * @param param1 sumId
     * @return List<Tb7Unit1>
     */
    public static List<Tb7Unit1> referTb7Unit1s(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("SUM_ID = :sum_id");
        String sql = "SELECT ";
        sql += "`UNIT1_ID`";
        sql += ", `SUM_ID`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB7_UNIT1 a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "UNIT1_ID";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sum_id", param1);
        List<Tb7Unit1> list = Queries.select(sql, map, Tb7Unit1.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb7Unit1>();
    }

    /*
     * 集約元：単位２
     */

    /** 単位２のリスト */
    private List<Tb7Unit2> tb7Unit2s;

    /** @return 単位２のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb7Unit2s", index = 11)
    public List<Tb7Unit2> getTb7Unit2s() {
        return this.tb7Unit2s;
    }

    /** @param list 単位２のリスト */
    public void setTb7Unit2s(final List<Tb7Unit2> list) {
        this.tb7Unit2s = list;
    }

    /** @param tb7Unit2 */
    public void addTb7Unit2s(final Tb7Unit2 tb7Unit2) {
        if (this.tb7Unit2s == null) {
            this.tb7Unit2s = new ArrayList<Tb7Unit2>();
        }
        this.tb7Unit2s.add(tb7Unit2);
    }

    /** @return 単位２のリスト */
    public List<Tb7Unit2> referTb7Unit2s() {
        this.tb7Unit2s = Tb7Sum.referTb7Unit2s(this.sumId);
        return this.tb7Unit2s;
    }

    /**
     * @param param1 sumId
     * @return List<Tb7Unit2>
     */
    public static List<Tb7Unit2> referTb7Unit2s(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("SUM_ID = :sum_id");
        String sql = "SELECT ";
        sql += "`UNIT2_ID`";
        sql += ", `SUM_ID`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB7_UNIT2 a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "UNIT2_ID";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sum_id", param1);
        List<Tb7Unit2> list = Queries.select(sql, map, Tb7Unit2.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb7Unit2>();
    }
}
