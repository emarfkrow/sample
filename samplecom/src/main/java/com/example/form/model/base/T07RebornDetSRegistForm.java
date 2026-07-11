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
public class T07RebornDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07RebornDetRegistForm.class);

    /** 転生明細登録フォームのリスト */
    @Valid
    private List<T07RebornDetRegistForm> t07RebornDetGrid;

    /**
     * @return 転生明細登録フォームのリスト
     */
    public List<T07RebornDetRegistForm> getT07RebornDetGrid() {
        return t07RebornDetGrid;
    }

    /**
     * @param p 転生明細登録フォームのリスト
     */
    public void setT07RebornDetGrid(final List<T07RebornDetRegistForm> p) {
        this.t07RebornDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07RebornDetGrid != null) {
            for (int i = 0; i < this.t07RebornDetGrid.size(); i++) {
                T07RebornDetRegistForm form = this.t07RebornDetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07RebornDetGrid", i, gridErrors);
                }
            }
        }
    }

}
