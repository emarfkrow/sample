package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * MHR_SHOKUI_NINKA
 * @author emarfkrow
 */
public class MhrShokuiNinka implements IEntity {

    /** デフォルトコンストラクタ */
    public MhrShokuiNinka() {
    }

    /** @param values */
    public MhrShokuiNinka(final String[] values) {
        this.setBushoId(values[0]);
        this.setShokuiId(values[1]);
        this.setTableRe(values[2]);
        this.setKengenB(values[3]);
        this.setTekiyoBi(values[4]);
        this.setHaishiBi(values[5]);
        this.setInsertTs(values[6]);
        this.setInsertUserId(values[7]);
        this.setUpdateTs(values[8]);
        this.setUpdateUserId(values[9]);
    }

    /** @param map */
    public MhrShokuiNinka(final java.util.Map<String, Object> map) {
        this.setBushoId(IgnoreCaseLinkedMap.get(map, "BUSHO_ID"));
        this.setShokuiId(IgnoreCaseLinkedMap.get(map, "SHOKUI_ID"));
        this.setTableRe(IgnoreCaseLinkedMap.get(map, "TABLE_RE"));
        this.setKengenB(IgnoreCaseLinkedMap.get(map, "KENGEN_B"));
        this.setTekiyoBi(IgnoreCaseLinkedMap.get(map, "TEKIYO_BI"));
        this.setHaishiBi(IgnoreCaseLinkedMap.get(map, "HAISHI_BI"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.bushoId)) {
            return true;
        }
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.shokuiId)) {
            return true;
        }
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.tableRe)) {
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
        isEmpty &= this.kengenB == null || this.kengenB.toString().replaceAll("　| ", "").equals("");
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

    /** BUSHO_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer bushoId;

    /** @return BUSHO_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BUSHO_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getBushoId() {
        return this.bushoId;
    }

    /** @param o BUSHO_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setBushoId(final Object o) {
        this.bushoId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.bushoId = Integer.valueOf(o.toString());
        }
    }

    /** 部署ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String bushoMei;

    /** @return 部署ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "busho_mei", index = 3)
    public String getBushoMei() {
        return this.bushoMei;
    }

    /** @param o 部署ID参照 */
    public void setBushoMei(final Object o) {
        this.bushoMei = null;
        if (o != null) {
            this.bushoMei = o.toString();
        }
    }

    /** SHOKUI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer shokuiId;

    /** @return SHOKUI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SHOKUI_ID", index = 4)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getShokuiId() {
        return this.shokuiId;
    }

    /** @param o SHOKUI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setShokuiId(final Object o) {
        this.shokuiId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.shokuiId = Integer.valueOf(o.toString());
        }
    }

    /** 職位ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String shokuiMei;

    /** @return 職位ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "shokui_mei", index = 5)
    public String getShokuiMei() {
        return this.shokuiMei;
    }

    /** @param o 職位ID参照 */
    public void setShokuiMei(final Object o) {
        this.shokuiMei = null;
        if (o != null) {
            this.shokuiMei = o.toString();
        }
    }

    /** TABLE_RE */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String tableRe;

    /** @return TABLE_RE */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TABLE_RE", index = 6)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTableRe() {
        return this.tableRe;
    }

    /** @param o TABLE_RE */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTableRe(final Object o) {
        this.tableRe = null;
        if (o != null) {
            this.tableRe = o.toString();
        }
    }

    /** KENGEN_B */
    private Integer kengenB;

    /** @return KENGEN_B */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KENGEN_B", index = 7)
    public Integer getKengenB() {
        return this.kengenB;
    }

    /** @param o KENGEN_B */
    public void setKengenB(final Object o) {
        this.kengenB = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kengenB = Integer.valueOf(o.toString());
        }
    }

    /** TEKIYO_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate tekiyoBi;

    /** @return TEKIYO_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TEKIYO_BI", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "HAISHI_BI", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 12)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 13)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 14)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 15)
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
     * 認可マスタ照会
     * @param param1 部署ID
     * @param param2 職位ID
     * @param param3 テーブル正規表現
     * @return 認可マスタ
     */
    public static MhrShokuiNinka get(final Object param1, final Object param2, final Object param3) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"busho_id\" = CAST (:busho_id AS INTEGER)");
        whereList.add("\"shokui_id\" = CAST (:shokui_id AS INTEGER)");
        whereList.add("\"table_re\" = :table_re");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"busho_id\" \n";
        sql += "    , a.\"shokui_id\" \n";
        sql += "    , a.\"table_re\" \n";
        sql += "    , a.\"kengen_b\" \n";
        sql += "    , TO_CHAR (a.\"tekiyo_bi\", 'YYYY-MM-DD') AS tekiyo_bi \n";
        sql += "    , TO_CHAR (a.\"haishi_bi\", 'YYYY-MM-DD') AS haishi_bi \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    MHR_SHOKUI_NINKA a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("busho_id", param1);
        map.put("shokui_id", param2);
        map.put("table_re", param3);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, MhrShokuiNinka.class);
    }

    /**
     * 認可マスタ追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {
        String sql = "INSERT INTO MHR_SHOKUI_NINKA(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"busho_id\" -- :busho_id");
        nameList.add("\"shokui_id\" -- :shokui_id");
        nameList.add("\"table_re\" -- :table_re");
        nameList.add("\"kengen_b\" -- :kengen_b");
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
        valueList.add("CAST (:busho_id AS INTEGER)");
        valueList.add("CAST (:shokui_id AS INTEGER)");
        valueList.add(":table_re");
        valueList.add("CAST (:kengen_b AS INTEGER)");
        valueList.add("TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD')");
        valueList.add("TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD')");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 認可マスタ更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {
        String sql = "UPDATE MHR_SHOKUI_NINKA\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"busho_id\" = CAST (:busho_id AS INTEGER)");
        setList.add("\"shokui_id\" = CAST (:shokui_id AS INTEGER)");
        setList.add("\"table_re\" = :table_re");
        setList.add("\"kengen_b\" = CAST (:kengen_b AS INTEGER)");
        setList.add("\"tekiyo_bi\" = TO_DATE (SUBSTR (:tekiyo_bi, 0, 10), 'YYYY-MM-DD')");
        setList.add("\"haishi_bi\" = TO_DATE (SUBSTR (:haishi_bi, 0, 10), 'YYYY-MM-DD')");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {
        String sql = "DELETE FROM MHR_SHOKUI_NINKA WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE MHR_SHOKUI_NINKA";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("busho_id", this.bushoId);
        map.put("shokui_id", this.shokuiId);
        map.put("table_re", this.tableRe);
        map.put("kengen_b", this.kengenB);
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
        whereList.add("\"busho_id\" = CAST (:busho_id AS INTEGER)");
        whereList.add("\"shokui_id\" = CAST (:shokui_id AS INTEGER)");
        whereList.add("\"table_re\" = :table_re");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
