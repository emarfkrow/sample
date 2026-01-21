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
public class Tb1IdbnSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1IdbnRegistForm.class);

    /** ID連番マスタ登録フォームのリスト */
    @Valid
    private List<Tb1IdbnRegistForm> tb1IdbnGrid;

    /**
     * @return ID連番マスタ登録フォームのリスト
     */
    public List<Tb1IdbnRegistForm> getTb1IdbnGrid() {
        return tb1IdbnGrid;
    }

    /**
     * @param p ID連番マスタ登録フォームのリスト
     */
    public void setTb1IdbnGrid(final List<Tb1IdbnRegistForm> p) {
        this.tb1IdbnGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1IdbnGrid.size(); i++) {
            Tb1IdbnRegistForm form = this.tb1IdbnGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1IdbnGrid", i, gridErrors);
            }
        }
    }

}
