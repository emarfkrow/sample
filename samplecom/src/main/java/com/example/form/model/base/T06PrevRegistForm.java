package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世登録フォーム
 *
 * @author emarfkrow
 */
public class T06PrevRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T06PrevRegistForm.class);

    /** 前世ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String prevId;

    /** @return 前世ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getPrevId() {
        return prevId;
    }

    /** @param p 前世ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setPrevId(final String p) {
        this.prevId = p;
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

    /** 前世明細 */
    @jakarta.validation.Valid
    private java.util.List<T06PrevDetRegistForm> t06PrevDetGrid;

    /**
     * @return 前世明細
     */
    public java.util.List<T06PrevDetRegistForm> getT06PrevDetGrid() {
        return t06PrevDetGrid;
    }

    /**
     * @param p
     */
    public void setT06PrevDetGrid(final java.util.List<T06PrevDetRegistForm> p) {
        this.t06PrevDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
