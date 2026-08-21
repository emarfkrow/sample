package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T02_OYA
 * @author emarfkrow
 */
public class T02Oya implements IEntity {

    /** デフォルトコンストラクタ */
    public T02Oya() {
    }

    /** @param values */
    public T02Oya(final String[] values) {
        this.setOyaId(values[0]);
        this.setOyaInfo(values[1]);
        this.setInsertTs(values[2]);
        this.setInsertUserId(values[3]);
        this.setUpdateTs(values[4]);
        this.setUpdateUserId(values[5]);
    }

    /** @param map */
    public T02Oya(final java.util.Map<String, Object> map) {
        this.setOyaId(IgnoreCaseLinkedMap.get(map, "OYA_ID"));
        this.setOyaInfo(IgnoreCaseLinkedMap.get(map, "OYA_INFO"));
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
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.updateTs)) {
            isNew = true;
        }
        return isNew;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.oyaInfo == null || this.oyaInfo.toString().replaceAll("　| ", "").equals("");
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

    /** OYA_INFO */
    private String oyaInfo;

    /** @return OYA_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_INFO", index = 3)
    public String getOyaInfo() {
        return this.oyaInfo;
    }

    /** @param o OYA_INFO */
    public void setOyaInfo(final Object o) {
        if (o != null) {
            this.oyaInfo = o.toString();
        } else {
            this.oyaInfo = null;
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 9)
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
     * 親照会
     * @param param1 親ID
     * @return 親
     */
    public static T02Oya get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"oya_id\" = CAST (:oya_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"oya_id\" \n";
        sql += "    , a.\"oya_info\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T02_OYA a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T02Oya.class);
    }

    /**
     * 親追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 親IDの採番処理
        numbering();

        // 子なしの登録
        if (this.t02Dinkss != null) {
            for (T02Dinks t02Dinks : this.t02Dinkss) {
                if (t02Dinks != null) {
                    t02Dinks.setOyaId(this.getOyaId());
                    t02Dinks.insert(at, by);
                }
            }
        }

        // 子の登録
        if (this.t02Kos != null) {
            for (T02Ko t02Ko : this.t02Kos) {
                if (t02Ko != null) {
                    t02Ko.setOyaId(this.getOyaId());
                    t02Ko.insert(at, by);
                }
            }
        }

        // 孤児の登録
        if (this.t02Orphans != null) {
            for (T02Orphan t02Orphan : this.t02Orphans) {
                if (t02Orphan != null) {
                    t02Orphan.setOyaId(this.getOyaId());
                    t02Orphan.insert(at, by);
                }
            }
        }

        // 親の登録
        String sql = "INSERT INTO T02_OYA(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"oya_id\" -- :oya_id");
        nameList.add("\"oya_info\" -- :oya_info");
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
        valueList.add(":oya_info");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 親IDの採番処理 */
    private void numbering() {
        if (this.oyaId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"oya_id\") IS NULL THEN 0 ELSE MAX(e.\"oya_id\") * 1 END + 1 AS \"oya_id\" FROM T02_OYA e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("oya_id");
        this.setOyaId(o);
    }

    /**
     * 親更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 子なしの登録
        if (this.t02Dinkss != null) {
            for (T02Dinks t02Dinks : this.t02Dinkss) {
                if (t02Dinks == null) {
                    continue;
                }
                t02Dinks.setOyaId(this.oyaId);
                if (t02Dinks.isNew()) {
                    t02Dinks.insert(at, by);
                } else {
                    t02Dinks.update(at, by);
                }
            }
        }

        // 子の登録
        if (this.t02Kos != null) {
            for (T02Ko t02Ko : this.t02Kos) {
                if (t02Ko == null) {
                    continue;
                }
                t02Ko.setOyaId(this.oyaId);
                if (t02Ko.isNew()) {
                    t02Ko.insert(at, by);
                } else {
                    t02Ko.update(at, by);
                }
            }
        }

        // 孤児の登録
        if (this.t02Orphans != null) {
            for (T02Orphan t02Orphan : this.t02Orphans) {
                if (t02Orphan == null) {
                    continue;
                }
                t02Orphan.setOyaId(this.oyaId);
                if (t02Orphan.isNew()) {
                    t02Orphan.insert(at, by);
                } else {
                    t02Orphan.update(at, by);
                }
            }
        }

        // 親の登録
        String sql = "UPDATE T02_OYA\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"oya_id\" = CAST (:oya_id AS INTEGER)");
        setList.add("\"oya_info\" = :oya_info");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 親削除
     * @return 削除件数
     */
    public int delete() {

        // 子なしの削除
        if (this.t02Dinkss != null) {
            for (T02Dinks t02Dinks : this.t02Dinkss) {
                if (t02Dinks.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "子なし");
                }
            }
        }

        // 子の削除
        if (this.t02Kos != null) {
            for (T02Ko t02Ko : this.t02Kos) {
                if (t02Ko.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "子");
                }
            }
        }

        // 孤児の削除
        if (this.t02Orphans != null) {
            for (T02Orphan t02Orphan : this.t02Orphans) {
                if (t02Orphan.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "孤児");
                }
            }
        }

        // 親の削除
        String sql = "DELETE FROM T02_OYA WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 親全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 子なしのチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T02_DINKS", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T02_OYA by T02_DINKS");
        }

        // 子のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T02_KO", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T02_OYA by T02_KO");
        }

        // 孤児のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T02_ORPHAN", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T02_OYA by T02_ORPHAN");
        }

        // 親の削除
        String sql = "TRUNCATE TABLE T02_OYA";
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
        map.put("oya_info", this.oyaInfo);
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
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：子なし
     */

    /** 子なしのリスト */
    private java.util.List<T02Dinks> t02Dinkss;

    /** @return 子なしのリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Dinkss", index = 10)
    public java.util.List<T02Dinks> getT02Dinkss() {
        return this.t02Dinkss;
    }

    /** @param list 子なしのリスト */
    public void setT02Dinkss(final java.util.List<T02Dinks> list) {
        this.t02Dinkss = list;
    }

    /** @param t02Dinks */
    public void addT02Dinkss(final T02Dinks t02Dinks) {
        if (this.t02Dinkss == null) {
            this.t02Dinkss = new java.util.ArrayList<T02Dinks>();
        }
        this.t02Dinkss.add(t02Dinks);
    }

    /** @return 子なしのリスト */
    public java.util.List<T02Dinks> referT02Dinkss() {
        this.t02Dinkss = T02Oya.referT02Dinkss(this.oyaId);
        return this.t02Dinkss;
    }

    /**
     * @param param1 oyaId
     * @return java.util.List<T02Dinks>
     */
    public static java.util.List<T02Dinks> referT02Dinkss(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("OYA_ID = :oya_id");
        String sql = "SELECT ";
        sql += "\"oya_id\"";
        sql += ", \"ko_bn\"";
        sql += ", \"dinks_info\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r0.\"user_sei\" FROM MHR_USER r0 WHERE r0.\"user_id\" = a.\"insert_user_id\") AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r1.\"user_sei\" FROM MHR_USER r1 WHERE r1.\"user_id\" = a.\"update_user_id\") AS \"update_user_sei\"";
        sql += " FROM T02_DINKS a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "OYA_ID, KO_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", param1);
        java.util.List<T02Dinks> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T02Dinks.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T02Dinks>();
    }

    /*
     * 子モデル：子
     */

    /** 子のリスト */
    private java.util.List<T02Ko> t02Kos;

    /** @return 子のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Kos", index = 11)
    public java.util.List<T02Ko> getT02Kos() {
        return this.t02Kos;
    }

    /** @param list 子のリスト */
    public void setT02Kos(final java.util.List<T02Ko> list) {
        this.t02Kos = list;
    }

    /** @param t02Ko */
    public void addT02Kos(final T02Ko t02Ko) {
        if (this.t02Kos == null) {
            this.t02Kos = new java.util.ArrayList<T02Ko>();
        }
        this.t02Kos.add(t02Ko);
    }

    /** @return 子のリスト */
    public java.util.List<T02Ko> referT02Kos() {
        this.t02Kos = T02Oya.referT02Kos(this.oyaId);
        return this.t02Kos;
    }

    /**
     * @param param1 oyaId
     * @return java.util.List<T02Ko>
     */
    public static java.util.List<T02Ko> referT02Kos(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("OYA_ID = :oya_id");
        String sql = "SELECT ";
        sql += "\"oya_id\"";
        sql += ", \"ko_bn\"";
        sql += ", \"ko_info\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r0.\"user_sei\" FROM MHR_USER r0 WHERE r0.\"user_id\" = a.\"insert_user_id\") AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r1.\"user_sei\" FROM MHR_USER r1 WHERE r1.\"user_id\" = a.\"update_user_id\") AS \"update_user_sei\"";
        sql += " FROM T02_KO a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "OYA_ID, KO_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", param1);
        java.util.List<T02Ko> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T02Ko.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T02Ko>();
    }

    /*
     * 子モデル：孤児
     */

    /** 孤児のリスト */
    private java.util.List<T02Orphan> t02Orphans;

    /** @return 孤児のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T02Orphans", index = 12)
    public java.util.List<T02Orphan> getT02Orphans() {
        return this.t02Orphans;
    }

    /** @param list 孤児のリスト */
    public void setT02Orphans(final java.util.List<T02Orphan> list) {
        this.t02Orphans = list;
    }

    /** @param t02Orphan */
    public void addT02Orphans(final T02Orphan t02Orphan) {
        if (this.t02Orphans == null) {
            this.t02Orphans = new java.util.ArrayList<T02Orphan>();
        }
        this.t02Orphans.add(t02Orphan);
    }

    /** @return 孤児のリスト */
    public java.util.List<T02Orphan> referT02Orphans() {
        this.t02Orphans = T02Oya.referT02Orphans(this.oyaId);
        return this.t02Orphans;
    }

    /**
     * @param param1 oyaId
     * @return java.util.List<T02Orphan>
     */
    public static java.util.List<T02Orphan> referT02Orphans(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("OYA_ID = :oya_id");
        String sql = "SELECT ";
        sql += "\"oya_id\"";
        sql += ", \"ko_bn\"";
        sql += ", \"orphan_info\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r0.\"user_sei\" FROM MHR_USER r0 WHERE r0.\"user_id\" = a.\"insert_user_id\") AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r1.\"user_sei\" FROM MHR_USER r1 WHERE r1.\"user_id\" = a.\"update_user_id\") AS \"update_user_sei\"";
        sql += " FROM T02_ORPHAN a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "OYA_ID, KO_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("oya_id", param1);
        java.util.List<T02Orphan> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T02Orphan.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T02Orphan>();
    }
}
