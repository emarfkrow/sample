package com.example.entity;

import java.time.LocalDateTime;
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
public class Tb9Henkan implements IEntity {

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

    /**
     * VIEW照会
     * @return VIEW
     */
    public static Tb9Henkan get() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`TABLE_NAME` = :table_name");
        whereList.add("`SRC_ID` = :src_id");
        whereList.add("`DEST_INFO` = :dest_info");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`TABLE_NAME` \n";
        sql += "    , a.`SRC_ID` \n";
        sql += "    , a.`DEST_INFO` \n";
        sql += "FROM \n";
        sql += "    TB9_HENKAN a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        return Queries.get(sql, map, Tb9Henkan.class);
    }

    /**
     * VIEW追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // VIEWの登録
        String sql = "INSERT INTO TB9_HENKAN(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`TABLE_NAME` -- :table_name");
        nameList.add("`SRC_ID` -- :src_id");
        nameList.add("`DEST_INFO` -- :dest_info");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":table_name");
        valueList.add(":src_id");
        valueList.add(":dest_info");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * VIEW更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // VIEWの登録
        String sql = "UPDATE TB9_HENKAN\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`TABLE_NAME` = :table_name");
        setList.add("`SRC_ID` = :src_id");
        setList.add("`DEST_INFO` = :dest_info");
        return String.join("\r\n    , ", setList);
    }

    /**
     * VIEW削除
     * @return 削除件数
     */
    public int delete() {

        // VIEWの削除
        String sql = "DELETE FROM TB9_HENKAN WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        return String.join(" AND ", whereList);
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private Map<String, Object> toMap(final LocalDateTime now, final String execId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("table_name", this.tableName);
        map.put("src_id", this.srcId);
        map.put("dest_info", this.destInfo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
