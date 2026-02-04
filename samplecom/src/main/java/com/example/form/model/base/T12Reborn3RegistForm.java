package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生３登録フォーム
 *
 * @author emarfkrow
 */
public class T12Reborn3RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T12Reborn3RegistForm.class);

    /** 転生３ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String reborn3Id;

    /** @return 転生３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getReborn3Id() {
        return reborn3Id;
    }

    /** @param p 転生３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setReborn3Id(final String p) {
        this.reborn3Id = p;
    }

    /** 他生２ID */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String tasho2Id;

    /** @return 他生２ID */
    public String getTasho2Id() {
        return tasho2Id;
    }

    /** @param p 他生２ID */
    public void setTasho2Id(final String p) {
        this.tasho2Id = p;
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

        // 他生２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> tasho2IdParams = new java.util.HashMap<String, Object>();
        tasho2IdParams.put("tasho2Id", this.getTasho2Id());
        baseProcess.masterCheck(errors, "T12Tasho2Search", "tasho2Id", tasho2IdParams, jp.co.golorp.emarf.util.Messages.get("T12Reborn3.tasho2Id"));
    }
}
