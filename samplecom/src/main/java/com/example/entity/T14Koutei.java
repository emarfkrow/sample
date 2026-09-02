package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T14_KOUTEI
 * @author emarfkrow
 */
public class T14Koutei implements IEntity {

    /** デフォルトコンストラクタ */
    public T14Koutei() {
    }

    /** @param values */
    public T14Koutei(final String[] values) {
        this.setKouteiId(values[0]);
        this.setKouteiMei(values[1]);
        this.setKaishiYmd(values[2]);
        this.setShuryoYmd(values[3]);
        this.setSagyokuCd(values[4]);
        this.setOyaKouteiId(values[5]);
        this.setInsertTs(values[6]);
        this.setInsertUserId(values[7]);
        this.setUpdateTs(values[8]);
        this.setUpdateUserId(values[9]);
    }

    /** @param map */
    public T14Koutei(final java.util.Map<String, Object> map) {
        this.setKouteiId(IgnoreCaseLinkedMap.get(map, "KOUTEI_ID"));
        this.setKouteiMei(IgnoreCaseLinkedMap.get(map, "KOUTEI_MEI"));
        this.setKaishiYmd(IgnoreCaseLinkedMap.get(map, "KAISHI_YMD"));
        this.setShuryoYmd(IgnoreCaseLinkedMap.get(map, "SHURYO_YMD"));
        this.setSagyokuCd(IgnoreCaseLinkedMap.get(map, "SAGYOKU_CD"));
        this.setOyaKouteiId(IgnoreCaseLinkedMap.get(map, "OYA_KOUTEI_ID"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.kouteiId)) {
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
        isEmpty &= this.kouteiMei == null || this.kouteiMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kaishiYmd == null || this.kaishiYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.shuryoYmd == null || this.shuryoYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.sagyokuCd == null || this.sagyokuCd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.oyaKouteiId == null || this.oyaKouteiId.toString().replaceAll("　| ", "").equals("");
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

    /** KOUTEI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer kouteiId;

    /** @return KOUTEI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getKouteiId() {
        return this.kouteiId;
    }

    /** @param o KOUTEI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKouteiId(final Object o) {
        this.kouteiId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kouteiId = Integer.valueOf(o.toString());
        }
    }

    /** KOUTEI_MEI */
    private String kouteiMei;

    /** @return KOUTEI_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_MEI", index = 3)
    public String getKouteiMei() {
        return this.kouteiMei;
    }

    /** @param o KOUTEI_MEI */
    public void setKouteiMei(final Object o) {
        this.kouteiMei = null;
        if (o != null) {
            this.kouteiMei = o.toString();
        }
    }

    /** KAISHI_YMD */
    private String kaishiYmd;

    /** @return KAISHI_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KAISHI_YMD", index = 4)
    public String getKaishiYmd() {
        return this.kaishiYmd;
    }

    /** @param o KAISHI_YMD */
    public void setKaishiYmd(final Object o) {
        this.kaishiYmd = null;
        if (o != null) {
            this.kaishiYmd = o.toString();
        }
    }

    /** SHURYO_YMD */
    private String shuryoYmd;

    /** @return SHURYO_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SHURYO_YMD", index = 5)
    public String getShuryoYmd() {
        return this.shuryoYmd;
    }

    /** @param o SHURYO_YMD */
    public void setShuryoYmd(final Object o) {
        this.shuryoYmd = null;
        if (o != null) {
            this.shuryoYmd = o.toString();
        }
    }

    /** SAGYOKU_CD */
    private String sagyokuCd;

    /** @return SAGYOKU_CD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAGYOKU_CD", index = 6)
    public String getSagyokuCd() {
        return this.sagyokuCd;
    }

    /** @param o SAGYOKU_CD */
    public void setSagyokuCd(final Object o) {
        this.sagyokuCd = null;
        if (o != null) {
            this.sagyokuCd = o.toString();
        }
    }

    /** OYA_KOUTEI_ID */
    private Integer oyaKouteiId;

    /** @return OYA_KOUTEI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_KOUTEI_ID", index = 7)
    public Integer getOyaKouteiId() {
        return this.oyaKouteiId;
    }

    /** @param o OYA_KOUTEI_ID */
    public void setOyaKouteiId(final Object o) {
        this.oyaKouteiId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaKouteiId = Integer.valueOf(o.toString());
        }
    }

    /** 親工程ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String oyaKouteiMei;

    /** @return 親工程ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "oya_koutei_mei", index = 8)
    public String getOyaKouteiMei() {
        return this.oyaKouteiMei;
    }

    /** @param o 親工程ID参照 */
    public void setOyaKouteiMei(final Object o) {
        this.oyaKouteiMei = null;
        if (o != null) {
            this.oyaKouteiMei = o.toString();
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 12)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 13)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 14)
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
     * 工程照会
     * @param param1 工程ID
     * @return 工程
     */
    public static T14Koutei get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"koutei_id\" = CAST (:koutei_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"koutei_id\" \n";
        sql += "    , a.\"koutei_mei\" \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"kaishi_ymd\") AS kaishi_ymd \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"shuryo_ymd\") AS shuryo_ymd \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"sagyoku_cd\") AS sagyoku_cd \n";
        sql += "    , a.\"oya_koutei_id\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T14_KOUTEI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("koutei_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T14Koutei.class);
    }

    /**
     * 工程追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 工程IDの採番処理
        numbering();

        String sql = "INSERT INTO T14_KOUTEI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"koutei_id\" -- :koutei_id");
        nameList.add("\"koutei_mei\" -- :koutei_mei");
        nameList.add("\"kaishi_ymd\" -- :kaishi_ymd");
        nameList.add("\"shuryo_ymd\" -- :shuryo_ymd");
        nameList.add("\"sagyoku_cd\" -- :sagyoku_cd");
        nameList.add("\"oya_koutei_id\" -- :oya_koutei_id");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:koutei_id AS INTEGER)");
        valueList.add(":koutei_mei");
        valueList.add(":kaishi_ymd");
        valueList.add(":shuryo_ymd");
        valueList.add(":sagyoku_cd");
        valueList.add("CAST (:oya_koutei_id AS INTEGER)");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 工程IDの採番処理 */
    private void numbering() {
        if (this.kouteiId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"koutei_id\") IS NULL THEN 0 ELSE MAX(e.\"koutei_id\") * 1 END + 1 AS \"koutei_id\" FROM T14_KOUTEI e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("KOUTEI_ID");
        this.setKouteiId(o);
    }

    /**
     * 工程更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {
        String sql = "UPDATE T14_KOUTEI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"koutei_id\" = CAST (:koutei_id AS INTEGER)");
        setList.add("\"koutei_mei\" = :koutei_mei");
        setList.add("\"kaishi_ymd\" = :kaishi_ymd");
        setList.add("\"shuryo_ymd\" = :shuryo_ymd");
        setList.add("\"sagyoku_cd\" = :sagyoku_cd");
        setList.add("\"oya_koutei_id\" = CAST (:oya_koutei_id AS INTEGER)");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {
        String sql = "DELETE FROM T14_KOUTEI WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE T14_KOUTEI";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("koutei_id", this.kouteiId);
        map.put("koutei_mei", this.kouteiMei);
        map.put("kaishi_ymd", this.kaishiYmd);
        map.put("shuryo_ymd", this.shuryoYmd);
        map.put("sagyoku_cd", this.sagyokuCd);
        map.put("oya_koutei_id", this.oyaKouteiId);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"koutei_id\" = CAST (:koutei_id AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
