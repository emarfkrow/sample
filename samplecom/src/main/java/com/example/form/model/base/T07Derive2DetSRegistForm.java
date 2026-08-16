package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生２明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T07Derive2DetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07Derive2DetRegistForm.class);

    /** 派生２明細登録フォームのリスト */
    @Valid
    private List<T07Derive2DetRegistForm> t07Derive2DetGrid;

    /**
     * @return 派生２明細登録フォームのリスト
     */
    public List<T07Derive2DetRegistForm> getT07Derive2DetGrid() {
        return t07Derive2DetGrid;
    }

    /**
     * @param p 派生２明細登録フォームのリスト
     */
    public void setT07Derive2DetGrid(final List<T07Derive2DetRegistForm> p) {
        this.t07Derive2DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07Derive2DetGrid != null) {
            for (int i = 0; i < this.t07Derive2DetGrid.size(); i++) {
                T07Derive2DetRegistForm form = this.t07Derive2DetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07Derive2DetGrid", i, gridErrors);
                }
            }
        }
    }

}
