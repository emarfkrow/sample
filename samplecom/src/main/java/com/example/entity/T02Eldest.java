package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 長兄
 * @author emarfkrow
 */
public class T02Eldest implements IEntity {

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

    /** 兄弟ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer broId;

    /** @return 兄弟ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BRO_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getBroId() {
        return this.broId;
    }

    /** @param o 兄弟ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setBroId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.broId = Integer.valueOf(o.toString());
        } else {
            this.broId = null;
        }
    }

    /** 長兄情報 */
    private String eldestInfo;

    /** @return 長兄情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ELDEST_INFO", index = 3)
    public String getEldestInfo() {
        return this.eldestInfo;
    }

    /** @param o 長兄情報 */
    public void setEldestInfo(final Object o) {
        if (o != null) {
            this.eldestInfo = o.toString();
        } else {
            this.eldestInfo = null;
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
     * 長兄照会
     * @param param1 兄弟ID
     * @return 長兄
     */
    public static T02Eldest get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`BRO_ID` = :bro_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`BRO_ID` \n";
        sql += "    , a.`ELDEST_INFO` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    T02_ELDEST a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bro_id", param1);
        return Queries.get(sql, map, T02Eldest.class);
    }

    /**
     * 長兄追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 兄弟IDの採番処理
        numbering();

        // 弟の登録
        if (this.t02Younger != null) {
            this.t02Younger.setBroId(this.getBroId());
            this.t02Younger.insert(now, execId);
        }

        // 末弟の登録
        if (this.t02Youngest != null) {
            this.t02Youngest.setBroId(this.getBroId());
            this.t02Youngest.insert(now, execId);
        }

        // 長兄の登録
        String sql = "INSERT INTO T02_ELDEST(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`BRO_ID` -- :bro_id");
        nameList.add("`ELDEST_INFO` -- :eldest_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":bro_id");
        valueList.add(":eldest_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 兄弟IDの採番処理 */
    private void numbering() {
        if (this.broId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`BRO_ID`) IS NULL THEN 0 ELSE MAX(e.`BRO_ID`) * 1 END + 1 AS `BRO_ID` FROM T02_ELDEST e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("BRO_ID");
        this.setBroId(o);
    }

    /**
     * 長兄更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 弟の登録
        if (this.t02Younger != null) {
            t02Younger.setBroId(this.getBroId());
            try {
                t02Younger.insert(now, execId);
            } catch (Exception e) {
                t02Younger.update(now, execId);
            }
        }

        // 末弟の登録
        if (this.t02Youngest != null) {
            t02Youngest.setBroId(this.getBroId());
            try {
                t02Youngest.insert(now, execId);
            } catch (Exception e) {
                t02Youngest.update(now, execId);
            }
        }

        // 長兄の登録
        String sql = "UPDATE T02_ELDEST\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`BRO_ID` = :bro_id");
        setList.add("`ELDEST_INFO` = :eldest_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 長兄削除
     * @return 削除件数
     */
    public int delete() {

        // 長兄の削除
        String sql = "DELETE FROM T02_ELDEST WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`BRO_ID` = :bro_id");
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
        map.put("bro_id", this.broId);
        map.put("eldest_info", this.eldestInfo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /** 兄弟：弟 */
    private T02Younger t02Younger;

    /** @return 弟 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Younger", index = 10)
    public T02Younger getT02Younger() {
        return this.t02Younger;
    }

    /** @param p 弟 */
    public void setT02Younger(final T02Younger p) {
        this.t02Younger = p;
    }

    /** @return 弟 */
    public T02Younger referT02Younger() {
        if (this.t02Younger == null) {
            try {
                this.t02Younger = T02Younger.get(this.broId);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t02Younger;
    }

    /** 兄弟：末弟 */
    private T02Youngest t02Youngest;

    /** @return 末弟 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Youngest", index = 11)
    public T02Youngest getT02Youngest() {
        return this.t02Youngest;
    }

    /** @param p 末弟 */
    public void setT02Youngest(final T02Youngest p) {
        this.t02Youngest = p;
    }

    /** @return 末弟 */
    public T02Youngest referT02Youngest() {
        if (this.t02Youngest == null) {
            try {
                this.t02Youngest = T02Youngest.get(this.broId);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t02Youngest;
    }
}
