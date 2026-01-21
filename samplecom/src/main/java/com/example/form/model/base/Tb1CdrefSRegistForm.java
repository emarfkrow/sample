package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * CD参照マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1CdrefSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1CdrefRegistForm.class);

    /** CD参照マスタ登録フォームのリスト */
    @Valid
    private List<Tb1CdrefRegistForm> tb1CdrefGrid;

    /**
     * @return CD参照マスタ登録フォームのリスト
     */
    public List<Tb1CdrefRegistForm> getTb1CdrefGrid() {
        return tb1CdrefGrid;
    }

    /**
     * @param p CD参照マスタ登録フォームのリスト
     */
    public void setTb1CdrefGrid(final List<Tb1CdrefRegistForm> p) {
        this.tb1CdrefGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1CdrefGrid.size(); i++) {
            Tb1CdrefRegistForm form = this.tb1CdrefGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1CdrefGrid", i, gridErrors);
            }
        }
    }

}
