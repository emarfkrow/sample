package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 実績一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T14JissekiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T14JissekiRegistForm.class);

    /** 実績登録フォームのリスト */
    @Valid
    private List<T14JissekiRegistForm> t14JissekiGrid;

    /**
     * @return 実績登録フォームのリスト
     */
    public List<T14JissekiRegistForm> getT14JissekiGrid() {
        return t14JissekiGrid;
    }

    /**
     * @param p 実績登録フォームのリスト
     */
    public void setT14JissekiGrid(final List<T14JissekiRegistForm> p) {
        this.t14JissekiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t14JissekiGrid != null) {
            for (int i = 0; i < this.t14JissekiGrid.size(); i++) {
                T14JissekiRegistForm form = this.t14JissekiGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T14JissekiGrid", i, gridErrors);
                }
            }
        }
    }

}
