package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 孤児登録フォーム
 *
 * @author emarfkrow
 */
public class T01OrphanRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T01OrphanRegistForm.class);

    /** 親ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String oyaId;

    /** @return 親ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getOyaId() {
        return oyaId;
    }

    /** @param p 親ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setOyaId(final String p) {
        this.oyaId = p;
    }

    /** 子枝番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String koBn;

    /** @return 子枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getKoBn() {
        return koBn;
    }

    /** @param p 子枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setKoBn(final String p) {
        this.koBn = p;
    }

    /** 孤児情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String orphanInfo;

    /** @return 孤児情報 */
    public String getOrphanInfo() {
        return orphanInfo;
    }

    /** @param p 孤児情報 */
    public void setOrphanInfo(final String p) {
        this.orphanInfo = p;
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

    /** 子なし */
    @jakarta.validation.Valid
    private T01DinksRegistForm t01DinksRegistForm;

    /** @return T01DinksRegistForm */
    public T01DinksRegistForm getT01DinksRegistForm() {
        return t01DinksRegistForm;
    }

    /** @param p */
    public void setT01DinksRegistForm(final T01DinksRegistForm p) {
        this.t01DinksRegistForm = p;
    }

    /** 子 */
    @jakarta.validation.Valid
    private T01KoRegistForm t01KoRegistForm;

    /** @return T01KoRegistForm */
    public T01KoRegistForm getT01KoRegistForm() {
        return t01KoRegistForm;
    }

    /** @param p */
    public void setT01KoRegistForm(final T01KoRegistForm p) {
        this.t01KoRegistForm = p;
    }

    /** 孫 */
    @jakarta.validation.Valid
    private java.util.List<T01MagoRegistForm> t01MagoGrid;

    /**
     * @return 孫
     */
    public java.util.List<T01MagoRegistForm> getT01MagoGrid() {
        return t01MagoGrid;
    }

    /**
     * @param p
     */
    public void setT01MagoGrid(final java.util.List<T01MagoRegistForm> p) {
        this.t01MagoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
