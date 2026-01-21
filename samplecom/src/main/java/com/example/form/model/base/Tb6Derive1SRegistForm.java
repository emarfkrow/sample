package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6Derive1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6Derive1RegistForm.class);

    /** 派生１登録フォームのリスト */
    @Valid
    private List<Tb6Derive1RegistForm> tb6Derive1Grid;

    /**
     * @return 派生１登録フォームのリスト
     */
    public List<Tb6Derive1RegistForm> getTb6Derive1Grid() {
        return tb6Derive1Grid;
    }

    /**
     * @param p 派生１登録フォームのリスト
     */
    public void setTb6Derive1Grid(final List<Tb6Derive1RegistForm> p) {
        this.tb6Derive1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6Derive1Grid.size(); i++) {
            Tb6Derive1RegistForm form = this.tb6Derive1Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6Derive1Grid", i, gridErrors);
            }
        }
    }

}
