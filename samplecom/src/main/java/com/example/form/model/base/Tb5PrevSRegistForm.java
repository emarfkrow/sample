package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb5PrevSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb5PrevRegistForm.class);

    /** 前世登録フォームのリスト */
    @Valid
    private List<Tb5PrevRegistForm> tb5PrevGrid;

    /**
     * @return 前世登録フォームのリスト
     */
    public List<Tb5PrevRegistForm> getTb5PrevGrid() {
        return tb5PrevGrid;
    }

    /**
     * @param p 前世登録フォームのリスト
     */
    public void setTb5PrevGrid(final List<Tb5PrevRegistForm> p) {
        this.tb5PrevGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb5PrevGrid.size(); i++) {
            Tb5PrevRegistForm form = this.tb5PrevGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb5PrevGrid", i, gridErrors);
            }
        }
    }

}
