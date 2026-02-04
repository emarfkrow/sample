package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 他生２登録フォーム
 *
 * @author emarfkrow
 */
public class T12Tasho2RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T12Tasho2RegistForm.class);

    /** 他生２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String tasho2Id;

    /** @return 他生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTasho2Id() {
        return tasho2Id;
    }

    /** @param p 他生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTasho2Id(final String p) {
        this.tasho2Id = p;
    }

    /** 候補３ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String koho3Id;

    /** @return 候補３ID */
    public String getKoho3Id() {
        return koho3Id;
    }

    /** @param p 候補３ID */
    public void setKoho3Id(final String p) {
        this.koho3Id = p;
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

        // 候補３ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> koho3IdParams = new java.util.HashMap<String, Object>();
        koho3IdParams.put("koho3Id", this.getKoho3Id());
        baseProcess.masterCheck(errors, "T12Koho3Search", "koho3Id", koho3IdParams, jp.co.golorp.emarf.util.Messages.get("T12Tasho2.koho3Id"));
    }
}
