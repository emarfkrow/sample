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
public class T00JissekiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T00JissekiRegistForm.class);

    /** 実績登録フォームのリスト */
    @Valid
    private List<T00JissekiRegistForm> t00JissekiGrid;

    /**
     * @return 実績登録フォームのリスト
     */
    public List<T00JissekiRegistForm> getT00JissekiGrid() {
        return t00JissekiGrid;
    }

    /**
     * @param p 実績登録フォームのリスト
     */
    public void setT00JissekiGrid(final List<T00JissekiRegistForm> p) {
        this.t00JissekiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t00JissekiGrid != null) {
            for (int i = 0; i < this.t00JissekiGrid.size(); i++) {
                T00JissekiRegistForm form = this.t00JissekiGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T00JissekiGrid", i, gridErrors);
                }
            }
        }
    }

}
