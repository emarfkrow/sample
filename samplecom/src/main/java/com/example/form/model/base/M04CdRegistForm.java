package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * CDマスタ登録フォーム
 *
 * @author emarfkrow
 */
public class M04CdRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(M04CdRegistForm.class);

    /** 参照CD */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([\\-0-9A-Za-z]{1,10})?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String cdrefCd;

    /** @return 参照CD */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getCdrefCd() {
        return cdrefCd;
    }

    /** @param p 参照CD */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setCdrefCd(final String p) {
        this.cdrefCd = p;
    }

    /** CD参照名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String cdrefMei;

    /** @return CD参照名 */
    public String getCdrefMei() {
        return cdrefMei;
    }

    /** @param p CD参照名 */
    public void setCdrefMei(final String p) {
        this.cdrefMei = p;
    }

    /** 更新タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3})?)?)?")
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
