package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 稼働日マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class MsyKadobiRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(MsyKadobiRegistForm.class);

    /** 稼働日 */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kadoBi;

    /** @return 稼働日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKadoBi() {
        return kadoBi;
    }

    /** @param p 稼働日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKadoBi(final String p) {
        this.kadoBi = p;
    }

    /** 部署ID */
    @jakarta.validation.constraints.NotBlank
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

    /** 稼働日フラグ */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 1)
    private String kadobiF;

    /** @return 稼働日フラグ */
    public String getKadobiF() {
        return kadobiF;
    }

    /** @param p 稼働日フラグ */
    public void setKadobiF(final String p) {
        this.kadobiF = p;
    }

    /** メモ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String memo;

    /** @return メモ */
    public String getMemo() {
        return memo;
    }

    /** @param p メモ */
    public void setMemo(final String p) {
        this.memo = p;
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

        // 部署ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> bushoIdParams = new java.util.HashMap<String, Object>();
        bushoIdParams.put("bushoId", this.getBushoId());
        baseProcess.masterCheck(errors, "MhrBushoSearch", "bushoId", bushoIdParams, jp.co.golorp.emarf.util.Messages.get("MsyKadobi.bushoId"));
    }
}
