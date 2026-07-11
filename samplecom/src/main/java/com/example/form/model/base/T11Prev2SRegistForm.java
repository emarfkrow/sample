package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T11Prev2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T11Prev2RegistForm.class);

    /** 前世２登録フォームのリスト */
    @Valid
    private List<T11Prev2RegistForm> t11Prev2Grid;

    /**
     * @return 前世２登録フォームのリスト
     */
    public List<T11Prev2RegistForm> getT11Prev2Grid() {
        return t11Prev2Grid;
    }

    /**
     * @param p 前世２登録フォームのリスト
     */
    public void setT11Prev2Grid(final List<T11Prev2RegistForm> p) {
        this.t11Prev2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t11Prev2Grid != null) {
            for (int i = 0; i < this.t11Prev2Grid.size(); i++) {
                T11Prev2RegistForm form = this.t11Prev2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T11Prev2Grid", i, gridErrors);
                }
            }
        }
    }

}
