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
public class M05CdSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M05CdRegistForm.class);

    /** CDマスタ登録フォームのリスト */
    @Valid
    private List<M05CdRegistForm> m05CdGrid;

    /**
     * @return CDマスタ登録フォームのリスト
     */
    public List<M05CdRegistForm> getM05CdGrid() {
        return m05CdGrid;
    }

    /**
     * @param p CDマスタ登録フォームのリスト
     */
    public void setM05CdGrid(final List<M05CdRegistForm> p) {
        this.m05CdGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m05CdGrid != null) {
            for (int i = 0; i < this.m05CdGrid.size(); i++) {
                M05CdRegistForm form = this.m05CdGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M05CdGrid", i, gridErrors);
                }
            }
        }
    }

}
