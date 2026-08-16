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
public class T06RebornSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06RebornRegistForm.class);

    /** 転生登録フォームのリスト */
    @Valid
    private List<T06RebornRegistForm> t06RebornGrid;

    /**
     * @return 転生登録フォームのリスト
     */
    public List<T06RebornRegistForm> getT06RebornGrid() {
        return t06RebornGrid;
    }

    /**
     * @param p 転生登録フォームのリスト
     */
    public void setT06RebornGrid(final List<T06RebornRegistForm> p) {
        this.t06RebornGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06RebornGrid != null) {
            for (int i = 0; i < this.t06RebornGrid.size(); i++) {
                T06RebornRegistForm form = this.t06RebornGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06RebornGrid", i, gridErrors);
                }
            }
        }
    }

}
