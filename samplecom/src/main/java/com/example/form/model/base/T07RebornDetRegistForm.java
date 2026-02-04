package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生明細登録フォーム
 *
 * @author emarfkrow
 */
public class T07RebornDetRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T07RebornDetRegistForm.class);

    /** 転生ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String rebornId;

    /** @return 転生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRebornId() {
        return rebornId;
    }

    /** @param p 転生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRebornId(final String p) {
        this.rebornId = p;
    }

    /** 転生枝番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String rebornBn;

    /** @return 転生枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRebornBn() {
        return rebornBn;
    }

    /** @param p 転生枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRebornBn(final String p) {
        this.rebornBn = p;
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
