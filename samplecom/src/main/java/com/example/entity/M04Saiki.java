package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 再帰
 * @author emarfkrow
 */
public class M04Saiki implements IEntity {

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

    /** 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer saikiId;

    /** @return 再帰ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAIKI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getSaikiId() {
        return this.saikiId;
    }

    /** @param o 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setSaikiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.saikiId = Integer.valueOf(o.toString());
        } else {
            this.saikiId = null;
        }
    }

    /** 再帰名 */
    private String saikiMei;

    /** @return 再帰名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAIKI_MEI", index = 3)
    public String getSaikiMei() {
        return this.saikiMei;
    }

    /** @param o 再帰名 */
    public void setSaikiMei(final Object o) {
        if (o != null) {
            this.saikiMei = o.toString();
        } else {
            this.saikiMei = null;
        }
    }

    /** 参照ID */
    private Integer idrefId;

    /** @return 参照ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDREF_ID", index = 4)
    public Integer getIdrefId() {
        return this.idrefId;
    }

    /** @param o 参照ID */
    public void setIdrefId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.idrefId = Integer.valueOf(o.toString());
        } else {
            this.idrefId = null;
        }
    }

    /** 参照ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String idrefMei;

    /** @return 参照ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDREF_MEI", index = 5)
    public String getIdrefMei() {
        return this.idrefMei;
    }

    /** @param o 参照ID参照 */
    public void setIdrefMei(final Object o) {
        if (o != null) {
            this.idrefMei = o.toString();
        } else {
            this.idrefMei = null;
        }
    }

    /** 参照CD */
    private String cdrefCd;

    /** @return 参照CD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CDREF_CD", index = 6)
    public String getCdrefCd() {
        return this.cdrefCd;
    }

    /** @param o 参照CD */
    public void setCdrefCd(final Object o) {
        if (o != null) {
            this.cdrefCd = o.toString();
        } else {
            this.cdrefCd = null;
        }
    }

    /** 参照CD参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String cdrefMei;

    /** @return 参照CD参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CDREF_MEI", index = 7)
    public String getCdrefMei() {
        return this.cdrefMei;
    }

    /** @param o 参照CD参照 */
    public void setCdrefMei(final Object o) {
        if (o != null) {
            this.cdrefMei = o.toString();
        } else {
            this.cdrefMei = null;
        }
    }

    /** 参照NO */
    private String norefNo;

    /** @return 参照NO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NOREF_NO", index = 8)
    public String getNorefNo() {
        return this.norefNo;
    }

    /** @param o 参照NO */
    public void setNorefNo(final Object o) {
        if (o != null) {
            this.norefNo = o.toString();
        } else {
            this.norefNo = null;
        }
    }

    /** 参照NO参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String norefMei;

    /** @return 参照NO参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NOREF_MEI", index = 9)
    public String getNorefMei() {
        return this.norefMei;
    }

    /** @param o 参照NO参照 */
    public void setNorefMei(final Object o) {
        if (o != null) {
            this.norefMei = o.toString();
        } else {
            this.norefMei = null;
        }
    }

    /** ID連番ID */
    private Integer idbnId;

    /** @return ID連番ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDBN_ID", index = 10)
    public Integer getIdbnId() {
        return this.idbnId;
    }

    /** @param o ID連番ID */
    public void setIdbnId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.idbnId = Integer.valueOf(o.toString());
        } else {
            this.idbnId = null;
        }
    }

    /** ID連番 */
    private Integer idbnBn;

    /** @return ID連番 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDBN_BN", index = 11)
    public Integer getIdbnBn() {
        return this.idbnBn;
    }

    /** @param o ID連番 */
    public void setIdbnBn(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.idbnBn = Integer.valueOf(o.toString());
        } else {
            this.idbnBn = null;
        }
    }

    /** 親再帰ID */
    private Integer oyaSaikiId;

    /** @return 親再帰ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_SAIKI_ID", index = 12)
    public Integer getOyaSaikiId() {
        return this.oyaSaikiId;
    }

    /** @param o 親再帰ID */
    public void setOyaSaikiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaSaikiId = Integer.valueOf(o.toString());
        } else {
            this.oyaSaikiId = null;
        }
    }

    /** 親再帰ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String oyaSaikiMei;

    /** @return 親再帰ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_SAIKI_MEI", index = 13)
    public String getOyaSaikiMei() {
        return this.oyaSaikiMei;
    }

    /** @param o 親再帰ID参照 */
    public void setOyaSaikiMei(final Object o) {
        if (o != null) {
            this.oyaSaikiMei = o.toString();
        } else {
            this.oyaSaikiMei = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 14)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 15)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 16)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 17)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 18)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 19)
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
     * 再帰照会
     * @param param1 再帰ID
     * @return 再帰
     */
    public static M04Saiki get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`SAIKI_ID` = :saiki_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`SAIKI_ID` \n";
        sql += "    , a.`SAIKI_MEI` \n";
        sql += "    , a.`IDREF_ID` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`CDREF_CD`) AS CDREF_CD \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NOREF_NO`) AS NOREF_NO \n";
        sql += "    , a.`IDBN_ID` \n";
        sql += "    , a.`IDBN_BN` \n";
        sql += "    , a.`OYA_SAIKI_ID` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    M04_SAIKI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("saiki_id", param1);
        return Queries.get(sql, map, M04Saiki.class);
    }

    /**
     * 再帰追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 再帰IDの採番処理
        numbering();

        // 再帰の登録
        String sql = "INSERT INTO M04_SAIKI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`SAIKI_ID` -- :saiki_id");
        nameList.add("`SAIKI_MEI` -- :saiki_mei");
        nameList.add("`IDREF_ID` -- :idref_id");
        nameList.add("`CDREF_CD` -- :cdref_cd");
        nameList.add("`NOREF_NO` -- :noref_no");
        nameList.add("`IDBN_ID` -- :idbn_id");
        nameList.add("`IDBN_BN` -- :idbn_bn");
        nameList.add("`OYA_SAIKI_ID` -- :oya_saiki_id");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":saiki_id");
        valueList.add(":saiki_mei");
        valueList.add(":idref_id");
        valueList.add(":cdref_cd");
        valueList.add(":noref_no");
        valueList.add(":idbn_id");
        valueList.add(":idbn_bn");
        valueList.add(":oya_saiki_id");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 再帰IDの採番処理 */
    private void numbering() {
        if (this.saikiId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`SAIKI_ID`) IS NULL THEN 0 ELSE MAX(e.`SAIKI_ID`) * 1 END + 1 AS `SAIKI_ID` FROM M04_SAIKI e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("SAIKI_ID");
        this.setSaikiId(o);
    }

    /**
     * 再帰更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 再帰の登録
        String sql = "UPDATE M04_SAIKI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`SAIKI_ID` = :saiki_id");
        setList.add("`SAIKI_MEI` = :saiki_mei");
        setList.add("`IDREF_ID` = :idref_id");
        setList.add("`CDREF_CD` = :cdref_cd");
        setList.add("`NOREF_NO` = :noref_no");
        setList.add("`IDBN_ID` = :idbn_id");
        setList.add("`IDBN_BN` = :idbn_bn");
        setList.add("`OYA_SAIKI_ID` = :oya_saiki_id");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 再帰削除
     * @return 削除件数
     */
    public int delete() {

        // 再帰の削除
        String sql = "DELETE FROM M04_SAIKI WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`SAIKI_ID` = :saiki_id");
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
        map.put("saiki_id", this.saikiId);
        map.put("saiki_mei", this.saikiMei);
        map.put("idref_id", this.idrefId);
        map.put("cdref_cd", this.cdrefCd);
        map.put("noref_no", this.norefNo);
        map.put("idbn_id", this.idbnId);
        map.put("idbn_bn", this.idbnBn);
        map.put("oya_saiki_id", this.oyaSaikiId);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
