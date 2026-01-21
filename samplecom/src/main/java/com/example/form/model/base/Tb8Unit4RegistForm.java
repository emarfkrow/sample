package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 単位４登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Unit4RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb8Unit4RegistForm.class);

    /** 単位４ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String unit4Id;

    /** @return 単位４ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getUnit4Id() {
        return unit4Id;
    }

    /** @param p 単位４ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setUnit4Id(final String p) {
        this.unit4Id = p;
    }

    /** 集約３ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String sum3Id;

    /** @return 集約３ID */
    public String getSum3Id() {
        return sum3Id;
    }

    /** @param p 集約３ID */
    public void setSum3Id(final String p) {
        this.sum3Id = p;
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

        // 集約３ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> sum3IdParams = new java.util.HashMap<String, Object>();
        sum3IdParams.put("sum3Id", this.getSum3Id());
        baseProcess.masterCheck(errors, "Tb8Sum3Search", "sum3Id", sum3IdParams, jp.co.golorp.emarf.util.Messages.get("Tb8Unit4.sum3Id"));
    }
}
