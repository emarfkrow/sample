package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 里子登録フォーム
 *
 * @author emarfkrow
 */
public class T01FosterRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T01FosterRegistForm.class);

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

    /** 里子情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String fosterInfo;

    /** @return 里子情報 */
    public String getFosterInfo() {
        return fosterInfo;
    }

    /** @param p 里子情報 */
    public void setFosterInfo(final String p) {
        this.fosterInfo = p;
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

    /** 末弟 */
    @jakarta.validation.Valid
    private T01YoungestRegistForm t01YoungestRegistForm;

    /** @return T01YoungestRegistForm */
    public T01YoungestRegistForm getT01YoungestRegistForm() {
        return t01YoungestRegistForm;
    }

    /** @param p */
    public void setT01YoungestRegistForm(final T01YoungestRegistForm p) {
        this.t01YoungestRegistForm = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
