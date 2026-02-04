package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * NOマスタ登録フォーム
 *
 * @author emarfkrow
 */
public class M04NoRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(M04NoRegistForm.class);

    /** 参照NO */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,10})?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String norefNo;

    /** @return 参照NO */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getNorefNo() {
        return norefNo;
    }

    /** @param p 参照NO */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setNorefNo(final String p) {
        this.norefNo = p;
    }

    /** NO参照名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String norefMei;

    /** @return NO参照名 */
    public String getNorefMei() {
        return norefMei;
    }

    /** @param p NO参照名 */
    public void setNorefMei(final String p) {
        this.norefMei = p;
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
