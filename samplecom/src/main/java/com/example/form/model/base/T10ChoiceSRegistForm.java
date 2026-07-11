package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 選抜一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T10ChoiceSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T10ChoiceRegistForm.class);

    /** 選抜登録フォームのリスト */
    @Valid
    private List<T10ChoiceRegistForm> t10ChoiceGrid;

    /**
     * @return 選抜登録フォームのリスト
     */
    public List<T10ChoiceRegistForm> getT10ChoiceGrid() {
        return t10ChoiceGrid;
    }

    /**
     * @param p 選抜登録フォームのリスト
     */
    public void setT10ChoiceGrid(final List<T10ChoiceRegistForm> p) {
        this.t10ChoiceGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t10ChoiceGrid != null) {
            for (int i = 0; i < this.t10ChoiceGrid.size(); i++) {
                T10ChoiceRegistForm form = this.t10ChoiceGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T10ChoiceGrid", i, gridErrors);
                }
            }
        }
    }

}
