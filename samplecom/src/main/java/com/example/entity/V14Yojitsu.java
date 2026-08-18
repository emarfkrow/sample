package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * V14_YOJITSU
 * @author emarfkrow
 */
public class V14Yojitsu implements IEntity {

    /** デフォルトコンストラクタ */
    public V14Yojitsu() {
    }

    /** @param values */
    public V14Yojitsu(final String[] values) {
        this.setKouteiId(values[0]);
        this.setKouteiTx(values[1]);
        this.setKaishiYmd(values[2]);
        this.setShuryoYmd(values[3]);
        this.setSagyokuCd(values[4]);
        this.setOyaKouteiId(values[5]);
        this.setJisshiYmd(values[6]);
        this.setKanryoYmd(values[7]);
        this.setDependencies(values[8]);
        this.setKouteiPath(values[9]);
        this.setRoot(values[10]);
    }

    /** @param map */
    public V14Yojitsu(final java.util.Map<String, Object> map) {
        this.setKouteiId(IgnoreCaseLinkedMap.get(map, "KOUTEI_ID"));
        this.setKouteiTx(IgnoreCaseLinkedMap.get(map, "KOUTEI_TX"));
        this.setKaishiYmd(IgnoreCaseLinkedMap.get(map, "KAISHI_YMD"));
        this.setShuryoYmd(IgnoreCaseLinkedMap.get(map, "SHURYO_YMD"));
        this.setSagyokuCd(IgnoreCaseLinkedMap.get(map, "SAGYOKU_CD"));
        this.setOyaKouteiId(IgnoreCaseLinkedMap.get(map, "OYA_KOUTEI_ID"));
        this.setJisshiYmd(IgnoreCaseLinkedMap.get(map, "JISSHI_YMD"));
        this.setKanryoYmd(IgnoreCaseLinkedMap.get(map, "KANRYO_YMD"));
        this.setDependencies(IgnoreCaseLinkedMap.get(map, "DEPENDENCIES"));
        this.setKouteiPath(IgnoreCaseLinkedMap.get(map, "KOUTEI_PATH"));
        this.setRoot(IgnoreCaseLinkedMap.get(map, "ROOT"));
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
        isEmpty &= this.kaishiYmd == null || this.kaishiYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.shuryoYmd == null || this.shuryoYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.sagyokuCd == null || this.sagyokuCd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.oyaKouteiId == null || this.oyaKouteiId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.jisshiYmd == null || this.jisshiYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kanryoYmd == null || this.kanryoYmd.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.dependencies == null || this.dependencies.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kouteiPath == null || this.kouteiPath.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.root == null || this.root.toString().replaceAll("　| ", "").equals("");
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

    /** KAISHI_YMD */
    private String kaishiYmd;

    /** @return KAISHI_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KAISHI_YMD", index = 4)
    public String getKaishiYmd() {
        return this.kaishiYmd;
    }

    /** @param o KAISHI_YMD */
    public void setKaishiYmd(final Object o) {
        if (o != null) {
            this.kaishiYmd = o.toString();
        } else {
            this.kaishiYmd = null;
        }
    }

    /** SHURYO_YMD */
    private String shuryoYmd;

    /** @return SHURYO_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SHURYO_YMD", index = 5)
    public String getShuryoYmd() {
        return this.shuryoYmd;
    }

    /** @param o SHURYO_YMD */
    public void setShuryoYmd(final Object o) {
        if (o != null) {
            this.shuryoYmd = o.toString();
        } else {
            this.shuryoYmd = null;
        }
    }

    /** SAGYOKU_CD */
    private String sagyokuCd;

    /** @return SAGYOKU_CD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAGYOKU_CD", index = 6)
    public String getSagyokuCd() {
        return this.sagyokuCd;
    }

    /** @param o SAGYOKU_CD */
    public void setSagyokuCd(final Object o) {
        if (o != null) {
            this.sagyokuCd = o.toString();
        } else {
            this.sagyokuCd = null;
        }
    }

    /** OYA_KOUTEI_ID */
    private Integer oyaKouteiId;

    /** @return OYA_KOUTEI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_KOUTEI_ID", index = 7)
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

    /** JISSHI_YMD */
    private String jisshiYmd;

    /** @return JISSHI_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "JISSHI_YMD", index = 8)
    public String getJisshiYmd() {
        return this.jisshiYmd;
    }

    /** @param o JISSHI_YMD */
    public void setJisshiYmd(final Object o) {
        if (o != null) {
            this.jisshiYmd = o.toString();
        } else {
            this.jisshiYmd = null;
        }
    }

    /** KANRYO_YMD */
    private String kanryoYmd;

    /** @return KANRYO_YMD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KANRYO_YMD", index = 9)
    public String getKanryoYmd() {
        return this.kanryoYmd;
    }

    /** @param o KANRYO_YMD */
    public void setKanryoYmd(final Object o) {
        if (o != null) {
            this.kanryoYmd = o.toString();
        } else {
            this.kanryoYmd = null;
        }
    }

    /** DEPENDENCIES */
    private String dependencies;

    /** @return DEPENDENCIES */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DEPENDENCIES", index = 10)
    public String getDependencies() {
        return this.dependencies;
    }

    /** @param o DEPENDENCIES */
    public void setDependencies(final Object o) {
        if (o != null) {
            this.dependencies = o.toString();
        } else {
            this.dependencies = null;
        }
    }

    /** KOUTEI_PATH */
    private String kouteiPath;

    /** @return KOUTEI_PATH */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_PATH", index = 11)
    public String getKouteiPath() {
        return this.kouteiPath;
    }

    /** @param o KOUTEI_PATH */
    public void setKouteiPath(final Object o) {
        if (o != null) {
            this.kouteiPath = o.toString();
        } else {
            this.kouteiPath = null;
        }
    }

    /** ROOT */
    private java.math.BigDecimal root;

    /** @return ROOT */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ROOT", index = 12)
    public java.math.BigDecimal getRoot() {
        return this.root;
    }

    /** @param o ROOT */
    public void setRoot(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.root = new java.math.BigDecimal(o.toString());
        } else {
            this.root = null;
        }
    }

    /**
     * 予実照会
     * @param param1 koutei_id
     * @return 予実
     */
    public static V14Yojitsu get(final Object param1) {
        java.util.List<String> whereList = new java.util.ArrayList<String>();
        whereList.add("\"KOUTEI_ID\" = :koutei_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.\"KOUTEI_ID\" \n";
        sql += "    , a.\"KOUTEI_TX\" \n";
        sql += "    , RTRIM (RTRIM (a.\"KAISHI_YMD\"), '　') AS KAISHI_YMD \n";
        sql += "    , RTRIM (RTRIM (a.\"SHURYO_YMD\"), '　') AS SHURYO_YMD \n";
        sql += "    , RTRIM (RTRIM (a.\"SAGYOKU_CD\"), '　') AS SAGYOKU_CD \n";
        sql += "    , a.\"OYA_KOUTEI_ID\" \n";
        sql += "    , RTRIM (RTRIM (a.\"JISSHI_YMD\"), '　') AS JISSHI_YMD \n";
        sql += "    , RTRIM (RTRIM (a.\"KANRYO_YMD\"), '　') AS KANRYO_YMD \n";
        sql += "    , a.\"DEPENDENCIES\" \n";
        sql += "    , a.\"KOUTEI_PATH\" \n";
        sql += "    , a.\"ROOT\" \n";
        sql += "FROM \n";
        sql += "    V14_YOJITSU a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        map.put("koutei_id", param1);
        return jp.co.golorp.emarf.sql.Queries.get(sql, map, V14Yojitsu.class);
    }
}
