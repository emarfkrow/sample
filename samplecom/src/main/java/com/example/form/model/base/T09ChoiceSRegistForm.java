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
public class T09ChoiceSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T09ChoiceRegistForm.class);

    /** 選抜登録フォームのリスト */
    @Valid
    private List<T09ChoiceRegistForm> t09ChoiceGrid;

    /**
     * @return 選抜登録フォームのリスト
     */
    public List<T09ChoiceRegistForm> getT09ChoiceGrid() {
        return t09ChoiceGrid;
    }

    /**
     * @param p 選抜登録フォームのリスト
     */
    public void setT09ChoiceGrid(final List<T09ChoiceRegistForm> p) {
        this.t09ChoiceGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t09ChoiceGrid != null) {
            for (int i = 0; i < this.t09ChoiceGrid.size(); i++) {
                T09ChoiceRegistForm form = this.t09ChoiceGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T09ChoiceGrid", i, gridErrors);
                }
            }
        }
    }

}
