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
public class T04Comp2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T04Comp2RegistForm.class);

    /** 複合２登録フォームのリスト */
    @Valid
    private List<T04Comp2RegistForm> t04Comp2Grid;

    /**
     * @return 複合２登録フォームのリスト
     */
    public List<T04Comp2RegistForm> getT04Comp2Grid() {
        return t04Comp2Grid;
    }

    /**
     * @param p 複合２登録フォームのリスト
     */
    public void setT04Comp2Grid(final List<T04Comp2RegistForm> p) {
        this.t04Comp2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t04Comp2Grid != null) {
            for (int i = 0; i < this.t04Comp2Grid.size(); i++) {
                T04Comp2RegistForm form = this.t04Comp2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T04Comp2Grid", i, gridErrors);
                }
            }
        }
    }

}
