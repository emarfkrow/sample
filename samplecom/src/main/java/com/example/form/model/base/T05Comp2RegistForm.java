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
public class T05Comp2RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T05Comp2RegistForm.class);

    /** 参照１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String ref1Id;

    /** @return 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRef1Id() {
        return ref1Id;
    }

    /** @param p 参照１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRef1Id(final String p) {
        this.ref1Id = p;
    }

    /** 参照２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String ref2Id;

    /** @return 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRef2Id() {
        return ref2Id;
    }

    /** @param p 参照２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRef2Id(final String p) {
        this.ref2Id = p;
    }

    /** 参照３ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String ref3Id;

    /** @return 参照３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRef3Id() {
        return ref3Id;
    }

    /** @param p 参照３ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRef3Id(final String p) {
        this.ref3Id = p;
    }

    /** 適用日 */
    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
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
    private String comp2Info;

    /** @return 複合２情報 */
    public String getComp2Info() {
        return comp2Info;
    }

    /** @param p 複合２情報 */
    public void setComp2Info(final String p) {
        this.comp2Info = p;
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

        // 参照１ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> ref1IdParams = new java.util.HashMap<String, Object>();
        ref1IdParams.put("ref1Id", this.getRef1Id());
        baseProcess.masterCheck(errors, "M05Ref1Search", "ref1Id", ref1IdParams, jp.co.golorp.emarf.util.Messages.get("T05Comp2.ref1Id"));

        // 参照２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> ref2IdParams = new java.util.HashMap<String, Object>();
        ref2IdParams.put("ref2Id", this.getRef2Id());
        baseProcess.masterCheck(errors, "M05Ref2Search", "ref2Id", ref2IdParams, jp.co.golorp.emarf.util.Messages.get("T05Comp2.ref2Id"));

        // 参照３ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> ref3IdParams = new java.util.HashMap<String, Object>();
        ref3IdParams.put("ref3Id", this.getRef3Id());
        baseProcess.masterCheck(errors, "M05Ref3Search", "ref3Id", ref3IdParams, jp.co.golorp.emarf.util.Messages.get("T05Comp2.ref3Id"));
    }
}
