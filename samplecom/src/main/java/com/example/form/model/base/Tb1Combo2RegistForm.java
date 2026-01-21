package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 複合２登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1Combo2RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb1Combo2RegistForm.class);

    /** 参照１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String refer1Id;

    /** @return 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRefer1Id() {
        return refer1Id;
    }

    /** @param p 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRefer1Id(final String p) {
        this.refer1Id = p;
    }

    /** 参照２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String refer2Id;

    /** @return 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRefer2Id() {
        return refer2Id;
    }

    /** @param p 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRefer2Id(final String p) {
        this.refer2Id = p;
    }

    /** 参照３ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String refer3Id;

    /** @return 参照３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRefer3Id() {
        return refer3Id;
    }

    /** @param p 参照３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRefer3Id(final String p) {
        this.refer3Id = p;
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

    /** 複合２情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String combo2Info;

    /** @return 複合２情報 */
    public String getCombo2Info() {
        return combo2Info;
    }

    /** @param p 複合２情報 */
    public void setCombo2Info(final String p) {
        this.combo2Info = p;
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

        // 参照１ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refer1IdParams = new java.util.HashMap<String, Object>();
        refer1IdParams.put("refer1Id", this.getRefer1Id());
        baseProcess.masterCheck(errors, "Tb1Refer1Search", "refer1Id", refer1IdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Combo2.refer1Id"));

        // 参照２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refer2IdParams = new java.util.HashMap<String, Object>();
        refer2IdParams.put("refer2Id", this.getRefer2Id());
        baseProcess.masterCheck(errors, "Tb1Refer2Search", "refer2Id", refer2IdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Combo2.refer2Id"));

        // 参照３ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refer3IdParams = new java.util.HashMap<String, Object>();
        refer3IdParams.put("refer3Id", this.getRefer3Id());
        baseProcess.masterCheck(errors, "Tb1Refer3Search", "refer3Id", refer3IdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Combo2.refer3Id"));
    }
}
