package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * IDマスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M04IdSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04IdRegistForm.class);

    /** IDマスタ登録フォームのリスト */
    @Valid
    private List<M04IdRegistForm> m04IdGrid;

    /**
     * @return IDマスタ登録フォームのリスト
     */
    public List<M04IdRegistForm> getM04IdGrid() {
        return m04IdGrid;
    }

    /**
     * @param p IDマスタ登録フォームのリスト
     */
    public void setM04IdGrid(final List<M04IdRegistForm> p) {
        this.m04IdGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m04IdGrid != null) {
            for (int i = 0; i < this.m04IdGrid.size(); i++) {
                M04IdRegistForm form = this.m04IdGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M04IdGrid", i, gridErrors);
                }
            }
        }
    }

}
