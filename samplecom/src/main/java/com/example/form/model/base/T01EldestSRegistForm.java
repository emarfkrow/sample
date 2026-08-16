package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 長兄一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01EldestSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01EldestRegistForm.class);

    /** 長兄登録フォームのリスト */
    @Valid
    private List<T01EldestRegistForm> t01EldestGrid;

    /**
     * @return 長兄登録フォームのリスト
     */
    public List<T01EldestRegistForm> getT01EldestGrid() {
        return t01EldestGrid;
    }

    /**
     * @param p 長兄登録フォームのリスト
     */
    public void setT01EldestGrid(final List<T01EldestRegistForm> p) {
        this.t01EldestGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01EldestGrid != null) {
            for (int i = 0; i < this.t01EldestGrid.size(); i++) {
                T01EldestRegistForm form = this.t01EldestGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01EldestGrid", i, gridErrors);
                }
            }
        }
    }

}
