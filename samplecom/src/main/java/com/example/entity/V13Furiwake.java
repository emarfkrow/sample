package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;

/**
 * 振分ビュー
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

    /** テーブル名 */
    private String tableName;

    /** @return テーブル名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TABLE_NAME", index = 2)
    public String getTableName() {
        return this.tableName;
    }

    /** @param o テーブル名 */
    public void setTableName(final Object o) {
        if (o != null) {
            this.tableName = o.toString();
        } else {
            this.tableName = null;
        }
    }

    /** 振分ID */
    private Integer srcIdDestId;

    /** @return 振分ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SRC_ID$DEST_ID", index = 3)
    public Integer getSrcIdDestId() {
        return this.srcIdDestId;
    }

    /** @param o 振分ID */
    public void setSrcIdDestId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.srcIdDestId = Integer.valueOf(o.toString());
        } else {
            this.srcIdDestId = null;
        }
    }

    /** 情報 */
    private String info;

    /** @return 情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INFO", index = 4)
    public String getInfo() {
        return this.info;
    }

    /** @param o 情報 */
    public void setInfo(final Object o) {
        if (o != null) {
            this.info = o.toString();
        } else {
            this.info = null;
        }
    }
}
