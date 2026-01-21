package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 単位２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb7Unit2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb7Unit2RegistForm.class);

    /** 単位２登録フォームのリスト */
    @Valid
    private List<Tb7Unit2RegistForm> tb7Unit2Grid;

    /**
     * @return 単位２登録フォームのリスト
     */
    public List<Tb7Unit2RegistForm> getTb7Unit2Grid() {
        return tb7Unit2Grid;
    }

    /**
     * @param p 単位２登録フォームのリスト
     */
    public void setTb7Unit2Grid(final List<Tb7Unit2RegistForm> p) {
        this.tb7Unit2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb7Unit2Grid.size(); i++) {
            Tb7Unit2RegistForm form = this.tb7Unit2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb7Unit2Grid", i, gridErrors);
            }
        }
    }

}
