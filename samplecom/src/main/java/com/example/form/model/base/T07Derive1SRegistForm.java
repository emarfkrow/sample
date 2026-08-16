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
public class T07Derive1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07Derive1RegistForm.class);

    /** 派生１登録フォームのリスト */
    @Valid
    private List<T07Derive1RegistForm> t07Derive1Grid;

    /**
     * @return 派生１登録フォームのリスト
     */
    public List<T07Derive1RegistForm> getT07Derive1Grid() {
        return t07Derive1Grid;
    }

    /**
     * @param p 派生１登録フォームのリスト
     */
    public void setT07Derive1Grid(final List<T07Derive1RegistForm> p) {
        this.t07Derive1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07Derive1Grid != null) {
            for (int i = 0; i < this.t07Derive1Grid.size(); i++) {
                T07Derive1RegistForm form = this.t07Derive1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07Derive1Grid", i, gridErrors);
                }
            }
        }
    }

}
