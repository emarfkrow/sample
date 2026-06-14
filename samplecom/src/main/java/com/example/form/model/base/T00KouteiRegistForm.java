package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 工程表登録フォーム
 *
 * @author emarfkrow
 */
public class T00KouteiRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T00KouteiRegistForm.class);

    /** 工程ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kouteiId;

    /** @return 工程ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKouteiId() {
        return kouteiId;
    }

    /** @param p 工程ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKouteiId(final String p) {
        this.kouteiId = p;
    }

    /** 工程名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String kouteiMei;

    /** @return 工程名 */
    public String getKouteiMei() {
        return kouteiMei;
    }

    /** @param p 工程名 */
    public void setKouteiMei(final String p) {
        this.kouteiMei = p;
    }

    /** 開始日 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String kaishiBi;

    /** @return 開始日 */
    public String getKaishiBi() {
        return kaishiBi;
    }

    /** @param p 開始日 */
    public void setKaishiBi(final String p) {
        this.kaishiBi = p;
    }

    /** 終了日 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String shuryoBi;

    /** @return 終了日 */
    public String getShuryoBi() {
        return shuryoBi;
    }

    /** @param p 終了日 */
    public void setShuryoBi(final String p) {
        this.shuryoBi = p;
    }

    /** 親工程ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String oyaKouteiId;

    /** @return 親工程ID */
    public String getOyaKouteiId() {
        return oyaKouteiId;
    }

    /** @param p 親工程ID */
    public void setOyaKouteiId(final String p) {
        this.oyaKouteiId = p;
    }

    /** 更新タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3}(\\+\\d{2}:\\d{2})?)?)?)?")
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

        // 親工程ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> oyaKouteiIdParams = new java.util.HashMap<String, Object>();
        oyaKouteiIdParams.put("kouteiId", this.getOyaKouteiId());
        baseProcess.masterCheck(errors, "T00KouteiSearch", "oyaKouteiId", oyaKouteiIdParams, jp.co.golorp.emarf.util.Messages.get("T00Koutei.oyaKouteiId"));
    }
}
