package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T14_JISSEKI
 * @author emarfkrow
 */
public class T14Jisseki implements IEntity {

    /** デフォルトコンストラクタ */
    public T14Jisseki() {
    }

    /** @param values */
    public T14Jisseki(final String[] values) {
        this.setKouteiId(values[0]);
        this.setJissekiBn(values[1]);
        this.setJisshiYmd(values[2]);
        this.setKanryoYmd(values[3]);
        this.setInsertTs(values[4]);
        this.setInsertUserId(values[5]);
        this.setUpdateTs(values[6]);
        this.setUpdateUserId(values[7]);
    }

    /** @param map */
    public T14Jisseki(final java.util.Map<String, Object> map) {
        this.setKouteiId(IgnoreCaseLinkedMap.get(map, "KOUTEI_ID"));
        this.setJissekiBn(IgnoreCaseLinkedMap.get(map, "JISSEKI_BN"));
        this.setJisshiYmd(IgnoreCaseLinkedMap.get(map, "JISSHI_YMD"));
        this.setKanryoYmd(IgnoreCaseLinkedMap.get(map, "KANRYO_YMD"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.kouteiId)) {
            return true;
        } else if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.jissekiBn)) {
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
        isEmpty &= this.jisshiYmd == null || this.jisshiYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kanryoYmd == null || this.kanryoYmd.toString().replaceAll("　| ", "").equals("");
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

    /** 工程ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String kouteiMei;

    /** @return 工程ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "koutei_mei", index = 3)
    public String getKouteiMei() {
        return this.kouteiMei;
    }

    /** @param o 工程ID参照 */
    public void setKouteiMei(final Object o) {
        this.kouteiMei = null;
        if (o != null) {
            this.kouteiMei = o.toString();
        }
    }

    /** JISSEKI_BN */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer jissekiBn;

    /** @return JISSEKI_BN */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JISSEKI_BN", index = 4)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getJissekiBn() {
        return this.jissekiBn;
    }

    /** @param o JISSEKI_BN */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setJissekiBn(final Object o) {
        this.jissekiBn = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.jissekiBn = Integer.valueOf(o.toString());
        }
    }

    /** JISSHI_YMD */
    private String jisshiYmd;

    /** @return JISSHI_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JISSHI_YMD", index = 5)
    public String getJisshiYmd() {
        return this.jisshiYmd;
    }

    /** @param o JISSHI_YMD */
    public void setJisshiYmd(final Object o) {
        this.jisshiYmd = null;
        if (o != null) {
            this.jisshiYmd = o.toString();
        }
    }

    /** KANRYO_YMD */
    private String kanryoYmd;

    /** @return KANRYO_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KANRYO_YMD", index = 6)
    public String getKanryoYmd() {
        return this.kanryoYmd;
    }

    /** @param o KANRYO_YMD */
    public void setKanryoYmd(final Object o) {
        this.kanryoYmd = null;
        if (o != null) {
            this.kanryoYmd = o.toString();
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
     * 実績照会
     * @param param1 工程ID
     * @param param2 実績連番
     * @return 実績
     */
    public static T14Jisseki get(final Object param1, final Object param2) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"koutei_id\" = CAST (:koutei_id AS INTEGER)");
        whereList.add("\"jisseki_bn\" = CAST (:jisseki_bn AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"koutei_id\" \n";
        sql += "    , a.\"jisseki_bn\" \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"jisshi_ymd\") AS jisshi_ymd \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"kanryo_ymd\") AS kanryo_ymd \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    T14_JISSEKI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("koutei_id", param1);
        map.put("jisseki_bn", param2);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T14Jisseki.class);
    }

    /**
     * 実績追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 実績連番の採番処理
        numbering();

        String sql = "INSERT INTO T14_JISSEKI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"koutei_id\" -- :koutei_id");
        nameList.add("\"jisseki_bn\" -- :jisseki_bn");
        nameList.add("\"jisshi_ymd\" -- :jisshi_ymd");
        nameList.add("\"kanryo_ymd\" -- :kanryo_ymd");
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
        valueList.add("CAST (:jisseki_bn AS INTEGER)");
        valueList.add(":jisshi_ymd");
        valueList.add(":kanryo_ymd");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 実績連番の採番処理 */
    private void numbering() {
        if (this.jissekiBn != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"jisseki_bn\") IS NULL THEN 0 ELSE MAX(e.\"jisseki_bn\") * 1 END + 1 AS \"jisseki_bn\" FROM T14_JISSEKI e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("e.\"koutei_id\" = :koutei_id");
        sql += " WHERE " + String.join(" AND ", whereList);
        map.put("koutei_id", this.kouteiId);
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("JISSEKI_BN");
        this.setJissekiBn(o);
    }

    /**
     * 実績更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {
        String sql = "UPDATE T14_JISSEKI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"koutei_id\" = CAST (:koutei_id AS INTEGER)");
        setList.add("\"jisseki_bn\" = CAST (:jisseki_bn AS INTEGER)");
        setList.add("\"jisshi_ymd\" = :jisshi_ymd");
        setList.add("\"kanryo_ymd\" = :kanryo_ymd");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {
        String sql = "DELETE FROM T14_JISSEKI WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE T14_JISSEKI";
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
        map.put("jisseki_bn", this.jissekiBn);
        map.put("jisshi_ymd", this.jisshiYmd);
        map.put("kanryo_ymd", this.kanryoYmd);
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
        whereList.add("\"jisseki_bn\" = CAST (:jisseki_bn AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
