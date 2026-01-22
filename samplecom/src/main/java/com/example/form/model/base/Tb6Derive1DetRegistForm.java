package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生１明細登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6Derive1DetRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb6Derive1DetRegistForm.class);

    /** 派生１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String derive1Id;

    /** @return 派生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getDerive1Id() {
        return derive1Id;
    }

    /** @param p 派生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive1Id(final String p) {
        this.derive1Id = p;
    }

    /** 派生１枝番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String derive1Bn;

    /** @return 派生１枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getDerive1Bn() {
        return derive1Bn;
    }

    /** @param p 派生１枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive1Bn(final String p) {
        this.derive1Bn = p;
    }

    /** 明細情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String detInfo;

    /** @return 明細情報 */
    public String getDetInfo() {
        return detInfo;
    }

    /** @param p 明細情報 */
    public void setDetInfo(final String p) {
        this.detInfo = p;
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
