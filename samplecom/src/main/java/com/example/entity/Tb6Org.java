package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 起源
 * @author emarfkrow
 */
public class Tb6Org implements IEntity {

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

    /** 起源ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer orgId;

    /** @return 起源ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ORG_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getOrgId() {
        return this.orgId;
    }

    /** @param o 起源ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setOrgId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.orgId = Integer.valueOf(o.toString());
        } else {
            this.orgId = null;
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

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 4)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 5)
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

    /** 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 8)
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
    public static Tb6Org get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`ORG_ID` = :org_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`ORG_ID` \n";
        sql += "    , a.`ORG_INFO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB6_ORG a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("org_id", param1);
        return Queries.get(sql, map, Tb6Org.class);
    }

    /**
     * 起源追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 起源IDの採番処理
        numbering();

        // 起源明細の登録
        if (this.tb6OrgDets != null) {
            for (Tb6OrgDet tb6OrgDet : this.tb6OrgDets) {
                if (tb6OrgDet != null) {
                    tb6OrgDet.setOrgId(this.getOrgId());
                }
                tb6OrgDet.insert(now, execId);
            }
        }

        // 起源の登録
        String sql = "INSERT INTO TB6_ORG(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`ORG_ID` -- :org_id");
        nameList.add("`ORG_INFO` -- :org_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":org_id");
        valueList.add(":org_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 起源IDの採番処理 */
    private void numbering() {
        if (this.orgId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`ORG_ID`) IS NULL THEN 0 ELSE MAX(e.`ORG_ID`) * 1 END + 1 AS `ORG_ID` FROM TB6_ORG e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("ORG_ID");
        this.setOrgId(o);
    }

    /**
     * 起源更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 起源明細の登録
        if (this.tb6OrgDets != null) {
            for (Tb6OrgDet tb6OrgDet : this.tb6OrgDets) {
                if (tb6OrgDet == null) {
                    continue;
                }
                tb6OrgDet.setOrgId(this.orgId);
                try {
                    tb6OrgDet.insert(now, execId);
                } catch (Exception e) {
                    tb6OrgDet.update(now, execId);
                }
            }
        }

        // 起源の登録
        String sql = "UPDATE TB6_ORG\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`ORG_ID` = :org_id");
        setList.add("`ORG_INFO` = :org_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 起源削除
     * @return 削除件数
     */
    public int delete() {

        // 起源明細の削除
        if (this.tb6OrgDets != null) {
            for (Tb6OrgDet tb6OrgDet : this.tb6OrgDets) {
                if (tb6OrgDet.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "起源明細");
                }
            }
        }

        // 起源の削除
        String sql = "DELETE FROM TB6_ORG WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`ORG_ID` = :org_id");
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
        map.put("org_id", this.orgId);
        map.put("org_info", this.orgInfo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：起源明細
     */

    /** 起源明細のリスト */
    private List<Tb6OrgDet> tb6OrgDets;

    /** @return 起源明細のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb6OrgDets", index = 10)
    public List<Tb6OrgDet> getTb6OrgDets() {
        return this.tb6OrgDets;
    }

    /** @param list 起源明細のリスト */
    public void setTb6OrgDets(final List<Tb6OrgDet> list) {
        this.tb6OrgDets = list;
    }

    /** @param tb6OrgDet */
    public void addTb6OrgDets(final Tb6OrgDet tb6OrgDet) {
        if (this.tb6OrgDets == null) {
            this.tb6OrgDets = new ArrayList<Tb6OrgDet>();
        }
        this.tb6OrgDets.add(tb6OrgDet);
    }

    /** @return 起源明細のリスト */
    public List<Tb6OrgDet> referTb6OrgDets() {
        this.tb6OrgDets = Tb6Org.referTb6OrgDets(this.orgId);
        return this.tb6OrgDets;
    }

    /**
     * @param param1 orgId
     * @return List<Tb6OrgDet>
     */
    public static List<Tb6OrgDet> referTb6OrgDets(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("ORG_ID = :org_id");
        String sql = "SELECT ";
        sql += "`ORG_ID`";
        sql += ", `ORG_BN`";
        sql += ", `DET_INFO`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB6_ORG_DET a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "ORG_ID, ORG_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("org_id", param1);
        List<Tb6OrgDet> list = Queries.select(sql, map, Tb6OrgDet.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb6OrgDet>();
    }

    /*
     * 集約元：寄生
     */

    /** 寄生のリスト */
    private List<Tb6Kisei2> tb6Kisei2s;

    /** @return 寄生のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb6Kisei2s", index = 11)
    public List<Tb6Kisei2> getTb6Kisei2s() {
        return this.tb6Kisei2s;
    }

    /** @param list 寄生のリスト */
    public void setTb6Kisei2s(final List<Tb6Kisei2> list) {
        this.tb6Kisei2s = list;
    }

    /** @param tb6Kisei2 */
    public void addTb6Kisei2s(final Tb6Kisei2 tb6Kisei2) {
        if (this.tb6Kisei2s == null) {
            this.tb6Kisei2s = new ArrayList<Tb6Kisei2>();
        }
        this.tb6Kisei2s.add(tb6Kisei2);
    }

    /** @return 寄生のリスト */
    public List<Tb6Kisei2> referTb6Kisei2s() {
        this.tb6Kisei2s = Tb6Org.referTb6Kisei2s(this.orgId);
        return this.tb6Kisei2s;
    }

    /**
     * @param param1 orgId
     * @return List<Tb6Kisei2>
     */
    public static List<Tb6Kisei2> referTb6Kisei2s(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("ORG_ID = :org_id");
        String sql = "SELECT ";
        sql += "`KISEI2_ID`";
        sql += ", `ORG_INFO`";
        sql += ", `ORG_ID`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB6_KISEI2 a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "KISEI2_ID";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("org_id", param1);
        List<Tb6Kisei2> list = Queries.select(sql, map, Tb6Kisei2.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb6Kisei2>();
    }
}
