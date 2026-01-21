package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 職位マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class MhrShokuiRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(MhrShokuiRegistForm.class);

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

    /** 職位名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String shokuiMei;

    /** @return 職位名 */
    public String getShokuiMei() {
        return shokuiMei;
    }

    /** @param p 職位名 */
    public void setShokuiMei(final String p) {
        this.shokuiMei = p;
    }

    /** 職位順 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String shokuiOn;

    /** @return 職位順 */
    public String getShokuiOn() {
        return shokuiOn;
    }

    /** @param p 職位順 */
    public void setShokuiOn(final String p) {
        this.shokuiOn = p;
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
    }
}
