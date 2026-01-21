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
public class Tb4MagoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb4MagoRegistForm.class);

    /** 孫登録フォームのリスト */
    @Valid
    private List<Tb4MagoRegistForm> tb4MagoGrid;

    /**
     * @return 孫登録フォームのリスト
     */
    public List<Tb4MagoRegistForm> getTb4MagoGrid() {
        return tb4MagoGrid;
    }

    /**
     * @param p 孫登録フォームのリスト
     */
    public void setTb4MagoGrid(final List<Tb4MagoRegistForm> p) {
        this.tb4MagoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb4MagoGrid.size(); i++) {
            Tb4MagoRegistForm form = this.tb4MagoGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb4MagoGrid", i, gridErrors);
            }
        }
    }

}
