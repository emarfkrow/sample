package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 候補１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T09Koho1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T09Koho1RegistForm.class);

    /** 候補１登録フォームのリスト */
    @Valid
    private List<T09Koho1RegistForm> t09Koho1Grid;

    /**
     * @return 候補１登録フォームのリスト
     */
    public List<T09Koho1RegistForm> getT09Koho1Grid() {
        return t09Koho1Grid;
    }

    /**
     * @param p 候補１登録フォームのリスト
     */
    public void setT09Koho1Grid(final List<T09Koho1RegistForm> p) {
        this.t09Koho1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t09Koho1Grid != null) {
            for (int i = 0; i < this.t09Koho1Grid.size(); i++) {
                T09Koho1RegistForm form = this.t09Koho1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T09Koho1Grid", i, gridErrors);
                }
            }
        }
    }

}
