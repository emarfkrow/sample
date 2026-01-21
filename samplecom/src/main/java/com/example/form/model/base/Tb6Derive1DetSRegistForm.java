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
public class Tb6Derive1DetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6Derive1DetRegistForm.class);

    /** 派生１明細登録フォームのリスト */
    @Valid
    private List<Tb6Derive1DetRegistForm> tb6Derive1DetGrid;

    /**
     * @return 派生１明細登録フォームのリスト
     */
    public List<Tb6Derive1DetRegistForm> getTb6Derive1DetGrid() {
        return tb6Derive1DetGrid;
    }

    /**
     * @param p 派生１明細登録フォームのリスト
     */
    public void setTb6Derive1DetGrid(final List<Tb6Derive1DetRegistForm> p) {
        this.tb6Derive1DetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6Derive1DetGrid.size(); i++) {
            Tb6Derive1DetRegistForm form = this.tb6Derive1DetGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6Derive1DetGrid", i, gridErrors);
            }
        }
    }

}
