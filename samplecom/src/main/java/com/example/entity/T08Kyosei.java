package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T08_KYOSEI
 * @author emarfkrow
 */
public class T08Kyosei implements IEntity {

    /** デフォルトコンストラクタ */
    public T08Kyosei() {
    }

    /** @param values */
    public T08Kyosei(final String[] values) {
        this.setKyoseiId(values[0]);
        this.setKisei1Id(values[1]);
        this.setKisei1Info(values[2]);
        this.setKisei2Id(values[3]);
        this.setKisei2Info(values[4]);
        this.setInsertTs(values[5]);
        this.setInsertUserId(values[6]);
        this.setUpdateTs(values[7]);
        this.setUpdateUserId(values[8]);
    }

    /** @param map */
    public T08Kyosei(final java.util.Map<String, Object> map) {
        this.setKyoseiId(IgnoreCaseLinkedMap.get(map, "KYOSEI_ID"));
        this.setKisei1Id(IgnoreCaseLinkedMap.get(map, "KISEI1_ID"));
        this.setKisei1Info(IgnoreCaseLinkedMap.get(map, "KISEI1_INFO"));
        this.setKisei2Id(IgnoreCaseLinkedMap.get(map, "KISEI2_ID"));
        this.setKisei2Info(IgnoreCaseLinkedMap.get(map, "KISEI2_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.kyoseiId)) {
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
        isEmpty &= this.kisei1Id == null || this.kisei1Id.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kisei1Info == null || this.kisei1Info.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kisei2Id == null || this.kisei2Id.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kisei2Info == null || this.kisei2Info.toString().replaceAll("　| ", "").equals("");
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

    /** KYOSEI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer kyoseiId;

    /** @return KYOSEI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KYOSEI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getKyoseiId() {
        return this.kyoseiId;
    }

    /** @param o KYOSEI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKyoseiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kyoseiId = Integer.valueOf(o.toString());
        } else {
            this.kyoseiId = null;
        }
    }

    /** KISEI1_ID */
    private Integer kisei1Id;

    /** @return KISEI1_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI1_ID", index = 3)
    public Integer getKisei1Id() {
        return this.kisei1Id;
    }

    /** @param o KISEI1_ID */
    public void setKisei1Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kisei1Id = Integer.valueOf(o.toString());
        } else {
            this.kisei1Id = null;
        }
    }

    /** KISEI1_INFO */
    private String kisei1Info;

    /** @return KISEI1_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI1_INFO", index = 4)
    public String getKisei1Info() {
        return this.kisei1Info;
    }

    /** @param o KISEI1_INFO */
    public void setKisei1Info(final Object o) {
        if (o != null) {
            this.kisei1Info = o.toString();
        } else {
            this.kisei1Info = null;
        }
    }

    /** KISEI2_ID */
    private Integer kisei2Id;

    /** @return KISEI2_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI2_ID", index = 5)
    public Integer getKisei2Id() {
        return this.kisei2Id;
    }

    /** @param o KISEI2_ID */
    public void setKisei2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kisei2Id = Integer.valueOf(o.toString());
        } else {
            this.kisei2Id = null;
        }
    }

    /** KISEI2_INFO */
    private String kisei2Info;

    /** @return KISEI2_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KISEI2_INFO", index = 6)
    public String getKisei2Info() {
        return this.kisei2Info;
    }

    /** @param o KISEI2_INFO */
    public void setKisei2Info(final Object o) {
        if (o != null) {
            this.kisei2Info = o.toString();
        } else {
            this.kisei2Info = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 12)
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
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"kyosei_id\" = CAST (:kyosei_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"kyosei_id\" \n";
        sql += "    , a.\"kisei1_id\" \n";
        sql += "    , a.\"kisei1_info\" \n";
        sql += "    , a.\"kisei2_id\" \n";
        sql += "    , a.\"kisei2_info\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T08_KYOSEI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("kyosei_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T08Kyosei.class);
    }

    /**
     * 共生追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 共生IDの採番処理
        numbering();

        // 共生の登録
        String sql = "INSERT INTO T08_KYOSEI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"kyosei_id\" -- :kyosei_id");
        nameList.add("\"kisei1_id\" -- :kisei_1_id");
        nameList.add("\"kisei1_info\" -- :kisei_1_info");
        nameList.add("\"kisei2_id\" -- :kisei_2_id");
        nameList.add("\"kisei2_info\" -- :kisei_2_info");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:kyosei_id AS INTEGER)");
        valueList.add("CAST (:kisei_1_id AS INTEGER)");
        valueList.add(":kisei_1_info");
        valueList.add("CAST (:kisei_2_id AS INTEGER)");
        valueList.add(":kisei_2_info");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 共生IDの採番処理 */
    private void numbering() {
        if (this.kyoseiId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"kyosei_id\") IS NULL THEN 0 ELSE MAX(e.\"kyosei_id\") * 1 END + 1 AS \"kyosei_id\" FROM T08_KYOSEI e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("kyosei_id");
        this.setKyoseiId(o);
    }

    /**
     * 共生更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 共生の登録
        String sql = "UPDATE T08_KYOSEI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"kyosei_id\" = CAST (:kyosei_id AS INTEGER)");
        setList.add("\"kisei1_id\" = CAST (:kisei_1_id AS INTEGER)");
        setList.add("\"kisei1_info\" = :kisei_1_info");
        setList.add("\"kisei2_id\" = CAST (:kisei_2_id AS INTEGER)");
        setList.add("\"kisei2_info\" = :kisei_2_info");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 共生削除
     * @return 削除件数
     */
    public int delete() {

        // 共生の削除
        String sql = "DELETE FROM T08_KYOSEI WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 共生全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 共生の削除
        String sql = "TRUNCATE TABLE T08_KYOSEI";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("kyosei_id", this.kyoseiId);
        map.put("kisei_1_id", this.kisei1Id);
        map.put("kisei_1_info", this.kisei1Info);
        map.put("kisei_2_id", this.kisei2Id);
        map.put("kisei_2_info", this.kisei2Info);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"kyosei_id\" = CAST (:kyosei_id AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
