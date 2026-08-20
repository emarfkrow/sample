package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * MHR_USER
 * @author emarfkrow
 */
public class MhrUser implements IEntity {

    /** デフォルトコンストラクタ */
    public MhrUser() {
    }

    /** @param values */
    public MhrUser(final String[] values) {
        this.setUserId(values[0]);
        this.setUserSei(values[1]);
        this.setUserMei(values[2]);
        this.setEMail(values[3]);
        this.setPassword(values[4]);
        this.setTekiyoBi(values[5]);
        this.setHaishiBi(values[6]);
        this.setInsertTs(values[7]);
        this.setInsertUserId(values[8]);
        this.setUpdateTs(values[9]);
        this.setUpdateUserId(values[10]);
    }

    /** @param map */
    public MhrUser(final java.util.Map<String, Object> map) {
        this.setUserId(IgnoreCaseLinkedMap.get(map, "USER_ID"));
        this.setUserSei(IgnoreCaseLinkedMap.get(map, "USER_SEI"));
        this.setUserMei(IgnoreCaseLinkedMap.get(map, "USER_MEI"));
        this.setEMail(IgnoreCaseLinkedMap.get(map, "E_MAIL"));
        this.setPassword(IgnoreCaseLinkedMap.get(map, "PASSWORD"));
        this.setTekiyoBi(IgnoreCaseLinkedMap.get(map, "TEKIYO_BI"));
        this.setHaishiBi(IgnoreCaseLinkedMap.get(map, "HAISHI_BI"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.userId)) {
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
        isEmpty &= this.userSei == null || this.userSei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.userMei == null || this.userMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.eMail == null || this.eMail.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.password == null || this.password.toString().replaceAll("　| ", "").equals("");
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
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.id = Integer.valueOf(o.toString());
        } else {
            this.id = null;
        }
    }

    /** USER_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer userId;

    /** @return USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "USER_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getUserId() {
        return this.userId;
    }

    /** @param o USER_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.userId = Integer.valueOf(o.toString());
        } else {
            this.userId = null;
        }
    }

    /** USER_SEI */
    private String userSei;

    /** @return USER_SEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "USER_SEI", index = 3)
    public String getUserSei() {
        return this.userSei;
    }

    /** @param o USER_SEI */
    public void setUserSei(final Object o) {
        if (o != null) {
            this.userSei = o.toString();
        } else {
            this.userSei = null;
        }
    }

    /** USER_MEI */
    private String userMei;

    /** @return USER_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "USER_MEI", index = 4)
    public String getUserMei() {
        return this.userMei;
    }

    /** @param o USER_MEI */
    public void setUserMei(final Object o) {
        if (o != null) {
            this.userMei = o.toString();
        } else {
            this.userMei = null;
        }
    }

    /** E_MAIL */
    private String eMail;

    /** @return E_MAIL */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "E_MAIL", index = 5)
    public String getEMail() {
        return this.eMail;
    }

    /** @param o E_MAIL */
    public void setEMail(final Object o) {
        if (o != null) {
            this.eMail = o.toString();
        } else {
            this.eMail = null;
        }
    }

    /** PASSWORD */
    private String password;

    /** @return PASSWORD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PASSWORD", index = 6)
    public String getPassword() {
        return this.password;
    }

    /** @param o PASSWORD */
    public void setPassword(final Object o) {
        if (o != null) {
            this.password = o.toString();
        } else {
            this.password = null;
        }
    }

    /** TEKIYO_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate tekiyoBi;

    /** @return TEKIYO_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TEKIYO_BI", index = 7)
    public java.time.LocalDate getTekiyoBi() {
        return this.tekiyoBi;
    }

    /** @param o TEKIYO_BI */
    public void setTekiyoBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.tekiyoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.tekiyoBi = null;
        }
    }

    /** HAISHI_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate haishiBi;

    /** @return HAISHI_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HAISHI_BI", index = 8)
    public java.time.LocalDate getHaishiBi() {
        return this.haishiBi;
    }

    /** @param o HAISHI_BI */
    public void setHaishiBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.haishiBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.haishiBi = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 12)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 13)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 14)
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
     * ユーザマスタ照会
     * @param param1 ユーザID
     * @return ユーザマスタ
     */
    public static MhrUser get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"user_id\" = CAST (:user_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"user_id\" \n";
        sql += "    , a.\"user_sei\" \n";
        sql += "    , a.\"user_mei\" \n";
        sql += "    , a.\"e_mail\" \n";
        sql += "    , a.\"password\" \n";
        sql += "    , TO_CHAR (a.\"tekiyo_bi\", 'YYYY-MM-DD') AS tekiyo_bi \n";
        sql += "    , TO_CHAR (a.\"haishi_bi\", 'YYYY-MM-DD') AS haishi_bi \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    MHR_USER a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("user_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, MhrUser.class);
    }

    /**
     * ユーザマスタ追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // ユーザIDの採番処理
        numbering();

        // ユーザマスタの登録
        String sql = "INSERT INTO MHR_USER(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"user_id\" -- :user_id");
        nameList.add("\"user_sei\" -- :user_sei");
        nameList.add("\"user_mei\" -- :user_mei");
        nameList.add("\"e_mail\" -- :e_mail");
        nameList.add("\"password\" -- :password");
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
        valueList.add("CAST (:user_id AS INTEGER)");
        valueList.add(":user_sei");
        valueList.add(":user_mei");
        valueList.add(":e_mail");
        valueList.add(":password");
        valueList.add("TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD')");
        valueList.add("TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD')");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** ユーザIDの採番処理 */
    private void numbering() {
        if (this.userId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"user_id\") IS NULL THEN 0 ELSE MAX(e.\"user_id\") * 1 END + 1 AS \"user_id\" FROM MHR_USER e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("user_id");
        this.setUserId(o);
    }

    /**
     * ユーザマスタ更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // ユーザマスタの登録
        String sql = "UPDATE MHR_USER\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"user_id\" = CAST (:user_id AS INTEGER)");
        setList.add("\"user_sei\" = :user_sei");
        setList.add("\"user_mei\" = :user_mei");
        setList.add("\"e_mail\" = :e_mail");
        setList.add("\"password\" = :password");
        setList.add("\"tekiyo_bi\" = TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD')");
        setList.add("\"haishi_bi\" = TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD')");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * ユーザマスタ削除
     * @return 削除件数
     */
    public int delete() {

        // ユーザマスタの削除
        String sql = "DELETE FROM MHR_USER WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * ユーザマスタ全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // ユーザマスタの削除
        String sql = "TRUNCATE TABLE MHR_USER";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("user_id", this.userId);
        map.put("user_sei", this.userSei);
        map.put("user_mei", this.userMei);
        map.put("e_mail", this.eMail);
        map.put("password", this.password);
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
        whereList.add("\"user_id\" = CAST (:user_id AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
