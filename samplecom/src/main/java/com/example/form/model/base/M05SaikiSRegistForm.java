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
public class M05SaikiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M05SaikiRegistForm.class);

    /** 再帰登録フォームのリスト */
    @Valid
    private List<M05SaikiRegistForm> m05SaikiGrid;

    /**
     * @return 再帰登録フォームのリスト
     */
    public List<M05SaikiRegistForm> getM05SaikiGrid() {
        return m05SaikiGrid;
    }

    /**
     * @param p 再帰登録フォームのリスト
     */
    public void setM05SaikiGrid(final List<M05SaikiRegistForm> p) {
        this.m05SaikiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m05SaikiGrid != null) {
            for (int i = 0; i < this.m05SaikiGrid.size(); i++) {
                M05SaikiRegistForm form = this.m05SaikiGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M05SaikiGrid", i, gridErrors);
                }
            }
        }
    }

}
