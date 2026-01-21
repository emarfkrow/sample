package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 区分マスタ
 * @author emarfkrow
 */
public class MsyKbn implements IEntity {

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

    /** 区分名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kbnNm;

    /** @return 区分名称 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_NM", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKbnNm() {
        return this.kbnNm;
    }

    /** @param o 区分名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKbnNm(final Object o) {
        if (o != null) {
            this.kbnNm = o.toString();
        } else {
            this.kbnNm = null;
        }
    }

    /** 区分名 */
    private String kbnMei;

    /** @return 区分名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KBN_MEI", index = 3)
    public String getKbnMei() {
        return this.kbnMei;
    }

    /** @param o 区分名 */
    public void setKbnMei(final Object o) {
        if (o != null) {
            this.kbnMei = o.toString();
        } else {
            this.kbnMei = null;
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
     * 区分マスタ照会
     * @param param1 区分名称
     * @return 区分マスタ
     */
    public static MsyKbn get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KBN_NM` = :kbn_nm");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`KBN_NM` \n";
        sql += "    , a.`KBN_MEI` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    MSY_KBN a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("kbn_nm", param1);
        return Queries.get(sql, map, MsyKbn.class);
    }

    /**
     * 区分マスタ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 区分値マスタの登録
        if (this.msyKbnVals != null) {
            for (MsyKbnVal msyKbnVal : this.msyKbnVals) {
                if (msyKbnVal != null) {
                    msyKbnVal.setKbnNm(this.getKbnNm());
                }
                msyKbnVal.insert(now, execId);
            }
        }

        // 区分マスタの登録
        String sql = "INSERT INTO MSY_KBN(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`KBN_NM` -- :kbn_nm");
        nameList.add("`KBN_MEI` -- :kbn_mei");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":kbn_nm");
        valueList.add(":kbn_mei");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 区分マスタ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 区分値マスタの登録
        if (this.msyKbnVals != null) {
            for (MsyKbnVal msyKbnVal : this.msyKbnVals) {
                if (msyKbnVal == null) {
                    continue;
                }
                msyKbnVal.setKbnNm(this.kbnNm);
                try {
                    msyKbnVal.insert(now, execId);
                } catch (Exception e) {
                    msyKbnVal.update(now, execId);
                }
            }
        }

        // 区分マスタの登録
        String sql = "UPDATE MSY_KBN\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`KBN_NM` = :kbn_nm");
        setList.add("`KBN_MEI` = :kbn_mei");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
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
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`KBN_NM` = :kbn_nm");
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
        map.put("kbn_nm", this.kbnNm);
        map.put("kbn_mei", this.kbnMei);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：区分値マスタ
     */

    /** 区分値マスタのリスト */
    private List<MsyKbnVal> msyKbnVals;

    /** @return 区分値マスタのリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "MsyKbnVals", index = 10)
    public List<MsyKbnVal> getMsyKbnVals() {
        return this.msyKbnVals;
    }

    /** @param list 区分値マスタのリスト */
    public void setMsyKbnVals(final List<MsyKbnVal> list) {
        this.msyKbnVals = list;
    }

    /** @param msyKbnVal */
    public void addMsyKbnVals(final MsyKbnVal msyKbnVal) {
        if (this.msyKbnVals == null) {
            this.msyKbnVals = new ArrayList<MsyKbnVal>();
        }
        this.msyKbnVals.add(msyKbnVal);
    }

    /** @return 区分値マスタのリスト */
    public List<MsyKbnVal> referMsyKbnVals() {
        this.msyKbnVals = MsyKbn.referMsyKbnVals(this.kbnNm);
        return this.msyKbnVals;
    }

    /**
     * @param param1 kbnNm
     * @return List<MsyKbnVal>
     */
    public static List<MsyKbnVal> referMsyKbnVals(final String param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("KBN_NM = :kbn_nm");
        String sql = "SELECT ";
        sql += "`KBN_NM`";
        sql += ", `KBN_VAL`";
        sql += ", `KBN_VAL_MEI`";
        sql += ", `HYOJI_ON`";
        sql += ", `CRITERIA`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM MSY_KBN_VAL a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "KBN_NM, KBN_VAL";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("kbn_nm", param1);
        List<MsyKbnVal> list = Queries.select(sql, map, MsyKbnVal.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<MsyKbnVal>();
    }
}
