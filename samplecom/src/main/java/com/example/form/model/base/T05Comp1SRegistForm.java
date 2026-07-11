package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 複合１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T05Comp1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T05Comp1RegistForm.class);

    /** 複合１登録フォームのリスト */
    @Valid
    private List<T05Comp1RegistForm> t05Comp1Grid;

    /**
     * @return 複合１登録フォームのリスト
     */
    public List<T05Comp1RegistForm> getT05Comp1Grid() {
        return t05Comp1Grid;
    }

    /**
     * @param p 複合１登録フォームのリスト
     */
    public void setT05Comp1Grid(final List<T05Comp1RegistForm> p) {
        this.t05Comp1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t05Comp1Grid != null) {
            for (int i = 0; i < this.t05Comp1Grid.size(); i++) {
                T05Comp1RegistForm form = this.t05Comp1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T05Comp1Grid", i, gridErrors);
                }
            }
        }
    }

}
