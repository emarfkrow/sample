package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 認可マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MhrShokuiNinkaSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MhrShokuiNinkaRegistForm.class);

    /** 認可マスタ登録フォームのリスト */
    @Valid
    private List<MhrShokuiNinkaRegistForm> mhrShokuiNinkaGrid;

    /**
     * @return 認可マスタ登録フォームのリスト
     */
    public List<MhrShokuiNinkaRegistForm> getMhrShokuiNinkaGrid() {
        return mhrShokuiNinkaGrid;
    }

    /**
     * @param p 認可マスタ登録フォームのリスト
     */
    public void setMhrShokuiNinkaGrid(final List<MhrShokuiNinkaRegistForm> p) {
        this.mhrShokuiNinkaGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mhrShokuiNinkaGrid.size(); i++) {
            MhrShokuiNinkaRegistForm form = this.mhrShokuiNinkaGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MhrShokuiNinkaGrid", i, gridErrors);
            }
        }
    }

}
