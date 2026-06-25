package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * T00_NOKEY
 * @author emarfkrow
 */
public class T00Nokey implements IEntity {

    /** デフォルトコンストラクタ */
    public T00Nokey() {
    }

    /** @param values */
    public T00Nokey(final String[] values) {
        this.setAMei(values[0]);
        this.setBMei(values[1]);
        this.setCMei(values[2]);
        this.setDMei(values[3]);
        this.setEMei(values[4]);
        this.setInsertTs(values[5]);
        this.setInsertUserId(values[6]);
        this.setUpdateTs(values[7]);
        this.setUpdateUserId(values[8]);
    }

    /** @param map */
    public T00Nokey(final java.util.Map<String, Object> map) {
        this.setAMei(IgnoreCaseLinkedMap.get(map, "A_MEI"));
        this.setBMei(IgnoreCaseLinkedMap.get(map, "B_MEI"));
        this.setCMei(IgnoreCaseLinkedMap.get(map, "C_MEI"));
        this.setDMei(IgnoreCaseLinkedMap.get(map, "D_MEI"));
        this.setEMei(IgnoreCaseLinkedMap.get(map, "E_MEI"));
        this.setInsertTs(IgnoreCaseLinkedMap.get(map, "INSERT_TS"));
        this.setInsertUserId(IgnoreCaseLinkedMap.get(map, "INSERT_USER_ID"));
        this.setUpdateTs(IgnoreCaseLinkedMap.get(map, "UPDATE_TS"));
        this.setUpdateUserId(IgnoreCaseLinkedMap.get(map, "UPDATE_USER_ID"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(this.updateTs)) {
            isNew = true;
        }
        return isNew;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.aMei == null || this.aMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.bMei == null || this.bMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.cMei == null || this.cMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.dMei == null || this.dMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.eMei == null || this.eMei.toString().replaceAll("　| ", "").equals("");
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

    /** A_MEI */
    private String aMei;

    /** @return A_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "A_MEI", index = 2)
    public String getAMei() {
        return this.aMei;
    }

    /** @param o A_MEI */
    public void setAMei(final Object o) {
        if (o != null) {
            this.aMei = o.toString();
        } else {
            this.aMei = null;
        }
    }

    /** B_MEI */
    private String bMei;

    /** @return B_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "B_MEI", index = 3)
    public String getBMei() {
        return this.bMei;
    }

    /** @param o B_MEI */
    public void setBMei(final Object o) {
        if (o != null) {
            this.bMei = o.toString();
        } else {
            this.bMei = null;
        }
    }

    /** C_MEI */
    private String cMei;

    /** @return C_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "C_MEI", index = 4)
    public String getCMei() {
        return this.cMei;
    }

    /** @param o C_MEI */
    public void setCMei(final Object o) {
        if (o != null) {
            this.cMei = o.toString();
        } else {
            this.cMei = null;
        }
    }

    /** D_MEI */
    private String dMei;

    /** @return D_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "D_MEI", index = 5)
    public String getDMei() {
        return this.dMei;
    }

    /** @param o D_MEI */
    public void setDMei(final Object o) {
        if (o != null) {
            this.dMei = o.toString();
        } else {
            this.dMei = null;
        }
    }

    /** E_MEI */
    private String eMei;

    /** @return E_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "E_MEI", index = 6)
    public String getEMei() {
        return this.eMei;
    }

    /** @param o E_MEI */
    public void setEMei(final Object o) {
        if (o != null) {
            this.eMei = o.toString();
        } else {
            this.eMei = null;
        }
    }

    /** INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return INSERT_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 7)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o INSERT_TS */
    public void setInsertTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.insertTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** INSERT_USER_ID */
    private String insertUserId;

    /** @return INSERT_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 8)
    public String getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o INSERT_USER_ID */
    public void setInsertUserId(final Object o) {
        if (o != null) {
            this.insertUserId = o.toString();
        } else {
            this.insertUserId = null;
        }
    }

    /** 作成者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String insertUserSei;

    /** @return 作成者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 9)
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

    /** UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return UPDATE_TS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 10)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o UPDATE_TS */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^.+\\+\\d{2}:\\d{2}$")) {
            java.time.Instant instant = java.time.Instant.parse(o.toString());
            this.updateTs = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** UPDATE_USER_ID */
    private String updateUserId;

    /** @return UPDATE_USER_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 11)
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o UPDATE_USER_ID */
    public void setUpdateUserId(final Object o) {
        if (o != null) {
            this.updateUserId = o.toString();
        } else {
            this.updateUserId = null;
        }
    }

    /** 更新者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String updateUserSei;

    /** @return 更新者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 12)
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
}
