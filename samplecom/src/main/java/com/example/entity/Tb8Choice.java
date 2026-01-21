package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 選抜
 * @author emarfkrow
 */
public class Tb8Choice implements IEntity {

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

    /** 選抜ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer choiceId;

    /** @return 選抜ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CHOICE_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getChoiceId() {
        return this.choiceId;
    }

    /** @param o 選抜ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setChoiceId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.choiceId = Integer.valueOf(o.toString());
        } else {
            this.choiceId = null;
        }
    }

    /** 集約ID */
    private Integer sumId;

    /** @return 集約ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM_ID", index = 3)
    public Integer getSumId() {
        return this.sumId;
    }

    /** @param o 集約ID */
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM_INFO", index = 4)
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

    /** 集約２ID */
    private Integer sum2Id;

    /** @return 集約２ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM2_ID", index = 5)
    public Integer getSum2Id() {
        return this.sum2Id;
    }

    /** @param o 集約２ID */
    public void setSum2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.sum2Id = Integer.valueOf(o.toString());
        } else {
            this.sum2Id = null;
        }
    }

    /** 集約２情報 */
    private String sum2Info;

    /** @return 集約２情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM2_INFO", index = 6)
    public String getSum2Info() {
        return this.sum2Info;
    }

    /** @param o 集約２情報 */
    public void setSum2Info(final Object o) {
        if (o != null) {
            this.sum2Info = o.toString();
        } else {
            this.sum2Info = null;
        }
    }

    /** 集約３ID */
    private Integer sum3Id;

    /** @return 集約３ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM3_ID", index = 7)
    public Integer getSum3Id() {
        return this.sum3Id;
    }

    /** @param o 集約３ID */
    public void setSum3Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.sum3Id = Integer.valueOf(o.toString());
        } else {
            this.sum3Id = null;
        }
    }

    /** 集約３情報 */
    private String sum3Info;

    /** @return 集約３情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SUM3_INFO", index = 8)
    public String getSum3Info() {
        return this.sum3Info;
    }

    /** @param o 集約３情報 */
    public void setSum3Info(final Object o) {
        if (o != null) {
            this.sum3Info = o.toString();
        } else {
            this.sum3Info = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 12)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 13)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 14)
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
     * 選抜照会
     * @param param1 選抜ID
     * @return 選抜
     */
    public static Tb8Choice get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`CHOICE_ID` = :choice_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`CHOICE_ID` \n";
        sql += "    , a.`SUM_ID` \n";
        sql += "    , a.`SUM_INFO` \n";
        sql += "    , a.`SUM2_ID` \n";
        sql += "    , a.`SUM2_INFO` \n";
        sql += "    , a.`SUM3_ID` \n";
        sql += "    , a.`SUM3_INFO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB8_CHOICE a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("choice_id", param1);
        return Queries.get(sql, map, Tb8Choice.class);
    }

    /**
     * 選抜追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 選抜IDの採番処理
        numbering();

        // 選抜の登録
        String sql = "INSERT INTO TB8_CHOICE(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`CHOICE_ID` -- :choice_id");
        nameList.add("`SUM_ID` -- :sum_id");
        nameList.add("`SUM_INFO` -- :sum_info");
        nameList.add("`SUM2_ID` -- :sum_2_id");
        nameList.add("`SUM2_INFO` -- :sum_2_info");
        nameList.add("`SUM3_ID` -- :sum_3_id");
        nameList.add("`SUM3_INFO` -- :sum_3_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":choice_id");
        valueList.add(":sum_id");
        valueList.add(":sum_info");
        valueList.add(":sum_2_id");
        valueList.add(":sum_2_info");
        valueList.add(":sum_3_id");
        valueList.add(":sum_3_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 選抜IDの採番処理 */
    private void numbering() {
        if (this.choiceId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`CHOICE_ID`) IS NULL THEN 0 ELSE MAX(e.`CHOICE_ID`) * 1 END + 1 AS `CHOICE_ID` FROM TB8_CHOICE e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("CHOICE_ID");
        this.setChoiceId(o);
    }

    /**
     * 選抜更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 選抜の登録
        String sql = "UPDATE TB8_CHOICE\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`CHOICE_ID` = :choice_id");
        setList.add("`SUM_ID` = :sum_id");
        setList.add("`SUM_INFO` = :sum_info");
        setList.add("`SUM2_ID` = :sum_2_id");
        setList.add("`SUM2_INFO` = :sum_2_info");
        setList.add("`SUM3_ID` = :sum_3_id");
        setList.add("`SUM3_INFO` = :sum_3_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 選抜削除
     * @return 削除件数
     */
    public int delete() {

        // 選抜の削除
        String sql = "DELETE FROM TB8_CHOICE WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`CHOICE_ID` = :choice_id");
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
        map.put("choice_id", this.choiceId);
        map.put("sum_id", this.sumId);
        map.put("sum_info", this.sumInfo);
        map.put("sum_2_id", this.sum2Id);
        map.put("sum_2_info", this.sum2Info);
        map.put("sum_3_id", this.sum3Id);
        map.put("sum_3_info", this.sum3Info);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
