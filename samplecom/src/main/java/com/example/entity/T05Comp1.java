package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 複合１
 * @author emarfkrow
 */
public class T05Comp1 implements IEntity {

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

    /** 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer ref1Id;

    /** @return 参照１ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF1_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRef1Id() {
        return this.ref1Id;
    }

    /** @param o 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRef1Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.ref1Id = Integer.valueOf(o.toString());
        } else {
            this.ref1Id = null;
        }
    }

    /** 参照１ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String ref1Mei;

    /** @return 参照１ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF1_MEI", index = 3)
    public String getRef1Mei() {
        return this.ref1Mei;
    }

    /** @param o 参照１ID参照 */
    public void setRef1Mei(final Object o) {
        if (o != null) {
            this.ref1Mei = o.toString();
        } else {
            this.ref1Mei = null;
        }
    }

    /** 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer ref2Id;

    /** @return 参照２ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF2_ID", index = 4)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRef2Id() {
        return this.ref2Id;
    }

    /** @param o 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRef2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.ref2Id = Integer.valueOf(o.toString());
        } else {
            this.ref2Id = null;
        }
    }

    /** 参照２ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String ref2Mei;

    /** @return 参照２ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF2_MEI", index = 5)
    public String getRef2Mei() {
        return this.ref2Mei;
    }

    /** @param o 参照２ID参照 */
    public void setRef2Mei(final Object o) {
        if (o != null) {
            this.ref2Mei = o.toString();
        } else {
            this.ref2Mei = null;
        }
    }

    /** 複合１名 */
    private String comp1Mei;

    /** @return 複合１名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COMP1_MEI", index = 6)
    public String getComp1Mei() {
        return this.comp1Mei;
    }

    /** @param o 複合１名 */
    public void setComp1Mei(final Object o) {
        if (o != null) {
            this.comp1Mei = o.toString();
        } else {
            this.comp1Mei = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 11)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 12)
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
     * 複合１照会
     * @param param1 参照１ID
     * @param param2 参照２ID
     * @return 複合１
     */
    public static T05Comp1 get(final Object param1, final Object param2) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`REF1_ID` = :ref_1_id");
        whereList.add("`REF2_ID` = :ref_2_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`REF1_ID` \n";
        sql += "    , a.`REF2_ID` \n";
        sql += "    , a.`COMP1_MEI` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    T05_COMP1 a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ref_1_id", param1);
        map.put("ref_2_id", param2);
        return Queries.get(sql, map, T05Comp1.class);
    }

    /**
     * 複合１追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 複合２の登録
        if (this.t05Comp2s != null) {
            for (T05Comp2 t05Comp2 : this.t05Comp2s) {
                if (t05Comp2 != null) {
                    t05Comp2.setRef1Id(this.getRef1Id());
                    t05Comp2.setRef2Id(this.getRef2Id());
                }
                t05Comp2.insert(now, execId);
            }
        }

        // 複合１の登録
        String sql = "INSERT INTO T05_COMP1(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`REF1_ID` -- :ref_1_id");
        nameList.add("`REF2_ID` -- :ref_2_id");
        nameList.add("`COMP1_MEI` -- :comp_1_mei");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":ref_1_id");
        valueList.add(":ref_2_id");
        valueList.add(":comp_1_mei");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 複合１更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 複合２の登録
        if (this.t05Comp2s != null) {
            for (T05Comp2 t05Comp2 : this.t05Comp2s) {
                if (t05Comp2 == null) {
                    continue;
                }
                t05Comp2.setRef1Id(this.ref1Id);
                t05Comp2.setRef2Id(this.ref2Id);
                try {
                    t05Comp2.insert(now, execId);
                } catch (Exception e) {
                    t05Comp2.update(now, execId);
                }
            }
        }

        // 複合１の登録
        String sql = "UPDATE T05_COMP1\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`REF1_ID` = :ref_1_id");
        setList.add("`REF2_ID` = :ref_2_id");
        setList.add("`COMP1_MEI` = :comp_1_mei");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 複合１削除
     * @return 削除件数
     */
    public int delete() {

        // 複合２の削除
        if (this.t05Comp2s != null) {
            for (T05Comp2 t05Comp2 : this.t05Comp2s) {
                if (t05Comp2.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "複合２");
                }
            }
        }

        // 複合１の削除
        String sql = "DELETE FROM T05_COMP1 WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`REF1_ID` = :ref_1_id");
        whereList.add("`REF2_ID` = :ref_2_id");
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
        map.put("ref_1_id", this.ref1Id);
        map.put("ref_2_id", this.ref2Id);
        map.put("comp_1_mei", this.comp1Mei);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：複合２
     */

    /** 複合２のリスト */
    private List<T05Comp2> t05Comp2s;

    /** @return 複合２のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T05Comp2s", index = 13)
    public List<T05Comp2> getT05Comp2s() {
        return this.t05Comp2s;
    }

    /** @param list 複合２のリスト */
    public void setT05Comp2s(final List<T05Comp2> list) {
        this.t05Comp2s = list;
    }

    /** @param t05Comp2 */
    public void addT05Comp2s(final T05Comp2 t05Comp2) {
        if (this.t05Comp2s == null) {
            this.t05Comp2s = new ArrayList<T05Comp2>();
        }
        this.t05Comp2s.add(t05Comp2);
    }

    /** @return 複合２のリスト */
    public List<T05Comp2> referT05Comp2s() {
        this.t05Comp2s = T05Comp1.referT05Comp2s(this.ref1Id, this.ref2Id);
        return this.t05Comp2s;
    }

    /**
     * @param param1 ref1Id
     * @param param2 ref2Id
     * @return List<T05Comp2>
     */
    public static List<T05Comp2> referT05Comp2s(final Integer param1, final Integer param2) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("REF1_ID = :ref_1_id");
        whereList.add("REF2_ID = :ref_2_id");
        String sql = "SELECT ";
        sql += "`REF1_ID`";
        sql += ", (SELECT r0.`REF1_MEI` FROM M05_REF1 r0 WHERE r0.`REF1_ID` = a.`REF1_ID`) AS `REF1_MEI`";
        sql += ", `REF2_ID`";
        sql += ", (SELECT r1.`REF2_MEI` FROM M05_REF2 r1 WHERE r1.`REF2_ID` = a.`REF2_ID`) AS `REF2_MEI`";
        sql += ", `REF3_ID`";
        sql += ", (SELECT r2.`REF3_MEI` FROM M05_REF3 r2 WHERE r2.`REF3_ID` = a.`REF3_ID`) AS `REF3_MEI`";
        sql += ", `TEKIYO_BI` AS TEKIYO_BI";
        sql += ", `COMP2_INFO`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r3.`USER_SEI` FROM MHR_USER r3 WHERE r3.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r4.`USER_SEI` FROM MHR_USER r4 WHERE r4.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM T05_COMP2 a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "REF1_ID, REF2_ID, REF3_ID, TEKIYO_BI";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ref_1_id", param1);
        map.put("ref_2_id", param2);
        List<T05Comp2> list = Queries.select(sql, map, T05Comp2.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<T05Comp2>();
    }
}
