package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 親一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T02OyaSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02OyaRegistForm.class);

    /** 親登録フォームのリスト */
    @Valid
    private List<T02OyaRegistForm> t02OyaGrid;

    /**
     * @return 親登録フォームのリスト
     */
    public List<T02OyaRegistForm> getT02OyaGrid() {
        return t02OyaGrid;
    }

    /**
     * @param p 親登録フォームのリスト
     */
    public void setT02OyaGrid(final List<T02OyaRegistForm> p) {
        this.t02OyaGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02OyaGrid != null) {
            for (int i = 0; i < this.t02OyaGrid.size(); i++) {
                T02OyaRegistForm form = this.t02OyaGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02OyaGrid", i, gridErrors);
                }
            }
        }
    }

}
