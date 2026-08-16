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
public class T04Comp1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T04Comp1RegistForm.class);

    /** 複合１登録フォームのリスト */
    @Valid
    private List<T04Comp1RegistForm> t04Comp1Grid;

    /**
     * @return 複合１登録フォームのリスト
     */
    public List<T04Comp1RegistForm> getT04Comp1Grid() {
        return t04Comp1Grid;
    }

    /**
     * @param p 複合１登録フォームのリスト
     */
    public void setT04Comp1Grid(final List<T04Comp1RegistForm> p) {
        this.t04Comp1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t04Comp1Grid != null) {
            for (int i = 0; i < this.t04Comp1Grid.size(); i++) {
                T04Comp1RegistForm form = this.t04Comp1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T04Comp1Grid", i, gridErrors);
                }
            }
        }
    }

}
