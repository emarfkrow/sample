package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 子一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01KoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01KoRegistForm.class);

    /** 子登録フォームのリスト */
    @Valid
    private List<T01KoRegistForm> t01KoGrid;

    /**
     * @return 子登録フォームのリスト
     */
    public List<T01KoRegistForm> getT01KoGrid() {
        return t01KoGrid;
    }

    /**
     * @param p 子登録フォームのリスト
     */
    public void setT01KoGrid(final List<T01KoRegistForm> p) {
        this.t01KoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01KoGrid != null) {
            for (int i = 0; i < this.t01KoGrid.size(); i++) {
                T01KoRegistForm form = this.t01KoGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01KoGrid", i, gridErrors);
                }
            }
        }
    }

}
