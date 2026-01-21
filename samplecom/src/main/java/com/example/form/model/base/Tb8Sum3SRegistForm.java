package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 集約３一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Sum3SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Sum3RegistForm.class);

    /** 集約３登録フォームのリスト */
    @Valid
    private List<Tb8Sum3RegistForm> tb8Sum3Grid;

    /**
     * @return 集約３登録フォームのリスト
     */
    public List<Tb8Sum3RegistForm> getTb8Sum3Grid() {
        return tb8Sum3Grid;
    }

    /**
     * @param p 集約３登録フォームのリスト
     */
    public void setTb8Sum3Grid(final List<Tb8Sum3RegistForm> p) {
        this.tb8Sum3Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Sum3Grid.size(); i++) {
            Tb8Sum3RegistForm form = this.tb8Sum3Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Sum3Grid", i, gridErrors);
            }
        }
    }

}
