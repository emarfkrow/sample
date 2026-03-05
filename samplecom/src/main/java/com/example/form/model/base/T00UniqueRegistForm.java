package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * ユニークキー登録フォーム
 *
 * @author emarfkrow
 */
public class T00UniqueRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T00UniqueRegistForm.class);

    /** 列Ａ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String aMei;

    /** @return 列Ａ */
    public String getAMei() {
        return aMei;
    }

    /** @param p 列Ａ */
    public void setAMei(final String p) {
        this.aMei = p;
    }

    /** 列Ｂ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String bMei;

    /** @return 列Ｂ */
    public String getBMei() {
        return bMei;
    }

    /** @param p 列Ｂ */
    public void setBMei(final String p) {
        this.bMei = p;
    }

    /** 列Ｃ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String cMei;

    /** @return 列Ｃ */
    public String getCMei() {
        return cMei;
    }

    /** @param p 列Ｃ */
    public void setCMei(final String p) {
        this.cMei = p;
    }

    /** 列Ｄ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String dMei;

    /** @return 列Ｄ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getDMei() {
        return dMei;
    }

    /** @param p 列Ｄ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDMei(final String p) {
        this.dMei = p;
    }

    /** 列Ｅ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String eMei;

    /** @return 列Ｅ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getEMei() {
        return eMei;
    }

    /** @param p 列Ｅ */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setEMei(final String p) {
        this.eMei = p;
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
