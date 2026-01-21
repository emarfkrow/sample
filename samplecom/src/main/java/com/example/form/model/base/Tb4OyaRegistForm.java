package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 親登録フォーム
 *
 * @author emarfkrow
 */
public class Tb4OyaRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb4OyaRegistForm.class);

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

    /** 親情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String oyaInfo;

    /** @return 親情報 */
    public String getOyaInfo() {
        return oyaInfo;
    }

    /** @param p 親情報 */
    public void setOyaInfo(final String p) {
        this.oyaInfo = p;
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

    /** 子 */
    @jakarta.validation.Valid
    private java.util.List<Tb4KoRegistForm> tb4KoGrid;

    /**
     * @return 子
     */
    public java.util.List<Tb4KoRegistForm> getTb4KoGrid() {
        return tb4KoGrid;
    }

    /**
     * @param p
     */
    public void setTb4KoGrid(final java.util.List<Tb4KoRegistForm> p) {
        this.tb4KoGrid = p;
    }

    /** 子なし */
    @jakarta.validation.Valid
    private java.util.List<Tb4KoDinksRegistForm> tb4KoDinksGrid;

    /**
     * @return 子なし
     */
    public java.util.List<Tb4KoDinksRegistForm> getTb4KoDinksGrid() {
        return tb4KoDinksGrid;
    }

    /**
     * @param p
     */
    public void setTb4KoDinksGrid(final java.util.List<Tb4KoDinksRegistForm> p) {
        this.tb4KoDinksGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
