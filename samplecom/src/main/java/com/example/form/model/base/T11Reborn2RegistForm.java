package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生２登録フォーム
 *
 * @author emarfkrow
 */
public class T11Reborn2RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T11Reborn2RegistForm.class);

    /** 転生２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String reborn2Id;

    /** @return 転生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getReborn2Id() {
        return reborn2Id;
    }

    /** @param p 転生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setReborn2Id(final String p) {
        this.reborn2Id = p;
    }

    /** 前世２情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String prev2Info;

    /** @return 前世２情報 */
    public String getPrev2Info() {
        return prev2Info;
    }

    /** @param p 前世２情報 */
    public void setPrev2Info(final String p) {
        this.prev2Info = p;
    }

    /** 前世２ID */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String prev2Id;

    /** @return 前世２ID */
    public String getPrev2Id() {
        return prev2Id;
    }

    /** @param p 前世２ID */
    public void setPrev2Id(final String p) {
        this.prev2Id = p;
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

        // 前世２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> prev2IdParams = new java.util.HashMap<String, Object>();
        prev2IdParams.put("prev2Id", this.getPrev2Id());
        baseProcess.masterCheck(errors, "T11Prev2Search", "prev2Id", prev2IdParams, jp.co.golorp.emarf.util.Messages.get("T11Reborn2.prev2Id"));
    }
}
