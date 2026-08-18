package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * M05_ID
 * @author emarfkrow
 */
public class M05Id implements IEntity {

    /** デフォルトコンストラクタ */
    public M05Id() {
    }

    /** @param values */
    public M05Id(final String[] values) {
        this.setIdrefId(values[0]);
        this.setIdrefMei(values[1]);
        this.setInsertTs(values[2]);
        this.setInsertUserId(values[3]);
        this.setUpdateTs(values[4]);
        this.setUpdateUserId(values[5]);
    }

    /** @param map */
    public M05Id(final java.util.Map<String, Object> map) {
        this.setIdrefId(IgnoreCaseLinkedMap.get(map, "IDREF_ID"));
        this.setIdrefMei(IgnoreCaseLinkedMap.get(map, "IDREF_MEI"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.idrefId)) {
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
        isEmpty &= this.idrefMei == null || this.idrefMei.toString().replaceAll("　| ", "").equals("");
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

    /** IDREF_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer idrefId;

    /** @return IDREF_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDREF_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getIdrefId() {
        return this.idrefId;
    }

    /** @param o IDREF_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setIdrefId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.idrefId = Integer.valueOf(o.toString());
        } else {
            this.idrefId = null;
        }
    }

    /** IDREF_MEI */
    private String idrefMei;

    /** @return IDREF_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDREF_MEI", index = 3)
    public String getIdrefMei() {
        return this.idrefMei;
    }

    /** @param o IDREF_MEI */
    public void setIdrefMei(final Object o) {
        if (o != null) {
            this.idrefMei = o.toString();
        } else {
            this.idrefMei = null;
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 9)
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
     * IDマスタ照会
     * @param param1 参照ID
     * @return IDマスタ
     */
    public static M05Id get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"IDREF_ID\" = :idref_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"IDREF_ID\" \n";
        sql += "    , a.\"IDREF_MEI\" \n";
        sql += "    , TO_CHAR (a.\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"INSERT_USER_ID\"), '　') AS INSERT_USER_ID \n";
        sql += "    , TO_CHAR (a.\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"UPDATE_USER_ID\"), '　') AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    M05_ID a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("idref_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, M05Id.class);
    }

    /**
     * IDマスタ追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 参照IDの採番処理
        numbering();

        // ID連番マスタの登録
        if (this.m05Idbns != null) {
            for (M05Idbn m05Idbn : this.m05Idbns) {
                if (m05Idbn != null) {
                    m05Idbn.setIdrefId(this.getIdrefId());
                    m05Idbn.insert(at, by);
                }
            }
        }

        // IDマスタの登録
        String sql = "INSERT INTO M05_ID(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"IDREF_ID\" -- :idref_id");
        nameList.add("\"IDREF_MEI\" -- :idref_mei");
        nameList.add("\"INSERT_TS\" -- :insert_ts");
        nameList.add("\"INSERT_USER_ID\" -- :insert_user_id");
        nameList.add("\"UPDATE_TS\" -- :update_ts");
        nameList.add("\"UPDATE_USER_ID\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":idref_id");
        valueList.add(":idref_mei");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 参照IDの採番処理 */
    private void numbering() {
        if (this.idrefId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"IDREF_ID\") IS NULL THEN 0 ELSE MAX(e.\"IDREF_ID\") * 1 END + 1 AS \"IDREF_ID\" FROM M05_ID e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("IDREF_ID");
        this.setIdrefId(o);
    }

    /**
     * IDマスタ更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // ID連番マスタの登録
        if (this.m05Idbns != null) {
            for (M05Idbn m05Idbn : this.m05Idbns) {
                if (m05Idbn == null) {
                    continue;
                }
                m05Idbn.setIdrefId(this.idrefId);
                if (m05Idbn.isNew()) {
                    m05Idbn.insert(at, by);
                } else {
                    m05Idbn.update(at, by);
                }
            }
        }

        // IDマスタの登録
        String sql = "UPDATE M05_ID\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"IDREF_ID\" = :idref_id");
        setList.add("\"IDREF_MEI\" = :idref_mei");
        setList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"UPDATE_USER_ID\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * IDマスタ削除
     * @return 削除件数
     */
    public int delete() {

        // ID連番マスタの削除
        if (this.m05Idbns != null) {
            for (M05Idbn m05Idbn : this.m05Idbns) {
                if (m05Idbn.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "ID連番マスタ");
                }
            }
        }

        // IDマスタの削除
        String sql = "DELETE FROM M05_ID WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * IDマスタ全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // ID連番マスタのチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM M05_IDBN", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "M05_ID by M05_IDBN");
        }

        // IDマスタの削除
        String sql = "TRUNCATE TABLE M05_ID";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("idref_id", this.idrefId);
        map.put("idref_mei", this.idrefMei);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"IDREF_ID\" = :idref_id");
        whereList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：ID連番マスタ
     */

    /** ID連番マスタのリスト */
    private java.util.List<M05Idbn> m05Idbns;

    /** @return ID連番マスタのリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "M05Idbns", index = 10)
    public java.util.List<M05Idbn> getM05Idbns() {
        return this.m05Idbns;
    }

    /** @param list ID連番マスタのリスト */
    public void setM05Idbns(final java.util.List<M05Idbn> list) {
        this.m05Idbns = list;
    }

    /** @param m05Idbn */
    public void addM05Idbns(final M05Idbn m05Idbn) {
        if (this.m05Idbns == null) {
            this.m05Idbns = new java.util.ArrayList<M05Idbn>();
        }
        this.m05Idbns.add(m05Idbn);
    }

    /** @return ID連番マスタのリスト */
    public java.util.List<M05Idbn> referM05Idbns() {
        this.m05Idbns = M05Id.referM05Idbns(this.idrefId);
        return this.m05Idbns;
    }

    /**
     * @param param1 idrefId
     * @return java.util.List<M05Idbn>
     */
    public static java.util.List<M05Idbn> referM05Idbns(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("IDREF_ID = :idref_id");
        String sql = "SELECT ";
        sql += "\"IDREF_ID\"";
        sql += ", \"IDBN_BN\"";
        sql += ", \"IDBN_NO\"";
        sql += ", TO_CHAR (\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS";
        sql += ", \"INSERT_USER_ID\"";
        sql += ", (SELECT r0.\"USER_SEI\" FROM MHR_USER r0 WHERE TO_CHAR (r0.\"USER_ID\") = a.\"INSERT_USER_ID\") AS \"INSERT_USER_SEI\"";
        sql += ", TO_CHAR (\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS";
        sql += ", \"UPDATE_USER_ID\"";
        sql += ", (SELECT r1.\"USER_SEI\" FROM MHR_USER r1 WHERE TO_CHAR (r1.\"USER_ID\") = a.\"UPDATE_USER_ID\") AS \"UPDATE_USER_SEI\"";
        sql += " FROM M05_IDBN a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "IDREF_ID, IDBN_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("idref_id", param1);
        java.util.List<M05Idbn> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, M05Idbn.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<M05Idbn>();
    }
}
