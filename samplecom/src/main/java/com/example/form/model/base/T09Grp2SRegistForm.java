package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 集団２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T09Grp2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T09Grp2RegistForm.class);

    /** 集団２登録フォームのリスト */
    @Valid
    private List<T09Grp2RegistForm> t09Grp2Grid;

    /**
     * @return 集団２登録フォームのリスト
     */
    public List<T09Grp2RegistForm> getT09Grp2Grid() {
        return t09Grp2Grid;
    }

    /**
     * @param p 集団２登録フォームのリスト
     */
    public void setT09Grp2Grid(final List<T09Grp2RegistForm> p) {
        this.t09Grp2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t09Grp2Grid != null) {
            for (int i = 0; i < this.t09Grp2Grid.size(); i++) {
                T09Grp2RegistForm form = this.t09Grp2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T09Grp2Grid", i, gridErrors);
                }
            }
        }
    }

}
