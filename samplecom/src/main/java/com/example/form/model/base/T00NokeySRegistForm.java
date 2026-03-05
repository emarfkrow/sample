package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * キーなし一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T00NokeySRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T00NokeyRegistForm.class);

    /** キーなし登録フォームのリスト */
    @Valid
    private List<T00NokeyRegistForm> t00NokeyGrid;

    /**
     * @return キーなし登録フォームのリスト
     */
    public List<T00NokeyRegistForm> getT00NokeyGrid() {
        return t00NokeyGrid;
    }

    /**
     * @param p キーなし登録フォームのリスト
     */
    public void setT00NokeyGrid(final List<T00NokeyRegistForm> p) {
        this.t00NokeyGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.t00NokeyGrid.size(); i++) {
            T00NokeyRegistForm form = this.t00NokeyGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "T00NokeyGrid", i, gridErrors);
            }
        }
    }

}
