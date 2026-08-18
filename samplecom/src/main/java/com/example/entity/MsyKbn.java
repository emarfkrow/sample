package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * MSY_KBN
 * @author emarfkrow
 */
public class MsyKbn implements IEntity {

    /** デフォルトコンストラクタ */
    public MsyKbn() {
    }

    /** @param values */
    public MsyKbn(final String[] values) {
        this.setKbnNm(values[0]);
        this.setKbnMei(values[1]);
        this.setInsertTs(values[2]);
        this.setInsertUserId(values[3]);
        this.setUpdateTs(values[4]);
        this.setUpdateUserId(values[5]);
    }

    /** @param map */
    public MsyKbn(final java.util.Map<String, Object> map) {
        this.setKbnNm(IgnoreCaseLinkedMap.get(map, "KBN_NM"));
        this.setKbnMei(IgnoreCaseLinkedMap.get(map, "KBN_MEI"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.kbnNm)) {
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
        isEmpty &= this.kbnMei == null || this.kbnMei.toString().replaceAll("　| ", "").equals("");
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

    /** KBN_NM */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kbnNm;

    /** @return KBN_NM */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_NM", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKbnNm() {
        return this.kbnNm;
    }

    /** @param o KBN_NM */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKbnNm(final Object o) {
        if (o != null) {
            this.kbnNm = o.toString();
        } else {
            this.kbnNm = null;
        }
    }

    /** KBN_MEI */
    private String kbnMei;

    /** @return KBN_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_MEI", index = 3)
    public String getKbnMei() {
        return this.kbnMei;
    }

    /** @param o KBN_MEI */
    public void setKbnMei(final Object o) {
        if (o != null) {
            this.kbnMei = o.toString();
        } else {
            this.kbnMei = null;
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
     * 区分マスタ照会
     * @param param1 区分名称
     * @return 区分マスタ
     */
    public static MsyKbn get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"KBN_NM\" = :kbn_nm");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"KBN_NM\" \n";
        sql += "    , a.\"KBN_MEI\" \n";
        sql += "    , TO_CHAR (a.\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"INSERT_USER_ID\"), '　') AS INSERT_USER_ID \n";
        sql += "    , TO_CHAR (a.\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"UPDATE_USER_ID\"), '　') AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    MSY_KBN a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("kbn_nm", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, MsyKbn.class);
    }

    /**
     * 区分マスタ追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 区分値マスタの登録
        if (this.msyKbnVals != null) {
            for (MsyKbnVal msyKbnVal : this.msyKbnVals) {
                if (msyKbnVal != null) {
                    msyKbnVal.setKbnNm(this.getKbnNm());
                    msyKbnVal.insert(at, by);
                }
            }
        }

        // 区分マスタの登録
        String sql = "INSERT INTO MSY_KBN(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"KBN_NM\" -- :kbn_nm");
        nameList.add("\"KBN_MEI\" -- :kbn_mei");
        nameList.add("\"INSERT_TS\" -- :insert_ts");
        nameList.add("\"INSERT_USER_ID\" -- :insert_user_id");
        nameList.add("\"UPDATE_TS\" -- :update_ts");
        nameList.add("\"UPDATE_USER_ID\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":kbn_nm");
        valueList.add(":kbn_mei");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 区分マスタ更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 区分値マスタの登録
        if (this.msyKbnVals != null) {
            for (MsyKbnVal msyKbnVal : this.msyKbnVals) {
                if (msyKbnVal == null) {
                    continue;
                }
                msyKbnVal.setKbnNm(this.kbnNm);
                if (msyKbnVal.isNew()) {
                    msyKbnVal.insert(at, by);
                } else {
                    msyKbnVal.update(at, by);
                }
            }
        }

        // 区分マスタの登録
        String sql = "UPDATE MSY_KBN\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"KBN_NM\" = :kbn_nm");
        setList.add("\"KBN_MEI\" = :kbn_mei");
        setList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"UPDATE_USER_ID\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 区分マスタ削除
     * @return 削除件数
     */
    public int delete() {

        // 区分値マスタの削除
        if (this.msyKbnVals != null) {
            for (MsyKbnVal msyKbnVal : this.msyKbnVals) {
                if (msyKbnVal.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "区分値マスタ");
                }
            }
        }

        // 区分マスタの削除
        String sql = "DELETE FROM MSY_KBN WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 区分マスタ全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 区分値マスタのチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM MSY_KBN_VAL", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "MSY_KBN by MSY_KBN_VAL");
        }

        // 区分マスタの削除
        String sql = "TRUNCATE TABLE MSY_KBN";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("kbn_nm", this.kbnNm);
        map.put("kbn_mei", this.kbnMei);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"KBN_NM\" = :kbn_nm");
        whereList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：区分値マスタ
     */

    /** 区分値マスタのリスト */
    private java.util.List<MsyKbnVal> msyKbnVals;

    /** @return 区分値マスタのリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MsyKbnVals", index = 10)
    public java.util.List<MsyKbnVal> getMsyKbnVals() {
        return this.msyKbnVals;
    }

    /** @param list 区分値マスタのリスト */
    public void setMsyKbnVals(final java.util.List<MsyKbnVal> list) {
        this.msyKbnVals = list;
    }

    /** @param msyKbnVal */
    public void addMsyKbnVals(final MsyKbnVal msyKbnVal) {
        if (this.msyKbnVals == null) {
            this.msyKbnVals = new java.util.ArrayList<MsyKbnVal>();
        }
        this.msyKbnVals.add(msyKbnVal);
    }

    /** @return 区分値マスタのリスト */
    public java.util.List<MsyKbnVal> referMsyKbnVals() {
        this.msyKbnVals = MsyKbn.referMsyKbnVals(this.kbnNm);
        return this.msyKbnVals;
    }

    /**
     * @param param1 kbnNm
     * @return java.util.List<MsyKbnVal>
     */
    public static java.util.List<MsyKbnVal> referMsyKbnVals(final String param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("KBN_NM = :kbn_nm");
        String sql = "SELECT ";
        sql += "\"KBN_NM\"";
        sql += ", \"KBN_VAL\"";
        sql += ", \"KBN_VAL_MEI\"";
        sql += ", \"HYOJI_ON\"";
        sql += ", \"CRITERIA\"";
        sql += ", TO_CHAR (\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS";
        sql += ", \"INSERT_USER_ID\"";
        sql += ", (SELECT r0.\"USER_SEI\" FROM MHR_USER r0 WHERE TO_CHAR (r0.\"USER_ID\") = a.\"INSERT_USER_ID\") AS \"INSERT_USER_SEI\"";
        sql += ", TO_CHAR (\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS";
        sql += ", \"UPDATE_USER_ID\"";
        sql += ", (SELECT r1.\"USER_SEI\" FROM MHR_USER r1 WHERE TO_CHAR (r1.\"USER_ID\") = a.\"UPDATE_USER_ID\") AS \"UPDATE_USER_SEI\"";
        sql += " FROM MSY_KBN_VAL a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "KBN_NM, KBN_VAL";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("kbn_nm", param1);
        java.util.List<MsyKbnVal> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, MsyKbnVal.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<MsyKbnVal>();
    }
}
