package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 変遷履歴
 * @author emarfkrow
 */
public class T03TransHis implements IEntity {

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

    /** 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer transId;

    /** @return 変遷ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TRANS_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getTransId() {
        return this.transId;
    }

    /** @param o 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTransId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.transId = Integer.valueOf(o.toString());
        } else {
            this.transId = null;
        }
    }

    /** 変遷枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer transBn;

    /** @return 変遷枝番 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TRANS_BN", index = 3)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getTransBn() {
        return this.transBn;
    }

    /** @param o 変遷枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTransBn(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.transBn = Integer.valueOf(o.toString());
        } else {
            this.transBn = null;
        }
    }

    /** 変遷情報 */
    private String transInfo;

    /** @return 変遷情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TRANS_INFO", index = 4)
    public String getTransInfo() {
        return this.transInfo;
    }

    /** @param o 変遷情報 */
    public void setTransInfo(final Object o) {
        if (o != null) {
            this.transInfo = o.toString();
        } else {
            this.transInfo = null;
        }
    }

    /** 変更理由 */
    private String riyuTx;

    /** @return 変更理由 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "RIYU_TX", index = 5)
    public String getRiyuTx() {
        return this.riyuTx;
    }

    /** @param o 変更理由 */
    public void setRiyuTx(final Object o) {
        if (o != null) {
            this.riyuTx = o.toString();
        } else {
            this.riyuTx = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 9)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 10)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 11)
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
     * 変遷履歴照会
     * @param param1 変遷ID
     * @param param2 変遷枝番
     * @return 変遷履歴
     */
    public static T03TransHis get(final Object param1, final Object param2) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`TRANS_ID` = :trans_id");
        whereList.add("`TRANS_BN` = :trans_bn");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`TRANS_ID` \n";
        sql += "    , a.`TRANS_BN` \n";
        sql += "    , a.`TRANS_INFO` \n";
        sql += "    , a.`RIYU_TX` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    T03_TRANS_HIS a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("trans_id", param1);
        map.put("trans_bn", param2);
        return Queries.get(sql, map, T03TransHis.class);
    }

    /**
     * 変遷履歴追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 変遷枝番の採番処理
        numbering();

        // 変遷履歴の登録
        String sql = "INSERT INTO T03_TRANS_HIS(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`TRANS_ID` -- :trans_id");
        nameList.add("`TRANS_BN` -- :trans_bn");
        nameList.add("`TRANS_INFO` -- :trans_info");
        nameList.add("`RIYU_TX` -- :riyu_tx");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":trans_id");
        valueList.add(":trans_bn");
        valueList.add(":trans_info");
        valueList.add(":riyu_tx");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 変遷枝番の採番処理 */
    private void numbering() {
        if (this.transBn != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`TRANS_BN`) IS NULL THEN 0 ELSE MAX(e.`TRANS_BN`) * 1 END + 1 AS `TRANS_BN` FROM T03_TRANS_HIS e";
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> whereList = new ArrayList<String>();
        whereList.add("e.`TRANS_ID` = :trans_id");
        sql += " WHERE " + String.join(" AND ", whereList);
        map.put("trans_id", this.transId);
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("TRANS_BN");
        this.setTransBn(o);
    }

    /**
     * 変遷履歴更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 変遷履歴の登録
        String sql = "UPDATE T03_TRANS_HIS\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`TRANS_ID` = :trans_id");
        setList.add("`TRANS_BN` = :trans_bn");
        setList.add("`TRANS_INFO` = :trans_info");
        setList.add("`RIYU_TX` = :riyu_tx");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 変遷履歴削除
     * @return 削除件数
     */
    public int delete() {

        // 変遷履歴の削除
        String sql = "DELETE FROM T03_TRANS_HIS WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`TRANS_ID` = :trans_id");
        whereList.add("`TRANS_BN` = :trans_bn");
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
        map.put("trans_id", this.transId);
        map.put("trans_bn", this.transBn);
        map.put("trans_info", this.transInfo);
        map.put("riyu_tx", this.riyuTx);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
