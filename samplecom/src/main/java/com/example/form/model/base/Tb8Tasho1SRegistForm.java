package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 他生１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb8Tasho1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8Tasho1RegistForm.class);

    /** 他生１登録フォームのリスト */
    @Valid
    private List<Tb8Tasho1RegistForm> tb8Tasho1Grid;

    /**
     * @return 他生１登録フォームのリスト
     */
    public List<Tb8Tasho1RegistForm> getTb8Tasho1Grid() {
        return tb8Tasho1Grid;
    }

    /**
     * @param p 他生１登録フォームのリスト
     */
    public void setTb8Tasho1Grid(final List<Tb8Tasho1RegistForm> p) {
        this.tb8Tasho1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8Tasho1Grid.size(); i++) {
            Tb8Tasho1RegistForm form = this.tb8Tasho1Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8Tasho1Grid", i, gridErrors);
            }
        }
    }

}
