package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * ID連番マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class M04IdbnRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(M04IdbnRegistForm.class);

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

    /** 参照連番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String idbnBn;

    /** @return 参照連番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getIdbnBn() {
        return idbnBn;
    }

    /** @param p 参照連番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setIdbnBn(final String p) {
        this.idbnBn = p;
    }

    /** ID連番NO */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,10})?")
    private String idbnNo;

    /** @return ID連番NO */
    public String getIdbnNo() {
        return idbnNo;
    }

    /** @param p ID連番NO */
    public void setIdbnNo(final String p) {
        this.idbnNo = p;
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

        // 参照ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> idrefIdParams = new java.util.HashMap<String, Object>();
        idrefIdParams.put("idrefId", this.getIdrefId());
        baseProcess.masterCheck(errors, "M04IdSearch", "idrefId", idrefIdParams, jp.co.golorp.emarf.util.Messages.get("M04Idbn.idrefId"));
    }
}
