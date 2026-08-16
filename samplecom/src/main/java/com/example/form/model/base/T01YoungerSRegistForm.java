package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 弟一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01YoungerSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01YoungerRegistForm.class);

    /** 弟登録フォームのリスト */
    @Valid
    private List<T01YoungerRegistForm> t01YoungerGrid;

    /**
     * @return 弟登録フォームのリスト
     */
    public List<T01YoungerRegistForm> getT01YoungerGrid() {
        return t01YoungerGrid;
    }

    /**
     * @param p 弟登録フォームのリスト
     */
    public void setT01YoungerGrid(final List<T01YoungerRegistForm> p) {
        this.t01YoungerGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01YoungerGrid != null) {
            for (int i = 0; i < this.t01YoungerGrid.size(); i++) {
                T01YoungerRegistForm form = this.t01YoungerGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01YoungerGrid", i, gridErrors);
                }
            }
        }
    }

}
