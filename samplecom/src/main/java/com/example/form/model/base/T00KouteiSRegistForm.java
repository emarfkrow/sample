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
public class T00KouteiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T00KouteiRegistForm.class);

    /** 工程登録フォームのリスト */
    @Valid
    private List<T00KouteiRegistForm> t00KouteiGrid;

    /**
     * @return 工程登録フォームのリスト
     */
    public List<T00KouteiRegistForm> getT00KouteiGrid() {
        return t00KouteiGrid;
    }

    /**
     * @param p 工程登録フォームのリスト
     */
    public void setT00KouteiGrid(final List<T00KouteiRegistForm> p) {
        this.t00KouteiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.t00KouteiGrid.size(); i++) {
            T00KouteiRegistForm form = this.t00KouteiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "T00KouteiGrid", i, gridErrors);
            }
        }
    }

}
