package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * 工程
 * @author emarfkrow
 */
public class T00Koutei implements IEntity {

    /** デフォルトコンストラクタ */
    public T00Koutei() {
    }

    /** @param values */
    public T00Koutei(final String[] values) {
        this.setKouteiId(values[0]);
        this.setKouteiMei(values[1]);
        this.setKaishiBi(values[2]);
        this.setShuryoBi(values[3]);
        this.setOyaKouteiId(values[4]);
        this.setInsertTs(values[5]);
        this.setInsertUserId(values[6]);
        this.setUpdateTs(values[7]);
        this.setUpdateUserId(values[8]);
    }

    /** @param map */
    public T00Koutei(final java.util.Map<String, Object> map) {
        this.setKouteiId(IgnoreCaseLinkedMap.get(map, "KOUTEI_ID"));
        this.setKouteiMei(IgnoreCaseLinkedMap.get(map, "KOUTEI_MEI"));
        this.setKaishiBi(IgnoreCaseLinkedMap.get(map, "KAISHI_BI"));
        this.setShuryoBi(IgnoreCaseLinkedMap.get(map, "SHURYO_BI"));
        this.setOyaKouteiId(IgnoreCaseLinkedMap.get(map, "OYA_KOUTEI_ID"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.kouteiId)) {
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
        isEmpty &= this.kouteiMei == null || this.kouteiMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kaishiBi == null || this.kaishiBi.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.shuryoBi == null || this.shuryoBi.toString().replaceAll("　| ", "").equals("");
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
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.id = Integer.valueOf(o.toString());
        } else {
            this.id = null;
        }
    }

    /** 工程ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer kouteiId;

    /** @return 工程ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getKouteiId() {
        return this.kouteiId;
    }

    /** @param o 工程ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKouteiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kouteiId = Integer.valueOf(o.toString());
        } else {
            this.kouteiId = null;
        }
    }

    /** 工程名 */
    private String kouteiMei;

    /** @return 工程名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_MEI", index = 3)
    public String getKouteiMei() {
        return this.kouteiMei;
    }

    /** @param o 工程名 */
    public void setKouteiMei(final Object o) {
        if (o != null) {
            this.kouteiMei = o.toString();
        } else {
            this.kouteiMei = null;
        }
    }

    /** 開始日 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate kaishiBi;

    /** @return 開始日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KAISHI_BI", index = 4)
    public java.time.LocalDate getKaishiBi() {
        return this.kaishiBi;
    }

    /** @param o 開始日 */
    public void setKaishiBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kaishiBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.kaishiBi = null;
        }
    }

    /** 終了日 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate shuryoBi;

    /** @return 終了日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SHURYO_BI", index = 5)
    public java.time.LocalDate getShuryoBi() {
        return this.shuryoBi;
    }

    /** @param o 終了日 */
    public void setShuryoBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.shuryoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.shuryoBi = null;
        }
    }

    /** 親工程ID */
    private Integer oyaKouteiId;

    /** @return 親工程ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_KOUTEI_ID", index = 6)
    public Integer getOyaKouteiId() {
        return this.oyaKouteiId;
    }

    /** @param o 親工程ID */
    public void setOyaKouteiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaKouteiId = Integer.valueOf(o.toString());
        } else {
            this.oyaKouteiId = null;
        }
    }

    /** 親工程ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String oyaKouteiMei;

    /** @return 親工程ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_KOUTEI_MEI", index = 7)
    public String getOyaKouteiMei() {
        return this.oyaKouteiMei;
    }

    /** @param o 親工程ID参照 */
    public void setOyaKouteiMei(final Object o) {
        if (o != null) {
            this.oyaKouteiMei = o.toString();
        } else {
            this.oyaKouteiMei = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 8)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o 作成タイムスタンプ */
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

    /** 作成者 */
    private String insertUserId;

    /** @return 作成者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 9)
    public String getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o 作成者 */
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 10)
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

    /** 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 11)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o 更新タイムスタンプ */
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

    /** 更新者 */
    private String updateUserId;

    /** @return 更新者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 12)
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o 更新者 */
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 13)
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
     * 工程照会
     * @param param1 工程ID
     * @return 工程
     */
    public static T00Koutei get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`KOUTEI_ID` = :koutei_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`KOUTEI_ID` \n";
        sql += "    , a.`KOUTEI_MEI` \n";
        sql += "    , a.`KAISHI_BI` AS KAISHI_BI \n";
        sql += "    , a.`SHURYO_BI` AS SHURYO_BI \n";
        sql += "    , a.`OYA_KOUTEI_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS INSERT_USER_ID \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T00_KOUTEI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("koutei_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T00Koutei.class);
    }

    /**
     * 工程追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime now, final String execId) {

        // 工程IDの採番処理
        numbering();

        // 工程の登録
        String sql = "INSERT INTO T00_KOUTEI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("`KOUTEI_ID` -- :koutei_id");
        nameList.add("`KOUTEI_MEI` -- :koutei_mei");
        nameList.add("`KAISHI_BI` -- :kaishi_bi");
        nameList.add("`SHURYO_BI` -- :shuryo_bi");
        nameList.add("`OYA_KOUTEI_ID` -- :oya_koutei_id");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":koutei_id");
        valueList.add(":koutei_mei");
        valueList.add(":kaishi_bi");
        valueList.add(":shuryo_bi");
        valueList.add(":oya_koutei_id");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 工程IDの採番処理 */
    private void numbering() {
        if (this.kouteiId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`KOUTEI_ID`) IS NULL THEN 0 ELSE MAX(e.`KOUTEI_ID`) * 1 END + 1 AS `KOUTEI_ID` FROM T00_KOUTEI e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("KOUTEI_ID");
        this.setKouteiId(o);
    }

    /**
     * 工程更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime now, final String execId) {

        // 工程の登録
        String sql = "UPDATE T00_KOUTEI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("`KOUTEI_ID` = :koutei_id");
        setList.add("`KOUTEI_MEI` = :koutei_mei");
        setList.add("`KAISHI_BI` = :kaishi_bi");
        setList.add("`SHURYO_BI` = :shuryo_bi");
        setList.add("`OYA_KOUTEI_ID` = :oya_koutei_id");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 工程削除
     * @return 削除件数
     */
    public int delete() {

        // 工程の削除
        String sql = "DELETE FROM T00_KOUTEI WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime now, final String execId) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("koutei_id", this.kouteiId);
        map.put("koutei_mei", this.kouteiMei);
        map.put("kaishi_bi", this.kaishiBi);
        map.put("shuryo_bi", this.shuryoBi);
        map.put("oya_koutei_id", this.oyaKouteiId);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`KOUTEI_ID` = :koutei_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }
}
