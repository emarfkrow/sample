package com.example.form.model.base;

import java.util.Map;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生登録フォーム
 *
 * @author emarfkrow
 */
public class T06RebornRegistForm implements IForm {

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

    /** 転生明細 */
    @jakarta.validation.Valid
    private java.util.List<T06RebornDetRegistForm> t06RebornDetGrid;

    /**
     * @return 転生明細
     */
    public java.util.List<T06RebornDetRegistForm> getT06RebornDetGrid() {
        return t06RebornDetGrid;
    }

    /**
     * @param p
     */
    public void setT06RebornDetGrid(final java.util.List<T06RebornDetRegistForm> p) {
        this.t06RebornDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {

        // 転生明細 の子モデル整合性チェック
        for (int i = 0; i < this.t06RebornDetGrid.size(); i++) {
            T06RebornDetRegistForm t06RebornDetForm = this.t06RebornDetGrid.get(i);
            Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
            t06RebornDetForm.validate(gridErrors, baseProcess);
            BaseProcess.copyGridErrors(errors, "T06RebornDetGrid", i, gridErrors);
        }

        // 前世 の転生元チェック
        Map<String, Object> t06PrevParams = new java.util.HashMap<String, Object>();
        t06PrevParams.put("prevId", this.prevId);
        baseProcess.masterCheck(errors, "T06PrevSearch", "prevId", t06PrevParams, jp.co.golorp.emarf.util.Messages.get("T06Reborn.prevId"));
    }
}
