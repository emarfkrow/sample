package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 寄生２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T08Kisei2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T08Kisei2RegistForm.class);

    /** 寄生２登録フォームのリスト */
    @Valid
    private List<T08Kisei2RegistForm> t08Kisei2Grid;

    /**
     * @return 寄生２登録フォームのリスト
     */
    public List<T08Kisei2RegistForm> getT08Kisei2Grid() {
        return t08Kisei2Grid;
    }

    /**
     * @param p 寄生２登録フォームのリスト
     */
    public void setT08Kisei2Grid(final List<T08Kisei2RegistForm> p) {
        this.t08Kisei2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t08Kisei2Grid != null) {
            for (int i = 0; i < this.t08Kisei2Grid.size(); i++) {
                T08Kisei2RegistForm form = this.t08Kisei2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T08Kisei2Grid", i, gridErrors);
                }
            }
        }
    }

}
