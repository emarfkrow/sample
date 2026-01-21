package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Prev2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Prev2RegistForm.class);

    /** 前世２登録フォームのリスト */
    @Valid
    private List<Tb8Prev2RegistForm> tb8Prev2Grid;

    /**
     * @return 前世２登録フォームのリスト
     */
    public List<Tb8Prev2RegistForm> getTb8Prev2Grid() {
        return tb8Prev2Grid;
    }

    /**
     * @param p 前世２登録フォームのリスト
     */
    public void setTb8Prev2Grid(final List<Tb8Prev2RegistForm> p) {
        this.tb8Prev2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Prev2Grid.size(); i++) {
            Tb8Prev2RegistForm form = this.tb8Prev2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Prev2Grid", i, gridErrors);
            }
        }
    }

}
