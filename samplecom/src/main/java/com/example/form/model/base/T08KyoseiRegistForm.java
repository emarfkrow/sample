package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 共生登録フォーム
 *
 * @author emarfkrow
 */
public class T08KyoseiRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T08KyoseiRegistForm.class);

    /** 共生ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String kyoseiId;

    /** @return 共生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKyoseiId() {
        return kyoseiId;
    }

    /** @param p 共生ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKyoseiId(final String p) {
        this.kyoseiId = p;
    }

    /** 寄生１ID */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String kisei1Id;

    /** @return 寄生１ID */
    public String getKisei1Id() {
        return kisei1Id;
    }

    /** @param p 寄生１ID */
    public void setKisei1Id(final String p) {
        this.kisei1Id = p;
    }

    /** 寄生１情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String kisei1Info;

    /** @return 寄生１情報 */
    public String getKisei1Info() {
        return kisei1Info;
    }

    /** @param p 寄生１情報 */
    public void setKisei1Info(final String p) {
        this.kisei1Info = p;
    }

    /** 寄生２ID */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String kisei2Id;

    /** @return 寄生２ID */
    public String getKisei2Id() {
        return kisei2Id;
    }

    /** @param p 寄生２ID */
    public void setKisei2Id(final String p) {
        this.kisei2Id = p;
    }

    /** 寄生２情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String kisei2Info;

    /** @return 寄生２情報 */
    public String getKisei2Info() {
        return kisei2Info;
    }

    /** @param p 寄生２情報 */
    public void setKisei2Info(final String p) {
        this.kisei2Info = p;
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

        // 寄生１ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> kisei1IdParams = new java.util.HashMap<String, Object>();
        kisei1IdParams.put("kisei1Id", this.getKisei1Id());
        baseProcess.masterCheck(errors, "T08Kisei1Search", "kisei1Id", kisei1IdParams, jp.co.golorp.emarf.util.Messages.get("T08Kyosei.kisei1Id"));

        // 寄生２ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> kisei2IdParams = new java.util.HashMap<String, Object>();
        kisei2IdParams.put("kisei2Id", this.getKisei2Id());
        baseProcess.masterCheck(errors, "T08Kisei2Search", "kisei2Id", kisei2IdParams, jp.co.golorp.emarf.util.Messages.get("T08Kyosei.kisei2Id"));
    }
}
