package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T06_REBORN
 * @author emarfkrow
 */
public class T06Reborn implements IEntity {

    /** デフォルトコンストラクタ */
    public T06Reborn() {
    }

    /** @param values */
    public T06Reborn(final String[] values) {
        this.setRebornId(values[0]);
        this.setPrevInfo(values[1]);
        this.setPrevId(values[2]);
        this.setInsertTs(values[3]);
        this.setInsertUserId(values[4]);
        this.setUpdateTs(values[5]);
        this.setUpdateUserId(values[6]);
    }

    /** @param map */
    public T06Reborn(final java.util.Map<String, Object> map) {
        this.setRebornId(IgnoreCaseLinkedMap.get(map, "REBORN_ID"));
        this.setPrevInfo(IgnoreCaseLinkedMap.get(map, "PREV_INFO"));
        this.setPrevId(IgnoreCaseLinkedMap.get(map, "PREV_ID"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.rebornId)) {
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
        isEmpty &= this.prevInfo == null || this.prevInfo.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.prevId == null || this.prevId.toString().replaceAll("　| ", "").equals("");
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

    /** REBORN_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer rebornId;

    /** @return REBORN_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REBORN_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRebornId() {
        return this.rebornId;
    }

    /** @param o REBORN_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRebornId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.rebornId = Integer.valueOf(o.toString());
        } else {
            this.rebornId = null;
        }
    }

    /** PREV_INFO */
    private String prevInfo;

    /** @return PREV_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PREV_INFO", index = 3)
    public String getPrevInfo() {
        return this.prevInfo;
    }

    /** @param o PREV_INFO */
    public void setPrevInfo(final Object o) {
        if (o != null) {
            this.prevInfo = o.toString();
        } else {
            this.prevInfo = null;
        }
    }

    /** PREV_ID */
    private Integer prevId;

    /** @return PREV_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PREV_ID", index = 4)
    public Integer getPrevId() {
        return this.prevId;
    }

    /** @param o PREV_ID */
    public void setPrevId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.prevId = Integer.valueOf(o.toString());
        } else {
            this.prevId = null;
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 10)
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
     * 転生照会
     * @param param1 転生ID
     * @return 転生
     */
    public static T06Reborn get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"reborn_id\" = CAST (:reborn_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"reborn_id\" \n";
        sql += "    , a.\"prev_info\" \n";
        sql += "    , a.\"prev_id\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T06_REBORN a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("reborn_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T06Reborn.class);
    }

    /**
     * 転生追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 転生IDの採番処理
        numbering();

        // 転生明細の登録
        if (this.t06RebornDets != null) {
            for (T06RebornDet t06RebornDet : this.t06RebornDets) {
                if (t06RebornDet != null) {
                    t06RebornDet.setRebornId(this.getRebornId());
                    t06RebornDet.insert(at, by);
                }
            }
        }

        // 転生の登録
        String sql = "INSERT INTO T06_REBORN(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"reborn_id\" -- :reborn_id");
        nameList.add("\"prev_info\" -- :prev_info");
        nameList.add("\"prev_id\" -- :prev_id");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:reborn_id AS INTEGER)");
        valueList.add(":prev_info");
        valueList.add("CAST (:prev_id AS INTEGER)");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 転生IDの採番処理 */
    private void numbering() {
        if (this.rebornId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"reborn_id\") IS NULL THEN 0 ELSE MAX(e.\"reborn_id\") * 1 END + 1 AS \"reborn_id\" FROM T06_REBORN e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("reborn_id");
        this.setRebornId(o);
    }

    /**
     * 転生更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 転生明細の登録
        if (this.t06RebornDets != null) {
            for (T06RebornDet t06RebornDet : this.t06RebornDets) {
                if (t06RebornDet == null) {
                    continue;
                }
                t06RebornDet.setRebornId(this.rebornId);
                if (t06RebornDet.isNew()) {
                    t06RebornDet.insert(at, by);
                } else {
                    t06RebornDet.update(at, by);
                }
            }
        }

        // 転生の登録
        String sql = "UPDATE T06_REBORN\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"reborn_id\" = CAST (:reborn_id AS INTEGER)");
        setList.add("\"prev_info\" = :prev_info");
        setList.add("\"prev_id\" = CAST (:prev_id AS INTEGER)");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 転生削除
     * @return 削除件数
     */
    public int delete() {

        // 転生明細の削除
        if (this.t06RebornDets != null) {
            for (T06RebornDet t06RebornDet : this.t06RebornDets) {
                if (t06RebornDet.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "転生明細");
                }
            }
        }

        // 転生の削除
        String sql = "DELETE FROM T06_REBORN WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 転生全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 転生明細のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T06_REBORN_DET", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T06_REBORN by T06_REBORN_DET");
        }

        // 転生の削除
        String sql = "TRUNCATE TABLE T06_REBORN";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("reborn_id", this.rebornId);
        map.put("prev_info", this.prevInfo);
        map.put("prev_id", this.prevId);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"reborn_id\" = CAST (:reborn_id AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：転生明細
     */

    /** 転生明細のリスト */
    private java.util.List<T06RebornDet> t06RebornDets;

    /** @return 転生明細のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T06RebornDets", index = 11)
    public java.util.List<T06RebornDet> getT06RebornDets() {
        return this.t06RebornDets;
    }

    /** @param list 転生明細のリスト */
    public void setT06RebornDets(final java.util.List<T06RebornDet> list) {
        this.t06RebornDets = list;
    }

    /** @param t06RebornDet */
    public void addT06RebornDets(final T06RebornDet t06RebornDet) {
        if (this.t06RebornDets == null) {
            this.t06RebornDets = new java.util.ArrayList<T06RebornDet>();
        }
        this.t06RebornDets.add(t06RebornDet);
    }

    /** @return 転生明細のリスト */
    public java.util.List<T06RebornDet> referT06RebornDets() {
        this.t06RebornDets = T06Reborn.referT06RebornDets(this.rebornId);
        return this.t06RebornDets;
    }

    /**
     * @param param1 rebornId
     * @return java.util.List<T06RebornDet>
     */
    public static java.util.List<T06RebornDet> referT06RebornDets(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("REBORN_ID = :reborn_id");
        String sql = "SELECT ";
        sql += "\"reborn_id\"";
        sql += ", \"reborn_bn\"";
        sql += ", \"det_info\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r0.\"user_sei\" FROM MHR_USER r0 WHERE r0.\"user_id\" = CAST (a.\"insert_user_id\" AS INTEGER)) AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r1.\"user_sei\" FROM MHR_USER r1 WHERE r1.\"user_id\" = CAST (a.\"update_user_id\" AS INTEGER)) AS \"update_user_sei\"";
        sql += " FROM T06_REBORN_DET a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "REBORN_ID, REBORN_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("reborn_id", param1);
        java.util.List<T06RebornDet> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T06RebornDet.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T06RebornDet>();
    }
}
