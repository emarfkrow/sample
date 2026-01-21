package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 集約一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb7SumSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb7SumRegistForm.class);

    /** 集約登録フォームのリスト */
    @Valid
    private List<Tb7SumRegistForm> tb7SumGrid;

    /**
     * @return 集約登録フォームのリスト
     */
    public List<Tb7SumRegistForm> getTb7SumGrid() {
        return tb7SumGrid;
    }

    /**
     * @param p 集約登録フォームのリスト
     */
    public void setTb7SumGrid(final List<Tb7SumRegistForm> p) {
        this.tb7SumGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb7SumGrid.size(); i++) {
            Tb7SumRegistForm form = this.tb7SumGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb7SumGrid", i, gridErrors);
            }
        }
    }

}
