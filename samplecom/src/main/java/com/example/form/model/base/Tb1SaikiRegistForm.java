package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 再帰登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1SaikiRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb1SaikiRegistForm.class);

    /** 再帰ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String saikiId;

    /** @return 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getSaikiId() {
        return saikiId;
    }

    /** @param p 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setSaikiId(final String p) {
        this.saikiId = p;
    }

    /** 再帰名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String saikiMei;

    /** @return 再帰名 */
    public String getSaikiMei() {
        return saikiMei;
    }

    /** @param p 再帰名 */
    public void setSaikiMei(final String p) {
        this.saikiMei = p;
    }

    /** 参照ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String idrefId;

    /** @return 参照ID */
    public String getIdrefId() {
        return idrefId;
    }

    /** @param p 参照ID */
    public void setIdrefId(final String p) {
        this.idrefId = p;
    }

    /** 参照CD */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([\\-0-9A-Za-z]{1,10})?")
    private String cdrefCd;

    /** @return 参照CD */
    public String getCdrefCd() {
        return cdrefCd;
    }

    /** @param p 参照CD */
    public void setCdrefCd(final String p) {
        this.cdrefCd = p;
    }

    /** 参照NO */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,10})?")
    private String norefNo;

    /** @return 参照NO */
    public String getNorefNo() {
        return norefNo;
    }

    /** @param p 参照NO */
    public void setNorefNo(final String p) {
        this.norefNo = p;
    }

    /** 別参照ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String exIdrefId;

    /** @return 別参照ID */
    public String getExIdrefId() {
        return exIdrefId;
    }

    /** @param p 別参照ID */
    public void setExIdrefId(final String p) {
        this.exIdrefId = p;
    }

    /** ID連番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String idbnBn;

    /** @return ID連番 */
    public String getIdbnBn() {
        return idbnBn;
    }

    /** @param p ID連番 */
    public void setIdbnBn(final String p) {
        this.idbnBn = p;
    }

    /** 親再帰ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String oyaSaikiId;

    /** @return 親再帰ID */
    public String getOyaSaikiId() {
        return oyaSaikiId;
    }

    /** @param p 親再帰ID */
    public void setOyaSaikiId(final String p) {
        this.oyaSaikiId = p;
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
        baseProcess.masterCheck(errors, "Tb1IdrefSearch", "idrefId", idrefIdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Saiki.idrefId"));

        // 参照CD のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> cdrefCdParams = new java.util.HashMap<String, Object>();
        cdrefCdParams.put("cdrefCdFull", this.getCdrefCd());
        baseProcess.masterCheck(errors, "Tb1CdrefSearch", "cdrefCd", cdrefCdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Saiki.cdrefCd"));

        // 参照NO のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> norefNoParams = new java.util.HashMap<String, Object>();
        norefNoParams.put("norefNoFull", this.getNorefNo());
        baseProcess.masterCheck(errors, "Tb1NorefSearch", "norefNo", norefNoParams, jp.co.golorp.emarf.util.Messages.get("Tb1Saiki.norefNo"));

        // 別参照ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> exIdrefIdParams = new java.util.HashMap<String, Object>();
        exIdrefIdParams.put("exIdrefId", this.getExIdrefId());
        baseProcess.masterCheck(errors, "Tb1IdrefSearch", "exIdrefId", exIdrefIdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Saiki.exIdrefId"));

        // ID連番 のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> tb1IdbnParams = new java.util.HashMap<String, Object>();
        tb1IdbnParams.put("idrefId", this.getIdrefId());
        tb1IdbnParams.put("idbnBn", this.getIdbnBn());
        baseProcess.masterCheck(errors, "Tb1IdbnSearch", "idbnBn", tb1IdbnParams, jp.co.golorp.emarf.util.Messages.get("Tb1Saiki.idbnBn"));

        // 親再帰ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> oyaSaikiIdParams = new java.util.HashMap<String, Object>();
        oyaSaikiIdParams.put("oyaSaikiId", this.getOyaSaikiId());
        baseProcess.masterCheck(errors, "Tb1SaikiSearch", "oyaSaikiId", oyaSaikiIdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Saiki.oyaSaikiId"));
    }
}
