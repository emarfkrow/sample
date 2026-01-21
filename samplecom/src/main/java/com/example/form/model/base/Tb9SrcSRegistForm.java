package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変換元一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb9SrcSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb9SrcRegistForm.class);

    /** 変換元登録フォームのリスト */
    @Valid
    private List<Tb9SrcRegistForm> tb9SrcGrid;

    /**
     * @return 変換元登録フォームのリスト
     */
    public List<Tb9SrcRegistForm> getTb9SrcGrid() {
        return tb9SrcGrid;
    }

    /**
     * @param p 変換元登録フォームのリスト
     */
    public void setTb9SrcGrid(final List<Tb9SrcRegistForm> p) {
        this.tb9SrcGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb9SrcGrid.size(); i++) {
            Tb9SrcRegistForm form = this.tb9SrcGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb9SrcGrid", i, gridErrors);
            }
        }
    }

}
