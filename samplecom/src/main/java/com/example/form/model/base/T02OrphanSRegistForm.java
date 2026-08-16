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
public class T02OrphanSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02OrphanRegistForm.class);

    /** 孤児登録フォームのリスト */
    @Valid
    private List<T02OrphanRegistForm> t02OrphanGrid;

    /**
     * @return 孤児登録フォームのリスト
     */
    public List<T02OrphanRegistForm> getT02OrphanGrid() {
        return t02OrphanGrid;
    }

    /**
     * @param p 孤児登録フォームのリスト
     */
    public void setT02OrphanGrid(final List<T02OrphanRegistForm> p) {
        this.t02OrphanGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02OrphanGrid != null) {
            for (int i = 0; i < this.t02OrphanGrid.size(); i++) {
                T02OrphanRegistForm form = this.t02OrphanGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02OrphanGrid", i, gridErrors);
                }
            }
        }
    }

}
