package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 単位４一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Unit4SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Unit4RegistForm.class);

    /** 単位４登録フォームのリスト */
    @Valid
    private List<Tb8Unit4RegistForm> tb8Unit4Grid;

    /**
     * @return 単位４登録フォームのリスト
     */
    public List<Tb8Unit4RegistForm> getTb8Unit4Grid() {
        return tb8Unit4Grid;
    }

    /**
     * @param p 単位４登録フォームのリスト
     */
    public void setTb8Unit4Grid(final List<Tb8Unit4RegistForm> p) {
        this.tb8Unit4Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Unit4Grid.size(); i++) {
            Tb8Unit4RegistForm form = this.tb8Unit4Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Unit4Grid", i, gridErrors);
            }
        }
    }

}
