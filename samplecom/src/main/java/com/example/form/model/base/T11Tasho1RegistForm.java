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
public class T11Tasho1RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T11Tasho1RegistForm.class);

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

    /** 転生２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String reborn2Id;

    /** @return 転生２ID */
    public String getReborn2Id() {
        return reborn2Id;
    }

    /** @param p 転生２ID */
    public void setReborn2Id(final String p) {
        this.reborn2Id = p;
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

        // 転生２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> reborn2IdParams = new java.util.HashMap<String, Object>();
        reborn2IdParams.put("reborn2Id", this.getReborn2Id());
        baseProcess.masterCheck(errors, "T11Reborn2Search", "reborn2Id", reborn2IdParams, jp.co.golorp.emarf.util.Messages.get("T11Tasho1.reborn2Id"));
    }
}
