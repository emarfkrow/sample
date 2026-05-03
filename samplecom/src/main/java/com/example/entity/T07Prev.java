package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * 前世
 * @author emarfkrow
 */
public class T07Prev implements IEntity {

    /** デフォルトコンストラクタ */
    public T07Prev() {
    }

    /** @param values */
    public T07Prev(final String[] values) {
        this.setPrevId(values[0]);
        this.setPrevInfo(values[1]);
        this.setInsertTs(values[2]);
        this.setInsertUserId(values[3]);
        this.setUpdateTs(values[4]);
        this.setUpdateUserId(values[5]);
    }

    /** @param map */
    public T07Prev(final java.util.Map<String, Object> map) {
        this.setPrevId(IgnoreCaseLinkedMap.get(map, "PREV_ID"));
        this.setPrevInfo(IgnoreCaseLinkedMap.get(map, "PREV_INFO"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
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

    /** 前世ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer prevId;

    /** @return 前世ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PREV_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getPrevId() {
        return this.prevId;
    }

    /** @param o 前世ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setPrevId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.prevId = Integer.valueOf(o.toString());
        } else {
            this.prevId = null;
        }
    }

    /** 前世情報 */
    private String prevInfo;

    /** @return 前世情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "PREV_INFO", index = 3)
    public String getPrevInfo() {
        return this.prevInfo;
    }

    /** @param o 前世情報 */
    public void setPrevInfo(final Object o) {
        if (o != null) {
            this.prevInfo = o.toString();
        } else {
            this.prevInfo = null;
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
    private String insertUserId;

    /** @return 作成者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 5)
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
    private String updateUserId;

    /** @return 更新者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 8)
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
     * 前世照会
     * @param param1 前世ID
     * @return 前世
     */
    public static T07Prev get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`PREV_ID` = :prev_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`PREV_ID` \n";
        sql += "    , a.`PREV_INFO` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS INSERT_USER_ID \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    T07_PREV a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, T07Prev.class);
    }

    /**
     * 前世追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime now, final String execId) {

        // 前世IDの採番処理
        numbering();

        // 前世明細の登録
        if (this.t07PrevDets != null) {
            for (T07PrevDet t07PrevDet : this.t07PrevDets) {
                if (t07PrevDet != null) {
                    t07PrevDet.setPrevId(this.getPrevId());
                }
                t07PrevDet.insert(now, execId);
            }
        }

        // 前世の登録
        String sql = "INSERT INTO T07_PREV(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("`PREV_ID` -- :prev_id");
        nameList.add("`PREV_INFO` -- :prev_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":prev_id");
        valueList.add(":prev_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 前世IDの採番処理 */
    private void numbering() {
        if (this.prevId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`PREV_ID`) IS NULL THEN 0 ELSE MAX(e.`PREV_ID`) * 1 END + 1 AS `PREV_ID` FROM T07_PREV e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("PREV_ID");
        this.setPrevId(o);
    }

    /**
     * 前世更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime now, final String execId) {

        // 前世明細の登録
        if (this.t07PrevDets != null) {
            for (T07PrevDet t07PrevDet : this.t07PrevDets) {
                if (t07PrevDet == null) {
                    continue;
                }
                t07PrevDet.setPrevId(this.prevId);
                try {
                    t07PrevDet.insert(now, execId);
                } catch (Exception e) {
                    t07PrevDet.update(now, execId);
                }
            }
        }

        // 前世の登録
        String sql = "UPDATE T07_PREV\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("`PREV_ID` = :prev_id");
        setList.add("`PREV_INFO` = :prev_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 前世削除
     * @return 削除件数
     */
    public int delete() {

        // 前世明細の削除
        if (this.t07PrevDets != null) {
            for (T07PrevDet t07PrevDet : this.t07PrevDets) {
                if (t07PrevDet.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "前世明細");
                }
            }
        }

        // 前世の削除
        String sql = "DELETE FROM T07_PREV WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`PREV_ID` = :prev_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime now, final String execId) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", this.prevId);
        map.put("prev_info", this.prevInfo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：前世明細
     */

    /** 前世明細のリスト */
    private java.util.List<T07PrevDet> t07PrevDets;

    /** @return 前世明細のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T07PrevDets", index = 10)
    public java.util.List<T07PrevDet> getT07PrevDets() {
        return this.t07PrevDets;
    }

    /** @param list 前世明細のリスト */
    public void setT07PrevDets(final java.util.List<T07PrevDet> list) {
        this.t07PrevDets = list;
    }

    /** @param t07PrevDet */
    public void addT07PrevDets(final T07PrevDet t07PrevDet) {
        if (this.t07PrevDets == null) {
            this.t07PrevDets = new java.util.ArrayList<T07PrevDet>();
        }
        this.t07PrevDets.add(t07PrevDet);
    }

    /** @return 前世明細のリスト */
    public java.util.List<T07PrevDet> referT07PrevDets() {
        this.t07PrevDets = T07Prev.referT07PrevDets(this.prevId);
        return this.t07PrevDets;
    }

    /**
     * @param param1 prevId
     * @return java.util.List<T07PrevDet>
     */
    public static java.util.List<T07PrevDet> referT07PrevDets(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("PREV_ID = :prev_id");
        String sql = "SELECT ";
        sql += "`PREV_ID`";
        sql += ", `PREV_BN`";
        sql += ", `DET_INFO`";
        sql += ", LEFT(DATE_FORMAT (`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", LEFT(DATE_FORMAT (`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM T07_PREV_DET a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "PREV_ID, PREV_BN";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", param1);
        java.util.List<T07PrevDet> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T07PrevDet.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T07PrevDet>();
    }

    /*
     * 転生先：転生
     */

    /** 転生のリスト */
    private java.util.List<T07Reborn> t07Reborns;

    /** @return 転生のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "T07Reborns", index = 11)
    public java.util.List<T07Reborn> getT07Reborns() {
        return this.t07Reborns;
    }

    /** @param list 転生のリスト */
    public void setT07Reborns(final java.util.List<T07Reborn> list) {
        this.t07Reborns = list;
    }

    /** @param t07Reborn */
    public void addT07Reborns(final T07Reborn t07Reborn) {
        if (this.t07Reborns == null) {
            this.t07Reborns = new java.util.ArrayList<T07Reborn>();
        }
        this.t07Reborns.add(t07Reborn);
    }

    /** @return 転生のリスト */
    public java.util.List<T07Reborn> referT07Reborns() {
        this.t07Reborns = T07Prev.referT07Reborns(this.prevId);
        return this.t07Reborns;
    }

    /**
     * @param param1 prevId
     * @return java.util.List<T07Reborn>
     */
    public static java.util.List<T07Reborn> referT07Reborns(final Integer param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("PREV_ID = :prev_id");
        String sql = "SELECT ";
        sql += "`REBORN_ID`";
        sql += ", `PREV_INFO`";
        sql += ", `PREV_ID`";
        sql += ", LEFT(DATE_FORMAT (`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", LEFT(DATE_FORMAT (`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM T07_REBORN a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "REBORN_ID";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("prev_id", param1);
        java.util.List<T07Reborn> list = jp.co.golorp.emarf.sql.Queries.select(sql, map, T07Reborn.class, null, null);
        if (list != null) {
            return list;
        }
        return new java.util.ArrayList<T07Reborn>();
    }
}
