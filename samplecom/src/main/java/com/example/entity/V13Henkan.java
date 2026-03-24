package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;

/**
 * 変換ビュー
 * @author emarfkrow
 */
public class V13Henkan implements IEntity {

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

    /** 変換元ID */
    private Integer srcId;

    /** @return 変換元ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SRC_ID", index = 3)
    public Integer getSrcId() {
        return this.srcId;
    }

    /** @param o 変換元ID */
    public void setSrcId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.srcId = Integer.valueOf(o.toString());
        } else {
            this.srcId = null;
        }
    }

    /** 変換元情報 */
    private String destInfo;

    /** @return 変換元情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DEST_INFO", index = 4)
    public String getDestInfo() {
        return this.destInfo;
    }

    /** @param o 変換元情報 */
    public void setDestInfo(final Object o) {
        if (o != null) {
            this.destInfo = o.toString();
        } else {
            this.destInfo = null;
        }
    }
}
