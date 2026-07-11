package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 他生１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T11Tasho1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T11Tasho1RegistForm.class);

    /** 他生１登録フォームのリスト */
    @Valid
    private List<T11Tasho1RegistForm> t11Tasho1Grid;

    /**
     * @return 他生１登録フォームのリスト
     */
    public List<T11Tasho1RegistForm> getT11Tasho1Grid() {
        return t11Tasho1Grid;
    }

    /**
     * @param p 他生１登録フォームのリスト
     */
    public void setT11Tasho1Grid(final List<T11Tasho1RegistForm> p) {
        this.t11Tasho1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t11Tasho1Grid != null) {
            for (int i = 0; i < this.t11Tasho1Grid.size(); i++) {
                T11Tasho1RegistForm form = this.t11Tasho1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T11Tasho1Grid", i, gridErrors);
                }
            }
        }
    }

}
