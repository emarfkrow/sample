package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * V00_YOJITSU
 * @author emarfkrow
 */
public class V00Yojitsu implements IEntity {

    /** デフォルトコンストラクタ */
    public V00Yojitsu() {
    }

    /** @param values */
    public V00Yojitsu(final String[] values) {
        this.setKouteiId(values[0]);
        this.setKouteiTx(values[1]);
        this.setKaishiBi(values[2]);
        this.setShuryoBi(values[3]);
        this.setOyaKouteiId(values[4]);
        this.setJisshiBi(values[5]);
        this.setKanryoBi(values[6]);
    }

    /** @param map */
    public V00Yojitsu(final java.util.Map<String, Object> map) {
        this.setKouteiId(IgnoreCaseLinkedMap.get(map, "KOUTEI_ID"));
        this.setKouteiTx(IgnoreCaseLinkedMap.get(map, "KOUTEI_TX"));
        this.setKaishiBi(IgnoreCaseLinkedMap.get(map, "KAISHI_BI"));
        this.setShuryoBi(IgnoreCaseLinkedMap.get(map, "SHURYO_BI"));
        this.setOyaKouteiId(IgnoreCaseLinkedMap.get(map, "OYA_KOUTEI_ID"));
        this.setJisshiBi(IgnoreCaseLinkedMap.get(map, "JISSHI_BI"));
        this.setKanryoBi(IgnoreCaseLinkedMap.get(map, "KANRYO_BI"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.kouteiId)) {
            isNew = true;
        }
        return isNew;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.kouteiTx == null || this.kouteiTx.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kaishiBi == null || this.kaishiBi.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.shuryoBi == null || this.shuryoBi.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.oyaKouteiId == null || this.oyaKouteiId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.jisshiBi == null || this.jisshiBi.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kanryoBi == null || this.kanryoBi.toString().replaceAll("　| ", "").equals("");
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
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.id = Integer.valueOf(o.toString());
        } else {
            this.id = null;
        }
    }

    /** KOUTEI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer kouteiId;

    /** @return KOUTEI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getKouteiId() {
        return this.kouteiId;
    }

    /** @param o KOUTEI_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKouteiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kouteiId = Integer.valueOf(o.toString());
        } else {
            this.kouteiId = null;
        }
    }

    /** KOUTEI_TX */
    private String kouteiTx;

    /** @return KOUTEI_TX */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_TX", index = 3)
    public String getKouteiTx() {
        return this.kouteiTx;
    }

    /** @param o KOUTEI_TX */
    public void setKouteiTx(final Object o) {
        if (o != null) {
            this.kouteiTx = o.toString();
        } else {
            this.kouteiTx = null;
        }
    }

    /** KAISHI_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate kaishiBi;

    /** @return KAISHI_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KAISHI_BI", index = 4)
    public java.time.LocalDate getKaishiBi() {
        return this.kaishiBi;
    }

    /** @param o KAISHI_BI */
    public void setKaishiBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kaishiBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.kaishiBi = null;
        }
    }

    /** SHURYO_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate shuryoBi;

    /** @return SHURYO_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SHURYO_BI", index = 5)
    public java.time.LocalDate getShuryoBi() {
        return this.shuryoBi;
    }

    /** @param o SHURYO_BI */
    public void setShuryoBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.shuryoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.shuryoBi = null;
        }
    }

    /** OYA_KOUTEI_ID */
    private Integer oyaKouteiId;

    /** @return OYA_KOUTEI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_KOUTEI_ID", index = 6)
    public Integer getOyaKouteiId() {
        return this.oyaKouteiId;
    }

    /** @param o OYA_KOUTEI_ID */
    public void setOyaKouteiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaKouteiId = Integer.valueOf(o.toString());
        } else {
            this.oyaKouteiId = null;
        }
    }

    /** JISSHI_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate jisshiBi;

    /** @return JISSHI_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JISSHI_BI", index = 7)
    public java.time.LocalDate getJisshiBi() {
        return this.jisshiBi;
    }

    /** @param o JISSHI_BI */
    public void setJisshiBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.jisshiBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.jisshiBi = null;
        }
    }

    /** KANRYO_BI */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private java.time.LocalDate kanryoBi;

    /** @return KANRYO_BI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KANRYO_BI", index = 8)
    public java.time.LocalDate getKanryoBi() {
        return this.kanryoBi;
    }

    /** @param o KANRYO_BI */
    public void setKanryoBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.kanryoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.kanryoBi = null;
        }
    }

    /**
     * VIEW照会
     * @param param1 工程ID
     * @return VIEW
     */
    public static V00Yojitsu get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("`KOUTEI_ID` = :koutei_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`koutei_id` \n";
        sql += "    , a.`koutei_tx` \n";
        sql += "    , a.`kaishi_bi` AS kaishi_bi \n";
        sql += "    , a.`shuryo_bi` AS shuryo_bi \n";
        sql += "    , a.`oya_koutei_id` \n";
        sql += "    , a.`jisshi_bi` AS jisshi_bi \n";
        sql += "    , a.`kanryo_bi` AS kanryo_bi \n";
        sql += "FROM \n";
        sql += "    V00_YOJITSU a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("koutei_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, V00Yojitsu.class);
    }
}
