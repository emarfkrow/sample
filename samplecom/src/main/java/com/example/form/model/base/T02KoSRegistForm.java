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
public class T02KoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02KoRegistForm.class);

    /** 子登録フォームのリスト */
    @Valid
    private List<T02KoRegistForm> t02KoGrid;

    /**
     * @return 子登録フォームのリスト
     */
    public List<T02KoRegistForm> getT02KoGrid() {
        return t02KoGrid;
    }

    /**
     * @param p 子登録フォームのリスト
     */
    public void setT02KoGrid(final List<T02KoRegistForm> p) {
        this.t02KoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02KoGrid != null) {
            for (int i = 0; i < this.t02KoGrid.size(); i++) {
                T02KoRegistForm form = this.t02KoGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02KoGrid", i, gridErrors);
                }
            }
        }
    }

}
