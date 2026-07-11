package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T06Derive1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06Derive1RegistForm.class);

    /** 派生１登録フォームのリスト */
    @Valid
    private List<T06Derive1RegistForm> t06Derive1Grid;

    /**
     * @return 派生１登録フォームのリスト
     */
    public List<T06Derive1RegistForm> getT06Derive1Grid() {
        return t06Derive1Grid;
    }

    /**
     * @param p 派生１登録フォームのリスト
     */
    public void setT06Derive1Grid(final List<T06Derive1RegistForm> p) {
        this.t06Derive1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06Derive1Grid != null) {
            for (int i = 0; i < this.t06Derive1Grid.size(); i++) {
                T06Derive1RegistForm form = this.t06Derive1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06Derive1Grid", i, gridErrors);
                }
            }
        }
    }

}
