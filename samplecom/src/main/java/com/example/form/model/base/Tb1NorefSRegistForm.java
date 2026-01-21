package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * NO参照マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1NorefSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1NorefRegistForm.class);

    /** NO参照マスタ登録フォームのリスト */
    @Valid
    private List<Tb1NorefRegistForm> tb1NorefGrid;

    /**
     * @return NO参照マスタ登録フォームのリスト
     */
    public List<Tb1NorefRegistForm> getTb1NorefGrid() {
        return tb1NorefGrid;
    }

    /**
     * @param p NO参照マスタ登録フォームのリスト
     */
    public void setTb1NorefGrid(final List<Tb1NorefRegistForm> p) {
        this.tb1NorefGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1NorefGrid.size(); i++) {
            Tb1NorefRegistForm form = this.tb1NorefGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1NorefGrid", i, gridErrors);
            }
        }
    }

}
