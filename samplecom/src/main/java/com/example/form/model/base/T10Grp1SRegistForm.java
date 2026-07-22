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
public class T10Grp1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T10Grp1RegistForm.class);

    /** 集団１登録フォームのリスト */
    @Valid
    private List<T10Grp1RegistForm> t10Grp1Grid;

    /**
     * @return 集団１登録フォームのリスト
     */
    public List<T10Grp1RegistForm> getT10Grp1Grid() {
        return t10Grp1Grid;
    }

    /**
     * @param p 集団１登録フォームのリスト
     */
    public void setT10Grp1Grid(final List<T10Grp1RegistForm> p) {
        this.t10Grp1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t10Grp1Grid != null) {
            for (int i = 0; i < this.t10Grp1Grid.size(); i++) {
                T10Grp1RegistForm form = this.t10Grp1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T10Grp1Grid", i, gridErrors);
                }
            }
        }
    }

}
