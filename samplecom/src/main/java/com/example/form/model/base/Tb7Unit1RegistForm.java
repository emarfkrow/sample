package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 単位１登録フォーム
 *
 * @author emarfkrow
 */
public class Tb7Unit1RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb7Unit1RegistForm.class);

    /** 単位１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String unit1Id;

    /** @return 単位１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getUnit1Id() {
        return unit1Id;
    }

    /** @param p 単位１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setUnit1Id(final String p) {
        this.unit1Id = p;
    }

    /** 集約ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String sumId;

    /** @return 集約ID */
    public String getSumId() {
        return sumId;
    }

    /** @param p 集約ID */
    public void setSumId(final String p) {
        this.sumId = p;
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

        // 集約ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> sumIdParams = new java.util.HashMap<String, Object>();
        sumIdParams.put("sumId", this.getSumId());
        baseProcess.masterCheck(errors, "Tb7SumSearch", "sumId", sumIdParams, jp.co.golorp.emarf.util.Messages.get("Tb7Unit1.sumId"));
    }
}
