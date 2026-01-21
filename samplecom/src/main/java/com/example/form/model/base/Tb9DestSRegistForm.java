package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変換先一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb9DestSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb9DestRegistForm.class);

    /** 変換先登録フォームのリスト */
    @Valid
    private List<Tb9DestRegistForm> tb9DestGrid;

    /**
     * @return 変換先登録フォームのリスト
     */
    public List<Tb9DestRegistForm> getTb9DestGrid() {
        return tb9DestGrid;
    }

    /**
     * @param p 変換先登録フォームのリスト
     */
    public void setTb9DestGrid(final List<Tb9DestRegistForm> p) {
        this.tb9DestGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb9DestGrid.size(); i++) {
            Tb9DestRegistForm form = this.tb9DestGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb9DestGrid", i, gridErrors);
            }
        }
    }

}
