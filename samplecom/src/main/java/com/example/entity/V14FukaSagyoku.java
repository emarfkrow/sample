package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * V14_FUKA_SAGYOKU
 * @author emarfkrow
 */
public class V14FukaSagyoku implements IEntity {

    /** デフォルトコンストラクタ */
    public V14FukaSagyoku() {
    }

    /** @param values */
    public V14FukaSagyoku(final String[] values) {
        this.setLabels(values[0]);
        this.setType(values[1]);
        this.setStack(values[2]);
        this.setLabel(values[3]);
        this.setData(values[4]);
    }

    /** @param map */
    public V14FukaSagyoku(final java.util.Map<String, Object> map) {
        this.setLabels(IgnoreCaseLinkedMap.get(map, "LABELS"));
        this.setType(IgnoreCaseLinkedMap.get(map, "TYPE"));
        this.setStack(IgnoreCaseLinkedMap.get(map, "STACK"));
        this.setLabel(IgnoreCaseLinkedMap.get(map, "LABEL"));
        this.setData(IgnoreCaseLinkedMap.get(map, "DATA"));
    }

    /** @return boolean */
    public boolean isNew() {
        boolean isNew = false;

        // 主キーが不足していたらINSERT
        return isNew;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.labels == null || this.labels.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.type == null || this.type.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.stack == null || this.stack.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.label == null || this.label.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.data == null || this.data.toString().replaceAll("　| ", "").equals("");
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

    /** LABELS */
    private String labels;

    /** @return LABELS */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "LABELS", index = 2)
    public String getLabels() {
        return this.labels;
    }

    /** @param o LABELS */
    public void setLabels(final Object o) {
        if (o != null) {
            this.labels = o.toString();
        } else {
            this.labels = null;
        }
    }

    /** TYPE */
    private String type;

    /** @return TYPE */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TYPE", index = 3)
    public String getType() {
        return this.type;
    }

    /** @param o TYPE */
    public void setType(final Object o) {
        if (o != null) {
            this.type = o.toString();
        } else {
            this.type = null;
        }
    }

    /** STACK */
    private String stack;

    /** @return STACK */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "STACK", index = 4)
    public String getStack() {
        return this.stack;
    }

    /** @param o STACK */
    public void setStack(final Object o) {
        if (o != null) {
            this.stack = o.toString();
        } else {
            this.stack = null;
        }
    }

    /** LABEL */
    private String label;

    /** @return LABEL */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "LABEL", index = 5)
    public String getLabel() {
        return this.label;
    }

    /** @param o LABEL */
    public void setLabel(final Object o) {
        if (o != null) {
            this.label = o.toString();
        } else {
            this.label = null;
        }
    }

    /** DATA */
    private String data;

    /** @return DATA */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DATA", index = 6)
    public String getData() {
        return this.data;
    }

    /** @param o DATA */
    public void setData(final Object o) {
        if (o != null) {
            this.data = o.toString();
        } else {
            this.data = null;
        }
    }
}
