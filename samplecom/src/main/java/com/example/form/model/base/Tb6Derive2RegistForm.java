package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生２登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6Derive2RegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb6Derive2RegistForm.class);

    /** 派生２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String derive2Id;

    /** @return 派生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getDerive2Id() {
        return derive2Id;
    }

    /** @param p 派生２ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setDerive2Id(final String p) {
        this.derive2Id = p;
    }

    /** 起源ID */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String orgId;

    /** @return 起源ID */
    public String getOrgId() {
        return orgId;
    }

    /** @param p 起源ID */
    public void setOrgId(final String p) {
        this.orgId = p;
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

    /** 派生２明細 */
    @jakarta.validation.Valid
    private java.util.List<Tb6Derive2DetRegistForm> tb6Derive2DetGrid;

    /**
     * @return 派生２明細
     */
    public java.util.List<Tb6Derive2DetRegistForm> getTb6Derive2DetGrid() {
        return tb6Derive2DetGrid;
    }

    /**
     * @param p
     */
    public void setTb6Derive2DetGrid(final java.util.List<Tb6Derive2DetRegistForm> p) {
        this.tb6Derive2DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");

        // 起源ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> orgIdParams = new java.util.HashMap<String, Object>();
        orgIdParams.put("orgId", this.getOrgId());
        baseProcess.masterCheck(errors, "Tb6OrgSearch", "orgId", orgIdParams, jp.co.golorp.emarf.util.Messages.get("Tb6Derive2.orgId"));
    }
}
