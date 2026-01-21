package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 税マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MsyTaxSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MsyTaxRegistForm.class);

    /** 税マスタ登録フォームのリスト */
    @Valid
    private List<MsyTaxRegistForm> msyTaxGrid;

    /**
     * @return 税マスタ登録フォームのリスト
     */
    public List<MsyTaxRegistForm> getMsyTaxGrid() {
        return msyTaxGrid;
    }

    /**
     * @param p 税マスタ登録フォームのリスト
     */
    public void setMsyTaxGrid(final List<MsyTaxRegistForm> p) {
        this.msyTaxGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.msyTaxGrid.size(); i++) {
            MsyTaxRegistForm form = this.msyTaxGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MsyTaxGrid", i, gridErrors);
            }
        }
    }

}
