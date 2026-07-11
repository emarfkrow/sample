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
public class T06Derive1DetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06Derive1DetRegistForm.class);

    /** 派生１明細登録フォームのリスト */
    @Valid
    private List<T06Derive1DetRegistForm> t06Derive1DetGrid;

    /**
     * @return 派生１明細登録フォームのリスト
     */
    public List<T06Derive1DetRegistForm> getT06Derive1DetGrid() {
        return t06Derive1DetGrid;
    }

    /**
     * @param p 派生１明細登録フォームのリスト
     */
    public void setT06Derive1DetGrid(final List<T06Derive1DetRegistForm> p) {
        this.t06Derive1DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06Derive1DetGrid != null) {
            for (int i = 0; i < this.t06Derive1DetGrid.size(); i++) {
                T06Derive1DetRegistForm form = this.t06Derive1DetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06Derive1DetGrid", i, gridErrors);
                }
            }
        }
    }

}
