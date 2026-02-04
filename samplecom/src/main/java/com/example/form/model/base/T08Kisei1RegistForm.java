package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 寄生１登録フォーム
 *
 * @author emarfkrow
 */
public class T08Kisei1RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T08Kisei1RegistForm.class);

    /** 寄生１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kisei1Id;

    /** @return 寄生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKisei1Id() {
        return kisei1Id;
    }

    /** @param p 寄生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKisei1Id(final String p) {
        this.kisei1Id = p;
    }

    /** 寄生１情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String kisei1Info;

    /** @return 寄生１情報 */
    public String getKisei1Info() {
        return kisei1Info;
    }

    /** @param p 寄生１情報 */
    public void setKisei1Info(final String p) {
        this.kisei1Info = p;
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
