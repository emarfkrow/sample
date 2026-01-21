package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 単位３一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Unit3SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Unit3RegistForm.class);

    /** 単位３登録フォームのリスト */
    @Valid
    private List<Tb8Unit3RegistForm> tb8Unit3Grid;

    /**
     * @return 単位３登録フォームのリスト
     */
    public List<Tb8Unit3RegistForm> getTb8Unit3Grid() {
        return tb8Unit3Grid;
    }

    /**
     * @param p 単位３登録フォームのリスト
     */
    public void setTb8Unit3Grid(final List<Tb8Unit3RegistForm> p) {
        this.tb8Unit3Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Unit3Grid.size(); i++) {
            Tb8Unit3RegistForm form = this.tb8Unit3Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Unit3Grid", i, gridErrors);
            }
        }
    }

}
