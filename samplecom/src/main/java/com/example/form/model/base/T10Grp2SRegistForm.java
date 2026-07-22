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
public class T10Grp2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T10Grp2RegistForm.class);

    /** 集団２登録フォームのリスト */
    @Valid
    private List<T10Grp2RegistForm> t10Grp2Grid;

    /**
     * @return 集団２登録フォームのリスト
     */
    public List<T10Grp2RegistForm> getT10Grp2Grid() {
        return t10Grp2Grid;
    }

    /**
     * @param p 集団２登録フォームのリスト
     */
    public void setT10Grp2Grid(final List<T10Grp2RegistForm> p) {
        this.t10Grp2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t10Grp2Grid != null) {
            for (int i = 0; i < this.t10Grp2Grid.size(); i++) {
                T10Grp2RegistForm form = this.t10Grp2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T10Grp2Grid", i, gridErrors);
                }
            }
        }
    }

}
