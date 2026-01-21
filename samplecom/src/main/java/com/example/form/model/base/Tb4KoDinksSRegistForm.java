package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 子なし一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb4KoDinksSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb4KoDinksRegistForm.class);

    /** 子なし登録フォームのリスト */
    @Valid
    private List<Tb4KoDinksRegistForm> tb4KoDinksGrid;

    /**
     * @return 子なし登録フォームのリスト
     */
    public List<Tb4KoDinksRegistForm> getTb4KoDinksGrid() {
        return tb4KoDinksGrid;
    }

    /**
     * @param p 子なし登録フォームのリスト
     */
    public void setTb4KoDinksGrid(final List<Tb4KoDinksRegistForm> p) {
        this.tb4KoDinksGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb4KoDinksGrid.size(); i++) {
            Tb4KoDinksRegistForm form = this.tb4KoDinksGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb4KoDinksGrid", i, gridErrors);
            }
        }
    }

}
