package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 稼働日マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MsyKadobiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MsyKadobiRegistForm.class);

    /** 稼働日マスタ登録フォームのリスト */
    @Valid
    private List<MsyKadobiRegistForm> msyKadobiGrid;

    /**
     * @return 稼働日マスタ登録フォームのリスト
     */
    public List<MsyKadobiRegistForm> getMsyKadobiGrid() {
        return msyKadobiGrid;
    }

    /**
     * @param p 稼働日マスタ登録フォームのリスト
     */
    public void setMsyKadobiGrid(final List<MsyKadobiRegistForm> p) {
        this.msyKadobiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.msyKadobiGrid.size(); i++) {
            MsyKadobiRegistForm form = this.msyKadobiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MsyKadobiGrid", i, gridErrors);
            }
        }
    }

}
