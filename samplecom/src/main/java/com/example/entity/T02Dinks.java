package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T02_DINKS
 * @author emarfkrow
 */
public class T02Dinks implements IEntity {

    /** デフォルトコンストラクタ */
    public T02Dinks() {
    }

    /** @param values */
    public T02Dinks(final String[] values) {
        this.setOyaId(values[0]);
        this.setKoBn(values[1]);
        this.setDinksInfo(values[2]);
        this.setInsertTs(values[3]);
        this.setInsertUserId(values[4]);
        this.setUpdateTs(values[5]);
        this.setUpdateUserId(values[6]);
    }

    /** @param map */
    public T02Dinks(final java.util.Map<String, Object> map) {
        this.setOyaId(IgnoreCaseLinkedMap.get(map, "OYA_ID"));
        this.setKoBn(IgnoreCaseLinkedMap.get(map, "KO_BN"));
        this.setDinksInfo(IgnoreCaseLinkedMap.get(map, "DINKS_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.oyaId)) {
            return true;
        } else if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.koBn)) {
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
        isEmpty &= this.dinksInfo == null || this.dinksInfo.toString().replaceAll("　| ", "").equals("");
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

    /** OYA_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer oyaId;

    /** @return OYA_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getOyaId() {
        return this.oyaId;
    }

    /** @param o OYA_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setOyaId(final Object o) {
        this.oyaId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaId = Integer.valueOf(o.toString());
        }
    }

    /** KO_BN */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer koBn;

    /** @return KO_BN */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KO_BN", index = 3)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getKoBn() {
        return this.koBn;
    }

    /** @param o KO_BN */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKoBn(final Object o) {
        this.koBn = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.koBn = Integer.valueOf(o.toString());
        }
    }

    /** DINKS_INFO */
    private String dinksInfo;

    /** @return DINKS_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DINKS_INFO", index = 4)
    public String getDinksInfo() {
        return this.dinksInfo;
    }

    /** @param o DINKS_INFO */
    public void setDinksInfo(final Object o) {
        this.dinksInfo = null;
        if (o != null) {
            this.dinksInfo = o.toString();
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 10)
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
     * 子なし照会
     * @param param1 親ID
     * @param param2 子枝番
     * @return 子なし
     */
    public static T02Dinks get(final Object param1, final Object param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"oya_id\" = CAST (:oya_id AS INTEGER)");
        whereList.add("\"ko_bn\" = CAST (:ko_bn AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"oya_id\" \n";
        sql += "    , a.\"ko_bn\" \n";
        sql += "    , a.\"dinks_info\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T02_DINKS a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", param1);
        map.put("ko_bn", param2);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T02Dinks.class);
    }

    /**
     * 子なし追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 子枝番の採番処理
        numbering();

        // 兄弟：子の登録
        if (this.t02Ko != null) {
            this.t02Ko.setOyaId(this.getOyaId());
            this.t02Ko.setKoBn(this.getKoBn());
            this.t02Ko.insert(at, by);
        }

        // 兄弟：孤児の登録
        if (this.t02Orphan != null) {
            this.t02Orphan.setOyaId(this.getOyaId());
            this.t02Orphan.setKoBn(this.getKoBn());
            this.t02Orphan.insert(at, by);
        }

        String sql = "INSERT INTO T02_DINKS(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"oya_id\" -- :oya_id");
        nameList.add("\"ko_bn\" -- :ko_bn");
        nameList.add("\"dinks_info\" -- :dinks_info");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:oya_id AS INTEGER)");
        valueList.add("CAST (:ko_bn AS INTEGER)");
        valueList.add(":dinks_info");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 子枝番の採番処理 */
    private void numbering() {
        if (this.koBn != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"ko_bn\") IS NULL THEN 0 ELSE MAX(e.\"ko_bn\") * 1 END + 1 AS \"ko_bn\" FROM T02_DINKS e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("e.\"oya_id\" = :oya_id");
        sql += " WHERE " + String.join(" AND ", whereList);
        map.put("oya_id", this.oyaId);
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("KO_BN");
        this.setKoBn(o);
    }

    /**
     * 子なし更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 兄弟：子の登録
        if (this.t02Ko != null) {
            t02Ko.setOyaId(this.getOyaId());
            t02Ko.setKoBn(this.getKoBn());
            if (t02Ko.isNew()) {
                t02Ko.insert(at, by);
            } else {
                t02Ko.update(at, by);
            }
        }

        // 兄弟：孤児の登録
        if (this.t02Orphan != null) {
            t02Orphan.setOyaId(this.getOyaId());
            t02Orphan.setKoBn(this.getKoBn());
            if (t02Orphan.isNew()) {
                t02Orphan.insert(at, by);
            } else {
                t02Orphan.update(at, by);
            }
        }

        String sql = "UPDATE T02_DINKS\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"oya_id\" = CAST (:oya_id AS INTEGER)");
        setList.add("\"ko_bn\" = CAST (:ko_bn AS INTEGER)");
        setList.add("\"dinks_info\" = :dinks_info");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {

        // 子の削除
        if (this.t02Ko != null) {
            if (this.t02Ko.delete() != 1) {
                throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "子");
            }
        }

        String sql = "DELETE FROM T02_DINKS WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE T02_DINKS";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", this.oyaId);
        map.put("ko_bn", this.koBn);
        map.put("dinks_info", this.dinksInfo);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"oya_id\" = CAST (:oya_id AS INTEGER)");
        whereList.add("\"ko_bn\" = CAST (:ko_bn AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /** 兄弟：子 */
    private T02Ko t02Ko;

    /** @return 子 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Ko", index = 11)
    public T02Ko getT02Ko() {
        return this.t02Ko;
    }

    /** @param p 子 */
    public void setT02Ko(final T02Ko p) {
        this.t02Ko = p;
    }

    /** @return 子 */
    public T02Ko referT02Ko() {
        if (this.t02Ko == null) {
            try {
                this.t02Ko = T02Ko.get(this.oyaId, this.koBn);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t02Ko;
    }

    /** 兄弟：孤児 */
    private T02Orphan t02Orphan;

    /** @return 孤児 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Orphan", index = 12)
    public T02Orphan getT02Orphan() {
        return this.t02Orphan;
    }

    /** @param p 孤児 */
    public void setT02Orphan(final T02Orphan p) {
        this.t02Orphan = p;
    }

    /** @return 孤児 */
    public T02Orphan referT02Orphan() {
        if (this.t02Orphan == null) {
            try {
                this.t02Orphan = T02Orphan.get(this.oyaId, this.koBn);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t02Orphan;
    }
}
