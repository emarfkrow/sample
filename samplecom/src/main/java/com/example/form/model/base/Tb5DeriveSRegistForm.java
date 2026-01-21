package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 派生一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb5DeriveSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb5DeriveRegistForm.class);

    /** 派生登録フォームのリスト */
    @Valid
    private List<Tb5DeriveRegistForm> tb5DeriveGrid;

    /**
     * @return 派生登録フォームのリスト
     */
    public List<Tb5DeriveRegistForm> getTb5DeriveGrid() {
        return tb5DeriveGrid;
    }

    /**
     * @param p 派生登録フォームのリスト
     */
    public void setTb5DeriveGrid(final List<Tb5DeriveRegistForm> p) {
        this.tb5DeriveGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb5DeriveGrid.size(); i++) {
            Tb5DeriveRegistForm form = this.tb5DeriveGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb5DeriveGrid", i, gridErrors);
            }
        }
    }

}
