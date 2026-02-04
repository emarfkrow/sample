package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生登録フォーム
 *
 * @author emarfkrow
 */
public class T07RebornRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T07RebornRegistForm.class);

    /** 転生ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String rebornId;

    /** @return 転生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getRebornId() {
        return rebornId;
    }

    /** @param p 転生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRebornId(final String p) {
        this.rebornId = p;
    }

    /** 前世情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String prevInfo;

    /** @return 前世情報 */
    public String getPrevInfo() {
        return prevInfo;
    }

    /** @param p 前世情報 */
    public void setPrevInfo(final String p) {
        this.prevInfo = p;
    }

    /** 前世ID */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String prevId;

    /** @return 前世ID */
    public String getPrevId() {
        return prevId;
    }

    /** @param p 前世ID */
    public void setPrevId(final String p) {
        this.prevId = p;
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

    /** 転生明細 */
    @jakarta.validation.Valid
    private java.util.List<T07RebornDetRegistForm> t07RebornDetGrid;

    /**
     * @return 転生明細
     */
    public java.util.List<T07RebornDetRegistForm> getT07RebornDetGrid() {
        return t07RebornDetGrid;
    }

    /**
     * @param p
     */
    public void setT07RebornDetGrid(final java.util.List<T07RebornDetRegistForm> p) {
        this.t07RebornDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");

        // 前世ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> prevIdParams = new java.util.HashMap<String, Object>();
        prevIdParams.put("prevId", this.getPrevId());
        baseProcess.masterCheck(errors, "T07PrevSearch", "prevId", prevIdParams, jp.co.golorp.emarf.util.Messages.get("T07Reborn.prevId"));
    }
}
