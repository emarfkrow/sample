package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 里子一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01FosterSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01FosterRegistForm.class);

    /** 里子登録フォームのリスト */
    @Valid
    private List<T01FosterRegistForm> t01FosterGrid;

    /**
     * @return 里子登録フォームのリスト
     */
    public List<T01FosterRegistForm> getT01FosterGrid() {
        return t01FosterGrid;
    }

    /**
     * @param p 里子登録フォームのリスト
     */
    public void setT01FosterGrid(final List<T01FosterRegistForm> p) {
        this.t01FosterGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01FosterGrid != null) {
            for (int i = 0; i < this.t01FosterGrid.size(); i++) {
                T01FosterRegistForm form = this.t01FosterGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01FosterGrid", i, gridErrors);
                }
            }
        }
    }

}
