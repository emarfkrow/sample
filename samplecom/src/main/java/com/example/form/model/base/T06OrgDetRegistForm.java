package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 起源明細登録フォーム
 *
 * @author emarfkrow
 */
public class T06OrgDetRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T06OrgDetRegistForm.class);

    /** 起源ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String orgId;

    /** @return 起源ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getOrgId() {
        return orgId;
    }

    /** @param p 起源ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setOrgId(final String p) {
        this.orgId = p;
    }

    /** 起源枝番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String orgBn;

    /** @return 起源枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getOrgBn() {
        return orgBn;
    }

    /** @param p 起源枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setOrgBn(final String p) {
        this.orgBn = p;
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
