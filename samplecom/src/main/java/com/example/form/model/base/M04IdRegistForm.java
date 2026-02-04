package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * IDマスタ登録フォーム
 *
 * @author emarfkrow
 */
public class M04IdRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(M04IdRegistForm.class);

    /** 参照ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String idrefId;

    /** @return 参照ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getIdrefId() {
        return idrefId;
    }

    /** @param p 参照ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setIdrefId(final String p) {
        this.idrefId = p;
    }

    /** ID参照名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String idrefMei;

    /** @return ID参照名 */
    public String getIdrefMei() {
        return idrefMei;
    }

    /** @param p ID参照名 */
    public void setIdrefMei(final String p) {
        this.idrefMei = p;
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

    /** ID連番マスタ */
    @jakarta.validation.Valid
    private java.util.List<M04IdbnRegistForm> m04IdbnGrid;

    /**
     * @return ID連番マスタ
     */
    public java.util.List<M04IdbnRegistForm> getM04IdbnGrid() {
        return m04IdbnGrid;
    }

    /**
     * @param p
     */
    public void setM04IdbnGrid(final java.util.List<M04IdbnRegistForm> p) {
        this.m04IdbnGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
