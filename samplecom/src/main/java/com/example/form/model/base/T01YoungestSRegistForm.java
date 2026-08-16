package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 末弟一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01YoungestSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01YoungestRegistForm.class);

    /** 末弟登録フォームのリスト */
    @Valid
    private List<T01YoungestRegistForm> t01YoungestGrid;

    /**
     * @return 末弟登録フォームのリスト
     */
    public List<T01YoungestRegistForm> getT01YoungestGrid() {
        return t01YoungestGrid;
    }

    /**
     * @param p 末弟登録フォームのリスト
     */
    public void setT01YoungestGrid(final List<T01YoungestRegistForm> p) {
        this.t01YoungestGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01YoungestGrid != null) {
            for (int i = 0; i < this.t01YoungestGrid.size(); i++) {
                T01YoungestRegistForm form = this.t01YoungestGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01YoungestGrid", i, gridErrors);
                }
            }
        }
    }

}
