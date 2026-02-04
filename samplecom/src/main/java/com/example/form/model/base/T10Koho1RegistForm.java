package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 候補１登録フォーム
 *
 * @author emarfkrow
 */
public class T10Koho1RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T10Koho1RegistForm.class);

    /** 候補１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String koho1Id;

    /** @return 候補１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKoho1Id() {
        return koho1Id;
    }

    /** @param p 候補１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
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
