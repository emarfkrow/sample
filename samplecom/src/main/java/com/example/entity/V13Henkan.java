package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * V13_HENKAN
 * @author emarfkrow
 */
public class V13Henkan implements IEntity {

    /** デフォルトコンストラクタ */
    public V13Henkan() {
    }

    /** @param values */
    public V13Henkan(final String[] values) {
        this.setTableName(values[0]);
        this.setSrcId(values[1]);
        this.setDestInfo(values[2]);
    }

    /** @param map */
    public V13Henkan(final java.util.Map<String, Object> map) {
        this.setTableName(IgnoreCaseLinkedMap.get(map, "TABLE_NAME"));
        this.setSrcId(IgnoreCaseLinkedMap.get(map, "SRC_ID"));
        this.setDestInfo(IgnoreCaseLinkedMap.get(map, "DEST_INFO"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        return isNew;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.tableName == null || this.tableName.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.srcId == null || this.srcId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.destInfo == null || this.destInfo.toString().replaceAll("　| ", "").equals("");
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

    /** TABLE_NAME */
    private String tableName;

    /** @return TABLE_NAME */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TABLE_NAME", index = 2)
    public String getTableName() {
        return this.tableName;
    }

    /** @param o TABLE_NAME */
    public void setTableName(final Object o) {
        if (o != null) {
            this.tableName = o.toString();
        } else {
            this.tableName = null;
        }
    }

    /** SRC_ID */
    private Integer srcId;

    /** @return SRC_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SRC_ID", index = 3)
    public Integer getSrcId() {
        return this.srcId;
    }

    /** @param o SRC_ID */
    public void setSrcId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.srcId = Integer.valueOf(o.toString());
        } else {
            this.srcId = null;
        }
    }

    /** DEST_INFO */
    private String destInfo;

    /** @return DEST_INFO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DEST_INFO", index = 4)
    public String getDestInfo() {
        return this.destInfo;
    }

    /** @param o DEST_INFO */
    public void setDestInfo(final Object o) {
        if (o != null) {
            this.destInfo = o.toString();
        } else {
            this.destInfo = null;
        }
    }
}
