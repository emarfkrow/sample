package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 他生２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Tasho2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Tasho2RegistForm.class);

    /** 他生２登録フォームのリスト */
    @Valid
    private List<Tb8Tasho2RegistForm> tb8Tasho2Grid;

    /**
     * @return 他生２登録フォームのリスト
     */
    public List<Tb8Tasho2RegistForm> getTb8Tasho2Grid() {
        return tb8Tasho2Grid;
    }

    /**
     * @param p 他生２登録フォームのリスト
     */
    public void setTb8Tasho2Grid(final List<Tb8Tasho2RegistForm> p) {
        this.tb8Tasho2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Tasho2Grid.size(); i++) {
            Tb8Tasho2RegistForm form = this.tb8Tasho2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Tasho2Grid", i, gridErrors);
            }
        }
    }

}
