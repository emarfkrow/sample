package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 子なし一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01DinksSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01DinksRegistForm.class);

    /** 子なし登録フォームのリスト */
    @Valid
    private List<T01DinksRegistForm> t01DinksGrid;

    /**
     * @return 子なし登録フォームのリスト
     */
    public List<T01DinksRegistForm> getT01DinksGrid() {
        return t01DinksGrid;
    }

    /**
     * @param p 子なし登録フォームのリスト
     */
    public void setT01DinksGrid(final List<T01DinksRegistForm> p) {
        this.t01DinksGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01DinksGrid != null) {
            for (int i = 0; i < this.t01DinksGrid.size(); i++) {
                T01DinksRegistForm form = this.t01DinksGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01DinksGrid", i, gridErrors);
                }
            }
        }
    }

}
