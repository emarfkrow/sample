package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変遷登録フォーム
 *
 * @author emarfkrow
 */
public class T03TransRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T03TransRegistForm.class);

    /** 変遷ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String transId;

    /** @return 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTransId() {
        return transId;
    }

    /** @param p 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTransId(final String p) {
        this.transId = p;
    }

    /** 変遷情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String transInfo;

    /** @return 変遷情報 */
    public String getTransInfo() {
        return transInfo;
    }

    /** @param p 変遷情報 */
    public void setTransInfo(final String p) {
        this.transInfo = p;
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
