package com.example.form.model.base;

import java.util.Map;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生１登録フォーム
 *
 * @author emarfkrow
 */
public class T07Derive1RegistForm implements IForm {

    /** 派生１ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "(-?[0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String derive1Id;

    /** @return 派生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getDerive1Id() {
        return derive1Id;
    }

    /** @param p 派生１ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive1Id(final String p) {
        this.derive1Id = p;
    }

    /** 起源情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String orgInfo;

    /** @return 起源情報 */
    public String getOrgInfo() {
        return orgInfo;
    }

    /** @param p 起源情報 */
    public void setOrgInfo(final String p) {
        this.orgInfo = p;
    }

    /** 起源ID */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "(-?[0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String orgId;

    /** @return 起源ID */
    public String getOrgId() {
        return orgId;
    }

    /** @param p 起源ID */
    public void setOrgId(final String p) {
        this.orgId = p;
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

    /** 派生１明細 */
    @jakarta.validation.Valid
    private java.util.List<T07Derive1DetRegistForm> t07Derive1DetGrid;

    /**
     * @return 派生１明細
     */
    public java.util.List<T07Derive1DetRegistForm> getT07Derive1DetGrid() {
        return t07Derive1DetGrid;
    }

    /**
     * @param p
     */
    public void setT07Derive1DetGrid(final java.util.List<T07Derive1DetRegistForm> p) {
        this.t07Derive1DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {

        // 派生１明細 の子モデル整合性チェック
        if (this.t07Derive1DetGrid != null) {
            for (int i = 0; i < this.t07Derive1DetGrid.size(); i++) {
                T07Derive1DetRegistForm t07Derive1DetForm = this.t07Derive1DetGrid.get(i);
                if (t07Derive1DetForm == null) {
                    continue;
                }
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                t07Derive1DetForm.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "T07Derive1DetGrid", i, gridErrors);
            }
        }

        // 起源 の派生元チェック
        Map<String, Object> t07OrgParams = new java.util.HashMap<String, Object>();
        t07OrgParams.put("orgId", this.orgId);
        baseProcess.masterCheck(errors, "T07OrgSearch", "orgId", t07OrgParams, jp.co.golorp.emarf.util.Messages.get("T07Derive1.orgId"));
    }
}
