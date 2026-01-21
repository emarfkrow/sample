package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 複合２
 * @author emarfkrow
 */
public class Tb1Combo2 implements IEntity {

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

    /** 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer refer1Id;

    /** @return 参照１ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REFER1_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRefer1Id() {
        return this.refer1Id;
    }

    /** @param o 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRefer1Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.refer1Id = Integer.valueOf(o.toString());
        } else {
            this.refer1Id = null;
        }
    }

    /** 参照１ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String refer1Mei;

    /** @return 参照１ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REFER1_MEI", index = 3)
    public String getRefer1Mei() {
        return this.refer1Mei;
    }

    /** @param o 参照１ID参照 */
    public void setRefer1Mei(final Object o) {
        if (o != null) {
            this.refer1Mei = o.toString();
        } else {
            this.refer1Mei = null;
        }
    }

    /** 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer refer2Id;

    /** @return 参照２ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REFER2_ID", index = 4)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRefer2Id() {
        return this.refer2Id;
    }

    /** @param o 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRefer2Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.refer2Id = Integer.valueOf(o.toString());
        } else {
            this.refer2Id = null;
        }
    }

    /** 参照２ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String refer2Mei;

    /** @return 参照２ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REFER2_MEI", index = 5)
    public String getRefer2Mei() {
        return this.refer2Mei;
    }

    /** @param o 参照２ID参照 */
    public void setRefer2Mei(final Object o) {
        if (o != null) {
            this.refer2Mei = o.toString();
        } else {
            this.refer2Mei = null;
        }
    }

    /** 参照３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer refer3Id;

    /** @return 参照３ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REFER3_ID", index = 6)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRefer3Id() {
        return this.refer3Id;
    }

    /** @param o 参照３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRefer3Id(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.refer3Id = Integer.valueOf(o.toString());
        } else {
            this.refer3Id = null;
        }
    }

    /** 参照３ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String refer3Mei;

    /** @return 参照３ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REFER3_MEI", index = 7)
    public String getRefer3Mei() {
        return this.refer3Mei;
    }

    /** @param o 参照３ID参照 */
    public void setRefer3Mei(final Object o) {
        if (o != null) {
            this.refer3Mei = o.toString();
        } else {
            this.refer3Mei = null;
        }
    }

    /** 適用日 */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private java.time.LocalDate tekiyoBi;

    /** @return 適用日 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TEKIYO_BI", index = 8)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public java.time.LocalDate getTekiyoBi() {
        return this.tekiyoBi;
    }

    /** @param o 適用日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTekiyoBi(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.tekiyoBi = java.time.LocalDate.parse(o.toString().substring(0, 10));
        } else {
            this.tekiyoBi = null;
        }
    }

    /** 複合２情報 */
    private String combo2Info;

    /** @return 複合２情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "COMBO2_INFO", index = 9)
    public String getCombo2Info() {
        return this.combo2Info;
    }

    /** @param o 複合２情報 */
    public void setCombo2Info(final Object o) {
        if (o != null) {
            this.combo2Info = o.toString();
        } else {
            this.combo2Info = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 10)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o 作成タイムスタンプ */
    public void setInsertTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** 作成者 */
    private Integer insertUserId;

    /** @return 作成者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 11)
    public Integer getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o 作成者 */
    public void setInsertUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertUserId = Integer.valueOf(o.toString());
        } else {
            this.insertUserId = null;
        }
    }

    /** 作成者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String insertUserSei;

    /** @return 作成者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 12)
    public String getInsertUserSei() {
        return this.insertUserSei;
    }

    /** @param o 作成者参照 */
    public void setInsertUserSei(final Object o) {
        if (o != null) {
            this.insertUserSei = o.toString();
        } else {
            this.insertUserSei = null;
        }
    }

    /** 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 13)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** 更新者 */
    private Integer updateUserId;

    /** @return 更新者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 14)
    public Integer getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o 更新者 */
    public void setUpdateUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateUserId = Integer.valueOf(o.toString());
        } else {
            this.updateUserId = null;
        }
    }

    /** 更新者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String updateUserSei;

    /** @return 更新者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 15)
    public String getUpdateUserSei() {
        return this.updateUserSei;
    }

    /** @param o 更新者参照 */
    public void setUpdateUserSei(final Object o) {
        if (o != null) {
            this.updateUserSei = o.toString();
        } else {
            this.updateUserSei = null;
        }
    }

    /**
     * 複合２照会
     * @param param1 参照１ID
     * @param param2 参照２ID
     * @param param3 参照３ID
     * @param param4 適用日
     * @return 複合２
     */
    public static Tb1Combo2 get(final Object param1, final Object param2, final Object param3, final Object param4) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`REFER1_ID` = :refer_1_id");
        whereList.add("`REFER2_ID` = :refer_2_id");
        whereList.add("`REFER3_ID` = :refer_3_id");
        whereList.add("`TEKIYO_BI` = :tekiyo_bi");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`REFER1_ID` \n";
        sql += "    , a.`REFER2_ID` \n";
        sql += "    , a.`REFER3_ID` \n";
        sql += "    , a.`TEKIYO_BI` AS TEKIYO_BI \n";
        sql += "    , a.`COMBO2_INFO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB1_COMBO2 a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("refer_1_id", param1);
        map.put("refer_2_id", param2);
        map.put("refer_3_id", param3);
        map.put("tekiyo_bi", param4);
        return Queries.get(sql, map, Tb1Combo2.class);
    }

    /**
     * 複合２追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 複合２の登録
        String sql = "INSERT INTO TB1_COMBO2(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`REFER1_ID` -- :refer_1_id");
        nameList.add("`REFER2_ID` -- :refer_2_id");
        nameList.add("`REFER3_ID` -- :refer_3_id");
        nameList.add("`TEKIYO_BI` -- :tekiyo_bi");
        nameList.add("`COMBO2_INFO` -- :combo_2_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":refer_1_id");
        valueList.add(":refer_2_id");
        valueList.add(":refer_3_id");
        valueList.add(":tekiyo_bi");
        valueList.add(":combo_2_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /**
     * 複合２更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 複合２の登録
        String sql = "UPDATE TB1_COMBO2\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`REFER1_ID` = :refer_1_id");
        setList.add("`REFER2_ID` = :refer_2_id");
        setList.add("`REFER3_ID` = :refer_3_id");
        setList.add("`TEKIYO_BI` = :tekiyo_bi");
        setList.add("`COMBO2_INFO` = :combo_2_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 複合２削除
     * @return 削除件数
     */
    public int delete() {

        // 複合２の削除
        String sql = "DELETE FROM TB1_COMBO2 WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`REFER1_ID` = :refer_1_id");
        whereList.add("`REFER2_ID` = :refer_2_id");
        whereList.add("`REFER3_ID` = :refer_3_id");
        whereList.add("`TEKIYO_BI` = :tekiyo_bi");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private Map<String, Object> toMap(final LocalDateTime now, final String execId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("refer_1_id", this.refer1Id);
        map.put("refer_2_id", this.refer2Id);
        map.put("refer_3_id", this.refer3Id);
        map.put("tekiyo_bi", this.tekiyoBi);
        map.put("combo_2_info", this.combo2Info);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
