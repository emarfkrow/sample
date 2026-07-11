package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T06Derive2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06Derive2RegistForm.class);

    /** 派生２登録フォームのリスト */
    @Valid
    private List<T06Derive2RegistForm> t06Derive2Grid;

    /**
     * @return 派生２登録フォームのリスト
     */
    public List<T06Derive2RegistForm> getT06Derive2Grid() {
        return t06Derive2Grid;
    }

    /**
     * @param p 派生２登録フォームのリスト
     */
    public void setT06Derive2Grid(final List<T06Derive2RegistForm> p) {
        this.t06Derive2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06Derive2Grid != null) {
            for (int i = 0; i < this.t06Derive2Grid.size(); i++) {
                T06Derive2RegistForm form = this.t06Derive2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06Derive2Grid", i, gridErrors);
                }
            }
        }
    }

}
