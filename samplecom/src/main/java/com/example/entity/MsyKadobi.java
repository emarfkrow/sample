package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * MSY_KADOBI
 * @author emarfkrow
 */
public class MsyKadobi implements IEntity {

    /** デフォルトコンストラクタ */
    public MsyKadobi() {
    }

    /** @param values */
    public MsyKadobi(final String[] values) {
        this.setKadoYmd(values[0]);
        this.setBushoId(values[1]);
        this.setKadobiF(values[2]);
        this.setMemo(values[3]);
        this.setInsertTs(values[4]);
        this.setInsertUserId(values[5]);
        this.setUpdateTs(values[6]);
        this.setUpdateUserId(values[7]);
    }

    /** @param map */
    public MsyKadobi(final java.util.Map<String, Object> map) {
        this.setKadoYmd(IgnoreCaseLinkedMap.get(map, "KADO_YMD"));
        this.setBushoId(IgnoreCaseLinkedMap.get(map, "BUSHO_ID"));
        this.setKadobiF(IgnoreCaseLinkedMap.get(map, "KADOBI_F"));
        this.setMemo(IgnoreCaseLinkedMap.get(map, "MEMO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.kadoYmd)) {
            isNew = true;
        }
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.bushoId)) {
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
        isEmpty &= this.kadobiF == null || this.kadobiF.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.memo == null || this.memo.toString().replaceAll("　| ", "").equals("");
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

    /** KADO_YMD */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kadoYmd;

    /** @return KADO_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KADO_YMD", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKadoYmd() {
        return this.kadoYmd;
    }

    /** @param o KADO_YMD */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKadoYmd(final Object o) {
        if (o != null) {
            this.kadoYmd = o.toString();
        } else {
            this.kadoYmd = null;
        }
    }

    /** BUSHO_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer bushoId;

    /** @return BUSHO_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BUSHO_ID", index = 3)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getBushoId() {
        return this.bushoId;
    }

    /** @param o BUSHO_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setBushoId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.bushoId = Integer.valueOf(o.toString());
        } else {
            this.bushoId = null;
        }
    }

    /** 部署ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String bushoMei;

    /** @return 部署ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "BUSHO_MEI", index = 4)
    public String getBushoMei() {
        return this.bushoMei;
    }

    /** @param o 部署ID参照 */
    public void setBushoMei(final Object o) {
        if (o != null) {
            this.bushoMei = o.toString();
        } else {
            this.bushoMei = null;
        }
    }

    /** KADOBI_F */
    private String kadobiF = "0";

    /** @return KADOBI_F */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KADOBI_F", index = 5)
    public String getKadobiF() {
        return this.kadobiF;
    }

    /** @param o KADOBI_F */
    public void setKadobiF(final Object o) {
        if (o != null) {
            this.kadobiF = o.toString();
        } else {
            this.kadobiF = null;
        }
    }

    /** MEMO */
    private String memo;

    /** @return MEMO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MEMO", index = 6)
    public String getMemo() {
        return this.memo;
    }

    /** @param o MEMO */
    public void setMemo(final Object o) {
        if (o != null) {
            this.memo = o.toString();
        } else {
            this.memo = null;
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 12)
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
     * 稼働日マスタ照会
     * @param param1 稼働年月日
     * @param param2 部署ID
     * @return 稼働日マスタ
     */
    public static MsyKadobi get(final Object param1, final Object param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("RTRIM (RTRIM (\"KADO_YMD\"), '　') = RTRIM (RTRIM (:kado_ymd), '　')");
        whereList.add("\"BUSHO_ID\" = :busho_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      RTRIM (RTRIM (a.\"KADO_YMD\"), '　') AS KADO_YMD \n";
        sql += "    , a.\"BUSHO_ID\" \n";
        sql += "    , RTRIM (RTRIM (a.\"KADOBI_F\"), '　') AS KADOBI_F \n";
        sql += "    , a.\"MEMO\" \n";
        sql += "    , TO_CHAR (a.\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"INSERT_USER_ID\"), '　') AS INSERT_USER_ID \n";
        sql += "    , TO_CHAR (a.\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"UPDATE_USER_ID\"), '　') AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    MSY_KADOBI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("kado_ymd", param1);
        map.put("busho_id", param2);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, MsyKadobi.class);
    }

    /**
     * 稼働日マスタ追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 稼働日マスタの登録
        String sql = "INSERT INTO MSY_KADOBI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"KADO_YMD\" -- :kado_ymd");
        nameList.add("\"BUSHO_ID\" -- :busho_id");
        nameList.add("\"KADOBI_F\" -- :kadobi_f");
        nameList.add("\"MEMO\" -- :memo");
        nameList.add("\"INSERT_TS\" -- :insert_ts");
        nameList.add("\"INSERT_USER_ID\" -- :insert_user_id");
        nameList.add("\"UPDATE_TS\" -- :update_ts");
        nameList.add("\"UPDATE_USER_ID\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":kado_ymd");
        valueList.add(":busho_id");
        valueList.add(":kadobi_f");
        valueList.add(":memo");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 稼働日マスタ更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 稼働日マスタの登録
        String sql = "UPDATE MSY_KADOBI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"KADO_YMD\" = :kado_ymd");
        setList.add("\"BUSHO_ID\" = :busho_id");
        setList.add("\"KADOBI_F\" = :kadobi_f");
        setList.add("\"MEMO\" = :memo");
        setList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"UPDATE_USER_ID\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 稼働日マスタ削除
     * @return 削除件数
     */
    public int delete() {

        // 稼働日マスタの削除
        String sql = "DELETE FROM MSY_KADOBI WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 稼働日マスタ全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 稼働日マスタの削除
        String sql = "TRUNCATE TABLE MSY_KADOBI";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("kado_ymd", this.kadoYmd);
        map.put("busho_id", this.bushoId);
        map.put("kadobi_f", this.kadobiF);
        map.put("memo", this.memo);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("RTRIM (RTRIM (\"KADO_YMD\"), '　') = RTRIM (RTRIM (:kado_ymd), '　')");
        whereList.add("\"BUSHO_ID\" = :busho_id");
        whereList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
