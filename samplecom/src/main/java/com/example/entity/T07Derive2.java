package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T07_DERIVE2
 * @author emarfkrow
 */
public class T07Derive2 implements IEntity {

    /** デフォルトコンストラクタ */
    public T07Derive2() {
    }

    /** @param values */
    public T07Derive2(final String[] values) {
        this.setDerive2Id(values[0]);
        this.setOrgInfo(values[1]);
        this.setOrgId(values[2]);
        this.setInsertTs(values[3]);
        this.setInsertUserId(values[4]);
        this.setUpdateTs(values[5]);
        this.setUpdateUserId(values[6]);
    }

    /** @param map */
    public T07Derive2(final java.util.Map<String, Object> map) {
        this.setDerive2Id(IgnoreCaseLinkedMap.get(map, "DERIVE2_ID"));
        this.setOrgInfo(IgnoreCaseLinkedMap.get(map, "ORG_INFO"));
        this.setOrgId(IgnoreCaseLinkedMap.get(map, "ORG_ID"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.derive2Id)) {
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
        isEmpty &= this.orgId == null || this.orgId.toString().replaceAll("　| ", "").equals("");
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

    /** DERIVE2_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer derive2Id;

    /** @return DERIVE2_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DERIVE2_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getDerive2Id() {
        return this.derive2Id;
    }

    /** @param o DERIVE2_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.derive2Id = Integer.valueOf(o.toString());
        } else {
            this.derive2Id = null;
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

    /** ORG_ID */
    private Integer orgId;

    /** @return ORG_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ORG_ID", index = 4)
    public Integer getOrgId() {
        return this.orgId;
    }

    /** @param o ORG_ID */
    public void setOrgId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.orgId = Integer.valueOf(o.toString());
        } else {
            this.orgId = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 5)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 10)
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
     * 派生２照会
     * @param param1 派生２ID
     * @return 派生２
     */
    public static T07Derive2 get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`DERIVE2_ID` = :derive_2_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`DERIVE2_ID` \n";
        sql += "    , a.`ORG_INFO` \n";
        sql += "    , a.`ORG_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS INSERT_USER_ID \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T07_DERIVE2 a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("derive_2_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T07Derive2.class);
    }

    /**
     * 派生２追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 派生２IDの採番処理
        numbering();

        // 派生２明細の登録
        if (this.t07Derive2Dets != null) {
            for (T07Derive2Det t07Derive2Det : this.t07Derive2Dets) {
                if (t07Derive2Det != null) {
                    t07Derive2Det.setDerive2Id(this.getDerive2Id());
                    t07Derive2Det.insert(at, by);
                }
            }
        }

        // 派生２の登録
        String sql = "INSERT INTO T07_DERIVE2(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("`DERIVE2_ID` -- :derive_2_id");
        nameList.add("`ORG_INFO` -- :org_info");
        nameList.add("`ORG_ID` -- :org_id");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":derive_2_id");
        valueList.add(":org_info");
        valueList.add(":org_id");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 派生２IDの採番処理 */
    private void numbering() {
        if (this.derive2Id != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`DERIVE2_ID`) IS NULL THEN 0 ELSE MAX(e.`DERIVE2_ID`) * 1 END + 1 AS `DERIVE2_ID` FROM T07_DERIVE2 e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("DERIVE2_ID");
        this.setDerive2Id(o);
    }

    /**
     * 派生２更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {

        // 派生２明細の登録
        if (this.t07Derive2Dets != null) {
            for (T07Derive2Det t07Derive2Det : this.t07Derive2Dets) {
                if (t07Derive2Det == null) {
                    continue;
                }
                t07Derive2Det.setDerive2Id(this.derive2Id);
                if (t07Derive2Det.isNew()) {
                    t07Derive2Det.insert(at, by);
                } else {
                    t07Derive2Det.update(at, by);
                }
            }
        }

        // 派生２の登録
        String sql = "UPDATE T07_DERIVE2\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("`DERIVE2_ID` = :derive_2_id");
        setList.add("`ORG_INFO` = :org_info");
        setList.add("`ORG_ID` = :org_id");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 派生２削除
     * @return 削除件数
     */
    public int delete() {

        // 派生２明細の削除
        if (this.t07Derive2Dets != null) {
            for (T07Derive2Det t07Derive2Det : this.t07Derive2Dets) {
                if (t07Derive2Det.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "派生２明細");
                }
            }
        }

        // 派生２の削除
        String sql = "DELETE FROM T07_DERIVE2 WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /**
     * 派生２全件削除
     * @return 削除件数
     */
    public static int truncate() {

        // 派生２明細のチェック
        if (jp.co.golorp.emarf.sql.Queries.select("SELECT COUNT (1) FROM T07_DERIVE2_DET", null, null).size() > 0) {
            throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.truncate", "T07_DERIVE2 by T07_DERIVE2_DET");
        }

        // 派生２の削除
        String sql = "TRUNCATE TABLE T07_DERIVE2";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("derive_2_id", this.derive2Id);
        map.put("org_info", this.orgInfo);
        map.put("org_id", this.orgId);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`DERIVE2_ID` = :derive_2_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }

    /*
     * 子モデル：派生２明細
     */

    /** 派生２明細のリスト */
    private java.util.List<T07Derive2Det> t07Derive2Dets;

    /** @return 派生２明細のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T07Derive2Dets", index = 11)
    public java.util.List<T07Derive2Det> getT07Derive2Dets() {
        return this.t07Derive2Dets;
    }

    /** @param list 派生２明細のリスト */
    public void setT07Derive2Dets(final java.util.List<T07Derive2Det> list) {
        this.t07Derive2Dets = list;
    }

    /** @param t07Derive2Det */
    public void addT07Derive2Dets(final T07Derive2Det t07Derive2Det) {
        if (this.t07Derive2Dets == null) {
            this.t07Derive2Dets = new java.util.ArrayList<T07Derive2Det>();
        }
        this.t07Derive2Dets.add(t07Derive2Det);
    }

    /** @return 派生２明細のリスト */
    public java.util.List<T07Derive2Det> referT07Derive2Dets() {
        this.t07Derive2Dets = T07Derive2.referT07Derive2Dets(this.derive2Id);
        return this.t07Derive2Dets;
    }

    /**
     * @param param1 derive2Id
     * @return java.util.List<T07Derive2Det>
     */
    public static java.util.List<T07Derive2Det> referT07Derive2Dets(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("DERIVE2_ID = :derive_2_id");
        String sql = "SELECT ";
        sql += "`DERIVE2_ID`";
        sql += ", `DERIVE2_BN`";
        sql += ", `DET_INFO`";
        sql += ", LEFT(DATE_FORMAT (`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", LEFT(DATE_FORMAT (`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM T07_DERIVE2_DET a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "DERIVE2_ID, DERIVE2_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("derive_2_id", param1);
        java.util.List<T07Derive2Det> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T07Derive2Det.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T07Derive2Det>();
    }
}
