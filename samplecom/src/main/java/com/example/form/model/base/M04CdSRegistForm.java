package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * CDマスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M04CdSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04CdRegistForm.class);

    /** CDマスタ登録フォームのリスト */
    @Valid
    private List<M04CdRegistForm> m04CdGrid;

    /**
     * @return CDマスタ登録フォームのリスト
     */
    public List<M04CdRegistForm> getM04CdGrid() {
        return m04CdGrid;
    }

    /**
     * @param p CDマスタ登録フォームのリスト
     */
    public void setM04CdGrid(final List<M04CdRegistForm> p) {
        this.m04CdGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m04CdGrid != null) {
            for (int i = 0; i < this.m04CdGrid.size(); i++) {
                M04CdRegistForm form = this.m04CdGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M04CdGrid", i, gridErrors);
                }
            }
        }
    }

}
