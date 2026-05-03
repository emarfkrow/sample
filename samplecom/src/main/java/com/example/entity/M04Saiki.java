package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * 再帰
 * @author emarfkrow
 */
public class M04Saiki implements IEntity {

    /** デフォルトコンストラクタ */
    public M04Saiki() {
    }

    /** @param values */
    public M04Saiki(final String[] values) {
        this.setSaikiId(values[0]);
        this.setSaikiMei(values[1]);
        this.setIdrefId(values[2]);
        this.setCdrefCd(values[3]);
        this.setNorefNo(values[4]);
        this.setExIdrefId(values[5]);
        this.setExIdbnBn(values[6]);
        this.setOyaSaikiId(values[7]);
        this.setInsertTs(values[8]);
        this.setInsertUserId(values[9]);
        this.setUpdateTs(values[10]);
        this.setUpdateUserId(values[11]);
    }

    /** @param map */
    public M04Saiki(final java.util.Map<String, Object> map) {
        this.setSaikiId(IgnoreCaseLinkedMap.get(map, "SAIKI_ID"));
        this.setSaikiMei(IgnoreCaseLinkedMap.get(map, "SAIKI_MEI"));
        this.setIdrefId(IgnoreCaseLinkedMap.get(map, "IDREF_ID"));
        this.setCdrefCd(IgnoreCaseLinkedMap.get(map, "CDREF_CD"));
        this.setNorefNo(IgnoreCaseLinkedMap.get(map, "NOREF_NO"));
        this.setExIdrefId(IgnoreCaseLinkedMap.get(map, "EX_IDREF_ID"));
        this.setExIdbnBn(IgnoreCaseLinkedMap.get(map, "EX_IDBN_BN"));
        this.setOyaSaikiId(IgnoreCaseLinkedMap.get(map, "OYA_SAIKI_ID"));
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
    private Integer exIdrefId;

    /** @return ID連番ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_IDREF_ID", index = 10)
    public Integer getExIdrefId() {
        return this.exIdrefId;
    }

    /** @param o ID連番ID */
    public void setExIdrefId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.exIdrefId = Integer.valueOf(o.toString());
        } else {
            this.exIdrefId = null;
        }
    }

    /** ID連番ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String exIdrefMei;

    /** @return ID連番ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_IDREF_MEI", index = 11)
    public String getExIdrefMei() {
        return this.exIdrefMei;
    }

    /** @param o ID連番ID参照 */
    public void setExIdrefMei(final Object o) {
        if (o != null) {
            this.exIdrefMei = o.toString();
        } else {
            this.exIdrefMei = null;
        }
    }

    /** ID連番 */
    private Integer exIdbnBn;

    /** @return ID連番 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_IDBN_BN", index = 12)
    public Integer getExIdbnBn() {
        return this.exIdbnBn;
    }

    /** @param o ID連番 */
    public void setExIdbnBn(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.exIdbnBn = Integer.valueOf(o.toString());
        } else {
            this.exIdbnBn = null;
        }
    }

    /** 親再帰ID */
    private Integer oyaSaikiId;

    /** @return 親再帰ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_SAIKI_ID", index = 13)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_SAIKI_MEI", index = 14)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 15)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 16)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 17)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 18)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 19)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 20)
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
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`SAIKI_ID` = :saiki_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`SAIKI_ID` \n";
        sql += "    , a.`SAIKI_MEI` \n";
        sql += "    , a.`IDREF_ID` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`CDREF_CD`) AS CDREF_CD \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`NOREF_NO`) AS NOREF_NO \n";
        sql += "    , a.`EX_IDREF_ID` \n";
        sql += "    , a.`EX_IDBN_BN` \n";
        sql += "    , a.`OYA_SAIKI_ID` \n";
        sql += "    , LEFT(DATE_FORMAT (a.`INSERT_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS INSERT_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`INSERT_USER_ID`) AS INSERT_USER_ID \n";
        sql += "    , LEFT(DATE_FORMAT (a.`UPDATE_TS`, '%Y-%m-%dT%H:%i:%s.%f'), 23) AS UPDATE_TS \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`UPDATE_USER_ID`) AS UPDATE_USER_ID \n";
        sql += "FROM \n";
        sql += "    M04_SAIKI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("saiki_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, M04Saiki.class);
    }

    /**
     * 再帰追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime now, final String execId) {

        // 再帰IDの採番処理
        numbering();

        // 再帰の登録
        String sql = "INSERT INTO M04_SAIKI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("`SAIKI_ID` -- :saiki_id");
        nameList.add("`SAIKI_MEI` -- :saiki_mei");
        nameList.add("`IDREF_ID` -- :idref_id");
        nameList.add("`CDREF_CD` -- :cdref_cd");
        nameList.add("`NOREF_NO` -- :noref_no");
        nameList.add("`EX_IDREF_ID` -- :ex_idref_id");
        nameList.add("`EX_IDBN_BN` -- :ex_idbn_bn");
        nameList.add("`OYA_SAIKI_ID` -- :oya_saiki_id");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add(":saiki_id");
        valueList.add(":saiki_mei");
        valueList.add(":idref_id");
        valueList.add(":cdref_cd");
        valueList.add(":noref_no");
        valueList.add(":ex_idref_id");
        valueList.add(":ex_idbn_bn");
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
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("SAIKI_ID");
        this.setSaikiId(o);
    }

    /**
     * 再帰更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime now, final String execId) {

        // 再帰の登録
        String sql = "UPDATE M04_SAIKI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("`SAIKI_ID` = :saiki_id");
        setList.add("`SAIKI_MEI` = :saiki_mei");
        setList.add("`IDREF_ID` = :idref_id");
        setList.add("`CDREF_CD` = :cdref_cd");
        setList.add("`NOREF_NO` = :noref_no");
        setList.add("`EX_IDREF_ID` = :ex_idref_id");
        setList.add("`EX_IDBN_BN` = :ex_idbn_bn");
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
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`SAIKI_ID` = :saiki_id");
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
        map.put("saiki_id", this.saikiId);
        map.put("saiki_mei", this.saikiMei);
        map.put("idref_id", this.idrefId);
        map.put("cdref_cd", this.cdrefCd);
        map.put("noref_no", this.norefNo);
        map.put("ex_idref_id", this.exIdrefId);
        map.put("ex_idbn_bn", this.exIdbnBn);
        map.put("oya_saiki_id", this.oyaSaikiId);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
