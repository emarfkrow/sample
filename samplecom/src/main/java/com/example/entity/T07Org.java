package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T07_ORG
 * @author emarfkrow
 */
public class T07Org implements IEntity {

    /** デフォルトコンストラクタ */
    public T07Org() {
    }

    /** @param values */
    public T07Org(final String[] values) {
        this.setOrgId(values[0]);
        this.setOrgInfo(values[1]);
        this.setInsertTs(values[2]);
        this.setInsertUserId(values[3]);
        this.setUpdateTs(values[4]);
        this.setUpdateUserId(values[5]);
    }

    /** @param map */
    public T07Org(final java.util.Map<String, Object> map) {
        this.setOrgId(IgnoreCaseLinkedMap.get(map, "ORG_ID"));
        this.setOrgInfo(IgnoreCaseLinkedMap.get(map, "ORG_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.orgId)) {
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
        isEmpty &= this.orgInfo == null || this.orgInfo.toString().replaceAll("　| ", "").equals("");
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

    /** ORG_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer orgId;

    /** @return ORG_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ORG_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getOrgId() {
        return this.orgId;
    }

    /** @param o ORG_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setOrgId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.orgId = Integer.valueOf(o.toString());
        } else {
            this.orgId = null;
        }
    }

    /** ORG_INFO */
    private String orgInfo;

    /** @return ORG_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ORG_INFO", index = 3)
    public String getOrgInfo() {
        return this.orgInfo;
    }

    /** @param o ORG_INFO */
    public void setOrgInfo(final Object o) {
        if (o != null) {
            this.orgInfo = o.toString();
        } else {
            this.orgInfo = null;
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
     * 起源照会
     * @param param1 起源ID
     * @return 起源
     */
    public static T07Org get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"ORG_ID\" = :org_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"ORG_ID\" \n";
        sql += "    , a.\"ORG_INFO\" \n";
        sql += "    , TO_CHAR (a.\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"INSERT_USER_ID\"), '　') AS INSERT_USER_ID \n";
        sql += "    , TO_CHAR (a.\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS \n";
        sql += "    , RTRIM (RTRIM (a.\"UPDATE_USER_ID\"), '　') AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T07_ORG a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("org_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T07Org.class);
    }

    /**
     * 起源追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 起源IDの採番処理
        numbering();

        // 起源明細の登録
        if (this.t07OrgDets != null) {
            for (T07OrgDet t07OrgDet : this.t07OrgDets) {
                if (t07OrgDet != null) {
                    t07OrgDet.setOrgId(this.getOrgId());
                    t07OrgDet.insert(at, by);
                }
            }
        }

        // 起源の登録
        String sql = "INSERT INTO T07_ORG(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"ORG_ID\" -- :org_id");
        nameList.add("\"ORG_INFO\" -- :org_info");
        nameList.add("\"INSERT_TS\" -- :insert_ts");
        nameList.add("\"INSERT_USER_ID\" -- :insert_user_id");
        nameList.add("\"UPDATE_TS\" -- :update_ts");
        nameList.add("\"UPDATE_USER_ID\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":org_id");
        valueList.add(":org_info");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 起源IDの採番処理 */
    private void numbering() {
        if (this.orgId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"ORG_ID\") IS NULL THEN 0 ELSE MAX(e.\"ORG_ID\") * 1 END + 1 AS \"ORG_ID\" FROM T07_ORG e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("ORG_ID");
        this.setOrgId(o);
    }

    /**
     * 起源更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 起源明細の登録
        if (this.t07OrgDets != null) {
            for (T07OrgDet t07OrgDet : this.t07OrgDets) {
                if (t07OrgDet == null) {
                    continue;
                }
                t07OrgDet.setOrgId(this.orgId);
                if (t07OrgDet.isNew()) {
                    t07OrgDet.insert(at, by);
                } else {
                    t07OrgDet.update(at, by);
                }
            }
        }

        // 起源の登録
        String sql = "UPDATE T07_ORG\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"ORG_ID\" = :org_id");
        setList.add("\"ORG_INFO\" = :org_info");
        setList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"UPDATE_USER_ID\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 起源削除
     * @return 削除件数
     */
    public int delete() {

        // 起源明細の削除
        if (this.t07OrgDets != null) {
            for (T07OrgDet t07OrgDet : this.t07OrgDets) {
                if (t07OrgDet.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "起源明細");
                }
            }
        }

        // 起源の削除
        String sql = "DELETE FROM T07_ORG WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 起源全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 起源明細のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T07_ORG_DET", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T07_ORG by T07_ORG_DET");
        }

        // 起源の削除
        String sql = "TRUNCATE TABLE T07_ORG";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("org_id", this.orgId);
        map.put("org_info", this.orgInfo);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"ORG_ID\" = :org_id");
        whereList.add("\"UPDATE_TS\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：起源明細
     */

    /** 起源明細のリスト */
    private java.util.List<T07OrgDet> t07OrgDets;

    /** @return 起源明細のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T07OrgDets", index = 10)
    public java.util.List<T07OrgDet> getT07OrgDets() {
        return this.t07OrgDets;
    }

    /** @param list 起源明細のリスト */
    public void setT07OrgDets(final java.util.List<T07OrgDet> list) {
        this.t07OrgDets = list;
    }

    /** @param t07OrgDet */
    public void addT07OrgDets(final T07OrgDet t07OrgDet) {
        if (this.t07OrgDets == null) {
            this.t07OrgDets = new java.util.ArrayList<T07OrgDet>();
        }
        this.t07OrgDets.add(t07OrgDet);
    }

    /** @return 起源明細のリスト */
    public java.util.List<T07OrgDet> referT07OrgDets() {
        this.t07OrgDets = T07Org.referT07OrgDets(this.orgId);
        return this.t07OrgDets;
    }

    /**
     * @param param1 orgId
     * @return java.util.List<T07OrgDet>
     */
    public static java.util.List<T07OrgDet> referT07OrgDets(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("ORG_ID = :org_id");
        String sql = "SELECT ";
        sql += "\"ORG_ID\"";
        sql += ", \"ORG_BN\"";
        sql += ", \"DET_INFO\"";
        sql += ", TO_CHAR (\"INSERT_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS INSERT_TS";
        sql += ", \"INSERT_USER_ID\"";
        sql += ", (SELECT r0.\"USER_SEI\" FROM MHR_USER r0 WHERE TO_CHAR (r0.\"USER_ID\") = a.\"INSERT_USER_ID\") AS \"INSERT_USER_SEI\"";
        sql += ", TO_CHAR (\"UPDATE_TS\", 'YYYY-MM-DD HH24:MI:SS.FF3') AS UPDATE_TS";
        sql += ", \"UPDATE_USER_ID\"";
        sql += ", (SELECT r1.\"USER_SEI\" FROM MHR_USER r1 WHERE TO_CHAR (r1.\"USER_ID\") = a.\"UPDATE_USER_ID\") AS \"UPDATE_USER_SEI\"";
        sql += " FROM T07_ORG_DET a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "ORG_ID, ORG_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("org_id", param1);
        java.util.List<T07OrgDet> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T07OrgDet.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T07OrgDet>();
    }
}
