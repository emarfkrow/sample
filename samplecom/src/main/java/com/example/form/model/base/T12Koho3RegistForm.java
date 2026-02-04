package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 候補３登録フォーム
 *
 * @author emarfkrow
 */
public class T12Koho3RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T12Koho3RegistForm.class);

    /** 候補３ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String koho3Id;

    /** @return 候補３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKoho3Id() {
        return koho3Id;
    }

    /** @param p 候補３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKoho3Id(final String p) {
        this.koho3Id = p;
    }

    /** 候補３情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String koho3Info;

    /** @return 候補３情報 */
    public String getKoho3Info() {
        return koho3Info;
    }

    /** @param p 候補３情報 */
    public void setKoho3Info(final String p) {
        this.koho3Info = p;
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
