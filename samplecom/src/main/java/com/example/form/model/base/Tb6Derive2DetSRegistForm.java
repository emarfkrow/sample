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
public class Tb6Derive2DetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6Derive2DetRegistForm.class);

    /** 派生２明細登録フォームのリスト */
    @Valid
    private List<Tb6Derive2DetRegistForm> tb6Derive2DetGrid;

    /**
     * @return 派生２明細登録フォームのリスト
     */
    public List<Tb6Derive2DetRegistForm> getTb6Derive2DetGrid() {
        return tb6Derive2DetGrid;
    }

    /**
     * @param p 派生２明細登録フォームのリスト
     */
    public void setTb6Derive2DetGrid(final List<Tb6Derive2DetRegistForm> p) {
        this.tb6Derive2DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6Derive2DetGrid.size(); i++) {
            Tb6Derive2DetRegistForm form = this.tb6Derive2DetGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6Derive2DetGrid", i, gridErrors);
            }
        }
    }

}
