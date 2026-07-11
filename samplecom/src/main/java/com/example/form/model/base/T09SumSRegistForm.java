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
public class T09SumSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T09SumRegistForm.class);

    /** 集約登録フォームのリスト */
    @Valid
    private List<T09SumRegistForm> t09SumGrid;

    /**
     * @return 集約登録フォームのリスト
     */
    public List<T09SumRegistForm> getT09SumGrid() {
        return t09SumGrid;
    }

    /**
     * @param p 集約登録フォームのリスト
     */
    public void setT09SumGrid(final List<T09SumRegistForm> p) {
        this.t09SumGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t09SumGrid != null) {
            for (int i = 0; i < this.t09SumGrid.size(); i++) {
                T09SumRegistForm form = this.t09SumGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T09SumGrid", i, gridErrors);
                }
            }
        }
    }

}
