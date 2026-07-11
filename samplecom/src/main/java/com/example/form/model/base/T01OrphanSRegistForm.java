package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 孤児一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01OrphanSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01OrphanRegistForm.class);

    /** 孤児登録フォームのリスト */
    @Valid
    private List<T01OrphanRegistForm> t01OrphanGrid;

    /**
     * @return 孤児登録フォームのリスト
     */
    public List<T01OrphanRegistForm> getT01OrphanGrid() {
        return t01OrphanGrid;
    }

    /**
     * @param p 孤児登録フォームのリスト
     */
    public void setT01OrphanGrid(final List<T01OrphanRegistForm> p) {
        this.t01OrphanGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01OrphanGrid != null) {
            for (int i = 0; i < this.t01OrphanGrid.size(); i++) {
                T01OrphanRegistForm form = this.t01OrphanGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01OrphanGrid", i, gridErrors);
                }
            }
        }
    }

}
