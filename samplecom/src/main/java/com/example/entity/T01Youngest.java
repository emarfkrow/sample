package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T01_YOUNGEST
 * @author emarfkrow
 */
public class T01Youngest implements IEntity {

    /** デフォルトコンストラクタ */
    public T01Youngest() {
    }

    /** @param values */
    public T01Youngest(final String[] values) {
        this.setBroId(values[0]);
        this.setYoungestInfo(values[1]);
        this.setInsertTs(values[2]);
        this.setInsertUserId(values[3]);
        this.setUpdateTs(values[4]);
        this.setUpdateUserId(values[5]);
    }

    /** @param map */
    public T01Youngest(final java.util.Map<String, Object> map) {
        this.setBroId(IgnoreCaseLinkedMap.get(map, "BRO_ID"));
        this.setYoungestInfo(IgnoreCaseLinkedMap.get(map, "YOUNGEST_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.broId)) {
            isNew = true;
        }
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.updateTs)) {
            isNew = true;
        }
        return isNew;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.youngestInfo == null || this.youngestInfo.toString().replaceAll("　| ", "").equals("");
        return isEmpty;
    }

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

    /** BRO_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer broId;

    /** @return BRO_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BRO_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getBroId() {
        return this.broId;
    }

    /** @param o BRO_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setBroId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.broId = Integer.valueOf(o.toString());
        } else {
            this.broId = null;
        }
    }

    /** YOUNGEST_INFO */
    private String youngestInfo;

    /** @return YOUNGEST_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "YOUNGEST_INFO", index = 3)
    public String getYoungestInfo() {
        return this.youngestInfo;
    }

    /** @param o YOUNGEST_INFO */
    public void setYoungestInfo(final Object o) {
        if (o != null) {
            this.youngestInfo = o.toString();
        } else {
            this.youngestInfo = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 4)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o INSERT_TS */
    public void setInsertTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.insertTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** INSERT_USER_ID */
    private String insertUserId;

    /** @return INSERT_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 5)
    public String getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o INSERT_USER_ID */
    public void setInsertUserId(final Object o) {
        if (o != null) {
            this.insertUserId = o.toString();
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

    /** UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 7)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o UPDATE_TS */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.updateTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** UPDATE_USER_ID */
    private String updateUserId;

    /** @return UPDATE_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 8)
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o UPDATE_USER_ID */
    public void setUpdateUserId(final Object o) {
        if (o != null) {
            this.updateUserId = o.toString();
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
     * 末弟照会
     * @param param1 兄弟ID
     * @return 末弟
     */
    public static T01Youngest get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`BRO_ID` = :bro_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`BRO_ID` \n";
        sql += "    , a.`YOUNGEST_INFO` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS INSERT_USER_ID \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T01_YOUNGEST a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("bro_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T01Youngest.class);
    }

    /**
     * 末弟追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 兄弟IDの採番処理
        numbering();

        // 長兄の登録
        if (this.t01Eldest != null) {
            this.t01Eldest.setBroId(this.getBroId());
            this.t01Eldest.insert(at, by);
        }

        // 里子の登録
        if (this.t01Foster != null) {
            this.t01Foster.setBroId(this.getBroId());
            this.t01Foster.insert(at, by);
        }

        // 弟の登録
        if (this.t01Younger != null) {
            this.t01Younger.setBroId(this.getBroId());
            this.t01Younger.insert(at, by);
        }

        // 末弟の登録
        String sql = "INSERT INTO T01_YOUNGEST(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("`BRO_ID` -- :bro_id");
        nameList.add("`YOUNGEST_INFO` -- :youngest_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":bro_id");
        valueList.add(":youngest_info");
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
        String sql = "SELECT CASE WHEN MAX(e.`BRO_ID`) IS NULL THEN 0 ELSE MAX(e.`BRO_ID`) * 1 END + 1 AS `BRO_ID` FROM T01_YOUNGEST e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("BRO_ID");
        this.setBroId(o);
    }

    /**
     * 末弟更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 長兄の登録
        if (this.t01Eldest != null) {
            t01Eldest.setBroId(this.getBroId());
            if (t01Eldest.isNew()) {
                t01Eldest.insert(at, by);
            } else {
                t01Eldest.update(at, by);
            }
        }

        // 里子の登録
        if (this.t01Foster != null) {
            t01Foster.setBroId(this.getBroId());
            if (t01Foster.isNew()) {
                t01Foster.insert(at, by);
            } else {
                t01Foster.update(at, by);
            }
        }

        // 弟の登録
        if (this.t01Younger != null) {
            t01Younger.setBroId(this.getBroId());
            if (t01Younger.isNew()) {
                t01Younger.insert(at, by);
            } else {
                t01Younger.update(at, by);
            }
        }

        // 末弟の登録
        String sql = "UPDATE T01_YOUNGEST\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("`BRO_ID` = :bro_id");
        setList.add("`YOUNGEST_INFO` = :youngest_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 末弟削除
     * @return 削除件数
     */
    public int delete() {

        // 末弟の削除
        String sql = "DELETE FROM T01_YOUNGEST WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 末弟全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 末弟の削除
        String sql = "TRUNCATE TABLE T01_YOUNGEST";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("bro_id", this.broId);
        map.put("youngest_info", this.youngestInfo);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`BRO_ID` = :bro_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }

    /** 兄弟：長兄 */
    private T01Eldest t01Eldest;

    /** @return 長兄 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T01Eldest", index = 10)
    public T01Eldest getT01Eldest() {
        return this.t01Eldest;
    }

    /** @param p 長兄 */
    public void setT01Eldest(final T01Eldest p) {
        this.t01Eldest = p;
    }

    /** @return 長兄 */
    public T01Eldest referT01Eldest() {
        if (this.t01Eldest == null) {
            try {
                this.t01Eldest = T01Eldest.get(this.broId);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t01Eldest;
    }

    /** 兄弟：里子 */
    private T01Foster t01Foster;

    /** @return 里子 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T01Foster", index = 11)
    public T01Foster getT01Foster() {
        return this.t01Foster;
    }

    /** @param p 里子 */
    public void setT01Foster(final T01Foster p) {
        this.t01Foster = p;
    }

    /** @return 里子 */
    public T01Foster referT01Foster() {
        if (this.t01Foster == null) {
            try {
                this.t01Foster = T01Foster.get(this.broId);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t01Foster;
    }

    /** 兄弟：弟 */
    private T01Younger t01Younger;

    /** @return 弟 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T01Younger", index = 12)
    public T01Younger getT01Younger() {
        return this.t01Younger;
    }

    /** @param p 弟 */
    public void setT01Younger(final T01Younger p) {
        this.t01Younger = p;
    }

    /** @return 弟 */
    public T01Younger referT01Younger() {
        if (this.t01Younger == null) {
            try {
                this.t01Younger = T01Younger.get(this.broId);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t01Younger;
    }
}
