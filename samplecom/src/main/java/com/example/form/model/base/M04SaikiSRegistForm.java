package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 再帰一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M04SaikiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04SaikiRegistForm.class);

    /** 再帰登録フォームのリスト */
    @Valid
    private List<M04SaikiRegistForm> m04SaikiGrid;

    /**
     * @return 再帰登録フォームのリスト
     */
    public List<M04SaikiRegistForm> getM04SaikiGrid() {
        return m04SaikiGrid;
    }

    /**
     * @param p 再帰登録フォームのリスト
     */
    public void setM04SaikiGrid(final List<M04SaikiRegistForm> p) {
        this.m04SaikiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.m04SaikiGrid.size(); i++) {
            M04SaikiRegistForm form = this.m04SaikiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "M04SaikiGrid", i, gridErrors);
            }
        }
    }

}
