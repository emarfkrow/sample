package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * ユーザマスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MhrUserSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MhrUserRegistForm.class);

    /** ユーザマスタ登録フォームのリスト */
    @Valid
    private List<MhrUserRegistForm> mhrUserGrid;

    /**
     * @return ユーザマスタ登録フォームのリスト
     */
    public List<MhrUserRegistForm> getMhrUserGrid() {
        return mhrUserGrid;
    }

    /**
     * @param p ユーザマスタ登録フォームのリスト
     */
    public void setMhrUserGrid(final List<MhrUserRegistForm> p) {
        this.mhrUserGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mhrUserGrid.size(); i++) {
            MhrUserRegistForm form = this.mhrUserGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MhrUserGrid", i, gridErrors);
            }
        }
    }

}
