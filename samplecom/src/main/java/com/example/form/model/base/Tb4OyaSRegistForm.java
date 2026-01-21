package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 親一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb4OyaSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb4OyaRegistForm.class);

    /** 親登録フォームのリスト */
    @Valid
    private List<Tb4OyaRegistForm> tb4OyaGrid;

    /**
     * @return 親登録フォームのリスト
     */
    public List<Tb4OyaRegistForm> getTb4OyaGrid() {
        return tb4OyaGrid;
    }

    /**
     * @param p 親登録フォームのリスト
     */
    public void setTb4OyaGrid(final List<Tb4OyaRegistForm> p) {
        this.tb4OyaGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb4OyaGrid.size(); i++) {
            Tb4OyaRegistForm form = this.tb4OyaGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb4OyaGrid", i, gridErrors);
            }
        }
    }

}
