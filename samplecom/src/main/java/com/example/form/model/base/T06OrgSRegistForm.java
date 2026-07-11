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
public class T06OrgSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06OrgRegistForm.class);

    /** 起源登録フォームのリスト */
    @Valid
    private List<T06OrgRegistForm> t06OrgGrid;

    /**
     * @return 起源登録フォームのリスト
     */
    public List<T06OrgRegistForm> getT06OrgGrid() {
        return t06OrgGrid;
    }

    /**
     * @param p 起源登録フォームのリスト
     */
    public void setT06OrgGrid(final List<T06OrgRegistForm> p) {
        this.t06OrgGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06OrgGrid != null) {
            for (int i = 0; i < this.t06OrgGrid.size(); i++) {
                T06OrgRegistForm form = this.t06OrgGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06OrgGrid", i, gridErrors);
                }
            }
        }
    }

}
