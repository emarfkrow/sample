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
public class T06Derive2DetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06Derive2DetRegistForm.class);

    /** 派生２明細登録フォームのリスト */
    @Valid
    private List<T06Derive2DetRegistForm> t06Derive2DetGrid;

    /**
     * @return 派生２明細登録フォームのリスト
     */
    public List<T06Derive2DetRegistForm> getT06Derive2DetGrid() {
        return t06Derive2DetGrid;
    }

    /**
     * @param p 派生２明細登録フォームのリスト
     */
    public void setT06Derive2DetGrid(final List<T06Derive2DetRegistForm> p) {
        this.t06Derive2DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06Derive2DetGrid != null) {
            for (int i = 0; i < this.t06Derive2DetGrid.size(); i++) {
                T06Derive2DetRegistForm form = this.t06Derive2DetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06Derive2DetGrid", i, gridErrors);
                }
            }
        }
    }

}
