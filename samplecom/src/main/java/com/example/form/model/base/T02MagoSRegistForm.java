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
public class T02MagoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T02MagoRegistForm.class);

    /** 孫登録フォームのリスト */
    @Valid
    private List<T02MagoRegistForm> t02MagoGrid;

    /**
     * @return 孫登録フォームのリスト
     */
    public List<T02MagoRegistForm> getT02MagoGrid() {
        return t02MagoGrid;
    }

    /**
     * @param p 孫登録フォームのリスト
     */
    public void setT02MagoGrid(final List<T02MagoRegistForm> p) {
        this.t02MagoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t02MagoGrid != null) {
            for (int i = 0; i < this.t02MagoGrid.size(); i++) {
                T02MagoRegistForm form = this.t02MagoGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T02MagoGrid", i, gridErrors);
                }
            }
        }
    }

}
