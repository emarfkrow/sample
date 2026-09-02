package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T06_PREV
 * @author emarfkrow
 */
public class T06Prev implements IEntity {

    /** デフォルトコンストラクタ */
    public T06Prev() {
    }

    /** @param values */
    public T06Prev(final String[] values) {
        this.setPrevId(values[0]);
        this.setPrevInfo(values[1]);
        this.setInsertTs(values[2]);
        this.setInsertUserId(values[3]);
        this.setUpdateTs(values[4]);
        this.setUpdateUserId(values[5]);
    }

    /** @param map */
    public T06Prev(final java.util.Map<String, Object> map) {
        this.setPrevId(IgnoreCaseLinkedMap.get(map, "PREV_ID"));
        this.setPrevInfo(IgnoreCaseLinkedMap.get(map, "PREV_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.prevId)) {
            return true;
        }
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.updateTs)) {
            return true;
        }
        return false;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.prevInfo == null || this.prevInfo.toString().replaceAll("　| ", "").equals("");
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

    /** PREV_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer prevId;

    /** @return PREV_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PREV_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getPrevId() {
        return this.prevId;
    }

    /** @param o PREV_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setPrevId(final Object o) {
        this.prevId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.prevId = Integer.valueOf(o.toString());
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
        this.prevInfo = null;
        if (o != null) {
            this.prevInfo = o.toString();
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 5)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 9)
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
     * 前世照会
     * @param param1 前世ID
     * @return 前世
     */
    public static T06Prev get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"prev_id\" = CAST (:prev_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"prev_id\" \n";
        sql += "    , a.\"prev_info\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T06_PREV a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T06Prev.class);
    }

    /**
     * 前世追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 前世IDの採番処理
        numbering();

        // 子：前世明細の登録
        if (this.t06PrevDets != null) {
            for (T06PrevDet t06PrevDet : this.t06PrevDets) {
                if (t06PrevDet != null) {
                    t06PrevDet.setPrevId(this.getPrevId());
                    t06PrevDet.insert(at, by);
                }
            }
        }

        String sql = "INSERT INTO T06_PREV(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"prev_id\" -- :prev_id");
        nameList.add("\"prev_info\" -- :prev_info");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:prev_id AS INTEGER)");
        valueList.add(":prev_info");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 前世IDの採番処理 */
    private void numbering() {
        if (this.prevId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"prev_id\") IS NULL THEN 0 ELSE MAX(e.\"prev_id\") * 1 END + 1 AS \"prev_id\" FROM T06_PREV e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("PREV_ID");
        this.setPrevId(o);
    }

    /**
     * 前世更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 子：前世明細の登録
        if (this.t06PrevDets != null) {
            for (T06PrevDet t06PrevDet : this.t06PrevDets) {
                if (t06PrevDet == null) {
                    continue;
                }
                t06PrevDet.setPrevId(this.prevId);
                if (t06PrevDet.isNew()) {
                    t06PrevDet.insert(at, by);
                } else {
                    t06PrevDet.update(at, by);
                }
            }
        }

        String sql = "UPDATE T06_PREV\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"prev_id\" = CAST (:prev_id AS INTEGER)");
        setList.add("\"prev_info\" = :prev_info");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {

        // 前世明細の削除
        if (this.t06PrevDets != null) {
            for (T06PrevDet t06PrevDet : this.t06PrevDets) {
                if (t06PrevDet.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "前世明細");
                }
            }
        }

        String sql = "DELETE FROM T06_PREV WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {

        // 前世明細のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T06_PREV_DET", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T06_PREV by T06_PREV_DET");
        }

        String sql = "TRUNCATE TABLE T06_PREV";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", this.prevId);
        map.put("prev_info", this.prevInfo);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"prev_id\" = CAST (:prev_id AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：前世明細
     */

    /** 前世明細のリスト */
    private java.util.List<T06PrevDet> t06PrevDets;

    /** @return 前世明細のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T06PrevDets", index = 10)
    public java.util.List<T06PrevDet> getT06PrevDets() {
        return this.t06PrevDets;
    }

    /** @param list 前世明細のリスト */
    public void setT06PrevDets(final java.util.List<T06PrevDet> list) {
        this.t06PrevDets = list;
    }

    /** @param t06PrevDet */
    public void addT06PrevDets(final T06PrevDet t06PrevDet) {
        if (this.t06PrevDets == null) {
            this.t06PrevDets = new java.util.ArrayList<T06PrevDet>();
        }
        this.t06PrevDets.add(t06PrevDet);
    }

    /** @return 前世明細のリスト */
    public java.util.List<T06PrevDet> referT06PrevDets() {
        this.t06PrevDets = T06Prev.referT06PrevDets(this.prevId);
        return this.t06PrevDets;
    }

    /**
     * @param param1 prevId
     * @return java.util.List<T06PrevDet>
     */
    public static java.util.List<T06PrevDet> referT06PrevDets(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("PREV_ID = :prev_id");
        String sql = "SELECT ";
        sql += "\"prev_id\"";
        sql += ", \"prev_bn\"";
        sql += ", \"det_info\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r0.\"user_sei\" FROM MHR_USER r0 WHERE r0.\"user_id\" = CAST (a.\"insert_user_id\" AS INTEGER)) AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r1.\"user_sei\" FROM MHR_USER r1 WHERE r1.\"user_id\" = CAST (a.\"update_user_id\" AS INTEGER)) AS \"update_user_sei\"";
        sql += " FROM T06_PREV_DET a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "PREV_ID, PREV_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", param1);
        java.util.List<T06PrevDet> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T06PrevDet.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T06PrevDet>();
    }

    /* 転生先：転生 */

    /** 転生のリスト */
    private java.util.List<T06Reborn> t06Reborns;

    /** @return 転生のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T06Reborns", index = 11)
    public java.util.List<T06Reborn> getT06Reborns() {
        return this.t06Reborns;
    }

    /** @param list 転生のリスト */
    public void setT06Reborns(final java.util.List<T06Reborn> list) {
        this.t06Reborns = list;
    }

    /** @param t06Reborn */
    public void addT06Reborns(final T06Reborn t06Reborn) {
        if (this.t06Reborns == null) {
            this.t06Reborns = new java.util.ArrayList<T06Reborn>();
        }
        this.t06Reborns.add(t06Reborn);
    }

    /** @return 転生のリスト */
    public java.util.List<T06Reborn> referT06Reborns() {
        this.t06Reborns = T06Prev.referT06Reborns(this.prevId);
        return this.t06Reborns;
    }

    /**
     * @param param1 prevId
     * @return java.util.List<T06Reborn>
     */
    public static java.util.List<T06Reborn> referT06Reborns(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("PREV_ID = :prev_id");
        String sql = "SELECT ";
        sql += "\"reborn_id\"";
        sql += ", \"prev_info\"";
        sql += ", \"prev_id\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r0.\"user_sei\" FROM MHR_USER r0 WHERE r0.\"user_id\" = CAST (a.\"insert_user_id\" AS INTEGER)) AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r1.\"user_sei\" FROM MHR_USER r1 WHERE r1.\"user_id\" = CAST (a.\"update_user_id\" AS INTEGER)) AS \"update_user_sei\"";
        sql += " FROM T06_REBORN a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "REBORN_ID";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", param1);
        java.util.List<T06Reborn> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T06Reborn.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T06Reborn>();
    }
}
