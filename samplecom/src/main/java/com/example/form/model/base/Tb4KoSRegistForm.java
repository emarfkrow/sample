package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 子一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb4KoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb4KoRegistForm.class);

    /** 子登録フォームのリスト */
    @Valid
    private List<Tb4KoRegistForm> tb4KoGrid;

    /**
     * @return 子登録フォームのリスト
     */
    public List<Tb4KoRegistForm> getTb4KoGrid() {
        return tb4KoGrid;
    }

    /**
     * @param p 子登録フォームのリスト
     */
    public void setTb4KoGrid(final List<Tb4KoRegistForm> p) {
        this.tb4KoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb4KoGrid.size(); i++) {
            Tb4KoRegistForm form = this.tb4KoGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb4KoGrid", i, gridErrors);
            }
        }
    }

}
