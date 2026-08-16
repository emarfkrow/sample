package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * マスタ参照２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M04Ref2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04Ref2RegistForm.class);

    /** マスタ参照２登録フォームのリスト */
    @Valid
    private List<M04Ref2RegistForm> m04Ref2Grid;

    /**
     * @return マスタ参照２登録フォームのリスト
     */
    public List<M04Ref2RegistForm> getM04Ref2Grid() {
        return m04Ref2Grid;
    }

    /**
     * @param p マスタ参照２登録フォームのリスト
     */
    public void setM04Ref2Grid(final List<M04Ref2RegistForm> p) {
        this.m04Ref2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m04Ref2Grid != null) {
            for (int i = 0; i < this.m04Ref2Grid.size(); i++) {
                M04Ref2RegistForm form = this.m04Ref2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M04Ref2Grid", i, gridErrors);
                }
            }
        }
    }

}
