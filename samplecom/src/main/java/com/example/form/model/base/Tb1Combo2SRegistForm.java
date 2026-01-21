package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 複合２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1Combo2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1Combo2RegistForm.class);

    /** 複合２登録フォームのリスト */
    @Valid
    private List<Tb1Combo2RegistForm> tb1Combo2Grid;

    /**
     * @return 複合２登録フォームのリスト
     */
    public List<Tb1Combo2RegistForm> getTb1Combo2Grid() {
        return tb1Combo2Grid;
    }

    /**
     * @param p 複合２登録フォームのリスト
     */
    public void setTb1Combo2Grid(final List<Tb1Combo2RegistForm> p) {
        this.tb1Combo2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1Combo2Grid.size(); i++) {
            Tb1Combo2RegistForm form = this.tb1Combo2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1Combo2Grid", i, gridErrors);
            }
        }
    }

}
