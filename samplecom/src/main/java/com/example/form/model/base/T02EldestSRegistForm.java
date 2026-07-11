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
public class T02EldestSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02EldestRegistForm.class);

    /** 長兄登録フォームのリスト */
    @Valid
    private List<T02EldestRegistForm> t02EldestGrid;

    /**
     * @return 長兄登録フォームのリスト
     */
    public List<T02EldestRegistForm> getT02EldestGrid() {
        return t02EldestGrid;
    }

    /**
     * @param p 長兄登録フォームのリスト
     */
    public void setT02EldestGrid(final List<T02EldestRegistForm> p) {
        this.t02EldestGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02EldestGrid != null) {
            for (int i = 0; i < this.t02EldestGrid.size(); i++) {
                T02EldestRegistForm form = this.t02EldestGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02EldestGrid", i, gridErrors);
                }
            }
        }
    }

}
