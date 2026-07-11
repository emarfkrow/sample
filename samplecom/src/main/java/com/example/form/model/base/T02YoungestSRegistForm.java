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
public class T02YoungestSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02YoungestRegistForm.class);

    /** 末弟登録フォームのリスト */
    @Valid
    private List<T02YoungestRegistForm> t02YoungestGrid;

    /**
     * @return 末弟登録フォームのリスト
     */
    public List<T02YoungestRegistForm> getT02YoungestGrid() {
        return t02YoungestGrid;
    }

    /**
     * @param p 末弟登録フォームのリスト
     */
    public void setT02YoungestGrid(final List<T02YoungestRegistForm> p) {
        this.t02YoungestGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02YoungestGrid != null) {
            for (int i = 0; i < this.t02YoungestGrid.size(); i++) {
                T02YoungestRegistForm form = this.t02YoungestGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02YoungestGrid", i, gridErrors);
                }
            }
        }
    }

}
