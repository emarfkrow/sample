package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6Derive2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6Derive2RegistForm.class);

    /** 派生２登録フォームのリスト */
    @Valid
    private List<Tb6Derive2RegistForm> tb6Derive2Grid;

    /**
     * @return 派生２登録フォームのリスト
     */
    public List<Tb6Derive2RegistForm> getTb6Derive2Grid() {
        return tb6Derive2Grid;
    }

    /**
     * @param p 派生２登録フォームのリスト
     */
    public void setTb6Derive2Grid(final List<Tb6Derive2RegistForm> p) {
        this.tb6Derive2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6Derive2Grid.size(); i++) {
            Tb6Derive2RegistForm form = this.tb6Derive2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6Derive2Grid", i, gridErrors);
            }
        }
    }

}
