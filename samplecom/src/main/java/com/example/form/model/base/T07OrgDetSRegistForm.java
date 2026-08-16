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
public class T07OrgDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07OrgDetRegistForm.class);

    /** 起源明細登録フォームのリスト */
    @Valid
    private List<T07OrgDetRegistForm> t07OrgDetGrid;

    /**
     * @return 起源明細登録フォームのリスト
     */
    public List<T07OrgDetRegistForm> getT07OrgDetGrid() {
        return t07OrgDetGrid;
    }

    /**
     * @param p 起源明細登録フォームのリスト
     */
    public void setT07OrgDetGrid(final List<T07OrgDetRegistForm> p) {
        this.t07OrgDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07OrgDetGrid != null) {
            for (int i = 0; i < this.t07OrgDetGrid.size(); i++) {
                T07OrgDetRegistForm form = this.t07OrgDetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07OrgDetGrid", i, gridErrors);
                }
            }
        }
    }

}
