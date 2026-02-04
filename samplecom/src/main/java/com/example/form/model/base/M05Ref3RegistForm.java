package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * マスタ参照３登録フォーム
 *
 * @author emarfkrow
 */
public class M05Ref3RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(M05Ref3RegistForm.class);

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

    /** 参照３名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String ref3Mei;

    /** @return 参照３名 */
    public String getRef3Mei() {
        return ref3Mei;
    }

    /** @param p 参照３名 */
    public void setRef3Mei(final String p) {
        this.ref3Mei = p;
    }

    /** 削除フラグ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 1)
    private String deleteF;

    /** @return 削除フラグ */
    public String getDeleteF() {
        return deleteF;
    }

    /** @param p 削除フラグ */
    public void setDeleteF(final String p) {
        this.deleteF = p;
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
    }
}
