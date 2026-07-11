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
public class M05Ref1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M05Ref1RegistForm.class);

    /** マスタ参照１登録フォームのリスト */
    @Valid
    private List<M05Ref1RegistForm> m05Ref1Grid;

    /**
     * @return マスタ参照１登録フォームのリスト
     */
    public List<M05Ref1RegistForm> getM05Ref1Grid() {
        return m05Ref1Grid;
    }

    /**
     * @param p マスタ参照１登録フォームのリスト
     */
    public void setM05Ref1Grid(final List<M05Ref1RegistForm> p) {
        this.m05Ref1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m05Ref1Grid != null) {
            for (int i = 0; i < this.m05Ref1Grid.size(); i++) {
                M05Ref1RegistForm form = this.m05Ref1Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M05Ref1Grid", i, gridErrors);
                }
            }
        }
    }

}
