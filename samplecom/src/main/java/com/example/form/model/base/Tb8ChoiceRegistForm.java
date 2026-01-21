package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 選抜登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8ChoiceRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb8ChoiceRegistForm.class);

    /** 選抜ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String choiceId;

    /** @return 選抜ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getChoiceId() {
        return choiceId;
    }

    /** @param p 選抜ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setChoiceId(final String p) {
        this.choiceId = p;
    }

    /** 集約ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String sumId;

    /** @return 集約ID */
    public String getSumId() {
        return sumId;
    }

    /** @param p 集約ID */
    public void setSumId(final String p) {
        this.sumId = p;
    }

    /** 集約情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String sumInfo;

    /** @return 集約情報 */
    public String getSumInfo() {
        return sumInfo;
    }

    /** @param p 集約情報 */
    public void setSumInfo(final String p) {
        this.sumInfo = p;
    }

    /** 集約２ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String sum2Id;

    /** @return 集約２ID */
    public String getSum2Id() {
        return sum2Id;
    }

    /** @param p 集約２ID */
    public void setSum2Id(final String p) {
        this.sum2Id = p;
    }

    /** 集約２情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String sum2Info;

    /** @return 集約２情報 */
    public String getSum2Info() {
        return sum2Info;
    }

    /** @param p 集約２情報 */
    public void setSum2Info(final String p) {
        this.sum2Info = p;
    }

    /** 集約３ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String sum3Id;

    /** @return 集約３ID */
    public String getSum3Id() {
        return sum3Id;
    }

    /** @param p 集約３ID */
    public void setSum3Id(final String p) {
        this.sum3Id = p;
    }

    /** 集約３情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String sum3Info;

    /** @return 集約３情報 */
    public String getSum3Info() {
        return sum3Info;
    }

    /** @param p 集約３情報 */
    public void setSum3Info(final String p) {
        this.sum3Info = p;
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

        // 集約ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> sumIdParams = new java.util.HashMap<String, Object>();
        sumIdParams.put("sumId", this.getSumId());
        baseProcess.masterCheck(errors, "Tb7SumSearch", "sumId", sumIdParams, jp.co.golorp.emarf.util.Messages.get("Tb8Choice.sumId"));

        // 集約２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> sum2IdParams = new java.util.HashMap<String, Object>();
        sum2IdParams.put("sum2Id", this.getSum2Id());
        baseProcess.masterCheck(errors, "Tb8Sum2Search", "sum2Id", sum2IdParams, jp.co.golorp.emarf.util.Messages.get("Tb8Choice.sum2Id"));

        // 集約３ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> sum3IdParams = new java.util.HashMap<String, Object>();
        sum3IdParams.put("sum3Id", this.getSum3Id());
        baseProcess.masterCheck(errors, "Tb8Sum3Search", "sum3Id", sum3IdParams, jp.co.golorp.emarf.util.Messages.get("Tb8Choice.sum3Id"));
    }
}
