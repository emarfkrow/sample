package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T07_DERIVE1_DET
 * @author emarfkrow
 */
public class T07Derive1Det implements IEntity {

    /** デフォルトコンストラクタ */
    public T07Derive1Det() {
    }

    /** @param values */
    public T07Derive1Det(final String[] values) {
        this.setDerive1Id(values[0]);
        this.setDerive1Bn(values[1]);
        this.setDetInfo(values[2]);
        this.setInsertTs(values[3]);
        this.setInsertUserId(values[4]);
        this.setUpdateTs(values[5]);
        this.setUpdateUserId(values[6]);
    }

    /** @param map */
    public T07Derive1Det(final java.util.Map<String, Object> map) {
        this.setDerive1Id(IgnoreCaseLinkedMap.get(map, "DERIVE1_ID"));
        this.setDerive1Bn(IgnoreCaseLinkedMap.get(map, "DERIVE1_BN"));
        this.setDetInfo(IgnoreCaseLinkedMap.get(map, "DET_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.derive1Id)) {
            return true;
        } else if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.derive1Bn)) {
            return true;
        }
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.updateTs)) {
            return true; // 楽観ロック値がなくてもINSERT
        }
        return false;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.detInfo == null || this.detInfo.toString().replaceAll("　| ", "").equals("");
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
        this.id = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.id = Integer.valueOf(o.toString());
        }
    }

    /** DERIVE1_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer derive1Id;

    /** @return DERIVE1_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DERIVE1_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getDerive1Id() {
        return this.derive1Id;
    }

    /** @param o DERIVE1_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive1Id(final Object o) {
        this.derive1Id = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.derive1Id = Integer.valueOf(o.toString());
        }
    }

    /** DERIVE1_BN */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer derive1Bn;

    /** @return DERIVE1_BN */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DERIVE1_BN", index = 3)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getDerive1Bn() {
        return this.derive1Bn;
    }

    /** @param o DERIVE1_BN */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive1Bn(final Object o) {
        this.derive1Bn = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.derive1Bn = Integer.valueOf(o.toString());
        }
    }

    /** DET_INFO */
    private String detInfo;

    /** @return DET_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DET_INFO", index = 4)
    public String getDetInfo() {
        return this.detInfo;
    }

    /** @param o DET_INFO */
    public void setDetInfo(final Object o) {
        this.detInfo = null;
        if (o != null) {
            this.detInfo = o.toString();
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 5)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o INSERT_TS */
    public void setInsertTs(final Object o) {
        this.insertTs = null;
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
        }
    }

    /** INSERT_USER_ID */
    private String insertUserId;

    /** @return INSERT_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 6)
    public String getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o INSERT_USER_ID */
    public void setInsertUserId(final Object o) {
        this.insertUserId = null;
        if (o != null) {
            this.insertUserId = o.toString();
        }
    }

    /** 作成者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String insertUserSei;

    /** @return 作成者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 7)
    public String getInsertUserSei() {
        return this.insertUserSei;
    }

    /** @param o 作成者参照 */
    public void setInsertUserSei(final Object o) {
        this.insertUserSei = null;
        if (o != null) {
            this.insertUserSei = o.toString();
        }
    }

    /** UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 8)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o UPDATE_TS */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        this.updateTs = null;
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
        }
    }

    /** UPDATE_USER_ID */
    private String updateUserId;

    /** @return UPDATE_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 9)
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o UPDATE_USER_ID */
    public void setUpdateUserId(final Object o) {
        this.updateUserId = null;
        if (o != null) {
            this.updateUserId = o.toString();
        }
    }

    /** 更新者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String updateUserSei;

    /** @return 更新者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 10)
    public String getUpdateUserSei() {
        return this.updateUserSei;
    }

    /** @param o 更新者参照 */
    public void setUpdateUserSei(final Object o) {
        this.updateUserSei = null;
        if (o != null) {
            this.updateUserSei = o.toString();
        }
    }

    /**
     * 派生１明細照会
     * @param param1 派生１ID
     * @param param2 派生１枝番
     * @return 派生１明細
     */
    public static T07Derive1Det get(final Object param1, final Object param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"DERIVE1_ID\" = :derive_1_id");
        whereList.add("\"DERIVE1_BN\" = :derive_1_bn");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"DERIVE1_ID\" \n";
        sql += "    , a.\"DERIVE1_BN\" \n";
        sql += "    , a.\"DET_INFO\" \n";
        sql += "    , TO_CHAR (a.\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"INSERT_USER_ID\"), '　') AS INSERT_USER_ID \n";
        sql += "    , TO_CHAR (a.\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"UPDATE_USER_ID\"), '　') AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T07_DERIVE1_DET a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("derive_1_id", param1);
        map.put("derive_1_bn", param2);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T07Derive1Det.class);
    }

    /**
     * 派生１明細追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 派生１枝番の採番処理
        numbering();

        String sql = "INSERT INTO T07_DERIVE1_DET(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"DERIVE1_ID\" -- :derive_1_id");
        nameList.add("\"DERIVE1_BN\" -- :derive_1_bn");
        nameList.add("\"DET_INFO\" -- :det_info");
        nameList.add("\"INSERT_TS\" -- :insert_ts");
        nameList.add("\"INSERT_USER_ID\" -- :insert_user_id");
        nameList.add("\"UPDATE_TS\" -- :update_ts");
        nameList.add("\"UPDATE_USER_ID\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":derive_1_id");
        valueList.add(":derive_1_bn");
        valueList.add(":det_info");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 派生１枝番の採番処理 */
    private void numbering() {
        if (this.derive1Bn != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"DERIVE1_BN\") IS NULL THEN 0 ELSE MAX(e.\"DERIVE1_BN\") * 1 END + 1 AS \"DERIVE1_BN\" FROM T07_DERIVE1_DET e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("e.\"DERIVE1_ID\" = :derive_1_id");
        sql += " WHERE " + String.join(" AND ", whereList);
        map.put("derive_1_id", this.derive1Id);
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("DERIVE1_BN");
        this.setDerive1Bn(o);
    }

    /**
     * 派生１明細更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {
        String sql = "UPDATE T07_DERIVE1_DET\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"DERIVE1_ID\" = :derive_1_id");
        setList.add("\"DERIVE1_BN\" = :derive_1_bn");
        setList.add("\"DET_INFO\" = :det_info");
        setList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"UPDATE_USER_ID\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {
        String sql = "DELETE FROM T07_DERIVE1_DET WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE T07_DERIVE1_DET";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("derive_1_id", this.derive1Id);
        map.put("derive_1_bn", this.derive1Bn);
        map.put("det_info", this.detInfo);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"DERIVE1_ID\" = :derive_1_id");
        whereList.add("\"DERIVE1_BN\" = :derive_1_bn");
        whereList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
