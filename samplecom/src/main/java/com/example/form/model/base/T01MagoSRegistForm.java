package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 孫一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T01MagoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T01MagoRegistForm.class);

    /** 孫登録フォームのリスト */
    @Valid
    private List<T01MagoRegistForm> t01MagoGrid;

    /**
     * @return 孫登録フォームのリスト
     */
    public List<T01MagoRegistForm> getT01MagoGrid() {
        return t01MagoGrid;
    }

    /**
     * @param p 孫登録フォームのリスト
     */
    public void setT01MagoGrid(final List<T01MagoRegistForm> p) {
        this.t01MagoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t01MagoGrid != null) {
            for (int i = 0; i < this.t01MagoGrid.size(); i++) {
                T01MagoRegistForm form = this.t01MagoGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T01MagoGrid", i, gridErrors);
                }
            }
        }
    }

}
