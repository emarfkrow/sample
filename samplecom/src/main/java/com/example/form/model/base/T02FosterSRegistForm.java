package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 里子一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T02FosterSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02FosterRegistForm.class);

    /** 里子登録フォームのリスト */
    @Valid
    private List<T02FosterRegistForm> t02FosterGrid;

    /**
     * @return 里子登録フォームのリスト
     */
    public List<T02FosterRegistForm> getT02FosterGrid() {
        return t02FosterGrid;
    }

    /**
     * @param p 里子登録フォームのリスト
     */
    public void setT02FosterGrid(final List<T02FosterRegistForm> p) {
        this.t02FosterGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02FosterGrid != null) {
            for (int i = 0; i < this.t02FosterGrid.size(); i++) {
                T02FosterRegistForm form = this.t02FosterGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02FosterGrid", i, gridErrors);
                }
            }
        }
    }

}
