package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 税マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class MsyTaxRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(MsyTaxRegistForm.class);

    /** 税区分 */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String taxKb;

    /** @return 税区分 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTaxKb() {
        return taxKb;
    }

    /** @param p 税区分 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTaxKb(final String p) {
        this.taxKb = p;
    }

    /** 適用日 */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String tekiyoBi;

    /** @return 適用日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTekiyoBi() {
        return tekiyoBi;
    }

    /** @param p 適用日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTekiyoBi(final String p) {
        this.tekiyoBi = p;
    }

    /** 廃止日 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String haishiBi;

    /** @return 廃止日 */
    public String getHaishiBi() {
        return haishiBi;
    }

    /** @param p 廃止日 */
    public void setHaishiBi(final String p) {
        this.haishiBi = p;
    }

    /** 税率 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,3}\\.?[0-9]{0,2}?)?")
    private String taxRt;

    /** @return 税率 */
    public String getTaxRt() {
        return taxRt;
    }

    /** @param p 税率 */
    public void setTaxRt(final String p) {
        this.taxRt = p;
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

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
