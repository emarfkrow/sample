package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T02_ORPHAN
 * @author emarfkrow
 */
public class T02Orphan implements IEntity {

    /** デフォルトコンストラクタ */
    public T02Orphan() {
    }

    /** @param values */
    public T02Orphan(final String[] values) {
        this.setOyaId(values[0]);
        this.setKoBn(values[1]);
        this.setOrphanInfo(values[2]);
        this.setInsertTs(values[3]);
        this.setInsertUserId(values[4]);
        this.setUpdateTs(values[5]);
        this.setUpdateUserId(values[6]);
    }

    /** @param map */
    public T02Orphan(final java.util.Map<String, Object> map) {
        this.setOyaId(IgnoreCaseLinkedMap.get(map, "OYA_ID"));
        this.setKoBn(IgnoreCaseLinkedMap.get(map, "KO_BN"));
        this.setOrphanInfo(IgnoreCaseLinkedMap.get(map, "ORPHAN_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.oyaId)) {
            isNew = true;
        }
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.koBn)) {
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
        isEmpty &= this.orphanInfo == null || this.orphanInfo.toString().replaceAll("　| ", "").equals("");
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
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaId = Integer.valueOf(o.toString());
        } else {
            this.oyaId = null;
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
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.koBn = Integer.valueOf(o.toString());
        } else {
            this.koBn = null;
        }
    }

    /** ORPHAN_INFO */
    private String orphanInfo;

    /** @return ORPHAN_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ORPHAN_INFO", index = 4)
    public String getOrphanInfo() {
        return this.orphanInfo;
    }

    /** @param o ORPHAN_INFO */
    public void setOrphanInfo(final Object o) {
        if (o != null) {
            this.orphanInfo = o.toString();
        } else {
            this.orphanInfo = null;
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
     * 孤児照会
     * @param param1 親ID
     * @param param2 子枝番
     * @return 孤児
     */
    public static T02Orphan get(final Object param1, final Object param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"oya_id\" = CAST (:oya_id AS INTEGER)");
        whereList.add("\"ko_bn\" = CAST (:ko_bn AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"oya_id\" \n";
        sql += "    , a.\"ko_bn\" \n";
        sql += "    , a.\"orphan_info\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T02_ORPHAN a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", param1);
        map.put("ko_bn", param2);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T02Orphan.class);
    }

    /**
     * 孤児追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 子枝番の採番処理
        numbering();

        // 孫の登録
        if (this.t02Magos != null) {
            for (T02Mago t02Mago : this.t02Magos) {
                if (t02Mago != null) {
                    t02Mago.setOyaId(this.getOyaId());
                    t02Mago.setKoBn(this.getKoBn());
                    t02Mago.insert(at, by);
                }
            }
        }

        // 子なしの登録
        if (this.t02Dinks != null) {
            this.t02Dinks.setOyaId(this.getOyaId());
            this.t02Dinks.setKoBn(this.getKoBn());
            this.t02Dinks.insert(at, by);
        }

        // 子の登録
        if (this.t02Ko != null) {
            this.t02Ko.setOyaId(this.getOyaId());
            this.t02Ko.setKoBn(this.getKoBn());
            this.t02Ko.insert(at, by);
        }

        // 孤児の登録
        String sql = "INSERT INTO T02_ORPHAN(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"oya_id\" -- :oya_id");
        nameList.add("\"ko_bn\" -- :ko_bn");
        nameList.add("\"orphan_info\" -- :orphan_info");
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
        valueList.add(":orphan_info");
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
        String sql = "SELECT CASE WHEN MAX(e.\"ko_bn\") IS NULL THEN 0 ELSE MAX(e.\"ko_bn\") * 1 END + 1 AS \"ko_bn\" FROM T02_ORPHAN e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("e.\"oya_id\" = :oya_id");
        sql += " WHERE " + String.join(" AND ", whereList);
        map.put("oya_id", this.oyaId);
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("ko_bn");
        this.setKoBn(o);
    }

    /**
     * 孤児更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 孫の登録
        if (this.t02Magos != null) {
            for (T02Mago t02Mago : this.t02Magos) {
                if (t02Mago == null) {
                    continue;
                }
                t02Mago.setOyaId(this.oyaId);
                t02Mago.setKoBn(this.koBn);
                if (t02Mago.isNew()) {
                    t02Mago.insert(at, by);
                } else {
                    t02Mago.update(at, by);
                }
            }
        }

        // 子なしの登録
        if (this.t02Dinks != null) {
            t02Dinks.setOyaId(this.getOyaId());
            t02Dinks.setKoBn(this.getKoBn());
            if (t02Dinks.isNew()) {
                t02Dinks.insert(at, by);
            } else {
                t02Dinks.update(at, by);
            }
        }

        // 子の登録
        if (this.t02Ko != null) {
            t02Ko.setOyaId(this.getOyaId());
            t02Ko.setKoBn(this.getKoBn());
            if (t02Ko.isNew()) {
                t02Ko.insert(at, by);
            } else {
                t02Ko.update(at, by);
            }
        }

        // 孤児の登録
        String sql = "UPDATE T02_ORPHAN\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"oya_id\" = CAST (:oya_id AS INTEGER)");
        setList.add("\"ko_bn\" = CAST (:ko_bn AS INTEGER)");
        setList.add("\"orphan_info\" = :orphan_info");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 孤児削除
     * @return 削除件数
     */
    public int delete() {

        // 孫の削除
        if (this.t02Magos != null) {
            for (T02Mago t02Mago : this.t02Magos) {
                if (t02Mago.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "孫");
                }
            }
        }

        // 子なしの削除
        if (this.t02Dinks != null) {
            if (this.t02Dinks.delete() != 1) {
                throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "子なし");
            }
        }

        // 子の削除
        if (this.t02Ko != null) {
            if (this.t02Ko.delete() != 1) {
                throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "子");
            }
        }

        // 孤児の削除
        String sql = "DELETE FROM T02_ORPHAN WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 孤児全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 孫のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T02_MAGO", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T02_ORPHAN by T02_MAGO");
        }

        // 孤児の削除
        String sql = "TRUNCATE TABLE T02_ORPHAN";
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
        map.put("orphan_info", this.orphanInfo);
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

    /** 兄弟：子なし */
    private T02Dinks t02Dinks;

    /** @return 子なし */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Dinks", index = 11)
    public T02Dinks getT02Dinks() {
        return this.t02Dinks;
    }

    /** @param p 子なし */
    public void setT02Dinks(final T02Dinks p) {
        this.t02Dinks = p;
    }

    /** @return 子なし */
    public T02Dinks referT02Dinks() {
        if (this.t02Dinks == null) {
            try {
                this.t02Dinks = T02Dinks.get(this.oyaId, this.koBn);
            } catch (jp.co.golorp.emarf.exception.NoDataError e) {
            }
        }
        return this.t02Dinks;
    }

    /** 兄弟：子 */
    private T02Ko t02Ko;

    /** @return 子 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Ko", index = 12)
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

    /*
     * 子モデル：孫
     */

    /** 孫のリスト */
    private java.util.List<T02Mago> t02Magos;

    /** @return 孫のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Magos", index = 13)
    public java.util.List<T02Mago> getT02Magos() {
        return this.t02Magos;
    }

    /** @param list 孫のリスト */
    public void setT02Magos(final java.util.List<T02Mago> list) {
        this.t02Magos = list;
    }

    /** @param t02Mago */
    public void addT02Magos(final T02Mago t02Mago) {
        if (this.t02Magos == null) {
            this.t02Magos = new java.util.ArrayList<T02Mago>();
        }
        this.t02Magos.add(t02Mago);
    }

    /** @return 孫のリスト */
    public java.util.List<T02Mago> referT02Magos() {
        this.t02Magos = T02Orphan.referT02Magos(this.oyaId, this.koBn);
        return this.t02Magos;
    }

    /**
     * @param param1 oyaId
     * @param param2 koBn
     * @return java.util.List<T02Mago>
     */
    public static java.util.List<T02Mago> referT02Magos(final Integer param1, final Integer param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("OYA_ID = :oya_id");
        whereList.add("KO_BN = :ko_bn");
        String sql = "SELECT ";
        sql += "\"oya_id\"";
        sql += ", \"ko_bn\"";
        sql += ", \"mago_bn\"";
        sql += ", \"mago_info\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r0.\"user_sei\" FROM MHR_USER r0 WHERE r0.\"user_id\" = a.\"insert_user_id\") AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r1.\"user_sei\" FROM MHR_USER r1 WHERE r1.\"user_id\" = a.\"update_user_id\") AS \"update_user_sei\"";
        sql += " FROM T02_MAGO a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "OYA_ID, KO_BN, MAGO_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", param1);
        map.put("ko_bn", param2);
        java.util.List<T02Mago> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T02Mago.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T02Mago>();
    }
}
