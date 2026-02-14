package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * IDマスタ
 * @author emarfkrow
 */
public class M04Id implements IEntity {

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

    /** 参照ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer idrefId;

    /** @return 参照ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDREF_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getIdrefId() {
        return this.idrefId;
    }

    /** @param o 参照ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setIdrefId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.idrefId = Integer.valueOf(o.toString());
        } else {
            this.idrefId = null;
        }
    }

    /** ID参照名 */
    private String idrefMei;

    /** @return ID参照名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDREF_MEI", index = 3)
    public String getIdrefMei() {
        return this.idrefMei;
    }

    /** @param o ID参照名 */
    public void setIdrefMei(final Object o) {
        if (o != null) {
            this.idrefMei = o.toString();
        } else {
            this.idrefMei = null;
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
     * IDマスタ照会
     * @param param1 参照ID
     * @return IDマスタ
     */
    public static M04Id get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`IDREF_ID` = :idref_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`IDREF_ID` \n";
        sql += "    , a.`IDREF_MEI` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    M04_ID a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idref_id", param1);
        return Queries.get(sql, map, M04Id.class);
    }

    /**
     * IDマスタ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 参照IDの採番処理
        numbering();

        // ID連番マスタの登録
        if (this.m04Idbns != null) {
            for (M04Idbn m04Idbn : this.m04Idbns) {
                if (m04Idbn != null) {
                    m04Idbn.setIdrefId(this.getIdrefId());
                }
                m04Idbn.insert(now, execId);
            }
        }

        // IDマスタの登録
        String sql = "INSERT INTO M04_ID(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`IDREF_ID` -- :idref_id");
        nameList.add("`IDREF_MEI` -- :idref_mei");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":idref_id");
        valueList.add(":idref_mei");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 参照IDの採番処理 */
    private void numbering() {
        if (this.idrefId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`IDREF_ID`) IS NULL THEN 0 ELSE MAX(e.`IDREF_ID`) * 1 END + 1 AS `IDREF_ID` FROM M04_ID e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("IDREF_ID");
        this.setIdrefId(o);
    }

    /**
     * IDマスタ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // ID連番マスタの登録
        if (this.m04Idbns != null) {
            for (M04Idbn m04Idbn : this.m04Idbns) {
                if (m04Idbn == null) {
                    continue;
                }
                m04Idbn.setIdrefId(this.idrefId);
                try {
                    m04Idbn.insert(now, execId);
                } catch (Exception e) {
                    m04Idbn.update(now, execId);
                }
            }
        }

        // IDマスタの登録
        String sql = "UPDATE M04_ID\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`IDREF_ID` = :idref_id");
        setList.add("`IDREF_MEI` = :idref_mei");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * IDマスタ削除
     * @return 削除件数
     */
    public int delete() {

        // ID連番マスタの削除
        if (this.m04Idbns != null) {
            for (M04Idbn m04Idbn : this.m04Idbns) {
                if (m04Idbn.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "ID連番マスタ");
                }
            }
        }

        // IDマスタの削除
        String sql = "DELETE FROM M04_ID WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`IDREF_ID` = :idref_id");
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
        map.put("idref_id", this.idrefId);
        map.put("idref_mei", this.idrefMei);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：ID連番マスタ
     */

    /** ID連番マスタのリスト */
    private List<M04Idbn> m04Idbns;

    /** @return ID連番マスタのリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "M04Idbns", index = 10)
    public List<M04Idbn> getM04Idbns() {
        return this.m04Idbns;
    }

    /** @param list ID連番マスタのリスト */
    public void setM04Idbns(final List<M04Idbn> list) {
        this.m04Idbns = list;
    }

    /** @param m04Idbn */
    public void addM04Idbns(final M04Idbn m04Idbn) {
        if (this.m04Idbns == null) {
            this.m04Idbns = new ArrayList<M04Idbn>();
        }
        this.m04Idbns.add(m04Idbn);
    }

    /** @return ID連番マスタのリスト */
    public List<M04Idbn> referM04Idbns() {
        this.m04Idbns = M04Id.referM04Idbns(this.idrefId);
        return this.m04Idbns;
    }

    /**
     * @param param1 idrefId
     * @return List<M04Idbn>
     */
    public static List<M04Idbn> referM04Idbns(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("IDREF_ID = :idref_id");
        String sql = "SELECT ";
        sql += "`IDREF_ID`";
        sql += ", `IDBN_BN`";
        sql += ", `IDBN_NO`";
        sql += ", LEFT(DATE_FORMAT (`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", LEFT(DATE_FORMAT (`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM M04_IDBN a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "IDREF_ID, IDBN_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idref_id", param1);
        List<M04Idbn> list = Queries.select(sql, map, M04Idbn.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<M04Idbn>();
    }
}
