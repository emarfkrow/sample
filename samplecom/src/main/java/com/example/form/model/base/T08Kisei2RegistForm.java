package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 寄生２登録フォーム
 *
 * @author emarfkrow
 */
public class T08Kisei2RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T08Kisei2RegistForm.class);

    /** 寄生２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kisei2Id;

    /** @return 寄生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKisei2Id() {
        return kisei2Id;
    }

    /** @param p 寄生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKisei2Id(final String p) {
        this.kisei2Id = p;
    }

    /** 寄生２情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String kisei2Info;

    /** @return 寄生２情報 */
    public String getKisei2Info() {
        return kisei2Info;
    }

    /** @param p 寄生２情報 */
    public void setKisei2Info(final String p) {
        this.kisei2Info = p;
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
