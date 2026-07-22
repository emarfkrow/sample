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
public class T10SumSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T10SumRegistForm.class);

    /** 集約登録フォームのリスト */
    @Valid
    private List<T10SumRegistForm> t10SumGrid;

    /**
     * @return 集約登録フォームのリスト
     */
    public List<T10SumRegistForm> getT10SumGrid() {
        return t10SumGrid;
    }

    /**
     * @param p 集約登録フォームのリスト
     */
    public void setT10SumGrid(final List<T10SumRegistForm> p) {
        this.t10SumGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t10SumGrid != null) {
            for (int i = 0; i < this.t10SumGrid.size(); i++) {
                T10SumRegistForm form = this.t10SumGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T10SumGrid", i, gridErrors);
                }
            }
        }
    }

}
