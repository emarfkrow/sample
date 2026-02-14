package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 共生
 * @author emarfkrow
 */
public class T08Kyosei implements IEntity {

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

    /** 共生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer kyoseiId;

    /** @return 共生ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KYOSEI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getKyoseiId() {
        return this.kyoseiId;
    }

    /** @param o 共生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKyoseiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kyoseiId = Integer.valueOf(o.toString());
        } else {
            this.kyoseiId = null;
        }
    }

    /** 寄生１ID */
    private Integer kisei1Id;

    /** @return 寄生１ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI1_ID", index = 3)
    public Integer getKisei1Id() {
        return this.kisei1Id;
    }

    /** @param o 寄生１ID */
    public void setKisei1Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kisei1Id = Integer.valueOf(o.toString());
        } else {
            this.kisei1Id = null;
        }
    }

    /** 寄生１情報 */
    private String kisei1Info;

    /** @return 寄生１情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI1_INFO", index = 4)
    public String getKisei1Info() {
        return this.kisei1Info;
    }

    /** @param o 寄生１情報 */
    public void setKisei1Info(final Object o) {
        if (o != null) {
            this.kisei1Info = o.toString();
        } else {
            this.kisei1Info = null;
        }
    }

    /** 寄生２ID */
    private Integer kisei2Id;

    /** @return 寄生２ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI2_ID", index = 5)
    public Integer getKisei2Id() {
        return this.kisei2Id;
    }

    /** @param o 寄生２ID */
    public void setKisei2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kisei2Id = Integer.valueOf(o.toString());
        } else {
            this.kisei2Id = null;
        }
    }

    /** 寄生２情報 */
    private String kisei2Info;

    /** @return 寄生２情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI2_INFO", index = 6)
    public String getKisei2Info() {
        return this.kisei2Info;
    }

    /** @param o 寄生２情報 */
    public void setKisei2Info(final Object o) {
        if (o != null) {
            this.kisei2Info = o.toString();
        } else {
            this.kisei2Info = null;
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
     * 共生照会
     * @param param1 共生ID
     * @return 共生
     */
    public static T08Kyosei get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KYOSEI_ID` = :kyosei_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`KYOSEI_ID` \n";
        sql += "    , a.`KISEI1_ID` \n";
        sql += "    , a.`KISEI1_INFO` \n";
        sql += "    , a.`KISEI2_ID` \n";
        sql += "    , a.`KISEI2_INFO` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    T08_KYOSEI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("kyosei_id", param1);
        return Queries.get(sql, map, T08Kyosei.class);
    }

    /**
     * 共生追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 共生IDの採番処理
        numbering();

        // 共生の登録
        String sql = "INSERT INTO T08_KYOSEI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`KYOSEI_ID` -- :kyosei_id");
        nameList.add("`KISEI1_ID` -- :kisei_1_id");
        nameList.add("`KISEI1_INFO` -- :kisei_1_info");
        nameList.add("`KISEI2_ID` -- :kisei_2_id");
        nameList.add("`KISEI2_INFO` -- :kisei_2_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":kyosei_id");
        valueList.add(":kisei_1_id");
        valueList.add(":kisei_1_info");
        valueList.add(":kisei_2_id");
        valueList.add(":kisei_2_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 共生IDの採番処理 */
    private void numbering() {
        if (this.kyoseiId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`KYOSEI_ID`) IS NULL THEN 0 ELSE MAX(e.`KYOSEI_ID`) * 1 END + 1 AS `KYOSEI_ID` FROM T08_KYOSEI e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("KYOSEI_ID");
        this.setKyoseiId(o);
    }

    /**
     * 共生更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 共生の登録
        String sql = "UPDATE T08_KYOSEI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`KYOSEI_ID` = :kyosei_id");
        setList.add("`KISEI1_ID` = :kisei_1_id");
        setList.add("`KISEI1_INFO` = :kisei_1_info");
        setList.add("`KISEI2_ID` = :kisei_2_id");
        setList.add("`KISEI2_INFO` = :kisei_2_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 共生削除
     * @return 削除件数
     */
    public int delete() {

        // 共生の削除
        String sql = "DELETE FROM T08_KYOSEI WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KYOSEI_ID` = :kyosei_id");
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
        map.put("kyosei_id", this.kyoseiId);
        map.put("kisei_1_id", this.kisei1Id);
        map.put("kisei_1_info", this.kisei1Info);
        map.put("kisei_2_id", this.kisei2Id);
        map.put("kisei_2_info", this.kisei2Info);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
