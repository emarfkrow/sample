package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Reborn2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Reborn2RegistForm.class);

    /** 転生２登録フォームのリスト */
    @Valid
    private List<Tb8Reborn2RegistForm> tb8Reborn2Grid;

    /**
     * @return 転生２登録フォームのリスト
     */
    public List<Tb8Reborn2RegistForm> getTb8Reborn2Grid() {
        return tb8Reborn2Grid;
    }

    /**
     * @param p 転生２登録フォームのリスト
     */
    public void setTb8Reborn2Grid(final List<Tb8Reborn2RegistForm> p) {
        this.tb8Reborn2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Reborn2Grid.size(); i++) {
            Tb8Reborn2RegistForm form = this.tb8Reborn2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Reborn2Grid", i, gridErrors);
            }
        }
    }

}
