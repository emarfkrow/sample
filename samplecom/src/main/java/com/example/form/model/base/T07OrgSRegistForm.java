package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 起源一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T07OrgSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07OrgRegistForm.class);

    /** 起源登録フォームのリスト */
    @Valid
    private List<T07OrgRegistForm> t07OrgGrid;

    /**
     * @return 起源登録フォームのリスト
     */
    public List<T07OrgRegistForm> getT07OrgGrid() {
        return t07OrgGrid;
    }

    /**
     * @param p 起源登録フォームのリスト
     */
    public void setT07OrgGrid(final List<T07OrgRegistForm> p) {
        this.t07OrgGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07OrgGrid != null) {
            for (int i = 0; i < this.t07OrgGrid.size(); i++) {
                T07OrgRegistForm form = this.t07OrgGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07OrgGrid", i, gridErrors);
                }
            }
        }
    }

}
