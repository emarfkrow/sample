package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * M04_REF1
 * @author emarfkrow
 */
public class M04Ref1 implements IEntity {

    /** デフォルトコンストラクタ */
    public M04Ref1() {
    }

    /** @param values */
    public M04Ref1(final String[] values) {
        this.setRef1Id(values[0]);
        this.setRef1Mei(values[1]);
        this.setDeleteF(values[2]);
        this.setTekiyoBi(values[3]);
        this.setHaishiBi(values[4]);
        this.setInsertTs(values[5]);
        this.setInsertUserId(values[6]);
        this.setUpdateTs(values[7]);
        this.setUpdateUserId(values[8]);
    }

    /** @param map */
    public M04Ref1(final java.util.Map<String, Object> map) {
        this.setRef1Id(IgnoreCaseLinkedMap.get(map, "REF1_ID"));
        this.setRef1Mei(IgnoreCaseLinkedMap.get(map, "REF1_MEI"));
        this.setDeleteF(IgnoreCaseLinkedMap.get(map, "DELETE_F"));
        this.setTekiyoBi(IgnoreCaseLinkedMap.get(map, "TEKIYO_BI"));
        this.setHaishiBi(IgnoreCaseLinkedMap.get(map, "HAISHI_BI"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.ref1Id)) {
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
        isEmpty &= this.ref1Mei == null || this.ref1Mei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.tekiyoBi == null || this.tekiyoBi.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.haishiBi == null || this.haishiBi.toString().replaceAll("　| ", "").equals("");
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
        this.ref1Id = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.ref1Id = Integer.valueOf(o.toString());
        }
    }

    /** REF1_MEI */
    private String ref1Mei;

    /** @return REF1_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF1_MEI", index = 3)
    public String getRef1Mei() {
        return this.ref1Mei;
    }

    /** @param o REF1_MEI */
    public void setRef1Mei(final Object o) {
        this.ref1Mei = null;
        if (o != null) {
            this.ref1Mei = o.toString();
        }
    }

    /** DELETE_F */
    private String deleteF = "0";

    /** @return DELETE_F */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DELETE_F", index = 4)
    public String getDeleteF() {
        return this.deleteF;
    }

    /** @param o DELETE_F */
    public void setDeleteF(final Object o) {
        this.deleteF = null;
        if (o != null) {
            this.deleteF = o.toString();
        }
    }

    /** TEKIYO_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate tekiyoBi;

    /** @return TEKIYO_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TEKIYO_BI", index = 5)
    public java.time.LocalDate getTekiyoBi() {
        return this.tekiyoBi;
    }

    /** @param o TEKIYO_BI */
    public void setTekiyoBi(final Object o) {
        this.tekiyoBi = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.tekiyoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        }
    }

    /** HAISHI_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate haishiBi;

    /** @return HAISHI_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HAISHI_BI", index = 6)
    public java.time.LocalDate getHaishiBi() {
        return this.haishiBi;
    }

    /** @param o HAISHI_BI */
    public void setHaishiBi(final Object o) {
        this.haishiBi = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.haishiBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 12)
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
     * マスタ参照１照会
     * @param param1 参照１ID
     * @return マスタ参照１
     */
    public static M04Ref1 get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"ref1_id\" = CAST (:ref_1_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"ref1_id\" \n";
        sql += "    , a.\"ref1_mei\" \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"delete_f\") AS delete_f \n";
        sql += "    , TO_CHAR (a.\"tekiyo_bi\", 'YYYY-MM-DD') AS tekiyo_bi \n";
        sql += "    , TO_CHAR (a.\"haishi_bi\", 'YYYY-MM-DD') AS haishi_bi \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    M04_REF1 a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("ref_1_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, M04Ref1.class);
    }

    /**
     * マスタ参照１追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 参照１IDの採番処理
        numbering();

        String sql = "INSERT INTO M04_REF1(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"ref1_id\" -- :ref_1_id");
        nameList.add("\"ref1_mei\" -- :ref_1_mei");
        nameList.add("\"delete_f\" -- :delete_f");
        nameList.add("\"tekiyo_bi\" -- :tekiyo_bi");
        nameList.add("\"haishi_bi\" -- :haishi_bi");
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
        valueList.add(":ref_1_mei");
        valueList.add(":delete_f");
        valueList.add("TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD')");
        valueList.add("TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD')");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 参照１IDの採番処理 */
    private void numbering() {
        if (this.ref1Id != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"ref1_id\") IS NULL THEN 0 ELSE MAX(e.\"ref1_id\") * 1 END + 1 AS \"ref1_id\" FROM M04_REF1 e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("REF1_ID");
        this.setRef1Id(o);
    }

    /**
     * マスタ参照１更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {
        String sql = "UPDATE M04_REF1\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"ref1_id\" = CAST (:ref_1_id AS INTEGER)");
        setList.add("\"ref1_mei\" = :ref_1_mei");
        setList.add("\"delete_f\" = :delete_f");
        setList.add("\"tekiyo_bi\" = TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD')");
        setList.add("\"haishi_bi\" = TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD')");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE M04_REF1";
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
        map.put("ref_1_mei", this.ref1Mei);
        map.put("delete_f", this.deleteF);
        map.put("tekiyo_bi", this.tekiyoBi);
        map.put("haishi_bi", this.haishiBi);
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
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
