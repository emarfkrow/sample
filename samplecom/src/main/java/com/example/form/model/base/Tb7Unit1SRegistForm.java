package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 単位１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb7Unit1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb7Unit1RegistForm.class);

    /** 単位１登録フォームのリスト */
    @Valid
    private List<Tb7Unit1RegistForm> tb7Unit1Grid;

    /**
     * @return 単位１登録フォームのリスト
     */
    public List<Tb7Unit1RegistForm> getTb7Unit1Grid() {
        return tb7Unit1Grid;
    }

    /**
     * @param p 単位１登録フォームのリスト
     */
    public void setTb7Unit1Grid(final List<Tb7Unit1RegistForm> p) {
        this.tb7Unit1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb7Unit1Grid.size(); i++) {
            Tb7Unit1RegistForm form = this.tb7Unit1Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb7Unit1Grid", i, gridErrors);
            }
        }
    }

}
