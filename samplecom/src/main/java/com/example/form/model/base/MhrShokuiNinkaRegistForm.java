package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 認可マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class MhrShokuiNinkaRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(MhrShokuiNinkaRegistForm.class);

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

    /** 職位ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String shokuiId;

    /** @return 職位ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getShokuiId() {
        return shokuiId;
    }

    /** @param p 職位ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setShokuiId(final String p) {
        this.shokuiId = p;
    }

    /** 機能名称 */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 20)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kinoNm;

    /** @return 機能名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKinoNm() {
        return kinoNm;
    }

    /** @param p 機能名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKinoNm(final String p) {
        this.kinoNm = p;
    }

    /** 権限区分 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    private String kengenKb;

    /** @return 権限区分 */
    public String getKengenKb() {
        return kengenKb;
    }

    /** @param p 権限区分 */
    public void setKengenKb(final String p) {
        this.kengenKb = p;
    }

    /** 適用日 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
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
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
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

        // 部署ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> bushoIdParams = new java.util.HashMap<String, Object>();
        bushoIdParams.put("bushoId", this.getBushoId());
        baseProcess.masterCheck(errors, "MhrBushoSearch", "bushoId", bushoIdParams, jp.co.golorp.emarf.util.Messages.get("MhrShokuiNinka.bushoId"));

        // 職位ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> shokuiIdParams = new java.util.HashMap<String, Object>();
        shokuiIdParams.put("shokuiId", this.getShokuiId());
        baseProcess.masterCheck(errors, "MhrShokuiSearch", "shokuiId", shokuiIdParams, jp.co.golorp.emarf.util.Messages.get("MhrShokuiNinka.shokuiId"));
    }
}
