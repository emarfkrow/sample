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

    /**
     * VIEW追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // VIEWの登録
        String sql = "INSERT INTO V13_FURIWAKE(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`TABLE_NAME` -- :table_name");
        nameList.add("`SRC_ID$DEST_ID` -- :src_id_dest_id");
        nameList.add("`INFO` -- :info");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":table_name");
        valueList.add(":src_id_dest_id");
        valueList.add(":info");
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
        String sql = "UPDATE V13_FURIWAKE\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`TABLE_NAME` = :table_name");
        setList.add("`SRC_ID$DEST_ID` = :src_id_dest_id");
        setList.add("`INFO` = :info");
        return String.join("\r\n    , ", setList);
    }

    /**
     * VIEW削除
     * @return 削除件数
     */
    public int delete() {

        // VIEWの削除
        String sql = "DELETE FROM V13_FURIWAKE WHERE " + getWhere();
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
        map.put("src_id$dest_id", this.srcIdDestId);
        map.put("info", this.info);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
