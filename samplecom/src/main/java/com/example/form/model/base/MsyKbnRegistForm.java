package com.example.form.model.base;

import java.util.Map;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 区分マスタ登録フォーム
 *
 * @author emarfkrow
 */
public class MsyKbnRegistForm implements IForm {

    /** 区分名称 */
    @jakarta.validation.constraints.NotBlank(groups = { jp.co.golorp.emarf.validation.Regist.class, jp.co.golorp.emarf.validation.Delete.class })
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([ -~]+)?")
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 20)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kbnNm;

    /** @return 区分名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKbnNm() {
        return kbnNm;
    }

    /** @param p 区分名称 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKbnNm(final String p) {
        this.kbnNm = p;
    }

    /** 区分名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String kbnMei;

    /** @return 区分名 */
    public String getKbnMei() {
        return kbnMei;
    }

    /** @param p 区分名 */
    public void setKbnMei(final String p) {
        this.kbnMei = p;
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

    /** 区分値マスタ */
    @jakarta.validation.Valid
    private java.util.List<MsyKbnValRegistForm> msyKbnValGrid;

    /**
     * @return 区分値マスタ
     */
    public java.util.List<MsyKbnValRegistForm> getMsyKbnValGrid() {
        return msyKbnValGrid;
    }

    /**
     * @param p
     */
    public void setMsyKbnValGrid(final java.util.List<MsyKbnValRegistForm> p) {
        this.msyKbnValGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {

        // 区分値マスタ の子モデル整合性チェック
        if (this.msyKbnValGrid != null) {
            for (int i = 0; i < this.msyKbnValGrid.size(); i++) {
                MsyKbnValRegistForm msyKbnValForm = this.msyKbnValGrid.get(i);
                if (msyKbnValForm == null) {
                    continue;
                }
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                msyKbnValForm.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MsyKbnValGrid", i, gridErrors);
            }
        }
    }
}
