package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * VIEW
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

    /** 変換元ID */
    private Integer srcId;

    /** @return 変換元ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "src_id", index = 3)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "dest_info", index = 4)
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
