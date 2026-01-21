package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 通貨マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class MsyTsukaRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(MsyTsukaRegistForm.class);

    /** 通貨区分 */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String tsukaKb;

    /** @return 通貨区分 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTsukaKb() {
        return tsukaKb;
    }

    /** @param p 通貨区分 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTsukaKb(final String p) {
        this.tsukaKb = p;
    }

    /** 適用日 */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String tekiyoBi;

    /** @return 適用日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTekiyoBi() {
        return tekiyoBi;
    }

    /** @param p 適用日 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTekiyoBi(final String p) {
        this.tekiyoBi = p;
    }

    /** 販売レート */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,3}\\.?[0-9]{0,2}?)?")
    private String tts;

    /** @return 販売レート */
    public String getTts() {
        return tts;
    }

    /** @param p 販売レート */
    public void setTts(final String p) {
        this.tts = p;
    }

    /** 買取レート */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,3}\\.?[0-9]{0,2}?)?")
    private String ttb;

    /** @return 買取レート */
    public String getTtb() {
        return ttb;
    }

    /** @param p 買取レート */
    public void setTtb(final String p) {
        this.ttb = p;
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
    }
}
