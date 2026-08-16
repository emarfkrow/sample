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
public class T02DinksSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02DinksRegistForm.class);

    /** 子なし登録フォームのリスト */
    @Valid
    private List<T02DinksRegistForm> t02DinksGrid;

    /**
     * @return 子なし登録フォームのリスト
     */
    public List<T02DinksRegistForm> getT02DinksGrid() {
        return t02DinksGrid;
    }

    /**
     * @param p 子なし登録フォームのリスト
     */
    public void setT02DinksGrid(final List<T02DinksRegistForm> p) {
        this.t02DinksGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02DinksGrid != null) {
            for (int i = 0; i < this.t02DinksGrid.size(); i++) {
                T02DinksRegistForm form = this.t02DinksGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02DinksGrid", i, gridErrors);
                }
            }
        }
    }

}
