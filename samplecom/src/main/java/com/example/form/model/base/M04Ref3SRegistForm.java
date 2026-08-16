package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * マスタ参照３一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M04Ref3SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04Ref3RegistForm.class);

    /** マスタ参照３登録フォームのリスト */
    @Valid
    private List<M04Ref3RegistForm> m04Ref3Grid;

    /**
     * @return マスタ参照３登録フォームのリスト
     */
    public List<M04Ref3RegistForm> getM04Ref3Grid() {
        return m04Ref3Grid;
    }

    /**
     * @param p マスタ参照３登録フォームのリスト
     */
    public void setM04Ref3Grid(final List<M04Ref3RegistForm> p) {
        this.m04Ref3Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m04Ref3Grid != null) {
            for (int i = 0; i < this.m04Ref3Grid.size(); i++) {
                M04Ref3RegistForm form = this.m04Ref3Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M04Ref3Grid", i, gridErrors);
                }
            }
        }
    }

}
