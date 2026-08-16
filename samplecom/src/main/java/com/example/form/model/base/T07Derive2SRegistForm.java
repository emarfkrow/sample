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
public class T07Derive2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07Derive2RegistForm.class);

    /** 派生２登録フォームのリスト */
    @Valid
    private List<T07Derive2RegistForm> t07Derive2Grid;

    /**
     * @return 派生２登録フォームのリスト
     */
    public List<T07Derive2RegistForm> getT07Derive2Grid() {
        return t07Derive2Grid;
    }

    /**
     * @param p 派生２登録フォームのリスト
     */
    public void setT07Derive2Grid(final List<T07Derive2RegistForm> p) {
        this.t07Derive2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07Derive2Grid != null) {
            for (int i = 0; i < this.t07Derive2Grid.size(); i++) {
                T07Derive2RegistForm form = this.t07Derive2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07Derive2Grid", i, gridErrors);
                }
            }
        }
    }

}
