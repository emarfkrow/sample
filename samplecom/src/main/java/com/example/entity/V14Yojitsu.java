package com.example.entity;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.lang.StringUtil;
import jp.co.golorp.emarf.util.IgnoreCaseLinkedMap;

/**
 * V14_YOJITSU
 * @author emarfkrow
 */
public class V14Yojitsu implements IEntity {

    /** デフォルトコンストラクタ */
    public V14Yojitsu() {
    }

    /** @param values */
    public V14Yojitsu(final String[] values) {
        this.setTableName(values[0]);
        this.setKouteiId(values[1]);
        this.setTaskId(values[2]);
        this.setTaskMei(values[3]);
        this.setTaskStart(values[4]);
        this.setTaskUntil(values[5]);
        this.setDependencies(values[6]);
        this.setTaskBeg(values[7]);
        this.setTaskEnd(values[8]);
    }

    /** @param map */
    public V14Yojitsu(final java.util.Map<String, Object> map) {
        this.setTableName(IgnoreCaseLinkedMap.get(map, "TABLE_NAME"));
        this.setKouteiId(IgnoreCaseLinkedMap.get(map, "KOUTEI_ID"));
        this.setTaskId(IgnoreCaseLinkedMap.get(map, "TASK_ID"));
        this.setTaskMei(IgnoreCaseLinkedMap.get(map, "TASK_MEI"));
        this.setTaskStart(IgnoreCaseLinkedMap.get(map, "TASK_START"));
        this.setTaskUntil(IgnoreCaseLinkedMap.get(map, "TASK_UNTIL"));
        this.setDependencies(IgnoreCaseLinkedMap.get(map, "DEPENDENCIES"));
        this.setTaskBeg(IgnoreCaseLinkedMap.get(map, "TASK_BEG"));
        this.setTaskEnd(IgnoreCaseLinkedMap.get(map, "TASK_END"));
    }

    /** @return boolean 主キーが不足していたらtrue */
    public boolean isNew() {
        return false;
    }

    /** @return boolean */
    public boolean isEmpty() {
        boolean isEmpty = true;
        isEmpty &= this.tableName == null || this.tableName.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.kouteiId == null || this.kouteiId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.taskId == null || this.taskId.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.taskMei == null || this.taskMei.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.taskStart == null || this.taskStart.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.taskUntil == null || this.taskUntil.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.dependencies == null || this.dependencies.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.taskBeg == null || this.taskBeg.toString().replaceAll("　| ", "").equals("");
        isEmpty &= this.taskEnd == null || this.taskEnd.toString().replaceAll("　| ", "").equals("");
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
        this.id = StringUtil.ifNullInteger(o);
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
        this.tableName = StringUtil.ifNull(o);
    }

    /** KOUTEI_ID */
    private Integer kouteiId;

    /** @return KOUTEI_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "KOUTEI_ID", index = 3)
    public Integer getKouteiId() {
        return this.kouteiId;
    }

    /** @param o KOUTEI_ID */
    public void setKouteiId(final Object o) {
        this.kouteiId = StringUtil.ifNullInteger(o);
    }

    /** TASK_ID */
    private Integer taskId;

    /** @return TASK_ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TASK_ID", index = 4)
    public Integer getTaskId() {
        return this.taskId;
    }

    /** @param o TASK_ID */
    public void setTaskId(final Object o) {
        this.taskId = StringUtil.ifNullInteger(o);
    }

    /** TASK_MEI */
    private String taskMei;

    /** @return TASK_MEI */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TASK_MEI", index = 5)
    public String getTaskMei() {
        return this.taskMei;
    }

    /** @param o TASK_MEI */
    public void setTaskMei(final Object o) {
        this.taskMei = StringUtil.ifNull(o);
    }

    /** TASK_START */
    private String taskStart;

    /** @return TASK_START */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TASK_START", index = 6)
    public String getTaskStart() {
        return this.taskStart;
    }

    /** @param o TASK_START */
    public void setTaskStart(final Object o) {
        this.taskStart = StringUtil.ifNull(o);
    }

    /** TASK_UNTIL */
    private String taskUntil;

    /** @return TASK_UNTIL */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TASK_UNTIL", index = 7)
    public String getTaskUntil() {
        return this.taskUntil;
    }

    /** @param o TASK_UNTIL */
    public void setTaskUntil(final Object o) {
        this.taskUntil = StringUtil.ifNull(o);
    }

    /** DEPENDENCIES */
    private String dependencies;

    /** @return DEPENDENCIES */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "DEPENDENCIES", index = 8)
    public String getDependencies() {
        return this.dependencies;
    }

    /** @param o DEPENDENCIES */
    public void setDependencies(final Object o) {
        this.dependencies = StringUtil.ifNull(o);
    }

    /** TASK_BEG */
    private String taskBeg;

    /** @return TASK_BEG */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TASK_BEG", index = 9)
    public String getTaskBeg() {
        return this.taskBeg;
    }

    /** @param o TASK_BEG */
    public void setTaskBeg(final Object o) {
        this.taskBeg = StringUtil.ifNull(o);
    }

    /** TASK_END */
    private String taskEnd;

    /** @return TASK_END */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TASK_END", index = 10)
    public String getTaskEnd() {
        return this.taskEnd;
    }

    /** @param o TASK_END */
    public void setTaskEnd(final Object o) {
        this.taskEnd = StringUtil.ifNull(o);
    }
}
