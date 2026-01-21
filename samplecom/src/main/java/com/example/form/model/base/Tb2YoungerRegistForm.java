package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 弟登録フォーム
 *
 * @author emarfkrow
 */
public class Tb2YoungerRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb2YoungerRegistForm.class);

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

    /** 弟情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String youngerInfo;

    /** @return 弟情報 */
    public String getYoungerInfo() {
        return youngerInfo;
    }

    /** @param p 弟情報 */
    public void setYoungerInfo(final String p) {
        this.youngerInfo = p;
    }

    /** 更新タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3})?)?)?")
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

    /** 末弟 */
    @jakarta.validation.Valid
    private Tb2YoungestRegistForm tb2YoungestRegistForm;

    /** @return Tb2YoungestRegistForm */
    public Tb2YoungestRegistForm getTb2YoungestRegistForm() {
        return tb2YoungestRegistForm;
    }

    /** @param p */
    public void setTb2YoungestRegistForm(final Tb2YoungestRegistForm p) {
        this.tb2YoungestRegistForm = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
