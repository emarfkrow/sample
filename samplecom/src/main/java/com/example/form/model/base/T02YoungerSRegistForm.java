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
public class T02YoungerSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02YoungerRegistForm.class);

    /** 弟登録フォームのリスト */
    @Valid
    private List<T02YoungerRegistForm> t02YoungerGrid;

    /**
     * @return 弟登録フォームのリスト
     */
    public List<T02YoungerRegistForm> getT02YoungerGrid() {
        return t02YoungerGrid;
    }

    /**
     * @param p 弟登録フォームのリスト
     */
    public void setT02YoungerGrid(final List<T02YoungerRegistForm> p) {
        this.t02YoungerGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02YoungerGrid != null) {
            for (int i = 0; i < this.t02YoungerGrid.size(); i++) {
                T02YoungerRegistForm form = this.t02YoungerGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02YoungerGrid", i, gridErrors);
                }
            }
        }
    }

}
