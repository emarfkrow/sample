package com.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * VIEW
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
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer srcId;

    /** @return 変換元ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "src_id", index = 3)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getSrcId() {
        return this.srcId;
    }

    /** @param o 変換元ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
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

    /**
     * VIEW照会
     * @return VIEW
     */
    public static V13Henkan get() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`TABLE_NAME` = :table_name");
        whereList.add("`SRC_ID` = :src_id");
        whereList.add("`DEST_INFO` = :dest_info");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`table_name` \n";
        sql += "    , a.`src_id` \n";
        sql += "    , a.`dest_info` \n";
        sql += "FROM \n";
        sql += "    V13_HENKAN a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        return Queries.get(sql, map, V13Henkan.class);
    }
}
