package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 派生２
 * @author emarfkrow
 */
public class Tb6Derive2 implements IEntity {

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

    /** 派生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer derive2Id;

    /** @return 派生２ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DERIVE2_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getDerive2Id() {
        return this.derive2Id;
    }

    /** @param o 派生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.derive2Id = Integer.valueOf(o.toString());
        } else {
            this.derive2Id = null;
        }
    }

    /** 起源情報 */
    private String orgInfo;

    /** @return 起源情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ORG_INFO", index = 3)
    public String getOrgInfo() {
        return this.orgInfo;
    }

    /** @param o 起源情報 */
    public void setOrgInfo(final Object o) {
        if (o != null) {
            this.orgInfo = o.toString();
        } else {
            this.orgInfo = null;
        }
    }

    /** 起源ID */
    private Integer orgId;

    /** @return 起源ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ORG_ID", index = 4)
    public Integer getOrgId() {
        return this.orgId;
    }

    /** @param o 起源ID */
    public void setOrgId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.orgId = Integer.valueOf(o.toString());
        } else {
            this.orgId = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 5)
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
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** 作成者 */
    private Integer insertUserId;

    /** @return 作成者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 6)
    public Integer getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o 作成者 */
    public void setInsertUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertUserId = Integer.valueOf(o.toString());
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

    /** 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 8)
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
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** 更新者 */
    private Integer updateUserId;

    /** @return 更新者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 9)
    public Integer getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o 更新者 */
    public void setUpdateUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateUserId = Integer.valueOf(o.toString());
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
    public static Tb6Derive2 get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`DERIVE2_ID` = :derive_2_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`DERIVE2_ID` \n";
        sql += "    , a.`ORG_INFO` \n";
        sql += "    , a.`ORG_ID` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB6_DERIVE2 a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("derive_2_id", param1);
        return Queries.get(sql, map, Tb6Derive2.class);
    }

    /**
     * 派生２追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 派生２IDの採番処理
        numbering();

        // 派生２明細の登録
        if (this.tb6Derive2Dets != null) {
            for (Tb6Derive2Det tb6Derive2Det : this.tb6Derive2Dets) {
                if (tb6Derive2Det != null) {
                    tb6Derive2Det.setDerive2Id(this.getDerive2Id());
                }
                tb6Derive2Det.insert(now, execId);
            }
        }

        // 派生２の登録
        String sql = "INSERT INTO TB6_DERIVE2(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
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
        List<String> valueList = new ArrayList<String>();
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
        String sql = "SELECT CASE WHEN MAX(e.`DERIVE2_ID`) IS NULL THEN 0 ELSE MAX(e.`DERIVE2_ID`) * 1 END + 1 AS `DERIVE2_ID` FROM TB6_DERIVE2 e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("DERIVE2_ID");
        this.setDerive2Id(o);
    }

    /**
     * 派生２更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 派生２明細の登録
        if (this.tb6Derive2Dets != null) {
            for (Tb6Derive2Det tb6Derive2Det : this.tb6Derive2Dets) {
                if (tb6Derive2Det == null) {
                    continue;
                }
                tb6Derive2Det.setDerive2Id(this.derive2Id);
                try {
                    tb6Derive2Det.insert(now, execId);
                } catch (Exception e) {
                    tb6Derive2Det.update(now, execId);
                }
            }
        }

        // 派生２の登録
        String sql = "UPDATE TB6_DERIVE2\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
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
        if (this.tb6Derive2Dets != null) {
            for (Tb6Derive2Det tb6Derive2Det : this.tb6Derive2Dets) {
                if (tb6Derive2Det.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "派生２明細");
                }
            }
        }

        // 派生２の削除
        String sql = "DELETE FROM TB6_DERIVE2 WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`DERIVE2_ID` = :derive_2_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private Map<String, Object> toMap(final LocalDateTime now, final String execId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("derive_2_id", this.derive2Id);
        map.put("org_info", this.orgInfo);
        map.put("org_id", this.orgId);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：派生２明細
     */

    /** 派生２明細のリスト */
    private List<Tb6Derive2Det> tb6Derive2Dets;

    /** @return 派生２明細のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb6Derive2Dets", index = 11)
    public List<Tb6Derive2Det> getTb6Derive2Dets() {
        return this.tb6Derive2Dets;
    }

    /** @param list 派生２明細のリスト */
    public void setTb6Derive2Dets(final List<Tb6Derive2Det> list) {
        this.tb6Derive2Dets = list;
    }

    /** @param tb6Derive2Det */
    public void addTb6Derive2Dets(final Tb6Derive2Det tb6Derive2Det) {
        if (this.tb6Derive2Dets == null) {
            this.tb6Derive2Dets = new ArrayList<Tb6Derive2Det>();
        }
        this.tb6Derive2Dets.add(tb6Derive2Det);
    }

    /** @return 派生２明細のリスト */
    public List<Tb6Derive2Det> referTb6Derive2Dets() {
        this.tb6Derive2Dets = Tb6Derive2.referTb6Derive2Dets(this.derive2Id);
        return this.tb6Derive2Dets;
    }

    /**
     * @param param1 derive2Id
     * @return List<Tb6Derive2Det>
     */
    public static List<Tb6Derive2Det> referTb6Derive2Dets(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("DERIVE2_ID = :derive_2_id");
        String sql = "SELECT ";
        sql += "`DERIVE2_ID`";
        sql += ", `DERIVE2_BN`";
        sql += ", `DET_INFO`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB6_DERIVE2_DET a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "DERIVE2_ID, DERIVE2_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("derive_2_id", param1);
        List<Tb6Derive2Det> list = Queries.select(sql, map, Tb6Derive2Det.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb6Derive2Det>();
    }
}
