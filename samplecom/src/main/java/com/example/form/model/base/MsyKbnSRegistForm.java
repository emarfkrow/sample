package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 区分マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MsyKbnSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MsyKbnRegistForm.class);

    /** 区分マスタ登録フォームのリスト */
    @Valid
    private List<MsyKbnRegistForm> msyKbnGrid;

    /**
     * @return 区分マスタ登録フォームのリスト
     */
    public List<MsyKbnRegistForm> getMsyKbnGrid() {
        return msyKbnGrid;
    }

    /**
     * @param p 区分マスタ登録フォームのリスト
     */
    public void setMsyKbnGrid(final List<MsyKbnRegistForm> p) {
        this.msyKbnGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.msyKbnGrid.size(); i++) {
            MsyKbnRegistForm form = this.msyKbnGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MsyKbnGrid", i, gridErrors);
            }
        }
    }

}
