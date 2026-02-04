package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 選抜登録フォーム
 *
 * @author emarfkrow
 */
public class T10ChoiceRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T10ChoiceRegistForm.class);

    /** 選抜ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String choiceId;

    /** @return 選抜ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getChoiceId() {
        return choiceId;
    }

    /** @param p 選抜ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setChoiceId(final String p) {
        this.choiceId = p;
    }

    /** 候補１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String koho1Id;

    /** @return 候補１ID */
    public String getKoho1Id() {
        return koho1Id;
    }

    /** @param p 候補１ID */
    public void setKoho1Id(final String p) {
        this.koho1Id = p;
    }

    /** 候補１情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String koho1Info;

    /** @return 候補１情報 */
    public String getKoho1Info() {
        return koho1Info;
    }

    /** @param p 候補１情報 */
    public void setKoho1Info(final String p) {
        this.koho1Info = p;
    }

    /** 候補２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String koho2Id;

    /** @return 候補２ID */
    public String getKoho2Id() {
        return koho2Id;
    }

    /** @param p 候補２ID */
    public void setKoho2Id(final String p) {
        this.koho2Id = p;
    }

    /** 候補２情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String koho2Info;

    /** @return 候補２情報 */
    public String getKoho2Info() {
        return koho2Info;
    }

    /** @param p 候補２情報 */
    public void setKoho2Info(final String p) {
        this.koho2Info = p;
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

        // 候補１ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> koho1IdParams = new java.util.HashMap<String, Object>();
        koho1IdParams.put("koho1Id", this.getKoho1Id());
        baseProcess.masterCheck(errors, "T10Koho1Search", "koho1Id", koho1IdParams, jp.co.golorp.emarf.util.Messages.get("T10Choice.koho1Id"));

        // 候補２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> koho2IdParams = new java.util.HashMap<String, Object>();
        koho2IdParams.put("koho2Id", this.getKoho2Id());
        baseProcess.masterCheck(errors, "T10Koho2Search", "koho2Id", koho2IdParams, jp.co.golorp.emarf.util.Messages.get("T10Choice.koho2Id"));
    }
}
