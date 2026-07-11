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
public class M05Ref2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M05Ref2RegistForm.class);

    /** マスタ参照２登録フォームのリスト */
    @Valid
    private List<M05Ref2RegistForm> m05Ref2Grid;

    /**
     * @return マスタ参照２登録フォームのリスト
     */
    public List<M05Ref2RegistForm> getM05Ref2Grid() {
        return m05Ref2Grid;
    }

    /**
     * @param p マスタ参照２登録フォームのリスト
     */
    public void setM05Ref2Grid(final List<M05Ref2RegistForm> p) {
        this.m05Ref2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m05Ref2Grid != null) {
            for (int i = 0; i < this.m05Ref2Grid.size(); i++) {
                M05Ref2RegistForm form = this.m05Ref2Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M05Ref2Grid", i, gridErrors);
                }
            }
        }
    }

}
