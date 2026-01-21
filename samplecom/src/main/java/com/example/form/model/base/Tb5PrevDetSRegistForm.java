package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb5PrevDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb5PrevDetRegistForm.class);

    /** 前世明細登録フォームのリスト */
    @Valid
    private List<Tb5PrevDetRegistForm> tb5PrevDetGrid;

    /**
     * @return 前世明細登録フォームのリスト
     */
    public List<Tb5PrevDetRegistForm> getTb5PrevDetGrid() {
        return tb5PrevDetGrid;
    }

    /**
     * @param p 前世明細登録フォームのリスト
     */
    public void setTb5PrevDetGrid(final List<Tb5PrevDetRegistForm> p) {
        this.tb5PrevDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb5PrevDetGrid.size(); i++) {
            Tb5PrevDetRegistForm form = this.tb5PrevDetGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb5PrevDetGrid", i, gridErrors);
            }
        }
    }

}
