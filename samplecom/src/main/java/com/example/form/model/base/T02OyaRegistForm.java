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
public class T02OyaRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T02OyaRegistForm.class);

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

    /** 子なし */
    @jakarta.validation.Valid
    private java.util.List<T02DinksRegistForm> t02DinksGrid;

    /**
     * @return 子なし
     */
    public java.util.List<T02DinksRegistForm> getT02DinksGrid() {
        return t02DinksGrid;
    }

    /**
     * @param p
     */
    public void setT02DinksGrid(final java.util.List<T02DinksRegistForm> p) {
        this.t02DinksGrid = p;
    }

    /** 子 */
    @jakarta.validation.Valid
    private java.util.List<T02KoRegistForm> t02KoGrid;

    /**
     * @return 子
     */
    public java.util.List<T02KoRegistForm> getT02KoGrid() {
        return t02KoGrid;
    }

    /**
     * @param p
     */
    public void setT02KoGrid(final java.util.List<T02KoRegistForm> p) {
        this.t02KoGrid = p;
    }

    /** 孤児 */
    @jakarta.validation.Valid
    private java.util.List<T02OrphanRegistForm> t02OrphanGrid;

    /**
     * @return 孤児
     */
    public java.util.List<T02OrphanRegistForm> getT02OrphanGrid() {
        return t02OrphanGrid;
    }

    /**
     * @param p
     */
    public void setT02OrphanGrid(final java.util.List<T02OrphanRegistForm> p) {
        this.t02OrphanGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
