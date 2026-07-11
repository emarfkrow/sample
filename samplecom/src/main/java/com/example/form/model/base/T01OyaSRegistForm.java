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
public class T01OyaSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01OyaRegistForm.class);

    /** 親登録フォームのリスト */
    @Valid
    private List<T01OyaRegistForm> t01OyaGrid;

    /**
     * @return 親登録フォームのリスト
     */
    public List<T01OyaRegistForm> getT01OyaGrid() {
        return t01OyaGrid;
    }

    /**
     * @param p 親登録フォームのリスト
     */
    public void setT01OyaGrid(final List<T01OyaRegistForm> p) {
        this.t01OyaGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01OyaGrid != null) {
            for (int i = 0; i < this.t01OyaGrid.size(); i++) {
                T01OyaRegistForm form = this.t01OyaGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01OyaGrid", i, gridErrors);
                }
            }
        }
    }

}
