package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 候補２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T09Koho2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T09Koho2RegistForm.class);

    /** 候補２登録フォームのリスト */
    @Valid
    private List<T09Koho2RegistForm> t09Koho2Grid;

    /**
     * @return 候補２登録フォームのリスト
     */
    public List<T09Koho2RegistForm> getT09Koho2Grid() {
        return t09Koho2Grid;
    }

    /**
     * @param p 候補２登録フォームのリスト
     */
    public void setT09Koho2Grid(final List<T09Koho2RegistForm> p) {
        this.t09Koho2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t09Koho2Grid != null) {
            for (int i = 0; i < this.t09Koho2Grid.size(); i++) {
                T09Koho2RegistForm form = this.t09Koho2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T09Koho2Grid", i, gridErrors);
                }
            }
        }
    }

}
