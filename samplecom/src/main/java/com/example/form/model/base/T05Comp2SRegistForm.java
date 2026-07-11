package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 複合２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T05Comp2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T05Comp2RegistForm.class);

    /** 複合２登録フォームのリスト */
    @Valid
    private List<T05Comp2RegistForm> t05Comp2Grid;

    /**
     * @return 複合２登録フォームのリスト
     */
    public List<T05Comp2RegistForm> getT05Comp2Grid() {
        return t05Comp2Grid;
    }

    /**
     * @param p 複合２登録フォームのリスト
     */
    public void setT05Comp2Grid(final List<T05Comp2RegistForm> p) {
        this.t05Comp2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t05Comp2Grid != null) {
            for (int i = 0; i < this.t05Comp2Grid.size(); i++) {
                T05Comp2RegistForm form = this.t05Comp2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T05Comp2Grid", i, gridErrors);
                }
            }
        }
    }

}
