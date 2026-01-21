package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 区分値マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MsyKbnValSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MsyKbnValRegistForm.class);

    /** 区分値マスタ登録フォームのリスト */
    @Valid
    private List<MsyKbnValRegistForm> msyKbnValGrid;

    /**
     * @return 区分値マスタ登録フォームのリスト
     */
    public List<MsyKbnValRegistForm> getMsyKbnValGrid() {
        return msyKbnValGrid;
    }

    /**
     * @param p 区分値マスタ登録フォームのリスト
     */
    public void setMsyKbnValGrid(final List<MsyKbnValRegistForm> p) {
        this.msyKbnValGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.msyKbnValGrid.size(); i++) {
            MsyKbnValRegistForm form = this.msyKbnValGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MsyKbnValGrid", i, gridErrors);
            }
        }
    }

}
