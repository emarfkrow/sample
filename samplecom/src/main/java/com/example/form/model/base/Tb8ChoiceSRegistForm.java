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
public class Tb8ChoiceSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb8ChoiceRegistForm.class);

    /** 選抜登録フォームのリスト */
    @Valid
    private List<Tb8ChoiceRegistForm> tb8ChoiceGrid;

    /**
     * @return 選抜登録フォームのリスト
     */
    public List<Tb8ChoiceRegistForm> getTb8ChoiceGrid() {
        return tb8ChoiceGrid;
    }

    /**
     * @param p 選抜登録フォームのリスト
     */
    public void setTb8ChoiceGrid(final List<Tb8ChoiceRegistForm> p) {
        this.tb8ChoiceGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb8ChoiceGrid.size(); i++) {
            Tb8ChoiceRegistForm form = this.tb8ChoiceGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb8ChoiceGrid", i, gridErrors);
            }
        }
    }

}
