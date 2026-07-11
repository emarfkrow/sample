package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 候補３一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T12Koho3SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T12Koho3RegistForm.class);

    /** 候補３登録フォームのリスト */
    @Valid
    private List<T12Koho3RegistForm> t12Koho3Grid;

    /**
     * @return 候補３登録フォームのリスト
     */
    public List<T12Koho3RegistForm> getT12Koho3Grid() {
        return t12Koho3Grid;
    }

    /**
     * @param p 候補３登録フォームのリスト
     */
    public void setT12Koho3Grid(final List<T12Koho3RegistForm> p) {
        this.t12Koho3Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t12Koho3Grid != null) {
            for (int i = 0; i < this.t12Koho3Grid.size(); i++) {
                T12Koho3RegistForm form = this.t12Koho3Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T12Koho3Grid", i, gridErrors);
                }
            }
        }
    }

}
