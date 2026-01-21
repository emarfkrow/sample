package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 起源明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6OrgDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6OrgDetRegistForm.class);

    /** 起源明細登録フォームのリスト */
    @Valid
    private List<Tb6OrgDetRegistForm> tb6OrgDetGrid;

    /**
     * @return 起源明細登録フォームのリスト
     */
    public List<Tb6OrgDetRegistForm> getTb6OrgDetGrid() {
        return tb6OrgDetGrid;
    }

    /**
     * @param p 起源明細登録フォームのリスト
     */
    public void setTb6OrgDetGrid(final List<Tb6OrgDetRegistForm> p) {
        this.tb6OrgDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6OrgDetGrid.size(); i++) {
            Tb6OrgDetRegistForm form = this.tb6OrgDetGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6OrgDetGrid", i, gridErrors);
            }
        }
    }

}
