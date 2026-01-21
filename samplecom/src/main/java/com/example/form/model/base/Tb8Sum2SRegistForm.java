package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 集約２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Sum2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Sum2RegistForm.class);

    /** 集約２登録フォームのリスト */
    @Valid
    private List<Tb8Sum2RegistForm> tb8Sum2Grid;

    /**
     * @return 集約２登録フォームのリスト
     */
    public List<Tb8Sum2RegistForm> getTb8Sum2Grid() {
        return tb8Sum2Grid;
    }

    /**
     * @param p 集約２登録フォームのリスト
     */
    public void setTb8Sum2Grid(final List<Tb8Sum2RegistForm> p) {
        this.tb8Sum2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Sum2Grid.size(); i++) {
            Tb8Sum2RegistForm form = this.tb8Sum2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Sum2Grid", i, gridErrors);
            }
        }
    }

}
