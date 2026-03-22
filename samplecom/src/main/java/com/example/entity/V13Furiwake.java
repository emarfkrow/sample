package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;

/**
 * VIEW
 * @author emarfkrow
 */
public class V13Furiwake implements IEntity {

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

    /** table_name */
    private String tableName;

    /** @return table_name */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "table_name", index = 2)
    public String getTableName() {
        return this.tableName;
    }

    /** @param o table_name */
    public void setTableName(final Object o) {
        if (o != null) {
            this.tableName = o.toString();
        } else {
            this.tableName = null;
        }
    }

    /** SRC_ID$DEST_ID */
    private Integer srcIdDestId;

    /** @return SRC_ID$DEST_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SRC_ID$DEST_ID", index = 3)
    public Integer getSrcIdDestId() {
        return this.srcIdDestId;
    }

    /** @param o SRC_ID$DEST_ID */
    public void setSrcIdDestId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.srcIdDestId = Integer.valueOf(o.toString());
        } else {
            this.srcIdDestId = null;
        }
    }

    /** info */
    private String info;

    /** @return info */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "info", index = 4)
    public String getInfo() {
        return this.info;
    }

    /** @param o info */
    public void setInfo(final Object o) {
        if (o != null) {
            this.info = o.toString();
        } else {
            this.info = null;
        }
    }
}
