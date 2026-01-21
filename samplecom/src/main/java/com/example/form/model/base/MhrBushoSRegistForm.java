package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 部署マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class MhrBushoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(MhrBushoRegistForm.class);

    /** 部署マスタ登録フォームのリスト */
    @Valid
    private List<MhrBushoRegistForm> mhrBushoGrid;

    /**
     * @return 部署マスタ登録フォームのリスト
     */
    public List<MhrBushoRegistForm> getMhrBushoGrid() {
        return mhrBushoGrid;
    }

    /**
     * @param p 部署マスタ登録フォームのリスト
     */
    public void setMhrBushoGrid(final List<MhrBushoRegistForm> p) {
        this.mhrBushoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mhrBushoGrid.size(); i++) {
            MhrBushoRegistForm form = this.mhrBushoGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "MhrBushoGrid", i, gridErrors);
            }
        }
    }

}
