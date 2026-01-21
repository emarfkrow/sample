package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 複合１登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1Combo1RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb1Combo1RegistForm.class);

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
    @jakarta.validation.constraints.NotBlank
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

    /** 複合１情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String combo1Info;

    /** @return 複合１情報 */
    public String getCombo1Info() {
        return combo1Info;
    }

    /** @param p 複合１情報 */
    public void setCombo1Info(final String p) {
        this.combo1Info = p;
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

    /** 複合２ */
    @jakarta.validation.Valid
    private java.util.List<Tb1Combo2RegistForm> tb1Combo2Grid;

    /**
     * @return 複合２
     */
    public java.util.List<Tb1Combo2RegistForm> getTb1Combo2Grid() {
        return tb1Combo2Grid;
    }

    /**
     * @param p
     */
    public void setTb1Combo2Grid(final java.util.List<Tb1Combo2RegistForm> p) {
        this.tb1Combo2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");

        // 参照１ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refer1IdParams = new java.util.HashMap<String, Object>();
        refer1IdParams.put("refer1Id", this.getRefer1Id());
        baseProcess.masterCheck(errors, "Tb1Refer1Search", "refer1Id", refer1IdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Combo1.refer1Id"));

        // 参照２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refer2IdParams = new java.util.HashMap<String, Object>();
        refer2IdParams.put("refer2Id", this.getRefer2Id());
        baseProcess.masterCheck(errors, "Tb1Refer2Search", "refer2Id", refer2IdParams, jp.co.golorp.emarf.util.Messages.get("Tb1Combo1.refer2Id"));
    }
}
