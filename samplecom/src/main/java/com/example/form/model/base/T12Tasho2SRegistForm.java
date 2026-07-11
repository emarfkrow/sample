package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 他生２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T12Tasho2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T12Tasho2RegistForm.class);

    /** 他生２登録フォームのリスト */
    @Valid
    private List<T12Tasho2RegistForm> t12Tasho2Grid;

    /**
     * @return 他生２登録フォームのリスト
     */
    public List<T12Tasho2RegistForm> getT12Tasho2Grid() {
        return t12Tasho2Grid;
    }

    /**
     * @param p 他生２登録フォームのリスト
     */
    public void setT12Tasho2Grid(final List<T12Tasho2RegistForm> p) {
        this.t12Tasho2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t12Tasho2Grid != null) {
            for (int i = 0; i < this.t12Tasho2Grid.size(); i++) {
                T12Tasho2RegistForm form = this.t12Tasho2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T12Tasho2Grid", i, gridErrors);
                }
            }
        }
    }

}
