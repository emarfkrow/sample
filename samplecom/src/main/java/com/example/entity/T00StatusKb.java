package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * 決裁フロー
 * @author emarfkrow
 */
public class T00StatusKb implements IEntity {

    /** デフォルトコンストラクタ */
    public T00StatusKb() {
    }

    /** @param values */
    public T00StatusKb(final String[] values) {
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
    public T00StatusKb(final java.util.Map<String, Object> map) {
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

    /** フローID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer flowId;

    /** @return フローID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "FLOW_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getFlowId() {
        return this.flowId;
    }

    /** @param o フローID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setFlowId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.flowId = Integer.valueOf(o.toString());
        } else {
            this.flowId = null;
        }
    }

    /** テーブル名称 */
    private String tableNm;

    /** @return テーブル名称 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TABLE_NM", index = 3)
    public String getTableNm() {
        return this.tableNm;
    }

    /** @param o テーブル名称 */
    public void setTableNm(final Object o) {
        if (o != null) {
            this.tableNm = o.toString();
        } else {
            this.tableNm = null;
        }
    }

    /** 主キー */
    private String primaryKeys;

    /** @return 主キー */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PRIMARY_KEYS", index = 4)
    public String getPrimaryKeys() {
        return this.primaryKeys;
    }

    /** @param o 主キー */
    public void setPrimaryKeys(final Object o) {
        if (o != null) {
            this.primaryKeys = o.toString();
        } else {
            this.primaryKeys = null;
        }
    }

    /** ステータス区分 */
    private String statusKb;

    /** @return ステータス区分 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "STATUS_KB", index = 5)
    public String getStatusKb() {
        return this.statusKb;
    }

    /** @param o ステータス区分 */
    public void setStatusKb(final Object o) {
        if (o != null) {
            this.statusKb = o.toString();
        } else {
            this.statusKb = null;
        }
    }

    /** 決裁タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime kessaiTs;

    /** @return 決裁タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KESSAI_TS", index = 6)
    public java.time.LocalDateTime getKessaiTs() {
        return this.kessaiTs;
    }

    /** @param o 決裁タイムスタンプ */
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

    /** 決裁者ID */
    private Integer kessaiId;

    /** @return 決裁者ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KESSAI_ID", index = 7)
    public Integer getKessaiId() {
        return this.kessaiId;
    }

    /** @param o 決裁者ID */
    public void setKessaiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kessaiId = Integer.valueOf(o.toString());
        } else {
            this.kessaiId = null;
        }
    }

    /** 決裁コメント */
    private String riyuTx;

    /** @return 決裁コメント */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "RIYU_TX", index = 8)
    public String getRiyuTx() {
        return this.riyuTx;
    }

    /** @param o 決裁コメント */
    public void setRiyuTx(final Object o) {
        if (o != null) {
            this.riyuTx = o.toString();
        } else {
            this.riyuTx = null;
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
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.insertTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** 作成者 */
    private String insertUserId;

    /** @return 作成者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 10)
    public String getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o 作成者 */
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
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.updateTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** 更新者 */
    private String updateUserId;

    /** @return 更新者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 13)
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o 更新者 */
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
     * 決裁フロー照会
     * @param param1 フローID
     * @return 決裁フロー
     */
    public static T00StatusKb get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`FLOW_ID` = :flow_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`FLOW_ID` \n";
        sql += "    , a.`TABLE_NM` \n";
        sql += "    , a.`PRIMARY_KEYS` \n";
        sql += "    , a.`STATUS_KB` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`KESSAI_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS KESSAI_TS \n";
        sql += "    , a.`KESSAI_ID` \n";
        sql += "    , a.`RIYU_TX` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS INSERT_USER_ID \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T00_STATUS_KB a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("flow_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T00StatusKb.class);
    }
}
