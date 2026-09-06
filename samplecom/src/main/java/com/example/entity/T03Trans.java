package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T03_TRANS
 * @author emarfkrow
 */
public class T03Trans implements IEntity {

    /** デフォルトコンストラクタ */
    public T03Trans() {
    }

    /** @param values */
    public T03Trans(final String[] values) {
        this.setTransId(values[0]);
        this.setTransInfo(values[1]);
        this.setStatusKb(values[2]);
        this.setInsertTs(values[3]);
        this.setInsertUserId(values[4]);
        this.setUpdateTs(values[5]);
        this.setUpdateUserId(values[6]);
    }

    /** @param map */
    public T03Trans(final java.util.Map<String, Object> map) {
        this.setTransId(IgnoreCaseLinkedMap.get(map, "TRANS_ID"));
        this.setTransInfo(IgnoreCaseLinkedMap.get(map, "TRANS_INFO"));
        this.setStatusKb(IgnoreCaseLinkedMap.get(map, "STATUS_KB"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.transId)) {
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
        isEmpty &= this.transInfo == null || this.transInfo.toString().replaceAll("　| ", "").equals("");
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

    /** TRANS_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer transId;

    /** @return TRANS_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TRANS_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getTransId() {
        return this.transId;
    }

    /** @param o TRANS_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTransId(final Object o) {
        this.transId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.transId = Integer.valueOf(o.toString());
        }
    }

    /** TRANS_INFO */
    private String transInfo;

    /** @return TRANS_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TRANS_INFO", index = 3)
    public String getTransInfo() {
        return this.transInfo;
    }

    /** @param o TRANS_INFO */
    public void setTransInfo(final Object o) {
        this.transInfo = null;
        if (o != null) {
            this.transInfo = o.toString();
        }
    }

    /** STATUS_KB */
    private String statusKb;

    /** @return STATUS_KB */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "STATUS_KB", index = 4)
    public String getStatusKb() {
        return this.statusKb;
    }

    /** @param o STATUS_KB */
    public void setStatusKb(final Object o) {
        this.statusKb = null;
        if (o != null) {
            this.statusKb = o.toString();
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

    /** riyuTx */
    private String riyuTx;

    /** @return riyuTx */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "riyu_tx", index = 11)
    public String getRiyuTx() {
        return this.riyuTx;
    }

    /** @param o riyuTx */
    public void setRiyuTx(final Object o) {
        if (o != null) {
            this.riyuTx = o.toString();
        }
    }

    /**
     * 変遷照会
     * @param param1 変遷ID
     * @return 変遷
     */
    public static T03Trans get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"TRANS_ID\" = :trans_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"TRANS_ID\" \n";
        sql += "    , a.\"TRANS_INFO\" \n";
        sql += "    , a.\"STATUS_KB\" \n";
        sql += "    , TO_CHAR (a.\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"INSERT_USER_ID\"), '　') AS INSERT_USER_ID \n";
        sql += "    , TO_CHAR (a.\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"UPDATE_USER_ID\"), '　') AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T03_TRANS a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("trans_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T03Trans.class);
    }

    /**
     * 変遷追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 変遷IDの採番処理
        numbering();

        // 履歴：変遷履歴の登録
        T03TransHis t03TransHis = new T03TransHis();
        t03TransHis.setTransId(this.transId);
        t03TransHis.setTransInfo(this.transInfo);
        t03TransHis.setStatusKb(this.statusKb);
        t03TransHis.setInsertTs(this.insertTs);
        t03TransHis.setInsertUserId(this.insertUserId);
        t03TransHis.setUpdateTs(this.updateTs);
        t03TransHis.setUpdateUserId(this.updateUserId);
        t03TransHis.setRiyuTx(this.riyuTx);
        t03TransHis.insert(at, by);

        String sql = "INSERT INTO T03_TRANS(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"TRANS_ID\" -- :trans_id");
        nameList.add("\"TRANS_INFO\" -- :trans_info");
        nameList.add("\"STATUS_KB\" -- :status_kb");
        nameList.add("\"INSERT_TS\" -- :insert_ts");
        nameList.add("\"INSERT_USER_ID\" -- :insert_user_id");
        nameList.add("\"UPDATE_TS\" -- :update_ts");
        nameList.add("\"UPDATE_USER_ID\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":trans_id");
        valueList.add(":trans_info");
        valueList.add(":status_kb");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 変遷IDの採番処理 */
    private void numbering() {
        if (this.transId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"TRANS_ID\") IS NULL THEN 0 ELSE MAX(e.\"TRANS_ID\") * 1 END + 1 AS \"TRANS_ID\" FROM T03_TRANS e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("TRANS_ID");
        this.setTransId(o);
    }

    /**
     * 変遷更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 決裁：決裁フローの登録
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.statusKb) && !jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.riyuTx)) {
            T03StatusKb t03StatusKb = new T03StatusKb();
            t03StatusKb.setTableNm("T03_TRANS");
            t03StatusKb.setPrimaryKeys(String.join(",", this.getTransId().toString()));
            t03StatusKb.setStatusKb(this.statusKb);
            t03StatusKb.setKessaiTs(at);
            t03StatusKb.setKessaiId(by);
            t03StatusKb.setRiyuTx(this.riyuTx);
            t03StatusKb.setInsertTs(this.insertTs);
            t03StatusKb.setInsertUserId(this.insertUserId);
            t03StatusKb.setUpdateTs(this.updateTs);
            t03StatusKb.setUpdateUserId(this.updateUserId);
            t03StatusKb.insert(at, by);
        }

        // 履歴：変遷履歴の登録
        T03TransHis t03TransHis = new T03TransHis();
        t03TransHis.setTransId(this.transId);
        t03TransHis.setTransInfo(this.transInfo);
        t03TransHis.setStatusKb(this.statusKb);
        t03TransHis.setInsertTs(this.insertTs);
        t03TransHis.setInsertUserId(this.insertUserId);
        t03TransHis.setUpdateTs(this.updateTs);
        t03TransHis.setUpdateUserId(this.updateUserId);
        t03TransHis.setRiyuTx(this.riyuTx);
        t03TransHis.insert(at, by);

        String sql = "UPDATE T03_TRANS\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"TRANS_ID\" = :trans_id");
        setList.add("\"TRANS_INFO\" = :trans_info");
        setList.add("\"STATUS_KB\" = :status_kb");
        setList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"UPDATE_USER_ID\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {
        String sql = "DELETE FROM T03_TRANS WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE T03_TRANS";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("trans_id", this.transId);
        map.put("trans_info", this.transInfo);
        map.put("status_kb", this.statusKb);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"TRANS_ID\" = :trans_id");
        whereList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
