package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 実績登録フォーム
 *
 * @author emarfkrow
 */
public class T14JissekiRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T14JissekiRegistForm.class);

    /** 工程ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kouteiId;

    /** @return 工程ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKouteiId() {
        return kouteiId;
    }

    /** @param p 工程ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKouteiId(final String p) {
        this.kouteiId = p;
    }

    /** 実績連番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String jissekiBn;

    /** @return 実績連番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getJissekiBn() {
        return jissekiBn;
    }

    /** @param p 実績連番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setJissekiBn(final String p) {
        this.jissekiBn = p;
    }

    /** 実施日 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String jisshiBi;

    /** @return 実施日 */
    public String getJisshiBi() {
        return jisshiBi;
    }

    /** @param p 実施日 */
    public void setJisshiBi(final String p) {
        this.jisshiBi = p;
    }

    /** 完了日 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String kanryoBi;

    /** @return 完了日 */
    public String getKanryoBi() {
        return kanryoBi;
    }

    /** @param p 完了日 */
    public void setKanryoBi(final String p) {
        this.kanryoBi = p;
    }

    /** 更新タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3}(\\+\\d{2}:\\d{2})?)?)?)?")
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

        // 工程ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> kouteiIdParams = new java.util.HashMap<String, Object>();
        kouteiIdParams.put("kouteiId", this.getKouteiId());
        baseProcess.masterCheck(errors, "T14KouteiSearch", "kouteiId", kouteiIdParams, jp.co.golorp.emarf.util.Messages.get("T14Jisseki.kouteiId"));
    }
}
