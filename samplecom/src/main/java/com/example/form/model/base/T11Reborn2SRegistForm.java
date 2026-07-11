package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T11Reborn2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T11Reborn2RegistForm.class);

    /** 転生２登録フォームのリスト */
    @Valid
    private List<T11Reborn2RegistForm> t11Reborn2Grid;

    /**
     * @return 転生２登録フォームのリスト
     */
    public List<T11Reborn2RegistForm> getT11Reborn2Grid() {
        return t11Reborn2Grid;
    }

    /**
     * @param p 転生２登録フォームのリスト
     */
    public void setT11Reborn2Grid(final List<T11Reborn2RegistForm> p) {
        this.t11Reborn2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t11Reborn2Grid != null) {
            for (int i = 0; i < this.t11Reborn2Grid.size(); i++) {
                T11Reborn2RegistForm form = this.t11Reborn2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T11Reborn2Grid", i, gridErrors);
                }
            }
        }
    }

}
