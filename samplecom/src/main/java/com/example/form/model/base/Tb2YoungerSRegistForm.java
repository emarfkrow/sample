package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 弟一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb2YoungerSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb2YoungerRegistForm.class);

    /** 弟登録フォームのリスト */
    @Valid
    private List<Tb2YoungerRegistForm> tb2YoungerGrid;

    /**
     * @return 弟登録フォームのリスト
     */
    public List<Tb2YoungerRegistForm> getTb2YoungerGrid() {
        return tb2YoungerGrid;
    }

    /**
     * @param p 弟登録フォームのリスト
     */
    public void setTb2YoungerGrid(final List<Tb2YoungerRegistForm> p) {
        this.tb2YoungerGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb2YoungerGrid.size(); i++) {
            Tb2YoungerRegistForm form = this.tb2YoungerGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb2YoungerGrid", i, gridErrors);
            }
        }
    }

}
