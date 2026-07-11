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
public class T06OrgDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06OrgDetRegistForm.class);

    /** 起源明細登録フォームのリスト */
    @Valid
    private List<T06OrgDetRegistForm> t06OrgDetGrid;

    /**
     * @return 起源明細登録フォームのリスト
     */
    public List<T06OrgDetRegistForm> getT06OrgDetGrid() {
        return t06OrgDetGrid;
    }

    /**
     * @param p 起源明細登録フォームのリスト
     */
    public void setT06OrgDetGrid(final List<T06OrgDetRegistForm> p) {
        this.t06OrgDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06OrgDetGrid != null) {
            for (int i = 0; i < this.t06OrgDetGrid.size(); i++) {
                T06OrgDetRegistForm form = this.t06OrgDetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06OrgDetGrid", i, gridErrors);
                }
            }
        }
    }

}
