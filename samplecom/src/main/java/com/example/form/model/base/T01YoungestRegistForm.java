package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 末弟登録フォーム
 *
 * @author emarfkrow
 */
public class T01YoungestRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T01YoungestRegistForm.class);

    /** 兄弟ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String broId;

    /** @return 兄弟ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getBroId() {
        return broId;
    }

    /** @param p 兄弟ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setBroId(final String p) {
        this.broId = p;
    }

    /** 末弟情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String youngestInfo;

    /** @return 末弟情報 */
    public String getYoungestInfo() {
        return youngestInfo;
    }

    /** @param p 末弟情報 */
    public void setYoungestInfo(final String p) {
        this.youngestInfo = p;
    }

    /** 更新タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3}(\\+\\d{2}:\\d{2})?)?)?)?")
    @jp.co.golorp.emarf.validation.OptLock
    private String updateTs;

    /** @return 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public String getUpdateTs() {
        return updateTs;
    }

    /** @param p 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final String p) {
        this.updateTs = p;
    }

    /** 長兄 */
    @jakarta.validation.Valid
    private T01EldestRegistForm t01EldestRegistForm;

    /** @return T01EldestRegistForm */
    public T01EldestRegistForm getT01EldestRegistForm() {
        return t01EldestRegistForm;
    }

    /** @param p */
    public void setT01EldestRegistForm(final T01EldestRegistForm p) {
        this.t01EldestRegistForm = p;
    }

    /** 里子 */
    @jakarta.validation.Valid
    private T01FosterRegistForm t01FosterRegistForm;

    /** @return T01FosterRegistForm */
    public T01FosterRegistForm getT01FosterRegistForm() {
        return t01FosterRegistForm;
    }

    /** @param p */
    public void setT01FosterRegistForm(final T01FosterRegistForm p) {
        this.t01FosterRegistForm = p;
    }

    /** 弟 */
    @jakarta.validation.Valid
    private T01YoungerRegistForm t01YoungerRegistForm;

    /** @return T01YoungerRegistForm */
    public T01YoungerRegistForm getT01YoungerRegistForm() {
        return t01YoungerRegistForm;
    }

    /** @param p */
    public void setT01YoungerRegistForm(final T01YoungerRegistForm p) {
        this.t01YoungerRegistForm = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
