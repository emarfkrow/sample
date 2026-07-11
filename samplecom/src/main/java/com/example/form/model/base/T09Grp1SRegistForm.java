package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 集団１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T09Grp1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T09Grp1RegistForm.class);

    /** 集団１登録フォームのリスト */
    @Valid
    private List<T09Grp1RegistForm> t09Grp1Grid;

    /**
     * @return 集団１登録フォームのリスト
     */
    public List<T09Grp1RegistForm> getT09Grp1Grid() {
        return t09Grp1Grid;
    }

    /**
     * @param p 集団１登録フォームのリスト
     */
    public void setT09Grp1Grid(final List<T09Grp1RegistForm> p) {
        this.t09Grp1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t09Grp1Grid != null) {
            for (int i = 0; i < this.t09Grp1Grid.size(); i++) {
                T09Grp1RegistForm form = this.t09Grp1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T09Grp1Grid", i, gridErrors);
                }
            }
        }
    }

}
