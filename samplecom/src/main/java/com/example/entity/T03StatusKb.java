package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T03_STATUS_KB
 * @author emarfkrow
 */
public class T03StatusKb implements IEntity {

    /** デフォルトコンストラクタ */
    public T03StatusKb() {
    }

    /** @param values */
    public T03StatusKb(final String[] values) {
        this.setFlowId(values[0]);
        this.setTableNm(values[1]);
        this.setPrimaryKeys(values[2]);
        this.setStatusKb(values[3]);
        this.setKessaiTs(values[4]);
        this.setKessaiId(values[5]);
        this.setRiyuTx(values[6]);
        this.setInsertTs(values[7]);
        this.setInsertUserId(values[8]);
        this.setUpdateTs(values[9]);
        this.setUpdateUserId(values[10]);
    }

    /** @param map */
    public T03StatusKb(final java.util.Map<String, Object> map) {
        this.setFlowId(IgnoreCaseLinkedMap.get(map, "FLOW_ID"));
        this.setTableNm(IgnoreCaseLinkedMap.get(map, "TABLE_NM"));
        this.setPrimaryKeys(IgnoreCaseLinkedMap.get(map, "PRIMARY_KEYS"));
        this.setStatusKb(IgnoreCaseLinkedMap.get(map, "STATUS_KB"));
        this.setKessaiTs(IgnoreCaseLinkedMap.get(map, "KESSAI_TS"));
        this.setKessaiId(IgnoreCaseLinkedMap.get(map, "KESSAI_ID"));
        this.setRiyuTx(IgnoreCaseLinkedMap.get(map, "RIYU_TX"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.flowId)) {
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
        isEmpty &= this.tableNm == null || this.tableNm.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.primaryKeys == null || this.primaryKeys.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kessaiTs == null || this.kessaiTs.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kessaiId == null || this.kessaiId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.riyuTx == null || this.riyuTx.toString().replaceAll("　| ", "").equals("");
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

    /** FLOW_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer flowId;

    /** @return FLOW_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "FLOW_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getFlowId() {
        return this.flowId;
    }

    /** @param o FLOW_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setFlowId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.flowId = Integer.valueOf(o.toString());
        } else {
            this.flowId = null;
        }
    }

    /** TABLE_NM */
    private String tableNm;

    /** @return TABLE_NM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TABLE_NM", index = 3)
    public String getTableNm() {
        return this.tableNm;
    }

    /** @param o TABLE_NM */
    public void setTableNm(final Object o) {
        if (o != null) {
            this.tableNm = o.toString();
        } else {
            this.tableNm = null;
        }
    }

    /** PRIMARY_KEYS */
    private String primaryKeys;

    /** @return PRIMARY_KEYS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PRIMARY_KEYS", index = 4)
    public String getPrimaryKeys() {
        return this.primaryKeys;
    }

    /** @param o PRIMARY_KEYS */
    public void setPrimaryKeys(final Object o) {
        if (o != null) {
            this.primaryKeys = o.toString();
        } else {
            this.primaryKeys = null;
        }
    }

    /** STATUS_KB */
    private String statusKb;

    /** @return STATUS_KB */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "STATUS_KB", index = 5)
    public String getStatusKb() {
        return this.statusKb;
    }

    /** @param o STATUS_KB */
    public void setStatusKb(final Object o) {
        if (o != null) {
            this.statusKb = o.toString();
        } else {
            this.statusKb = null;
        }
    }

    /** KESSAI_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime kessaiTs;

    /** @return KESSAI_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KESSAI_TS", index = 6)
    public java.time.LocalDateTime getKessaiTs() {
        return this.kessaiTs;
    }

    /** @param o KESSAI_TS */
    public void setKessaiTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.kessaiTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.kessaiTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.kessaiTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kessaiTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.kessaiTs = null;
        }
    }

    /** KESSAI_ID */
    private Integer kessaiId;

    /** @return KESSAI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KESSAI_ID", index = 7)
    public Integer getKessaiId() {
        return this.kessaiId;
    }

    /** @param o KESSAI_ID */
    public void setKessaiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kessaiId = Integer.valueOf(o.toString());
        } else {
            this.kessaiId = null;
        }
    }

    /** RIYU_TX */
    private String riyuTx;

    /** @return RIYU_TX */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "RIYU_TX", index = 8)
    public String getRiyuTx() {
        return this.riyuTx;
    }

    /** @param o RIYU_TX */
    public void setRiyuTx(final Object o) {
        if (o != null) {
            this.riyuTx = o.toString();
        } else {
            this.riyuTx = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 12)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 13)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 14)
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
     * 決裁フロー照会
     * @param param1 フローID
     * @return 決裁フロー
     */
    public static T03StatusKb get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"flow_id\" = CAST (:flow_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"flow_id\" \n";
        sql += "    , a.\"table_nm\" \n";
        sql += "    , a.\"primary_keys\" \n";
        sql += "    , a.\"status_kb\" \n";
        sql += "    , TO_CHAR (a.\"kessai_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS kessai_ts \n";
        sql += "    , a.\"kessai_id\" \n";
        sql += "    , a.\"riyu_tx\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T03_STATUS_KB a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("flow_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T03StatusKb.class);
    }

    /**
     * 決裁フロー追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // フローIDの採番処理
        numbering();

        // 決裁フローの登録
        String sql = "INSERT INTO T03_STATUS_KB(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"flow_id\" -- :flow_id");
        nameList.add("\"table_nm\" -- :table_nm");
        nameList.add("\"primary_keys\" -- :primary_keys");
        nameList.add("\"status_kb\" -- :status_kb");
        nameList.add("\"kessai_ts\" -- :kessai_ts");
        nameList.add("\"kessai_id\" -- :kessai_id");
        nameList.add("\"riyu_tx\" -- :riyu_tx");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:flow_id AS INTEGER)");
        valueList.add(":table_nm");
        valueList.add(":primary_keys");
        valueList.add(":status_kb");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (TO_CHAR (CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS.MS'), 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add("CAST (:kessai_id AS INTEGER)");
        valueList.add(":riyu_tx");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** フローIDの採番処理 */
    private void numbering() {
        if (this.flowId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"flow_id\") IS NULL THEN 0 ELSE MAX(e.\"flow_id\") * 1 END + 1 AS \"flow_id\" FROM T03_STATUS_KB e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("flow_id");
        this.setFlowId(o);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("flow_id", this.flowId);
        map.put("table_nm", this.tableNm);
        map.put("primary_keys", this.primaryKeys);
        map.put("status_kb", this.statusKb);
        map.put("kessai_ts", this.kessaiTs);
        map.put("kessai_id", this.kessaiId);
        map.put("riyu_tx", this.riyuTx);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }
}
