package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * ID連番マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M04IdbnSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04IdbnRegistForm.class);

    /** ID連番マスタ登録フォームのリスト */
    @Valid
    private List<M04IdbnRegistForm> m04IdbnGrid;

    /**
     * @return ID連番マスタ登録フォームのリスト
     */
    public List<M04IdbnRegistForm> getM04IdbnGrid() {
        return m04IdbnGrid;
    }

    /**
     * @param p ID連番マスタ登録フォームのリスト
     */
    public void setM04IdbnGrid(final List<M04IdbnRegistForm> p) {
        this.m04IdbnGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m04IdbnGrid != null) {
            for (int i = 0; i < this.m04IdbnGrid.size(); i++) {
                M04IdbnRegistForm form = this.m04IdbnGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M04IdbnGrid", i, gridErrors);
                }
            }
        }
    }

}
