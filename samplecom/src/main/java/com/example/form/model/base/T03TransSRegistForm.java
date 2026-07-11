package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変遷一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T03TransSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T03TransRegistForm.class);

    /** 変遷登録フォームのリスト */
    @Valid
    private List<T03TransRegistForm> t03TransGrid;

    /**
     * @return 変遷登録フォームのリスト
     */
    public List<T03TransRegistForm> getT03TransGrid() {
        return t03TransGrid;
    }

    /**
     * @param p 変遷登録フォームのリスト
     */
    public void setT03TransGrid(final List<T03TransRegistForm> p) {
        this.t03TransGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t03TransGrid != null) {
            for (int i = 0; i < this.t03TransGrid.size(); i++) {
                T03TransRegistForm form = this.t03TransGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T03TransGrid", i, gridErrors);
                }
            }
        }
    }

}
