package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生１明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T07Derive1DetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07Derive1DetRegistForm.class);

    /** 派生１明細登録フォームのリスト */
    @Valid
    private List<T07Derive1DetRegistForm> t07Derive1DetGrid;

    /**
     * @return 派生１明細登録フォームのリスト
     */
    public List<T07Derive1DetRegistForm> getT07Derive1DetGrid() {
        return t07Derive1DetGrid;
    }

    /**
     * @param p 派生１明細登録フォームのリスト
     */
    public void setT07Derive1DetGrid(final List<T07Derive1DetRegistForm> p) {
        this.t07Derive1DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07Derive1DetGrid != null) {
            for (int i = 0; i < this.t07Derive1DetGrid.size(); i++) {
                T07Derive1DetRegistForm form = this.t07Derive1DetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07Derive1DetGrid", i, gridErrors);
                }
            }
        }
    }

}
