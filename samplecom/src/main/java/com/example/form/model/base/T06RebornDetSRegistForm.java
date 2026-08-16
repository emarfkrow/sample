package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T06RebornDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06RebornDetRegistForm.class);

    /** 転生明細登録フォームのリスト */
    @Valid
    private List<T06RebornDetRegistForm> t06RebornDetGrid;

    /**
     * @return 転生明細登録フォームのリスト
     */
    public List<T06RebornDetRegistForm> getT06RebornDetGrid() {
        return t06RebornDetGrid;
    }

    /**
     * @param p 転生明細登録フォームのリスト
     */
    public void setT06RebornDetGrid(final List<T06RebornDetRegistForm> p) {
        this.t06RebornDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06RebornDetGrid != null) {
            for (int i = 0; i < this.t06RebornDetGrid.size(); i++) {
                T06RebornDetRegistForm form = this.t06RebornDetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06RebornDetGrid", i, gridErrors);
                }
            }
        }
    }

}
