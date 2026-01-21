package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 子登録フォーム
 *
 * @author emarfkrow
 */
public class Tb4KoRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb4KoRegistForm.class);

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

    /** 子情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String koInfo;

    /** @return 子情報 */
    public String getKoInfo() {
        return koInfo;
    }

    /** @param p 子情報 */
    public void setKoInfo(final String p) {
        this.koInfo = p;
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

    /** 子なし */
    @jakarta.validation.Valid
    private Tb4KoDinksRegistForm tb4KoDinksRegistForm;

    /** @return Tb4KoDinksRegistForm */
    public Tb4KoDinksRegistForm getTb4KoDinksRegistForm() {
        return tb4KoDinksRegistForm;
    }

    /** @param p */
    public void setTb4KoDinksRegistForm(final Tb4KoDinksRegistForm p) {
        this.tb4KoDinksRegistForm = p;
    }

    /** 孤児 */
    @jakarta.validation.Valid
    private Tb4KoOrphansRegistForm tb4KoOrphansRegistForm;

    /** @return Tb4KoOrphansRegistForm */
    public Tb4KoOrphansRegistForm getTb4KoOrphansRegistForm() {
        return tb4KoOrphansRegistForm;
    }

    /** @param p */
    public void setTb4KoOrphansRegistForm(final Tb4KoOrphansRegistForm p) {
        this.tb4KoOrphansRegistForm = p;
    }

    /** 孫 */
    @jakarta.validation.Valid
    private java.util.List<Tb4MagoRegistForm> tb4MagoGrid;

    /**
     * @return 孫
     */
    public java.util.List<Tb4MagoRegistForm> getTb4MagoGrid() {
        return tb4MagoGrid;
    }

    /**
     * @param p
     */
    public void setTb4MagoGrid(final java.util.List<Tb4MagoRegistForm> p) {
        this.tb4MagoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
