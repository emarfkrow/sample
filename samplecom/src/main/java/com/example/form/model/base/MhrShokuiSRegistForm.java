package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 職位マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MhrShokuiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MhrShokuiRegistForm.class);

    /** 職位マスタ登録フォームのリスト */
    @Valid
    private List<MhrShokuiRegistForm> mhrShokuiGrid;

    /**
     * @return 職位マスタ登録フォームのリスト
     */
    public List<MhrShokuiRegistForm> getMhrShokuiGrid() {
        return mhrShokuiGrid;
    }

    /**
     * @param p 職位マスタ登録フォームのリスト
     */
    public void setMhrShokuiGrid(final List<MhrShokuiRegistForm> p) {
        this.mhrShokuiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mhrShokuiGrid.size(); i++) {
            MhrShokuiRegistForm form = this.mhrShokuiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MhrShokuiGrid", i, gridErrors);
            }
        }
    }

}
