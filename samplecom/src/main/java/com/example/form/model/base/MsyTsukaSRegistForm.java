package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 通貨マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MsyTsukaSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MsyTsukaRegistForm.class);

    /** 通貨マスタ登録フォームのリスト */
    @Valid
    private List<MsyTsukaRegistForm> msyTsukaGrid;

    /**
     * @return 通貨マスタ登録フォームのリスト
     */
    public List<MsyTsukaRegistForm> getMsyTsukaGrid() {
        return msyTsukaGrid;
    }

    /**
     * @param p 通貨マスタ登録フォームのリスト
     */
    public void setMsyTsukaGrid(final List<MsyTsukaRegistForm> p) {
        this.msyTsukaGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.msyTsukaGrid.size(); i++) {
            MsyTsukaRegistForm form = this.msyTsukaGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MsyTsukaGrid", i, gridErrors);
            }
        }
    }

}
