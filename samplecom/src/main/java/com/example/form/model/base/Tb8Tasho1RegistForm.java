package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 他生１登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Tasho1RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb8Tasho1RegistForm.class);

    /** 他生１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String tasho1Id;

    /** @return 他生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTasho1Id() {
        return tasho1Id;
    }

    /** @param p 他生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTasho1Id(final String p) {
        this.tasho1Id = p;
    }

    /** 集約２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String sum2Id;

    /** @return 集約２ID */
    public String getSum2Id() {
        return sum2Id;
    }

    /** @param p 集約２ID */
    public void setSum2Id(final String p) {
        this.sum2Id = p;
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

        // 集約２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> sum2IdParams = new java.util.HashMap<String, Object>();
        sum2IdParams.put("sum2Id", this.getSum2Id());
        baseProcess.masterCheck(errors, "Tb8Sum2Search", "sum2Id", sum2IdParams, jp.co.golorp.emarf.util.Messages.get("Tb8Tasho1.sum2Id"));
    }
}
