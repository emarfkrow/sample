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
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer srcIdDestId;

    /** @return SRC_ID$DEST_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SRC_ID$DEST_ID", index = 3)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getSrcIdDestId() {
        return this.srcIdDestId;
    }

    /** @param o SRC_ID$DEST_ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
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

    /**
     * VIEW照会
     * @return VIEW
     */
    public static V13Furiwake get() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`TABLE_NAME` = :table_name");
        whereList.add("`SRC_ID$DEST_ID` = :src_id_dest_id");
        whereList.add("`INFO` = :info");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`table_name` \n";
        sql += "    , a.`SRC_ID$DEST_ID` \n";
        sql += "    , a.`info` \n";
        sql += "FROM \n";
        sql += "    V13_FURIWAKE a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        return Queries.get(sql, map, V13Furiwake.class);
    }
}
