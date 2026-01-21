package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 参照２マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1Refer2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1Refer2RegistForm.class);

    /** 参照２マスタ登録フォームのリスト */
    @Valid
    private List<Tb1Refer2RegistForm> tb1Refer2Grid;

    /**
     * @return 参照２マスタ登録フォームのリスト
     */
    public List<Tb1Refer2RegistForm> getTb1Refer2Grid() {
        return tb1Refer2Grid;
    }

    /**
     * @param p 参照２マスタ登録フォームのリスト
     */
    public void setTb1Refer2Grid(final List<Tb1Refer2RegistForm> p) {
        this.tb1Refer2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1Refer2Grid.size(); i++) {
            Tb1Refer2RegistForm form = this.tb1Refer2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1Refer2Grid", i, gridErrors);
            }
        }
    }

}
