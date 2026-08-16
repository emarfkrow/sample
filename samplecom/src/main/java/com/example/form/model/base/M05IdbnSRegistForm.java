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
public class M05IdbnSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M05IdbnRegistForm.class);

    /** ID連番マスタ登録フォームのリスト */
    @Valid
    private List<M05IdbnRegistForm> m05IdbnGrid;

    /**
     * @return ID連番マスタ登録フォームのリスト
     */
    public List<M05IdbnRegistForm> getM05IdbnGrid() {
        return m05IdbnGrid;
    }

    /**
     * @param p ID連番マスタ登録フォームのリスト
     */
    public void setM05IdbnGrid(final List<M05IdbnRegistForm> p) {
        this.m05IdbnGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m05IdbnGrid != null) {
            for (int i = 0; i < this.m05IdbnGrid.size(); i++) {
                M05IdbnRegistForm form = this.m05IdbnGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M05IdbnGrid", i, gridErrors);
                }
            }
        }
    }

}
