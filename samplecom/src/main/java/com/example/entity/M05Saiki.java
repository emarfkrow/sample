package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * M05_SAIKI
 * @author emarfkrow
 */
public class M05Saiki implements IEntity {

    /** デフォルトコンストラクタ */
    public M05Saiki() {
    }

    /** @param values */
    public M05Saiki(final String[] values) {
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
    public M05Saiki(final java.util.Map<String, Object> map) {
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

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.saikiId)) {
            return true;
        }
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.updateTs)) {
            return true; // 楽観ロック値がなくてもINSERT
        }
        return false;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.saikiMei == null || this.saikiMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.idrefId == null || this.idrefId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.cdrefCd == null || this.cdrefCd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.norefNo == null || this.norefNo.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.exIdrefId == null || this.exIdrefId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.exIdbnBn == null || this.exIdbnBn.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.oyaSaikiId == null || this.oyaSaikiId.toString().replaceAll("　| ", "").equals("");
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
        this.id = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.id = Integer.valueOf(o.toString());
        }
    }

    /** SAIKI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer saikiId;

    /** @return SAIKI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAIKI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getSaikiId() {
        return this.saikiId;
    }

    /** @param o SAIKI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setSaikiId(final Object o) {
        this.saikiId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.saikiId = Integer.valueOf(o.toString());
        }
    }

    /** SAIKI_MEI */
    private String saikiMei;

    /** @return SAIKI_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAIKI_MEI", index = 3)
    public String getSaikiMei() {
        return this.saikiMei;
    }

    /** @param o SAIKI_MEI */
    public void setSaikiMei(final Object o) {
        this.saikiMei = null;
        if (o != null) {
            this.saikiMei = o.toString();
        }
    }

    /** IDREF_ID */
    private Integer idrefId;

    /** @return IDREF_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "IDREF_ID", index = 4)
    public Integer getIdrefId() {
        return this.idrefId;
    }

    /** @param o IDREF_ID */
    public void setIdrefId(final Object o) {
        this.idrefId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.idrefId = Integer.valueOf(o.toString());
        }
    }

    /** 参照ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String idrefMei;

    /** @return 参照ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "idref_mei", index = 5)
    public String getIdrefMei() {
        return this.idrefMei;
    }

    /** @param o 参照ID参照 */
    public void setIdrefMei(final Object o) {
        this.idrefMei = null;
        if (o != null) {
            this.idrefMei = o.toString();
        }
    }

    /** CDREF_CD */
    private String cdrefCd;

    /** @return CDREF_CD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CDREF_CD", index = 6)
    public String getCdrefCd() {
        return this.cdrefCd;
    }

    /** @param o CDREF_CD */
    public void setCdrefCd(final Object o) {
        this.cdrefCd = null;
        if (o != null) {
            this.cdrefCd = o.toString();
        }
    }

    /** 参照CD参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String cdrefMei;

    /** @return 参照CD参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "cdref_mei", index = 7)
    public String getCdrefMei() {
        return this.cdrefMei;
    }

    /** @param o 参照CD参照 */
    public void setCdrefMei(final Object o) {
        this.cdrefMei = null;
        if (o != null) {
            this.cdrefMei = o.toString();
        }
    }

    /** NOREF_NO */
    private String norefNo;

    /** @return NOREF_NO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "NOREF_NO", index = 8)
    public String getNorefNo() {
        return this.norefNo;
    }

    /** @param o NOREF_NO */
    public void setNorefNo(final Object o) {
        this.norefNo = null;
        if (o != null) {
            this.norefNo = o.toString();
        }
    }

    /** 参照NO参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String norefMei;

    /** @return 参照NO参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "noref_mei", index = 9)
    public String getNorefMei() {
        return this.norefMei;
    }

    /** @param o 参照NO参照 */
    public void setNorefMei(final Object o) {
        this.norefMei = null;
        if (o != null) {
            this.norefMei = o.toString();
        }
    }

    /** EX_IDREF_ID */
    private Integer exIdrefId;

    /** @return EX_IDREF_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_IDREF_ID", index = 10)
    public Integer getExIdrefId() {
        return this.exIdrefId;
    }

    /** @param o EX_IDREF_ID */
    public void setExIdrefId(final Object o) {
        this.exIdrefId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.exIdrefId = Integer.valueOf(o.toString());
        }
    }

    /** ID連番ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String exIdrefMei;

    /** @return ID連番ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ex_idref_mei", index = 11)
    public String getExIdrefMei() {
        return this.exIdrefMei;
    }

    /** @param o ID連番ID参照 */
    public void setExIdrefMei(final Object o) {
        this.exIdrefMei = null;
        if (o != null) {
            this.exIdrefMei = o.toString();
        }
    }

    /** EX_IDBN_BN */
    private Integer exIdbnBn;

    /** @return EX_IDBN_BN */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_IDBN_BN", index = 12)
    public Integer getExIdbnBn() {
        return this.exIdbnBn;
    }

    /** @param o EX_IDBN_BN */
    public void setExIdbnBn(final Object o) {
        this.exIdbnBn = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.exIdbnBn = Integer.valueOf(o.toString());
        }
    }

    /** ID連番参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String exIdbnNo;

    /** @return ID連番参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ex_idbn_no", index = 13)
    public String getExIdbnNo() {
        return this.exIdbnNo;
    }

    /** @param o ID連番参照 */
    public void setExIdbnNo(final Object o) {
        this.exIdbnNo = null;
        if (o != null) {
            this.exIdbnNo = o.toString();
        }
    }

    /** OYA_SAIKI_ID */
    private Integer oyaSaikiId;

    /** @return OYA_SAIKI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_SAIKI_ID", index = 14)
    public Integer getOyaSaikiId() {
        return this.oyaSaikiId;
    }

    /** @param o OYA_SAIKI_ID */
    public void setOyaSaikiId(final Object o) {
        this.oyaSaikiId = null;
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaSaikiId = Integer.valueOf(o.toString());
        }
    }

    /** 親再帰ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String oyaSaikiMei;

    /** @return 親再帰ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "oya_saiki_mei", index = 15)
    public String getOyaSaikiMei() {
        return this.oyaSaikiMei;
    }

    /** @param o 親再帰ID参照 */
    public void setOyaSaikiMei(final Object o) {
        this.oyaSaikiMei = null;
        if (o != null) {
            this.oyaSaikiMei = o.toString();
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 16)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o INSERT_TS */
    public void setInsertTs(final Object o) {
        this.insertTs = null;
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
        }
    }

    /** INSERT_USER_ID */
    private String insertUserId;

    /** @return INSERT_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 17)
    public String getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o INSERT_USER_ID */
    public void setInsertUserId(final Object o) {
        this.insertUserId = null;
        if (o != null) {
            this.insertUserId = o.toString();
        }
    }

    /** 作成者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String insertUserSei;

    /** @return 作成者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "insert_user_sei", index = 18)
    public String getInsertUserSei() {
        return this.insertUserSei;
    }

    /** @param o 作成者参照 */
    public void setInsertUserSei(final Object o) {
        this.insertUserSei = null;
        if (o != null) {
            this.insertUserSei = o.toString();
        }
    }

    /** UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 19)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o UPDATE_TS */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        this.updateTs = null;
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
        }
    }

    /** UPDATE_USER_ID */
    private String updateUserId;

    /** @return UPDATE_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 20)
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o UPDATE_USER_ID */
    public void setUpdateUserId(final Object o) {
        this.updateUserId = null;
        if (o != null) {
            this.updateUserId = o.toString();
        }
    }

    /** 更新者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String updateUserSei;

    /** @return 更新者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "update_user_sei", index = 21)
    public String getUpdateUserSei() {
        return this.updateUserSei;
    }

    /** @param o 更新者参照 */
    public void setUpdateUserSei(final Object o) {
        this.updateUserSei = null;
        if (o != null) {
            this.updateUserSei = o.toString();
        }
    }

    /**
     * 再帰照会
     * @param param1 再帰ID
     * @return 再帰
     */
    public static M05Saiki get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"saiki_id\" = CAST (:saiki_id AS INTEGER)");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"saiki_id\" \n";
        sql += "    , a.\"saiki_mei\" \n";
        sql += "    , a.\"idref_id\" \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"cdref_cd\") AS cdref_cd \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"noref_no\") AS noref_no \n";
        sql += "    , a.\"ex_idref_id\" \n";
        sql += "    , a.\"ex_idbn_bn\" \n";
        sql += "    , a.\"oya_saiki_id\" \n";
        sql += "    , TO_CHAR (a.\"insert_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS insert_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"insert_user_id\") AS insert_user_id \n";
        sql += "    , TO_CHAR (a.\"update_ts\", 'YYYY-MM-DD HH24:MI:SS.MS') AS update_ts \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.\"update_user_id\") AS update_user_id \n";
        sql += "FROM \n";
        sql += "    M05_SAIKI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("saiki_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, M05Saiki.class);
    }

    /**
     * 再帰追加
     * @param at システム日時
     * @param by 登録者
     * @return 追加件数
     */
    public int insert(final java.time.LocalDateTime at, final String by) {

        // 再帰IDの採番処理
        numbering();

        String sql = "INSERT INTO M05_SAIKI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return insert用のname句 */
    private String names() {
        java.util.List<String> nameList = new java.util.ArrayList<String>();
        nameList.add("\"saiki_id\" -- :saiki_id");
        nameList.add("\"saiki_mei\" -- :saiki_mei");
        nameList.add("\"idref_id\" -- :idref_id");
        nameList.add("\"cdref_cd\" -- :cdref_cd");
        nameList.add("\"noref_no\" -- :noref_no");
        nameList.add("\"ex_idref_id\" -- :ex_idref_id");
        nameList.add("\"ex_idbn_bn\" -- :ex_idbn_bn");
        nameList.add("\"oya_saiki_id\" -- :oya_saiki_id");
        nameList.add("\"insert_ts\" -- :insert_ts");
        nameList.add("\"insert_user_id\" -- :insert_user_id");
        nameList.add("\"update_ts\" -- :update_ts");
        nameList.add("\"update_user_id\" -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        java.util.List<String> valueList = new java.util.ArrayList<String>();
        valueList.add("CAST (:saiki_id AS INTEGER)");
        valueList.add(":saiki_mei");
        valueList.add("CAST (:idref_id AS INTEGER)");
        valueList.add(":cdref_cd");
        valueList.add(":noref_no");
        valueList.add("CAST (:ex_idref_id AS INTEGER)");
        valueList.add("CAST (:ex_idbn_bn AS INTEGER)");
        valueList.add("CAST (:oya_saiki_id AS INTEGER)");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:insert_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":insert_user_id");
        valueList.add("TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 再帰IDの採番処理 */
    private void numbering() {
        if (this.saikiId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.\"saiki_id\") IS NULL THEN 0 ELSE MAX(e.\"saiki_id\") * 1 END + 1 AS \"saiki_id\" FROM M05_SAIKI e";
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = jp.co.golorp.emarf.sql.Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("SAIKI_ID");
        this.setSaikiId(o);
    }

    /**
     * 再帰更新
     * @param at システム日時
     * @param by 更新者
     * @return 更新件数
     */
    public int update(final java.time.LocalDateTime at, final String by) {
        String sql = "UPDATE M05_SAIKI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(at, by));
    }

    /** @return update用のset句 */
    private String getSet() {
        java.util.List<String> setList = new java.util.ArrayList<String>();
        setList.add("\"saiki_id\" = CAST (:saiki_id AS INTEGER)");
        setList.add("\"saiki_mei\" = :saiki_mei");
        setList.add("\"idref_id\" = CAST (:idref_id AS INTEGER)");
        setList.add("\"cdref_cd\" = :cdref_cd");
        setList.add("\"noref_no\" = :noref_no");
        setList.add("\"ex_idref_id\" = CAST (:ex_idref_id AS INTEGER)");
        setList.add("\"ex_idbn_bn\" = CAST (:ex_idbn_bn AS INTEGER)");
        setList.add("\"oya_saiki_id\" = CAST (:oya_saiki_id AS INTEGER)");
        setList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR (:update_ts, 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        setList.add("\"update_user_id\" = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /** @return 削除件数 */
    public int delete() {
        String sql = "DELETE FROM M05_SAIKI WHERE " + getWhere();
        return jp.co.golorp.emarf.sql.Queries.regist(sql, toMap(null, null));
    }

    /** @return 削除件数 */
    public static int truncate() {
        String sql = "TRUNCATE TABLE M05_SAIKI";
        return jp.co.golorp.emarf.sql.Queries.regist(sql, null);
    }

    /**
     * @param at システム日時
     * @param by 実行ID
     * @return マップ化したエンティティ
     */
    private java.util.Map<String, Object> toMap(final java.time.LocalDateTime at, final String by) {
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("saiki_id", this.saikiId);
        map.put("saiki_mei", this.saikiMei);
        map.put("idref_id", this.idrefId);
        map.put("cdref_cd", this.cdrefCd);
        map.put("noref_no", this.norefNo);
        map.put("ex_idref_id", this.exIdrefId);
        map.put("ex_idbn_bn", this.exIdbnBn);
        map.put("oya_saiki_id", this.oyaSaikiId);
        map.put("insert_ts", at);
        map.put("insert_user_id", by);
        map.put("update_ts", at);
        map.put("update_user_id", by);
        return map;
    }

    /** @return where句 */
    private String getWhere() {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"saiki_id\" = CAST (:saiki_id AS INTEGER)");
        whereList.add("\"update_ts\" = TO_TIMESTAMP (REPLACE (SUBSTR ('" + this.updateTs + "', 0, 23), 'T', ' '), 'YYYY-MM-DD HH24:MI:SS.FF3')");
        return String.join(" AND ", whereList);
    }
}
