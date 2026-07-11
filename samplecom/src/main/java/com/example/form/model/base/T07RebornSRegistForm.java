package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T07RebornSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07RebornRegistForm.class);

    /** 転生登録フォームのリスト */
    @Valid
    private List<T07RebornRegistForm> t07RebornGrid;

    /**
     * @return 転生登録フォームのリスト
     */
    public List<T07RebornRegistForm> getT07RebornGrid() {
        return t07RebornGrid;
    }

    /**
     * @param p 転生登録フォームのリスト
     */
    public void setT07RebornGrid(final List<T07RebornRegistForm> p) {
        this.t07RebornGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07RebornGrid != null) {
            for (int i = 0; i < this.t07RebornGrid.size(); i++) {
                T07RebornRegistForm form = this.t07RebornGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07RebornGrid", i, gridErrors);
                }
            }
        }
    }

}
