package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 所属マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MhrUserPosSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MhrUserPosRegistForm.class);

    /** 所属マスタ登録フォームのリスト */
    @Valid
    private List<MhrUserPosRegistForm> mhrUserPosGrid;

    /**
     * @return 所属マスタ登録フォームのリスト
     */
    public List<MhrUserPosRegistForm> getMhrUserPosGrid() {
        return mhrUserPosGrid;
    }

    /**
     * @param p 所属マスタ登録フォームのリスト
     */
    public void setMhrUserPosGrid(final List<MhrUserPosRegistForm> p) {
        this.mhrUserPosGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mhrUserPosGrid.size(); i++) {
            MhrUserPosRegistForm form = this.mhrUserPosGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MhrUserPosGrid", i, gridErrors);
            }
        }
    }

}
