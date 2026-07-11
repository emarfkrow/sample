package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 寄生１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T08Kisei1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T08Kisei1RegistForm.class);

    /** 寄生１登録フォームのリスト */
    @Valid
    private List<T08Kisei1RegistForm> t08Kisei1Grid;

    /**
     * @return 寄生１登録フォームのリスト
     */
    public List<T08Kisei1RegistForm> getT08Kisei1Grid() {
        return t08Kisei1Grid;
    }

    /**
     * @param p 寄生１登録フォームのリスト
     */
    public void setT08Kisei1Grid(final List<T08Kisei1RegistForm> p) {
        this.t08Kisei1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t08Kisei1Grid != null) {
            for (int i = 0; i < this.t08Kisei1Grid.size(); i++) {
                T08Kisei1RegistForm form = this.t08Kisei1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T08Kisei1Grid", i, gridErrors);
                }
            }
        }
    }

}
