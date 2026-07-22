package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 工程一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T14KouteiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T14KouteiRegistForm.class);

    /** 工程登録フォームのリスト */
    @Valid
    private List<T14KouteiRegistForm> t14KouteiGrid;

    /**
     * @return 工程登録フォームのリスト
     */
    public List<T14KouteiRegistForm> getT14KouteiGrid() {
        return t14KouteiGrid;
    }

    /**
     * @param p 工程登録フォームのリスト
     */
    public void setT14KouteiGrid(final List<T14KouteiRegistForm> p) {
        this.t14KouteiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t14KouteiGrid != null) {
            for (int i = 0; i < this.t14KouteiGrid.size(); i++) {
                T14KouteiRegistForm form = this.t14KouteiGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T14KouteiGrid", i, gridErrors);
                }
            }
        }
    }

}
