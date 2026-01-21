package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生２明細登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6Derive2DetRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb6Derive2DetRegistForm.class);

    /** 派生２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String derive2Id;

    /** @return 派生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getDerive2Id() {
        return derive2Id;
    }

    /** @param p 派生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive2Id(final String p) {
        this.derive2Id = p;
    }

    /** 派生２枝番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String derive2Bn;

    /** @return 派生２枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getDerive2Bn() {
        return derive2Bn;
    }

    /** @param p 派生２枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive2Bn(final String p) {
        this.derive2Bn = p;
    }

    /** 起源明細情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String orgDetInfo;

    /** @return 起源明細情報 */
    public String getOrgDetInfo() {
        return orgDetInfo;
    }

    /** @param p 起源明細情報 */
    public void setOrgDetInfo(final String p) {
        this.orgDetInfo = p;
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
