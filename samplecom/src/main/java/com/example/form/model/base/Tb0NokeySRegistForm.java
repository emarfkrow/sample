package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 主キーなし一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb0NokeySRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb0NokeyRegistForm.class);

    /** 主キーなし登録フォームのリスト */
    @Valid
    private List<Tb0NokeyRegistForm> tb0NokeyGrid;

    /**
     * @return 主キーなし登録フォームのリスト
     */
    public List<Tb0NokeyRegistForm> getTb0NokeyGrid() {
        return tb0NokeyGrid;
    }

    /**
     * @param p 主キーなし登録フォームのリスト
     */
    public void setTb0NokeyGrid(final List<Tb0NokeyRegistForm> p) {
        this.tb0NokeyGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb0NokeyGrid.size(); i++) {
            Tb0NokeyRegistForm form = this.tb0NokeyGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb0NokeyGrid", i, gridErrors);
            }
        }
    }

}
