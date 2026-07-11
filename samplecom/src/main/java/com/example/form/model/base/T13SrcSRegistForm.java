package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変換元一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T13SrcSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T13SrcRegistForm.class);

    /** 変換元登録フォームのリスト */
    @Valid
    private List<T13SrcRegistForm> t13SrcGrid;

    /**
     * @return 変換元登録フォームのリスト
     */
    public List<T13SrcRegistForm> getT13SrcGrid() {
        return t13SrcGrid;
    }

    /**
     * @param p 変換元登録フォームのリスト
     */
    public void setT13SrcGrid(final List<T13SrcRegistForm> p) {
        this.t13SrcGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t13SrcGrid != null) {
            for (int i = 0; i < this.t13SrcGrid.size(); i++) {
                T13SrcRegistForm form = this.t13SrcGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T13SrcGrid", i, gridErrors);
                }
            }
        }
    }

}
