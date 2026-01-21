package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 当初一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb3BeginSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb3BeginRegistForm.class);

    /** 当初登録フォームのリスト */
    @Valid
    private List<Tb3BeginRegistForm> tb3BeginGrid;

    /**
     * @return 当初登録フォームのリスト
     */
    public List<Tb3BeginRegistForm> getTb3BeginGrid() {
        return tb3BeginGrid;
    }

    /**
     * @param p 当初登録フォームのリスト
     */
    public void setTb3BeginGrid(final List<Tb3BeginRegistForm> p) {
        this.tb3BeginGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb3BeginGrid.size(); i++) {
            Tb3BeginRegistForm form = this.tb3BeginGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb3BeginGrid", i, gridErrors);
            }
        }
    }

}
