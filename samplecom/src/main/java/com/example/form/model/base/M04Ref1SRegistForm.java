package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * マスタ参照１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M04Ref1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04Ref1RegistForm.class);

    /** マスタ参照１登録フォームのリスト */
    @Valid
    private List<M04Ref1RegistForm> m04Ref1Grid;

    /**
     * @return マスタ参照１登録フォームのリスト
     */
    public List<M04Ref1RegistForm> getM04Ref1Grid() {
        return m04Ref1Grid;
    }

    /**
     * @param p マスタ参照１登録フォームのリスト
     */
    public void setM04Ref1Grid(final List<M04Ref1RegistForm> p) {
        this.m04Ref1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m04Ref1Grid != null) {
            for (int i = 0; i < this.m04Ref1Grid.size(); i++) {
                M04Ref1RegistForm form = this.m04Ref1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M04Ref1Grid", i, gridErrors);
                }
            }
        }
    }

}
