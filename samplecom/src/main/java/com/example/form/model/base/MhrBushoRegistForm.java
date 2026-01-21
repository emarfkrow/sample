package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 部署マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class MhrBushoRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(MhrBushoRegistForm.class);

    /** 部署ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String bushoId;

    /** @return 部署ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getBushoId() {
        return bushoId;
    }

    /** @param p 部署ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setBushoId(final String p) {
        this.bushoId = p;
    }

    /** 部署名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String bushoMei;

    /** @return 部署名 */
    public String getBushoMei() {
        return bushoMei;
    }

    /** @param p 部署名 */
    public void setBushoMei(final String p) {
        this.bushoMei = p;
    }

    /** 親部署ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String oyaBushoId;

    /** @return 親部署ID */
    public String getOyaBushoId() {
        return oyaBushoId;
    }

    /** @param p 親部署ID */
    public void setOyaBushoId(final String p) {
        this.oyaBushoId = p;
    }

    /** 適用日 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String tekiyoBi;

    /** @return 適用日 */
    public String getTekiyoBi() {
        return tekiyoBi;
    }

    /** @param p 適用日 */
    public void setTekiyoBi(final String p) {
        this.tekiyoBi = p;
    }

    /** 廃止日 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String haishiBi;

    /** @return 廃止日 */
    public String getHaishiBi() {
        return haishiBi;
    }

    /** @param p 廃止日 */
    public void setHaishiBi(final String p) {
        this.haishiBi = p;
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

        // 親部署ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> oyaBushoIdParams = new java.util.HashMap<String, Object>();
        oyaBushoIdParams.put("oyaBushoId", this.getOyaBushoId());
        baseProcess.masterCheck(errors, "MhrBushoSearch", "oyaBushoId", oyaBushoIdParams, jp.co.golorp.emarf.util.Messages.get("MhrBusho.oyaBushoId"));
    }
}
