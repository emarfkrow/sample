package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 共生一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T08KyoseiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T08KyoseiRegistForm.class);

    /** 共生登録フォームのリスト */
    @Valid
    private List<T08KyoseiRegistForm> t08KyoseiGrid;

    /**
     * @return 共生登録フォームのリスト
     */
    public List<T08KyoseiRegistForm> getT08KyoseiGrid() {
        return t08KyoseiGrid;
    }

    /**
     * @param p 共生登録フォームのリスト
     */
    public void setT08KyoseiGrid(final List<T08KyoseiRegistForm> p) {
        this.t08KyoseiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t08KyoseiGrid != null) {
            for (int i = 0; i < this.t08KyoseiGrid.size(); i++) {
                T08KyoseiRegistForm form = this.t08KyoseiGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T08KyoseiGrid", i, gridErrors);
                }
            }
        }
    }

}
