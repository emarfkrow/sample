package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T04_COMP1
 * @author emarfkrow
 */
public class T04Comp1 implements IEntity {

    /** デフォルトコンストラクタ */
    public T04Comp1() {
    }

    /** @param values */
    public T04Comp1(final String[] values) {
        this.setRef1Id(values[0]);
        this.setRef2Id(values[1]);
        this.setComp1Mei(values[2]);
        this.setInsertTs(values[3]);
        this.setInsertUserId(values[4]);
        this.setUpdateTs(values[5]);
        this.setUpdateUserId(values[6]);
    }

    /** @param map */
    public T04Comp1(final java.util.Map<String, Object> map) {
        this.setRef1Id(IgnoreCaseLinkedMap.get(map, "REF1_ID"));
        this.setRef2Id(IgnoreCaseLinkedMap.get(map, "REF2_ID"));
        this.setComp1Mei(IgnoreCaseLinkedMap.get(map, "COMP1_MEI"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.ref1Id)) {
            isNew = true;
        }
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.ref2Id)) {
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
        isEmpty &= this.comp1Mei == null || this.comp1Mei.toString().replaceAll("　| ", "").equals("");
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

    /** REF1_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer ref1Id;

    /** @return REF1_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF1_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRef1Id() {
        return this.ref1Id;
    }

    /** @param o REF1_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRef1Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.ref1Id = Integer.valueOf(o.toString());
        } else {
            this.ref1Id = null;
        }
    }

    /** 参照１ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String ref1Mei;

    /** @return 参照１ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ref1_mei", index = 3)
    public String getRef1Mei() {
        return this.ref1Mei;
    }

    /** @param o 参照１ID参照 */
    public void setRef1Mei(final Object o) {
        if (o != null) {
            this.ref1Mei = o.toString();
        } else {
            this.ref1Mei = null;
        }
    }

    /** REF2_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer ref2Id;

    /** @return REF2_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF2_ID", index = 4)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRef2Id() {
        return this.ref2Id;
    }

    /** @param o REF2_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRef2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.ref2Id = Integer.valueOf(o.toString());
        } else {
            this.ref2Id = null;
        }
    }

    /** 参照２ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String ref2Mei;

    /** @return 参照２ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ref2_mei", index = 5)
    public String getRef2Mei() {
        return this.ref2Mei;
    }

    /** @param o 参照２ID参照 */
    public void setRef2Mei(final Object o) {
        if (o != null) {
            this.ref2Mei = o.toString();
        } else {
            this.ref2Mei = null;
        }
    }

    /** COMP1_MEI */
    private String comp1Mei;

    /** @return COMP1_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COMP1_MEI", index = 6)
    public String getComp1Mei() {
        return this.comp1Mei;
    }

    /** @param o COMP1_MEI */
    public void setComp1Mei(final Object o) {
        if (o != null) {
            this.comp1Mei = o.toString();
        } else {
            this.comp1Mei = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 12)
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
     * 複合１照会
     * @param param1 参照１ID
     * @param param2 参照２ID
     * @return 複合１
     */
    public static T04Comp1 get(final Object param1, final Object param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"ref1_id\" = CAST (:ref_1_id AS INTEGER)");
        whereList.add("\"ref2_id\" = CAST (:ref_2_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"ref1_id\" \n";
        sql += "    , a.\"ref2_id\" \n";
        sql += "    , a.\"comp1_mei\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T04_COMP1 a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("ref_1_id", param1);
        map.put("ref_2_id", param2);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T04Comp1.class);
    }

    /**
     * 複合１追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 複合２の登録
        if (this.t04Comp2s != null) {
            for (T04Comp2 t04Comp2 : this.t04Comp2s) {
                if (t04Comp2 != null) {
                    t04Comp2.setRef1Id(this.getRef1Id());
                    t04Comp2.setRef2Id(this.getRef2Id());
                    t04Comp2.insert(at, by);
                }
            }
        }

        // 複合１の登録
        String sql = "INSERT INTO T04_COMP1(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"ref1_id\" -- :ref_1_id");
        nameList.add("\"ref2_id\" -- :ref_2_id");
        nameList.add("\"comp1_mei\" -- :comp_1_mei");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:ref_1_id AS INTEGER)");
        valueList.add("CAST (:ref_2_id AS INTEGER)");
        valueList.add(":comp_1_mei");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 複合１更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 複合２の登録
        if (this.t04Comp2s != null) {
            for (T04Comp2 t04Comp2 : this.t04Comp2s) {
                if (t04Comp2 == null) {
                    continue;
                }
                t04Comp2.setRef1Id(this.ref1Id);
                t04Comp2.setRef2Id(this.ref2Id);
                if (t04Comp2.isNew()) {
                    t04Comp2.insert(at, by);
                } else {
                    t04Comp2.update(at, by);
                }
            }
        }

        // 複合１の登録
        String sql = "UPDATE T04_COMP1\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"ref1_id\" = CAST (:ref_1_id AS INTEGER)");
        setList.add("\"ref2_id\" = CAST (:ref_2_id AS INTEGER)");
        setList.add("\"comp1_mei\" = :comp_1_mei");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 複合１削除
     * @return 削除件数
     */
    public int delete() {

        // 複合２の削除
        if (this.t04Comp2s != null) {
            for (T04Comp2 t04Comp2 : this.t04Comp2s) {
                if (t04Comp2.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "複合２");
                }
            }
        }

        // 複合１の削除
        String sql = "DELETE FROM T04_COMP1 WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 複合１全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 複合２のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T04_COMP2", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T04_COMP1 by T04_COMP2");
        }

        // 複合１の削除
        String sql = "TRUNCATE TABLE T04_COMP1";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("ref_1_id", this.ref1Id);
        map.put("ref_2_id", this.ref2Id);
        map.put("comp_1_mei", this.comp1Mei);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"ref1_id\" = CAST (:ref_1_id AS INTEGER)");
        whereList.add("\"ref2_id\" = CAST (:ref_2_id AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：複合２
     */

    /** 複合２のリスト */
    private java.util.List<T04Comp2> t04Comp2s;

    /** @return 複合２のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T04Comp2s", index = 13)
    public java.util.List<T04Comp2> getT04Comp2s() {
        return this.t04Comp2s;
    }

    /** @param list 複合２のリスト */
    public void setT04Comp2s(final java.util.List<T04Comp2> list) {
        this.t04Comp2s = list;
    }

    /** @param t04Comp2 */
    public void addT04Comp2s(final T04Comp2 t04Comp2) {
        if (this.t04Comp2s == null) {
            this.t04Comp2s = new java.util.ArrayList<T04Comp2>();
        }
        this.t04Comp2s.add(t04Comp2);
    }

    /** @return 複合２のリスト */
    public java.util.List<T04Comp2> referT04Comp2s() {
        this.t04Comp2s = T04Comp1.referT04Comp2s(this.ref1Id, this.ref2Id);
        return this.t04Comp2s;
    }

    /**
     * @param param1 ref1Id
     * @param param2 ref2Id
     * @return java.util.List<T04Comp2>
     */
    public static java.util.List<T04Comp2> referT04Comp2s(final Integer param1, final Integer param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("REF1_ID = :ref_1_id");
        whereList.add("REF2_ID = :ref_2_id");
        String sql = "SELECT ";
        sql += "\"ref1_id\"";
        sql += ", (SELECT r0.\"ref1_mei\" FROM M04_REF1 r0 WHERE r0.\"ref1_id\" = a.\"ref1_id\") AS \"ref1_mei\"";
        sql += ", \"ref2_id\"";
        sql += ", (SELECT r1.\"ref2_mei\" FROM M04_REF2 r1 WHERE r1.\"ref2_id\" = a.\"ref2_id\") AS \"ref2_mei\"";
        sql += ", \"ref3_id\"";
        sql += ", (SELECT r2.\"ref3_mei\" FROM M04_REF3 r2 WHERE r2.\"ref3_id\" = a.\"ref3_id\") AS \"ref3_mei\"";
        sql += ", TO_CHAR (\"tekiyo_bi\", 'YYYY-MM-DD') AS tekiyo_bi";
        sql += ", \"comp2_info\"";
        sql += ", TO_CHAR (\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts";
        sql += ", \"insert_user_id\"";
        sql += ", (SELECT r3.\"user_sei\" FROM MHR_USER r3 WHERE r3.\"user_id\" = CAST (a.\"insert_user_id\" AS INTEGER)) AS \"insert_user_sei\"";
        sql += ", TO_CHAR (\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts";
        sql += ", \"update_user_id\"";
        sql += ", (SELECT r4.\"user_sei\" FROM MHR_USER r4 WHERE r4.\"user_id\" = CAST (a.\"update_user_id\" AS INTEGER)) AS \"update_user_sei\"";
        sql += " FROM T04_COMP2 a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "REF1_ID, REF2_ID, REF3_ID, TEKIYO_BI";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("ref_1_id", param1);
        map.put("ref_2_id", param2);
        java.util.List<T04Comp2> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T04Comp2.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T04Comp2>();
    }
}
