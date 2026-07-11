package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生３一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T12Reborn3SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T12Reborn3RegistForm.class);

    /** 転生３登録フォームのリスト */
    @Valid
    private List<T12Reborn3RegistForm> t12Reborn3Grid;

    /**
     * @return 転生３登録フォームのリスト
     */
    public List<T12Reborn3RegistForm> getT12Reborn3Grid() {
        return t12Reborn3Grid;
    }

    /**
     * @param p 転生３登録フォームのリスト
     */
    public void setT12Reborn3Grid(final List<T12Reborn3RegistForm> p) {
        this.t12Reborn3Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t12Reborn3Grid != null) {
            for (int i = 0; i < this.t12Reborn3Grid.size(); i++) {
                T12Reborn3RegistForm form = this.t12Reborn3Grid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T12Reborn3Grid", i, gridErrors);
                }
            }
        }
    }

}
